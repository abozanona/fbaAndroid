package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.Intent;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.tracking.android.AnalyticsGmsCoreClient.OnConnectedListener;
import com.google.analytics.tracking.android.AnalyticsGmsCoreClient.OnConnectionFailedListener;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.protobuf.WireFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

class GAServiceProxy implements ServiceProxy, OnConnectedListener, OnConnectionFailedListener {
	private static final long FAILED_CONNECT_WAIT_TIME = 3000;
	private static final int MAX_TRIES = 2;
	private static final long RECONNECT_WAIT_TIME = 5000;
	private static final long SERVICE_CONNECTION_TIMEOUT = 300000;
	private volatile AnalyticsClient client;
	private Clock clock;
	private volatile int connectTries;
	private final Context ctx;
	private volatile Timer disconnectCheckTimer;
	private volatile Timer failedConnectTimer;
	private boolean forceLocalDispatch;
	private final GoogleAnalytics gaInstance;
	private long idleTimeout;
	private volatile long lastRequestTime;
	private boolean pendingClearHits;
	private boolean pendingDispatch;
	private boolean pendingServiceDisconnect;
	private final Queue<HitParams> queue;
	private volatile Timer reConnectTimer;
	private volatile ConnectState state;
	private AnalyticsStore store;
	private AnalyticsStore testStore;
	private final AnalyticsThread thread;

	static /* synthetic */ class AnonymousClass_3 {
		static final /* synthetic */ int[] $SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState;

		static {
			$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState = new int[GAServiceProxy.ConnectState.values().length];
			try {
				$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState[GAServiceProxy.ConnectState.CONNECTED_LOCAL.ordinal()] = 1;
			} catch (NoSuchFieldError e) {
			}
			try {
				$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState[GAServiceProxy.ConnectState.CONNECTED_SERVICE.ordinal()] = 2;
			} catch (NoSuchFieldError e_2) {
			}
			try {
				$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState[GAServiceProxy.ConnectState.CONNECTING.ordinal()] = 3;
			} catch (NoSuchFieldError e_3) {
			}
			try {
				$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState[GAServiceProxy.ConnectState.PENDING_CONNECTION.ordinal()] = 4;
			} catch (NoSuchFieldError e_4) {
			}
			try {
				$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState[GAServiceProxy.ConnectState.PENDING_DISCONNECT.ordinal()] = 5;
			} catch (NoSuchFieldError e_5) {
			}
			$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState[GAServiceProxy.ConnectState.DISCONNECTED.ordinal()] = 6;
		}
	}

	private static enum ConnectState {
		CONNECTING,
		CONNECTED_SERVICE,
		CONNECTED_LOCAL,
		BLOCKED,
		PENDING_CONNECTION,
		PENDING_DISCONNECT,
		DISCONNECTED;

	}

	private class DisconnectCheckTask extends TimerTask {
		private DisconnectCheckTask() {
		}

		public void run() {
			if (state != GAServiceProxy.ConnectState.CONNECTED_SERVICE || !queue.isEmpty() || lastRequestTime + idleTimeout >= clock.currentTimeMillis()) {
				disconnectCheckTimer.schedule(new GAServiceProxy.DisconnectCheckTask(), idleTimeout);
				return;
			} else {
				Log.v("Disconnecting due to inactivity");
				disconnectFromService();
			}
		}
	}

	private class FailedConnectTask extends TimerTask {
		private FailedConnectTask() {
		}

		public void run() {
			if (state == GAServiceProxy.ConnectState.CONNECTING) {
				useStore();
			}
		}
	}

	private static class HitParams {
		private final List<Command> commands;
		private final long hitTimeInMilliseconds;
		private final String path;
		private final Map<String, String> wireFormatParams;

		public HitParams(Map<String, String> wireFormatParams, long hitTimeInMilliseconds, String path, List<Command> commands) {
			this.wireFormatParams = wireFormatParams;
			this.hitTimeInMilliseconds = hitTimeInMilliseconds;
			this.path = path;
			this.commands = commands;
		}

		public List<Command> getCommands() {
			return this.commands;
		}

		public long getHitTimeInMilliseconds() {
			return this.hitTimeInMilliseconds;
		}

		public String getPath() {
			return this.path;
		}

		public Map<String, String> getWireFormatParams() {
			return this.wireFormatParams;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("PATH: ");
			sb.append(this.path);
			if (this.wireFormatParams != null) {
				sb.append("  PARAMS: ");
				Iterator i$ = this.wireFormatParams.entrySet().iterator();
				while (i$.hasNext()) {
					Entry<String, String> entry = (Entry) i$.next();
					sb.append((String) entry.getKey());
					sb.append("=");
					sb.append((String) entry.getValue());
					sb.append(",  ");
				}
			}
			return sb.toString();
		}
	}

	private class ReconnectTask extends TimerTask {
		private ReconnectTask() {
		}

		public void run() {
			connectToService();
		}
	}


	GAServiceProxy(Context ctx, AnalyticsThread thread) {
		this(ctx, thread, null, GoogleAnalytics.getInstance(ctx));
	}

	@VisibleForTesting
	GAServiceProxy(Context ctx, AnalyticsThread thread, AnalyticsStore store, GoogleAnalytics gaInstance) {
		this.queue = new ConcurrentLinkedQueue();
		this.idleTimeout = 300000;
		this.testStore = store;
		this.ctx = ctx;
		this.thread = thread;
		this.gaInstance = gaInstance;
		this.clock = new Clock() {
			public long currentTimeMillis() {
				return System.currentTimeMillis();
			}
		};
		this.connectTries = 0;
		this.state = ConnectState.DISCONNECTED;
	}

	private Timer cancelTimer(Timer timer) {
		if (timer != null) {
			timer.cancel();
		}
		return null;
	}

	private void clearAllTimers() {
		this.reConnectTimer = cancelTimer(this.reConnectTimer);
		this.failedConnectTimer = cancelTimer(this.failedConnectTimer);
		this.disconnectCheckTimer = cancelTimer(this.disconnectCheckTimer);
	}

	private synchronized void connectToService() {
		synchronized(this) {
			if (this.forceLocalDispatch || this.client == null || this.state == ConnectState.CONNECTED_LOCAL) {
				Log.w("client not initialized.");
				useStore();
			} else {
				try {
					this.connectTries++;
					cancelTimer(this.failedConnectTimer);
					this.state = ConnectState.CONNECTING;
					this.failedConnectTimer = new Timer("Failed Connect");
					this.failedConnectTimer.schedule(new FailedConnectTask(null), FAILED_CONNECT_WAIT_TIME);
					Log.v("connecting to Analytics service");
					this.client.connect();
				} catch (SecurityException e) {
					Log.w("security exception on connectToService");
					useStore();
				}
			}
		}
	}

	private synchronized void disconnectFromService() {
		synchronized(this) {
			if (this.client == null || this.state != ConnectState.CONNECTED_SERVICE) {
			} else {
				this.state = ConnectState.PENDING_DISCONNECT;
				this.client.disconnect();
			}
		}
	}

	private void dispatchToStore() {
		this.store.dispatch();
		this.pendingDispatch = false;
	}

	private void fireReconnectAttempt() {
		this.reConnectTimer = cancelTimer(this.reConnectTimer);
		this.reConnectTimer = new Timer("Service Reconnect");
		this.reConnectTimer.schedule(new ReconnectTask(null), RECONNECT_WAIT_TIME);
	}

	/* JADX WARNING: inconsistent code */
	/*
	private synchronized void sendQueue() {
		r7_this = this;
		monitor-enter(r7);
		r0 = java.lang.Thread.currentThread();	 //Catch:{ all -> 0x0072 }
		r1 = r7.thread;	 //Catch:{ all -> 0x0072 }
		r1 = r1.getThread();	 //Catch:{ all -> 0x0072 }
		r0 = r0.equals(r1);	 //Catch:{ all -> 0x0072 }
		if (r0 != 0) goto L_0x0021;
	L_0x0011:
		r0 = r7.thread;	 //Catch:{ all -> 0x0072 }
		r0 = r0.getQueue();	 //Catch:{ all -> 0x0072 }
		r1 = new com.google.analytics.tracking.android.GAServiceProxy$2;	 //Catch:{ all -> 0x0072 }
		r1.<init>();	 //Catch:{ all -> 0x0072 }
		r0.add(r1);	 //Catch:{ all -> 0x0072 }
	L_0x001f:
		monitor-exit(r7);
		return;
	L_0x0021:
		r0 = r7.pendingClearHits;	 //Catch:{ all -> 0x0072 }
		if (r0 == 0) goto L_0x0028;
	L_0x0025:
		r7.clearHits();	 //Catch:{ all -> 0x0072 }
	L_0x0028:
		r0 = com.google.analytics.tracking.android.GAServiceProxy.AnonymousClass_3.$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState;	 //Catch:{ all -> 0x0072 }
		r1 = r7.state;	 //Catch:{ all -> 0x0072 }
		r1 = r1.ordinal();	 //Catch:{ all -> 0x0072 }
		r0 = r0[r1];	 //Catch:{ all -> 0x0072 }
		switch(r0) {
			case 1: goto L_0x0036;
			case 2: goto L_0x007d;
			case 3: goto L_0x0035;
			case 4: goto L_0x0035;
			case 5: goto L_0x0035;
			case 6: goto L_0x00d6;
			default: goto L_0x0035;
		}	 //Catch:{ all -> 0x0072 }
	L_0x0035:
		goto L_0x001f;
	L_0x0036:
		r0 = r7.queue;	 //Catch:{ all -> 0x0072 }
		r0 = r0.isEmpty();	 //Catch:{ all -> 0x0072 }
		if (r0 != 0) goto L_0x0075;
	L_0x003e:
		r0 = r7.queue;	 //Catch:{ all -> 0x0072 }
		r6 = r0.poll();	 //Catch:{ all -> 0x0072 }
		r6 = (com.google.analytics.tracking.android.GAServiceProxy.HitParams) r6;	 //Catch:{ all -> 0x0072 }
		r0 = new java.lang.StringBuilder;	 //Catch:{ all -> 0x0072 }
		r0.<init>();	 //Catch:{ all -> 0x0072 }
		r1 = "Sending hit to store  ";
		r0 = r0.append(r1);	 //Catch:{ all -> 0x0072 }
		r0 = r0.append(r6_hitParams);	 //Catch:{ all -> 0x0072 }
		r0 = r0.toString();	 //Catch:{ all -> 0x0072 }
		com.google.analytics.tracking.android.Log.v(r0);	 //Catch:{ all -> 0x0072 }
		r0 = r7.store;	 //Catch:{ all -> 0x0072 }
		r1 = r6_hitParams.getWireFormatParams();	 //Catch:{ all -> 0x0072 }
		r2 = r6_hitParams.getHitTimeInMilliseconds();	 //Catch:{ all -> 0x0072 }
		r4 = r6_hitParams.getPath();	 //Catch:{ all -> 0x0072 }
		r5 = r6_hitParams.getCommands();	 //Catch:{ all -> 0x0072 }
		r0.putHit(r1, r2, r4, r5);	 //Catch:{ all -> 0x0072 }
		goto L_0x0036;
	L_0x0072:
		r0 = move-exception;
		monitor-exit(r7);
		throw r0;
	L_0x0075:
		r0 = r7.pendingDispatch;	 //Catch:{ all -> 0x0072 }
		if (r0 == 0) goto L_0x001f;
	L_0x0079:
		r7.dispatchToStore();	 //Catch:{ all -> 0x0072 }
		goto L_0x001f;
	L_0x007d:
		r0 = r7.queue;	 //Catch:{ all -> 0x0072 }
		r0 = r0.isEmpty();	 //Catch:{ all -> 0x0072 }
		if (r0 != 0) goto L_0x00cc;
	L_0x0085:
		r0 = r7.queue;	 //Catch:{ all -> 0x0072 }
		r6_hitParams = r0.peek();	 //Catch:{ all -> 0x0072 }
		r6_hitParams = (com.google.analytics.tracking.android.GAServiceProxy.HitParams) r6_hitParams;	 //Catch:{ all -> 0x0072 }
		r0 = new java.lang.StringBuilder;	 //Catch:{ all -> 0x0072 }
		r0.<init>();	 //Catch:{ all -> 0x0072 }
		r1 = "Sending hit to service   ";
		r0 = r0.append(r1);	 //Catch:{ all -> 0x0072 }
		r0 = r0.append(r6_hitParams);	 //Catch:{ all -> 0x0072 }
		r0 = r0.toString();	 //Catch:{ all -> 0x0072 }
		com.google.analytics.tracking.android.Log.v(r0);	 //Catch:{ all -> 0x0072 }
		r0 = r7.gaInstance;	 //Catch:{ all -> 0x0072 }
		r0 = r0.isDryRunEnabled();	 //Catch:{ all -> 0x0072 }
		if (r0 != 0) goto L_0x00c6;
	L_0x00ab:
		r0 = r7.client;	 //Catch:{ all -> 0x0072 }
		r1 = r6_hitParams.getWireFormatParams();	 //Catch:{ all -> 0x0072 }
		r2 = r6_hitParams.getHitTimeInMilliseconds();	 //Catch:{ all -> 0x0072 }
		r4 = r6_hitParams.getPath();	 //Catch:{ all -> 0x0072 }
		r5 = r6_hitParams.getCommands();	 //Catch:{ all -> 0x0072 }
		r0.sendHit(r1, r2, r4, r5);	 //Catch:{ all -> 0x0072 }
	L_0x00c0:
		r0 = r7.queue;	 //Catch:{ all -> 0x0072 }
		r0.poll();	 //Catch:{ all -> 0x0072 }
		goto L_0x007d;
	L_0x00c6:
		r0 = "Dry run enabled. Hit not actually sent to service.";
		com.google.analytics.tracking.android.Log.v(r0);	 //Catch:{ all -> 0x0072 }
		goto L_0x00c0;
	L_0x00cc:
		r0 = r7.clock;	 //Catch:{ all -> 0x0072 }
		r0 = r0.currentTimeMillis();	 //Catch:{ all -> 0x0072 }
		r7.lastRequestTime = r0;	 //Catch:{ all -> 0x0072 }
		goto L_0x001f;
	L_0x00d6:
		r0 = "Need to reconnect";
		com.google.analytics.tracking.android.Log.v(r0);	 //Catch:{ all -> 0x0072 }
		r0 = r7.queue;	 //Catch:{ all -> 0x0072 }
		r0 = r0.isEmpty();	 //Catch:{ all -> 0x0072 }
		if (r0 != 0) goto L_0x001f;
	L_0x00e3:
		r7.connectToService();	 //Catch:{ all -> 0x0072 }
		goto L_0x001f;
	}
	*/
	private synchronized void sendQueue() {
		synchronized(this) {
			if (!Thread.currentThread().equals(this.thread.getThread())) {
				this.thread.getQueue().add(new Runnable() {
			public void run() {
				sendQueue();
			}
		});
			} else {
				if (this.pendingClearHits) {
					clearHits();
				}
				switch(AnonymousClass_3.$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState[this.state.ordinal()]) {
				case WireFormat.WIRETYPE_FIXED64:
					break;
				case MAX_TRIES:
					break;
				case Value.MACRO_REFERENCE_FIELD_NUMBER:
					Log.v("Need to reconnect");
					if (!this.queue.isEmpty()) {
						connectToService();
					}
					break;
				default:
					break;
				}
			}
		}
	}

	private synchronized void useStore() {
		synchronized(this) {
			if (this.state == ConnectState.CONNECTED_LOCAL) {
			} else {
				clearAllTimers();
				Log.v("falling back to local store");
				if (this.testStore != null) {
					this.store = this.testStore;
				} else {
					GAServiceManager instance = GAServiceManager.getInstance();
					instance.initialize(this.ctx, this.thread);
					this.store = instance.getStore();
				}
				this.state = ConnectState.CONNECTED_LOCAL;
				sendQueue();
			}
		}
	}

	public void clearHits() {
		Log.v("clearHits called");
		this.queue.clear();
		switch(AnonymousClass_3.$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState[this.state.ordinal()]) {
		case WireFormat.WIRETYPE_FIXED64:
			this.store.clearHits(0);
			this.pendingClearHits = false;
			return;
		case MAX_TRIES:
			this.client.clearHits();
			this.pendingClearHits = false;
			return;
		}
		this.pendingClearHits = true;
	}

	public void createService() {
		if (this.client != null) {
		} else {
			this.client = new AnalyticsGmsCoreClient(this.ctx, this, this);
			connectToService();
		}
	}

	void createService(AnalyticsClient client) {
		if (this.client != null) {
		} else {
			this.client = client;
			connectToService();
		}
	}

	public void dispatch() {
		switch(AnonymousClass_3.$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState[this.state.ordinal()]) {
		case WireFormat.WIRETYPE_FIXED64:
			dispatchToStore();
			break;
		case MAX_TRIES:
			break;
		default:
			this.pendingDispatch = true;
			break;
		}
	}

	public synchronized void onConnected() {
		synchronized(this) {
			this.failedConnectTimer = cancelTimer(this.failedConnectTimer);
			this.connectTries = 0;
			Log.v("Connected to service");
			this.state = ConnectState.CONNECTED_SERVICE;
			if (this.pendingServiceDisconnect) {
				disconnectFromService();
				this.pendingServiceDisconnect = false;
			} else {
				sendQueue();
				this.disconnectCheckTimer = cancelTimer(this.disconnectCheckTimer);
				this.disconnectCheckTimer = new Timer("disconnect check");
				this.disconnectCheckTimer.schedule(new DisconnectCheckTask(null), this.idleTimeout);
			}
		}
	}

	public synchronized void onConnectionFailed(int errorCode, Intent resolution) {
		synchronized(this) {
			this.state = ConnectState.PENDING_CONNECTION;
			if (this.connectTries < 2) {
				Log.w("Service unavailable (code=" + errorCode + "), will retry.");
				fireReconnectAttempt();
			} else {
				Log.w("Service unavailable (code=" + errorCode + "), using local store.");
				useStore();
			}
		}
	}

	public synchronized void onDisconnected() {
		synchronized(this) {
			if (this.state == ConnectState.PENDING_DISCONNECT) {
				Log.v("Disconnected from service");
				clearAllTimers();
				this.state = ConnectState.DISCONNECTED;
			} else {
				Log.v("Unexpected disconnect.");
				this.state = ConnectState.PENDING_CONNECTION;
				if (this.connectTries < 2) {
					fireReconnectAttempt();
				} else {
					useStore();
				}
			}
		}
	}

	public void putHit(Map<String, String> wireFormatParams, long hitTimeInMilliseconds, String path, List<Command> commands) {
		Log.v("putHit called");
		this.queue.add(new HitParams(wireFormatParams, hitTimeInMilliseconds, path, commands));
		sendQueue();
	}

	void setClock(Clock clock) {
		this.clock = clock;
	}

	public synchronized void setForceLocalDispatch() {
		synchronized(this) {
			if (this.forceLocalDispatch) {
			} else {
				Log.v("setForceLocalDispatch called.");
				this.forceLocalDispatch = true;
				switch(AnonymousClass_3.$SwitchMap$com$google$analytics$tracking$android$GAServiceProxy$ConnectState[this.state.ordinal()]) {
				case WireFormat.WIRETYPE_FIXED64:
				case WireFormat.WIRETYPE_END_GROUP:
				case WireFormat.WIRETYPE_FIXED32:
				case Value.MACRO_REFERENCE_FIELD_NUMBER:
					break;
				case MAX_TRIES:
					disconnectFromService();
					break;
				case WireFormat.WIRETYPE_START_GROUP:
					this.pendingServiceDisconnect = true;
					break;
				}
			}
		}
	}

	public void setIdleTimeout(long idleTimeout) {
		this.idleTimeout = idleTimeout;
	}
}

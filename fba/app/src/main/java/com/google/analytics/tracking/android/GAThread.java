package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

class GAThread extends Thread implements AnalyticsThread {
	static final String API_VERSION = "1";
	private static final String CLIENT_VERSION = "ma3.0.1";
	private static final int MAX_SAMPLE_RATE = 100;
	private static final int SAMPLE_RATE_MODULO = 10000;
	private static final int SAMPLE_RATE_MULTIPLIER = 100;
	private static GAThread sInstance;
	private volatile String mClientId;
	private volatile boolean mClosed;
	private volatile List<Command> mCommands;
	private final Context mContext;
	private volatile boolean mDisabled;
	private volatile String mInstallCampaign;
	private volatile ServiceProxy mServiceProxy;
	private final LinkedBlockingQueue<Runnable> queue;

	class AnonymousClass_1 implements Runnable {
		final /* synthetic */ Map val$hitCopy;

		AnonymousClass_1(Map r2_Map) {
			this.val$hitCopy = r2_Map;
		}

		public void run() {
			if (TextUtils.isEmpty((CharSequence) this.val$hitCopy.get(Fields.CLIENT_ID))) {
				this.val$hitCopy.put(Fields.CLIENT_ID, mClientId);
			}
			if (GoogleAnalytics.getInstance(mContext).getAppOptOut() || isSampledOut(this.val$hitCopy)) {
			} else {
				if (!TextUtils.isEmpty(mInstallCampaign)) {
					GAUsage.getInstance().setDisableUsage(true);
					this.val$hitCopy.putAll(new MapBuilder().setCampaignParamsFromUrl(mInstallCampaign).build());
					GAUsage.getInstance().setDisableUsage(false);
					mInstallCampaign = null;
				}
				fillAppParameters(this.val$hitCopy);
				Map<String, String> wireFormatParams = HitBuilder.generateHitParams(this.val$hitCopy);
				mServiceProxy.putHit(wireFormatParams, Long.valueOf((String) this.val$hitCopy.get("&ht")).longValue(), getUrlScheme(this.val$hitCopy), mCommands);
			}
		}
	}


	private GAThread(Context ctx) {
		super("GAThread");
		this.queue = new LinkedBlockingQueue();
		this.mDisabled = false;
		this.mClosed = false;
		if (ctx != null) {
			this.mContext = ctx.getApplicationContext();
		} else {
			this.mContext = ctx;
		}
		start();
	}

	@VisibleForTesting
	GAThread(Context ctx, ServiceProxy proxy) {
		super("GAThread");
		this.queue = new LinkedBlockingQueue();
		this.mDisabled = false;
		this.mClosed = false;
		if (ctx != null) {
			this.mContext = ctx.getApplicationContext();
		} else {
			this.mContext = ctx;
		}
		this.mServiceProxy = proxy;
		start();
	}

	private void fillAppParameters(Map<String, String> hit) {
		DefaultProvider appFieldsProvider = AppFieldsDefaultProvider.getProvider();
		Utils.putIfAbsent(hit, Fields.APP_NAME, appFieldsProvider.getValue(Fields.APP_NAME));
		Utils.putIfAbsent(hit, Fields.APP_VERSION, appFieldsProvider.getValue(Fields.APP_VERSION));
		Utils.putIfAbsent(hit, Fields.APP_ID, appFieldsProvider.getValue(Fields.APP_ID));
		Utils.putIfAbsent(hit, Fields.APP_INSTALLER_ID, appFieldsProvider.getValue(Fields.APP_INSTALLER_ID));
		hit.put("&v", API_VERSION);
	}

	@VisibleForTesting
	static String getAndClearCampaign(Context context) {
		FileInputStream input;
		byte[] inputBytes;
		int readLen;
		String campaignString;
		try {
			input = context.openFileInput("gaInstallData");
			inputBytes = new byte[8192];
			readLen = input.read(inputBytes, 0, 8192);
			if (input.available() > 0) {
				Log.e("Too much campaign data, ignoring it.");
				input.close();
				context.deleteFile("gaInstallData");
				campaignString = null;
				return campaignString;
			} else {
				input.close();
				context.deleteFile("gaInstallData");
				if (readLen <= 0) {
					Log.w("Campaign file is empty.");
					campaignString = null;
					return campaignString;
				} else {
					campaignString = new String(inputBytes, 0, readLen);
					Log.i("Campaign found: " + campaignString);
					return campaignString;
				}
			}
		} catch (FileNotFoundException e) {
			Log.i("No campaign data found.");
			campaignString = null;
		} catch (IOException e_2) {
			Log.e("Error reading campaign data.");
			context.deleteFile("gaInstallData");
			campaignString = null;
		}
	}

	static GAThread getInstance(Context ctx) {
		if (sInstance == null) {
			sInstance = new GAThread(ctx);
		}
		return sInstance;
	}

	private String getUrlScheme(Map<String, String> hit) {
		if (hit.containsKey(Fields.USE_SECURE)) {
			return (Utils.safeParseBoolean((String) hit.get(Fields.USE_SECURE), true)) ? "https:" : "http:";
		} else {
			return "https:";
		}
	}

	@VisibleForTesting
	static int hashClientIdForSampling(String clientId) {
		int hashVal = 1;
		if (!TextUtils.isEmpty(clientId)) {
			hashVal = 0;
			int charPos = clientId.length() - 1;
			while (charPos >= 0) {
				char curChar = clientId.charAt(charPos);
				hashVal = (((hashVal << 6) & 268435455) + curChar) + (curChar << 14);
				int lefMost7 = hashVal & 266338304;
				if (lefMost7 != 0) {
					hashVal ^= lefMost7 >> 21;
				}
				charPos--;
			}
		}
		return hashVal;
	}

	private boolean isSampledOut(Map<String, String> hit) {
		double r9d = 100.0d;
		if (hit.get(Fields.SAMPLE_RATE) == null) {
			return false;
		} else {
			double sampleRate = Utils.safeParseDouble((String) hit.get(Fields.SAMPLE_RATE), 100.0d);
			if (sampleRate >= 100.0d) {
				return false;
			} else if (((double) (hashClientIdForSampling((String) hit.get(Fields.CLIENT_ID)) % 10000)) >= r9d * sampleRate) {
				Object[] r7_Object_A = new Object[1];
				r7_Object_A[0] = (hit.get(Fields.HIT_TYPE) == null) ? "unknown" : (String) hit.get(Fields.HIT_TYPE);
				Log.v(String.format("%s hit sampled out", r7_Object_A));
				return true;
			} else {
				return false;
			}
		}
	}

	private String printStackTrace(Throwable t) {
		OutputStream baos = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(baos);
		t.printStackTrace(stream);
		stream.flush();
		return new String(baos.toByteArray());
	}

	public void clearHits() {
		queueToThread(new Runnable() {
			public void run() {
				mServiceProxy.clearHits();
			}
		});
	}

	@VisibleForTesting
	void close() {
		this.mClosed = true;
		interrupt();
	}

	public void dispatch() {
		queueToThread(new Runnable() {
			public void run() {
				mServiceProxy.dispatch();
			}
		});
	}

	public LinkedBlockingQueue<Runnable> getQueue() {
		return this.queue;
	}

	public Thread getThread() {
		return this;
	}

	@VisibleForTesting
	protected void init() {
		this.mServiceProxy.createService();
		this.mCommands = new ArrayList();
		this.mCommands.add(new Command(Command.APPEND_VERSION, "&_v".substring(1), CLIENT_VERSION));
		this.mCommands.add(new Command(Command.APPEND_QUEUE_TIME, "&qt".substring(1), null));
		this.mCommands.add(new Command(Command.APPEND_CACHE_BUSTER, "&z".substring(1), null));
	}

	@VisibleForTesting
	boolean isDisabled() {
		return this.mDisabled;
	}

	@VisibleForTesting
	void queueToThread(Runnable r) {
		this.queue.add(r);
	}

	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			Log.w("sleep interrupted in GAThread initialize");
		}
		try {
			if (this.mServiceProxy == null) {
				this.mServiceProxy = new GAServiceProxy(this.mContext, this);
			}
			init();
			this.mClientId = ClientIdDefaultProvider.getProvider().getValue(Fields.CLIENT_ID);
			this.mInstallCampaign = getAndClearCampaign(this.mContext);
		} catch (Throwable th) {
			Log.e("Error initializing the GAThread: " + printStackTrace(th));
			Log.e("Google Analytics will not start up.");
			this.mDisabled = true;
		}
		while (!(this.mClosed)) {
			Runnable r;
			try {
				r = (Runnable) this.queue.take();
				if (!(this.mDisabled)) {
					r.run();
				}
			} catch (InterruptedException e_2) {
				Log.i(e_2.toString());
			}
		}
	}

	public void sendHit(Map<String, String> hit) {
		Map<String, String> hitCopy = new HashMap(hit);
		String hitTime = (String) hit.get("&ht");
		if (hitTime != null) {
			try {
				Long.valueOf(hitTime).longValue();
			} catch (NumberFormatException e) {
				hitTime = null;
			}
		}
		if (hitTime == null) {
			hitCopy.put("&ht", Long.toString(System.currentTimeMillis()));
		}
		queueToThread(new AnonymousClass_1(hitCopy));
	}

	public void setForceLocalDispatch() {
		queueToThread(new Runnable() {
			public void run() {
				mServiceProxy.setForceLocalDispatch();
			}
		});
	}
}

package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.DebugEvents;
import com.google.analytics.containertag.proto.MutableDebug.EventInfo;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;

class CtfeDebugInformationHandler implements DebugInformationHandler {
	@VisibleForTesting
	static final String CTFE_URL_PATH_PREFIX = "/d?";
	@VisibleForTesting
	static final int NUM_EVENTS_PER_SEND = 1;
	private int currentDebugEventNumber;
	private NetworkClient mClient;
	private CtfeHost mCtfeHost;
	private DebugEvents mDebugEvents;

	public CtfeDebugInformationHandler(CtfeHost host) {
		this(new NetworkClientFactory().createNetworkClient(), host);
	}

	@VisibleForTesting
	CtfeDebugInformationHandler(NetworkClient client, CtfeHost host) {
		this.mCtfeHost = host;
		this.mClient = client;
		this.mDebugEvents = DebugEvents.newMessage();
	}

	private byte[] getDebugEventsAsBytes() {
		return this.mDebugEvents.toByteArray();
	}

	private boolean sendDebugInformationtoCtfe() {
		try {
			NetworkClient r1_NetworkClient = this.mClient;
			CtfeHost r2_CtfeHost = this.mCtfeHost;
			int r3i = this.currentDebugEventNumber;
			this.currentDebugEventNumber = r3i + 1;
			r1_NetworkClient.sendPostRequest(r2_CtfeHost.constructCtfeDebugUrl(r3i), getDebugEventsAsBytes());
			return true;
		} catch (IOException e) {
			Log.e("CtfeDebugInformationHandler: Error sending information to server that handles debug information: " + e.getMessage());
			return false;
		}
	}

	public synchronized void receiveEventInfo(EventInfo event) {
		synchronized(this) {
			this.mDebugEvents.addEvent(event);
			if (this.mDebugEvents.getEventCount() < 1 || !sendDebugInformationtoCtfe()) {
			} else {
				this.mDebugEvents = this.mDebugEvents.clear();
			}
		}
	}
}

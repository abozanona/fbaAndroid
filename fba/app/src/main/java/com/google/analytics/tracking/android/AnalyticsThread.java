package com.google.analytics.tracking.android;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

interface AnalyticsThread {
	public void clearHits();

	public void dispatch();

	public LinkedBlockingQueue<Runnable> getQueue();

	public Thread getThread();

	public void sendHit(Map<String, String> r1_Map_StringString);

	public void setForceLocalDispatch();
}

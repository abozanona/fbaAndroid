package com.google.tagmanager;

interface HitSendingThread {
	public void queueToThread(Runnable r1_Runnable);

	public void sendHit(String r1_String);
}

package com.google.tagmanager;

interface HitStore {
	public void close();

	public void dispatch();

	public Dispatcher getDispatcher();

	public void putHit(long r1j, String r3_String);
}

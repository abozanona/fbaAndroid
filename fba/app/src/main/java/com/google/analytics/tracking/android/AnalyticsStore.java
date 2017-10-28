package com.google.analytics.tracking.android;

import com.google.android.gms.analytics.internal.Command;
import java.util.Collection;
import java.util.Map;

interface AnalyticsStore {
	public void clearHits(long r1j);

	public void close();

	public void dispatch();

	public Dispatcher getDispatcher();

	public void putHit(Map<String, String> r1_Map_StringString, long r2j, String r4_String, Collection<Command> r5_Collection_Command);

	public void setDispatch(boolean r1z);
}

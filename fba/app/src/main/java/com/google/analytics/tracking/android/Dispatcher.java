package com.google.analytics.tracking.android;

import java.util.List;

interface Dispatcher {
	public void close();

	public int dispatchHits(List<Hit> r1_List_Hit);

	public boolean okToDispatch();

	public void overrideHostUrl(String r1_String);
}

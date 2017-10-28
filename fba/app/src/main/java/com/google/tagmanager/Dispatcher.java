package com.google.tagmanager;

import java.util.List;

interface Dispatcher {
	public void close();

	public void dispatchHits(List<Hit> r1_List_Hit);

	public boolean okToDispatch();
}

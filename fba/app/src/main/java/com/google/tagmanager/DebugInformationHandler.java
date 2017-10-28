package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.EventInfo;

interface DebugInformationHandler {
	public void receiveEventInfo(EventInfo r1_EventInfo);
}

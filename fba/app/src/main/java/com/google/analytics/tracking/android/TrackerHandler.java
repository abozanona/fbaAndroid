package com.google.analytics.tracking.android;

import java.util.Map;

abstract class TrackerHandler {
	TrackerHandler() {
	}

	abstract void sendHit(Map<String, String> r1_Map_StringString);
}

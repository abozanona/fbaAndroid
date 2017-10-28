package com.google.tagmanager;

interface EventInfoDistributor {
	public EventInfoBuilder createDataLayerEventEvaluationEventInfo(String r1_String);

	public EventInfoBuilder createMacroEvalutionEventInfo(String r1_String);

	public boolean debugMode();
}

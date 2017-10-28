package com.google.tagmanager;

interface EventInfoBuilder {
	public DataLayerEventEvaluationInfoBuilder createDataLayerEventEvaluationInfoBuilder();

	public MacroEvaluationInfoBuilder createMacroEvaluationInfoBuilder();

	public void processEventInfo();
}

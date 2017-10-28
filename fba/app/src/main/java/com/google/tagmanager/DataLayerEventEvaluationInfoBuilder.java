package com.google.tagmanager;

interface DataLayerEventEvaluationInfoBuilder {
	public ResolvedFunctionCallBuilder createAndAddResult();

	public RuleEvaluationStepInfoBuilder createRulesEvaluation();
}

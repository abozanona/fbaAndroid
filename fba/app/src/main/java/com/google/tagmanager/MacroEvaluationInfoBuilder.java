package com.google.tagmanager;

interface MacroEvaluationInfoBuilder {
	public ResolvedFunctionCallBuilder createResult();

	public RuleEvaluationStepInfoBuilder createRulesEvaluation();
}

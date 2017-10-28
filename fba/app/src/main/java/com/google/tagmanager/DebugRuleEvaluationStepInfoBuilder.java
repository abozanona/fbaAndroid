package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.RuleEvaluationStepInfo;
import com.google.tagmanager.ResourceUtil.ExpandedFunctionCall;
import java.util.Iterator;
import java.util.Set;

class DebugRuleEvaluationStepInfoBuilder implements RuleEvaluationStepInfoBuilder {
	private RuleEvaluationStepInfo ruleEvaluationStepInfo;

	public DebugRuleEvaluationStepInfoBuilder(RuleEvaluationStepInfo ruleEvaluationStepInfo) {
		this.ruleEvaluationStepInfo = ruleEvaluationStepInfo;
	}

	public ResolvedRuleBuilder createResolvedRuleBuilder() {
		return new DebugResolvedRuleBuilder(this.ruleEvaluationStepInfo.addRules());
	}

	public void setEnabledFunctions(Set<ExpandedFunctionCall> enabledFunctions) {
		Iterator i$ = enabledFunctions.iterator();
		while (i$.hasNext()) {
			this.ruleEvaluationStepInfo.addEnabledFunctions(DebugResolvedRuleBuilder.translateExpandedFunctionCall((ExpandedFunctionCall) i$.next()));
		}
	}
}

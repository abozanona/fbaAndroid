package com.google.tagmanager;

import com.google.tagmanager.ResourceUtil.ExpandedFunctionCall;
import java.util.Set;

interface RuleEvaluationStepInfoBuilder {
	public ResolvedRuleBuilder createResolvedRuleBuilder();

	public void setEnabledFunctions(Set<ExpandedFunctionCall> r1_Set_ExpandedFunctionCall);
}

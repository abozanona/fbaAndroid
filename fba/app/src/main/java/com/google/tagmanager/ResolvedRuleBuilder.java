package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;

interface ResolvedRuleBuilder {
	public ResolvedFunctionCallBuilder createNegativePredicate();

	public ResolvedFunctionCallBuilder createPositivePredicate();

	public ResolvedFunctionCallTranslatorList getAddedMacroFunctions();

	public ResolvedFunctionCallTranslatorList getAddedTagFunctions();

	public ResolvedFunctionCallTranslatorList getRemovedMacroFunctions();

	public ResolvedFunctionCallTranslatorList getRemovedTagFunctions();

	public void setValue(Value r1_Value);
}

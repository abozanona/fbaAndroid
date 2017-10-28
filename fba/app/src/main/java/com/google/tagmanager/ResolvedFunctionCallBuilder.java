package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;

interface ResolvedFunctionCallBuilder {
	public ResolvedPropertyBuilder createResolvedPropertyBuilder(String r1_String);

	public void setFunctionResult(Value r1_Value);
}

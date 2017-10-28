package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;

interface ResolvedPropertyBuilder {
	public ValueBuilder createPropertyValueBuilder(Value r1_Value);
}

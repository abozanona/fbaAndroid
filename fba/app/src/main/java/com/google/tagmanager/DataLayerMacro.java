package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class DataLayerMacro extends FunctionCallImplementation {
	private static final String DEFAULT_VALUE;
	private static final String ID;
	private static final String NAME;
	private final DataLayer mDataLayer;

	static {
		ID = FunctionType.CUSTOM_VAR.toString();
		NAME = Key.NAME.toString();
		DEFAULT_VALUE = Key.DEFAULT_VALUE.toString();
	}

	public DataLayerMacro(DataLayer dataLayer) {
		String r0_String = ID;
		String[] r1_String_A = new String[1];
		r1_String_A[0] = NAME;
		super(r0_String, r1_String_A);
		this.mDataLayer = dataLayer;
	}

	public static String getDefaultValueKey() {
		return DEFAULT_VALUE;
	}

	public static String getFunctionId() {
		return ID;
	}

	public static String getNameKey() {
		return NAME;
	}

	public Value evaluate(Map<String, Value> parameters) {
		Object dataLayerValue = this.mDataLayer.get(Types.valueToString((Value) parameters.get(NAME)));
		if (dataLayerValue == null) {
			Value defaultValue = (Value) parameters.get(DEFAULT_VALUE);
			return (defaultValue != null) ? defaultValue : Types.getDefaultValue();
		} else {
			return Types.objectToValue(dataLayerValue);
		}
	}

	public boolean isCacheable() {
		return false;
	}
}

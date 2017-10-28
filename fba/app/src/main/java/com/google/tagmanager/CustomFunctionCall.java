package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class CustomFunctionCall extends FunctionCallImplementation {
	private static final String ADDITIONAL_PARAMS;
	private static final String FUNCTION_CALL_NAME;
	private static final String ID;
	private final CustomEvaluator mFunctionCallEvaluator;

	public static interface CustomEvaluator {
		public Object evaluate(String r1_String, Map<String, Object> r2_Map_StringObject);
	}


	static {
		ID = FunctionType.FUNCTION_CALL.toString();
		FUNCTION_CALL_NAME = Key.FUNCTION_CALL_NAME.toString();
		ADDITIONAL_PARAMS = Key.ADDITIONAL_PARAMS.toString();
	}

	public CustomFunctionCall(CustomEvaluator functionCallEvaluator) {
		String r0_String = ID;
		String[] r1_String_A = new String[1];
		r1_String_A[0] = FUNCTION_CALL_NAME;
		super(r0_String, r1_String_A);
		this.mFunctionCallEvaluator = functionCallEvaluator;
	}

	public static String getAdditionalParamsKey() {
		return ADDITIONAL_PARAMS;
	}

	public static String getFunctionCallNameKey() {
		return FUNCTION_CALL_NAME;
	}

	public static String getFunctionId() {
		return ID;
	}

	public Value evaluate(Map<String, Value> parameters) {
		String functionCallName = Types.valueToString((Value) parameters.get(FUNCTION_CALL_NAME));
		Map<String, Object> objectParams = new HashMap();
		Value additionalParamsValue = (Value) parameters.get(ADDITIONAL_PARAMS);
		if (additionalParamsValue != null) {
			Object additionalParamsObject = Types.valueToObject(additionalParamsValue);
			if (!((additionalParamsObject instanceof Map))) {
				Log.w("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
				return Types.getDefaultValue();
			} else {
				Iterator i$ = ((Map) additionalParamsObject).entrySet().iterator();
				while (i$.hasNext()) {
					Entry<Object, Object> entry = (Entry) i$.next();
					objectParams.put(entry.getKey().toString(), entry.getValue());
				}
			}
		}
		try {
			return Types.objectToValue(this.mFunctionCallEvaluator.evaluate(functionCallName, objectParams));
		} catch (Exception e) {
			Log.w("Custom macro/tag " + functionCallName + " threw exception " + e.getMessage());
			return Types.getDefaultValue();
		}
	}

	public boolean isCacheable() {
		return false;
	}
}

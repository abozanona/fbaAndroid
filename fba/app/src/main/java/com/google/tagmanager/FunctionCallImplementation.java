package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class FunctionCallImplementation {
	private static final String FUNCTION_KEY = "function";
	private final String mFunctionId;
	private final Set<String> mRequiredKeys;

	public FunctionCallImplementation(String functionId, String ... requiredKeys) {
		this.mFunctionId = functionId;
		this.mRequiredKeys = new HashSet(requiredKeys.length);
		String[] arr$ = requiredKeys;
		int len$ = arr$.length;
		int i$ = 0;
		while (i$ < len$) {
			Set r4_Set = this.mRequiredKeys;
			r4_Set.add(arr$[i$]);
			i$++;
		}
	}

	public static String getFunctionKey() {
		return FUNCTION_KEY;
	}

	public abstract Value evaluate(Map<String, Value> r1_Map_StringValue);

	public String getInstanceFunctionId() {
		return this.mFunctionId;
	}

	public Set<String> getRequiredKeys() {
		return this.mRequiredKeys;
	}

	boolean hasRequiredKeys(Set<String> keys) {
		return keys.containsAll(this.mRequiredKeys);
	}

	public abstract boolean isCacheable();
}

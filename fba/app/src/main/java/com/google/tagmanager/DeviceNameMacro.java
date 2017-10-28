package com.google.tagmanager;

import android.os.Build;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class DeviceNameMacro extends FunctionCallImplementation {
	private static final String ID;

	static {
		ID = FunctionType.DEVICE_NAME.toString();
	}

	public DeviceNameMacro() {
		super(ID, new String[0]);
	}

	public static String getFunctionId() {
		return ID;
	}

	public Value evaluate(Map<String, Value> parameters) {
		String manufacturer = Build.MANUFACTURER;
		String model = Build.MODEL;
		if (model.startsWith(manufacturer) || manufacturer.equals("unknown")) {
			return Types.objectToValue(model);
		} else {
			model = manufacturer + " " + model;
			return Types.objectToValue(model);
		}
	}

	public boolean isCacheable() {
		return true;
	}
}

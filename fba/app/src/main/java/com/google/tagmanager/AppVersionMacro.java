package com.google.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class AppVersionMacro extends FunctionCallImplementation {
	private static final String ID;
	private final Context mContext;

	static {
		ID = FunctionType.APP_VERSION.toString();
	}

	public AppVersionMacro(Context context) {
		super(ID, new String[0]);
		this.mContext = context;
	}

	public static String getFunctionId() {
		return ID;
	}

	public Value evaluate(Map<String, Value> parameters) {
		try {
			return Types.objectToValue(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
		} catch (NameNotFoundException e) {
			Log.e("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
			return Types.getDefaultValue();
		}
	}

	public boolean isCacheable() {
		return true;
	}
}

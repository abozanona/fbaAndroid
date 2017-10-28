package com.google.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;

class ResolutionMacro extends FunctionCallImplementation {
	private static final String ID;
	private final Context mContext;

	static {
		ID = FunctionType.RESOLUTION.toString();
	}

	public ResolutionMacro(Context context) {
		super(ID, new String[0]);
		this.mContext = context;
	}

	public static String getFunctionId() {
		return ID;
	}

	public Value evaluate(Map<String, Value> parameters) {
		DisplayMetrics displayMetrics = new DisplayMetrics();
		((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
		int screenWidth = displayMetrics.widthPixels;
		int screenHeight = displayMetrics.heightPixels;
		return Types.objectToValue(screenWidth + "x" + screenHeight);
	}

	public boolean isCacheable() {
		return true;
	}
}

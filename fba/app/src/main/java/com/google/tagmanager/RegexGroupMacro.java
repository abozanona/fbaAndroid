package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class RegexGroupMacro extends FunctionCallImplementation {
	private static final String GROUP;
	private static final String ID;
	private static final String IGNORE_CASE;
	private static final String REGEX;
	private static final String TO_MATCH;

	static {
		ID = FunctionType.REGEX_GROUP.toString();
		TO_MATCH = Key.ARG0.toString();
		REGEX = Key.ARG1.toString();
		IGNORE_CASE = Key.IGNORE_CASE.toString();
		GROUP = Key.GROUP.toString();
	}

	public RegexGroupMacro() {
		String r0_String = ID;
		String[] r1_String_A = new String[2];
		r1_String_A[0] = TO_MATCH;
		r1_String_A[1] = REGEX;
		super(r0_String, r1_String_A);
	}

	public static String getFunctionId() {
		return ID;
	}

	/* JADX WARNING: inconsistent code */
	/*
	public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(java.util.Map<java.lang.String, com.google.analytics.midtier.proto.containertag.TypeSystem.Value> r13_parameters) {
		r12_this = this;
		r11 = TO_MATCH;
		r9 = r13_parameters.get(r11);
		r9 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value) r9;
		r11 = REGEX;
		r7 = r13_parameters.get(r11);
		r7 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value) r7;
		if (r9_toMatch == 0) goto L_0x0020;
	L_0x0012:
		r11 = com.google.tagmanager.Types.getDefaultValue();
		if (r9_toMatch == r11) goto L_0x0020;
	L_0x0018:
		if (r7_regex == 0) goto L_0x0020;
	L_0x001a:
		r11 = com.google.tagmanager.Types.getDefaultValue();
		if (r7_regex != r11) goto L_0x0025;
	L_0x0020:
		r11 = com.google.tagmanager.Types.getDefaultValue();
	L_0x0024:
		return r11;
	L_0x0025:
		r2 = 64;
		r11 = IGNORE_CASE;
		r11 = r13_parameters.get(r11);
		r11 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value) r11;
		r11 = com.google.tagmanager.Types.valueToBoolean(r11);
		r11 = r11.booleanValue();
		if (r11 == 0) goto L_0x003b;
	L_0x0039:
		r2_flags |= 2;
	L_0x003b:
		r3 = 1;
		r11 = GROUP;
		r5 = r13_parameters.get(r11);
		r5 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value) r5;
		if (r5_groupNumberValue == 0) goto L_0x0060;
	L_0x0046:
		r4 = com.google.tagmanager.Types.valueToInt64(r5_groupNumberValue);
		r11 = com.google.tagmanager.Types.getDefaultInt64();
		if (r4_groupNumberLong != r11) goto L_0x0055;
	L_0x0050:
		r11 = com.google.tagmanager.Types.getDefaultValue();
		goto L_0x0024;
	L_0x0055:
		r3_groupNumber = r4_groupNumberLong.intValue();
		if (r3_groupNumber >= 0) goto L_0x0060;
	L_0x005b:
		r11 = com.google.tagmanager.Types.getDefaultValue();
		goto L_0x0024;
	L_0x0060:
		r10 = com.google.tagmanager.Types.valueToString(r9_toMatch);	 //Catch:{ PatternSyntaxException -> 0x008d }
		r8 = com.google.tagmanager.Types.valueToString(r7_regex);	 //Catch:{ PatternSyntaxException -> 0x008d }
		r1 = 0;
		r11 = java.util.regex.Pattern.compile(r8_regexString, r2_flags);	 //Catch:{ PatternSyntaxException -> 0x008d }
		r6 = r11.matcher(r10_toMatchString);	 //Catch:{ PatternSyntaxException -> 0x008d }
		r11 = r6_m.find();	 //Catch:{ PatternSyntaxException -> 0x008d }
		if (r11 == 0) goto L_0x0081;
	L_0x0077:
		r11 = r6_m.groupCount();	 //Catch:{ PatternSyntaxException -> 0x008d }
		if (r11 < r3_groupNumber) goto L_0x0081;
	L_0x007d:
		r1_extracted = r6_m.group(r3_groupNumber);	 //Catch:{ PatternSyntaxException -> 0x008d }
	L_0x0081:
		if (r1_extracted != 0) goto L_0x0088;
	L_0x0083:
		r11 = com.google.tagmanager.Types.getDefaultValue();	 //Catch:{ PatternSyntaxException -> 0x008d }
		goto L_0x0024;
	L_0x0088:
		r11 = com.google.tagmanager.Types.objectToValue(r1_extracted);	 //Catch:{ PatternSyntaxException -> 0x008d }
		goto L_0x0024;
	L_0x008d:
		r0_err = move-exception;
		r11 = com.google.tagmanager.Types.getDefaultValue();
		goto L_0x0024;
	}
	*/
	public Value evaluate(Map<String, Value> r13_Map_StringValue) {
		Value toMatch = (Value) parameters.get(TO_MATCH);
		Value regex = (Value) parameters.get(REGEX);
		if (toMatch == null || toMatch == Types.getDefaultValue() || regex == null || regex == Types.getDefaultValue()) {
			return Types.getDefaultValue();
		} else {
			String extracted;
			Matcher m;
			int flags = 64;
			if (Types.valueToBoolean((Value) parameters.get(IGNORE_CASE)).booleanValue()) {
				flags |= 2;
			}
			int groupNumber = 1;
			Value groupNumberValue = (Value) parameters.get(GROUP);
			if (groupNumberValue != null) {
				Long groupNumberLong = Types.valueToInt64(groupNumberValue);
				if (groupNumberLong == Types.getDefaultInt64()) {
					return Types.getDefaultValue();
				} else {
					groupNumber = groupNumberLong.intValue();
					if (groupNumber < 0) {
						return Types.getDefaultValue();
					}
				}
			}
			try {
				String toMatchString = Types.valueToString(toMatch);
				extracted = null;
				m = Pattern.compile(Types.valueToString(regex), flags).matcher(toMatchString);
				if (!m.find() || m.groupCount() < groupNumber) {
					return Types.objectToValue(extracted);
				} else {
					extracted = m.group(groupNumber);
					return Types.objectToValue(extracted);
				}
			} catch (PatternSyntaxException e) {
				return Types.getDefaultValue();
			}
		}
	}

	public boolean isCacheable() {
		return true;
	}
}

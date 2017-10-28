package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import com.google.tagmanager.protobuf.WireFormat;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class JoinerMacro extends FunctionCallImplementation {
	private static final String ARG0;
	private static final String DEFAULT_ITEM_SEPARATOR = "";
	private static final String DEFAULT_KEY_VALUE_SEPARATOR = "=";
	private static final String ESCAPE;
	private static final String ID;
	private static final String ITEM_SEPARATOR;
	private static final String KEY_VALUE_SEPARATOR;

	static /* synthetic */ class AnonymousClass_1 {
		static final /* synthetic */ int[] $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type;
		static final /* synthetic */ int[] $SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType;

		static {
			$SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType = new int[JoinerMacro.EscapeType.values().length];
			try {
				$SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType[JoinerMacro.EscapeType.URL.ordinal()] = 1;
			} catch (NoSuchFieldError e) {
			}
			try {
				$SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType[JoinerMacro.EscapeType.BACKSLASH.ordinal()] = 2;
			} catch (NoSuchFieldError e_2) {
			}
			try {
				$SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType[JoinerMacro.EscapeType.NONE.ordinal()] = 3;
			} catch (NoSuchFieldError e_3) {
			}
			$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type = new int[Type.values().length];
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.LIST.ordinal()] = 1;
			} catch (NoSuchFieldError e_4) {
			}
			$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.MAP.ordinal()] = 2;
		}
	}

	private static enum EscapeType {
		NONE,
		URL,
		BACKSLASH;

	}


	static {
		ID = FunctionType.JOINER.toString();
		ARG0 = Key.ARG0.toString();
		ITEM_SEPARATOR = Key.ITEM_SEPARATOR.toString();
		KEY_VALUE_SEPARATOR = Key.KEY_VALUE_SEPARATOR.toString();
		ESCAPE = Key.ESCAPE.toString();
	}

	public JoinerMacro() {
		String r0_String = ID;
		String[] r1_String_A = new String[1];
		r1_String_A[0] = ARG0;
		super(r0_String, r1_String_A);
	}

	private void addTo(Set<Character> set, String string) {
		int i = 0;
		while (i < string.length()) {
			set.add(Character.valueOf(string.charAt(i)));
			i++;
		}
	}

	private void append(StringBuilder sb, String s, EscapeType escapeType, Set<Character> charsToBackslashEscape) {
		sb.append(escape(s, escapeType, charsToBackslashEscape));
	}

	private String escape(String s, EscapeType escapeType, Set<Character> charsToBackslashEscape) {
		switch(AnonymousClass_1.$SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType[escapeType.ordinal()]) {
		case WireFormat.WIRETYPE_FIXED64:
			try {
				return ValueEscapeUtil.urlEncode(s);
			} catch (UnsupportedEncodingException e) {
				Log.e("Joiner: unsupported encoding", e);
				return s;
			}
		case WireFormat.WIRETYPE_LENGTH_DELIMITED:
			s = s.replace("\\", "\\\\");
			Iterator i$ = charsToBackslashEscape.iterator();
			while (i$.hasNext()) {
				String charAsString = ((Character) i$.next()).toString();
				s = s.replace(charAsString, "\\" + charAsString);
			}
			return s;
		}
		return s;
	}

	public static String getFunctionId() {
		return ID;
	}

	public Value evaluate(Map<String, Value> parameters) {
		Value input = (Value) parameters.get(ARG0);
		if (input == null) {
			return Types.getDefaultValue();
		} else {
			String itemSeparator;
			String keyValueSeparator;
			Value itemSeparatorParameter = (Value) parameters.get(ITEM_SEPARATOR);
			itemSeparator = (itemSeparatorParameter != null) ? Types.valueToString(itemSeparatorParameter) : DEFAULT_ITEM_SEPARATOR;
			Value keyValueSeparatorParameter = (Value) parameters.get(KEY_VALUE_SEPARATOR);
			keyValueSeparator = (keyValueSeparatorParameter != null) ? Types.valueToString(keyValueSeparatorParameter) : DEFAULT_KEY_VALUE_SEPARATOR;
			EscapeType escapeType = EscapeType.NONE;
			Value escapeParameter = (Value) parameters.get(ESCAPE);
			Set<Character> charsToBackslashEscape = null;
			if (escapeParameter != null) {
				String escape = Types.valueToString(escapeParameter);
				if ("url".equals(escape)) {
					escapeType = EscapeType.URL;
				} else if ("backslash".equals(escape)) {
					escapeType = EscapeType.BACKSLASH;
					charsToBackslashEscape = new HashSet();
					addTo(charsToBackslashEscape, itemSeparator);
					addTo(charsToBackslashEscape, keyValueSeparator);
					charsToBackslashEscape.remove(Character.valueOf('\\'));
				} else {
					Log.e("Joiner: unsupported escape type: " + escape);
					return Types.getDefaultValue();
				}
			}
			StringBuilder sb = new StringBuilder();
			switch(AnonymousClass_1.$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[input.getType().ordinal()]) {
			case WireFormat.WIRETYPE_FIXED64:
				boolean firstTime = true;
				Iterator i$ = input.getListItemList().iterator();
				while (i$.hasNext()) {
					Value itemVal = (Value) i$.next();
					if (!firstTime) {
						sb.append(itemSeparator);
					}
					firstTime = false;
					append(sb, Types.valueToString(itemVal), escapeType, charsToBackslashEscape);
				}
				return Types.objectToValue(sb.toString());
			case WireFormat.WIRETYPE_LENGTH_DELIMITED:
				int i = 0;
				while (i < input.getMapKeyCount()) {
					if (i > 0) {
						sb.append(itemSeparator);
					}
					String value = Types.valueToString(input.getMapValue(i));
					append(sb, Types.valueToString(input.getMapKey(i)), escapeType, charsToBackslashEscape);
					sb.append(keyValueSeparator);
					append(sb, value, escapeType, charsToBackslashEscape);
					i++;
				}
				return Types.objectToValue(sb.toString());
			}
			append(sb, Types.valueToString(input), escapeType, charsToBackslashEscape);
			return Types.objectToValue(sb.toString());
		}
	}

	public boolean isCacheable() {
		return true;
	}
}

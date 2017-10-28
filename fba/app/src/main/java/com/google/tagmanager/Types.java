package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.WireFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Types {
	private static Boolean DEFAULT_BOOLEAN;
	private static Double DEFAULT_DOUBLE;
	private static Long DEFAULT_INT64;
	private static List<Object> DEFAULT_LIST;
	private static Map<Object, Object> DEFAULT_MAP;
	private static TypedNumber DEFAULT_NUMBER;
	private static final Object DEFAULT_OBJECT;
	private static String DEFAULT_STRING;
	private static Value DEFAULT_VALUE;

	static /* synthetic */ class AnonymousClass_1 {
		static final /* synthetic */ int[] $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type;

		static {
			$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type = new int[Type.values().length];
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.STRING.ordinal()] = 1;
			} catch (NoSuchFieldError e) {
			}
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.LIST.ordinal()] = 2;
			} catch (NoSuchFieldError e_2) {
			}
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.MAP.ordinal()] = 3;
			} catch (NoSuchFieldError e_3) {
			}
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.MACRO_REFERENCE.ordinal()] = 4;
			} catch (NoSuchFieldError e_4) {
			}
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.FUNCTION_ID.ordinal()] = 5;
			} catch (NoSuchFieldError e_5) {
			}
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.INTEGER.ordinal()] = 6;
			} catch (NoSuchFieldError e_6) {
			}
			try {
				$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.TEMPLATE.ordinal()] = 7;
			} catch (NoSuchFieldError e_7) {
			}
			$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[Type.BOOLEAN.ordinal()] = 8;
		}
	}


	static {
		DEFAULT_OBJECT = null;
		DEFAULT_INT64 = new Long(0);
		DEFAULT_DOUBLE = new Double(0.0d);
		DEFAULT_NUMBER = TypedNumber.numberWithInt64(0);
		DEFAULT_STRING = new String("");
		DEFAULT_BOOLEAN = new Boolean(false);
		DEFAULT_LIST = new ArrayList(0);
		DEFAULT_MAP = new HashMap();
		DEFAULT_VALUE = objectToValue(DEFAULT_STRING);
	}

	private Types() {
	}

	public static Value functionIdToValue(String id) {
		return Value.newBuilder().setType(Type.FUNCTION_ID).setFunctionId(id).build();
	}

	public static Boolean getDefaultBoolean() {
		return DEFAULT_BOOLEAN;
	}

	public static Double getDefaultDouble() {
		return DEFAULT_DOUBLE;
	}

	public static Long getDefaultInt64() {
		return DEFAULT_INT64;
	}

	public static List<Object> getDefaultList() {
		return DEFAULT_LIST;
	}

	public static Map<Object, Object> getDefaultMap() {
		return DEFAULT_MAP;
	}

	public static TypedNumber getDefaultNumber() {
		return DEFAULT_NUMBER;
	}

	public static Object getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static String getDefaultString() {
		return DEFAULT_STRING;
	}

	public static Value getDefaultValue() {
		return DEFAULT_VALUE;
	}

	private static double getDouble(Object o) {
		if (o instanceof Number) {
			return ((Number) o).doubleValue();
		} else {
			Log.e("getDouble received non-Number");
			return 0.0d;
		}
	}

	private static long getInt64(Object o) {
		if (o instanceof Number) {
			return ((Number) o).longValue();
		} else {
			Log.e("getInt64 received non-Number");
			return 0;
		}
	}

	private static boolean isDoubleableNumber(Object o) {
		if (o instanceof Double || o instanceof Float) {
			return true;
		} else if (!((o instanceof TypedNumber)) || !((TypedNumber) o).isDouble()) {
			return false;
		} else {
			return true;
		}
	}

	private static boolean isInt64ableNumber(Object o) {
		if (o instanceof Byte || o instanceof Short || o instanceof Integer || o instanceof Long) {
			return true;
		} else if (!((o instanceof TypedNumber)) || !((TypedNumber) o).isInt64()) {
			return false;
		} else {
			return true;
		}
	}

	public static Value macroReferenceToValue(String macroName, Escaping ... escapings) {
		Builder builder = Value.newBuilder().setType(Type.MACRO_REFERENCE).setMacroReference(macroName).setContainsReferences(true);
		Escaping[] arr$ = escapings;
		int len$ = arr$.length;
		int i$ = 0;
		while (i$ < len$) {
			builder.addEscaping(arr$[i$]);
			i$++;
		}
		return builder.build();
	}

	public static Boolean objectToBoolean(Object o) {
		return (o instanceof Boolean) ? (Boolean) o : parseBoolean(objectToString(o));
	}

	public static Double objectToDouble(Object o) {
		return (isDoubleableNumber(o)) ? Double.valueOf(getDouble(o)) : parseDouble(objectToString(o));
	}

	public static Long objectToInt64(Object o) {
		return (isInt64ableNumber(o)) ? Long.valueOf(getInt64(o)) : parseInt64(objectToString(o));
	}

	public static TypedNumber objectToNumber(Object o) {
		if (o instanceof TypedNumber) {
			return (TypedNumber) o;
		} else if (isInt64ableNumber(o)) {
			return TypedNumber.numberWithInt64(getInt64(o));
		} else if (isDoubleableNumber(o)) {
			return TypedNumber.numberWithDouble(Double.valueOf(getDouble(o)));
		} else {
			return parseNumber(objectToString(o));
		}
	}

	public static String objectToString(Object o) {
		return (o == null) ? DEFAULT_STRING : o.toString();
	}

	public static Value objectToValue(Object o) {
		Builder builder = Value.newBuilder();
		boolean containsRef = false;
		if (o instanceof Value) {
			return (Value) o;
		} else {
			if (o instanceof String) {
				builder.setType(Type.STRING).setString((String) o);
			} else if (o instanceof List) {
				builder.setType(Type.LIST);
				i$ = ((List) o).iterator();
				while (i$.hasNext()) {
					Value listValue = objectToValue(i$.next());
					if (listValue == DEFAULT_VALUE) {
						return DEFAULT_VALUE;
					} else {
						containsRef = containsRef || listValue.getContainsReferences();
						builder.addListItem(listValue);
					}
				}
			} else if (o instanceof Map) {
				builder.setType(Type.MAP);
				i$ = ((Map) o).entrySet().iterator();
				while (i$.hasNext()) {
					Entry<Object, Object> entry = (Entry) i$.next();
					Value key = objectToValue(entry.getKey());
					Value value = objectToValue(entry.getValue());
					if (key == DEFAULT_VALUE || value == DEFAULT_VALUE) {
						return DEFAULT_VALUE;
					} else {
						containsRef = containsRef || key.getContainsReferences() || value.getContainsReferences();
						builder.addMapKey(key);
						builder.addMapValue(value);
					}
				}
			} else if (isDoubleableNumber(o)) {
				builder.setType(Type.STRING).setString(o.toString());
			} else if (isInt64ableNumber(o)) {
				builder.setType(Type.INTEGER).setInteger(getInt64(o));
			} else if (o instanceof Boolean) {
				builder.setType(Type.BOOLEAN).setBoolean(((Boolean) o).booleanValue());
			} else {
				Log.e("Converting to Value from unknown object type: " + ((o == null) ? "null" : o.getClass().toString()));
				return DEFAULT_VALUE;
			}
			if (containsRef) {
				builder.setContainsReferences(true);
			}
			return builder.build();
		}
	}

	private static Boolean parseBoolean(String s) {
		if ("true".equalsIgnoreCase(s)) {
			return Boolean.TRUE;
		} else if ("false".equalsIgnoreCase(s)) {
			return Boolean.FALSE;
		} else {
			return DEFAULT_BOOLEAN;
		}
	}

	private static Double parseDouble(String s) {
		TypedNumber result = parseNumber(s);
		return (result == DEFAULT_NUMBER) ? DEFAULT_DOUBLE : Double.valueOf(result.doubleValue());
	}

	private static Long parseInt64(String s) {
		TypedNumber result = parseNumber(s);
		return (result == DEFAULT_NUMBER) ? DEFAULT_INT64 : Long.valueOf(result.longValue());
	}

	private static TypedNumber parseNumber(String s) {
		try {
			return TypedNumber.numberWithString(s);
		} catch (NumberFormatException e) {
			Log.e("Failed to convert '" + s + "' to a number.");
			return DEFAULT_NUMBER;
		}
	}

	public static Value templateToValue(Value ... tokens) {
		Builder builder = Value.newBuilder().setType(Type.TEMPLATE);
		boolean containsRef = false;
		Value[] arr$ = tokens;
		int len$ = arr$.length;
		int i$ = 0;
		while (i$ < len$) {
			Value token = arr$[i$];
			builder.addTemplateToken(token);
			containsRef = containsRef || token.getContainsReferences();
			i$++;
		}
		if (containsRef) {
			builder.setContainsReferences(true);
		}
		return builder.build();
	}

	public static Boolean valueToBoolean(Value v) {
		return objectToBoolean(valueToObject(v));
	}

	public static Double valueToDouble(Value v) {
		return objectToDouble(valueToObject(v));
	}

	public static Long valueToInt64(Value v) {
		return objectToInt64(valueToObject(v));
	}

	public static TypedNumber valueToNumber(Value v) {
		return objectToNumber(valueToObject(v));
	}

	public static Object valueToObject(Value v) {
		if (v == null) {
			return DEFAULT_OBJECT;
		} else {
			Iterator i$;
			switch(AnonymousClass_1.$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[v.getType().ordinal()]) {
			case WireFormat.WIRETYPE_FIXED64:
				return v.getString();
			case WireFormat.WIRETYPE_LENGTH_DELIMITED:
				ArrayList<Object> result = new ArrayList(v.getListItemCount());
				i$ = v.getListItemList().iterator();
				while (i$.hasNext()) {
					Object o = valueToObject((Value) i$.next());
					if (o == DEFAULT_OBJECT) {
						return DEFAULT_OBJECT;
					} else {
						result.add(o);
					}
				}
				return result;
			case WireFormat.WIRETYPE_START_GROUP:
				if (v.getMapKeyCount() != v.getMapValueCount()) {
					Log.e("Converting an invalid value to object: " + v.toString());
					return DEFAULT_OBJECT;
				} else {
					Map<Object, Object> result_2 = new HashMap(v.getMapValueCount());
					int i = 0;
					while (i < v.getMapKeyCount()) {
						Object key = valueToObject(v.getMapKey(i));
						Object value = valueToObject(v.getMapValue(i));
						if (key == DEFAULT_OBJECT || value == DEFAULT_OBJECT) {
							return DEFAULT_OBJECT;
						} else {
							result_2.put(key, value);
							i++;
						}
					}
					return result_2;
				}
			case WireFormat.WIRETYPE_END_GROUP:
				Log.e("Trying to convert a macro reference to object");
				return DEFAULT_OBJECT;
			case WireFormat.WIRETYPE_FIXED32:
				Log.e("Trying to convert a function id to object");
				return DEFAULT_OBJECT;
			case Value.MACRO_REFERENCE_FIELD_NUMBER:
				return Long.valueOf(v.getInteger());
			case Value.FUNCTION_ID_FIELD_NUMBER:
				StringBuffer result_3 = new StringBuffer();
				i$ = v.getTemplateTokenList().iterator();
				while (i$.hasNext()) {
					String s = valueToString(i$.next());
					if (s == DEFAULT_STRING) {
						return DEFAULT_OBJECT;
					} else {
						result_3.append(s);
					}
				}
				return result_3.toString();
			case CodedOutputStream.LITTLE_ENDIAN_64_SIZE:
				return Boolean.valueOf(v.getBoolean());
			}
			Log.e("Failed to convert a value of type: " + v.getType());
			return DEFAULT_OBJECT;
		}
	}

	public static String valueToString(Value v) {
		return objectToString(valueToObject(v));
	}
}

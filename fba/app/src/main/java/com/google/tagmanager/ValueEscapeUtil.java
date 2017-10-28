package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import com.google.tagmanager.protobuf.WireFormat;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

class ValueEscapeUtil {
	static /* synthetic */ class AnonymousClass_1 {
		static final /* synthetic */ int[] $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Escaping;

		static {
			$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Escaping = new int[Escaping.values().length];
			$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Escaping[Escaping.ESCAPE_URI.ordinal()] = 1;
		}
	}


	private ValueEscapeUtil() {
	}

	private static ObjectAndStatic<Value> applyEscaping(ObjectAndStatic<Value> value, Escaping escaping) {
		if (!isValidStringType((Value) value.getObject())) {
			Log.e("Escaping can only be applied to strings.");
			return value;
		} else {
			switch(AnonymousClass_1.$SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Escaping[escaping.ordinal()]) {
			case WireFormat.WIRETYPE_FIXED64:
				return escapeUri(value);
			}
			Log.e("Unsupported Value Escaping: " + escaping);
			return value;
		}
	}

	static ObjectAndStatic<Value> applyEscapings(ObjectAndStatic<Value> value, List<Escaping> escapings) {
		ObjectAndStatic<Value> escapedValue = value;
		Iterator i$ = escapings.iterator();
		while (i$.hasNext()) {
			escapedValue = applyEscaping(escapedValue, (Escaping) i$.next());
		}
		return escapedValue;
	}

	private static ObjectAndStatic<Value> escapeUri(ObjectAndStatic<Value> value) {
		try {
			return new ObjectAndStatic(Types.objectToValue(urlEncode(((Value) value.getObject()).getString())), value.isStatic());
		} catch (UnsupportedEncodingException e) {
			Log.e("Escape URI: unsupported encoding", e);
			return value;
		}
	}

	private static boolean isValidStringType(Value value) {
		return value.hasType() && value.getType().equals(Type.STRING) && value.hasString();
	}

	static String urlEncode(String string) throws UnsupportedEncodingException {
		return URLEncoder.encode(string, "UTF-8").replaceAll("\\+", "%20");
	}
}

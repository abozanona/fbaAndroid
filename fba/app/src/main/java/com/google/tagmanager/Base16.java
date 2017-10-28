package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping;

class Base16 {
	Base16() {
	}

	public static byte[] decode(String s) {
		int len = s.length();
		if (len % 2 != 0) {
			throw new IllegalArgumentException("purported base16 string has odd number of characters");
		} else {
			byte[] result = new byte[(len / 2)];
			int i = 0;
			while (i < len) {
				int c1 = Character.digit(s.charAt(i), Escaping.CONVERT_JS_VALUE_TO_EXPRESSION_VALUE);
				int c2 = Character.digit(s.charAt(i + 1), Escaping.CONVERT_JS_VALUE_TO_EXPRESSION_VALUE);
				if (c1 == -1 || c2 == -1) {
					throw new IllegalArgumentException("purported base16 string has illegal char");
				} else {
					result[i / 2] = (byte) ((c1 << 4) + c2);
					i += 2;
				}
			}
			return result;
		}
	}

	public static String encode(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		byte[] arr$ = bytes;
		int len$ = arr$.length;
		int i$ = 0;
		while (i$ < len$) {
			byte b = arr$[i$];
			if ((b & 240) == 0) {
				sb.append("0");
			}
			sb.append(Integer.toHexString(b & 255));
			i$++;
		}
		return sb.toString().toUpperCase();
	}
}

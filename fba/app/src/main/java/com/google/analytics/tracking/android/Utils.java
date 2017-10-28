package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class Utils {
	private static final char[] HEXBYTES;

	static {
		HEXBYTES = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	}

	Utils() {
	}

	public static String filterCampaign(String campaign) {
		if (TextUtils.isEmpty(campaign)) {
			return null;
		} else {
			String urlParameters = campaign;
			if (campaign.contains("?")) {
				String[] urlParts = campaign.split("[\\?]");
				if (urlParts.length > 1) {
					urlParameters = urlParts[1];
				}
			}
			if (urlParameters.contains("%3D")) {
				try {
					urlParameters = URLDecoder.decode(urlParameters, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					return null;
				}
			} else if (!urlParameters.contains("=")) {
				return null;
			}
			Map<String, String> paramsMap = parseURLParameters(urlParameters);
			String[] validParameters = new String[9];
			validParameters[0] = "dclid";
			validParameters[1] = "utm_source";
			validParameters[2] = "gclid";
			validParameters[3] = "utm_campaign";
			validParameters[4] = "utm_medium";
			validParameters[5] = "utm_term";
			validParameters[6] = "utm_content";
			validParameters[7] = "utm_id";
			validParameters[8] = "gmob_t";
			StringBuilder params = new StringBuilder();
			int i = 0;
			while (i < validParameters.length) {
				if (!TextUtils.isEmpty((CharSequence) paramsMap.get(validParameters[i]))) {
					if (params.length() > 0) {
						params.append("&");
					}
					params.append(validParameters[i]).append("=").append((String) paramsMap.get(validParameters[i]));
				}
				i++;
			}
			return params.toString();
		}
	}

	static int fromHexDigit(char hexDigit) {
		int value = hexDigit - 48;
		if (value > 9) {
			return value - 7;
		}
		return value;
	}

	static String getLanguage(Locale locale) {
		if (locale == null) {
			return null;
		} else {
			if (!TextUtils.isEmpty(locale.getLanguage())) {
				StringBuilder lang = new StringBuilder();
				lang.append(locale.getLanguage().toLowerCase());
				if (!TextUtils.isEmpty(locale.getCountry())) {
					lang.append("-").append(locale.getCountry().toLowerCase());
				}
				return lang.toString();
			}
			return null;
		}
	}

	static byte[] hexDecode(String s) {
		byte[] bytes = new byte[(s.length() / 2)];
		int i = 0;
		while (i < bytes.length) {
			bytes[i] = (byte) ((fromHexDigit(s.charAt(i * 2)) << 4) | fromHexDigit(s.charAt((i * 2) + 1)));
			i++;
		}
		return bytes;
	}

	static String hexEncode(byte[] bytes) {
		char[] out = new char[(bytes.length * 2)];
		int i = 0;
		while (i < bytes.length) {
			int b = bytes[i] & 255;
			out[i * 2] = HEXBYTES[b >> 4];
			out[(i * 2) + 1] = HEXBYTES[b & 15];
			i++;
		}
		return new String(out);
	}

	public static Map<String, String> parseURLParameters(String parameterString) {
		Map<String, String> parameters = new HashMap();
		String[] arr$ = parameterString.split("&");
		int len$ = arr$.length;
		int i$ = 0;
		while (i$ < len$) {
			String[] ss = arr$[i$].split("=");
			if (ss.length > 1) {
				parameters.put(ss[0], ss[1]);
			} else if (ss.length != 1 || ss[0].length() == 0) {
				i$++;
			} else {
				parameters.put(ss[0], null);
			}
			i$++;
		}
		return parameters;
	}

	public static void putIfAbsent(Map<String, String> hit, String key, String value) {
		if (!hit.containsKey(key)) {
			hit.put(key, value);
		}
	}

	public static boolean safeParseBoolean(String s, boolean defaultValue) {
		if (s != null) {
			if (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("1")) {
				return true;
			} else {
				if (s.equalsIgnoreCase("false") || s.equalsIgnoreCase("no") || s.equalsIgnoreCase("0")) {
					return false;
				}
				return defaultValue;
			}
		}
		return defaultValue;
	}

	public static double safeParseDouble(String s) {
		return safeParseDouble(s, 0.0d);
	}

	public static double safeParseDouble(String s, double defaultValue) {
		if (s == null) {
			return defaultValue;
		} else {
			try {
				return Double.parseDouble(s);
			} catch (NumberFormatException e) {
				return defaultValue;
			}
		}
	}

	public static long safeParseLong(String s) {
		if (s == null) {
			return 0;
		} else {
			try {
				return Long.parseLong(s);
			} catch (NumberFormatException e) {
				return 0;
			}
		}
	}
}

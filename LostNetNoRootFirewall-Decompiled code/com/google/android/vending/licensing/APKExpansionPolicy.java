package com.google.android.vending.licensing;

import android.content.Context;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class APKExpansionPolicy implements Policy {
    private static final String DEFAULT_MAX_RETRIES = "0";
    private static final String DEFAULT_RETRY_COUNT = "0";
    private static final String DEFAULT_RETRY_UNTIL = "0";
    private static final String DEFAULT_VALIDITY_TIMESTAMP = "0";
    public static final int MAIN_FILE_URL_INDEX = 0;
    private static final long MILLIS_PER_MINUTE = 60000;
    public static final int PATCH_FILE_URL_INDEX = 1;
    private static final String PREFS_FILE = "com.android.vending.licensing.APKExpansionPolicy";
    private static final String PREF_LAST_RESPONSE = "lastResponse";
    private static final String PREF_MAX_RETRIES = "maxRetries";
    private static final String PREF_RETRY_COUNT = "retryCount";
    private static final String PREF_RETRY_UNTIL = "retryUntil";
    private static final String PREF_VALIDITY_TIMESTAMP = "validityTimestamp";
    private static final String TAG = "APKExpansionPolicy";
    private Vector mExpansionFileNames = new Vector();
    private Vector mExpansionFileSizes = new Vector();
    private Vector mExpansionURLs = new Vector();
    private int mLastResponse;
    private long mLastResponseTime = 0;
    private long mMaxRetries;
    private PreferenceObfuscator mPreferences;
    private long mRetryCount;
    private long mRetryUntil;
    private long mValidityTimestamp;

    public APKExpansionPolicy(Context context, Obfuscator obfuscator) {
        this.mPreferences = new PreferenceObfuscator(context.getSharedPreferences(PREFS_FILE, 0), obfuscator);
        this.mLastResponse = Integer.parseInt(this.mPreferences.getString(PREF_LAST_RESPONSE, Integer.toString(Policy.RETRY)));
        this.mValidityTimestamp = Long.parseLong(this.mPreferences.getString(PREF_VALIDITY_TIMESTAMP, "0"));
        this.mRetryUntil = Long.parseLong(this.mPreferences.getString(PREF_RETRY_UNTIL, "0"));
        this.mMaxRetries = Long.parseLong(this.mPreferences.getString(PREF_MAX_RETRIES, "0"));
        this.mRetryCount = Long.parseLong(this.mPreferences.getString(PREF_RETRY_COUNT, "0"));
    }

    private Map decodeExtras(String str) {
        Map hashMap = new HashMap();
        try {
            for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI("?" + str), "UTF-8")) {
                Object name = nameValuePair.getName();
                int i = 0;
                while (hashMap.containsKey(name)) {
                    i++;
                    name = nameValuePair.getName() + i;
                }
                hashMap.put(name, nameValuePair.getValue());
            }
        } catch (URISyntaxException e) {
            Log.w(TAG, "Invalid syntax error while decoding extras data from server.");
        }
        return hashMap;
    }

    private void setLastResponse(int i) {
        this.mLastResponseTime = System.currentTimeMillis();
        this.mLastResponse = i;
        this.mPreferences.putString(PREF_LAST_RESPONSE, Integer.toString(i));
    }

    private void setMaxRetries(String str) {
        Long valueOf;
        try {
            valueOf = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e) {
            Log.w(TAG, "Licence retry count (GR) missing, grace period disabled");
            str = "0";
            valueOf = Long.valueOf(0);
        }
        this.mMaxRetries = valueOf.longValue();
        this.mPreferences.putString(PREF_MAX_RETRIES, str);
    }

    private void setRetryCount(long j) {
        this.mRetryCount = j;
        this.mPreferences.putString(PREF_RETRY_COUNT, Long.toString(j));
    }

    private void setRetryUntil(String str) {
        Long valueOf;
        try {
            valueOf = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e) {
            Log.w(TAG, "License retry timestamp (GT) missing, grace period disabled");
            str = "0";
            valueOf = Long.valueOf(0);
        }
        this.mRetryUntil = valueOf.longValue();
        this.mPreferences.putString(PREF_RETRY_UNTIL, str);
    }

    private void setValidityTimestamp(String str) {
        Long valueOf;
        try {
            valueOf = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e) {
            Log.w(TAG, "License validity timestamp (VT) missing, caching for a minute");
            valueOf = Long.valueOf(System.currentTimeMillis() + MILLIS_PER_MINUTE);
            str = Long.toString(valueOf.longValue());
        }
        this.mValidityTimestamp = valueOf.longValue();
        this.mPreferences.putString(PREF_VALIDITY_TIMESTAMP, str);
    }

    public boolean allowAccess() {
        long currentTimeMillis = System.currentTimeMillis();
        return this.mLastResponse == Policy.LICENSED ? currentTimeMillis <= this.mValidityTimestamp : (this.mLastResponse != Policy.RETRY || currentTimeMillis >= this.mLastResponseTime + MILLIS_PER_MINUTE) ? false : currentTimeMillis <= this.mRetryUntil || this.mRetryCount <= this.mMaxRetries;
    }

    public String getExpansionFileName(int i) {
        return i < this.mExpansionFileNames.size() ? (String) this.mExpansionFileNames.elementAt(i) : null;
    }

    public long getExpansionFileSize(int i) {
        return i < this.mExpansionFileSizes.size() ? ((Long) this.mExpansionFileSizes.elementAt(i)).longValue() : -1;
    }

    public String getExpansionURL(int i) {
        return i < this.mExpansionURLs.size() ? (String) this.mExpansionURLs.elementAt(i) : null;
    }

    public int getExpansionURLCount() {
        return this.mExpansionURLs.size();
    }

    public long getMaxRetries() {
        return this.mMaxRetries;
    }

    public long getRetryCount() {
        return this.mRetryCount;
    }

    public long getRetryUntil() {
        return this.mRetryUntil;
    }

    public long getValidityTimestamp() {
        return this.mValidityTimestamp;
    }

    public void processServerResponse(int i, ResponseData responseData) {
        if (i != Policy.RETRY) {
            setRetryCount(0);
        } else {
            setRetryCount(this.mRetryCount + 1);
        }
        if (i == Policy.LICENSED) {
            Map decodeExtras = decodeExtras(responseData.extra);
            this.mLastResponse = i;
            setValidityTimestamp(Long.toString(System.currentTimeMillis() + MILLIS_PER_MINUTE));
            for (String str : decodeExtras.keySet()) {
                if (str.equals("VT")) {
                    setValidityTimestamp((String) decodeExtras.get(str));
                } else if (str.equals("GT")) {
                    setRetryUntil((String) decodeExtras.get(str));
                } else if (str.equals("GR")) {
                    setMaxRetries((String) decodeExtras.get(str));
                } else if (str.startsWith("FILE_URL")) {
                    setExpansionURL(Integer.parseInt(str.substring("FILE_URL".length())) - 1, (String) decodeExtras.get(str));
                } else if (str.startsWith("FILE_NAME")) {
                    setExpansionFileName(Integer.parseInt(str.substring("FILE_NAME".length())) - 1, (String) decodeExtras.get(str));
                } else if (str.startsWith("FILE_SIZE")) {
                    setExpansionFileSize(Integer.parseInt(str.substring("FILE_SIZE".length())) - 1, Long.parseLong((String) decodeExtras.get(str)));
                }
            }
        } else if (i == Policy.NOT_LICENSED) {
            setValidityTimestamp("0");
            setRetryUntil("0");
            setMaxRetries("0");
        }
        setLastResponse(i);
        this.mPreferences.commit();
    }

    public void resetPolicy() {
        this.mPreferences.putString(PREF_LAST_RESPONSE, Integer.toString(Policy.RETRY));
        setRetryUntil("0");
        setMaxRetries("0");
        setRetryCount(Long.parseLong("0"));
        setValidityTimestamp("0");
        this.mPreferences.commit();
    }

    public void setExpansionFileName(int i, String str) {
        if (i >= this.mExpansionFileNames.size()) {
            this.mExpansionFileNames.setSize(i + 1);
        }
        this.mExpansionFileNames.set(i, str);
    }

    public void setExpansionFileSize(int i, long j) {
        if (i >= this.mExpansionFileSizes.size()) {
            this.mExpansionFileSizes.setSize(i + 1);
        }
        this.mExpansionFileSizes.set(i, Long.valueOf(j));
    }

    public void setExpansionURL(int i, String str) {
        if (i >= this.mExpansionURLs.size()) {
            this.mExpansionURLs.setSize(i + 1);
        }
        this.mExpansionURLs.set(i, str);
    }
}

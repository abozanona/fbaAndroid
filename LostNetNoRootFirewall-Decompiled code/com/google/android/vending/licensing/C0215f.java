package com.google.android.vending.licensing;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.Signature;

class C0215f {
    private final Policy f909a;
    private final LicenseCheckerCallback f910b;
    private final int f911c;
    private final String f912d;
    private final String f913e;
    private final DeviceLimiter f914f;

    C0215f(Policy policy, DeviceLimiter deviceLimiter, LicenseCheckerCallback licenseCheckerCallback, int i, String str, String str2) {
        this.f909a = policy;
        this.f914f = deviceLimiter;
        this.f910b = licenseCheckerCallback;
        this.f911c = i;
        this.f912d = str;
        this.f913e = str2;
    }

    private void m1245a(int i) {
        this.f910b.applicationError(i);
    }

    private void m1246a(int i, ResponseData responseData) {
        this.f909a.processServerResponse(i, responseData);
        if (this.f909a.allowAccess()) {
            this.f910b.allow(i);
        } else {
            this.f910b.dontAllow(i);
        }
    }

    private void m1247d() {
        this.f910b.dontAllow(Policy.NOT_LICENSED);
    }

    public LicenseCheckerCallback m1248a() {
        return this.f910b;
    }

    public void m1249a(PublicKey publicKey, int i, String str, String str2) {
        ResponseData responseData = null;
        String str3;
        if (i == 0 || i == 1 || i == 2) {
            try {
                Signature instance = Signature.getInstance("SHA1withRSA");
                instance.initVerify(publicKey);
                instance.update(str.getBytes());
                if (instance.verify(Base64.decode(str2))) {
                    try {
                        responseData = ResponseData.parse(str);
                        if (responseData.responseCode != i) {
                            Log.e("LicenseValidator", "Response codes don't match.");
                            m1247d();
                            return;
                        } else if (responseData.nonce != this.f911c) {
                            Log.e("LicenseValidator", "Nonce doesn't match.");
                            m1247d();
                            return;
                        } else if (!responseData.packageName.equals(this.f912d)) {
                            Log.e("LicenseValidator", "Package name doesn't match.");
                            m1247d();
                            return;
                        } else if (responseData.versionCode.equals(this.f913e)) {
                            str3 = responseData.userId;
                            if (TextUtils.isEmpty(str3)) {
                                Log.e("LicenseValidator", "User identifier is empty.");
                                m1247d();
                                return;
                            }
                        } else {
                            Log.e("LicenseValidator", "Version codes don't match.");
                            m1247d();
                            return;
                        }
                    } catch (IllegalArgumentException e) {
                        Log.e("LicenseValidator", "Could not parse response.");
                        m1247d();
                        return;
                    }
                }
                Log.e("LicenseValidator", "Signature verification failed.");
                m1247d();
                return;
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (InvalidKeyException e3) {
                m1245a(5);
                return;
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            } catch (Base64DecoderException e4) {
                Log.e("LicenseValidator", "Could not Base64-decode signature.");
                m1247d();
                return;
            }
        }
        str3 = null;
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
            case 2:
                m1246a(this.f914f.isDeviceAllowed(str3), responseData);
                return;
            case 1:
                m1246a(Policy.NOT_LICENSED, responseData);
                return;
            case 3:
                m1245a(3);
                return;
            case 4:
                Log.w("LicenseValidator", "An error has occurred on the licensing server.");
                m1246a(Policy.RETRY, responseData);
                return;
            case 5:
                Log.w("LicenseValidator", "Licensing server is refusing to talk to this device, over quota.");
                m1246a(Policy.RETRY, responseData);
                return;
            case 257:
                Log.w("LicenseValidator", "Error contacting licensing server.");
                m1246a(Policy.RETRY, responseData);
                return;
            case 258:
                m1245a(1);
                return;
            case 259:
                m1245a(2);
                return;
            default:
                Log.e("LicenseValidator", "Unknown response code for license check.");
                m1247d();
                return;
        }
    }

    public int m1250b() {
        return this.f911c;
    }

    public String m1251c() {
        return this.f912d;
    }
}

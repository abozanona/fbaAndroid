package com.google.android.vending.licensing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.vending.licensing.ILicensingService.Stub;
import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LicenseChecker implements ServiceConnection {
    private static final boolean DEBUG_LICENSE_ERROR = false;
    private static final String KEY_FACTORY_ALGORITHM = "RSA";
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String TAG = "LicenseChecker";
    private static final int TIMEOUT_MS = 10000;
    private final Set mChecksInProgress = new HashSet();
    private final Context mContext;
    private Handler mHandler;
    private final String mPackageName;
    private final Queue mPendingChecks = new LinkedList();
    private final Policy mPolicy;
    private PublicKey mPublicKey;
    private ILicensingService mService;
    private final String mVersionCode;

    public LicenseChecker(Context context, Policy policy, String str) {
        this.mContext = context;
        this.mPolicy = policy;
        this.mPublicKey = generatePublicKey(str);
        this.mPackageName = this.mContext.getPackageName();
        this.mVersionCode = getVersionCode(context, this.mPackageName);
        HandlerThread handlerThread = new HandlerThread("background thread");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    private void cleanupService() {
        if (this.mService != null) {
            try {
                this.mContext.unbindService(this);
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "Unable to unbind from licensing service (already unbound)");
            }
            this.mService = null;
        }
    }

    private synchronized void finishCheck(C0215f c0215f) {
        this.mChecksInProgress.remove(c0215f);
        if (this.mChecksInProgress.isEmpty()) {
            cleanupService();
        }
    }

    private int generateNonce() {
        return RANDOM.nextInt();
    }

    private static PublicKey generatePublicKey(String str) {
        try {
            return KeyFactory.getInstance(KEY_FACTORY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            Log.e(TAG, "Could not decode from Base64.");
            throw new IllegalArgumentException(e2);
        } catch (Throwable e22) {
            Log.e(TAG, "Invalid key specification.");
            throw new IllegalArgumentException(e22);
        }
    }

    private static String getVersionCode(Context context, String str) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(str, 0).versionCode);
        } catch (NameNotFoundException e) {
            Log.e(TAG, "Package not found. could not get version code.");
            return "";
        }
    }

    private synchronized void handleServiceConnectionError(C0215f c0215f) {
        this.mPolicy.processServerResponse(Policy.RETRY, null);
        if (this.mPolicy.allowAccess()) {
            c0215f.m1248a().allow(Policy.RETRY);
        } else {
            c0215f.m1248a().dontAllow(Policy.RETRY);
        }
    }

    private void runChecks() {
        while (true) {
            C0215f c0215f = (C0215f) this.mPendingChecks.poll();
            if (c0215f != null) {
                try {
                    Log.i(TAG, "Calling checkLicense on service for " + c0215f.m1251c());
                    this.mService.checkLicense((long) c0215f.m1250b(), c0215f.m1251c(), new C0212c(this, c0215f));
                    this.mChecksInProgress.add(c0215f);
                } catch (Throwable e) {
                    Log.w(TAG, "RemoteException in checkLicense call.", e);
                    handleServiceConnectionError(c0215f);
                }
            } else {
                return;
            }
        }
    }

    public synchronized void checkAccess(LicenseCheckerCallback licenseCheckerCallback) {
        if (this.mPolicy.allowAccess()) {
            Log.i(TAG, "Using cached license response");
            licenseCheckerCallback.allow(Policy.LICENSED);
        } else {
            C0215f c0215f = new C0215f(this.mPolicy, new NullDeviceLimiter(), licenseCheckerCallback, generateNonce(), this.mPackageName, this.mVersionCode);
            if (this.mService == null) {
                Log.i(TAG, "Binding to licensing service.");
                try {
                    if (this.mContext.bindService(new Intent(new String(Base64.decode("Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U="))), this, 1)) {
                        this.mPendingChecks.offer(c0215f);
                    } else {
                        Log.e(TAG, "Could not bind to service.");
                        handleServiceConnectionError(c0215f);
                    }
                } catch (SecurityException e) {
                    licenseCheckerCallback.applicationError(6);
                } catch (Base64DecoderException e2) {
                    e2.printStackTrace();
                }
            } else {
                this.mPendingChecks.offer(c0215f);
                runChecks();
            }
        }
    }

    public synchronized void onDestroy() {
        cleanupService();
        this.mHandler.getLooper().quit();
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.mService = Stub.asInterface(iBinder);
        runChecks();
    }

    public synchronized void onServiceDisconnected(ComponentName componentName) {
        Log.w(TAG, "Service unexpectedly disconnected.");
        this.mService = null;
    }
}

package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

class ab extends Thread implements C0183e {
    private static ab f799g;
    private final LinkedBlockingQueue f800a = new LinkedBlockingQueue();
    private volatile boolean f801b = false;
    private volatile boolean f802c = false;
    private volatile List f803d;
    private volatile String f804e;
    private volatile String f805f;
    private volatile ao f806h;
    private final Context f807i;

    private ab(Context context) {
        super("GAThread");
        if (context != null) {
            this.f807i = context.getApplicationContext();
        } else {
            this.f807i = context;
        }
        start();
    }

    @VisibleForTesting
    static int m1086a(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    static ab m1087a(Context context) {
        if (f799g == null) {
            f799g = new ab(context);
        }
        return f799g;
    }

    private String m1090a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    @VisibleForTesting
    static String m1093b(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[8192];
            int read = openFileInput.read(bArr, 0, 8192);
            if (openFileInput.available() > 0) {
                Log.m1076e("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                Log.m1079w("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            Log.m1077i("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            Log.m1077i("No campaign data found.");
            return null;
        } catch (IOException e2) {
            Log.m1076e("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    private String m1094b(Map map) {
        return map.containsKey(Fields.USE_SECURE) ? ar.m1183a((String) map.get(Fields.USE_SECURE), true) ? "https:" : "http:" : "https:";
    }

    private boolean m1098c(Map map) {
        if (map.get(Fields.SAMPLE_RATE) == null) {
            return false;
        }
        double a = ar.m1179a((String) map.get(Fields.SAMPLE_RATE), 100.0d);
        if (a >= 100.0d) {
            return false;
        }
        if (((double) (m1086a((String) map.get(Fields.CLIENT_ID)) % 10000)) < a * 100.0d) {
            return false;
        }
        String str = map.get(Fields.HIT_TYPE) == null ? "unknown" : (String) map.get(Fields.HIT_TYPE);
        Log.m1078v(String.format("%s hit sampled out", new Object[]{str}));
        return true;
    }

    private void m1100d(Map map) {
        C0186k b = C0190f.m1188b();
        ar.m1182a(map, Fields.APP_NAME, b.mo562b(Fields.APP_NAME));
        ar.m1182a(map, Fields.APP_VERSION, b.mo562b(Fields.APP_VERSION));
        ar.m1182a(map, Fields.APP_ID, b.mo562b(Fields.APP_ID));
        ar.m1182a(map, Fields.APP_INSTALLER_ID, b.mo562b(Fields.APP_INSTALLER_ID));
        map.put("&v", "1");
    }

    public void mo546a() {
        m1103a(new ad(this));
    }

    @VisibleForTesting
    void m1103a(Runnable runnable) {
        this.f800a.add(runnable);
    }

    public void mo547a(Map map) {
        Map hashMap = new HashMap(map);
        String str = (String) map.get("&ht");
        if (str != null) {
            try {
                Long.valueOf(str).longValue();
            } catch (NumberFormatException e) {
                str = null;
            }
        }
        if (str == null) {
            hashMap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        m1103a(new ac(this, hashMap));
    }

    public void mo548b() {
        m1103a(new ae(this));
    }

    public void mo549c() {
        m1103a(new af(this));
    }

    public LinkedBlockingQueue mo550d() {
        return this.f800a;
    }

    public Thread mo551e() {
        return this;
    }

    @VisibleForTesting
    protected void m1109f() {
        this.f806h.mo578d();
        this.f803d = new ArrayList();
        this.f803d.add(new Command(Command.APPEND_VERSION, "&_v".substring(1), "ma3.0.1"));
        this.f803d.add(new Command(Command.APPEND_QUEUE_TIME, "&qt".substring(1), null));
        this.f803d.add(new Command(Command.APPEND_CACHE_BUSTER, "&z".substring(1), null));
    }

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Log.m1079w("sleep interrupted in GAThread initialize");
        }
        try {
            if (this.f806h == null) {
                this.f806h = new C0200s(this.f807i, this);
            }
            m1109f();
            this.f805f = C0191g.m1196b().mo562b(Fields.CLIENT_ID);
            this.f804e = m1093b(this.f807i);
        } catch (Throwable th) {
            Log.m1076e("Error initializing the GAThread: " + m1090a(th));
            Log.m1076e("Google Analytics will not start up.");
            this.f801b = true;
        }
        while (!this.f802c) {
            try {
                Runnable runnable = (Runnable) this.f800a.take();
                if (!this.f801b) {
                    runnable.run();
                }
            } catch (InterruptedException e2) {
                Log.m1077i(e2.toString());
            } catch (Throwable th2) {
                Log.m1076e("Error on GAThread: " + m1090a(th2));
                Log.m1076e("Google Analytics is shutting down.");
                this.f801b = true;
            }
        }
    }
}

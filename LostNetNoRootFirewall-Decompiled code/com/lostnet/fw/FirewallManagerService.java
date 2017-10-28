package com.lostnet.fw;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v4.app.ai;
import com.google.analytics.tracking.android.GAServiceManager;
import com.google.android.vending.licensing.APKExpansionPolicy;
import com.lostnet.fw.p007b.C0289a;
import com.lostnet.fw.p007b.C0290b;
import com.lostnet.fw.p007b.C0291c;
import com.lostnet.fw.p007b.C0292d;
import com.lostnet.fw.p007b.C0293e;
import com.lostnet.fw.p007b.C0294f;
import com.lostnet.fw.p008c.C0296a;
import com.lostnet.fw.p008c.C0297b;
import com.lostnet.fw.p008c.C0300e;
import com.lostnet.fw.p008c.C0301f;
import com.lostnet.fw.p008c.C0302g;
import com.lostnet.fw.p009d.C0309f;
import com.lostnet.fw.p009d.C0310g;
import com.lostnet.fw.p009d.C0311h;
import com.lostnet.fw.p009d.C0313j;
import com.lostnet.fw.p009d.C0315l;
import com.lostnet.fw.p009d.C0316m;
import com.lostnet.fw.p009d.C0317n;
import com.lostnet.fw.ui.LogsActivity;
import java.math.BigInteger;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

public class FirewallManagerService extends Service implements Runnable {
    public static final Object f1290i = "";
    private static FirewallManagerService f1291j;
    public volatile boolean f1292a = false;
    public LinkedBlockingQueue f1293b = new LinkedBlockingQueue(64);
    public C0291c f1294c;
    public C0294f f1295d;
    public C0300e f1296e = new C0300e();
    public C0301f f1297f = new C0301f();
    public boolean f1298g = false;
    public Date f1299h = new Date();
    private boolean f1300k = false;
    private Thread f1301l;
    private boolean f1302m = false;
    private boolean f1303n = false;
    private Thread f1304o;
    public String f1305p = null;
    public String f1306q = null;
    public int f1307r = 0;
    public int f1308s = 0;
    public int f1309t = 0;
    public int f1310u = 0;
    boolean f1311v = false;
    public Date f1312w = new Date();
    public Date f1313x = new Date();

    public FirewallManagerService() {
        C0315l.m2018a("FWManagerService", "DCManagerService");
        if (f1291j != null) {
            C0315l.m2018a("FWManagerService", "DOUBLE INITIALIZATION");
        }
        f1291j = this;
        this.f1294c = new C0291c();
        this.f1295d = new C0294f();
    }

    public static synchronized FirewallManagerService m1852a(Context context) {
        FirewallManagerService firewallManagerService;
        synchronized (FirewallManagerService.class) {
            if (f1291j == null && context != null) {
                C0315l.m2018a("FWManagerService", "getInstance: new");
                context.startService(new Intent(FirewallApplication.m1851a(), FirewallManagerService.class));
            }
            firewallManagerService = f1291j;
        }
        return firewallManagerService;
    }

    private void m1853a() {
        C0315l.m2018a("FWManagerService", "cmdVpnUp");
        this.f1298g = true;
        this.f1299h = new Date();
        String str = "do not wait";
        m1859e();
        Intent intent = new Intent(this, FirewallVPNStart.class);
        intent.setFlags(268435456);
        intent.putExtra("waiter", str);
        startActivity(intent);
        synchronized (str) {
            try {
                str.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        intent = new Intent();
        intent.setAction("com.lostnet.fw.ui.StatusChange");
        sendBroadcast(intent);
    }

    private void m1854a(String str) {
        C0315l.m2018a("FWManagerService", "cmdAlert: " + str);
        if ("com.lostnet.fw.free".equals(getResources().getString(C0330m.package_name)) || !C0313j.m2004a((Context) this) || PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a()).getBoolean("notifications_on", true)) {
            C0310g.m1989b(this);
            Context applicationContext = getApplicationContext();
            ai b = new ai(applicationContext).m102a(C0327j.country_blocked).m104a(getResources().getText(C0330m.app_name)).m107c(str).m105a(true).m106b(str);
            Intent intent = new Intent(this, LogsActivity.class);
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(131072);
            intent.addFlags(536870912);
            b.m103a(PendingIntent.getActivity(applicationContext, 0, intent, 134217728));
            ((NotificationManager) getSystemService("notification")).notify(12345, b.m101a());
        }
    }

    private void m1856b() {
        C0315l.m2018a("FWManagerService", "cmdVpnDown");
        this.f1298g = false;
        FirewallVpnService a = FirewallVpnService.m1864a();
        if (a != null) {
            a.m1870b();
        }
        Intent intent = new Intent();
        intent.setAction("com.lostnet.fw.ui.StatusChange");
        sendBroadcast(intent);
    }

    private void m1857c() {
        C0315l.m2018a("FWManagerService", "cmdNetworkChange");
        boolean z = this.f1302m;
        boolean z2 = this.f1303n;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if ((networkInfo == null || !networkInfo.isAvailable()) && (networkInfo2 == null || !networkInfo2.isAvailable())) {
            this.f1302m = false;
        } else {
            this.f1302m = true;
        }
        if (networkInfo == null || !networkInfo.isAvailable()) {
            this.f1303n = false;
        } else {
            GAServiceManager.getInstance().dispatchLocalHits();
            this.f1303n = true;
            this.f1305p = null;
            WifiManager wifiManager = (WifiManager) getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    String ssid = connectionInfo.getSSID();
                    if (ssid != null) {
                        this.f1305p = ssid;
                    }
                }
            }
        }
        if (!(z == this.f1302m && z2 == this.f1303n)) {
            m1859e();
        }
        C0315l.m2018a("FWManagerService", "cmdNetworkChange: end");
    }

    private void m1858d() {
        C0315l.m2018a("FWManagerService", "cmdUpdateApps");
        this.f1294c.m1925a(this);
        C0315l.m2018a("FWManagerService", "cmdUpdateApps: end");
    }

    private void m1859e() {
        C0315l.m2018a("FWManagerService", "cmdPolicySet");
        int c = ((int) (C0296a.m1930c() / 60000)) % 86400;
        int i = this.f1308s + (this.f1307r * 60);
        int i2 = this.f1310u + (this.f1309t * 60);
        if ((i <= i2 || (c < i && c >= i2)) && (i >= i2 || c < i || c >= i2)) {
            this.f1311v = false;
        } else {
            this.f1311v = true;
        }
        synchronized (this.f1294c) {
            for (C0289a c0289a : this.f1294c.f1366a.values()) {
                int a = c0289a.m1919a();
                int b = c0289a.m1921b();
                if (this.f1311v && (b & 16) != 0) {
                    NativeWrapper.jni_dicke(c0289a.f1363a, 1);
                } else if (!this.f1302m || !this.f1303n || (b & 32) == 0 || this.f1306q == null || this.f1305p == null || !this.f1306q.equals(this.f1305p)) {
                    switch (a) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            if ((b & 8) == 0) {
                                NativeWrapper.jni_dicke(c0289a.f1363a, 0);
                                break;
                            } else {
                                NativeWrapper.jni_dicke(c0289a.f1363a, 2);
                                break;
                            }
                        case 1:
                            if (this.f1302m && this.f1303n) {
                                if ((b & 8) == 0) {
                                    NativeWrapper.jni_dicke(c0289a.f1363a, 0);
                                    break;
                                } else {
                                    NativeWrapper.jni_dicke(c0289a.f1363a, 2);
                                    break;
                                }
                            }
                            NativeWrapper.jni_dicke(c0289a.f1363a, 1);
                            break;
                        case 2:
                            NativeWrapper.jni_dicke(c0289a.f1363a, 1);
                            break;
                    }
                    c0289a.f1364b = false;
                } else {
                    NativeWrapper.jni_dicke(c0289a.f1363a, 1);
                }
            }
            C0311h.m1999a(this, this.f1294c.f1366a, "appsCollection", true);
        }
        synchronized (this.f1295d) {
            for (C0292d c0292d : this.f1295d.f1370a.values()) {
                NativeWrapper.jni_dickh(c0292d.f1367a, c0292d.f1369c);
            }
            C0311h.m1999a(this, this.f1295d.f1370a, "cntsCollection", true);
        }
        String string = C0316m.m2021b().getString("currentProfile", null);
        if (string != null) {
            C0317n.m2025b(string);
        }
        C0315l.m2018a("FWManagerService", "cmdPolicySet: end");
    }

    private void m1860f() {
        C0315l.m2018a("FWManagerService", "cmdPolicyFeedback");
        NativeWrapper.jni_dickp();
        C0315l.m2018a("FWManagerService", "cmdPolicyFeedback: end");
    }

    private void m1861g() {
        Object a;
        try {
            synchronized (this.f1294c) {
                a = C0311h.m1997a(this, "appsCollection");
                if (a != null && (a instanceof C0290b)) {
                    this.f1294c.f1366a = (C0290b) a;
                } else if (a != null) {
                    C0315l.m2018a("FWManagerService", "WRONG TYPE OF APPCOLLECTION: " + a.getClass().getCanonicalName());
                } else {
                    C0315l.m2018a("FWManagerService", "NO APPCOLLECTION");
                }
                this.f1294c.m1925a(this);
            }
        } catch (Exception e) {
        }
        try {
            synchronized (this.f1295d) {
                a = C0311h.m1997a(this, "cntsCollection");
                if (a != null && (a instanceof C0293e)) {
                    this.f1295d.f1370a = (C0293e) a;
                } else if (a != null) {
                    C0315l.m2018a("FWManagerService", "WRONG TYPE OF CNTCOLLECTION: " + a.getClass().getCanonicalName());
                } else {
                    C0315l.m2018a("FWManagerService", "NO CNTCOLLECTION");
                }
                this.f1295d.m1927a(this);
            }
        } catch (Exception e2) {
        }
    }

    private void m1862h() {
        C0315l.m2018a("FWManagerService", "cmdPolicyLoad");
        synchronized (this.f1294c) {
            synchronized (this.f1295d) {
                String string = C0316m.m2021b().getString("currentProfile", null);
                if (string != null) {
                    C0317n.m2027c(string);
                    m1861g();
                }
            }
        }
        NativeWrapper.jni_dickd();
        NativeWrapper.jni_dickg();
        m1859e();
    }

    public void m1863a(C0288a c0288a) {
        C0315l.m2018a("FWManagerService", "queue");
        if (this.f1301l != null) {
            synchronized (this.f1301l) {
                synchronized (this.f1293b) {
                    this.f1293b.offer(c0288a);
                }
                this.f1301l.notifyAll();
            }
        } else {
            C0315l.m2018a("FWManagerService", "queue: the thread is not there");
        }
        C0315l.m2018a("FWManagerService", "queue: end");
    }

    public void enlargeyourtinypenis(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        C0315l.m2018a("FWManagerService", "policyReportCnt: " + i);
        if (this.f1292a) {
            C0315l.m2018a("FWManagerService", "policyReport " + i2 + ":" + i3 + " " + i4 + ":" + i5 + " " + i6);
            BigInteger add = BigInteger.valueOf((long) i3).shiftLeft(31).add(BigInteger.valueOf((long) i2));
            BigInteger add2 = BigInteger.valueOf((long) i5).shiftLeft(31).add(BigInteger.valueOf((long) i4));
            synchronized (this.f1295d.f1370a) {
                if (((C0292d) this.f1295d.f1370a.get(Integer.valueOf(i))) == null) {
                    this.f1295d.f1370a.put(Integer.valueOf(i), new C0292d(C0309f.m1974a(i), i));
                }
            }
            Long valueOf = Long.valueOf(C0296a.m1929b());
            Long valueOf2 = Long.valueOf(C0296a.m1928a());
            synchronized (this.f1297f) {
                this.f1297f.m1952a(valueOf.longValue()).m1945b(i, add, add2, i6, i7, i8, i9, i10);
                ((C0302g) this.f1297f.m1954b(valueOf.longValue())).m1959a(BigInteger.ZERO, BigInteger.ZERO, i6, i7, i8, i9, i10);
            }
            synchronized (this.f1296e) {
                this.f1296e.m1952a(valueOf2.longValue()).m1945b(i, add, add2, i6, i7, i8, i9, i10);
                ((C0302g) this.f1296e.m1954b(valueOf2.longValue())).m1959a(BigInteger.ZERO, BigInteger.ZERO, i6, i7, i8, i9, i10);
            }
        }
    }

    public void forgetyourmomsass(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        if (this.f1292a) {
            C0297b a;
            BigInteger add = BigInteger.valueOf((long) i4).shiftLeft(31).add(BigInteger.valueOf((long) i3));
            BigInteger add2 = BigInteger.valueOf((long) i6).shiftLeft(31).add(BigInteger.valueOf((long) i5));
            Long valueOf = Long.valueOf(C0296a.m1929b());
            Long valueOf2 = Long.valueOf(C0296a.m1928a());
            synchronized (this.f1297f) {
                a = this.f1297f.m1952a(valueOf.longValue());
                a.m1944b(i, i2, add, add2, i7, i8, i9, i10, i11);
                ((C0302g) this.f1297f.m1954b(valueOf.longValue())).m1959a(BigInteger.ZERO, BigInteger.ZERO, 0, i7, 0, 0, 0);
                a.m1939a(i2, BigInteger.ZERO, BigInteger.ZERO, 0, i7, 0, 0, 0);
                a.m1938a(i2, i, BigInteger.ZERO, BigInteger.ZERO, 0, i7, 0, 0, 0);
            }
            synchronized (this.f1296e) {
                a = this.f1296e.m1952a(valueOf2.longValue());
                a.m1944b(i, i2, add, add2, i7, i8, i9, i10, i11);
                ((C0302g) this.f1296e.m1954b(valueOf2.longValue())).m1959a(BigInteger.ZERO, BigInteger.ZERO, 0, i7, 0, 0, 0);
                a.m1939a(i2, BigInteger.ZERO, BigInteger.ZERO, 0, i7, 0, 0, 0);
                a.m1938a(i2, i, BigInteger.ZERO, BigInteger.ZERO, 0, i7, 0, 0, 0);
            }
        }
    }

    public void lickmyass(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        C0315l.m2018a("FWManagerService", "policyReportAppCnt: " + i + " " + i2);
        if (this.f1292a) {
            C0315l.m2018a("FWManagerService", "policyReport " + i3 + ":" + i4 + " " + i5 + ":" + i6 + " " + i7 + "/" + i8 + " " + i9 + "+" + i10 + " " + i11);
            BigInteger add = BigInteger.valueOf((long) i4).shiftLeft(31).add(BigInteger.valueOf((long) i3));
            BigInteger add2 = BigInteger.valueOf((long) i6).shiftLeft(31).add(BigInteger.valueOf((long) i5));
            Long valueOf = Long.valueOf(C0296a.m1929b());
            Long valueOf2 = Long.valueOf(C0296a.m1928a());
            synchronized (this.f1297f) {
                this.f1297f.m1952a(valueOf.longValue()).m1938a(i, i2, add, add2, i7, i8, i9, i10, i11);
            }
            synchronized (this.f1296e) {
                this.f1296e.m1952a(valueOf2.longValue()).m1938a(i, i2, add, add2, i7, i8, i9, i10, i11);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        C0315l.m2018a("FWManagerService", "onBind");
        return null;
    }

    public void onDestroy() {
        try {
            this.f1300k = true;
            this.f1301l.join();
            this.f1301l = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        C0315l.m2019b("FWManagerService", "onDestroy");
        this.f1292a = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(android.content.Intent r8, int r9, int r10) {
        /*
        r7 = this;
        r2 = 1;
        r1 = 0;
        r0 = "FWManagerService";
        r3 = "onStartCommand";
        com.lostnet.fw.p009d.C0315l.m2018a(r0, r3);
        r3 = f1290i;
        monitor-enter(r3);
        r0 = r7.f1292a;	 Catch:{ all -> 0x00eb }
        if (r0 == 0) goto L_0x001a;
    L_0x0010:
        r0 = "FWManagerService";
        r2 = "onStartCommand: DOUBLE START!!!";
        com.lostnet.fw.p009d.C0315l.m2018a(r0, r2);	 Catch:{ all -> 0x00eb }
        monitor-exit(r3);	 Catch:{ all -> 0x00eb }
        r0 = r1;
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = 1;
        r7.f1292a = r0;	 Catch:{ all -> 0x00eb }
        com.lostnet.fw.p009d.C0311h.m1998a(r7);	 Catch:{ all -> 0x00eb }
        r0 = r7.f1296e;	 Catch:{ all -> 0x00eb }
        r0.m1956c(r7);	 Catch:{ all -> 0x00eb }
        r0 = r7.f1297f;	 Catch:{ all -> 0x00eb }
        r0.m1956c(r7);	 Catch:{ all -> 0x00eb }
        monitor-exit(r3);	 Catch:{ all -> 0x00eb }
        r0 = "com.lostnet.fw.free";
        r3 = r7.getResources();
        r4 = com.lostnet.fw.C0330m.package_name;
        r3 = r3.getString(r4);
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x00ee;
    L_0x003d:
        r0 = com.lostnet.fw.p009d.C0313j.m2004a(r7);
        if (r0 == 0) goto L_0x00ee;
    L_0x0043:
        r0 = java.lang.Boolean.TRUE;
        r0 = r0.booleanValue();
    L_0x0049:
        com.lostnet.fw.p009d.C0316m.m2020a();
        r3 = com.lostnet.fw.FirewallApplication.m1851a();
        r3 = android.preference.PreferenceManager.getDefaultSharedPreferences(r3);
        r4 = r3.edit();
        r5 = "ad_blocking_on";
        r5 = r3.getBoolean(r5, r2);
        if (r5 == 0) goto L_0x0068;
    L_0x0060:
        r6 = "ad_blocking_on";
        r4.putBoolean(r6, r5);
        r4.apply();
    L_0x0068:
        r5 = "malware_shield_on";
        r5 = r3.getBoolean(r5, r0);
        if (r0 == 0) goto L_0x007a;
    L_0x0070:
        if (r5 == 0) goto L_0x007a;
    L_0x0072:
        r0 = "malware_shield_on";
        r4.putBoolean(r0, r5);
        r4.apply();
    L_0x007a:
        r0 = "officeWifi";
        r4 = 0;
        r0 = r3.getString(r0, r4);
        r7.f1306q = r0;
        r0 = "nightStartsHour";
        r0 = r3.getInt(r0, r1);
        r7.f1307r = r0;
        r0 = "nightStartsMin";
        r0 = r3.getInt(r0, r1);
        r7.f1308s = r0;
        r0 = "nightEndsHour";
        r0 = r3.getInt(r0, r1);
        r7.f1309t = r0;
        r0 = "nightEndsMin";
        r0 = r3.getInt(r0, r1);
        r7.f1310u = r0;
        r7.m1861g();
        r7.f1300k = r1;
        r0 = new com.lostnet.fw.c;
        r1 = "DCManagerService.monitor";
        r0.<init>(r7, r1);
        r7.f1301l = r0;
        r0 = r7.f1301l;
        r0.start();
        r0 = new com.lostnet.fw.a;
        r1 = 2;
        r0.<init>(r1);
        r7.m1863a(r0);
        r0 = "status_on";
        r0 = r3.getBoolean(r0, r2);
        if (r0 == 0) goto L_0x00cf;
    L_0x00c7:
        r0 = new com.lostnet.fw.a;
        r0.<init>(r2);
        r7.m1863a(r0);
    L_0x00cf:
        r0 = new com.lostnet.fw.a;
        r1 = 3;
        r0.<init>(r1);
        r7.m1863a(r0);
        r0 = new com.lostnet.fw.a;
        r1 = 5;
        r0.<init>(r1);
        r7.m1863a(r0);
        r0 = "FWManagerService";
        r1 = "onStartCommand: end";
        com.lostnet.fw.p009d.C0315l.m2018a(r0, r1);
        r0 = r2;
        goto L_0x0019;
    L_0x00eb:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00eb }
        throw r0;
    L_0x00ee:
        r0 = java.lang.Boolean.FALSE;
        r0 = r0.booleanValue();
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lostnet.fw.FirewallManagerService.onStartCommand(android.content.Intent, int, int):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r10 = this;
        r9 = 2;
        r2 = 0;
        r0 = "FWManagerService";
        r1 = "run";
        com.lostnet.fw.p009d.C0315l.m2018a(r0, r1);
        r0 = new com.lostnet.fw.c;
        r1 = new com.lostnet.fw.b;
        r1.<init>(r10);
        r3 = "t9";
        r0.<init>(r1, r3);
        r10.f1304o = r0;
        r0 = r10.f1304o;
        r0.start();
        com.lostnet.fw.NativeWrapper.jni_dicka(r10);
    L_0x001f:
        r0 = r10.f1300k;
        if (r0 != 0) goto L_0x00be;
    L_0x0023:
        r3 = r10.f1301l;	 Catch:{ InterruptedException -> 0x00e0 }
        monitor-enter(r3);	 Catch:{ InterruptedException -> 0x00e0 }
        r1 = r2;
    L_0x0027:
        r0 = r10.f1300k;	 Catch:{ all -> 0x00dd }
        if (r0 != 0) goto L_0x00b9;
    L_0x002b:
        r1 = r10.f1293b;	 Catch:{ all -> 0x00dd }
        monitor-enter(r1);	 Catch:{ all -> 0x00dd }
        r0 = r10.f1293b;	 Catch:{ all -> 0x00da }
        r0 = r0.poll();	 Catch:{ all -> 0x00da }
        r0 = (com.lostnet.fw.C0288a) r0;	 Catch:{ all -> 0x00da }
        monitor-exit(r1);	 Catch:{ all -> 0x00da }
        if (r0 != 0) goto L_0x01c6;
    L_0x0039:
        r1 = r10.f1301l;	 Catch:{ all -> 0x00dd }
        r1.wait();	 Catch:{ all -> 0x00dd }
        r1 = r10.f1298g;	 Catch:{ all -> 0x00dd }
        if (r1 == 0) goto L_0x00e6;
    L_0x0042:
        r1 = com.lostnet.fw.FirewallVpnService.m1864a();	 Catch:{ all -> 0x00dd }
        if (r1 == 0) goto L_0x00e6;
    L_0x0048:
        r1 = new java.util.Date;	 Catch:{ all -> 0x00dd }
        r1.<init>();	 Catch:{ all -> 0x00dd }
        r4 = r1.getTime();	 Catch:{ all -> 0x00dd }
        r6 = r10.f1312w;	 Catch:{ all -> 0x00dd }
        r6 = r6.getTime();	 Catch:{ all -> 0x00dd }
        r4 = r4 - r6;
        r6 = 10000000; // 0x989680 float:1.4012985E-38 double:4.9406565E-317;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x00e6;
    L_0x005f:
        r4 = com.lostnet.fw.NativeWrapper.jni_dickq();	 Catch:{ all -> 0x00dd }
        r10.f1312w = r1;	 Catch:{ all -> 0x00dd }
        if (r4 == 0) goto L_0x00e6;
    L_0x0067:
        r5 = r1.getTime();	 Catch:{ all -> 0x00dd }
        r0 = r10.f1313x;	 Catch:{ all -> 0x00dd }
        r7 = r0.getTime();	 Catch:{ all -> 0x00dd }
        r5 = r5 - r7;
        r7 = 300000000; // 0x11e1a300 float:3.5599197E-28 double:1.482196938E-315;
        r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r0 <= 0) goto L_0x0090;
    L_0x0079:
        r10.f1313x = r1;	 Catch:{ all -> 0x00dd }
        r0 = "error";
        r1 = "selftest";
        r5 = 0;
        r6 = (long) r4;	 Catch:{ all -> 0x00dd }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x00dd }
        r0 = com.google.analytics.tracking.android.MapBuilder.createEvent(r0, r1, r5, r6);	 Catch:{ all -> 0x00dd }
        r0 = r0.build();	 Catch:{ all -> 0x00dd }
        com.lostnet.fw.p009d.C0318o.m2031a(r0);	 Catch:{ all -> 0x00dd }
    L_0x0090:
        r0 = r10.f1293b;	 Catch:{ all -> 0x00dd }
        r1 = new com.lostnet.fw.a;	 Catch:{ all -> 0x00dd }
        r5 = 1;
        r1.<init>(r5);	 Catch:{ all -> 0x00dd }
        r0.add(r1);	 Catch:{ all -> 0x00dd }
        r1 = new com.lostnet.fw.a;	 Catch:{ all -> 0x00dd }
        r0 = 2;
        r1.<init>(r0);	 Catch:{ all -> 0x00dd }
        r0 = "ServiceThread";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00dd }
        r5.<init>();	 Catch:{ all -> 0x00dd }
        r6 = "restarting on selftest fail ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x00dd }
        r4 = r5.append(r4);	 Catch:{ all -> 0x00dd }
        r4 = r4.toString();	 Catch:{ all -> 0x00dd }
        com.lostnet.fw.p009d.C0315l.m2018a(r0, r4);	 Catch:{ all -> 0x00dd }
    L_0x00b9:
        r0 = r10.f1300k;	 Catch:{ all -> 0x00dd }
        if (r0 == 0) goto L_0x0118;
    L_0x00bd:
        monitor-exit(r3);	 Catch:{ all -> 0x00dd }
    L_0x00be:
        com.lostnet.fw.NativeWrapper.jni_dicko();
        r0 = r10.f1304o;	 Catch:{ InterruptedException -> 0x01c0 }
        if (r0 == 0) goto L_0x00cf;
    L_0x00c5:
        r0 = r10.f1304o;	 Catch:{ InterruptedException -> 0x01c0 }
        r1 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r0.join(r1);	 Catch:{ InterruptedException -> 0x01c0 }
        r0 = 0;
        r10.f1304o = r0;	 Catch:{ InterruptedException -> 0x01c0 }
    L_0x00cf:
        r0 = "FWManagerService";
        r1 = "run: end";
        com.lostnet.fw.p009d.C0315l.m2018a(r0, r1);
        com.lostnet.fw.NativeWrapper.jni_dickc();
        return;
    L_0x00da:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00da }
        throw r0;	 Catch:{ all -> 0x00dd }
    L_0x00dd:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00dd }
        throw r0;	 Catch:{ InterruptedException -> 0x00e0 }
    L_0x00e0:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x001f;
    L_0x00e6:
        r1 = r10.f1298g;	 Catch:{ all -> 0x00dd }
        if (r1 == 0) goto L_0x01c3;
    L_0x00ea:
        r1 = com.lostnet.fw.FirewallVpnService.m1864a();	 Catch:{ all -> 0x00dd }
        if (r1 != 0) goto L_0x01c3;
    L_0x00f0:
        r1 = new java.util.Date;	 Catch:{ all -> 0x00dd }
        r1.<init>();	 Catch:{ all -> 0x00dd }
        r4 = r1.getTime();	 Catch:{ all -> 0x00dd }
        r1 = r10.f1299h;	 Catch:{ all -> 0x00dd }
        r6 = r1.getTime();	 Catch:{ all -> 0x00dd }
        r4 = r4 - r6;
        r6 = 15000000; // 0xe4e1c0 float:2.1019477E-38 double:7.4109847E-317;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0115;
    L_0x0107:
        r1 = new com.lostnet.fw.a;	 Catch:{ all -> 0x00dd }
        r0 = 1;
        r1.<init>(r0);	 Catch:{ all -> 0x00dd }
        r0 = "ServiceThread";
        r4 = "triggering ON";
        com.lostnet.fw.p009d.C0315l.m2018a(r0, r4);	 Catch:{ all -> 0x00dd }
        goto L_0x00b9;
    L_0x0115:
        r1 = r0;
        goto L_0x0027;
    L_0x0118:
        monitor-exit(r3);	 Catch:{ all -> 0x00dd }
        r0 = "FWManagerService";
        r3 = "run: item";
        com.lostnet.fw.p009d.C0315l.m2018a(r0, r3);	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = r1.m1916a();	 Catch:{ InterruptedException -> 0x00e0 }
        switch(r0) {
            case 1: goto L_0x0137;
            case 2: goto L_0x015a;
            case 3: goto L_0x015f;
            case 4: goto L_0x0164;
            case 5: goto L_0x016e;
            case 6: goto L_0x0173;
            case 7: goto L_0x0178;
            case 8: goto L_0x0181;
            case 9: goto L_0x0169;
            default: goto L_0x0127;
        };	 Catch:{ InterruptedException -> 0x00e0 }
    L_0x0127:
        r0 = r1;
    L_0x0128:
        r0.m1918c();	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = r10.f1297f;	 Catch:{ InterruptedException -> 0x00e0 }
        r0.m1955b(r10);	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = r10.f1296e;	 Catch:{ InterruptedException -> 0x00e0 }
        r0.m1955b(r10);	 Catch:{ InterruptedException -> 0x00e0 }
        goto L_0x001f;
    L_0x0137:
        r0 = r10.f1293b;	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = r0.peek();	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = (com.lostnet.fw.C0288a) r0;	 Catch:{ InterruptedException -> 0x00e0 }
        if (r0 == 0) goto L_0x0155;
    L_0x0141:
        r0 = r0.m1916a();	 Catch:{ InterruptedException -> 0x00e0 }
        if (r0 != r9) goto L_0x0155;
    L_0x0147:
        r0 = "FWManagerService";
        r3 = "run: skipping ON: there is already an OFF";
        com.lostnet.fw.p009d.C0315l.m2018a(r0, r3);	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = r10.f1293b;	 Catch:{ InterruptedException -> 0x00e0 }
        r0.poll();	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = r1;
        goto L_0x0128;
    L_0x0155:
        r10.m1853a();	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = r1;
        goto L_0x0128;
    L_0x015a:
        r10.m1856b();	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = r1;
        goto L_0x0128;
    L_0x015f:
        r10.m1857c();	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = r1;
        goto L_0x0128;
    L_0x0164:
        r10.m1858d();	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = r1;
        goto L_0x0128;
    L_0x0169:
        r10.m1862h();	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = r1;
        goto L_0x0128;
    L_0x016e:
        r10.m1859e();	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = r1;
        goto L_0x0128;
    L_0x0173:
        r10.m1860f();	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = r1;
        goto L_0x0128;
    L_0x0178:
        r0 = r1.m1917b();	 Catch:{ InterruptedException -> 0x00e0 }
        r10.m1854a(r0);	 Catch:{ InterruptedException -> 0x00e0 }
        r0 = r1;
        goto L_0x0128;
    L_0x0181:
        r3 = com.lostnet.fw.p008c.C0296a.m1930c();	 Catch:{ InterruptedException -> 0x00e0 }
        r5 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r3 = r3 / r5;
        r0 = (int) r3;	 Catch:{ InterruptedException -> 0x00e0 }
        r3 = 86400; // 0x15180 float:1.21072E-40 double:4.26873E-319;
        r0 = r0 % r3;
        r3 = r10.f1308s;	 Catch:{ InterruptedException -> 0x00e0 }
        r4 = r10.f1307r;	 Catch:{ InterruptedException -> 0x00e0 }
        r4 = r4 * 60;
        r3 = r3 + r4;
        r4 = r10.f1310u;	 Catch:{ InterruptedException -> 0x00e0 }
        r5 = r10.f1309t;	 Catch:{ InterruptedException -> 0x00e0 }
        r5 = r5 * 60;
        r4 = r4 + r5;
        if (r3 <= r4) goto L_0x01a2;
    L_0x019e:
        if (r0 >= r3) goto L_0x01a8;
    L_0x01a0:
        if (r0 < r4) goto L_0x01a8;
    L_0x01a2:
        if (r3 >= r4) goto L_0x01b4;
    L_0x01a4:
        if (r0 < r3) goto L_0x01b4;
    L_0x01a6:
        if (r0 >= r4) goto L_0x01b4;
    L_0x01a8:
        r0 = r10.f1311v;	 Catch:{ InterruptedException -> 0x00e0 }
        if (r0 != 0) goto L_0x0127;
    L_0x01ac:
        r0 = new com.lostnet.fw.a;	 Catch:{ InterruptedException -> 0x00e0 }
        r1 = 5;
        r0.<init>(r1);	 Catch:{ InterruptedException -> 0x00e0 }
        goto L_0x0128;
    L_0x01b4:
        r0 = r10.f1311v;	 Catch:{ InterruptedException -> 0x00e0 }
        if (r0 == 0) goto L_0x0127;
    L_0x01b8:
        r0 = new com.lostnet.fw.a;	 Catch:{ InterruptedException -> 0x00e0 }
        r1 = 5;
        r0.<init>(r1);	 Catch:{ InterruptedException -> 0x00e0 }
        goto L_0x0128;
    L_0x01c0:
        r0 = move-exception;
        goto L_0x00cf;
    L_0x01c3:
        r1 = r0;
        goto L_0x0027;
    L_0x01c6:
        r1 = r0;
        goto L_0x00b9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lostnet.fw.FirewallManagerService.run():void");
    }

    public void suckmydick(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        C0315l.m2018a("FWManagerService", "policyReportApp: " + i);
        if (this.f1292a) {
            C0315l.m2018a("FWManagerService", "policyReport " + i2 + ":" + i3 + " " + i4 + ":" + i5 + " " + i6 + "/" + i7 + " " + i8 + "+" + i9 + " " + i10);
            BigInteger add = BigInteger.valueOf((long) i3).shiftLeft(31).add(BigInteger.valueOf((long) i2));
            BigInteger add2 = BigInteger.valueOf((long) i5).shiftLeft(31).add(BigInteger.valueOf((long) i4));
            synchronized (this.f1294c) {
                if (((C0289a) this.f1294c.f1366a.get(Integer.valueOf(i))) == null) {
                    this.f1294c.f1366a.put(Integer.valueOf(i), new C0289a(i));
                }
            }
            Long valueOf = Long.valueOf(C0296a.m1929b());
            Long valueOf2 = Long.valueOf(C0296a.m1928a());
            synchronized (this.f1297f) {
                this.f1297f.m1952a(valueOf.longValue()).m1939a(i, add, add2, i6, i7, i8, i9, i10);
                ((C0302g) this.f1297f.m1954b(valueOf.longValue())).m1959a(add, add2, i6, i7, i8, i9, i10);
            }
            synchronized (this.f1296e) {
                this.f1296e.m1952a(valueOf2.longValue()).m1939a(i, add, add2, i6, i7, i8, i9, i10);
                ((C0302g) this.f1296e.m1954b(valueOf2.longValue())).m1959a(add, add2, i6, i7, i8, i9, i10);
            }
        }
    }

    public void whodidnotfuckyourwife() {
        C0315l.m2018a("FWManagerService", "policyTrigger");
        if (this.f1292a) {
            m1863a(new C0288a(8));
        }
    }
}

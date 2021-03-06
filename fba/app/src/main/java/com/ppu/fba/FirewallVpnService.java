package com.ppu.fba;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.net.VpnService;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.C0308e;
import com.ppu.fba.p009d.C0309f;
import com.ppu.fba.p009d.Log1;
import com.ppu.fba.p009d.Log1;
import com.ppu.fba.ui.LogsActivity;
import java.util.List;

@TargetApi(14)
public class FirewallVpnService extends VpnService {
    private static FirewallVpnService f1316b;
    public boolean f1317a;
    private Thread f1318c;
    private Thread f1319d;
    private Thread f1320e;
    public boolean f1321f = false;
    private ParcelFileDescriptor f1322g;
    private Thread f1323h;
    private Thread f1324i;

    public FirewallVpnService() {
        if (f1316b != null) {
            Log1.LogF1("DCVpnService", "DCVpnService: DOUBLE INITIALIZATION!!!");
            return;
        }
        f1316b = this;
        Log1.LogF1("DCVpnService", "DCVpnService");
    }

    public static FirewallVpnService m1864a() {
        return f1316b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1866c() {
        /*
        r10 = this;
        r2 = 0;
        r1 = 1;
        r0 = "DCVpnService";
        r3 = "startVPN";
        com.ppu.fba.p009d.Log1.LogF1(r0, r3);
        monitor-enter(r10);
        r0 = r10.f1317a;	 Catch:{ all -> 0x0065 }
        if (r0 == 0) goto L_0x0017;
    L_0x000e:
        r0 = "DCVpnService";
        r1 = "startVPN: already started";
        com.ppu.fba.p009d.Log1.LogF1(r0, r1);	 Catch:{ all -> 0x0065 }
        monitor-exit(r10);	 Catch:{ all -> 0x0065 }
    L_0x0016:
        return;
    L_0x0017:
        r0 = 1;
        r10.f1317a = r0;	 Catch:{ all -> 0x0065 }
        monitor-exit(r10);	 Catch:{ all -> 0x0065 }
        r0 = "DCVpnService";
        r3 = "startVPN: about to build";
        com.ppu.fba.p009d.Log1.LogF1(r0, r3);
        r0 = com.ppu.fba.FirewallApplication.m1851a();
        r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r0);
        r3 = "data_caching_on";
        r3 = r0.getBoolean(r3, r2);
        r4 = "ad_blocking_on";
        r4 = r0.getBoolean(r4, r1);
        r5 = "malware_shield_on";
        r6 = r0.getBoolean(r5, r2);
        if (r3 == 0) goto L_0x0068;
    L_0x003e:
        r5 = r1;
    L_0x003f:
        if (r4 == 0) goto L_0x006a;
    L_0x0041:
        r4 = r1;
    L_0x0042:
        if (r6 == 0) goto L_0x006c;
    L_0x0044:
        r0 = r1;
    L_0x0045:
        r3 = r10.f1322g;
        if (r3 != 0) goto L_0x0054;
    L_0x0049:
        r3 = new com.ppu.fba.g;
        r3.<init>(r10, r6);
        r3 = r3.establish();	 Catch:{ Exception -> 0x006e }
        r10.f1322g = r3;	 Catch:{ Exception -> 0x006e }
    L_0x0054:
        r3 = r10.f1322g;
        if (r3 != 0) goto L_0x00b6;
    L_0x0058:
        r10.f1317a = r2;
        r0 = "DCVpnService";
        r1 = "builder failed: stopSelf() now";
        com.ppu.fba.p009d.Log1.LogF1(r0, r1);
        r10.stopSelf();
        goto L_0x0016;
    L_0x0065:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x0065 }
        throw r0;
    L_0x0068:
        r5 = r2;
        goto L_0x003f;
    L_0x006a:
        r4 = r2;
        goto L_0x0042;
    L_0x006c:
        r0 = r2;
        goto L_0x0045;
    L_0x006e:
        r3 = move-exception;
        r3 = new com.ppu.fba.q;
        r3.<init>(r10, r6);
        r3 = r3.establish();	 Catch:{ Exception -> 0x007b }
        r10.f1322g = r3;	 Catch:{ Exception -> 0x007b }
        goto L_0x0054;
    L_0x007b:
        r3 = move-exception;
        r6 = "state";
        r7 = "vpnFail";
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "excEst: ";
        r8 = r8.append(r9);
        r9 = r3.getMessage();
        if (r9 != 0) goto L_0x00b1;
    L_0x0091:
        r3 = "null";
    L_0x0093:
        r3 = r8.append(r3);
        r3 = r3.toString();
        r8 = 0;
        r3 = com.google.analytics.tracking.android.MapBuilder.createEvent(r6, r7, r3, r8);
        r3 = r3.build();
        com.ppu.fba.p009d.Log1.LogAction(r3);
        r3 = com.ppu.fba.R.string.error_vpn_establish;
        r3 = android.widget.Toast.makeText(r10, r3, r1);
        r3.show();
        goto L_0x0054;
    L_0x00b1:
        r3 = r3.getMessage();
        goto L_0x0093;
    L_0x00b6:
        r3 = r10.m1868e();
        r10.startForeground(r1, r3);
        r3 = "DCVpnService";
        r6 = "init";
        com.ppu.fba.p009d.Log1.LogF1(r3, r6);
        r3 = r10.f1322g;
        r3 = r3.getFd();
        r6 = r10.getFilesDir();
        r6 = r6.getAbsolutePath();
        r0 = com.ppu.fba.NativeWrapper.jni_dicki(r3, r6, r5, r4, r0);
        if (r0 == 0) goto L_0x00e4;
    L_0x00d8:
        r0 = "DCVpnService";
        r2 = "account_init failed!!!!!";
        com.ppu.fba.p009d.Log1.LogF1(r0, r2);
        r10.stopForeground(r1);
        goto L_0x0016;
    L_0x00e4:
        r10.f1321f = r2;
        r0 = new com.ppu.fba.c;
        r1 = new com.ppu.fba.d;
        r1.<init>(r10);
        r2 = "t4";
        r0.<init>(r1, r2);
        r10.f1324i = r0;
        r0 = r10.f1324i;
        r0.start();
        r0 = new com.ppu.fba.c;
        r1 = new com.ppu.fba.e;
        r1.<init>(r10);
        r2 = "t0";
        r0.<init>(r1, r2);
        r10.f1323h = r0;
        r0 = r10.f1323h;
        r0.start();
        r0 = new com.ppu.fba.c;
        r1 = new com.ppu.fba.f;
        r1.<init>(r10);
        r2 = "t1";
        r0.<init>(r1, r2);
        r10.f1319d = r0;
        r0 = new com.ppu.fba.c;
        r1 = new com.ppu.fba.o;
        r1.<init>(r10);
        r2 = "t2";
        r0.<init>(r1, r2);
        r10.f1320e = r0;
        r0 = new com.ppu.fba.c;
        r1 = new com.ppu.fba.p;
        r1.<init>(r10);
        r2 = "t3";
        r0.<init>(r1, r2);
        r10.f1318c = r0;
        r0 = r10.f1319d;
        r0.start();
        r0 = r10.f1320e;
        r0.start();
        r0 = r10.f1318c;
        r0.start();
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ppu.fba.FirewallVpnService.c():void");
    }

    private void m1867d() {
        Log1.LogF1("DCVpnService", "waitVPN");
        try {
            if (this.f1323h != null) {
                this.f1323h.join(3000);
                this.f1323h = null;
            }
        } catch (InterruptedException e) {
        }
        try {
            if (this.f1324i != null) {
                this.f1324i.join(1000);
                this.f1324i = null;
            }
        } catch (InterruptedException e2) {
        }
        try {
            if (this.f1318c != null) {
                this.f1318c.join(1000);
                this.f1318c = null;
            }
        } catch (InterruptedException e3) {
        }
        try {
            if (this.f1319d != null) {
                this.f1319d.join(1000);
                this.f1319d = null;
            }
        } catch (InterruptedException e4) {
        }
        try {
            if (this.f1320e != null) {
                this.f1320e.join(1000);
                this.f1320e = null;
            }
        } catch (InterruptedException e5) {
        }
    }

    private Notification m1868e() {
        Context applicationContext = getApplicationContext();
        NotificationCompat.Builder b = new NotificationCompat.Builder(applicationContext).setSmallIcon(R.drawable.lnf2).setContentTitle(getResources().getText(R.string.app_name)).setContentText("Protection is turned ON").setContentText("LostNet Firewall controls data using VPN");
        Intent intent = new Intent(this, LogsActivity.class);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        b.setContentIntent(PendingIntent.getActivity(applicationContext, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT));
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        return b.build();
    }

    private int m1869f() {
        ActivityManager activityManager = null;
        if (null == null) {
            activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        }
        if (activityManager == null) {
            return 0;
        }
        List runningTasks = activityManager.getRunningTasks(1);
        if (runningTasks == null) {
            return 0;
        }
        RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
        if (runningTaskInfo != null) {
            ComponentName componentName = runningTaskInfo.topActivity;
            if (componentName != null) {
                String packageName = componentName.getPackageName();
                if (packageName != null) {
                    Integer a = C0308e.m1963a(packageName);
                    return a == null ? 0 : a.intValue();
                }
            }
        }
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1870b() {
        /*
        r3 = this;
        r2 = 1;
        r0 = "DCVpnService";
        r1 = "stopVPN";
        com.ppu.fba.p009d.Log1.LogF1(r0, r1);
        monitor-enter(r3);
        r0 = r3.f1317a;	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x0016;
    L_0x000d:
        r0 = "DCVpnService";
        r1 = "stopVPN: already stopped";
        com.ppu.fba.p009d.Log1.LogF1(r0, r1);	 Catch:{ all -> 0x0045 }
        monitor-exit(r3);	 Catch:{ all -> 0x0045 }
    L_0x0015:
        return;
    L_0x0016:
        r0 = 0;
        r3.f1317a = r0;	 Catch:{ all -> 0x0045 }
        monitor-exit(r3);	 Catch:{ all -> 0x0045 }
        r0 = r3.f1318c;
        if (r0 != 0) goto L_0x0026;
    L_0x001e:
        r0 = r3.f1319d;
        if (r0 != 0) goto L_0x0026;
    L_0x0022:
        r0 = r3.f1320e;
        if (r0 == 0) goto L_0x0035;
    L_0x0026:
        r3.f1321f = r2;
        r0 = "DCVpnService";
        r1 = "fini";
        com.ppu.fba.p009d.Log1.LogF1(r0, r1);
        com.ppu.fba.NativeWrapper.jni_dickj();
        r3.m1867d();
    L_0x0035:
        r0 = r3.f1322g;
        if (r0 == 0) goto L_0x0041;
    L_0x0039:
        r0 = r3.f1322g;	 Catch:{ Exception -> 0x0048 }
        r0.close();	 Catch:{ Exception -> 0x0048 }
    L_0x003e:
        r0 = 0;
        r3.f1322g = r0;
    L_0x0041:
        r3.stopForeground(r2);
        goto L_0x0015;
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0045 }
        throw r0;
    L_0x0048:
        r0 = move-exception;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ppu.fba.FirewallVpnService.b():void");
    }

    public int dontbeabitch() {
        int f = m1869f();
        Log1.LogF1("DCVpnService", "getForegroundApp: " + f);
        return f;
    }

    public void gettheirdicksoffyourass(int i, int i2) {
        Log1.LogF1("DCVpnService", "policyNotifyCnt: " + i + " " + i2);
        if (i2 != 0) {
            String c = C0309f.m1980c(C0309f.m1974a(i));
            String a = C0308e.m1964a(i2);
            if (c == null) {
                c = "<Unknown Country>";
            }
            if (a == null) {
                a = "<Unknown App>";
            }
            a = getResources().getString(R.string.alert_app_cnt_1) + " " + a + " " + getResources().getString(R.string.alert_app_cnt_2) + " " + c + " " + getResources().getString(R.string.alert_app_cnt_3);
            FirewallManagerService a2 = FirewallManagerService.m1852a(null);
            if (a2 != null) {
                a2.m1863a(new C0288a(7, a));
            }
        }
    }

    public void howmuchdoesaminuteofyourtimecost(int i, int i2) {
        Log1.LogF1("DCVpnService", "policyNotifyAd: " + i + " " + i2);
        String a = C0308e.m1964a(i);
        if (a == null) {
            a = "<Unknown App>";
        }
        a = getResources().getString(R.string.alert_ad_1) + " " + a + " " + getResources().getString(R.string.alert_ad_2);
        FirewallManagerService a2 = FirewallManagerService.m1852a(null);
        if (a2 != null) {
            a2.m1863a(new C0288a(7, a));
        }
    }

    public void ivespent5minobfuscatingmindyourtime(int i) {
        Log1.LogF1("DCVpnService", "policyNotifyApp: " + i);
        String a = C0308e.m1964a(i);
        if (a == null) {
            a = "<Unknown App>";
        }
        a = getResources().getString(R.string.alert_app_1) + " " + a + " " + getResources().getString(R.string.alert_app_2);
        FirewallManagerService a2 = FirewallManagerService.m1852a(null);
        if (a2 != null) {
            a2.m1863a(new C0288a(7, a));
        }
    }

    public void onDestroy() {
        Log1.LogF1("DCVpnService", "onDestroy");
        m1870b();
        Log1.LogF1("DCVpnService", "onDestroy: end");
    }

    public void onRevoke() {
        Log1.LogF1("DCVpnService", "onRevoke");
        Log1.LogAction("state", "vpnRevoke", null, null);
        Editor edit = PreferenceManager.getDefaultSharedPreferences(FirewallApplication.m1851a()).edit();
        edit.putBoolean("status_on", false);
        edit.commit();
        m1870b();
        FirewallManagerService a = FirewallManagerService.m1852a((Context) this);
        if (a != null) {
            a.m1863a(new C0288a(2));
        }
        Intent intent = new Intent(this, FirewallVPNStop.class);
        intent.setFlags(268435456);
        startActivity(intent);
        Log1.LogF1("DCVpnService", "onRevoke: end");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Log1.LogF1("DCVpnService", "onStartCommand");
        m1866c();
        return START_NOT_STICKY;
    }

    public void whatonearthmakesyoubeaslave(int i, int i2) {
        Log1.LogF1("DCVpnService", "policyNotifyMw: " + i + " " + i2);
        String a = C0308e.m1964a(i);
        if (a == null) {
            a = "<Unknown App>";
        }
        a = getResources().getString(R.string.alert_mw_1) + " " + a + " " + getResources().getString(R.string.alert_mw_2);
        FirewallManagerService a2 = FirewallManagerService.m1852a(null);
        if (a2 != null) {
            a2.m1863a(new C0288a(7, a));
        }
    }

    public void workonyourown(int i) {
        if (!protect(i)) {
            Log1.LogF1("DCVpnService", "protect() failed");
        }
    }
}

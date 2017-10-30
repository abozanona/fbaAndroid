package com.ppu.fba.p009d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.ppu.fba.FirewallApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.ppu.fba.free.R;

@SuppressLint({"UseSparseArrays"})
public class C0308e {
    private static HashMap f1394a = new HashMap();
    private static HashMap f1395b = new HashMap();
    private static Drawable f1396c = FirewallApplication.m1851a().getPackageManager().getDefaultActivityIcon();
    private static Bitmap f1397d;
    private static HashMap f1398e = new HashMap();
    private static HashMap f1399f = new HashMap();
    private static HashSet f1400g = new HashSet();
    private static HashSet f1401h = new HashSet();
    private static Boolean f1402i = Boolean.valueOf(false);
    private static HashMap f1403j = new HashMap();
    private static HashMap f1404k = new HashMap();
    private static final Object[][] f1405l;

    static {
        Object[][] objArr = new Object[33][];
        objArr[0] = new Object[]{"system", Integer.valueOf(1000)};
        objArr[1] = new Object[]{"radio", Integer.valueOf(1001)};
        objArr[2] = new Object[]{"bluetooth", Integer.valueOf(1002)};
        objArr[3] = new Object[]{"graphics", Integer.valueOf(1003)};
        objArr[4] = new Object[]{"input", Integer.valueOf(1004)};
        objArr[5] = new Object[]{"audio", Integer.valueOf(1005)};
        objArr[6] = new Object[]{"camera", Integer.valueOf(1006)};
        objArr[7] = new Object[]{"log", Integer.valueOf(1007)};
        objArr[8] = new Object[]{"compass", Integer.valueOf(1008)};
        objArr[9] = new Object[]{"mount", Integer.valueOf(1009)};
        objArr[10] = new Object[]{"wifi", Integer.valueOf(1010)};
        objArr[11] = new Object[]{"dhcp", Integer.valueOf(1014)};
        objArr[12] = new Object[]{"adb", Integer.valueOf(1011)};
        objArr[13] = new Object[]{"install", Integer.valueOf(1012)};
        objArr[14] = new Object[]{"media", Integer.valueOf(1013)};
        objArr[15] = new Object[]{"drm", Integer.valueOf(1019)};
        objArr[16] = new Object[]{"drmio", Integer.valueOf(1020)};
        objArr[17] = new Object[]{"nfc", Integer.valueOf(1025)};
        objArr[18] = new Object[]{"shell", Integer.valueOf(2000)};
        objArr[19] = new Object[]{"cache", Integer.valueOf(2001)};
        objArr[20] = new Object[]{"diag", Integer.valueOf(2002)};
        objArr[21] = new Object[]{"net_bt_admin", Integer.valueOf(3001)};
        objArr[22] = new Object[]{"net_bt", Integer.valueOf(3002)};
        objArr[23] = new Object[]{"sdcard_rw", Integer.valueOf(1015)};
        objArr[24] = new Object[]{"vpn", Integer.valueOf(1016)};
        objArr[25] = new Object[]{"keystore", Integer.valueOf(1017)};
        objArr[26] = new Object[]{"usb", Integer.valueOf(1018)};
        objArr[27] = new Object[]{"gps", Integer.valueOf(1021)};
        objArr[28] = new Object[]{"inet", Integer.valueOf(3003)};
        objArr[29] = new Object[]{"net_raw", Integer.valueOf(3004)};
        objArr[30] = new Object[]{"net_admin", Integer.valueOf(3005)};
        objArr[31] = new Object[]{"misc", Integer.valueOf(9998)};
        objArr[32] = new Object[]{"nobody", Integer.valueOf(9999)};
        f1405l = objArr;
        if (f1396c != null) {
            f1397d = ((BitmapDrawable) f1396c.mutate()).getBitmap();
            if (VERSION.SDK_INT >= 17) {
                f1397d.setHasMipMap(false);
            }
            f1397d = Bitmap.createScaledBitmap(f1397d, 48, 48, false);
            if (VERSION.SDK_INT >= 17) {
                f1397d.setHasMipMap(false);
            }
        }
        for (Object[] objArr2 : f1405l) {
            f1404k.put((Integer) objArr2[1], "android:" + ((String) objArr2[0]));
        }
        Integer valueOf = Integer.valueOf(0);
        f1394a.put(valueOf, "Android System");
        f1395b.put(valueOf, "com.android");
        f1401h.add(valueOf);
    }

    public static ApplicationInfo m1962a(Integer num) {
        return (ApplicationInfo) f1399f.get(num);
    }

    public static Integer m1963a(String str) {
        return (Integer) f1403j.get(str);
    }

    public static String m1964a(int i) {
        Context a = FirewallApplication.m1851a();
        Integer valueOf = Integer.valueOf(i);
        String str = (String) f1394a.get(valueOf);
        if (str != null) {
            return str;
        }
        if (i < 10000) {
            str = (String) f1404k.get(valueOf);
            if (str != null) {
                return str;
            }
        }
        try {
            PackageManager packageManager = a.getPackageManager();
            String[] packagesForUid = packageManager.getPackagesForUid(i);
            if (packagesForUid == null || packagesForUid.length == 0) {
                return "<" + a.getResources().getString(R.string.unknown) + " " + i + ">";
            }
            str = packageManager.getApplicationLabel(packageManager.getApplicationInfo(packagesForUid[0], 0)).toString();
            synchronized (f1394a) {
                f1394a.put(Integer.valueOf(i), str);
            }
            f1400g.add(Integer.valueOf(i));
            return str;
        } catch (Exception e) {
            return "<" + a.getResources().getString(R.string.unknown_app) + ">";
        }
    }

    public static Set m1965a() {
        Set hashSet = new HashSet();
        synchronized (f1394a) {
            hashSet.addAll(f1394a.keySet());
        }
        return hashSet;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m1966a(int r7, android.graphics.drawable.Drawable r8) {
        /*
        r6 = 17;
        r1 = 0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = com.ppu.fba.FirewallApplication.m1851a();
        r2 = r2.getFilesDir();
        r0 = r0.append(r2);
        r2 = "/icons/";
        r0 = r0.append(r2);
        r0 = r0.append(r7);
        r2 = ".png";
        r0 = r0.append(r2);
        r2 = r0.toString();
        r0 = r8.mutate();	 Catch:{ Exception -> 0x0086, OutOfMemoryError -> 0x0084 }
        r0 = (android.graphics.drawable.BitmapDrawable) r0;	 Catch:{ Exception -> 0x0086, OutOfMemoryError -> 0x0084 }
        r0 = r0.getBitmap();	 Catch:{ Exception -> 0x0086, OutOfMemoryError -> 0x0084 }
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0086, OutOfMemoryError -> 0x0084 }
        if (r3 < r6) goto L_0x003a;
    L_0x0036:
        r3 = 0;
        r0.setHasMipMap(r3);	 Catch:{ Exception -> 0x0086, OutOfMemoryError -> 0x0084 }
    L_0x003a:
        r3 = 48;
        r4 = 48;
        r5 = 0;
        r0 = android.graphics.Bitmap.createScaledBitmap(r0, r3, r4, r5);	 Catch:{ Exception -> 0x0086, OutOfMemoryError -> 0x0084 }
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0089, OutOfMemoryError -> 0x0084 }
        if (r1 < r6) goto L_0x004b;
    L_0x0047:
        r1 = 0;
        r0.setHasMipMap(r1);	 Catch:{ Exception -> 0x0089, OutOfMemoryError -> 0x0084 }
    L_0x004b:
        if (r0 == 0) goto L_0x0081;
    L_0x004d:
        r1 = f1398e;
        r3 = java.lang.Integer.valueOf(r7);
        r1.put(r3, r0);
        r1 = new java.io.ByteArrayOutputStream;
        r1.<init>();
        r3 = android.graphics.Bitmap.CompressFormat.PNG;
        r4 = 100;
        r0.compress(r3, r4, r1);
        r0 = new java.io.File;
        r0.<init>(r2);
        r0.createNewFile();	 Catch:{ Exception -> 0x0082 }
        r2 = 1;
        r3 = 0;
        r0.setReadable(r2, r3);	 Catch:{ Exception -> 0x0082 }
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0082 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = r1.toByteArray();	 Catch:{ Exception -> 0x0082 }
        r2.write(r0);	 Catch:{ Exception -> 0x0082 }
        r2.flush();	 Catch:{ Exception -> 0x0082 }
        r2.close();	 Catch:{ Exception -> 0x0082 }
    L_0x0081:
        return;
    L_0x0082:
        r0 = move-exception;
        goto L_0x0081;
    L_0x0084:
        r0 = move-exception;
        goto L_0x0081;
    L_0x0086:
        r0 = move-exception;
        r0 = r1;
        goto L_0x004b;
    L_0x0089:
        r1 = move-exception;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ppu.fba.d.e.a(int, android.graphics.drawable.Drawable):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap m1967b(int r7) {
        /*
        r1 = 0;
        r6 = 17;
        r4 = 0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = com.ppu.fba.FirewallApplication.m1851a();
        r2 = r2.getFilesDir();
        r0 = r0.append(r2);
        r2 = "/icons/";
        r0 = r0.append(r2);
        r0 = r0.append(r7);
        r2 = ".png";
        r0 = r0.append(r2);
        r2 = r0.toString();
        r0 = f1398e;
        r3 = java.lang.Integer.valueOf(r7);
        r0 = r0.get(r3);
        r0 = (android.graphics.Bitmap) r0;
        if (r0 != 0) goto L_0x004d;
    L_0x0037:
        r0 = android.graphics.BitmapFactory.decodeFile(r2);
        if (r0 == 0) goto L_0x004d;
    L_0x003d:
        r3 = android.os.Build.VERSION.SDK_INT;
        if (r3 < r6) goto L_0x0044;
    L_0x0041:
        r0.setHasMipMap(r4);
    L_0x0044:
        r3 = f1398e;
        r4 = java.lang.Integer.valueOf(r7);
        r3.put(r4, r0);
    L_0x004d:
        if (r0 != 0) goto L_0x0066;
    L_0x004f:
        if (r1 != 0) goto L_0x0067;
    L_0x0051:
        r0 = com.ppu.fba.p009d.C0308e.m1970c(r7);
        if (r0 == 0) goto L_0x00d5;
    L_0x0057:
        r0 = com.ppu.fba.p009d.C0308e.m1968b(r0);
        r3 = r0 instanceof android.graphics.drawable.BitmapDrawable;
        if (r3 != 0) goto L_0x0060;
    L_0x005f:
        r0 = r1;
    L_0x0060:
        if (r0 == 0) goto L_0x0062;
    L_0x0062:
        if (r0 != 0) goto L_0x0068;
    L_0x0064:
        r0 = f1397d;
    L_0x0066:
        return r0;
    L_0x0067:
        r0 = r1;
    L_0x0068:
        if (r0 == 0) goto L_0x00d3;
    L_0x006a:
        r0 = r0.mutate();	 Catch:{ Exception -> 0x0093, OutOfMemoryError -> 0x0096 }
        r0 = (android.graphics.drawable.BitmapDrawable) r0;	 Catch:{ Exception -> 0x0093, OutOfMemoryError -> 0x0096 }
        r0 = r0.getBitmap();	 Catch:{ Exception -> 0x0093, OutOfMemoryError -> 0x0096 }
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0093, OutOfMemoryError -> 0x0096 }
        if (r3 < r6) goto L_0x007c;
    L_0x0078:
        r3 = 0;
        r0.setHasMipMap(r3);	 Catch:{ Exception -> 0x0093, OutOfMemoryError -> 0x0096 }
    L_0x007c:
        r3 = 48;
        r4 = 48;
        r5 = 0;
        r1 = android.graphics.Bitmap.createScaledBitmap(r0, r3, r4, r5);	 Catch:{ Exception -> 0x0093, OutOfMemoryError -> 0x0096 }
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0093, OutOfMemoryError -> 0x0096 }
        if (r0 < r6) goto L_0x008d;
    L_0x0089:
        r0 = 0;
        r1.setHasMipMap(r0);	 Catch:{ Exception -> 0x0093, OutOfMemoryError -> 0x0096 }
    L_0x008d:
        r0 = r1;
    L_0x008e:
        if (r0 != 0) goto L_0x009a;
    L_0x0090:
        r0 = f1397d;
        goto L_0x0066;
    L_0x0093:
        r0 = move-exception;
        r0 = r1;
        goto L_0x008e;
    L_0x0096:
        r0 = move-exception;
        r0 = f1397d;
        goto L_0x0066;
    L_0x009a:
        if (r0 == 0) goto L_0x0066;
    L_0x009c:
        r1 = f1398e;
        r3 = java.lang.Integer.valueOf(r7);
        r1.put(r3, r0);
        r1 = new java.io.ByteArrayOutputStream;
        r1.<init>();
        r3 = android.graphics.Bitmap.CompressFormat.PNG;
        r4 = 100;
        r0.compress(r3, r4, r1);
        r3 = new java.io.File;
        r3.<init>(r2);
        r3.createNewFile();	 Catch:{ Exception -> 0x00d1 }
        r2 = 1;
        r4 = 0;
        r3.setReadable(r2, r4);	 Catch:{ Exception -> 0x00d1 }
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x00d1 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00d1 }
        r1 = r1.toByteArray();	 Catch:{ Exception -> 0x00d1 }
        r2.write(r1);	 Catch:{ Exception -> 0x00d1 }
        r2.flush();	 Catch:{ Exception -> 0x00d1 }
        r2.close();	 Catch:{ Exception -> 0x00d1 }
        goto L_0x0066;
    L_0x00d1:
        r1 = move-exception;
        goto L_0x0066;
    L_0x00d3:
        r0 = r1;
        goto L_0x008e;
    L_0x00d5:
        r0 = r1;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ppu.fba.d.e.b(int):android.graphics.Bitmap");
    }

    private static Drawable m1968b(String str) {
        Drawable drawable;
        Context a = FirewallApplication.m1851a();
        PackageManager packageManager = a.getPackageManager();
        try {
            try {
                drawable = a.createPackageContext(str, Context.CONTEXT_IGNORE_SECURITY).getResources().getDrawable(packageManager.getPackageInfo(str, 0).applicationInfo.icon);
                if (drawable != null) {
                    return drawable;
                }
            } catch (NotFoundException e) {
            }
        } catch (Exception e2) {
        }
        drawable = null;
        try {
            drawable = packageManager.getApplicationInfo(str, PackageManager.GET_META_DATA).loadIcon(packageManager);
        } catch (NameNotFoundException e3) {
        }
        return drawable == null ? packageManager.getDefaultActivityIcon() : drawable;
    }

    public static Set m1969b() {
        return f1400g;
    }

    public static String m1970c(int i) {
        Context a = FirewallApplication.m1851a();
        String str = (String) f1395b.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        try {
            String[] packagesForUid = a.getPackageManager().getPackagesForUid(i);
            if (packagesForUid == null || packagesForUid.length == 0) {
                return "null";
            }
            str = packagesForUid[0];
            f1395b.put(Integer.valueOf(i), str);
            if (i < 10000) {
                f1401h.add(Integer.valueOf(i));
                return str;
            }
            f1400g.add(Integer.valueOf(i));
            return str;
        } catch (Exception e) {
            return "exception";
        }
    }

    public static Set m1971c() {
        return f1401h;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m1972d() {
        /*
        r0 = com.ppu.fba.FirewallApplication.m1851a();
        r3 = r0.getPackageManager();
        r1 = 0;
        r1 = java.lang.Integer.valueOf(r1);
        r0 = r0.getApplicationInfo();
        r4 = r0.uid;
        r2 = f1402i;
        monitor-enter(r2);
        r0 = f1402i;	 Catch:{ all -> 0x009d }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x009d }
        if (r0 == 0) goto L_0x0020;
    L_0x001e:
        monitor-exit(r2);	 Catch:{ all -> 0x009d }
    L_0x001f:
        return;
    L_0x0020:
        r0 = 1;
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x009d }
        f1402i = r0;	 Catch:{ all -> 0x009d }
        monitor-exit(r2);	 Catch:{ all -> 0x009d }
        r5 = com.ppu.fba.p008c.C0296a.m1930c();
        r2 = f1394a;
        monitor-enter(r2);
        r0 = f1394a;	 Catch:{ all -> 0x00a0 }
        r7 = "Android System";
        r0.put(r1, r7);	 Catch:{ all -> 0x00a0 }
        monitor-exit(r2);	 Catch:{ all -> 0x00a0 }
        r0 = f1395b;
        r2 = "com.android";
        r0.put(r1, r2);
        r0 = f1400g;
        r0.clear();
        r0 = f1401h;
        r0.clear();
        r0 = f1401h;
        r0.add(r1);
        r0 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r0 = r3.getInstalledPackages(r0);
        r7 = r0.iterator();
    L_0x0057:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x01e9;
    L_0x005d:
        r0 = r7.next();
        r0 = (android.content.pm.PackageInfo) r0;
        r1 = r0.applicationInfo;	 Catch:{ Exception -> 0x0083 }
        if (r1 == 0) goto L_0x0057;
    L_0x0067:
        r1 = r0.applicationInfo;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.uid;	 Catch:{ Exception -> 0x0083 }
        if (r1 == 0) goto L_0x0075;
    L_0x006d:
        r1 = r0.applicationInfo;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.uid;	 Catch:{ Exception -> 0x0083 }
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r1 != r2) goto L_0x00a3;
    L_0x0075:
        r1 = f1401h;	 Catch:{ Exception -> 0x0083 }
        r0 = r0.applicationInfo;	 Catch:{ Exception -> 0x0083 }
        r0 = r0.uid;	 Catch:{ Exception -> 0x0083 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0083 }
        r1.add(r0);	 Catch:{ Exception -> 0x0083 }
        goto L_0x0057;
    L_0x0083:
        r0 = move-exception;
        r1 = "error";
        r2 = "preload";
        r0 = r0.getClass();
        r0 = r0.getCanonicalName();
        r8 = 0;
        r0 = com.google.analytics.tracking.android.MapBuilder.createEvent(r1, r2, r0, r8);
        r0 = r0.build();
        com.ppu.fba.p009d.Log1.LogAction(r0);
        goto L_0x0057;
    L_0x009d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x009d }
        throw r0;
    L_0x00a0:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00a0 }
        throw r0;
    L_0x00a3:
        r1 = r0.applicationInfo;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.uid;	 Catch:{ Exception -> 0x0083 }
        if (r1 == r4) goto L_0x0057;
    L_0x00a9:
        r1 = r0.applicationInfo;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.flags;	 Catch:{ Exception -> 0x0083 }
        r2 = 16777216; // 0x1000000 float:2.3509887E-38 double:8.289046E-317;
        r1 = r1 & r2;
        r2 = 16777216; // 0x1000000 float:2.3509887E-38 double:8.289046E-317;
        if (r1 == r2) goto L_0x0057;
    L_0x00b4:
        r8 = r0.packageName;	 Catch:{ Exception -> 0x0083 }
        if (r8 == 0) goto L_0x00c8;
    L_0x00b8:
        r1 = com.ppu.fba.FirewallVpnService.class;
        r1 = r1.getPackage();	 Catch:{ Exception -> 0x0083 }
        r1 = r1.getName();	 Catch:{ Exception -> 0x0083 }
        r1 = r8.equals(r1);	 Catch:{ Exception -> 0x0083 }
        if (r1 != 0) goto L_0x0057;
    L_0x00c8:
        r1 = r0.applicationInfo;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.uid;	 Catch:{ Exception -> 0x0083 }
        r9 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0083 }
        r1 = f1395b;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.get(r9);	 Catch:{ Exception -> 0x0083 }
        if (r1 != 0) goto L_0x00dd;
    L_0x00d8:
        r1 = f1395b;	 Catch:{ Exception -> 0x0083 }
        r1.put(r9, r8);	 Catch:{ Exception -> 0x0083 }
    L_0x00dd:
        r1 = f1403j;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.get(r8);	 Catch:{ Exception -> 0x0083 }
        if (r1 != 0) goto L_0x00ea;
    L_0x00e5:
        r1 = f1403j;	 Catch:{ Exception -> 0x0083 }
        r1.put(r8, r9);	 Catch:{ Exception -> 0x0083 }
    L_0x00ea:
        r2 = 1;
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0083 }
        r1.<init>();	 Catch:{ Exception -> 0x0083 }
        r10 = com.ppu.fba.FirewallApplication.m1851a();	 Catch:{ Exception -> 0x0083 }
        r10 = r10.getFilesDir();	 Catch:{ Exception -> 0x0083 }
        r1 = r1.append(r10);	 Catch:{ Exception -> 0x0083 }
        r10 = "/labels/";
        r1 = r1.append(r10);	 Catch:{ Exception -> 0x0083 }
        r1 = r1.append(r9);	 Catch:{ Exception -> 0x0083 }
        r10 = ".txt";
        r1 = r1.append(r10);	 Catch:{ Exception -> 0x0083 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0083 }
        r10 = new java.io.File;	 Catch:{ Exception -> 0x0083 }
        r10.<init>(r1);	 Catch:{ Exception -> 0x0083 }
        r1 = r10.exists();	 Catch:{ Exception -> 0x0083 }
        if (r1 == 0) goto L_0x0239;
    L_0x011b:
        r1 = 32;
        r1 = new char[r1];	 Catch:{ Exception -> 0x01e2 }
        r11 = new java.io.FileReader;	 Catch:{ Exception -> 0x01e2 }
        r11.<init>(r10);	 Catch:{ Exception -> 0x01e2 }
        r11.read(r1);	 Catch:{ Exception -> 0x01e2 }
        r11.close();	 Catch:{ Exception -> 0x01e2 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x01e2 }
        r11 = f1394a;	 Catch:{ Exception -> 0x01e2 }
        monitor-enter(r11);	 Catch:{ Exception -> 0x01e2 }
        r12 = f1394a;	 Catch:{ all -> 0x01df }
        r12.put(r9, r1);	 Catch:{ all -> 0x01df }
        monitor-exit(r11);	 Catch:{ all -> 0x01df }
        r1 = 0;
    L_0x0138:
        if (r1 == 0) goto L_0x0164;
    L_0x013a:
        r1 = f1394a;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.get(r9);	 Catch:{ Exception -> 0x0083 }
        if (r1 != 0) goto L_0x0164;
    L_0x0142:
        r1 = r0.applicationInfo;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.loadLabel(r3);	 Catch:{ Exception -> 0x0083 }
        r2 = f1394a;	 Catch:{ Exception -> 0x0083 }
        monitor-enter(r2);	 Catch:{ Exception -> 0x0083 }
        r11 = f1394a;	 Catch:{ all -> 0x01e6 }
        r12 = r1.toString();	 Catch:{ all -> 0x01e6 }
        r11.put(r9, r12);	 Catch:{ all -> 0x01e6 }
        monitor-exit(r2);	 Catch:{ all -> 0x01e6 }
        r2 = new java.io.FileWriter;	 Catch:{ Exception -> 0x0236 }
        r2.<init>(r10);	 Catch:{ Exception -> 0x0236 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0236 }
        r2.write(r1);	 Catch:{ Exception -> 0x0236 }
        r2.close();	 Catch:{ Exception -> 0x0236 }
    L_0x0164:
        r1 = 1;
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0083 }
        r2.<init>();	 Catch:{ Exception -> 0x0083 }
        r10 = com.ppu.fba.FirewallApplication.m1851a();	 Catch:{ Exception -> 0x0083 }
        r10 = r10.getFilesDir();	 Catch:{ Exception -> 0x0083 }
        r2 = r2.append(r10);	 Catch:{ Exception -> 0x0083 }
        r10 = "/icons/";
        r2 = r2.append(r10);	 Catch:{ Exception -> 0x0083 }
        r2 = r2.append(r9);	 Catch:{ Exception -> 0x0083 }
        r10 = ".png";
        r2 = r2.append(r10);	 Catch:{ Exception -> 0x0083 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0083 }
        r10 = new java.io.File;	 Catch:{ Exception -> 0x0083 }
        r10.<init>(r2);	 Catch:{ Exception -> 0x0083 }
        r10 = r10.exists();	 Catch:{ Exception -> 0x0083 }
        if (r10 == 0) goto L_0x01ac;
    L_0x0195:
        r1 = 0;
        r1 = android.graphics.BitmapFactory.decodeFile(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0233 }
        r10 = 17;
        if (r2 < r10) goto L_0x01a4;
    L_0x01a0:
        r2 = 0;
        r1.setHasMipMap(r2);	 Catch:{ Exception -> 0x0233 }
    L_0x01a4:
        if (r1 == 0) goto L_0x01ab;
    L_0x01a6:
        r2 = f1398e;	 Catch:{ Exception -> 0x0083 }
        r2.put(r9, r1);	 Catch:{ Exception -> 0x0083 }
    L_0x01ab:
        r1 = 0;
    L_0x01ac:
        if (r1 == 0) goto L_0x01b9;
    L_0x01ae:
        r1 = r9.intValue();	 Catch:{ Exception -> 0x0083 }
        r2 = com.ppu.fba.p009d.C0308e.m1968b(r8);	 Catch:{ Exception -> 0x0083 }
        com.ppu.fba.p009d.C0308e.m1966a(r1, r2);	 Catch:{ Exception -> 0x0083 }
    L_0x01b9:
        r1 = f1399f;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.get(r9);	 Catch:{ Exception -> 0x0083 }
        if (r1 != 0) goto L_0x01c8;
    L_0x01c1:
        r1 = f1399f;	 Catch:{ Exception -> 0x0083 }
        r2 = r0.applicationInfo;	 Catch:{ Exception -> 0x0083 }
        r1.put(r9, r2);	 Catch:{ Exception -> 0x0083 }
    L_0x01c8:
        r1 = r0.applicationInfo;	 Catch:{ Exception -> 0x0083 }
        r1 = r1.flags;	 Catch:{ Exception -> 0x0083 }
        r1 = r1 & 1;
        if (r1 != 0) goto L_0x01d8;
    L_0x01d0:
        r0 = r0.applicationInfo;	 Catch:{ Exception -> 0x0083 }
        r0 = r0.flags;	 Catch:{ Exception -> 0x0083 }
        r0 = r0 & 128;
        if (r0 == 0) goto L_0x0057;
    L_0x01d8:
        r0 = f1401h;	 Catch:{ Exception -> 0x0083 }
        r0.add(r9);	 Catch:{ Exception -> 0x0083 }
        goto L_0x0057;
    L_0x01df:
        r1 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x01df }
        throw r1;	 Catch:{ Exception -> 0x01e2 }
    L_0x01e2:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0138;
    L_0x01e6:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x01e6 }
        throw r0;	 Catch:{ Exception -> 0x0083 }
    L_0x01e9:
        r0 = com.ppu.fba.p009d.C0308e.m1965a();
        r1 = r0.iterator();
    L_0x01f1:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x020b;
    L_0x01f7:
        r0 = r1.next();
        r0 = (java.lang.Integer) r0;
        r2 = f1401h;
        r2 = r2.contains(r0);
        if (r2 != 0) goto L_0x01f1;
    L_0x0205:
        r2 = f1400g;
        r2.add(r0);
        goto L_0x01f1;
    L_0x020b:
        r0 = com.ppu.fba.p008c.C0296a.m1930c();
        r0 = r0 - r5;
        r2 = 10;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x001f;
    L_0x0216:
        r2 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x001f;
    L_0x021d:
        r2 = "preload";
        r0 = java.lang.Long.valueOf(r0);
        r1 = "apps";
        r3 = 0;
        r0 = com.google.analytics.tracking.android.MapBuilder.createTiming(r2, r0, r1, r3);
        r0 = r0.build();
        com.ppu.fba.p009d.Log1.LogAction(r0);
        goto L_0x001f;
    L_0x0233:
        r2 = move-exception;
        goto L_0x01a4;
    L_0x0236:
        r1 = move-exception;
        goto L_0x0164;
    L_0x0239:
        r1 = r2;
        goto L_0x0138;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ppu.fba.d.e.d():void");
    }

    public static void m1973e() {
        ArrayList arrayList = new ArrayList(f1398e.keySet());
        while (arrayList.size() > 0) {
            Integer num = (Integer) arrayList.get(0);
            arrayList.remove(0);
            if (num != null) {
                Bitmap bitmap = (Bitmap) f1398e.get(num);
                f1398e.remove(num);
                bitmap.recycle();
            }
        }
        f1402i = Boolean.valueOf(false);
    }
}

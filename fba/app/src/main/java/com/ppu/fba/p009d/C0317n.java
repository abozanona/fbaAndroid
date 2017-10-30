package com.ppu.fba.p009d;

import android.content.Context;
import com.ppu.fba.FirewallApplication;
import com.ppu.fba.p007b.C0290b;
import com.ppu.fba.p007b.C0293e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class C0317n {
    private static final String[] f1422a = new String[]{"appsCollection", "cntsCollection"};

    public static void m2022a(String str) {
        Log1.LogF1("ProfileUtils", "profileCreateEmpty: " + str);
        Context a = FirewallApplication.m1851a();
        try {
            new File(a.getFilesDir().getPath() + "/profiles/" + str + "/").mkdir();
            C0311h.m1999a(a, new C0290b(), "profiles/" + str + "/appsCollection", true);
            C0311h.m1999a(a, new C0293e(), "profiles/" + str + "/cntsCollection", true);
        } catch (Exception e) {
        }
    }

    public static void m2023a(String str, String str2) {
        Log1.LogF1("ProfileUtils", "fileCopy: " + str + "->" + str2);
        try {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                File file2 = new File(str2);
                file2.createNewFile();
                InputStream fileInputStream = new FileInputStream(file);
                OutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        fileInputStream.close();
                        return;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static String[] m2024a() {
        Log1.LogF1("ProfileUtils", "profileGetList");
        try {
            return new File(FirewallApplication.m1851a().getFilesDir().getPath() + "/profiles").list();
        } catch (Exception e) {
            return new String[0];
        }
    }

    public static void m2025b(String str) {
        Log1.LogF1("ProfileUtils", "profileSave: " + str);
        Context a = FirewallApplication.m1851a();
        try {
            File file = new File(a.getFilesDir().getPath() + "/");
            File file2 = new File(a.getFilesDir().getPath() + "/profiles/" + str + "/");
            file2.mkdir();
            for (String str2 : new String[]{"appsCollection", "cntsCollection"}) {
                C0317n.m2023a(file + "/" + str2, file2 + "/" + str2);
            }
        } catch (Exception e) {
        }
    }

    public static void m2026b(String str, String str2) {
        Log1.LogF1("ProfileUtils", "profileCreate: " + str2 + "->" + str);
        Context a = FirewallApplication.m1851a();
        try {
            String str3 = a.getFilesDir().getPath() + "/";
            if (str2 != null) {
                str3 = str3 + "profiles/" + str2 + "/";
            }
            File file = new File(str3);
            File file2 = new File(a.getFilesDir().getPath() + "/profiles/" + str + "/");
            file2.mkdir();
            for (String str4 : f1422a) {
                C0317n.m2023a(file + "/" + str4, file2 + "/" + str4);
            }
        } catch (Exception e) {
        }
    }

    public static void m2027c(String str) {
        Log1.LogF1("ProfileUtils", "profileRestore: " + str);
        Context a = FirewallApplication.m1851a();
        try {
            File file = new File(a.getFilesDir().getPath() + "/");
            File file2 = new File(a.getFilesDir().getPath() + "/profiles/" + str + "/");
            for (String str2 : new String[]{"appsCollection", "cntsCollection"}) {
                C0317n.m2023a(file2 + "/" + str2, file + "/" + str2);
            }
        } catch (Exception e) {
        }
    }

    public static void m2028d(String str) {
        Log1.LogF1("ProfileUtils", "profileDelete: " + str);
        try {
            File file = new File(FirewallApplication.m1851a().getFilesDir().getPath() + "/profiles/" + str + "/");
            file.mkdir();
            for (String str2 : f1422a) {
                try {
                    new File(file + "/" + str2).delete();
                } catch (Exception e) {
                }
            }
            file.delete();
        } catch (Exception e2) {
        }
    }
}

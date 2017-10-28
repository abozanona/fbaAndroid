package com.google.analytics.tracking.android;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class C0191g implements C0186k {
    private static C0191g f847a;
    private static final Object f848b = new Object();
    private final Context f849c;
    private String f850d;
    private boolean f851e = false;
    private final Object f852f = new Object();

    protected C0191g(Context context) {
        this.f849c = context;
        m1199f();
    }

    @VisibleForTesting
    static void m1193a() {
        synchronized (f848b) {
            f847a = null;
        }
    }

    public static void m1194a(Context context) {
        synchronized (f848b) {
            if (f847a == null) {
                f847a = new C0191g(context);
            }
        }
    }

    public static C0191g m1196b() {
        C0191g c0191g;
        synchronized (f848b) {
            c0191g = f847a;
        }
        return c0191g;
    }

    private boolean m1197c(String str) {
        try {
            Log.m1078v("Storing clientId.");
            FileOutputStream openFileOutput = this.f849c.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            Log.m1076e("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            Log.m1076e("Error writing to clientId file.");
            return false;
        }
    }

    private String m1198e() {
        if (!this.f851e) {
            synchronized (this.f852f) {
                if (!this.f851e) {
                    Log.m1078v("Waiting for clientId to load");
                    do {
                        try {
                            this.f852f.wait();
                        } catch (InterruptedException e) {
                            Log.m1076e("Exception while waiting for clientId: " + e);
                        }
                    } while (!this.f851e);
                }
            }
        }
        Log.m1078v("Loaded clientId");
        return this.f850d;
    }

    private void m1199f() {
        new C0192h(this, "client_id_fetcher").start();
    }

    public boolean m1200a(String str) {
        return Fields.CLIENT_ID.equals(str);
    }

    public String mo562b(String str) {
        return Fields.CLIENT_ID.equals(str) ? m1198e() : null;
    }

    protected String m1202c() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        return !m1197c(toLowerCase) ? "0" : toLowerCase;
    }

    @VisibleForTesting
    String m1203d() {
        String str = null;
        try {
            FileInputStream openFileInput = this.f849c.openFileInput("gaClientId");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                Log.m1076e("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.f849c.deleteFile("gaClientId");
            } else if (read <= 0) {
                Log.m1076e("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.f849c.deleteFile("gaClientId");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    Log.m1076e("Error reading clientId file, deleting it.");
                    this.f849c.deleteFile("gaClientId");
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            Log.m1076e("Error reading clientId file, deleting it.");
            this.f849c.deleteFile("gaClientId");
        }
        return str == null ? m1202c() : str;
    }
}

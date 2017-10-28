package com.google.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.analytics.containertag.proto.Serving.OptionalResource;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.LoadCallback.Failure;
import java.io.FileNotFoundException;

class dc implements Runnable {
    private final Context f1064a;
    private final bw f1065b;
    private final String f1066c;
    private final String f1067d;
    private LoadCallback f1068e;
    private volatile ad f1069f;
    private volatile String f1070g;
    private volatile String f1071h;

    public dc(Context context, String str, ad adVar) {
        this(context, str, new bw(), adVar);
    }

    @VisibleForTesting
    dc(Context context, String str, bw bwVar, ad adVar) {
        this.f1064a = context;
        this.f1065b = bwVar;
        this.f1066c = str;
        this.f1069f = adVar;
        this.f1067d = "/r?id=" + str;
        this.f1070g = this.f1067d;
        this.f1071h = null;
    }

    private boolean m1544b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f1064a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bs.m1445e("...no network connectivity");
        return false;
    }

    private void m1545c() {
        if (m1544b()) {
            bs.m1445e("Start loading resource from network ...");
            String a = m1546a();
            bv a2 = this.f1065b.m1451a();
            try {
                try {
                    OptionalResource parseFrom = OptionalResource.parseFrom(a2.mo625a(a), cs.m1533a());
                    bs.m1445e("Successfully loaded resource: " + parseFrom);
                    if (!parseFrom.hasResource()) {
                        bs.m1445e("No change for container: " + this.f1066c);
                    }
                    this.f1068e.mo678a(parseFrom.hasResource() ? parseFrom.getResource() : null);
                    bs.m1445e("Load resource from network finished.");
                } catch (Throwable e) {
                    bs.m1442b("Error when parsing downloaded resources from url: " + a + " " + e.getMessage(), e);
                    this.f1068e.mo677a(Failure.SERVER_ERROR);
                    a2.mo626a();
                }
            } catch (FileNotFoundException e2) {
                bs.m1441b("No data is retrieved from the given url: " + a + ". Make sure container_id: " + this.f1066c + " is correct.");
                this.f1068e.mo677a(Failure.SERVER_ERROR);
            } catch (Throwable e3) {
                bs.m1442b("Error when loading resources from url: " + a + " " + e3.getMessage(), e3);
                this.f1068e.mo677a(Failure.IO_ERROR);
            } finally {
                a2.mo626a();
            }
        } else {
            this.f1068e.mo677a(Failure.NOT_AVAILABLE);
        }
    }

    @VisibleForTesting
    String m1546a() {
        String str = this.f1069f.m1333a() + this.f1070g + "&v=a50788154";
        if (!(this.f1071h == null || this.f1071h.trim().equals(""))) {
            str = str + "&pv=" + this.f1071h;
        }
        return cq.m1525a().m1529b().equals(cr.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    void m1547a(LoadCallback loadCallback) {
        this.f1068e = loadCallback;
    }

    @VisibleForTesting
    void m1548a(String str) {
        if (str == null) {
            this.f1070g = this.f1067d;
            return;
        }
        bs.m1444d("Setting CTFE URL path: " + str);
        this.f1070g = str;
    }

    @VisibleForTesting
    void m1549b(String str) {
        bs.m1444d("Setting previous container version: " + str);
        this.f1071h = str;
    }

    public void run() {
        if (this.f1068e == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.f1068e.mo676a();
        m1545c();
    }
}

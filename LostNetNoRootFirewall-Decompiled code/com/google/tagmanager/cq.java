package com.google.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class cq {
    private static cq f1040a;
    private volatile cr f1041b;
    private volatile String f1042c;
    private volatile String f1043d;
    private volatile String f1044e;

    cq() {
        m1532e();
    }

    static cq m1525a() {
        cq cqVar;
        synchronized (cq.class) {
            if (f1040a == null) {
                f1040a = new cq();
            }
            cqVar = f1040a;
        }
        return cqVar;
    }

    private String m1526a(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String m1527b(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    synchronized boolean m1528a(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    bs.m1445e("Container preview url: " + decode);
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.f1041b = cr.CONTAINER_DEBUG;
                    } else {
                        this.f1041b = cr.CONTAINER;
                    }
                    this.f1044e = m1527b(uri);
                    if (this.f1041b == cr.CONTAINER || this.f1041b == cr.CONTAINER_DEBUG) {
                        this.f1043d = "/r?" + this.f1044e;
                    }
                    this.f1042c = m1526a(this.f1044e);
                } else {
                    if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        bs.m1441b("Invalid preview uri: " + decode);
                        z = false;
                    } else if (m1526a(uri.getQuery()).equals(this.f1042c)) {
                        bs.m1445e("Exit preview mode for container: " + this.f1042c);
                        this.f1041b = cr.NONE;
                        this.f1043d = null;
                    } else {
                        z = false;
                    }
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }

    cr m1529b() {
        return this.f1041b;
    }

    String m1530c() {
        return this.f1043d;
    }

    String m1531d() {
        return this.f1042c;
    }

    void m1532e() {
        this.f1041b = cr.NONE;
        this.f1043d = null;
        this.f1042c = null;
        this.f1044e = null;
    }
}

package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ArbitraryPixelTag extends eq {
    static final String f917a = ("gtm_" + f918b + "_unrepeatable");
    private static final String f918b = FunctionType.ARBITRARY_PIXEL.toString();
    private static final String f919c = Key.URL.toString();
    private static final String f920d = Key.ADDITIONAL_PARAMS.toString();
    private static final String f921e = Key.UNREPEATABLE.toString();
    private static final Set f922f = new HashSet();
    private final HitSenderProvider f923g;
    private final Context f924h;

    public interface HitSenderProvider {
        az get();
    }

    public ArbitraryPixelTag(Context context) {
        this(context, new C0228h(context));
    }

    @VisibleForTesting
    ArbitraryPixelTag(Context context, HitSenderProvider hitSenderProvider) {
        super(f918b, f919c);
        this.f923g = hitSenderProvider;
        this.f924h = context;
    }

    private synchronized boolean m1260c(String str) {
        boolean z = true;
        synchronized (this) {
            if (!m1263b(str)) {
                if (m1261a(str)) {
                    f922f.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    @VisibleForTesting
    boolean m1261a(String str) {
        return this.f924h.getSharedPreferences(f917a, 0).contains(str);
    }

    public void mo593b(Map map) {
        String a = map.get(f921e) != null ? es.m1668a((Value) map.get(f921e)) : null;
        if (a == null || !m1260c(a)) {
            Builder buildUpon = Uri.parse(es.m1668a((Value) map.get(f919c))).buildUpon();
            Value value = (Value) map.get(f920d);
            if (value != null) {
                Object f = es.m1688f(value);
                if (f instanceof List) {
                    for (Object f2 : (List) f2) {
                        if (f2 instanceof Map) {
                            for (Entry entry : ((Map) f2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            bs.m1438a("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                            return;
                        }
                    }
                }
                bs.m1438a("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                return;
            }
            String uri = buildUpon.build().toString();
            this.f923g.get().mo621a(uri);
            bs.m1445e("ArbitraryPixel: url = " + uri);
            if (a != null) {
                synchronized (ArbitraryPixelTag.class) {
                    f922f.add(a);
                    ed.m1643a(this.f924h, f917a, a, "true");
                }
            }
        }
    }

    @VisibleForTesting
    boolean m1263b(String str) {
        return f922f.contains(str);
    }
}

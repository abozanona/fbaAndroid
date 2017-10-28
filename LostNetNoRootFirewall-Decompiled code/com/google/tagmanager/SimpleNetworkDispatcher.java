package com.google.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class SimpleNetworkDispatcher implements al {
    private final String f934a = m1320a("GoogleTagManager", "3.01", VERSION.RELEASE, m1317a(Locale.getDefault()), Build.MODEL, Build.ID);
    private final HttpClient f935b;
    private final Context f936c;
    private DispatchListener f937d;

    public interface DispatchListener {
        void onHitDispatched(ay ayVar);

        void onHitPermanentDispatchFailure(ay ayVar);

        void onHitTransientDispatchFailure(ay ayVar);
    }

    @VisibleForTesting
    SimpleNetworkDispatcher(HttpClient httpClient, Context context, DispatchListener dispatchListener) {
        this.f936c = context.getApplicationContext();
        this.f935b = httpClient;
        this.f937d = dispatchListener;
    }

    static String m1317a(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    private HttpEntityEnclosingRequest m1318a(URL url) {
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        URISyntaxException e;
        try {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString());
            try {
                basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.f934a);
            } catch (URISyntaxException e2) {
                e = e2;
                bs.m1441b("Exception sending hit: " + e.getClass().getSimpleName());
                bs.m1441b(e.getMessage());
                return basicHttpEntityEnclosingRequest;
            }
        } catch (URISyntaxException e3) {
            URISyntaxException uRISyntaxException = e3;
            basicHttpEntityEnclosingRequest = null;
            e = uRISyntaxException;
            bs.m1441b("Exception sending hit: " + e.getClass().getSimpleName());
            bs.m1441b(e.getMessage());
            return basicHttpEntityEnclosingRequest;
        }
        return basicHttpEntityEnclosingRequest;
    }

    private void m1319a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append("\n");
                    }
                }
            } catch (IOException e) {
                bs.m1445e("Error Writing hit to log...");
            }
        }
        bs.m1445e(stringBuffer.toString());
    }

    String m1320a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    @VisibleForTesting
    URL m1321a(ay ayVar) {
        try {
            return new URL(ayVar.m1384c());
        } catch (MalformedURLException e) {
            bs.m1438a("Error trying to parse the GTM url.");
            return null;
        }
    }

    public void mo602a(List list) {
        int min = Math.min(list.size(), 40);
        Object obj = 1;
        int i = 0;
        while (i < min) {
            Object obj2;
            ay ayVar = (ay) list.get(i);
            URL a = m1321a(ayVar);
            if (a == null) {
                bs.m1441b("No destination: discarding hit.");
                this.f937d.onHitPermanentDispatchFailure(ayVar);
                obj2 = obj;
            } else {
                HttpEntityEnclosingRequest a2 = m1318a(a);
                if (a2 == null) {
                    this.f937d.onHitPermanentDispatchFailure(ayVar);
                    obj2 = obj;
                } else {
                    HttpHost httpHost = new HttpHost(a.getHost(), a.getPort(), a.getProtocol());
                    a2.addHeader("Host", httpHost.toHostString());
                    m1319a(a2);
                    if (obj != null) {
                        try {
                            bx.m1453b(this.f936c);
                            obj = null;
                        } catch (ClientProtocolException e) {
                            bs.m1441b("ClientProtocolException sending hit; discarding hit...");
                            this.f937d.onHitPermanentDispatchFailure(ayVar);
                            obj2 = obj;
                        } catch (IOException e2) {
                            bs.m1441b("Exception sending hit: " + e2.getClass().getSimpleName());
                            bs.m1441b(e2.getMessage());
                            this.f937d.onHitTransientDispatchFailure(ayVar);
                            obj2 = obj;
                        }
                    }
                    HttpResponse execute = this.f935b.execute(httpHost, a2);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        bs.m1441b("Bad response: " + execute.getStatusLine().getStatusCode());
                        this.f937d.onHitTransientDispatchFailure(ayVar);
                    } else {
                        this.f937d.onHitDispatched(ayVar);
                    }
                    obj2 = obj;
                }
            }
            i++;
            obj = obj2;
        }
    }

    public boolean mo603a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f936c.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bs.m1445e("...no network connectivity");
        return false;
    }
}

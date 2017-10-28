package com.google.tagmanager;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.ResourceUtil.ExpandedResource;
import com.google.tagmanager.proto.Resource.ResourceWithMetadata;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class di implements C0223v {
    private final Context f1083a;
    private final String f1084b;
    private final ExecutorService f1085c = Executors.newSingleThreadExecutor();
    private LoadCallback f1086d;

    di(Context context, String str) {
        this.f1083a = context;
        this.f1084b = str;
    }

    private String m1572a(InputStream inputStream) {
        Writer stringWriter = new StringWriter();
        char[] cArr = new char[1024];
        Reader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read == -1) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.analytics.containertag.proto.Serving.Resource mo662a(java.lang.String r6) {
        /*
        r5 = this;
        r0 = 0;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Loading default container from ";
        r1 = r1.append(r2);
        r1 = r1.append(r6);
        r1 = r1.toString();
        com.google.tagmanager.bs.m1445e(r1);
        r1 = r5.f1083a;
        r1 = r1.getAssets();
        if (r1 != 0) goto L_0x0025;
    L_0x001f:
        r1 = "No assets found in package";
        com.google.tagmanager.bs.m1438a(r1);
    L_0x0024:
        return r0;
    L_0x0025:
        r2 = r1.open(r6);	 Catch:{ IOException -> 0x004c }
        r1 = com.google.tagmanager.cs.m1533a();	 Catch:{ IOException -> 0x006a }
        r1 = com.google.analytics.containertag.proto.Serving.Resource.parseFrom(r2, r1);	 Catch:{ IOException -> 0x006a }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x006a }
        r3.<init>();	 Catch:{ IOException -> 0x006a }
        r4 = "Parsed default container: ";
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x006a }
        r3 = r3.append(r1);	 Catch:{ IOException -> 0x006a }
        r3 = r3.toString();	 Catch:{ IOException -> 0x006a }
        com.google.tagmanager.bs.m1445e(r3);	 Catch:{ IOException -> 0x006a }
        r2.close();	 Catch:{ IOException -> 0x008c }
    L_0x004a:
        r0 = r1;
        goto L_0x0024;
    L_0x004c:
        r1 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "No asset file: ";
        r1 = r1.append(r2);
        r1 = r1.append(r6);
        r2 = " found.";
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.google.tagmanager.bs.m1441b(r1);
        goto L_0x0024;
    L_0x006a:
        r1 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0087 }
        r1.<init>();	 Catch:{ all -> 0x0087 }
        r3 = "Error when parsing: ";
        r1 = r1.append(r3);	 Catch:{ all -> 0x0087 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0087 }
        r1 = r1.toString();	 Catch:{ all -> 0x0087 }
        com.google.tagmanager.bs.m1441b(r1);	 Catch:{ all -> 0x0087 }
        r2.close();	 Catch:{ IOException -> 0x0085 }
        goto L_0x0024;
    L_0x0085:
        r1 = move-exception;
        goto L_0x0024;
    L_0x0087:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x008e }
    L_0x008b:
        throw r0;
    L_0x008c:
        r0 = move-exception;
        goto L_0x004a;
    L_0x008e:
        r1 = move-exception;
        goto L_0x008b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.tagmanager.di.a(java.lang.String):com.google.analytics.containertag.proto.Serving$Resource");
    }

    public void mo663a() {
        this.f1085c.execute(new dj(this));
    }

    public void mo664a(LoadCallback loadCallback) {
        this.f1086d = loadCallback;
    }

    public void mo665a(ResourceWithMetadata resourceWithMetadata) {
        this.f1085c.execute(new dk(this, resourceWithMetadata));
    }

    public ExpandedResource mo666b(String str) {
        Throwable th;
        InputStream inputStream;
        Object obj;
        ExpandedResource expandedResource = null;
        bs.m1445e("loading default container from " + str);
        AssetManager assets = this.f1083a.getAssets();
        if (assets == null) {
            bs.m1441b("Looking for default JSON container in package, but no assets were found.");
        } else {
            InputStream open;
            try {
                open = assets.open(str);
                try {
                    expandedResource = bm.m1425a(m1572a(open));
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (IOException e2) {
                    try {
                        bs.m1441b("No asset file: " + str + " found (or errors reading it).");
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e3) {
                            }
                        }
                        return expandedResource;
                    } catch (Throwable th2) {
                        th = th2;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                } catch (JSONException e5) {
                    JSONException jSONException = e5;
                    inputStream = open;
                    JSONException jSONException2 = jSONException;
                    try {
                        bs.m1441b("Error parsing JSON file" + str + " : " + obj);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        return expandedResource;
                    } catch (Throwable th3) {
                        th = th3;
                        open = inputStream;
                        if (open != null) {
                            open.close();
                        }
                        throw th;
                    }
                }
            } catch (IOException e7) {
                open = expandedResource;
                bs.m1441b("No asset file: " + str + " found (or errors reading it).");
                if (open != null) {
                    open.close();
                }
                return expandedResource;
            } catch (JSONException e8) {
                obj = e8;
                inputStream = expandedResource;
                bs.m1441b("Error parsing JSON file" + str + " : " + obj);
                if (inputStream != null) {
                    inputStream.close();
                }
                return expandedResource;
            } catch (Throwable th4) {
                Throwable th5 = th4;
                open = expandedResource;
                th = th5;
                if (open != null) {
                    open.close();
                }
                throw th;
            }
        }
        return expandedResource;
    }

    public synchronized void mo667b() {
        this.f1085c.shutdown();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.android.gms.common.util.VisibleForTesting
    boolean m1579b(com.google.tagmanager.proto.Resource.ResourceWithMetadata r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.m1581d();
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0012 }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0012 }
        r5.writeTo(r2);	 Catch:{ IOException -> 0x0020 }
        r0 = 1;
        r2.close();	 Catch:{ IOException -> 0x0019 }
    L_0x0011:
        return r0;
    L_0x0012:
        r1 = move-exception;
        r1 = "Error opening resource file for writing";
        com.google.tagmanager.bs.m1438a(r1);
        goto L_0x0011;
    L_0x0019:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.tagmanager.bs.m1441b(r1);
        goto L_0x0011;
    L_0x0020:
        r3 = move-exception;
        r3 = "Error writing resource to disk. Removing resource from disk.";
        com.google.tagmanager.bs.m1441b(r3);	 Catch:{ all -> 0x0034 }
        r1.delete();	 Catch:{ all -> 0x0034 }
        r2.close();	 Catch:{ IOException -> 0x002d }
        goto L_0x0011;
    L_0x002d:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.tagmanager.bs.m1441b(r1);
        goto L_0x0011;
    L_0x0034:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x0039 }
    L_0x0038:
        throw r0;
    L_0x0039:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.tagmanager.bs.m1441b(r1);
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.tagmanager.di.b(com.google.tagmanager.proto.Resource$ResourceWithMetadata):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.android.gms.common.util.VisibleForTesting
    void m1580c() {
        /*
        r3 = this;
        r0 = r3.f1086d;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.IllegalStateException;
        r1 = "callback must be set before execute";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r0 = r3.f1086d;
        r0.mo676a();
        r0 = "Start loading resource from disk ...";
        com.google.tagmanager.bs.m1445e(r0);
        r0 = com.google.tagmanager.cq.m1525a();
        r0 = r0.m1529b();
        r1 = com.google.tagmanager.cr.CONTAINER;
        if (r0 == r1) goto L_0x002e;
    L_0x0022:
        r0 = com.google.tagmanager.cq.m1525a();
        r0 = r0.m1529b();
        r1 = com.google.tagmanager.cr.CONTAINER_DEBUG;
        if (r0 != r1) goto L_0x0046;
    L_0x002e:
        r0 = r3.f1084b;
        r1 = com.google.tagmanager.cq.m1525a();
        r1 = r1.m1531d();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0046;
    L_0x003e:
        r0 = r3.f1086d;
        r1 = com.google.tagmanager.LoadCallback.Failure.NOT_AVAILABLE;
        r0.mo677a(r1);
    L_0x0045:
        return;
    L_0x0046:
        r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0065 }
        r0 = r3.m1581d();	 Catch:{ FileNotFoundException -> 0x0065 }
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0065 }
        r0 = r3.f1086d;	 Catch:{ IOException -> 0x007a }
        r2 = com.google.tagmanager.cs.m1533a();	 Catch:{ IOException -> 0x007a }
        r2 = com.google.tagmanager.proto.Resource.ResourceWithMetadata.parseFrom(r1, r2);	 Catch:{ IOException -> 0x007a }
        r0.mo678a(r2);	 Catch:{ IOException -> 0x007a }
        r1.close();	 Catch:{ IOException -> 0x0073 }
    L_0x005f:
        r0 = "Load resource from disk finished.";
        com.google.tagmanager.bs.m1445e(r0);
        goto L_0x0045;
    L_0x0065:
        r0 = move-exception;
        r0 = "resource not on disk";
        com.google.tagmanager.bs.m1444d(r0);
        r0 = r3.f1086d;
        r1 = com.google.tagmanager.LoadCallback.Failure.NOT_AVAILABLE;
        r0.mo677a(r1);
        goto L_0x0045;
    L_0x0073:
        r0 = move-exception;
        r0 = "error closing stream for reading resource from disk";
        com.google.tagmanager.bs.m1441b(r0);
        goto L_0x005f;
    L_0x007a:
        r0 = move-exception;
        r0 = "error reading resource from disk";
        com.google.tagmanager.bs.m1441b(r0);	 Catch:{ all -> 0x0092 }
        r0 = r3.f1086d;	 Catch:{ all -> 0x0092 }
        r2 = com.google.tagmanager.LoadCallback.Failure.IO_ERROR;	 Catch:{ all -> 0x0092 }
        r0.mo677a(r2);	 Catch:{ all -> 0x0092 }
        r1.close();	 Catch:{ IOException -> 0x008b }
        goto L_0x005f;
    L_0x008b:
        r0 = move-exception;
        r0 = "error closing stream for reading resource from disk";
        com.google.tagmanager.bs.m1441b(r0);
        goto L_0x005f;
    L_0x0092:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x0097 }
    L_0x0096:
        throw r0;
    L_0x0097:
        r1 = move-exception;
        r1 = "error closing stream for reading resource from disk";
        com.google.tagmanager.bs.m1441b(r1);
        goto L_0x0096;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.tagmanager.di.c():void");
    }

    @VisibleForTesting
    File m1581d() {
        return new File(this.f1083a.getDir("google_tagmanager", 0), "resource_" + this.f1084b);
    }
}

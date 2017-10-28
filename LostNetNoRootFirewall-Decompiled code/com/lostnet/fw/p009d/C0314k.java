package com.lostnet.fw.p009d;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class C0314k {
    private static Random f1417e = new Random();
    URLConnection f1418a;
    OutputStream f1419b;
    Map f1420c;
    String f1421d;

    public C0314k(String str) {
        this(new URL(str));
    }

    public C0314k(URL url) {
        this(url.openConnection());
    }

    public C0314k(URLConnection uRLConnection) {
        this.f1419b = null;
        this.f1420c = new HashMap();
        this.f1421d = "---------------------------" + C0314k.m2007c() + C0314k.m2007c() + C0314k.m2007c();
        this.f1418a = uRLConnection;
        uRLConnection.setDoOutput(true);
        uRLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f1421d);
    }

    private static void m2006a(InputStream inputStream, OutputStream outputStream) {
        int i = 0;
        byte[] bArr = new byte[500000];
        synchronized (inputStream) {
            while (true) {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read >= 0) {
                    outputStream.write(bArr, 0, read);
                    i += read;
                }
            }
        }
        outputStream.flush();
    }

    protected static String m2007c() {
        return Long.toString(f1417e.nextLong(), 36);
    }

    private void m2008c(String str) {
        m2015b();
        m2012a("Content-Disposition: form-data; name=\"");
        m2012a(str);
        m2011a('\"');
    }

    private void m2009e() {
        m2012a("--");
        m2012a(this.f1421d);
    }

    protected void m2010a() {
        if (this.f1419b == null) {
            this.f1419b = this.f1418a.getOutputStream();
        }
    }

    protected void m2011a(char c) {
        m2010a();
        this.f1419b.write(c);
    }

    protected void m2012a(String str) {
        m2010a();
        this.f1419b.write(str.getBytes());
    }

    public void m2013a(String str, File file) {
        m2014a(str, file.getPath(), new FileInputStream(file));
    }

    public void m2014a(String str, String str2, InputStream inputStream) {
        m2009e();
        m2008c(str);
        m2012a("; filename=\"");
        m2012a(str2);
        m2011a('\"');
        m2015b();
        m2012a("Content-Type: ");
        URLConnection uRLConnection = this.f1418a;
        String guessContentTypeFromName = URLConnection.guessContentTypeFromName(str2);
        if (guessContentTypeFromName == null) {
            guessContentTypeFromName = "application/octet-stream";
        }
        m2016b(guessContentTypeFromName);
        m2015b();
        C0314k.m2006a(inputStream, this.f1419b);
        m2015b();
    }

    protected void m2015b() {
        m2010a();
        m2012a("\r\n");
    }

    protected void m2016b(String str) {
        m2010a();
        m2012a(str);
        m2015b();
    }

    public InputStream m2017d() {
        m2009e();
        m2016b("--");
        this.f1419b.close();
        return this.f1418a.getInputStream();
    }
}

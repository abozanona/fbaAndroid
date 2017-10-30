package com.ppu.fba.ui;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;
import com.ppu.fba.p009d.C0314k;
import com.ppu.fba.p009d.C0316m;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONObject;

public class fi extends AsyncTask {
    final /* synthetic */ ToolSnifferActivity f1855a;

    fi(ToolSnifferActivity toolSnifferActivity) {
        this.f1855a = toolSnifferActivity;
    }

    protected String m2145a(Object... objArr) {
        try {
            SharedPreferences b = C0316m.m2021b();
            String string = b.getString("cloudshark", "www.cloudshark.org");
            String string2 = b.getString("cloudshark_key", "f450b127b5911af9c44732fe2a4cf417");
            String str = b.getBoolean("cloudshark_https", true) ? "https://" : "http://";
            C0314k c0314k = new C0314k(str + string + "/api/v1/" + string2 + "/upload/");
            c0314k.m2013a("file", new File(this.f1855a.getFilesDir() + "/lostnetfirewall.pcap"));
            InputStream d = c0314k.m2017d();
            Reader bufferedReader = new BufferedReader(new InputStreamReader(d, "UTF-8"));
            char[] cArr = new char[1024];
            Writer stringWriter = new StringWriter();
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    d.close();
                    return str + string + "/captures/" + new JSONObject(stringWriter.toString()).getString("id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void m2146a(String str) {
        super.onPostExecute(str);
        if (str != null) {
            this.f1855a.runOnUiThread(new fj(this, str));
        } else {
            this.f1855a.runOnUiThread(new fk(this));
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m2145a(objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m2146a((String) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(this.f1855a, "Uploading...", 0).show();
    }
}

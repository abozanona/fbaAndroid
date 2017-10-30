package com.ppu.fba.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ci implements OnClickListener {
    final /* synthetic */ Context f1731a;
    final /* synthetic */ ImportActivity f1732b;

    ci(ImportActivity importActivity, Context context) {
        this.f1732b = importActivity;
        this.f1731a = context;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        int i2 = 0;
        String[] strArr = new String[]{"appsCollection", "cntsCollection"};
        int length = strArr.length;
        while (i2 < length) {
            String str = strArr[i2];
            try {
                String str2 = this.f1731a.getFilesDir().getPath() + "/../../com.ppu.fba.free/files/" + str;
                str = this.f1731a.getFilesDir().getPath() + "/" + str;
                File file = new File(str2);
                if (file.exists() && file.canRead()) {
                    File file2 = new File(str);
                    file2.createNewFile();
                    InputStream fileInputStream = new FileInputStream(file);
                    OutputStream fileOutputStream = new FileOutputStream(file2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileInputStream.close();
                }
            } catch (Exception e) {
            }
            i2++;
        }
        this.f1732b.f1480a.dismiss();
        this.f1732b.finish();
    }
}

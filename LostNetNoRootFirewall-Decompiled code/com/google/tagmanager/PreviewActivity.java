package com.google.tagmanager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            bs.m1443c("Preview activity");
            Uri data = getIntent().getData();
            if (TagManager.getInstance(this).setPreviewData(data)) {
                Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                if (launchIntentForPackage != null) {
                    bs.m1443c("Invoke the launch activity for package name: " + getPackageName());
                    startActivity(launchIntentForPackage);
                    return;
                }
                bs.m1443c("No launch activity found for package name: " + getPackageName());
                return;
            }
            bs.m1441b("Cannot preview the app with the uri: " + data);
        } catch (Exception e) {
            bs.m1438a("Calling preview threw an exception: " + e.getMessage());
        }
    }
}

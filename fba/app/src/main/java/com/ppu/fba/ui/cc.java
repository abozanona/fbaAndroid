package com.ppu.fba.ui;

import android.content.Intent;

public class cc implements Runnable {
    final /* synthetic */ SplashScreen f1720a;

    cc(SplashScreen splashScreen) {
        this.f1720a = splashScreen;
    }

    public void run() {
        Intent intent;
        switch (this.f1720a.f1530a) {
            case 2:
                intent = new Intent(this.f1720a, LogsActivity.class);
                break;
            default:
                intent = new Intent(this.f1720a, DashboardActivity.class);
                break;
        }
        intent.setFlags(536870912);
        this.f1720a.startActivity(intent);
        this.f1720a.finish();
    }
}

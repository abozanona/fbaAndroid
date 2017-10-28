package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class ai {
    Context f114a;
    CharSequence f115b;
    CharSequence f116c;
    PendingIntent f117d;
    PendingIntent f118e;
    RemoteViews f119f;
    Bitmap f120g;
    CharSequence f121h;
    int f122i;
    int f123j;
    boolean f124k;
    ap f125l;
    CharSequence f126m;
    int f127n;
    int f128o;
    boolean f129p;
    ArrayList f130q = new ArrayList();
    Notification f131r = new Notification();

    public ai(Context context) {
        this.f114a = context;
        this.f131r.when = System.currentTimeMillis();
        this.f131r.audioStreamType = -1;
        this.f123j = 0;
    }

    private void m100a(int i, boolean z) {
        if (z) {
            Notification notification = this.f131r;
            notification.flags |= i;
            return;
        }
        notification = this.f131r;
        notification.flags &= i ^ -1;
    }

    public Notification m101a() {
        return ae.f103a.mo2a(this);
    }

    public ai m102a(int i) {
        this.f131r.icon = i;
        return this;
    }

    public ai m103a(PendingIntent pendingIntent) {
        this.f117d = pendingIntent;
        return this;
    }

    public ai m104a(CharSequence charSequence) {
        this.f115b = charSequence;
        return this;
    }

    public ai m105a(boolean z) {
        m100a(16, z);
        return this;
    }

    public ai m106b(CharSequence charSequence) {
        this.f116c = charSequence;
        return this;
    }

    public ai m107c(CharSequence charSequence) {
        this.f131r.tickerText = charSequence;
        return this;
    }
}

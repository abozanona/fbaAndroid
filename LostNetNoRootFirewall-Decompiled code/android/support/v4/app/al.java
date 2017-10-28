package android.support.v4.app;

import android.app.Notification;

class al implements ak {
    al() {
    }

    public Notification mo2a(ai aiVar) {
        Notification notification = aiVar.f131r;
        notification.setLatestEventInfo(aiVar.f114a, aiVar.f115b, aiVar.f116c, aiVar.f117d);
        if (aiVar.f123j > 0) {
            notification.flags |= 128;
        }
        return notification;
    }
}

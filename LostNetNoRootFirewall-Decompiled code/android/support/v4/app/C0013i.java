package android.support.v4.app;

import android.os.Handler;
import android.os.Message;

class C0013i extends Handler {
    final /* synthetic */ C0012h f176a;

    C0013i(C0012h c0012h) {
        this.f176a = c0012h;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f176a.f168f) {
                    this.f176a.m151a(false);
                    return;
                }
                return;
            case 2:
                this.f176a.m147a();
                this.f176a.f164b.m206e();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}

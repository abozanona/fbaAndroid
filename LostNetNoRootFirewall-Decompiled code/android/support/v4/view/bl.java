package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p003a.C0046a;
import android.support.v4.view.p003a.C0071w;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.tagmanager.protobuf.CodedOutputStream;

class bl extends C0072a {
    final /* synthetic */ ViewPager f343b;

    bl(ViewPager viewPager) {
        this.f343b = viewPager;
    }

    private boolean m658b() {
        return this.f343b.f294h != null && this.f343b.f294h.mo756b() > 1;
    }

    public void mo95a(View view, C0046a c0046a) {
        super.mo95a(view, c0046a);
        c0046a.m362a(ViewPager.class.getName());
        c0046a.m363a(m658b());
        if (this.f343b.canScrollHorizontally(1)) {
            c0046a.m360a((int) CodedOutputStream.DEFAULT_BUFFER_SIZE);
        }
        if (this.f343b.canScrollHorizontally(-1)) {
            c0046a.m360a(8192);
        }
    }

    public boolean mo96a(View view, int i, Bundle bundle) {
        if (super.mo96a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case CodedOutputStream.DEFAULT_BUFFER_SIZE /*4096*/:
                if (!this.f343b.canScrollHorizontally(1)) {
                    return false;
                }
                this.f343b.setCurrentItem(this.f343b.f295i + 1);
                return true;
            case 8192:
                if (!this.f343b.canScrollHorizontally(-1)) {
                    return false;
                }
                this.f343b.setCurrentItem(this.f343b.f295i - 1);
                return true;
            default:
                return false;
        }
    }

    public void mo97d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo97d(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        C0071w a = C0071w.m507a();
        a.m509a(m658b());
        if (accessibilityEvent.getEventType() == CodedOutputStream.DEFAULT_BUFFER_SIZE && this.f343b.f294h != null) {
            a.m508a(this.f343b.f294h.mo756b());
            a.m510b(this.f343b.f295i);
            a.m511c(this.f343b.f295i);
        }
    }
}

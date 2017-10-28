package android.support.v4.view.p003a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class C0070u extends AccessibilityNodeProvider {
    final /* synthetic */ C0065v f322a;

    C0070u(C0065v c0065v) {
        this.f322a = c0065v;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f322a.mo59a(i);
    }

    public List findAccessibilityNodeInfosByText(String str, int i) {
        return this.f322a.mo60a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f322a.mo61a(i, i2, bundle);
    }
}

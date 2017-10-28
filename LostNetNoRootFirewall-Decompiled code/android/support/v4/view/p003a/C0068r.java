package android.support.v4.view.p003a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class C0068r extends AccessibilityNodeProvider {
    final /* synthetic */ C0062s f321a;

    C0068r(C0062s c0062s) {
        this.f321a = c0062s;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f321a.mo56a(i);
    }

    public List findAccessibilityNodeInfosByText(String str, int i) {
        return this.f321a.mo57a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f321a.mo58a(i, i2, bundle);
    }
}

package android.support.v4.view.p003a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import com.google.android.vending.licensing.Policy;
import com.google.tagmanager.protobuf.CodedOutputStream;

public class C0046a {
    private static final C0050c f313a;
    private final Object f314b;

    static {
        if (VERSION.SDK_INT >= 19) {
            f313a = new C0055f();
        } else if (VERSION.SDK_INT >= 18) {
            f313a = new C0054e();
        } else if (VERSION.SDK_INT >= 16) {
            f313a = new C0053d();
        } else if (VERSION.SDK_INT >= 14) {
            f313a = new C0052b();
        } else {
            f313a = new C0051g();
        }
    }

    public C0046a(Object obj) {
        this.f314b = obj;
    }

    private static String m358b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case Policy.LICENSED /*256*/:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case CodedOutputStream.DEFAULT_BUFFER_SIZE /*4096*/:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public Object m359a() {
        return this.f314b;
    }

    public void m360a(int i) {
        f313a.mo35a(this.f314b, i);
    }

    public void m361a(Rect rect) {
        f313a.mo36a(this.f314b, rect);
    }

    public void m362a(CharSequence charSequence) {
        f313a.mo37a(this.f314b, charSequence);
    }

    public void m363a(boolean z) {
        f313a.mo38a(this.f314b, z);
    }

    public int m364b() {
        return f313a.mo34a(this.f314b);
    }

    public void m365b(Rect rect) {
        f313a.mo40b(this.f314b, rect);
    }

    public boolean m366c() {
        return f313a.mo44f(this.f314b);
    }

    public boolean m367d() {
        return f313a.mo45g(this.f314b);
    }

    public boolean m368e() {
        return f313a.mo48j(this.f314b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0046a c0046a = (C0046a) obj;
        return this.f314b == null ? c0046a.f314b == null : this.f314b.equals(c0046a.f314b);
    }

    public boolean m369f() {
        return f313a.mo49k(this.f314b);
    }

    public boolean m370g() {
        return f313a.mo53o(this.f314b);
    }

    public boolean m371h() {
        return f313a.mo46h(this.f314b);
    }

    public int hashCode() {
        return this.f314b == null ? 0 : this.f314b.hashCode();
    }

    public boolean m372i() {
        return f313a.mo50l(this.f314b);
    }

    public boolean m373j() {
        return f313a.mo47i(this.f314b);
    }

    public boolean m374k() {
        return f313a.mo51m(this.f314b);
    }

    public boolean m375l() {
        return f313a.mo52n(this.f314b);
    }

    public CharSequence m376m() {
        return f313a.mo42d(this.f314b);
    }

    public CharSequence m377n() {
        return f313a.mo39b(this.f314b);
    }

    public CharSequence m378o() {
        return f313a.mo43e(this.f314b);
    }

    public CharSequence m379p() {
        return f313a.mo41c(this.f314b);
    }

    public String m380q() {
        return f313a.mo54p(this.f314b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m361a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m365b(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m376m());
        stringBuilder.append("; className: ").append(m377n());
        stringBuilder.append("; text: ").append(m378o());
        stringBuilder.append("; contentDescription: ").append(m379p());
        stringBuilder.append("; viewId: ").append(m380q());
        stringBuilder.append("; checkable: ").append(m366c());
        stringBuilder.append("; checked: ").append(m367d());
        stringBuilder.append("; focusable: ").append(m368e());
        stringBuilder.append("; focused: ").append(m369f());
        stringBuilder.append("; selected: ").append(m370g());
        stringBuilder.append("; clickable: ").append(m371h());
        stringBuilder.append("; longClickable: ").append(m372i());
        stringBuilder.append("; enabled: ").append(m373j());
        stringBuilder.append("; password: ").append(m374k());
        stringBuilder.append("; scrollable: " + m375l());
        stringBuilder.append("; [");
        int b = m364b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(C0046a.m358b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

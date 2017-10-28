package android.support.v4.view;

import android.support.v4.view.p003a.C0046a;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class C0077c implements C0076j {
    final /* synthetic */ C0072a f345a;
    final /* synthetic */ C0075b f346b;

    C0077c(C0075b c0075b, C0072a c0072a) {
        this.f346b = c0075b;
        this.f345a = c0072a;
    }

    public void mo103a(View view, int i) {
        this.f345a.m514a(view, i);
    }

    public void mo104a(View view, Object obj) {
        this.f345a.mo95a(view, new C0046a(obj));
    }

    public boolean mo105a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f345a.m519b(view, accessibilityEvent);
    }

    public boolean mo106a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f345a.m518a(viewGroup, view, accessibilityEvent);
    }

    public void mo107b(View view, AccessibilityEvent accessibilityEvent) {
        this.f345a.mo97d(view, accessibilityEvent);
    }

    public void mo108c(View view, AccessibilityEvent accessibilityEvent) {
        this.f345a.m520c(view, accessibilityEvent);
    }

    public void mo109d(View view, AccessibilityEvent accessibilityEvent) {
        this.f345a.m516a(view, accessibilityEvent);
    }
}

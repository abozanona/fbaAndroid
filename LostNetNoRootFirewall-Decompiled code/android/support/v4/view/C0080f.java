package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p003a.C0046a;
import android.support.v4.view.p003a.C0058j;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class C0080f implements C0079m {
    final /* synthetic */ C0072a f347a;
    final /* synthetic */ C0078e f348b;

    C0080f(C0078e c0078e, C0072a c0072a) {
        this.f348b = c0078e;
        this.f347a = c0072a;
    }

    public Object mo110a(View view) {
        C0058j a = this.f347a.m512a(view);
        return a != null ? a.m486a() : null;
    }

    public void mo111a(View view, int i) {
        this.f347a.m514a(view, i);
    }

    public void mo112a(View view, Object obj) {
        this.f347a.mo95a(view, new C0046a(obj));
    }

    public boolean mo113a(View view, int i, Bundle bundle) {
        return this.f347a.mo96a(view, i, bundle);
    }

    public boolean mo114a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f347a.m519b(view, accessibilityEvent);
    }

    public boolean mo115a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f347a.m518a(viewGroup, view, accessibilityEvent);
    }

    public void mo116b(View view, AccessibilityEvent accessibilityEvent) {
        this.f347a.mo97d(view, accessibilityEvent);
    }

    public void mo117c(View view, AccessibilityEvent accessibilityEvent) {
        this.f347a.m520c(view, accessibilityEvent);
    }

    public void mo118d(View view, AccessibilityEvent accessibilityEvent) {
        this.f347a.m516a(view, accessibilityEvent);
    }
}

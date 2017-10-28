package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.p003a.C0046a;
import android.support.v4.view.p003a.C0058j;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class C0072a {
    private static final C0073d f325b;
    private static final Object f326c = f325b.mo84a();
    final Object f327a = f325b.mo85a(this);

    static {
        if (VERSION.SDK_INT >= 16) {
            f325b = new C0078e();
        } else if (VERSION.SDK_INT >= 14) {
            f325b = new C0075b();
        } else {
            f325b = new C0074g();
        }
    }

    public C0058j m512a(View view) {
        return f325b.mo83a(f326c, view);
    }

    Object m513a() {
        return this.f327a;
    }

    public void m514a(View view, int i) {
        f325b.mo86a(f326c, view, i);
    }

    public void mo95a(View view, C0046a c0046a) {
        f325b.mo87a(f326c, view, c0046a);
    }

    public void m516a(View view, AccessibilityEvent accessibilityEvent) {
        f325b.mo93d(f326c, view, accessibilityEvent);
    }

    public boolean mo96a(View view, int i, Bundle bundle) {
        return f325b.mo88a(f326c, view, i, bundle);
    }

    public boolean m518a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f325b.mo90a(f326c, viewGroup, view, accessibilityEvent);
    }

    public boolean m519b(View view, AccessibilityEvent accessibilityEvent) {
        return f325b.mo89a(f326c, view, accessibilityEvent);
    }

    public void m520c(View view, AccessibilityEvent accessibilityEvent) {
        f325b.mo92c(f326c, view, accessibilityEvent);
    }

    public void mo97d(View view, AccessibilityEvent accessibilityEvent) {
        f325b.mo91b(f326c, view, accessibilityEvent);
    }
}

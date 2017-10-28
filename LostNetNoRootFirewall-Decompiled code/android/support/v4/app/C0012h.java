package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.p002c.C0033l;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.vending.licensing.APKExpansionPolicy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

public class C0012h extends Activity {
    final Handler f163a = new C0013i(this);
    final C0019p f164b = new C0019p();
    final C0008m f165c = new C0014j(this);
    boolean f166d;
    boolean f167e;
    boolean f168f;
    boolean f169g;
    boolean f170h;
    boolean f171i;
    boolean f172j;
    boolean f173k;
    C0033l f174l;
    ab f175m;

    private static String m144a(View view) {
        char c = 'F';
        char c2 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        stringBuilder.append(view.isFocusable() ? 'F' : '.');
        stringBuilder.append(view.isEnabled() ? 'E' : '.');
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        stringBuilder.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        stringBuilder.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        stringBuilder.append(view.isClickable() ? 'C' : '.');
        stringBuilder.append(view.isLongClickable() ? 'L' : '.');
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.isSelected() ? 'S' : '.');
        if (view.isPressed()) {
            c2 = 'P';
        }
        stringBuilder.append(c2);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m145a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(C0012h.m144a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m145a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    ab m146a(String str, boolean z, boolean z2) {
        if (this.f174l == null) {
            this.f174l = new C0033l();
        }
        ab abVar = (ab) this.f174l.get(str);
        if (abVar != null) {
            abVar.m80a(this);
            return abVar;
        } else if (!z2) {
            return abVar;
        } else {
            abVar = new ab(str, this, z);
            this.f174l.put(str, abVar);
            return abVar;
        }
    }

    protected void m147a() {
        this.f164b.m215m();
    }

    public void m148a(Fragment fragment) {
    }

    public void m149a(Fragment fragment, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            super.startActivityForResult(intent, ((fragment.f38f + 1) << 16) + (65535 & i));
        }
    }

    void m150a(String str) {
        if (this.f174l != null) {
            ab abVar = (ab) this.f174l.get(str);
            if (abVar != null && !abVar.f87g) {
                abVar.m89h();
                this.f174l.remove(str);
            }
        }
    }

    void m151a(boolean z) {
        if (!this.f169g) {
            this.f169g = true;
            this.f170h = z;
            this.f163a.removeMessages(1);
            m155d();
        }
    }

    protected boolean m152a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public Object m153b() {
        return null;
    }

    public void m154c() {
        if (VERSION.SDK_INT >= 11) {
            C0002a.m75a(this);
        } else {
            this.f171i = true;
        }
    }

    void m155d() {
        if (this.f173k) {
            this.f173k = false;
            if (this.f175m != null) {
                if (this.f170h) {
                    this.f175m.m85d();
                } else {
                    this.f175m.m84c();
                }
            }
        }
        this.f164b.m218p();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f166d);
            printWriter.print("mResumed=");
            printWriter.print(this.f167e);
            printWriter.print(" mStopped=");
            printWriter.print(this.f168f);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f169g);
            printWriter.print(str2);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.f173k);
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f166d);
            printWriter.print("mResumed=");
            printWriter.print(this.f167e);
            printWriter.print(" mStopped=");
            printWriter.print(this.f168f);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f169g);
            printWriter.print(str2);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.f173k);
        }
        if (this.f175m != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f175m)));
            printWriter.println(":");
            this.f175m.m81a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        this.f164b.m186a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        m145a(str + "  ", printWriter, getWindow().getDecorView());
    }

    public C0017n m156e() {
        return this.f164b;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f164b.m211i();
        int i3 = i >> 16;
        if (i3 != 0) {
            i3--;
            if (this.f164b.f193f == null || i3 < 0 || i3 >= this.f164b.f193f.size()) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = (Fragment) this.f164b.f193f.get(i3);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            } else {
                fragment.m16a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f164b.m200c()) {
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f164b.m177a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.f164b.m184a(this, this.f165c, null);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        C0016l c0016l = (C0016l) getLastNonConfigurationInstance();
        if (c0016l != null) {
            this.f174l = c0016l.f183e;
        }
        if (bundle != null) {
            this.f164b.m179a(bundle.getParcelable("android:support:fragments"), c0016l != null ? c0016l.f182d : null);
        }
        this.f164b.m212j();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        return VERSION.SDK_INT >= 11 ? super.onCreatePanelMenu(i, menu) | this.f164b.m189a(menu, getMenuInflater()) : true;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        int i = 0;
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        String attributeValue = attributeSet.getAttributeValue(fragment, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0015k.f178a);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.m13b((Context) this, attributeValue)) {
            return super.onCreateView(str, context, attributeSet);
        }
        if (fragment != null) {
            i = fragment.getId();
        }
        if (i == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f164b.m169a(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f164b.mo9a(string);
        }
        if (fragment == null && i != -1) {
            fragment = this.f164b.m169a(i);
        }
        if (C0019p.f187a) {
            Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + fragment);
        }
        if (fragment == null) {
            Fragment a = Fragment.m11a((Context) this, attributeValue);
            a.f47o = true;
            a.f55w = resourceId != 0 ? resourceId : i;
            a.f56x = i;
            a.f57y = string;
            a.f48p = true;
            a.f51s = this.f164b;
            a.m19a((Activity) this, attributeSet, a.f36d);
            this.f164b.m183a(a, true);
            fragment = a;
        } else if (fragment.f48p) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + attributeValue);
        } else {
            fragment.f48p = true;
            if (!fragment.f20C) {
                fragment.m19a((Activity) this, attributeSet, fragment.f36d);
            }
            this.f164b.m192b(fragment);
        }
        if (fragment.f26I == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.f26I.setId(resourceId);
        }
        if (fragment.f26I.getTag() == null) {
            fragment.f26I.setTag(string);
        }
        return fragment.f26I;
    }

    protected void onDestroy() {
        super.onDestroy();
        m151a(false);
        this.f164b.m220r();
        if (this.f175m != null) {
            this.f175m.m89h();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f164b.m221s();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                return this.f164b.m190a(menuItem);
            case 6:
                return this.f164b.m197b(menuItem);
            default:
                return false;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f164b.m211i();
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                this.f164b.m195b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f167e = false;
        if (this.f163a.hasMessages(2)) {
            this.f163a.removeMessages(2);
            m147a();
        }
        this.f164b.m216n();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f163a.removeMessages(2);
        m147a();
        this.f164b.m206e();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f171i) {
            this.f171i = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return m152a(view, menu) | this.f164b.m188a(menu);
    }

    protected void onResume() {
        super.onResume();
        this.f163a.sendEmptyMessage(2);
        this.f167e = true;
        this.f164b.m206e();
    }

    public final Object onRetainNonConfigurationInstance() {
        int i = 0;
        if (this.f168f) {
            m151a(true);
        }
        Object b = m153b();
        ArrayList g = this.f164b.m209g();
        int i2;
        if (this.f174l != null) {
            int size = this.f174l.size();
            ab[] abVarArr = new ab[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                abVarArr[i3] = (ab) this.f174l.m275c(i3);
            }
            i2 = 0;
            while (i < size) {
                ab abVar = abVarArr[i];
                if (abVar.f87g) {
                    i2 = true;
                } else {
                    abVar.m89h();
                    this.f174l.remove(abVar.f84d);
                }
                i++;
            }
        } else {
            i2 = 0;
        }
        if (g == null && r0 == 0 && b == null) {
            return null;
        }
        C0016l c0016l = new C0016l();
        c0016l.f179a = null;
        c0016l.f180b = b;
        c0016l.f181c = null;
        c0016l.f182d = g;
        c0016l.f183e = this.f174l;
        return c0016l;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable h = this.f164b.m210h();
        if (h != null) {
            bundle.putParcelable("android:support:fragments", h);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f168f = false;
        this.f169g = false;
        this.f163a.removeMessages(1);
        if (!this.f166d) {
            this.f166d = true;
            this.f164b.m213k();
        }
        this.f164b.m211i();
        this.f164b.m206e();
        if (!this.f173k) {
            this.f173k = true;
            if (this.f175m != null) {
                this.f175m.m83b();
            } else if (!this.f172j) {
                this.f175m = m146a("(root)", this.f173k, false);
                if (!(this.f175m == null || this.f175m.f86f)) {
                    this.f175m.m83b();
                }
            }
            this.f172j = true;
        }
        this.f164b.m214l();
        if (this.f174l != null) {
            int size = this.f174l.size();
            ab[] abVarArr = new ab[size];
            for (int i = size - 1; i >= 0; i--) {
                abVarArr[i] = (ab) this.f174l.m275c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                ab abVar = abVarArr[i2];
                abVar.m86e();
                abVar.m88g();
            }
        }
    }

    protected void onStop() {
        super.onStop();
        this.f168f = true;
        this.f163a.sendEmptyMessage(1);
        this.f164b.m217o();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
}

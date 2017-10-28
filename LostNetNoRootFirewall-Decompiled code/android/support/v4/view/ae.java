package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class ae {
    private DataSetObservable f216a = new DataSetObservable();

    public int m224a(Object obj) {
        return -1;
    }

    public Parcelable mo12a() {
        return null;
    }

    public Object mo754a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public Object mo13a(ViewGroup viewGroup, int i) {
        return mo754a((View) viewGroup, i);
    }

    public void m228a(DataSetObserver dataSetObserver) {
        this.f216a.registerObserver(dataSetObserver);
    }

    public void mo14a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void m230a(View view) {
    }

    public void mo755a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void mo15a(ViewGroup viewGroup) {
        m230a((View) viewGroup);
    }

    public void mo16a(ViewGroup viewGroup, int i, Object obj) {
        mo755a((View) viewGroup, i, obj);
    }

    public abstract boolean mo17a(View view, Object obj);

    public abstract int mo756b();

    public void m236b(DataSetObserver dataSetObserver) {
        this.f216a.unregisterObserver(dataSetObserver);
    }

    public void m237b(View view) {
    }

    public void m238b(View view, int i, Object obj) {
    }

    public void mo18b(ViewGroup viewGroup) {
        m237b((View) viewGroup);
    }

    public void mo19b(ViewGroup viewGroup, int i, Object obj) {
        m238b((View) viewGroup, i, obj);
    }

    public CharSequence mo758c(int i) {
        return null;
    }

    public float m242d(int i) {
        return 1.0f;
    }
}

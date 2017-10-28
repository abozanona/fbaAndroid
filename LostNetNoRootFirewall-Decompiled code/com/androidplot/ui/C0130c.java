package com.androidplot.ui;

import android.graphics.RectF;
import java.util.Iterator;

final class C0130c implements Iterator {
    private FixedTableModel f557a;
    private RectF f558b;
    private RectF f559c;
    private int f560d;
    private int f561e;

    protected C0130c(FixedTableModel fixedTableModel, FixedTableModel fixedTableModel2, RectF rectF, int i) {
        this.f557a = fixedTableModel2;
        this.f558b = rectF;
        this.f560d = i;
        this.f559c = new RectF(rectF.left, rectF.top, rectF.left + fixedTableModel2.getCellWidth(), rectF.top + fixedTableModel2.getCellHeight());
    }

    private boolean m968a() {
        return this.f559c.bottom + this.f557a.getCellHeight() > this.f558b.height();
    }

    private boolean m969b() {
        return this.f559c.right + this.f557a.getCellWidth() > this.f558b.width();
    }

    private RectF m970c() {
        try {
            RectF rectF;
            if (this.f561e == 0) {
                rectF = this.f559c;
            } else if (this.f561e >= this.f560d) {
                throw new IndexOutOfBoundsException();
            } else {
                switch (C0131d.f562a[this.f557a.getOrder().ordinal()]) {
                    case 1:
                        if (!m968a()) {
                            this.f559c.offsetTo(this.f559c.left, this.f559c.bottom);
                            break;
                        }
                        this.f559c.offsetTo(this.f559c.right, this.f558b.top);
                        break;
                    case 2:
                        if (!m969b()) {
                            this.f559c.offsetTo(this.f559c.right, this.f559c.top);
                            break;
                        }
                        this.f559c.offsetTo(this.f558b.left, this.f559c.bottom);
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
                rectF = this.f559c;
                this.f561e++;
            }
            return rectF;
        } finally {
            this.f561e++;
        }
    }

    public final boolean hasNext() {
        return this.f561e < this.f560d && !(m968a() && m969b());
    }

    public final /* synthetic */ Object next() {
        return m970c();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

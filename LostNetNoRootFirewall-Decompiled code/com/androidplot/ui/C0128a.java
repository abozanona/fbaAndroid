package com.androidplot.ui;

import android.graphics.RectF;
import java.util.Iterator;

final class C0128a implements Iterator {
    private boolean f544a = true;
    private int f545b = 0;
    private int f546c = 0;
    private int f547d = 0;
    private DynamicTableModel f548e;
    private RectF f549f;
    private RectF f550g;
    private TableOrder f551h;
    private int f552i;
    private int f553j;
    private int f554k;

    public C0128a(DynamicTableModel dynamicTableModel, DynamicTableModel dynamicTableModel2, RectF rectF, int i) {
        this.f548e = dynamicTableModel2;
        this.f549f = rectF;
        this.f551h = dynamicTableModel2.getOrder();
        if (dynamicTableModel2.getNumColumns() == 0 && dynamicTableModel2.getNumRows() >= 1) {
            this.f553j = dynamicTableModel2.getNumRows();
            this.f554k = new Float(((double) (((float) i) / ((float) this.f553j))) + 0.5d).intValue();
        } else if (dynamicTableModel2.getNumRows() == 0 && dynamicTableModel2.getNumColumns() >= 1) {
            this.f554k = dynamicTableModel2.getNumColumns();
            this.f553j = new Float(((double) (((float) i) / ((float) this.f554k))) + 0.5d).intValue();
        } else if (dynamicTableModel2.getNumColumns() == 0 && dynamicTableModel2.getNumRows() == 0) {
            this.f553j = 1;
            this.f554k = i;
        } else {
            this.f553j = dynamicTableModel2.getNumRows();
            this.f554k = dynamicTableModel2.getNumColumns();
        }
        this.f552i = this.f553j * this.f554k;
        this.f550g = dynamicTableModel2.getCellRect(rectF, i);
    }

    public final boolean hasNext() {
        return this.f544a && this.f547d < this.f552i;
    }

    public final /* synthetic */ Object next() {
        if (!hasNext()) {
            this.f544a = false;
            throw new IndexOutOfBoundsException();
        } else if (this.f547d == 0) {
            this.f547d++;
            return this.f550g;
        } else {
            RectF rectF = new RectF(this.f550g);
            switch (C0129b.f556b[this.f551h.ordinal()]) {
                case 1:
                    if (this.f548e.getNumColumns() > 0 && this.f545b >= this.f548e.getNumColumns() - 1) {
                        rectF.offsetTo(this.f549f.left, this.f550g.bottom);
                        this.f545b = 0;
                        this.f546c++;
                        break;
                    }
                    rectF.offsetTo(this.f550g.right, this.f550g.top);
                    this.f545b++;
                    break;
                case 2:
                    if (this.f548e.getNumRows() > 0 && this.f546c >= this.f548e.getNumRows() - 1) {
                        rectF.offsetTo(this.f550g.right, this.f549f.top);
                        this.f546c = 0;
                        this.f545b++;
                        break;
                    }
                    rectF.offsetTo(this.f550g.left, this.f550g.bottom);
                    this.f546c++;
                    break;
                    break;
                default:
                    this.f544a = false;
                    throw new IllegalArgumentException();
            }
            this.f547d++;
            this.f550g = rectF;
            return rectF;
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

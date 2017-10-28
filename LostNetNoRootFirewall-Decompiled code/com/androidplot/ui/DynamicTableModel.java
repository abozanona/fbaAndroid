package com.androidplot.ui;

import android.graphics.RectF;
import com.androidplot.ui.TableModel.Axis;

public class DynamicTableModel extends TableModel {
    private int f507a;
    private int f508b;

    public DynamicTableModel(int i, int i2) {
        this(i, i2, TableOrder.ROW_MAJOR);
    }

    public DynamicTableModel(int i, int i2, TableOrder tableOrder) {
        super(tableOrder);
        this.f508b = i;
        this.f507a = i2;
    }

    private float m958a(RectF rectF, Axis axis, int i) {
        int i2 = 0;
        float f = 0.0f;
        switch (C0129b.f555a[axis.ordinal()]) {
            case 1:
                i2 = this.f507a;
                f = rectF.height();
                break;
            case 2:
                i2 = this.f508b;
                f = rectF.width();
                break;
        }
        return i2 != 0 ? f / ((float) i2) : f / ((float) i);
    }

    public RectF getCellRect(RectF rectF, int i) {
        RectF rectF2 = new RectF();
        rectF2.left = rectF.left;
        rectF2.top = rectF.top;
        rectF2.bottom = rectF.top + m958a(rectF, Axis.ROW, i);
        rectF2.right = rectF.left + m958a(rectF, Axis.COLUMN, i);
        return rectF2;
    }

    public C0128a getIterator(RectF rectF, int i) {
        return new C0128a(this, this, rectF, i);
    }

    public int getNumColumns() {
        return this.f508b;
    }

    public int getNumRows() {
        return this.f507a;
    }

    public void setNumColumns(int i) {
        this.f508b = i;
    }

    public void setNumRows(int i) {
        this.f507a = i;
    }
}

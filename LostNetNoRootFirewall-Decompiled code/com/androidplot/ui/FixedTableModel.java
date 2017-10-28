package com.androidplot.ui;

import android.graphics.RectF;
import java.util.Iterator;

public class FixedTableModel extends TableModel {
    private float f509a;
    private float f510b;

    public float getCellHeight() {
        return this.f510b;
    }

    public float getCellWidth() {
        return this.f509a;
    }

    public Iterator getIterator(RectF rectF, int i) {
        return new C0130c(this, this, rectF, i);
    }

    public void setCellHeight(float f) {
        this.f510b = f;
    }

    public void setCellWidth(float f) {
        this.f509a = f;
    }
}

package com.androidplot.ui;

import android.graphics.RectF;
import java.util.Iterator;

public abstract class TableModel {
    private TableOrder f506a;

    public enum Axis {
        ROW,
        COLUMN
    }

    public enum CellSizingMethod {
        FIXED,
        FILL
    }

    protected TableModel(TableOrder tableOrder) {
        setOrder(tableOrder);
    }

    public abstract Iterator getIterator(RectF rectF, int i);

    public TableOrder getOrder() {
        return this.f506a;
    }

    public void setOrder(TableOrder tableOrder) {
        this.f506a = tableOrder;
    }
}

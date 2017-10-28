package com.ppu.fba.ui;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

class C0348m extends NumberFormat {
    private static final long serialVersionUID = 5171555486113804745L;
    final /* synthetic */ DetailsAppActivity f1882a;
    private DecimalFormat f1883b = new DecimalFormat("#");

    C0348m(DetailsAppActivity detailsAppActivity) {
        this.f1882a = detailsAppActivity;
    }

    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.f1883b.format(d % 24.0d, stringBuffer, fieldPosition);
    }

    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.f1883b.format(j % 24, stringBuffer, fieldPosition);
    }

    public Number parse(String str, ParsePosition parsePosition) {
        return Long.valueOf(Long.parseLong(str));
    }
}

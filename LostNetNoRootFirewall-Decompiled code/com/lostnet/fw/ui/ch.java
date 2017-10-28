package com.lostnet.fw.ui;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

class ch extends NumberFormat {
    private static final long serialVersionUID = 5171555486113804745L;
    final /* synthetic */ cg f1729a;
    private DecimalFormat f1730b = new DecimalFormat("#");

    ch(cg cgVar) {
        this.f1729a = cgVar;
    }

    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.f1730b.format(d % 24.0d, stringBuffer, fieldPosition);
    }

    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.f1730b.format(j % 24, stringBuffer, fieldPosition);
    }

    public Number parse(String str, ParsePosition parsePosition) {
        return Long.valueOf(Long.parseLong(str));
    }
}

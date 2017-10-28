package com.lostnet.fw.ui;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

class C0356u extends NumberFormat {
    private static final long serialVersionUID = 5171555486113804745L;
    final /* synthetic */ DetailsGeoActivity f1899a;
    private DecimalFormat f1900b = new DecimalFormat("#");

    C0356u(DetailsGeoActivity detailsGeoActivity) {
        this.f1899a = detailsGeoActivity;
    }

    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.f1900b.format(d % 24.0d, stringBuffer, fieldPosition);
    }

    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.f1900b.format(j % 24, stringBuffer, fieldPosition);
    }

    public Number parse(String str, ParsePosition parsePosition) {
        return Long.valueOf(Long.parseLong(str));
    }
}

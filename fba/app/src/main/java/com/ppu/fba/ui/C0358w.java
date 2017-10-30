package com.ppu.fba.ui;

import com.ppu.fba.p008c.C0296a;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class C0358w extends NumberFormat {
    private static final long serialVersionUID = -667979541060720601L;
    final /* synthetic */ DetailsGeoActivity f1904a;
    private SimpleDateFormat f1905b = new SimpleDateFormat("dd", Locale.US);
    private Date f1906c = new Date();

    C0358w(DetailsGeoActivity detailsGeoActivity) {
        this.f1904a = detailsGeoActivity;
    }

    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        this.f1906c.setTime(((((((long) d) * 1000) * 60) * 60) * 24) - C0296a.m1931d());
        return this.f1905b.format(this.f1906c, stringBuffer, fieldPosition);
    }

    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        this.f1906c.setTime(((((1000 * j) * 60) * 60) * 24) - C0296a.m1931d());
        return this.f1905b.format(this.f1906c, stringBuffer, fieldPosition);
    }

    public Number parse(String str, ParsePosition parsePosition) {
        return Long.valueOf(Long.parseLong(str));
    }
}

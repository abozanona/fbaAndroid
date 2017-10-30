package com.ppu.fba.ui;

import com.ppu.fba.p008c.C0296a;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class C0357v extends NumberFormat {
    private static final long serialVersionUID = -667979541060720601L;
    final /* synthetic */ DetailsGeoActivity f1901a;
    private SimpleDateFormat f1902b = new SimpleDateFormat("dd", Locale.US);
    private Date f1903c = new Date();

    C0357v(DetailsGeoActivity detailsGeoActivity) {
        this.f1901a = detailsGeoActivity;
    }

    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        this.f1903c.setTime(((((((long) d) * 1000) * 60) * 60) * 24) - C0296a.m1931d());
        return this.f1902b.format(this.f1903c, stringBuffer, fieldPosition);
    }

    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        this.f1903c.setTime(((((1000 * j) * 60) * 60) * 24) - C0296a.m1931d());
        return this.f1902b.format(this.f1903c, stringBuffer, fieldPosition);
    }

    public Number parse(String str, ParsePosition parsePosition) {
        return Long.valueOf(Long.parseLong(str));
    }
}

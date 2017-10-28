package com.ppu.fba.ui;

import com.ppu.fba.p008c.C0296a;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class C0340e extends NumberFormat {
    private static final long serialVersionUID = -667979541060720601L;
    final /* synthetic */ DetailsAppActivity f1792a;
    private SimpleDateFormat f1793b = new SimpleDateFormat("dd", Locale.US);
    private Date f1794c = new Date();

    C0340e(DetailsAppActivity detailsAppActivity) {
        this.f1792a = detailsAppActivity;
    }

    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        this.f1794c.setTime(((((((long) d) * 1000) * 60) * 60) * 24) - C0296a.m1931d());
        return this.f1793b.format(this.f1794c, stringBuffer, fieldPosition);
    }

    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        this.f1794c.setTime(((((1000 * j) * 60) * 60) * 24) - C0296a.m1931d());
        return this.f1793b.format(this.f1794c, stringBuffer, fieldPosition);
    }

    public Number parse(String str, ParsePosition parsePosition) {
        return Long.valueOf(Long.parseLong(str));
    }
}

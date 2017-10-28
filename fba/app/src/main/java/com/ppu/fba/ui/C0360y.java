package com.ppu.fba.ui;

import android.content.Context;
import com.ppu.fba.free.R;
import com.ppu.fba.FirewallApplication;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class C0360y extends NumberFormat {
    private static final long serialVersionUID = 6372228667738078111L;

    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        char c;
        StringBuffer stringBuffer2 = new StringBuffer();
        Context a = FirewallApplication.m1851a();
        int i = (int) d;
        if (i < 1000) {
            c = ' ';
        } else {
            int i2 = i / 1024;
            if (i2 < 1000) {
                i = i2;
                c = a.getResources().getString(R.string.data_kilobyte).toCharArray()[0];
            } else {
                i2 /= 1024;
                if (i2 < 1000) {
                    i = i2;
                    c = a.getResources().getString(R.string.data_megabyte).toCharArray()[0];
                } else {
                    i = i2;
                    c = ' ';
                }
            }
        }
        if (i == 0) {
            i = 1;
        }
        stringBuffer2.append(i);
        if (c != ' ') {
            stringBuffer2.append(c);
        }
        return stringBuffer2;
    }

    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return format((double) j, stringBuffer, fieldPosition);
    }

    public Number parse(String str, ParsePosition parsePosition) {
        return Integer.valueOf(0);
    }
}

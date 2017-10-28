package com.ppu.fba.ui;

import com.ppu.fba.free.R;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

class bm extends NumberFormat {
    private static final long serialVersionUID = 6372228667738078111L;
    final /* synthetic */ DetailsAppActivity f1680a;

    private bm(DetailsAppActivity detailsAppActivity) {
        this.f1680a = detailsAppActivity;
    }

    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        int i;
        char c;
        StringBuffer stringBuffer2 = new StringBuffer();
        int i2 = (int) d;
        char c2 = this.f1680a.getResources().getString(R.string.data_byte).toCharArray()[0];
        char c3;
        if (i2 < 1000) {
            c3 = c2;
            i = i2;
            c = c3;
        } else {
            i2 /= 1024;
            if (i2 < 1000) {
                i = i2;
                c = this.f1680a.getResources().getString(R.string.data_kilobyte).toCharArray()[0];
            } else {
                i2 /= 1024;
                if (i2 < 1000) {
                    i = i2;
                    c = this.f1680a.getResources().getString(R.string.data_megabyte).toCharArray()[0];
                } else {
                    c3 = c2;
                    i = i2;
                    c = c3;
                }
            }
        }
        if (i == 0) {
            i = 1;
        }
        stringBuffer2.append(i);
        stringBuffer2.append(c);
        return stringBuffer2;
    }

    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return format((double) j, stringBuffer, fieldPosition);
    }

    public Number parse(String str, ParsePosition parsePosition) {
        return Integer.valueOf(0);
    }
}

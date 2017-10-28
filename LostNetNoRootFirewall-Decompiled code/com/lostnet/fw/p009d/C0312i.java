package com.lostnet.fw.p009d;

import android.content.Context;
import com.lostnet.fw.C0330m;
import java.math.BigInteger;

public class C0312i {
    public static String m2001a(Context context, BigInteger bigInteger) {
        return bigInteger.compareTo(BigInteger.valueOf(4096)) != 1 ? bigInteger.toString(10) + context.getResources().getString(C0330m.data_byte) : bigInteger.compareTo(BigInteger.valueOf(1048576)) != 1 ? bigInteger.divide(BigInteger.valueOf(1024)).toString(10) + context.getResources().getString(C0330m.data_kilobyte) : bigInteger.compareTo(BigInteger.valueOf(1073741824)) != 1 ? bigInteger.divide(BigInteger.valueOf(1048576)).toString(10) + context.getResources().getString(C0330m.data_megabyte) : bigInteger.divide(BigInteger.valueOf(1073741824)).toString(10) + context.getResources().getString(C0330m.data_gigabyte);
    }
}

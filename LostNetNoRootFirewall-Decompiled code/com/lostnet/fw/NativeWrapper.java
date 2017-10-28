package com.lostnet.fw;

public class NativeWrapper {
    static {
        System.loadLibrary("maxminddb");
        System.loadLibrary("polipo");
        System.loadLibrary("dnscache");
        System.loadLibrary("account3");
    }

    public static native void jni_dicka(Object obj);

    public static native void jni_dickb(Object obj);

    public static native void jni_dickc();

    public static native void jni_dickd();

    public static native void jni_dicke(int i, int i2);

    public static native int jni_dickf(String str);

    public static native void jni_dickg();

    public static native void jni_dickh(int i, int i2);

    public static native int jni_dicki(int i, String str, int i2, int i3, int i4);

    public static native void jni_dickj();

    public static native void jni_dickk();

    public static native void jni_dickl();

    public static native void jni_dickm();

    public static native void jni_dickn();

    public static native void jni_dicko();

    public static native void jni_dickp();

    public static native int jni_dickq();

    public static native void jni_dickr();

    public static native void jni_dicks(int i);

    public static native void jni_dickt();

    public static native int jni_dicku();

    public static native int jni_dickv();

    public static native void jni_dickw(int i);

    public static native void jni_dickx();
}

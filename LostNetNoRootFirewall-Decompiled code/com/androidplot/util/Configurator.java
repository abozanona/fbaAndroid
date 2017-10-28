package com.androidplot.util;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public abstract class Configurator {
    private static final String f575a = Configurator.class.getName();

    private static int m972a(Context context, String str) {
        try {
            return context.getResources().getColor(m973a(context, "@color", str));
        } catch (IllegalArgumentException e) {
            try {
                return Color.parseColor(str);
            } catch (IllegalArgumentException e2) {
                return Integer.parseInt(str);
            }
        }
    }

    private static int m973a(Context context, String str, String str2) {
        String[] split = str2.split("/");
        if (split.length <= 1 || !split[0].equalsIgnoreCase(str)) {
            throw new IllegalArgumentException();
        }
        String replace = split[0].replace("@", "");
        return context.getResources().getIdentifier(split[1], replace, context.getPackageName());
    }

    private static Object m974a(Object obj, String str) {
        while (obj != null) {
            Log.d(f575a, "Looking up object containing: " + str);
            int indexOf = str.indexOf(".");
            if (indexOf <= 0) {
                return obj;
            }
            String substring = str.substring(0, indexOf);
            str = str.substring(indexOf + 1, str.length());
            Class cls = obj.getClass();
            Log.d(f575a, "Attempting to find getter for " + substring + " in class " + cls.getName());
            Method method = cls.getMethod("get" + substring.substring(0, 1).toUpperCase() + substring.substring(1, substring.length()), new Class[0]);
            if (method == null) {
                throw new NullPointerException("No getter found for field: " + substring + " within " + obj.getClass());
            }
            Log.d(f575a, "Invoking " + method.getName() + " on instance of " + obj.getClass().getName());
            obj = method.invoke(obj, new Object[0]);
        }
        throw new NullPointerException("Attempt to call getObjectContaining(Object obj, String path) on a null Object instance.  Path was: " + str);
    }

    private static String m975a(Object[] objArr) {
        int length = objArr.length;
        String str = "";
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            str = str + (obj == null ? str + "[null] " : "[" + obj.getClass() + ": " + obj + "] ");
        }
        return str;
    }

    private static Object[] m976a(Context context, Class[] clsArr, String[] strArr) {
        Object[] objArr = new Object[clsArr.length];
        int i = 0;
        for (Class cls : clsArr) {
            if (Enum.class.isAssignableFrom(cls)) {
                objArr[i] = cls.getMethod("valueOf", new Class[]{String.class}).invoke(null, new Object[]{strArr[i].toUpperCase()});
            } else if (cls.equals(Float.TYPE)) {
                objArr[i] = Float.valueOf(m977b(context, strArr[i]));
            } else if (cls.equals(Integer.TYPE)) {
                objArr[i] = Integer.valueOf(m972a(context, strArr[i]));
            } else if (cls.equals(Boolean.TYPE)) {
                objArr[i] = Boolean.valueOf(strArr[i]);
            } else if (cls.equals(String.class)) {
                objArr[i] = m978c(context, strArr[i]);
            } else {
                throw new IllegalArgumentException("Error inflating XML: Setter requires param of unsupported type: " + cls);
            }
            i++;
        }
        return objArr;
    }

    private static float m977b(Context context, String str) {
        try {
            return context.getResources().getDimension(m973a(context, "@dimen", str));
        } catch (IllegalArgumentException e) {
            try {
                return PixelUtils.stringToDimension(str);
            } catch (Exception e2) {
                return Float.parseFloat(str);
            }
        }
    }

    private static String m978c(Context context, String str) {
        try {
            str = context.getResources().getString(m973a(context, "@string", str));
        } catch (IllegalArgumentException e) {
        }
        return str;
    }

    public static void configure(Context context, Object obj, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            HashMap hashMap = new HashMap();
            while (xml.getEventType() != 1) {
                xml.next();
                String name = xml.getName();
                if (xml.getEventType() == 2) {
                    if (name.equalsIgnoreCase("config")) {
                        for (int i2 = 0; i2 < xml.getAttributeCount(); i2++) {
                            hashMap.put(xml.getAttributeName(i2), xml.getAttributeValue(i2));
                        }
                    }
                    configure(context, obj, hashMap);
                }
            }
            configure(context, obj, hashMap);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            xml.close();
        }
    }

    public static void configure(Context context, Object obj, HashMap hashMap) {
        for (String str : hashMap.keySet()) {
            try {
                String str2 = (String) hashMap.get(str);
                Object a = m974a(obj, str);
                if (a != null) {
                    int lastIndexOf = str.lastIndexOf(".");
                    String substring = lastIndexOf > 0 ? str.substring(lastIndexOf + 1, str.length()) : str;
                    Class cls = a.getClass();
                    String str3 = "set" + substring;
                    for (Method method : cls.getMethods()) {
                        if (method.getName().equalsIgnoreCase(str3)) {
                            Class[] parameterTypes = method.getParameterTypes();
                            if (parameterTypes.length >= 1) {
                                String[] split = str2.split("\\|");
                                if (split.length == parameterTypes.length) {
                                    Object[] a2 = m976a(context, parameterTypes, split);
                                    Log.d(f575a, "Invoking " + method.getName() + " with arg(s) " + m975a(a2));
                                    method.invoke(a, a2);
                                } else {
                                    throw new IllegalArgumentException("Error inflating XML: Unexpected number of argments passed to \"" + method.getName() + "\".  Expected: " + parameterTypes.length + " Got: " + split.length);
                                }
                            }
                            throw new IllegalArgumentException("Error inflating XML: no setter method found for param \"" + substring + "\".");
                        }
                    }
                    throw new NoSuchMethodException("No such public method (case insensitive): " + str3 + " in " + cls);
                }
                continue;
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                Log.w(f575a, "Error inflating XML: Setter for field \"" + str + "\" does not exist. ");
                e3.printStackTrace();
            }
        }
    }
}

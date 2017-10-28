package com.ppu.fba.p009d;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.google.analytics.tracking.android.MapBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class C0311h {
    private static boolean f1416a = false;

    public static Object m1997a(Context context, String str) {
        ObjectInputStream objectInputStream;
        Object readObject;
        ObjectInputStream objectInputStream2;
        FileInputStream fileInputStream;
        Exception exception;
        String message;
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2 = null;
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(context.getFilesDir().getPath() + "/" + str);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream2);
                try {
                    readObject = objectInputStream.readObject();
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (FileNotFoundException e3) {
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e5) {
                        }
                    }
                    return readObject;
                } catch (Exception e6) {
                    Exception exception2 = e6;
                    objectInputStream2 = objectInputStream;
                    fileInputStream = fileInputStream2;
                    exception = exception2;
                    try {
                        C0315l.m2018a("readObjectFromFile", exception.getClass().getCanonicalName());
                        message = exception.getMessage();
                        if (message != null) {
                            C0315l.m2018a("readObjectFromFile", message);
                        }
                        C0318o.m2031a(MapBuilder.createEvent("error", "read", exception.getClass().getCanonicalName(), null).build());
                        exception.printStackTrace();
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e8) {
                            }
                        }
                        return readObject;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e10) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    objectInputStream2 = objectInputStream;
                    fileInputStream = fileInputStream2;
                    if (objectInputStream2 != null) {
                        objectInputStream2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e11) {
                InputStream inputStream3 = inputStream2;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return readObject;
            } catch (Exception e12) {
                inputStream = inputStream2;
                FileInputStream fileInputStream3 = fileInputStream2;
                exception = e12;
                fileInputStream = fileInputStream3;
                C0315l.m2018a("readObjectFromFile", exception.getClass().getCanonicalName());
                message = exception.getMessage();
                if (message != null) {
                    C0315l.m2018a("readObjectFromFile", message);
                }
                C0318o.m2031a(MapBuilder.createEvent("error", "read", exception.getClass().getCanonicalName(), null).build());
                exception.printStackTrace();
                if (objectInputStream2 != null) {
                    objectInputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return readObject;
            } catch (Throwable th4) {
                inputStream = inputStream2;
                th = th4;
                fileInputStream = fileInputStream2;
                if (objectInputStream2 != null) {
                    objectInputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e13) {
            fileInputStream2 = inputStream2;
            objectInputStream = inputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return readObject;
        } catch (Exception e14) {
            exception = e14;
            fileInputStream = inputStream2;
            objectInputStream2 = inputStream2;
            C0315l.m2018a("readObjectFromFile", exception.getClass().getCanonicalName());
            message = exception.getMessage();
            if (message != null) {
                C0315l.m2018a("readObjectFromFile", message);
            }
            C0318o.m2031a(MapBuilder.createEvent("error", "read", exception.getClass().getCanonicalName(), null).build());
            exception.printStackTrace();
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return readObject;
        } catch (Throwable th5) {
            fileInputStream = inputStream2;
            objectInputStream2 = inputStream2;
            th = th5;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return readObject;
    }

    public static void m1998a(Context context) {
        if (!f1416a) {
            C0311h.m2000b(context);
        }
    }

    public static void m1999a(Context context, Object obj, String str, boolean z) {
        Object e;
        OutputStream outputStream;
        ObjectOutputStream objectOutputStream;
        Throwable th;
        OutputStream outputStream2;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(context.getFilesDir().getPath() + "/" + str);
            if (z) {
                file.createNewFile();
                file.setReadable(true, false);
            }
            OutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);
                try {
                    objectOutputStream2.writeObject(obj);
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.flush();
                            objectOutputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.getFD().sync();
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    outputStream = fileOutputStream2;
                    objectOutputStream = objectOutputStream2;
                    try {
                        C0318o.m2031a(MapBuilder.createEvent("error", "write", e.getClass().getCanonicalName(), null).build());
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.flush();
                                objectOutputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (fileOutputStream == null) {
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.getFD().sync();
                                fileOutputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.flush();
                                objectOutputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.getFD().sync();
                                fileOutputStream.close();
                            } catch (IOException e8) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = fileOutputStream2;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        objectOutputStream.flush();
                        objectOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.getFD().sync();
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
                outputStream2 = fileOutputStream2;
                objectOutputStream = null;
                outputStream = outputStream2;
                C0318o.m2031a(MapBuilder.createEvent("error", "write", e.getClass().getCanonicalName(), null).build());
                if (objectOutputStream != null) {
                    objectOutputStream.flush();
                    objectOutputStream.close();
                }
                if (fileOutputStream == null) {
                    fileOutputStream.flush();
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                }
            } catch (Throwable th4) {
                th = th4;
                outputStream2 = fileOutputStream2;
                objectOutputStream = null;
                outputStream = outputStream2;
                if (objectOutputStream != null) {
                    objectOutputStream.flush();
                    objectOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            objectOutputStream = null;
            C0318o.m2031a(MapBuilder.createEvent("error", "write", e.getClass().getCanonicalName(), null).build());
            if (objectOutputStream != null) {
                objectOutputStream.flush();
                objectOutputStream.close();
            }
            if (fileOutputStream == null) {
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
            }
        } catch (Throwable th5) {
            th = th5;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.flush();
                objectOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
            }
            throw th;
        }
    }

    private static synchronized void m2000b(Context context) {
        synchronized (C0311h.class) {
            int i;
            f1416a = true;
            ArrayList arrayList = new ArrayList();
            arrayList.add("../cache/polipo");
            arrayList.add("polipo");
            arrayList.add("polipo/www");
            arrayList.add("profiles");
            arrayList.add("icons");
            arrayList.add("labels");
            arrayList.add("hourly");
            arrayList.add("daily");
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("GeoLite2-Country.mmdb");
            arrayList2.add("polipo/COPYING");
            arrayList2.add("polipo/cache");
            arrayList2.add("polipo/cache2");
            arrayList2.add("polipo/www/index.html");
            arrayList2.add("polipo/www/ad.html");
            arrayList2.add("polipo/www/ad2.html");
            arrayList2.add("polipo/www/forbidden.html");
            arrayList2.add("polipo/www/notfound.html");
            arrayList2.add("polipo/www/lnf2.png");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                File file = new File(context.getFilesDir().getPath() + "/" + ((String) it.next()));
                if (!(file == null || file.exists())) {
                    file.mkdir();
                }
            }
            for (String str : new String[]{"appsCollection", "cntsCollection", "profiles"}) {
                File file2 = new File(context.getFilesDir().getPath() + "/" + str);
                if (file2.exists()) {
                    file2.setReadable(true, false);
                }
            }
            AssetManager assets = context.getAssets();
            if (assets != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    String str2 = (String) it2.next();
                    String str3 = context.getFilesDir().getPath() + "/" + str2;
                    file = new File(str3);
                    try {
                        if (file.exists()) {
                            AssetFileDescriptor openFd = assets.openFd(str2);
                            if (openFd.getLength() != file.length()) {
                                openFd.close();
                            }
                        }
                    } catch (Exception e) {
                    }
                    try {
                        InputStream open = assets.open(str2);
                        FileOutputStream fileOutputStream = new FileOutputStream(str3);
                        byte[] bArr = new byte[32768];
                        i = 32768;
                        while (i == 32768) {
                            i = open.read(bArr, 0, 32768);
                            if (i > 0) {
                                fileOutputStream.write(bArr, 0, i);
                            }
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        open.close();
                    } catch (Exception e2) {
                        C0318o.m2031a(MapBuilder.createEvent("error", "pers", e2.getClass().getCanonicalName(), null).build());
                    }
                }
            }
        }
    }
}

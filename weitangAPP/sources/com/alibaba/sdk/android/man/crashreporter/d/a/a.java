package com.alibaba.sdk.android.man.crashreporter.d.a;

import android.content.Context;
import com.alibaba.sdk.android.man.crashreporter.e.f;
import com.alibaba.sdk.android.man.crashreporter.e.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.ObjectOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String[] a(final Context context, String str) {
        try {
            if (context == null) {
                com.alibaba.sdk.android.man.crashreporter.b.a.h("Trying to get crash reports but MotuCrashReporter is not initialized.");
                return new String[0];
            }
            File dir = context.getDir(str, 0);
            if (dir == null) {
                com.alibaba.sdk.android.man.crashreporter.b.a.g("Application files directory does not exist! The application may not be installed correctly. Please try reinstalling.");
                return new String[0];
            }
            com.alibaba.sdk.android.man.crashreporter.b.a.e("Looking for error files in " + dir.getAbsolutePath());
            String[] list = dir.list(new FilenameFilter() { // from class: com.alibaba.sdk.android.man.crashreporter.d.a.a.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    String strA = com.alibaba.sdk.android.man.crashreporter.e.a.a(context);
                    return strA == null ? str2.startsWith("FAILURE") : str2.startsWith(Integer.toString(i.a(i.a(strA, ""))));
                }
            });
            return list == null ? new String[0] : list;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("find file error.", e2);
            return null;
        }
    }

    public static String[] a(Context context, String str, final String str2) {
        try {
            if (context == null) {
                com.alibaba.sdk.android.man.crashreporter.b.a.h("Trying to get crash reports but MotuCrashReporter is not initialized.");
                return new String[0];
            }
            File file = new File(str);
            com.alibaba.sdk.android.man.crashreporter.b.a.e("Looking for error files in " + file.getAbsolutePath());
            String[] list = file.list(new FilenameFilter() { // from class: com.alibaba.sdk.android.man.crashreporter.d.a.a.2
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str3) {
                    return str3.endsWith(str2);
                }
            });
            return list == null ? new String[0] : list;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("find file error.", e2);
            return null;
        }
    }

    public static void a(Object obj, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        if (obj != null && file != null) {
            ObjectOutputStream objectOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    try {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream);
                        try {
                            objectOutputStream2.writeObject(obj);
                            f.a(objectOutputStream2);
                        } catch (Exception e2) {
                            e = e2;
                            objectOutputStream = objectOutputStream2;
                            com.alibaba.sdk.android.man.crashreporter.b.a.d("store file error.", e);
                            if (objectOutputStream != null) {
                                f.a(objectOutputStream);
                            }
                            if (fileOutputStream == null) {
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                                f.a(objectOutputStream);
                            }
                            if (fileOutputStream != null) {
                                f.a(fileOutputStream);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            f.a(fileOutputStream);
            return;
        }
        com.alibaba.sdk.android.man.crashreporter.b.a.h("store file error:object or file is null!");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object a(java.io.InputStream r3) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r3 != 0) goto L9
            java.lang.String r3 = "load file error:input stream is null!"
            com.alibaba.sdk.android.man.crashreporter.b.a.h(r3)
            return r0
        L9:
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            java.lang.Object r3 = r1.readObject()     // Catch: java.lang.Exception -> L18 java.lang.Throwable -> L29
            if (r3 == 0) goto L25
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r1)
            return r3
        L18:
            r3 = move-exception
            goto L1e
        L1a:
            r3 = move-exception
            goto L2b
        L1c:
            r3 = move-exception
            r1 = r0
        L1e:
            java.lang.String r2 = "load reports error."
            com.alibaba.sdk.android.man.crashreporter.b.a.d(r2, r3)     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L28
        L25:
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r1)
        L28:
            return r0
        L29:
            r3 = move-exception
            r0 = r1
        L2b:
            if (r0 == 0) goto L30
            com.alibaba.sdk.android.man.crashreporter.e.f.a(r0)
        L30:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.man.crashreporter.d.a.a.a(java.io.InputStream):java.lang.Object");
    }
}

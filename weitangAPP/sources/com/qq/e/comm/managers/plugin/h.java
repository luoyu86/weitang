package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.util.GDTLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f9698a = b.a("e_qq_com_plugin");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f9699b = b.a("e_qq_com_dex");

    public static File a(Context context) {
        return context.getDir(f9699b, 0);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(File file, File file2) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            return a(new FileInputStream(file), file2);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(InputStream inputStream, File file) throws Throwable {
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                GDTLogger.e("parent dir not exists " + parentFile.getAbsolutePath());
                return false;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 <= 0) {
                        a(inputStream);
                        a(fileOutputStream2);
                        return true;
                    }
                    fileOutputStream2.write(bArr, 0, i2);
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    GDTLogger.e("Exception while copy from InputStream to File", th);
                    throw th;
                } finally {
                    a(inputStream);
                    a(fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b() {
        return "gdt_plugin";
    }

    public static void c(String str, File file) throws Throwable {
        OutputStreamWriter outputStreamWriter;
        if (file == null) {
            throw new IOException("Target File Can not be null in StringUtil.writeTo");
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        } catch (Throwable th) {
            th = th;
        }
        try {
            outputStreamWriter.write(str);
            a(outputStreamWriter);
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter2 = outputStreamWriter;
            a(outputStreamWriter2);
            throw th;
        }
    }

    public static File d(Context context) {
        return new File(context.getDir(f9698a, 0), "update_lc");
    }

    public static File e(Context context) {
        return new File(context.getDir(f9698a, 0), "gdt_plugin.next");
    }

    public static File f(Context context) {
        return new File(context.getDir(f9698a, 0), "gdt_plugin.next.sig");
    }

    public static File g(Context context) {
        return new File(context.getDir(f9698a, 0), "gdt_plugin.jar");
    }

    public static File h(Context context) {
        return new File(context.getDir(f9698a, 0), "gdt_plugin.jar.sig");
    }
}

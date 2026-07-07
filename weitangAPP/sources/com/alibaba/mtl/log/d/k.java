package com.alibaba.mtl.log.d;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f4565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static FileChannel f63a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static FileLock f64a;

    public static synchronized boolean c(Context context) {
        FileLock fileLockTryLock;
        if (f4565a == null) {
            f4565a = new File(context.getFilesDir() + File.separator + "ap.Lock");
        }
        boolean zExists = f4565a.exists();
        if (!zExists) {
            try {
                zExists = f4565a.createNewFile();
            } catch (IOException unused) {
            }
        }
        if (!zExists) {
            return true;
        }
        if (f63a == null) {
            try {
                f63a = new RandomAccessFile(f4565a, "rw").getChannel();
            } catch (Exception unused2) {
                return false;
            }
        }
        try {
            fileLockTryLock = f63a.tryLock();
            if (fileLockTryLock != null) {
                f64a = fileLockTryLock;
                return true;
            }
        } catch (Throwable unused3) {
            fileLockTryLock = null;
        }
        Log.d("TAG", "mLock:" + fileLockTryLock);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0016 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void release() {
        /*
            java.lang.Class<com.alibaba.mtl.log.d.k> r0 = com.alibaba.mtl.log.d.k.class
            monitor-enter(r0)
            java.nio.channels.FileLock r1 = com.alibaba.mtl.log.d.k.f64a     // Catch: java.lang.Throwable -> L22
            r2 = 0
            if (r1 == 0) goto L12
            r1.release()     // Catch: java.io.IOException -> Lb java.lang.Throwable -> Le
        Lb:
            com.alibaba.mtl.log.d.k.f64a = r2     // Catch: java.lang.Throwable -> L22
            goto L12
        Le:
            r1 = move-exception
            com.alibaba.mtl.log.d.k.f64a = r2     // Catch: java.lang.Throwable -> L22
            throw r1     // Catch: java.lang.Throwable -> L22
        L12:
            java.nio.channels.FileChannel r1 = com.alibaba.mtl.log.d.k.f63a     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L20
            r1.close()     // Catch: java.lang.Exception -> L19 java.lang.Throwable -> L1c
        L19:
            com.alibaba.mtl.log.d.k.f63a = r2     // Catch: java.lang.Throwable -> L22
            goto L20
        L1c:
            r1 = move-exception
            com.alibaba.mtl.log.d.k.f63a = r2     // Catch: java.lang.Throwable -> L22
            throw r1     // Catch: java.lang.Throwable -> L22
        L20:
            monitor-exit(r0)
            return
        L22:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.d.k.release():void");
    }
}

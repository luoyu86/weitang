package com.ta.a.c;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static File f10197a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static FileChannel f144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static FileLock f145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f10198b;

    public static synchronized void c() {
        f.e();
        if (f10197a == null) {
            f10197a = new File(com.ta.a.b.e.c());
        }
        if (!f10197a.exists()) {
            try {
                f10197a.createNewFile();
            } catch (Exception unused) {
                return;
            }
        }
        if (f144a == null) {
            try {
                f144a = new RandomAccessFile(f10197a, "rw").getChannel();
            } catch (Exception unused2) {
                return;
            }
        }
        try {
            f145a = f144a.lock();
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0019 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void d() {
        /*
            java.lang.Class<com.ta.a.c.c> r0 = com.ta.a.c.c.class
            monitor-enter(r0)
            com.ta.a.c.f.e()     // Catch: java.lang.Throwable -> L25
            java.nio.channels.FileLock r1 = com.ta.a.c.c.f145a     // Catch: java.lang.Throwable -> L25
            r2 = 0
            if (r1 == 0) goto L15
            r1.release()     // Catch: java.lang.Exception -> Le java.lang.Throwable -> L11
        Le:
            com.ta.a.c.c.f145a = r2     // Catch: java.lang.Throwable -> L25
            goto L15
        L11:
            r1 = move-exception
            com.ta.a.c.c.f145a = r2     // Catch: java.lang.Throwable -> L25
            throw r1     // Catch: java.lang.Throwable -> L25
        L15:
            java.nio.channels.FileChannel r1 = com.ta.a.c.c.f144a     // Catch: java.lang.Throwable -> L25
            if (r1 == 0) goto L23
            r1.close()     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L1f
        L1c:
            com.ta.a.c.c.f144a = r2     // Catch: java.lang.Throwable -> L25
            goto L23
        L1f:
            r1 = move-exception
            com.ta.a.c.c.f144a = r2     // Catch: java.lang.Throwable -> L25
            throw r1     // Catch: java.lang.Throwable -> L25
        L23:
            monitor-exit(r0)
            return
        L25:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.a.c.c.d():void");
    }
}

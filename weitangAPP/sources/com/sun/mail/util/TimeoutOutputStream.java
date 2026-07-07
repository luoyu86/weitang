package com.sun.mail.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class TimeoutOutputStream extends OutputStream {
    private byte[] b1;
    private final OutputStream os;
    private final ScheduledExecutorService ses;
    private final int timeout;
    private final Callable<Object> timeoutTask = new Callable<Object>() { // from class: com.sun.mail.util.TimeoutOutputStream.1
        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            TimeoutOutputStream.this.os.close();
            return null;
        }
    };

    public TimeoutOutputStream(OutputStream outputStream, ScheduledExecutorService scheduledExecutorService, int i2) throws IOException {
        this.os = outputStream;
        this.ses = scheduledExecutorService;
        this.timeout = i2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.os.close();
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i2) throws IOException {
        if (this.b1 == null) {
            this.b1 = new byte[1];
        }
        byte[] bArr = this.b1;
        bArr[0] = (byte) i2;
        write(bArr);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        if (i2 >= 0) {
            if (i2 <= bArr.length && i3 >= 0 && (i4 = i2 + i3) <= bArr.length && i4 >= 0) {
                if (i3 == 0) {
                    return;
                }
                ScheduledFuture scheduledFutureSchedule = null;
                try {
                    try {
                        int i5 = this.timeout;
                        if (i5 > 0) {
                            scheduledFutureSchedule = this.ses.schedule(this.timeoutTask, i5, TimeUnit.MILLISECONDS);
                        }
                    } catch (RejectedExecutionException unused) {
                    }
                    this.os.write(bArr, i2, i3);
                    return;
                } finally {
                    if (scheduledFutureSchedule != null) {
                        scheduledFutureSchedule.cancel(true);
                    }
                }
            }
        }
        throw new IndexOutOfBoundsException();
    }
}

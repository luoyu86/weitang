package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.q.kf;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public class n implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FileDescriptor f10116a;
    private RandomAccessFile bl;
    private BufferedOutputStream ok;

    public n(File file, int i2) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.bl = randomAccessFile;
            this.f10116a = randomAccessFile.getFD();
            if (i2 <= 0) {
                this.ok = new BufferedOutputStream(new FileOutputStream(this.bl.getFD()));
                return;
            }
            if (i2 < 8192) {
                i2 = 8192;
            } else if (i2 > 131072) {
                i2 = 131072;
            }
            this.ok = new BufferedOutputStream(new FileOutputStream(this.bl.getFD()), i2);
        } catch (IOException e2) {
            throw new BaseException(1039, e2);
        }
    }

    public void a() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.ok;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void bl() throws IOException {
        FileDescriptor fileDescriptor = this.f10116a;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        kf.ok(this.bl, this.ok);
    }

    public void ok(byte[] bArr, int i2, int i3) throws IOException {
        this.ok.write(bArr, i2, i3);
    }

    public void ok() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.ok;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.f10116a;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void a(long j) throws IOException {
        this.bl.setLength(j);
    }

    public void ok(long j) throws IOException {
        this.bl.seek(j);
    }
}

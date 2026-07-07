package com.bytedance.pangle.util.b;

import com.bytedance.pangle.util.b.b.d;
import com.bytedance.pangle.util.g;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f6262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.pangle.util.b.a.b f6263b = new com.bytedance.pangle.util.b.a.b();

    public a(d dVar) {
        this.f6262a = dVar;
    }

    public static void a(File file) throws ZipException {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    public static void a(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j, long j2, String str) throws IOException {
        g.a(randomAccessFile, randomAccessFile2, j, j + j2, str);
    }
}

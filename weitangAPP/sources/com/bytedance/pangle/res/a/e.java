package com.bytedance.pangle.res.a;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class e extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6222a;

    public e(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.bytedance.pangle.res.a.j
    public final synchronized void a(int i2) {
        if (i2 != -1) {
            this.f6222a += (long) i2;
        }
    }

    public final synchronized long b() {
        return this.f6222a;
    }

    @Override // com.bytedance.pangle.res.a.j, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j) {
        long jSkip;
        jSkip = super.skip(j);
        this.f6222a += jSkip;
        return jSkip;
    }

    public final int a() {
        long jB = b();
        if (jB <= 2147483647L) {
            return (int) jB;
        }
        throw new ArithmeticException("The byte count " + jB + " is too large to be converted to an int");
    }
}

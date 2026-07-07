package com.bytedance.pangle.f.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f6055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6056b;

    public b(InputStream inputStream) {
        a(inputStream);
    }

    public final void a(InputStream inputStream) {
        this.f6055a = inputStream;
        this.f6056b = 0;
    }

    public final void b() throws IOException {
        long jSkip = this.f6055a.skip(4L);
        this.f6056b = (int) (((long) this.f6056b) + jSkip);
        if (jSkip != 4) {
            throw new EOFException();
        }
    }

    public final int a() throws IOException {
        int i2 = 0;
        for (int i3 = 0; i3 != 32; i3 += 8) {
            int i4 = this.f6055a.read();
            if (i4 == -1) {
                throw new EOFException();
            }
            this.f6056b++;
            i2 |= i4 << i3;
        }
        return i2;
    }

    public final void b(int i2) throws IOException {
        int iA = a();
        if (iA != i2) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i2), Integer.valueOf(iA)));
        }
    }

    public final int[] a(int i2) {
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i2 > 0) {
            iArr[i3] = a();
            i2--;
            i3++;
        }
        return iArr;
    }
}

package com.ss.android.socialbase.appdownloader.kf.ok;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f9940a;
    private int bl;
    private InputStream ok;

    public s() {
    }

    public final int a() throws IOException {
        return ok(4);
    }

    public final void bl(int i2) throws IOException {
        if (i2 > 0) {
            long j = i2;
            long jSkip = this.ok.skip(j);
            this.bl = (int) (((long) this.bl) + jSkip);
            if (jSkip != j) {
                throw new EOFException();
            }
        }
    }

    public final void ok(InputStream inputStream, boolean z) {
        this.ok = inputStream;
        this.f9940a = z;
        this.bl = 0;
    }

    public s(InputStream inputStream, boolean z) {
        ok(inputStream, z);
    }

    public final int[] a(int i2) throws IOException {
        int[] iArr = new int[i2];
        ok(iArr, 0, i2);
        return iArr;
    }

    public final void bl() throws IOException {
        bl(4);
    }

    public final void ok() {
        InputStream inputStream = this.ok;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            ok(null, false);
        }
    }

    public final int ok(int i2) throws IOException {
        if (i2 >= 0 && i2 <= 4) {
            int i3 = 0;
            if (this.f9940a) {
                for (int i4 = (i2 - 1) * 8; i4 >= 0; i4 -= 8) {
                    int i5 = this.ok.read();
                    if (i5 == -1) {
                        throw new EOFException();
                    }
                    this.bl++;
                    i3 |= i5 << i4;
                }
                return i3;
            }
            int i6 = i2 * 8;
            int i7 = 0;
            while (i3 != i6) {
                int i8 = this.ok.read();
                if (i8 == -1) {
                    throw new EOFException();
                }
                this.bl++;
                i7 |= i8 << i3;
                i3 += 8;
            }
            return i7;
        }
        throw new IllegalArgumentException();
    }

    public final void ok(int[] iArr, int i2, int i3) throws IOException {
        while (i3 > 0) {
            iArr[i2] = a();
            i3--;
            i2++;
        }
    }
}

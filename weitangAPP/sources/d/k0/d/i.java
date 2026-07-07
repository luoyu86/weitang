package d.k0.d;

import d.g0.a1;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final d.g0.p iterator(byte[] bArr) {
        t.checkNotNullParameter(bArr, "array");
        return new b(bArr);
    }

    public static final d.g0.q iterator(char[] cArr) {
        t.checkNotNullParameter(cArr, "array");
        return new c(cArr);
    }

    public static final a1 iterator(short[] sArr) {
        t.checkNotNullParameter(sArr, "array");
        return new k(sArr);
    }

    public static final d.g0.l0 iterator(int[] iArr) {
        t.checkNotNullParameter(iArr, "array");
        return new f(iArr);
    }

    public static final d.g0.m0 iterator(long[] jArr) {
        t.checkNotNullParameter(jArr, "array");
        return new j(jArr);
    }

    public static final d.g0.g0 iterator(float[] fArr) {
        t.checkNotNullParameter(fArr, "array");
        return new e(fArr);
    }

    public static final d.g0.b0 iterator(double[] dArr) {
        t.checkNotNullParameter(dArr, "array");
        return new d(dArr);
    }

    public static final d.g0.o iterator(boolean[] zArr) {
        t.checkNotNullParameter(zArr, "array");
        return new a(zArr);
    }
}

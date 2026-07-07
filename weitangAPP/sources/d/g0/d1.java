package d.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class d1 {
    public static final int a(long[] jArr, int i2, int i3) {
        long jM461getsVKNKU = d.y.m461getsVKNKU(jArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (d.f0.ulongCompare(d.y.m461getsVKNKU(jArr, i2), jM461getsVKNKU) < 0) {
                i2++;
            }
            while (d.f0.ulongCompare(d.y.m461getsVKNKU(jArr, i3), jM461getsVKNKU) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                long jM461getsVKNKU2 = d.y.m461getsVKNKU(jArr, i2);
                d.y.m466setk8EXiF4(jArr, i2, d.y.m461getsVKNKU(jArr, i3));
                d.y.m466setk8EXiF4(jArr, i3, jM461getsVKNKU2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    public static final int b(byte[] bArr, int i2, int i3) {
        int i4;
        byte bM413getw2LRezQ = d.u.m413getw2LRezQ(bArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                i4 = bM413getw2LRezQ & 255;
                if (d.k0.d.t.compare(d.u.m413getw2LRezQ(bArr, i2) & 255, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (d.k0.d.t.compare(d.u.m413getw2LRezQ(bArr, i3) & 255, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                byte bM413getw2LRezQ2 = d.u.m413getw2LRezQ(bArr, i2);
                d.u.m418setVurrAj0(bArr, i2, d.u.m413getw2LRezQ(bArr, i3));
                d.u.m418setVurrAj0(bArr, i3, bM413getw2LRezQ2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    public static final int c(short[] sArr, int i2, int i3) {
        int i4;
        short sM108getMh2AYeg = d.b0.m108getMh2AYeg(sArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                i4 = sM108getMh2AYeg & 65535;
                if (d.k0.d.t.compare(d.b0.m108getMh2AYeg(sArr, i2) & 65535, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (d.k0.d.t.compare(d.b0.m108getMh2AYeg(sArr, i3) & 65535, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                short sM108getMh2AYeg2 = d.b0.m108getMh2AYeg(sArr, i2);
                d.b0.m113set01HTLdE(sArr, i2, d.b0.m108getMh2AYeg(sArr, i3));
                d.b0.m113set01HTLdE(sArr, i3, sM108getMh2AYeg2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    public static final int d(int[] iArr, int i2, int i3) {
        int iM437getpVg5ArA = d.w.m437getpVg5ArA(iArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (d.f0.uintCompare(d.w.m437getpVg5ArA(iArr, i2), iM437getpVg5ArA) < 0) {
                i2++;
            }
            while (d.f0.uintCompare(d.w.m437getpVg5ArA(iArr, i3), iM437getpVg5ArA) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                int iM437getpVg5ArA2 = d.w.m437getpVg5ArA(iArr, i2);
                d.w.m442setVXSXFK8(iArr, i2, d.w.m437getpVg5ArA(iArr, i3));
                d.w.m442setVXSXFK8(iArr, i3, iM437getpVg5ArA2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    public static final void e(long[] jArr, int i2, int i3) {
        int iA = a(jArr, i2, i3);
        int i4 = iA - 1;
        if (i2 < i4) {
            e(jArr, i2, i4);
        }
        if (iA < i3) {
            e(jArr, iA, i3);
        }
    }

    public static final void f(byte[] bArr, int i2, int i3) {
        int iB = b(bArr, i2, i3);
        int i4 = iB - 1;
        if (i2 < i4) {
            f(bArr, i2, i4);
        }
        if (iB < i3) {
            f(bArr, iB, i3);
        }
    }

    public static final void g(short[] sArr, int i2, int i3) {
        int iC = c(sArr, i2, i3);
        int i4 = iC - 1;
        if (i2 < i4) {
            g(sArr, i2, i4);
        }
        if (iC < i3) {
            g(sArr, iC, i3);
        }
    }

    public static final void h(int[] iArr, int i2, int i3) {
        int iD = d(iArr, i2, i3);
        int i4 = iD - 1;
        if (i2 < i4) {
            h(iArr, i2, i4);
        }
        if (iD < i3) {
            h(iArr, iD, i3);
        }
    }

    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m131sortArraynroSd4(long[] jArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(jArr, "array");
        e(jArr, i2, i3 - 1);
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m132sortArray4UcCI2c(byte[] bArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(bArr, "array");
        f(bArr, i2, i3 - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m133sortArrayAa5vz7o(short[] sArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(sArr, "array");
        g(sArr, i2, i3 - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m134sortArrayoBK06Vg(int[] iArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(iArr, "array");
        h(iArr, i2, i3 - 1);
    }
}

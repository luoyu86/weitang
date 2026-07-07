package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q0 extends a0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13291a = new a(q0.class, 28);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f13292b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f13293c;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return q0.g(x1Var.getOctets());
        }
    }

    public q0(byte[] bArr, boolean z) {
        this.f13293c = z ? g.a.j.a.clone(bArr) : bArr;
    }

    public static q0 g(byte[] bArr) {
        return new h2(bArr, false);
    }

    public static q0 getInstance(l0 l0Var, boolean z) {
        return (q0) f13291a.e(l0Var, z);
    }

    public static q0 getInstance(Object obj) {
        if (obj == null || (obj instanceof q0)) {
            return (q0) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof q0) {
                return (q0) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (q0) f13291a.b((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error getInstance: " + e2.toString());
        }
    }

    public static void h(StringBuffer stringBuffer, int i2) {
        char[] cArr = f13292b;
        stringBuffer.append(cArr[(i2 >>> 4) & 15]);
        stringBuffer.append(cArr[i2 & 15]);
    }

    public static void i(StringBuffer stringBuffer, int i2) {
        if (i2 < 128) {
            h(stringBuffer, i2);
            return;
        }
        byte[] bArr = new byte[5];
        int i3 = 5;
        do {
            i3--;
            bArr[i3] = (byte) i2;
            i2 >>>= 8;
        } while (i2 != 0);
        int i4 = 5 - i3;
        int i5 = i3 - 1;
        bArr[i5] = (byte) (i4 | 128);
        while (true) {
            int i6 = i5 + 1;
            h(stringBuffer, bArr[i5]);
            if (i6 >= 5) {
                return;
            } else {
                i5 = i6;
            }
        }
    }

    @Override // g.a.a.a0
    public final boolean a(a0 a0Var) {
        if (a0Var instanceof q0) {
            return g.a.j.a.areEqual(this.f13293c, ((q0) a0Var).f13293c);
        }
        return false;
    }

    @Override // g.a.a.a0
    public final void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 28, this.f13293c);
    }

    @Override // g.a.a.a0
    public final boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public final int d(boolean z) {
        return y.e(z, this.f13293c.length);
    }

    public final byte[] getOctets() {
        return g.a.j.a.clone(this.f13293c);
    }

    @Override // g.a.a.i0
    public final String getString() {
        int length = this.f13293c.length;
        StringBuffer stringBuffer = new StringBuffer(((y.d(length) + length) * 2) + 3);
        stringBuffer.append("#1C");
        i(stringBuffer, length);
        for (int i2 = 0; i2 < length; i2++) {
            h(stringBuffer, this.f13293c[i2]);
        }
        return stringBuffer.toString();
    }

    @Override // g.a.a.a0, g.a.a.t
    public final int hashCode() {
        return g.a.j.a.hashCode(this.f13293c);
    }

    public String toString() {
        return getString();
    }
}

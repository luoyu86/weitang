package g.a.a;

import com.alibaba.android.arouter.utils.Consts;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class c0 extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13051a = new a(c0.class, 13);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f13053c;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return c0.g(x1Var.getOctets(), false);
        }
    }

    public c0(c0 c0Var, String str) {
        if (!i(str, 0)) {
            throw new IllegalArgumentException("string " + str + " not a valid OID branch");
        }
        this.f13052b = c0Var.getId() + Consts.DOT + str;
    }

    public c0(String str) {
        Objects.requireNonNull(str, "'identifier' cannot be null");
        if (i(str, 0)) {
            this.f13052b = str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not a relative OID");
    }

    public c0(byte[] bArr, boolean z) {
        byte[] bArr2 = bArr;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z2 = true;
        long j = 0;
        BigInteger bigIntegerShiftLeft = null;
        for (int i2 = 0; i2 != bArr2.length; i2++) {
            int i3 = bArr2[i2] & 255;
            if (j <= 72057594037927808L) {
                long j2 = j + ((long) (i3 & 127));
                if ((i3 & 128) == 0) {
                    if (z2) {
                        z2 = false;
                    } else {
                        stringBuffer.append('.');
                    }
                    stringBuffer.append(j2);
                    j = 0;
                } else {
                    j = j2 << 7;
                }
            } else {
                BigInteger bigIntegerOr = (bigIntegerShiftLeft == null ? BigInteger.valueOf(j) : bigIntegerShiftLeft).or(BigInteger.valueOf(i3 & 127));
                if ((i3 & 128) == 0) {
                    if (z2) {
                        z2 = false;
                    } else {
                        stringBuffer.append('.');
                    }
                    stringBuffer.append(bigIntegerOr);
                    j = 0;
                    bigIntegerShiftLeft = null;
                } else {
                    bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                }
            }
        }
        this.f13052b = stringBuffer.toString();
        this.f13053c = z ? g.a.j.a.clone(bArr) : bArr2;
    }

    public static c0 fromContents(byte[] bArr) {
        return g(bArr, true);
    }

    public static c0 g(byte[] bArr, boolean z) {
        return new c0(bArr, z);
    }

    public static c0 getInstance(l0 l0Var, boolean z) {
        return (c0) f13051a.e(l0Var, z);
    }

    public static c0 getInstance(Object obj) {
        if (obj == null || (obj instanceof c0)) {
            return (c0) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof c0) {
                return (c0) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (c0) f13051a.b((byte[]) obj);
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct relative OID from byte[]: " + e2.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        if (r7.charAt(r0 + 1) != '0') goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r2 == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if (r2 <= 1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean i(java.lang.String r7, int r8) {
        /*
            int r0 = r7.length()
            r1 = 0
        L5:
            r2 = 0
        L6:
            int r0 = r0 + (-1)
            r3 = 48
            r4 = 1
            if (r0 < r8) goto L2c
            char r5 = r7.charAt(r0)
            r6 = 46
            if (r5 != r6) goto L22
            if (r2 == 0) goto L21
            if (r2 <= r4) goto L5
            int r2 = r0 + 1
            char r2 = r7.charAt(r2)
            if (r2 != r3) goto L5
        L21:
            return r1
        L22:
            if (r3 > r5) goto L2b
            r3 = 57
            if (r5 > r3) goto L2b
            int r2 = r2 + 1
            goto L6
        L2b:
            return r1
        L2c:
            if (r2 == 0) goto L39
            if (r2 <= r4) goto L38
            int r0 = r0 + r4
            char r7 = r7.charAt(r0)
            if (r7 != r3) goto L38
            goto L39
        L38:
            return r4
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.a.c0.i(java.lang.String, int):boolean");
    }

    public static void j(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i2 = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i2--;
            bArr[i2] = (byte) (((int) j) | 128);
        }
        byteArrayOutputStream.write(bArr, i2, 9 - i2);
    }

    public static void k(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int iBitLength = (bigInteger.bitLength() + 6) / 7;
        if (iBitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[iBitLength];
        int i2 = iBitLength - 1;
        for (int i3 = i2; i3 >= 0; i3--) {
            bArr[i3] = (byte) (bigInteger.intValue() | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i2] = (byte) (bArr[i2] & 127);
        byteArrayOutputStream.write(bArr, 0, iBitLength);
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        if (this == a0Var) {
            return true;
        }
        if (a0Var instanceof c0) {
            return this.f13052b.equals(((c0) a0Var).f13052b);
        }
        return false;
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 13, getContents());
    }

    public c0 branch(String str) {
        return new c0(this, str);
    }

    @Override // g.a.a.a0
    public boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public int d(boolean z) {
        return y.e(z, getContents().length);
    }

    public final synchronized byte[] getContents() {
        if (this.f13053c == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            h(byteArrayOutputStream);
            this.f13053c = byteArrayOutputStream.toByteArray();
        }
        return this.f13053c;
    }

    public String getId() {
        return this.f13052b;
    }

    public final void h(ByteArrayOutputStream byteArrayOutputStream) {
        d3 d3Var = new d3(this.f13052b);
        while (d3Var.hasMoreTokens()) {
            String strNextToken = d3Var.nextToken();
            if (strNextToken.length() <= 18) {
                j(byteArrayOutputStream, Long.parseLong(strNextToken));
            } else {
                k(byteArrayOutputStream, new BigInteger(strNextToken));
            }
        }
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        return this.f13052b.hashCode();
    }

    public String toString() {
        return getId();
    }
}

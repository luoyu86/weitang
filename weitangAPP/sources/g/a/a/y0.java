package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class y0 extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c[] f13447e;

    public y0(byte b2, int i2) {
        super(b2, i2);
        this.f13447e = null;
        this.f13446d = 1000;
    }

    public y0(g gVar) throws IOException {
        this(gVar.toASN1Primitive().getEncoded("DER"), 0);
    }

    public y0(byte[] bArr) {
        this(bArr, 0);
    }

    public y0(byte[] bArr, int i2) {
        this(bArr, i2, 1000);
    }

    public y0(byte[] bArr, int i2, int i3) {
        super(bArr, i2);
        this.f13447e = null;
        this.f13446d = i3;
    }

    public y0(c[] cVarArr) {
        this(cVarArr, 1000);
    }

    public y0(c[] cVarArr, int i2) {
        super(j(cVarArr), false);
        this.f13447e = cVarArr;
        this.f13446d = i2;
    }

    public static byte[] j(c[] cVarArr) {
        int length = cVarArr.length;
        if (length == 0) {
            return new byte[]{0};
        }
        if (length == 1) {
            return cVarArr[0].f13050c;
        }
        int i2 = length - 1;
        int length2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr = cVarArr[i3].f13050c;
            if (bArr[0] != 0) {
                throw new IllegalArgumentException("only the last nested bitstring can have padding");
            }
            length2 += bArr.length - 1;
        }
        byte[] bArr2 = cVarArr[i2].f13050c;
        byte b2 = bArr2[0];
        byte[] bArr3 = new byte[length2 + bArr2.length];
        bArr3[0] = b2;
        int i4 = 1;
        for (c cVar : cVarArr) {
            byte[] bArr4 = cVar.f13050c;
            int length3 = bArr4.length - 1;
            System.arraycopy(bArr4, 1, bArr3, i4, length3);
            i4 += length3;
        }
        return bArr3;
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        if (!c()) {
            byte[] bArr = this.f13050c;
            l2.k(yVar, z, bArr, 0, bArr.length);
            return;
        }
        yVar.q(z, 35);
        yVar.g(128);
        c[] cVarArr = this.f13447e;
        if (cVarArr != null) {
            yVar.t(cVarArr);
        } else {
            byte[] bArr2 = this.f13050c;
            if (bArr2.length >= 2) {
                byte b2 = bArr2[0];
                int length = bArr2.length;
                int i2 = length - 1;
                int i3 = this.f13446d - 1;
                while (i2 > i3) {
                    l2.j(yVar, true, (byte) 0, this.f13050c, length - i2, i3);
                    i2 -= i3;
                }
                l2.j(yVar, true, b2, this.f13050c, length - i2, i2);
            }
        }
        yVar.g(0);
        yVar.g(0);
    }

    @Override // g.a.a.a0
    public boolean c() {
        return this.f13447e != null || this.f13050c.length > this.f13446d;
    }

    @Override // g.a.a.a0
    public int d(boolean z) throws IOException {
        if (!c()) {
            return l2.l(z, this.f13050c.length);
        }
        int iD = z ? 4 : 3;
        if (this.f13447e == null) {
            byte[] bArr = this.f13050c;
            if (bArr.length < 2) {
                return iD;
            }
            int length = bArr.length - 2;
            int i2 = this.f13446d;
            int i3 = length / (i2 - 1);
            return iD + (l2.l(true, i2) * i3) + l2.l(true, this.f13050c.length - (i3 * (this.f13446d - 1)));
        }
        int i4 = 0;
        while (true) {
            c[] cVarArr = this.f13447e;
            if (i4 >= cVarArr.length) {
                return iD;
            }
            iD += cVarArr[i4].d(true);
            i4++;
        }
    }
}

package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class n1 extends c {
    public n1(byte b2, int i2) {
        super(b2, i2);
    }

    public n1(int i2) {
        super(c.h(i2), c.i(i2));
    }

    public n1(g gVar) throws IOException {
        super(gVar.toASN1Primitive().getEncoded("DER"), 0);
    }

    public n1(byte[] bArr) {
        this(bArr, 0);
    }

    public n1(byte[] bArr, int i2) {
        super(bArr, i2);
    }

    public n1(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    public static n1 convert(c cVar) {
        return (n1) cVar.e();
    }

    public static n1 getInstance(l0 l0Var, boolean z) {
        a0 object = l0Var.getObject();
        return (z || (object instanceof n1)) ? getInstance((Object) object) : j(w.getInstance(object));
    }

    public static n1 getInstance(Object obj) {
        if (obj == null || (obj instanceof n1)) {
            return (n1) obj;
        }
        if (obj instanceof c) {
            return convert((c) obj);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return convert((c) a0.fromByteArray((byte[]) obj));
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }

    public static n1 j(w wVar) {
        return new n1(wVar.getOctets(), true);
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        byte[] bArr = this.f13050c;
        int i2 = bArr[0] & 255;
        int length = bArr.length - 1;
        byte b2 = bArr[length];
        byte b3 = (byte) ((255 << i2) & bArr[length]);
        if (b2 == b3) {
            yVar.m(z, 3, bArr);
        } else {
            yVar.o(z, 3, bArr, 0, length, b3);
        }
    }

    @Override // g.a.a.a0
    public boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public int d(boolean z) {
        return y.e(z, this.f13050c.length);
    }

    @Override // g.a.a.c, g.a.a.a0
    public a0 e() {
        return this;
    }

    @Override // g.a.a.c, g.a.a.a0
    public a0 f() {
        return this;
    }
}

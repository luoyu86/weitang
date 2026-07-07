package g.a.i.b.i;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.a.d.e f14466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14467b;

    public h(g.a.a.v vVar, int i2) {
        Objects.requireNonNull(vVar, "digest == null");
        this.f14466a = f.a(vVar);
        this.f14467b = i2;
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i2 = this.f14467b;
        if (length != i2) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == i2) {
            return d(0, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong in length");
    }

    public byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i2 = this.f14467b;
        if (length != i2) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == i2 * 2) {
            return d(1, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong in length");
    }

    public byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr.length != this.f14467b) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == 32) {
            return d(3, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong address length");
    }

    public final byte[] d(int i2, byte[] bArr, byte[] bArr2) {
        byte[] bytesBigEndian = a0.toBytesBigEndian(i2, this.f14467b);
        this.f14466a.update(bytesBigEndian, 0, bytesBigEndian.length);
        this.f14466a.update(bArr, 0, bArr.length);
        this.f14466a.update(bArr2, 0, bArr2.length);
        int i3 = this.f14467b;
        byte[] bArr3 = new byte[i3];
        g.a.d.e eVar = this.f14466a;
        if (eVar instanceof g.a.d.i) {
            ((g.a.d.i) eVar).doFinal(bArr3, 0, i3);
        } else {
            eVar.doFinal(bArr3, 0);
        }
        return bArr3;
    }
}

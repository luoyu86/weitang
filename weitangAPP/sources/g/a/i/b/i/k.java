package g.a.i.b.i;

import g.a.i.b.i.j;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f14480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f14481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f14482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f14483d;

    public k(m mVar) {
        Objects.requireNonNull(mVar, "params == null");
        this.f14480a = mVar;
        int iB = mVar.b();
        this.f14481b = new h(mVar.getTreeDigest(), iB);
        this.f14482c = new byte[iB];
        this.f14483d = new byte[iB];
    }

    public final byte[] a(byte[] bArr, int i2, int i3, j jVar) {
        int iB = this.f14480a.b();
        Objects.requireNonNull(bArr, "startHash == null");
        if (bArr.length != iB) {
            throw new IllegalArgumentException("startHash needs to be " + iB + "bytes");
        }
        Objects.requireNonNull(jVar, "otsHashAddress == null");
        Objects.requireNonNull(jVar.c(), "otsHashAddress byte array == null");
        int i4 = i2 + i3;
        if (i4 > this.f14480a.c() - 1) {
            throw new IllegalArgumentException("max chain length must not be greater than w");
        }
        if (i3 == 0) {
            return bArr;
        }
        byte[] bArrA = a(bArr, i2, i3 - 1, jVar);
        j jVar2 = (j) new j.b().g(jVar.a()).h(jVar.b()).p(jVar.f()).n(jVar.d()).o(i4 - 1).f(0).l();
        byte[] bArrC = this.f14481b.c(this.f14483d, jVar2.c());
        byte[] bArrC2 = this.f14481b.c(this.f14483d, ((j) new j.b().g(jVar2.a()).h(jVar2.b()).p(jVar2.f()).n(jVar2.d()).o(jVar2.e()).f(1).l()).c());
        byte[] bArr2 = new byte[iB];
        for (int i5 = 0; i5 < iB; i5++) {
            bArr2[i5] = (byte) (bArrA[i5] ^ bArrC2[i5]);
        }
        return this.f14481b.a(bArrC, bArr2);
    }

    public final byte[] b(int i2) {
        if (i2 < 0 || i2 >= this.f14480a.a()) {
            throw new IllegalArgumentException("index out of bounds");
        }
        return this.f14481b.c(this.f14482c, a0.toBytesBigEndian(i2, 32));
    }

    public h c() {
        return this.f14481b;
    }

    public m d() {
        return this.f14480a;
    }

    public n e(j jVar) {
        Objects.requireNonNull(jVar, "otsHashAddress == null");
        byte[][] bArr = new byte[this.f14480a.a()][];
        for (int i2 = 0; i2 < this.f14480a.a(); i2++) {
            jVar = (j) new j.b().g(jVar.a()).h(jVar.b()).p(jVar.f()).n(i2).o(jVar.e()).f(jVar.getKeyAndMask()).l();
            bArr[i2] = a(b(i2), 0, this.f14480a.c() - 1, jVar);
        }
        return new n(this.f14480a, bArr);
    }

    public byte[] f() {
        return g.a.j.a.clone(this.f14483d);
    }

    public byte[] g(byte[] bArr, j jVar) {
        return this.f14481b.c(bArr, ((j) new j.b().g(jVar.a()).h(jVar.b()).p(jVar.f()).l()).c());
    }

    public void h(byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(bArr, "secretKeySeed == null");
        if (bArr.length != this.f14480a.b()) {
            throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
        }
        Objects.requireNonNull(bArr2, "publicSeed == null");
        if (bArr2.length != this.f14480a.b()) {
            throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
        this.f14482c = bArr;
        this.f14483d = bArr2;
    }
}

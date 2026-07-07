package g.a.i.b.i;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends p implements g.a.j.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f14560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f14562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f14563f;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x f14564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f14565b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f14566c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f14567d = null;

        public b(x xVar) {
            this.f14564a = xVar;
        }

        public z build() {
            return new z(this);
        }

        public b withPublicKey(byte[] bArr) {
            this.f14567d = a0.cloneArray(bArr);
            return this;
        }

        public b withPublicSeed(byte[] bArr) {
            this.f14566c = a0.cloneArray(bArr);
            return this;
        }

        public b withRoot(byte[] bArr) {
            this.f14565b = a0.cloneArray(bArr);
            return this;
        }
    }

    public z(b bVar) {
        super(false, bVar.f14564a.e());
        x xVar = bVar.f14564a;
        this.f14560c = xVar;
        Objects.requireNonNull(xVar, "params == null");
        int treeDigestSize = xVar.getTreeDigestSize();
        byte[] bArr = bVar.f14567d;
        if (bArr != null) {
            if (bArr.length == treeDigestSize + treeDigestSize) {
                this.f14561d = 0;
                this.f14562e = a0.extractBytesAtOffset(bArr, 0, treeDigestSize);
                this.f14563f = a0.extractBytesAtOffset(bArr, treeDigestSize + 0, treeDigestSize);
                return;
            } else {
                if (bArr.length != treeDigestSize + 4 + treeDigestSize) {
                    throw new IllegalArgumentException("public key has wrong size");
                }
                this.f14561d = g.a.j.k.bigEndianToInt(bArr, 0);
                this.f14562e = a0.extractBytesAtOffset(bArr, 4, treeDigestSize);
                this.f14563f = a0.extractBytesAtOffset(bArr, 4 + treeDigestSize, treeDigestSize);
                return;
            }
        }
        if (xVar.d() != null) {
            this.f14561d = xVar.d().getOid();
        } else {
            this.f14561d = 0;
        }
        byte[] bArr2 = bVar.f14565b;
        if (bArr2 == null) {
            this.f14562e = new byte[treeDigestSize];
        } else {
            if (bArr2.length != treeDigestSize) {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            this.f14562e = bArr2;
        }
        byte[] bArr3 = bVar.f14566c;
        if (bArr3 == null) {
            this.f14563f = new byte[treeDigestSize];
        } else {
            if (bArr3.length != treeDigestSize) {
                throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            }
            this.f14563f = bArr3;
        }
    }

    @Override // g.a.j.d
    public byte[] getEncoded() throws IOException {
        return toByteArray();
    }

    public x getParameters() {
        return this.f14560c;
    }

    public byte[] getPublicSeed() {
        return a0.cloneArray(this.f14563f);
    }

    public byte[] getRoot() {
        return a0.cloneArray(this.f14562e);
    }

    public byte[] toByteArray() {
        byte[] bArr;
        int treeDigestSize = this.f14560c.getTreeDigestSize();
        int i2 = this.f14561d;
        int i3 = 0;
        if (i2 != 0) {
            bArr = new byte[treeDigestSize + 4 + treeDigestSize];
            g.a.j.k.intToBigEndian(i2, bArr, 0);
            i3 = 4;
        } else {
            bArr = new byte[treeDigestSize + treeDigestSize];
        }
        a0.copyBytesAtOffset(bArr, this.f14562e, i3);
        a0.copyBytesAtOffset(bArr, this.f14563f, i3 + treeDigestSize);
        return bArr;
    }
}

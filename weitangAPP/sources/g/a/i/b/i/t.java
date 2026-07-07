package g.a.i.b.i;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends q implements g.a.j.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f14526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f14528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f14529f;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f14530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f14531b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f14532c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f14533d = null;

        public b(r rVar) {
            this.f14530a = rVar;
        }

        public t build() {
            return new t(this);
        }

        public b withPublicKey(byte[] bArr) {
            this.f14533d = a0.cloneArray(bArr);
            return this;
        }

        public b withPublicSeed(byte[] bArr) {
            this.f14532c = a0.cloneArray(bArr);
            return this;
        }

        public b withRoot(byte[] bArr) {
            this.f14531b = a0.cloneArray(bArr);
            return this;
        }
    }

    public t(b bVar) {
        super(false, bVar.f14530a.c());
        r rVar = bVar.f14530a;
        this.f14526c = rVar;
        Objects.requireNonNull(rVar, "params == null");
        int treeDigestSize = rVar.getTreeDigestSize();
        byte[] bArr = bVar.f14533d;
        if (bArr != null) {
            if (bArr.length == treeDigestSize + treeDigestSize) {
                this.f14527d = 0;
                this.f14528e = a0.extractBytesAtOffset(bArr, 0, treeDigestSize);
                this.f14529f = a0.extractBytesAtOffset(bArr, treeDigestSize + 0, treeDigestSize);
                return;
            } else {
                if (bArr.length != treeDigestSize + 4 + treeDigestSize) {
                    throw new IllegalArgumentException("public key has wrong size");
                }
                this.f14527d = g.a.j.k.bigEndianToInt(bArr, 0);
                this.f14528e = a0.extractBytesAtOffset(bArr, 4, treeDigestSize);
                this.f14529f = a0.extractBytesAtOffset(bArr, 4 + treeDigestSize, treeDigestSize);
                return;
            }
        }
        if (rVar.b() != null) {
            this.f14527d = rVar.b().getOid();
        } else {
            this.f14527d = 0;
        }
        byte[] bArr2 = bVar.f14531b;
        if (bArr2 == null) {
            this.f14528e = new byte[treeDigestSize];
        } else {
            if (bArr2.length != treeDigestSize) {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            this.f14528e = bArr2;
        }
        byte[] bArr3 = bVar.f14532c;
        if (bArr3 == null) {
            this.f14529f = new byte[treeDigestSize];
        } else {
            if (bArr3.length != treeDigestSize) {
                throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            }
            this.f14529f = bArr3;
        }
    }

    @Override // g.a.j.d
    public byte[] getEncoded() throws IOException {
        return toByteArray();
    }

    public r getParameters() {
        return this.f14526c;
    }

    public byte[] getPublicSeed() {
        return a0.cloneArray(this.f14529f);
    }

    public byte[] getRoot() {
        return a0.cloneArray(this.f14528e);
    }

    public byte[] toByteArray() {
        byte[] bArr;
        int treeDigestSize = this.f14526c.getTreeDigestSize();
        int i2 = this.f14527d;
        int i3 = 0;
        if (i2 != 0) {
            bArr = new byte[treeDigestSize + 4 + treeDigestSize];
            g.a.j.k.intToBigEndian(i2, bArr, 0);
            i3 = 4;
        } else {
            bArr = new byte[treeDigestSize + treeDigestSize];
        }
        a0.copyBytesAtOffset(bArr, this.f14528e, i3);
        a0.copyBytesAtOffset(bArr, this.f14529f, i3 + treeDigestSize);
        return bArr;
    }
}

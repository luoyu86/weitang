package g.a.i.b.i;

import g.a.i.b.i.j;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends p implements g.a.j.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f14545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f14546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f14547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f14548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f14549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile g.a.i.b.i.a f14550h;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x f14551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14552b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14553c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f14554d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f14555e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte[] f14556f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f14557g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public g.a.i.b.i.a f14558h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f14559i = null;

        public b(x xVar) {
            this.f14551a = xVar;
        }

        public y build() {
            return new y(this);
        }

        public b withBDSState(g.a.i.b.i.a aVar) {
            this.f14558h = aVar;
            return this;
        }

        public b withIndex(int i2) {
            this.f14552b = i2;
            return this;
        }

        public b withMaxIndex(int i2) {
            this.f14553c = i2;
            return this;
        }

        public b withPrivateKey(byte[] bArr) {
            this.f14559i = a0.cloneArray(bArr);
            return this;
        }

        public b withPublicSeed(byte[] bArr) {
            this.f14556f = a0.cloneArray(bArr);
            return this;
        }

        public b withRoot(byte[] bArr) {
            this.f14557g = a0.cloneArray(bArr);
            return this;
        }

        public b withSecretKeyPRF(byte[] bArr) {
            this.f14555e = a0.cloneArray(bArr);
            return this;
        }

        public b withSecretKeySeed(byte[] bArr) {
            this.f14554d = a0.cloneArray(bArr);
            return this;
        }
    }

    public y(b bVar) {
        super(true, bVar.f14551a.e());
        x xVar = bVar.f14551a;
        this.f14545c = xVar;
        Objects.requireNonNull(xVar, "params == null");
        int treeDigestSize = xVar.getTreeDigestSize();
        byte[] bArr = bVar.f14559i;
        if (bArr != null) {
            int height = xVar.getHeight();
            int iBigEndianToInt = g.a.j.k.bigEndianToInt(bArr, 0);
            if (!a0.isIndexValid(height, iBigEndianToInt)) {
                throw new IllegalArgumentException("index out of bounds");
            }
            this.f14546d = a0.extractBytesAtOffset(bArr, 4, treeDigestSize);
            int i2 = 4 + treeDigestSize;
            this.f14547e = a0.extractBytesAtOffset(bArr, i2, treeDigestSize);
            int i3 = i2 + treeDigestSize;
            this.f14548f = a0.extractBytesAtOffset(bArr, i3, treeDigestSize);
            int i4 = i3 + treeDigestSize;
            this.f14549g = a0.extractBytesAtOffset(bArr, i4, treeDigestSize);
            int i5 = i4 + treeDigestSize;
            try {
                g.a.i.b.i.a aVar = (g.a.i.b.i.a) a0.deserialize(a0.extractBytesAtOffset(bArr, i5, bArr.length - i5), g.a.i.b.i.a.class);
                if (aVar.b() != iBigEndianToInt) {
                    throw new IllegalStateException("serialized BDS has wrong index");
                }
                this.f14550h = aVar.withWOTSDigest(bVar.f14551a.getTreeDigestOID());
                return;
            } catch (IOException e2) {
                throw new IllegalArgumentException(e2.getMessage(), e2);
            } catch (ClassNotFoundException e3) {
                throw new IllegalArgumentException(e3.getMessage(), e3);
            }
        }
        byte[] bArr2 = bVar.f14554d;
        if (bArr2 == null) {
            this.f14546d = new byte[treeDigestSize];
        } else {
            if (bArr2.length != treeDigestSize) {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            this.f14546d = bArr2;
        }
        byte[] bArr3 = bVar.f14555e;
        if (bArr3 == null) {
            this.f14547e = new byte[treeDigestSize];
        } else {
            if (bArr3.length != treeDigestSize) {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            this.f14547e = bArr3;
        }
        byte[] bArr4 = bVar.f14556f;
        if (bArr4 == null) {
            this.f14548f = new byte[treeDigestSize];
        } else {
            if (bArr4.length != treeDigestSize) {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            this.f14548f = bArr4;
        }
        byte[] bArr5 = bVar.f14557g;
        if (bArr5 == null) {
            this.f14549g = new byte[treeDigestSize];
        } else {
            if (bArr5.length != treeDigestSize) {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            this.f14549g = bArr5;
        }
        g.a.i.b.i.a aVar2 = bVar.f14558h;
        this.f14550h = aVar2 == null ? (bVar.f14552b >= (1 << xVar.getHeight()) + (-2) || bArr4 == null || bArr2 == null) ? new g.a.i.b.i.a(xVar, (1 << xVar.getHeight()) - 1, bVar.f14552b) : new g.a.i.b.i.a(xVar, bArr4, bArr2, (j) new j.b().l(), bVar.f14552b) : aVar2;
        if (bVar.f14553c >= 0 && bVar.f14553c != this.f14550h.getMaxIndex()) {
            throw new IllegalArgumentException("maxIndex set but not reflected in state");
        }
    }

    public y extractKeyShard(int i2) {
        y yVarBuild;
        if (i2 < 1) {
            throw new IllegalArgumentException("cannot ask for a shard with 0 keys");
        }
        synchronized (this) {
            long j = i2;
            if (j > getUsagesRemaining()) {
                throw new IllegalArgumentException("usageCount exceeds usages remaining");
            }
            yVarBuild = new b(this.f14545c).withSecretKeySeed(this.f14546d).withSecretKeyPRF(this.f14547e).withPublicSeed(this.f14548f).withRoot(this.f14549g).withIndex(getIndex()).withBDSState(this.f14550h.withMaxIndex((this.f14550h.b() + i2) - 1, this.f14545c.getTreeDigestOID())).build();
            if (j == getUsagesRemaining()) {
                this.f14550h = new g.a.i.b.i.a(this.f14545c, this.f14550h.getMaxIndex(), getIndex() + i2);
            } else {
                j jVar = (j) new j.b().l();
                for (int i3 = 0; i3 != i2; i3++) {
                    this.f14550h = this.f14550h.getNextState(this.f14548f, this.f14546d, jVar);
                }
            }
        }
        return yVarBuild;
    }

    @Override // g.a.j.d
    public byte[] getEncoded() throws IOException {
        byte[] byteArray;
        synchronized (this) {
            byteArray = toByteArray();
        }
        return byteArray;
    }

    public int getIndex() {
        return this.f14550h.b();
    }

    public y getNextKey() {
        y yVarExtractKeyShard;
        synchronized (this) {
            yVarExtractKeyShard = extractKeyShard(1);
        }
        return yVarExtractKeyShard;
    }

    public x getParameters() {
        return this.f14545c;
    }

    public byte[] getPublicSeed() {
        return a0.cloneArray(this.f14548f);
    }

    public byte[] getRoot() {
        return a0.cloneArray(this.f14549g);
    }

    public byte[] getSecretKeyPRF() {
        return a0.cloneArray(this.f14547e);
    }

    public byte[] getSecretKeySeed() {
        return a0.cloneArray(this.f14546d);
    }

    public long getUsagesRemaining() {
        long maxIndex;
        synchronized (this) {
            maxIndex = (this.f14550h.getMaxIndex() - getIndex()) + 1;
        }
        return maxIndex;
    }

    public byte[] toByteArray() {
        byte[] bArrConcatenate;
        synchronized (this) {
            int treeDigestSize = this.f14545c.getTreeDigestSize();
            byte[] bArr = new byte[treeDigestSize + 4 + treeDigestSize + treeDigestSize + treeDigestSize];
            g.a.j.k.intToBigEndian(this.f14550h.b(), bArr, 0);
            a0.copyBytesAtOffset(bArr, this.f14546d, 4);
            int i2 = 4 + treeDigestSize;
            a0.copyBytesAtOffset(bArr, this.f14547e, i2);
            int i3 = i2 + treeDigestSize;
            a0.copyBytesAtOffset(bArr, this.f14548f, i3);
            a0.copyBytesAtOffset(bArr, this.f14549g, i3 + treeDigestSize);
            try {
                bArrConcatenate = g.a.j.a.concatenate(bArr, a0.serialize(this.f14550h));
            } catch (IOException e2) {
                throw new RuntimeException("error serializing bds state: " + e2.getMessage());
            }
        }
        return bArrConcatenate;
    }
}

package g.a.i.b.i;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends q implements g.a.j.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f14510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f14511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f14512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f14513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f14514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f14515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile g.a.i.b.i.b f14516i;
    public volatile boolean j;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f14517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f14518b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f14519c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f14520d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f14521e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte[] f14522f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f14523g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public g.a.i.b.i.b f14524h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f14525i = null;
        public x j = null;

        public b(r rVar) {
            this.f14517a = rVar;
        }

        public s build() {
            return new s(this);
        }

        public b withBDSState(g.a.i.b.i.b bVar) {
            if (bVar.getMaxIndex() == 0) {
                this.f14524h = new g.a.i.b.i.b(bVar, (1 << this.f14517a.getHeight()) - 1);
            } else {
                this.f14524h = bVar;
            }
            return this;
        }

        public b withIndex(long j) {
            this.f14518b = j;
            return this;
        }

        public b withMaxIndex(long j) {
            this.f14519c = j;
            return this;
        }

        public b withPrivateKey(byte[] bArr) {
            this.f14525i = a0.cloneArray(bArr);
            this.j = this.f14517a.e();
            return this;
        }

        public b withPublicSeed(byte[] bArr) {
            this.f14522f = a0.cloneArray(bArr);
            return this;
        }

        public b withRoot(byte[] bArr) {
            this.f14523g = a0.cloneArray(bArr);
            return this;
        }

        public b withSecretKeyPRF(byte[] bArr) {
            this.f14521e = a0.cloneArray(bArr);
            return this;
        }

        public b withSecretKeySeed(byte[] bArr) {
            this.f14520d = a0.cloneArray(bArr);
            return this;
        }
    }

    public s(b bVar) {
        super(true, bVar.f14517a.c());
        r rVar = bVar.f14517a;
        this.f14510c = rVar;
        Objects.requireNonNull(rVar, "params == null");
        int treeDigestSize = rVar.getTreeDigestSize();
        byte[] bArr = bVar.f14525i;
        if (bArr != null) {
            Objects.requireNonNull(bVar.j, "xmss == null");
            int height = rVar.getHeight();
            int i2 = (height + 7) / 8;
            this.f14515h = a0.bytesToXBigEndian(bArr, 0, i2);
            if (!a0.isIndexValid(height, this.f14515h)) {
                throw new IllegalArgumentException("index out of bounds");
            }
            int i3 = i2 + 0;
            this.f14511d = a0.extractBytesAtOffset(bArr, i3, treeDigestSize);
            int i4 = i3 + treeDigestSize;
            this.f14512e = a0.extractBytesAtOffset(bArr, i4, treeDigestSize);
            int i5 = i4 + treeDigestSize;
            this.f14513f = a0.extractBytesAtOffset(bArr, i5, treeDigestSize);
            int i6 = i5 + treeDigestSize;
            this.f14514g = a0.extractBytesAtOffset(bArr, i6, treeDigestSize);
            int i7 = i6 + treeDigestSize;
            try {
                this.f14516i = ((g.a.i.b.i.b) a0.deserialize(a0.extractBytesAtOffset(bArr, i7, bArr.length - i7), g.a.i.b.i.b.class)).withWOTSDigest(bVar.j.getTreeDigestOID());
                return;
            } catch (IOException e2) {
                throw new IllegalArgumentException(e2.getMessage(), e2);
            } catch (ClassNotFoundException e3) {
                throw new IllegalArgumentException(e3.getMessage(), e3);
            }
        }
        this.f14515h = bVar.f14518b;
        byte[] bArr2 = bVar.f14520d;
        if (bArr2 == null) {
            this.f14511d = new byte[treeDigestSize];
        } else {
            if (bArr2.length != treeDigestSize) {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            this.f14511d = bArr2;
        }
        byte[] bArr3 = bVar.f14521e;
        if (bArr3 == null) {
            this.f14512e = new byte[treeDigestSize];
        } else {
            if (bArr3.length != treeDigestSize) {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            this.f14512e = bArr3;
        }
        byte[] bArr4 = bVar.f14522f;
        if (bArr4 == null) {
            this.f14513f = new byte[treeDigestSize];
        } else {
            if (bArr4.length != treeDigestSize) {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            this.f14513f = bArr4;
        }
        byte[] bArr5 = bVar.f14523g;
        if (bArr5 == null) {
            this.f14514g = new byte[treeDigestSize];
        } else {
            if (bArr5.length != treeDigestSize) {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            this.f14514g = bArr5;
        }
        g.a.i.b.i.b bVar2 = bVar.f14524h;
        if (bVar2 == null) {
            bVar2 = (!a0.isIndexValid(rVar.getHeight(), bVar.f14518b) || bArr4 == null || bArr2 == null) ? new g.a.i.b.i.b(bVar.f14519c + 1) : new g.a.i.b.i.b(rVar, bVar.f14518b, bArr4, bArr2);
        }
        this.f14516i = bVar2;
        if (bVar.f14519c >= 0 && bVar.f14519c != this.f14516i.getMaxIndex()) {
            throw new IllegalArgumentException("maxIndex set but not reflected in state");
        }
    }

    public s a() {
        synchronized (this) {
            if (getIndex() < this.f14516i.getMaxIndex()) {
                this.f14516i.d(this.f14510c, this.f14515h, this.f14513f, this.f14511d);
                this.f14515h++;
            } else {
                this.f14515h = this.f14516i.getMaxIndex() + 1;
                this.f14516i = new g.a.i.b.i.b(this.f14516i.getMaxIndex());
            }
            this.j = false;
        }
        return this;
    }

    public s extractKeyShard(int i2) {
        s sVarBuild;
        if (i2 < 1) {
            throw new IllegalArgumentException("cannot ask for a shard with 0 keys");
        }
        synchronized (this) {
            long j = i2;
            if (j > getUsagesRemaining()) {
                throw new IllegalArgumentException("usageCount exceeds usages remaining");
            }
            sVarBuild = new b(this.f14510c).withSecretKeySeed(this.f14511d).withSecretKeyPRF(this.f14512e).withPublicSeed(this.f14513f).withRoot(this.f14514g).withIndex(getIndex()).withBDSState(new g.a.i.b.i.b(this.f14516i, (getIndex() + j) - 1)).build();
            for (int i3 = 0; i3 != i2; i3++) {
                a();
            }
        }
        return sVarBuild;
    }

    @Override // g.a.j.d
    public byte[] getEncoded() throws IOException {
        byte[] byteArray;
        synchronized (this) {
            byteArray = toByteArray();
        }
        return byteArray;
    }

    public long getIndex() {
        return this.f14515h;
    }

    public s getNextKey() {
        s sVarExtractKeyShard;
        synchronized (this) {
            sVarExtractKeyShard = extractKeyShard(1);
        }
        return sVarExtractKeyShard;
    }

    public r getParameters() {
        return this.f14510c;
    }

    public byte[] getPublicSeed() {
        return a0.cloneArray(this.f14513f);
    }

    public byte[] getRoot() {
        return a0.cloneArray(this.f14514g);
    }

    public byte[] getSecretKeyPRF() {
        return a0.cloneArray(this.f14512e);
    }

    public byte[] getSecretKeySeed() {
        return a0.cloneArray(this.f14511d);
    }

    public long getUsagesRemaining() {
        long maxIndex;
        synchronized (this) {
            maxIndex = (this.f14516i.getMaxIndex() - getIndex()) + 1;
        }
        return maxIndex;
    }

    public byte[] toByteArray() {
        byte[] bArrConcatenate;
        synchronized (this) {
            int treeDigestSize = this.f14510c.getTreeDigestSize();
            int height = (this.f14510c.getHeight() + 7) / 8;
            byte[] bArr = new byte[height + treeDigestSize + treeDigestSize + treeDigestSize + treeDigestSize];
            a0.copyBytesAtOffset(bArr, a0.toBytesBigEndian(this.f14515h, height), 0);
            int i2 = height + 0;
            a0.copyBytesAtOffset(bArr, this.f14511d, i2);
            int i3 = i2 + treeDigestSize;
            a0.copyBytesAtOffset(bArr, this.f14512e, i3);
            int i4 = i3 + treeDigestSize;
            a0.copyBytesAtOffset(bArr, this.f14513f, i4);
            a0.copyBytesAtOffset(bArr, this.f14514g, i4 + treeDigestSize);
            try {
                bArrConcatenate = g.a.j.a.concatenate(bArr, a0.serialize(this.f14516i));
            } catch (IOException e2) {
                throw new IllegalStateException("error serializing bds state: " + e2.getMessage(), e2);
            }
        }
        return bArrConcatenate;
    }
}

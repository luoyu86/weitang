package d.l0;

import d.k0.d.t;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Random {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f12665b;

    public c(f fVar) {
        t.checkNotNullParameter(fVar, "impl");
        this.f12665b = fVar;
    }

    public final f getImpl() {
        return this.f12665b;
    }

    @Override // java.util.Random
    public int next(int i2) {
        return this.f12665b.nextBits(i2);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.f12665b.nextBoolean();
    }

    @Override // java.util.Random
    public void nextBytes(byte[] bArr) {
        t.checkNotNullParameter(bArr, "bytes");
        this.f12665b.nextBytes(bArr);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.f12665b.nextDouble();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.f12665b.nextFloat();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.f12665b.nextInt();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.f12665b.nextLong();
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (this.f12664a) {
            throw new UnsupportedOperationException("Setting seed is not supported.");
        }
        this.f12664a = true;
    }

    @Override // java.util.Random
    public int nextInt(int i2) {
        return this.f12665b.nextInt(i2);
    }
}

package d.l0;

import d.k0.d.t;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends f {
    public abstract Random getImpl();

    @Override // d.l0.f
    public int nextBits(int i2) {
        return g.takeUpperBits(getImpl().nextInt(), i2);
    }

    @Override // d.l0.f
    public boolean nextBoolean() {
        return getImpl().nextBoolean();
    }

    @Override // d.l0.f
    public byte[] nextBytes(byte[] bArr) {
        t.checkNotNullParameter(bArr, "array");
        getImpl().nextBytes(bArr);
        return bArr;
    }

    @Override // d.l0.f
    public double nextDouble() {
        return getImpl().nextDouble();
    }

    @Override // d.l0.f
    public float nextFloat() {
        return getImpl().nextFloat();
    }

    @Override // d.l0.f
    public int nextInt() {
        return getImpl().nextInt();
    }

    @Override // d.l0.f
    public long nextLong() {
        return getImpl().nextLong();
    }

    @Override // d.l0.f
    public int nextInt(int i2) {
        return getImpl().nextInt(i2);
    }
}

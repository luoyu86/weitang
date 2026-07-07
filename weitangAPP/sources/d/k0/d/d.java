package d.k0.d;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends d.g0.b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double[] f12618b;

    public d(double[] dArr) {
        t.checkNotNullParameter(dArr, "array");
        this.f12618b = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12617a < this.f12618b.length;
    }

    @Override // d.g0.b0
    public double nextDouble() {
        try {
            double[] dArr = this.f12618b;
            int i2 = this.f12617a;
            this.f12617a = i2 + 1;
            return dArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f12617a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}

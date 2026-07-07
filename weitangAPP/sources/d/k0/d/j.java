package d.k0.d;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends d.g0.m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f12628b;

    public j(long[] jArr) {
        t.checkNotNullParameter(jArr, "array");
        this.f12628b = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12627a < this.f12628b.length;
    }

    @Override // d.g0.m0
    public long nextLong() {
        try {
            long[] jArr = this.f12628b;
            int i2 = this.f12627a;
            this.f12627a = i2 + 1;
            return jArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f12627a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}

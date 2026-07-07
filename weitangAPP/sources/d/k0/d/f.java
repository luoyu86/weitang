package d.k0.d;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends d.g0.l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f12622b;

    public f(int[] iArr) {
        t.checkNotNullParameter(iArr, "array");
        this.f12622b = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12621a < this.f12622b.length;
    }

    @Override // d.g0.l0
    public int nextInt() {
        try {
            int[] iArr = this.f12622b;
            int i2 = this.f12621a;
            this.f12621a = i2 + 1;
            return iArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f12621a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}

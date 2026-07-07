package d.k0.d;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends d.g0.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean[] f12612b;

    public a(boolean[] zArr) {
        t.checkNotNullParameter(zArr, "array");
        this.f12612b = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12611a < this.f12612b.length;
    }

    @Override // d.g0.o
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.f12612b;
            int i2 = this.f12611a;
            this.f12611a = i2 + 1;
            return zArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f12611a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}

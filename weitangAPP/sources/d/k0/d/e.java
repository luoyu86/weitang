package d.k0.d;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends d.g0.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f12620b;

    public e(float[] fArr) {
        t.checkNotNullParameter(fArr, "array");
        this.f12620b = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12619a < this.f12620b.length;
    }

    @Override // d.g0.g0
    public float nextFloat() {
        try {
            float[] fArr = this.f12620b;
            int i2 = this.f12619a;
            this.f12619a = i2 + 1;
            return fArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f12619a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}

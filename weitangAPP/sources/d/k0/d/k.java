package d.k0.d;

import d.g0.a1;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final short[] f12631b;

    public k(short[] sArr) {
        t.checkNotNullParameter(sArr, "array");
        this.f12631b = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12630a < this.f12631b.length;
    }

    @Override // d.g0.a1
    public short nextShort() {
        try {
            short[] sArr = this.f12631b;
            int i2 = this.f12630a;
            this.f12630a = i2 + 1;
            return sArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f12630a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}

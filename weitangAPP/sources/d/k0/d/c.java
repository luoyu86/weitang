package d.k0.d;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends d.g0.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char[] f12616b;

    public c(char[] cArr) {
        t.checkNotNullParameter(cArr, "array");
        this.f12616b = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12615a < this.f12616b.length;
    }

    @Override // d.g0.q
    public char nextChar() {
        try {
            char[] cArr = this.f12616b;
            int i2 = this.f12615a;
            this.f12615a = i2 + 1;
            return cArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f12615a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}

package d.k0.d;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class g<T> implements Iterator<T>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T[] f12626b;

    public g(T[] tArr) {
        t.checkNotNullParameter(tArr, "array");
        this.f12626b = tArr;
    }

    public final T[] getArray() {
        return this.f12626b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12625a < this.f12626b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f12626b;
            int i2 = this.f12625a;
            this.f12625a = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f12625a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

package d.g0;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class x0<T> extends d<T> implements RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object[] f12560e;

    public static final class a extends c<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12561c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12562d;

        public a() {
            this.f12561c = x0.this.size();
            this.f12562d = x0.this.f12558c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.g0.c
        public void a() {
            if (this.f12561c == 0) {
                b();
                return;
            }
            c(x0.this.f12560e[this.f12562d]);
            this.f12562d = (this.f12562d + 1) % x0.this.f12557b;
            this.f12561c--;
        }
    }

    public x0(Object[] objArr, int i2) {
        d.k0.d.t.checkNotNullParameter(objArr, "buffer");
        this.f12560e = objArr;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i2).toString());
        }
        if (i2 <= objArr.length) {
            this.f12557b = objArr.length;
            this.f12559d = i2;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i2 + " cannot be larger than the buffer size: " + objArr.length).toString());
    }

    public final int a(int i2, int i3) {
        return (i2 + i3) % this.f12557b;
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T t) {
        if (isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f12560e[(this.f12558c + size()) % this.f12557b] = t;
        this.f12559d = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final x0<T> expanded(int i2) {
        Object[] array;
        int i3 = this.f12557b;
        int iCoerceAtMost = d.m0.p.coerceAtMost(i3 + (i3 >> 1) + 1, i2);
        if (this.f12558c == 0) {
            array = Arrays.copyOf(this.f12560e, iCoerceAtMost);
            d.k0.d.t.checkNotNullExpressionValue(array, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            array = toArray(new Object[iCoerceAtMost]);
        }
        return new x0<>(array, size());
    }

    @Override // d.g0.d, java.util.List
    public T get(int i2) {
        d.f12454a.checkElementIndex$kotlin_stdlib(i2, size());
        return (T) this.f12560e[(this.f12558c + i2) % this.f12557b];
    }

    @Override // d.g0.d, d.g0.a
    public int getSize() {
        return this.f12559d;
    }

    public final boolean isFull() {
        return size() == this.f12557b;
    }

    @Override // d.g0.d, d.g0.a, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new a();
    }

    public final void removeFirst(int i2) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i2).toString());
        }
        if (!(i2 <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i2 + ", size = " + size()).toString());
        }
        if (i2 > 0) {
            int i3 = this.f12558c;
            int i4 = (i3 + i2) % this.f12557b;
            if (i3 > i4) {
                l.fill(this.f12560e, (Object) null, i3, this.f12557b);
                l.fill(this.f12560e, (Object) null, 0, i4);
            } else {
                l.fill(this.f12560e, (Object) null, i3, i4);
            }
            this.f12558c = i4;
            this.f12559d = size() - i2;
        }
    }

    @Override // d.g0.a, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            d.k0.d.t.checkNotNullExpressionValue(tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = this.f12558c; i3 < size && i4 < this.f12557b; i4++) {
            tArr[i3] = this.f12560e[i4];
            i3++;
        }
        while (i3 < size) {
            tArr[i3] = this.f12560e[i2];
            i3++;
            i2++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }

    public x0(int i2) {
        this(new Object[i2], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g0.a, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}

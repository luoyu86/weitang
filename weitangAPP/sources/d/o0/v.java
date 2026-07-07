package d.o0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class v<T> implements m<T>, e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<T> f12856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12857b;

    public static final class a implements Iterator<T>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator<T> f12859b;

        public a() {
            this.f12858a = v.this.f12857b;
            this.f12859b = v.this.f12856a.iterator();
        }

        public final Iterator<T> getIterator() {
            return this.f12859b;
        }

        public final int getLeft() {
            return this.f12858a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12858a > 0 && this.f12859b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            int i2 = this.f12858a;
            if (i2 == 0) {
                throw new NoSuchElementException();
            }
            this.f12858a = i2 - 1;
            return this.f12859b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setLeft(int i2) {
            this.f12858a = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(m<? extends T> mVar, int i2) {
        d.k0.d.t.checkNotNullParameter(mVar, "sequence");
        this.f12856a = mVar;
        this.f12857b = i2;
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + '.').toString());
    }

    @Override // d.o0.e
    public m<T> drop(int i2) {
        int i3 = this.f12857b;
        return i2 >= i3 ? r.emptySequence() : new u(this.f12856a, i2, i3);
    }

    @Override // d.o0.m
    public Iterator<T> iterator() {
        return new a();
    }

    @Override // d.o0.e
    public m<T> take(int i2) {
        return i2 >= this.f12857b ? this : new v(this.f12856a, i2);
    }
}

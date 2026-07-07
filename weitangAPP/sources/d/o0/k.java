package d.o0;

import d.g0.i0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class k<T> implements m<i0<? extends T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<T> f12758a;

    public static final class a implements Iterator<i0<? extends T>>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f12759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12760b;

        public a() {
            this.f12759a = k.this.f12758a.iterator();
        }

        public final int getIndex() {
            return this.f12760b;
        }

        public final Iterator<T> getIterator() {
            return this.f12759a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12759a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i2) {
            this.f12760b = i2;
        }

        @Override // java.util.Iterator
        public i0<T> next() {
            int i2 = this.f12760b;
            this.f12760b = i2 + 1;
            if (i2 < 0) {
                d.g0.s.throwIndexOverflow();
            }
            return new i0<>(i2, this.f12759a.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "sequence");
        this.f12758a = mVar;
    }

    @Override // d.o0.m
    public Iterator<i0<T>> iterator() {
        return new a();
    }
}

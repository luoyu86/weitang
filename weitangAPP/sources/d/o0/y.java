package d.o0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class y<T, R> implements m<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<T> f12872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.k0.c.l<T, R> f12873b;

    public static final class a implements Iterator<R>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f12874a;

        public a() {
            this.f12874a = y.this.f12872a.iterator();
        }

        public final Iterator<T> getIterator() {
            return this.f12874a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12874a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) y.this.f12873b.invoke(this.f12874a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(m<? extends T> mVar, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "sequence");
        d.k0.d.t.checkNotNullParameter(lVar, "transformer");
        this.f12872a = mVar;
        this.f12873b = lVar;
    }

    public final <E> m<E> flatten$kotlin_stdlib(d.k0.c.l<? super R, ? extends Iterator<? extends E>> lVar) {
        d.k0.d.t.checkNotNullParameter(lVar, "iterator");
        return new i(this.f12872a, this.f12873b, lVar);
    }

    @Override // d.o0.m
    public Iterator<R> iterator() {
        return new a();
    }
}

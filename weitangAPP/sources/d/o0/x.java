package d.o0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class x<T, R> implements m<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<T> f12867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.k0.c.p<Integer, T, R> f12868b;

    public static final class a implements Iterator<R>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f12869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12870b;

        public a() {
            this.f12869a = x.this.f12867a.iterator();
        }

        public final int getIndex() {
            return this.f12870b;
        }

        public final Iterator<T> getIterator() {
            return this.f12869a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12869a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            d.k0.c.p pVar = x.this.f12868b;
            int i2 = this.f12870b;
            this.f12870b = i2 + 1;
            if (i2 < 0) {
                d.g0.s.throwIndexOverflow();
            }
            return (R) pVar.invoke(Integer.valueOf(i2), this.f12869a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i2) {
            this.f12870b = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(m<? extends T> mVar, d.k0.c.p<? super Integer, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "sequence");
        d.k0.d.t.checkNotNullParameter(pVar, "transformer");
        this.f12867a = mVar;
        this.f12868b = pVar;
    }

    @Override // d.o0.m
    public Iterator<R> iterator() {
        return new a();
    }
}

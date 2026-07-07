package d.o0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class l<T1, T2, V> implements m<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<T1> f12762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m<T2> f12763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d.k0.c.p<T1, T2, V> f12764c;

    public static final class a implements Iterator<V>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T1> f12765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator<T2> f12766b;

        public a() {
            this.f12765a = l.this.f12762a.iterator();
            this.f12766b = l.this.f12763b.iterator();
        }

        public final Iterator<T1> getIterator1() {
            return this.f12765a;
        }

        public final Iterator<T2> getIterator2() {
            return this.f12766b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12765a.hasNext() && this.f12766b.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) l.this.f12764c.invoke(this.f12765a.next(), this.f12766b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(m<? extends T1> mVar, m<? extends T2> mVar2, d.k0.c.p<? super T1, ? super T2, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "sequence1");
        d.k0.d.t.checkNotNullParameter(mVar2, "sequence2");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        this.f12762a = mVar;
        this.f12763b = mVar2;
        this.f12764c = pVar;
    }

    @Override // d.o0.m
    public Iterator<V> iterator() {
        return new a();
    }
}

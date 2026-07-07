package d.o0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class f<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<T> f12733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.k0.c.l<T, Boolean> f12734b;

    public static final class a implements Iterator<T>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f12735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12736b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f12737c;

        public a() {
            this.f12735a = f.this.f12733a.iterator();
        }

        public final void a() {
            while (this.f12735a.hasNext()) {
                T next = this.f12735a.next();
                if (!((Boolean) f.this.f12734b.invoke(next)).booleanValue()) {
                    this.f12737c = next;
                    this.f12736b = 1;
                    return;
                }
            }
            this.f12736b = 0;
        }

        public final int getDropState() {
            return this.f12736b;
        }

        public final Iterator<T> getIterator() {
            return this.f12735a;
        }

        public final T getNextItem() {
            return this.f12737c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f12736b == -1) {
                a();
            }
            return this.f12736b == 1 || this.f12735a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f12736b == -1) {
                a();
            }
            if (this.f12736b != 1) {
                return this.f12735a.next();
            }
            T t = this.f12737c;
            this.f12737c = null;
            this.f12736b = 0;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setDropState(int i2) {
            this.f12736b = i2;
        }

        public final void setNextItem(T t) {
            this.f12737c = t;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "sequence");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        this.f12733a = mVar;
        this.f12734b = lVar;
    }

    @Override // d.o0.m
    public Iterator<T> iterator() {
        return new a();
    }
}

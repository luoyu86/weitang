package d.o0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class w<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<T> f12861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.k0.c.l<T, Boolean> f12862b;

    public static final class a implements Iterator<T>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f12863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12864b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f12865c;

        public a() {
            this.f12863a = w.this.f12861a.iterator();
        }

        public final void a() {
            if (this.f12863a.hasNext()) {
                T next = this.f12863a.next();
                if (((Boolean) w.this.f12862b.invoke(next)).booleanValue()) {
                    this.f12864b = 1;
                    this.f12865c = next;
                    return;
                }
            }
            this.f12864b = 0;
        }

        public final Iterator<T> getIterator() {
            return this.f12863a;
        }

        public final T getNextItem() {
            return this.f12865c;
        }

        public final int getNextState() {
            return this.f12864b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f12864b == -1) {
                a();
            }
            return this.f12864b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f12864b == -1) {
                a();
            }
            if (this.f12864b == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f12865c;
            this.f12865c = null;
            this.f12864b = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setNextItem(T t) {
            this.f12865c = t;
        }

        public final void setNextState(int i2) {
            this.f12864b = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(m<? extends T> mVar, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "sequence");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        this.f12861a = mVar;
        this.f12862b = lVar;
    }

    @Override // d.o0.m
    public Iterator<T> iterator() {
        return new a();
    }
}

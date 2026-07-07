package d.o0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class j<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.k0.c.a<T> f12753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.k0.c.l<T, T> f12754b;

    public static final class a implements Iterator<T>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f12755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12756b = -2;

        public a() {
        }

        public final void a() {
            T t;
            if (this.f12756b == -2) {
                t = (T) j.this.f12753a.invoke();
            } else {
                d.k0.c.l lVar = j.this.f12754b;
                T t2 = this.f12755a;
                d.k0.d.t.checkNotNull(t2);
                t = (T) lVar.invoke(t2);
            }
            this.f12755a = t;
            this.f12756b = t == null ? 0 : 1;
        }

        public final T getNextItem() {
            return this.f12755a;
        }

        public final int getNextState() {
            return this.f12756b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f12756b < 0) {
                a();
            }
            return this.f12756b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f12756b < 0) {
                a();
            }
            if (this.f12756b == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f12755a;
            Objects.requireNonNull(t, "null cannot be cast to non-null type T");
            this.f12756b = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setNextItem(T t) {
            this.f12755a = t;
        }

        public final void setNextState(int i2) {
            this.f12756b = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(d.k0.c.a<? extends T> aVar, d.k0.c.l<? super T, ? extends T> lVar) {
        d.k0.d.t.checkNotNullParameter(aVar, "getInitialValue");
        d.k0.d.t.checkNotNullParameter(lVar, "getNextValue");
        this.f12753a = aVar;
        this.f12754b = lVar;
    }

    @Override // d.o0.m
    public Iterator<T> iterator() {
        return new a();
    }
}

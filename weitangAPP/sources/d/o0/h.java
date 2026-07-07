package d.o0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class h<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<T> f12740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d.k0.c.l<T, Boolean> f12742c;

    public static final class a implements Iterator<T>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f12743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12744b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f12745c;

        public a() {
            this.f12743a = h.this.f12740a.iterator();
        }

        public final void a() {
            while (this.f12743a.hasNext()) {
                T next = this.f12743a.next();
                if (((Boolean) h.this.f12742c.invoke(next)).booleanValue() == h.this.f12741b) {
                    this.f12745c = next;
                    this.f12744b = 1;
                    return;
                }
            }
            this.f12744b = 0;
        }

        public final Iterator<T> getIterator() {
            return this.f12743a;
        }

        public final T getNextItem() {
            return this.f12745c;
        }

        public final int getNextState() {
            return this.f12744b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f12744b == -1) {
                a();
            }
            return this.f12744b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f12744b == -1) {
                a();
            }
            if (this.f12744b == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f12745c;
            this.f12745c = null;
            this.f12744b = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setNextItem(T t) {
            this.f12745c = t;
        }

        public final void setNextState(int i2) {
            this.f12744b = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(m<? extends T> mVar, boolean z, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "sequence");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        this.f12740a = mVar;
        this.f12741b = z;
        this.f12742c = lVar;
    }

    @Override // d.o0.m
    public Iterator<T> iterator() {
        return new a();
    }

    public /* synthetic */ h(m mVar, boolean z, d.k0.c.l lVar, int i2, d.k0.d.p pVar) {
        this(mVar, (i2 & 2) != 0 ? true : z, lVar);
    }
}

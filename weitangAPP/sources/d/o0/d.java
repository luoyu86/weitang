package d.o0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class d<T> implements m<T>, e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<T> f12728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12729b;

    public static final class a implements Iterator<T>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f12730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12731b;

        public a() {
            this.f12730a = d.this.f12728a.iterator();
            this.f12731b = d.this.f12729b;
        }

        public final void a() {
            while (this.f12731b > 0 && this.f12730a.hasNext()) {
                this.f12730a.next();
                this.f12731b--;
            }
        }

        public final Iterator<T> getIterator() {
            return this.f12730a;
        }

        public final int getLeft() {
            return this.f12731b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f12730a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.f12730a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setLeft(int i2) {
            this.f12731b = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(m<? extends T> mVar, int i2) {
        d.k0.d.t.checkNotNullParameter(mVar, "sequence");
        this.f12728a = mVar;
        this.f12729b = i2;
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + '.').toString());
    }

    @Override // d.o0.e
    public m<T> drop(int i2) {
        int i3 = this.f12729b + i2;
        return i3 < 0 ? new d(this, i2) : new d(this.f12728a, i3);
    }

    @Override // d.o0.m
    public Iterator<T> iterator() {
        return new a();
    }

    @Override // d.o0.e
    public m<T> take(int i2) {
        int i3 = this.f12729b;
        int i4 = i3 + i2;
        return i4 < 0 ? new v(this, i2) : new u(this.f12728a, i3, i4);
    }
}

package d.o0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class u<T> implements m<T>, e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<T> f12850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12852c;

    public static final class a implements Iterator<T>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f12853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12854b;

        public a() {
            this.f12853a = u.this.f12850a.iterator();
        }

        public final void a() {
            while (this.f12854b < u.this.f12851b && this.f12853a.hasNext()) {
                this.f12853a.next();
                this.f12854b++;
            }
        }

        public final Iterator<T> getIterator() {
            return this.f12853a;
        }

        public final int getPosition() {
            return this.f12854b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f12854b < u.this.f12852c && this.f12853a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (this.f12854b >= u.this.f12852c) {
                throw new NoSuchElementException();
            }
            this.f12854b++;
            return this.f12853a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setPosition(int i2) {
            this.f12854b = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(m<? extends T> mVar, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(mVar, "sequence");
        this.f12850a = mVar;
        this.f12851b = i2;
        this.f12852c = i3;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i2).toString());
        }
        if (!(i3 >= 0)) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i3).toString());
        }
        if (i3 >= i2) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i3 + " < " + i2).toString());
    }

    public final int a() {
        return this.f12852c - this.f12851b;
    }

    @Override // d.o0.e
    public m<T> drop(int i2) {
        return i2 >= a() ? r.emptySequence() : new u(this.f12850a, this.f12851b + i2, this.f12852c);
    }

    @Override // d.o0.m
    public Iterator<T> iterator() {
        return new a();
    }

    @Override // d.o0.e
    public m<T> take(int i2) {
        if (i2 >= a()) {
            return this;
        }
        m<T> mVar = this.f12850a;
        int i3 = this.f12851b;
        return new u(mVar, i3, i2 + i3);
    }
}

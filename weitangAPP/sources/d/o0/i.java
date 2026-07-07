package d.o0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class i<T, R, E> implements m<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<T> f12747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.k0.c.l<T, R> f12748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d.k0.c.l<R, Iterator<E>> f12749c;

    public static final class a implements Iterator<E>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f12750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator<? extends E> f12751b;

        public a() {
            this.f12750a = i.this.f12747a.iterator();
        }

        public final boolean a() {
            Iterator<? extends E> it = this.f12751b;
            if (it != null && !it.hasNext()) {
                this.f12751b = null;
            }
            while (true) {
                if (this.f12751b != null) {
                    break;
                }
                if (!this.f12750a.hasNext()) {
                    return false;
                }
                Iterator<? extends E> it2 = (Iterator) i.this.f12749c.invoke(i.this.f12748b.invoke(this.f12750a.next()));
                if (it2.hasNext()) {
                    this.f12751b = it2;
                    break;
                }
            }
            return true;
        }

        public final Iterator<E> getItemIterator() {
            return this.f12751b;
        }

        public final Iterator<T> getIterator() {
            return this.f12750a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return a();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends E> it = this.f12751b;
            d.k0.d.t.checkNotNull(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setItemIterator(Iterator<? extends E> it) {
            this.f12751b = it;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(m<? extends T> mVar, d.k0.c.l<? super T, ? extends R> lVar, d.k0.c.l<? super R, ? extends Iterator<? extends E>> lVar2) {
        d.k0.d.t.checkNotNullParameter(mVar, "sequence");
        d.k0.d.t.checkNotNullParameter(lVar, "transformer");
        d.k0.d.t.checkNotNullParameter(lVar2, "iterator");
        this.f12747a = mVar;
        this.f12748b = lVar;
        this.f12749c = lVar2;
    }

    @Override // d.o0.m
    public Iterator<E> iterator() {
        return new a();
    }
}

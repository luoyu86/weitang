package d.o0;

import d.d0;
import d.n;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class n<T> extends o<T> implements Iterator<T>, d.i0.a<d0>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f12769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator<? extends T> f12770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d.i0.a<? super d0> f12771d;

    public final Throwable a() {
        int i2 = this.f12768a;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f12768a);
    }

    public final T b() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // d.i0.a
    public d.i0.c getContext() {
        return d.i0.d.INSTANCE;
    }

    public final d.i0.a<d0> getNextStep() {
        return this.f12771d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i2 = this.f12768a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return true;
                    }
                    if (i2 == 4) {
                        return false;
                    }
                    throw a();
                }
                Iterator<? extends T> it = this.f12770c;
                d.k0.d.t.checkNotNull(it);
                if (it.hasNext()) {
                    this.f12768a = 2;
                    return true;
                }
                this.f12770c = null;
            }
            this.f12768a = 5;
            d.i0.a<? super d0> aVar = this.f12771d;
            d.k0.d.t.checkNotNull(aVar);
            this.f12771d = null;
            d0 d0Var = d0.f12421a;
            n.a aVar2 = d.n.Companion;
            aVar.resumeWith(d.n.m379constructorimpl(d0Var));
        }
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i2 = this.f12768a;
        if (i2 == 0 || i2 == 1) {
            return b();
        }
        if (i2 == 2) {
            this.f12768a = 1;
            Iterator<? extends T> it = this.f12770c;
            d.k0.d.t.checkNotNull(it);
            return it.next();
        }
        if (i2 != 3) {
            throw a();
        }
        this.f12768a = 0;
        T t = this.f12769b;
        this.f12769b = null;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // d.i0.a
    public void resumeWith(Object obj) {
        d.o.throwOnFailure(obj);
        this.f12768a = 4;
    }

    public final void setNextStep(d.i0.a<? super d0> aVar) {
        this.f12771d = aVar;
    }

    @Override // d.o0.o
    public Object yield(T t, d.i0.a<? super d0> aVar) {
        this.f12769b = t;
        this.f12768a = 3;
        this.f12771d = aVar;
        Object coroutine_suspended = d.i0.e.c.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == d.i0.e.c.getCOROUTINE_SUSPENDED()) {
            d.i0.f.a.h.probeCoroutineSuspended(aVar);
        }
        return coroutine_suspended == d.i0.e.c.getCOROUTINE_SUSPENDED() ? coroutine_suspended : d0.f12421a;
    }

    @Override // d.o0.o
    public Object yieldAll(Iterator<? extends T> it, d.i0.a<? super d0> aVar) {
        if (!it.hasNext()) {
            return d0.f12421a;
        }
        this.f12770c = it;
        this.f12768a = 2;
        this.f12771d = aVar;
        Object coroutine_suspended = d.i0.e.c.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == d.i0.e.c.getCOROUTINE_SUSPENDED()) {
            d.i0.f.a.h.probeCoroutineSuspended(aVar);
        }
        return coroutine_suspended == d.i0.e.c.getCOROUTINE_SUSPENDED() ? coroutine_suspended : d0.f12421a;
    }
}

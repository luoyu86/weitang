package d.g0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> implements Iterator<T>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c1 f12450a = c1.NotReady;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f12451b;

    public abstract void a();

    public final void b() {
        this.f12450a = c1.Done;
    }

    public final void c(T t) {
        this.f12451b = t;
        this.f12450a = c1.Ready;
    }

    public final boolean d() {
        this.f12450a = c1.Failed;
        a();
        return this.f12450a == c1.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        c1 c1Var = this.f12450a;
        if (!(c1Var != c1.Failed)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i2 = b.f12437a[c1Var.ordinal()];
        if (i2 == 1) {
            return false;
        }
        if (i2 != 2) {
            return d();
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f12450a = c1.NotReady;
        return this.f12451b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

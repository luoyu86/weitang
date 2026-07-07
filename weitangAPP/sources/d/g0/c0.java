package d.g0;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements ListIterator, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f12452a = new c0();

    @Override // java.util.ListIterator
    public /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return false;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void set(Void r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Void next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public Void previous() {
        throw new NoSuchElementException();
    }
}

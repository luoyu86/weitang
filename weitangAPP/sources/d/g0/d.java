package d.g0;

import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<E> extends d.g0.a<E> implements List<E>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12454a = new a(null);

    public static final class a {
        public a() {
        }

        public final void checkBoundsIndexes$kotlin_stdlib(int i2, int i3, int i4) {
            if (i2 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("startIndex: " + i2 + ", endIndex: " + i3 + ", size: " + i4);
            }
            if (i2 <= i3) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i2 + " > endIndex: " + i3);
        }

        public final void checkElementIndex$kotlin_stdlib(int i2, int i3) {
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final void checkPositionIndex$kotlin_stdlib(int i2, int i3) {
            if (i2 < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final void checkRangeIndexes$kotlin_stdlib(int i2, int i3, int i4) {
            if (i2 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3 + ", size: " + i4);
            }
            if (i2 <= i3) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i2 + " > toIndex: " + i3);
        }

        public final boolean orderedEquals$kotlin_stdlib(Collection<?> collection, Collection<?> collection2) {
            d.k0.d.t.checkNotNullParameter(collection, OperatorName.CURVE_TO);
            d.k0.d.t.checkNotNullParameter(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!d.k0.d.t.areEqual(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int orderedHashCode$kotlin_stdlib(Collection<?> collection) {
            d.k0.d.t.checkNotNullParameter(collection, OperatorName.CURVE_TO);
            Iterator<?> it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public class b implements Iterator<E>, d.k0.d.n0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12455a;

        public b() {
        }

        public final int a() {
            return this.f12455a;
        }

        public final void b(int i2) {
            this.f12455a = i2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12455a < d.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            d dVar = d.this;
            int i2 = this.f12455a;
            this.f12455a = i2 + 1;
            return (E) dVar.get(i2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public class c extends d<E>.b implements ListIterator<E>, d.k0.d.n0.a {
        public c(int i2) {
            super();
            d.f12454a.checkPositionIndex$kotlin_stdlib(i2, d.this.size());
            b(i2);
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            d dVar = d.this;
            b(a() - 1);
            return (E) dVar.get(a());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: d.g0.d$d, reason: collision with other inner class name */
    public static final class C0232d<E> extends d<E> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d<E> f12459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f12460d;

        /* JADX WARN: Multi-variable type inference failed */
        public C0232d(d<? extends E> dVar, int i2, int i3) {
            d.k0.d.t.checkNotNullParameter(dVar, "list");
            this.f12459c = dVar;
            this.f12460d = i2;
            d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, dVar.size());
            this.f12458b = i3 - i2;
        }

        @Override // d.g0.d, java.util.List
        public E get(int i2) {
            d.f12454a.checkElementIndex$kotlin_stdlib(i2, this.f12458b);
            return this.f12459c.get(this.f12460d + i2);
        }

        @Override // d.g0.d, d.g0.a
        public int getSize() {
            return this.f12458b;
        }
    }

    @Override // java.util.List
    public void add(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f12454a.orderedEquals$kotlin_stdlib(this, (Collection) obj);
        }
        return false;
    }

    @Override // java.util.List
    public abstract E get(int i2);

    @Override // d.g0.a
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f12454a.orderedHashCode$kotlin_stdlib(this);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Iterator<E> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (d.k0.d.t.areEqual(it.next(), obj)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // d.g0.a, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new b();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (d.k0.d.t.areEqual(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i2, int i3) {
        return new C0232d(this, i2, i3);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i2) {
        return new c(i2);
    }
}

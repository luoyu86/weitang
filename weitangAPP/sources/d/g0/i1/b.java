package d.g0.i1;

import d.g0.i;
import d.g0.l;
import d.k0.d.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class b<E> extends d.g0.f<E> implements List<E>, RandomAccess, d.k0.d.n0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public E[] f12470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b<E> f12474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b<E> f12475f;

    public static final class a<E> implements ListIterator<E>, d.k0.d.n0.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b<E> f12476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12478c;

        public a(b<E> bVar, int i2) {
            t.checkNotNullParameter(bVar, "list");
            this.f12476a = bVar;
            this.f12477b = i2;
            this.f12478c = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            b<E> bVar = this.f12476a;
            int i2 = this.f12477b;
            this.f12477b = i2 + 1;
            bVar.add(i2, e2);
            this.f12478c = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f12477b < this.f12476a.f12472c;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f12477b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.f12477b >= this.f12476a.f12472c) {
                throw new NoSuchElementException();
            }
            int i2 = this.f12477b;
            this.f12477b = i2 + 1;
            this.f12478c = i2;
            return (E) this.f12476a.f12470a[this.f12476a.f12471b + this.f12478c];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f12477b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i2 = this.f12477b;
            if (i2 <= 0) {
                throw new NoSuchElementException();
            }
            int i3 = i2 - 1;
            this.f12477b = i3;
            this.f12478c = i3;
            return (E) this.f12476a.f12470a[this.f12476a.f12471b + this.f12478c];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f12477b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i2 = this.f12478c;
            if (!(i2 != -1)) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.f12476a.remove(i2);
            this.f12477b = this.f12478c;
            this.f12478c = -1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            int i2 = this.f12478c;
            if (!(i2 != -1)) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.f12476a.set(i2, e2);
        }
    }

    public b(E[] eArr, int i2, int i3, boolean z, b<E> bVar, b<E> bVar2) {
        this.f12470a = eArr;
        this.f12471b = i2;
        this.f12472c = i3;
        this.f12473d = z;
        this.f12474e = bVar;
        this.f12475f = bVar2;
    }

    public final void a(int i2, Collection<? extends E> collection, int i3) {
        b<E> bVar = this.f12474e;
        if (bVar != null) {
            bVar.a(i2, collection, i3);
            this.f12470a = this.f12474e.f12470a;
            this.f12472c += i3;
        } else {
            g(i2, i3);
            Iterator<? extends E> it = collection.iterator();
            for (int i4 = 0; i4 < i3; i4++) {
                this.f12470a[i2 + i4] = it.next();
            }
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        c();
        b(this.f12471b + this.f12472c, e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        t.checkNotNullParameter(collection, "elements");
        c();
        int size = collection.size();
        a(this.f12471b + this.f12472c, collection, size);
        return size > 0;
    }

    public final void b(int i2, E e2) {
        b<E> bVar = this.f12474e;
        if (bVar == null) {
            g(i2, 1);
            this.f12470a[i2] = e2;
        } else {
            bVar.b(i2, e2);
            this.f12470a = this.f12474e.f12470a;
            this.f12472c++;
        }
    }

    public final List<E> build() {
        if (this.f12474e != null) {
            throw new IllegalStateException();
        }
        c();
        this.f12473d = true;
        return this;
    }

    public final void c() {
        b<E> bVar;
        if (this.f12473d || ((bVar = this.f12475f) != null && bVar.f12473d)) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        c();
        i(this.f12471b, this.f12472c);
    }

    public final boolean d(List<?> list) {
        return c.a(this.f12470a, this.f12471b, this.f12472c, list);
    }

    public final void e(int i2) {
        if (this.f12474e != null) {
            throw new IllegalStateException();
        }
        E[] eArr = this.f12470a;
        if (i2 > eArr.length) {
            this.f12470a = (E[]) c.copyOfUninitializedElements(this.f12470a, i.f12464b.newCapacity$kotlin_stdlib(eArr.length, i2));
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof List) && d((List) obj));
    }

    public final void f(int i2) {
        e(this.f12472c + i2);
    }

    public final void g(int i2, int i3) {
        f(i3);
        E[] eArr = this.f12470a;
        l.copyInto(eArr, eArr, i2 + i3, i2, this.f12471b + this.f12472c);
        this.f12472c += i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        d.g0.d.f12454a.checkElementIndex$kotlin_stdlib(i2, this.f12472c);
        return this.f12470a[this.f12471b + i2];
    }

    @Override // d.g0.f
    public int getSize() {
        return this.f12472c;
    }

    public final E h(int i2) {
        b<E> bVar = this.f12474e;
        if (bVar != null) {
            this.f12472c--;
            return bVar.h(i2);
        }
        E[] eArr = this.f12470a;
        E e2 = eArr[i2];
        l.copyInto(eArr, eArr, i2, i2 + 1, this.f12471b + this.f12472c);
        c.resetAt(this.f12470a, (this.f12471b + this.f12472c) - 1);
        this.f12472c--;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return c.b(this.f12470a, this.f12471b, this.f12472c);
    }

    public final void i(int i2, int i3) {
        b<E> bVar = this.f12474e;
        if (bVar != null) {
            bVar.i(i2, i3);
        } else {
            E[] eArr = this.f12470a;
            l.copyInto(eArr, eArr, i2, i2 + i3, this.f12472c);
            E[] eArr2 = this.f12470a;
            int i4 = this.f12472c;
            c.resetRange(eArr2, i4 - i3, i4);
        }
        this.f12472c -= i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i2 = 0; i2 < this.f12472c; i2++) {
            if (t.areEqual(this.f12470a[this.f12471b + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.f12472c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new a(this, 0);
    }

    public final int j(int i2, int i3, Collection<? extends E> collection, boolean z) {
        b<E> bVar = this.f12474e;
        if (bVar != null) {
            int iJ = bVar.j(i2, i3, collection, z);
            this.f12472c -= iJ;
            return iJ;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i2 + i4;
            if (collection.contains(this.f12470a[i6]) == z) {
                E[] eArr = this.f12470a;
                i4++;
                eArr[i5 + i2] = eArr[i6];
                i5++;
            } else {
                i4++;
            }
        }
        int i7 = i3 - i5;
        E[] eArr2 = this.f12470a;
        l.copyInto(eArr2, eArr2, i2 + i5, i3 + i2, this.f12472c);
        E[] eArr3 = this.f12470a;
        int i8 = this.f12472c;
        c.resetRange(eArr3, i8 - i7, i8);
        this.f12472c -= i7;
        return i7;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i2 = this.f12472c - 1; i2 >= 0; i2--) {
            if (t.areEqual(this.f12470a[this.f12471b + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        c();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> collection) {
        t.checkNotNullParameter(collection, "elements");
        c();
        return j(this.f12471b, this.f12472c, collection, false) > 0;
    }

    @Override // d.g0.f
    public E removeAt(int i2) {
        c();
        d.g0.d.f12454a.checkElementIndex$kotlin_stdlib(i2, this.f12472c);
        return h(this.f12471b + i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> collection) {
        t.checkNotNullParameter(collection, "elements");
        c();
        return j(this.f12471b, this.f12472c, collection, true) > 0;
    }

    @Override // d.g0.f, java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        c();
        d.g0.d.f12454a.checkElementIndex$kotlin_stdlib(i2, this.f12472c);
        E[] eArr = this.f12470a;
        int i3 = this.f12471b;
        E e3 = eArr[i3 + i2];
        eArr[i3 + i2] = e2;
        return e3;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i2, int i3) {
        d.g0.d.f12454a.checkRangeIndexes$kotlin_stdlib(i2, i3, this.f12472c);
        E[] eArr = this.f12470a;
        int i4 = this.f12471b + i2;
        int i5 = i3 - i2;
        boolean z = this.f12473d;
        b<E> bVar = this.f12475f;
        return new b(eArr, i4, i5, z, this, bVar != null ? bVar : this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return c.c(this.f12470a, this.f12471b, this.f12472c);
    }

    public b() {
        this(10);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i2) {
        d.g0.d.f12454a.checkPositionIndex$kotlin_stdlib(i2, this.f12472c);
        return new a(this, i2);
    }

    public b(int i2) {
        this(c.arrayOfUninitializedElements(i2), 0, 0, false, null, null);
    }

    @Override // d.g0.f, java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        c();
        d.g0.d.f12454a.checkPositionIndex$kotlin_stdlib(i2, this.f12472c);
        b(this.f12471b + i2, e2);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection<? extends E> collection) {
        t.checkNotNullParameter(collection, "elements");
        c();
        d.g0.d.f12454a.checkPositionIndex$kotlin_stdlib(i2, this.f12472c);
        int size = collection.size();
        a(this.f12471b + i2, collection, size);
        return size > 0;
    }
}

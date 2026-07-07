package d.g0;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class i<E> extends f<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object[] f12466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12467e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12464b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f12463a = new Object[0];

    public static final class a {
        public a() {
        }

        public final int newCapacity$kotlin_stdlib(int i2, int i3) {
            int i4 = i2 + (i2 >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            if (i4 - 2147483639 <= 0) {
                return i4;
            }
            if (i3 > 2147483639) {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            return 2147483639;
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public i(int i2) {
        Object[] objArr;
        if (i2 == 0) {
            objArr = f12463a;
        } else {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i2);
            }
            objArr = new Object[i2];
        }
        this.f12466d = objArr;
    }

    public final void a(int i2, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f12466d.length;
        while (i2 < length && it.hasNext()) {
            this.f12466d[i2] = it.next();
            i2++;
        }
        int i3 = this.f12465c;
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            this.f12466d[i4] = it.next();
        }
        this.f12467e = size() + collection.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        d(size() + collection.size());
        a(g(this.f12465c + size()), collection);
        return true;
    }

    public final void addFirst(E e2) {
        d(size() + 1);
        int iC = c(this.f12465c);
        this.f12465c = iC;
        this.f12466d[iC] = e2;
        this.f12467e = size() + 1;
    }

    public final void addLast(E e2) {
        d(size() + 1);
        this.f12466d[g(this.f12465c + size())] = e2;
        this.f12467e = size() + 1;
    }

    public final void b(int i2) {
        Object[] objArr = new Object[i2];
        Object[] objArr2 = this.f12466d;
        l.copyInto(objArr2, objArr, 0, this.f12465c, objArr2.length);
        Object[] objArr3 = this.f12466d;
        int length = objArr3.length;
        int i3 = this.f12465c;
        l.copyInto(objArr3, objArr, length - i3, 0, i3);
        this.f12465c = 0;
        this.f12466d = objArr;
    }

    public final int c(int i2) {
        return i2 == 0 ? m.getLastIndex(this.f12466d) : i2 - 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int iG = g(this.f12465c + size());
        int i2 = this.f12465c;
        if (i2 < iG) {
            l.fill(this.f12466d, (Object) null, i2, iG);
        } else if (!isEmpty()) {
            Object[] objArr = this.f12466d;
            l.fill(objArr, (Object) null, this.f12465c, objArr.length);
            l.fill(this.f12466d, (Object) null, 0, iG);
        }
        this.f12465c = 0;
        this.f12467e = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f12466d;
        if (i2 <= objArr.length) {
            return;
        }
        if (objArr == f12463a) {
            this.f12466d = new Object[d.m0.p.coerceAtLeast(i2, 10)];
        } else {
            b(f12464b.newCapacity$kotlin_stdlib(objArr.length, i2));
        }
    }

    public final int e(int i2) {
        if (i2 == m.getLastIndex(this.f12466d)) {
            return 0;
        }
        return i2 + 1;
    }

    public final int f(int i2) {
        return i2 < 0 ? i2 + this.f12466d.length : i2;
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f12466d[this.f12465c];
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f12466d[this.f12465c];
    }

    public final int g(int i2) {
        Object[] objArr = this.f12466d;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        d.f12454a.checkElementIndex$kotlin_stdlib(i2, size());
        return (E) this.f12466d[g(this.f12465c + i2)];
    }

    @Override // d.g0.f
    public int getSize() {
        return this.f12467e;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i2;
        int iG = g(this.f12465c + size());
        int length = this.f12465c;
        if (length < iG) {
            while (length < iG) {
                if (d.k0.d.t.areEqual(obj, this.f12466d[length])) {
                    i2 = this.f12465c;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iG) {
            return -1;
        }
        int length2 = this.f12466d.length;
        while (true) {
            if (length >= length2) {
                for (int i3 = 0; i3 < iG; i3++) {
                    if (d.k0.d.t.areEqual(obj, this.f12466d[i3])) {
                        length = i3 + this.f12466d.length;
                        i2 = this.f12465c;
                    }
                }
                return -1;
            }
            if (d.k0.d.t.areEqual(obj, this.f12466d[length])) {
                i2 = this.f12465c;
                break;
            }
            length++;
        }
        return length - i2;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.lang.Object[]] */
    public final void internalStructure$kotlin_stdlib(d.k0.c.p<? super Integer, ? super Object[], d.d0> pVar) {
        d.k0.d.t.checkNotNullParameter(pVar, "structure");
        int iG = g(this.f12465c + size());
        if (isEmpty()) {
            pVar.invoke(Integer.valueOf(this.f12465c), new Object[0]);
            return;
        }
        ?? r0 = new Object[size()];
        int i2 = this.f12465c;
        if (i2 < iG) {
            l.copyInto$default(this.f12466d, (Object[]) r0, 0, i2, iG, 2, (Object) null);
            pVar.invoke(Integer.valueOf(this.f12465c), r0);
        } else {
            l.copyInto$default(this.f12466d, (Object[]) r0, 0, i2, 0, 10, (Object) null);
            Object[] objArr = this.f12466d;
            l.copyInto(objArr, (Object[]) r0, objArr.length - this.f12465c, 0, iG);
            pVar.invoke(Integer.valueOf(this.f12465c - this.f12466d.length), r0);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f12466d[g(this.f12465c + s.getLastIndex(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int lastIndex;
        int i2;
        int iG = g(this.f12465c + size());
        int i3 = this.f12465c;
        if (i3 < iG) {
            lastIndex = iG - 1;
            if (lastIndex < i3) {
                return -1;
            }
            while (!d.k0.d.t.areEqual(obj, this.f12466d[lastIndex])) {
                if (lastIndex == i3) {
                    return -1;
                }
                lastIndex--;
            }
            i2 = this.f12465c;
        } else {
            if (i3 <= iG) {
                return -1;
            }
            int i4 = iG - 1;
            while (true) {
                if (i4 < 0) {
                    lastIndex = m.getLastIndex(this.f12466d);
                    int i5 = this.f12465c;
                    if (lastIndex < i5) {
                        return -1;
                    }
                    while (!d.k0.d.t.areEqual(obj, this.f12466d[lastIndex])) {
                        if (lastIndex == i5) {
                            return -1;
                        }
                        lastIndex--;
                    }
                    i2 = this.f12465c;
                } else {
                    if (d.k0.d.t.areEqual(obj, this.f12466d[i4])) {
                        lastIndex = i4 + this.f12466d.length;
                        i2 = this.f12465c;
                        break;
                    }
                    i4--;
                }
            }
        }
        return lastIndex - i2;
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f12466d[g(this.f12465c + s.getLastIndex(this))];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.f12466d.length == 0)) {
                int iG = g(this.f12465c + size());
                int iG2 = this.f12465c;
                if (this.f12465c < iG) {
                    for (int i2 = this.f12465c; i2 < iG; i2++) {
                        Object obj = this.f12466d[i2];
                        if (!collection.contains(obj)) {
                            this.f12466d[iG2] = obj;
                            iG2++;
                        } else {
                            z = true;
                        }
                    }
                    l.fill(this.f12466d, (Object) null, iG2, iG);
                } else {
                    int length = this.f12466d.length;
                    boolean z2 = false;
                    for (int i3 = this.f12465c; i3 < length; i3++) {
                        Object obj2 = this.f12466d[i3];
                        this.f12466d[i3] = null;
                        if (!collection.contains(obj2)) {
                            this.f12466d[iG2] = obj2;
                            iG2++;
                        } else {
                            z2 = true;
                        }
                    }
                    iG2 = g(iG2);
                    for (int i4 = 0; i4 < iG; i4++) {
                        Object obj3 = this.f12466d[i4];
                        this.f12466d[i4] = null;
                        if (!collection.contains(obj3)) {
                            this.f12466d[iG2] = obj3;
                            iG2 = e(iG2);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f12467e = f(iG2 - this.f12465c);
                }
            }
        }
        return z;
    }

    @Override // d.g0.f
    public E removeAt(int i2) {
        d.f12454a.checkElementIndex$kotlin_stdlib(i2, size());
        if (i2 == s.getLastIndex(this)) {
            return removeLast();
        }
        if (i2 == 0) {
            return removeFirst();
        }
        int iG = g(this.f12465c + i2);
        E e2 = (E) this.f12466d[iG];
        if (i2 < (size() >> 1)) {
            int i3 = this.f12465c;
            if (iG >= i3) {
                Object[] objArr = this.f12466d;
                l.copyInto(objArr, objArr, i3 + 1, i3, iG);
            } else {
                Object[] objArr2 = this.f12466d;
                l.copyInto(objArr2, objArr2, 1, 0, iG);
                Object[] objArr3 = this.f12466d;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i4 = this.f12465c;
                l.copyInto(objArr3, objArr3, i4 + 1, i4, objArr3.length - 1);
            }
            Object[] objArr4 = this.f12466d;
            int i5 = this.f12465c;
            objArr4[i5] = null;
            this.f12465c = e(i5);
        } else {
            int iG2 = g(this.f12465c + s.getLastIndex(this));
            if (iG <= iG2) {
                Object[] objArr5 = this.f12466d;
                l.copyInto(objArr5, objArr5, iG, iG + 1, iG2 + 1);
            } else {
                Object[] objArr6 = this.f12466d;
                l.copyInto(objArr6, objArr6, iG, iG + 1, objArr6.length);
                Object[] objArr7 = this.f12466d;
                objArr7[objArr7.length - 1] = objArr7[0];
                l.copyInto(objArr7, objArr7, 0, 1, iG2 + 1);
            }
            this.f12466d[iG2] = null;
        }
        this.f12467e = size() - 1;
        return e2;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        E e2 = (E) this.f12466d[this.f12465c];
        Object[] objArr = this.f12466d;
        int i2 = this.f12465c;
        objArr[i2] = null;
        this.f12465c = e(i2);
        this.f12467e = size() - 1;
        return e2;
    }

    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int iG = g(this.f12465c + s.getLastIndex(this));
        E e2 = (E) this.f12466d[iG];
        this.f12466d[iG] = null;
        this.f12467e = size() - 1;
        return e2;
    }

    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.f12466d.length == 0)) {
                int iG = g(this.f12465c + size());
                int iG2 = this.f12465c;
                if (this.f12465c < iG) {
                    for (int i2 = this.f12465c; i2 < iG; i2++) {
                        Object obj = this.f12466d[i2];
                        if (collection.contains(obj)) {
                            this.f12466d[iG2] = obj;
                            iG2++;
                        } else {
                            z = true;
                        }
                    }
                    l.fill(this.f12466d, (Object) null, iG2, iG);
                } else {
                    int length = this.f12466d.length;
                    boolean z2 = false;
                    for (int i3 = this.f12465c; i3 < length; i3++) {
                        Object obj2 = this.f12466d[i3];
                        this.f12466d[i3] = null;
                        if (collection.contains(obj2)) {
                            this.f12466d[iG2] = obj2;
                            iG2++;
                        } else {
                            z2 = true;
                        }
                    }
                    iG2 = g(iG2);
                    for (int i4 = 0; i4 < iG; i4++) {
                        Object obj3 = this.f12466d[i4];
                        this.f12466d[i4] = null;
                        if (collection.contains(obj3)) {
                            this.f12466d[iG2] = obj3;
                            iG2 = e(iG2);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f12467e = f(iG2 - this.f12465c);
                }
            }
        }
        return z;
    }

    @Override // d.g0.f, java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        d.f12454a.checkElementIndex$kotlin_stdlib(i2, size());
        int iG = g(this.f12465c + i2);
        E e3 = (E) this.f12466d[iG];
        this.f12466d[iG] = e2;
        return e3;
    }

    @Override // d.g0.f, java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        d.f12454a.checkPositionIndex$kotlin_stdlib(i2, size());
        if (i2 == size()) {
            addLast(e2);
            return;
        }
        if (i2 == 0) {
            addFirst(e2);
            return;
        }
        d(size() + 1);
        int iG = g(this.f12465c + i2);
        if (i2 < ((size() + 1) >> 1)) {
            int iC = c(iG);
            int iC2 = c(this.f12465c);
            int i3 = this.f12465c;
            if (iC >= i3) {
                Object[] objArr = this.f12466d;
                objArr[iC2] = objArr[i3];
                l.copyInto(objArr, objArr, i3, i3 + 1, iC + 1);
            } else {
                Object[] objArr2 = this.f12466d;
                l.copyInto(objArr2, objArr2, i3 - 1, i3, objArr2.length);
                Object[] objArr3 = this.f12466d;
                objArr3[objArr3.length - 1] = objArr3[0];
                l.copyInto(objArr3, objArr3, 0, 1, iC + 1);
            }
            this.f12466d[iC] = e2;
            this.f12465c = iC2;
        } else {
            int iG2 = g(this.f12465c + size());
            if (iG < iG2) {
                Object[] objArr4 = this.f12466d;
                l.copyInto(objArr4, objArr4, iG + 1, iG, iG2);
            } else {
                Object[] objArr5 = this.f12466d;
                l.copyInto(objArr5, objArr5, 1, 0, iG2);
                Object[] objArr6 = this.f12466d;
                objArr6[0] = objArr6[objArr6.length - 1];
                l.copyInto(objArr6, objArr6, iG + 1, iG, objArr6.length - 1);
            }
            this.f12466d[iG] = e2;
        }
        this.f12467e = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection<? extends E> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        d.f12454a.checkPositionIndex$kotlin_stdlib(i2, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i2 == size()) {
            return addAll(collection);
        }
        d(size() + collection.size());
        int iG = g(this.f12465c + size());
        int iG2 = g(this.f12465c + i2);
        int size = collection.size();
        if (i2 < ((size() + 1) >> 1)) {
            int i3 = this.f12465c;
            int length = i3 - size;
            if (iG2 < i3) {
                Object[] objArr = this.f12466d;
                l.copyInto(objArr, objArr, length, i3, objArr.length);
                if (size >= iG2) {
                    Object[] objArr2 = this.f12466d;
                    l.copyInto(objArr2, objArr2, objArr2.length - size, 0, iG2);
                } else {
                    Object[] objArr3 = this.f12466d;
                    l.copyInto(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f12466d;
                    l.copyInto(objArr4, objArr4, 0, size, iG2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f12466d;
                l.copyInto(objArr5, objArr5, length, i3, iG2);
            } else {
                Object[] objArr6 = this.f12466d;
                length += objArr6.length;
                int i4 = iG2 - i3;
                int length2 = objArr6.length - length;
                if (length2 >= i4) {
                    l.copyInto(objArr6, objArr6, length, i3, iG2);
                } else {
                    l.copyInto(objArr6, objArr6, length, i3, i3 + length2);
                    Object[] objArr7 = this.f12466d;
                    l.copyInto(objArr7, objArr7, 0, this.f12465c + length2, iG2);
                }
            }
            this.f12465c = length;
            a(f(iG2 - size), collection);
        } else {
            int i5 = iG2 + size;
            if (iG2 < iG) {
                int i6 = size + iG;
                Object[] objArr8 = this.f12466d;
                if (i6 <= objArr8.length) {
                    l.copyInto(objArr8, objArr8, i5, iG2, iG);
                } else if (i5 >= objArr8.length) {
                    l.copyInto(objArr8, objArr8, i5 - objArr8.length, iG2, iG);
                } else {
                    int length3 = iG - (i6 - objArr8.length);
                    l.copyInto(objArr8, objArr8, 0, length3, iG);
                    Object[] objArr9 = this.f12466d;
                    l.copyInto(objArr9, objArr9, i5, iG2, length3);
                }
            } else {
                Object[] objArr10 = this.f12466d;
                l.copyInto(objArr10, objArr10, size, 0, iG);
                Object[] objArr11 = this.f12466d;
                if (i5 >= objArr11.length) {
                    l.copyInto(objArr11, objArr11, i5 - objArr11.length, iG2, objArr11.length);
                } else {
                    l.copyInto(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f12466d;
                    l.copyInto(objArr12, objArr12, i5, iG2, objArr12.length - size);
                }
            }
            a(iG2, collection);
        }
        return true;
    }

    public i() {
        this.f12466d = f12463a;
    }

    public i(Collection<? extends E> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        Object[] array = collection.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.f12466d = array;
        this.f12467e = array.length;
        if (array.length == 0) {
            this.f12466d = f12463a;
        }
    }
}

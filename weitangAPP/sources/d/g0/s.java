package d.g0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class s extends r {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> extends d.k0.d.u implements d.k0.c.l<T, Integer> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.l f12547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Comparable f12548c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d.k0.c.l lVar, Comparable comparable) {
            super(1);
            this.f12547b = lVar;
            this.f12548c = comparable;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(T t) {
            return d.h0.a.compareValues((Comparable) this.f12547b.invoke(t), this.f12548c);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.k0.c.l
        public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
            return Integer.valueOf(invoke2(obj));
        }
    }

    public static final void a(int i2, int i3, int i4) {
        if (i3 > i4) {
            throw new IllegalArgumentException("fromIndex (" + i3 + ") is greater than toIndex (" + i4 + ").");
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i3 + ") is less than zero.");
        }
        if (i4 <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + i2 + ").");
    }

    public static final <T> ArrayList<T> arrayListOf(T... tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new h(tArr, true));
    }

    public static final <T> Collection<T> asCollection(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$asCollection");
        return new h(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T t, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(list, "$this$binarySearch");
        a(list.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int iCompareValues = d.h0.a.compareValues(list.get(i5), t);
            if (iCompareValues < 0) {
                i2 = i5 + 1;
            } else {
                if (iCompareValues <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int binarySearch$default(List list, Comparable comparable, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = list.size();
        }
        return binarySearch((List<? extends Comparable>) list, comparable, i2, i3);
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(List<? extends T> list, K k, int i2, int i3, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$binarySearchBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return binarySearch(list, i2, i3, new a(lVar, k));
    }

    public static /* synthetic */ int binarySearchBy$default(List list, Comparable comparable, int i2, int i3, d.k0.c.l lVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = list.size();
        }
        d.k0.d.t.checkNotNullParameter(list, "$this$binarySearchBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return binarySearch(list, i2, i3, new a(lVar, comparable));
    }

    public static final <T> List<T> emptyList() {
        return d0.INSTANCE;
    }

    public static final d.m0.k getIndices(Collection<?> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$indices");
        return new d.m0.k(0, collection.size() - 1);
    }

    public static final <T> int getLastIndex(List<? extends T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$lastIndex");
        return list.size() - 1;
    }

    public static final <T> List<T> listOf(T... tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return tArr.length > 0 ? l.asList(tArr) : emptyList();
    }

    public static final <T> List<T> listOfNotNull(T t) {
        return t != null ? r.listOf(t) : emptyList();
    }

    public static final <T> List<T> mutableListOf(T... tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new h(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        return size != 0 ? size != 1 ? list : r.listOf(list.get(0)) : emptyList();
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$shuffled");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        List<T> mutableList = a0.toMutableList(iterable);
        a0.shuffle(mutableList, fVar);
        return mutableList;
    }

    public static final void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static final void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static /* synthetic */ int binarySearch$default(List list, Object obj, Comparator comparator, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = list.size();
        }
        return binarySearch(list, obj, comparator, i2, i3);
    }

    public static final <T> List<T> listOfNotNull(T... tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return m.filterNotNull(tArr);
    }

    public static /* synthetic */ int binarySearch$default(List list, int i2, int i3, d.k0.c.l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = list.size();
        }
        return binarySearch(list, i2, i3, lVar);
    }

    public static final <T> int binarySearch(List<? extends T> list, T t, Comparator<? super T> comparator, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(list, "$this$binarySearch");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        a(list.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int iCompare = comparator.compare(list.get(i5), t);
            if (iCompare < 0) {
                i2 = i5 + 1;
            } else {
                if (iCompare <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final <T> int binarySearch(List<? extends T> list, int i2, int i3, d.k0.c.l<? super T, Integer> lVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$binarySearch");
        d.k0.d.t.checkNotNullParameter(lVar, "comparison");
        a(list.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int iIntValue = lVar.invoke(list.get(i5)).intValue();
            if (iIntValue < 0) {
                i2 = i5 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }
}

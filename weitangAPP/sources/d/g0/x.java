package d.g0;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public class x extends w {
    public static final <T> boolean addAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$addAll");
        d.k0.d.t.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static final <T> boolean c(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static final <T> boolean d(List<T> list, d.k0.c.l<? super T, Boolean> lVar, boolean z) {
        int i2;
        if (!(list instanceof RandomAccess)) {
            Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
            return c(d.k0.d.i0.asMutableIterable(list), lVar, z);
        }
        int lastIndex = s.getLastIndex(list);
        if (lastIndex >= 0) {
            int i3 = 0;
            i2 = 0;
            while (true) {
                T t = list.get(i3);
                if (lVar.invoke(t).booleanValue() != z) {
                    if (i2 != i3) {
                        list.set(i2, t);
                    }
                    i2++;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        } else {
            i2 = 0;
        }
        if (i2 >= list.size()) {
            return false;
        }
        int lastIndex2 = s.getLastIndex(list);
        if (lastIndex2 < i2) {
            return true;
        }
        while (true) {
            list.remove(lastIndex2);
            if (lastIndex2 == i2) {
                return true;
            }
            lastIndex2--;
        }
    }

    public static final boolean e(Collection<?> collection) {
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$removeAll");
        d.k0.d.t.checkNotNullParameter(iterable, "elements");
        return d.k0.d.i0.asMutableCollection(collection).removeAll(t.convertToSetForSetOperationWith(iterable, collection));
    }

    public static final <T> T removeFirst(List<T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$removeFirst");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    public static final <T> T removeFirstOrNull(List<T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$removeFirstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    public static final <T> T removeLast(List<T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$removeLast");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(s.getLastIndex(list));
    }

    public static final <T> T removeLastOrNull(List<T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$removeLastOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(s.getLastIndex(list));
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$retainAll");
        d.k0.d.t.checkNotNullParameter(iterable, "elements");
        return d.k0.d.i0.asMutableCollection(collection).retainAll(t.convertToSetForSetOperationWith(iterable, collection));
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$removeAll");
        d.k0.d.t.checkNotNullParameter(mVar, "elements");
        HashSet hashSet = d.o0.t.toHashSet(mVar);
        return (hashSet.isEmpty() ^ true) && collection.removeAll(hashSet);
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, T[] tArr) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$retainAll");
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return (tArr.length == 0) ^ true ? collection.retainAll(m.toHashSet(tArr)) : e(collection);
    }

    public static final <T> boolean addAll(Collection<? super T> collection, d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$addAll");
        d.k0.d.t.checkNotNullParameter(mVar, "elements");
        Iterator<? extends T> it = mVar.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, T[] tArr) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$removeAll");
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return ((tArr.length == 0) ^ true) && collection.removeAll(m.toHashSet(tArr));
    }

    public static final <T> boolean removeAll(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$removeAll");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        return c(iterable, lVar, true);
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$retainAll");
        d.k0.d.t.checkNotNullParameter(mVar, "elements");
        HashSet hashSet = d.o0.t.toHashSet(mVar);
        if (!hashSet.isEmpty()) {
            return collection.retainAll(hashSet);
        }
        return e(collection);
    }

    public static final <T> boolean addAll(Collection<? super T> collection, T[] tArr) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$addAll");
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return collection.addAll(l.asList(tArr));
    }

    public static final <T> boolean removeAll(List<T> list, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$removeAll");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        return d(list, lVar, true);
    }

    public static final <T> boolean retainAll(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$retainAll");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        return c(iterable, lVar, false);
    }

    public static final <T> boolean retainAll(List<T> list, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$retainAll");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        return d(list, lVar, false);
    }
}

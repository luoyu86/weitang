package d.g0;

import com.alibaba.mtl.appmonitor.AppMonitorDelegate;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a0 extends z {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements d.o0.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f12432a;

        public a(Iterable iterable) {
            this.f12432a = iterable;
        }

        @Override // d.o0.m
        public Iterator<T> iterator() {
            return this.f12432a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> extends d.k0.d.u implements d.k0.c.l<Integer, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12433b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(1);
            this.f12433b = i2;
        }

        public final T invoke(int i2) {
            throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.f12433b + '.');
        }

        @Override // d.k0.c.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    public static final class c<K, T> implements h0<T, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f12434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.l f12435b;

        public c(Iterable<? extends T> iterable, d.k0.c.l lVar) {
            this.f12434a = iterable;
            this.f12435b = lVar;
        }

        @Override // d.g0.h0
        public K keyOf(T t) {
            return (K) this.f12435b.invoke(t);
        }

        @Override // d.g0.h0
        public Iterator<T> sourceIterator() {
            return this.f12434a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> extends d.k0.d.u implements d.k0.c.a<Iterator<? extends T>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f12436b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Iterable iterable) {
            super(0);
            this.f12436b = iterable;
        }

        @Override // d.k0.c.a
        public final Iterator<T> invoke() {
            return this.f12436b.iterator();
        }
    }

    public static final <T> boolean all(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$all");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!lVar.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$any");
        return iterable instanceof Collection ? !((Collection) iterable).isEmpty() : iterable.iterator().hasNext();
    }

    public static final <T> d.o0.m<T> asSequence(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$asSequence");
        return new a(iterable);
    }

    public static final <T, K, V> Map<K, V> associate(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$associate");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(t.collectionSizeOrDefault(iterable, 10)), 16));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(it.next());
            linkedHashMap.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <T, K> Map<K, T> associateBy(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(t.collectionSizeOrDefault(iterable, 10)), 16));
        for (T t : iterable) {
            linkedHashMap.put(lVar.invoke(t), t);
        }
        return linkedHashMap;
    }

    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(Iterable<? extends T> iterable, M m, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (T t : iterable) {
            m.put(lVar.invoke(t), t);
        }
        return m;
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(Iterable<? extends T> iterable, M m, d.k0.c.l<? super T, ? extends d.m<? extends K, ? extends V>> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$associateTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            d.m<? extends K, ? extends V> mVarInvoke = lVar.invoke(it.next());
            m.put(mVarInvoke.getFirst(), mVarInvoke.getSecond());
        }
        return m;
    }

    public static final <K, V> Map<K, V> associateWith(Iterable<? extends K> iterable, d.k0.c.l<? super K, ? extends V> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$associateWith");
        d.k0.d.t.checkNotNullParameter(lVar, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(t.collectionSizeOrDefault(iterable, 10)), 16));
        for (K k : iterable) {
            linkedHashMap.put(k, lVar.invoke(k));
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(Iterable<? extends K> iterable, M m, d.k0.c.l<? super K, ? extends V> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$associateWithTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "valueSelector");
        for (K k : iterable) {
            m.put(k, lVar.invoke(k));
        }
        return m;
    }

    public static final double averageOfByte(Iterable<Byte> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$average");
        Iterator<Byte> it = iterable.iterator();
        double dByteValue = 0.0d;
        int i2 = 0;
        while (it.hasNext()) {
            dByteValue += (double) it.next().byteValue();
            i2++;
            if (i2 < 0) {
                s.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i2);
    }

    public static final double averageOfDouble(Iterable<Double> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$average");
        Iterator<Double> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        int i2 = 0;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
            i2++;
            if (i2 < 0) {
                s.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i2);
    }

    public static final double averageOfFloat(Iterable<Float> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$average");
        Iterator<Float> it = iterable.iterator();
        double dFloatValue = 0.0d;
        int i2 = 0;
        while (it.hasNext()) {
            dFloatValue += (double) it.next().floatValue();
            i2++;
            if (i2 < 0) {
                s.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i2);
    }

    public static final double averageOfInt(Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$average");
        Iterator<Integer> it = iterable.iterator();
        double dIntValue = 0.0d;
        int i2 = 0;
        while (it.hasNext()) {
            dIntValue += (double) it.next().intValue();
            i2++;
            if (i2 < 0) {
                s.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i2);
    }

    public static final double averageOfLong(Iterable<Long> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$average");
        Iterator<Long> it = iterable.iterator();
        double dLongValue = 0.0d;
        int i2 = 0;
        while (it.hasNext()) {
            dLongValue += it.next().longValue();
            i2++;
            if (i2 < 0) {
                s.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i2);
    }

    public static final double averageOfShort(Iterable<Short> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$average");
        Iterator<Short> it = iterable.iterator();
        double dShortValue = 0.0d;
        int i2 = 0;
        while (it.hasNext()) {
            dShortValue += (double) it.next().shortValue();
            i2++;
            if (i2 < 0) {
                s.throwCountOverflow();
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i2);
    }

    public static final <T> List<List<T>> chunked(Iterable<? extends T> iterable, int i2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$chunked");
        return windowed(iterable, i2, i2, true);
    }

    public static final <T> boolean contains(Iterable<? extends T> iterable, T t) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$contains");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t) : indexOf(iterable, t) >= 0;
    }

    public static final <T> int count(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$count");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        int i2 = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            it.next();
            i2++;
            if (i2 < 0) {
                s.throwCountOverflow();
            }
        }
        return i2;
    }

    public static final <T> List<T> distinct(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$distinct");
        return toList(toMutableSet(iterable));
    }

    public static final <T, K> List<T> distinctBy(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$distinctBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (hashSet.add(lVar.invoke(t))) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> drop(Iterable<? extends T> iterable, int i2) {
        ArrayList arrayList;
        d.k0.d.t.checkNotNullParameter(iterable, "$this$drop");
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return toList(iterable);
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i2;
            if (size <= 0) {
                return s.emptyList();
            }
            if (size == 1) {
                return r.listOf(last(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i2 < size2) {
                        arrayList.add(((List) iterable).get(i2));
                        i2++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i2);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        for (T t : iterable) {
            if (i3 >= i2) {
                arrayList.add(t);
            } else {
                i3++;
            }
        }
        return s.optimizeReadOnlyList(arrayList);
    }

    public static final <T> List<T> dropLast(List<? extends T> list, int i2) {
        d.k0.d.t.checkNotNullParameter(list, "$this$dropLast");
        if (i2 >= 0) {
            return take(list, d.m0.p.coerceAtLeast(list.size() - i2, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final <T> List<T> dropLastWhile(List<? extends T> list, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$dropLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (!lVar.invoke(listIterator.previous()).booleanValue()) {
                    return take(list, listIterator.nextIndex() + 1);
                }
            }
        }
        return s.emptyList();
    }

    public static final <T> List<T> dropWhile(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$dropWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (T t : iterable) {
            if (z) {
                arrayList.add(t);
            } else if (!lVar.invoke(t).booleanValue()) {
                arrayList.add(t);
                z = true;
            }
        }
        return arrayList;
    }

    public static final <T> T elementAt(Iterable<? extends T> iterable, int i2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$elementAt");
        return iterable instanceof List ? (T) ((List) iterable).get(i2) : (T) elementAtOrElse(iterable, i2, new b(i2));
    }

    public static final <T> T elementAtOrElse(Iterable<? extends T> iterable, int i2, d.k0.c.l<? super Integer, ? extends T> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$elementAtOrElse");
        d.k0.d.t.checkNotNullParameter(lVar, AppMonitorDelegate.DEFAULT_VALUE);
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i2 < 0 || i2 > s.getLastIndex(list)) ? lVar.invoke(Integer.valueOf(i2)) : (T) list.get(i2);
        }
        if (i2 < 0) {
            return lVar.invoke(Integer.valueOf(i2));
        }
        int i3 = 0;
        for (T t : iterable) {
            int i4 = i3 + 1;
            if (i2 == i3) {
                return t;
            }
            i3 = i4;
        }
        return lVar.invoke(Integer.valueOf(i2));
    }

    public static final <T> T elementAtOrNull(Iterable<? extends T> iterable, int i2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$elementAtOrNull");
        if (iterable instanceof List) {
            return (T) getOrNull((List) iterable, i2);
        }
        if (i2 < 0) {
            return null;
        }
        int i3 = 0;
        for (T t : iterable) {
            int i4 = i3 + 1;
            if (i2 == i3) {
                return t;
            }
            i3 = i4;
        }
        return null;
    }

    public static final <T> List<T> filter(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$filter");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (lVar.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> filterIndexed(Iterable<? extends T> iterable, d.k0.c.p<? super Integer, ? super T, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$filterIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                s.throwIndexOverflow();
            }
            if (pVar.invoke(Integer.valueOf(i2), t).booleanValue()) {
                arrayList.add(t);
            }
            i2 = i3;
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C filterIndexedTo(Iterable<? extends T> iterable, C c2, d.k0.c.p<? super Integer, ? super T, Boolean> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$filterIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "predicate");
        int i2 = 0;
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                s.throwIndexOverflow();
            }
            if (pVar.invoke(Integer.valueOf(i2), t).booleanValue()) {
                c2.add(t);
            }
            i2 = i3;
        }
        return c2;
    }

    public static final /* synthetic */ <R> List<R> filterIsInstance(Iterable<?> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$filterIsInstance");
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            d.k0.d.t.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Iterable<?> iterable, C c2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$filterIsInstanceTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (Object obj : iterable) {
            d.k0.d.t.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                c2.add(obj);
            }
        }
        return c2;
    }

    public static final <T> List<T> filterNot(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$filterNot");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!lVar.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> filterNotNull(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$filterNotNull");
        return (List) filterNotNullTo(iterable, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(Iterable<? extends T> iterable, C c2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$filterNotNullTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        for (T t : iterable) {
            if (t != null) {
                c2.add(t);
            }
        }
        return c2;
    }

    public static final <T, C extends Collection<? super T>> C filterNotTo(Iterable<? extends T> iterable, C c2, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$filterNotTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t : iterable) {
            if (!lVar.invoke(t).booleanValue()) {
                c2.add(t);
            }
        }
        return c2;
    }

    public static final <T, C extends Collection<? super T>> C filterTo(Iterable<? extends T> iterable, C c2, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$filterTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t : iterable) {
            if (lVar.invoke(t).booleanValue()) {
                c2.add(t);
            }
        }
        return c2;
    }

    public static final <T> T first(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$first");
        if (iterable instanceof List) {
            return (T) first((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T firstOrNull(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$firstOrNull");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final <T, R> List<R> flatMap(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            x.addAll(arrayList, lVar.invoke(it.next()));
        }
        return arrayList;
    }

    public static final <T, R> List<R> flatMapSequence(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends d.o0.m<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$flatMap");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            x.addAll(arrayList, lVar.invoke(it.next()));
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapSequenceTo(Iterable<? extends T> iterable, C c2, d.k0.c.l<? super T, ? extends d.o0.m<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            x.addAll(c2, lVar.invoke(it.next()));
        }
        return c2;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapTo(Iterable<? extends T> iterable, C c2, d.k0.c.l<? super T, ? extends Iterable<? extends R>> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$flatMapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            x.addAll(c2, lVar.invoke(it.next()));
        }
        return c2;
    }

    public static final <T, R> R fold(Iterable<? extends T> iterable, R r, d.k0.c.p<? super R, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$fold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r = pVar.invoke(r, it.next());
        }
        return r;
    }

    public static final <T, R> R foldIndexed(Iterable<? extends T> iterable, R r, d.k0.c.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$foldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int i2 = 0;
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                s.throwIndexOverflow();
            }
            r = qVar.invoke(Integer.valueOf(i2), r, t);
            i2 = i3;
        }
        return r;
    }

    public static final <T, R> R foldRight(List<? extends T> list, R r, d.k0.c.p<? super T, ? super R, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$foldRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r = pVar.invoke(listIterator.previous(), r);
            }
        }
        return r;
    }

    public static final <T, R> R foldRightIndexed(List<? extends T> list, R r, d.k0.c.q<? super Integer, ? super T, ? super R, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$foldRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r = qVar.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), r);
            }
        }
        return r;
    }

    public static final <T> void forEach(Iterable<? extends T> iterable, d.k0.c.l<? super T, d.d0> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$forEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            lVar.invoke(it.next());
        }
    }

    public static final <T> void forEachIndexed(Iterable<? extends T> iterable, d.k0.c.p<? super Integer, ? super T, d.d0> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$forEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        int i2 = 0;
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                s.throwIndexOverflow();
            }
            pVar.invoke(Integer.valueOf(i2), t);
            i2 = i3;
        }
    }

    public static final <T> T getOrNull(List<? extends T> list, int i2) {
        d.k0.d.t.checkNotNullParameter(list, "$this$getOrNull");
        if (i2 < 0 || i2 > s.getLastIndex(list)) {
            return null;
        }
        return list.get(i2);
    }

    public static final <T, K> Map<K, List<T>> groupBy(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : iterable) {
            K kInvoke = lVar.invoke(t);
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(t);
        }
        return linkedHashMap;
    }

    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(Iterable<? extends T> iterable, M m, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        for (T t : iterable) {
            K kInvoke = lVar.invoke(t);
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(t);
        }
        return m;
    }

    public static final <T, K> h0<T, K> groupingBy(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$groupingBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        return new c(iterable, lVar);
    }

    public static final <T> int indexOf(Iterable<? extends T> iterable, T t) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$indexOf");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i2 = 0;
        for (T t2 : iterable) {
            if (i2 < 0) {
                s.throwIndexOverflow();
            }
            if (d.k0.d.t.areEqual(t, t2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$indexOfFirst");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int i2 = 0;
        for (T t : iterable) {
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                s.throwIndexOverflow();
            }
            if (lVar.invoke(t).booleanValue()) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$indexOfLast");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        int i2 = -1;
        int i3 = 0;
        for (T t : iterable) {
            if (i3 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                s.throwIndexOverflow();
            }
            if (lVar.invoke(t).booleanValue()) {
                i2 = i3;
            }
            i3++;
        }
        return i2;
    }

    public static final <T> Set<T> intersect(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$intersect");
        d.k0.d.t.checkNotNullParameter(iterable2, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        x.retainAll(mutableSet, iterable2);
        return mutableSet;
    }

    public static final <T, A extends Appendable> A joinTo(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super T, ? extends CharSequence> lVar) throws IOException {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$joinTo");
        d.k0.d.t.checkNotNullParameter(a2, "buffer");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (T t : iterable) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            d.p0.p.appendElement(a2, t, lVar);
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T> String joinToString(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l<? super T, ? extends CharSequence> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$joinToString");
        d.k0.d.t.checkNotNullParameter(charSequence, "separator");
        d.k0.d.t.checkNotNullParameter(charSequence2, RequestParameters.PREFIX);
        d.k0.d.t.checkNotNullParameter(charSequence3, "postfix");
        d.k0.d.t.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, lVar)).toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, d.k0.c.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return joinToString(iterable, charSequence, charSequence5, charSequence6, i4, charSequence7, lVar);
    }

    public static final <T> T last(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$last");
        if (iterable instanceof List) {
            return (T) last((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T> int lastIndexOf(Iterable<? extends T> iterable, T t) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$lastIndexOf");
        if (iterable instanceof List) {
            return ((List) iterable).lastIndexOf(t);
        }
        int i2 = -1;
        int i3 = 0;
        for (T t2 : iterable) {
            if (i3 < 0) {
                s.throwIndexOverflow();
            }
            if (d.k0.d.t.areEqual(t, t2)) {
                i2 = i3;
            }
            i3++;
        }
        return i2;
    }

    public static final <T> T lastOrNull(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$lastOrNull");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T, R> List<R> map(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$map");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList(t.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(lVar.invoke(it.next()));
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapIndexed(Iterable<? extends T> iterable, d.k0.c.p<? super Integer, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$mapIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        ArrayList arrayList = new ArrayList(t.collectionSizeOrDefault(iterable, 10));
        int i2 = 0;
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                s.throwIndexOverflow();
            }
            arrayList.add(pVar.invoke(Integer.valueOf(i2), t));
            i2 = i3;
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapIndexedNotNull(Iterable<? extends T> iterable, d.k0.c.p<? super Integer, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$mapIndexedNotNull");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                s.throwIndexOverflow();
            }
            R rInvoke = pVar.invoke(Integer.valueOf(i2), t);
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
            i2 = i3;
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(Iterable<? extends T> iterable, C c2, d.k0.c.p<? super Integer, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$mapIndexedNotNullTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                s.throwIndexOverflow();
            }
            R rInvoke = pVar.invoke(Integer.valueOf(i2), t);
            if (rInvoke != null) {
                c2.add(rInvoke);
            }
            i2 = i3;
        }
        return c2;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(Iterable<? extends T> iterable, C c2, d.k0.c.p<? super Integer, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$mapIndexedTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int i2 = 0;
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                s.throwIndexOverflow();
            }
            c2.add(pVar.invoke(Integer.valueOf(i2), t));
            i2 = i3;
        }
        return c2;
    }

    public static final <T, R> List<R> mapNotNull(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$mapNotNull");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(it.next());
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(Iterable<? extends T> iterable, C c2, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$mapNotNullTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R rInvoke = lVar.invoke(it.next());
            if (rInvoke != null) {
                c2.add(rInvoke);
            }
        }
        return c2;
    }

    public static final <T, R, C extends Collection<? super R>> C mapTo(Iterable<? extends T> iterable, C c2, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$mapTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c2.add(lVar.invoke(it.next()));
        }
        return c2;
    }

    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final Double m123max(Iterable<Double> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$max");
        return m125maxOrNull(iterable);
    }

    public static final <T, R extends Comparable<? super R>> T maxBy(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$maxBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            R rInvoke = lVar.invoke(next);
            do {
                T next2 = it.next();
                R rInvoke2 = lVar.invoke(next2);
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    next = next2;
                    rInvoke = rInvoke2;
                }
            } while (it.hasNext());
        }
        return (T) next;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    public static final <T, R extends Comparable<? super R>> T maxByOrNull(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$maxByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rInvoke = lVar.invoke(next);
        do {
            T next2 = it.next();
            R rInvoke2 = lVar.invoke(next2);
            next = next;
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static final Double m125maxOrNull(Iterable<Double> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$maxOrNull");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final <T> T maxWith(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$maxWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return (T) maxWithOrNull(iterable, comparator);
    }

    public static final <T> T maxWithOrNull(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$maxWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final Double m127min(Iterable<Double> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$min");
        return m129minOrNull(iterable);
    }

    public static final <T, R extends Comparable<? super R>> T minBy(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$minBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            R rInvoke = lVar.invoke(next);
            do {
                T next2 = it.next();
                R rInvoke2 = lVar.invoke(next2);
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    next = next2;
                    rInvoke = rInvoke2;
                }
            } while (it.hasNext());
        }
        return (T) next;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    public static final <T, R extends Comparable<? super R>> T minByOrNull(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$minByOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rInvoke = lVar.invoke(next);
        do {
            T next2 = it.next();
            R rInvoke2 = lVar.invoke(next2);
            next = next;
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static final Double m129minOrNull(Iterable<Double> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$minOrNull");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final <T> T minWith(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$minWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return (T) minWithOrNull(iterable, comparator);
    }

    public static final <T> T minWithOrNull(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$minWithOrNull");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, T t) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$minus");
        ArrayList arrayList = new ArrayList(t.collectionSizeOrDefault(iterable, 10));
        boolean z = false;
        for (T t2 : iterable) {
            boolean z2 = true;
            if (!z && d.k0.d.t.areEqual(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static final <T> boolean none(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$none");
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    public static final <T, C extends Iterable<? extends T>> C onEach(C c2, d.k0.c.l<? super T, d.d0> lVar) {
        d.k0.d.t.checkNotNullParameter(c2, "$this$onEach");
        d.k0.d.t.checkNotNullParameter(lVar, "action");
        Iterator<T> it = c2.iterator();
        while (it.hasNext()) {
            lVar.invoke(it.next());
        }
        return c2;
    }

    public static final <T, C extends Iterable<? extends T>> C onEachIndexed(C c2, d.k0.c.p<? super Integer, ? super T, d.d0> pVar) {
        d.k0.d.t.checkNotNullParameter(c2, "$this$onEachIndexed");
        d.k0.d.t.checkNotNullParameter(pVar, "action");
        int i2 = 0;
        for (T t : c2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                s.throwIndexOverflow();
            }
            pVar.invoke(Integer.valueOf(i2), t);
            i2 = i3;
        }
        return c2;
    }

    public static final <T> d.m<List<T>, List<T>> partition(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$partition");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : iterable) {
            if (lVar.invoke(t).booleanValue()) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        return new d.m<>(arrayList, arrayList2);
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, T t) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$plus");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Object) t);
        }
        ArrayList arrayList = new ArrayList();
        x.addAll(arrayList, iterable);
        arrayList.add(t);
        return arrayList;
    }

    public static final <T> T random(Collection<? extends T> collection, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$random");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (collection.isEmpty()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return (T) elementAt(collection, fVar.nextInt(collection.size()));
    }

    public static final <T> T randomOrNull(Collection<? extends T> collection, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$randomOrNull");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        if (collection.isEmpty()) {
            return null;
        }
        return (T) elementAt(collection, fVar.nextInt(collection.size()));
    }

    public static final <S, T extends S> S reduce(Iterable<? extends T> iterable, d.k0.c.p<? super S, ? super T, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$reduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        S next = it.next();
        while (it.hasNext()) {
            next = pVar.invoke(next, it.next());
        }
        return next;
    }

    public static final <S, T extends S> S reduceIndexed(Iterable<? extends T> iterable, d.k0.c.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$reduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        S next = it.next();
        int i2 = 1;
        while (it.hasNext()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                s.throwIndexOverflow();
            }
            next = qVar.invoke(Integer.valueOf(i2), next, it.next());
            i2 = i3;
        }
        return next;
    }

    public static final <S, T extends S> S reduceIndexedOrNull(Iterable<? extends T> iterable, d.k0.c.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$reduceIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        int i2 = 1;
        while (it.hasNext()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                s.throwIndexOverflow();
            }
            next = qVar.invoke(Integer.valueOf(i2), next, it.next());
            i2 = i3;
        }
        return next;
    }

    public static final <S, T extends S> S reduceOrNull(Iterable<? extends T> iterable, d.k0.c.p<? super S, ? super T, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$reduceOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        while (it.hasNext()) {
            next = pVar.invoke(next, it.next());
        }
        return next;
    }

    public static final <S, T extends S> S reduceRight(List<? extends T> list, d.k0.c.p<? super T, ? super S, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$reduceRight");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            throw new UnsupportedOperationException("Empty list can't be reduced.");
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = pVar.invoke(listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    public static final <S, T extends S> S reduceRightIndexed(List<? extends T> list, d.k0.c.q<? super Integer, ? super T, ? super S, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$reduceRightIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            throw new UnsupportedOperationException("Empty list can't be reduced.");
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = qVar.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    public static final <S, T extends S> S reduceRightIndexedOrNull(List<? extends T> list, d.k0.c.q<? super Integer, ? super T, ? super S, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$reduceRightIndexedOrNull");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = qVar.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    public static final <S, T extends S> S reduceRightOrNull(List<? extends T> list, d.k0.c.p<? super T, ? super S, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$reduceRightOrNull");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = pVar.invoke(listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Iterable<T> requireNoNulls(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$requireNoNulls");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + iterable + '.');
            }
        }
        return iterable;
    }

    public static final <T> List<T> reversed(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$reversed");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return toList(iterable);
        }
        List<T> mutableList = toMutableList(iterable);
        z.reverse(mutableList);
        return mutableList;
    }

    public static final <T, R> List<R> runningFold(Iterable<? extends T> iterable, R r, d.k0.c.p<? super R, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$runningFold");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int iCollectionSizeOrDefault = t.collectionSizeOrDefault(iterable, 9);
        if (iCollectionSizeOrDefault == 0) {
            return r.listOf(r);
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault + 1);
        arrayList.add(r);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r = pVar.invoke(r, it.next());
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final <T, R> List<R> runningFoldIndexed(Iterable<? extends T> iterable, R r, d.k0.c.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$runningFoldIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int iCollectionSizeOrDefault = t.collectionSizeOrDefault(iterable, 9);
        if (iCollectionSizeOrDefault == 0) {
            return r.listOf(r);
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault + 1);
        arrayList.add(r);
        int i2 = 0;
        for (T t : iterable) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            r = qVar.invoke(numValueOf, r, t);
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> runningReduce(Iterable<? extends T> iterable, d.k0.c.p<? super S, ? super T, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$runningReduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return s.emptyList();
        }
        S next = it.next();
        ArrayList arrayList = new ArrayList(t.collectionSizeOrDefault(iterable, 10));
        arrayList.add(next);
        while (it.hasNext()) {
            next = pVar.invoke(next, it.next());
            arrayList.add(next);
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> runningReduceIndexed(Iterable<? extends T> iterable, d.k0.c.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$runningReduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return s.emptyList();
        }
        S next = it.next();
        ArrayList arrayList = new ArrayList(t.collectionSizeOrDefault(iterable, 10));
        arrayList.add(next);
        int i2 = 1;
        while (it.hasNext()) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            next = qVar.invoke(numValueOf, next, it.next());
            arrayList.add(next);
        }
        return arrayList;
    }

    public static final <T, R> List<R> scan(Iterable<? extends T> iterable, R r, d.k0.c.p<? super R, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$scan");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        int iCollectionSizeOrDefault = t.collectionSizeOrDefault(iterable, 9);
        if (iCollectionSizeOrDefault == 0) {
            return r.listOf(r);
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault + 1);
        arrayList.add(r);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r = pVar.invoke(r, it.next());
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final <T, R> List<R> scanIndexed(Iterable<? extends T> iterable, R r, d.k0.c.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$scanIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        int iCollectionSizeOrDefault = t.collectionSizeOrDefault(iterable, 9);
        if (iCollectionSizeOrDefault == 0) {
            return r.listOf(r);
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault + 1);
        arrayList.add(r);
        int i2 = 0;
        for (T t : iterable) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            r = qVar.invoke(numValueOf, r, t);
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> scanReduce(Iterable<? extends T> iterable, d.k0.c.p<? super S, ? super T, ? extends S> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$scanReduce");
        d.k0.d.t.checkNotNullParameter(pVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return s.emptyList();
        }
        S next = it.next();
        ArrayList arrayList = new ArrayList(t.collectionSizeOrDefault(iterable, 10));
        arrayList.add(next);
        while (it.hasNext()) {
            next = pVar.invoke(next, it.next());
            arrayList.add(next);
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> scanReduceIndexed(Iterable<? extends T> iterable, d.k0.c.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$scanReduceIndexed");
        d.k0.d.t.checkNotNullParameter(qVar, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return s.emptyList();
        }
        S next = it.next();
        ArrayList arrayList = new ArrayList(t.collectionSizeOrDefault(iterable, 10));
        arrayList.add(next);
        int i2 = 1;
        while (it.hasNext()) {
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            next = qVar.invoke(numValueOf, next, it.next());
            arrayList.add(next);
        }
        return arrayList;
    }

    public static final <T> void shuffle(List<T> list, d.l0.f fVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$shuffle");
        d.k0.d.t.checkNotNullParameter(fVar, "random");
        for (int lastIndex = s.getLastIndex(list); lastIndex >= 1; lastIndex--) {
            int iNextInt = fVar.nextInt(lastIndex + 1);
            list.set(iNextInt, list.set(lastIndex, list.get(iNextInt)));
        }
    }

    public static final <T> T single(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$single");
        if (iterable instanceof List) {
            return (T) single((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T singleOrNull(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$singleOrNull");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static final <T> List<T> slice(List<? extends T> list, d.m0.k kVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$slice");
        d.k0.d.t.checkNotNullParameter(kVar, "indices");
        return kVar.isEmpty() ? s.emptyList() : toList(list.subList(kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1));
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(List<T> list, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$sortBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        if (list.size() > 1) {
            w.sortWith(list, new d.h0.b(lVar));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(List<T> list, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$sortByDescending");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        if (list.size() > 1) {
            w.sortWith(list, new d.h0.c(lVar));
        }
    }

    public static final <T extends Comparable<? super T>> void sortDescending(List<T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$sortDescending");
        w.sortWith(list, d.h0.a.reverseOrder());
    }

    public static final <T extends Comparable<? super T>> List<T> sorted(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$sorted");
        if (!(iterable instanceof Collection)) {
            List<T> mutableList = toMutableList(iterable);
            w.sort(mutableList);
            return mutableList;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return toList(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Comparable[] comparableArr = (Comparable[]) array;
        l.sort(comparableArr);
        return l.asList(comparableArr);
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$sortedBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(iterable, new d.h0.b(lVar));
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$sortedByDescending");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        return sortedWith(iterable, new d.h0.c(lVar));
    }

    public static final <T extends Comparable<? super T>> List<T> sortedDescending(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$sortedDescending");
        return sortedWith(iterable, d.h0.a.reverseOrder());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> sortedWith(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$sortedWith");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> mutableList = toMutableList(iterable);
            w.sortWith(mutableList, comparator);
            return mutableList;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return toList(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        l.sortWith(array, comparator);
        return l.asList(array);
    }

    public static final <T> Set<T> subtract(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$subtract");
        d.k0.d.t.checkNotNullParameter(iterable2, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        x.removeAll(mutableSet, iterable2);
        return mutableSet;
    }

    public static final <T> int sumBy(Iterable<? extends T> iterable, d.k0.c.l<? super T, Integer> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$sumBy");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        Iterator<? extends T> it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += lVar.invoke(it.next()).intValue();
        }
        return iIntValue;
    }

    public static final <T> double sumByDouble(Iterable<? extends T> iterable, d.k0.c.l<? super T, Double> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$sumByDouble");
        d.k0.d.t.checkNotNullParameter(lVar, "selector");
        Iterator<? extends T> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += lVar.invoke(it.next()).doubleValue();
        }
        return dDoubleValue;
    }

    public static final int sumOfByte(Iterable<Byte> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$sum");
        Iterator<Byte> it = iterable.iterator();
        int iByteValue = 0;
        while (it.hasNext()) {
            iByteValue += it.next().byteValue();
        }
        return iByteValue;
    }

    public static final double sumOfDouble(Iterable<Double> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$sum");
        Iterator<Double> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
        }
        return dDoubleValue;
    }

    public static final float sumOfFloat(Iterable<Float> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$sum");
        Iterator<Float> it = iterable.iterator();
        float fFloatValue = 0.0f;
        while (it.hasNext()) {
            fFloatValue += it.next().floatValue();
        }
        return fFloatValue;
    }

    public static final int sumOfInt(Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$sum");
        Iterator<Integer> it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue;
    }

    public static final long sumOfLong(Iterable<Long> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$sum");
        Iterator<Long> it = iterable.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    public static final int sumOfShort(Iterable<Short> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$sum");
        Iterator<Short> it = iterable.iterator();
        int iShortValue = 0;
        while (it.hasNext()) {
            iShortValue += it.next().shortValue();
        }
        return iShortValue;
    }

    public static final <T> List<T> take(Iterable<? extends T> iterable, int i2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$take");
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return s.emptyList();
        }
        if (iterable instanceof Collection) {
            if (i2 >= ((Collection) iterable).size()) {
                return toList(iterable);
            }
            if (i2 == 1) {
                return r.listOf(first(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i2);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return s.optimizeReadOnlyList(arrayList);
    }

    public static final <T> List<T> takeLast(List<? extends T> list, int i2) {
        d.k0.d.t.checkNotNullParameter(list, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return s.emptyList();
        }
        int size = list.size();
        if (i2 >= size) {
            return toList(list);
        }
        if (i2 == 1) {
            return r.listOf(last((List) list));
        }
        ArrayList arrayList = new ArrayList(i2);
        if (list instanceof RandomAccess) {
            for (int i3 = size - i2; i3 < size; i3++) {
                arrayList.add(list.get(i3));
            }
        } else {
            ListIterator<? extends T> listIterator = list.listIterator(size - i2);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static final <T> List<T> takeLastWhile(List<? extends T> list, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$takeLastWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        if (list.isEmpty()) {
            return s.emptyList();
        }
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (!lVar.invoke(listIterator.previous()).booleanValue()) {
                listIterator.next();
                int size = list.size() - listIterator.nextIndex();
                if (size == 0) {
                    return s.emptyList();
                }
                ArrayList arrayList = new ArrayList(size);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
                return arrayList;
            }
        }
        return toList(list);
    }

    public static final <T> List<T> takeWhile(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$takeWhile");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!lVar.invoke(t).booleanValue()) {
                break;
            }
            arrayList.add(t);
        }
        return arrayList;
    }

    public static final boolean[] toBooleanArray(Collection<Boolean> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$toBooleanArray");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            zArr[i2] = it.next().booleanValue();
            i2++;
        }
        return zArr;
    }

    public static final byte[] toByteArray(Collection<Byte> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$toByteArray");
        byte[] bArr = new byte[collection.size()];
        Iterator<Byte> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            bArr[i2] = it.next().byteValue();
            i2++;
        }
        return bArr;
    }

    public static final char[] toCharArray(Collection<Character> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$toCharArray");
        char[] cArr = new char[collection.size()];
        Iterator<Character> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            cArr[i2] = it.next().charValue();
            i2++;
        }
        return cArr;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Iterable<? extends T> iterable, C c2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$toCollection");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }

    public static final double[] toDoubleArray(Collection<Double> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$toDoubleArray");
        double[] dArr = new double[collection.size()];
        Iterator<Double> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            dArr[i2] = it.next().doubleValue();
            i2++;
        }
        return dArr;
    }

    public static final float[] toFloatArray(Collection<Float> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$toFloatArray");
        float[] fArr = new float[collection.size()];
        Iterator<Float> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            fArr[i2] = it.next().floatValue();
            i2++;
        }
        return fArr;
    }

    public static final <T> HashSet<T> toHashSet(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$toHashSet");
        return (HashSet) toCollection(iterable, new HashSet(q0.mapCapacity(t.collectionSizeOrDefault(iterable, 12))));
    }

    public static final int[] toIntArray(Collection<Integer> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$toIntArray");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = it.next().intValue();
            i2++;
        }
        return iArr;
    }

    public static final <T> List<T> toList(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return s.optimizeReadOnlyList(toMutableList(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return s.emptyList();
        }
        if (size != 1) {
            return toMutableList(collection);
        }
        return r.listOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final long[] toLongArray(Collection<Long> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$toLongArray");
        long[] jArr = new long[collection.size()];
        Iterator<Long> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            jArr[i2] = it.next().longValue();
            i2++;
        }
        return jArr;
    }

    public static final <T> List<T> toMutableList(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$toMutableList");
        return iterable instanceof Collection ? toMutableList((Collection) iterable) : (List) toCollection(iterable, new ArrayList());
    }

    public static final <T> Set<T> toMutableSet(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$toMutableSet");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) toCollection(iterable, new LinkedHashSet());
    }

    public static final <T> Set<T> toSet(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$toSet");
        if (!(iterable instanceof Collection)) {
            return z0.optimizeReadOnlySet((Set) toCollection(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return z0.emptySet();
        }
        if (size != 1) {
            return (Set) toCollection(iterable, new LinkedHashSet(q0.mapCapacity(collection.size())));
        }
        return y0.setOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final short[] toShortArray(Collection<Short> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$toShortArray");
        short[] sArr = new short[collection.size()];
        Iterator<Short> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            sArr[i2] = it.next().shortValue();
            i2++;
        }
        return sArr;
    }

    public static final <T> Set<T> union(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$union");
        d.k0.d.t.checkNotNullParameter(iterable2, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        x.addAll(mutableSet, iterable2);
        return mutableSet;
    }

    public static final <T> List<List<T>> windowed(Iterable<? extends T> iterable, int i2, int i3, boolean z) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$windowed");
        b1.checkWindowSizeStep(i2, i3);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itWindowedIterator = b1.windowedIterator(iterable.iterator(), i2, i3, z, false);
            while (itWindowedIterator.hasNext()) {
                arrayList.add((List) itWindowedIterator.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i3) + (size % i3 == 0 ? 0 : 1));
        int i4 = 0;
        while (i4 >= 0 && size > i4) {
            int iCoerceAtMost = d.m0.p.coerceAtMost(i2, size - i4);
            if (iCoerceAtMost < i2 && !z) {
                break;
            }
            ArrayList arrayList3 = new ArrayList(iCoerceAtMost);
            for (int i5 = 0; i5 < iCoerceAtMost; i5++) {
                arrayList3.add(list.get(i5 + i4));
            }
            arrayList2.add(arrayList3);
            i4 += i3;
        }
        return arrayList2;
    }

    public static /* synthetic */ List windowed$default(Iterable iterable, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return windowed(iterable, i2, i3, z);
    }

    public static final <T> Iterable<i0<T>> withIndex(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$withIndex");
        return new j0(new d(iterable));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R, V> List<V> zip(Iterable<? extends T> iterable, R[] rArr, d.k0.c.p<? super T, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        int length = rArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (T t : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(t, rArr[i2]));
            i2++;
        }
        return arrayList;
    }

    public static final <T, R> List<R> zipWithNext(Iterable<? extends T> iterable, d.k0.c.p<? super T, ? super T, ? extends R> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$zipWithNext");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return s.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        a.a.a next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(pVar.invoke(next, next2));
            next = next2;
        }
        return arrayList;
    }

    public static final <T, R> List<R> chunked(Iterable<? extends T> iterable, int i2, d.k0.c.l<? super List<? extends T>, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$chunked");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        return windowed(iterable, i2, i2, true, lVar);
    }

    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final Float m124max(Iterable<Float> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$max");
        return m126maxOrNull(iterable);
    }

    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final Float m128min(Iterable<Float> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$min");
        return m130minOrNull(iterable);
    }

    public static /* synthetic */ List windowed$default(Iterable iterable, int i2, int i3, boolean z, d.k0.c.l lVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return windowed(iterable, i2, i3, z, lVar);
    }

    public static final <T> boolean any(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$any");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(Iterable<? extends T> iterable, M m, d.k0.c.l<? super T, ? extends K> lVar, d.k0.c.l<? super T, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$associateByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (T t : iterable) {
            m.put(lVar.invoke(t), lVar2.invoke(t));
        }
        return m;
    }

    public static final <T> int count(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$count");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return 0;
        }
        Iterator<? extends T> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue() && (i2 = i2 + 1) < 0) {
                if (!d.j0.b.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
                s.throwCountOverflow();
            }
        }
        return i2;
    }

    public static final <T extends Comparable<? super T>> T max(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$max");
        return (T) maxOrNull(iterable);
    }

    public static final <T extends Comparable<? super T>> T min(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$min");
        return (T) minOrNull(iterable);
    }

    public static final <T> boolean none(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$none");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> requireNoNulls(List<? extends T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$requireNoNulls");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + list + '.');
            }
        }
        return list;
    }

    public static final <T> List<T> slice(List<? extends T> list, Iterable<Integer> iterable) {
        d.k0.d.t.checkNotNullParameter(list, "$this$slice");
        d.k0.d.t.checkNotNullParameter(iterable, "indices");
        int iCollectionSizeOrDefault = t.collectionSizeOrDefault(iterable, 10);
        if (iCollectionSizeOrDefault == 0) {
            return s.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(list.get(it.next().intValue()));
        }
        return arrayList;
    }

    public static final <T> int indexOfFirst(List<? extends T> list, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$indexOfFirst");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        Iterator<? extends T> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue()) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(List<? extends T> list, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$indexOfLast");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (lVar.invoke(listIterator.previous()).booleanValue()) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, T[] tArr) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$minus");
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        if (tArr.length == 0) {
            return toList(iterable);
        }
        HashSet hashSet = m.toHashSet(tArr);
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!hashSet.contains(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> toMutableList(Collection<? extends T> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    public static final <T, K, V> Map<K, V> associateBy(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends K> lVar, d.k0.c.l<? super T, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$associateBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(t.collectionSizeOrDefault(iterable, 10)), 16));
        for (T t : iterable) {
            linkedHashMap.put(lVar.invoke(t), lVar2.invoke(t));
        }
        return linkedHashMap;
    }

    public static final <T> int indexOf(List<? extends T> list, T t) {
        d.k0.d.t.checkNotNullParameter(list, "$this$indexOf");
        return list.indexOf(t);
    }

    public static final <T> int lastIndexOf(List<? extends T> list, T t) {
        d.k0.d.t.checkNotNullParameter(list, "$this$lastIndexOf");
        return list.lastIndexOf(t);
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, T t) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$plus");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    public static final <T, R, V> List<V> zip(Iterable<? extends T> iterable, Iterable<? extends R> iterable2, d.k0.c.p<? super T, ? super R, ? extends V> pVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable2, "other");
        d.k0.d.t.checkNotNullParameter(pVar, "transform");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(t.collectionSizeOrDefault(iterable, 10), t.collectionSizeOrDefault(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(pVar.invoke(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static final <T> T first(List<? extends T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$first");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T singleOrNull(List<? extends T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$singleOrNull");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static final <T> T firstOrNull(List<? extends T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$firstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> T lastOrNull(List<? extends T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$lastOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static final <T> T singleOrNull(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$singleOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        boolean z = false;
        T t = null;
        for (T t2 : iterable) {
            if (lVar.invoke(t2).booleanValue()) {
                if (z) {
                    return null;
                }
                z = true;
                t = t2;
            }
        }
        if (z) {
            return t;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T firstOrNull(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$firstOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t : iterable) {
            if (lVar.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(Iterable<? extends T> iterable, M m, d.k0.c.l<? super T, ? extends K> lVar, d.k0.c.l<? super T, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$groupByTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        for (T t : iterable) {
            K kInvoke = lVar.invoke(t);
            Object arrayList = m.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(lVar2.invoke(t));
        }
        return m;
    }

    public static final <T> T last(List<? extends T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$last");
        if (!list.isEmpty()) {
            return list.get(s.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T lastOrNull(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$lastOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        T t = null;
        for (T t2 : iterable) {
            if (lVar.invoke(t2).booleanValue()) {
                t = t2;
            }
        }
        return t;
    }

    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static final Float m126maxOrNull(Iterable<Float> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$maxOrNull");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static final Float m130minOrNull(Iterable<Float> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$minOrNull");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, T[] tArr) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$plus");
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Object[]) tArr);
        }
        ArrayList arrayList = new ArrayList();
        x.addAll(arrayList, iterable);
        x.addAll(arrayList, tArr);
        return arrayList;
    }

    public static final <T> T single(List<? extends T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$single");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static final <T> List<d.m<T, T>> zipWithNext(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$zipWithNext");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return s.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(d.s.to(next, next2));
            next = next2;
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T first(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$first");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (T t : iterable) {
            if (lVar.invoke(t).booleanValue()) {
                return t;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final <T, K, V> Map<K, List<V>> groupBy(Iterable<? extends T> iterable, d.k0.c.l<? super T, ? extends K> lVar, d.k0.c.l<? super T, ? extends V> lVar2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$groupBy");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        d.k0.d.t.checkNotNullParameter(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : iterable) {
            K kInvoke = lVar.invoke(t);
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(lVar2.invoke(t));
        }
        return linkedHashMap;
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$minus");
        d.k0.d.t.checkNotNullParameter(iterable2, "elements");
        Collection collectionConvertToSetForSetOperationWith = t.convertToSetForSetOperationWith(iterable2, iterable);
        if (collectionConvertToSetForSetOperationWith.isEmpty()) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!collectionConvertToSetForSetOperationWith.contains(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    public static final <T> T lastOrNull(List<? extends T> list, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$lastOrNull");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (lVar.invoke(tPrevious).booleanValue()) {
                return tPrevious;
            }
        }
        return null;
    }

    public static final <T, R> List<d.m<T, R>> zip(Iterable<? extends T> iterable, R[] rArr) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$zip");
        d.k0.d.t.checkNotNullParameter(rArr, "other");
        int length = rArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (T t : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(d.s.to(t, rArr[i2]));
            i2++;
        }
        return arrayList;
    }

    public static final <T> T last(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$last");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : iterable) {
            if (lVar.invoke(t2).booleanValue()) {
                t = t2;
                z = true;
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, T[] tArr) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$plus");
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + tArr.length);
        arrayList.addAll(collection);
        x.addAll(arrayList, tArr);
        return arrayList;
    }

    public static final <T> T single(Iterable<? extends T> iterable, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$single");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : iterable) {
            if (lVar.invoke(t2).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Collection contains more than one matching element.");
                }
                t = t2;
                z = true;
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final <T, R> List<R> windowed(Iterable<? extends T> iterable, int i2, int i3, boolean z, d.k0.c.l<? super List<? extends T>, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$windowed");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        b1.checkWindowSizeStep(i2, i3);
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            List list = (List) iterable;
            int size = list.size();
            int i4 = 0;
            ArrayList arrayList = new ArrayList((size / i3) + (size % i3 == 0 ? 0 : 1));
            s0 s0Var = new s0(list);
            while (i4 >= 0 && size > i4) {
                int iCoerceAtMost = d.m0.p.coerceAtMost(i2, size - i4);
                if (!z && iCoerceAtMost < i2) {
                    break;
                }
                s0Var.move(i4, iCoerceAtMost + i4);
                arrayList.add(lVar.invoke(s0Var));
                i4 += i3;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator itWindowedIterator = b1.windowedIterator(iterable.iterator(), i2, i3, z, true);
        while (itWindowedIterator.hasNext()) {
            arrayList2.add(lVar.invoke((List) itWindowedIterator.next()));
        }
        return arrayList2;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    public static final <T> T last(List<? extends T> list, d.k0.c.l<? super T, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(list, "$this$last");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (lVar.invoke(tPrevious).booleanValue()) {
                return tPrevious;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    public static final <T extends Comparable<? super T>> T maxOrNull(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$maxOrNull");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T extends Comparable<? super T>> T minOrNull(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$minOrNull");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$minus");
        d.k0.d.t.checkNotNullParameter(mVar, "elements");
        HashSet hashSet = d.o0.t.toHashSet(mVar);
        if (hashSet.isEmpty()) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!hashSet.contains(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$plus");
        d.k0.d.t.checkNotNullParameter(iterable2, "elements");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Iterable) iterable2);
        }
        ArrayList arrayList = new ArrayList();
        x.addAll(arrayList, iterable);
        x.addAll(arrayList, iterable2);
        return arrayList;
    }

    public static final <T, R> List<d.m<T, R>> zip(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$zip");
        d.k0.d.t.checkNotNullParameter(iterable2, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(t.collectionSizeOrDefault(iterable, 10), t.collectionSizeOrDefault(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(d.s.to(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$plus");
        d.k0.d.t.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        x.addAll(arrayList2, iterable);
        return arrayList2;
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$plus");
        d.k0.d.t.checkNotNullParameter(mVar, "elements");
        ArrayList arrayList = new ArrayList();
        x.addAll(arrayList, iterable);
        x.addAll(arrayList, mVar);
        return arrayList;
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, d.o0.m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$plus");
        d.k0.d.t.checkNotNullParameter(mVar, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + 10);
        arrayList.addAll(collection);
        x.addAll(arrayList, mVar);
        return arrayList;
    }
}

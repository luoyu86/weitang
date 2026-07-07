package d.g0;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class y0 {
    public static final <E> Set<E> build(Set<E> set) {
        d.k0.d.t.checkNotNullParameter(set, "builder");
        return ((d.g0.i1.h) set).build();
    }

    public static final <E> Set<E> createSetBuilder() {
        return new d.g0.i1.h();
    }

    public static final <T> Set<T> setOf(T t) {
        Set<T> setSingleton = Collections.singleton(t);
        d.k0.d.t.checkNotNullExpressionValue(setSingleton, "java.util.Collections.singleton(element)");
        return setSingleton;
    }

    public static final <T> TreeSet<T> sortedSetOf(T... tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return (TreeSet) m.toCollection(tArr, new TreeSet());
    }

    public static final <E> Set<E> createSetBuilder(int i2) {
        return new d.g0.i1.h(i2);
    }

    public static final <T> TreeSet<T> sortedSetOf(Comparator<? super T> comparator, T... tArr) {
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return (TreeSet) m.toCollection(tArr, new TreeSet(comparator));
    }
}

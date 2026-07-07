package d.g0;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class z0 extends y0 {
    public static final <T> Set<T> emptySet() {
        return f0.INSTANCE;
    }

    public static final <T> HashSet<T> hashSetOf(T... tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return (HashSet) m.toCollection(tArr, new HashSet(q0.mapCapacity(tArr.length)));
    }

    public static final <T> LinkedHashSet<T> linkedSetOf(T... tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return (LinkedHashSet) m.toCollection(tArr, new LinkedHashSet(q0.mapCapacity(tArr.length)));
    }

    public static final <T> Set<T> mutableSetOf(T... tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return (Set) m.toCollection(tArr, new LinkedHashSet(q0.mapCapacity(tArr.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> set) {
        d.k0.d.t.checkNotNullParameter(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        return size != 0 ? size != 1 ? set : y0.setOf(set.iterator().next()) : emptySet();
    }

    public static final <T> Set<T> setOf(T... tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return tArr.length > 0 ? m.toSet(tArr) : emptySet();
    }

    public static final <T> Set<T> setOfNotNull(T t) {
        return t != null ? y0.setOf(t) : emptySet();
    }

    public static final <T> Set<T> setOfNotNull(T... tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "elements");
        return (Set) m.filterNotNullTo(tArr, new LinkedHashSet());
    }
}

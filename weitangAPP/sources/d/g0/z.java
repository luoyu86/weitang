package d.g0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class z extends y {
    public static final <R> List<R> filterIsInstance(Iterable<?> iterable, Class<R> cls) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$filterIsInstance");
        d.k0.d.t.checkNotNullParameter(cls, "klass");
        return (List) filterIsInstanceTo(iterable, new ArrayList(), cls);
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Iterable<?> iterable, C c2, Class<R> cls) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$filterIsInstanceTo");
        d.k0.d.t.checkNotNullParameter(c2, "destination");
        d.k0.d.t.checkNotNullParameter(cls, "klass");
        for (Object obj : iterable) {
            if (cls.isInstance(obj)) {
                c2.add(obj);
            }
        }
        return c2;
    }

    public static final <T> void reverse(List<T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$reverse");
        Collections.reverse(list);
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$toSortedSet");
        return (SortedSet) a0.toCollection(iterable, new TreeSet());
    }

    public static final <T> SortedSet<T> toSortedSet(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$toSortedSet");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) a0.toCollection(iterable, new TreeSet(comparator));
    }
}

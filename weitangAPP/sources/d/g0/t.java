package d.g0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class t extends s {
    public static final <T> boolean b(Collection<? extends T> collection) {
        return collection.size() > 2 && (collection instanceof ArrayList);
    }

    public static final <T> int collectionSizeOrDefault(Iterable<? extends T> iterable, int i2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }

    public static final <T> Integer collectionSizeOrNull(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$collectionSizeOrNull");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    public static final <T> Collection<T> convertToSetForSetOperation(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$convertToSetForSetOperation");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (!(iterable instanceof Collection)) {
            return a0.toHashSet(iterable);
        }
        Collection<T> collection = (Collection) iterable;
        return b(collection) ? a0.toHashSet(iterable) : collection;
    }

    public static final <T> Collection<T> convertToSetForSetOperationWith(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$convertToSetForSetOperationWith");
        d.k0.d.t.checkNotNullParameter(iterable2, "source");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (!(iterable instanceof Collection)) {
            return a0.toHashSet(iterable);
        }
        if ((iterable2 instanceof Collection) && ((Collection) iterable2).size() < 2) {
            return (Collection) iterable;
        }
        Collection<T> collection = (Collection) iterable;
        return b(collection) ? a0.toHashSet(iterable) : collection;
    }

    public static final <T> List<T> flatten(Iterable<? extends Iterable<? extends T>> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$flatten");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Iterable<? extends T>> it = iterable.iterator();
        while (it.hasNext()) {
            x.addAll(arrayList, it.next());
        }
        return arrayList;
    }

    public static final <T, R> d.m<List<T>, List<R>> unzip(Iterable<? extends d.m<? extends T, ? extends R>> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$unzip");
        int iCollectionSizeOrDefault = collectionSizeOrDefault(iterable, 10);
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        ArrayList arrayList2 = new ArrayList(iCollectionSizeOrDefault);
        for (d.m<? extends T, ? extends R> mVar : iterable) {
            arrayList.add(mVar.getFirst());
            arrayList2.add(mVar.getSecond());
        }
        return d.s.to(arrayList, arrayList2);
    }
}

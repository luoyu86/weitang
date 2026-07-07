package d.g0;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class r {
    public static final <E> List<E> build(List<E> list) {
        d.k0.d.t.checkNotNullParameter(list, "builder");
        return ((d.g0.i1.b) list).build();
    }

    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$copyToArrayOfAny");
        if (z && d.k0.d.t.areEqual(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        d.k0.d.t.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    public static final <E> List<E> createListBuilder() {
        return new d.g0.i1.b();
    }

    public static final <T> List<T> listOf(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        d.k0.d.t.checkNotNullExpressionValue(listSingletonList, "java.util.Collections.singletonList(element)");
        return listSingletonList;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$shuffled");
        List<T> mutableList = a0.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }

    public static final <E> List<E> createListBuilder(int i2) {
        return new d.g0.i1.b(i2);
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable, Random random) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$shuffled");
        d.k0.d.t.checkNotNullParameter(random, "random");
        List<T> mutableList = a0.toMutableList(iterable);
        Collections.shuffle(mutableList, random);
        return mutableList;
    }
}

package d.g0;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class y extends x {
    public static final <T> List<T> asReversed(List<? extends T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$asReversed");
        return new w0(list);
    }

    public static final <T> List<T> asReversedMutable(List<T> list) {
        d.k0.d.t.checkNotNullParameter(list, "$this$asReversed");
        return new v0(list);
    }

    public static final int f(List<?> list, int i2) {
        int lastIndex = s.getLastIndex(list);
        if (i2 >= 0 && lastIndex >= i2) {
            return s.getLastIndex(list) - i2;
        }
        throw new IndexOutOfBoundsException("Element index " + i2 + " must be in range [" + new d.m0.k(0, s.getLastIndex(list)) + "].");
    }

    public static final int g(List<?> list, int i2) {
        int size = list.size();
        if (i2 >= 0 && size >= i2) {
            return list.size() - i2;
        }
        throw new IndexOutOfBoundsException("Position index " + i2 + " must be in range [" + new d.m0.k(0, list.size()) + "].");
    }
}

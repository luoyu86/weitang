package d.g0.i1;

import d.k0.d.t;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final <T> boolean a(T[] tArr, int i2, int i3, List<?> list) {
        if (i3 != list.size()) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (true ^ t.areEqual(tArr[i2 + i4], list.get(i4))) {
                return false;
            }
        }
        return true;
    }

    public static final <E> E[] arrayOfUninitializedElements(int i2) {
        if (i2 >= 0) {
            return (E[]) new Object[i2];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> int b(T[] tArr, int i2, int i3) {
        int iHashCode = 1;
        for (int i4 = 0; i4 < i3; i4++) {
            T t = tArr[i2 + i4];
            iHashCode = (iHashCode * 31) + (t != null ? t.hashCode() : 0);
        }
        return iHashCode;
    }

    public static final <T> String c(T[] tArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder((i3 * 3) + 2);
        sb.append("[");
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(tArr[i2 + i4]);
        }
        sb.append("]");
        String string = sb.toString();
        t.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final <T> T[] copyOfUninitializedElements(T[] tArr, int i2) {
        t.checkNotNullParameter(tArr, "$this$copyOfUninitializedElements");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i2);
        t.checkNotNullExpressionValue(tArr2, "java.util.Arrays.copyOf(this, newSize)");
        Objects.requireNonNull(tArr2, "null cannot be cast to non-null type kotlin.Array<T>");
        return tArr2;
    }

    public static final <E> void resetAt(E[] eArr, int i2) {
        t.checkNotNullParameter(eArr, "$this$resetAt");
        eArr[i2] = null;
    }

    public static final <E> void resetRange(E[] eArr, int i2, int i3) {
        t.checkNotNullParameter(eArr, "$this$resetRange");
        while (i2 < i3) {
            resetAt(eArr, i2);
            i2++;
        }
    }
}

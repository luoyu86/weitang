package d.g0;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    public static final <T> T[] arrayOfNulls(T[] tArr, int i2) {
        d.k0.d.t.checkNotNullParameter(tArr, "reference");
        Object objNewInstance = Array.newInstance(tArr.getClass().getComponentType(), i2);
        Objects.requireNonNull(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T>");
        return (T[]) ((Object[]) objNewInstance);
    }

    public static final <T> int contentDeepHashCode(T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }

    public static final void copyOfRangeToIndexCheck(int i2, int i3) {
        if (i2 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i3 + ").");
    }

    public static final /* synthetic */ <T> T[] orEmpty(T[] tArr) {
        if (tArr != null) {
            return tArr;
        }
        d.k0.d.t.reifiedOperationMarker(0, "T?");
        return (T[]) new Object[0];
    }

    public static final /* synthetic */ <T> T[] toTypedArray(Collection<? extends T> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "$this$toTypedArray");
        d.k0.d.t.reifiedOperationMarker(0, "T?");
        T[] tArr = (T[]) collection.toArray(new Object[0]);
        Objects.requireNonNull(tArr, "null cannot be cast to non-null type kotlin.Array<T>");
        return tArr;
    }
}

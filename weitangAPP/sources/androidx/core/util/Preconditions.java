package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static float checkArgumentFinite(float f2, String str) {
        if (Float.isNaN(f2)) {
            throw new IllegalArgumentException(str + " must not be NaN");
        }
        if (!Float.isInfinite(f2)) {
            return f2;
        }
        throw new IllegalArgumentException(str + " must not be infinite");
    }

    public static float checkArgumentInRange(float f2, float f3, float f4, String str) {
        if (Float.isNaN(f2)) {
            throw new IllegalArgumentException(str + " must not be NaN");
        }
        if (f2 < f3) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (f2 <= f4) {
            return f2;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f3), Float.valueOf(f4)));
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i2, String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkArgumentPositive(int i2, String str) {
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalArgumentException(str);
    }

    public static float[] checkArrayElementsInRange(float[] fArr, float f2, float f3, String str) {
        checkNotNull(fArr, str + " must not be null");
        for (int i2 = 0; i2 < fArr.length; i2++) {
            float f4 = fArr[i2];
            if (Float.isNaN(f4)) {
                throw new IllegalArgumentException(str + "[" + i2 + "] must not be NaN");
            }
            if (f4 < f2) {
                throw new IllegalArgumentException(String.format(Locale.US, "%s[%d] is out of range of [%f, %f] (too low)", str, Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)));
            }
            if (f4 > f3) {
                throw new IllegalArgumentException(String.format(Locale.US, "%s[%d] is out of range of [%f, %f] (too high)", str, Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)));
            }
        }
        return fArr;
    }

    public static <T> T[] checkArrayElementsNotNull(T[] tArr, String str) {
        if (tArr == null) {
            throw new NullPointerException(str + " must not be null");
        }
        for (int i2 = 0; i2 < tArr.length; i2++) {
            if (tArr[i2] == null) {
                throw new NullPointerException(String.format(Locale.US, "%s[%d] must not be null", str, Integer.valueOf(i2)));
            }
        }
        return tArr;
    }

    @NonNull
    public static <C extends Collection<T>, T> C checkCollectionElementsNotNull(C c2, String str) {
        if (c2 == null) {
            throw new NullPointerException(str + " must not be null");
        }
        long j = 0;
        Iterator it = c2.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException(String.format(Locale.US, "%s[%d] must not be null", str, Long.valueOf(j)));
            }
            j++;
        }
        return c2;
    }

    public static <T> Collection<T> checkCollectionNotEmpty(Collection<T> collection, String str) {
        if (collection == null) {
            throw new NullPointerException(str + " must not be null");
        }
        if (!collection.isEmpty()) {
            return collection;
        }
        throw new IllegalArgumentException(str + " is empty");
    }

    public static int checkFlagsArgument(int i2, int i3) {
        if ((i2 & i3) == i2) {
            return i2;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(i3) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static void checkState(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(T t) {
        if (TextUtils.isEmpty(t)) {
            throw new IllegalArgumentException();
        }
        return t;
    }

    public static void checkArgument(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z) {
        checkState(z, null);
    }

    public static long checkArgumentNonnegative(long j) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(T t, Object obj) {
        if (TextUtils.isEmpty(t)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t;
    }

    public static long checkArgumentNonnegative(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkArgumentInRange(int i2, int i3, int i4, String str) {
        if (i2 < i3) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        if (i2 <= i4) {
            return i2;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    public static long checkArgumentInRange(long j, long j2, long j3, String str) {
        if (j < j2) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Long.valueOf(j2), Long.valueOf(j3)));
        }
        if (j <= j3) {
            return j;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Long.valueOf(j2), Long.valueOf(j3)));
    }
}

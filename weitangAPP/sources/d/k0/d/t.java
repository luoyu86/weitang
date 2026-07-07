package d.k0.d;

import com.alibaba.android.arouter.utils.Consts;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    public static String a(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + Consts.DOT + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static boolean areEqual(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static <T extends Throwable> T b(T t) {
        return (T) c(t, t.class.getName());
    }

    public static <T extends Throwable> T c(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t;
    }

    public static void checkExpressionValueIsNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) b(new IllegalStateException(str + " must not be null")));
    }

    public static void checkFieldIsNotNull(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) b(new IllegalStateException("Field specified as non-null is null: " + str + Consts.DOT + str2)));
    }

    public static void checkHasClass(String str) throws ClassNotFoundException {
        String strReplace = str.replace('/', '.');
        try {
            Class.forName(strReplace);
        } catch (ClassNotFoundException e2) {
            throw ((ClassNotFoundException) b(new ClassNotFoundException("Class " + strReplace + " is not found. Please update the Kotlin runtime to the latest version", e2)));
        }
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throwJavaNpe();
        }
    }

    public static void checkNotNullExpressionValue(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) b(new NullPointerException(str + " must not be null")));
    }

    public static void checkNotNullParameter(Object obj, String str) {
        if (obj == null) {
            e(str);
        }
    }

    public static void checkParameterIsNotNull(Object obj, String str) {
        if (obj == null) {
            d(str);
        }
    }

    public static void checkReturnedValueIsNotNull(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) b(new IllegalStateException("Method specified as non-null returned null: " + str + Consts.DOT + str2)));
    }

    public static int compare(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static void d(String str) {
        throw ((IllegalArgumentException) b(new IllegalArgumentException(a(str))));
    }

    public static void e(String str) {
        throw ((NullPointerException) b(new NullPointerException(a(str))));
    }

    public static void needClassReification() {
        throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int i2, String str) {
        throwUndefinedForReified();
    }

    public static String stringPlus(String str, Object obj) {
        return str + obj;
    }

    public static void throwAssert() {
        throw ((AssertionError) b(new AssertionError()));
    }

    public static void throwIllegalArgument() {
        throw ((IllegalArgumentException) b(new IllegalArgumentException()));
    }

    public static void throwIllegalState() {
        throw ((IllegalStateException) b(new IllegalStateException()));
    }

    public static void throwJavaNpe() {
        throw ((NullPointerException) b(new NullPointerException()));
    }

    public static void throwNpe() {
        throw ((d.d) b(new d.d()));
    }

    public static void throwUndefinedForReified() {
        throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUninitializedProperty(String str) {
        throw ((d.c0) b(new d.c0(str)));
    }

    public static void throwUninitializedPropertyAccessException(String str) {
        throwUninitializedProperty("lateinit property " + str + " has not been initialized");
    }

    public static boolean areEqual(Double d2, Double d3) {
        if (d2 == null) {
            if (d3 == null) {
                return true;
            }
        } else if (d3 != null && d2.doubleValue() == d3.doubleValue()) {
            return true;
        }
        return false;
    }

    public static void checkFieldIsNotNull(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) b(new IllegalStateException(str)));
        }
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throwJavaNpe(str);
        }
    }

    public static void checkReturnedValueIsNotNull(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) b(new IllegalStateException(str)));
        }
    }

    public static void needClassReification(String str) {
        throwUndefinedForReified(str);
    }

    public static void reifiedOperationMarker(int i2, String str, String str2) {
        throwUndefinedForReified(str2);
    }

    public static void throwAssert(String str) {
        throw ((AssertionError) b(new AssertionError(str)));
    }

    public static void throwIllegalArgument(String str) {
        throw ((IllegalArgumentException) b(new IllegalArgumentException(str)));
    }

    public static void throwIllegalState(String str) {
        throw ((IllegalStateException) b(new IllegalStateException(str)));
    }

    public static void throwJavaNpe(String str) {
        throw ((NullPointerException) b(new NullPointerException(str)));
    }

    public static void throwNpe(String str) {
        throw ((d.d) b(new d.d(str)));
    }

    public static void throwUndefinedForReified(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static boolean areEqual(Double d2, double d3) {
        return d2 != null && d2.doubleValue() == d3;
    }

    public static boolean areEqual(double d2, Double d3) {
        return d3 != null && d2 == d3.doubleValue();
    }

    public static void checkHasClass(String str, String str2) throws ClassNotFoundException {
        String strReplace = str.replace('/', '.');
        try {
            Class.forName(strReplace);
        } catch (ClassNotFoundException e2) {
            throw ((ClassNotFoundException) b(new ClassNotFoundException("Class " + strReplace + " is not found: this code requires the Kotlin runtime of version at least " + str2, e2)));
        }
    }

    public static boolean areEqual(Float f2, Float f3) {
        if (f2 == null) {
            if (f3 == null) {
                return true;
            }
        } else if (f3 != null && f2.floatValue() == f3.floatValue()) {
            return true;
        }
        return false;
    }

    public static boolean areEqual(Float f2, float f3) {
        return f2 != null && f2.floatValue() == f3;
    }

    public static boolean areEqual(float f2, Float f3) {
        return f3 != null && f2 == f3.floatValue();
    }
}

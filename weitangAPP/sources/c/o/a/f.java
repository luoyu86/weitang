package c.o.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public static i f2970a = new g();

    public static void addLogAdapter(@NonNull c cVar) {
        f2970a.addAdapter((c) j.a(cVar));
    }

    public static void clearLogAdapters() {
        f2970a.clearLogAdapters();
    }

    public static void d(@NonNull String str, @Nullable Object... objArr) {
        f2970a.d(str, objArr);
    }

    public static void e(@NonNull String str, @Nullable Object... objArr) {
        f2970a.e(null, str, objArr);
    }

    public static void i(@NonNull String str, @Nullable Object... objArr) {
        f2970a.i(str, objArr);
    }

    public static void json(@Nullable String str) {
        f2970a.json(str);
    }

    public static void log(int i2, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        f2970a.log(i2, str, str2, th);
    }

    public static void printer(@NonNull i iVar) {
        f2970a = (i) j.a(iVar);
    }

    public static i t(@Nullable String str) {
        return f2970a.t(str);
    }

    public static void v(@NonNull String str, @Nullable Object... objArr) {
        f2970a.v(str, objArr);
    }

    public static void w(@NonNull String str, @Nullable Object... objArr) {
        f2970a.w(str, objArr);
    }

    public static void wtf(@NonNull String str, @Nullable Object... objArr) {
        f2970a.wtf(str, objArr);
    }

    public static void xml(@Nullable String str) {
        f2970a.xml(str);
    }

    public static void d(@Nullable Object obj) {
        f2970a.d(obj);
    }

    public static void e(@Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        f2970a.e(th, str, objArr);
    }
}

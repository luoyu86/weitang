package c.o.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface i {
    void addAdapter(@NonNull c cVar);

    void clearLogAdapters();

    void d(@Nullable Object obj);

    void d(@NonNull String str, @Nullable Object... objArr);

    void e(@NonNull String str, @Nullable Object... objArr);

    void e(@Nullable Throwable th, @NonNull String str, @Nullable Object... objArr);

    void i(@NonNull String str, @Nullable Object... objArr);

    void json(@Nullable String str);

    void log(int i2, @Nullable String str, @Nullable String str2, @Nullable Throwable th);

    i t(@Nullable String str);

    void v(@NonNull String str, @Nullable Object... objArr);

    void w(@NonNull String str, @Nullable Object... objArr);

    void wtf(@NonNull String str, @Nullable Object... objArr);

    void xml(@Nullable String str);
}

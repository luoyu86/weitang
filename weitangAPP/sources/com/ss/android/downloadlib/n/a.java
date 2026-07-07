package com.ss.android.downloadlib.n;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    public interface ok<T> {
        T a();
    }

    public static <T> T ok(boolean z, String str, @NonNull ok<T> okVar) {
        try {
            return okVar.a();
        } catch (Throwable th) {
            if (th instanceof com.ss.android.downloadlib.n.ok) {
                throw th;
            }
            bl.ok().ok(z, th, str);
            if (TextUtils.isEmpty(str)) {
                throw th;
            }
            return null;
        }
    }

    public static <T> T ok(ok<T> okVar) {
        return (T) ok(true, null, okVar);
    }

    public static void ok(final Runnable runnable) {
        ok(new ok<Void>() { // from class: com.ss.android.downloadlib.n.a.1
            @Override // com.ss.android.downloadlib.n.a.ok
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Void a() {
                runnable.run();
                return null;
            }
        });
    }
}

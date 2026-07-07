package com.ss.android.downloadlib.h;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final ok ok = new C0135a();

    /* JADX INFO: renamed from: com.ss.android.downloadlib.h.a$a, reason: collision with other inner class name */
    @TargetApi(11)
    public static class C0135a extends ok {
        private C0135a() {
            super();
        }

        @Override // com.ss.android.downloadlib.h.a.ok
        public <T> void ok(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static class ok {
        private ok() {
        }

        public <T> void ok(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void ok(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        ok.ok(asyncTask, tArr);
    }
}

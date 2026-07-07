package com.tianmu.c.h.b;

import android.text.TextUtils;
import com.tianmu.utils.TianmuLogUtil;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f11636a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ThreadPoolExecutor f11637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f11638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f11639c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f11640d;

        private boolean b(Runnable runnable) {
            BlockingQueue<Runnable> queue = this.f11637a.getQueue();
            if (queue != null && queue.size() != 0) {
                com.tianmu.c.h.a.c cVarA = null;
                if ((runnable instanceof com.tianmu.c.h.a.d) && (cVarA = ((com.tianmu.c.h.a.d) runnable).a()) == null) {
                    return false;
                }
                for (Runnable runnable2 : queue) {
                    if (runnable2 instanceof com.tianmu.c.h.a.d) {
                        com.tianmu.c.h.a.c cVarA2 = ((com.tianmu.c.h.a.d) runnable2).a();
                        if (cVarA2 == null) {
                            return false;
                        }
                        if (!TextUtils.isEmpty(cVarA2.c()) && !TextUtils.isEmpty(cVarA.c()) && cVarA2.c().equals(cVarA.c())) {
                            return true;
                        }
                        if (!TextUtils.isEmpty(cVarA2.d()) && !TextUtils.isEmpty(cVarA.d()) && cVarA2.d().equals(cVarA.d())) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public void a(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            if (this.f11637a == null) {
                this.f11637a = new ThreadPoolExecutor(this.f11638b, this.f11639c, this.f11640d, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
            }
            if (b(runnable)) {
                return;
            }
            this.f11637a.execute(runnable);
        }

        private b(int i2, int i3, long j) {
            this.f11638b = i2;
            this.f11639c = i3;
            this.f11640d = j;
        }
    }

    public static b a() {
        if (f11636a == null) {
            synchronized (d.class) {
                if (f11636a == null) {
                    int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
                    int i2 = (iAvailableProcessors * 2) + 1;
                    TianmuLogUtil.iD("cpu num:" + iAvailableProcessors);
                    f11636a = new b(i2, i2, 0L);
                }
            }
        }
        return f11636a;
    }
}

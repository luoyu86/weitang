package com.alibaba.sdk.android.man.crashreporter.handler.b;

import android.content.Context;
import com.alibaba.sdk.android.man.crashreporter.handler.b.b;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private AtomicBoolean crashing;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f4741a = new AtomicBoolean(false);
    private Timer timer = new Timer();

    public a(final Context context, final com.alibaba.sdk.android.man.crashreporter.handler.a aVar, AtomicBoolean atomicBoolean, final int i2, final boolean z) {
        this.crashing = atomicBoolean;
        this.timer.schedule(new TimerTask() { // from class: com.alibaba.sdk.android.man.crashreporter.handler.b.a.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                b bVar = new b(i2);
                if (z) {
                    bVar.a();
                }
                bVar.a(new b.a() { // from class: com.alibaba.sdk.android.man.crashreporter.handler.b.a.1.1
                    @Override // com.alibaba.sdk.android.man.crashreporter.handler.b.b.a
                    public void a(String str, int i3) {
                        if (a.this.f4741a.compareAndSet(false, true)) {
                            com.alibaba.sdk.android.man.crashreporter.handler.c.a.d("crash_anr");
                        }
                        String strM44b = com.alibaba.sdk.android.man.crashreporter.a.c.a.m44b(context);
                        if (strM44b == null) {
                            strM44b = "-";
                        }
                        com.alibaba.sdk.android.man.crashreporter.handler.c.a.a(strM44b, "crash_anr", str, i3);
                    }

                    @Override // com.alibaba.sdk.android.man.crashreporter.handler.b.b.a
                    public void c(String str) {
                        try {
                            com.alibaba.sdk.android.man.crashreporter.handler.a aVar2 = aVar;
                            if (aVar2 != null) {
                                aVar2.m54b(str);
                            } else {
                                com.alibaba.sdk.android.man.crashreporter.b.a.e("stuck: crash manager is null!");
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                    }
                }).start();
            }
        }, 20000L);
    }

    public void c() {
        this.timer.cancel();
    }
}

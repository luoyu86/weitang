package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ok.ok;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f9951a;
    private long bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Runnable f9952h;
    private Handler kf;
    private SoftReference<JumpUnknownSourceActivity> n;
    private final Queue<Integer> ok;
    private long s;

    public static class ok {
        private static final p ok = new p();
    }

    private p() {
        this.ok = new ArrayDeque();
        this.f9951a = false;
        this.kf = new Handler(Looper.getMainLooper());
        this.f9952h = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.p.1
            @Override // java.lang.Runnable
            public void run() {
                p.this.bl();
            }
        };
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(new ok.InterfaceC0174ok() { // from class: com.ss.android.socialbase.appdownloader.p.2
            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC0174ok
            public void a() {
                if (p.this.ok.isEmpty()) {
                    return;
                }
                long jOk = com.ss.android.socialbase.downloader.h.ok.bl().ok("install_on_resume_install_interval", 120000L);
                long jCurrentTimeMillis = System.currentTimeMillis() - p.this.s;
                if (jCurrentTimeMillis < jOk) {
                    if (p.this.kf.hasCallbacks(p.this.f9952h)) {
                        return;
                    }
                    p.this.kf.postDelayed(p.this.f9952h, jOk - jCurrentTimeMillis);
                } else {
                    p.this.s = System.currentTimeMillis();
                    p.this.bl();
                }
            }

            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC0174ok
            public void bl() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Context context, int i2, boolean z) {
        int iA = bl.a(context, i2, z);
        if (iA == 1) {
            this.f9951a = true;
        }
        this.bl = System.currentTimeMillis();
        return iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl() {
        final Integer numPoll;
        if (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.ok.ok.ok().a()) {
            synchronized (this.ok) {
                numPoll = this.ok.poll();
            }
            this.kf.removeCallbacks(this.f9952h);
            if (numPoll == null) {
                this.f9951a = false;
                return;
            }
            final Context contextL = com.ss.android.socialbase.downloader.downloader.bl.l();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.kf.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.p.3
                    @Override // java.lang.Runnable
                    public void run() {
                        p.this.a(contextL, numPoll.intValue(), false);
                    }
                });
            } else {
                a(contextL, numPoll.intValue(), false);
            }
            this.kf.postDelayed(this.f9952h, 20000L);
        }
    }

    private boolean s() {
        return System.currentTimeMillis() - this.bl < 1000;
    }

    public void ok(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        bl();
    }

    public JumpUnknownSourceActivity a() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.n;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.n = null;
        return jumpUnknownSourceActivity;
    }

    public static p ok() {
        return ok.ok;
    }

    public int ok(final Context context, final int i2, final boolean z) {
        if (z) {
            return a(context, i2, z);
        }
        if (s()) {
            this.kf.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.p.4
                @Override // java.lang.Runnable
                public void run() {
                    p.this.ok(context, i2, z);
                }
            }, 1000L);
            return 1;
        }
        if (com.ss.android.socialbase.downloader.ok.ok.ok().a()) {
            com.ss.android.socialbase.downloader.bl.ok.bl("leaves", "on Foreground");
            return a(context, i2, z);
        }
        if (a.ok()) {
            return 1;
        }
        boolean z2 = Build.VERSION.SDK_INT < 29;
        if (this.ok.isEmpty() && !this.f9951a && z2) {
            return a(context, i2, z);
        }
        int iOk = com.ss.android.socialbase.downloader.h.ok.bl().ok("install_queue_size", 3);
        synchronized (this.ok) {
            while (this.ok.size() > iOk) {
                this.ok.poll();
            }
        }
        if (z2) {
            this.kf.removeCallbacks(this.f9952h);
            this.kf.postDelayed(this.f9952h, com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("install_queue_timeout", 20000L));
        }
        synchronized (this.ok) {
            if (!this.ok.contains(Integer.valueOf(i2))) {
                this.ok.offer(Integer.valueOf(i2));
            }
        }
        return 1;
    }

    public void ok(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.n = new SoftReference<>(jumpUnknownSourceActivity);
    }
}

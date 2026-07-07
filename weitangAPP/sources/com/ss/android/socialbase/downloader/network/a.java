package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10124a = "a";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f10125h = -1;
    public static volatile boolean ok;
    private static volatile a p;
    private long kf;
    private final r bl = r.ok();
    private final AtomicInteger s = new AtomicInteger();
    private final ok n = new ok(com.ss.android.socialbase.downloader.p.n.ok());

    public class ok extends Handler {
        public ok(Looper looper) {
            super(looper);
        }

        public void a() {
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            a.this.kf();
            sendEmptyMessageDelayed(1, 1000L);
        }

        public void ok() {
            sendEmptyMessage(1);
        }
    }

    private a() {
    }

    public static void n() {
        ok = com.ss.android.socialbase.downloader.q.kf.a(com.ss.android.socialbase.downloader.downloader.bl.l());
    }

    public static a ok() {
        if (p == null) {
            synchronized (a.class) {
                if (p == null) {
                    p = new a();
                }
            }
        }
        return p;
    }

    public static long s() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public void a() {
        try {
            com.ss.android.socialbase.downloader.bl.ok.bl(f10124a, "startSampling: mSamplingCounter = " + this.s);
            if (this.s.getAndIncrement() == 0) {
                this.n.ok();
                this.kf = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void bl() {
        try {
            com.ss.android.socialbase.downloader.bl.ok.bl(f10124a, "stopSampling: mSamplingCounter = " + this.s);
            if (this.s.decrementAndGet() == 0) {
                this.n.a();
                h();
            }
        } catch (Throwable unused) {
        }
    }

    public void h() {
        kf();
        f10125h = -1L;
    }

    public void kf() {
        try {
            n();
            long jS = ok ? s() : TrafficStats.getMobileRxBytes();
            long j = f10125h;
            long j2 = jS - j;
            if (j >= 0) {
                synchronized (this) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    this.bl.ok(j2, jUptimeMillis - this.kf);
                    this.kf = jUptimeMillis;
                }
            }
            f10125h = jS;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

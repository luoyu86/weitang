package com.tianmu.g;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandlerThread f12189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f12190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f12191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f12192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f12193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f12194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f12195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f12196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f12197i;
    public long j;
    public long k;
    public int l;
    public int m;
    public int n;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final z f12198a;

        /* JADX INFO: renamed from: com.tianmu.g.z$a$a, reason: collision with other inner class name */
        public class RunnableC0224a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Message f12199a;

            public RunnableC0224a(a aVar, Message message) {
                this.f12199a = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new AssertionError("Unhandled stats message." + this.f12199a.what);
            }
        }

        public a(Looper looper, z zVar) {
            super(looper);
            this.f12198a = zVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                this.f12198a.d();
                return;
            }
            if (i2 == 1) {
                this.f12198a.e();
                return;
            }
            if (i2 == 2) {
                this.f12198a.b(message.arg1);
                return;
            }
            if (i2 == 3) {
                this.f12198a.c(message.arg1);
            } else if (i2 != 4) {
                r.p.post(new RunnableC0224a(this, message));
            } else {
                this.f12198a.a((Long) message.obj);
            }
        }
    }

    public z(d dVar) {
        this.f12190b = dVar;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        this.f12189a = handlerThread;
        handlerThread.start();
        f0.a(handlerThread.getLooper());
        this.f12191c = new a(handlerThread.getLooper(), this);
    }

    public void a(Bitmap bitmap) {
        a(bitmap, 2);
    }

    public void b(Bitmap bitmap) {
        a(bitmap, 3);
    }

    public void c() {
        this.f12191c.sendEmptyMessage(1);
    }

    public void d() {
        this.f12192d++;
    }

    public void e() {
        this.f12193e++;
    }

    public void a(long j) {
        Handler handler = this.f12191c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j)));
    }

    public void b() {
        this.f12191c.sendEmptyMessage(0);
    }

    public void c(long j) {
        this.n++;
        long j2 = this.f12196h + j;
        this.f12196h = j2;
        this.k = a(this.m, j2);
    }

    public void a(Long l) {
        this.l++;
        long jLongValue = this.f12194f + l.longValue();
        this.f12194f = jLongValue;
        this.f12197i = a(this.l, jLongValue);
    }

    public void b(long j) {
        int i2 = this.m + 1;
        this.m = i2;
        long j2 = this.f12195g + j;
        this.f12195g = j2;
        this.j = a(i2, j2);
    }

    public a0 a() {
        return new a0(this.f12190b.a(), this.f12190b.b(), this.f12192d, this.f12193e, this.f12194f, this.f12195g, this.f12196h, this.f12197i, this.j, this.k, this.l, this.m, this.n, System.currentTimeMillis());
    }

    private void a(Bitmap bitmap, int i2) {
        int iA = f0.a(bitmap);
        Handler handler = this.f12191c;
        handler.sendMessage(handler.obtainMessage(i2, iA, 0));
    }

    private static long a(int i2, long j) {
        return j / ((long) i2);
    }
}

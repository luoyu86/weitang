package cn.admobiletop.adsuyi.c;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandlerThread f4184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0331k f4185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f4186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f4192i;
    public long j;
    public long k;
    public int l;
    public int m;
    public int n;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final L f4193a;

        public a(Looper looper, L l) {
            super(looper);
            this.f4193a = l;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                this.f4193a.l();
                return;
            }
            if (i2 == 1) {
                this.f4193a.m();
                return;
            }
            if (i2 == 2) {
                this.f4193a.h(message.arg1);
                return;
            }
            if (i2 == 3) {
                this.f4193a.k(message.arg1);
            } else if (i2 != 4) {
                A.f4107a.post(new K(this, message));
            } else {
                this.f4193a.f((Long) message.obj);
            }
        }
    }

    public L(InterfaceC0331k interfaceC0331k) {
        this.f4185b = interfaceC0331k;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        this.f4184a = handlerThread;
        handlerThread.start();
        S.m(handlerThread.getLooper());
        this.f4186c = new a(handlerThread.getLooper(), this);
    }

    public static long a(int i2, long j) {
        return j / ((long) i2);
    }

    public M b() {
        return new M(this.f4185b.a(), this.f4185b.size(), this.f4187d, this.f4188e, this.f4189f, this.f4190g, this.f4191h, this.f4192i, this.j, this.k, this.l, this.m, this.n, System.currentTimeMillis());
    }

    public void c(long j) {
        Handler handler = this.f4186c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j)));
    }

    public void d(Bitmap bitmap) {
        e(bitmap, 2);
    }

    public final void e(Bitmap bitmap, int i2) {
        int iC = S.c(bitmap);
        Handler handler = this.f4186c;
        handler.sendMessage(handler.obtainMessage(i2, iC, 0));
    }

    public void f(Long l) {
        this.l++;
        long jLongValue = this.f4189f + l.longValue();
        this.f4189f = jLongValue;
        this.f4192i = a(this.l, jLongValue);
    }

    public void g() {
        this.f4186c.sendEmptyMessage(0);
    }

    public void h(long j) {
        int i2 = this.m + 1;
        this.m = i2;
        long j2 = this.f4190g + j;
        this.f4190g = j2;
        this.j = a(i2, j2);
    }

    public void i(Bitmap bitmap) {
        e(bitmap, 3);
    }

    public void j() {
        this.f4186c.sendEmptyMessage(1);
    }

    public void k(long j) {
        this.n++;
        long j2 = this.f4191h + j;
        this.f4191h = j2;
        this.k = a(this.m, j2);
    }

    public void l() {
        this.f4187d++;
    }

    public void m() {
        this.f4188e++;
    }
}

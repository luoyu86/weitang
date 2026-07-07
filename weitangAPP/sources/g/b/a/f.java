package g.b.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public class f extends Handler implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f14706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f14708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14709d;

    public f(c cVar, Looper looper, int i2) {
        super(looper);
        this.f14708c = cVar;
        this.f14707b = i2;
        this.f14706a = new k();
    }

    @Override // g.b.a.l
    public void enqueue(q qVar, Object obj) {
        j jVarA = j.a(qVar, obj);
        synchronized (this) {
            this.f14706a.a(jVarA);
            if (!this.f14709d) {
                this.f14709d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new e("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                j jVarB = this.f14706a.b();
                if (jVarB == null) {
                    synchronized (this) {
                        jVarB = this.f14706a.b();
                        if (jVarB == null) {
                            this.f14709d = false;
                            return;
                        }
                    }
                }
                this.f14708c.e(jVarB);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f14707b);
            if (!sendMessage(obtainMessage())) {
                throw new e("Could not send handler message");
            }
            this.f14709d = true;
        } finally {
            this.f14709d = false;
        }
    }
}

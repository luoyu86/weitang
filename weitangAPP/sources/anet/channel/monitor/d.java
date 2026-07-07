package anet.channel.monitor;

import anet.channel.util.ALog;

/* JADX INFO: loaded from: classes.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f514d;

    public d(b bVar, long j, long j2, long j3) {
        this.f514d = bVar;
        this.f511a = j;
        this.f512b = j2;
        this.f513c = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.f500a++;
        b.f504e += this.f511a;
        if (b.f500a == 1) {
            b.f503d = this.f512b - this.f513c;
        }
        int i2 = b.f500a;
        if (i2 >= 2 && i2 <= 3) {
            long j = this.f513c;
            long j2 = b.f502c;
            if (j >= j2) {
                b.f503d += this.f512b - j;
            } else if (j < j2) {
                long j3 = this.f512b;
                if (j3 >= j2) {
                    long j4 = b.f503d + (j3 - j);
                    b.f503d = j4;
                    b.f503d = j4 - (b.f502c - j);
                }
            }
        }
        b.f501b = this.f513c;
        b.f502c = this.f512b;
        if (b.f500a == 3) {
            b.f508i = (long) this.f514d.n.a(b.f504e, b.f503d);
            b.f505f++;
            b.b(this.f514d);
            if (b.f505f > 30) {
                this.f514d.n.a();
                b.f505f = 3L;
            }
            double d2 = (b.f508i * 0.68d) + (b.f507h * 0.27d) + (b.f506g * 0.05d);
            b.f506g = b.f507h;
            b.f507h = b.f508i;
            if (b.f508i < b.f506g * 0.65d || b.f508i > b.f506g * 2.0d) {
                b.f508i = d2;
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.BandWidthSampler", "NetworkSpeed", null, "mKalmanDataSize", Long.valueOf(b.f504e), "mKalmanTimeUsed", Long.valueOf(b.f503d), "speed", Double.valueOf(b.f508i), "mSpeedKalmanCount", Long.valueOf(b.f505f));
            }
            if (this.f514d.m > 5 || b.f505f == 2) {
                a.a().a(b.f508i);
                this.f514d.m = 0;
                this.f514d.l = b.f508i < b.j ? 1 : 5;
                ALog.i("awcn.BandWidthSampler", "NetworkSpeed notification!", null, "Send Network quality notification.");
            }
            b.f503d = 0L;
            b.f504e = 0L;
            b.f500a = 0;
        }
    }
}

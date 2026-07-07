package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f500a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f501b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f502c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f503d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f504e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f505f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static double f506g = 0.0d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static double f507h = 0.0d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static double f508i = 0.0d;
    public static double j = 40.0d;
    private static volatile boolean k = false;
    private int l;
    private int m;
    private e n;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static b f509a = new b(null);
    }

    public /* synthetic */ b(c cVar) {
        this();
    }

    public static /* synthetic */ int b(b bVar) {
        int i2 = bVar.m;
        bVar.m = i2 + 1;
        return i2;
    }

    public synchronized void d() {
        try {
            ALog.i("awcn.BandWidthSampler", "[startNetworkMeter]", null, "NetworkStatus", NetworkStatusHelper.getStatus());
        } catch (Exception e2) {
            ALog.w("awcn.BandWidthSampler", "startNetworkMeter fail.", null, e2, new Object[0]);
        }
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            k = false;
        } else {
            k = true;
        }
    }

    public void e() {
        k = false;
    }

    private b() {
        this.l = 5;
        this.m = 0;
        this.n = new e();
        NetworkStatusHelper.addStatusChangeListener(new c(this));
    }

    public double c() {
        return f508i;
    }

    public static b a() {
        return a.f509a;
    }

    public int b() {
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            return 1;
        }
        return this.l;
    }

    public void a(long j2, long j3, long j4) {
        if (k) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.BandWidthSampler", "onDataReceived", null, "mRequestStartTime", Long.valueOf(j2), "mRequestFinishedTime", Long.valueOf(j3), "mRequestDataSize", Long.valueOf(j4));
            }
            if (j4 <= 3000 || j2 >= j3) {
                return;
            }
            ThreadPoolExecutorFactory.submitScheduledTask(new d(this, j4, j3, j2));
        }
    }
}

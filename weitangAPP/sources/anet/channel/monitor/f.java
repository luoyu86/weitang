package anet.channel.monitor;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f526c = 40.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f524a = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f527d = true;

    public int a() {
        return 0;
    }

    public boolean a(double d2) {
        return d2 < 40.0d;
    }

    public final boolean b() {
        if (!this.f527d) {
            return false;
        }
        if (System.currentTimeMillis() - this.f525b <= a() * 1000) {
            return true;
        }
        this.f527d = false;
        return false;
    }
}

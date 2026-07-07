package c.r.a.d;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f3156a;

    public static boolean a(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - f3156a < j) {
            return true;
        }
        f3156a = jCurrentTimeMillis;
        return false;
    }

    public static boolean isFastClick() {
        return a(1000L);
    }
}

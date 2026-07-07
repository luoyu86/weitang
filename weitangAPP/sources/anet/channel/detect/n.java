package anet.channel.detect;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f429a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ExceptionDetector f430b = new ExceptionDetector();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static k f431c = new k();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f432d = new AtomicBoolean(false);

    public static void a() {
        try {
            if (f432d.compareAndSet(false, true)) {
                ALog.i("awcn.NetworkDetector", "registerListener", null, new Object[0]);
                f429a.b();
                f430b.a();
                f431c.a();
            }
        } catch (Exception e2) {
            ALog.e("awcn.NetworkDetector", "[registerListener]error", null, e2, new Object[0]);
        }
    }

    public static void a(RequestStatistic requestStatistic) {
        if (f432d.get()) {
            f430b.a(requestStatistic);
        }
    }
}

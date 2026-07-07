package a.a.t;

import android.content.Context;
import anet.channel.monitor.INetworkQualityChangeListener;
import anet.channel.monitor.NetworkSpeed;
import anet.channel.monitor.b;
import anet.channel.monitor.f;
import anet.channel.util.ALog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f227a = new AtomicBoolean(false);

    public static void addListener(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        addListener(iNetworkQualityChangeListener, null);
    }

    public static NetworkSpeed getNetSpeed() {
        NetworkSpeed networkSpeed = NetworkSpeed.Fast;
        try {
            return NetworkSpeed.valueOfCode(b.a().b());
        } catch (Throwable th) {
            ALog.e("anet.Monitor", "getNetworkSpeed failed", null, th, new Object[0]);
            return networkSpeed;
        }
    }

    public static double getNetSpeedValue() {
        return b.a().c();
    }

    @Deprecated
    public static a.a.t.b.a getNetworkSpeed() {
        return a.a.t.b.a.valueOfCode(getNetSpeed().getCode());
    }

    public static synchronized void init() {
        if (f227a.compareAndSet(false, true)) {
            b.a().d();
        }
    }

    public static void removeListener(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        anet.channel.monitor.a.a().a(iNetworkQualityChangeListener);
    }

    public static void start() {
        try {
            b.a().d();
        } catch (Throwable th) {
            ALog.e("anet.Monitor", "start failed", null, th, new Object[0]);
        }
    }

    public static void stop() {
        try {
            b.a().e();
        } catch (Throwable th) {
            ALog.e("anet.Monitor", "stop failed", null, th, new Object[0]);
        }
    }

    public static void addListener(INetworkQualityChangeListener iNetworkQualityChangeListener, f fVar) {
        anet.channel.monitor.a.a().a(iNetworkQualityChangeListener, fVar);
    }

    @Deprecated
    public static synchronized void init(Context context) {
        init();
    }
}

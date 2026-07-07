package anet.channel.monitor;

import anet.channel.util.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<INetworkQualityChangeListener, f> f498b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f499c = new f();

    private a() {
    }

    public static a a() {
        if (f497a == null) {
            synchronized (a.class) {
                if (f497a == null) {
                    f497a = new a();
                }
            }
        }
        return f497a;
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener, f fVar) {
        if (iNetworkQualityChangeListener == null) {
            ALog.e("BandWidthListenerHelp", "listener is null", null, new Object[0]);
            return;
        }
        if (fVar == null) {
            this.f499c.f525b = System.currentTimeMillis();
            this.f498b.put(iNetworkQualityChangeListener, this.f499c);
        } else {
            fVar.f525b = System.currentTimeMillis();
            this.f498b.put(iNetworkQualityChangeListener, fVar);
        }
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        this.f498b.remove(iNetworkQualityChangeListener);
    }

    public void a(double d2) {
        boolean zA;
        for (Map.Entry<INetworkQualityChangeListener, f> entry : this.f498b.entrySet()) {
            INetworkQualityChangeListener key = entry.getKey();
            f value = entry.getValue();
            if (key != null && value != null && !value.b() && value.f524a != (zA = value.a(d2))) {
                value.f524a = zA;
                key.onNetworkQualityChanged(zA ? NetworkSpeed.Slow : NetworkSpeed.Fast);
            }
        }
    }
}

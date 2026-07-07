package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.util.ALog;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ anet.channel.entity.b f375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Session f376c;

    public b(Session session, int i2, anet.channel.entity.b bVar) {
        this.f376c = session;
        this.f374a = i2;
        this.f375b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Map<EventCb, Integer> map = this.f376c.f323b;
            if (map != null) {
                for (EventCb eventCb : map.keySet()) {
                    if (eventCb != null) {
                        int iIntValue = this.f376c.f323b.get(eventCb).intValue();
                        int i2 = this.f374a;
                        if ((iIntValue & i2) != 0) {
                            try {
                                eventCb.onEvent(this.f376c, i2, this.f375b);
                            } catch (Exception e2) {
                                ALog.e("awcn.Session", e2.toString(), this.f376c.p, new Object[0]);
                            }
                        }
                    }
                }
            }
        } catch (Exception e3) {
            ALog.e("awcn.Session", "handleCallbacks", this.f376c.p, e3, new Object[0]);
        }
    }
}

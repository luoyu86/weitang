package anet.channel.e;

import androidx.core.view.InputDeviceCompat;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.session.TnetSpdySession;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NetworkStatusHelper.NetworkStatus f450b;

    public e(List list, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f449a = list;
        this.f450b = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        IConnStrategy iConnStrategy = (IConnStrategy) this.f449a.get(0);
        TnetSpdySession tnetSpdySession = new TnetSpdySession(GlobalAppRuntimeInfo.getContext(), new anet.channel.entity.a("https://" + a.f438b, "Http3Detect" + a.f444h.getAndIncrement(), a.b(iConnStrategy)));
        tnetSpdySession.registerEventcb(InputDeviceCompat.SOURCE_KEYBOARD, new f(this, iConnStrategy));
        tnetSpdySession.f331q.isCommitted = true;
        tnetSpdySession.connect();
    }
}

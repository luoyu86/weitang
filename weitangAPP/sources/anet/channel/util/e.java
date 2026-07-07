package anet.channel.util;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.NetTypeStat;
import anet.channel.status.NetworkStatusHelper;

/* JADX INFO: loaded from: classes.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f723a;

    public e(d dVar) {
        this.f723a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVarK;
        try {
            if (this.f723a.f721a.equals(c.b(NetworkStatusHelper.getStatus()))) {
                ALog.e("awcn.Inet64Util", "startIpStackDetect double check", null, new Object[0]);
                int iJ = c.j();
                d dVar = this.f723a;
                if (dVar.f722b.ipStackType != iJ) {
                    c.f720e.put(dVar.f721a, Integer.valueOf(iJ));
                    NetTypeStat netTypeStat = this.f723a.f722b;
                    netTypeStat.lastIpStackType = netTypeStat.ipStackType;
                    netTypeStat.ipStackType = iJ;
                }
                if ((iJ == 2 || iJ == 3) && (fVarK = c.k()) != null) {
                    c.f719d.put(this.f723a.f721a, fVarK);
                    this.f723a.f722b.nat64Prefix = fVarK.toString();
                }
                if (GlobalAppRuntimeInfo.isTargetProcess()) {
                    AppMonitor.getInstance().commitStat(this.f723a.f722b);
                }
            }
        } catch (Exception unused) {
        }
    }
}

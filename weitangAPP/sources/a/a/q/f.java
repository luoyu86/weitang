package a.a.q;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.detect.n;
import anet.channel.statist.RequestMonitor;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.ParcelableNetworkListener;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DefaultFinishEvent f211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ParcelableNetworkListener f212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f213c;

    public f(c cVar, DefaultFinishEvent defaultFinishEvent, ParcelableNetworkListener parcelableNetworkListener) {
        this.f213c = cVar;
        this.f211a = defaultFinishEvent;
        this.f212b = parcelableNetworkListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        DefaultFinishEvent defaultFinishEvent = this.f211a;
        String strOptString = null;
        if (defaultFinishEvent != null) {
            defaultFinishEvent.setContext(null);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            RequestStatistic requestStatistic = this.f211a.f740e;
            if (requestStatistic != null) {
                requestStatistic.rspCbStart = jCurrentTimeMillis;
                requestStatistic.lastProcessTime = jCurrentTimeMillis - requestStatistic.rspEnd;
                requestStatistic.oneWayTime = requestStatistic.retryCostTime + (jCurrentTimeMillis - requestStatistic.start);
                this.f211a.getStatisticData().filledBy(requestStatistic);
            }
            this.f212b.onFinished(this.f211a);
            if (requestStatistic != null) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                requestStatistic.rspCbEnd = jCurrentTimeMillis2;
                requestStatistic.callbackTime = jCurrentTimeMillis2 - jCurrentTimeMillis;
                anet.channel.fulltrace.a.a().commitRequest(requestStatistic.traceId, requestStatistic);
            }
            if (this.f213c.f199c != null) {
                this.f213c.f199c.writeEnd();
            }
            if (requestStatistic != null) {
                ALog.e("anet.Repeater", "[traceId:" + requestStatistic.traceId + "]end, " + requestStatistic.toString(), this.f213c.f198b, new Object[0]);
                CopyOnWriteArrayList<String> bucketInfo = GlobalAppRuntimeInfo.getBucketInfo();
                if (bucketInfo != null) {
                    int size = bucketInfo.size();
                    for (int i2 = 0; i2 < size - 1; i2 += 2) {
                        requestStatistic.putExtra(bucketInfo.get(i2), bucketInfo.get(i2 + 1));
                    }
                }
                if (GlobalAppRuntimeInfo.isAppBackground()) {
                    requestStatistic.putExtra("restrictBg", Integer.valueOf(NetworkStatusHelper.getRestrictBackgroundStatus()));
                }
                anet.channel.fulltrace.b sceneInfo = anet.channel.fulltrace.a.a().getSceneInfo();
                if (sceneInfo != null) {
                    ALog.i("anet.Repeater", sceneInfo.toString(), this.f213c.f198b, new Object[0]);
                    long j = requestStatistic.start;
                    long j2 = sceneInfo.f473c;
                    requestStatistic.sinceInitTime = j - j2;
                    int i3 = sceneInfo.f471a;
                    requestStatistic.startType = i3;
                    if (i3 != 1) {
                        requestStatistic.sinceLastLaunchTime = j2 - sceneInfo.f474d;
                    }
                    requestStatistic.deviceLevel = sceneInfo.f475e;
                    requestStatistic.isFromExternal = sceneInfo.f472b ? 1 : 0;
                    requestStatistic.speedBucket = sceneInfo.f476f;
                    requestStatistic.abTestBucket = sceneInfo.f477g;
                }
                requestStatistic.serializeTransferTime = requestStatistic.reqServiceTransmissionEnd - requestStatistic.netReqStart;
                requestStatistic.userInfo = this.f213c.f201e.a("RequestUserInfo");
                AppMonitor.getInstance().commitStat(requestStatistic);
                if (a.a.o.b.isRequestInMonitorList(requestStatistic)) {
                    AppMonitor.getInstance().commitStat(new RequestMonitor(requestStatistic));
                }
                try {
                    String str = requestStatistic.ip;
                    JSONObject jSONObject = requestStatistic.extra;
                    if (jSONObject != null) {
                        strOptString = jSONObject.optString("firstIp");
                    }
                    if (anet.channel.strategy.utils.c.b(str) || anet.channel.strategy.utils.c.b(strOptString)) {
                        AppMonitor.getInstance().commitStat(new RequestMonitor(requestStatistic));
                    }
                } catch (Exception unused) {
                }
                a.a.u.b.getNetworkStat().put(this.f213c.f201e.g(), this.f211a.getStatisticData());
                n.a(requestStatistic);
            }
        } catch (Throwable unused2) {
        }
    }
}

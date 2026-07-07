package a.a.w;

import a.a.n.a;
import anet.channel.bytes.ByteArray;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;

/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a.a.n.a f235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f236c = false;

    public b(k kVar, a.a.n.a aVar) {
        this.f234a = null;
        this.f235b = null;
        this.f234a = kVar;
        this.f235b = aVar;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f236c = true;
        this.f234a.f275a.f219f.ret = 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zEquals;
        a.C0000a c0000a;
        if (this.f236c) {
            return;
        }
        a.a.q.g gVar = this.f234a.f275a;
        RequestStatistic requestStatistic = gVar.f219f;
        if (this.f235b != null) {
            String strG = gVar.g();
            Request requestA = this.f234a.f275a.a();
            String str = requestA.getHeaders().get("Cache-Control");
            boolean zEquals2 = "no-store".equals(str);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (zEquals2) {
                this.f235b.remove(strG);
                zEquals = false;
                c0000a = null;
            } else {
                zEquals = "no-cache".equals(str);
                c0000a = this.f235b.get(strG);
                if (ALog.isPrintLog(2)) {
                    String str2 = this.f234a.f277c;
                    Object[] objArr = new Object[8];
                    objArr[0] = "hit";
                    objArr[1] = Boolean.valueOf(c0000a != null);
                    objArr[2] = "cost";
                    objArr[3] = Long.valueOf(requestStatistic.cacheTime);
                    objArr[4] = "length";
                    objArr[5] = Integer.valueOf(c0000a != null ? c0000a.data.length : 0);
                    objArr[6] = "key";
                    objArr[7] = strG;
                    ALog.i("anet.CacheTask", "read cache", str2, objArr);
                }
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            requestStatistic.cacheTime = jCurrentTimeMillis2 - jCurrentTimeMillis;
            if (c0000a == null || zEquals || !c0000a.isFresh()) {
                if (this.f236c) {
                    return;
                }
                f fVar = new f(this.f234a, zEquals2 ? null : this.f235b, c0000a);
                this.f234a.f279e = fVar;
                fVar.run();
                return;
            }
            if (this.f234a.f278d.compareAndSet(false, true)) {
                this.f234a.a();
                requestStatistic.ret = 1;
                requestStatistic.statusCode = 200;
                requestStatistic.msg = "SUCCESS";
                requestStatistic.protocolType = "cache";
                requestStatistic.rspEnd = jCurrentTimeMillis2;
                requestStatistic.processTime = jCurrentTimeMillis2 - requestStatistic.start;
                if (ALog.isPrintLog(2)) {
                    k kVar = this.f234a;
                    ALog.i("anet.CacheTask", "hit fresh cache", kVar.f277c, "URL", kVar.f275a.f().urlString());
                }
                this.f234a.f276b.onResponseCode(200, c0000a.responseHeaders);
                a.a.s.a aVar = this.f234a.f276b;
                byte[] bArr = c0000a.data;
                aVar.onDataReceiveSize(1, bArr.length, ByteArray.wrap(bArr));
                this.f234a.f276b.onFinish(new DefaultFinishEvent(200, "SUCCESS", requestA));
            }
        }
    }
}

package a.a.w;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d implements RequestCb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f243a;

    public d(c cVar) {
        this.f243a = cVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
        if (this.f243a.f239c.f278d.get()) {
            return;
        }
        c.c(this.f243a);
        if (this.f243a.f239c.f276b != null) {
            this.f243a.f239c.f276b.onDataReceiveSize(this.f243a.f241e, this.f243a.f240d, byteArray);
        }
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        if (this.f243a.f239c.f278d.getAndSet(true)) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.DegradeTask", "[onFinish]", this.f243a.f239c.f277c, "code", Integer.valueOf(i2), "msg", str);
        }
        this.f243a.f239c.a();
        requestStatistic.isDone.set(true);
        if (this.f243a.f239c.f276b != null) {
            this.f243a.f239c.f276b.onFinish(new DefaultFinishEvent(i2, str, this.f243a.f242f));
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        if (this.f243a.f239c.f278d.get()) {
            return;
        }
        this.f243a.f239c.a();
        a.a.p.a.setCookie(this.f243a.f239c.f275a.g(), map);
        this.f243a.f240d = HttpHelper.parseContentLength(map);
        if (this.f243a.f239c.f276b != null) {
            this.f243a.f239c.f276b.onResponseCode(i2, map);
        }
    }
}

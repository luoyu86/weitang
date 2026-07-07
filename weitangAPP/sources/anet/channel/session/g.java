package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g implements RequestCb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f576a;

    public g(f fVar) {
        this.f576a = fVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
        this.f576a.f573b.onDataReceive(byteArray, z);
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        if (i2 <= 0 && i2 != -204) {
            this.f576a.f575d.handleCallbacks(2, new anet.channel.entity.b(2, 0, "Http connect fail"));
        }
        this.f576a.f573b.onFinish(i2, str, requestStatistic);
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        ALog.i("awcn.HttpSession", "", this.f576a.f572a.getSeq(), "httpStatusCode", Integer.valueOf(i2));
        ALog.i("awcn.HttpSession", "", this.f576a.f572a.getSeq(), "response headers", map);
        this.f576a.f573b.onResponseCode(i2, map);
        this.f576a.f574c.serverRT = HttpHelper.parseServerRT(map);
        f fVar = this.f576a;
        fVar.f575d.handleResponseCode(fVar.f572a, i2);
        f fVar2 = this.f576a;
        fVar2.f575d.handleResponseHeaders(fVar2.f572a, map);
    }
}

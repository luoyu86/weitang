package a.a.w;

import a.a.n.a;
import a.a.w.f;
import android.support.v4.media.session.PlaybackStateCompat;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.flow.FlowStat;
import anet.channel.flow.NetworkAnalysis;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.HttpUrl;
import anetwork.channel.aidl.DefaultFinishEvent;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class j implements RequestCb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Request f272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RequestStatistic f273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f274c;

    public j(f fVar, Request request, RequestStatistic requestStatistic) {
        this.f274c = fVar;
        this.f272a = request;
        this.f273b = requestStatistic;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
        if (this.f274c.f253h.get()) {
            return;
        }
        f fVar = this.f274c;
        if (fVar.j == 0) {
            ALog.i("anet.NetworkTask", "[onDataReceive] receive first data chunk!", fVar.f246a.f277c, new Object[0]);
        }
        if (z) {
            ALog.i("anet.NetworkTask", "[onDataReceive] receive last data chunk!", this.f274c.f246a.f277c, new Object[0]);
        }
        f fVar2 = this.f274c;
        int i2 = fVar2.j + 1;
        fVar2.j = i2;
        try {
            f.a aVar = fVar2.m;
            if (aVar != null) {
                aVar.f257c.add(byteArray);
                if (this.f273b.recDataSize > PlaybackStateCompat.ACTION_PREPARE_FROM_URI || z) {
                    f fVar3 = this.f274c;
                    fVar3.j = fVar3.m.a(fVar3.f246a.f276b, fVar3.f254i);
                    f fVar4 = this.f274c;
                    fVar4.k = true;
                    fVar4.l = fVar4.j > 1;
                    fVar4.m = null;
                }
            } else {
                fVar2.f246a.f276b.onDataReceiveSize(i2, fVar2.f254i, byteArray);
                this.f274c.l = true;
            }
            ByteArrayOutputStream byteArrayOutputStream = this.f274c.f249d;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.write(byteArray.getBuffer(), 0, byteArray.getDataLength());
                if (z) {
                    String strG = this.f274c.f246a.f275a.g();
                    f fVar5 = this.f274c;
                    fVar5.f248c.data = fVar5.f249d.toByteArray();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    f fVar6 = this.f274c;
                    fVar6.f247b.put(strG, fVar6.f248c);
                    ALog.i("anet.NetworkTask", "write cache", this.f274c.f246a.f277c, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "size", Integer.valueOf(this.f274c.f248c.data.length), "key", strG);
                }
            }
        } catch (Exception e2) {
            ALog.w("anet.NetworkTask", "[onDataReceive] error.", this.f274c.f246a.f277c, e2, new Object[0]);
        }
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        String strValueOf;
        DefaultFinishEvent defaultFinishEvent;
        if (this.f274c.f253h.getAndSet(true)) {
            return;
        }
        int i3 = 3;
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkTask", "[onFinish]", this.f274c.f246a.f277c, "code", Integer.valueOf(i2), "msg", str);
        }
        if (i2 < 0) {
            try {
                if (this.f274c.f246a.f275a.d()) {
                    f fVar = this.f274c;
                    if (!fVar.k && !fVar.l) {
                        ALog.e("anet.NetworkTask", "clear response buffer and retry", fVar.f246a.f277c, new Object[0]);
                        f.a aVar = this.f274c.m;
                        if (aVar != null) {
                            if (!aVar.f257c.isEmpty()) {
                                i3 = 4;
                            }
                            requestStatistic.roaming = i3;
                            this.f274c.m.b();
                            this.f274c.m = null;
                        }
                        if (this.f274c.f246a.f275a.f218e == 0) {
                            requestStatistic.firstProtocol = requestStatistic.protocolType;
                            requestStatistic.firstErrorCode = requestStatistic.tnetErrorCode != 0 ? requestStatistic.tnetErrorCode : i2;
                        }
                        this.f274c.f246a.f275a.k();
                        this.f274c.f246a.f278d = new AtomicBoolean();
                        f fVar2 = this.f274c;
                        k kVar = fVar2.f246a;
                        kVar.f279e = new f(kVar, fVar2.f247b, fVar2.f248c);
                        if (requestStatistic.tnetErrorCode != 0) {
                            strValueOf = i2 + "|" + requestStatistic.protocolType + "|" + requestStatistic.tnetErrorCode;
                            requestStatistic.tnetErrorCode = 0;
                        } else {
                            strValueOf = String.valueOf(i2);
                        }
                        requestStatistic.appendErrorTrace(strValueOf);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        requestStatistic.retryCostTime += jCurrentTimeMillis - requestStatistic.start;
                        requestStatistic.start = jCurrentTimeMillis;
                        ThreadPoolExecutorFactory.submitPriorityTask(this.f274c.f246a.f279e, ThreadPoolExecutorFactory.Priority.HIGH);
                        return;
                    }
                    requestStatistic.msg += ":回调后触发重试";
                    f fVar3 = this.f274c;
                    if (fVar3.l) {
                        requestStatistic.roaming = 2;
                    } else if (fVar3.k) {
                        requestStatistic.roaming = 1;
                    }
                    ALog.e("anet.NetworkTask", "Cannot retry request after onHeader/onDataReceived callback!", fVar3.f246a.f277c, new Object[0]);
                }
            } catch (Exception unused) {
                return;
            }
        }
        f fVar4 = this.f274c;
        f.a aVar2 = fVar4.m;
        if (aVar2 != null) {
            aVar2.a(fVar4.f246a.f276b, fVar4.f254i);
        }
        this.f274c.f246a.a();
        requestStatistic.isDone.set(true);
        if (this.f274c.f246a.f275a.j() && requestStatistic.contentLength != 0 && requestStatistic.contentLength != requestStatistic.rspBodyDeflateSize) {
            requestStatistic.ret = 0;
            requestStatistic.statusCode = ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH;
            str = ErrorConstant.getErrMsg(ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH);
            requestStatistic.msg = str;
            f fVar5 = this.f274c;
            ALog.e("anet.NetworkTask", "received data length not match with content-length", fVar5.f246a.f277c, "content-length", Integer.valueOf(fVar5.f254i), "recDataLength", Long.valueOf(requestStatistic.rspBodyDeflateSize));
            ExceptionStatistic exceptionStatistic = new ExceptionStatistic(ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH, str, "rt");
            exceptionStatistic.url = this.f274c.f246a.f275a.g();
            AppMonitor.getInstance().commitStat(exceptionStatistic);
            i2 = ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH;
        }
        if (i2 != 304 || this.f274c.f248c == null) {
            defaultFinishEvent = new DefaultFinishEvent(i2, str, this.f272a);
        } else {
            requestStatistic.protocolType = "cache";
            defaultFinishEvent = new DefaultFinishEvent(200, str, this.f272a);
        }
        this.f274c.f246a.f276b.onFinish(defaultFinishEvent);
        if (i2 >= 0) {
            anet.channel.monitor.b.a().a(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.rspHeadDeflateSize + requestStatistic.rspBodyDeflateSize);
        } else {
            requestStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        }
        NetworkAnalysis.getInstance().commitFlow(new FlowStat(this.f274c.f250e, requestStatistic));
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        String singleHeaderFieldByKey;
        if (this.f274c.f253h.get()) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkTask", "onResponseCode", this.f272a.getSeq(), "code", Integer.valueOf(i2));
            ALog.i("anet.NetworkTask", "onResponseCode", this.f272a.getSeq(), TTDownloadField.TT_HEADERS, map);
        }
        if (HttpHelper.checkRedirect(this.f272a, i2) && (singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Location")) != null) {
            HttpUrl httpUrl = HttpUrl.parse(singleHeaderFieldByKey);
            if (httpUrl != null) {
                if (this.f274c.f253h.compareAndSet(false, true)) {
                    httpUrl.lockScheme();
                    this.f274c.f246a.f275a.a(httpUrl);
                    this.f274c.f246a.f278d = new AtomicBoolean();
                    k kVar = this.f274c.f246a;
                    kVar.f279e = new f(kVar, null, null);
                    this.f273b.recordRedirect(i2, httpUrl.simpleUrlString());
                    this.f273b.locationUrl = singleHeaderFieldByKey;
                    ThreadPoolExecutorFactory.submitPriorityTask(this.f274c.f246a.f279e, ThreadPoolExecutorFactory.Priority.HIGH);
                    return;
                }
                return;
            }
            ALog.e("anet.NetworkTask", "redirect url is invalid!", this.f272a.getSeq(), "redirect url", singleHeaderFieldByKey);
        }
        try {
            this.f274c.f246a.a();
            a.a.p.a.setCookie(this.f274c.f246a.f275a.g(), map);
            this.f274c.f254i = HttpHelper.parseContentLength(map);
            String strG = this.f274c.f246a.f275a.g();
            f fVar = this.f274c;
            a.C0000a c0000a = fVar.f248c;
            if (c0000a != null && i2 == 304) {
                c0000a.responseHeaders.putAll(map);
                a.C0000a c0000aA = a.a.n.d.a(map);
                if (c0000aA != null) {
                    long j = c0000aA.ttl;
                    a.C0000a c0000a2 = this.f274c.f248c;
                    if (j > c0000a2.ttl) {
                        c0000a2.ttl = j;
                    }
                }
                f fVar2 = this.f274c;
                fVar2.f246a.f276b.onResponseCode(200, fVar2.f248c.responseHeaders);
                f fVar3 = this.f274c;
                a.a.s.a aVar = fVar3.f246a.f276b;
                byte[] bArr = fVar3.f248c.data;
                aVar.onDataReceiveSize(1, bArr.length, ByteArray.wrap(bArr));
                long jCurrentTimeMillis = System.currentTimeMillis();
                f fVar4 = this.f274c;
                fVar4.f247b.put(strG, fVar4.f248c);
                ALog.i("anet.NetworkTask", "update cache", this.f274c.f246a.f277c, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "key", strG);
                return;
            }
            if (fVar.f247b != null) {
                if ("no-store".equals(HttpHelper.getSingleHeaderFieldByKey(map, "Cache-Control"))) {
                    this.f274c.f247b.remove(strG);
                } else {
                    f fVar5 = this.f274c;
                    a.C0000a c0000aA2 = a.a.n.d.a(map);
                    fVar5.f248c = c0000aA2;
                    if (c0000aA2 != null) {
                        HttpHelper.removeHeaderFiledByKey(map, "Cache-Control");
                        map.put("Cache-Control", Arrays.asList("no-store"));
                        f fVar6 = this.f274c;
                        int i3 = this.f274c.f254i;
                        if (i3 == 0) {
                            i3 = 5120;
                        }
                        fVar6.f249d = new ByteArrayOutputStream(i3);
                    }
                }
            }
            map.put(HttpConstant.X_PROTOCOL, Arrays.asList(this.f273b.protocolType));
            if (!"open".equalsIgnoreCase(HttpHelper.getSingleHeaderFieldByKey(map, HttpConstant.STREAMING_PARSER)) && a.a.o.b.isResponseBufferEnable()) {
                f fVar7 = this.f274c;
                if (fVar7.f254i <= 131072) {
                    fVar7.m = new f.a(i2, map);
                    return;
                }
            }
            this.f274c.f246a.f276b.onResponseCode(i2, map);
            this.f274c.k = true;
        } catch (Exception e2) {
            ALog.w("anet.NetworkTask", "[onResponseCode] error.", this.f274c.f246a.f277c, e2, new Object[0]);
        }
    }
}

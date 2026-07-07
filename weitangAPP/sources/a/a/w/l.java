package a.a.w;

import a.a.s.b;
import android.os.Looper;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.DefaultFinishEvent;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f281a;

    public class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Request f283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a.a.s.a f284c;

        public a(int i2, Request request, a.a.s.a aVar) {
            this.f282a = 0;
            this.f283b = null;
            this.f284c = null;
            this.f282a = i2;
            this.f283b = request;
            this.f284c = aVar;
        }

        @Override // a.a.s.b.a
        public a.a.s.a callback() {
            return this.f284c;
        }

        @Override // a.a.s.b.a
        public Future proceed(Request request, a.a.s.a aVar) {
            if (l.this.f281a.f278d.get()) {
                ALog.i("anet.UnifiedRequestTask", "request canneled or timeout in processing interceptor", request.getSeq(), new Object[0]);
                return null;
            }
            if (this.f282a < a.a.s.c.getSize()) {
                return a.a.s.c.getInterceptor(this.f282a).intercept(l.this.new a(this.f282a + 1, request, aVar));
            }
            l.this.f281a.f275a.a(request);
            l.this.f281a.f276b = aVar;
            a.a.n.a cache = a.a.o.b.isHttpCacheEnable() ? a.a.n.b.getCache(l.this.f281a.f275a.g(), l.this.f281a.f275a.h()) : null;
            k kVar = l.this.f281a;
            kVar.f279e = cache != null ? new b(kVar, cache) : new f(kVar, null, null);
            l.this.f281a.f279e.run();
            l.this.d();
            return null;
        }

        @Override // a.a.s.b.a
        public Request request() {
            return this.f283b;
        }
    }

    public l(a.a.q.g gVar, a.a.q.c cVar) {
        cVar.a(gVar.f222i);
        this.f281a = new k(gVar, cVar);
    }

    public Future a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f281a.f275a.f219f.reqServiceTransmissionEnd = jCurrentTimeMillis;
        this.f281a.f275a.f219f.start = jCurrentTimeMillis;
        a.a.q.g gVar = this.f281a.f275a;
        gVar.f219f.isReqSync = gVar.c();
        this.f281a.f275a.f219f.isReqMain = Looper.myLooper() == Looper.getMainLooper();
        try {
            a.a.q.g gVar2 = this.f281a.f275a;
            gVar2.f219f.netReqStart = Long.valueOf(gVar2.a("f-netReqStart")).longValue();
        } catch (Exception unused) {
        }
        String strA = this.f281a.f275a.a("f-traceId");
        if (!TextUtils.isEmpty(strA)) {
            this.f281a.f275a.f219f.traceId = strA;
        }
        String strA2 = this.f281a.f275a.a("f-reqProcess");
        a.a.q.g gVar3 = this.f281a.f275a;
        RequestStatistic requestStatistic = gVar3.f219f;
        requestStatistic.process = strA2;
        requestStatistic.pTraceId = gVar3.a("f-pTraceId");
        String str = "[traceId:" + strA + "]" + RequestBannerParamBo.GET_SPLASH_TYPE;
        k kVar = this.f281a;
        ALog.e("anet.UnifiedRequestTask", str, kVar.f277c, "bizId", kVar.f275a.a().getBizId(), "processFrom", strA2, AgooConstants.OPEN_URL, this.f281a.f275a.g());
        if (!a.a.o.b.isUrlInDegradeList(this.f281a.f275a.f())) {
            ThreadPoolExecutorFactory.submitPriorityTask(new n(this), ThreadPoolExecutorFactory.Priority.HIGH);
            return new e(this);
        }
        c cVar = new c(this.f281a);
        this.f281a.f279e = cVar;
        cVar.f238b = new anet.channel.request.b(ThreadPoolExecutorFactory.submitBackupTask(new m(this)), this.f281a.f275a.a().getSeq());
        d();
        return new e(this);
    }

    public void c() {
        if (this.f281a.f278d.compareAndSet(false, true)) {
            ALog.e("anet.UnifiedRequestTask", "task cancelled", this.f281a.f277c, "URL", this.f281a.f275a.f().simpleUrlString());
            RequestStatistic requestStatistic = this.f281a.f275a.f219f;
            if (requestStatistic.isDone.compareAndSet(false, true)) {
                requestStatistic.ret = 2;
                requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_CANCEL;
                requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_CANCEL);
                requestStatistic.rspEnd = System.currentTimeMillis();
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_CANCEL, null, requestStatistic, null));
                if (requestStatistic.recDataSize > OSSConstants.MIN_PART_SIZE_LIMIT) {
                    anet.channel.monitor.b.a().a(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.recDataSize);
                }
            }
            this.f281a.b();
            this.f281a.a();
            this.f281a.f276b.onFinish(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_CANCEL, (String) null, this.f281a.f275a.a()));
        }
    }

    public final void d() {
        this.f281a.f280f = ThreadPoolExecutorFactory.submitScheduledTask(new o(this), this.f281a.f275a.b(), TimeUnit.MILLISECONDS);
    }
}

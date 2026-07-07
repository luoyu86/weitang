package a.a.w;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.DefaultFinishEvent;

/* JADX INFO: loaded from: classes.dex */
public class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f288a;

    public o(l lVar) {
        this.f288a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f288a.f281a.f278d.compareAndSet(false, true)) {
            RequestStatistic requestStatistic = this.f288a.f281a.f275a.f219f;
            if (requestStatistic.isDone.compareAndSet(false, true)) {
                requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_TIME_OUT;
                requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_TIME_OUT);
                requestStatistic.rspEnd = System.currentTimeMillis();
                ALog.e("anet.UnifiedRequestTask", "task time out", this.f288a.f281a.f277c, "rs", requestStatistic);
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_TIME_OUT, null, requestStatistic, null));
            }
            this.f288a.f281a.b();
            this.f288a.f281a.f276b.onFinish(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_TIME_OUT, (String) null, this.f288a.f281a.f275a.a()));
        }
    }
}

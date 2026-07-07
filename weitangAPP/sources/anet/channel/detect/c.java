package anet.channel.detect;

import android.text.TextUtils;
import android.util.Pair;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RequestStatistic f409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExceptionDetector f410b;

    public c(ExceptionDetector exceptionDetector, RequestStatistic requestStatistic) {
        this.f410b = exceptionDetector;
        this.f409a = requestStatistic;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            RequestStatistic requestStatistic = this.f409a;
            if (requestStatistic == null) {
                return;
            }
            if (!TextUtils.isEmpty(requestStatistic.ip) && this.f409a.ret == 0) {
                if ("guide-acs.m.taobao.com".equalsIgnoreCase(this.f409a.host)) {
                    this.f410b.f394b = this.f409a.ip;
                } else if ("msgacs.m.taobao.com".equalsIgnoreCase(this.f409a.host)) {
                    this.f410b.f395c = this.f409a.ip;
                } else if ("gw.alicdn.com".equalsIgnoreCase(this.f409a.host)) {
                    this.f410b.f396d = this.f409a.ip;
                }
            }
            if (!TextUtils.isEmpty(this.f409a.url)) {
                this.f410b.f397e.add(Pair.create(this.f409a.url, Integer.valueOf(this.f409a.statusCode)));
            }
            if (this.f410b.c()) {
                this.f410b.b();
            }
        } catch (Throwable th) {
            ALog.e("anet.ExceptionDetector", "network detect fail.", null, th, new Object[0]);
        }
    }
}

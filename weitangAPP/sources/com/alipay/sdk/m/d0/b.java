package com.alipay.sdk.m.d0;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataReportRequest f5306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f5307b;

    public b(c cVar, DataReportRequest dataReportRequest) {
        this.f5307b = cVar;
        this.f5306a = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DataReportResult unused = c.f5309e = this.f5307b.f5312c.reportData(this.f5306a);
        } catch (Throwable th) {
            DataReportResult unused2 = c.f5309e = new DataReportResult();
            c.f5309e.success = false;
            c.f5309e.resultCode = "static data rpc upload error, " + com.alipay.sdk.m.z.a.a(th);
            new StringBuilder("rpc failed:").append(com.alipay.sdk.m.z.a.a(th));
        }
    }
}

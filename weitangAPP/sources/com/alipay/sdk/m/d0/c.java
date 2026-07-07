package com.alipay.sdk.m.d0;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f5308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static DataReportResult f5309e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f5310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BugTrackMessageService f5311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataReportService f5312c;

    public c(Context context, String str) {
        this.f5310a = null;
        this.f5311b = null;
        this.f5312c = null;
        aa aaVar = new aa();
        aaVar.a(str);
        h hVar = new h(context);
        this.f5310a = hVar;
        this.f5311b = (BugTrackMessageService) hVar.a(BugTrackMessageService.class, aaVar);
        this.f5312c = (DataReportService) this.f5310a.a(DataReportService.class, aaVar);
    }

    public static synchronized c a(Context context, String str) {
        if (f5308d == null) {
            f5308d = new c(context, str);
        }
        return f5308d;
    }

    @Override // com.alipay.sdk.m.d0.a
    public DataReportResult a(DataReportRequest dataReportRequest) throws InterruptedException {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.f5312c != null) {
            f5309e = null;
            new Thread(new b(this, dataReportRequest)).start();
            for (int i2 = com.alipay.sdk.m.e0.a.f5315a; f5309e == null && i2 >= 0; i2 -= 50) {
                Thread.sleep(50L);
            }
        }
        return f5309e;
    }

    @Override // com.alipay.sdk.m.d0.a
    public boolean logCollect(String str) {
        BugTrackMessageService bugTrackMessageService;
        if (com.alipay.sdk.m.z.a.a(str) || (bugTrackMessageService = this.f5311b) == null) {
            return false;
        }
        String strLogCollect = null;
        try {
            strLogCollect = bugTrackMessageService.logCollect(com.alipay.sdk.m.z.a.f(str));
        } catch (Throwable unused) {
        }
        if (com.alipay.sdk.m.z.a.a(strLogCollect)) {
            return false;
        }
        return ((Boolean) new JSONObject(strLogCollect).get(com.taobao.agoo.a.a.b.JSON_SUCCESS)).booleanValue();
    }
}

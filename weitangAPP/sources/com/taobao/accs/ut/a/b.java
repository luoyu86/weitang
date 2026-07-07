package com.taobao.accs.ut.a;

import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10430f = false;

    private void b(String str) {
        String str2;
        String strValueOf;
        if (this.f10430f) {
            return;
        }
        this.f10430f = true;
        HashMap map = new HashMap();
        try {
            str2 = this.f10425a;
            try {
                strValueOf = String.valueOf(Constants.SDK_VERSION_CODE);
            } catch (Throwable th) {
                th = th;
                strValueOf = null;
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
            strValueOf = null;
        }
        try {
            map.put("device_id", this.f10425a);
            map.put("bind_date", this.f10426b);
            map.put("ret", this.f10427c ? OperatorName.CURVE_TO_REPLICATE_FINAL_POINT : OperatorName.ENDPATH);
            map.put("fail_reasons", this.f10428d);
            map.put("user_id", this.f10429e);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("accs.BindUserStatistic", UTMini.getCommitInfo(66001, str2, (String) null, strValueOf, map), new Object[0]);
            }
            UTMini.getInstance().commitEvent(66001, str, str2, (Object) null, strValueOf, map);
        } catch (Throwable th3) {
            th = th3;
            ALog.d("accs.BindUserStatistic", UTMini.getCommitInfo(66001, str2, (String) null, strValueOf, map) + " " + th.toString(), new Object[0]);
        }
    }

    public void a(String str) {
        this.f10428d = str;
    }

    public void a(ErrorCode errorCode) {
        if (errorCode.getCodeInt() != AccsErrorCode.SUCCESS.getCodeInt()) {
            a(errorCode.getMsg());
        }
    }

    public void a() {
        b("BindUser");
    }
}

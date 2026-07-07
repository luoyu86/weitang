package com.taobao.accs.ut.a;

import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10424e = false;

    private void b(String str) {
        String str2;
        String strValueOf;
        if (this.f10424e) {
            return;
        }
        this.f10424e = true;
        HashMap map = new HashMap();
        try {
            str2 = this.f10420a;
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
            map.put("device_id", this.f10420a);
            map.put("bind_date", this.f10421b);
            map.put("ret", this.f10422c ? OperatorName.CURVE_TO_REPLICATE_FINAL_POINT : OperatorName.ENDPATH);
            map.put("fail_reasons", this.f10423d);
            map.put("push_token", "");
            UTMini.getInstance().commitEvent(66001, str, str2, (Object) null, strValueOf, map);
        } catch (Throwable th3) {
            th = th3;
            ALog.d("BindAppStatistic", UTMini.getCommitInfo(66001, str2, (String) null, strValueOf, map) + " " + th.toString(), new Object[0]);
        }
    }

    public void a(String str) {
        this.f10423d = str;
    }

    public void a(ErrorCode errorCode) {
        if (errorCode.getCodeInt() != AccsErrorCode.SUCCESS.getCodeInt()) {
            a(errorCode.getMsg());
        }
    }

    public void a() {
        b("BindApp");
    }
}

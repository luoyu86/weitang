package com.taobao.accs.ut.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10455g = false;

    public void a() {
        String str;
        String strValueOf;
        if (this.f10455g) {
            return;
        }
        this.f10455g = true;
        HashMap map = new HashMap();
        try {
            str = this.f10449a;
            try {
                strValueOf = String.valueOf(Constants.SDK_VERSION_CODE);
            } catch (Throwable th) {
                th = th;
                strValueOf = null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
            strValueOf = null;
        }
        try {
            map.put("device_id", this.f10449a);
            map.put("session_id", this.f10450b);
            map.put("data_id", this.f10451c);
            map.put("ack_date", this.f10452d);
            map.put("service_id", this.f10453e);
            map.put("fail_reasons", this.f10454f);
            UTMini.getInstance().commitEvent(66001, "sendAck", str, (Object) null, strValueOf, map);
        } catch (Throwable th3) {
            th = th3;
            ALog.d("accs.SendAckStatistic", UTMini.getCommitInfo(66001, str, (String) null, strValueOf, map) + " " + th.toString(), new Object[0]);
        }
    }
}

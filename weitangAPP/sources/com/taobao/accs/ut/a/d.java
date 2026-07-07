package com.taobao.accs.ut.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f10446g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f10448i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10447h = false;
    private boolean j = false;

    public void a() {
        String str;
        String strValueOf;
        if (this.j) {
            return;
        }
        this.j = true;
        HashMap map = new HashMap();
        try {
            str = this.f10440a;
            try {
                strValueOf = String.valueOf(Constants.SDK_VERSION_CODE);
            } catch (Throwable th) {
                th = th;
                strValueOf = null;
            }
            try {
                map.put("device_id", this.f10440a);
                map.put("data_id", this.f10441b);
                map.put("receive_date", this.f10442c);
                map.put("to_bz_date", this.f10443d);
                map.put("service_id", this.f10444e);
                map.put("data_length", this.f10445f);
                map.put("msg_type", this.f10446g);
                map.put("repeat", this.f10447h ? OperatorName.CURVE_TO_REPLICATE_FINAL_POINT : OperatorName.ENDPATH);
                map.put("user_id", this.f10448i);
                UTMini.getInstance().commitEvent(66001, "receiveMessage", str, (Object) null, strValueOf, map);
            } catch (Throwable th2) {
                th = th2;
                ALog.d("ReceiveMessage", UTMini.getCommitInfo(66001, str, (String) null, strValueOf, map) + " " + th.toString(), new Object[0]);
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
            strValueOf = null;
        }
    }
}

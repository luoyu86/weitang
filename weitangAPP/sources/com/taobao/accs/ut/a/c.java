package com.taobao.accs.ut.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10432b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f10437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f10438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10439i;
    public boolean j;
    private long k = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10433c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10434d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10435e = 0;

    public void a() {
        String strValueOf;
        String strValueOf2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level)) {
            ALog.d("MonitorStatistic", "commitUT interval:" + (jCurrentTimeMillis - this.k) + " interval1:" + (jCurrentTimeMillis - this.f10438h), new Object[0]);
        }
        if (jCurrentTimeMillis - this.k <= 1200000 || jCurrentTimeMillis - this.f10438h <= 60000) {
            return;
        }
        HashMap map = new HashMap();
        String str = null;
        try {
            String strValueOf3 = String.valueOf(this.f10434d);
            try {
                strValueOf2 = String.valueOf(this.f10435e);
                try {
                    strValueOf = String.valueOf(Constants.SDK_VERSION_CODE);
                    try {
                        map.put("connStatus", String.valueOf(this.f10431a));
                        map.put("connType", String.valueOf(this.f10432b));
                        map.put("tcpConnected", String.valueOf(this.f10433c));
                        map.put("proxy", String.valueOf(this.f10436f));
                        map.put("startServiceTime", String.valueOf(this.f10438h));
                        map.put("commitTime", String.valueOf(jCurrentTimeMillis));
                        map.put("networkAvailable", String.valueOf(this.f10439i));
                        map.put("threadIsalive", String.valueOf(this.j));
                        map.put(AgooConstants.OPEN_URL, this.f10437g);
                        if (ALog.isPrintLog(level)) {
                            try {
                                ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, strValueOf3, strValueOf2, strValueOf, map), new Object[0]);
                            } catch (Throwable th) {
                                th = th;
                                str = strValueOf3;
                                ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, str, strValueOf2, strValueOf, map) + " " + th.toString(), new Object[0]);
                            }
                        }
                        try {
                            UTMini.getInstance().commitEvent(66001, "MONITOR", strValueOf3, strValueOf2, strValueOf, map);
                            this.k = jCurrentTimeMillis;
                        } catch (Throwable th2) {
                            th = th2;
                            str = strValueOf3;
                            strValueOf = strValueOf;
                            strValueOf2 = strValueOf2;
                            ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, str, strValueOf2, strValueOf, map) + " " + th.toString(), new Object[0]);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    strValueOf = null;
                }
            } catch (Throwable th5) {
                th = th5;
                strValueOf = null;
                strValueOf2 = null;
            }
        } catch (Throwable th6) {
            th = th6;
            strValueOf = null;
            strValueOf2 = null;
        }
    }
}

package com.taobao.accs.flowcontrol;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FlowControl {
    public static final int DELAY_MAX = -1;
    public static final int DELAY_MAX_BRUSH = -1000;
    public static final int HIGH_FLOW_CTRL = 2;
    public static final int HIGH_FLOW_CTRL_BRUSH = 3;
    public static final int LOW_FLOW_CTRL = 1;
    public static final int NO_FLOW_CTRL = 0;
    public static final String SERVICE_ALL = "ALL";
    public static final String SERVICE_ALL_BRUSH = "ALL_BRUSH";
    public static final int STATUS_FLOW_CTRL_ALL = 420;
    public static final int STATUS_FLOW_CTRL_BRUSH = 422;
    public static final int STATUS_FLOW_CTRL_CUR = 421;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FlowCtrlInfoHolder f10308b;

    public static class FlowControlInfo implements Serializable {
        private static final long serialVersionUID = -2259991484877844919L;
        public String bizId;
        public long delayTime;
        public long expireTime;
        public String serviceId;
        public long startTime;
        public int status;

        public FlowControlInfo(String str, String str2, int i2, long j, long j2, long j3) {
            this.serviceId = str;
            this.bizId = str2;
            this.status = i2;
            this.delayTime = j;
            this.expireTime = j2 <= 0 ? 0L : j2;
            this.startTime = j3 <= 0 ? 0L : j3;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() - (this.startTime + this.expireTime) > 0;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("flow ctrl serviceId:");
            stringBuffer.append(this.serviceId);
            stringBuffer.append(" bizId:");
            stringBuffer.append(this.bizId);
            stringBuffer.append(" status:");
            stringBuffer.append(this.status);
            stringBuffer.append(" delayTime:");
            stringBuffer.append(this.delayTime);
            stringBuffer.append(" startTime:");
            stringBuffer.append(this.startTime);
            stringBuffer.append(" expireTime:");
            stringBuffer.append(this.expireTime);
            return stringBuffer.toString();
        }
    }

    public static class FlowCtrlInfoHolder implements Serializable {
        private static final long serialVersionUID = 6307563052429742524L;
        public Map<String, FlowControlInfo> flowCtrlMap = null;

        public FlowControlInfo get(String str, String str2) {
            if (this.flowCtrlMap == null) {
                return null;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str + "_" + str2;
            }
            return this.flowCtrlMap.get(str);
        }

        public void put(String str, String str2, FlowControlInfo flowControlInfo) {
            if (!TextUtils.isEmpty(str2)) {
                str = str + "_" + str2;
            }
            if (this.flowCtrlMap == null) {
                this.flowCtrlMap = new HashMap();
            }
            this.flowCtrlMap.put(str, flowControlInfo);
        }
    }

    public FlowControl(Context context) {
        this.f10307a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00fd A[Catch: all -> 0x0126, TryCatch #1 {all -> 0x0126, blocks: (B:32:0x00ab, B:42:0x00fd, B:43:0x0119, B:47:0x0120, B:36:0x00bd, B:38:0x00db, B:40:0x00e1), top: B:75:0x008d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(java.util.Map<java.lang.Integer, java.lang.String> r22, java.lang.String r23) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.flowcontrol.FlowControl.a(java.util.Map, java.lang.String):int");
    }

    private boolean a(long j, long j2) {
        if (j != 0 && j2 > 0) {
            return true;
        }
        ALog.e("FlowControl", "error flow ctrl info", new Object[0]);
        return false;
    }

    public long a(String str, String str2) {
        long j;
        long j2;
        long j3;
        FlowCtrlInfoHolder flowCtrlInfoHolder = this.f10308b;
        long j4 = 0;
        if (flowCtrlInfoHolder == null || flowCtrlInfoHolder.flowCtrlMap == null || TextUtils.isEmpty(str)) {
            return 0L;
        }
        synchronized (this) {
            FlowControlInfo flowControlInfo = this.f10308b.get("ALL", null);
            FlowControlInfo flowControlInfo2 = this.f10308b.get(SERVICE_ALL_BRUSH, null);
            FlowControlInfo flowControlInfo3 = this.f10308b.get(str, null);
            FlowControlInfo flowControlInfo4 = this.f10308b.get(str, str2);
            j = (flowControlInfo == null || flowControlInfo.isExpired()) ? 0L : flowControlInfo.delayTime;
            long j5 = (flowControlInfo2 == null || flowControlInfo2.isExpired()) ? 0L : flowControlInfo2.delayTime;
            j2 = (flowControlInfo3 == null || flowControlInfo3.isExpired()) ? 0L : flowControlInfo3.delayTime;
            if (flowControlInfo4 != null && !flowControlInfo4.isExpired()) {
                j4 = flowControlInfo4.delayTime;
            }
            j3 = -1;
            if (j != -1 && j4 != -1 && j2 != -1) {
                if (j5 == -1) {
                    j3 = -1000;
                } else {
                    long j6 = j > j4 ? j : j4;
                    j3 = j6 > j2 ? j6 : j2;
                }
            }
            if ((flowControlInfo4 != null && flowControlInfo4.isExpired()) || (flowControlInfo != null && flowControlInfo.isExpired())) {
                a();
            }
        }
        ALog.e("FlowControl", "getFlowCtrlDelay service " + str + " biz " + str2 + " result:" + j3 + " global:" + j + " serviceDelay:" + j2 + " bidDelay:" + j4, new Object[0]);
        return j3;
    }

    private void a() {
        FlowCtrlInfoHolder flowCtrlInfoHolder = this.f10308b;
        if (flowCtrlInfoHolder == null || flowCtrlInfoHolder.flowCtrlMap == null) {
            return;
        }
        synchronized (this) {
            Iterator<Map.Entry<String, FlowControlInfo>> it = this.f10308b.flowCtrlMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().isExpired()) {
                    it.remove();
                }
            }
        }
    }
}

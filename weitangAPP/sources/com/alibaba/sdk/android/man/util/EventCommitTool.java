package com.alibaba.sdk.android.man.util;

import com.alibaba.sdk.android.man.customperf.MANCustomPerformance;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class EventCommitTool {
    private static final String TAG = "MAN_EventCommitTool";

    public static void commitCustomPerformanceEvent(MANCustomPerformance mANCustomPerformance) {
        if (!Aggregation.getInstance().addCustomPerfToAggregation(mANCustomPerformance)) {
            commitEventToUT("UT", MANConfig.CUSTOM_PERFORMANCE_EVENT_ID, mANCustomPerformance.getEventLabel(), "", String.valueOf(mANCustomPerformance.getDuration()), mANCustomPerformance.getProperties());
            return;
        }
        if (MANLog.isPrintLog()) {
            MANLog.Logi(TAG, "ToAggregation : 66602, duration=" + mANCustomPerformance.getDuration() + ", label=" + mANCustomPerformance.getEventLabel());
        }
    }

    public static void commitEvent(int i2, String str, Map<String, String> map) {
        if (str == null || map == null) {
            MANLog.Logw(TAG, "[commitEvent] - eventLabel: " + str + ", property : " + map);
            return;
        }
        if (!Aggregation.getInstance().addToNetPerfAggregation(map)) {
            commitEventDirectly(i2, str, map);
            return;
        }
        MANLog.Logi(TAG, "ToAggregation : " + i2 + ", " + map.toString());
    }

    public static void commitEventDirectly(int i2, String str, Map<String, String> map) {
        if (str != null && map != null) {
            commitEventToUT("UT", i2, str, "", "", map);
            return;
        }
        MANLog.Logf(TAG, "[commitEvent] - eventLabel: " + str + ", property : " + map);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018 A[Catch: all -> 0x006a, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0018, B:9:0x0052), top: B:15:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void commitEventToUT(java.lang.String r8, int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
            java.lang.Class<com.alibaba.sdk.android.man.util.EventCommitTool> r0 = com.alibaba.sdk.android.man.util.EventCommitTool.class
            monitor-enter(r0)
            if (r13 != 0) goto La
            java.util.HashMap r13 = new java.util.HashMap     // Catch: java.lang.Throwable -> L6a
            r13.<init>()     // Catch: java.lang.Throwable -> L6a
        La:
            r7 = r13
            java.lang.String r13 = "MAS_VER"
            java.lang.String r1 = "MBAAS_MAS_ANDROID_1.2.4"
            r7.put(r13, r1)     // Catch: java.lang.Throwable -> L6a
            boolean r13 = com.alibaba.sdk.android.man.util.MANLog.isPrintLog()     // Catch: java.lang.Throwable -> L6a
            if (r13 == 0) goto L52
            java.lang.String r13 = "MAN_EventCommitTool"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            r1.<init>()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = "commitEventFinally : eventId="
            r1.append(r2)     // Catch: java.lang.Throwable -> L6a
            r1.append(r9)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = ", arg1="
            r1.append(r2)     // Catch: java.lang.Throwable -> L6a
            r1.append(r10)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = ", arg2="
            r1.append(r2)     // Catch: java.lang.Throwable -> L6a
            r1.append(r11)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = ", arg3="
            r1.append(r2)     // Catch: java.lang.Throwable -> L6a
            r1.append(r12)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = ", "
            r1.append(r2)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = r7.toString()     // Catch: java.lang.Throwable -> L6a
            r1.append(r2)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L6a
            com.alibaba.sdk.android.man.util.MANLog.Logd(r13, r1)     // Catch: java.lang.Throwable -> L6a
        L52:
            com.ut.mini.internal.UTOriginalCustomHitBuilder r13 = new com.ut.mini.internal.UTOriginalCustomHitBuilder     // Catch: java.lang.Throwable -> L6a
            r1 = r13
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L6a
            com.alibaba.sdk.android.man.MANTracker r8 = com.alibaba.sdk.android.man.MANTracker.getInstance()     // Catch: java.lang.Throwable -> L6a
            java.util.Map r9 = r13.build()     // Catch: java.lang.Throwable -> L6a
            r8.send(r9)     // Catch: java.lang.Throwable -> L6a
            monitor-exit(r0)
            return
        L6a:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.man.util.EventCommitTool.commitEventToUT(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.util.Map):void");
    }
}

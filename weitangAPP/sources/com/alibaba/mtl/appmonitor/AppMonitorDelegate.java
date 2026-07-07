package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.l;
import com.alibaba.mtl.log.sign.BaseRequestAuth;
import com.alibaba.mtl.log.sign.SecurityRequestAuth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class AppMonitorDelegate {
    public static final String DEFAULT_VALUE = "defaultValue";
    public static boolean IS_DEBUG = false;
    public static final String MAX_VALUE = "maxValue";
    public static final String MIN_VALUE = "minValue";
    public static final String TAG = "AppMonitorDelegate";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Application f4456b = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f4457i = false;

    public static class Alarm {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return j.a(f.ALARM, str, str2);
        }

        public static void commitFail(String str, String str2, String str3, String str4, Map<String, String> map) {
            commitFail(str, str2, null, str3, str4, map);
        }

        public static void commitSuccess(String str, String str2, Map<String, String> map) {
            commitSuccess(str, str2, null, map);
        }

        public static void setSampling(int i2) {
            j.a().a(f.ALARM, i2);
        }

        public static void setStatisticsInterval(int i2) {
            f fVar = f.ALARM;
            fVar.setStatisticsInterval(i2);
            AppMonitorDelegate.setStatisticsInterval(fVar, i2);
        }

        public static void commitFail(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    com.alibaba.mtl.log.b.a.A();
                    HashMap map2 = new HashMap();
                    map2.put("_status", "0");
                    if (AppMonitorDelegate.f4457i && com.alibaba.mtl.log.a.a.f()) {
                        f fVar = f.ALARM;
                        if (fVar.isOpen() && (AppMonitorDelegate.IS_DEBUG || j.a(str, str2, Boolean.FALSE, map2))) {
                            i.a(AppMonitorDelegate.TAG, "commitFail module:", str, " monitorPoint:", str2, " errorCode:", str4, "errorMsg:", str5);
                            com.alibaba.mtl.log.b.a.B();
                            e.a().a(fVar.a(), str, str2, str3, str4, str5, map);
                            return;
                        }
                    }
                    i.a("log discard !", "");
                    return;
                }
                i.a(AppMonitorDelegate.TAG, "module & monitorPoint must not null");
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.m23a(th);
            }
        }

        public static void commitSuccess(String str, String str2, String str3, Map<String, String> map) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    com.alibaba.mtl.log.b.a.A();
                    if (AppMonitorDelegate.f4457i && com.alibaba.mtl.log.a.a.f()) {
                        f fVar = f.ALARM;
                        if (fVar.isOpen() && (AppMonitorDelegate.IS_DEBUG || j.a(str, str2, Boolean.TRUE, (Map<String, String>) null))) {
                            i.a(AppMonitorDelegate.TAG, "commitSuccess module:", str, " monitorPoint:", str2);
                            com.alibaba.mtl.log.b.a.B();
                            e.a().a(fVar.a(), str, str2, str3, map);
                            return;
                        }
                    }
                    i.a("log discard !", "");
                    return;
                }
                i.a(AppMonitorDelegate.TAG, "module & monitorPoint must not null");
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.m23a(th);
            }
        }
    }

    public static class Counter {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return j.a(f.COUNTER, str, str2);
        }

        public static void commit(String str, String str2, double d2, Map<String, String> map) {
            commit(str, str2, null, d2, map);
        }

        public static void setSampling(int i2) {
            j.a().a(f.COUNTER, i2);
        }

        public static void setStatisticsInterval(int i2) {
            f fVar = f.COUNTER;
            fVar.setStatisticsInterval(i2);
            AppMonitorDelegate.setStatisticsInterval(fVar, i2);
        }

        public static void commit(String str, String str2, String str3, double d2, Map<String, String> map) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    com.alibaba.mtl.log.b.a.y();
                    if (AppMonitorDelegate.f4457i && com.alibaba.mtl.log.a.a.f()) {
                        f fVar = f.COUNTER;
                        if (fVar.isOpen()) {
                            if (AppMonitorDelegate.IS_DEBUG || j.a(fVar, str, str2)) {
                                i.a(AppMonitorDelegate.TAG, "commitCount module: ", str, " monitorPoint: ", str2, " value: ", Double.valueOf(d2));
                                com.alibaba.mtl.log.b.a.z();
                                e.a().a(fVar.a(), str, str2, str3, d2, map);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                i.a(AppMonitorDelegate.TAG, "module & monitorPoint must not null");
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.m23a(th);
            }
        }
    }

    public static class OffLineCounter {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return j.a(f.OFFLINE_COUNTER, str, str2);
        }

        public static void commit(String str, String str2, double d2) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    com.alibaba.mtl.log.b.a.w();
                    if (AppMonitorDelegate.f4457i && com.alibaba.mtl.log.a.a.f()) {
                        f fVar = f.OFFLINE_COUNTER;
                        if (fVar.isOpen()) {
                            if (AppMonitorDelegate.IS_DEBUG || j.a(fVar, str, str2)) {
                                i.a(AppMonitorDelegate.TAG, "commitOffLineCount module: ", str, " monitorPoint: ", str2, " value: ", Double.valueOf(d2));
                                com.alibaba.mtl.log.b.a.x();
                                e.a().a(fVar.a(), str, str2, (String) null, d2, (Map<String, String>) null);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                i.a(AppMonitorDelegate.TAG, "module & monitorPoint must not null");
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.m23a(th);
            }
        }

        public static void setSampling(int i2) {
            j.a().a(f.OFFLINE_COUNTER, i2);
        }

        public static void setStatisticsInterval(int i2) {
            f fVar = f.OFFLINE_COUNTER;
            fVar.setStatisticsInterval(i2);
            AppMonitorDelegate.setStatisticsInterval(fVar, i2);
        }
    }

    public static class Stat {
        public static void begin(String str, String str2, String str3) {
            try {
                if (AppMonitorDelegate.f4457i && com.alibaba.mtl.log.a.a.f()) {
                    f fVar = f.STAT;
                    if (fVar.isOpen()) {
                        if (AppMonitorDelegate.IS_DEBUG || j.a(fVar, str, str2)) {
                            i.a(AppMonitorDelegate.TAG, "statEvent begin. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                            e.a().a(Integer.valueOf(fVar.a()), str, str2, str3);
                        }
                    }
                }
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.m23a(th);
            }
        }

        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return j.a(f.STAT, str, str2);
        }

        public static void commit(String str, String str2, double d2, Map<String, String> map) {
            commit(str, str2, (DimensionValueSet) null, d2, map);
        }

        public static Transaction createTransaction(String str, String str2) {
            return createTransaction(str, str2, null);
        }

        public static void end(String str, String str2, String str3) {
            try {
                if (AppMonitorDelegate.f4457i && com.alibaba.mtl.log.a.a.f()) {
                    f fVar = f.STAT;
                    if (fVar.isOpen()) {
                        if (AppMonitorDelegate.IS_DEBUG || j.a(fVar, str, str2)) {
                            i.a(AppMonitorDelegate.TAG, "statEvent end. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                            e.a().a(str, str2, str3);
                        }
                    }
                }
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.m23a(th);
            }
        }

        public static void setSampling(int i2) {
            j.a().a(f.STAT, i2);
        }

        public static void setStatisticsInterval(int i2) {
            f fVar = f.STAT;
            fVar.setStatisticsInterval(i2);
            AppMonitorDelegate.setStatisticsInterval(fVar, i2);
        }

        public static void commit(String str, String str2, DimensionValueSet dimensionValueSet, double d2, Map<String, String> map) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    com.alibaba.mtl.log.b.a.u();
                    if (AppMonitorDelegate.f4457i && com.alibaba.mtl.log.a.a.f()) {
                        f fVar = f.STAT;
                        if (fVar.isOpen()) {
                            if (AppMonitorDelegate.IS_DEBUG || j.a(fVar, str, str2)) {
                                i.a(AppMonitorDelegate.TAG, "statEvent commit. module: ", str, " monitorPoint: ", str2);
                                Metric metric = MetricRepo.getRepo().getMetric(str, str2);
                                com.alibaba.mtl.log.b.a.v();
                                if (metric != null) {
                                    List<Measure> measures = metric.getMeasureSet().getMeasures();
                                    if (measures.size() == 1) {
                                        commit(str, str2, dimensionValueSet, ((MeasureValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValueSet.class, new Object[0])).setValue(measures.get(0).getName(), d2), map);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                i.a(AppMonitorDelegate.TAG, "module & monitorPoint must not null");
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.m23a(th);
            }
        }

        public static Transaction createTransaction(String str, String str2, DimensionValueSet dimensionValueSet) {
            return new Transaction(Integer.valueOf(f.STAT.a()), str, str2, dimensionValueSet);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
        
            if (com.alibaba.mtl.appmonitor.d.j.a(r1, r11, r12, r13 != null ? r13.getMap() : null) != false) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void commit(java.lang.String r11, java.lang.String r12, com.alibaba.mtl.appmonitor.model.DimensionValueSet r13, com.alibaba.mtl.appmonitor.model.MeasureValueSet r14, java.util.Map<java.lang.String, java.lang.String> r15) {
            /*
                boolean r1 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L7d
                if (r1 != 0) goto L75
                boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L7d
                if (r1 == 0) goto Le
                goto L75
            Le:
                com.alibaba.mtl.log.b.a.u()     // Catch: java.lang.Throwable -> L7d
                boolean r1 = com.alibaba.mtl.appmonitor.AppMonitorDelegate.f4457i     // Catch: java.lang.Throwable -> L7d
                r2 = 3
                java.lang.String r3 = " monitorPoint: "
                r5 = 2
                r6 = 1
                r7 = 0
                r8 = 4
                if (r1 == 0) goto L63
                boolean r1 = com.alibaba.mtl.log.a.a.f()     // Catch: java.lang.Throwable -> L7d
                if (r1 == 0) goto L63
                com.alibaba.mtl.appmonitor.a.f r1 = com.alibaba.mtl.appmonitor.a.f.STAT     // Catch: java.lang.Throwable -> L7d
                boolean r9 = r1.isOpen()     // Catch: java.lang.Throwable -> L7d
                if (r9 == 0) goto L63
                boolean r9 = com.alibaba.mtl.appmonitor.AppMonitorDelegate.IS_DEBUG     // Catch: java.lang.Throwable -> L7d
                if (r9 != 0) goto L3c
                if (r13 == 0) goto L35
                java.util.Map r9 = r13.getMap()     // Catch: java.lang.Throwable -> L7d
                goto L36
            L35:
                r9 = 0
            L36:
                boolean r9 = com.alibaba.mtl.appmonitor.d.j.a(r1, r11, r12, r9)     // Catch: java.lang.Throwable -> L7d
                if (r9 == 0) goto L63
            L3c:
                java.lang.String r9 = "statEvent commit success"
                java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L7d
                java.lang.String r10 = "statEvent commit. module: "
                r8[r7] = r10     // Catch: java.lang.Throwable -> L7d
                r8[r6] = r11     // Catch: java.lang.Throwable -> L7d
                r8[r5] = r3     // Catch: java.lang.Throwable -> L7d
                r8[r2] = r12     // Catch: java.lang.Throwable -> L7d
                com.alibaba.mtl.log.d.i.a(r9, r8)     // Catch: java.lang.Throwable -> L7d
                com.alibaba.mtl.log.b.a.v()     // Catch: java.lang.Throwable -> L7d
                com.alibaba.mtl.appmonitor.a.e r2 = com.alibaba.mtl.appmonitor.a.e.a()     // Catch: java.lang.Throwable -> L7d
                int r3 = r1.a()     // Catch: java.lang.Throwable -> L7d
                r1 = r2
                r2 = r3
                r3 = r11
                r4 = r12
                r5 = r14
                r6 = r13
                r7 = r15
                r1.a(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7d
                goto L81
            L63:
                java.lang.String r1 = "statEvent commit failed,log discard"
                java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L7d
                java.lang.String r9 = " ,. module: "
                r8[r7] = r9     // Catch: java.lang.Throwable -> L7d
                r8[r6] = r11     // Catch: java.lang.Throwable -> L7d
                r8[r5] = r3     // Catch: java.lang.Throwable -> L7d
                r8[r2] = r12     // Catch: java.lang.Throwable -> L7d
                com.alibaba.mtl.log.d.i.a(r1, r8)     // Catch: java.lang.Throwable -> L7d
                goto L81
            L75:
                java.lang.String r0 = "AppMonitorDelegate"
                java.lang.String r1 = "module & monitorPoint must not null"
                com.alibaba.mtl.log.d.i.a(r0, r1)     // Catch: java.lang.Throwable -> L7d
                return
            L7d:
                r0 = move-exception
                com.alibaba.mtl.appmonitor.b.b.m23a(r0)
            L81:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.AppMonitorDelegate.Stat.commit(java.lang.String, java.lang.String, com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.model.MeasureValueSet, java.util.Map):void");
        }
    }

    public static synchronized void destroy() {
        try {
            i.a(TAG, "start destory");
            if (f4457i) {
                c.d();
                c.destroy();
                b.destroy();
                Application application = f4456b;
                if (application != null) {
                    l.c(application.getApplicationContext());
                }
                f4457i = false;
            }
        } finally {
        }
    }

    public static void enableLog(boolean z) {
        i.a(TAG, "[enableLog]");
        i.d(z);
    }

    public static synchronized void init(Application application) {
        i.a(TAG, "start init");
        try {
            if (!f4457i) {
                f4456b = application;
                com.alibaba.mtl.log.a.a(application.getApplicationContext());
                b.init();
                c.init();
                a.init(application);
                l.b(application.getApplicationContext());
                f4457i = true;
            }
        } catch (Throwable unused) {
            destroy();
        }
    }

    public static void register(String str, String str2, MeasureSet measureSet) {
        register(str, str2, measureSet, (DimensionSet) null);
    }

    public static void setChannel(String str) {
        com.alibaba.mtl.log.a.setChannel(str);
    }

    public static void setRequestAuthInfo(boolean z, String str, String str2, String str3) {
        com.alibaba.mtl.log.a.a(z ? new SecurityRequestAuth(str, str3) : new BaseRequestAuth(str, str2, "1".equalsIgnoreCase(str3)));
        com.alibaba.mtl.log.a.a.a(f4456b);
    }

    public static void setSampling(int i2) {
        i.a(TAG, "[setSampling]");
        for (f fVar : f.values()) {
            fVar.c(i2);
            j.a().a(fVar, i2);
        }
    }

    public static void setStatisticsInterval(int i2) {
        for (f fVar : f.values()) {
            fVar.setStatisticsInterval(i2);
            setStatisticsInterval(fVar, i2);
        }
    }

    public static synchronized void triggerUpload() {
        try {
            i.a(TAG, "triggerUpload");
            if (f4457i && com.alibaba.mtl.log.a.a.f()) {
                c.d();
            }
        } finally {
        }
    }

    public static void turnOffRealTimeDebug() {
        i.a(TAG, "[turnOffRealTimeDebug]");
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        com.alibaba.mtl.log.a.a.turnOnRealTimeDebug(map);
    }

    public static void updateMeasure(String str, String str2, String str3, double d2, double d3, double d4) {
        Metric metric;
        i.a(TAG, "[updateMeasure]");
        try {
            if (!f4457i || com.alibaba.mtl.appmonitor.f.b.d(str) || com.alibaba.mtl.appmonitor.f.b.d(str2) || (metric = MetricRepo.getRepo().getMetric(str, str2)) == null || metric.getMeasureSet() == null) {
                return;
            }
            metric.getMeasureSet().upateMeasure(new Measure(str3, Double.valueOf(d4), Double.valueOf(d2), Double.valueOf(d3)));
        } catch (Exception unused) {
        }
    }

    public static void register(String str, String str2, MeasureSet measureSet, boolean z) {
        register(str, str2, measureSet, null, z);
    }

    public static void register(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) {
        register(str, str2, measureSet, dimensionSet, false);
    }

    public static void register(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        try {
            if (f4457i) {
                if (!com.alibaba.mtl.appmonitor.f.b.d(str) && !com.alibaba.mtl.appmonitor.f.b.d(str2)) {
                    MetricRepo.getRepo().add(new Metric(str, str2, measureSet, dimensionSet, z));
                    return;
                }
                i.a(TAG, "register stat event. module: ", str, " monitorPoint: ", str2);
                if (IS_DEBUG) {
                    throw new com.alibaba.mtl.appmonitor.b.a("register error. module and monitorPoint can't be null");
                }
            }
        } catch (Throwable th) {
            com.alibaba.mtl.appmonitor.b.b.m23a(th);
        }
    }

    public static void setStatisticsInterval(f fVar, int i2) {
        try {
            if (f4457i && fVar != null) {
                c.a(fVar.a(), i2);
                if (i2 > 0) {
                    fVar.b(true);
                } else {
                    fVar.b(false);
                }
            }
        } catch (Throwable th) {
            com.alibaba.mtl.appmonitor.b.b.m23a(th);
        }
    }
}

package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.IMonitor;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.log.d.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class AppMonitor {
    public static final String TAG = "AppMonitor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Application f4382a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static HandlerThread f15a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static c f17a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static IMonitor f18a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static volatile boolean f21a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4384c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f4385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f4386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f4387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f4388i;
    private static Context mContext;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Object f19a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static List<a> f20a = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static boolean f22b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static b f16a = b.Local;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ServiceConnection f14a = new ServiceConnection() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.5
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c cVar;
            if (b.Service == AppMonitor.f16a) {
                AppMonitor.f18a = IMonitor.Stub.asInterface(iBinder);
                if (AppMonitor.f22b && (cVar = AppMonitor.f17a) != null) {
                    cVar.postAtFrontOfQueue(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AppMonitor.restart();
                        }
                    });
                }
            }
            synchronized (AppMonitor.f19a) {
                AppMonitor.f19a.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            i.a(AppMonitor.TAG, "[onServiceDisconnected]");
            synchronized (AppMonitor.f19a) {
                AppMonitor.f19a.notifyAll();
            }
            boolean unused = AppMonitor.f22b = true;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, APTrack> f4383b = Collections.synchronizedMap(new HashMap());

    public static class OffLineCounter {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            IMonitor iMonitor = AppMonitor.f18a;
            if (iMonitor == null) {
                return false;
            }
            try {
                return iMonitor.offlinecounter_checkSampled(str, str2);
            } catch (RemoteException e2) {
                AppMonitor.a(e2);
                return false;
            }
        }

        public static void commit(final String str, final String str2, final double d2) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.OffLineCounter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.offlinecounter_commit(str, str2, d2);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i2) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.OffLineCounter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.offlinecounter_setSampling(i2);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static void setStatisticsInterval(final int i2) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.OffLineCounter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.offlinecounter_setStatisticsInterval(i2);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }
    }

    public static class Stat {
        public static void begin(final String str, final String str2, final String str3) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.stat_begin(str, str2, str3);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static boolean checkSampled(String str, String str2) {
            IMonitor iMonitor = AppMonitor.f18a;
            if (iMonitor == null) {
                return false;
            }
            try {
                return iMonitor.stat_checkSampled(str, str2);
            } catch (RemoteException e2) {
                AppMonitor.a(e2);
                return false;
            }
        }

        public static void commit(String str, String str2, double d2) {
            commit(str, str2, (DimensionValueSet) null, d2);
        }

        public static Transaction createTransaction(String str, String str2) {
            return createTransaction(str, str2, null);
        }

        public static void end(final String str, final String str2, final String str3) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.stat_end(str, str2, str3);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i2) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.stat_setSampling(i2);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static void setStatisticsInterval(final int i2) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.stat_setStatisticsInterval(i2);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static void commit(final String str, final String str2, final DimensionValueSet dimensionValueSet, final double d2) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.stat_commit2(str, str2, dimensionValueSet, d2, null);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static Transaction createTransaction(String str, String str2, DimensionValueSet dimensionValueSet) {
            return new Transaction(Integer.valueOf(f.STAT.a()), str, str2, dimensionValueSet);
        }

        public static Transaction createTransaction(String str, String str2, DimensionValueSet dimensionValueSet, String str3) {
            return new Transaction(Integer.valueOf(f.STAT.a()), str, str2, dimensionValueSet, str3);
        }

        public static void commit(String str, String str2, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
            DimensionValueSet dimensionValueSetCreate;
            i.a(AppMonitor.TAG, "[commit from jni]");
            MeasureValueSet measureValueSetCreate = null;
            if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
                dimensionValueSetCreate = null;
            } else {
                dimensionValueSetCreate = DimensionValueSet.create();
                for (int i2 = 0; i2 < strArr2.length; i2++) {
                    dimensionValueSetCreate.setValue(strArr[i2], strArr2[i2]);
                }
            }
            if (strArr3 != null && strArr4 != null && strArr3.length == strArr4.length) {
                measureValueSetCreate = MeasureValueSet.create();
                for (int i3 = 0; i3 < strArr4.length; i3++) {
                    double dDoubleValue = 0.0d;
                    if (!TextUtils.isEmpty(strArr4[i3])) {
                        try {
                            dDoubleValue = Double.valueOf(strArr4[i3]).doubleValue();
                        } catch (Exception unused) {
                            i.a(AppMonitor.TAG, "measure's value cannot convert to double. measurevalue:" + strArr4[i3]);
                        }
                    }
                    measureValueSetCreate.setValue(strArr3[i3], dDoubleValue);
                }
            } else {
                i.a(AppMonitor.TAG, "measure is null ,or lenght not match");
            }
            commit(str, str2, dimensionValueSetCreate, measureValueSetCreate);
        }

        public static void commit(final String str, final String str2, final DimensionValueSet dimensionValueSet, final MeasureValueSet measureValueSet) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.stat_commit3(str, str2, dimensionValueSet, measureValueSet, null);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }
    }

    public static class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DimensionSet f4450b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public MeasureSet f37b;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f4451g;
        public String o;
        public String p;
    }

    public enum b {
        Local,
        Service
    }

    public static boolean checkInit() {
        if (!f21a) {
            i.a(TAG, "Please call UTAnalytics.getInstance().setAppApplicationInstance()||.setAppApplicationInstance4sdk() before call other method");
        }
        return f21a;
    }

    @Deprecated
    public static synchronized void destroy() {
        if (checkInit()) {
            f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f18a.destroy();
                    } catch (RemoteException e2) {
                        AppMonitor.a(e2);
                    }
                }
            });
        }
    }

    public static void enableLog(final boolean z) {
        if (checkInit()) {
            f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.13
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f18a.enableLog(z);
                    } catch (RemoteException e2) {
                        AppMonitor.a(e2);
                    }
                }
            });
        }
    }

    public static APTrack getTrackByAppkey(String str) {
        if (!checkInit()) {
            return null;
        }
        if (!f4383b.containsKey(str)) {
            f4383b.put(str, new APTrack(str));
        }
        return f4383b.get(str);
    }

    public static synchronized void init(Application application) {
        i.a(TAG, "[init]");
        try {
            if (!f21a) {
                f4382a = application;
                if (application != null) {
                    mContext = application.getApplicationContext();
                }
                HandlerThread handlerThread = new HandlerThread("AppMonitor_Client");
                f15a = handlerThread;
                handlerThread.start();
                f17a = new c(f15a.getLooper());
                if (f16a == b.Local) {
                    m13a();
                } else if (m15a()) {
                    f17a.a(true);
                }
                m12a().run();
                f21a = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet) {
        if (checkInit()) {
            f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.14
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f18a.register1(str, str2, measureSet);
                    } catch (RemoteException e2) {
                        AppMonitor.a(e2);
                    }
                }
            });
            m14a(str, str2, measureSet, (DimensionSet) null, false);
        }
    }

    public static void registerInternal(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z, boolean z2) {
        if (checkInit()) {
            i.a(TAG, "[registerInternal] : module:", str, "monitorPoint:", str2, "measures:", measureSet, "dimensions:", dimensionSet, "isCommitDetail:", Boolean.valueOf(z), "isInternal:", Boolean.valueOf(z2));
            if (!z2) {
                m14a(str, str2, measureSet, dimensionSet, z);
            }
            f17a.a(a(str, str2, measureSet, dimensionSet, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void restart() {
        i.a(TAG, "[restart]");
        try {
            if (f22b) {
                f22b = false;
                m13a();
                m12a().run();
                a(f4384c, f4386g, f4387h, f4388i).run();
                a(f4385f).run();
                synchronized (f20a) {
                    for (int i2 = 0; i2 < f20a.size(); i2++) {
                        a aVar = f20a.get(i2);
                        if (aVar != null) {
                            try {
                                a(aVar.o, aVar.p, aVar.f37b, aVar.f4450b, aVar.f4451g).run();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void setChannel(String str) {
        if (checkInit()) {
            f17a.a(a(str));
            f4385f = str;
        }
    }

    public static void setRequestAuthInfo(boolean z, String str, String str2, String str3) {
        if (checkInit()) {
            f17a.a(a(z, str, str2, str3));
            f4384c = z;
            f4386g = str;
            f4387h = str2;
            f4388i = str3;
        }
    }

    public static void setSampling(final int i2) {
        if (checkInit()) {
            f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.12
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f18a.setSampling(i2);
                    } catch (RemoteException e2) {
                        AppMonitor.a(e2);
                    }
                }
            });
        }
    }

    public static void setStatisticsInterval(final int i2) {
        if (checkInit()) {
            f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.11
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f18a.setStatisticsInterval1(i2);
                    } catch (RemoteException e2) {
                        AppMonitor.a(e2);
                    }
                }
            });
        }
    }

    @Deprecated
    public static synchronized void triggerUpload() {
        if (f21a) {
            f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f18a.triggerUpload();
                    } catch (RemoteException e2) {
                        AppMonitor.a(e2);
                    }
                }
            });
        }
    }

    public static void turnOffRealTimeDebug() {
        if (checkInit()) {
            f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f18a.turnOffRealTimeDebug();
                    } catch (RemoteException e2) {
                        AppMonitor.a(e2);
                    }
                }
            });
        }
    }

    public static void turnOnRealTimeDebug(final Map<String, String> map) {
        if (checkInit()) {
            f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f18a.turnOnRealTimeDebug(map);
                    } catch (RemoteException e2) {
                        AppMonitor.a(e2);
                    }
                }
            });
        }
    }

    public static void updateMeasure(final String str, final String str2, final String str3, final double d2, final double d3, final double d4) {
        i.a(TAG, "[updateMeasure]");
        if (checkInit()) {
            f17a.post(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.17
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f18a.updateMeasure(str, str2, str3, d2, d3, d4);
                    } catch (RemoteException e2) {
                        AppMonitor.a(e2);
                    }
                }
            });
        }
    }

    public static class Alarm {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            IMonitor iMonitor = AppMonitor.f18a;
            if (iMonitor == null) {
                return false;
            }
            try {
                return iMonitor.alarm_checkSampled(str, str2);
            } catch (RemoteException e2) {
                AppMonitor.a(e2);
                return false;
            }
        }

        public static void commitFail(final String str, final String str2, final String str3, final String str4) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.alarm_commitFail1(str, str2, str3, str4, null);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static void commitSuccess(final String str, final String str2) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.alarm_commitSuccess1(str, str2, null);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i2) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.alarm_setSampling(i2);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static void setStatisticsInterval(final int i2) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.alarm_setStatisticsInterval(i2);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static void commitFail(final String str, final String str2, final String str3, final String str4, final String str5) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.alarm_commitFail2(str, str2, str3, str4, str5, null);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static void commitSuccess(final String str, final String str2, final String str3) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.alarm_commitSuccess2(str, str2, str3, null);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }
    }

    public static class Counter {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            IMonitor iMonitor = AppMonitor.f18a;
            if (iMonitor == null) {
                return false;
            }
            try {
                return iMonitor.counter_checkSampled(str, str2);
            } catch (RemoteException e2) {
                AppMonitor.a(e2);
                return false;
            }
        }

        public static void commit(final String str, final String str2, final double d2) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Counter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.counter_commit1(str, str2, d2, null);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i2) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Counter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.counter_setSampling(i2);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static void setStatisticsInterval(final int i2) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Counter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.counter_setStatisticsInterval(i2);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }

        public static void commit(final String str, final String str2, final String str3, final double d2) {
            if (AppMonitor.checkInit()) {
                AppMonitor.f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Counter.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f18a.counter_commit2(str, str2, str3, d2, null);
                        } catch (RemoteException e2) {
                            AppMonitor.a(e2);
                        }
                    }
                });
            }
        }
    }

    public static class c extends Handler {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f4455h;

        public c(Looper looper) {
            super(looper);
            this.f4455h = false;
        }

        public void a(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            try {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = runnable;
                sendMessage(messageObtain);
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (this.f4455h) {
                    this.f4455h = false;
                    synchronized (AppMonitor.f19a) {
                        try {
                            AppMonitor.f19a.wait(5000L);
                        } catch (InterruptedException unused) {
                            AppMonitor.m13a();
                        }
                    }
                }
                Object obj = message.obj;
                if (obj != null && (obj instanceof Runnable)) {
                    ((Runnable) obj).run();
                }
            } catch (Throwable unused2) {
            }
            super.handleMessage(message);
        }

        public void a(boolean z) {
            this.f4455h = true;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static void m14a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        try {
            a aVar = new a();
            aVar.o = str;
            aVar.p = str2;
            aVar.f37b = measureSet;
            aVar.f4450b = dimensionSet;
            aVar.f4451g = z;
            f20a.add(aVar);
        } catch (Throwable unused) {
        }
    }

    public static void setStatisticsInterval(f fVar, final int i2) {
        if (checkInit()) {
            final int iA = a(fVar);
            f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f18a.setStatisticsInterval2(iA, i2);
                    } catch (RemoteException e2) {
                        AppMonitor.a(e2);
                    }
                }
            });
        }
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet, final boolean z) {
        if (checkInit()) {
            f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.15
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f18a.register2(str, str2, measureSet, z);
                    } catch (RemoteException e2) {
                        AppMonitor.a(e2);
                    }
                }
            });
            m14a(str, str2, measureSet, (DimensionSet) null, z);
        }
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet, final DimensionSet dimensionSet) {
        if (checkInit()) {
            f17a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.16
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        i.a(AppMonitor.TAG, "[register]:", AppMonitor.f18a);
                        AppMonitor.f18a.register3(str, str2, measureSet, dimensionSet);
                    } catch (RemoteException e2) {
                        AppMonitor.a(e2);
                    }
                }
            });
            m14a(str, str2, measureSet, dimensionSet, false);
        }
    }

    private static int a(f fVar) {
        return fVar.a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m15a() {
        Application application = f4382a;
        if (application == null) {
            return false;
        }
        boolean zBindService = application.getApplicationContext().bindService(new Intent(f4382a.getApplicationContext(), (Class<?>) AppMonitorService.class), f14a, 1);
        if (!zBindService) {
            m13a();
        }
        i.a(TAG, "bindsuccess:", Boolean.valueOf(zBindService));
        return zBindService;
    }

    public static void register(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        if (checkInit()) {
            registerInternal(str, str2, measureSet, dimensionSet, z, false);
        }
    }

    public static void register(String str, String str2, String[] strArr, String[] strArr2, boolean z) {
        Object[] objArr = new Object[9];
        objArr[0] = "[register]";
        objArr[1] = "module:";
        objArr[2] = str;
        objArr[3] = "measures:";
        objArr[4] = strArr == null ? "null" : new JSONArray((Collection) Arrays.asList(strArr)).toString();
        objArr[5] = "dimensions:";
        objArr[6] = strArr2 != null ? new JSONArray((Collection) Arrays.asList(strArr2)).toString() : "null";
        objArr[7] = "isCommitDetail:";
        objArr[8] = Boolean.valueOf(z);
        i.a(TAG, objArr);
        if (strArr != null) {
            MeasureSet measureSetCreate = MeasureSet.create();
            for (String str3 : strArr) {
                measureSetCreate.addMeasure(str3);
            }
            DimensionSet dimensionSetCreate = null;
            if (strArr2 != null) {
                dimensionSetCreate = DimensionSet.create();
                for (String str4 : strArr2) {
                    dimensionSetCreate.addDimension(str4);
                }
            }
            register(str, str2, measureSetCreate, dimensionSetCreate, z);
            return;
        }
        i.a(TAG, "register failed:no mearsure");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Exception exc) {
        i.a(TAG, "", exc);
        if (exc instanceof DeadObjectException) {
            restart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m13a() {
        f18a = new Monitor(f4382a);
        f16a = b.Local;
        i.a(TAG, "Start AppMonitor Service failed,AppMonitor run in local Mode...");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static Runnable m12a() {
        return new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppMonitor.f18a.init();
                } catch (RemoteException unused) {
                    AppMonitor.m13a();
                    try {
                        AppMonitor.f18a.init();
                    } catch (Throwable unused2) {
                    }
                }
            }
        };
    }

    private static Runnable a(final boolean z, final String str, final String str2, final String str3) {
        return new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppMonitor.f18a.setRequestAuthInfo(z, str, str2, str3);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable a(final String str) {
        return new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppMonitor.f18a.setChannel(str);
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static Runnable a(final String str, final String str2, final MeasureSet measureSet, final DimensionSet dimensionSet, final boolean z) {
        return new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    i.a(AppMonitor.TAG, "register stat event. module: ", str, " monitorPoint: ", str2);
                    AppMonitor.f18a.register4(str, str2, measureSet, dimensionSet, z);
                } catch (RemoteException e2) {
                    AppMonitor.a(e2);
                }
            }
        };
    }
}

package com.alibaba.sdk.android.man.crashreporter.c;

import android.content.Context;
import com.alibaba.sdk.android.man.crashreporter.MotuCrashReporter;
import com.alibaba.sdk.android.man.crashreporter.d.c;
import com.alibaba.sdk.android.man.crashreporter.e.e;
import com.alibaba.sdk.android.man.crashreporter.e.g;
import com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent;
import com.alibaba.sdk.android.man.crashreporter.global.CrashReportDataForSave;
import com.alibaba.sdk.android.man.util.MANConfig;
import com.ut.mini.UTAnalytics;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ExecutorService f99a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private AtomicBoolean f100b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f4707b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private c f98a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.man.crashreporter.a.b f97a = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4706a = null;
    private final int B = 3600000;
    private final int C = 10;

    @Override // com.alibaba.sdk.android.man.crashreporter.c.b
    public void b(Map<com.alibaba.sdk.android.man.crashreporter.global.a, String> map) {
        if (this.f4706a == null || this.f99a == null || this.f4707b == null) {
            com.alibaba.sdk.android.man.crashreporter.b.a.e("send all err because sendPools or crashReportStorage ot context is null!");
        }
        if (this.f100b.get() || !com.alibaba.sdk.android.man.crashreporter.e.a.d(this.f4706a)) {
            return;
        }
        this.f99a.execute(new RunnableC0063a(3, null, this.f4706a, map));
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.c.b
    public boolean a(Context context, com.alibaba.sdk.android.man.crashreporter.a.b bVar, c cVar, c cVar2) {
        try {
            this.f99a = Executors.newCachedThreadPool();
            this.f97a = bVar;
            this.f4707b = cVar;
            this.f98a = cVar2;
            this.f4706a = context;
            return true;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("init sender failure!", e2);
            return false;
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.man.crashreporter.c.a$a, reason: collision with other inner class name */
    public final class RunnableC0063a implements Runnable {
        private final int D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f4708a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final CrashReportDataForSave f102a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<com.alibaba.sdk.android.man.crashreporter.global.a, String> f4709d;
        private final int E = 1;
        private final int F = 61006;
        private final int G = 61007;
        private final int w = 61005;
        private final String MOTU_PATH = "motu";

        public RunnableC0063a(int i2, CrashReportDataForSave crashReportDataForSave, Context context, Map<com.alibaba.sdk.android.man.crashreporter.global.a, String> map) {
            this.D = i2;
            this.f102a = crashReportDataForSave;
            this.f4708a = context;
            this.f4709d = map;
        }

        private void d() {
            String str;
            String str2;
            try {
                com.alibaba.sdk.android.man.crashreporter.b.a.e("start send abort content!");
                BaseDataContent baseDataContentA = a.this.f98a.a();
                if (baseDataContentA != null && (str = baseDataContentA.abortFlag) != null && (str2 = this.f4709d.get(com.alibaba.sdk.android.man.crashreporter.global.a.APP_VERSION)) != null && str2.length() != 0 && str2.equals(baseDataContentA.appVersion)) {
                    a("Application", 61005, com.alibaba.sdk.android.man.crashreporter.b.f94h, str2 + str, str.contains(com.alibaba.sdk.android.man.crashreporter.b.f91e) ? "CRASH_CAUGHT" : "CRASH_NOT_CAUGHT", null);
                    a.this.f97a.a(MotuCrashReporter.getInstance().getConfigure(), baseDataContentA, 2);
                }
                a.this.f97a.a(MotuCrashReporter.getInstance().getConfigure(), baseDataContentA, 1);
                if (baseDataContentA != null) {
                    baseDataContentA.appStatus = String.format("%s%s", com.alibaba.sdk.android.man.crashreporter.b.f96j, Long.valueOf(System.currentTimeMillis()));
                    a.this.f98a.a(baseDataContentA);
                }
                com.alibaba.sdk.android.man.crashreporter.b.a.e("end send abort content!");
            } catch (Exception e2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.a("start send abort content err", e2);
            }
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m48a(CrashReportDataForSave crashReportDataForSave) {
            Integer num;
            if (crashReportDataForSave.type.intValue() != 2 && MotuCrashReporter.getInstance().getConfigure().enableDeduplication && (num = crashReportDataForSave.times) != null && crashReportDataForSave.triggeredTime != null && num.intValue() != 1 && crashReportDataForSave.times.intValue() > 1) {
                if (System.currentTimeMillis() - crashReportDataForSave.triggeredTime.longValue() < 3600000 && crashReportDataForSave.times.intValue() < 10) {
                    return false;
                }
                a.this.f98a.b(true);
            }
            return true;
        }

        public void e() {
            try {
                int i2 = this.D;
                if (i2 != 3) {
                    if ((i2 == 1 || i2 == 2) && m48a(this.f102a)) {
                        a(this.f102a, 0);
                        return;
                    }
                    return;
                }
                String[] strArrA = a.this.f4707b.a(0);
                if (strArrA != null) {
                    for (String str : strArrA) {
                        com.alibaba.sdk.android.man.crashreporter.b.a.b("find file and start send:", str);
                        CrashReportDataForSave crashReportDataForSaveB = a.this.f4707b.b(str);
                        if (m48a(crashReportDataForSaveB)) {
                            a(crashReportDataForSaveB, 0);
                        }
                    }
                }
                String[] strArrA2 = a.this.f4707b.a(1);
                if (strArrA2 != null) {
                    for (String str2 : strArrA2) {
                        com.alibaba.sdk.android.man.crashreporter.b.a.b("find file and start send:", str2);
                        com.alibaba.sdk.android.man.crashreporter.b.a.e("start send native crash here.");
                        CrashReportDataForSave crashReportDataForSaveB2 = a.this.f4707b.b(str2);
                        if (crashReportDataForSaveB2 == null) {
                            crashReportDataForSaveB2 = new CrashReportDataForSave();
                            crashReportDataForSaveB2.type = 1;
                            crashReportDataForSaveB2.times = 1;
                            crashReportDataForSaveB2.triggeredTime = Long.valueOf(System.currentTimeMillis());
                            crashReportDataForSaveB2.path = null;
                            crashReportDataForSaveB2.nativeCrashPath = String.format("%s/%s/%s", a.this.f4707b.i(), "motu", str2);
                        }
                        if (m48a(crashReportDataForSaveB2)) {
                            a(crashReportDataForSaveB2, 1);
                        }
                    }
                }
            } catch (Exception e2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("start send crash failure", e2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.f100b.compareAndSet(false, true)) {
                    try {
                        e();
                        a.this.f100b.compareAndSet(true, false);
                    } catch (Throwable th) {
                        a.this.f100b.compareAndSet(true, false);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("send error.", th2);
            }
        }

        private String a(CrashReportDataForSave crashReportDataForSave) {
            String strMo38a;
            try {
                if (crashReportDataForSave.nativeCrashPath == null || (strMo38a = a.this.f97a.mo38a(crashReportDataForSave.nativeCrashPath)) == null) {
                    return "";
                }
                String str = crashReportDataForSave.content;
                if (str != null) {
                    Map mapA = g.a(com.alibaba.sdk.android.man.crashreporter.e.b.decode(str.getBytes()));
                    if (mapA == null) {
                        return "";
                    }
                    mapA.put("backtrace", strMo38a);
                    return com.alibaba.sdk.android.man.crashreporter.e.b.b(g.c(mapA));
                }
                HashMap map = new HashMap();
                map.put("backtrace", strMo38a);
                return com.alibaba.sdk.android.man.crashreporter.e.b.b(g.c(map));
            } catch (Exception e2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("get native crash content failure", e2);
                return "";
            }
        }

        private void a(CrashReportDataForSave crashReportDataForSave, int i2) {
            int i3;
            if (crashReportDataForSave != null) {
                try {
                    if (a.this.f4707b.a(crashReportDataForSave, i2)) {
                        com.alibaba.sdk.android.man.crashreporter.b.a.e("start send crash file!");
                        if (crashReportDataForSave.type.intValue() == 0) {
                            i3 = 1;
                        } else if (crashReportDataForSave.type.intValue() == 1) {
                            crashReportDataForSave.content = a(crashReportDataForSave);
                            i3 = 61006;
                        } else {
                            i3 = crashReportDataForSave.type.intValue() == 2 ? 61007 : 0;
                        }
                        HashMap map = new HashMap();
                        String str = crashReportDataForSave.toUTCrashMsg;
                        if (str != null) {
                            map.put("StackTrace=====>" + str, "--invalid--");
                        }
                        String str2 = crashReportDataForSave.content;
                        if (str2 != null) {
                            com.alibaba.sdk.android.man.crashreporter.b.a.e("content_base64 is not null");
                        }
                        if (a(crashReportDataForSave.utPage, i3, com.alibaba.sdk.android.man.crashreporter.b.f93g, str2, crashReportDataForSave.metaDataBase64, map)) {
                            com.alibaba.sdk.android.man.crashreporter.b.a.e("delete crash file!");
                            e.i(crashReportDataForSave.path);
                        } else {
                            com.alibaba.sdk.android.man.crashreporter.b.a.e("send file failure!");
                        }
                    }
                } catch (Exception e2) {
                    com.alibaba.sdk.android.man.crashreporter.b.a.d("send crashReport err.", e2);
                }
            }
        }

        private boolean a(String str, int i2, String str2, String str3, String str4, Map map) {
            if (map == null) {
                try {
                    map = new HashMap();
                } catch (Exception e2) {
                    com.alibaba.sdk.android.man.crashreporter.b.a.d("send crashReport err.", e2);
                    return false;
                }
            }
            Map map2 = map;
            map2.put(MANConfig.SDK_VERSION_KEY, MANConfig.SDK_VERSION_VALUE);
            com.alibaba.sdk.android.man.crashreporter.b.a.b(com.alibaba.sdk.android.man.crashreporter.b.a.TAG, "commitEventFinally : eventId=" + i2 + ", arg1=" + str2 + ", arg2=" + str3 + ", arg3=" + str4 + ", " + map2.toString());
            UTAnalytics.getInstance().getTracker("aliyun_mbaas").send(new UTOriginalCustomHitBuilder(str, i2, str2, str3, str4, map2).build());
            return true;
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.c.b
    public void a(CrashReportDataForSave crashReportDataForSave, Map<com.alibaba.sdk.android.man.crashreporter.global.a, String> map, int i2) {
        if (this.f4706a == null || this.f99a == null || this.f4707b == null) {
            com.alibaba.sdk.android.man.crashreporter.b.a.e("send err because sendPools or crashReportStorage or context is null!");
        }
        if (this.f100b.get() || !com.alibaba.sdk.android.man.crashreporter.e.a.d(this.f4706a)) {
            return;
        }
        this.f99a.execute(new RunnableC0063a(i2, crashReportDataForSave, this.f4706a, map));
    }
}

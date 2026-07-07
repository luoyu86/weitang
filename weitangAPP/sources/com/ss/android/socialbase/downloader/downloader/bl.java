package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.depend.kz;
import com.ss.android.socialbase.downloader.depend.sg;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.vz;
import com.ss.android.socialbase.downloader.downloader.io;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile k f10021a;
    private static final int ah;
    private static volatile r bl;
    private static volatile boolean cf;
    private static boolean cs;
    private static com.ss.android.socialbase.downloader.s.bl dx;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.network.kf f10022e;
    private static final List<com.ss.android.socialbase.downloader.depend.r> ej;
    private static volatile zz ep;
    private static volatile vz er;
    private static volatile io fd;
    private static volatile com.ss.android.socialbase.downloader.network.kf fl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile t f10024h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile ExecutorService f10025i;
    private static volatile ExecutorService io;
    private static volatile IDownloadHttpService j;
    private static volatile IDownloadHttpService k;
    private static volatile com.ss.android.socialbase.downloader.impls.ok kf;
    private static volatile com.ss.android.socialbase.downloader.s.a kz;
    private static final int l;
    private static volatile DownloadReceiver m;
    private static volatile v n;
    private static volatile ScheduledExecutorService o;
    private static volatile Context ok;
    private static volatile t p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static volatile ok f10026q;
    private static int qu;
    private static final List<kz> qx;
    private static volatile com.ss.android.socialbase.downloader.network.p r;
    private static volatile j rh;
    private static volatile p s;
    private static volatile ExecutorService t;
    private static volatile ExecutorService td;
    private static td tg;
    private static int tr;
    private static volatile ExecutorService u;
    private static volatile ExecutorService ul;
    private static int vk;
    private static volatile x vz;
    private static boolean w;
    private static final int wv;
    private static volatile ExecutorService x;
    private static final int xy;
    private static volatile h y;
    private static boolean yt;
    private static volatile com.ss.android.socialbase.downloader.network.p z;
    private static volatile ExecutorService zz;
    private static volatile List<sg> fb = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f10023g = false;
    private static volatile OkHttpClient v = null;
    private static final List<com.ss.android.socialbase.downloader.depend.z> em = new ArrayList();
    private static boolean sg = false;

    public interface ok {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.downloader.bl$ok$ok, reason: collision with other inner class name */
        public interface InterfaceC0165ok {
            void ok();
        }

        z a();

        t ok();

        u ok(InterfaceC0165ok interfaceC0165ok);
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        xy = iAvailableProcessors;
        ah = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        l = iAvailableProcessors;
        wv = iAvailableProcessors;
        vk = 8192;
        ej = new ArrayList();
        qx = new ArrayList();
        cs = true;
        w = false;
        cf = false;
    }

    private bl() {
    }

    public static synchronized void a(DownloaderBuilder downloaderBuilder) {
        bl(downloaderBuilder);
    }

    public static io ah() {
        if (fd == null) {
            synchronized (bl.class) {
                if (fd == null) {
                    fd = new io.ok();
                }
            }
        }
        return fd;
    }

    private static void bl(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                ok(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                ok(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                ok(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                ok(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                ok(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                a(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                ok(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                ok(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                ok(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                bl(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                s(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                n(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                kf(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                h(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                p(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                ok(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                a(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                ok(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                vz = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                vk = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                ok(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                f10023g = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                tr = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                ok(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                fl = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                fd = downloaderBuilder.getTTNetHandler();
                if (fd.ok()) {
                    ok(fd.a());
                    ok(fd.bl());
                } else {
                    ok(p());
                    ok(q());
                }
            }
            a(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                ok(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    private static void cs() {
        if (m == null) {
            m = new DownloadReceiver();
        }
        if (sg) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            ok.registerReceiver(m, intentFilter);
            sg = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean e() {
        return cs;
    }

    public static boolean ej() {
        return cf;
    }

    public static p em() {
        if (s == null) {
            synchronized (bl.class) {
                if (s == null) {
                    s = new com.ss.android.socialbase.downloader.impls.bl();
                }
            }
        }
        return s;
    }

    public static t ep() {
        if (f10024h == null) {
            synchronized (bl.class) {
                if (f10024h == null) {
                    f10024h = new com.ss.android.socialbase.downloader.impls.p();
                }
            }
        }
        return f10024h;
    }

    public static r er() {
        if (bl == null) {
            synchronized (bl.class) {
                if (bl == null) {
                    bl = new com.ss.android.socialbase.downloader.impls.q();
                }
            }
        }
        return bl;
    }

    public static com.ss.android.socialbase.downloader.impls.ok fb() {
        if (kf == null) {
            synchronized (bl.class) {
                if (kf == null) {
                    kf = new com.ss.android.socialbase.downloader.impls.n();
                }
            }
        }
        return kf;
    }

    public static synchronized int fd() {
        return vk;
    }

    public static void fl() {
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.n.bl)) {
            com.ss.android.socialbase.downloader.constants.n.bl = AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO;
            com.ss.android.socialbase.downloader.constants.n.f9994a = com.ss.android.socialbase.downloader.constants.n.bl.toUpperCase();
        }
    }

    public static int g() {
        return tr;
    }

    public static com.ss.android.socialbase.downloader.s.a h() {
        return kz;
    }

    public static ExecutorService i() {
        if (x == null) {
            synchronized (bl.class) {
                if (x == null) {
                    int i2 = l;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.p.ok("DownloadThreadPool-mix-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    x = threadPoolExecutor;
                }
            }
        }
        return x;
    }

    public static OkHttpClient.Builder io() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(30000L, timeUnit).readTimeout(30000L, timeUnit).writeTimeout(30000L, timeUnit).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (ul != null) {
            builder.dispatcher(new Dispatcher(ul));
        }
        return builder;
    }

    public static ExecutorService j() {
        if (t == null) {
            synchronized (bl.class) {
                if (t == null) {
                    int i2 = xy;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.p.ok("DownloadThreadPool-cpu-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    t = threadPoolExecutor;
                }
            }
        }
        return t;
    }

    public static boolean k() {
        return com.ss.android.socialbase.downloader.h.ok.bl().ok("switch_not_auto_boot_service", w ? 1 : 0) > 0;
    }

    public static com.ss.android.socialbase.downloader.network.p kf() {
        return r;
    }

    public static List<com.ss.android.socialbase.downloader.depend.z> kz() {
        return em;
    }

    public static synchronized Context l() {
        return ok;
    }

    public static k m() {
        if (f10021a == null) {
            synchronized (bl.class) {
                if (f10021a == null) {
                    f10021a = new com.ss.android.socialbase.downloader.impls.s();
                }
            }
        }
        return f10021a;
    }

    public static List<sg> n() {
        List<sg> list;
        synchronized (fb) {
            list = fb;
        }
        return list;
    }

    public static com.ss.android.socialbase.downloader.network.kf o() {
        if (f10022e == null) {
            synchronized (bl.class) {
                if (f10022e == null) {
                    f10022e = new com.ss.android.socialbase.downloader.network.kf() { // from class: com.ss.android.socialbase.downloader.downloader.bl.2
                        @Override // com.ss.android.socialbase.downloader.network.kf
                        public List<InetAddress> ok(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return f10022e;
    }

    public static synchronized void ok(DownloaderBuilder downloaderBuilder) {
        if (cf) {
            com.ss.android.socialbase.downloader.bl.ok.n("DownloadComponentManager", "component has init");
            return;
        }
        boolean z2 = f10023g;
        bl(downloaderBuilder);
        if (f10021a == null) {
            f10021a = new com.ss.android.socialbase.downloader.impls.s();
        }
        if (f10024h == null) {
            f10024h = new com.ss.android.socialbase.downloader.impls.p();
        }
        if (p == null && f10026q != null) {
            p = f10026q.ok();
        }
        if (bl == null) {
            bl = new com.ss.android.socialbase.downloader.impls.q();
        }
        if (kf == null) {
            kf = new com.ss.android.socialbase.downloader.impls.n();
        }
        if (s == null) {
            s = new com.ss.android.socialbase.downloader.impls.bl();
        }
        if (y == null) {
            y = new com.ss.android.socialbase.downloader.impls.a();
        }
        if (ep == null) {
            ep = new com.ss.android.socialbase.downloader.impls.k();
        }
        int i2 = qu;
        if (i2 <= 0 || i2 > xy) {
            qu = xy;
        }
        cs();
        if (f10023g && !z2 && !com.ss.android.socialbase.downloader.q.kf.bl()) {
            com.ss.android.socialbase.downloader.impls.j.ok(true).startService();
        } else if (com.ss.android.socialbase.downloader.q.kf.s()) {
            ExecutorService executorServiceZ = z();
            if (executorServiceZ != null) {
                executorServiceZ.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.bl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Context contextL = bl.l();
                        if (contextL != null) {
                            com.ss.android.socialbase.downloader.q.kf.s(contextL);
                        }
                    }
                });
            }
        } else {
            Context contextL = l();
            if (contextL != null) {
                com.ss.android.socialbase.downloader.q.kf.s(contextL);
            }
        }
        fl();
        cf = true;
    }

    public static void ok(td tdVar) {
    }

    public static IDownloadHttpService p() {
        if (j == null) {
            synchronized (bl.class) {
                if (j == null) {
                    j = new com.ss.android.socialbase.downloader.impls.h();
                }
            }
        }
        return j;
    }

    public static com.ss.android.socialbase.downloader.network.p q() {
        if (z == null) {
            synchronized (bl.class) {
                if (z == null) {
                    z = new com.ss.android.socialbase.downloader.impls.kf();
                }
            }
        }
        return z;
    }

    public static h qu() {
        if (y == null) {
            synchronized (bl.class) {
                if (y == null) {
                    y = new com.ss.android.socialbase.downloader.impls.a();
                }
            }
        }
        return y;
    }

    public static boolean qx() {
        StringBuilder sb = new StringBuilder();
        sb.append("supportMultiProc::=");
        sb.append(f10026q != null);
        com.ss.android.socialbase.downloader.bl.ok.ok("wjd", sb.toString());
        return f10026q != null;
    }

    public static synchronized x r() {
        return vz;
    }

    public static ExecutorService rh() {
        return td != null ? td : i();
    }

    public static IDownloadHttpService s() {
        return k;
    }

    public static v sg() {
        return n;
    }

    public static ExecutorService t() {
        return zz != null ? zz : i();
    }

    public static ExecutorService td() {
        if (u == null) {
            synchronized (bl.class) {
                if (u == null) {
                    int i2 = wv;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.p.ok("DownloadThreadPool-db-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    u = threadPoolExecutor;
                }
            }
        }
        return u;
    }

    public static ok tr() {
        return f10026q;
    }

    public static ScheduledExecutorService u() {
        if (o == null) {
            synchronized (bl.class) {
                if (o == null) {
                    o = new ScheduledThreadPoolExecutor(1, new com.ss.android.socialbase.downloader.p.ok("DownloadThreadPool-Schedule", true));
                }
            }
        }
        return o;
    }

    public static com.ss.android.socialbase.downloader.network.kf ul() {
        return fl;
    }

    @NonNull
    public static JSONObject v() {
        return (er == null || er.ok() == null) ? com.ss.android.socialbase.downloader.constants.n.f9996q : er.ok();
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.s.bl vk() {
        if (dx == null) {
            dx = new com.ss.android.socialbase.downloader.s.bl() { // from class: com.ss.android.socialbase.downloader.downloader.bl.3
                @Override // com.ss.android.socialbase.downloader.s.bl
                public void a(int i2, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.s.bl
                public void ok(int i2, String str, JSONObject jSONObject) {
                }
            };
        }
        return dx;
    }

    public static t vz() {
        if (p == null) {
            synchronized (bl.class) {
                if (p == null) {
                    p = f10026q.ok();
                }
            }
        }
        return p;
    }

    public static synchronized boolean wv() {
        return yt;
    }

    public static ExecutorService x() {
        if (io == null) {
            synchronized (bl.class) {
                if (io == null) {
                    int i2 = ah;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.p.ok("DownloadThreadPool-chunk-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    io = threadPoolExecutor;
                }
            }
        }
        return io;
    }

    public static zz xy() {
        if (ep == null) {
            synchronized (bl.class) {
                if (ep == null) {
                    ep = new com.ss.android.socialbase.downloader.impls.k();
                }
            }
        }
        return ep;
    }

    public static synchronized j y() {
        return rh;
    }

    public static td yt() {
        return tg;
    }

    public static ExecutorService z() {
        return f10025i != null ? f10025i : j();
    }

    public static OkHttpClient zz() {
        if (v == null) {
            synchronized (bl.class) {
                if (v == null) {
                    v = io().build();
                }
            }
        }
        return v;
    }

    private static void h(ExecutorService executorService) {
        if (executorService != null) {
            zz = executorService;
        }
    }

    private static void kf(ExecutorService executorService) {
        if (executorService != null) {
            td = executorService;
        }
    }

    private static void s(ExecutorService executorService) {
        if (executorService != null) {
            f10025i = executorService;
        }
    }

    public static synchronized void a() {
        if (f10023g) {
            return;
        }
        f10023g = true;
        try {
            Intent intent = new Intent(l(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            l().startService(intent);
            if (!com.ss.android.socialbase.downloader.q.kf.bl()) {
                com.ss.android.socialbase.downloader.impls.j.ok(true).startService();
            }
        } catch (Throwable th) {
            f10023g = false;
            th.printStackTrace();
        }
    }

    private static void n(ExecutorService executorService) {
        if (executorService != null) {
            x = executorService;
        }
    }

    private static void p(ExecutorService executorService) {
        if (executorService != null) {
            u = executorService;
        }
    }

    public static void a(com.ss.android.socialbase.downloader.depend.r rVar) {
        List<com.ss.android.socialbase.downloader.depend.r> list = ej;
        synchronized (list) {
            if (rVar != null) {
                if (list.contains(rVar)) {
                    list.remove(rVar);
                }
            }
        }
    }

    public static void a(DownloadTask downloadTask, int i2) {
        List<kz> list = qx;
        synchronized (list) {
            for (kz kzVar : list) {
                if (kzVar != null) {
                    kzVar.a(downloadTask, i2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.network.h a(java.lang.String r11, java.util.List<com.ss.android.socialbase.downloader.model.bl> r12, int r13, boolean r14, com.ss.android.socialbase.downloader.model.DownloadInfo r15) throws java.lang.Throwable {
        /*
            r0 = 1
            if (r13 != r0) goto L8
            com.ss.android.socialbase.downloader.network.p r0 = kf()
            goto Lc
        L8:
            com.ss.android.socialbase.downloader.network.p r0 = q()
        Lc:
            if (r0 == 0) goto L49
            r1 = 0
            r9 = 0
            r2 = 0
            if (r14 == 0) goto L18
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
        L18:
            com.ss.android.socialbase.downloader.network.h r12 = r0.ok(r11, r12)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
            if (r14 == 0) goto L2e
            r4 = 0
            long r0 = java.lang.System.currentTimeMillis()
            long r5 = r0 - r2
            java.lang.String r7 = "head"
            r2 = r12
            r3 = r11
            r8 = r13
            r10 = r15
            com.ss.android.socialbase.downloader.s.ok.ok(r2, r3, r4, r5, r7, r8, r9, r10)
        L2e:
            return r12
        L2f:
            r12 = move-exception
            r8 = r9
            goto L37
        L32:
            r12 = move-exception
            throw r12     // Catch: java.lang.Throwable -> L34
        L34:
            r0 = move-exception
            r8 = r12
            r12 = r0
        L37:
            if (r14 == 0) goto L48
            r14 = 0
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            java.lang.String r6 = "head"
            r2 = r11
            r3 = r14
            r7 = r13
            r9 = r15
            com.ss.android.socialbase.downloader.s.ok.ok(r1, r2, r3, r4, r6, r7, r8, r9)
        L48:
            throw r12
        L49:
            com.ss.android.socialbase.downloader.exception.BaseException r11 = new com.ss.android.socialbase.downloader.exception.BaseException
            r12 = 1022(0x3fe, float:1.432E-42)
            java.io.IOException r14 = new java.io.IOException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "httpService not exist, netLib = "
            r15.append(r0)
            r15.append(r13)
            java.lang.String r13 = r15.toString()
            r14.<init>(r13)
            r11.<init>(r12, r14)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.bl.a(java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.h");
    }

    public static void a(ExecutorService executorService) {
        if (executorService != null) {
            ul = executorService;
        }
    }

    public static void a(Runnable runnable) {
        a(runnable, false);
    }

    public static void a(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.q.kf.s()) {
            runnable.run();
        } else {
            z().execute(runnable);
        }
    }

    public static synchronized void ok() {
        try {
            if (sg && m != null && ok != null) {
                ok.unregisterReceiver(m);
                sg = false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(int i2) {
        if (i2 > 0) {
            qu = i2;
        }
    }

    private static void a(boolean z2) {
        cs = z2;
    }

    public static void ok(sg sgVar) {
        if (sgVar == null) {
            return;
        }
        synchronized (fb) {
            fb.add(sgVar);
        }
    }

    public static void ok(com.ss.android.socialbase.downloader.depend.r rVar) {
        List<com.ss.android.socialbase.downloader.depend.r> list = ej;
        synchronized (list) {
            if (rVar != null) {
                if (!list.contains(rVar)) {
                    list.add(rVar);
                }
            }
        }
    }

    public static void ok(com.ss.android.socialbase.downloader.constants.s sVar) {
        List<com.ss.android.socialbase.downloader.depend.r> list = ej;
        synchronized (list) {
            for (com.ss.android.socialbase.downloader.depend.r rVar : list) {
                if (rVar != null) {
                    if (sVar == com.ss.android.socialbase.downloader.constants.s.SYNC_START) {
                        rVar.ok();
                    } else if (sVar == com.ss.android.socialbase.downloader.constants.s.SYNC_SUCCESS) {
                        rVar.a();
                    }
                }
            }
            if (sVar == com.ss.android.socialbase.downloader.constants.s.SYNC_SUCCESS) {
                ej.clear();
            }
        }
    }

    public static synchronized boolean bl() {
        return f10023g;
    }

    public static void ok(DownloadTask downloadTask, int i2) {
        List<kz> list = qx;
        synchronized (list) {
            for (kz kzVar : list) {
                if (kzVar != null) {
                    kzVar.ok(downloadTask, i2);
                }
            }
        }
    }

    private static void bl(ExecutorService executorService) {
        if (executorService != null) {
            t = executorService;
        }
    }

    public static void bl(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.q.kf.s()) {
            runnable.run();
        } else {
            td().execute(runnable);
        }
    }

    public static com.ss.android.socialbase.downloader.network.q ok(boolean z2, int i2, String str, List<com.ss.android.socialbase.downloader.model.bl> list) throws Exception {
        return ok(z2, i2, str, null, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.q ok(boolean z2, int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.bl> list, int i3, boolean z3, DownloadInfo downloadInfo) throws Exception {
        List<com.ss.android.socialbase.downloader.model.bl> list2;
        int i4;
        com.ss.android.socialbase.downloader.network.q qVarOk;
        if (!TextUtils.isEmpty(str2)) {
            List<com.ss.android.socialbase.downloader.model.bl> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.model.bl("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i4 = 1;
        } else if (z2) {
            list2 = list;
            i4 = i3;
        } else {
            i4 = 2;
            list2 = list;
        }
        int[] iArrOk = ok(i4);
        Exception exc = null;
        for (int i5 : iArrOk) {
            try {
                qVarOk = ok(i2, str, str2, list2, i5, z3, downloadInfo);
            } catch (Exception e2) {
                if (downloadInfo.isExpiredRedownload() && com.ss.android.socialbase.downloader.q.kf.h(e2) && com.ss.android.socialbase.downloader.q.kf.bl(list2)) {
                    com.ss.android.socialbase.downloader.bl.ok.ok("dcach::http exception 304, throw excepiton, not retry " + e2);
                    throw e2;
                }
                exc = e2;
            }
            if (qVarOk != null) {
                return qVarOk;
            }
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.network.q ok(int r11, java.lang.String r12, java.lang.String r13, java.util.List<com.ss.android.socialbase.downloader.model.bl> r14, int r15, boolean r16, com.ss.android.socialbase.downloader.model.DownloadInfo r17) throws java.lang.Throwable {
        /*
            r7 = r15
            r0 = 1
            if (r7 != r0) goto L9
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = s()
            goto Ld
        L9:
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = p()
        Ld:
            if (r0 == 0) goto L55
            r1 = 0
            r8 = 0
            r2 = 0
            if (r16 == 0) goto L20
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1d
            goto L20
        L1a:
            r0 = move-exception
            r5 = r12
            goto L42
        L1d:
            r0 = move-exception
            r5 = r12
            goto L3e
        L20:
            r4 = r11
            r5 = r12
            r6 = r14
            com.ss.android.socialbase.downloader.network.q r0 = r0.downloadWithConnection(r11, r12, r14)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            if (r16 == 0) goto L3a
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r2
            java.lang.String r6 = "get"
            r1 = r0
            r2 = r12
            r3 = r13
            r4 = r9
            r7 = r15
            r9 = r17
            com.ss.android.socialbase.downloader.s.ok.ok(r1, r2, r3, r4, r6, r7, r8, r9)
        L3a:
            return r0
        L3b:
            r0 = move-exception
            goto L42
        L3d:
            r0 = move-exception
        L3e:
            r4 = r0
            throw r4     // Catch: java.lang.Throwable -> L40
        L40:
            r0 = move-exception
            r8 = r4
        L42:
            if (r16 == 0) goto L54
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r2
            java.lang.String r6 = "get"
            r2 = r12
            r3 = r13
            r4 = r9
            r7 = r15
            r9 = r17
            com.ss.android.socialbase.downloader.s.ok.ok(r1, r2, r3, r4, r6, r7, r8, r9)
        L54:
            throw r0
        L55:
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            r1 = 1022(0x3fe, float:1.432E-42)
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "httpService not exist, netLib = "
            r3.append(r4)
            r3.append(r15)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.bl.ok(int, java.lang.String, java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.q");
    }

    public static com.ss.android.socialbase.downloader.network.h ok(String str, List<com.ss.android.socialbase.downloader.model.bl> list) throws Exception {
        return ok(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.h ok(String str, List<com.ss.android.socialbase.downloader.model.bl> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        com.ss.android.socialbase.downloader.network.h hVarA;
        Exception e2 = null;
        for (int i3 : ok(i2)) {
            try {
                hVarA = a(str, list, i3, z2, downloadInfo);
            } catch (Exception e3) {
                e2 = e3;
            }
            if (hVarA != null) {
                return hVarA;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw e2;
    }

    private static int[] ok(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0};
    }

    public static synchronized void ok(j jVar) {
        if (jVar != null) {
            rh = jVar;
            if (f10021a instanceof com.ss.android.socialbase.downloader.impls.s) {
                ((com.ss.android.socialbase.downloader.impls.s) f10021a).p();
            }
        }
    }

    public static void ok(ExecutorService executorService) {
        if (executorService != null) {
            io = executorService;
        }
    }

    private static void ok(List<com.ss.android.socialbase.downloader.depend.z> list) {
        List<com.ss.android.socialbase.downloader.depend.z> list2 = em;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void ok(boolean z2) {
        w = z2;
    }

    public static void ok(Runnable runnable) {
        ok(runnable, false);
    }

    public static void ok(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.q.kf.s()) {
            runnable.run();
        } else {
            j().execute(runnable);
        }
    }

    public static Future ok(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return u().schedule(runnable, j2, timeUnit);
    }

    public static void ok(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            k = iDownloadHttpService;
        }
        yt = k != null;
    }

    public static void ok(com.ss.android.socialbase.downloader.network.p pVar) {
        if (pVar != null) {
            r = pVar;
        }
    }

    private static void ok(k kVar) {
        if (kVar != null) {
            f10021a = kVar;
        }
    }

    private static void ok(r rVar) {
        if (rVar != null) {
            bl = rVar;
        }
    }

    private static void ok(com.ss.android.socialbase.downloader.s.a aVar) {
        if (aVar != null) {
            kz = aVar;
        }
    }

    public static void ok(vz vzVar) {
        er = vzVar;
        com.ss.android.socialbase.downloader.h.ok.ok();
    }

    private static void ok(p pVar) {
        if (pVar != null) {
            s = pVar;
        }
    }

    public static void ok(v vVar) {
        if (vVar != null) {
            n = vVar;
        }
    }

    private static void ok(h hVar) {
        if (hVar != null) {
            y = hVar;
        }
    }

    public static synchronized void ok(Context context) {
        if (context != null) {
            if (ok == null) {
                ok = context.getApplicationContext();
                com.ss.android.socialbase.downloader.ok.ok.ok().ok(ok);
            }
        }
    }

    public static int ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        String taskKey = downloadInfo.getTaskKey();
        if (TextUtils.isEmpty(taskKey)) {
            taskKey = downloadInfo.getUrl();
        }
        return ok(taskKey, downloadInfo.getSavePath());
    }

    public static int ok(String str, String str2) {
        r rVarEr = er();
        if (rVarEr == null) {
            return 0;
        }
        return rVarEr.ok(str, str2);
    }

    public static void ok(com.ss.android.socialbase.downloader.s.bl blVar) {
        dx = blVar;
    }

    public static void ok(ok okVar) {
        com.ss.android.socialbase.downloader.bl.ok.ok("wjd", "setIndependentServiceCreator::creator=" + okVar);
        f10026q = okVar;
    }
}

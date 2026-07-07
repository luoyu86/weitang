package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.ss.android.socialbase.appdownloader.bl.k;
import com.ss.android.socialbase.appdownloader.bl.z;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.fb;
import com.ss.android.socialbase.downloader.depend.fl;
import com.ss.android.socialbase.downloader.depend.rh;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.td;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile s f9955a = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f9956h = false;
    private static boolean kf = false;
    private static final String ok = "s";
    private static boolean p = false;
    private String bl;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private z f9957i;
    private com.ss.android.socialbase.appdownloader.bl.bl j;
    private int k;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Future f9958q;
    private com.ss.android.socialbase.appdownloader.bl.p rh;
    private String s;
    private com.ss.android.socialbase.appdownloader.bl.h t;
    private k td;
    private fl u;
    private com.ss.android.socialbase.appdownloader.bl.kf x;
    private com.ss.android.socialbase.appdownloader.bl.s z;
    private fb zz;
    private DownloadReceiver n = new DownloadReceiver();
    private boolean r = false;

    private s() {
    }

    private void io() {
        if (Build.VERSION.SDK_INT >= 21) {
            td.ok(new td.a() { // from class: com.ss.android.socialbase.appdownloader.s.2
                @Override // com.ss.android.socialbase.downloader.impls.td.a
                public void ok(DownloadInfo downloadInfo, long j, boolean z, int i2) {
                    RetryJobSchedulerService.ok(downloadInfo, j, z, i2);
                }
            });
        }
    }

    public static s k() {
        if (f9955a == null) {
            synchronized (s.class) {
                if (f9955a == null) {
                    f9955a = new s();
                }
            }
        }
        return f9955a;
    }

    private void u() {
        this.k = com.ss.android.socialbase.downloader.h.ok.bl().a("app_install_keep_receiver_time_s");
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.k);
        if (this.k <= 0) {
            return;
        }
        Future future = this.f9958q;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.f9958q = com.ss.android.socialbase.downloader.downloader.bl.ok(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.s.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.bl.ok.a(s.ok, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                s.this.j();
                s.this.zz();
            }
        }, this.k, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zz() {
        synchronized (this.n) {
            if (f9956h) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
                intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme("file");
                com.ss.android.socialbase.downloader.downloader.bl.l().registerReceiver(this.n, intentFilter);
                com.ss.android.socialbase.downloader.downloader.bl.l().registerReceiver(this.n, intentFilter2);
                f9956h = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "registerDownloadReceiver mIsRegistered:" + f9956h);
        }
    }

    public com.ss.android.socialbase.appdownloader.bl.p bl() {
        return this.rh;
    }

    public k h() {
        return this.td;
    }

    public fb i() {
        return this.zz;
    }

    public void j() {
        synchronized (this.n) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (f9956h) {
                com.ss.android.socialbase.downloader.downloader.bl.l().unregisterReceiver(this.n);
                f9956h = false;
                p = false;
            } else {
                f9956h = false;
                p = false;
            }
        }
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    public boolean kf() {
        return com.ss.android.socialbase.downloader.h.ok.a().optInt("package_flag_config", 1) == 1;
    }

    public com.ss.android.socialbase.appdownloader.bl.kf n() {
        return this.x;
    }

    public File p() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getGlobalSaveDir();
    }

    public String q() {
        return this.bl;
    }

    public void r() {
        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("enable_app_install_receiver", 1) <= 0) {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "disable app install receiver");
            return;
        }
        synchronized (this.n) {
            try {
                if (p) {
                    return;
                }
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter.addDataScheme(AbsServerManager.PACKAGE_QUERY_BINDER);
                    com.ss.android.socialbase.downloader.downloader.bl.l().registerReceiver(this.n, intentFilter);
                    p = true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                com.ss.android.socialbase.downloader.bl.ok.a(ok, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + f9956h);
            } finally {
                u();
            }
        }
    }

    public com.ss.android.socialbase.appdownloader.bl.h rh() {
        return this.t;
    }

    public String s() {
        return this.s;
    }

    public com.ss.android.socialbase.downloader.downloader.td t() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getReserveWifiStatusListener();
    }

    public fl x() {
        return this.u;
    }

    public z z() {
        return this.f9957i;
    }

    private void bl(Context context) {
        if (context == null || kf) {
            return;
        }
        com.ss.android.socialbase.downloader.constants.n.ok("application/vnd.android.package-archive");
        com.ss.android.socialbase.downloader.downloader.bl.ok(context);
        com.ss.android.socialbase.downloader.downloader.bl.ok(new com.ss.android.socialbase.appdownloader.s.a());
        zz();
        io();
        kf = true;
    }

    public com.ss.android.socialbase.appdownloader.bl.s a() {
        return this.z;
    }

    public void a(String str) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).setDefaultSavePath(str);
    }

    public com.ss.android.socialbase.appdownloader.bl.bl ok() {
        return this.j;
    }

    private DownloadInfo a(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList == null) {
            return null;
        }
        for (DownloadInfo downloadInfo : downloadInfoList) {
            if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                return downloadInfo;
            }
        }
        return null;
    }

    public void ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.s = str;
    }

    public void ok(k kVar) {
        this.td = kVar;
    }

    public List<DownloadInfo> a(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    @Deprecated
    public void ok(Context context, String str, com.ss.android.socialbase.appdownloader.bl.bl blVar, com.ss.android.socialbase.appdownloader.bl.s sVar, com.ss.android.socialbase.appdownloader.bl.p pVar) {
        if (blVar != null) {
            this.j = blVar;
        }
        if (sVar != null) {
            this.z = sVar;
        }
        if (pVar != null) {
            this.rh = pVar;
        }
        bl(context);
    }

    public static boolean ok(Context context, int i2) {
        return bl.ok(context, i2, true) == 1;
    }

    public void ok(Context context, int i2, int i3) {
        try {
            switch (i3) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i2);
                    break;
                case -3:
                    bl.ok(context, i2, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i2);
                    break;
                case 0:
                case 6:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    Downloader.getInstance(context).pause(i2);
                    break;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int ok(kf kfVar) {
        int i2;
        String str;
        int i3;
        JSONObject jSONObject;
        DownloadInfo downloadInfo;
        if (kfVar == null || kfVar.getContext() == null) {
            return 0;
        }
        try {
            List<com.ss.android.socialbase.downloader.model.bl> listOk = ok(kfVar.s());
            String strOk = kfVar.ok();
            if (TextUtils.isEmpty(strOk)) {
                return 0;
            }
            final int iZz = kfVar.zz();
            final boolean z = iZz == 0;
            String strQu = kfVar.qu();
            final String strA = kfVar.a();
            if (TextUtils.isEmpty(strQu)) {
                strQu = bl.ok(strOk, strA, kfVar.j(), z);
            }
            if (strQu.length() > 255) {
                strQu = strQu.substring(strQu.length() - 255);
            }
            if (TextUtils.isEmpty(strA)) {
                strA = strQu;
            }
            String strJ = kfVar.j();
            if (strQu.endsWith(".apk") && !bl.bl(kfVar.j())) {
                strJ = "application/vnd.android.package-archive";
            }
            String strBl = kfVar.bl();
            if (TextUtils.isEmpty(kfVar.bl())) {
                strBl = bl.a();
            }
            String str2 = strBl;
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strQu)) {
                String strEj = kfVar.ej();
                if (TextUtils.isEmpty(strEj)) {
                    strEj = strOk;
                }
                int iOk = com.ss.android.socialbase.downloader.downloader.bl.ok(strEj, str2);
                if (com.ss.android.socialbase.downloader.h.ok.ok(kfVar.to()).ok("resume_task_override_settings") && (downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getDownloadInfo(iOk)) != null) {
                    try {
                        kfVar.ok(new JSONObject(downloadInfo.getDownloadSettingString()));
                    } catch (Throwable unused) {
                    }
                }
                com.ss.android.socialbase.downloader.h.ok.ok(iOk, kfVar.to());
                boolean zSg = kfVar.sg();
                boolean z2 = (com.ss.android.socialbase.downloader.h.ok.ok(iOk).ok("modify_force", 1) == 1 && !zSg && com.ss.android.socialbase.downloader.q.kf.s(str2, strQu) && Downloader.getInstance(kfVar.getContext()).getDownloadInfo(iOk) == null) ? true : zSg;
                IDownloadListener iDownloadListenerK = kfVar.k();
                if (iDownloadListenerK != null || (!kfVar.n() && !kfVar.kf())) {
                    i2 = iOk;
                    str = str2;
                } else if (kfVar.rh() != null) {
                    iDownloadListenerK = new com.ss.android.socialbase.appdownloader.n.a(kfVar.rh());
                    i2 = iOk;
                    str = str2;
                } else {
                    i2 = iOk;
                    str = str2;
                    iDownloadListenerK = new com.ss.android.socialbase.appdownloader.n.a(kfVar.getContext(), iOk, strA, str, strQu, kfVar.r());
                }
                rh rhVarAh = kfVar.ah();
                if (rhVarAh == null) {
                    rhVarAh = new rh() { // from class: com.ss.android.socialbase.appdownloader.s.3
                        @Override // com.ss.android.socialbase.downloader.depend.rh
                        public void ok(DownloadInfo downloadInfo2, BaseException baseException, int i4) {
                            if (s.this.rh != null) {
                                s.this.rh.ok(downloadInfo2, baseException, i4);
                            }
                        }
                    };
                }
                List<com.ss.android.socialbase.downloader.depend.z> listKz = com.ss.android.socialbase.downloader.downloader.bl.kz();
                if (!listKz.isEmpty()) {
                    Iterator<com.ss.android.socialbase.downloader.depend.z> it = listKz.iterator();
                    while (it.hasNext()) {
                        kfVar.ok(it.next());
                    }
                }
                String strR = kfVar.r();
                try {
                    if (!TextUtils.isEmpty(strR)) {
                        jSONObject = new JSONObject(strR);
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("auto_install_with_notification", kfVar.h());
                    jSONObject.put("auto_install_without_notification", kfVar.kf());
                    strR = jSONObject.toString();
                } catch (Throwable unused2) {
                }
                boolean z3 = kfVar.n() || kfVar.kf();
                if (!z3 || com.ss.android.socialbase.downloader.h.ok.ok(i2).a("enable_notification_ui") < 1) {
                    i3 = i2;
                } else {
                    i3 = i2;
                    com.ss.android.socialbase.appdownloader.n.bl.ok().ok(i3, kfVar.ry());
                }
                final DownloadTask autoInstall = com.ss.android.socialbase.downloader.downloader.a.with(kfVar.getContext()).url(strOk).backUpUrls(kfVar.de()).name(strQu).title(strA).savePath(str).onlyWifi(kfVar.p()).extraHeaders(listOk).depend(rhVarAh).retryCount(kfVar.o()).backUpUrlRetryCount(kfVar.y()).showNotification(z3).extra(strR).mimeType(strJ).minProgressTimeMsInterval(kfVar.fb()).maxProgressCount(kfVar.g()).mainThreadListener(kfVar.q()).notificationListener(iDownloadListenerK).notificationEventListener(ok(kfVar.l())).force(z2).autoResumed(kfVar.x()).showNotificationForAutoResumed(kfVar.td()).chunkStategy(kfVar.t()).chunkAdjustCalculator(kfVar.i()).needHttpsToHttpRetry(kfVar.z()).packageName(kfVar.u()).md5(kfVar.io()).expectFileLength(kfVar.ul()).needRetryDelay(kfVar.m()).retryDelayTimeArray(kfVar.ep()).needDefaultHttpServiceBackUp(kfVar.vz()).needReuseFirstConnection(kfVar.kz()).needReuseChunkRunnable(kfVar.v()).needIndependentProcess(kfVar.fl()).enqueueType(kfVar.em()).monitorDepend(kfVar.xy()).retryDelayTimeCalculator(kfVar.er()).headConnectionAvailable(kfVar.e()).fileUriProvider(kfVar.wv()).diskSpaceHandler(kfVar.dn()).needChunkDowngradeRetry(kfVar.fd()).notificationClickCallback(kfVar.vk()).downloadSetting(kfVar.to()).iconUrl(kfVar.ry()).needSDKMonitor(kfVar.w()).monitorScene(kfVar.tg()).extraMonitorStatus(kfVar.dx()).executorGroup(kfVar.tr()).throttleNetSpeed(kfVar.cs()).distinctDirectory(kfVar.cf()).taskKey(kfVar.ej()).setAutoInstall(kfVar.ew());
                if (autoInstall != null && !kfVar.yt().isEmpty()) {
                    autoInstall.setDownloadCompleteHandlers(kfVar.yt());
                }
                if (autoInstall != null) {
                    if (z3 && kfVar.qx() && kfVar.getActivity() != null && !kfVar.getActivity().isFinishing() && !com.ss.android.socialbase.appdownloader.n.s.ok()) {
                        com.ss.android.socialbase.appdownloader.n.s.ok(kfVar.getActivity(), new com.ss.android.socialbase.appdownloader.bl.rh() { // from class: com.ss.android.socialbase.appdownloader.s.4
                            @Override // com.ss.android.socialbase.appdownloader.bl.rh
                            public void a() {
                                com.ss.android.socialbase.downloader.bl.ok.a(s.ok, "notification permission denied, start download :" + strA);
                                s.this.ok(autoInstall, iZz, z);
                            }

                            @Override // com.ss.android.socialbase.appdownloader.bl.rh
                            public void ok() {
                                com.ss.android.socialbase.downloader.bl.ok.a(s.ok, "notification permission granted, start download :" + strA);
                                s.this.ok(autoInstall, iZz, z);
                            }
                        });
                    } else {
                        com.ss.android.socialbase.downloader.bl.ok.a(ok, "notification permission need not request, start download :" + strA);
                        ok(autoInstall, iZz, z);
                        autoInstall.getDownloadInfo();
                    }
                }
                return i3;
            }
            return 0;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.s.ok.ok(kfVar.xy(), (DownloadInfo) null, new BaseException(1003, com.ss.android.socialbase.downloader.q.kf.a(th, "addDownloadTask")), 0);
            com.ss.android.socialbase.downloader.bl.ok.n(ok, String.format("add download task error:%s", th));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(DownloadTask downloadTask, int i2, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i2);
        }
        if (downloadInfo == null || !z) {
            return;
        }
        downloadInfo.setSavePathRedirected(z);
    }

    private List<com.ss.android.socialbase.downloader.model.bl> ok(List<com.ss.android.socialbase.downloader.model.bl> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.bl blVar : list) {
                if (blVar != null && !TextUtils.isEmpty(blVar.ok()) && !TextUtils.isEmpty(blVar.a())) {
                    if (blVar.ok().equals(HttpHeaders.USER_AGENT)) {
                        z = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.model.bl(blVar.ok(), blVar.a()));
                }
            }
        }
        if (!z) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.bl(HttpHeaders.USER_AGENT, com.ss.android.socialbase.appdownloader.a.ok.ok));
        }
        return arrayList;
    }

    public String ok(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || bl.bl(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    private ep ok(final com.ss.android.socialbase.appdownloader.bl.n nVar) {
        if (nVar == null) {
            return null;
        }
        return new ep() { // from class: com.ss.android.socialbase.appdownloader.s.5
            @Override // com.ss.android.socialbase.downloader.depend.ep
            public void ok(int i2, DownloadInfo downloadInfo, String str, String str2) {
                if (i2 != 1 && i2 != 3) {
                    switch (i2) {
                        case 8:
                            nVar.ok(i2, downloadInfo.getPackageName(), str, str2);
                            break;
                        case 9:
                            nVar.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), str);
                            break;
                        case 10:
                            nVar.ok(downloadInfo);
                            break;
                    }
                }
                nVar.ok(i2, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }

            @Override // com.ss.android.socialbase.downloader.depend.ep
            public boolean ok(boolean z) {
                return nVar.ok(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.ep
            public String ok() {
                return nVar.ok();
            }
        };
    }

    public DownloadInfo ok(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo downloadInfoOk = ok(context, str, p());
                if (downloadInfoOk == null) {
                    downloadInfoOk = ok(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                }
                if (downloadInfoOk == null) {
                    downloadInfoOk = ok(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (downloadInfoOk == null) {
                    downloadInfoOk = ok(context, str, context.getFilesDir());
                }
                return (downloadInfoOk == null && com.ss.android.socialbase.downloader.h.ok.bl().ok("get_download_info_by_list")) ? a(context, str) : downloadInfoOk;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.bl.ok.a(ok, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo ok(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    public List<DownloadInfo> ok(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public void ok(com.ss.android.socialbase.appdownloader.bl.h hVar) {
        this.t = hVar;
    }

    public void ok(com.ss.android.socialbase.downloader.downloader.td tdVar) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).setReserveWifiStatusListener(tdVar);
    }

    public void ok(fb fbVar) {
        this.zz = fbVar;
    }

    public void ok(fl flVar) {
        this.u = flVar;
    }
}

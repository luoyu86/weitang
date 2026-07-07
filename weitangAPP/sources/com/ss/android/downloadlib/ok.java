package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.qq.e.comm.constants.ErrorCode;
import com.ss.android.downloadlib.addownload.a.q;
import com.ss.android.downloadlib.addownload.a.s;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.appdownloader.a;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.fl;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ok.ok;
import com.taobao.accs.messenger.MessengerService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ok implements com.ss.android.downloadad.api.ok, a.bl, fl, ok.InterfaceC0174ok {
    private static String ok = "ok";
    private static volatile ok s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9884a;
    private a bl;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9889a;
        private long bl;
        private long n;
        private long ok;
        private int s;

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.n = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (ok()) {
                    ok.ok().ok(this.ok, this.f9889a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private a(long j, int i2, long j2, int i3) {
            this.ok = j;
            this.f9889a = i2;
            this.bl = j2;
            this.s = i3;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(21:12|(1:19)(20:16|(0)|21|52|22|23|54|24|(1:26)|27|(1:29)(1:30)|31|(1:34)|35|(1:37)(1:38)|39|(1:41)|42|49|50)|20|21|52|22|23|54|24|(0)|27|(0)(0)|31|(1:34)|35|(0)(0)|39|(0)|42|49|50) */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00ee, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00f0, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00f1, code lost:
        
            r3 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00f3, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ad A[Catch: Exception -> 0x00ee, TryCatch #1 {Exception -> 0x00ee, blocks: (B:24:0x008c, B:26:0x00ad, B:31:0x00bf, B:34:0x00cc, B:39:0x00da, B:42:0x00ea), top: B:54:0x008c }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00e9  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean ok() {
            /*
                Method dump skipped, instruction units count: 257
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.ok.a.ok():boolean");
        }

        private int ok(boolean z, com.ss.android.downloadad.api.ok.a aVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.h.ok okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
            int i2 = 1;
            if (okVarOk.ok("install_failed_check_ttmd5", 1) == 1) {
                int iCheckMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", iCheckMd5Status);
                } catch (Throwable unused) {
                }
                if (!com.ss.android.socialbase.downloader.q.kf.ok(iCheckMd5Status)) {
                    return 2005;
                }
            }
            int i3 = this.s;
            if (i3 != 2000) {
                return i3;
            }
            if (okVarOk.ok("install_failed_check_signature", 1) == 1 && j.n(r.getContext(), aVar.n())) {
                if (!j.ok(j.q(r.getContext(), downloadInfo.getTargetFilePath()), j.p(r.getContext(), aVar.n()))) {
                    return 2006;
                }
            }
            if (!z) {
                return ErrorCode.INNER_ERROR;
            }
            long j = this.n;
            long j2 = this.bl;
            if (j <= j2) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j - j2);
                if (aVar.er() <= this.bl) {
                    i2 = 0;
                }
                jSONObject.put("install_again", i2);
            } catch (Throwable unused2) {
            }
            if (z2) {
                return 2004;
            }
            return ErrorCode.NOT_INIT;
        }
    }

    public class bl implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.ss.android.downloadad.api.ok.a f9890a;

        public bl(com.ss.android.downloadad.api.ok.a aVar) {
            this.f9890a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.f9890a.k(true);
                    ok.this.bl(this.f9890a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.f9890a.k(false);
            }
        }
    }

    /* JADX INFO: renamed from: com.ss.android.downloadlib.ok$ok, reason: collision with other inner class name */
    @WorkerThread
    public class RunnableC0137ok implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9891a;

        public RunnableC0137ok(int i2) {
            this.f9891a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.a.kf.ok().a();
                ConcurrentHashMap<Long, com.ss.android.downloadad.api.ok.a> concurrentHashMapBl = com.ss.android.downloadlib.addownload.a.kf.ok().bl();
                if (concurrentHashMapBl == null || concurrentHashMapBl.isEmpty()) {
                    return;
                }
                ok.this.ok(concurrentHashMapBl, this.f9891a);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private ok() {
        com.ss.android.socialbase.appdownloader.a.ok(this);
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(this);
    }

    public static JSONObject a(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long jA = j.a(0L);
            double d2 = jA;
            jSONObject.put("available_space", d2 / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d3 = totalBytes;
            jSONObject.put("apk_size", d3 / 1048576.0d);
            if (jA > 0 && totalBytes > 0) {
                jSONObject.put("available_space_ratio", d2 / d3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void bl(com.ss.android.downloadad.api.ok.a aVar) {
        SystemClock.sleep(20000L);
        int i2 = 15;
        while (i2 > 0) {
            if (j.a(aVar)) {
                ok(aVar.n());
                return;
            }
            i2--;
            if (i2 == 0) {
                return;
            } else {
                SystemClock.sleep(20000L);
            }
        }
    }

    public synchronized void s() {
        a aVar = this.bl;
        if (aVar != null) {
            aVar.a();
            this.bl = null;
        }
    }

    public static ok ok() {
        if (s == null) {
            synchronized (ok.class) {
                if (s == null) {
                    s = new ok();
                }
            }
        }
        return s;
    }

    public static String bl(@NonNull DownloadInfo downloadInfo, @NonNull com.ss.android.downloadad.api.ok.a aVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = r.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.bl.ok());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.getPackageName())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", downloadInfo.getPackageName());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            com.ss.android.downloadlib.s.ok.ok().ok("embeded_ad", "package_name_error", jSONObject, aVar);
            return str;
        }
        return downloadInfo.getPackageName();
    }

    private int s(com.ss.android.downloadad.api.ok.a aVar) {
        int realStatus;
        double dOk = com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("download_failed_finally_hours", 48.0d);
        if (dOk <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - aVar.e() < dOk * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (aVar.s.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(aVar.zz());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && aVar.s.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                ok(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(aVar.g()));
                jSONObject.putOpt("fail_msg", aVar.v());
                jSONObject.put("download_failed_times", aVar.y());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put("is_update_download", aVar.cs() ? 1 : 2);
                com.ss.android.downloadlib.s.ok.ok().ok(aVar.k(), "download_failed_finally", jSONObject, aVar);
                q.ok().ok(aVar);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    @WorkerThread
    public static synchronized void ok(DownloadInfo downloadInfo, com.ss.android.downloadad.api.ok.a aVar) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("onDownloadFinish info null");
            return;
        }
        if (aVar == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("onDownloadFinish nativeModel null");
            return;
        }
        if (aVar.fl() != 1) {
            return;
        }
        com.ss.android.downloadlib.bl.p.ok().s(aVar);
        String strBl = bl(downloadInfo, aVar);
        com.ss.android.downloadlib.addownload.a.kf.ok().a(downloadInfo.getUrl(), strBl);
        Map<Long, com.ss.android.downloadad.api.ok.a> mapOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo.getUrl(), strBl);
        aVar.kf(System.currentTimeMillis());
        aVar.n(2);
        aVar.a(strBl);
        mapOk.put(Long.valueOf(aVar.a()), aVar);
        q.ok().ok(mapOk.values());
        a(aVar);
        h.ok().ok(downloadInfo, strBl);
        if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
            ok().ok(aVar);
            ok().a(downloadInfo, aVar);
            if (aVar.qu()) {
                com.ss.android.downloadlib.addownload.ok.ok.ok().ok(downloadInfo.getId(), aVar.a(), aVar.j(), strBl, downloadInfo.getTitle(), aVar.s(), downloadInfo.getTargetFilePath());
            }
            com.ss.android.downloadlib.addownload.n.ok.ok(downloadInfo, aVar.a(), aVar.s(), strBl);
        }
    }

    public void a(DownloadInfo downloadInfo, final com.ss.android.downloadad.api.ok.a aVar) {
        if (downloadInfo == null || aVar == null || com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        s.ok().a(new Runnable() { // from class: com.ss.android.downloadlib.ok.3
            @Override // java.lang.Runnable
            public void run() {
                String strOk = com.ss.android.downloadlib.h.ok.ok(targetFilePath);
                if (TextUtils.isEmpty(strOk)) {
                    return;
                }
                r.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(aVar.a()), strOk).apply();
            }
        });
    }

    private static void a(com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar == null) {
            return;
        }
        String strWv = TextUtils.isEmpty(aVar.wv()) ? "" : aVar.wv();
        DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(aVar.zz());
        aVar.j("");
        q.ok().ok(aVar);
        JSONObject jSONObjectOk = ok(new JSONObject(), downloadInfo);
        int i2 = 1;
        try {
            jSONObjectOk.putOpt("finish_reason", strWv);
            jSONObjectOk.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadad.api.ok.a aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
        com.ss.android.downloadlib.h.kf.ok(jSONObjectOk, downloadInfo.getId());
        try {
            jSONObjectOk.put("download_failed_times", aVarOk.y());
            jSONObjectOk.put("can_show_notification", com.ss.android.socialbase.appdownloader.n.s.ok() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                jSONObjectOk.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            jSONObjectOk.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            jSONObjectOk.put("has_send_download_failed_finally", aVarOk.s.get() ? 1 : 2);
            if (!aVarOk.cs()) {
                i2 = 2;
            }
            jSONObjectOk.put("is_update_download", i2);
            com.ss.android.downloadlib.h.kf.ok(aVarOk, jSONObjectOk);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().a("download_finish", jSONObjectOk, aVar);
    }

    @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC0174ok
    public void bl() {
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "onAppBackground()");
        ok(6);
    }

    @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC0174ok
    public void a() {
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "onAppForeground()");
        s();
        ok(5);
    }

    @WorkerThread
    public synchronized void ok(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!j.a()) {
            final com.ss.android.downloadad.api.ok.a aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(str);
            if (aVarOk == null) {
                com.ss.android.downloadlib.addownload.a.s.ok().ok(str);
                return;
            }
            com.ss.android.downloadlib.addownload.n nVarOk = h.ok().ok(aVarOk.ok());
            if (nVarOk != null) {
                nVarOk.kf();
            }
            if (aVarOk.bl.get()) {
                return;
            }
            if (com.ss.android.socialbase.downloader.h.ok.ok(aVarOk.zz()).a("notification_opt_2") == 1) {
                com.ss.android.socialbase.downloader.notification.a.ok().kf(aVarOk.zz());
            }
            new com.ss.android.downloadlib.a.a().ok(aVarOk, new com.ss.android.downloadlib.a.h() { // from class: com.ss.android.downloadlib.ok.1
                @Override // com.ss.android.downloadlib.a.h
                public void ok(boolean z) {
                    com.ss.android.socialbase.downloader.bl.ok.a(ok.ok, "appBackForeground->" + z);
                    if (!z) {
                        if (com.ss.android.downloadlib.a.ok.ok(str, aVarOk) || aVarOk.sg() != 4) {
                            return;
                        }
                        com.ss.android.downloadlib.addownload.ok.ok.ok().ok(aVarOk);
                        return;
                    }
                    if (!(com.ss.android.downloadlib.a.kf.bl(aVarOk) ? com.ss.android.downloadlib.a.ok.ok(str, aVarOk) : false) && com.ss.android.downloadlib.a.kf.s(aVarOk) && aVarOk.sg() == 4) {
                        com.ss.android.downloadlib.addownload.ok.ok.ok().ok(aVarOk);
                    }
                }
            }, com.ss.android.downloadlib.h.n.ok(aVarOk).ok("try_applink_delay_after_installed", 0));
            com.ss.android.downloadlib.bl.p.ok().kf(aVarOk);
            ok(str, aVarOk);
            com.ss.android.downloadlib.addownload.ok.ok.ok().a(str);
            DownloadInfo downloadInfoOk = ok((List<DownloadInfo>) Downloader.getInstance(r.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive"), str);
            if (downloadInfoOk != null) {
                if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfoOk.getId()).a("no_hide_notification") != 1) {
                    com.ss.android.socialbase.downloader.notification.a.ok().ok(downloadInfoOk.getId());
                }
                h.ok().a(downloadInfoOk, str);
                com.ss.android.downloadlib.addownload.bl.s.ok(downloadInfoOk);
            } else {
                h.ok().a(null, str);
            }
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    private JSONObject a(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.ok okVar) {
        com.ss.android.downloadad.api.ok.a aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
        if (aVarOk == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        okVar.ok(jSONObject);
        try {
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.h.kf.ok(jSONObject, downloadInfo.getId());
        com.ss.android.downloadlib.s.ok.ok().ok("embeded_ad", "ah_result", jSONObject, aVarOk);
        return jSONObject;
    }

    public void ok(DownloadInfo downloadInfo, com.ss.android.downloadad.api.ok.a aVar, int i2) {
        long jMax;
        if (downloadInfo == null || aVar == null) {
            return;
        }
        s();
        long jCurrentTimeMillis = System.currentTimeMillis();
        aVar.a(jCurrentTimeMillis);
        aVar.h(j.ok(Environment.getDataDirectory(), -1L));
        if (i2 != 2000) {
            jMax = 2000;
        } else {
            long jOk = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("check_install_failed_delay_time", 120000L);
            if (jOk < 0) {
                return;
            } else {
                jMax = Math.max(jOk, 30000L);
            }
        }
        long j = jMax;
        a aVar2 = new a(aVar.a(), downloadInfo.getId(), jCurrentTimeMillis, i2);
        s.ok().ok(aVar2, j);
        this.bl = aVar2;
        q.ok().ok(aVar);
    }

    public void ok(final long j, int i2) {
        long jOk = com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("check_install_finish_hijack_delay_time", 900000L);
        if (jOk < 0) {
            return;
        }
        s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.ok.2
            @Override // java.lang.Runnable
            public void run() {
                ok.ok().ok(j);
            }
        }, Math.max(jOk, 300000L));
    }

    public void ok(long j) {
        s.ok okVarOk;
        int iIntValue;
        try {
            com.ss.android.downloadad.api.ok.a aVarS = com.ss.android.downloadlib.addownload.a.kf.ok().s(j);
            if (aVarS != null && !j.a(aVarS) && !aVarS.bl.get()) {
                Pair<s.ok, Integer> pairA = com.ss.android.downloadlib.addownload.a.s.ok().a(aVarS);
                if (pairA != null) {
                    okVarOk = (s.ok) pairA.first;
                    iIntValue = ((Integer) pairA.second).intValue();
                } else {
                    okVarOk = com.ss.android.downloadlib.addownload.a.s.ok().ok(aVarS);
                    iIntValue = -1;
                }
                if (okVarOk == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.a.s.ok().a(okVarOk.ok);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", okVarOk.s);
                jSONObject.put("installed_pkg_name", okVarOk.ok);
                if (iIntValue != -1) {
                    jSONObject.put("error_code", iIntValue);
                    com.ss.android.downloadlib.h.kf.ok(jSONObject, aVarS.zz());
                    com.ss.android.downloadlib.s.ok.ok().a("install_finish_hijack", jSONObject, aVarS);
                    return;
                }
                com.ss.android.downloadlib.s.ok.ok().a("install_finish_may_hijack", jSONObject, aVarS);
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.n.bl.ok().ok(th, "trySendInstallFinishHijack");
        }
    }

    public void ok(String str, com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar != null && j.a(aVar) && aVar.bl.compareAndSet(false, true)) {
            com.ss.android.downloadlib.s.ok.ok().ok(aVar.k(), "install_finish", ok(aVar, str, aVar.sg() != 4 ? 3 : 4), aVar);
            q.ok().ok(aVar);
        }
    }

    private static DownloadInfo ok(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (j.ok(r.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject ok(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i2 = 1;
            if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.put("current_network_quality", com.ss.android.socialbase.downloader.network.r.ok().a().name());
                jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put("retry_count", downloadInfo.getRetryCount());
                jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put("total_retry_count", downloadInfo.getTotalRetryCount());
                jSONObject.put("cur_retry_time_in_total", downloadInfo.getCurRetryTimeInTotal());
                jSONObject.put("real_download_time", downloadInfo.getRealDownloadTime());
                jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                jSONObject.put("chunk_downgrade_retry_used", downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                jSONObject.put("need_chunk_downgrade_retry", downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                jSONObject.put("preconnect_level", downloadInfo.getPreconnectLevel());
                jSONObject.put(TTDownloadField.TT_MD5, downloadInfo.getMd5());
                jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                double curBytes = downloadInfo.getCurBytes() / 1048576.0d;
                double realDownloadTime = downloadInfo.getRealDownloadTime() / 1000.0d;
                if (curBytes > 0.0d && realDownloadTime > 0.0d) {
                    double d2 = curBytes / realDownloadTime;
                    try {
                        jSONObject.put("download_speed", d2);
                    } catch (Exception unused) {
                    }
                    com.ss.android.socialbase.downloader.bl.ok.a(ok, "download speed : " + d2 + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", Downloader.getInstance(r.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                    jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.bl.s.ok().a(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!com.ss.android.socialbase.downloader.q.kf.bl(r.getContext())) {
                    i2 = 2;
                }
                jSONObject.put("network_available", i2);
                jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                a(jSONObject, downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    private int ok(com.ss.android.downloadad.api.ok.a aVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int iA = com.ss.android.socialbase.appdownloader.bl.a(r.getContext(), downloadInfo);
        int iA2 = j.a(r.getContext(), str);
        if (iA > 0 && iA2 > 0 && iA != iA2) {
            return iA2 > iA ? 3011 : 3010;
        }
        if (com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("install_finish_check_ttmd5", 1) != 1) {
            return ErrorCode.NETWORK_ERROR;
        }
        String string = r.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(aVar.a()), null);
        if (TextUtils.isEmpty(string) && downloadInfo != null) {
            string = com.ss.android.downloadlib.h.ok.ok(downloadInfo.getTargetFilePath());
        }
        int iOk = com.ss.android.downloadlib.h.ok.ok(string, com.ss.android.downloadlib.h.ok.a(str));
        try {
            jSONObject.put("ttmd5_status", iOk);
        } catch (Throwable unused) {
        }
        if (iOk == 0) {
            return 3000;
        }
        if (iOk == 1) {
            return 3002;
        }
        return ErrorCode.NETWORK_ERROR;
    }

    @Override // com.ss.android.downloadad.api.ok
    public void ok(int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f9884a < 120000) {
            return;
        }
        s.ok().ok(new RunnableC0137ok(i2), this.f9884a > 0 ? 2000L : 8000L);
        this.f9884a = jCurrentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void ok(@NonNull ConcurrentHashMap<Long, com.ss.android.downloadad.api.ok.a> concurrentHashMap, int i2) {
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.api.ok.a aVar : concurrentHashMap.values()) {
            if (aVar.bl.get()) {
                if (jCurrentTimeMillis - aVar.e() >= com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(aVar.a()));
                }
            } else if (aVar.fl() == 1) {
                if (s(aVar) <= 0 && jCurrentTimeMillis - aVar.e() >= com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(aVar.a()));
                }
            } else if (aVar.fl() == 2) {
                if (!aVar.dx()) {
                    if (j.a(aVar)) {
                        if (aVar.sg() == 4) {
                            i2 = aVar.sg();
                        }
                        com.ss.android.downloadlib.s.ok.ok().ok(ok(aVar, aVar.n(), i2), aVar);
                        arrayList.add(Long.valueOf(aVar.a()));
                        com.ss.android.downloadlib.addownload.bl.s.ok(aVar);
                    } else if (jCurrentTimeMillis - aVar.e() >= com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(aVar.a()));
                    } else if (TextUtils.isEmpty(aVar.n())) {
                        arrayList.add(Long.valueOf(aVar.a()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(aVar.a()));
            }
        }
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.bl
    public void ok(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.ok okVar) {
        JSONObject jSONObjectA;
        if (downloadInfo == null || okVar == null) {
            return;
        }
        JSONArray jSONArrayN = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).n("ah_report_config");
        if (okVar.f9949a != 0) {
            downloadInfo.getTempCacheData().remove(MessengerService.INTENT);
        }
        if (jSONArrayN == null || (jSONObjectA = a(downloadInfo, okVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", jSONObjectA);
    }

    @Override // com.ss.android.socialbase.downloader.depend.fl
    public void ok(@Nullable final DownloadInfo downloadInfo, @Nullable String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("info is null");
        } else if ((com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo).a("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.ss.android.downloadlib.a.n.ok().a(new com.ss.android.downloadlib.a.s() { // from class: com.ss.android.downloadlib.ok.4
                @Override // com.ss.android.downloadlib.a.s
                public void ok(boolean z) {
                    if (!z) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get(MessengerService.INTENT);
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove(MessengerService.INTENT);
                            com.ss.android.socialbase.appdownloader.bl.ok(r.getContext(), intent);
                            j.ok(jSONObject, "backup", (Object) 1);
                        } else {
                            j.ok(jSONObject, "backup", (Object) 2);
                        }
                    }
                    com.ss.android.downloadad.api.ok.a aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
                    if (aVarOk != null) {
                        com.ss.android.downloadlib.s.ok.ok().ok(z ? "installer_delay_success" : "installer_delay_failed", jSONObject, aVarOk);
                    } else {
                        com.ss.android.downloadlib.n.bl.ok().a("ah nativeModel=null");
                    }
                    if (z) {
                        r.io().ok(r.getContext(), null, null, null, null, 1);
                    }
                }
            });
        }
    }

    public void ok(com.ss.android.downloadad.api.ok.a aVar) {
        s.ok().ok(new bl(aVar));
    }

    private JSONObject ok(com.ss.android.downloadad.api.ok.a aVar, String str, int i2) {
        com.ss.android.socialbase.appdownloader.ok okVarOk;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(aVar.zz());
            jSONObject.putOpt("scene", Integer.valueOf(i2));
            com.ss.android.downloadlib.h.kf.ok(jSONObject, aVar.zz());
            com.ss.android.downloadlib.h.kf.ok(aVar, jSONObject);
            jSONObject.put("is_update_download", aVar.cs() ? 1 : 2);
            jSONObject.put("install_after_back_app", aVar.ry() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", aVar.yt() ? "1" : "2");
            if (downloadInfo != null) {
                ok(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (aVar.er() > 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - aVar.er();
                        jSONObject.put("install_time", jCurrentTimeMillis);
                        if (jCurrentTimeMillis > com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String strOk = com.ss.android.socialbase.downloader.q.kf.ok(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(strOk) && (okVarOk = com.ss.android.socialbase.appdownloader.ok.ok(strOk)) != null) {
                    okVarOk.ok(jSONObject);
                }
            }
            int iOk = ok(aVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", iOk);
            if (iOk == 3000) {
                jSONObject.put("hijack", 2);
            } else if (iOk == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public void ok(DownloadInfo downloadInfo, long j, long j2, long j3, long j4, long j5, boolean z) {
        com.ss.android.downloadad.api.ok.a aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
        if (aVarOk == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j2 - j) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j4));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j3));
            jSONObject.putOpt("byte_required_after", Double.valueOf((j3 - j2) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j5));
            com.ss.android.downloadlib.h.kf.bl(downloadInfo, jSONObject);
            com.ss.android.downloadlib.s.ok.ok().ok("cleanup", jSONObject, aVarOk);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

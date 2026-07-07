package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.h.k;
import com.ss.android.downloadlib.h.z;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p implements z.ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9827a;
    private boolean bl = false;
    private a n;
    public com.ss.android.downloadlib.addownload.a.n ok;
    private n s;

    public interface a {
        void ok(DownloadInfo downloadInfo);
    }

    public static class ok extends com.ss.android.socialbase.downloader.depend.ok {
        private com.ss.android.downloadlib.h.z ok;

        public ok(com.ss.android.downloadlib.h.z zVar) {
            this.ok = zVar;
        }

        @Override // com.ss.android.socialbase.downloader.depend.ok, com.ss.android.socialbase.downloader.depend.zz
        public void ok(DownloadInfo downloadInfo) {
            ok(downloadInfo, 11);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            ok(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            ok(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            ok(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            ok(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            ok(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            ok(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            ok(downloadInfo, -3);
        }

        private void ok(DownloadInfo downloadInfo, int i2) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            messageObtain.obj = downloadInfo;
            messageObtain.arg1 = i2;
            this.ok.sendMessage(messageObtain);
        }
    }

    public p(n nVar) {
        this.s = nVar;
    }

    private boolean bl() {
        return s() && n();
    }

    private boolean kf() {
        return com.ss.android.downloadlib.h.j.ok(this.ok.f9775a) && q.ok(this.ok.s.getLinkMode());
    }

    private boolean n() {
        return this.ok.s.isAddToDownloadManage();
    }

    private boolean s() {
        DownloadModel downloadModel = this.ok.f9775a;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.ok.f9775a.getDownloadUrl())) ? false : true;
    }

    public void a(@Nullable DownloadInfo downloadInfo) {
        a aVar = this.n;
        if (aVar != null) {
            aVar.ok(downloadInfo);
            this.n = null;
        }
    }

    @Override // com.ss.android.downloadlib.h.z.ok
    public void ok(Message message) {
    }

    private boolean kf(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && com.ss.android.socialbase.downloader.q.kf.s(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    private boolean n(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.h.j.ok(this.ok.f9775a) && kf(downloadInfo);
    }

    public void bl(DownloadInfo downloadInfo) {
        if (!q.ok(this.ok.f9775a) || this.bl) {
            return;
        }
        com.ss.android.downloadlib.s.ok.ok().ok("file_status", (downloadInfo == null || !com.ss.android.downloadlib.h.j.a(downloadInfo.getTargetFilePath())) ? 2 : 1, this.ok);
        this.bl = true;
    }

    public void ok(long j) {
        this.f9827a = j;
        com.ss.android.downloadlib.addownload.a.n nVarN = com.ss.android.downloadlib.addownload.a.kf.ok().n(j);
        this.ok = nVarN;
        if (nVarN.y()) {
            com.ss.android.downloadlib.n.bl.ok().ok("setAdId ModelBox notValid");
        }
    }

    private void a(final u uVar) {
        if (com.ss.android.downloadlib.h.k.a("android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (uVar != null) {
                uVar.ok();
                return;
            }
            return;
        }
        String str = "android.permission.READ_MEDIA_IMAGES";
        if (!com.ss.android.downloadlib.h.j.ok()) {
            str = "android.permission.READ_EXTERNAL_STORAGE";
        } else if (com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_VIDEO")) {
            if (uVar != null) {
                uVar.ok();
                return;
            }
            return;
        }
        com.ss.android.downloadlib.h.k.ok(new String[]{str}, new k.ok() { // from class: com.ss.android.downloadlib.addownload.p.2
            @Override // com.ss.android.downloadlib.h.k.ok
            public void ok() {
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.ok();
                }
            }

            @Override // com.ss.android.downloadlib.h.k.ok
            public void ok(String str2) {
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.ok(str2);
                }
            }
        });
    }

    public boolean s(DownloadInfo downloadInfo) {
        return kf() || n(downloadInfo);
    }

    public void ok(DownloadInfo downloadInfo) {
        this.bl = false;
        a(downloadInfo);
    }

    public boolean ok(Context context, int i2, boolean z) {
        if (com.ss.android.downloadlib.h.j.ok(this.ok.f9775a)) {
            com.ss.android.downloadad.api.ok.a aVarS = com.ss.android.downloadlib.addownload.a.kf.ok().s(this.ok.ok);
            if (aVarS != null) {
                com.ss.android.socialbase.downloader.notification.a.ok().kf(aVarS.zz());
            }
            return com.ss.android.downloadlib.a.ok.ok(this.ok);
        }
        if (ok(i2) && !TextUtils.isEmpty(this.ok.f9775a.getPackageName()) && r.q().optInt("disable_market") != 1) {
            if (com.ss.android.downloadlib.a.ok.ok(this.ok, i2)) {
                return true;
            }
            return this.s.q() && this.s.s(true);
        }
        if (!z || this.ok.s.getDownloadMode() != 4 || this.s.n()) {
            return false;
        }
        this.s.bl(true);
        return true;
    }

    @Nullable
    public String a() {
        File externalFilesDir = r.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (externalFilesDir.exists()) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    @NonNull
    public static List<com.ss.android.download.api.download.ok> a(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.ok) {
                    arrayList.add((com.ss.android.download.api.download.ok) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ok) {
                            arrayList.add((com.ss.android.download.api.download.ok) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.download.api.download.ok) {
                            arrayList.add((com.ss.android.download.api.download.ok) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean ok(int i2) {
        if (this.ok.s.getDownloadMode() == 2 && i2 == 2) {
            return true;
        }
        return this.ok.s.getDownloadMode() == 2 && i2 == 1 && r.q().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean ok(int i2, DownloadModel downloadModel) {
        return com.ss.android.socialbase.appdownloader.kf.n.bl() && ok(i2) && !com.ss.android.downloadlib.h.j.ok(downloadModel);
    }

    public boolean ok(boolean z) {
        return !z && this.ok.s.getDownloadMode() == 1;
    }

    public void ok(@NonNull final u uVar) {
        if (!TextUtils.isEmpty(this.ok.f9775a.getFilePath())) {
            String filePath = this.ok.f9775a.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                uVar.ok();
                return;
            } else {
                try {
                    if (filePath.startsWith(r.getContext().getExternalCacheDir().getParent())) {
                        uVar.ok();
                        return;
                    }
                } catch (Exception unused) {
                }
            }
        }
        a(new u() { // from class: com.ss.android.downloadlib.addownload.p.1
            @Override // com.ss.android.download.api.config.u
            public void ok() {
                uVar.ok();
            }

            @Override // com.ss.android.download.api.config.u
            public void ok(String str) {
                r.bl().ok(1, r.getContext(), p.this.ok.f9775a, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.ss.android.downloadlib.s.ok.ok().a(p.this.f9827a, 1);
                uVar.ok(str);
            }
        });
    }

    public void ok(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        a aVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i2 = message.arg1;
        if (i2 != 1 && i2 != 6 && i2 == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.h hVarOk = com.ss.android.downloadlib.h.ok();
                com.ss.android.downloadlib.addownload.a.n nVar = this.ok;
                hVarOk.ok(nVar.f9775a, nVar.s, nVar.bl);
                downloadInfo.setFirstDownload(false);
            }
            com.ss.android.downloadlib.s.ok.ok().ok(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        k.ok(downloadShortInfo);
        int iOk = com.ss.android.socialbase.appdownloader.bl.ok(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_click_start")) && (aVar = this.n) != null) {
            aVar.ok(downloadInfo);
            this.n = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : ok(map)) {
            if (iOk != 1) {
                if (iOk == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, k.ok(downloadInfo.getId(), curBytes));
                } else if (iOk == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.h.j.ok(this.ok.f9775a)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, k.ok(downloadInfo.getId(), curBytes));
            } else {
                Iterator<com.ss.android.download.api.download.ok> it = a(map).iterator();
                while (it.hasNext()) {
                    it.next().ok(downloadInfo);
                }
            }
        }
    }

    public void ok() {
        if (this.n == null) {
            this.n = new a() { // from class: com.ss.android.downloadlib.addownload.p.3
                @Override // com.ss.android.downloadlib.addownload.p.a
                public void ok(DownloadInfo downloadInfo) {
                    com.ss.android.downloadlib.s.ok.ok().ok(p.this.f9827a, 2, downloadInfo);
                }
            };
        }
    }

    public int ok(Context context, IDownloadListener iDownloadListener) {
        com.ss.android.socialbase.downloader.model.bl blVarOk;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.ok.f9775a.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (r.q().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.ok.f9775a.getLogExtra()) && (blVarOk = ok(this.ok.f9775a.getLogExtra())) != null) {
            arrayList.add(blVarOk);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.bl(entry.getKey(), entry.getValue()));
                }
            }
        }
        String strOk = com.ss.android.downloadlib.h.s.ok(String.valueOf(this.ok.f9775a.getId()), this.ok.f9775a.getNotificationJumpUrl(), this.ok.f9775a.isShowToast(), String.valueOf(this.ok.f9775a.getModelType()));
        com.ss.android.socialbase.downloader.h.ok okVarA = com.ss.android.downloadlib.h.n.a(this.ok.f9775a);
        JSONObject jSONObjectOk = com.ss.android.downloadlib.h.n.ok(this.ok.f9775a);
        if (!this.ok.s.enableAH()) {
            jSONObjectOk = com.ss.android.downloadlib.h.j.ok(jSONObjectOk);
            com.ss.android.downloadlib.h.j.ok(jSONObjectOk, "ah_plans", new JSONArray());
        }
        int executorGroup = this.ok.f9775a.getExecutorGroup();
        if (this.ok.f9775a.isAd() || q.a(this.ok.f9775a)) {
            executorGroup = 4;
        }
        String strOk2 = ok(okVarA);
        DownloadInfo downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(com.ss.android.socialbase.downloader.downloader.bl.ok(this.ok.f9775a.getDownloadUrl(), strOk2));
        if (downloadInfo != null && 3 == this.ok.f9775a.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.kf kfVarT = new com.ss.android.socialbase.appdownloader.kf(context, this.ok.f9775a.getDownloadUrl()).a(this.ok.f9775a.getBackupUrls()).ok(this.ok.f9775a.getName()).n(strOk).ok(arrayList).ok(this.ok.f9775a.isShowNotification()).bl(this.ok.f9775a.isNeedWifi()).a(this.ok.f9775a.getFileName()).bl(strOk2).r(this.ok.f9775a.getAppIcon()).p(this.ok.f9775a.getMd5()).k(this.ok.f9775a.getSdkMonitorScene()).ok(this.ok.f9775a.getExpectFileLength()).ok(iDownloadListener).j(this.ok.f9775a.needIndependentProcess() || okVarA.ok("need_independent_process", 0) == 1).ok(this.ok.f9775a.getDownloadFileUriProvider()).a(this.ok.f9775a.autoInstallWithoutNotification()).h(this.ok.f9775a.getPackageName()).s(1000).n(100).ok(jSONObjectOk).q(true).k(true).a(okVarA.ok("retry_count", 5)).bl(okVarA.ok("backup_url_retry_count", 0)).k(true).z(okVarA.ok("need_head_connection", 0) == 1).s(okVarA.ok("need_https_to_http_retry", 0) == 1).p(okVarA.ok("need_chunk_downgrade_retry", 1) == 1).h(okVarA.ok("need_retry_delay", 0) == 1).q(okVarA.bl("retry_delay_time_array")).r(okVarA.ok("need_reuse_runnable", 0) == 1).kf(executorGroup).i(this.ok.f9775a.isAutoInstall()).t(this.ok.f9775a.distinctDir());
        if (!TextUtils.isEmpty(this.ok.f9775a.getMimeType())) {
            kfVarT.kf(this.ok.f9775a.getMimeType());
        } else {
            kfVarT.kf("application/vnd.android.package-archive");
        }
        if (okVarA.ok("notification_opt_2", 0) == 1) {
            kfVarT.ok(false);
            kfVarT.a(true);
        }
        com.ss.android.downloadlib.addownload.bl.ok okVar = null;
        if (okVarA.ok("clear_space_use_disk_handler", 0) == 1) {
            okVar = new com.ss.android.downloadlib.addownload.bl.ok();
            kfVarT.ok(okVar);
        }
        DownloadModel downloadModel = this.ok.f9775a;
        if ((downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(((AdDownloadModel) downloadModel).getTaskKey())) {
            kfVarT.s(((AdDownloadModel) this.ok.f9775a).getTaskKey());
        }
        int iOk = q.ok(this.ok, bl(), kfVarT);
        if (okVar != null) {
            okVar.ok(iOk);
        }
        return iOk;
    }

    private String ok(com.ss.android.socialbase.downloader.h.ok okVar) {
        boolean zA;
        if (!TextUtils.isEmpty(this.ok.f9775a.getFilePath())) {
            return this.ok.f9775a.getFilePath();
        }
        DownloadInfo downloadInfoOk = com.ss.android.socialbase.appdownloader.s.k().ok(r.getContext(), this.ok.f9775a.getDownloadUrl());
        if (!com.ss.android.downloadlib.h.j.ok()) {
            zA = com.ss.android.downloadlib.h.k.a("android.permission.WRITE_EXTERNAL_STORAGE");
        } else {
            zA = com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_VIDEO");
        }
        String strA = a();
        if (downloadInfoOk != null && !TextUtils.isEmpty(downloadInfoOk.getSavePath())) {
            String savePath = downloadInfoOk.getSavePath();
            if (zA || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(strA)) {
                    if (savePath.startsWith(strA)) {
                        return savePath;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).cancel(downloadInfoOk.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(zA ? 1 : 2));
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("label_external_permission", jSONObject, this.ok);
        String strA2 = null;
        try {
            strA2 = com.ss.android.socialbase.appdownloader.bl.a();
        } catch (Exception unused) {
        }
        int iOk = com.ss.android.downloadlib.h.n.ok(okVar);
        if (iOk != 0) {
            if (iOk != 4 && (zA || iOk != 2)) {
                if ((iOk == 3 || (!zA && iOk == 1)) && !TextUtils.isEmpty(strA)) {
                    return strA;
                }
            } else {
                File filesDir = r.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            }
        }
        return strA2;
    }

    public void ok(DownloadInfo downloadInfo, boolean z) {
        if (this.ok.f9775a == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status == -1 || status == -4 || q.ok(this.ok.f9775a)) {
            com.ss.android.downloadlib.s.ok.ok().ok(this.f9827a, 2);
        } else if (z && com.ss.android.downloadlib.s.bl.ok().bl() && (status == -2 || status == -3)) {
            com.ss.android.downloadlib.s.ok.ok().ok(this.f9827a, 2);
        }
        switch (status) {
            case -4:
            case -1:
                ok();
                com.ss.android.downloadlib.addownload.a.kf kfVarOk = com.ss.android.downloadlib.addownload.a.kf.ok();
                com.ss.android.downloadlib.addownload.a.n nVar = this.ok;
                kfVarOk.ok(new com.ss.android.downloadad.api.ok.a(nVar.f9775a, nVar.bl, nVar.s, downloadInfo.getId()));
                break;
            case -3:
                if (com.ss.android.downloadlib.h.j.ok(this.ok.f9775a)) {
                    com.ss.android.downloadlib.n.bl.ok().a("SUCCESSED isInstalledApp");
                    break;
                } else {
                    com.ss.android.downloadlib.s.ok.ok().ok(this.f9827a, 5, downloadInfo);
                    if (z && com.ss.android.downloadlib.s.bl.ok().a() && !com.ss.android.downloadlib.s.bl.ok().a(this.f9827a, this.ok.f9775a.getLogExtra())) {
                        com.ss.android.downloadlib.s.ok.ok().ok(this.f9827a, 2);
                        break;
                    }
                }
                break;
            case -2:
                com.ss.android.downloadlib.s.ok.ok().ok(this.f9827a, 4, downloadInfo);
                if (z && com.ss.android.downloadlib.s.bl.ok().a() && !com.ss.android.downloadlib.s.bl.ok().a(this.f9827a, this.ok.f9775a.getLogExtra())) {
                    com.ss.android.downloadlib.s.ok.ok().ok(this.f9827a, 2);
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.ss.android.downloadlib.s.ok.ok().ok(this.f9827a, 3, downloadInfo);
                break;
        }
    }

    public void ok(DownloadInfo downloadInfo, DownloadShortInfo downloadShortInfo, List<DownloadStatusChangeListener> list) {
        if (list.isEmpty()) {
            return;
        }
        if (downloadInfo != null && downloadShortInfo != null) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            int curBytes = downloadInfo.getTotalBytes() > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / downloadInfo.getTotalBytes()) : 0;
            int i2 = curBytes >= 0 ? curBytes : 0;
            downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
            k.ok(downloadShortInfo);
            for (DownloadStatusChangeListener downloadStatusChangeListener : list) {
                switch (downloadInfo.getStatus()) {
                    case -4:
                    case 0:
                        if (com.ss.android.downloadlib.h.j.ok(this.ok.f9775a)) {
                            downloadShortInfo.status = -3;
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onIdle();
                        }
                        break;
                    case -3:
                        if (com.ss.android.downloadlib.h.j.ok(this.ok.f9775a)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                        break;
                    case -2:
                        downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, k.ok(downloadInfo.getId(), i2));
                        break;
                    case -1:
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                        downloadStatusChangeListener.onDownloadActive(downloadShortInfo, k.ok(downloadInfo.getId(), i2));
                        break;
                    case 11:
                        if (downloadStatusChangeListener instanceof com.ss.android.download.api.download.ok) {
                            ((com.ss.android.download.api.download.ok) downloadStatusChangeListener).ok(downloadInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadActive(downloadShortInfo, k.ok(downloadInfo.getId(), i2));
                        }
                        break;
                }
            }
            return;
        }
        Iterator<DownloadStatusChangeListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
    }

    @NonNull
    public static List<DownloadStatusChangeListener> ok(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private com.ss.android.socialbase.downloader.model.bl ok(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new com.ss.android.socialbase.downloader.model.bl("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e2) {
            r.u().ok(e2, "parseLogExtra Error");
            return null;
        }
    }
}

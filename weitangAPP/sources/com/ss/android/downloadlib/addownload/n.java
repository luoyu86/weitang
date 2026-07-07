package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.bl;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.p;
import com.ss.android.downloadlib.h.z;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n implements h, z.ok {
    private static final String ok = "n";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ss.android.downloadlib.h.z f9809a;
    private p bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DownloadShortInfo f9810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private DownloadEventConfig f9811i;
    private SoftReference<IDownloadButtonClickListener> io;
    private long j;
    private final IDownloadListener k;
    private final Map<Integer, Object> kf;
    private WeakReference<Context> n;
    private DownloadInfo p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private bl f9812q;
    private boolean r;
    private long rh;
    private s s;
    private DownloadModel t;
    private SoftReference<OnItemClickListener> td;
    private final boolean u;
    private DownloadController x;
    private String z;
    private boolean zz;

    public interface a {
        void ok(long j);
    }

    public interface ok {
        void ok();
    }

    public n() {
        com.ss.android.downloadlib.h.z zVar = new com.ss.android.downloadlib.h.z(Looper.getMainLooper(), this);
        this.f9809a = zVar;
        this.kf = new ConcurrentHashMap();
        this.k = new p.ok(zVar);
        this.rh = -1L;
        this.t = null;
        this.f9811i = null;
        this.x = null;
        this.bl = new p(this);
        this.s = new s(zVar);
        this.u = com.ss.android.socialbase.downloader.h.ok.bl().ok("ttdownloader_callback_twice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.n;
        return (weakReference == null || weakReference.get() == null) ? r.getContext() : this.n.get();
    }

    private void i() {
        bl blVar = this.f9812q;
        if (blVar != null && blVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.f9812q.cancel(true);
        }
        this.f9812q = new bl();
        if (TextUtils.isEmpty(this.z)) {
            com.ss.android.downloadlib.h.a.ok(this.f9812q, this.t.getDownloadUrl(), this.t.getPackageName());
        } else {
            com.ss.android.downloadlib.h.a.ok(this.f9812q, this.t.getDownloadUrl(), this.t.getPackageName(), this.z);
        }
    }

    @NonNull
    private DownloadEventConfig j() {
        DownloadEventConfig downloadEventConfig = this.f9811i;
        return downloadEventConfig == null ? new bl.ok().ok() : downloadEventConfig;
    }

    private void r() {
        SoftReference<OnItemClickListener> softReference = this.td;
        if (softReference == null || softReference.get() == null) {
            r.a().ok(getContext(), this.t, z(), j());
        } else {
            this.td.get().onItemClick(this.t, j(), z());
            this.td = null;
        }
    }

    private void rh() {
        String str = ok;
        com.ss.android.downloadlib.h.r.ok(str, "pICD", null);
        if (this.bl.s(this.p)) {
            com.ss.android.downloadlib.h.r.ok(str, "pICD BC", null);
            kf(false);
        } else {
            com.ss.android.downloadlib.h.r.ok(str, "pICD IC", null);
            r();
        }
    }

    private boolean t() {
        if (!com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_click_start")) {
            DownloadInfo downloadInfo = this.p;
            if (downloadInfo == null) {
                return true;
            }
            return !(downloadInfo.getStatus() == -3 || Downloader.getInstance(r.getContext()).canResume(this.p.getId())) || this.p.getStatus() == 0;
        }
        DownloadInfo downloadInfo2 = this.p;
        if (downloadInfo2 == null) {
            return true;
        }
        if ((downloadInfo2.getStatus() == -3 && this.p.getCurBytes() <= 0) || this.p.getStatus() == 0 || this.p.getStatus() == -4) {
            return true;
        }
        return com.ss.android.socialbase.downloader.q.kf.ok(this.p.getStatus(), this.p.getSavePath(), this.p.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo x() {
        if (this.f9810h == null) {
            this.f9810h = new DownloadShortInfo();
        }
        return this.f9810h;
    }

    @NonNull
    private DownloadController z() {
        if (this.x == null) {
            this.x = new com.ss.android.download.api.download.a();
        }
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final boolean z) {
        this.s.ok(new com.ss.android.downloadlib.addownload.a.n(this.rh, this.t, j(), z()));
        this.s.ok(0, 0L, 0L, new ok() { // from class: com.ss.android.downloadlib.addownload.n.9
            @Override // com.ss.android.downloadlib.addownload.n.ok
            public void ok() {
                if (n.this.s.ok()) {
                    return;
                }
                n.this.p(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z) {
        Iterator<DownloadStatusChangeListener> it = p.ok(this.kf).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.t, z());
        }
        int iOk = this.bl.ok(r.getContext(), this.k);
        String str = ok;
        com.ss.android.downloadlib.h.r.ok(str, "beginDown id:" + iOk, null);
        if (iOk == 0) {
            DownloadInfo downloadInfoOk = new DownloadInfo.ok(this.t.getDownloadUrl()).ok();
            downloadInfoOk.setStatus(-1);
            ok(downloadInfoOk);
            com.ss.android.downloadlib.s.ok.ok().ok(this.rh, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.n.bl.ok().a("beginDown");
        } else if (this.p != null && !com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_click_start")) {
            this.bl.ok(this.p, false);
        } else if (z) {
            this.bl.ok();
        }
        if (this.bl.ok(bl())) {
            com.ss.android.downloadlib.h.r.ok(str, "beginDown IC id:" + iOk, null);
            r();
        }
    }

    public boolean bl() {
        DownloadInfo downloadInfo = this.p;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    public void kf() {
        this.f9809a.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.n.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadStatusChangeListener> it = p.ok((Map<Integer, Object>) n.this.kf).iterator();
                while (it.hasNext()) {
                    it.next().onInstalled(n.this.x());
                }
            }
        });
    }

    public boolean n() {
        return r.q().optInt("quick_app_enable_switch", 0) == 0 && this.t.getQuickAppModel() != null && !TextUtils.isEmpty(this.t.getQuickAppModel().ok()) && com.ss.android.downloadlib.addownload.bl.ok(this.p) && com.ss.android.downloadlib.h.j.ok(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.t.getQuickAppModel().ok())));
    }

    public boolean q() {
        SoftReference<IDownloadButtonClickListener> softReference = this.io;
        if (softReference == null) {
            return false;
        }
        return q.ok(this.t, softReference.get());
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public long s() {
        return this.j;
    }

    private boolean bl(int i2) {
        if (!n()) {
            return false;
        }
        int i3 = -1;
        String strOk = this.t.getQuickAppModel().ok();
        if (i2 == 1) {
            i3 = 5;
        } else if (i2 == 2) {
            i3 = 4;
        }
        DownloadModel downloadModel = this.t;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        boolean zBl = com.ss.android.downloadlib.h.q.bl(r.getContext(), strOk);
        if (zBl) {
            com.ss.android.downloadlib.s.ok.ok().ok(this.rh, i2);
            Message messageObtain = Message.obtain();
            messageObtain.what = i3;
            messageObtain.obj = Long.valueOf(this.t.getId());
            com.ss.android.downloadlib.addownload.bl.ok().ok(this, i3, this.t);
        } else {
            com.ss.android.downloadlib.s.ok.ok().ok(this.rh, false, 0);
        }
        return zBl;
    }

    private void kf(final boolean z) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        String str = ok;
        com.ss.android.downloadlib.h.r.ok(str, "pBCD", null);
        if (t()) {
            com.ss.android.downloadlib.addownload.a.n nVarN = com.ss.android.downloadlib.addownload.a.kf.ok().n(this.rh);
            if (this.zz) {
                if (q()) {
                    if (s(false) && (downloadController2 = nVarN.s) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        ok(z, true);
                        return;
                    }
                    return;
                }
                ok(z, true);
                return;
            }
            if (this.t.isAd() && (downloadController = nVarN.s) != null && downloadController.enableShowComplianceDialog() && nVarN.f9775a != null && com.ss.android.downloadlib.addownload.compliance.a.ok().ok(nVarN.f9775a) && com.ss.android.downloadlib.addownload.compliance.a.ok().ok(nVarN)) {
                return;
            }
            ok(z, true);
            return;
        }
        com.ss.android.downloadlib.h.r.ok(str, "pBCD continue download, status:" + this.p.getStatus(), null);
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo != null && (downloadModel = this.t) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.p.getStatus();
        final int id = this.p.getId();
        final com.ss.android.downloadad.api.ok.a aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(this.p);
        if (status != -2 && status != -1) {
            if (z.ok(status)) {
                if (this.t.enablePause()) {
                    this.s.ok(true);
                    com.ss.android.downloadlib.bl.p.ok().a(com.ss.android.downloadlib.addownload.a.kf.ok().s(this.rh));
                    if (com.ss.android.downloadlib.h.n.ok(aVarOk).ok("cancel_pause_optimise_switch", 0) == 1) {
                        com.ss.android.downloadlib.addownload.s.s.ok().ok(aVarOk, status, new com.ss.android.downloadlib.addownload.s.p() { // from class: com.ss.android.downloadlib.addownload.n.6
                            @Override // com.ss.android.downloadlib.addownload.s.p
                            public void ok(com.ss.android.downloadad.api.ok.a aVar) {
                                if (n.this.p == null && com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_handle_pause")) {
                                    n.this.p = Downloader.getInstance(r.getContext()).getDownloadInfo(id);
                                }
                                n.this.bl.ok(n.this.p, z);
                                if (n.this.p != null && com.ss.android.socialbase.downloader.q.kf.a(r.getContext()) && n.this.p.isPauseReserveOnWifi()) {
                                    n.this.p.stopPauseReserveOnWifi();
                                    com.ss.android.downloadlib.s.ok.ok().ok("cancel_pause_reserve_wifi_cancel_on_wifi", aVarOk);
                                } else {
                                    n nVar = n.this;
                                    nVar.ok(id, status, nVar.p);
                                }
                            }
                        }, new com.ss.android.downloadlib.addownload.ok.bl() { // from class: com.ss.android.downloadlib.addownload.n.5
                            @Override // com.ss.android.downloadlib.addownload.ok.bl
                            public void delete() {
                                n.this.ok(true);
                            }
                        });
                        return;
                    } else {
                        com.ss.android.downloadlib.addownload.s.r.ok().ok(aVarOk, status, new com.ss.android.downloadlib.addownload.s.p() { // from class: com.ss.android.downloadlib.addownload.n.7
                            @Override // com.ss.android.downloadlib.addownload.s.p
                            public void ok(com.ss.android.downloadad.api.ok.a aVar) {
                                if (n.this.p == null && com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_handle_pause")) {
                                    n.this.p = Downloader.getInstance(r.getContext()).getDownloadInfo(id);
                                }
                                n.this.bl.ok(n.this.p, z);
                                if (n.this.p != null && com.ss.android.socialbase.downloader.q.kf.a(r.getContext()) && n.this.p.isPauseReserveOnWifi()) {
                                    n.this.p.stopPauseReserveOnWifi();
                                    com.ss.android.downloadlib.s.ok.ok().a("pause_reserve_wifi_cancel_on_wifi", aVarOk);
                                } else {
                                    n nVar = n.this;
                                    nVar.ok(id, status, nVar.p);
                                }
                            }
                        });
                        return;
                    }
                }
                return;
            }
            this.bl.ok(this.p, z);
            ok(id, status, this.p);
            return;
        }
        this.bl.ok(this.p, z);
        if (aVarOk != null) {
            aVarOk.p(System.currentTimeMillis());
            aVarOk.q(this.p.getCurBytes());
        }
        this.p.setDownloadFromReserveWifi(false);
        this.s.ok(new com.ss.android.downloadlib.addownload.a.n(this.rh, this.t, j(), z()));
        this.s.ok(id, this.p.getCurBytes(), this.p.getTotalBytes(), new ok() { // from class: com.ss.android.downloadlib.addownload.n.3
            @Override // com.ss.android.downloadlib.addownload.n.ok
            public void ok() {
                if (n.this.s.ok()) {
                    return;
                }
                n nVar = n.this;
                nVar.ok(id, status, nVar.p);
            }
        });
        if (status == -2 && com.ss.android.downloadlib.h.n.ok(aVarOk).ok("show_pause_continue_toast", 0) == 1) {
            com.ss.android.downloadlib.h.ok().a().postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.n.4
                @Override // java.lang.Runnable
                public void run() {
                    r.bl().ok(13, r.getContext(), n.this.t, "已恢复下载", null, 0);
                }
            }, 500L);
        }
    }

    public boolean s(boolean z) {
        SoftReference<IDownloadButtonClickListener> softReference = this.io;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z) {
                    this.io.get().handleComplianceDialog(true);
                } else {
                    this.io.get().handleMarketFailedComplianceDialog();
                }
                this.io = null;
                return true;
            } catch (Exception unused) {
                com.ss.android.downloadlib.n.bl.ok().a("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.ss.android.downloadlib.n.bl.ok().a("mDownloadButtonClickListener has recycled");
        return false;
    }

    public void h() {
        if (this.kf.size() == 0) {
            return;
        }
        Iterator<DownloadStatusChangeListener> it = p.ok(this.kf).iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
    public n a(Context context) {
        if (context != null) {
            this.n = new WeakReference<>(context);
        }
        r.a(context);
        return this;
    }

    private void n(boolean z) {
        if (com.ss.android.downloadlib.h.n.a(this.t).a("notification_opt_2") == 1 && this.p != null) {
            com.ss.android.socialbase.downloader.notification.a.ok().kf(this.p.getId());
        }
        kf(z);
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
    public n a(int i2, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (r.q().optInt("back_use_softref_listener") == 1) {
                this.kf.put(Integer.valueOf(i2), downloadStatusChangeListener);
            } else if (r.q().optInt("use_weakref_listener") == 1) {
                this.kf.put(Integer.valueOf(i2), new WeakReference(downloadStatusChangeListener));
            } else {
                this.kf.put(Integer.valueOf(i2), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public boolean a() {
        return this.r;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public void a(final int i2) {
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.bl.ok(this.rh);
        if (!com.ss.android.downloadlib.addownload.a.kf.ok().n(this.rh).m()) {
            com.ss.android.downloadlib.n.bl.ok().ok("handleDownload ModelBox !isStrictValid");
        }
        if (this.bl.ok(i2, this.t)) {
            com.ss.android.downloadlib.addownload.compliance.kf.ok().ok(this.bl.ok, new com.ss.android.downloadlib.addownload.compliance.p() { // from class: com.ss.android.downloadlib.addownload.n.1
                @Override // com.ss.android.downloadlib.addownload.compliance.p
                public void ok(String str) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_miui_new_market", 1);
                        jSONObject.putOpt("download_miui_market_deeplink", str);
                        if (com.ss.android.downloadlib.h.p.ok(n.this.getContext(), n.this.bl.ok, str, jSONObject, true, i2)) {
                            jSONObject.putOpt("download_miui_jump_market_success", 1);
                            com.ss.android.downloadlib.addownload.compliance.kf.ok().ok(0, n.this.bl.ok, jSONObject);
                        } else {
                            jSONObject.putOpt("download_miui_jump_market_success", 0);
                            com.ss.android.downloadlib.addownload.compliance.kf.ok().ok(1, n.this.bl.ok, jSONObject);
                            int i3 = i2;
                            if (i3 == 1) {
                                com.ss.android.socialbase.downloader.bl.ok.ok(n.ok, "miui new rollback fail: handleDownload id:" + n.this.rh + ",tryPerformButtonClick:", null);
                                n.this.bl(true);
                            } else if (i3 == 2) {
                                com.ss.android.socialbase.downloader.bl.ok.ok(n.ok, "miui new rollback fail: handleDownload id:" + n.this.rh + ",tryPerformButtonClick:", null);
                                n.this.a(true);
                            }
                        }
                    } catch (Exception e2) {
                        com.ss.android.downloadlib.n.bl.ok().ok(e2, "generate miui new market param error");
                    }
                }

                @Override // com.ss.android.downloadlib.addownload.compliance.p
                public void ok() {
                    int i3 = i2;
                    if (i3 == 1) {
                        com.ss.android.socialbase.downloader.bl.ok.ok(n.ok, "miui new get miui deeplink fail: handleDownload id:" + n.this.rh + ",tryPerformButtonClick:", null);
                        n.this.bl(true);
                        return;
                    }
                    if (i3 != 2) {
                        return;
                    }
                    com.ss.android.socialbase.downloader.bl.ok.ok(n.ok, "miui new get miui deeplink fail: handleDownload id:" + n.this.rh + ",tryPerformButtonClick:", null);
                    n.this.a(true);
                }
            });
            return;
        }
        if (this.bl.ok(getContext(), i2, this.zz)) {
            return;
        }
        boolean zBl = bl(i2);
        if (i2 == 1) {
            if (zBl) {
                return;
            }
            com.ss.android.downloadlib.h.r.ok(ok, "handleDownload id:" + this.rh + ",pIC:", null);
            bl(true);
            return;
        }
        if (i2 == 2 && !zBl) {
            com.ss.android.downloadlib.h.r.ok(ok, "handleDownload id:" + this.rh + ",pBC:", null);
            a(true);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
    public n a(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.n.bl.ok().ok("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.ss.android.downloadlib.n.bl.ok().ok(false, "setDownloadModel id=0");
                if (com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadModel);
            this.rh = downloadModel.getId();
            this.t = downloadModel;
            if (q.ok(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.ok.a aVarS = com.ss.android.downloadlib.addownload.a.kf.ok().s(this.rh);
                if (aVarS != null && aVarS.j() != 3) {
                    aVarS.n(3L);
                    com.ss.android.downloadlib.addownload.a.q.ok().ok(aVarS);
                }
            }
        }
        return this;
    }

    public class bl extends AsyncTask<String, Void, DownloadInfo> {
        private bl() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length >= 1 && TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            String str = (strArr.length < 3 || TextUtils.isEmpty(strArr[2])) ? "" : strArr[2];
            String str2 = strArr[0];
            if (n.this.t != null && !TextUtils.isEmpty(n.this.t.getFilePath())) {
                downloadInfo = !TextUtils.isEmpty(str) ? Downloader.getInstance(r.getContext()).getDownloadInfo(Downloader.getInstance(r.getContext()).getDownloadId(str, n.this.t.getFilePath())) : Downloader.getInstance(r.getContext()).getDownloadInfo(str2, n.this.t.getFilePath());
            }
            return downloadInfo == null ? !TextUtils.isEmpty(str) ? com.ss.android.socialbase.appdownloader.s.k().ok(r.getContext(), str) : com.ss.android.socialbase.appdownloader.s.k().ok(r.getContext(), str2) : downloadInfo;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || n.this.t == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.a.bl blVarOk = com.ss.android.downloadlib.h.j.ok(n.this.t.getPackageName(), n.this.t.getVersionCode(), n.this.t.getVersionName());
                com.ss.android.downloadlib.addownload.a.p.ok().ok(n.this.t.getVersionCode(), blVarOk.a(), com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo));
                boolean zOk = blVarOk.ok();
                if (downloadInfo != null && downloadInfo.getId() != 0 && (zOk || !Downloader.getInstance(r.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    Downloader.getInstance(r.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (n.this.p == null || n.this.p.getStatus() != -4) {
                        n.this.p = downloadInfo;
                        if (n.this.u) {
                            Downloader.getInstance(r.getContext()).setMainThreadListener(n.this.p.getId(), n.this.k, false);
                        } else {
                            Downloader.getInstance(r.getContext()).setMainThreadListener(n.this.p.getId(), n.this.k);
                        }
                    } else {
                        n.this.p = null;
                    }
                    n.this.bl.ok(n.this.p, n.this.x(), p.ok((Map<Integer, Object>) n.this.kf));
                } else {
                    if (downloadInfo != null && Downloader.getInstance(r.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        com.ss.android.socialbase.downloader.notification.a.ok().kf(downloadInfo.getId());
                        n.this.p = null;
                    }
                    if (n.this.p != null) {
                        Downloader.getInstance(r.getContext()).removeTaskMainListener(n.this.p.getId());
                        if (n.this.u) {
                            Downloader.getInstance(n.this.getContext()).setMainThreadListener(n.this.p.getId(), n.this.k, false);
                        } else {
                            Downloader.getInstance(n.this.getContext()).setMainThreadListener(n.this.p.getId(), n.this.k);
                        }
                    }
                    if (!zOk) {
                        Iterator<DownloadStatusChangeListener> it = p.ok((Map<Integer, Object>) n.this.kf).iterator();
                        while (it.hasNext()) {
                            it.next().onIdle();
                        }
                        n.this.p = null;
                    } else {
                        n nVar = n.this;
                        nVar.p = new DownloadInfo.ok(nVar.t.getDownloadUrl()).ok();
                        n.this.p.setStatus(-3);
                        n.this.bl.ok(n.this.p, n.this.x(), p.ok((Map<Integer, Object>) n.this.kf));
                    }
                }
                n.this.bl.bl(n.this.p);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void bl(boolean z) {
        if (z) {
            com.ss.android.downloadlib.s.ok.ok().ok(this.rh, 1);
        }
        rh();
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public void p() {
        com.ss.android.downloadlib.addownload.a.kf.ok().kf(this.rh);
    }

    public void a(boolean z) {
        n(z);
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
    public n a(DownloadController downloadController) {
        JSONObject extra;
        this.x = downloadController;
        if (com.ss.android.downloadlib.h.n.a(this.t).a("force_auto_open") == 1) {
            z().setLinkMode(1);
        }
        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_show_dialog") && (extra = this.t.getExtra()) != null && extra.optInt("subprocess") > 0) {
            z().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(this.rh, z());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
    public n a(DownloadEventConfig downloadEventConfig) {
        this.f9811i = downloadEventConfig;
        this.zz = j().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(this.rh, j());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public h ok(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.td = null;
        } else {
            this.td = new SoftReference<>(onItemClickListener);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public void ok() {
        this.r = true;
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(this.rh, j());
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(this.rh, z());
        this.bl.ok(this.rh);
        i();
        if (r.q().optInt("enable_empty_listener", 1) == 1 && this.kf.get(Integer.MIN_VALUE) == null) {
            a(Integer.MIN_VALUE, new com.ss.android.download.api.config.ok());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public boolean ok(int i2) {
        if (i2 == 0) {
            this.kf.clear();
        } else {
            this.kf.remove(Integer.valueOf(i2));
        }
        if (this.kf.isEmpty()) {
            this.r = false;
            this.j = System.currentTimeMillis();
            if (this.p != null) {
                Downloader.getInstance(r.getContext()).removeTaskMainListener(this.p.getId());
            }
            bl blVar = this.f9812q;
            if (blVar != null && blVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.f9812q.cancel(true);
            }
            this.bl.ok(this.p);
            String str = ok;
            StringBuilder sb = new StringBuilder();
            sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.p;
            sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            com.ss.android.downloadlib.h.r.ok(str, sb.toString(), null);
            this.f9809a.removeCallbacksAndMessages(null);
            this.f9810h = null;
            this.p = null;
            return true;
        }
        if (this.kf.size() == 1 && this.kf.containsKey(Integer.MIN_VALUE)) {
            this.bl.a(this.p);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public void ok(boolean z) {
        if (this.p != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.bl.s sVarA = com.ss.android.socialbase.appdownloader.s.k().a();
                if (sVarA != null) {
                    sVarA.ok(this.p);
                }
                Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).cancel(this.p.getId(), true);
                return;
            }
            Intent intent = new Intent(r.getContext(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.p.getId());
            r.getContext().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public h ok(long j) {
        if (j != 0) {
            DownloadModel downloadModelOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(j);
            if (downloadModelOk != null) {
                this.t = downloadModelOk;
                this.rh = j;
                this.bl.ok(j);
            }
        } else {
            com.ss.android.downloadlib.n.bl.ok().ok(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.h.z.ok
    public void ok(Message message) {
        if (message != null && this.r && message.what == 3) {
            this.p = (DownloadInfo) message.obj;
            this.bl.ok(message, x(), this.kf);
        }
    }

    public void ok(boolean z, final boolean z2) {
        if (z) {
            com.ss.android.downloadlib.s.ok.ok().ok(this.rh, 2);
        }
        if (!com.ss.android.downloadlib.h.j.ok()) {
            if (!com.ss.android.downloadlib.h.k.a("android.permission.WRITE_EXTERNAL_STORAGE") && !z().enableNewActivity()) {
                this.t.setFilePath(this.bl.a());
            }
        } else if (!com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_IMAGES") && !com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_AUDIO") && !com.ss.android.downloadlib.h.k.a("android.permission.READ_MEDIA_VIDEO") && !z().enableNewActivity()) {
            this.t.setFilePath(this.bl.a());
        }
        if (com.ss.android.downloadlib.h.n.bl(this.t) == 0) {
            com.ss.android.downloadlib.h.r.ok(ok, "pBCD not start", null);
            this.bl.ok(new u() { // from class: com.ss.android.downloadlib.addownload.n.8
                @Override // com.ss.android.download.api.config.u
                public void ok() {
                    com.ss.android.downloadlib.h.r.ok(n.ok, "pBCD start download", null);
                    n.this.h(z2);
                }

                @Override // com.ss.android.download.api.config.u
                public void ok(String str) {
                    com.ss.android.downloadlib.h.r.ok(n.ok, "pBCD onDenied", null);
                }
            });
        } else {
            h(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i2, int i3, @NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_click_start")) {
            if (i3 != -3 && !com.ss.android.socialbase.downloader.downloader.s.ok().n(i2)) {
                ok(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.s.k().ok(r.getContext(), i2, i3);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.s.k().ok(r.getContext(), i2, i3);
    }

    private void ok(DownloadInfo downloadInfo) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.obj = downloadInfo;
        this.f9809a.sendMessage(messageObtain);
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public h ok(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.z = str;
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public h ok(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.io = null;
        } else {
            this.io = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }
}

package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.a;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.downloadlib.h.q;
import com.ss.android.downloadlib.n.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.ss.android.downloadad.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f9747a = null;
    private static String ok = "a";
    private p bl = p.ok(r.getContext());

    private a() {
    }

    public static DownloadEventConfig bl() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    public Dialog a(Context context, String str, boolean z, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, boolean z2, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (ok(downloadModel.getId())) {
            if (z2) {
                ok(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                a(downloadModel.getId());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        }
        this.bl.ok(context, i2, downloadStatusChangeListener, downloadModel);
        final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) j.ok(downloadEventConfig, bl());
        final DownloadController downloadController2 = (DownloadController) j.ok(downloadController, a());
        downloadEventConfig2.setDownloadScene(1);
        if ((downloadController2.enableShowComplianceDialog() && com.ss.android.downloadlib.addownload.compliance.a.ok().ok(downloadModel)) ? true : (r.q().optInt("disable_lp_dialog", 0) == 1) | z) {
            this.bl.ok(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
            return null;
        }
        com.ss.android.downloadlib.h.r.ok(ok, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
        Dialog dialogA = r.bl().a(new a.ok(context).ok(downloadModel.getName()).a("确认要下载此应用吗？").bl("确认").s("取消").ok(new a.InterfaceC0128a() { // from class: com.ss.android.downloadlib.a.2
            @Override // com.ss.android.download.api.model.a.InterfaceC0128a
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.s.ok.ok().ok("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.a.InterfaceC0128a
            public void bl(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.s.ok.ok().ok("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
            }

            @Override // com.ss.android.download.api.model.a.InterfaceC0128a
            public void ok(DialogInterface dialogInterface) {
                a.this.bl.ok(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                com.ss.android.downloadlib.s.ok.ok().ok("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }
        }).ok(0).ok());
        com.ss.android.downloadlib.s.ok.ok().ok("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
        return dialogA;
    }

    public static a ok() {
        if (f9747a == null) {
            synchronized (a.class) {
                if (f9747a == null) {
                    f9747a = new a();
                }
            }
        }
        return f9747a;
    }

    @Override // com.ss.android.downloadad.api.a
    public Dialog ok(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2) {
        return ok(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, false);
    }

    @Override // com.ss.android.downloadad.api.a
    public Dialog ok(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ok(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, false, iDownloadButtonClickListener);
    }

    public Dialog ok(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, boolean z2) {
        return ok(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, z2, null);
    }

    public Dialog ok(final Context context, final String str, final boolean z, @NonNull final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i2, final boolean z2, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) com.ss.android.downloadlib.n.a.ok(new a.ok<Dialog>() { // from class: com.ss.android.downloadlib.a.1
            @Override // com.ss.android.downloadlib.n.a.ok
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Dialog a() {
                return a.this.a(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, z2, iDownloadButtonClickListener);
            }
        });
    }

    @Override // com.ss.android.downloadad.api.a
    public boolean ok(Context context, long j, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i2) {
        com.ss.android.downloadad.api.ok.a aVarS = com.ss.android.downloadlib.addownload.a.kf.ok().s(j);
        if (aVarS != null) {
            this.bl.ok(context, i2, downloadStatusChangeListener, aVarS.d());
            return true;
        }
        DownloadModel downloadModelOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(j);
        if (downloadModelOk == null) {
            return false;
        }
        this.bl.ok(context, i2, downloadStatusChangeListener, downloadModelOk);
        return true;
    }

    @Override // com.ss.android.downloadad.api.a
    public boolean ok(long j, int i2) {
        DownloadModel downloadModelOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(j);
        if (downloadModelOk == null) {
            return false;
        }
        this.bl.ok(downloadModelOk.getDownloadUrl(), i2);
        return true;
    }

    public void ok(long j, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel downloadModelOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(j);
        com.ss.android.downloadad.api.ok.a aVarS = com.ss.android.downloadlib.addownload.a.kf.ok().s(j);
        if (downloadModelOk == null && aVarS != null) {
            downloadModelOk = aVarS.d();
        }
        if (downloadModelOk == null) {
            return;
        }
        if (downloadEventConfig != null && downloadController != null && !(downloadEventConfig instanceof com.ss.android.download.api.download.bl) && !(downloadController instanceof com.ss.android.download.api.download.a)) {
            downloadEventConfig.setDownloadScene(1);
            this.bl.ok(downloadModelOk.getDownloadUrl(), j, 2, downloadEventConfig, downloadController);
        } else {
            a(j);
        }
    }

    public void a(long j) {
        DownloadModel downloadModelOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(j);
        com.ss.android.downloadad.api.ok.a aVarS = com.ss.android.downloadlib.addownload.a.kf.ok().s(j);
        if (downloadModelOk == null && aVarS != null) {
            downloadModelOk = aVarS.d();
        }
        if (downloadModelOk == null) {
            return;
        }
        DownloadEventConfig downloadEventConfigA = com.ss.android.downloadlib.addownload.a.kf.ok().a(j);
        DownloadController downloadControllerBl = com.ss.android.downloadlib.addownload.a.kf.ok().bl(j);
        if (downloadEventConfigA instanceof com.ss.android.download.api.download.bl) {
            downloadEventConfigA = null;
        }
        if (downloadControllerBl instanceof com.ss.android.download.api.download.a) {
            downloadControllerBl = null;
        }
        if (aVarS == null) {
            if (downloadEventConfigA == null) {
                downloadEventConfigA = bl();
            }
            if (downloadControllerBl == null) {
                downloadControllerBl = a();
            }
        } else {
            if (downloadEventConfigA == null) {
                downloadEventConfigA = new AdDownloadEventConfig.Builder().setClickButtonTag(aVarS.k()).setRefer(aVarS.q()).setIsEnableV3Event(aVarS.z()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (downloadControllerBl == null) {
                downloadControllerBl = aVarS.c();
            }
        }
        DownloadEventConfig downloadEventConfig = downloadEventConfigA;
        downloadEventConfig.setDownloadScene(1);
        this.bl.ok(downloadModelOk.getDownloadUrl(), j, 2, downloadEventConfig, downloadControllerBl);
    }

    @Override // com.ss.android.downloadad.api.a
    public boolean ok(long j) {
        return (com.ss.android.downloadlib.addownload.a.kf.ok().ok(j) == null && com.ss.android.downloadlib.addownload.a.kf.ok().s(j) == null) ? false : true;
    }

    @Override // com.ss.android.downloadad.api.a
    public boolean ok(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return ok(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.ss.android.downloadad.api.a
    public boolean ok(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) com.ss.android.downloadlib.n.a.ok(new a.ok<Boolean>() { // from class: com.ss.android.downloadlib.a.3
            @Override // com.ss.android.downloadlib.n.a.ok
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean a() {
                return Boolean.valueOf(a.this.a(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    public static DownloadController ok(boolean z) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        DownloadController downloadControllerA = downloadController;
        if (!com.ss.android.download.api.bl.ok.ok(uri) || r.q().optInt("disable_market") == 1) {
            return false;
        }
        Context context2 = context == null ? r.getContext() : context;
        String strA = com.ss.android.download.api.bl.ok.a(uri);
        if (downloadModel == null) {
            return q.ok(context2, strA).getType() == 5;
        }
        if (!TextUtils.isEmpty(strA) && (downloadModel instanceof AdDownloadModel)) {
            ((AdDownloadModel) downloadModel).setPackageName(strA);
        }
        if (downloadControllerA != null) {
            downloadControllerA.setDownloadMode(2);
        } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
            downloadControllerA = ok(true);
        } else if (downloadModel.getDownloadUrl().startsWith("market")) {
            downloadControllerA = ok(true);
        } else {
            downloadControllerA = a();
        }
        com.ss.android.downloadlib.addownload.a.n nVar = new com.ss.android.downloadlib.addownload.a.n(downloadModel.getId(), downloadModel, (DownloadEventConfig) j.ok(downloadEventConfig, bl()), downloadControllerA);
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(nVar.f9775a);
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(nVar.ok, nVar.bl);
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(nVar.ok, nVar.s);
        if (j.ok(downloadModel) && com.ss.android.socialbase.downloader.h.ok.bl().a("app_link_opt") == 1 && com.ss.android.downloadlib.a.ok.ok(nVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        j.ok(jSONObject, "market_url", uri.toString());
        j.ok(jSONObject, "download_scene", (Object) 1);
        com.ss.android.downloadlib.s.ok.ok().a("market_click_open", jSONObject, nVar);
        com.ss.android.downloadlib.addownload.a.h hVarOk = q.ok(context2, nVar, strA);
        String strOk = j.ok(hVarOk.a(), "open_market");
        if (hVarOk.getType() == 5) {
            com.ss.android.downloadlib.a.ok.ok(strOk, jSONObject, nVar, true);
            return true;
        }
        if (hVarOk.getType() != 6) {
            return true;
        }
        j.ok(jSONObject, "error_code", Integer.valueOf(hVarOk.ok()));
        com.ss.android.downloadlib.s.ok.ok().a("market_open_failed", jSONObject, nVar);
        if (com.ss.android.downloadlib.addownload.q.ok(downloadModel, iDownloadButtonClickListener)) {
            iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
        }
        return false;
    }

    public static DownloadController a() {
        return ok(false);
    }
}

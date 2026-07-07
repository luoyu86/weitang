package com.ss.android.downloadlib.addownload;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    public static boolean a(int i2) {
        return i2 == 2 || i2 == 1;
    }

    public static boolean a(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static boolean ok(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public static boolean ok(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean ok(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int ok(@NonNull com.ss.android.downloadlib.addownload.a.n nVar, boolean z, com.ss.android.socialbase.appdownloader.kf kfVar) {
        int iOk;
        if (kfVar == null || TextUtils.isEmpty(kfVar.ok()) || kfVar.getContext() == null) {
            return 0;
        }
        try {
            iOk = ok(kfVar, kfVar.ok());
        } catch (Throwable th) {
            r.u().ok(th, "redirectSavePathIfPossible");
            iOk = 4;
        }
        kfVar.ok(iOk);
        if (iOk == 0) {
            kfVar.ok(new com.ss.android.downloadlib.bl.ok());
        }
        if (!kfVar.ew()) {
            kfVar.ok(new com.ss.android.downloadlib.bl.a());
        }
        int iOk2 = com.ss.android.socialbase.appdownloader.s.k().ok(kfVar);
        com.ss.android.downloadad.api.ok.a aVarOk = ok(nVar, iOk2);
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(aVarOk);
        aVarOk.h(iOk2);
        aVarOk.p(System.currentTimeMillis());
        aVarOk.q(0L);
        com.ss.android.socialbase.downloader.h.ok okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(kfVar.to());
        if (!ok(kfVar, okVarOk, iOk2) && nVar.f9775a.isShowToast()) {
            String startToast = nVar.f9775a.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = okVarOk.bl("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            r.bl().ok(2, kfVar.getContext(), nVar.f9775a, startToast, null, 0);
        }
        return iOk2;
    }

    private static com.ss.android.downloadad.api.ok.a ok(com.ss.android.downloadlib.addownload.a.n nVar, int i2) {
        com.ss.android.downloadad.api.ok.a aVar = new com.ss.android.downloadad.api.ok.a(nVar.f9775a, nVar.bl, nVar.s, i2);
        boolean z = true;
        if (com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("download_event_opt", 1) > 1) {
            try {
                String packageName = nVar.f9775a.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (r.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    aVar.p(z);
                }
            } catch (Throwable unused) {
            }
        }
        return aVar;
    }

    private static boolean ok(com.ss.android.socialbase.appdownloader.kf kfVar, @NonNull com.ss.android.socialbase.downloader.h.ok okVar, int i2) {
        String strOptString;
        JSONArray jSONArrayN = okVar.n("ah_plans");
        if (jSONArrayN != null && jSONArrayN.length() != 0) {
            int length = jSONArrayN.length();
            JSONObject jSONObject = null;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayN.optJSONObject(i3);
                    if (jSONObjectOptJSONObject != null && ((strOptString = jSONObjectOptJSONObject.optString("type")) == "plan_c" || com.ss.android.socialbase.appdownloader.kf.ok.ok(jSONObjectOptJSONObject))) {
                        strOptString.hashCode();
                        switch (strOptString) {
                            case "plan_a":
                            case "plan_b":
                            case "plan_e":
                            case "plan_f":
                                if (com.ss.android.socialbase.appdownloader.a.ok(jSONObjectOptJSONObject, okVar).f9949a != 0) {
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "plan_c":
                                jSONObject = jSONObjectOptJSONObject;
                                continue;
                                break;
                            case "plan_g":
                                if (com.ss.android.socialbase.appdownloader.a.a(jSONObjectOptJSONObject, okVar).f9949a != 0) {
                                    break;
                                } else {
                                    break;
                                }
                                break;
                        }
                    }
                    i3++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("show_unknown_source_on_startup") == 1) {
                    return com.ss.android.socialbase.appdownloader.a.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), (Intent) null, jSONObject, i2, new com.ss.android.socialbase.appdownloader.ok());
                }
            }
        }
        return false;
    }

    public static String ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private static int ok(com.ss.android.socialbase.appdownloader.kf kfVar, String str) {
        com.ss.android.socialbase.downloader.h.ok okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(kfVar.to());
        JSONObject jSONObjectS = okVarOk.s("download_dir");
        if (jSONObjectS == null || TextUtils.isEmpty(jSONObjectS.optString("dir_name"))) {
            return -1;
        }
        String strA = kfVar.a();
        String strQu = kfVar.qu();
        if (TextUtils.isEmpty(strQu)) {
            strQu = com.ss.android.socialbase.appdownloader.bl.ok(str, strA, kfVar.j(), true);
        }
        if (strQu.length() > 255) {
            strQu = strQu.substring(strQu.length() - 255);
        }
        if (TextUtils.isEmpty(strA)) {
            strA = strQu;
        }
        String strBl = kfVar.bl();
        if (TextUtils.isEmpty(strBl)) {
            strBl = com.ss.android.socialbase.appdownloader.bl.a();
        }
        String str2 = strBl + File.separator + com.ss.android.socialbase.appdownloader.bl.ok(strA, okVarOk);
        DownloadInfo downloadInfoOk = com.ss.android.socialbase.appdownloader.s.k().ok(kfVar.getContext(), str);
        if (downloadInfoOk != null && downloadInfoOk.isSavePathRedirected()) {
            kfVar.bl(downloadInfoOk.getSavePath());
            try {
                kfVar.ok(new JSONObject(downloadInfoOk.getDownloadSettingString()));
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        }
        if (downloadInfoOk != null || !"application/vnd.android.package-archive".equalsIgnoreCase(com.ss.android.socialbase.appdownloader.s.k().ok(strQu, kfVar.j()))) {
            return downloadInfoOk != null ? 8 : 9;
        }
        int iOk = com.ss.android.socialbase.appdownloader.a.ok(okVarOk);
        if (iOk != 0) {
            return iOk;
        }
        kfVar.bl(str2);
        return iOk;
    }
}

package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.x.c;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    public static ok ok(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        com.ss.android.socialbase.downloader.h.ok okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo);
        if (str.equals(c.f5758c)) {
            return new k(context, okVarOk, downloadInfo.getTargetFilePath());
        }
        if (str.equals(c.f5759d)) {
            return new r(context, okVarOk, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new j(context, okVarOk, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new h(context, okVarOk, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new p(context, okVarOk, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new q(context, okVarOk, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        }
        if (str.equals(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM)) {
            return new bl(context, okVarOk, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new z(context, okVarOk, com.ss.android.socialbase.appdownloader.bl.ok(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.ss.android.socialbase.appdownloader.s.k().s(), new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
    }

    public static boolean ok(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.h.ok okVar) {
        if (context == null || str == null) {
            return false;
        }
        ok zVar = null;
        String strA = com.ss.android.socialbase.appdownloader.bl.a();
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.ss.android.socialbase.appdownloader.kf.n.s() && str.equals(c.f5758c)) {
            zVar = new k(context, okVar, strA);
        } else if (com.ss.android.socialbase.appdownloader.kf.n.s() && str.equals(c.f5759d)) {
            zVar = new r(context, okVar, strA);
        } else if (com.ss.android.socialbase.appdownloader.kf.n.s() && str.equals("v3")) {
            zVar = new j(context, okVar, strA);
        } else if (com.ss.android.socialbase.appdownloader.kf.n.n() && str.equals("o1")) {
            zVar = new h(context, okVar, strA);
        } else if (com.ss.android.socialbase.appdownloader.kf.n.n() && str.equals("o2")) {
            zVar = new p(context, okVar, strA);
        } else if (com.ss.android.socialbase.appdownloader.kf.n.n() && str.equals("o3")) {
            zVar = new q(context, okVar, strA, strA, strA);
        } else if (com.ss.android.socialbase.appdownloader.kf.n.s() && str.equals(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM)) {
            zVar = new bl(context, okVar, strA, jSONObject);
        } else if (com.ss.android.socialbase.appdownloader.kf.n.s() && str.equals("vbi")) {
            zVar = new z(context, okVar, strA);
        }
        return zVar != null && zVar.ok();
    }
}

package com.ss.android.downloadlib.addownload.s;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bl implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.ok.bl f9843a;
    private static com.ss.android.downloadlib.addownload.ok.s ok;

    public static com.ss.android.downloadlib.addownload.ok.bl a() {
        return f9843a;
    }

    public static com.ss.android.downloadlib.addownload.ok.s ok() {
        return ok;
    }

    public static void ok(com.ss.android.downloadlib.addownload.ok.bl blVar) {
        f9843a = blVar;
    }

    @Override // com.ss.android.downloadlib.addownload.s.h
    public boolean ok(final com.ss.android.downloadad.api.ok.a aVar, int i2, final p pVar, final com.ss.android.downloadlib.addownload.ok.bl blVar) {
        DownloadInfo downloadInfoA;
        String str;
        if (aVar == null || !ok(aVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(aVar.ld())) {
            downloadInfoA = com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).ok(aVar.ld(), null, true);
        } else {
            downloadInfoA = com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).a(aVar.ok());
        }
        if (downloadInfoA == null) {
            return false;
        }
        long curBytes = downloadInfoA.getCurBytes();
        long totalBytes = downloadInfoA.getTotalBytes();
        if (curBytes < 0 || totalBytes <= 0) {
            return false;
        }
        final int iOk = com.ss.android.downloadlib.addownload.k.ok(downloadInfoA.getId(), (int) ((100 * curBytes) / totalBytes));
        final int i3 = (int) (curBytes / 1048576);
        boolean z = iOk > ok(aVar.zz());
        ok = new com.ss.android.downloadlib.addownload.ok.s() { // from class: com.ss.android.downloadlib.addownload.s.bl.1
            @Override // com.ss.android.downloadlib.addownload.ok.s
            public void a() {
                com.ss.android.downloadlib.addownload.ok.s unused = bl.ok = null;
                bl.this.ok(iOk, i3, i3, aVar, "download_percent_cancel", "cancel");
                pVar.ok(aVar);
            }

            @Override // com.ss.android.downloadlib.addownload.ok.s
            public void ok() {
                com.ss.android.downloadlib.addownload.ok.s unused = bl.ok = null;
                bl.this.ok(iOk, i3, i3, aVar, "download_percent_cancel", "confirm");
            }
        };
        String strOk = com.ss.android.downloadlib.h.j.ok(com.ss.android.downloadlib.addownload.k.ok(aVar.zz(), curBytes, totalBytes));
        if (z) {
            str = String.format("该任务已下载%s，仅需%s即可下载完成，是否继续？", strOk, com.ss.android.downloadlib.h.j.ok(totalBytes - curBytes));
        } else {
            str = String.format("该任务已下载%s，即将下载完成，是否继续下载？", strOk);
        }
        String str2 = str;
        if (blVar != null) {
            ok(new com.ss.android.downloadlib.addownload.ok.bl() { // from class: com.ss.android.downloadlib.addownload.s.bl.2
                @Override // com.ss.android.downloadlib.addownload.ok.bl
                public void delete() {
                    com.ss.android.downloadlib.addownload.ok.s unused = bl.ok = null;
                    bl.this.ok(iOk, i3, i3, aVar, "download_percent_cancel", RequestParameters.SUBRESOURCE_DELETE);
                    blVar.delete();
                }
            });
        }
        TTDelegateActivity.a(aVar, str2, "继续", "暂停", "删除");
        return true;
    }

    private int ok(int i2) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("cancel_pause_optimise_download_percent_value", 50);
    }

    private boolean ok(com.ss.android.downloadad.api.ok.ok okVar) {
        return com.ss.android.downloadlib.h.n.ok(okVar).ok("cancel_pause_optimise_download_percent_retain_switch", 0) == 1 && okVar.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i2, int i3, int i4, com.ss.android.downloadad.api.ok.a aVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_percent", Integer.valueOf(i2));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i3));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i4));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("pause_cancel_optimise", jSONObject, aVar);
    }
}

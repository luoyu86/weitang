package com.ss.android.downloadlib.addownload.s;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.ok.bl f9840a;
    private static com.ss.android.downloadlib.addownload.ok.s ok;

    public static com.ss.android.downloadlib.addownload.ok.bl a() {
        return f9840a;
    }

    public static com.ss.android.downloadlib.addownload.ok.s ok() {
        return ok;
    }

    public static void ok(com.ss.android.downloadlib.addownload.ok.bl blVar) {
        f9840a = blVar;
    }

    @Override // com.ss.android.downloadlib.addownload.s.h
    public boolean ok(final com.ss.android.downloadad.api.ok.a aVar, int i2, final p pVar, final com.ss.android.downloadlib.addownload.ok.bl blVar) {
        DownloadInfo downloadInfoA;
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
        long jOk = com.ss.android.downloadlib.addownload.k.ok(downloadInfoA.getId(), downloadInfoA.getCurBytes(), downloadInfoA.getTotalBytes());
        long totalBytes = downloadInfoA.getTotalBytes();
        if (jOk >= 0 && totalBytes > 0) {
            if (totalBytes <= ok(aVar.zz())) {
                final int i3 = (int) (jOk / 1048576);
                ok = new com.ss.android.downloadlib.addownload.ok.s() { // from class: com.ss.android.downloadlib.addownload.s.a.1
                    @Override // com.ss.android.downloadlib.addownload.ok.s
                    public void a() {
                        com.ss.android.downloadlib.addownload.ok.s unused = a.ok = null;
                        a.this.ok(i3, i3, aVar, "apk_size_cancel", "cancel");
                        pVar.ok(aVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.ok.s
                    public void ok() {
                        com.ss.android.downloadlib.addownload.ok.s unused = a.ok = null;
                        a.this.ok(i3, i3, aVar, "apk_size_cancel", "confirm");
                    }
                };
                String str = String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", com.ss.android.downloadlib.h.j.ok(totalBytes - jOk));
                if (blVar != null) {
                    ok(new com.ss.android.downloadlib.addownload.ok.bl() { // from class: com.ss.android.downloadlib.addownload.s.a.2
                        @Override // com.ss.android.downloadlib.addownload.ok.bl
                        public void delete() {
                            com.ss.android.downloadlib.addownload.ok.s unused = a.ok = null;
                            a.this.ok(i3, i3, aVar, "apk_size_cancel", RequestParameters.SUBRESOURCE_DELETE);
                            blVar.delete();
                        }
                    });
                }
                TTDelegateActivity.ok(aVar, str, "继续", "暂停", "删除");
                return true;
            }
        }
        return false;
    }

    private int ok(int i2) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("cancel_pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean ok(com.ss.android.downloadad.api.ok.ok okVar) {
        return com.ss.android.downloadlib.h.n.ok(okVar).ok("cancel_pause_optimise_apk_retain_switch", 0) == 1 && okVar.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i2, int i3, com.ss.android.downloadad.api.ok.a aVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i2));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("pause_cancel_optimise", jSONObject, aVar);
    }
}

package com.ss.android.downloadlib.addownload.compliance;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.td;
import com.ss.android.downloadlib.addownload.r;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class kf {
    private final AtomicInteger ok;

    public static class ok {
        private static kf ok = new kf();
    }

    private kf() {
        this.ok = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.ok.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com");
        sb.append("/customer/api/app/deep_link");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull final com.ss.android.downloadlib.addownload.a.n nVar, final String str, final byte[] bArr, final p pVar) {
        r.s().ok(str, bArr, "application/json; charset=utf-8", 0, new td() { // from class: com.ss.android.downloadlib.addownload.compliance.kf.2
            @Override // com.ss.android.download.api.config.td
            public void ok(String str2) {
                kf.this.ok(nVar, str2, pVar);
            }

            @Override // com.ss.android.download.api.config.td
            public void ok(Throwable th) {
                kf.this.ok(nVar, str, bArr, pVar);
            }
        });
    }

    public static kf ok() {
        return ok.ok;
    }

    public void ok(final com.ss.android.downloadlib.addownload.a.n nVar, final p pVar) {
        if (r.s() == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("getDownloadNetworkFactory == NULL");
            ok(401, nVar);
        } else {
            com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.kf.1
                @Override // java.lang.Runnable
                public void run() {
                    kf kfVar = kf.this;
                    kfVar.a(nVar, kfVar.a(), kf.this.ok(nVar, true, 4), pVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(com.ss.android.downloadlib.addownload.a.n nVar, String str, byte[] bArr, p pVar) {
        if (this.ok.get() < 6) {
            this.ok.incrementAndGet();
            a(nVar, str, bArr, pVar);
        } else {
            ok("当前网络不佳，请稍后再试");
            this.ok.set(0);
            ok(402, nVar);
        }
    }

    private void ok(final String str) {
        com.ss.android.downloadlib.h.ok().a().post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.kf.3
            @Override // java.lang.Runnable
            public void run() {
                r.bl().ok(6, r.getContext(), null, str, null, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] ok(com.ss.android.downloadlib.addownload.a.n nVar, boolean z, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_url", nVar.ok());
            jSONObject.put("package_name", nVar.n());
            jSONObject.put("call_scene", 50);
            if (z) {
                jSONObject.put("sender_package_name", r.getContext().getPackageName());
                jSONObject.put("sender_version", r.k().n);
                if (i2 > 0) {
                    jSONObject.put("store", i2);
                }
            } else {
                jSONObject.put("id", String.valueOf(nVar.a()));
                if (nVar.io().getDeepLink() != null) {
                    if (TextUtils.isEmpty(nVar.io().getDeepLink().getWebUrl())) {
                        com.ss.android.downloadlib.n.bl.ok().ok("web_url is null");
                    }
                    jSONObject.put("web_url", nVar.io().getDeepLink().getWebUrl());
                } else {
                    com.ss.android.downloadlib.n.bl.ok().ok("deeplink is null");
                }
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.n.bl.ok().ok("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(@NonNull com.ss.android.downloadlib.addownload.a.n nVar, String str, p pVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.n.bl.ok().ok("response content is null");
                ok(404, nVar);
                pVar.ok();
                return;
            }
            this.ok.set(0);
            n nVarH = n.h(str);
            if (nVarH.ok() != 0) {
                ok(403, nVar);
                pVar.ok();
            } else if (TextUtils.isEmpty(nVarH.a())) {
                ok(405, nVar);
                pVar.ok();
            } else {
                pVar.ok(nVarH.a());
            }
        } catch (Exception e2) {
            com.ss.android.downloadlib.n.bl.ok().ok(e2, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    public void ok(int i2, com.ss.android.downloadlib.addownload.a.n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("get_miui_market_compliance_error", jSONObject, nVar);
    }

    public void ok(int i2, com.ss.android.downloadlib.addownload.a.n nVar, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("get_miui_market_compliance_success", jSONObject, nVar);
    }
}

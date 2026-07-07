package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.download.api.config.td;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.bl;
import com.ss.android.downloadlib.h.j;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private SoftReference<Activity> ok;

    public static class ok {
        private static a ok = new a();
    }

    public void a(long j) {
        com.ss.android.downloadlib.addownload.n nVarOk = com.ss.android.downloadlib.h.ok().ok(com.ss.android.downloadlib.addownload.a.kf.ok().n(j).f9775a.getDownloadUrl());
        if (nVarOk != null) {
            nVarOk.ok(true, true);
        } else {
            h.ok(11, j);
            com.ss.android.downloadlib.n.bl.ok().a("startDownload handler null");
        }
    }

    private a() {
    }

    public static a ok() {
        return ok.ok;
    }

    public void ok(long j) {
        TTDelegateActivity.ok(j);
    }

    public boolean ok(DownloadModel downloadModel) {
        if (!downloadModel.isAd() || r.q().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
        return (TextUtils.isEmpty(webUrl) || Pattern.compile(r.q().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
    }

    public Activity a() {
        Activity activity = this.ok.get();
        this.ok = null;
        return activity;
    }

    public boolean ok(@NonNull com.ss.android.downloadlib.addownload.a.n nVar) {
        long jOk;
        long j;
        if (!TextUtils.isEmpty(nVar.f9775a.getLogExtra())) {
            try {
                jOk = j.ok(new JSONObject(nVar.f9775a.getLogExtra()), "convert_id");
            } catch (Exception e2) {
                e2.printStackTrace();
                jOk = 0;
            }
            if (jOk <= 0) {
                h.ok(3, nVar);
            }
            j = jOk;
        } else {
            h.ok(9, nVar);
            com.ss.android.downloadlib.n.bl.ok().ok("requestAppInfo getLogExtra null");
            j = 0;
        }
        final long j2 = nVar.ok;
        com.ss.android.downloadlib.addownload.a.a aVarOk = bl.ok().ok(j, j2);
        if (aVarOk != null) {
            s.ok().ok(aVarOk.ok(), j2, aVarOk.s);
            ok(aVarOk.ok());
            h.ok("lp_app_dialog_try_show", nVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j > 0) {
            sb.append("convert_id=");
            sb.append(j);
        }
        if (!TextUtils.isEmpty(nVar.f9775a.getPackageName())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=");
            sb.append(nVar.f9775a.getPackageName());
        }
        if (sb.length() <= 0) {
            h.ok(6, nVar);
            return false;
        }
        final long j3 = j;
        com.ss.android.downloadlib.h.bl.ok((bl.ok<String, R>) new bl.ok<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.a.2
            @Override // com.ss.android.downloadlib.h.bl.ok
            public Boolean ok(String str) {
                final boolean[] zArr = {false};
                r.s().ok("GET", str, new HashMap(), new td() { // from class: com.ss.android.downloadlib.addownload.compliance.a.2.1
                    @Override // com.ss.android.download.api.config.td
                    public void ok(String str2) {
                        boolean[] zArr2 = zArr;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = a.this.ok(j3, j2, str2);
                    }

                    @Override // com.ss.android.download.api.config.td
                    public void ok(Throwable th) {
                        h.ok(2, j2);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).ok(new bl.ok<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.a.1
            @Override // com.ss.android.downloadlib.h.bl.ok
            public Object ok(Boolean bool) {
                if (!bool.booleanValue()) {
                    a.this.a(j2);
                    return null;
                }
                a.this.ok(com.ss.android.downloadlib.addownload.a.a.ok(j3, j2));
                h.a("lp_app_dialog_try_show", j2);
                return null;
            }
        }).ok();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ok(long j, long j2, String str) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(AbsServerManager.PACKAGE_QUERY_BINDER);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.a.a aVar = new com.ss.android.downloadlib.addownload.a.a();
                aVar.ok = j;
                aVar.f9767a = j2;
                aVar.s = jSONObjectOptJSONObject.optString("icon_url");
                aVar.n = jSONObjectOptJSONObject.optString("app_name");
                aVar.bl = jSONObjectOptJSONObject.optString("package_name");
                aVar.kf = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                aVar.f9768h = jSONObjectOptJSONObject.optString("developer_name");
                aVar.f9769q = jSONObjectOptJSONObject.optString("policy_url");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObject = (JSONObject) jSONArrayOptJSONArray.get(i2);
                        aVar.p.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                bl.ok().ok(aVar);
                s.ok().ok(aVar.ok(), j2, aVar.s);
                return true;
            }
            h.ok(7, j2);
            return false;
        } catch (Exception e2) {
            com.ss.android.downloadlib.n.bl.ok().ok(e2, "AdLpComplianceManager parseResponse");
            h.ok(7, j2);
            return false;
        }
    }

    public void ok(Activity activity) {
        this.ok = new SoftReference<>(activity);
    }
}

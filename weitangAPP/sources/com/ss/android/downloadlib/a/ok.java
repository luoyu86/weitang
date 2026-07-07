package com.ss.android.downloadlib.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.zz;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ok {
    public static void a(com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar == null) {
            return;
        }
        String strKf = com.ss.android.socialbase.downloader.h.ok.bl().a("app_link_opt") == 1 ? aVar.kf() : null;
        JSONObject jSONObjectOk = com.ss.android.downloadlib.h.kf.ok(new JSONObject(), aVar);
        j.ok(jSONObjectOk, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.s.ok.ok().a("applink_click", jSONObjectOk, aVar);
        com.ss.android.downloadlib.addownload.a.h hVarOk = com.ss.android.downloadlib.h.q.ok(strKf, aVar);
        if (hVarOk.getType() == 2) {
            if (!TextUtils.isEmpty(strKf)) {
                a("dialog_by_url", hVarOk, jSONObjectOk, aVar);
            }
            hVarOk = com.ss.android.downloadlib.h.q.ok(r.getContext(), aVar.n(), aVar);
        }
        int type = hVarOk.getType();
        if (type == 1) {
            a("dialog_by_url", jSONObjectOk, aVar);
            return;
        }
        if (type == 3) {
            ok("dialog_by_package", jSONObjectOk, aVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.n.bl.ok().a("AppLinkClickDialog default");
        } else {
            ok("dialog_by_package", hVarOk, jSONObjectOk, aVar);
        }
    }

    public static boolean ok(@NonNull com.ss.android.downloadlib.addownload.a.n nVar) {
        boolean z;
        DeepLink deepLink = nVar.f9775a.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject jSONObjectOk = com.ss.android.downloadlib.h.kf.ok(new JSONObject(), nVar);
        j.ok(jSONObjectOk, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.s.ok.ok().a("applink_click", jSONObjectOk, nVar);
        com.ss.android.downloadlib.addownload.a.h hVarOk = com.ss.android.downloadlib.h.q.ok(openUrl, nVar);
        if (hVarOk.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                a("by_url", hVarOk, jSONObjectOk, nVar);
            }
            hVarOk = com.ss.android.downloadlib.h.q.ok(r.getContext(), nVar.f9775a.getPackageName(), nVar);
        }
        boolean z2 = false;
        if (ok(nVar.ok) && r.q().optInt("link_ad_click_event") == 1) {
            DownloadModel downloadModel = nVar.f9775a;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(4);
            }
            com.ss.android.downloadlib.s.ok.ok().ok(nVar.ok, 0);
            z = true;
        } else {
            z = false;
        }
        int type = hVarOk.getType();
        if (type == 1) {
            a("by_url", jSONObjectOk, nVar);
        } else {
            if (type != 3) {
                if (type != 4) {
                    com.ss.android.downloadlib.n.bl.ok().a("AppLinkClick default");
                } else {
                    ok("by_package", hVarOk, jSONObjectOk, nVar);
                }
                if (z2 && !z && ((com.ss.android.downloadlib.s.bl.ok().a() && !com.ss.android.downloadlib.s.bl.ok().a(nVar.ok, nVar.f9775a.getLogExtra())) || com.ss.android.downloadlib.s.bl.ok().bl())) {
                    com.ss.android.downloadlib.s.ok.ok().ok(nVar.ok, 2);
                }
                return z2;
            }
            ok("by_package", jSONObjectOk, nVar);
        }
        z2 = true;
        if (z2) {
            com.ss.android.downloadlib.s.ok.ok().ok(nVar.ok, 2);
        }
        return z2;
    }

    public static void a(String str, @NonNull final JSONObject jSONObject, @NonNull final com.ss.android.downloadad.api.ok.ok okVar) {
        j.ok(jSONObject, "applink_source", str);
        j.ok(jSONObject, "download_scene", Integer.valueOf(okVar.u()));
        com.ss.android.downloadlib.s.ok.ok().a("deeplink_url_open", jSONObject, okVar);
        str.hashCode();
        switch (str) {
            case "auto_by_url":
            case "by_url":
            case "notify_by_url":
            case "dialog_by_url":
                if ((r.q().optInt("check_applink_mode") & 1) != 0) {
                    j.ok(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    n.ok().ok(new s() { // from class: com.ss.android.downloadlib.a.ok.2
                        @Override // com.ss.android.downloadlib.a.s
                        public void ok(boolean z) {
                            com.ss.android.downloadlib.s.ok.ok().a(z ? "deeplink_success" : "deeplink_failed", jSONObject, okVar);
                            if (z) {
                                r.io().ok(r.getContext(), okVar.io(), okVar.o(), okVar.ul(), okVar.n(), 0);
                            }
                        }
                    });
                    break;
                } else {
                    r.a().ok(r.getContext(), okVar.io(), okVar.o(), okVar.ul(), okVar.n(), str);
                    break;
                }
                break;
        }
    }

    public static void ok(@NonNull com.ss.android.downloadad.api.ok.a aVar) {
        String strKf = aVar.kf();
        JSONObject jSONObjectOk = com.ss.android.downloadlib.h.kf.ok(new JSONObject(), aVar);
        j.ok(jSONObjectOk, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.s.ok.ok().a("applink_click", jSONObjectOk, aVar);
        com.ss.android.downloadlib.addownload.a.h hVarOk = com.ss.android.downloadlib.h.q.ok(strKf, aVar);
        if (hVarOk.getType() == 2) {
            if (!TextUtils.isEmpty(strKf)) {
                a("notify_by_url", hVarOk, jSONObjectOk, aVar);
            }
            hVarOk = com.ss.android.downloadlib.h.q.ok(r.getContext(), aVar.n(), aVar);
        }
        int type = hVarOk.getType();
        if (type == 1) {
            a("notify_by_url", jSONObjectOk, aVar);
            return;
        }
        if (type == 3) {
            ok("notify_by_package", jSONObjectOk, aVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.n.bl.ok().a("AppLinkClickNotification default");
        } else {
            ok("notify_by_package", hVarOk, jSONObjectOk, aVar);
        }
    }

    public static void a(String str, @NonNull com.ss.android.downloadlib.addownload.a.h hVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.ok.ok okVar) {
        j.ok(jSONObject, "applink_source", str);
        j.ok(jSONObject, "error_code", Integer.valueOf(hVar.ok()));
        j.ok(jSONObject, "download_scene", Integer.valueOf(okVar.u()));
        com.ss.android.downloadlib.s.ok.ok().a("deeplink_url_open_fail", jSONObject, okVar);
    }

    public static boolean ok(String str, @NonNull com.ss.android.downloadad.api.ok.a aVar) {
        if (!com.ss.android.downloadlib.addownload.q.a(aVar.l())) {
            return false;
        }
        if (TextUtils.isEmpty(aVar.kf()) && TextUtils.isEmpty(str)) {
            return false;
        }
        com.ss.android.socialbase.downloader.notification.a.ok().kf(aVar.zz());
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.h.kf.ok(jSONObject, aVar);
        j.ok(jSONObject, "applink_source", "auto_click");
        com.ss.android.downloadlib.s.ok.ok().a("applink_click", aVar);
        com.ss.android.downloadlib.addownload.a.h hVarOk = com.ss.android.downloadlib.h.q.ok(aVar, aVar.kf(), aVar.n());
        int type = hVarOk.getType();
        if (type == 1) {
            a("auto_by_url", jSONObject, aVar);
            return true;
        }
        if (type == 2) {
            a("auto_by_url", hVarOk, jSONObject, aVar);
            return false;
        }
        if (type == 3) {
            ok("auto_by_package", jSONObject, aVar);
            return true;
        }
        if (type != 4) {
            return false;
        }
        ok("auto_by_package", hVarOk, jSONObject, aVar);
        return false;
    }

    public static void ok(String str, @NonNull final JSONObject jSONObject, @NonNull final com.ss.android.downloadad.api.ok.ok okVar) {
        j.ok(jSONObject, "applink_source", str);
        j.ok(jSONObject, "download_scene", Integer.valueOf(okVar.u()));
        com.ss.android.downloadlib.s.ok.ok().a("deeplink_app_open", jSONObject, okVar);
        str.hashCode();
        switch (str) {
            case "notify_by_package":
            case "auto_by_package":
            case "by_package":
            case "dialog_by_package":
                if ((r.q().optInt("check_applink_mode") & 1) != 0) {
                    j.ok(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    n.ok().ok(new s() { // from class: com.ss.android.downloadlib.a.ok.1
                        @Override // com.ss.android.downloadlib.a.s
                        public void ok(boolean z) {
                            com.ss.android.downloadlib.s.ok.ok().a(z ? "deeplink_success" : "deeplink_failed", jSONObject, okVar);
                            if (z) {
                                r.io().ok(r.getContext(), okVar.io(), okVar.o(), okVar.ul(), okVar.n(), 0);
                            }
                        }
                    });
                    break;
                } else {
                    r.a().ok(r.getContext(), okVar.io(), okVar.o(), okVar.ul(), okVar.n(), str);
                    break;
                }
                break;
        }
    }

    public static void ok(String str, @NonNull com.ss.android.downloadlib.addownload.a.h hVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.ok.ok okVar) {
        j.ok(jSONObject, "applink_source", str);
        j.ok(jSONObject, "error_code", Integer.valueOf(hVar.ok()));
        j.ok(jSONObject, "download_scene", Integer.valueOf(okVar.u()));
        com.ss.android.downloadlib.s.ok.ok().a("deeplink_app_open_fail", jSONObject, okVar);
    }

    public static boolean ok(@NonNull com.ss.android.downloadlib.addownload.a.n nVar, int i2) {
        JSONObject jSONObject = new JSONObject();
        j.ok(jSONObject, "download_scene", Integer.valueOf(nVar.u()));
        com.ss.android.downloadlib.s.ok.ok().a("market_click_open", jSONObject, nVar);
        com.ss.android.downloadlib.addownload.a.h hVarOk = com.ss.android.downloadlib.h.q.ok(r.getContext(), nVar, nVar.f9775a.getPackageName());
        String strOk = j.ok(hVarOk.a(), "open_market");
        int type = hVarOk.getType();
        if (type == 5) {
            ok(strOk, jSONObject, nVar, true);
        } else {
            if (type == 6) {
                j.ok(jSONObject, "error_code", Integer.valueOf(hVarOk.ok()));
                j.ok(jSONObject, "download_scene", Integer.valueOf(nVar.u()));
                com.ss.android.downloadlib.s.ok.ok().a("market_open_failed", jSONObject, nVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        com.ss.android.downloadlib.s.ok.ok().ok(nVar.ok, i2);
        return true;
    }

    public static void ok(final String str, @Nullable final JSONObject jSONObject, final com.ss.android.downloadlib.addownload.a.n nVar, boolean z) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e2) {
                com.ss.android.downloadlib.n.bl.ok().ok(e2, "onMarketSuccess");
                return;
            }
        }
        j.ok(jSONObject, "applink_source", str);
        j.ok(jSONObject, "download_scene", Integer.valueOf(nVar.u()));
        if (z) {
            com.ss.android.downloadlib.s.ok.ok().a("market_open_success", jSONObject, nVar);
        }
        if ((r.q().optInt("check_applink_mode") & 4) != 0) {
            n.ok().a(new s() { // from class: com.ss.android.downloadlib.a.ok.3
                @Override // com.ss.android.downloadlib.a.s
                public void ok(boolean z2) {
                    if (!z2 && !"open_market".equals(str)) {
                        ok.ok(com.ss.android.downloadlib.h.q.ok(r.getContext(), Uri.parse("market://details?id=" + nVar.n())), nVar, false);
                    }
                    com.ss.android.downloadlib.s.ok.ok().ok(z2 ? "market_delay_success" : "market_delay_failed", jSONObject, nVar);
                    if (z2) {
                        zz zzVarIo = r.io();
                        Context context = r.getContext();
                        com.ss.android.downloadlib.addownload.a.n nVar2 = nVar;
                        DownloadModel downloadModel = nVar2.f9775a;
                        zzVarIo.ok(context, downloadModel, nVar2.s, nVar2.bl, downloadModel.getPackageName(), 2);
                    }
                }
            });
        } else {
            com.ss.android.download.api.config.bl blVarA = r.a();
            Context context = r.getContext();
            DownloadModel downloadModel = nVar.f9775a;
            blVarA.ok(context, downloadModel, nVar.s, nVar.bl, downloadModel.getPackageName(), str);
        }
        com.ss.android.downloadad.api.ok.a aVar = new com.ss.android.downloadad.api.ok.a(nVar.f9775a, nVar.bl, nVar.s);
        aVar.n(2);
        aVar.kf(System.currentTimeMillis());
        aVar.p(4);
        aVar.q(2);
        com.ss.android.downloadlib.addownload.a.kf.ok().ok(aVar);
    }

    public static void ok(com.ss.android.downloadlib.addownload.a.h hVar, com.ss.android.downloadlib.addownload.a.n nVar, boolean z) {
        String strOk = j.ok(hVar.a(), "open_market");
        JSONObject jSONObject = new JSONObject();
        j.ok(jSONObject, "ttdownloader_type", "backup");
        int type = hVar.getType();
        if (type == 5) {
            ok(strOk, jSONObject, nVar, z);
        } else {
            if (type != 6) {
                return;
            }
            j.ok(jSONObject, "error_code", Integer.valueOf(hVar.ok()));
            j.ok(jSONObject, "download_scene", Integer.valueOf(nVar.u()));
            com.ss.android.downloadlib.s.ok.ok().a("market_open_failed", jSONObject, nVar);
        }
    }

    public static boolean ok(long j) {
        return com.ss.android.downloadlib.addownload.a.kf.ok().s(j) == null;
    }
}

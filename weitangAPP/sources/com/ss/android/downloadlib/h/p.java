package com.ss.android.downloadlib.h;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alipay.sdk.m.p0.b;
import com.ss.android.download.api.config.td;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.taobao.accs.AccsState;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p {
    private static com.ss.android.downloadlib.addownload.a.h bl(Context context, com.ss.android.downloadlib.addownload.a.n nVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("dl", true);
        intent.putExtra("p", str);
        intent.putExtra("id", nVar.ok);
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("bk", "com.heytap.browser");
        } else if (j.n(context, "com.android.browser")) {
            intent.putExtra("bk", "com.android.browser");
        } else {
            if (!j.n(context, "com.coloros.browser")) {
                return ok(context, Uri.parse("market://details?id=" + str));
            }
            intent.putExtra("bk", "com.coloros.browser");
        }
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.a.h(7, "am_kllk3");
        } catch (Throwable unused) {
            a(nVar, jSONObject, 1, 3, "market://details?id=" + str);
            return ok(context, Uri.parse("market://details?id=" + str));
        }
    }

    private static void h(final Context context, final com.ss.android.downloadlib.addownload.a.n nVar, final String str) {
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.h.p.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectQ = com.ss.android.downloadlib.addownload.r.q();
                String strOptString = jSONObjectQ.optString(OperatorName.CLOSE_AND_STROKE);
                final JSONObject jSONObject = new JSONObject();
                String strOk = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("x"), strOptString);
                JSONObject jSONObject2 = new JSONObject();
                j.ok(jSONObject2, DispatchConstants.TIMESTAMP, "v");
                j.ok(jSONObject2, "p", str);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.r.s().ok(strOk, com.ss.android.downloadlib.addownload.r.td().ok(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new td() { // from class: com.ss.android.downloadlib.h.p.7.1
                    @Override // com.ss.android.download.api.config.td
                    public void ok(String str2) {
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        p.a(context, str, str2, nVar, jSONObject);
                    }

                    @Override // com.ss.android.download.api.config.td
                    public void ok(Throwable th) {
                        com.ss.android.downloadlib.a.ok.ok(p.ok(context, Uri.parse("market://details?id=" + str)), nVar, true);
                        j.ok(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                        p.a(nVar, jSONObject, 7, 5, "market://details?id=" + str);
                    }
                });
            }
        });
    }

    private static void kf(Context context, com.ss.android.downloadlib.addownload.a.n nVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.ok(str, nVar.ok);
        } catch (Exception unused) {
            com.ss.android.downloadlib.a.ok.ok(ok(context, Uri.parse("market://details?id=" + str)), nVar, true);
            a(nVar, jSONObject, 13, 10, "market://details?id=" + str);
        }
    }

    private static void n(final Context context, final com.ss.android.downloadlib.addownload.a.n nVar, final String str) {
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.h.p.6
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectQ = com.ss.android.downloadlib.addownload.r.q();
                final JSONObject jSONObject = new JSONObject();
                try {
                    String strOptString = jSONObjectQ.optString(OperatorName.CLOSE_AND_STROKE);
                    String strOk = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("bw"), strOptString);
                    String strOk2 = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("bx"), strOptString);
                    String strOk3 = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("by"), strOptString);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("https").authority(strOk).appendPath(strOk2).appendQueryParameter(strOk3, str);
                    com.ss.android.downloadlib.addownload.r.s().ok("GET", builder.build().toString(), null, new td() { // from class: com.ss.android.downloadlib.h.p.6.1
                        /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
                        @Override // com.ss.android.download.api.config.td
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public void ok(java.lang.String r6) {
                            /*
                                r5 = this;
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                r1 = 1
                                if (r0 != 0) goto L28
                                java.lang.String r6 = com.ss.android.downloadlib.h.p.ok(r6)
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                if (r0 != 0) goto L28
                                java.lang.String r6 = com.ss.android.downloadlib.h.p.a(r6)
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                if (r0 != 0) goto L28
                                com.ss.android.downloadlib.h.p$6 r0 = com.ss.android.downloadlib.h.p.AnonymousClass6.this
                                android.content.Context r2 = r2
                                com.ss.android.downloadlib.addownload.a.n r3 = r3
                                java.lang.String r0 = r1
                                com.ss.android.downloadlib.h.p.ok(r2, r3, r0, r6)
                                r6 = 1
                                goto L29
                            L28:
                                r6 = 0
                            L29:
                                if (r6 != 0) goto L73
                                com.ss.android.downloadlib.h.p$6 r6 = com.ss.android.downloadlib.h.p.AnonymousClass6.this
                                android.content.Context r6 = r2
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                r0.<init>()
                                java.lang.String r2 = "market://details?id="
                                r0.append(r2)
                                com.ss.android.downloadlib.h.p$6 r3 = com.ss.android.downloadlib.h.p.AnonymousClass6.this
                                java.lang.String r3 = r1
                                r0.append(r3)
                                java.lang.String r0 = r0.toString()
                                android.net.Uri r0 = android.net.Uri.parse(r0)
                                com.ss.android.downloadlib.addownload.a.h r6 = com.ss.android.downloadlib.h.p.ok(r6, r0)
                                com.ss.android.downloadlib.h.p$6 r0 = com.ss.android.downloadlib.h.p.AnonymousClass6.this
                                com.ss.android.downloadlib.addownload.a.n r0 = r3
                                com.ss.android.downloadlib.a.ok.ok(r6, r0, r1)
                                com.ss.android.downloadlib.h.p$6 r6 = com.ss.android.downloadlib.h.p.AnonymousClass6.this
                                com.ss.android.downloadlib.addownload.a.n r6 = r3
                                org.json.JSONObject r0 = r2
                                r1 = 10
                                r3 = 9
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                r4.<init>()
                                r4.append(r2)
                                com.ss.android.downloadlib.h.p$6 r2 = com.ss.android.downloadlib.h.p.AnonymousClass6.this
                                java.lang.String r2 = r1
                                r4.append(r2)
                                java.lang.String r2 = r4.toString()
                                com.ss.android.downloadlib.h.p.ok(r6, r0, r1, r3, r2)
                            L73:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.h.p.AnonymousClass6.AnonymousClass1.ok(java.lang.String):void");
                        }

                        @Override // com.ss.android.download.api.config.td
                        public void ok(Throwable th) {
                            com.ss.android.downloadlib.a.ok.ok(p.ok(context, Uri.parse("market://details?id=" + str)), nVar, true);
                            j.ok(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                            p.a(nVar, jSONObject, 11, 9, "market://details?id=" + str);
                        }
                    });
                } catch (Exception e2) {
                    e2.printStackTrace();
                    p.a(nVar, jSONObject, 4, 9, "market://details?id=" + str);
                }
            }
        });
    }

    private static void p(Context context, com.ss.android.downloadlib.addownload.a.n nVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.ok(str, nVar.ok, "need_comment");
        } catch (Exception unused) {
            com.ss.android.downloadlib.a.ok.ok(ok(context, Uri.parse("market://details?id=" + str)), nVar, true);
            a(nVar, jSONObject, 9, 8, "market://details?id=" + str);
        }
    }

    private static com.ss.android.downloadlib.addownload.a.h s(@NonNull Context context, @NonNull String str) {
        try {
            Uri uri = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(uri);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.a.h(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.a.h(6, 14);
        }
    }

    private static com.ss.android.downloadlib.addownload.a.h a(Context context, com.ss.android.downloadlib.addownload.a.n nVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("p", str);
        intent.putExtra("id", nVar.ok);
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.a.h(7, "am_kllk2");
        } catch (Throwable unused) {
            a(nVar, jSONObject, 1, 3, "market://details?id=" + str);
            return ok(context, Uri.parse("market://details?id=" + str));
        }
    }

    public static com.ss.android.downloadlib.addownload.a.h ok(Context context, Uri uri) {
        if (!com.ss.android.socialbase.appdownloader.kf.n.bl() && (context == null || uri == null || !"market".equals(uri.getScheme()))) {
            return new com.ss.android.downloadlib.addownload.a.h(6, 12);
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!j.ok(context, intent)) {
                return new com.ss.android.downloadlib.addownload.a.h(6, 13);
            }
            String strK = com.ss.android.socialbase.appdownloader.kf.n.k();
            if (j.n(context, strK) && !com.ss.android.socialbase.appdownloader.kf.n.h()) {
                intent.setPackage(strK);
            }
            if (com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_jump_market")) {
                intent.addFlags(335544320);
            } else if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (com.ss.android.socialbase.downloader.h.ok.bl().a("test_jump_market_failed") == 1) {
                com.ss.android.downloadlib.n.bl.ok().ok(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.a.h(6, 25);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.a.h(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.a.h(6, 14);
        }
    }

    private static void s(final Context context, final com.ss.android.downloadlib.addownload.a.n nVar, final String str) {
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.h.p.5
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.downloadlib.a.ok.ok(p.ok(context, Uri.parse("market://details?id=" + str)), nVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObjectQ = com.ss.android.downloadlib.addownload.r.q();
                    Thread.sleep(jSONObjectQ.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.ok.ok.ok.ok().ok(context, true);
                    com.ss.android.downloadlib.ok.ok.a aVar = new com.ss.android.downloadlib.ok.ok.a();
                    aVar.ok = 1;
                    aVar.f9892a = 0;
                    String strOk = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("v"), jSONObjectQ.optString(OperatorName.CLOSE_AND_STROKE));
                    aVar.bl = String.format(strOk, str);
                    com.ss.android.downloadlib.ok.ok.ok.ok().ok(aVar, (com.ss.android.downloadlib.ok.ok.s) null);
                    com.ss.android.downloadlib.ok.ok.ok.ok().a();
                    p.a(nVar, jSONObject, -1, 2, String.format(strOk, str));
                } catch (Throwable th) {
                    th.printStackTrace();
                    p.a(nVar, jSONObject, 1, 2, "market://details?id=" + str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, String str, String str2, @NonNull com.ss.android.downloadlib.addownload.a.n nVar, @NonNull JSONObject jSONObject) {
        j.ok(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String strOk = com.ss.android.socialbase.appdownloader.kf.bl.ok(new JSONObject(str2).optString(PDPageLabelRange.STYLE_LETTERS_LOWER));
            if (!TextUtils.isEmpty(strOk)) {
                TTDelegateActivity.ok(str, nVar.ok, strOk, jSONObject);
            } else {
                com.ss.android.downloadlib.a.ok.ok(ok(context, Uri.parse("market://details?id=" + str)), nVar, true);
                a(nVar, jSONObject, 5, 5, "market://details?id=" + str);
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.a.ok.ok(ok(context, Uri.parse("market://details?id=" + str)), nVar, true);
            a(nVar, jSONObject, 6, 5, "market://details?id=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String s(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 0) {
            return pathSegments.get(pathSegments.size() - 1);
        }
        return null;
    }

    public static boolean bl(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String strK = com.ss.android.socialbase.appdownloader.kf.n.k();
        if (j.n(com.ss.android.downloadlib.addownload.r.getContext(), strK)) {
            intent.setPackage(strK);
        }
        if (!j.ok(com.ss.android.downloadlib.addownload.r.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e2) {
            com.ss.android.downloadlib.n.bl.ok().ok(e2, "start HM2");
            return false;
        }
    }

    public static boolean a(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String strK = com.ss.android.socialbase.appdownloader.kf.n.k();
        if (j.n(com.ss.android.downloadlib.addownload.r.getContext(), strK)) {
            intent.setPackage(strK);
        }
        if (!j.ok(com.ss.android.downloadlib.addownload.r.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e2) {
            com.ss.android.downloadlib.n.bl.ok().ok(e2, "start HM1");
            return false;
        }
    }

    public static com.ss.android.downloadlib.addownload.a.h ok(final Context context, Uri uri, com.ss.android.downloadlib.addownload.a.n nVar) {
        com.ss.android.downloadad.api.ok.a aVar;
        if (context != null && com.ss.android.downloadlib.a.k.ok(uri)) {
            try {
                final Intent intent = new Intent("android.intent.action.VIEW", uri);
                if (!j.ok(context, intent)) {
                    return new com.ss.android.downloadlib.addownload.a.h(6, 13);
                }
                String strK = com.ss.android.socialbase.appdownloader.kf.n.k();
                if (j.n(context, strK)) {
                    intent.setPackage(strK);
                }
                intent.addFlags(335544320);
                if (com.ss.android.socialbase.downloader.h.ok.bl().a("test_jump_market_failed") == 1 && "local_test".equals(com.ss.android.downloadlib.addownload.r.k().bl)) {
                    com.ss.android.downloadlib.n.bl.ok().ok(false, "jump market error");
                    return new com.ss.android.downloadlib.addownload.a.h(6, 25);
                }
                intent.putExtra("start_only_for_android", true);
                long jOptLong = com.ss.android.downloadlib.addownload.r.q().optLong("market_jump_delay", 1000L);
                if (jOptLong > 0 && nVar != null && (aVar = nVar.n) != null && !aVar.to()) {
                    com.ss.android.downloadlib.h.ok().a().post(new Runnable() { // from class: com.ss.android.downloadlib.h.p.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.downloadlib.addownload.r.bl().ok(8, com.ss.android.downloadlib.addownload.r.getContext(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
                        }
                    });
                }
                com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.h.p.2
                    @Override // java.lang.Runnable
                    public void run() {
                        context.startActivity(intent);
                    }
                }, jOptLong);
                return new com.ss.android.downloadlib.addownload.a.h(5);
            } catch (Exception unused) {
                return new com.ss.android.downloadlib.addownload.a.h(6, 14);
            }
        }
        return new com.ss.android.downloadlib.addownload.a.h(6, 12);
    }

    public static boolean bl(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.ss.android.downloadlib.addownload.a.n nVar, JSONObject jSONObject, int i2, int i3, String str) {
        j.ok(jSONObject, "error_code", Integer.valueOf(i2));
        j.ok(jSONObject, "ttdownloader_type", Integer.valueOf(i3));
        j.ok(jSONObject, "rmu", str);
        j.ok(jSONObject, com.ss.android.socialbase.appdownloader.kf.n.k(), Integer.valueOf(j.a(com.ss.android.downloadlib.addownload.r.getContext(), com.ss.android.socialbase.appdownloader.kf.n.k())));
        com.ss.android.downloadlib.s.ok.ok().a("am_result", jSONObject, nVar);
    }

    public static com.ss.android.downloadlib.addownload.a.h a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.a.h(4, 11);
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.r.getContext();
        }
        Intent intentH = j.h(context, str);
        if (intentH == null) {
            return new com.ss.android.downloadlib.addownload.a.h(4, 22);
        }
        intentH.putExtra("start_only_for_android", true);
        try {
            context.startActivity(intentH);
            return new com.ss.android.downloadlib.addownload.a.h(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.a.h(4, 23);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String bl(String str) {
        Matcher matcher = Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
        String strGroup = matcher.find() ? matcher.group() : "";
        if (!strGroup.equals(null) && strGroup.length() > 0) {
            for (String str2 : strGroup.split("\\n")) {
                if (str2.startsWith("<input")) {
                    for (String str3 : str2.split("\\s")) {
                        if (str3.startsWith(b.f5579d)) {
                            return str3.substring(7, str3.length() - 1);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static com.ss.android.downloadlib.addownload.a.h ok(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.kf.n.h() && j.n(context, "com.sec.android.app.samsungapps")) {
                return s(context, str);
            }
            return ok(context, Uri.parse("market://details?id=" + str));
        }
        return new com.ss.android.downloadlib.addownload.a.h(6, 11);
    }

    public static com.ss.android.downloadlib.addownload.a.h a(String str, @NonNull com.ss.android.downloadad.api.ok.ok okVar) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.a.h(2, 21);
        }
        Context context = com.ss.android.downloadlib.addownload.r.getContext();
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        intent.putExtra("open_url", str);
        intent.putExtra("start_only_for_android", true);
        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_app_link_flag")) {
            intent.addFlags(67108864);
        }
        if (j.a(context, intent)) {
            if (com.ss.android.downloadlib.addownload.r.q().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.r.j() != null && com.ss.android.downloadlib.addownload.r.j().ok() && Build.VERSION.SDK_INT >= 26 && okVar.x()) {
                TTDelegateActivity.ok(str, okVar);
            } else {
                try {
                    com.ss.android.downloadlib.addownload.r.getContext().startActivity(intent);
                } catch (Exception unused) {
                    return new com.ss.android.downloadlib.addownload.a.h(2);
                }
            }
            return new com.ss.android.downloadlib.addownload.a.h(1);
        }
        return new com.ss.android.downloadlib.addownload.a.h(2, 24);
    }

    public static com.ss.android.downloadlib.addownload.a.h ok(Context context, com.ss.android.downloadlib.addownload.a.n nVar, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.kf.n.h() && j.n(context, "com.sec.android.app.samsungapps")) {
                return s(context, str);
            }
            if (nVar.f9775a.isAd() && nVar.s.enableAM()) {
                JSONArray jSONArrayOptJSONArray = com.ss.android.downloadlib.addownload.r.q().optJSONArray("am_plans");
                if (com.ss.android.socialbase.appdownloader.kf.n.n() && com.ss.android.socialbase.appdownloader.kf.ok.ok(jSONArrayOptJSONArray, "am_3")) {
                    return a(context, nVar, str);
                }
                if (com.ss.android.socialbase.appdownloader.kf.n.kf() && com.ss.android.socialbase.appdownloader.kf.ok.ok(jSONArrayOptJSONArray, "am_2")) {
                    s(context, nVar, str);
                    return new com.ss.android.downloadlib.addownload.a.h(7, "am_m2");
                }
                if (com.ss.android.socialbase.appdownloader.kf.n.s() && com.ss.android.socialbase.appdownloader.kf.ok.ok(jSONArrayOptJSONArray, "am_5")) {
                    h(context, nVar, str);
                    return new com.ss.android.downloadlib.addownload.a.h(7, "am_v1");
                }
                if (com.ss.android.socialbase.appdownloader.kf.n.n() && com.ss.android.socialbase.appdownloader.kf.ok.ok(jSONArrayOptJSONArray, "am_7")) {
                    DownloadController downloadController = nVar.s;
                    if ((downloadController instanceof AdDownloadController) && ((AdDownloadController) downloadController).enableOppoAutoDownload()) {
                        return bl(context, nVar, str);
                    }
                }
                if (com.ss.android.socialbase.appdownloader.kf.n.s() && com.ss.android.socialbase.appdownloader.kf.ok.ok(jSONArrayOptJSONArray, "am_8") && j.ok(j.bl(context, "com.bbk.appstore"), "8.7.2.0") >= 0) {
                    p(context, nVar, str);
                    return new com.ss.android.downloadlib.addownload.a.h(7, "am_v2");
                }
                if ((com.ss.android.socialbase.appdownloader.kf.n.ok() || com.ss.android.socialbase.appdownloader.kf.n.a()) && com.ss.android.socialbase.appdownloader.kf.ok.ok(jSONArrayOptJSONArray, "am_9")) {
                    n(context, nVar, str);
                    return new com.ss.android.downloadlib.addownload.a.h(7, "am_hr");
                }
                if ((com.ss.android.socialbase.appdownloader.kf.n.ok() || com.ss.android.socialbase.appdownloader.kf.n.a()) && com.ss.android.socialbase.appdownloader.kf.ok.ok(jSONArrayOptJSONArray, "am_10")) {
                    kf(context, nVar, str);
                    return new com.ss.android.downloadlib.addownload.a.h(7, "am_hr2");
                }
                return ok(context, Uri.parse("market://details?id=" + str));
            }
            return ok(context, Uri.parse("market://details?id=" + str));
        }
        return new com.ss.android.downloadlib.addownload.a.h(6, 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, @NonNull com.ss.android.downloadlib.addownload.a.n nVar, @NonNull String str, @NonNull String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.a(str, nVar.ok, str2);
        } catch (Exception unused) {
            com.ss.android.downloadlib.a.ok.ok(ok(context, Uri.parse("market://details?id=" + str)), nVar, true);
            a(nVar, jSONObject, 12, 9, "market://details?id=" + str);
        }
    }

    public static void a(@NonNull Activity activity, String str, long j, String str2) {
        com.ss.android.downloadlib.addownload.a.n nVarN = com.ss.android.downloadlib.addownload.a.kf.ok().n(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectQ = com.ss.android.downloadlib.addownload.r.q();
        String strOptString = jSONObjectQ.optString(OperatorName.CLOSE_AND_STROKE);
        String strOk = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("bz"), strOptString);
        String strOk2 = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("ca"), strOptString);
        String strOk3 = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString(PDPrintFieldAttributeObject.ROLE_CB), strOptString);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("hiapplink").authority("com.huawei.appmarket");
        if (!TextUtils.isEmpty(strOk)) {
            builder.appendQueryParameter(strOk, str2);
        }
        if (!TextUtils.isEmpty(strOk2) && !TextUtils.isEmpty(strOk3)) {
            builder.appendQueryParameter(strOk2, strOk3);
        }
        if (a(activity, builder.build())) {
            a(nVarN, jSONObject, -1, 9, "market://details?id=" + str);
            com.ss.android.downloadlib.a.ok.ok("am_hr", jSONObject, nVarN, true);
            return;
        }
        a(nVarN, jSONObject, 2, 9, "market://details?id=" + str);
        com.ss.android.downloadlib.a.ok.ok(ok((Context) activity, Uri.parse("market://details?id=" + str)), nVarN, true);
    }

    public static boolean ok(Context context, com.ss.android.downloadlib.addownload.a.n nVar, String str, JSONObject jSONObject, boolean z, int i2) {
        j.ok(jSONObject, "download_scene", Integer.valueOf(nVar.u()));
        com.ss.android.downloadlib.s.ok.ok().a("market_click_open", jSONObject, nVar);
        com.ss.android.downloadlib.addownload.a.h hVarOk = ok(context, Uri.parse(str));
        String strOk = j.ok(hVarOk.a(), "open_market");
        int type = hVarOk.getType();
        if (type == 5) {
            com.ss.android.downloadlib.a.ok.ok(strOk, jSONObject, nVar, true);
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
        if (z) {
            com.ss.android.downloadlib.s.ok.ok().ok(nVar.ok, i2);
        }
        return true;
    }

    public static void ok(Context context, String str, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.a.n nVarN = com.ss.android.downloadlib.addownload.a.kf.ok().n(j);
        try {
            JSONObject jSONObjectQ = com.ss.android.downloadlib.addownload.r.q();
            String strOptString = jSONObjectQ.optString(OperatorName.CLOSE_AND_STROKE);
            String strOk = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("aa"), strOptString);
            String strOk2 = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("ac"), strOptString);
            String strOk3 = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("af"), strOptString);
            boolean zOk = com.ss.android.socialbase.appdownloader.kf.ok.ok(jSONObjectQ, context, strOk2);
            StringBuilder sb = new StringBuilder(String.format(strOk, str, strOk3, strOk2));
            Intent intent = new Intent("android.intent.action.VIEW");
            String strK = com.ss.android.socialbase.appdownloader.kf.n.k();
            if (j.n(context, strK)) {
                intent.setPackage(strK);
            }
            if (z) {
                sb.append(com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("ae"), strOptString));
            } else {
                intent.addFlags(335544320);
            }
            j.ok(jSONObject, "mf", Boolean.valueOf(zOk));
            j.ok(jSONObject, "if", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            com.ss.android.downloadlib.a.ok.ok("am_kllk2", jSONObject, nVarN, true);
            if (zOk) {
                a(nVarN, jSONObject, -1, 3, sb.toString());
            } else {
                a(nVarN, jSONObject, 3, 3, sb.toString());
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.a.ok.ok(ok(com.ss.android.downloadlib.addownload.r.getContext(), Uri.parse("market://details?id=" + str)), nVarN, true);
            a(nVarN, jSONObject, 2, 3, "market://details?id=" + str);
        }
    }

    public static void ok(final Context context, String str, long j, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.a.n nVarN = com.ss.android.downloadlib.addownload.a.kf.ok().n(j);
        try {
            JSONObject jSONObjectQ = com.ss.android.downloadlib.addownload.r.q();
            String strOptString = jSONObjectQ.optString(OperatorName.CLOSE_AND_STROKE);
            String strOk = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("br"), strOptString);
            String strOk2 = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("bs_1"), strOptString);
            String strOk3 = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("bs_2"), strOptString);
            String strOk4 = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("bs_3"), strOptString);
            String strOk5 = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("bt"), strOptString);
            String strOk6 = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("bu"), strOptString);
            StringBuilder sb = new StringBuilder(String.format("https://", new Object[0]));
            sb.append(strOk);
            sb.append(strOk2);
            sb.append(strOk3);
            sb.append(strOk4);
            sb.append(strOk5);
            sb.append(strOk6);
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(str2);
            if (z) {
                sb.append("pkg=" + str);
                sb.append("&dl=true");
            } else {
                intent.addFlags(335544320);
            }
            j.ok(jSONObject, "dl", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra("start_only_for_android", true);
            long jOptLong = com.ss.android.downloadlib.addownload.r.q().optLong("oppo_browser_jump_delay", 1000L);
            if (jOptLong > 0) {
                com.ss.android.downloadlib.h.ok().a().post(new Runnable() { // from class: com.ss.android.downloadlib.h.p.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.ss.android.downloadlib.addownload.r.bl().ok(12, com.ss.android.downloadlib.addownload.r.getContext(), null, "正在前往浏览器下载", null, 0);
                    }
                });
            }
            com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.h.p.4
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, jOptLong);
            com.ss.android.downloadad.api.ok.a aVar = nVarN.n;
            if (aVar != null) {
                aVar.ul(true);
            }
            com.ss.android.downloadlib.a.ok.ok("am_kllk3", jSONObject, nVarN, true);
            a(nVarN, jSONObject, -1, 7, sb.toString());
        } catch (Exception unused) {
            com.ss.android.downloadad.api.ok.a aVar2 = nVarN.n;
            if (aVar2 != null) {
                aVar2.ul(false);
            }
            com.ss.android.downloadlib.a.ok.ok(ok(com.ss.android.downloadlib.addownload.r.getContext(), Uri.parse("market://details?id=" + str), nVarN), nVarN, true);
            a(nVarN, jSONObject, 2, 7, "market://details?id=" + str);
        }
    }

    private static boolean ok(@NonNull Activity activity, @NonNull String str, @NonNull HashMap<String, String> map) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + str));
        intent.putExtra("start_only_for_android", true);
        intent.putExtra("param", map);
        String strK = com.ss.android.socialbase.appdownloader.kf.n.k();
        if (j.n(com.ss.android.downloadlib.addownload.r.getContext(), strK)) {
            intent.setPackage(strK);
        }
        if (!j.ok(com.ss.android.downloadlib.addownload.r.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e2) {
            com.ss.android.downloadlib.n.bl.ok().ok(e2, "start v1");
            return false;
        }
    }

    public static void ok(@NonNull Activity activity, String str, long j, String str2, String str3) {
        JSONObject jSONObject;
        int i2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        com.ss.android.downloadlib.addownload.a.n nVarN = com.ss.android.downloadlib.addownload.a.kf.ok().n(j);
        try {
            JSONObject jSONObjectQ = com.ss.android.downloadlib.addownload.r.q();
            boolean zOk = com.ss.android.socialbase.appdownloader.kf.ok.ok(jSONObjectQ, activity, com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("bg"), jSONObjectQ.optString(OperatorName.CLOSE_AND_STROKE)));
            HashMap<String, String> mapA = j.a(new JSONObject(str2));
            if (zOk && !mapA.isEmpty() && ok(activity, str, mapA)) {
                a(nVarN, jSONObject, -1, 5, "market://details?id=" + str);
                com.ss.android.downloadlib.a.ok.ok("am_v1", jSONObject, nVarN, true);
                return;
            }
            if (zOk) {
                i2 = mapA.isEmpty() ? 1 : 2;
            } else {
                i2 = 3;
            }
            a(nVarN, jSONObject, i2, 5, "market://details?id=" + str);
            com.ss.android.downloadlib.a.ok.ok(ok((Context) activity, Uri.parse("market://details?id=" + str)), nVarN, true);
        } catch (Exception unused2) {
            com.ss.android.downloadlib.a.ok.ok(ok(com.ss.android.downloadlib.addownload.r.getContext(), Uri.parse("market://details?id=" + str)), nVarN, true);
            a(nVarN, jSONObject, 4, 5, "market://details?id=" + str);
        }
    }

    public static void ok(@NonNull Activity activity, String str, long j, String str2) {
        com.ss.android.downloadlib.addownload.a.n nVarN = com.ss.android.downloadlib.addownload.a.kf.ok().n(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectQ = com.ss.android.downloadlib.addownload.r.q();
        String strOk = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("bv"), jSONObjectQ.optString(OperatorName.CLOSE_AND_STROKE));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("market").authority("details").appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(strOk)) {
            builder.appendQueryParameter(strOk, str2);
        }
        if (ok(activity, builder.build())) {
            a(nVarN, jSONObject, -1, 8, "market://details?id=" + str);
            com.ss.android.downloadlib.a.ok.ok("am_v2", jSONObject, nVarN, true);
            return;
        }
        a(nVarN, jSONObject, 2, 8, "market://details?id=" + str);
        com.ss.android.downloadlib.a.ok.ok(ok((Context) activity, Uri.parse("market://details?id=" + str)), nVarN, true);
    }

    public static boolean ok(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String strK = com.ss.android.socialbase.appdownloader.kf.n.k();
        if (j.n(com.ss.android.downloadlib.addownload.r.getContext(), strK)) {
            intent.setPackage(strK);
        }
        if (!j.ok(com.ss.android.downloadlib.addownload.r.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e2) {
            com.ss.android.downloadlib.n.bl.ok().ok(e2, "start v2");
            return false;
        }
    }

    public static com.ss.android.downloadlib.addownload.a.h ok(Context context, String str, com.ss.android.downloadad.api.ok.ok okVar) {
        Intent intentH = j.h(context, str);
        if (intentH == null) {
            return new com.ss.android.downloadlib.addownload.a.h(4, 22);
        }
        if (Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.r.q().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.r.j() != null && com.ss.android.downloadlib.addownload.r.j().ok() && okVar.x()) {
            TTDelegateActivity.a(str, okVar);
            return new com.ss.android.downloadlib.addownload.a.h(3);
        }
        intentH.putExtra("start_only_for_android", true);
        try {
            context.startActivity(intentH);
            return new com.ss.android.downloadlib.addownload.a.h(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.a.h(4, 23);
        }
    }

    public static com.ss.android.downloadlib.addownload.a.h ok(String str, com.ss.android.downloadad.api.ok.ok okVar) {
        return ok(com.ss.android.downloadlib.addownload.r.getContext(), str, okVar);
    }

    public static com.ss.android.downloadlib.addownload.a.h ok(@NonNull com.ss.android.downloadad.api.ok.a aVar, String str, String str2) {
        com.ss.android.downloadlib.addownload.a.h hVarA = a(str, aVar);
        return (com.ss.android.downloadlib.a.kf.ok(aVar) && hVarA.getType() == 2) ? ok(str2, aVar) : hVarA;
    }

    public static void ok(@NonNull Activity activity, String str, long j) {
        com.ss.android.downloadlib.addownload.a.n nVarN = com.ss.android.downloadlib.addownload.a.kf.ok().n(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectQ = com.ss.android.downloadlib.addownload.r.q();
        String strOptString = jSONObjectQ.optString(OperatorName.CLOSE_AND_STROKE);
        String strOk = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("ca"), strOptString);
        String strOk2 = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString(AccsState.CONNECTION_CHANGE), strOptString);
        StringBuilder sb = new StringBuilder("market://details?id=");
        if (!TextUtils.isEmpty(strOk) && !TextUtils.isEmpty(strOk2)) {
            sb.append(str);
            sb.append("&");
            sb.append(strOk);
            sb.append("=");
            sb.append(strOk2);
        }
        if (bl(activity, Uri.parse(sb.toString()))) {
            a(nVarN, jSONObject, -1, 10, "market://details?id=" + str);
            com.ss.android.downloadlib.a.ok.ok("am_hr2", jSONObject, nVarN, true);
            return;
        }
        a(nVarN, jSONObject, 2, 10, "market://details?id=" + str);
        com.ss.android.downloadlib.a.ok.ok(ok((Context) activity, Uri.parse("market://details?id=" + str)), nVarN, true);
    }
}

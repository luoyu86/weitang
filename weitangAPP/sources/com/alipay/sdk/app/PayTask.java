package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.q.f;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.h;
import com.alipay.sdk.m.u.i;
import com.alipay.sdk.m.u.l;
import com.alipay.sdk.m.u.n;
import com.alipay.sdk.util.H5PayResultModel;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PayTask {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f5228h = h.class;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f5229i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f5230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.alipay.sdk.m.x.a f5231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5232c = "wappaygw.alipay.com/service/rest.htm";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5233d = "mclient.alipay.com/service/rest.htm";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5234e = "mclient.alipay.com/home/exterfaceAssign.htm";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5235f = "mclient.alipay.com/cashier/mobilepay.htm";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, c> f5236g = new HashMap();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f5238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ H5PayCallback f5239c;

        public a(String str, boolean z, H5PayCallback h5PayCallback) {
            this.f5237a = str;
            this.f5238b = z;
            this.f5239c = h5PayCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            H5PayResultModel h5PayResultModelH5Pay = PayTask.this.h5Pay(new com.alipay.sdk.m.s.a(PayTask.this.f5230a, this.f5237a, "payInterceptorWithUrl"), this.f5237a, this.f5238b);
            e.d(com.alipay.sdk.m.l.a.A, "inc finished: " + h5PayResultModelH5Pay.getResultCode());
            this.f5239c.onPayResult(h5PayResultModelH5Pay);
        }
    }

    public class b implements h.g {
        public b() {
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void a() {
            PayTask.this.dismissLoading();
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void b() {
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f5244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f5245d;

        public c() {
            this.f5242a = "";
            this.f5243b = "";
            this.f5244c = "";
            this.f5245d = "";
        }

        public String a() {
            return this.f5244c;
        }

        public String b() {
            return this.f5242a;
        }

        public String c() {
            return this.f5243b;
        }

        public String d() {
            return this.f5245d;
        }

        public void a(String str) {
            this.f5244c = str;
        }

        public void b(String str) {
            this.f5242a = str;
        }

        public void c(String str) {
            this.f5243b = str;
        }

        public void d(String str) {
            this.f5245d = str;
        }

        public /* synthetic */ c(PayTask payTask, a aVar) {
            this();
        }
    }

    public PayTask(Activity activity) {
        this.f5230a = activity;
        com.alipay.sdk.m.s.b.d().a(this.f5230a);
        this.f5231b = new com.alipay.sdk.m.x.a(activity, com.alipay.sdk.m.x.a.j);
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        try {
            com.alipay.sdk.m.s.b.d().a(context);
            long jElapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            if (jElapsedRealtime - f5229i < com.alipay.sdk.m.m.a.D().d()) {
                return false;
            }
            f5229i = jElapsedRealtime;
            com.alipay.sdk.m.m.a.D().a(com.alipay.sdk.m.s.a.h(), context.getApplicationContext(), false, 4);
            return true;
        } catch (Exception e2) {
            e.a(e2);
            return false;
        }
    }

    public void dismissLoading() {
        com.alipay.sdk.m.x.a aVar = this.f5231b;
        if (aVar != null) {
            aVar.a();
            this.f5231b = null;
        }
    }

    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strTrim = str.trim();
                if (strTrim.startsWith("https://wappaygw.alipay.com/service/rest.htm") || strTrim.startsWith("http://wappaygw.alipay.com/service/rest.htm")) {
                    String strTrim2 = strTrim.replaceFirst("(http|https)://wappaygw.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(strTrim2)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + n.a("<request_token>", "</request_token>", n.b(strTrim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.f5230a) + "\"";
                    }
                }
                if (strTrim.startsWith("https://mclient.alipay.com/service/rest.htm") || strTrim.startsWith("http://mclient.alipay.com/service/rest.htm")) {
                    String strTrim3 = strTrim.replaceFirst("(http|https)://mclient.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(strTrim3)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + n.a("<request_token>", "</request_token>", n.b(strTrim3).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.f5230a) + "\"";
                    }
                }
                if ((strTrim.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm") || strTrim.startsWith("http://mclient.alipay.com/home/exterfaceAssign.htm")) && ((strTrim.contains("alipay.wap.create.direct.pay.by.user") || strTrim.contains("create_forex_trade_wap")) && !TextUtils.isEmpty(strTrim.replaceFirst("(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?", "").trim()))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(AgooConstants.OPEN_URL, str);
                    jSONObject.put("bizcontext", a(this.f5230a));
                    return com.alipay.sdk.m.s.a.C + jSONObject.toString();
                }
                a aVar = null;
                if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                    String strA = n.a("?", "", str);
                    if (!TextUtils.isEmpty(strA)) {
                        Map<String, String> mapB = n.b(strA);
                        StringBuilder sb = new StringBuilder();
                        if (a(false, true, com.alipay.sdk.m.k.b.B0, sb, mapB, com.alipay.sdk.m.k.b.B0, "alipay_trade_no")) {
                            a(true, false, "pay_phase_id", sb, mapB, "payPhaseId", "pay_phase_id", "out_relation_id");
                            sb.append("&biz_sub_type=\"TRADE\"");
                            sb.append("&biz_type=\"trade\"");
                            String str2 = mapB.get("app_name");
                            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(mapB.get("cid"))) {
                                str2 = "ali1688";
                            } else if (TextUtils.isEmpty(str2) && (!TextUtils.isEmpty(mapB.get("sid")) || !TextUtils.isEmpty(mapB.get("s_id")))) {
                                str2 = "tb";
                            }
                            sb.append("&app_name=\"" + str2 + "\"");
                            if (!a(true, true, "extern_token", sb, mapB, "extern_token", "cid", "sid", "s_id")) {
                                return "";
                            }
                            a(true, false, "appenv", sb, mapB, "appenv");
                            sb.append("&pay_channel_id=\"alipay_sdk\"");
                            c cVar = new c(this, aVar);
                            cVar.b(mapB.get("return_url"));
                            cVar.c(mapB.get("show_url"));
                            cVar.a(mapB.get("pay_order_id"));
                            String str3 = sb.toString() + "&bizcontext=\"" + a(this.f5230a) + "\"";
                            this.f5236g.put(str3, cVar);
                            return str3;
                        }
                    }
                }
                if (!strTrim.startsWith("https://mclient.alipay.com/cashier/mobilepay.htm") && !strTrim.startsWith("http://mclient.alipay.com/cashier/mobilepay.htm") && (!EnvUtils.isSandBox() || !strTrim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                    if (com.alipay.sdk.m.m.a.D().h() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(strTrim).find()) {
                        Uri uri = Uri.parse(strTrim);
                        String queryParameter = uri.getQueryParameter("return_url");
                        String queryParameter2 = uri.getQueryParameter("show_url");
                        String queryParameter3 = uri.getQueryParameter("pay_order_id");
                        String strA2 = a(uri.getQueryParameter("trade_nos"), uri.getQueryParameter("alipay_trade_no"));
                        String strA3 = a(uri.getQueryParameter("payPhaseId"), uri.getQueryParameter("pay_phase_id"), uri.getQueryParameter("out_relation_id"));
                        String[] strArr = new String[4];
                        strArr[0] = uri.getQueryParameter("app_name");
                        strArr[1] = !TextUtils.isEmpty(uri.getQueryParameter("cid")) ? "ali1688" : "";
                        strArr[2] = !TextUtils.isEmpty(uri.getQueryParameter("sid")) ? "tb" : "";
                        strArr[3] = !TextUtils.isEmpty(uri.getQueryParameter("s_id")) ? "tb" : "";
                        String strA4 = a(strArr);
                        String strA5 = a(uri.getQueryParameter("extern_token"), uri.getQueryParameter("cid"), uri.getQueryParameter("sid"), uri.getQueryParameter("s_id"));
                        String strA6 = a(uri.getQueryParameter("appenv"));
                        if (!TextUtils.isEmpty(strA2) && !TextUtils.isEmpty(strA4) && !TextUtils.isEmpty(strA5)) {
                            String str4 = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", strA2, strA3, strA4, strA5, strA6, a(this.f5230a));
                            c cVar2 = new c(this, null);
                            cVar2.b(queryParameter);
                            cVar2.c(queryParameter2);
                            cVar2.a(queryParameter3);
                            cVar2.d(strA2);
                            this.f5236g.put(str4, cVar2);
                            return str4;
                        }
                    }
                }
                String strA7 = a(this.f5230a);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(AgooConstants.OPEN_URL, strTrim);
                jSONObject2.put("bizcontext", strA7);
                return String.format("new_external_info==%s", jSONObject2.toString());
            }
        } catch (Throwable th) {
            e.a(th);
        }
        return "";
    }

    public synchronized String fetchTradeToken() {
        return i.a(new com.alipay.sdk.m.s.a(this.f5230a, "", "fetchTradeToken"), this.f5230a.getApplicationContext());
    }

    public String getVersion() {
        return "15.8.15";
    }

    public synchronized H5PayResultModel h5Pay(com.alipay.sdk.m.s.a aVar, String str, boolean z) {
        H5PayResultModel h5PayResultModel;
        h5PayResultModel = new H5PayResultModel();
        try {
            String[] strArrSplit = a(aVar, str, z).split(i.f5697b);
            HashMap map = new HashMap();
            for (String str2 : strArrSplit) {
                int iIndexOf = str2.indexOf("={");
                if (iIndexOf >= 0) {
                    String strSubstring = str2.substring(0, iIndexOf);
                    map.put(strSubstring, a(str2, strSubstring));
                }
            }
            if (map.containsKey(l.f5707a)) {
                h5PayResultModel.setResultCode(map.get(l.f5707a));
            }
            h5PayResultModel.setReturnUrl(a(str, map));
            if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.n0, "");
            }
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.o0, th);
            e.a(th);
        }
        return h5PayResultModel;
    }

    public synchronized String pay(String str, boolean z) {
        if (com.alipay.sdk.m.u.b.a()) {
            return com.alipay.sdk.m.j.b.b();
        }
        return a(new com.alipay.sdk.m.s.a(this.f5230a, str, "pay"), str, z);
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        String strFetchOrderInfoFromH5PayUrl;
        strFetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(strFetchOrderInfoFromH5PayUrl)) {
            e.d(com.alipay.sdk.m.l.a.A, "intercepted: " + strFetchOrderInfoFromH5PayUrl);
            new Thread(new a(strFetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(strFetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        String strA;
        com.alipay.sdk.m.s.a aVar;
        if (com.alipay.sdk.m.u.b.a()) {
            aVar = null;
            strA = com.alipay.sdk.m.j.b.b();
        } else {
            com.alipay.sdk.m.s.a aVar2 = new com.alipay.sdk.m.s.a(this.f5230a, str, "payV2");
            strA = a(aVar2, str, z);
            aVar = aVar2;
        }
        return l.a(aVar, strA);
    }

    public void showLoading() {
        com.alipay.sdk.m.x.a aVar = this.f5231b;
        if (aVar != null) {
            aVar.d();
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0043 A[Catch: all -> 0x01fc, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050 A[Catch: all -> 0x01fc, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0057 A[Catch: all -> 0x01fc, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x015f A[Catch: all -> 0x01fc, PHI: r9
  0x015f: PHI (r9v18 java.lang.String) = (r9v17 java.lang.String), (r9v20 java.lang.String) binds: [B:34:0x015d, B:29:0x0107] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f A[Catch: all -> 0x01fc, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized java.lang.String a(com.alipay.sdk.m.s.a r7, java.lang.String r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 511
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(com.alipay.sdk.m.s.a, java.lang.String, boolean):java.lang.String");
    }

    public static String a(Context context) {
        String str;
        String str2;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName;
            try {
                str2 = packageInfo.packageName;
            } catch (Exception e2) {
                e = e2;
                e.a(e);
                str2 = "";
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", com.alipay.sdk.m.l.a.f5442g);
            jSONObject.put(com.alipay.sdk.m.s.a.s, "and_lite");
            jSONObject.put("sv", "h.a.3.8.15");
            jSONObject.put(com.alipay.sdk.m.s.a.u, str2);
            jSONObject.put(com.alipay.sdk.m.s.a.w, str);
            jSONObject.put(com.alipay.sdk.m.s.a.x, System.currentTimeMillis());
            if (!TextUtils.isEmpty(OperatorName.NON_STROKING_COLOR)) {
                jSONObject.put(OperatorName.NON_STROKING_COLOR, "h5tonative");
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            e.a(th);
            return "";
        }
    }

    public static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    private boolean a(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i2];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str2)) {
            return !z2;
        }
        if (z) {
            sb.append("&");
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        }
        sb.append(str);
        sb.append("=\"");
        sb.append(str2);
        sb.append("\"");
        return true;
    }

    private String a(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean zEquals = "9000".equals(map.get(l.f5707a));
        String str2 = map.get("result");
        c cVarRemove = this.f5236g.remove(str);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String strA = a(n.a("&callBackUrl=\"", "\"", str2), n.a("&call_back_url=\"", "\"", str2), n.a(com.alipay.sdk.m.l.a.u, "\"", str2), URLDecoder.decode(n.a(com.alipay.sdk.m.l.a.v, "&", str2), "utf-8"), URLDecoder.decode(n.a("&callBackUrl=", "&", str2), "utf-8"), n.a("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        if (cVarRemove != null) {
            String strB = zEquals ? cVarRemove.b() : cVarRemove.c();
            if (!TextUtils.isEmpty(strB)) {
                return strB;
            }
        }
        return cVarRemove != null ? com.alipay.sdk.m.m.a.D().r() : "";
    }

    private String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(i.f5699d));
    }

    private h.g a() {
        return new b();
    }

    private String a(String str, com.alipay.sdk.m.s.a aVar) {
        String strA = aVar.a(str);
        if (strA.contains("paymethod=\"expressGateway\"")) {
            return a(aVar, strA);
        }
        List<a.b> listL = com.alipay.sdk.m.m.a.D().l();
        if (!com.alipay.sdk.m.m.a.D().f5491h || listL == null) {
            listL = com.alipay.sdk.m.j.a.f5387d;
        }
        if (n.a(aVar, (Context) this.f5230a, listL, true)) {
            h hVar = new h(this.f5230a, aVar, a());
            e.d(com.alipay.sdk.m.l.a.A, "pay inner started: " + strA);
            String strA2 = hVar.a(strA, false);
            if (!TextUtils.isEmpty(strA2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("resultStatus={");
                com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.ACTIVITY_NOT_START_EXIT;
                sb.append(cVar.b());
                sb.append(i.f5699d);
                if (strA2.contains(sb.toString())) {
                    n.a("alipaySdk", com.alipay.sdk.m.l.b.f5455q, this.f5230a, aVar);
                    if (com.alipay.sdk.m.m.a.D().A()) {
                        strA2 = hVar.a(strA, true);
                    } else {
                        strA2 = strA2.replace("resultStatus={" + cVar.b() + i.f5699d, "resultStatus={" + com.alipay.sdk.m.j.c.CANCELED.b() + i.f5699d);
                    }
                }
            }
            e.d(com.alipay.sdk.m.l.a.A, "pay inner raw result: " + strA2);
            hVar.a();
            boolean zW = com.alipay.sdk.m.m.a.D().w();
            if (!TextUtils.equals(strA2, h.j) && !TextUtils.equals(strA2, h.k) && (!zW || !aVar.e())) {
                if (TextUtils.isEmpty(strA2)) {
                    return com.alipay.sdk.m.j.b.a();
                }
                if (!strA2.contains(PayResultActivity.f5216b)) {
                    return strA2;
                }
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.k0);
                return a(aVar, strA, listL, strA2, this.f5230a);
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.i0);
            return a(aVar, strA);
        }
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.j0);
        return a(aVar, strA);
    }

    public static String a(com.alipay.sdk.m.s.a aVar, String str, List<a.b> list, String str2, Activity activity) {
        n.c cVarA = n.a(aVar, activity, list);
        if (cVarA == null || cVarA.a(aVar) || cVarA.a() || !TextUtils.equals(cVarA.f5723a.packageName, "hk.alipay.wallet")) {
            return str2;
        }
        e.b(com.alipay.sdk.m.l.a.A, "PayTask not_login");
        String strValueOf = String.valueOf(str.hashCode());
        Object obj = new Object();
        HashMap<String, Object> map = PayResultActivity.f5217c;
        map.put(strValueOf, obj);
        Intent intent = new Intent(activity, (Class<?>) PayResultActivity.class);
        intent.putExtra(PayResultActivity.f5220f, str);
        intent.putExtra(PayResultActivity.f5221g, activity.getPackageName());
        intent.putExtra(PayResultActivity.f5219e, strValueOf);
        a.C0089a.a(aVar, intent);
        activity.startActivity(intent);
        synchronized (map.get(strValueOf)) {
            try {
                e.b(com.alipay.sdk.m.l.a.A, "PayTask wait");
                map.get(strValueOf).wait();
            } catch (InterruptedException unused) {
                e.b(com.alipay.sdk.m.l.a.A, "PayTask interrupted");
                return com.alipay.sdk.m.j.b.a();
            }
        }
        String str3 = PayResultActivity.b.f5227b;
        e.b(com.alipay.sdk.m.l.a.A, "PayTask ret: " + str3);
        return str3;
    }

    private String a(com.alipay.sdk.m.s.a aVar, String str) {
        showLoading();
        com.alipay.sdk.m.j.c cVarB = null;
        try {
            try {
                try {
                    JSONObject jSONObjectC = new f().a(aVar, this.f5230a.getApplicationContext(), str).c();
                    String strOptString = jSONObjectC.optString("end_code", null);
                    List<com.alipay.sdk.m.r.b> listA = com.alipay.sdk.m.r.b.a(jSONObjectC.optJSONObject(com.alipay.sdk.m.l.c.f5458c).optJSONObject(com.alipay.sdk.m.l.c.f5459d));
                    for (int i2 = 0; i2 < listA.size(); i2++) {
                        if (listA.get(i2).a() == com.alipay.sdk.m.r.a.Update) {
                            com.alipay.sdk.m.r.b.a(listA.get(i2));
                        }
                    }
                    a(aVar, jSONObjectC);
                    dismissLoading();
                    com.alipay.sdk.m.k.a.a(this.f5230a, aVar, str, aVar.f5636d);
                    for (int i3 = 0; i3 < listA.size(); i3++) {
                        com.alipay.sdk.m.r.b bVar = listA.get(i3);
                        if (bVar.a() == com.alipay.sdk.m.r.a.WapPay) {
                            String strA = a(aVar, bVar);
                            dismissLoading();
                            com.alipay.sdk.m.k.a.a(this.f5230a, aVar, str, aVar.f5636d);
                            return strA;
                        }
                        if (bVar.a() == com.alipay.sdk.m.r.a.OpenWeb) {
                            String strA2 = a(aVar, bVar, strOptString);
                            dismissLoading();
                            com.alipay.sdk.m.k.a.a(this.f5230a, aVar, str, aVar.f5636d);
                            return strA2;
                        }
                    }
                    dismissLoading();
                    com.alipay.sdk.m.k.a.a(this.f5230a, aVar, str, aVar.f5636d);
                } catch (Throwable th) {
                    e.a(th);
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, th);
                    dismissLoading();
                    com.alipay.sdk.m.k.a.a(this.f5230a, aVar, str, aVar.f5636d);
                }
            } catch (IOException e2) {
                com.alipay.sdk.m.j.c cVarB2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.NETWORK_ERROR.b());
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.k, e2);
                dismissLoading();
                com.alipay.sdk.m.k.a.a(this.f5230a, aVar, str, aVar.f5636d);
                cVarB = cVarB2;
            }
            if (cVarB == null) {
                cVarB = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.FAILED.b());
            }
            return com.alipay.sdk.m.j.b.a(cVarB.b(), cVarB.a(), "");
        } catch (Throwable th2) {
            dismissLoading();
            com.alipay.sdk.m.k.a.a(this.f5230a, aVar, str, aVar.f5636d);
            throw th2;
        }
    }

    private void a(com.alipay.sdk.m.s.a aVar, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("tid");
            String strOptString2 = jSONObject.optString(com.alipay.sdk.m.t.a.j);
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                return;
            }
            com.alipay.sdk.m.t.a.a(com.alipay.sdk.m.s.b.d().b()).a(strOptString, strOptString2);
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.P, th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
    
        r0 = r6.c();
        r11 = com.alipay.sdk.m.j.b.a(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], com.alipay.sdk.m.u.n.e(r10, r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(com.alipay.sdk.m.s.a r10, com.alipay.sdk.m.r.b r11, java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(com.alipay.sdk.m.s.a, com.alipay.sdk.m.r.b, java.lang.String):java.lang.String");
    }

    private String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.r.b bVar) {
        String[] strArrC = bVar.c();
        Intent intent = new Intent(this.f5230a, (Class<?>) H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(AgooConstants.OPEN_URL, strArrC[0]);
        if (strArrC.length == 2) {
            bundle.putString("cookie", strArrC[1]);
        }
        intent.putExtras(bundle);
        a.C0089a.a(aVar, intent);
        this.f5230a.startActivity(intent);
        Object obj = f5228h;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e2) {
                e.a(e2);
                return com.alipay.sdk.m.j.b.a();
            }
        }
        String strD = com.alipay.sdk.m.j.b.d();
        return TextUtils.isEmpty(strD) ? com.alipay.sdk.m.j.b.a() : strD;
    }
}

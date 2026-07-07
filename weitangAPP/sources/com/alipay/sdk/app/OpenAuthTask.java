package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.taobao.accs.common.Constants;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class OpenAuthTask {
    public static final int Duplex = 5000;
    public static final int NOT_INSTALLED = 4001;
    public static final int OK = 9000;
    public static final int SYS_ERR = 4000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Callback> f5204e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f5205f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5206g = 122;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f5208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Callback f5209c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f5207a = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f5210d = new Handler(Looper.getMainLooper());

    public enum BizType {
        Invoice("20000920"),
        AccountAuth("20000067"),
        Deduct("60000157");

        public String appId;

        BizType(String str) {
            this.appId = str;
        }
    }

    public interface Callback {
        void onResult(int i2, String str, Bundle bundle);
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5211a;

        static {
            int[] iArr = new int[BizType.values().length];
            f5211a = iArr;
            try {
                iArr[BizType.Deduct.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5211a[BizType.AccountAuth.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5211a[BizType.Invoice.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f5213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f5214c;

        public /* synthetic */ b(OpenAuthTask openAuthTask, int i2, String str, Bundle bundle, a aVar) {
            this(i2, str, bundle);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OpenAuthTask.this.f5209c != null) {
                OpenAuthTask.this.f5209c.onResult(this.f5212a, this.f5213b, this.f5214c);
            }
        }

        public b(int i2, String str, Bundle bundle) {
            this.f5212a = i2;
            this.f5213b = str;
            this.f5214c = bundle;
        }
    }

    public OpenAuthTask(Activity activity) {
        this.f5208b = activity;
        com.alipay.sdk.m.s.b.d().a(activity);
    }

    public void execute(String str, BizType bizType, Map<String, String> map, Callback callback, boolean z) {
        com.alipay.sdk.m.s.a aVar = new com.alipay.sdk.m.s.a(this.f5208b, String.valueOf(map), "oa-" + bizType);
        this.f5209c = callback;
        if (a(aVar, str, bizType, map, z)) {
            com.alipay.sdk.m.k.a.b(this.f5208b, aVar, "", aVar.f5636d);
        }
    }

    private boolean a(com.alipay.sdk.m.s.a aVar, String str, BizType bizType, Map<String, String> map, boolean z) {
        PackageInfo packageInfo;
        if (this.f5207a) {
            this.f5210d.post(new b(this, 4000, "该 OpenAuthTask 已在执行", null, null));
            return true;
        }
        this.f5207a = true;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - f5205f <= 3000) {
            this.f5210d.post(new b(this, 5000, "3s 内重复支付", null, null));
            return true;
        }
        f5205f = jElapsedRealtime;
        com.alipay.sdk.m.j.a.a("");
        String strA = n.a(32);
        HashMap map2 = new HashMap(map);
        map2.put("mqpPkgName", this.f5208b.getPackageName());
        map2.put("mqpScene", "sdk");
        List<a.b> listL = com.alipay.sdk.m.m.a.D().l();
        if (!com.alipay.sdk.m.m.a.D().f5491h || listL == null) {
            listL = com.alipay.sdk.m.j.a.f5387d;
        }
        n.c cVarA = n.a(aVar, this.f5208b, listL);
        if (cVarA == null || cVarA.a(aVar) || cVarA.a() || (packageInfo = cVarA.f5723a) == null || packageInfo.versionCode < 122) {
            if (!z) {
                this.f5210d.post(new b(this, 4001, "支付宝未安装或签名错误", null, null));
                return true;
            }
            map2.put("mqpScheme", String.valueOf(str));
            map2.put("mqpNotifyName", strA);
            map2.put("mqpScene", "landing");
            String strA2 = a(bizType, map2);
            Intent intent = new Intent(this.f5208b, (Class<?>) H5OpenAuthActivity.class);
            intent.putExtra(AgooConstants.OPEN_URL, String.format("https://render.alipay.com/p/s/i?scheme=%s", Uri.encode(strA2)));
            a.C0089a.a(aVar, intent);
            this.f5208b.startActivity(intent);
            return false;
        }
        try {
            try {
                HashMap<String, String> mapA = com.alipay.sdk.m.s.a.a(aVar);
                mapA.put("ts_scheme", String.valueOf(SystemClock.elapsedRealtime()));
                map2.put("mqpLoc", new JSONObject(mapA).toString());
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "OpenAuthLocEx", th);
            }
            String strA3 = a(bizType, map2);
            f5204e.put(strA, this.f5209c);
            String strA4 = null;
            try {
                strA4 = a(jElapsedRealtime, strA, bizType, strA3);
            } catch (JSONException e2) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.q0, e2);
            }
            String str2 = strA4;
            if (TextUtils.isEmpty(str2)) {
                this.f5210d.post(new b(this, 4000, "参数错误", null, null));
                return true;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW", new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", "20001129").appendQueryParameter("payload", str2).build());
            intent2.addFlags(268435456);
            intent2.setPackage(cVarA.f5723a.packageName);
            try {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.Y, "" + jElapsedRealtime);
                a.C0089a.a(aVar, strA);
                this.f5208b.startActivity(intent2);
            } catch (Throwable th2) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "StartWalletEx", th2);
            }
            return false;
        } catch (Throwable unused) {
            this.f5210d.post(new b(this, 4000, "业务参数错误", null, null));
            return true;
        }
    }

    private String a(BizType bizType, Map<String, String> map) {
        if (bizType != null) {
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", bizType.appId);
            if (a.f5211a[bizType.ordinal()] == 1) {
                builderAppendQueryParameter.appendQueryParameter("appClearTop", "false").appendQueryParameter("startMultApp", "YES");
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builderAppendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            return builderAppendQueryParameter.build().toString();
        }
        throw new RuntimeException("missing bizType");
    }

    private String a(long j, String str, BizType bizType, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("startTime", String.valueOf(j));
        jSONObject.put("session", str);
        jSONObject.put(AbsServerManager.PACKAGE_QUERY_BINDER, this.f5208b.getPackageName());
        if (bizType != null) {
            jSONObject.put("appId", bizType.appId);
        }
        jSONObject.put(Constants.KEY_SDK_VERSION, "h.a.3.8.15");
        jSONObject.put("mqpURL", str2);
        return Base64.encodeToString(jSONObject.toString().getBytes(Charset.forName("UTF-8")), 2);
    }

    public static void a(String str, int i2, String str2, Bundle bundle) {
        Callback callbackRemove = f5204e.remove(str);
        if (callbackRemove != null) {
            try {
                callbackRemove.onResult(i2, str2, bundle);
            } catch (Throwable th) {
                e.a(th);
            }
        }
    }
}

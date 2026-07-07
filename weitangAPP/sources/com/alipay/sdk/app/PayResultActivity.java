package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class PayResultActivity extends Activity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5216b = "{\"isLogin\":\"false\"}";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, Object> f5217c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5218d = "hk.alipay.wallet";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5219e = "phonecashier.pay.hash";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5220f = "orderSuffix";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5221g = "externalPkgName";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f5222h = "phonecashier.pay.result";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f5223i = "phonecashier.pay.resultOrderHash";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.alipay.sdk.m.s.a f5224a = null;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f5225a;

        public a(Activity activity) {
            this.f5225a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5225a.finish();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static volatile String f5226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static volatile String f5227b;
    }

    public static void a(Activity activity, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent();
        try {
            intent.setPackage("hk.alipay.wallet");
            intent.setData(Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + URLEncoder.encode(str, "UTF-8") + "&orderSuffix=" + URLEncoder.encode(str2, "UTF-8") + "&packageName=" + URLEncoder.encode(str3, "UTF-8") + "&externalPkgName=" + URLEncoder.encode(str3, "UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            e.a(e2);
        }
        if (activity != null) {
            try {
                activity.startActivity(intent);
            } catch (Throwable unused) {
                activity.finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (!TextUtils.isEmpty(intent.getStringExtra(f5220f))) {
                b.f5226a = intent.getStringExtra(f5219e);
                String stringExtra = intent.getStringExtra(f5220f);
                String stringExtra2 = intent.getStringExtra(f5221g);
                com.alipay.sdk.m.s.a aVarA = a.C0089a.a(intent);
                this.f5224a = aVarA;
                if (aVarA == null) {
                    finish();
                }
                a(this, b.f5226a, stringExtra, stringExtra2);
                a(this, 300);
                return;
            }
            if (this.f5224a == null) {
                finish();
            }
            String stringExtra3 = intent.getStringExtra(f5222h);
            int intExtra = intent.getIntExtra(f5223i, 0);
            if (intExtra != 0 && TextUtils.equals(b.f5226a, String.valueOf(intExtra))) {
                if (TextUtils.isEmpty(stringExtra3)) {
                    a(b.f5226a);
                } else {
                    a(stringExtra3, b.f5226a);
                }
                b.f5226a = "";
                a(this, 300);
                return;
            }
            com.alipay.sdk.m.k.a.b(this.f5224a, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.l0, "Expected " + b.f5226a + ", got " + intExtra);
            a(b.f5226a);
            a(this, 300);
        } catch (Throwable unused) {
            finish();
        }
    }

    public static void a(String str) {
        b.f5227b = com.alipay.sdk.m.j.b.a();
        a(f5217c, str);
    }

    public static void a(String str, String str2) {
        b.f5227b = str;
        a(f5217c, str2);
    }

    public static void a(Activity activity, int i2) {
        new Handler().postDelayed(new a(activity), i2);
    }

    public static boolean a(HashMap<String, Object> map, String str) {
        Object obj;
        if (map == null || str == null || (obj = map.get(str)) == null) {
            return false;
        }
        synchronized (obj) {
            obj.notifyAll();
        }
        return true;
    }
}

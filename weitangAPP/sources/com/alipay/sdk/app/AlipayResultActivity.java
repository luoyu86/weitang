package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.l;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AlipayResultActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f5190a = new ConcurrentHashMap<>();

    public interface a {
        void a(int i2, String str, String str2);
    }

    private void a(String str, Bundle bundle) {
        a aVarRemove = f5190a.remove(str);
        if (aVarRemove == null) {
            return;
        }
        try {
            aVarRemove.a(bundle.getInt("endCode"), bundle.getString(l.f5708b), bundle.getString("result"));
        } finally {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Throwable th;
        JSONObject jSONObject;
        Bundle bundle2;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            try {
                String stringExtra = intent.getStringExtra("session");
                Bundle bundleExtra = intent.getBundleExtra("result");
                String stringExtra2 = intent.getStringExtra("scene");
                com.alipay.sdk.m.s.a aVarA = a.C0089a.a(stringExtra);
                if (aVarA == null) {
                    finish();
                    return;
                }
                com.alipay.sdk.m.k.a.a(aVarA, b.l, "BSPSession", stringExtra + "|" + SystemClock.elapsedRealtime());
                if (TextUtils.equals("mqpSchemePay", stringExtra2)) {
                    a(stringExtra, bundleExtra);
                    return;
                }
                if ((TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(new String(Base64.decode(intent.getData().getQuery(), 2), "UTF-8"));
                        jSONObject = jSONObject2.getJSONObject("result");
                        stringExtra = jSONObject2.getString("session");
                        com.alipay.sdk.m.k.a.a(aVarA, b.l, "BSPUriSession", stringExtra);
                        bundle2 = new Bundle();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            bundle2.putString(next, jSONObject.getString(next));
                        }
                        bundleExtra = bundle2;
                    } catch (Throwable th3) {
                        th = th3;
                        bundleExtra = bundle2;
                        com.alipay.sdk.m.k.a.a(aVarA, b.l, "BSPResEx", th);
                        com.alipay.sdk.m.k.a.a(aVarA, b.l, b.s0, th);
                    }
                }
                if (TextUtils.isEmpty(stringExtra) || bundleExtra == null) {
                    com.alipay.sdk.m.k.a.b(this, aVarA, "", aVarA.f5636d);
                    finish();
                    return;
                }
                try {
                    com.alipay.sdk.m.k.a.a(aVarA, b.l, b.V, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.k.a.a(aVarA, b.l, b.W, bundleExtra.getInt("endCode", -1) + "|" + bundleExtra.getString(l.f5708b, "-"));
                    OpenAuthTask.a(stringExtra, 9000, "OK", bundleExtra);
                    com.alipay.sdk.m.k.a.b(this, aVarA, "", aVarA.f5636d);
                    finish();
                } catch (Throwable th4) {
                    com.alipay.sdk.m.k.a.b(this, aVarA, "", aVarA.f5636d);
                    finish();
                    throw th4;
                }
            } catch (Throwable th5) {
                com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) null, b.l, "BSPSerError", th5);
                com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) null, b.l, b.r0, th5);
                finish();
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}

package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.s.a;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class APayEntranceActivity extends Activity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5182d = "ap_order_info";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5183e = "ap_target_packagename";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5184f = "ap_session";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5185g = "ap_local_info";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f5186h = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.alipay.sdk.m.s.a f5189c;

    public interface a {
        void a(String str);
    }

    @Override // android.app.Activity
    public void finish() {
        String str = this.f5188b;
        com.alipay.sdk.m.k.a.a(this.f5189c, b.l, "BSAFinish", str + "|" + TextUtils.isEmpty(this.f5187a));
        if (TextUtils.isEmpty(this.f5187a)) {
            this.f5187a = com.alipay.sdk.m.j.b.a();
            com.alipay.sdk.m.s.a aVar = this.f5189c;
            if (aVar != null) {
                aVar.b(true);
            }
        }
        if (str != null) {
            a aVarRemove = f5186h.remove(str);
            if (aVarRemove != null) {
                aVarRemove.a(this.f5187a);
            } else {
                com.alipay.sdk.m.k.a.b(this.f5189c, "wr", "refNull", "session=" + str);
            }
        }
        try {
            super.finish();
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(this.f5189c, "wr", "APStartFinish", th);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        com.alipay.sdk.m.k.a.a(this.f5189c, b.l, "BSAOnAR", this.f5188b + "|" + i2 + "," + i3);
        if (i2 == 1000) {
            if (intent != null) {
                try {
                    this.f5187a = intent.getStringExtra("result");
                } catch (Throwable unused) {
                }
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            String string = extras.getString(f5182d);
            String string2 = extras.getString(f5183e);
            this.f5188b = extras.getString(f5184f);
            String string3 = extras.getString(f5185g, "{}");
            if (!TextUtils.isEmpty(this.f5188b)) {
                com.alipay.sdk.m.s.a aVarA = a.C0089a.a(this.f5188b);
                this.f5189c = aVarA;
                com.alipay.sdk.m.k.a.a(aVarA, b.l, "BSAEntryCreate", this.f5188b + "|" + SystemClock.elapsedRealtime());
            }
            Intent intent = new Intent();
            intent.putExtra("order_info", string);
            intent.putExtra("localInfo", string3);
            intent.setClassName(string2, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            try {
                startActivityForResult(intent, 1000);
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(this.f5189c, "wr", "APStartEx", th);
                finish();
            }
            if (this.f5189c != null) {
                Context applicationContext = getApplicationContext();
                com.alipay.sdk.m.s.a aVar = this.f5189c;
                com.alipay.sdk.m.k.a.a(applicationContext, aVar, string, aVar.f5636d);
                this.f5189c.a(true);
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}

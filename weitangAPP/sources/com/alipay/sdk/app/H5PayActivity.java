package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alipay.sdk.m.j.b;
import com.alipay.sdk.m.j.d;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import com.alipay.sdk.m.x.c;
import java.lang.ref.WeakReference;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class H5PayActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f5196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference<a> f5203h;

    private void b() {
        try {
            super.requestWindowFeature(1);
            getWindow().addFlags(8192);
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public void a() {
        Object obj = PayTask.f5228h;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        a();
        super.finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1010) {
            d.a((a) n.a(this.f5203h), i2, i3, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        c cVar = this.f5196a;
        if (cVar == null) {
            finish();
            return;
        }
        if (cVar.a()) {
            cVar.b();
            return;
        }
        if (!cVar.b()) {
            super.onBackPressed();
        }
        b.a(b.a());
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            a aVarA = a.C0089a.a(getIntent());
            if (aVarA == null) {
                finish();
                return;
            }
            this.f5203h = new WeakReference<>(aVarA);
            if (com.alipay.sdk.m.m.a.D().y()) {
                setRequestedOrientation(3);
            } else {
                setRequestedOrientation(1);
            }
            try {
                Bundle extras = getIntent().getExtras();
                String string = extras.getString(AgooConstants.OPEN_URL, null);
                this.f5197b = string;
                if (!n.f(string)) {
                    finish();
                    return;
                }
                this.f5199d = extras.getString("cookie", null);
                this.f5198c = extras.getString(com.alipay.sdk.m.p.e.s, null);
                this.f5200e = extras.getString("title", null);
                this.f5202g = extras.getString("version", c.f5758c);
                this.f5201f = extras.getBoolean("backisexit", false);
                try {
                    com.alipay.sdk.m.x.d dVar = new com.alipay.sdk.m.x.d(this, aVarA, this.f5202g);
                    setContentView(dVar);
                    dVar.a(this.f5200e, this.f5198c, this.f5201f);
                    dVar.a(this.f5197b, this.f5199d);
                    dVar.a(this.f5197b);
                    this.f5196a = dVar;
                } catch (Throwable th) {
                    com.alipay.sdk.m.k.a.a(aVarA, com.alipay.sdk.m.k.b.l, "GetInstalledAppEx", th);
                    finish();
                }
            } catch (Exception unused) {
                finish();
            }
        } catch (Exception unused2) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.f5196a;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        try {
            super.setRequestedOrientation(i2);
        } catch (Throwable th) {
            try {
                com.alipay.sdk.m.k.a.a((a) n.a(this.f5203h), com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, th);
            } catch (Throwable unused) {
            }
        }
    }
}

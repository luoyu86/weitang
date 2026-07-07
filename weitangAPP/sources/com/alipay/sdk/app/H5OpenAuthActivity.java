package com.alipay.sdk.app;

import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.s.a;

/* JADX INFO: loaded from: classes.dex */
public class H5OpenAuthActivity extends H5PayActivity {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5195i = false;

    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
    }

    @Override // com.alipay.sdk.app.H5PayActivity, android.app.Activity
    public void onDestroy() {
        if (this.f5195i) {
            try {
                a aVarA = a.C0089a.a(getIntent());
                if (aVarA != null) {
                    com.alipay.sdk.m.k.a.b(this, aVarA, "", aVarA.f5636d);
                }
            } catch (Throwable unused) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            a aVarA = a.C0089a.a(intent);
            try {
                super.startActivity(intent);
                Uri data = intent != null ? intent.getData() : null;
                if (data == null || !data.toString().startsWith("alipays://platformapi/startapp")) {
                    return;
                }
                finish();
            } catch (Throwable th) {
                String string = (intent == null || intent.getData() == null) ? "null" : intent.getData().toString();
                if (aVarA != null) {
                    com.alipay.sdk.m.k.a.a(aVarA, b.l, b.p0, th, string);
                }
                this.f5195i = true;
                throw th;
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}

package com.alipay.sdk.m.c;

import android.content.Context;
import com.alipay.sdk.m.r0.b;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.alipay.sdk.m.b.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5283d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.alipay.sdk.m.r0.b f5284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5285b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5286c = false;

    @Override // com.alipay.sdk.m.b.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f5285b) {
            com.alipay.sdk.m.r0.b bVar = new com.alipay.sdk.m.r0.b();
            this.f5284a = bVar;
            this.f5286c = bVar.a(context, (b.InterfaceC0088b<String>) null) == 1;
            this.f5285b = true;
        }
        com.alipay.sdk.m.d.a.b("getOAID", "isSupported", Boolean.valueOf(this.f5286c));
        if (this.f5286c && this.f5284a.e()) {
            return this.f5284a.b();
        }
        return null;
    }
}

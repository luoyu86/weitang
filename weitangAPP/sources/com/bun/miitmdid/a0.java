package com.bun.miitmdid;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class a0 extends n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Context f5816h;

    public a0(Context context, String str) {
        this.f5816h = checkContext(context);
        this.f5815g = str;
    }

    @Override // com.bun.miitmdid.n
    public native g a();

    public native boolean a(Activity activity, int i2);

    @Override // com.bun.miitmdid.n, com.bun.miitmdid.interfaces.IdSupplier
    public native String getAAID();

    @Override // com.bun.miitmdid.n, com.bun.miitmdid.interfaces.IdSupplier
    public native String getOAID();

    @Override // com.bun.miitmdid.n, com.bun.miitmdid.interfaces.IdSupplier
    public native String getVAID();

    @Override // com.bun.miitmdid.n, com.bun.miitmdid.interfaces.IdSupplier
    public native boolean isLimited();

    @Override // com.bun.miitmdid.n, com.bun.miitmdid.interfaces.IdSupplier
    public native boolean isSupported();

    @Override // com.bun.miitmdid.o, com.bun.miitmdid.interfaces.IdSupplier
    public native void requestOAIDPermission(Activity activity, int i2);
}

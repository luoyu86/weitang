package com.bun.miitmdid;

import android.app.Activity;
import android.content.Context;
import com.heytap.openid.bean.OpenIDInfo;
import com.heytap.openid.sdk.OpenIDSDK;

/* JADX INFO: loaded from: classes.dex */
public class v extends n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f5913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OpenIDInfo f5914h;

    public v(Context context) {
        this.f5913g = context;
        Context contextCheckContext = checkContext(context);
        this.f5913g = contextCheckContext;
        OpenIDSDK.init(contextCheckContext);
        if (j0.f5872a) {
            OpenIDSDK.setLoggable(true);
        }
    }

    @Override // com.bun.miitmdid.n
    public native g a();

    public final native void b();

    @Override // com.bun.miitmdid.n, com.bun.miitmdid.interfaces.IIdProvider
    public native void doStart();

    @Override // com.bun.miitmdid.o, com.bun.miitmdid.interfaces.IdSupplier
    public native void requestOAIDPermission(Activity activity, int i2);
}

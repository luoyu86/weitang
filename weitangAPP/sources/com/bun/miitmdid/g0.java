package com.bun.miitmdid;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class g0 extends n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f5855g;

    public g0(Context context) {
        this.f5855g = context;
    }

    @Override // com.bun.miitmdid.n
    public native g a();

    @Override // com.bun.miitmdid.n, com.bun.miitmdid.interfaces.IIdProvider
    public native void doStart();

    @Override // com.bun.miitmdid.n, com.bun.miitmdid.interfaces.IIdProvider
    public native boolean isSync();
}

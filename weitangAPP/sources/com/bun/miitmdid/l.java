package com.bun.miitmdid;

import android.content.Context;
import com.android.msasdk.FreemeIdsSupplier;
import com.android.msasdk.IConnect;

/* JADX INFO: loaded from: classes.dex */
public class l extends m implements IConnect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FreemeIdsSupplier f5879c;

    public l(Context context) {
        this.f5877a = context;
    }

    @Override // com.android.msasdk.IConnect
    public native void connectSuccess(boolean z);

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void doStart();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void shutDown();
}

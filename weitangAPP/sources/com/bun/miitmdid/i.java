package com.bun.miitmdid;

import android.content.Context;
import android.os.IBinder;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.asus.msa.sdid.IDIDBinderStatusListener;
import com.asus.msa.sdid.SupplementaryDIDManager;

/* JADX INFO: loaded from: classes.dex */
public class i extends m implements IDIDBinderStatusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SupplementaryDIDManager f5868b;

    public i(Context context) {
        this.f5867a = context;
        this.f5868b = new SupplementaryDIDManager(context);
    }

    @Override // android.os.IInterface
    public native IBinder asBinder();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void doStart();

    @Override // com.bun.miitmdid.m, com.bun.miitmdid.interfaces.IIdProvider
    public native boolean isSync();

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
    public native void onError();

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
    public native void onSuccess(IDidAidlInterface iDidAidlInterface);

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void shutDown();
}

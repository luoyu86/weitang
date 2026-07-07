package com.bun.miitmdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.coolpad.deviceidsupport.IDeviceIdManager;

/* JADX INFO: loaded from: classes.dex */
public class j extends m implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IDeviceIdManager f5869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f5870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5871c;

    public j(Context context) {
        this.f5870b = context;
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void doStart();

    @Override // android.content.ServiceConnection
    public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

    @Override // android.content.ServiceConnection
    public native void onServiceDisconnected(ComponentName componentName);

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void shutDown();
}

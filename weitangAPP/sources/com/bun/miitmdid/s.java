package com.bun.miitmdid;

import android.content.Context;
import com.zui.opendeviceidlibrary.OpenDeviceId;

/* JADX INFO: loaded from: classes.dex */
public class s extends m implements OpenDeviceId.CallBack<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OpenDeviceId f5906b;

    public s(Context context) {
        this.f5905a = context;
    }

    @Override // com.zui.opendeviceidlibrary.OpenDeviceId.CallBack
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public native void serviceConnected(String str, OpenDeviceId openDeviceId);

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void doStart();

    @Override // com.bun.miitmdid.m, com.bun.miitmdid.interfaces.IIdProvider
    public native boolean isSync();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void shutDown();
}

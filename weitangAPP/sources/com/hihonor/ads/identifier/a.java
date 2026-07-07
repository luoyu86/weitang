package com.hihonor.ads.identifier;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.bun.miitmdid.o0;
import com.hihonor.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdvertisingIdClient.Info f9086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f9087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BinderC0122a f9088c = new BinderC0122a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f9089d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CountDownLatch f9090e = new CountDownLatch(2);

    /* JADX INFO: renamed from: com.hihonor.ads.identifier.a$a, reason: collision with other inner class name */
    public class BinderC0122a extends o0.a {
        public BinderC0122a() {
        }

        @Override // com.bun.miitmdid.o0
        public native void a(int i2, long j, boolean z, float f2, double d2, String str);

        @Override // com.bun.miitmdid.o0
        public native void a(int i2, Bundle bundle);
    }

    public class b extends o0.a {
        public b() {
        }

        @Override // com.bun.miitmdid.o0
        public native void a(int i2, long j, boolean z, float f2, double d2, String str);

        @Override // com.bun.miitmdid.o0
        public native void a(int i2, Bundle bundle);
    }

    public final native void a();

    public native boolean a(Context context);

    @Override // android.content.ServiceConnection
    public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

    @Override // android.content.ServiceConnection
    public native void onServiceDisconnected(ComponentName componentName);
}

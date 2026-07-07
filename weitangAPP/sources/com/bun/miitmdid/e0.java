package com.bun.miitmdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bun.lib.MsaIdInterface;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5842a = "MsaClient";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ServiceConnection f5843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f5844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MsaIdInterface f5845d;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f5846a;

        public a(f0 f0Var) {
            this.f5846a = f0Var;
        }

        @Override // android.content.ServiceConnection
        public native synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Override // android.content.ServiceConnection
        public native void onServiceDisconnected(ComponentName componentName);
    }

    public e0(Context context, f0 f0Var) {
        Objects.requireNonNull(context, "Context can not be null.");
        this.f5844c = context;
        this.f5843b = new a(f0Var);
    }

    public static native void a(Context context, String str);

    public native String a();

    public native void a(String str);

    public native String b();

    public native String c();

    public native boolean d();

    public native void e();
}

package com.bun.miitmdid;

import android.content.Context;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IPermissionCallbackListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5836a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f5837b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AtomicLong f5838c = new AtomicLong(5000);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f5839d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f5840e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f5841f = true;

    public e(boolean z, long j) {
        AtomicLong atomicLong;
        j0.a(z);
        if (j <= 0) {
            atomicLong = f5838c;
            j = 5000;
        } else {
            atomicLong = f5838c;
        }
        atomicLong.set(j);
    }

    public e(boolean z, long j, boolean z2, boolean z3, boolean z4) {
        AtomicLong atomicLong;
        j0.a(z);
        if (j <= 0) {
            atomicLong = f5838c;
            j = 5000;
        } else {
            atomicLong = f5838c;
        }
        atomicLong.set(j);
        a(z2, z3, z4);
    }

    public static native String a();

    public static native void a(Context context, IPermissionCallbackListener iPermissionCallbackListener);

    public static native boolean a(Context context, String str);

    public static native int b();

    public final native int a(int i2, IdSupplier idSupplier);

    public native int a(Context context, IIdentifierListener iIdentifierListener);

    public native void a(boolean z, boolean z2, boolean z3);
}

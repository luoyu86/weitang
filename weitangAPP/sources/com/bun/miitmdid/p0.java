package com.bun.miitmdid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public interface p0 extends IInterface {

    public static abstract class a extends Binder implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f5901a = 0;

        /* JADX INFO: renamed from: com.bun.miitmdid.p0$a$a, reason: collision with other inner class name */
        public static class C0097a implements p0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f5902a;

            public C0097a(IBinder iBinder) {
                this.f5902a = iBinder;
            }

            @Override // com.bun.miitmdid.p0
            public native void a(o0 o0Var);

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.bun.miitmdid.p0
            public native void b(o0 o0Var);
        }
    }

    void a(o0 o0Var);

    void b(o0 o0Var);
}

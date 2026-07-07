package com.bun.miitmdid;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface o0 extends IInterface {

    public static abstract class a extends Binder implements o0 {
        public a() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3);
    }

    void a(int i2, long j, boolean z, float f2, double d2, String str);

    void a(int i2, Bundle bundle);
}

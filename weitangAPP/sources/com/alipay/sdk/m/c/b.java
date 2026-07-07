package com.alipay.sdk.m.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.alipay.sdk.m.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5277a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5278b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5279c = 2;

    /* JADX INFO: renamed from: com.alipay.sdk.m.c.b$b, reason: collision with other inner class name */
    public static final class ServiceConnectionC0077b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f5281b;

        public ServiceConnectionC0077b() {
            this.f5280a = false;
            this.f5281b = new LinkedBlockingQueue<>();
        }

        public IBinder a() throws InterruptedException {
            if (this.f5280a) {
                throw new IllegalStateException();
            }
            this.f5280a = true;
            return this.f5281b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f5281b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static final class c implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public IBinder f5282a;

        public c(IBinder iBinder) {
            this.f5282a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f5282a;
        }

        public String d() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(b.f5277a);
                this.f5282a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public boolean e() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(b.f5277a);
                this.f5282a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    @Override // com.alipay.sdk.m.b.b
    public String a(Context context) {
        ServiceConnectionC0077b serviceConnectionC0077b = new ServiceConnectionC0077b();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, serviceConnectionC0077b, 1)) {
            try {
                return new c(serviceConnectionC0077b.a()).d();
            } catch (Exception unused) {
            } finally {
                context.unbindService(serviceConnectionC0077b);
            }
        }
        return null;
    }
}

package com.alipay.sdk.m.k0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;

    /* JADX INFO: renamed from: com.alipay.sdk.m.k0.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0081a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f5431a = "com.samsung.android.deviceidservice.IDeviceIdService";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f5432b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f5433c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f5434d = 3;

        public AbstractBinderC0081a() {
            attachInterface(this, f5431a);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f5431a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0082a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f5431a);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f5431a);
                String strB = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f5431a);
                return true;
            }
            parcel.enforceInterface(f5431a);
            String strA2 = a(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strA2);
            return true;
        }

        /* JADX INFO: renamed from: com.alipay.sdk.m.k0.a$a$a, reason: collision with other inner class name */
        public static class C0082a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f5435a;

            public C0082a(IBinder iBinder) {
                this.f5435a = iBinder;
            }

            @Override // com.alipay.sdk.m.k0.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0081a.f5431a);
                    this.f5435a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5435a;
            }

            @Override // com.alipay.sdk.m.k0.a
            public String b(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0081a.f5431a);
                    parcelObtain.writeString(str);
                    this.f5435a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String d() {
                return AbstractBinderC0081a.f5431a;
            }

            @Override // com.alipay.sdk.m.k0.a
            public String a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0081a.f5431a);
                    parcelObtain.writeString(str);
                    this.f5435a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}

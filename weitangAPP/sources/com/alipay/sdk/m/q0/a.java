package com.alipay.sdk.m.q0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    boolean c() throws RemoteException;

    boolean c(String str) throws RemoteException;

    /* JADX INFO: renamed from: com.alipay.sdk.m.q0.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0086a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f5600a = "com.zui.deviceidservice.IDeviceidInterface";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f5601b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f5602c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f5603d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f5604e = 4;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f5605f = 5;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f5606g = 6;

        public AbstractBinderC0086a() {
            attachInterface(this, f5600a);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f5600a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0087a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(f5600a);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(f5600a);
                    String strA = a();
                    parcel2.writeNoException();
                    parcel2.writeString(strA);
                    return true;
                case 2:
                    parcel.enforceInterface(f5600a);
                    String strB = b();
                    parcel2.writeNoException();
                    parcel2.writeString(strB);
                    return true;
                case 3:
                    parcel.enforceInterface(f5600a);
                    boolean zC = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(zC ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(f5600a);
                    String strB2 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strB2);
                    return true;
                case 5:
                    parcel.enforceInterface(f5600a);
                    String strA2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strA2);
                    return true;
                case 6:
                    parcel.enforceInterface(f5600a);
                    boolean zC2 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zC2 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* JADX INFO: renamed from: com.alipay.sdk.m.q0.a$a$a, reason: collision with other inner class name */
        public static class C0087a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f5607a;

            public C0087a(IBinder iBinder) {
                this.f5607a = iBinder;
            }

            @Override // com.alipay.sdk.m.q0.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0086a.f5600a);
                    this.f5607a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5607a;
            }

            @Override // com.alipay.sdk.m.q0.a
            public String b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0086a.f5600a);
                    this.f5607a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alipay.sdk.m.q0.a
            public boolean c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0086a.f5600a);
                    this.f5607a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String d() {
                return AbstractBinderC0086a.f5600a;
            }

            @Override // com.alipay.sdk.m.q0.a
            public String a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0086a.f5600a);
                    parcelObtain.writeString(str);
                    this.f5607a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alipay.sdk.m.q0.a
            public String b(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0086a.f5600a);
                    parcelObtain.writeString(str);
                    this.f5607a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alipay.sdk.m.q0.a
            public boolean c(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0086a.f5600a);
                    parcelObtain.writeString(str);
                    this.f5607a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}

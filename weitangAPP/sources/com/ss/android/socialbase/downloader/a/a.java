package com.ss.android.socialbase.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {
    void ok(Map map, Map map2) throws RemoteException;

    public static abstract class ok extends Binder implements a {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.a.a$ok$ok, reason: collision with other inner class name */
        public static class C0147ok implements a {
            public static a ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f9968a;

            public C0147ok(IBinder iBinder) {
                this.f9968a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9968a;
            }

            @Override // com.ss.android.socialbase.downloader.a.a
            public void ok(Map map, Map map2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
                    parcelObtain.writeMap(map);
                    parcelObtain.writeMap(map2);
                    if (this.f9968a.transact(1, parcelObtain, parcelObtain2, 0) || ok.ok() == null) {
                        parcelObtain2.readException();
                    } else {
                        ok.ok().ok(map, map2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
        }

        public static a ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0147ok(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            ClassLoader classLoader = getClass().getClassLoader();
            ok(parcel.readHashMap(classLoader), parcel.readHashMap(classLoader));
            parcel2.writeNoException();
            return true;
        }

        public static a ok() {
            return C0147ok.ok;
        }
    }
}

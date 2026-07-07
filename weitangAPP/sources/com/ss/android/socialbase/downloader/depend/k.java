package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface k extends IInterface {
    int[] a() throws RemoteException;

    String ok() throws RemoteException;

    void ok(String str) throws RemoteException;

    public static abstract class ok extends Binder implements k {
        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
        }

        public static k bl() {
            return C0157ok.ok;
        }

        public static k ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof k)) ? new C0157ok(iBinder) : (k) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                ok(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                String strOk = ok();
                parcel2.writeNoException();
                parcel2.writeString(strOk);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            int[] iArrA = a();
            parcel2.writeNoException();
            parcel2.writeIntArray(iArrA);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.k$ok$ok, reason: collision with other inner class name */
        public static class C0157ok implements k {
            public static k ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10009a;

            public C0157ok(IBinder iBinder) {
                this.f10009a = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.k
            public int[] a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.f10009a.transact(3, parcelObtain, parcelObtain2, 0) && ok.bl() != null) {
                        return ok.bl().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createIntArray();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10009a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.k
            public void ok(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    parcelObtain.writeString(str);
                    if (this.f10009a.transact(1, parcelObtain, parcelObtain2, 0) || ok.bl() == null) {
                        parcelObtain2.readException();
                    } else {
                        ok.bl().ok(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.k
            public String ok() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.f10009a.transact(2, parcelObtain, parcelObtain2, 0) && ok.bl() != null) {
                        return ok.bl().ok();
                    }
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

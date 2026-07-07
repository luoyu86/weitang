package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface t extends IInterface {

    public static abstract class ok extends Binder implements t {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.t$ok$ok, reason: collision with other inner class name */
        public static class C0163ok implements t {
            public static t ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10015a;

            public C0163ok(IBinder iBinder) {
                this.f10015a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10015a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.t
            public void ok() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                    if (this.f10015a.transact(1, parcelObtain, parcelObtain2, 0) || ok.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        ok.a().ok();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
        }

        public static t a() {
            return C0163ok.ok;
        }

        public static t ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof t)) ? new C0163ok(iBinder) : (t) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            ok();
            parcel2.writeNoException();
            return true;
        }
    }

    void ok() throws RemoteException;
}

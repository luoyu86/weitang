package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface p extends IInterface {

    public static abstract class ok extends Binder implements p {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.p$ok$ok, reason: collision with other inner class name */
        public static class C0161ok implements p {
            public static p ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10013a;

            public C0161ok(IBinder iBinder) {
                this.f10013a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10013a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.p
            public boolean ok() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                    if (!this.f10013a.transact(1, parcelObtain, parcelObtain2, 0) && ok.a() != null) {
                        return ok.a().ok();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
        }

        public static p a() {
            return C0161ok.ok;
        }

        public static p ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof p)) ? new C0161ok(iBinder) : (p) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            boolean zOk = ok();
            parcel2.writeNoException();
            parcel2.writeInt(zOk ? 1 : 0);
            return true;
        }
    }

    boolean ok() throws RemoteException;
}

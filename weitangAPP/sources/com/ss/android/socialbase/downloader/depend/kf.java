package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface kf extends IInterface {
    void ok(DownloadInfo downloadInfo, BaseException baseException, int i2) throws RemoteException;

    public static abstract class ok extends Binder implements kf {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.kf$ok$ok, reason: collision with other inner class name */
        public static class C0158ok implements kf {
            public static kf ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10010a;

            public C0158ok(IBinder iBinder) {
                this.f10010a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10010a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.kf
            public void ok(DownloadInfo downloadInfo, BaseException baseException, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (baseException != null) {
                        parcelObtain.writeInt(1);
                        baseException.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i2);
                    if (this.f10010a.transact(1, parcelObtain, parcelObtain2, 0) || ok.ok() == null) {
                        parcelObtain2.readException();
                    } else {
                        ok.ok().ok(downloadInfo, baseException, i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
        }

        public static kf ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof kf)) ? new C0158ok(iBinder) : (kf) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            ok(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BaseException.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        public static kf ok() {
            return C0158ok.ok;
        }
    }
}

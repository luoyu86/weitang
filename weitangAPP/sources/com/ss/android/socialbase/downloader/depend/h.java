package com.ss.android.socialbase.downloader.depend;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface h extends IInterface {
    Uri ok(String str, String str2) throws RemoteException;

    public static abstract class ok extends Binder implements h {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.h$ok$ok, reason: collision with other inner class name */
        public static class C0153ok implements h {
            public static h ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10005a;

            public C0153ok(IBinder iBinder) {
                this.f10005a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10005a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.h
            public Uri ok(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.f10005a.transact(1, parcelObtain, parcelObtain2, 0) && ok.ok() != null) {
                        return ok.ok().ok(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        }

        public static h ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof h)) ? new C0153ok(iBinder) : (h) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            Uri uriOk = ok(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            if (uriOk != null) {
                parcel2.writeInt(1);
                uriOk.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        public static h ok() {
            return C0153ok.ok;
        }
    }
}

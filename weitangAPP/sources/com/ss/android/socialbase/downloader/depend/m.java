package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface m extends IInterface {
    String ok() throws RemoteException;

    void ok(int i2, DownloadInfo downloadInfo, String str, String str2) throws RemoteException;

    boolean ok(boolean z) throws RemoteException;

    public static abstract class ok extends Binder implements m {
        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
        }

        public static m a() {
            return C0159ok.ok;
        }

        public static m ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof m)) ? new C0159ok(iBinder) : (m) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                ok(parcel.readInt(), parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                boolean zOk = ok(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(zOk ? 1 : 0);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            String strOk = ok();
            parcel2.writeNoException();
            parcel2.writeString(strOk);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.m$ok$ok, reason: collision with other inner class name */
        public static class C0159ok implements m {
            public static m ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10011a;

            public C0159ok(IBinder iBinder) {
                this.f10011a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10011a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.m
            public void ok(int i2, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    parcelObtain.writeInt(i2);
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.f10011a.transact(1, parcelObtain, parcelObtain2, 0) || ok.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        ok.a().ok(i2, downloadInfo, str, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.m
            public boolean ok(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.f10011a.transact(2, parcelObtain, parcelObtain2, 0) && ok.a() != null) {
                        return ok.a().ok(z);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.m
            public String ok() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    if (!this.f10011a.transact(3, parcelObtain, parcelObtain2, 0) && ok.a() != null) {
                        return ok.a().ok();
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

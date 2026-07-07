package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface u extends IInterface {
    void ok(List<String> list) throws RemoteException;

    boolean ok() throws RemoteException;

    public static abstract class ok extends Binder implements u {
        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
        }

        public static u a() {
            return C0164ok.ok;
        }

        public static u ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof u)) ? new C0164ok(iBinder) : (u) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                ok(parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 2) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            boolean zOk = ok();
            parcel2.writeNoException();
            parcel2.writeInt(zOk ? 1 : 0);
            return true;
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.u$ok$ok, reason: collision with other inner class name */
        public static class C0164ok implements u {
            public static u ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10016a;

            public C0164ok(IBinder iBinder) {
                this.f10016a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10016a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.u
            public void ok(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    parcelObtain.writeStringList(list);
                    if (this.f10016a.transact(1, parcelObtain, parcelObtain2, 0) || ok.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        ok.a().ok(list);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.u
            public boolean ok() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    if (!this.f10016a.transact(2, parcelObtain, parcelObtain2, 0) && ok.a() != null) {
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
    }
}

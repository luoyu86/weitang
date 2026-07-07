package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.u;

/* JADX INFO: loaded from: classes2.dex */
public interface io extends IInterface {
    boolean ok(u uVar) throws RemoteException;

    public static abstract class ok extends Binder implements io {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.io$ok$ok, reason: collision with other inner class name */
        public static class C0155ok implements io {
            public static io ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10007a;

            public C0155ok(IBinder iBinder) {
                this.f10007a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10007a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.io
            public boolean ok(u uVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    parcelObtain.writeStrongBinder(uVar != null ? uVar.asBinder() : null);
                    if (!this.f10007a.transact(1, parcelObtain, parcelObtain2, 0) && ok.ok() != null) {
                        return ok.ok().ok(uVar);
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static io ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof io)) ? new C0155ok(iBinder) : (io) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            boolean zOk = ok(u.ok.ok(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(zOk ? 1 : 0);
            return true;
        }

        public static io ok() {
            return C0155ok.ok;
        }
    }
}

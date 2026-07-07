package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.t;

/* JADX INFO: loaded from: classes2.dex */
public interface i extends IInterface {
    boolean ok(long j, long j2, t tVar) throws RemoteException;

    public static abstract class ok extends Binder implements i {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.i$ok$ok, reason: collision with other inner class name */
        public static class C0154ok implements i {
            public static i ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10006a;

            public C0154ok(IBinder iBinder) {
                this.f10006a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10006a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public boolean ok(long j, long j2, t tVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeStrongBinder(tVar != null ? tVar.asBinder() : null);
                    if (!this.f10006a.transact(1, parcelObtain, parcelObtain2, 0) && ok.ok() != null) {
                        return ok.ok().ok(j, j2, tVar);
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static i ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof i)) ? new C0154ok(iBinder) : (i) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            boolean zOk = ok(parcel.readLong(), parcel.readLong(), t.ok.ok(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(zOk ? 1 : 0);
            return true;
        }

        public static i ok() {
            return C0154ok.ok;
        }
    }
}

package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface n extends IInterface {
    int ok(long j) throws RemoteException;

    public static abstract class ok extends Binder implements n {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.n$ok$ok, reason: collision with other inner class name */
        public static class C0160ok implements n {
            public static n ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10012a;

            public C0160ok(IBinder iBinder) {
                this.f10012a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10012a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.n
            public int ok(long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                    parcelObtain.writeLong(j);
                    if (!this.f10012a.transact(1, parcelObtain, parcelObtain2, 0) && ok.ok() != null) {
                        return ok.ok().ok(j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
        }

        public static n ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof n)) ? new C0160ok(iBinder) : (n) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            int iOk = ok(parcel.readLong());
            parcel2.writeNoException();
            parcel2.writeInt(iOk);
            return true;
        }

        public static n ok() {
            return C0160ok.ok;
        }
    }
}

package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface e extends IInterface {
    long ok(int i2, int i3) throws RemoteException;

    public static abstract class ok extends Binder implements e {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.e$ok$ok, reason: collision with other inner class name */
        public static class C0150ok implements e {
            public static e ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10002a;

            public C0150ok(IBinder iBinder) {
                this.f10002a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10002a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.e
            public long ok(int i2, int i3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (!this.f10002a.transact(1, parcelObtain, parcelObtain2, 0) && ok.ok() != null) {
                        return ok.ok().ok(i2, i3);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
        }

        public static e ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new C0150ok(iBinder) : (e) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            long jOk = ok(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(jOk);
            return true;
        }

        public static e ok() {
            return C0150ok.ok;
        }
    }
}

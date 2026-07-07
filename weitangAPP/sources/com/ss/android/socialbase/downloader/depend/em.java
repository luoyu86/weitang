package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface em extends IInterface {
    void ok(int i2, int i3) throws RemoteException;

    public static abstract class ok extends Binder implements em {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.depend.em$ok$ok, reason: collision with other inner class name */
        public static class C0151ok implements em {
            public static em ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10003a;

            public C0151ok(IBinder iBinder) {
                this.f10003a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10003a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.em
            public void ok(int i2, int i3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (this.f10003a.transact(1, parcelObtain, parcelObtain2, 0) || ok.ok() == null) {
                        parcelObtain2.readException();
                    } else {
                        ok.ok().ok(i2, i3);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        public static em ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof em)) ? new C0151ok(iBinder) : (em) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            ok(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        public static em ok() {
            return C0151ok.ok;
        }
    }
}

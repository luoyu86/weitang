package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface ParcelableFuture extends IInterface {

    public static abstract class Stub extends Binder implements ParcelableFuture {
        private static final String DESCRIPTOR = "anetwork.channel.aidl.ParcelableFuture";
        public static final int TRANSACTION_cancel = 1;
        public static final int TRANSACTION_get = 4;
        public static final int TRANSACTION_isCancelled = 2;
        public static final int TRANSACTION_isDone = 3;

        public static class Proxy implements ParcelableFuture {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f759a;

            public Proxy(IBinder iBinder) {
                this.f759a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f759a;
            }

            @Override // anetwork.channel.aidl.ParcelableFuture
            public boolean cancel(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.f759a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.ParcelableFuture
            public NetworkResponse get(long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    this.f759a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? NetworkResponse.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.ParcelableFuture
            public boolean isCancelled() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.f759a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.ParcelableFuture
            public boolean isDone() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.f759a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ParcelableFuture asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ParcelableFuture)) ? new Proxy(iBinder) : (ParcelableFuture) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean zCancel = cancel(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(zCancel ? 1 : 0);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean zIsCancelled = isCancelled();
                parcel2.writeNoException();
                parcel2.writeInt(zIsCancelled ? 1 : 0);
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean zIsDone = isDone();
                parcel2.writeNoException();
                parcel2.writeInt(zIsDone ? 1 : 0);
                return true;
            }
            if (i2 != 4) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            NetworkResponse networkResponse = get(parcel.readLong());
            parcel2.writeNoException();
            if (networkResponse != null) {
                parcel2.writeInt(1);
                networkResponse.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    boolean cancel(boolean z) throws RemoteException;

    NetworkResponse get(long j) throws RemoteException;

    boolean isCancelled() throws RemoteException;

    boolean isDone() throws RemoteException;
}

package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface ParcelableBodyHandler extends IInterface {

    public static abstract class Stub extends Binder implements ParcelableBodyHandler {
        private static final String DESCRIPTOR = "anetwork.channel.aidl.ParcelableBodyHandler";
        public static final int TRANSACTION_isCompleted = 2;
        public static final int TRANSACTION_read = 1;

        public static class Proxy implements ParcelableBodyHandler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f758a;

            public Proxy(IBinder iBinder) {
                this.f758a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f758a;
            }

            @Override // anetwork.channel.aidl.ParcelableBodyHandler
            public boolean isCompleted() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.f758a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.ParcelableBodyHandler
            public int read(byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeByteArray(bArr);
                    this.f758a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    int i2 = parcelObtain2.readInt();
                    parcelObtain2.readByteArray(bArr);
                    return i2;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ParcelableBodyHandler asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ParcelableBodyHandler)) ? new Proxy(iBinder) : (ParcelableBodyHandler) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                byte[] bArrCreateByteArray = parcel.createByteArray();
                int i4 = read(bArrCreateByteArray);
                parcel2.writeNoException();
                parcel2.writeInt(i4);
                parcel2.writeByteArray(bArrCreateByteArray);
                return true;
            }
            if (i2 != 2) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            boolean zIsCompleted = isCompleted();
            parcel2.writeNoException();
            parcel2.writeInt(zIsCompleted ? 1 : 0);
            return true;
        }
    }

    boolean isCompleted() throws RemoteException;

    int read(byte[] bArr) throws RemoteException;
}

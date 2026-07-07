package adsuyi.com.hihonor.cloudservice.oaid;

import adsuyi.com.hihonor.cloudservice.oaid.a;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    public static abstract class Stub extends Binder implements b {
        public static final int f214a = 0;

        public static class InternalStub implements b {
            public IBinder binder;

            public InternalStub(IBinder iBinder) {
                this.binder = iBinder;
            }

            @Override // adsuyi.com.hihonor.cloudservice.oaid.b
            public void a(a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(aVar != null ? (a.Stub) aVar : null);
                    this.binder.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.binder;
            }

            @Override // adsuyi.com.hihonor.cloudservice.oaid.b
            public void b(a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(aVar != null ? (a.Stub) aVar : null);
                    this.binder.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    void a(a aVar);

    void b(a aVar);
}

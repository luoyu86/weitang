package adsuyi.com.hihonor.cloudservice.oaid;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    public static abstract class Stub extends Binder implements a {
        public Stub() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
            } else {
                if (i2 != 2) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    return true;
                }
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i2, long j, boolean z, float f2, double d2, String str);

    void a(int i2, Bundle bundle);
}

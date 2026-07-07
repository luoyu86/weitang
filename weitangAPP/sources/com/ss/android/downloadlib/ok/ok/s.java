package com.ss.android.downloadlib.ok.ok;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.ss.android.downloadlib.addownload.r;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface s extends IInterface {

    public static abstract class ok extends Binder implements s {
        private static String ok = "";

        /* JADX INFO: renamed from: com.ss.android.downloadlib.ok.ok.s$ok$ok, reason: collision with other inner class name */
        public static class C0140ok implements s {
            private IBinder ok;

            public C0140ok(IBinder iBinder) {
                if (TextUtils.isEmpty(ok.ok)) {
                    JSONObject jSONObjectQ = r.q();
                    String unused = ok.ok = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString(DispatchConstants.TIMESTAMP), jSONObjectQ.optString(OperatorName.CLOSE_AND_STROKE));
                }
                this.ok = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.ok;
            }

            @Override // com.ss.android.downloadlib.ok.ok.s
            public void ok(a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ok.ok);
                    if (aVar != null) {
                        parcelObtain.writeInt(1);
                        aVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.ok.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(ok);
                ok(parcel.readInt() != 0 ? a.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeString(ok);
            return true;
        }

        public static s ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ok);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof s)) {
                return (s) iInterfaceQueryLocalInterface;
            }
            return new C0140ok(iBinder);
        }
    }

    void ok(a aVar) throws RemoteException;
}

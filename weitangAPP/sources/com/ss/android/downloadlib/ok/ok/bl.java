package com.ss.android.downloadlib.ok.ok;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.ok.ok.s;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface bl extends IInterface {

    public static abstract class ok extends Binder implements bl {
        private static String ok = "";

        /* JADX INFO: renamed from: com.ss.android.downloadlib.ok.ok.bl$ok$ok, reason: collision with other inner class name */
        public static class C0138ok implements bl {
            private IBinder ok;

            public C0138ok(IBinder iBinder) {
                if (TextUtils.isEmpty(ok.ok)) {
                    JSONObject jSONObjectQ = r.q();
                    String unused = ok.ok = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString(PDPageLabelRange.STYLE_ROMAN_LOWER), jSONObjectQ.optString(OperatorName.CLOSE_AND_STROKE));
                }
                this.ok = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.ok;
            }

            @Override // com.ss.android.downloadlib.ok.ok.bl
            public void ok(a aVar, s sVar) throws RemoteException {
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
                    parcelObtain.writeStrongBinder(sVar != null ? sVar.asBinder() : null);
                    this.ok.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(ok);
                return true;
            }
            if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.enforceInterface(ok);
            ok(parcel.readInt() != 0 ? a.CREATOR.createFromParcel(parcel) : null, s.ok.ok(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static bl ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ok);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof bl)) {
                return (bl) iInterfaceQueryLocalInterface;
            }
            return new C0138ok(iBinder);
        }
    }

    void ok(a aVar, s sVar) throws RemoteException;
}

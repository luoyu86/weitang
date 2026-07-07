package com.bytedance.pangle;

import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface g extends IInterface {
    int a();

    void a(ComponentName componentName, IBinder iBinder);

    public static abstract class a extends Binder implements g {
        public a() {
            attachInterface(this, "com.bytedance.pangle.ServiceConnection");
        }

        public static g a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.ServiceConnection");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof g)) ? new C0103a(iBinder) : (g) iInterfaceQueryLocalInterface;
        }

        public static g b() {
            return C0103a.f6069a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
                a(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 2) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.bytedance.pangle.ServiceConnection");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
            int iA = a();
            parcel2.writeNoException();
            parcel2.writeInt(iA);
            return true;
        }

        /* JADX INFO: renamed from: com.bytedance.pangle.g$a$a, reason: collision with other inner class name */
        public static class C0103a implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static g f6069a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f6070b;

            public C0103a(IBinder iBinder) {
                this.f6070b = iBinder;
            }

            @Override // com.bytedance.pangle.g
            public final void a(ComponentName componentName, IBinder iBinder) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (componentName != null) {
                        parcelObtain.writeInt(1);
                        componentName.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iBinder);
                    if (this.f6070b.transact(1, parcelObtain, parcelObtain2, 0) || a.b() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.b().a(componentName, iBinder);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f6070b;
            }

            @Override // com.bytedance.pangle.g
            public final int a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (!this.f6070b.transact(2, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}

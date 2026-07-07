package com.bytedance.pangle;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.pangle.g;

/* JADX INFO: loaded from: classes.dex */
public interface e extends IInterface {
    ComponentName a(Intent intent, String str);

    void a(g gVar);

    boolean a(Intent intent, g gVar, int i2, String str);

    boolean b(Intent intent, String str);

    public static abstract class a extends Binder implements e {
        public a() {
            attachInterface(this, "com.bytedance.pangle.IServiceManager");
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IServiceManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new C0102a(iBinder) : (e) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                ComponentName componentNameA = a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                if (componentNameA != null) {
                    parcel2.writeInt(1);
                    componentNameA.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                boolean zB = b(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zB ? 1 : 0);
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                boolean zA = a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, g.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            }
            if (i2 != 4) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.bytedance.pangle.IServiceManager");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
            a(g.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static e a() {
            return C0102a.f6006a;
        }

        /* JADX INFO: renamed from: com.bytedance.pangle.e$a$a, reason: collision with other inner class name */
        public static class C0102a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static e f6006a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f6007b;

            public C0102a(IBinder iBinder) {
                this.f6007b = iBinder;
            }

            @Override // com.bytedance.pangle.e
            public final ComponentName a(Intent intent, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (!this.f6007b.transact(1, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        return a.a().a(intent, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f6007b;
            }

            @Override // com.bytedance.pangle.e
            public final boolean b(Intent intent, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (!this.f6007b.transact(2, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        return a.a().b(intent, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.e
            public final boolean a(Intent intent, g gVar, int i2, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        parcelObtain.writeInt(1);
                        intent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    if (!this.f6007b.transact(3, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        return a.a().a(intent, gVar, i2, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.e
            public final void a(g gVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    parcelObtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    if (!this.f6007b.transact(4, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        a.a().a(gVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}

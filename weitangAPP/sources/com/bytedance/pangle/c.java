package com.bytedance.pangle;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.pangle.d;

/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {
    void a(int i2);

    void a(int i2, d dVar);

    boolean a(String str);

    boolean a(String str, String str2);

    int b(String str);

    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPackageManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0100a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            d c0101a;
            if (i2 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean zA = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int iB = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iB);
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean zA2 = a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zA2 ? 1 : 0);
                return true;
            }
            if (i2 != 4) {
                if (i2 != 5) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString("com.bytedance.pangle.IPackageManager");
                    return true;
                }
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
            int i4 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                c0101a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.bytedance.pangle.IPluginInstallListener");
                c0101a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) ? new d.a.C0101a(strongBinder) : (d) iInterfaceQueryLocalInterface;
            }
            a(i4, c0101a);
            parcel2.writeNoException();
            return true;
        }

        public static c a() {
            return C0100a.f5956a;
        }

        /* JADX INFO: renamed from: com.bytedance.pangle.c$a$a, reason: collision with other inner class name */
        public static class C0100a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static c f5956a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f5957b;

            public C0100a(IBinder iBinder) {
                this.f5957b = iBinder;
            }

            @Override // com.bytedance.pangle.c
            public final boolean a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    if (!this.f5957b.transact(1, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        return a.a().a(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f5957b;
            }

            @Override // com.bytedance.pangle.c
            public final int b(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    if (!this.f5957b.transact(2, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        return a.a().b(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.c
            public final boolean a(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.f5957b.transact(3, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        return a.a().a(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.c
            public final void a(int i2, d dVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    if (!this.f5957b.transact(4, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        a.a().a(i2, dVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.c
            public final void a(int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    parcelObtain.writeInt(i2);
                    if (!this.f5957b.transact(5, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        a.a().a(i2);
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

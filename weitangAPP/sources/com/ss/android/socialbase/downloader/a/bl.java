package com.ss.android.socialbase.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface bl extends IInterface {
    DownloadInfo a(int i2) throws RemoteException;

    DownloadInfo a(int i2, long j) throws RemoteException;

    List<DownloadInfo> a() throws RemoteException;

    List<DownloadInfo> a(String str) throws RemoteException;

    void a(int i2, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException;

    void a(DownloadInfo downloadInfo) throws RemoteException;

    void a(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException;

    DownloadInfo bl(int i2, long j) throws RemoteException;

    List<com.ss.android.socialbase.downloader.model.a> bl(int i2) throws RemoteException;

    List<DownloadInfo> bl(String str) throws RemoteException;

    void bl() throws RemoteException;

    DownloadInfo h(int i2) throws RemoteException;

    DownloadInfo k(int i2) throws RemoteException;

    boolean kf(int i2) throws RemoteException;

    DownloadInfo n(int i2, long j) throws RemoteException;

    boolean n() throws RemoteException;

    boolean n(int i2) throws RemoteException;

    DownloadInfo ok(int i2, int i3) throws RemoteException;

    DownloadInfo ok(int i2, long j) throws RemoteException;

    DownloadInfo ok(int i2, long j, String str, String str2) throws RemoteException;

    List<DownloadInfo> ok(String str) throws RemoteException;

    void ok() throws RemoteException;

    void ok(int i2, int i3, int i4, int i5) throws RemoteException;

    void ok(int i2, int i3, int i4, long j) throws RemoteException;

    void ok(int i2, int i3, long j) throws RemoteException;

    void ok(int i2, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException;

    void ok(a aVar) throws RemoteException;

    void ok(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException;

    boolean ok(int i2) throws RemoteException;

    boolean ok(DownloadInfo downloadInfo) throws RemoteException;

    DownloadInfo p(int i2) throws RemoteException;

    DownloadInfo q(int i2) throws RemoteException;

    DownloadInfo s(int i2, long j) throws RemoteException;

    List<DownloadInfo> s(String str) throws RemoteException;

    void s(int i2) throws RemoteException;

    boolean s() throws RemoteException;

    public static abstract class ok extends Binder implements bl {
        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        public static bl kf() {
            return C0148ok.ok;
        }

        public static bl ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof bl)) ? new C0148ok(iBinder) : (bl) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    ok();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zOk = ok(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zOk ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoA = a(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoA != null) {
                        parcel2.writeInt(1);
                        downloadInfoA.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listOk = ok(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listOk);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listA = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listA);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listBl = bl(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listBl);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listS = s(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listS);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<DownloadInfo> listA2 = a();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listA2);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    List<com.ss.android.socialbase.downloader.model.a> listBl2 = bl(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listBl2);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    s(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    ok(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.a.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    a(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.a.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    ok(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    ok(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    ok(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoOk = ok(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoOk != null) {
                        parcel2.writeInt(1);
                        downloadInfoOk.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 17:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zOk2 = ok(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zOk2 ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zN = n(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zN ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zKf = kf(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zKf ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    bl();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoH = h(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoH != null) {
                        parcel2.writeInt(1);
                        downloadInfoH.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 22:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoOk2 = ok(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (downloadInfoOk2 != null) {
                        parcel2.writeInt(1);
                        downloadInfoOk2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 23:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoOk3 = ok(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoOk3 != null) {
                        parcel2.writeInt(1);
                        downloadInfoOk3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 24:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoA2 = a(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoA2 != null) {
                        parcel2.writeInt(1);
                        downloadInfoA2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 25:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoP = p(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoP != null) {
                        parcel2.writeInt(1);
                        downloadInfoP.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 26:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoBl = bl(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoBl != null) {
                        parcel2.writeInt(1);
                        downloadInfoBl.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 27:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoS = s(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoS != null) {
                        parcel2.writeInt(1);
                        downloadInfoS.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 28:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoN = n(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    if (downloadInfoN != null) {
                        parcel2.writeInt(1);
                        downloadInfoN.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 29:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoQ = q(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoQ != null) {
                        parcel2.writeInt(1);
                        downloadInfoQ.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 30:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    DownloadInfo downloadInfoK = k(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoK != null) {
                        parcel2.writeInt(1);
                        downloadInfoK.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 31:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zS = s();
                    parcel2.writeNoException();
                    parcel2.writeInt(zS ? 1 : 0);
                    return true;
                case 32:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean zN2 = n();
                    parcel2.writeNoException();
                    parcel2.writeInt(zN2 ? 1 : 0);
                    return true;
                case 33:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    ok(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.a.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    a(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.a.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    ok(a.ok.ok(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.a.bl$ok$ok, reason: collision with other inner class name */
        public static class C0148ok implements bl {
            public static bl ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f9969a;

            public C0148ok(IBinder iBinder) {
                this.f9969a = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo a(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    if (!this.f9969a.transact(3, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().a(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9969a;
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public List<DownloadInfo> bl(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.f9969a.transact(6, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().bl(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo h(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    if (!this.f9969a.transact(21, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().h(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo k(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    if (!this.f9969a.transact(30, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().k(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public boolean kf(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    if (!this.f9969a.transact(19, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().kf(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public boolean n(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    if (!this.f9969a.transact(18, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().n(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void ok() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (this.f9969a.transact(1, parcelObtain, parcelObtain2, 0) || ok.kf() == null) {
                        parcelObtain2.readException();
                    } else {
                        ok.kf().ok();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo p(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    if (!this.f9969a.transact(25, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().p(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo q(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    if (!this.f9969a.transact(29, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().q(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public List<DownloadInfo> s(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.f9969a.transact(7, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().s(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public boolean ok(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    if (!this.f9969a.transact(2, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().ok(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public List<com.ss.android.socialbase.downloader.model.a> bl(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    if (!this.f9969a.transact(9, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().bl(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.a.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo n(int i2, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    if (!this.f9969a.transact(28, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().n(i2, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void s(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    if (!this.f9969a.transact(10, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        ok.kf().s(i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public List<DownloadInfo> a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.f9969a.transact(5, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().a(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public List<DownloadInfo> ok(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeString(str);
                    if (!this.f9969a.transact(4, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().ok(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo s(int i2, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    if (!this.f9969a.transact(27, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().s(i2, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void bl() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f9969a.transact(20, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        ok.kf().bl();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public List<DownloadInfo> a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f9969a.transact(8, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public boolean n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f9969a.transact(32, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().n();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo bl(int i2, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    if (!this.f9969a.transact(26, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().bl(i2, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void ok(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (aVar != null) {
                        parcelObtain.writeInt(1);
                        aVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9969a.transact(11, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        ok.kf().ok(aVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void a(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (aVar != null) {
                        parcelObtain.writeInt(1);
                        aVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9969a.transact(12, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        ok.kf().a(aVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public boolean s() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f9969a.transact(31, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().s();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void ok(int i2, int i3, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeLong(j);
                    if (!this.f9969a.transact(13, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        ok.kf().ok(i2, i3, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo a(int i2, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    if (!this.f9969a.transact(24, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().a(i2, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void ok(int i2, int i3, int i4, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeLong(j);
                    if (!this.f9969a.transact(14, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        ok.kf().ok(i2, i3, i4, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void a(DownloadInfo downloadInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9969a.transact(33, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        ok.kf().a(downloadInfo);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void ok(int i2, int i3, int i4, int i5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    if (!this.f9969a.transact(15, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        ok.kf().ok(i2, i3, i4, i5);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void a(int i2, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeTypedList(list);
                    if (!this.f9969a.transact(35, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        ok.kf().a(i2, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo ok(int i2, int i3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (!this.f9969a.transact(16, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().ok(i2, i3);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public boolean ok(DownloadInfo downloadInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f9969a.transact(17, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().ok(downloadInfo);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo ok(int i2, long j, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.f9969a.transact(22, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().ok(i2, j, str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public DownloadInfo ok(int i2, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    if (!this.f9969a.transact(23, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        return ok.kf().ok(i2, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void ok(int i2, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeTypedList(list);
                    if (!this.f9969a.transact(34, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        ok.kf().ok(i2, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.bl
            public void ok(a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (!this.f9969a.transact(36, parcelObtain, parcelObtain2, 0) && ok.kf() != null) {
                        ok.kf().ok(aVar);
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

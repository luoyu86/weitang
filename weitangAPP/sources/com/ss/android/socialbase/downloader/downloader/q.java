package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.em;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.ok;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface q extends IInterface {
    DownloadInfo a(String str, String str2) throws RemoteException;

    List<DownloadInfo> a() throws RemoteException;

    List<DownloadInfo> a(String str) throws RemoteException;

    void a(int i2, int i3, com.ss.android.socialbase.downloader.depend.q qVar, int i4, boolean z) throws RemoteException;

    void a(int i2, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException;

    void a(int i2, boolean z) throws RemoteException;

    void a(List<String> list) throws RemoteException;

    boolean a(int i2) throws RemoteException;

    boolean a(DownloadInfo downloadInfo) throws RemoteException;

    List<DownloadInfo> bl(String str) throws RemoteException;

    void bl(int i2) throws RemoteException;

    void bl(int i2, boolean z) throws RemoteException;

    boolean bl() throws RemoteException;

    boolean h(int i2) throws RemoteException;

    boolean i(int i2) throws RemoteException;

    void j(int i2) throws RemoteException;

    void k(int i2) throws RemoteException;

    int kf(int i2) throws RemoteException;

    boolean kf() throws RemoteException;

    long n(int i2) throws RemoteException;

    List<DownloadInfo> n(String str) throws RemoteException;

    void n() throws RemoteException;

    int ok(String str, String str2) throws RemoteException;

    List<DownloadInfo> ok(String str) throws RemoteException;

    void ok() throws RemoteException;

    void ok(int i2) throws RemoteException;

    void ok(int i2, int i3) throws RemoteException;

    void ok(int i2, int i3, int i4, int i5) throws RemoteException;

    void ok(int i2, int i3, int i4, long j) throws RemoteException;

    void ok(int i2, int i3, long j) throws RemoteException;

    void ok(int i2, int i3, com.ss.android.socialbase.downloader.depend.q qVar, int i4, boolean z) throws RemoteException;

    void ok(int i2, int i3, com.ss.android.socialbase.downloader.depend.q qVar, int i4, boolean z, boolean z2) throws RemoteException;

    void ok(int i2, long j) throws RemoteException;

    void ok(int i2, Notification notification) throws RemoteException;

    void ok(int i2, m mVar) throws RemoteException;

    void ok(int i2, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException;

    void ok(int i2, boolean z) throws RemoteException;

    void ok(em emVar) throws RemoteException;

    void ok(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException;

    void ok(com.ss.android.socialbase.downloader.model.ok okVar) throws RemoteException;

    void ok(List<String> list) throws RemoteException;

    void ok(boolean z) throws RemoteException;

    boolean ok(DownloadInfo downloadInfo) throws RemoteException;

    DownloadInfo p(int i2) throws RemoteException;

    List<com.ss.android.socialbase.downloader.model.a> q(int i2) throws RemoteException;

    boolean r(int i2) throws RemoteException;

    boolean rh(int i2) throws RemoteException;

    List<DownloadInfo> s(String str) throws RemoteException;

    void s(int i2) throws RemoteException;

    void s(int i2, boolean z) throws RemoteException;

    boolean s() throws RemoteException;

    void t(int i2) throws RemoteException;

    g td(int i2) throws RemoteException;

    m x(int i2) throws RemoteException;

    int z(int i2) throws RemoteException;

    com.ss.android.socialbase.downloader.depend.h zz(int i2) throws RemoteException;

    public static abstract class ok extends Binder implements q {
        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        }

        public static q h() {
            return C0166ok.ok;
        }

        public static q ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof q)) ? new C0166ok(iBinder) : (q) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(ok.AbstractBinderC0169ok.ok(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zA = a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    bl(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    s(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    long jN = n(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(jN);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    int iKf = kf(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iKf);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zH = h(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zH ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    DownloadInfo downloadInfoP = p(parcel.readInt());
                    parcel2.writeNoException();
                    if (downloadInfoP != null) {
                        parcel2.writeInt(1);
                        downloadInfoP.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<DownloadInfo> listOk = ok(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listOk);
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<com.ss.android.socialbase.downloader.model.a> listQ = q(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listQ);
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    int iOk = ok(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iOk);
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    DownloadInfo downloadInfoA = a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (downloadInfoA != null) {
                        parcel2.writeInt(1);
                        downloadInfoA.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<DownloadInfo> listA = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listA);
                    return true;
                case 17:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<DownloadInfo> listBl = bl(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listBl);
                    return true;
                case 18:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<DownloadInfo> listS = s(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listS);
                    return true;
                case 19:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<DownloadInfo> listA2 = a();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listA2);
                    return true;
                case 20:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    bl(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    k(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.readInt(), parcel.readInt(), q.ok.ok(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), parcel.readInt(), q.ok.ok(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.readInt(), parcel.readInt(), q.ok.ok(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zOk = ok(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zOk ? 1 : 0);
                    return true;
                case 29:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 30:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.readInt() != 0);
                    return true;
                case 31:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zBl = bl();
                    parcel2.writeNoException();
                    parcel2.writeInt(zBl ? 1 : 0);
                    return true;
                case 32:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    List<DownloadInfo> listN = n(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listN);
                    return true;
                case 33:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zR = r(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zR ? 1 : 0);
                    return true;
                case 34:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    j(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zS = s();
                    parcel2.writeNoException();
                    parcel2.writeInt(zS ? 1 : 0);
                    return true;
                case 36:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    s(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    int iZ = z(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iZ);
                    return true;
                case 38:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.a.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zA2 = a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zA2 ? 1 : 0);
                    return true;
                case 40:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zRh = rh(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRh ? 1 : 0);
                    return true;
                case 41:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    t(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zI = i(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zI ? 1 : 0);
                    return true;
                case 46:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    n();
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.a.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 48:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    a(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.a.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(em.ok.ok(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 51:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    m mVarX = x(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(mVarX != null ? mVarX.asBinder() : null);
                    return true;
                case 52:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    g gVarTd = td(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(gVarTd != null ? gVarTd.asBinder() : null);
                    return true;
                case 53:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.readInt(), m.ok.ok(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 54:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    com.ss.android.socialbase.downloader.depend.h hVarZz = zz(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(hVarZz != null ? hVarZz.asBinder() : null);
                    return true;
                case 55:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean zKf = kf();
                    parcel2.writeNoException();
                    parcel2.writeInt(zKf ? 1 : 0);
                    return true;
                case 56:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    ok(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.downloader.q$ok$ok, reason: collision with other inner class name */
        public static class C0166ok implements q {
            public static q ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10038a;

            public C0166ok(IBinder iBinder) {
                this.f10038a = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean a(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (!this.f10038a.transact(4, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().a(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10038a;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void bl(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (this.f10038a.transact(5, parcelObtain, parcelObtain2, 0) || ok.h() == null) {
                        parcelObtain2.readException();
                    } else {
                        ok.h().bl(i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean h(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (!this.f10038a.transact(10, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().h(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean i(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (!this.f10038a.transact(45, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().i(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void j(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (this.f10038a.transact(34, parcelObtain, parcelObtain2, 0) || ok.h() == null) {
                        parcelObtain2.readException();
                    } else {
                        ok.h().j(i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void k(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (this.f10038a.transact(24, parcelObtain, parcelObtain2, 0) || ok.h() == null) {
                        parcelObtain2.readException();
                    } else {
                        ok.h().k(i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public int kf(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (!this.f10038a.transact(9, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().kf(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public long n(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (!this.f10038a.transact(8, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().n(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(com.ss.android.socialbase.downloader.model.ok okVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeStrongBinder(okVar != null ? okVar.asBinder() : null);
                    if (this.f10038a.transact(1, parcelObtain, parcelObtain2, 0) || ok.h() == null) {
                        parcelObtain2.readException();
                    } else {
                        ok.h().ok(okVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public DownloadInfo p(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (!this.f10038a.transact(11, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().p(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public List<com.ss.android.socialbase.downloader.model.a> q(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (!this.f10038a.transact(13, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().q(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.a.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean r(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (!this.f10038a.transact(33, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().r(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean rh(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (!this.f10038a.transact(40, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().rh(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void s(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (this.f10038a.transact(6, parcelObtain, parcelObtain2, 0) || ok.h() == null) {
                        parcelObtain2.readException();
                    } else {
                        ok.h().s(i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void t(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (this.f10038a.transact(41, parcelObtain, parcelObtain2, 0) || ok.h() == null) {
                        parcelObtain2.readException();
                    } else {
                        ok.h().t(i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public g td(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (!this.f10038a.transact(52, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().td(i2);
                    }
                    parcelObtain2.readException();
                    return g.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public m x(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (!this.f10038a.transact(51, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().x(i2);
                    }
                    parcelObtain2.readException();
                    return m.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public int z(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (!this.f10038a.transact(37, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().z(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public com.ss.android.socialbase.downloader.depend.h zz(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (!this.f10038a.transact(54, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().zz(i2);
                    }
                    parcelObtain2.readException();
                    return h.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public List<DownloadInfo> bl(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.f10038a.transact(17, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().bl(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (!this.f10038a.transact(2, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok(i2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public List<DownloadInfo> s(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.f10038a.transact(18, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().s(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public DownloadInfo a(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.f10038a.transact(15, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().a(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean kf() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f10038a.transact(55, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().kf();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public List<DownloadInfo> n(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.f10038a.transact(32, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().n(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i2, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.f10038a.transact(3, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok(i2, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void bl(int i2, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.f10038a.transact(23, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().bl(i2, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean s() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f10038a.transact(35, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().s();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f10038a.transact(46, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().n();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public List<DownloadInfo> a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.f10038a.transact(16, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().a(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f10038a.transact(7, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void s(int i2, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.f10038a.transact(36, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().s(i2, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean bl() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f10038a.transact(31, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().bl();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public List<DownloadInfo> a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (!this.f10038a.transact(19, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public List<DownloadInfo> ok(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    if (!this.f10038a.transact(12, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().ok(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void a(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeStringList(list);
                    if (!this.f10038a.transact(21, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().a(list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public int ok(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.f10038a.transact(14, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().ok(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void a(int i2, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.f10038a.transact(22, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().a(i2, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeStringList(list);
                    if (!this.f10038a.transact(20, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok(list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void a(int i2, int i3, com.ss.android.socialbase.downloader.depend.q qVar, int i4, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.f10038a.transact(26, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().a(i2, i3, qVar, i4, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i2, int i3, com.ss.android.socialbase.downloader.depend.q qVar, int i4, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.f10038a.transact(25, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok(i2, i3, qVar, i4, z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f10038a.transact(39, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().a(downloadInfo);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i2, int i3, com.ss.android.socialbase.downloader.depend.q qVar, int i4, boolean z, boolean z2) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
                    parcelObtain.writeInt(i4);
                    int i5 = 1;
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i5 = 0;
                    }
                    parcelObtain.writeInt(i5);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.f10038a.transact(27, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok(i2, i3, qVar, i4, z, z2);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void a(int i2, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeTypedList(list);
                    if (!this.f10038a.transact(48, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().a(i2, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public boolean ok(DownloadInfo downloadInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (downloadInfo != null) {
                        parcelObtain.writeInt(1);
                        downloadInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f10038a.transact(28, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        return ok.h().ok(downloadInfo);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i2, Notification notification) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    if (notification != null) {
                        parcelObtain.writeInt(1);
                        notification.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f10038a.transact(29, parcelObtain, null, 1) || ok.h() == null) {
                        return;
                    }
                    ok.h().ok(i2, notification);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.f10038a.transact(30, parcelObtain, null, 1) || ok.h() == null) {
                        return;
                    }
                    ok.h().ok(z);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (aVar != null) {
                        parcelObtain.writeInt(1);
                        aVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f10038a.transact(38, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok(aVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i2, int i3, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeLong(j);
                    if (!this.f10038a.transact(42, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok(i2, i3, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i2, int i3, int i4, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeLong(j);
                    if (!this.f10038a.transact(43, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok(i2, i3, i4, j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i2, int i3, int i4, int i5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    if (!this.f10038a.transact(44, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok(i2, i3, i4, i5);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i2, List<com.ss.android.socialbase.downloader.model.a> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeTypedList(list);
                    if (!this.f10038a.transact(47, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok(i2, list);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(em emVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeStrongBinder(emVar != null ? emVar.asBinder() : null);
                    if (!this.f10038a.transact(49, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok(emVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i2, int i3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (!this.f10038a.transact(50, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok(i2, i3);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i2, m mVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(mVar != null ? mVar.asBinder() : null);
                    if (!this.f10038a.transact(53, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok(i2, mVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public void ok(int i2, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    if (!this.f10038a.transact(56, parcelObtain, parcelObtain2, 0) && ok.h() != null) {
                        ok.h().ok(i2, j);
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

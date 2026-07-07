package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.depend.kf;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.q;

/* JADX INFO: loaded from: classes2.dex */
public interface ok extends IInterface {
    com.ss.android.socialbase.downloader.depend.n a() throws RemoteException;

    q a(int i2) throws RemoteException;

    j bl(int i2) throws RemoteException;

    m bl() throws RemoteException;

    io h() throws RemoteException;

    int j() throws RemoteException;

    k k() throws RemoteException;

    kf kf() throws RemoteException;

    p n() throws RemoteException;

    int ok(int i2) throws RemoteException;

    q ok(int i2, int i3) throws RemoteException;

    DownloadInfo ok() throws RemoteException;

    e p() throws RemoteException;

    i q() throws RemoteException;

    h r() throws RemoteException;

    g s() throws RemoteException;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.model.ok$ok, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0169ok extends Binder implements ok {
        public AbstractBinderC0169ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static ok ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ok)) ? new C0170ok(iBinder) : (ok) iInterfaceQueryLocalInterface;
        }

        public static ok z() {
            return C0170ok.ok;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    DownloadInfo downloadInfoOk = ok();
                    parcel2.writeNoException();
                    if (downloadInfoOk != null) {
                        parcel2.writeInt(1);
                        downloadInfoOk.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    com.ss.android.socialbase.downloader.depend.n nVarA = a();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(nVarA != null ? nVarA.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iOk = ok(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iOk);
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    q qVarOk = ok(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(qVarOk != null ? qVarOk.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    q qVarA = a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(qVarA != null ? qVarA.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    m mVarBl = bl();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(mVarBl != null ? mVarBl.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    g gVarS = s();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(gVarS != null ? gVarS.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    p pVarN = n();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(pVarN != null ? pVarN.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    kf kfVarKf = kf();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(kfVarKf != null ? kfVarKf.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    io ioVarH = h();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(ioVarH != null ? ioVarH.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    e eVarP = p();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(eVarP != null ? eVarP.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    i iVarQ = q();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iVarQ != null ? iVarQ.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    k kVarK = k();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(kVarK != null ? kVarK.asBinder() : null);
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    h hVarR = r();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(hVarR != null ? hVarR.asBinder() : null);
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iJ = j();
                    parcel2.writeNoException();
                    parcel2.writeInt(iJ);
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    j jVarBl = bl(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(jVarBl != null ? jVarBl.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.model.ok$ok$ok, reason: collision with other inner class name */
        public static class C0170ok implements ok {
            public static ok ok;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f10117a;

            public C0170ok(IBinder iBinder) {
                this.f10117a = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.n a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f10117a.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().a();
                    }
                    parcelObtain2.readException();
                    return n.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10117a;
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public m bl() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f10117a.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().bl();
                    }
                    parcelObtain2.readException();
                    return m.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public io h() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f10117a.transact(10, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().h();
                    }
                    parcelObtain2.readException();
                    return io.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public int j() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f10117a.transact(15, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().j();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public k k() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f10117a.transact(13, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().k();
                    }
                    parcelObtain2.readException();
                    return k.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public kf kf() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f10117a.transact(9, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().kf();
                    }
                    parcelObtain2.readException();
                    return kf.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public p n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f10117a.transact(8, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().n();
                    }
                    parcelObtain2.readException();
                    return p.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public DownloadInfo ok() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f10117a.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().ok();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public e p() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f10117a.transact(11, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().p();
                    }
                    parcelObtain2.readException();
                    return e.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public i q() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f10117a.transact(12, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().q();
                    }
                    parcelObtain2.readException();
                    return i.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public h r() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f10117a.transact(14, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().r();
                    }
                    parcelObtain2.readException();
                    return h.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public g s() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f10117a.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().s();
                    }
                    parcelObtain2.readException();
                    return g.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public q a(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i2);
                    if (!this.f10117a.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().a(i2);
                    }
                    parcelObtain2.readException();
                    return q.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public j bl(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i2);
                    if (!this.f10117a.transact(16, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().bl(i2);
                    }
                    parcelObtain2.readException();
                    return j.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public int ok(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i2);
                    if (!this.f10117a.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().ok(i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public q ok(int i2, int i3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    if (!this.f10117a.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0169ok.z() != null) {
                        return AbstractBinderC0169ok.z().ok(i2, i3);
                    }
                    parcelObtain2.readException();
                    return q.ok.ok(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}

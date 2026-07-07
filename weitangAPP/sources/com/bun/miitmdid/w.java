package com.bun.miitmdid;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class w extends n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f5915g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f5916h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f5917i = 5;
    public static int j = 6;
    public static int k = 7;
    public IBinder l = null;
    public Context m;

    public w(Context context) {
        j0.a("QikuIdmanager", "QikuProvider");
        this.m = context;
        b();
    }

    @Override // com.bun.miitmdid.n
    public g a() {
        return null;
    }

    public void b() {
        try {
            Method declaredMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class);
            if (declaredMethod != null) {
                j0.a("QikuIdmanager", "getService success");
                this.l = (IBinder) declaredMethod.invoke(null, "qikuid");
            }
        } catch (Exception e2) {
            Log.e("QikuIdmanager", "Failure get qikuid service", e2);
        }
    }

    @Override // com.bun.miitmdid.n, com.bun.miitmdid.interfaces.IdSupplier
    public String getAAID() {
        j0.a("QikuIdmanager", "getAAID start");
        if (this.l == null) {
            return null;
        }
        j0.a("QikuIdmanager", "mIBinder != null");
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.l.transact(j, parcelObtain, parcelObtain2, 0);
            this.f5892d = parcelObtain2.readString();
            j0.a("QikuIdmanager", "getAAID : " + this.f5892d);
            return this.f5892d;
        } catch (RemoteException e2) {
            j0.a("QikuIdmanager", "getAAID RemoteException");
            e2.printStackTrace();
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.bun.miitmdid.n, com.bun.miitmdid.interfaces.IdSupplier
    public String getOAID() {
        j0.a("QikuIdmanager", "getOAID start");
        if (this.l == null) {
            return null;
        }
        j0.a("QikuIdmanager", "mIBinder != null");
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.l.transact(f5916h, parcelObtain, parcelObtain2, 0);
            this.f5890b = parcelObtain2.readString();
            j0.a("QikuIdmanager", "getOAID : " + this.f5890b);
            return this.f5890b;
        } catch (RemoteException e2) {
            j0.a("QikuIdmanager", "getOAID RemoteException");
            e2.printStackTrace();
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.bun.miitmdid.n, com.bun.miitmdid.interfaces.IdSupplier
    public String getVAID() {
        j0.a("QikuIdmanager", "getVAID start");
        if (this.l == null) {
            return null;
        }
        j0.a("QikuIdmanager", "mIBinder != null");
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.l.transact(f5917i, parcelObtain, parcelObtain2, 0);
            this.f5891c = parcelObtain2.readString();
            j0.a("QikuIdmanager", "getVAID : " + this.f5891c);
            return this.f5891c;
        } catch (RemoteException e2) {
            j0.a("QikuIdmanager", "getVAID RemoteException");
            e2.printStackTrace();
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.bun.miitmdid.n, com.bun.miitmdid.interfaces.IdSupplier
    public boolean isLimited() {
        j0.a("QikuIdmanager", "isLimited start");
        if (this.l != null) {
            j0.a("QikuIdmanager", "mIBinder != null");
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                this.l.transact(9, parcelObtain, parcelObtain2, 0);
                this.f5894f = parcelObtain2.readInt() != 0;
                j0.a("QikuIdmanager", "islimited : " + this.f5894f);
                return this.f5894f;
            } catch (RemoteException e2) {
                j0.a("QikuIdmanager", "isLimited RemoteException");
                e2.printStackTrace();
                return false;
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
        return false;
    }

    @Override // com.bun.miitmdid.n, com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        j0.a("QikuIdmanager", "isSupported start");
        if (this.l != null) {
            j0.a("QikuIdmanager", "mIBinder != null");
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                this.l.transact(f5915g, parcelObtain, parcelObtain2, 0);
                int i2 = parcelObtain2.readInt();
                j0.a("QikuIdmanager", "isSupported : " + i2);
                boolean z = true;
                if (i2 != 1) {
                    z = false;
                }
                this.f5893e = z;
                return z;
            } catch (RemoteException e2) {
                j0.a("QikuIdmanager", "isSupported RemoteException");
                e2.printStackTrace();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
        return false;
    }

    @Override // com.bun.miitmdid.n, com.bun.miitmdid.interfaces.IIdProvider
    public void shutDown() {
        if (this.l != null) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    j0.a("QikuIdmanager", "shutDown");
                    this.l.transact(k, parcelObtain, parcelObtain2, 0);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
    }
}

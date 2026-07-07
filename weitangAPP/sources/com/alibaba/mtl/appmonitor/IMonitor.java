package com.alibaba.mtl.appmonitor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IMonitor extends IInterface {

    public static abstract class Stub extends Binder implements IMonitor {

        public static class a implements IMonitor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f4459a;

            public a(IBinder iBinder) {
                this.f4459a = iBinder;
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public boolean alarm_checkSampled(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f4459a.transact(27, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void alarm_commitFail1(String str, String str2, String str3, String str4, Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeMap(map);
                    this.f4459a.transact(30, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void alarm_commitFail2(String str, String str2, String str3, String str4, String str5, Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    parcelObtain.writeMap(map);
                    this.f4459a.transact(31, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void alarm_commitSuccess1(String str, String str2, Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeMap(map);
                    this.f4459a.transact(28, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void alarm_commitSuccess2(String str, String str2, String str3, Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeMap(map);
                    this.f4459a.transact(29, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void alarm_setSampling(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeInt(i2);
                    this.f4459a.transact(26, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void alarm_setStatisticsInterval(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeInt(i2);
                    this.f4459a.transact(25, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4459a;
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public boolean counter_checkSampled(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f4459a.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void counter_commit1(String str, String str2, double d2, Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeDouble(d2);
                    parcelObtain.writeMap(map);
                    this.f4459a.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void counter_commit2(String str, String str2, String str3, double d2, Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeDouble(d2);
                    parcelObtain.writeMap(map);
                    this.f4459a.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void counter_setSampling(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeInt(i2);
                    this.f4459a.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void counter_setStatisticsInterval(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeInt(i2);
                    this.f4459a.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void destroy() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.f4459a.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void enableLog(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.f4459a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void init() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.f4459a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public boolean offlinecounter_checkSampled(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f4459a.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void offlinecounter_commit(String str, String str2, double d2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeDouble(d2);
                    this.f4459a.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void offlinecounter_setSampling(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeInt(i2);
                    this.f4459a.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void offlinecounter_setStatisticsInterval(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeInt(i2);
                    this.f4459a.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void register1(String str, String str2, MeasureSet measureSet) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (measureSet != null) {
                        parcelObtain.writeInt(1);
                        measureSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f4459a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void register2(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    int i2 = 1;
                    if (measureSet != null) {
                        parcelObtain.writeInt(1);
                        measureSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!z) {
                        i2 = 0;
                    }
                    parcelObtain.writeInt(i2);
                    this.f4459a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void register3(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (measureSet != null) {
                        parcelObtain.writeInt(1);
                        measureSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (dimensionSet != null) {
                        parcelObtain.writeInt(1);
                        dimensionSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f4459a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void register4(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    int i2 = 1;
                    if (measureSet != null) {
                        parcelObtain.writeInt(1);
                        measureSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (dimensionSet != null) {
                        parcelObtain.writeInt(1);
                        dimensionSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!z) {
                        i2 = 0;
                    }
                    parcelObtain.writeInt(i2);
                    this.f4459a.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void setChannel(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    this.f4459a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void setRequestAuthInfo(boolean z, String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.f4459a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void setSampling(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeInt(i2);
                    this.f4459a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void setStatisticsInterval1(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeInt(i2);
                    this.f4459a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void setStatisticsInterval2(int i2, int i3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.f4459a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void stat_begin(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.f4459a.transact(32, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public boolean stat_checkSampled(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f4459a.transact(36, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void stat_commit1(String str, String str2, double d2, Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeDouble(d2);
                    parcelObtain.writeMap(map);
                    this.f4459a.transact(37, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void stat_commit2(String str, String str2, DimensionValueSet dimensionValueSet, double d2, Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (dimensionValueSet != null) {
                        parcelObtain.writeInt(1);
                        dimensionValueSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeDouble(d2);
                    parcelObtain.writeMap(map);
                    this.f4459a.transact(38, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void stat_commit3(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet, Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (dimensionValueSet != null) {
                        parcelObtain.writeInt(1);
                        dimensionValueSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (measureValueSet != null) {
                        parcelObtain.writeInt(1);
                        measureValueSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeMap(map);
                    this.f4459a.transact(39, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void stat_end(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.f4459a.transact(33, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void stat_setSampling(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeInt(i2);
                    this.f4459a.transact(35, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void stat_setStatisticsInterval(int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeInt(i2);
                    this.f4459a.transact(34, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void transaction_begin(Transaction transaction, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    if (transaction != null) {
                        parcelObtain.writeInt(1);
                        transaction.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    this.f4459a.transact(40, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void transaction_end(Transaction transaction, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    if (transaction != null) {
                        parcelObtain.writeInt(1);
                        transaction.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    this.f4459a.transact(41, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void triggerUpload() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.f4459a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void turnOffRealTimeDebug() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.f4459a.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void turnOnRealTimeDebug(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    parcelObtain.writeMap(map);
                    this.f4459a.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.mtl.appmonitor.IMonitor
            public void updateMeasure(String str, String str2, String str3, double d2, double d3, double d4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeDouble(d2);
                    parcelObtain.writeDouble(d3);
                    parcelObtain.writeDouble(d4);
                    this.f4459a.transact(42, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.alibaba.mtl.appmonitor.IMonitor");
        }

        public static IMonitor asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.alibaba.mtl.appmonitor.IMonitor");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMonitor)) ? new a(iBinder) : (IMonitor) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString("com.alibaba.mtl.appmonitor.IMonitor");
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    init();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    enableLog(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    setRequestAuthInfo(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    setChannel(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    triggerUpload();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    setSampling(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    setStatisticsInterval1(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    setStatisticsInterval2(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    register1(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? MeasureSet.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    register2(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? MeasureSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    register3(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? MeasureSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? DimensionSet.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    register4(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? MeasureSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? DimensionSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    turnOnRealTimeDebug(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    turnOffRealTimeDebug();
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    destroy();
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    counter_setStatisticsInterval(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    counter_setSampling(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    boolean zCounter_checkSampled = counter_checkSampled(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCounter_checkSampled ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    counter_commit1(parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    counter_commit2(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    offlinecounter_setStatisticsInterval(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    offlinecounter_setSampling(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    boolean zOfflinecounter_checkSampled = offlinecounter_checkSampled(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zOfflinecounter_checkSampled ? 1 : 0);
                    return true;
                case 24:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    offlinecounter_commit(parcel.readString(), parcel.readString(), parcel.readDouble());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    alarm_setStatisticsInterval(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    alarm_setSampling(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    boolean zAlarm_checkSampled = alarm_checkSampled(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zAlarm_checkSampled ? 1 : 0);
                    return true;
                case 28:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    alarm_commitSuccess1(parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    alarm_commitSuccess2(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    alarm_commitFail1(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    alarm_commitFail2(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    stat_begin(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    stat_end(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    stat_setStatisticsInterval(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    stat_setSampling(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    boolean zStat_checkSampled = stat_checkSampled(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zStat_checkSampled ? 1 : 0);
                    return true;
                case 37:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    stat_commit1(parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    stat_commit2(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? DimensionValueSet.CREATOR.createFromParcel(parcel) : null, parcel.readDouble(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    stat_commit3(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? DimensionValueSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? MeasureValueSet.CREATOR.createFromParcel(parcel) : null, parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    transaction_begin(parcel.readInt() != 0 ? Transaction.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    transaction_end(parcel.readInt() != 0 ? Transaction.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    boolean alarm_checkSampled(String str, String str2) throws RemoteException;

    void alarm_commitFail1(String str, String str2, String str3, String str4, Map map) throws RemoteException;

    void alarm_commitFail2(String str, String str2, String str3, String str4, String str5, Map map) throws RemoteException;

    void alarm_commitSuccess1(String str, String str2, Map map) throws RemoteException;

    void alarm_commitSuccess2(String str, String str2, String str3, Map map) throws RemoteException;

    void alarm_setSampling(int i2) throws RemoteException;

    void alarm_setStatisticsInterval(int i2) throws RemoteException;

    boolean counter_checkSampled(String str, String str2) throws RemoteException;

    void counter_commit1(String str, String str2, double d2, Map map) throws RemoteException;

    void counter_commit2(String str, String str2, String str3, double d2, Map map) throws RemoteException;

    void counter_setSampling(int i2) throws RemoteException;

    void counter_setStatisticsInterval(int i2) throws RemoteException;

    void destroy() throws RemoteException;

    void enableLog(boolean z) throws RemoteException;

    void init() throws RemoteException;

    boolean offlinecounter_checkSampled(String str, String str2) throws RemoteException;

    void offlinecounter_commit(String str, String str2, double d2) throws RemoteException;

    void offlinecounter_setSampling(int i2) throws RemoteException;

    void offlinecounter_setStatisticsInterval(int i2) throws RemoteException;

    void register1(String str, String str2, MeasureSet measureSet) throws RemoteException;

    void register2(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException;

    void register3(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException;

    void register4(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException;

    void setChannel(String str) throws RemoteException;

    void setRequestAuthInfo(boolean z, String str, String str2, String str3) throws RemoteException;

    void setSampling(int i2) throws RemoteException;

    void setStatisticsInterval1(int i2) throws RemoteException;

    void setStatisticsInterval2(int i2, int i3) throws RemoteException;

    void stat_begin(String str, String str2, String str3) throws RemoteException;

    boolean stat_checkSampled(String str, String str2) throws RemoteException;

    void stat_commit1(String str, String str2, double d2, Map map) throws RemoteException;

    void stat_commit2(String str, String str2, DimensionValueSet dimensionValueSet, double d2, Map map) throws RemoteException;

    void stat_commit3(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet, Map map) throws RemoteException;

    void stat_end(String str, String str2, String str3) throws RemoteException;

    void stat_setSampling(int i2) throws RemoteException;

    void stat_setStatisticsInterval(int i2) throws RemoteException;

    void transaction_begin(Transaction transaction, String str) throws RemoteException;

    void transaction_end(Transaction transaction, String str) throws RemoteException;

    void triggerUpload() throws RemoteException;

    void turnOffRealTimeDebug() throws RemoteException;

    void turnOnRealTimeDebug(Map map) throws RemoteException;

    void updateMeasure(String str, String str2, String str3, double d2, double d3, double d4) throws RemoteException;
}

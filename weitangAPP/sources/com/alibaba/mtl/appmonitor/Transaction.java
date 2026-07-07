package com.alibaba.mtl.appmonitor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class Transaction implements Parcelable {
    public static final Parcelable.Creator<Transaction> CREATOR = new Parcelable.Creator<Transaction>() { // from class: com.alibaba.mtl.appmonitor.Transaction.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Transaction[] newArray(int i2) {
            return new Transaction[i2];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Transaction createFromParcel(Parcel parcel) {
            return Transaction.a(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f4462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DimensionValueSet f4463b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f4464e;
    private Object lock;
    public String o;
    public String p;
    public String r;

    public Transaction(Integer num, String str, String str2, DimensionValueSet dimensionValueSet) {
        this(num, str, str2, dimensionValueSet, null);
    }

    public static Transaction a(Parcel parcel) {
        Transaction transaction = new Transaction();
        try {
            transaction.f4463b = (DimensionValueSet) parcel.readParcelable(Transaction.class.getClassLoader());
            transaction.f4462a = Integer.valueOf(parcel.readInt());
            transaction.o = parcel.readString();
            transaction.p = parcel.readString();
            transaction.r = parcel.readString();
            transaction.f4464e = parcel.readHashMap(Transaction.class.getClassLoader());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return transaction;
    }

    public void addDimensionValues(DimensionValueSet dimensionValueSet) {
        synchronized (this.lock) {
            DimensionValueSet dimensionValueSet2 = this.f4463b;
            if (dimensionValueSet2 == null) {
                this.f4463b = dimensionValueSet;
            } else {
                dimensionValueSet2.addValues(dimensionValueSet);
            }
        }
    }

    public void begin(String str) {
        IMonitor iMonitor = AppMonitor.f18a;
        if (iMonitor == null) {
            return;
        }
        try {
            iMonitor.transaction_begin(this, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void end(String str) {
        IMonitor iMonitor = AppMonitor.f18a;
        if (iMonitor == null) {
            return;
        }
        try {
            iMonitor.transaction_end(this, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f4463b, i2);
        parcel.writeInt(this.f4462a.intValue());
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.r);
        parcel.writeMap(this.f4464e);
    }

    public Transaction(Integer num, String str, String str2, DimensionValueSet dimensionValueSet, String str3) {
        this.f4462a = num;
        this.o = str;
        this.p = str2;
        this.r = UUID.randomUUID().toString();
        this.f4463b = dimensionValueSet;
        if (!TextUtils.isEmpty(str3)) {
            HashMap map = new HashMap();
            this.f4464e = map;
            map.put(LogField.APPKEY.toString(), str3);
        }
        this.lock = new Object();
    }

    public void addDimensionValues(String str, String str2) {
        synchronized (this.lock) {
            if (this.f4463b == null) {
                this.f4463b = (DimensionValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(DimensionValueSet.class, new Object[0]);
            }
            this.f4463b.setValue(str, str2);
        }
    }

    public Transaction() {
    }
}

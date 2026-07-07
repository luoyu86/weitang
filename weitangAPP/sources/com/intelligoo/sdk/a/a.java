package com.intelligoo.sdk.a;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.intelligoo.sdk.utils.AdRecordUtil;
import com.intelligoo.sdk.utils.HexUtil;
import com.tom_roush.fontbox.ttf.OpenTypeScript;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.intelligoo.sdk.a.a.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.intelligoo.sdk.a.a.b f9165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BluetoothDevice f9166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Long, Integer> f9167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f9168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f9170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f9172h;

    public a(BluetoothDevice bluetoothDevice, int i2, byte[] bArr, long j) {
        this.f9166b = bluetoothDevice;
        this.f9169e = i2;
        this.f9170f = j;
        this.f9165a = new com.intelligoo.sdk.a.a.b(AdRecordUtil.parseScanRecordAsSparseArray(bArr));
        this.f9168d = bArr;
        this.f9167c = new LinkedHashMap(10);
        a(j, i2);
    }

    public a(Parcel parcel) {
        Bundle bundle = parcel.readBundle(getClass().getClassLoader());
        this.f9171g = bundle.getInt("current_rssi", 0);
        this.f9172h = bundle.getLong("current_timestamp", 0L);
        this.f9166b = (BluetoothDevice) bundle.getParcelable("bluetooth_device");
        this.f9169e = bundle.getInt("device_first_rssi", 0);
        this.f9170f = bundle.getLong("first_timestamp", 0L);
        this.f9165a = (com.intelligoo.sdk.a.a.b) bundle.getParcelable("device_scanrecord_store");
        this.f9167c = (Map) bundle.getSerializable("device_rssi_log");
        this.f9168d = bundle.getByteArray("device_scanrecord");
    }

    private static String a(int i2) {
        switch (i2) {
            case 10:
                return "UnBonded";
            case 11:
                return "Pairing";
            case 12:
                return "Paired";
            default:
                return OpenTypeScript.UNKNOWN;
        }
    }

    private void b(long j, int i2) {
        synchronized (this.f9167c) {
            if (j - this.f9172h > 10000) {
                this.f9167c.clear();
            }
            this.f9171g = i2;
            this.f9172h = j;
            this.f9167c.put(Long.valueOf(j), Integer.valueOf(i2));
        }
    }

    public String a() {
        return a(this.f9166b.getBondState());
    }

    public void a(long j, int i2) {
        b(j, i2);
    }

    public String b() {
        return com.intelligoo.sdk.a.b.a.a(this.f9166b.getBluetoothClass().getDeviceClass());
    }

    public String c() {
        return this.f9166b.getName();
    }

    public int d() {
        return this.f9171g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f9171g != aVar.f9171g || this.f9172h != aVar.f9172h) {
            return false;
        }
        BluetoothDevice bluetoothDevice = this.f9166b;
        if (bluetoothDevice == null) {
            if (aVar.f9166b != null) {
                return false;
            }
        } else if (!bluetoothDevice.equals(aVar.f9166b)) {
            return false;
        }
        if (this.f9169e != aVar.f9169e || this.f9170f != aVar.f9170f) {
            return false;
        }
        com.intelligoo.sdk.a.a.b bVar = this.f9165a;
        if (bVar == null) {
            if (aVar.f9165a != null) {
                return false;
            }
        } else if (!bVar.equals(aVar.f9165a)) {
            return false;
        }
        Map<Long, Integer> map = this.f9167c;
        if (map == null) {
            if (aVar.f9167c != null) {
                return false;
            }
        } else if (!map.equals(aVar.f9167c)) {
            return false;
        }
        return Arrays.equals(this.f9168d, aVar.f9168d);
    }

    public int hashCode() {
        int i2 = (this.f9171g + 31) * 31;
        long j = this.f9172h;
        int i3 = (i2 + ((int) (j ^ (j >>> 32)))) * 31;
        BluetoothDevice bluetoothDevice = this.f9166b;
        int iHashCode = (((i3 + (bluetoothDevice == null ? 0 : bluetoothDevice.hashCode())) * 31) + this.f9169e) * 31;
        long j2 = this.f9170f;
        int i4 = (iHashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        com.intelligoo.sdk.a.a.b bVar = this.f9165a;
        int iHashCode2 = (i4 + (bVar == null ? 0 : bVar.hashCode())) * 31;
        Map<Long, Integer> map = this.f9167c;
        return ((iHashCode2 + (map != null ? map.hashCode() : 0)) * 31) + Arrays.hashCode(this.f9168d);
    }

    public String toString() {
        return "BluetoothLeDevice [mDevice=" + this.f9166b + ", mRssi=" + this.f9169e + ", mScanRecord=" + HexUtil.encodeHexStr(this.f9168d) + ", mRecordStore=" + this.f9165a + ", getBluetoothDeviceBondState()=" + a() + ", getBluetoothDeviceClassName()=" + b() + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Bundle bundle = new Bundle(getClass().getClassLoader());
        bundle.putByteArray("device_scanrecord", this.f9168d);
        bundle.putInt("device_first_rssi", this.f9169e);
        bundle.putInt("current_rssi", this.f9171g);
        bundle.putLong("first_timestamp", this.f9170f);
        bundle.putLong("current_timestamp", this.f9172h);
        bundle.putParcelable("bluetooth_device", this.f9166b);
        bundle.putParcelable("device_scanrecord_store", this.f9165a);
        bundle.putSerializable("device_rssi_log", (Serializable) this.f9167c);
        parcel.writeBundle(bundle);
    }
}

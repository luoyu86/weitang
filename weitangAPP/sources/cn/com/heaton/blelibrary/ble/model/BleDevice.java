package cn.com.heaton.blelibrary.ble.model;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import cn.com.heaton.blelibrary.ble.BleStates;

/* JADX INFO: loaded from: classes.dex */
public class BleDevice implements Parcelable {
    private static final long serialVersionUID = -2576082824642358033L;
    private boolean isAutoConnectting;
    private boolean mAutoConnect;
    private String mBleAddress;
    private String mBleAlias;
    private String mBleName;
    private int mConnectionState;
    private ScanRecord scanRecord;
    public static final String TAG = BleDevice.class.getSimpleName();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<BleDevice> CREATOR = new Parcelable.Creator<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.model.BleDevice.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BleDevice createFromParcel(Parcel parcel) {
            return new BleDevice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BleDevice[] newArray(int i2) {
            return new BleDevice[i2];
        }
    };

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public BleDevice(BluetoothDevice bluetoothDevice) {
        this.mConnectionState = BleStates.BleStatus.DISCONNECT;
        this.mAutoConnect = false;
        this.isAutoConnectting = false;
        this.mBleAddress = bluetoothDevice.getAddress();
        this.mBleName = bluetoothDevice.getName();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBleAddress() {
        return this.mBleAddress;
    }

    public String getBleAlias() {
        return this.mBleAlias;
    }

    public String getBleName() {
        return this.mBleName;
    }

    public int getConnectionState() {
        return this.mConnectionState;
    }

    public ScanRecord getScanRecord() {
        return this.scanRecord;
    }

    public boolean isAutoConnect() {
        return this.mAutoConnect;
    }

    public boolean isAutoConnectting() {
        return this.isAutoConnectting;
    }

    public boolean isConnected() {
        return this.mConnectionState == 2505;
    }

    public boolean isConnectting() {
        return this.mConnectionState == 2504;
    }

    public void setAutoConnect(boolean z) {
        this.mAutoConnect = z;
    }

    public void setAutoConnectting(boolean z) {
        this.isAutoConnectting = z;
    }

    public void setBleAddress(String str) {
        this.mBleAddress = str;
    }

    public void setBleAlias(String str) {
        this.mBleAlias = str;
    }

    public void setBleName(String str) {
        this.mBleName = str;
    }

    public void setConnectionState(int i2) {
        this.mConnectionState = i2;
    }

    public void setScanRecord(ScanRecord scanRecord) {
        this.scanRecord = scanRecord;
    }

    public String toString() {
        return "BleDevice{mConnectionState=" + this.mConnectionState + ", mBleAddress='" + this.mBleAddress + "', mBleName='" + this.mBleName + "', mBleAlias='" + this.mBleAlias + "', mAutoConnect=" + this.mAutoConnect + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mConnectionState);
        parcel.writeString(this.mBleAddress);
        parcel.writeString(this.mBleName);
        parcel.writeString(this.mBleAlias);
        parcel.writeByte(this.mAutoConnect ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isAutoConnectting ? (byte) 1 : (byte) 0);
    }

    public BleDevice(Parcel parcel) {
        this.mConnectionState = BleStates.BleStatus.DISCONNECT;
        this.mAutoConnect = false;
        this.isAutoConnectting = false;
        this.mConnectionState = parcel.readInt();
        this.mBleAddress = parcel.readString();
        this.mBleName = parcel.readString();
        this.mBleAlias = parcel.readString();
        this.mAutoConnect = parcel.readByte() != 0;
        this.isAutoConnectting = parcel.readByte() != 0;
    }
}

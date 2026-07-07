package cn.com.heaton.blelibrary.ble.event;

import android.bluetooth.BluetoothGatt;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ReceiveDataEvent {
    private byte[] data;
    private BluetoothGatt gatt;

    public ReceiveDataEvent(BluetoothGatt bluetoothGatt, byte[] bArr) {
        this.gatt = bluetoothGatt;
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public BluetoothGatt getGatt() {
        return this.gatt;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setGatt(BluetoothGatt bluetoothGatt) {
        this.gatt = bluetoothGatt;
    }

    public String toString() {
        return "ReceiveDataEvent{gatt=" + this.gatt + ", data=" + Arrays.toString(this.data) + '}';
    }
}

package cn.com.heaton.blelibrary.ble.event;

import android.bluetooth.BluetoothGatt;

/* JADX INFO: loaded from: classes.dex */
public class SetNotifySuccessEvent {
    private BluetoothGatt gatt;

    public SetNotifySuccessEvent(BluetoothGatt bluetoothGatt) {
        this.gatt = bluetoothGatt;
    }

    public BluetoothGatt getGatt() {
        return this.gatt;
    }

    public void setGatt(BluetoothGatt bluetoothGatt) {
        this.gatt = bluetoothGatt;
    }
}

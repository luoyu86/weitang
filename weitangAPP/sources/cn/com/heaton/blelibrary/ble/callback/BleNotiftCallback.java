package cn.com.heaton.blelibrary.ble.callback;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

/* JADX INFO: loaded from: classes.dex */
public abstract class BleNotiftCallback<T> {
    public abstract void onChanged(T t, BluetoothGattCharacteristic bluetoothGattCharacteristic);

    public void onNotifySuccess(BluetoothGatt bluetoothGatt) {
    }

    public void onReady(T t) {
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt) {
    }
}

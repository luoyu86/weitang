package cn.com.heaton.blelibrary.ble.callback;

import android.bluetooth.BluetoothGattCharacteristic;

/* JADX INFO: loaded from: classes.dex */
public interface BleWriteCallback<T> {
    void onWriteSuccess(BluetoothGattCharacteristic bluetoothGattCharacteristic);
}

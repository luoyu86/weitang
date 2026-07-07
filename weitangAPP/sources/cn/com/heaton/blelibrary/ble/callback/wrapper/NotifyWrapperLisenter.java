package cn.com.heaton.blelibrary.ble.callback.wrapper;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

/* JADX INFO: loaded from: classes.dex */
public interface NotifyWrapperLisenter<T> {
    void onChanged(T t, BluetoothGattCharacteristic bluetoothGattCharacteristic);

    void onNotifySuccess(BluetoothGatt bluetoothGatt);

    void onReady(T t);

    void onServicesDiscovered(BluetoothGatt bluetoothGatt);
}

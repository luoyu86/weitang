package cn.com.heaton.blelibrary.ble.callback.wrapper;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes.dex */
public interface ConnectWrapperLisenter {
    void onConnectException(BluetoothDevice bluetoothDevice);

    void onConnectTimeOut(BluetoothDevice bluetoothDevice);

    void onConnectionChanged(BluetoothDevice bluetoothDevice, int i2);
}

package cn.com.heaton.blelibrary.ble.proxy;

import android.bluetooth.BluetoothDevice;
import cn.com.heaton.blelibrary.ble.callback.BleConnectCallback;
import cn.com.heaton.blelibrary.ble.callback.BleMtuCallback;
import cn.com.heaton.blelibrary.ble.callback.BleNotiftCallback;
import cn.com.heaton.blelibrary.ble.callback.BleReadCallback;
import cn.com.heaton.blelibrary.ble.callback.BleReadRssiCallback;
import cn.com.heaton.blelibrary.ble.callback.BleScanCallback;
import cn.com.heaton.blelibrary.ble.callback.BleWriteCallback;
import cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback;
import cn.com.heaton.blelibrary.ble.model.EntityData;

/* JADX INFO: loaded from: classes.dex */
public interface RequestLisenter<T> {
    void cancelWriteEntity();

    boolean connect(T t, BluetoothDevice bluetoothDevice, BleConnectCallback<T> bleConnectCallback);

    boolean connect(T t, BleConnectCallback<T> bleConnectCallback);

    boolean connect(String str, BleConnectCallback<T> bleConnectCallback);

    void disconnect(T t);

    void disconnect(T t, BleConnectCallback<T> bleConnectCallback);

    void notify(T t, BleNotiftCallback<T> bleNotiftCallback);

    boolean read(T t, BleReadCallback<T> bleReadCallback);

    boolean readRssi(T t, BleReadRssiCallback<T> bleReadRssiCallback);

    boolean setMtu(String str, int i2, BleMtuCallback<T> bleMtuCallback);

    void startAdvertising(byte[] bArr);

    void startScan(BleScanCallback<T> bleScanCallback, String str);

    void stopAdvertising();

    void stopScan();

    void unNotify(T t);

    boolean write(T t, byte[] bArr, BleWriteCallback<T> bleWriteCallback);

    void writeEntity(EntityData entityData, BleWriteEntityCallback<T> bleWriteEntityCallback);

    void writeEntity(T t, byte[] bArr, int i2, int i3, BleWriteEntityCallback<T> bleWriteEntityCallback);
}

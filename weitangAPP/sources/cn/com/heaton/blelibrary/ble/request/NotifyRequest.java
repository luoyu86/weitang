package cn.com.heaton.blelibrary.ble.request;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import cn.com.heaton.blelibrary.ble.annotation.Implement;
import cn.com.heaton.blelibrary.ble.callback.BleNotiftCallback;
import cn.com.heaton.blelibrary.ble.callback.wrapper.NotifyWrapperLisenter;
import cn.com.heaton.blelibrary.ble.model.BleDevice;
import cn.com.heaton.blelibrary.ble.utils.TaskExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Implement(NotifyRequest.class)
public class NotifyRequest<T extends BleDevice> implements NotifyWrapperLisenter<T> {
    private static final String TAG = "NotifyRequest";
    private List<BleNotiftCallback> mNotifyCallbacks = new ArrayList();
    private HashMap<T, List<BleNotiftCallback>> mBleNotifyMaps = new HashMap<>();

    public void notify(T t, BleNotiftCallback<T> bleNotiftCallback) {
        if (this.mNotifyCallbacks.contains(bleNotiftCallback)) {
            return;
        }
        if (this.mBleNotifyMaps.containsKey(t)) {
            this.mBleNotifyMaps.get(t).add(bleNotiftCallback);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bleNotiftCallback);
            this.mBleNotifyMaps.put(t, arrayList);
        }
        this.mNotifyCallbacks.add(bleNotiftCallback);
    }

    @Override // cn.com.heaton.blelibrary.ble.callback.wrapper.NotifyWrapperLisenter
    public void onNotifySuccess(final BluetoothGatt bluetoothGatt) {
        TaskExecutor.mainThread(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.request.NotifyRequest.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = NotifyRequest.this.mNotifyCallbacks.iterator();
                while (it.hasNext()) {
                    ((BleNotiftCallback) it.next()).onNotifySuccess(bluetoothGatt);
                }
            }
        });
    }

    @Override // cn.com.heaton.blelibrary.ble.callback.wrapper.NotifyWrapperLisenter
    public void onReady(T t) {
    }

    @Override // cn.com.heaton.blelibrary.ble.callback.wrapper.NotifyWrapperLisenter
    public void onServicesDiscovered(final BluetoothGatt bluetoothGatt) {
        TaskExecutor.mainThread(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.request.NotifyRequest.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = NotifyRequest.this.mNotifyCallbacks.iterator();
                while (it.hasNext()) {
                    ((BleNotiftCallback) it.next()).onServicesDiscovered(bluetoothGatt);
                }
            }
        });
    }

    public void unNotify(T t) {
        if (this.mBleNotifyMaps.containsKey(t)) {
            this.mNotifyCallbacks.removeAll(this.mBleNotifyMaps.get(t));
            this.mBleNotifyMaps.remove(t);
        }
    }

    @Override // cn.com.heaton.blelibrary.ble.callback.wrapper.NotifyWrapperLisenter
    public void onChanged(T t, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Iterator<BleNotiftCallback> it = this.mNotifyCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onChanged(t, bluetoothGattCharacteristic);
        }
    }
}

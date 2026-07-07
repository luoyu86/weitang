package cn.com.heaton.blelibrary.ble.callback;

import android.bluetooth.BluetoothDevice;
import androidx.annotation.RequiresApi;
import cn.com.heaton.blelibrary.ble.model.ScanRecord;

/* JADX INFO: loaded from: classes.dex */
public abstract class BleScanCallback<T> {
    public abstract void onLeScan(T t, int i2, byte[] bArr, BluetoothDevice bluetoothDevice);

    @RequiresApi(api = 21)
    public void onParsedData(T t, ScanRecord scanRecord) {
    }

    public void onScanFailed(int i2) {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}

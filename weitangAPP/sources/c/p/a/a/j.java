package c.p.a.a;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes2.dex */
public interface j {
    void onConnect();

    void onConnectError(String str);

    void onReadResult(String str);

    void onScanEnd();

    void onScanError(String str);

    void onScanResult(BluetoothDevice bluetoothDevice);

    void onScanStart();

    void onUnlockFailed(String str);

    void onUnlockPwdFailed(String str);

    void onUnlockSuccess();

    void onUnlocking();
}

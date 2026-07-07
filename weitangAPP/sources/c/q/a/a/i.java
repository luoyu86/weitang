package c.q.a.a;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes2.dex */
public interface i {
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

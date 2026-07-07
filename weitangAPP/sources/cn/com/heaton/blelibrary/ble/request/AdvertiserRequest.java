package cn.com.heaton.blelibrary.ble.request;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import cn.com.heaton.blelibrary.ble.BleHandler;
import cn.com.heaton.blelibrary.ble.L;
import cn.com.heaton.blelibrary.ble.annotation.Implement;
import cn.com.heaton.blelibrary.ble.exception.AdvertiserUnsupportException;
import cn.com.heaton.blelibrary.ble.model.BleDevice;
import cn.com.heaton.blelibrary.ble.utils.TaskExecutor;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
@Implement(AdvertiserRequest.class)
public class AdvertiserRequest<T extends BleDevice> {
    private static final String TAG = "AdvertiserRequest";
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothLeAdvertiser mAdvertiser;
    private Handler mHandler;
    private AdvertiseData myAdvertiseData;
    private AdvertiseSettings myAdvertiseSettings;
    private Runnable stopAvertiseRunnable = new Runnable() { // from class: cn.com.heaton.blelibrary.ble.request.AdvertiserRequest.3
        @Override // java.lang.Runnable
        public void run() {
            AdvertiserRequest.this.stopAdvertising();
        }
    };
    private AdvertiseCallback mAdvertiseCallback = new AdvertiseCallback() { // from class: cn.com.heaton.blelibrary.ble.request.AdvertiserRequest.4
        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartFailure(int i2) {
            super.onStartFailure(i2);
            if (i2 == 1) {
                L.e(AdvertiserRequest.TAG, "Failed to start advertising as the advertise data to be broadcasted is larger than 31 bytes.");
                return;
            }
            if (i2 == 2) {
                L.e(AdvertiserRequest.TAG, "Failed to start advertising because no advertising instance is available.");
                return;
            }
            if (i2 == 3) {
                L.e(AdvertiserRequest.TAG, "Failed to start advertising as the advertising is already started");
            } else if (i2 == 4) {
                L.e(AdvertiserRequest.TAG, "Operation failed due to an internal error");
            } else if (i2 == 5) {
                L.e(AdvertiserRequest.TAG, "This feature is not supported on this platform");
            }
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartSuccess(AdvertiseSettings advertiseSettings) {
            super.onStartSuccess(advertiseSettings);
            L.e(AdvertiserRequest.TAG, "onStartSuccess: 开启广播成功");
        }
    };

    public AdvertiserRequest() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.bluetoothAdapter = defaultAdapter;
        this.mAdvertiser = defaultAdapter.getBluetoothLeAdvertiser();
        this.mHandler = BleHandler.of();
        if (this.mAdvertiser == null) {
            try {
                throw new AdvertiserUnsupportException("Device does not support Avertise!");
            } catch (AdvertiserUnsupportException e2) {
                e2.printStackTrace();
            }
        }
        this.myAdvertiseSettings = new AdvertiseSettings.Builder().setAdvertiseMode(2).setConnectable(true).setTimeout(0).setTxPowerLevel(3).build();
    }

    public void startAdvertising(final byte[] bArr) {
        this.mHandler.removeCallbacks(this.stopAvertiseRunnable);
        if (this.mAdvertiser != null) {
            TaskExecutor.executeTask(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.request.AdvertiserRequest.1
                @Override // java.lang.Runnable
                public void run() {
                    AdvertiserRequest.this.mAdvertiser.stopAdvertising(AdvertiserRequest.this.mAdvertiseCallback);
                    AdvertiserRequest.this.myAdvertiseData = new AdvertiseData.Builder().addManufacturerData(65520, bArr).setIncludeDeviceName(true).build();
                    AdvertiserRequest.this.mAdvertiser.startAdvertising(AdvertiserRequest.this.myAdvertiseSettings, AdvertiserRequest.this.myAdvertiseData, AdvertiserRequest.this.mAdvertiseCallback);
                }
            });
        }
    }

    public void stopAdvertising() {
        if (this.mAdvertiser != null) {
            TaskExecutor.executeTask(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.request.AdvertiserRequest.2
                @Override // java.lang.Runnable
                public void run() {
                    L.e(AdvertiserRequest.TAG, "stopAdvertising: 停止广播");
                    AdvertiserRequest.this.mAdvertiser.stopAdvertising(AdvertiserRequest.this.mAdvertiseCallback);
                }
            });
        }
    }

    public void stopAdvertising(Long l) {
        this.mHandler.postDelayed(this.stopAvertiseRunnable, l.longValue());
    }
}

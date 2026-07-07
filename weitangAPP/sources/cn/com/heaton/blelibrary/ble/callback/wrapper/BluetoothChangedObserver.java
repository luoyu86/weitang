package cn.com.heaton.blelibrary.ble.callback.wrapper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.com.heaton.blelibrary.ble.BleStates;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothChangedObserver {
    private BleReceiver mBleReceiver;
    private BluetoothStatusLisenter mBluetoothStatusLisenter;
    private Context mContext;

    public class BleReceiver extends BroadcastReceiver {
        private WeakReference<BluetoothChangedObserver> mObserverWeakReference;

        public BleReceiver(BluetoothChangedObserver bluetoothChangedObserver) {
            this.mObserverWeakReference = new WeakReference<>(bluetoothChangedObserver);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                BluetoothChangedObserver bluetoothChangedObserver = this.mObserverWeakReference.get();
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (intExtra == 12) {
                    bluetoothChangedObserver.mBluetoothStatusLisenter.onBluetoothStatusChanged(BleStates.BleStatus.BlutoothStatusOn);
                } else if (intExtra == 10) {
                    bluetoothChangedObserver.mBluetoothStatusLisenter.onBluetoothStatusChanged(BleStates.BleStatus.BlutoothStatusOff);
                }
            }
        }
    }

    public interface BluetoothStatusLisenter {
        void onBluetoothStatusChanged(int i2);
    }

    public BluetoothChangedObserver(Context context) {
        this.mContext = context;
    }

    public void registerReceiver() {
        this.mBleReceiver = new BleReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.mContext.registerReceiver(this.mBleReceiver, intentFilter);
    }

    public void setBluetoothStatusLisenter(BluetoothStatusLisenter bluetoothStatusLisenter) {
        this.mBluetoothStatusLisenter = bluetoothStatusLisenter;
    }

    public void unregisterReceiver() {
        try {
            this.mContext.unregisterReceiver(this.mBleReceiver);
            this.mBluetoothStatusLisenter = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

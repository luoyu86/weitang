package cn.com.heaton.blelibrary.ble.request;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Build;
import androidx.annotation.RequiresApi;
import cn.com.heaton.blelibrary.ble.Ble;
import cn.com.heaton.blelibrary.ble.BleHandler;
import cn.com.heaton.blelibrary.ble.L;
import cn.com.heaton.blelibrary.ble.annotation.Implement;
import cn.com.heaton.blelibrary.ble.callback.BleScanCallback;
import cn.com.heaton.blelibrary.ble.callback.BleStatusCallback;
import cn.com.heaton.blelibrary.ble.callback.wrapper.BluetoothChangedObserver;
import cn.com.heaton.blelibrary.ble.model.BleDevice;
import cn.com.heaton.blelibrary.ble.model.ScanRecord;
import cn.com.heaton.blelibrary.ble.utils.BleUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Implement(ScanRequest.class)
public class ScanRequest<T extends BleDevice> {
    private static final String TAG = "ScanRequest";
    private BluetoothChangedObserver mBleObserver;
    private BleStatusCallback mBleStatusCallback;
    private BluetoothAdapter mBluetoothAdapter;
    private List<ScanFilter> mFilters;
    private BleScanCallback<T> mScanCallback;
    private BluetoothLeScanner mScanner;
    private ScanRequest<T>.BLEScanCallback mScannerCallback;
    private ScanSettings mScannerSetting;
    private boolean mScanning;
    private ArrayList<T> mScanDevices = new ArrayList<>();
    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: cn.com.heaton.blelibrary.ble.request.ScanRequest.2
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
            ScanRequest.this.dispatcherScanResult(bluetoothDevice, i2, bArr);
        }
    };
    private BluetoothChangedObserver.BluetoothStatusLisenter mBluetoothStatusLisenter = new BluetoothChangedObserver.BluetoothStatusLisenter() { // from class: cn.com.heaton.blelibrary.ble.request.ScanRequest.3
        @Override // cn.com.heaton.blelibrary.ble.callback.wrapper.BluetoothChangedObserver.BluetoothStatusLisenter
        public void onBluetoothStatusChanged(int i2) {
            L.i(ScanRequest.TAG, "onBluetoothStatusChanged>>>" + i2);
            if (i2 != 2527) {
                if (ScanRequest.this.mBleStatusCallback != null) {
                    ScanRequest.this.mBleStatusCallback.onBluetoothStatusOn();
                }
            } else {
                if (ScanRequest.this.mScanning) {
                    ScanRequest.this.stopScan();
                }
                if (ScanRequest.this.mBleStatusCallback != null) {
                    ScanRequest.this.mBleStatusCallback.onBluetoothStatusOff();
                }
            }
        }
    };

    @RequiresApi(api = 21)
    public class BLEScanCallback extends ScanCallback {
        private BLEScanCallback() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            Iterator<ScanResult> it = list.iterator();
            while (it.hasNext()) {
                L.i("ScanResult - Results", it.next().toString());
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i2) {
            L.e("Scan Failed", "Error Code: " + i2);
            if (ScanRequest.this.mScanCallback != null) {
                ScanRequest.this.mScanCallback.onScanFailed(i2);
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i2, ScanResult scanResult) {
            ScanRecord fromBytes;
            BluetoothDevice device = scanResult.getDevice();
            byte[] bytes = scanResult.getScanRecord().getBytes();
            BleDevice bleDeviceDispatcherScanResult = ScanRequest.this.dispatcherScanResult(device, scanResult.getRssi(), bytes);
            if (!Ble.options().isParseScanData || (fromBytes = ScanRecord.parseFromBytes(bytes)) == null || ScanRequest.this.mScanCallback == null) {
                return;
            }
            ScanRequest.this.mScanCallback.onParsedData(bleDeviceDispatcherScanResult, fromBytes);
        }
    }

    public ScanRequest() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothAdapter = defaultAdapter;
        if (Build.VERSION.SDK_INT >= 21) {
            this.mScanner = defaultAdapter.getBluetoothLeScanner();
            this.mScannerSetting = new ScanSettings.Builder().setScanMode(2).build();
            this.mScannerCallback = new BLEScanCallback();
            this.mFilters = new ArrayList();
        }
        if (this.mBleObserver == null) {
            BluetoothChangedObserver bluetoothChangedObserver = new BluetoothChangedObserver(Ble.getInstance().getContext());
            this.mBleObserver = bluetoothChangedObserver;
            bluetoothChangedObserver.setBluetoothStatusLisenter(this.mBluetoothStatusLisenter);
            this.mBleObserver.registerReceiver();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public T dispatcherScanResult(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
        BleScanCallback<T> bleScanCallback;
        if (bluetoothDevice == null) {
            return null;
        }
        T t = (T) getDevice(bluetoothDevice.getAddress());
        if (t == null) {
            t = (T) new BleDevice(bluetoothDevice);
            BleScanCallback<T> bleScanCallback2 = this.mScanCallback;
            if (bleScanCallback2 != null) {
                bleScanCallback2.onLeScan(t, i2, bArr, bluetoothDevice);
            }
            this.mScanDevices.add(t);
        } else if (!Ble.options().isFilterScan && (bleScanCallback = this.mScanCallback) != null) {
            bleScanCallback.onLeScan(t, i2, bArr, bluetoothDevice);
        }
        return t;
    }

    private T getDevice(String str) {
        for (T t : this.mScanDevices) {
            if (t.getBleAddress().equals(str)) {
                return t;
            }
        }
        return null;
    }

    @RequiresApi(api = 21)
    private void setScanSettings(String str) {
        boolean zIsBackground = BleUtils.isBackground(Ble.getInstance().getContext());
        L.i(TAG, "currently in the background:>>>>>" + zIsBackground);
        if (zIsBackground) {
            this.mFilters = new ArrayList();
            Ble.options().getUuidService();
            this.mFilters.add(new ScanFilter.Builder().setDeviceAddress(str).build());
            this.mScannerSetting = new ScanSettings.Builder().setScanMode(0).build();
            return;
        }
        this.mFilters = new ArrayList();
        Ble.options().getUuidService();
        this.mFilters.add(new ScanFilter.Builder().setDeviceAddress(str).build());
        this.mScannerSetting = new ScanSettings.Builder().setScanMode(2).build();
    }

    public boolean isScanning() {
        return this.mScanning;
    }

    public void setBluetoothStatusCallback(BleStatusCallback bleStatusCallback) {
        this.mBleStatusCallback = bleStatusCallback;
    }

    public void startScan(BleScanCallback<T> bleScanCallback, long j, String str) {
        if (this.mScanning) {
            return;
        }
        if (bleScanCallback != null) {
            this.mScanCallback = bleScanCallback;
        }
        this.mScanning = true;
        BleHandler.of().postDelayed(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.request.ScanRequest.1
            @Override // java.lang.Runnable
            public void run() {
                if (ScanRequest.this.mScanning) {
                    ScanRequest.this.stopScan();
                }
            }
        }, j);
        if (Build.VERSION.SDK_INT < 21) {
            this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
        } else if (this.mBluetoothAdapter.isEnabled()) {
            if (this.mScanner == null) {
                this.mScanner = this.mBluetoothAdapter.getBluetoothLeScanner();
            }
            setScanSettings(str);
            this.mScanner.startScan(this.mFilters, this.mScannerSetting, this.mScannerCallback);
        }
        if (bleScanCallback != null) {
            this.mScanCallback.onStart();
        }
    }

    public void stopScan() {
        if (this.mScanning) {
            this.mScanning = false;
            if (Build.VERSION.SDK_INT < 21) {
                this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
            } else if (this.mBluetoothAdapter.isEnabled()) {
                if (this.mScanner == null) {
                    this.mScanner = this.mBluetoothAdapter.getBluetoothLeScanner();
                }
                this.mScanner.stopScan(this.mScannerCallback);
            }
            this.mScanDevices.clear();
            BleScanCallback<T> bleScanCallback = this.mScanCallback;
            if (bleScanCallback != null) {
                bleScanCallback.onStop();
            }
        }
    }

    public void unRegisterReceiver() {
        BluetoothChangedObserver bluetoothChangedObserver = this.mBleObserver;
        if (bluetoothChangedObserver != null) {
            bluetoothChangedObserver.unregisterReceiver();
        }
    }
}

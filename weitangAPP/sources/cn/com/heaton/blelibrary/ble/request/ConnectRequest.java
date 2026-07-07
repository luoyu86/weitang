package cn.com.heaton.blelibrary.ble.request;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.SystemClock;
import cn.com.heaton.blelibrary.ble.Ble;
import cn.com.heaton.blelibrary.ble.BleStates;
import cn.com.heaton.blelibrary.ble.BluetoothLeService;
import cn.com.heaton.blelibrary.ble.L;
import cn.com.heaton.blelibrary.ble.annotation.Implement;
import cn.com.heaton.blelibrary.ble.callback.BleConnectCallback;
import cn.com.heaton.blelibrary.ble.callback.wrapper.ConnectWrapperLisenter;
import cn.com.heaton.blelibrary.ble.model.BleDevice;
import cn.com.heaton.blelibrary.ble.utils.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Implement(ConnectRequest.class)
public class ConnectRequest<T extends BleDevice> implements ConnectWrapperLisenter {
    private static final String TAG = "ConnectRequest";
    private ConnectRequest<T>.AutoConThread autoConThread;
    private List<BleConnectCallback<T>> mConnectCallbacks = new ArrayList();
    private ArrayList<T> mDevices = new ArrayList<>();
    private ArrayList<T> mConnetedDevices = new ArrayList<>();
    private ArrayList<T> mAutoDevices = new ArrayList<>();
    private final byte[] lock = new byte[1];
    private Ble<T> mBle = Ble.getInstance();

    public class AutoConThread extends Thread {
        private AutoConThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (Ble.options().autoConnect) {
                synchronized (ConnectRequest.this.lock) {
                    if (ConnectRequest.this.mAutoDevices.size() > 0) {
                        ConnectRequest.this.autoConnect();
                        try {
                            Thread.sleep(Ble.options().connectTimeout);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public ConnectRequest() {
        ConnectRequest<T>.AutoConThread autoConThread = new AutoConThread();
        this.autoConThread = autoConThread;
        autoConThread.start();
    }

    private boolean addBleDevice(T t) {
        if (t == null) {
            throw new IllegalArgumentException("device is not null");
        }
        if (getBleDevice(t.getBleAddress()) != null) {
            L.i(TAG, "addBleDevice>>>> Already contains the device");
            return true;
        }
        this.mDevices.add(t);
        L.i(TAG, "addBleDevice>>>> Added a device to the device pool");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoConnect() {
        TaskExecutor.executeTask(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.request.ConnectRequest.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ConnectRequest.this.mBle.getLocker()) {
                    for (int i2 = 0; i2 < ConnectRequest.this.mAutoDevices.size(); i2++) {
                        BleDevice bleDevice = (BleDevice) ConnectRequest.this.mAutoDevices.get(i2);
                        if (bleDevice.getConnectionState() == 2503 && bleDevice.isAutoConnect()) {
                            L.e(ConnectRequest.TAG, "onLeScan: 正在重连设备>>>>..." + bleDevice.getBleName());
                            ConnectRequest.this.mBle.reconnect(bleDevice);
                            SystemClock.sleep(2000L);
                        }
                    }
                }
            }
        });
    }

    public void addAutoPool(T t) {
        if (t == null) {
            return;
        }
        Iterator<T> it = this.mAutoDevices.iterator();
        while (it.hasNext()) {
            if (t.getBleAddress().equals(it.next().getBleAddress())) {
                L.w(TAG, "自动连接池中已存在");
                return;
            }
        }
        if (t.isAutoConnect()) {
            L.w(TAG, "addAutoPool: Add automatic connection device to the connection pool");
            this.mAutoDevices.add(t);
        }
    }

    public boolean connect(T t, BleConnectCallback<T> bleConnectCallback) {
        addBleDevice(t);
        if (bleConnectCallback != null && !this.mConnectCallbacks.contains(bleConnectCallback)) {
            this.mConnectCallbacks.add(bleConnectCallback);
        }
        BluetoothLeService bleService = Ble.getInstance().getBleService();
        if (bleService == null) {
            return false;
        }
        t.setAutoConnect(t.isAutoConnect());
        return bleService.connect(t.getBleAddress());
    }

    public void disconnect(String str) {
        BluetoothLeService bleService;
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            L.d(TAG, "the device address is invalid");
            return;
        }
        if (BluetoothAdapter.getDefaultAdapter() == null || (bleService = Ble.getInstance().getBleService()) == null) {
            return;
        }
        for (T t : getConnetedDevices()) {
            if (t.getBleAddress().equals(str)) {
                t.setAutoConnect(false);
            }
        }
        bleService.disconnect(str);
    }

    public T getBleDevice(int i2) {
        return this.mDevices.get(i2);
    }

    public ArrayList<T> getConnetedDevices() {
        return this.mConnetedDevices;
    }

    public ArrayList<T> getDevices() {
        return this.mDevices;
    }

    @Override // cn.com.heaton.blelibrary.ble.callback.wrapper.ConnectWrapperLisenter
    public void onConnectException(BluetoothDevice bluetoothDevice) {
        final BleDevice bleDevice = getBleDevice(bluetoothDevice);
        if (bleDevice == null) {
            return;
        }
        final int i2 = bleDevice.isConnected() ? BleStates.BleStatus.ConnectException : bleDevice.isConnectting() ? BleStates.BleStatus.ConnectFailed : BleStates.BleStatus.ConnectError;
        L.e(TAG, "ConnectException>>>> " + bleDevice.getBleName() + "\n异常码:" + i2);
        TaskExecutor.mainThread(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.request.ConnectRequest.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ConnectRequest.this.mConnectCallbacks.iterator();
                while (it.hasNext()) {
                    ((BleConnectCallback) it.next()).onConnectException(bleDevice, i2);
                }
            }
        });
    }

    @Override // cn.com.heaton.blelibrary.ble.callback.wrapper.ConnectWrapperLisenter
    public void onConnectTimeOut(BluetoothDevice bluetoothDevice) {
        final BleDevice bleDevice = getBleDevice(bluetoothDevice);
        if (bleDevice == null) {
            return;
        }
        L.e(TAG, "ConnectTimeOut>>>> " + bleDevice.getBleName());
        TaskExecutor.mainThread(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.request.ConnectRequest.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ConnectRequest.this.mConnectCallbacks.iterator();
                while (it.hasNext()) {
                    ((BleConnectCallback) it.next()).onConnectTimeOut(bleDevice);
                }
            }
        });
        onConnectionChanged(bluetoothDevice, BleStates.BleStatus.DISCONNECT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cn.com.heaton.blelibrary.ble.callback.wrapper.ConnectWrapperLisenter
    public void onConnectionChanged(BluetoothDevice bluetoothDevice, int i2) {
        final BleDevice bleDevice = getBleDevice(bluetoothDevice);
        if (bleDevice == null) {
            return;
        }
        bleDevice.setConnectionState(i2);
        if (i2 == 2505) {
            this.mConnetedDevices.add((T) bleDevice);
            L.e(TAG, "CONNECTED>>>> " + bleDevice.getBleName());
            removeAutoPool(bleDevice);
        } else if (i2 == 2503) {
            this.mConnetedDevices.remove(bleDevice);
            this.mDevices.remove(bleDevice);
            L.e(TAG, "DISCONNECT>>>> " + bleDevice.getBleName());
            Ble.getInstance().cancelNotify(bleDevice);
            addAutoPool(bleDevice);
            this.autoConThread.interrupt();
        }
        TaskExecutor.mainThread(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.request.ConnectRequest.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ConnectRequest.this.mConnectCallbacks.iterator();
                while (it.hasNext()) {
                    ((BleConnectCallback) it.next()).onConnectionChanged(bleDevice);
                }
            }
        });
    }

    public void removeAutoPool(BleDevice bleDevice) {
        if (bleDevice == null) {
            return;
        }
        Iterator<T> it = this.mAutoDevices.iterator();
        while (it.hasNext()) {
            if (bleDevice.getBleAddress().equals(it.next().getBleAddress())) {
                it.remove();
            }
        }
    }

    public void resetReConnect(T t, boolean z) {
        if (t == null) {
            return;
        }
        t.setAutoConnect(z);
        if (z) {
            addAutoPool(t);
            return;
        }
        removeAutoPool(t);
        if (t.isConnectting()) {
            disconnect(t);
        }
    }

    public T getBleDevice(String str) {
        if (str == null) {
            L.w(TAG, "By address to get BleDevice but address is null");
            return null;
        }
        synchronized (this.mDevices) {
            if (this.mDevices.size() > 0) {
                for (T t : this.mDevices) {
                    if (t.getBleAddress().equals(str)) {
                        return t;
                    }
                }
            }
            L.w(TAG, "By address to get BleDevice and BleDevice isn't exist");
            return null;
        }
    }

    public boolean connect(T t, BluetoothDevice bluetoothDevice, BleConnectCallback<T> bleConnectCallback) {
        addBleDevice(t);
        if (bleConnectCallback != null && !this.mConnectCallbacks.contains(bleConnectCallback)) {
            this.mConnectCallbacks.add(bleConnectCallback);
        }
        BluetoothLeService bleService = Ble.getInstance().getBleService();
        if (bleService == null) {
            return false;
        }
        t.setAutoConnect(t.isAutoConnect());
        return bleService.connect(bluetoothDevice);
    }

    public void disconnect(BleDevice bleDevice) {
        if (bleDevice != null) {
            disconnect(bleDevice.getBleAddress());
        }
    }

    public void disconnect(BleDevice bleDevice, BleConnectCallback<T> bleConnectCallback) {
        if (bleDevice != null) {
            disconnect(bleDevice.getBleAddress());
            if (bleConnectCallback == null || this.mConnectCallbacks.contains(bleConnectCallback)) {
                return;
            }
            this.mConnectCallbacks.add(bleConnectCallback);
        }
    }

    public T getBleDevice(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            L.w(TAG, "By BluetoothDevice to get BleDevice but BluetoothDevice is null");
            return null;
        }
        return (T) getBleDevice(bluetoothDevice.getAddress());
    }

    public boolean connect(String str, BleConnectCallback<T> bleConnectCallback) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            L.d(TAG, "the device address is invalid");
            return false;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return false;
        }
        return connect(new BleDevice(defaultAdapter.getRemoteDevice(str)), bleConnectCallback);
    }
}

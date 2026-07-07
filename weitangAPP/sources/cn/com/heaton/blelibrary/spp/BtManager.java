package cn.com.heaton.blelibrary.spp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BtManager implements Handler.Callback {
    public static final int MSG_CLOSE = 3077;
    public static final int MSG_DEVICE_CHANGED = 3074;
    public static final int MSG_READ_DATA = 3075;
    public static final int MSG_STATE_CHANGED = 3073;
    public static final int MSG_STOP_SCAN = 3078;
    public static final int MSG_WRITE_DATA = 3076;
    private static final String NAME_INSECURE = "BluetoothChatInsecure";
    private static final String NAME_SECURE = "BluetoothChatSecure";
    public static final int STATE_FINISH = 2819;
    public static final int STATE_IDLE = 2817;
    public static final int STATE_SERVING = 2818;
    public static final String TAG = BtManager.class.getSimpleName();
    private static BtManager btManager;
    private BluetoothAdapter mBluetoothAdapter;
    private BtActionTask mBtActionTask;
    private BtDeviceListener mBtDeviceListener;
    private BtServerThread mBtServerThread;
    private boolean mConnecting;
    private Context mContext;
    private Handler mHandler;
    private int mState;
    private final List<BtDevice> mDevices = new ArrayList();
    private final List<BtDevice> mWaitingDevices = new ArrayList();
    private final List<BtDevice> mConnectingDevices = new ArrayList();
    private final List<BtDevice> mConnectedDevices = new ArrayList();
    private final Object mLocker = new Object();
    private boolean mRegistered = false;
    private boolean mSecure = true;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: cn.com.heaton.blelibrary.spp.BtManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BtDevice btDeviceAddDevice;
            String action = intent.getAction();
            if ("android.bluetooth.device.action.FOUND".equals(action)) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (TextUtils.isEmpty(bluetoothDevice.getName()) || bluetoothDevice.getName().equalsIgnoreCase("null") || (btDeviceAddDevice = BtManager.this.addDevice(bluetoothDevice)) == null || BtManager.this.mBtDeviceListener == null) {
                    return;
                }
                BtManager.this.mBtDeviceListener.onFound(btDeviceAddDevice);
                return;
            }
            if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                if (BtManager.this.mRegistered) {
                    BtManager.this.mRegistered = false;
                    BtManager.this.mContext.unregisterReceiver(BtManager.this.mReceiver);
                }
                if (BtManager.this.mBtDeviceListener != null) {
                    BtManager.this.mBtDeviceListener.onStopScan();
                }
            }
        }
    };

    public class BtActionTask extends AsyncTask<Void, Void, Void> {
        private BtActionTask() {
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            super.onCancelled();
            BtManager.this.mConnecting = false;
            BtManager.this.mBtActionTask = null;
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            BtDevice btDevice;
            if (BtManager.this.mWaitingDevices.size() == 0) {
                return null;
            }
            BtManager.this.mConnecting = true;
            BtManager.this.cancelDiscovery();
            synchronized (BtManager.this.mLocker) {
                btDevice = (BtDevice) BtManager.this.mWaitingDevices.remove(0);
                BtManager.this.mConnectingDevices.add(btDevice);
            }
            while (BtManager.this.mConnecting && btDevice != null) {
                btDevice.connect(BtManager.this.mSecure);
                synchronized (BtManager.this.mLocker) {
                    if (BtManager.this.mWaitingDevices.size() > 0) {
                        btDevice = (BtDevice) BtManager.this.mWaitingDevices.remove(0);
                        BtManager.this.mConnectingDevices.add(btDevice);
                    } else {
                        BtManager.this.mConnecting = false;
                        btDevice = null;
                    }
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Void r2) {
            super.onPostExecute(r2);
            BtManager.this.mConnecting = false;
            BtManager.this.mBtActionTask = null;
        }
    }

    public interface BtDeviceListener {
        void onDevicesChanged();

        void onError(int i2, BtDevice btDevice);

        void onFound(BtDevice btDevice);

        void onRead(byte[] bArr, BtDevice btDevice);

        void onStartScan();

        void onStateChanged(int i2, BtDevice btDevice);

        void onStopScan();

        void onWrite(byte[] bArr, BtDevice btDevice);
    }

    public class BtServerThread extends Thread {
        public BluetoothServerSocket mServerSocket = null;

        public BtServerThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            try {
                BluetoothServerSocket bluetoothServerSocketListenUsingRfcommWithServiceRecord = BtManager.this.mSecure ? BtManager.this.mBluetoothAdapter.listenUsingRfcommWithServiceRecord(BtManager.NAME_SECURE, BtConfig.UUID_SECURE) : BtManager.this.mBluetoothAdapter.listenUsingInsecureRfcommWithServiceRecord(BtManager.NAME_INSECURE, BtConfig.UUID_INSECURE);
                while (BtManager.this.mState == 2818) {
                    try {
                        BluetoothSocket bluetoothSocketAccept = bluetoothServerSocketListenUsingRfcommWithServiceRecord.accept();
                        if (bluetoothSocketAccept != null) {
                            BluetoothDevice remoteDevice = bluetoothSocketAccept.getRemoteDevice();
                            BtManager.this.addDevice(remoteDevice);
                            BtDevice device = BtManager.this.getDevice(remoteDevice);
                            if (device != null) {
                                device.setMaster(true);
                                device.setBluetoothSocket(bluetoothSocketAccept);
                                BtManager.this.onStateChanged(BtDevice.STATE_IDLE, device);
                                return;
                            }
                            return;
                        }
                    } catch (IOException e2) {
                        Log.e(BtManager.TAG, "Socket Type: mSecure=" + BtManager.this.mSecure + ",accept() failed", e2);
                        return;
                    }
                }
            } catch (IOException e3) {
                Log.e(BtManager.TAG, "Socket Type: mSecure=" + BtManager.this.mSecure + ",listen() failed", e3);
            }
        }

        public void stopServing() {
            BluetoothServerSocket bluetoothServerSocket = this.mServerSocket;
            if (bluetoothServerSocket != null) {
                try {
                    bluetoothServerSocket.close();
                } catch (IOException unused) {
                }
            }
            interrupt();
        }
    }

    private BtManager(Context context, BtDeviceListener btDeviceListener) {
        this.mState = STATE_IDLE;
        this.mContext = context;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothAdapter = defaultAdapter;
        this.mBtDeviceListener = btDeviceListener;
        if (defaultAdapter != null) {
            this.mState = STATE_SERVING;
            BtServerThread btServerThread = new BtServerThread();
            this.mBtServerThread = btServerThread;
            btServerThread.start();
        }
        this.mHandler = new Handler(this.mContext.getMainLooper(), this);
    }

    public static BtManager getBtManager() {
        BtManager btManager2 = btManager;
        if (btManager2 != null) {
            return btManager2;
        }
        throw new RuntimeException("请先调用BtManager的init方法进行初始化!");
    }

    private BtDevice getDevice(int i2) {
        synchronized (this.mLocker) {
            for (BtDevice btDevice : this.mDevices) {
                if (btDevice.getIndex() == i2) {
                    return btDevice;
                }
            }
            return null;
        }
    }

    public static BtManager init(Context context, BtDeviceListener btDeviceListener) {
        if (btManager == null) {
            btManager = new BtManager(context, btDeviceListener);
        }
        return btManager;
    }

    public void addDevice(BtDevice btDevice) {
        if (this.mBluetoothAdapter == null || btDevice == null) {
            return;
        }
        synchronized (this.mLocker) {
            if (!contains(btDevice)) {
                this.mDevices.add(btDevice);
                onDevicesChanged();
            }
        }
    }

    public void cancelDiscovery() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter == null || !bluetoothAdapter.isDiscovering()) {
            return;
        }
        this.mBluetoothAdapter.cancelDiscovery();
    }

    public void close(BtDevice btDevice) {
        Handler handler = this.mHandler;
        if (handler == null || btDevice == null) {
            return;
        }
        handler.obtainMessage(MSG_CLOSE, btDevice.getIndex(), 0).sendToTarget();
    }

    public void connect(BtDevice btDevice) {
        if (this.mBluetoothAdapter == null) {
            return;
        }
        synchronized (this.mLocker) {
            if (btDevice != null) {
                if (!btDevice.isConnected() && !btDevice.isConnecting() && this.mDevices.contains(btDevice) && !this.mWaitingDevices.contains(btDevice) && !this.mConnectingDevices.contains(btDevice) && !this.mConnectedDevices.contains(btDevice)) {
                    this.mWaitingDevices.add(btDevice);
                    BtActionTask btActionTask = this.mBtActionTask;
                    if (btActionTask == null || btActionTask.isCancelled()) {
                        this.mBtActionTask = new BtActionTask();
                    }
                    if (this.mConnecting) {
                        return;
                    }
                    this.mConnecting = true;
                    this.mBtActionTask.execute(new Void[0]);
                }
            }
        }
    }

    public boolean contains(BtDevice btDevice) {
        boolean zContains;
        synchronized (this.mLocker) {
            zContains = this.mDevices.contains(btDevice);
        }
        return zContains;
    }

    public void delete(BtDevice btDevice) {
        if (btDevice == null) {
            return;
        }
        btDevice.setDelete(true);
        if (btDevice.isConnected() || btDevice.isConnecting()) {
            btDevice.close();
            return;
        }
        synchronized (this.mLocker) {
            if (this.mWaitingDevices.contains(btDevice)) {
                this.mWaitingDevices.remove(btDevice);
            }
            if (this.mConnectingDevices.contains(btDevice)) {
                this.mConnectingDevices.remove(btDevice);
            }
            if (this.mConnectedDevices.contains(btDevice)) {
                this.mConnectedDevices.remove(btDevice);
            }
            if (this.mDevices.contains(btDevice)) {
                this.mDevices.remove(btDevice);
            }
        }
    }

    public void disconnect(BtDevice btDevice) {
    }

    public BluetoothAdapter getAdapter() {
        return this.mBluetoothAdapter;
    }

    public List<BtDevice> getConnectedDevices() {
        return this.mConnectedDevices;
    }

    public List<BtDevice> getDevices() {
        return this.mDevices;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public Object getLocker() {
        return this.mLocker;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        switch (message.what) {
            case MSG_STATE_CHANGED /* 3073 */:
                BtDeviceListener btDeviceListener = this.mBtDeviceListener;
                if (btDeviceListener != null) {
                    btDeviceListener.onStateChanged(message.arg1, getDevice(message.arg2));
                }
                break;
            case MSG_DEVICE_CHANGED /* 3074 */:
                BtDeviceListener btDeviceListener2 = this.mBtDeviceListener;
                if (btDeviceListener2 != null) {
                    btDeviceListener2.onDevicesChanged();
                }
                break;
            case MSG_READ_DATA /* 3075 */:
                BtDeviceListener btDeviceListener3 = this.mBtDeviceListener;
                if (btDeviceListener3 != null) {
                    btDeviceListener3.onRead((byte[]) message.obj, getDevice(message.arg1));
                }
                break;
            case MSG_WRITE_DATA /* 3076 */:
                BtDeviceListener btDeviceListener4 = this.mBtDeviceListener;
                if (btDeviceListener4 != null) {
                    btDeviceListener4.onWrite((byte[]) message.obj, getDevice(message.arg1));
                }
                break;
            case MSG_CLOSE /* 3077 */:
                BtDevice device = getDevice(message.arg1);
                if (device != null) {
                    device.closeInner();
                }
                break;
            case MSG_STOP_SCAN /* 3078 */:
                cancelDiscovery();
                break;
        }
        return false;
    }

    public void onDevicesChanged() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.obtainMessage(MSG_DEVICE_CHANGED).sendToTarget();
        }
    }

    public void onDisconnected(BtDevice btDevice) {
        if (btDevice == null) {
            return;
        }
        synchronized (this.mLocker) {
            if (this.mWaitingDevices.contains(btDevice)) {
                this.mWaitingDevices.remove(btDevice);
            }
            if (this.mConnectingDevices.contains(btDevice)) {
                this.mConnectingDevices.remove(btDevice);
            }
            if (this.mConnectedDevices.contains(btDevice)) {
                this.mConnectedDevices.remove(btDevice);
            }
            onStateChanged(BtDevice.STATE_IDLE, btDevice);
            if (btDevice.getDelete()) {
                this.mDevices.remove(btDevice);
            }
        }
    }

    public void onReadData(BtDevice btDevice, byte[] bArr) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.obtainMessage(MSG_READ_DATA, btDevice.getIndex(), 0, bArr).sendToTarget();
        }
    }

    public void onStateChanged(int i2, BtDevice btDevice) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.obtainMessage(MSG_STATE_CHANGED, i2, btDevice.getIndex()).sendToTarget();
        }
        if (i2 == 2563) {
            synchronized (this.mLocker) {
                this.mConnectingDevices.remove(btDevice);
                this.mConnectedDevices.add(btDevice);
            }
            return;
        }
        if (i2 == 2561) {
            synchronized (this.mLocker) {
                this.mConnectedDevices.remove(btDevice);
                this.mConnectingDevices.remove(btDevice);
            }
            return;
        }
        if (i2 == 2562) {
            synchronized (this.mLocker) {
                this.mConnectedDevices.remove(btDevice);
            }
        }
    }

    public void onWriteData(BtDevice btDevice, byte[] bArr) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.obtainMessage(MSG_WRITE_DATA, btDevice.getIndex(), 0, bArr).sendToTarget();
        }
    }

    public void release() {
        synchronized (this.mLocker) {
            this.mState = STATE_FINISH;
            Iterator<BtDevice> it = this.mDevices.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            this.mDevices.clear();
            this.mWaitingDevices.clear();
            this.mConnectingDevices.clear();
            BtServerThread btServerThread = this.mBtServerThread;
            if (btServerThread != null) {
                btServerThread.stopServing();
                this.mBtServerThread = null;
            }
            this.mHandler = null;
        }
    }

    public void setSecure(boolean z) {
        if (this.mSecure != z) {
            this.mSecure = z;
        }
    }

    public void startDiscovery() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(MSG_STOP_SCAN);
        }
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null) {
            if (bluetoothAdapter.isDiscovering()) {
                this.mBluetoothAdapter.cancelDiscovery();
            }
            if (!this.mRegistered) {
                this.mRegistered = true;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.bluetooth.device.action.FOUND");
                intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
                this.mContext.registerReceiver(this.mReceiver, intentFilter);
            }
            this.mBluetoothAdapter.startDiscovery();
            BtDeviceListener btDeviceListener = this.mBtDeviceListener;
            if (btDeviceListener != null) {
                btDeviceListener.onStartScan();
            }
            Handler handler2 = this.mHandler;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(MSG_STOP_SCAN, 12000L);
            }
        }
    }

    public boolean contains(BluetoothDevice bluetoothDevice) {
        synchronized (this.mLocker) {
            Iterator<BtDevice> it = this.mDevices.iterator();
            while (it.hasNext()) {
                if (it.next().getAddress().equalsIgnoreCase(bluetoothDevice.getAddress())) {
                    return true;
                }
            }
            return false;
        }
    }

    public BtDevice getDevice(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        synchronized (this.mLocker) {
            for (BtDevice btDevice : this.mDevices) {
                if (bluetoothDevice.equals(btDevice.getBluetoothDevice())) {
                    return btDevice;
                }
            }
            return null;
        }
    }

    public BtDevice addDevice(BluetoothDevice bluetoothDevice) {
        if (this.mBluetoothAdapter == null || bluetoothDevice == null) {
            return null;
        }
        synchronized (this.mLocker) {
            if (!contains(bluetoothDevice)) {
                BtDevice btDevice = new BtDevice(this, bluetoothDevice);
                this.mDevices.add(btDevice);
                onDevicesChanged();
                return btDevice;
            }
            return getDevice(bluetoothDevice);
        }
    }
}

package cn.com.heaton.blelibrary.spp;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class BtDevice {
    public static final int STATE_CONNECTED = 2563;
    public static final int STATE_CONNECTING = 2562;
    public static final int STATE_IDLE = 2561;
    public static final String TAG = "BtDevice";
    private static final int WRITE_TIMEOUT = 3000;
    private static int mDeviceIndex = 1;
    private String mAlias;
    private BluetoothSocket mBluetoothSocket;
    private BtManager mBtManager;
    private ConnectThread mConnectThread;
    private boolean mDelete;
    private BluetoothDevice mDevice;
    private int mIndex;
    private boolean mMaster;
    private String mName;
    private ReadThread mReadThread;
    private boolean mReading;
    private boolean mSecure;
    private int mState = STATE_IDLE;
    private final Object mLocker = new Object();
    private boolean mRewrite = false;

    public class ConnectThread extends Thread {
        public ConnectThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            BtDevice.this.mState = BtDevice.STATE_CONNECTING;
            try {
                if (BtDevice.this.mBluetoothSocket != null && BtDevice.this.mBluetoothSocket.isConnected()) {
                    try {
                        BtDevice.this.mBluetoothSocket.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (BtDevice.this.mSecure) {
                    try {
                        try {
                            try {
                                BtDevice btDevice = BtDevice.this;
                                btDevice.mBluetoothSocket = (BluetoothSocket) btDevice.mDevice.getClass().getMethod("createRfcommSocket", Integer.TYPE).invoke(BtDevice.this.mDevice, 1);
                            } catch (NoSuchMethodException e3) {
                                e3.printStackTrace();
                            }
                        } catch (InvocationTargetException e4) {
                            e4.printStackTrace();
                        }
                    } catch (IllegalAccessException e5) {
                        e5.printStackTrace();
                    }
                } else {
                    BtDevice btDevice2 = BtDevice.this;
                    btDevice2.mBluetoothSocket = btDevice2.mDevice.createInsecureRfcommSocketToServiceRecord(BtConfig.UUID_INSECURE);
                }
                if (BtDevice.this.mBluetoothSocket == null) {
                    BtDevice.this.mState = BtDevice.STATE_IDLE;
                    BtDevice.this.mBtManager.onStateChanged(BtDevice.this.mState, BtDevice.this);
                    return;
                }
                try {
                    BtDevice.this.mBtManager.cancelDiscovery();
                    BtDevice.this.mBluetoothSocket.connect();
                    BtDevice.this.mState = BtDevice.STATE_CONNECTED;
                    BtDevice.this.mBtManager.onStateChanged(BtDevice.this.mState, BtDevice.this);
                    BtDevice.this.startWorking();
                    return;
                } catch (IOException unused) {
                    BtDevice.this.mState = BtDevice.STATE_IDLE;
                    try {
                        if (BtDevice.this.mBluetoothSocket != null) {
                            BtDevice.this.mBluetoothSocket.close();
                        }
                    } catch (IOException unused2) {
                    }
                }
            } catch (IOException unused3) {
                BtDevice.this.mState = BtDevice.STATE_IDLE;
            }
            BtDevice.this.mBtManager.onStateChanged(BtDevice.this.mState, BtDevice.this);
        }
    }

    public class ReadThread extends Thread {
        public ReadThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            while (BtDevice.this.mReading && BtDevice.this.mState == 2563) {
                try {
                    BtDevice.this.readData();
                } catch (IOException unused) {
                    BtDevice.this.close();
                    return;
                }
            }
        }
    }

    public BtDevice(BtManager btManager, BluetoothDevice bluetoothDevice) {
        this.mBtManager = btManager;
        this.mDevice = bluetoothDevice;
        int i2 = mDeviceIndex;
        mDeviceIndex = i2 + 1;
        this.mIndex = i2;
    }

    private void printData(byte[] bArr) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWorking() {
        if (this.mBluetoothSocket == null || this.mState != 2563) {
            return;
        }
        ReadThread readThread = this.mReadThread;
        if (readThread != null) {
            this.mReading = false;
            readThread.interrupt();
        }
        ReadThread readThread2 = new ReadThread();
        this.mReadThread = readThread2;
        this.mReading = true;
        readThread2.start();
    }

    public void close() {
        if (this.mState == 2561) {
            return;
        }
        this.mBtManager.close(this);
    }

    public void closeInner() {
        this.mReading = false;
        this.mState = STATE_IDLE;
        BluetoothSocket bluetoothSocket = this.mBluetoothSocket;
        if (bluetoothSocket != null) {
            try {
                bluetoothSocket.close();
                this.mBluetoothSocket = null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        ConnectThread connectThread = this.mConnectThread;
        if (connectThread != null) {
            connectThread.interrupt();
        }
        ReadThread readThread = this.mReadThread;
        if (readThread != null) {
            readThread.interrupt();
        }
        BtManager btManager = this.mBtManager;
        if (btManager != null) {
            btManager.onDisconnected(this);
        }
    }

    public boolean connect(boolean z) {
        int i2 = this.mState;
        if (i2 != 2563 && i2 != 2562) {
            this.mState = STATE_CONNECTING;
            this.mSecure = z;
            ConnectThread connectThread = this.mConnectThread;
            if (connectThread != null) {
                connectThread.interrupt();
            }
            ConnectThread connectThread2 = new ConnectThread();
            this.mConnectThread = connectThread2;
            connectThread2.start();
        }
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof BluetoothDevice ? obj.equals(this.mDevice) : obj instanceof BtDevice ? ((BtDevice) obj).mDevice.equals(this.mDevice) : super.equals(obj);
    }

    public String getAddress() {
        BluetoothDevice bluetoothDevice = this.mDevice;
        return bluetoothDevice != null ? bluetoothDevice.getAddress() : "";
    }

    public String getAlias() {
        return this.mAlias;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.mDevice;
    }

    public boolean getDelete() {
        return this.mDelete;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String getName() {
        BluetoothDevice bluetoothDevice = this.mDevice;
        String name = bluetoothDevice != null ? bluetoothDevice.getName() : "";
        if (!TextUtils.isEmpty(name)) {
            return name;
        }
        String str = this.mName;
        return str == null ? "" : str;
    }

    public boolean isConnected() {
        return this.mState == 2563;
    }

    public boolean isConnecting() {
        return this.mState == 2562;
    }

    public boolean isMaster() {
        return this.mMaster;
    }

    public void notifyWrite() {
        notifyWrite(false);
    }

    public void readData() throws IOException {
        InputStream inputStream;
        byte[] bArr;
        BluetoothSocket bluetoothSocket = this.mBluetoothSocket;
        if (bluetoothSocket == null || (inputStream = bluetoothSocket.getInputStream()) == null || !this.mBluetoothSocket.isConnected()) {
            return;
        }
        byte[] bArr2 = new byte[1024];
        int i2 = inputStream.read(bArr2);
        if (i2 < 0) {
            bArr = new byte[0];
        } else {
            byte[] bArr3 = new byte[i2];
            System.arraycopy(bArr2, 0, bArr3, 0, i2);
            bArr = bArr3;
        }
        BtManager btManager = this.mBtManager;
        if (btManager != null) {
            btManager.onReadData(this, bArr);
        }
    }

    public boolean sendOnePacket(byte[] bArr, int i2) {
        return sendOnePacket(bArr, i2, false);
    }

    public void setAlias(String str) {
        this.mAlias = str;
    }

    public void setBluetoothSocket(BluetoothSocket bluetoothSocket) {
        if (bluetoothSocket == null) {
            return;
        }
        close();
        this.mBluetoothSocket = bluetoothSocket;
        if (bluetoothSocket.isConnected()) {
            this.mState = STATE_CONNECTED;
        }
        startWorking();
    }

    public void setDelete(boolean z) {
        this.mDelete = z;
    }

    public void setMaster(boolean z) {
        this.mMaster = z;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public boolean writeData(byte[] bArr) {
        return writeData(bArr, false);
    }

    public void notifyWrite(boolean z) {
        this.mRewrite = z;
        synchronized (this.mLocker) {
            this.mLocker.notify();
        }
    }

    public boolean sendOnePacket(byte[] bArr, int i2, boolean z) {
        if (bArr.length > 20 || !isConnected()) {
            return false;
        }
        boolean zWriteData = writeData(bArr, z);
        printData(bArr);
        if (!zWriteData) {
            return false;
        }
        if (i2 <= 0) {
            return true;
        }
        try {
            Thread.sleep(i2);
            return true;
        } catch (InterruptedException unused) {
            return true;
        }
    }

    public boolean writeData(byte[] bArr, boolean z) {
        long jCurrentTimeMillis;
        if (this.mBluetoothSocket == null) {
            return false;
        }
        while (true) {
            try {
                OutputStream outputStream = this.mBluetoothSocket.getOutputStream();
                if (outputStream == null || !this.mBluetoothSocket.isConnected()) {
                    break;
                }
                outputStream.write(bArr);
                BtManager btManager = this.mBtManager;
                if (btManager != null) {
                    btManager.onWriteData(this, bArr);
                }
                if (!z) {
                    return true;
                }
                try {
                    synchronized (this.mLocker) {
                        jCurrentTimeMillis = System.currentTimeMillis();
                        this.mLocker.wait(3000L);
                    }
                    if (System.currentTimeMillis() - jCurrentTimeMillis >= 3000) {
                        return false;
                    }
                    if (!this.mRewrite) {
                        return true;
                    }
                    this.mRewrite = false;
                } catch (InterruptedException unused) {
                    return false;
                }
            } catch (IOException unused2) {
            }
        }
        return false;
    }
}

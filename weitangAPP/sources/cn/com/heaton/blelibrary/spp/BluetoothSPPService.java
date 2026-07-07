package cn.com.heaton.blelibrary.spp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothSPPService implements Handler.Callback {
    private static final boolean D = true;
    private static final int MESSAGE_DEVICE_NAME = 18;
    private static final int MESSAGE_ERROR = 21;
    private static final int MESSAGE_READ = 19;
    private static final int MESSAGE_STATE_CHANGE = 17;
    private static final int MESSAGE_WRITE = 20;
    private static final String NAME_INSECURE = "BluetoothChatInsecure";
    private static final String NAME_SECURE = "BluetoothChatSecure";
    public static final int STATE_CONNECTED = 3;
    public static final int STATE_CONNECTING = 2;
    public static final int STATE_LISTEN = 1;
    public static final int STATE_NONE = 0;
    private static final String TAG = "BluetoothChatService";
    private BluetoothDeviceListener mBluetoothDeviceListener;
    private ConnectThread mConnectThread;
    private ConnectedThread mConnectedThread;
    private final Context mContext;
    private Handler mHandler;
    private AcceptThread mInsecureAcceptThread;
    private AcceptThread mSecureAcceptThread;
    private static final UUID MY_UUID_SECURE = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final UUID MY_UUID_INSECURE = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private final BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();
    private int mState = 0;

    public class AcceptThread extends Thread {
        private String mSocketType;
        private final BluetoothServerSocket mmServerSocket;

        public AcceptThread(boolean z) {
            BluetoothServerSocket bluetoothServerSocketListenUsingRfcommWithServiceRecord;
            this.mSocketType = z ? "Secure" : "Insecure";
            try {
                bluetoothServerSocketListenUsingRfcommWithServiceRecord = z ? BluetoothSPPService.this.mAdapter.listenUsingRfcommWithServiceRecord(BluetoothSPPService.NAME_SECURE, BluetoothSPPService.MY_UUID_SECURE) : BluetoothSPPService.this.mAdapter.listenUsingInsecureRfcommWithServiceRecord(BluetoothSPPService.NAME_INSECURE, BluetoothSPPService.MY_UUID_INSECURE);
            } catch (IOException e2) {
                Log.e(BluetoothSPPService.TAG, "Socket Type: " + this.mSocketType + "listen() failed", e2);
                bluetoothServerSocketListenUsingRfcommWithServiceRecord = null;
            }
            this.mmServerSocket = bluetoothServerSocketListenUsingRfcommWithServiceRecord;
        }

        public void cancel() {
            Log.d(BluetoothSPPService.TAG, "Socket Type" + this.mSocketType + "cancel " + this);
            try {
                this.mmServerSocket.close();
            } catch (IOException e2) {
                Log.e(BluetoothSPPService.TAG, "Socket Type" + this.mSocketType + "close() of server failed", e2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r5 = this;
                java.lang.String r0 = "BluetoothChatService"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Socket Type: "
                r1.append(r2)
                java.lang.String r2 = r5.mSocketType
                r1.append(r2)
                java.lang.String r2 = "BEGIN mAcceptThread"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r1 = r1.toString()
                android.util.Log.d(r0, r1)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "AcceptThread"
                r0.append(r1)
                java.lang.String r1 = r5.mSocketType
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r5.setName(r0)
            L36:
                cn.com.heaton.blelibrary.spp.BluetoothSPPService r0 = cn.com.heaton.blelibrary.spp.BluetoothSPPService.this
                int r0 = cn.com.heaton.blelibrary.spp.BluetoothSPPService.access$300(r0)
                r1 = 3
                if (r0 == r1) goto L96
                android.bluetooth.BluetoothServerSocket r0 = r5.mmServerSocket     // Catch: java.io.IOException -> L78
                android.bluetooth.BluetoothSocket r0 = r0.accept()     // Catch: java.io.IOException -> L78
                if (r0 == 0) goto L36
                cn.com.heaton.blelibrary.spp.BluetoothSPPService r2 = cn.com.heaton.blelibrary.spp.BluetoothSPPService.this
                monitor-enter(r2)
                cn.com.heaton.blelibrary.spp.BluetoothSPPService r3 = cn.com.heaton.blelibrary.spp.BluetoothSPPService.this     // Catch: java.lang.Throwable -> L75
                int r3 = cn.com.heaton.blelibrary.spp.BluetoothSPPService.access$300(r3)     // Catch: java.lang.Throwable -> L75
                if (r3 == 0) goto L67
                r4 = 1
                if (r3 == r4) goto L5b
                r4 = 2
                if (r3 == r4) goto L5b
                if (r3 == r1) goto L67
                goto L73
            L5b:
                cn.com.heaton.blelibrary.spp.BluetoothSPPService r1 = cn.com.heaton.blelibrary.spp.BluetoothSPPService.this     // Catch: java.lang.Throwable -> L75
                android.bluetooth.BluetoothDevice r3 = r0.getRemoteDevice()     // Catch: java.lang.Throwable -> L75
                java.lang.String r4 = r5.mSocketType     // Catch: java.lang.Throwable -> L75
                r1.connected(r0, r3, r4)     // Catch: java.lang.Throwable -> L75
                goto L73
            L67:
                r0.close()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L75
                goto L73
            L6b:
                r0 = move-exception
                java.lang.String r1 = "BluetoothChatService"
                java.lang.String r3 = "Could not close unwanted socket"
                android.util.Log.e(r1, r3, r0)     // Catch: java.lang.Throwable -> L75
            L73:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L75
                goto L36
            L75:
                r0 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L75
                throw r0
            L78:
                r0 = move-exception
                java.lang.String r1 = "BluetoothChatService"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Socket Type: "
                r2.append(r3)
                java.lang.String r3 = r5.mSocketType
                r2.append(r3)
                java.lang.String r3 = "accept() failed"
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                android.util.Log.e(r1, r2, r0)
            L96:
                java.lang.String r0 = "BluetoothChatService"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "END mAcceptThread, socket Type: "
                r1.append(r2)
                java.lang.String r2 = r5.mSocketType
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                android.util.Log.i(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.com.heaton.blelibrary.spp.BluetoothSPPService.AcceptThread.run():void");
        }
    }

    public interface BluetoothDeviceListener {
        void onConnected(BluetoothDevice bluetoothDevice);

        void onError(String str);

        void onRead(byte[] bArr);

        void onStateChanged(int i2);

        void onWrite(byte[] bArr);
    }

    public class ConnectThread extends Thread {
        private String mSocketType;
        private final BluetoothDevice mmDevice;
        private final BluetoothSocket mmSocket;

        public ConnectThread(BluetoothDevice bluetoothDevice, boolean z) {
            BluetoothSocket bluetoothSocketCreateRfcommSocketToServiceRecord;
            this.mmDevice = bluetoothDevice;
            this.mSocketType = z ? "Secure" : "Insecure";
            try {
                bluetoothSocketCreateRfcommSocketToServiceRecord = z ? bluetoothDevice.createRfcommSocketToServiceRecord(BluetoothSPPService.MY_UUID_SECURE) : bluetoothDevice.createInsecureRfcommSocketToServiceRecord(BluetoothSPPService.MY_UUID_INSECURE);
            } catch (IOException e2) {
                Log.e(BluetoothSPPService.TAG, "Socket Type: " + this.mSocketType + "create() failed", e2);
                bluetoothSocketCreateRfcommSocketToServiceRecord = null;
            }
            this.mmSocket = bluetoothSocketCreateRfcommSocketToServiceRecord;
        }

        public void cancel() {
            try {
                this.mmSocket.close();
            } catch (IOException e2) {
                Log.e(BluetoothSPPService.TAG, "close() of connect " + this.mSocketType + " socket failed", e2);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.i(BluetoothSPPService.TAG, "BEGIN mConnectThread SocketType:" + this.mSocketType);
            setName("ConnectThread" + this.mSocketType);
            BluetoothSPPService.this.mAdapter.cancelDiscovery();
            try {
                try {
                    this.mmSocket.connect();
                    synchronized (BluetoothSPPService.this) {
                        BluetoothSPPService.this.mConnectThread = null;
                    }
                    BluetoothSPPService.this.connected(this.mmSocket, this.mmDevice, this.mSocketType);
                } catch (IOException e2) {
                    Log.e(BluetoothSPPService.TAG, "unable to close() " + this.mSocketType + " socket during connection failure", e2);
                    BluetoothSPPService.this.connectionFailed();
                }
            } catch (IOException unused) {
                this.mmSocket.close();
                BluetoothSPPService.this.connectionFailed();
            }
        }
    }

    public class ConnectedThread extends Thread {
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;
        private final BluetoothSocket mmSocket;

        public ConnectedThread(BluetoothSocket bluetoothSocket, String str) {
            InputStream inputStream;
            Log.d(BluetoothSPPService.TAG, "create ConnectedThread: " + str);
            this.mmSocket = bluetoothSocket;
            OutputStream outputStream = null;
            try {
                inputStream = bluetoothSocket.getInputStream();
                try {
                    outputStream = bluetoothSocket.getOutputStream();
                } catch (IOException e2) {
                    e = e2;
                    Log.e(BluetoothSPPService.TAG, "temp sockets not created", e);
                }
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
            }
            this.mmInStream = inputStream;
            this.mmOutStream = outputStream;
        }

        public void cancel() {
            try {
                this.mmSocket.close();
            } catch (IOException e2) {
                Log.e(BluetoothSPPService.TAG, "close() of connect socket failed", e2);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr;
            Log.i(BluetoothSPPService.TAG, "BEGIN mConnectedThread");
            byte[] bArr2 = new byte[1024];
            while (true) {
                try {
                    int i2 = this.mmInStream.read(bArr2);
                    if (i2 < 0) {
                        bArr = new byte[0];
                    } else {
                        byte[] bArr3 = new byte[i2];
                        System.arraycopy(bArr2, 0, bArr3, 0, i2);
                        bArr = bArr3;
                    }
                    BluetoothSPPService.this.mHandler.obtainMessage(19, bArr).sendToTarget();
                } catch (IOException e2) {
                    Log.e(BluetoothSPPService.TAG, "disconnected", e2);
                    BluetoothSPPService.this.connectionLost();
                    BluetoothSPPService.this.start();
                    return;
                }
            }
        }

        public void write(byte[] bArr) {
            try {
                this.mmOutStream.write(bArr);
                BluetoothSPPService.this.mHandler.obtainMessage(20, bArr).sendToTarget();
            } catch (IOException e2) {
                Log.e(BluetoothSPPService.TAG, "Exception during write", e2);
            }
        }
    }

    public BluetoothSPPService(Context context, BluetoothDeviceListener bluetoothDeviceListener) {
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.mBluetoothDeviceListener = bluetoothDeviceListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionFailed() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(21, "无法连接到设备"));
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionLost() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(21, "设备连接已断开"));
        start();
    }

    private synchronized void setState(int i2) {
        Log.d(TAG, "setState() " + this.mState + " -> " + i2);
        this.mState = i2;
        this.mHandler.obtainMessage(17, i2, 0).sendToTarget();
    }

    public synchronized void connect(BluetoothDevice bluetoothDevice, boolean z) {
        ConnectThread connectThread;
        Log.d(TAG, "connect to: " + bluetoothDevice);
        if (this.mState == 2 && (connectThread = this.mConnectThread) != null) {
            connectThread.cancel();
            this.mConnectThread = null;
        }
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread != null) {
            connectedThread.cancel();
            this.mConnectedThread = null;
        }
        ConnectThread connectThread2 = new ConnectThread(bluetoothDevice, z);
        this.mConnectThread = connectThread2;
        connectThread2.start();
        setState(2);
    }

    public synchronized void connected(BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice, String str) {
        Log.d(TAG, "connected, Socket Type:" + str);
        ConnectThread connectThread = this.mConnectThread;
        if (connectThread != null) {
            connectThread.cancel();
            this.mConnectThread = null;
        }
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread != null) {
            connectedThread.cancel();
            this.mConnectedThread = null;
        }
        AcceptThread acceptThread = this.mSecureAcceptThread;
        if (acceptThread != null) {
            acceptThread.cancel();
            this.mSecureAcceptThread = null;
        }
        AcceptThread acceptThread2 = this.mInsecureAcceptThread;
        if (acceptThread2 != null) {
            acceptThread2.cancel();
            this.mInsecureAcceptThread = null;
        }
        ConnectedThread connectedThread2 = new ConnectedThread(bluetoothSocket, str);
        this.mConnectedThread = connectedThread2;
        connectedThread2.start();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(18, bluetoothDevice.getAddress()));
        setState(3);
    }

    public synchronized int getState() {
        return this.mState;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        if (message == null) {
            return false;
        }
        switch (message.what) {
            case 17:
                BluetoothDeviceListener bluetoothDeviceListener = this.mBluetoothDeviceListener;
                if (bluetoothDeviceListener != null) {
                    bluetoothDeviceListener.onStateChanged(message.arg1);
                }
                break;
            case 18:
                if (this.mBluetoothDeviceListener != null && (obj = message.obj) != null && (obj instanceof String)) {
                    this.mBluetoothDeviceListener.onConnected(this.mAdapter.getRemoteDevice((String) obj));
                    break;
                }
                break;
            case 19:
                BluetoothDeviceListener bluetoothDeviceListener2 = this.mBluetoothDeviceListener;
                if (bluetoothDeviceListener2 != null) {
                    bluetoothDeviceListener2.onRead((byte[]) message.obj);
                }
                break;
            case 20:
                BluetoothDeviceListener bluetoothDeviceListener3 = this.mBluetoothDeviceListener;
                if (bluetoothDeviceListener3 != null) {
                    bluetoothDeviceListener3.onWrite((byte[]) message.obj);
                }
                break;
            case 21:
                BluetoothDeviceListener bluetoothDeviceListener4 = this.mBluetoothDeviceListener;
                if (bluetoothDeviceListener4 != null) {
                    bluetoothDeviceListener4.onError(String.valueOf(message.obj));
                }
                break;
        }
        return false;
    }

    public synchronized void start() {
        Log.d(TAG, RequestBannerParamBo.GET_SPLASH_TYPE);
        ConnectThread connectThread = this.mConnectThread;
        if (connectThread != null) {
            connectThread.cancel();
            this.mConnectThread = null;
        }
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread != null) {
            connectedThread.cancel();
            this.mConnectedThread = null;
        }
        setState(1);
        if (this.mSecureAcceptThread == null) {
            AcceptThread acceptThread = new AcceptThread(true);
            this.mSecureAcceptThread = acceptThread;
            acceptThread.start();
        }
        if (this.mInsecureAcceptThread == null) {
            AcceptThread acceptThread2 = new AcceptThread(false);
            this.mInsecureAcceptThread = acceptThread2;
            acceptThread2.start();
        }
    }

    public synchronized void stop() {
        Log.d(TAG, "stop");
        ConnectThread connectThread = this.mConnectThread;
        if (connectThread != null) {
            connectThread.cancel();
            this.mConnectThread = null;
        }
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread != null) {
            connectedThread.cancel();
            this.mConnectedThread = null;
        }
        AcceptThread acceptThread = this.mSecureAcceptThread;
        if (acceptThread != null) {
            acceptThread.cancel();
            this.mSecureAcceptThread = null;
        }
        AcceptThread acceptThread2 = this.mInsecureAcceptThread;
        if (acceptThread2 != null) {
            acceptThread2.cancel();
            this.mInsecureAcceptThread = null;
        }
        setState(0);
    }

    public void write(byte[] bArr) {
        synchronized (this) {
            if (this.mState != 3) {
                return;
            }
            this.mConnectedThread.write(bArr);
        }
    }
}

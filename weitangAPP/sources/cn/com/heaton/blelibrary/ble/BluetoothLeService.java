package cn.com.heaton.blelibrary.ble;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import cn.com.heaton.blelibrary.ble.Ble;
import cn.com.heaton.blelibrary.ble.BleStates;
import cn.com.heaton.blelibrary.ble.callback.wrapper.ConnectWrapperLisenter;
import cn.com.heaton.blelibrary.ble.callback.wrapper.NotifyWrapperLisenter;
import cn.com.heaton.blelibrary.ble.event.ReceiveDataEvent;
import cn.com.heaton.blelibrary.ble.event.SetNotifySuccessEvent;
import cn.com.heaton.blelibrary.ble.model.BleDevice;
import cn.com.heaton.blelibrary.ble.request.ConnectRequest;
import cn.com.heaton.blelibrary.ble.request.NotifyRequest;
import cn.com.heaton.blelibrary.ble.request.Rproxy;
import cn.com.heaton.blelibrary.ota.OtaListener;
import com.alipay.sdk.m.x.d;
import g.b.a.c;
import g.b.a.m;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public class BluetoothLeService extends Service {
    private static final String TAG = BluetoothLeService.class.getSimpleName();
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothManager mBluetoothManager;
    private ConnectWrapperLisenter mConnectWrapperLisenter;
    private Handler mHandler;
    private NotifyWrapperLisenter<BleDevice> mNotifyWrapperLisenter;
    private Ble.Options mOptions;
    private OtaListener mOtaListener;
    private BluetoothGattCharacteristic mOtaWriteCharacteristic;
    private final Object mLocker = new Object();
    private List<BluetoothGattCharacteristic> mNotifyCharacteristics = new ArrayList();
    private int mNotifyIndex = 0;
    private boolean mOtaUpdating = false;
    private Map<String, BluetoothGattCharacteristic> mWriteCharacteristicMap = new HashMap();
    private Map<String, BluetoothGattCharacteristic> mReadCharacteristicMap = new HashMap();
    private Map<String, Runnable> mTimeoutTasks = new HashMap();
    private Map<String, BluetoothGatt> mBluetoothGattMap = new HashMap();
    private List<BluetoothGatt> mBluetoothGattList = new ArrayList();
    private List<String> mConnectedAddressList = new ArrayList();
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: cn.com.heaton.blelibrary.ble.BluetoothLeService.1
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            synchronized (BluetoothLeService.this.mLocker) {
                if (bluetoothGatt.getDevice() == null) {
                    return;
                }
                BleDevice bleDevice = Ble.getInstance().getBleDevice(bluetoothGatt.getDevice());
                String str = BluetoothLeService.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(bluetoothGatt.getDevice().getAddress());
                sb.append(" -- onCharacteristicChanged: ");
                sb.append(bluetoothGattCharacteristic.getValue() != null ? Arrays.toString(bluetoothGattCharacteristic.getValue()) : "");
                L.i(str, sb.toString());
                if (bluetoothGattCharacteristic.getValue() != null) {
                    c.getDefault().post(new ReceiveDataEvent(bluetoothGatt, bluetoothGattCharacteristic.getValue()));
                }
                if (!BluetoothLeService.this.mOptions.uuid_ota_write_cha.equals(bluetoothGattCharacteristic.getUuid()) && !BluetoothLeService.this.mOptions.uuid_ota_notify_cha.equals(bluetoothGattCharacteristic.getUuid())) {
                    if (bleDevice != null && BluetoothLeService.this.mNotifyWrapperLisenter != null) {
                        BluetoothLeService.this.mNotifyWrapperLisenter.onChanged(bleDevice, bluetoothGattCharacteristic);
                    }
                    return;
                }
                if (BluetoothLeService.this.mOtaListener != null) {
                    BluetoothLeService.this.mOtaListener.onChange(bluetoothGattCharacteristic.getValue());
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            L.d(BluetoothLeService.TAG, "onCharacteristicRead:" + i2);
            if (i2 == 0) {
                BluetoothLeService.this.mHandler.obtainMessage(BleStates.BleStatus.Read, bluetoothGattCharacteristic).sendToTarget();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            L.i(BluetoothLeService.TAG, "--------write success----- status:" + i2);
            synchronized (BluetoothLeService.this.mLocker) {
                L.i(BluetoothLeService.TAG, bluetoothGatt.getDevice().getAddress() + " -- onCharacteristicWrite: " + i2);
                if (i2 == 0) {
                    if (BluetoothLeService.this.mOptions.uuid_ota_write_cha.equals(bluetoothGattCharacteristic.getUuid())) {
                        if (BluetoothLeService.this.mOtaListener != null) {
                            BluetoothLeService.this.mOtaListener.onWrite();
                        }
                        return;
                    }
                    BluetoothLeService.this.mHandler.obtainMessage(BleStates.BleStatus.Write, bluetoothGattCharacteristic).sendToTarget();
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
            BluetoothDevice device = bluetoothGatt.getDevice();
            Runnable runnable = (Runnable) BluetoothLeService.this.mTimeoutTasks.get(device.getAddress());
            if (runnable != null) {
                BluetoothLeService.this.mTimeoutTasks.remove(device.getAddress());
                BluetoothLeService.this.mHandler.removeCallbacks(runnable);
            }
            if (i2 != 0) {
                L.e(BluetoothLeService.TAG, "onConnectionStateChange>>>>>>>>: Connection status is abnormal:" + i2);
                BluetoothLeService.this.close(device.getAddress());
                if (BluetoothLeService.this.mConnectWrapperLisenter != null) {
                    BluetoothLeService.this.mConnectWrapperLisenter.onConnectException(device);
                    BluetoothLeService.this.mConnectWrapperLisenter.onConnectionChanged(device, BleStates.BleStatus.DISCONNECT);
                    return;
                }
                return;
            }
            if (i3 != 2) {
                if (i3 == 0) {
                    L.i(BluetoothLeService.TAG, "Disconnected from GATT server.");
                    if (BluetoothLeService.this.mConnectWrapperLisenter != null) {
                        BluetoothLeService.this.mConnectWrapperLisenter.onConnectionChanged(device, BleStates.BleStatus.DISCONNECT);
                    }
                    BluetoothLeService.this.close(device.getAddress());
                    return;
                }
                return;
            }
            BluetoothLeService.this.mConnectedAddressList.add(device.getAddress());
            if (BluetoothLeService.this.mConnectWrapperLisenter != null) {
                BluetoothLeService.this.mConnectWrapperLisenter.onConnectionChanged(device, BleStates.BleStatus.CONNECTED);
            }
            L.i(BluetoothLeService.TAG, "handleMessage:>>>>>>>>CONNECTED.");
            Log.i(BluetoothLeService.TAG, "Attempting to start service discovery");
            Object obj = BluetoothLeService.this.mBluetoothGattMap.get(device.getAddress());
            Objects.requireNonNull(obj);
            ((BluetoothGatt) obj).discoverServices();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i2);
            UUID uuid = bluetoothGattDescriptor.getCharacteristic().getUuid();
            L.i(BluetoothLeService.TAG, "onDescriptorRead");
            L.i(BluetoothLeService.TAG, "descriptor_uuid:" + uuid);
            BluetoothLeService.this.mHandler.obtainMessage(BleStates.BleStatus.DescriptorRead, bluetoothGatt).sendToTarget();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
            UUID uuid = bluetoothGattDescriptor.getCharacteristic().getUuid();
            L.i(BluetoothLeService.TAG, "onDescriptorWrite");
            L.i(BluetoothLeService.TAG, "descriptor_uuid:" + uuid);
            synchronized (BluetoothLeService.this.mLocker) {
                L.w(BluetoothLeService.TAG, " -- onDescriptorWrite: " + i2);
                if (i2 == 0) {
                    if (BluetoothLeService.this.mNotifyCharacteristics == null || BluetoothLeService.this.mNotifyCharacteristics.size() <= 0 || BluetoothLeService.this.mNotifyIndex >= BluetoothLeService.this.mNotifyCharacteristics.size()) {
                        L.i(BluetoothLeService.TAG, "====setCharacteristicNotification is true,ready to sendData===");
                        c.getDefault().post(new SetNotifySuccessEvent(bluetoothGatt));
                        if (BluetoothLeService.this.mNotifyWrapperLisenter != null) {
                            BluetoothLeService.this.mNotifyWrapperLisenter.onNotifySuccess(bluetoothGatt);
                        }
                    } else {
                        BluetoothLeService.this.setCharacteristicNotification(bluetoothGatt.getDevice().getAddress(), (BluetoothGattCharacteristic) BluetoothLeService.this.mNotifyCharacteristics.get(BluetoothLeService.access$808(BluetoothLeService.this)), true);
                    }
                }
                BluetoothLeService.this.mHandler.obtainMessage(BleStates.BleStatus.DescriptorWriter, bluetoothGatt).sendToTarget();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        @TargetApi(21)
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i2, int i3) {
            if (bluetoothGatt == null || bluetoothGatt.getDevice() == null) {
                return;
            }
            BleDevice bleDevice = Ble.getInstance().getBleDevice(bluetoothGatt.getDevice());
            L.e(BluetoothLeService.TAG, "onMtuChanged mtu=" + i2 + ",status=" + i3);
            BluetoothLeService.this.mHandler.obtainMessage(BleStates.BleStatus.MTUCHANGED, i2, i3, bleDevice).sendToTarget();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i2, int i3) {
            System.out.println("rssi = " + i2);
            BluetoothLeService.this.mHandler.obtainMessage(BleStates.BleStatus.ReadRssi, Integer.valueOf(i2)).sendToTarget();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
            if (i2 == 0) {
                if (BluetoothLeService.this.mNotifyWrapperLisenter != null) {
                    BluetoothLeService.this.mNotifyWrapperLisenter.onServicesDiscovered(bluetoothGatt);
                }
                BluetoothLeService.this.mNotifyCharacteristics.clear();
                BluetoothLeService.this.mNotifyIndex = 0;
                BluetoothLeService.this.displayGattServices(bluetoothGatt.getDevice().getAddress(), BluetoothLeService.this.getSupportedGattServices(bluetoothGatt.getDevice().getAddress()));
                return;
            }
            L.w(BluetoothLeService.TAG, "onServicesDiscovered received: " + i2);
        }
    };
    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public BluetoothLeService getService() {
            return BluetoothLeService.this;
        }
    }

    public static /* synthetic */ int access$808(BluetoothLeService bluetoothLeService) {
        int i2 = bluetoothLeService.mNotifyIndex;
        bluetoothLeService.mNotifyIndex = i2 + 1;
        return i2;
    }

    private Runnable checkTimeOutTask(final BluetoothDevice bluetoothDevice) {
        return new Runnable() { // from class: cn.com.heaton.blelibrary.ble.BluetoothLeService.2
            @Override // java.lang.Runnable
            public void run() {
                if (BluetoothLeService.this.mConnectWrapperLisenter != null) {
                    BluetoothLeService.this.mConnectWrapperLisenter.onConnectTimeOut(bluetoothDevice);
                    BluetoothLeService.this.close(bluetoothDevice.getAddress());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayGattServices(String str, List<BluetoothGattService> list) {
        if (list == null) {
            return;
        }
        for (BluetoothGattService bluetoothGattService : list) {
            String string = bluetoothGattService.getUuid().toString();
            String str2 = TAG;
            L.d(str2, "displayGattServices: " + string);
            if (string.equals(this.mOptions.uuid_service.toString()) || isContainUUID(string)) {
                L.d(str2, "service_uuid: " + string);
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                    String string2 = bluetoothGattCharacteristic.getUuid().toString();
                    L.d(TAG, "Characteristic_uuid: " + string2);
                    if (string2.equals(this.mOptions.uuid_write_cha.toString())) {
                        L.e("mWriteCharacteristic", string2);
                        this.mWriteCharacteristicMap.put(str, bluetoothGattCharacteristic);
                    }
                    if (string2.equals(this.mOptions.uuid_read_cha.toString())) {
                        L.e("mReadCharacteristic", string2);
                        this.mReadCharacteristicMap.put(str, bluetoothGattCharacteristic);
                    }
                    if ((bluetoothGattCharacteristic.getProperties() & 16) != 0) {
                        this.mNotifyCharacteristics.add(bluetoothGattCharacteristic);
                        L.e("mNotifyCharacteristics", "PROPERTY_NOTIFY");
                    }
                    if ((bluetoothGattCharacteristic.getProperties() & 32) != 0) {
                        this.mNotifyCharacteristics.add(bluetoothGattCharacteristic);
                        L.e("mNotifyCharacteristics", "PROPERTY_INDICATE");
                    }
                }
                List<BluetoothGattCharacteristic> list2 = this.mNotifyCharacteristics;
                if (list2 != null && list2.size() > 0) {
                    L.e("setCharaNotification", "setCharaNotification");
                    List<BluetoothGattCharacteristic> list3 = this.mNotifyCharacteristics;
                    int i2 = this.mNotifyIndex;
                    this.mNotifyIndex = i2 + 1;
                    setCharacteristicNotification(str, list3.get(i2), true);
                }
            }
        }
    }

    private boolean isContainUUID(String str) {
        for (UUID uuid : this.mOptions.uuid_services_extra) {
            if (uuid != null && str.equals(uuid.toString())) {
                return true;
            }
        }
        return false;
    }

    public void close(String str) {
        this.mConnectedAddressList.remove(str);
        if (this.mBluetoothGattMap.get(str) != null) {
            this.mBluetoothGattMap.get(str).close();
            this.mBluetoothGattMap.remove(str);
        }
    }

    public boolean connect(String str) {
        if (this.mConnectedAddressList.contains(str)) {
            L.d(TAG, "This is device already connected.");
            return true;
        }
        if (this.mBluetoothAdapter == null) {
            L.w(TAG, "BluetoothAdapter not initialized");
            return false;
        }
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            L.d(TAG, "the device address is invalid");
            return false;
        }
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        if (remoteDevice == null) {
            L.d(TAG, "no device");
            return false;
        }
        Runnable runnableCheckTimeOutTask = checkTimeOutTask(remoteDevice);
        this.mTimeoutTasks.put(remoteDevice.getAddress(), runnableCheckTimeOutTask);
        this.mHandler.postDelayed(runnableCheckTimeOutTask, this.mOptions.getConnectTimeout());
        ConnectWrapperLisenter connectWrapperLisenter = this.mConnectWrapperLisenter;
        if (connectWrapperLisenter != null) {
            connectWrapperLisenter.onConnectionChanged(remoteDevice, BleStates.BleStatus.CONNECTING);
        }
        BluetoothGatt bluetoothGattConnectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback);
        if (bluetoothGattConnectGatt == null) {
            return false;
        }
        this.mBluetoothGattMap.put(str, bluetoothGattConnectGatt);
        this.mBluetoothGattList.add(bluetoothGattConnectGatt);
        L.d(TAG, "Trying to create a new connection.");
        return true;
    }

    public void disconnect(String str) {
        if (this.mBluetoothAdapter == null || this.mBluetoothGattMap.get(str) == null) {
            L.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        this.mNotifyIndex = 0;
        this.mBluetoothGattMap.get(str).disconnect();
        this.mNotifyCharacteristics.clear();
        this.mWriteCharacteristicMap.remove(str);
        this.mReadCharacteristicMap.remove(str);
        this.mOtaWriteCharacteristic = null;
    }

    public List<BluetoothDevice> getConnectedDevices() {
        BluetoothManager bluetoothManager = this.mBluetoothManager;
        if (bluetoothManager == null) {
            return null;
        }
        return bluetoothManager.getConnectedDevices(7);
    }

    public BluetoothGattCharacteristic getReadCharacteristic(String str) {
        synchronized (this.mLocker) {
            Map<String, BluetoothGattCharacteristic> map = this.mReadCharacteristicMap;
            if (map == null) {
                return null;
            }
            return map.get(str);
        }
    }

    public boolean getRssiVal(String str) {
        if (this.mBluetoothGattMap.get(str) == null) {
            return false;
        }
        return this.mBluetoothGattMap.get(str).readRemoteRssi();
    }

    public List<BluetoothGattService> getSupportedGattServices(String str) {
        if (this.mBluetoothGattMap.get(str) == null) {
            return null;
        }
        return this.mBluetoothGattMap.get(str).getServices();
    }

    public BluetoothGattCharacteristic getWriteCharacteristic(String str) {
        synchronized (this.mLocker) {
            Map<String, BluetoothGattCharacteristic> map = this.mWriteCharacteristicMap;
            if (map == null) {
                return null;
            }
            return map.get(str);
        }
    }

    public List<BluetoothGatt> getmBluetoothGattList() {
        return this.mBluetoothGattList;
    }

    public boolean initBLE() {
        if (this.mBluetoothManager == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
            this.mBluetoothManager = bluetoothManager;
            if (bluetoothManager == null) {
                L.e(TAG, "Unable to initBLE BluetoothManager.");
                return false;
            }
        }
        BluetoothAdapter adapter = this.mBluetoothManager.getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter != null) {
            return true;
        }
        L.e(TAG, "Unable to obtain a BluetoothAdapter.");
        return false;
    }

    public void initialize(Ble.Options options) {
        this.mConnectWrapperLisenter = (ConnectWrapperLisenter) Rproxy.getInstance().getRequest(ConnectRequest.class);
        this.mNotifyWrapperLisenter = (NotifyWrapperLisenter) Rproxy.getInstance().getRequest(NotifyRequest.class);
        this.mHandler = BleHandler.of();
        this.mOptions = options;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        L.e(TAG, "onBind>>>>");
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c.getDefault().register(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        c.getDefault().unregister(this);
    }

    @m
    public void onEvent(String str) {
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        close();
        L.e(TAG, "onUnbind>>>>");
        return super.onUnbind(intent);
    }

    public void otaUpdateComplete() {
        this.mOtaUpdating = false;
    }

    public boolean readCharacteristic(String str) {
        if (this.mBluetoothAdapter == null || this.mBluetoothGattMap.get(str) == null) {
            L.w(TAG, "BluetoothAdapter not initialized");
            return false;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.mReadCharacteristicMap.get(str);
        if (bluetoothGattCharacteristic != null) {
            try {
                if (this.mOptions.uuid_read_cha.equals(bluetoothGattCharacteristic.getUuid())) {
                    boolean characteristic = this.mBluetoothGattMap.get(str).readCharacteristic(bluetoothGattCharacteristic);
                    L.d(TAG, str + " -- read result:" + characteristic);
                    return characteristic;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public boolean readRssi(String str) {
        if (this.mBluetoothAdapter == null || this.mBluetoothGattMap.get(str) == null) {
            L.w(TAG, "BluetoothAdapter not initialized");
            return false;
        }
        if (this.mReadCharacteristicMap.get(str) != null) {
            try {
                boolean remoteRssi = this.mBluetoothGattMap.get(str).readRemoteRssi();
                L.d(TAG, str + " -- read result:" + remoteRssi);
                return remoteRssi;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public boolean refreshDeviceCache(String str) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGattMap.get(str);
        if (bluetoothGatt != null) {
            try {
                Method method = bluetoothGatt.getClass().getMethod(d.w, new Class[0]);
                if (method != null) {
                    return ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                }
            } catch (Exception unused) {
                L.i(TAG, "An exception occured while refreshing device");
            }
        }
        return false;
    }

    public void setCharacteristicNotification(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        if (this.mBluetoothAdapter == null || this.mBluetoothGattMap.get(str) == null) {
            L.d(TAG, "BluetoothAdapter is null");
            return;
        }
        this.mBluetoothGattMap.get(str).setCharacteristicNotification(bluetoothGattCharacteristic, z);
        if (bluetoothGattCharacteristic.getDescriptors().size() > 0) {
            for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                if (bluetoothGattDescriptor != null) {
                    if ((bluetoothGattCharacteristic.getProperties() & 16) != 0) {
                        bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                    } else if ((bluetoothGattCharacteristic.getProperties() & 32) != 0) {
                        bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
                    }
                    this.mBluetoothGattMap.get(str).writeDescriptor(bluetoothGattDescriptor);
                }
            }
        }
    }

    @TargetApi(21)
    public boolean setMTU(String str, int i2) {
        String str2 = TAG;
        L.d(str2, "setMTU " + i2);
        if (Build.VERSION.SDK_INT < 21 || i2 <= 20 || this.mBluetoothGattMap.get(str) == null) {
            return false;
        }
        boolean zRequestMtu = this.mBluetoothGattMap.get(str).requestMtu(i2);
        L.d(str2, "requestMTU " + i2 + " result=" + zRequestMtu);
        return zRequestMtu;
    }

    public void setOtaListener(OtaListener otaListener) {
        this.mOtaListener = otaListener;
    }

    public void setOtaUpdating(boolean z) {
        this.mOtaUpdating = z;
    }

    public boolean wirteCharacteristic(String str, byte[] bArr) {
        if (this.mBluetoothAdapter == null || this.mBluetoothGattMap.get(str) == null) {
            L.w(TAG, "BluetoothAdapter not initialized");
            return false;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.mWriteCharacteristicMap.get(str);
        if (bluetoothGattCharacteristic != null) {
            try {
                if (this.mOptions.uuid_write_cha.equals(bluetoothGattCharacteristic.getUuid())) {
                    bluetoothGattCharacteristic.setValue(bArr);
                    boolean zWriteCharacteristic = this.mBluetoothGattMap.get(str).writeCharacteristic(bluetoothGattCharacteristic);
                    String str2 = TAG;
                    L.d(str2, str + " -- write type:" + bluetoothGattCharacteristic.getWriteType());
                    L.d(str2, str + " -- write data:" + Arrays.toString(bArr));
                    L.d(str2, str + " -- write result:" + zWriteCharacteristic);
                    return zWriteCharacteristic;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean writeCharacteristic(android.bluetooth.BluetoothGatt r2, android.bluetooth.BluetoothGattCharacteristic r3) {
        /*
            r1 = this;
            java.lang.Object r0 = r1.mLocker
            monitor-enter(r0)
            if (r2 == 0) goto Lf
            if (r3 == 0) goto Lf
            boolean r2 = r2.writeCharacteristic(r3)     // Catch: java.lang.Throwable -> L12
            if (r2 == 0) goto Lf
            r2 = 1
            goto L10
        Lf:
            r2 = 0
        L10:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L12
            return r2
        L12:
            r2 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L12
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.heaton.blelibrary.ble.BluetoothLeService.writeCharacteristic(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic):boolean");
    }

    public boolean writeOtaData(String str, byte[] bArr) {
        if (this.mBluetoothAdapter == null || this.mBluetoothGattMap.get(str) == null) {
            L.w(TAG, str + " -- BluetoothAdapter not initialized");
            return false;
        }
        try {
            if (this.mOtaWriteCharacteristic == null) {
                this.mOtaUpdating = true;
                BluetoothGattService service = this.mBluetoothGattMap.get(str).getService(this.mOptions.uuid_ota_service);
                if (service == null) {
                    return false;
                }
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(this.mOptions.uuid_ota_notify_cha);
                if (characteristic != null) {
                    this.mBluetoothGattMap.get(str).setCharacteristicNotification(characteristic, true);
                }
                this.mOtaWriteCharacteristic = service.getCharacteristic(this.mOptions.uuid_ota_write_cha);
            }
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.mOtaWriteCharacteristic;
            if (bluetoothGattCharacteristic == null || !this.mOptions.uuid_ota_write_cha.equals(bluetoothGattCharacteristic.getUuid())) {
                return true;
            }
            this.mOtaWriteCharacteristic.setValue(bArr);
            boolean zWriteCharacteristic = writeCharacteristic(this.mBluetoothGattMap.get(str), this.mOtaWriteCharacteristic);
            String str2 = TAG;
            L.d(str2, str + " -- write data:" + Arrays.toString(bArr));
            L.d(str2, str + " -- write result:" + zWriteCharacteristic);
            return zWriteCharacteristic;
        } catch (Exception unused) {
            close();
            return false;
        }
    }

    public void close() {
        List<String> list = this.mConnectedAddressList;
        if (list == null) {
            return;
        }
        for (String str : list) {
            if (this.mBluetoothGattMap.get(str) != null) {
                this.mBluetoothGattMap.get(str).close();
            }
        }
        this.mBluetoothGattMap.clear();
        this.mConnectedAddressList.clear();
        this.mConnectWrapperLisenter = null;
        this.mNotifyWrapperLisenter = null;
    }

    public void readCharacteristic(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        String str2 = TAG;
        L.d(str2, "readCharacteristic: " + bluetoothGattCharacteristic.getProperties());
        if (this.mBluetoothAdapter != null && this.mBluetoothGattMap.get(str) != null) {
            this.mBluetoothGattMap.get(str).readCharacteristic(bluetoothGattCharacteristic);
        } else {
            L.d(str2, "BluetoothAdapter is null");
        }
    }

    public boolean connect(BluetoothDevice bluetoothDevice) {
        if (this.mConnectedAddressList.contains(bluetoothDevice.getAddress())) {
            L.d(TAG, "This is device already connected.");
            return true;
        }
        if (this.mBluetoothAdapter == null) {
            L.w(TAG, "BluetoothAdapter not initialized");
            return false;
        }
        if (!BluetoothAdapter.checkBluetoothAddress(bluetoothDevice.getAddress())) {
            L.d(TAG, "the device address is invalid");
            return false;
        }
        Runnable runnableCheckTimeOutTask = checkTimeOutTask(bluetoothDevice);
        this.mTimeoutTasks.put(bluetoothDevice.getAddress(), runnableCheckTimeOutTask);
        this.mHandler.postDelayed(runnableCheckTimeOutTask, this.mOptions.getConnectTimeout());
        ConnectWrapperLisenter connectWrapperLisenter = this.mConnectWrapperLisenter;
        if (connectWrapperLisenter != null) {
            connectWrapperLisenter.onConnectionChanged(bluetoothDevice, BleStates.BleStatus.CONNECTING);
        }
        BluetoothGatt bluetoothGattConnectGatt = bluetoothDevice.connectGatt(this, false, this.mGattCallback);
        if (bluetoothGattConnectGatt == null) {
            return false;
        }
        this.mBluetoothGattMap.put(bluetoothDevice.getAddress(), bluetoothGattConnectGatt);
        this.mBluetoothGattList.add(bluetoothGattConnectGatt);
        L.d(TAG, "Trying to create a new connection.");
        return true;
    }
}

package cn.com.heaton.blelibrary.ble;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import cn.com.heaton.blelibrary.ble.BluetoothLeService;
import cn.com.heaton.blelibrary.ble.callback.BleConnectCallback;
import cn.com.heaton.blelibrary.ble.callback.BleMtuCallback;
import cn.com.heaton.blelibrary.ble.callback.BleNotiftCallback;
import cn.com.heaton.blelibrary.ble.callback.BleReadCallback;
import cn.com.heaton.blelibrary.ble.callback.BleReadRssiCallback;
import cn.com.heaton.blelibrary.ble.callback.BleScanCallback;
import cn.com.heaton.blelibrary.ble.callback.BleStatusCallback;
import cn.com.heaton.blelibrary.ble.callback.BleWriteCallback;
import cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback;
import cn.com.heaton.blelibrary.ble.exception.BleServiceException;
import cn.com.heaton.blelibrary.ble.model.BleDevice;
import cn.com.heaton.blelibrary.ble.model.EntityData;
import cn.com.heaton.blelibrary.ble.proxy.RequestImpl;
import cn.com.heaton.blelibrary.ble.proxy.RequestLisenter;
import cn.com.heaton.blelibrary.ble.proxy.RequestProxy;
import cn.com.heaton.blelibrary.ble.request.ConnectRequest;
import cn.com.heaton.blelibrary.ble.request.Rproxy;
import cn.com.heaton.blelibrary.ble.request.ScanRequest;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class Ble<T extends BleDevice> {
    public static final int REQUEST_ENABLE_BT = 1;
    private static final String TAG = "Ble";
    private static volatile Ble sInstance;
    private static volatile Options sOptions;
    private BluetoothLeService mBluetoothLeService;
    private Context mContext;
    private RequestLisenter<T> mRequest;
    private final Object mLocker = new Object();
    private final ServiceConnection mServiceConnection = new ServiceConnection() { // from class: cn.com.heaton.blelibrary.ble.Ble.3
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Ble.this.mBluetoothLeService = ((BluetoothLeService.LocalBinder) iBinder).getService();
            if (Ble.sInstance != null) {
                Ble.this.mBluetoothLeService.initialize(Ble.sOptions);
            }
            L.e(Ble.TAG, "Service connection successful");
            if (Ble.this.mBluetoothLeService.initBLE()) {
                return;
            }
            L.e(Ble.TAG, "Unable to initBLE Bluetooth");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Ble.this.mBluetoothLeService = null;
        }
    };
    private BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    public static class Options {
        public boolean logBleExceptions = true;
        public String logTAG = "AndroidBLE";
        public boolean throwBleException = true;
        public boolean autoConnect = false;
        public long connectTimeout = 10000;
        public long scanPeriod = 10000;
        public int serviceBindFailedRetryCount = 3;
        public int connectFailedRetryCount = 3;
        public boolean isFilterScan = false;
        public boolean isParseScanData = false;

        @RequiresApi(api = 21)
        public int manufacturerId = 65520;
        public UUID[] uuid_services_extra = new UUID[0];
        public UUID uuid_service = UUID.fromString("0000fee9-0000-1000-8000-00805f9b34fb");
        public UUID uuid_write_cha = UUID.fromString("d44bc439-abfd-45a2-b575-925416129600");
        public UUID uuid_read_cha = UUID.fromString("d44bc439-abfd-45a2-b575-925416129600");
        public UUID uuid_notify = UUID.fromString("d44bc439-abfd-45a2-b575-925416129601");
        public UUID uuid_notify_desc = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        public UUID uuid_ota_service = UUID.fromString("0000fee8-0000-1000-8000-00805f9b34fb");
        public UUID uuid_ota_notify_cha = UUID.fromString("003784cf-f7e3-55b4-6c4c-9fd140100a16");
        public UUID uuid_ota_write_cha = UUID.fromString("013784cf-f7e3-55b4-6c4c-9fd140100a16");

        public Ble<BleDevice> create(Context context) {
            return Ble.create(context);
        }

        public int getConnectFailedRetryCount() {
            return this.connectFailedRetryCount;
        }

        public long getConnectTimeout() {
            return this.connectTimeout;
        }

        public String getLogTAG() {
            return this.logTAG;
        }

        @RequiresApi(api = 21)
        public int getManufacturerId() {
            return this.manufacturerId;
        }

        public long getScanPeriod() {
            return this.scanPeriod;
        }

        public int getServiceBindFailedRetryCount() {
            return this.serviceBindFailedRetryCount;
        }

        public UUID getUuidNotify() {
            return this.uuid_notify;
        }

        public UUID getUuidNotifyDesc() {
            return this.uuid_notify_desc;
        }

        public UUID getUuidOtaNotifyCha() {
            return this.uuid_ota_notify_cha;
        }

        public UUID getUuidOtaService() {
            return this.uuid_ota_service;
        }

        public UUID getUuidOtaWriteCha() {
            return this.uuid_ota_write_cha;
        }

        public UUID getUuidReadCha() {
            return this.uuid_read_cha;
        }

        public UUID getUuidService() {
            return this.uuid_service;
        }

        public UUID[] getUuidServicesExtra() {
            return this.uuid_services_extra;
        }

        public UUID getUuidWriteCha() {
            return this.uuid_write_cha;
        }

        public boolean isAutoConnect() {
            return this.autoConnect;
        }

        public boolean isFilterScan() {
            return this.isFilterScan;
        }

        public boolean isLogBleExceptions() {
            return this.logBleExceptions;
        }

        public boolean isParseScanData() {
            return this.isParseScanData;
        }

        public boolean isThrowBleException() {
            return this.throwBleException;
        }

        public Options setAutoConnect(boolean z) {
            this.autoConnect = z;
            return this;
        }

        public Options setConnectFailedRetryCount(int i2) {
            this.connectFailedRetryCount = i2;
            return this;
        }

        public Options setConnectTimeout(long j) {
            this.connectTimeout = j;
            return this;
        }

        public Options setFilterScan(boolean z) {
            this.isFilterScan = z;
            return this;
        }

        public Options setLogBleExceptions(boolean z) {
            this.logBleExceptions = z;
            return this;
        }

        public Options setLogTAG(String str) {
            this.logTAG = str;
            return this;
        }

        @RequiresApi(api = 21)
        public Options setManufacturerId(int i2) {
            this.manufacturerId = i2;
            return this;
        }

        public Options setParseScanData(boolean z) {
            this.isParseScanData = z;
            return this;
        }

        public Options setScanPeriod(long j) {
            this.scanPeriod = j;
            return this;
        }

        public Options setServiceBindFailedRetryCount(int i2) {
            this.serviceBindFailedRetryCount = i2;
            return this;
        }

        public Options setThrowBleException(boolean z) {
            this.throwBleException = z;
            return this;
        }

        public Options setUuidNotify(UUID uuid) {
            this.uuid_notify = uuid;
            return this;
        }

        public Options setUuidNotifyDesc(UUID uuid) {
            this.uuid_notify_desc = uuid;
            return this;
        }

        public Options setUuidOtaNotifyCha(UUID uuid) {
            this.uuid_ota_notify_cha = uuid;
            return this;
        }

        public Options setUuidOtaService(UUID uuid) {
            this.uuid_ota_service = uuid;
            return this;
        }

        public Options setUuidOtaWriteCha(UUID uuid) {
            this.uuid_ota_write_cha = uuid;
            return this;
        }

        public Options setUuidReadCha(UUID uuid) {
            this.uuid_read_cha = uuid;
            return this;
        }

        public Options setUuidService(UUID uuid) {
            this.uuid_service = uuid;
            return this;
        }

        public Options setUuidServicesExtra(UUID[] uuidArr) {
            this.uuid_services_extra = uuidArr;
            return this;
        }

        public Options setUuidWriteCha(UUID uuid) {
            this.uuid_write_cha = uuid;
            return this;
        }
    }

    private Ble() {
    }

    public static Ble<BleDevice> create(Context context) {
        return create(context, options());
    }

    private static Class getClass(Type type, int i2) {
        return type instanceof ParameterizedType ? getGenericClass((ParameterizedType) type, i2) : type instanceof TypeVariable ? getClass(((TypeVariable) type).getBounds()[0], 0) : (Class) type;
    }

    private static Class getGenericClass(ParameterizedType parameterizedType, int i2) {
        Type type = parameterizedType.getActualTypeArguments()[i2];
        return type instanceof ParameterizedType ? (Class) ((ParameterizedType) type).getRawType() : type instanceof GenericArrayType ? (Class) ((GenericArrayType) type).getGenericComponentType() : type instanceof TypeVariable ? getClass(((TypeVariable) type).getBounds()[0], 0) : (Class) type;
    }

    public static <T extends BleDevice> Ble<T> getInstance() {
        if (sInstance == null) {
            synchronized (Ble.class) {
                if (sInstance == null) {
                    sInstance = new Ble();
                }
            }
        }
        return sInstance;
    }

    public static Options options() {
        if (sOptions == null) {
            sOptions = new Options();
        }
        return sOptions;
    }

    private boolean startService(Context context) {
        boolean zBindService = context != null ? context.bindService(new Intent(context, (Class<?>) BluetoothLeService.class), this.mServiceConnection, 1) : false;
        if (zBindService) {
            L.i(TAG, "service bind succseed!!!");
        } else if (sOptions.throwBleException) {
            try {
                throw new BleServiceException("Bluetooth service binding failed,Please check whether the service is registered in the manifest file!");
            } catch (BleServiceException e2) {
                e2.printStackTrace();
            }
        }
        return zBindService;
    }

    public void cancelNotify(T t) {
        this.mRequest.unNotify(t);
    }

    public void cancelWriteEntity() {
        this.mRequest.cancelWriteEntity();
    }

    public void clearDevices() {
        getDevices().clear();
    }

    public void connect(T t, BleConnectCallback<T> bleConnectCallback) {
        synchronized (this.mLocker) {
            this.mRequest.connect(t, bleConnectCallback);
        }
    }

    public void destory(Context context) {
        unService(context);
    }

    public void disconnect(T t) {
        this.mRequest.disconnect(t);
    }

    public T getBleDevice(int i2) {
        ConnectRequest connectRequest = (ConnectRequest) Rproxy.getInstance().getRequest(ConnectRequest.class);
        if (connectRequest != null) {
            return (T) connectRequest.getBleDevice(i2);
        }
        return null;
    }

    public BluetoothLeService getBleService() {
        return this.mBluetoothLeService;
    }

    public Class<T> getClassType() {
        return (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public ArrayList<T> getConnetedDevices() {
        ConnectRequest connectRequest = (ConnectRequest) Rproxy.getInstance().getRequest(ConnectRequest.class);
        if (connectRequest != null) {
            return connectRequest.getConnetedDevices();
        }
        return null;
    }

    public Context getContext() {
        return this.mContext;
    }

    public ArrayList<T> getDevices() {
        ConnectRequest connectRequest = (ConnectRequest) Rproxy.getInstance().getRequest(ConnectRequest.class);
        if (connectRequest != null) {
            return connectRequest.getDevices();
        }
        return null;
    }

    public Object getLocker() {
        return this.mLocker;
    }

    public boolean init(Context context, Options options) {
        if (options == null) {
            options = options();
        }
        sOptions = options;
        this.mContext = context;
        L.init(sOptions);
        this.mRequest = (RequestLisenter) RequestProxy.getInstance().bindProxy(context, RequestImpl.getInstance(sOptions));
        boolean zStartService = sInstance.startService(context);
        L.w(TAG, "bind service result is" + zStartService);
        return zStartService;
    }

    public boolean isBleEnable() {
        return this.mBluetoothAdapter.isEnabled();
    }

    public boolean isScanning() {
        return ((ScanRequest) Rproxy.getInstance().getRequest(ScanRequest.class)).isScanning();
    }

    public boolean isSupportBle(Context context) {
        return this.mBluetoothAdapter != null && context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public boolean read(T t, BleReadCallback<T> bleReadCallback) {
        return this.mRequest.read(t, bleReadCallback);
    }

    public void readRssi(T t, BleReadRssiCallback<T> bleReadRssiCallback) {
        this.mRequest.readRssi(t, bleReadRssiCallback);
    }

    public void reconnect(T t) {
        connect(t, (BleConnectCallback) null);
    }

    public boolean refreshDeviceCache(String str) {
        BluetoothLeService bluetoothLeService = this.mBluetoothLeService;
        if (bluetoothLeService != null) {
            return bluetoothLeService.refreshDeviceCache(str);
        }
        return false;
    }

    public void resetReConnect(T t, boolean z) {
        ConnectRequest connectRequest = (ConnectRequest) Rproxy.getInstance().getRequest(ConnectRequest.class);
        if (connectRequest != null) {
            connectRequest.resetReConnect(t, z);
        }
    }

    public void setBleStatusCallback(BleStatusCallback bleStatusCallback) {
        ScanRequest scanRequest = (ScanRequest) Rproxy.getInstance().getRequest(ScanRequest.class);
        if (scanRequest != null) {
            scanRequest.setBluetoothStatusCallback(bleStatusCallback);
        }
    }

    public boolean setMTU(String str, int i2, BleMtuCallback<T> bleMtuCallback) {
        return this.mRequest.setMtu(str, i2, bleMtuCallback);
    }

    public void startAdvertising(byte[] bArr) {
        this.mRequest.startAdvertising(bArr);
    }

    public void startNotify(T t, BleNotiftCallback<T> bleNotiftCallback) {
        this.mRequest.notify(t, bleNotiftCallback);
    }

    public void startScan(BleScanCallback<T> bleScanCallback, String str) {
        this.mRequest.startScan(bleScanCallback, str);
    }

    public void stopAdvertising() {
        this.mRequest.stopAdvertising();
    }

    public void stopScan() {
        this.mRequest.stopScan();
    }

    public boolean turnOffBlueTooth() {
        return !this.mBluetoothAdapter.isEnabled() || this.mBluetoothAdapter.disable();
    }

    public void turnOnBlueTooth(Activity activity) {
        if (isBleEnable()) {
            return;
        }
        activity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
    }

    public void turnOnBlueToothNo() {
        if (isBleEnable()) {
            return;
        }
        this.mBluetoothAdapter.enable();
    }

    public void unService(Context context) {
        if (context == null || this.mBluetoothLeService == null) {
            return;
        }
        context.unbindService(this.mServiceConnection);
        this.mBluetoothLeService = null;
    }

    public boolean write(T t, byte[] bArr, BleWriteCallback<T> bleWriteCallback) {
        return this.mRequest.write(t, bArr, bleWriteCallback);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Deprecated
    public void writeEntity(T t, byte[] bArr, @IntRange(from = 1, to = 20) int i2, int i3, BleWriteEntityCallback<T> bleWriteEntityCallback) {
        this.mRequest.writeEntity(t, new byte[]{0}, i2, i3, new BleWriteEntityCallback<T>() { // from class: cn.com.heaton.blelibrary.ble.Ble.1
            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteFailed() {
                L.e(Ble.TAG, "蓝牙锁唤醒命令发送失败");
            }

            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteSuccess() {
                L.e(Ble.TAG, "蓝牙锁唤醒命令发送成功");
            }
        });
        try {
            Thread.sleep(100L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mRequest.writeEntity(t, bArr, i2, i3, bleWriteEntityCallback);
    }

    public static Ble<BleDevice> create(Context context, Options options) {
        Ble<BleDevice> ble = getInstance();
        ble.init(context, options);
        return ble;
    }

    public void disconnect(T t, BleConnectCallback<T> bleConnectCallback) {
        this.mRequest.disconnect(t, bleConnectCallback);
    }

    public boolean setMTU(String str, int i2) {
        BluetoothLeService bluetoothLeService = this.mBluetoothLeService;
        if (bluetoothLeService != null) {
            return bluetoothLeService.setMTU(str, i2);
        }
        return false;
    }

    public T getBleDevice(String str) {
        ConnectRequest connectRequest = (ConnectRequest) Rproxy.getInstance().getRequest(ConnectRequest.class);
        if (connectRequest != null) {
            return (T) connectRequest.getBleDevice(str);
        }
        return null;
    }

    public void connect(T t, BluetoothDevice bluetoothDevice, BleConnectCallback<T> bleConnectCallback) {
        synchronized (this.mLocker) {
            this.mRequest.connect(t, bluetoothDevice, bleConnectCallback);
        }
    }

    public T getBleDevice(BluetoothDevice bluetoothDevice) {
        ConnectRequest connectRequest = (ConnectRequest) Rproxy.getInstance().getRequest(ConnectRequest.class);
        if (connectRequest != null) {
            return (T) connectRequest.getBleDevice(bluetoothDevice);
        }
        return null;
    }

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
    public void writeEntity(EntityData entityData, BleWriteEntityCallback<T> bleWriteEntityCallback) {
        if (!entityData.isAutoWriteMode()) {
            this.mRequest.writeEntity(new EntityData(entityData.isAutoWriteMode(), entityData.getAddress(), new byte[]{0}, entityData.getPackLength(), entityData.getDelay(), entityData.isLastPackComplete()), new BleWriteEntityCallback<T>() { // from class: cn.com.heaton.blelibrary.ble.Ble.2
                @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
                public void onWriteFailed() {
                    L.e(Ble.TAG, "蓝牙锁唤醒命令发送失败");
                }

                @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
                public void onWriteSuccess() {
                    L.e(Ble.TAG, "蓝牙锁唤醒命令发送成功");
                }
            });
            try {
                Thread.sleep(300L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            byte[] data = entityData.getData();
            byte[] bArr = new byte[data.length + 20];
            System.arraycopy(data, 0, bArr, 20, data.length);
            entityData.setData(bArr);
        }
        this.mRequest.writeEntity(entityData, bleWriteEntityCallback);
    }

    public void connect(String str, BleConnectCallback<T> bleConnectCallback) {
        synchronized (this.mLocker) {
            this.mRequest.connect(str, bleConnectCallback);
        }
    }
}

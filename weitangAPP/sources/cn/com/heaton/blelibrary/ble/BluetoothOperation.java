package cn.com.heaton.blelibrary.ble;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import cn.com.heaton.blelibrary.ble.callback.BleConnectCallback;
import cn.com.heaton.blelibrary.ble.callback.BleNotiftCallback;
import cn.com.heaton.blelibrary.ble.callback.BleScanCallback;
import cn.com.heaton.blelibrary.ble.callback.BleStatusCallback;
import cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback;
import cn.com.heaton.blelibrary.ble.event.CommandResultEvent;
import cn.com.heaton.blelibrary.ble.event.ConnectionChangedEvent;
import cn.com.heaton.blelibrary.ble.model.BleDevice;
import cn.com.heaton.blelibrary.ble.model.EntityData;
import cn.com.heaton.blelibrary.ble.utils.CommandUtil;
import cn.com.heaton.blelibrary.ble.utils.TLVParseUtils;
import com.tom_roush.fontbox.ttf.GlyfDescript;
import com.tom_roush.pdfbox.pdfparser.BaseParser;
import g.b.a.c;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothOperation {
    private static BleDevice BleDevice = null;
    private static BluetoothDevice BluetoothDevice = null;
    private static String Cookie = null;
    private static boolean IsAutoLock = false;
    private static byte[] LockPackage = null;
    private static String MacAddress = null;
    private static String Password = null;
    private static final String closeLock = "closeLock";
    private static final String confirmUpdateKeyPackage = "confirmUpdateKeyPackage";
    private static Context context = null;
    private static final String getNBSignal = "getNBSignal";
    private static final String getNBStatus = "getNBStatus";
    private static final String getNewKeyPackage = "getNewKeyPackage";
    private static final String getRandomStr = "getRandomStr";
    private static final String getTimeZoneFromLock = "getTimeZoneFromLock";
    private static Handler handler = null;
    private static Ble<BleDevice> mBle = null;
    private static byte[] miyao3 = null;
    private static final String openLock = "openLock";
    private static final String operationKey = "operationKey";
    private static final String setLockTimeZone = "setLockTimeZone";
    private static final String setNBStatus = "setNBStatus";
    private static Map<String, String> operationMap = new HashMap();
    private static byte[] buffer = new byte[256];
    private static boolean isNotifySuccess = false;
    private static boolean isSuperOperation = false;
    private static int connectnum = 0;
    private static boolean isReconnect = false;
    private static BleScanCallback<BleDevice> scanCallback = new BleScanCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.3
        @Override // cn.com.heaton.blelibrary.ble.callback.BleScanCallback
        public void onLeScan(BleDevice bleDevice, int i2, byte[] bArr, BluetoothDevice bluetoothDevice) {
            L.e(L.TAG, "onLeScan: " + bleDevice.getBleAddress());
            if (bluetoothDevice.getAddress().equals(BluetoothOperation.MacAddress)) {
                L.e(L.TAG, "已扫描到该设备：" + bluetoothDevice.getAddress());
                BluetoothDevice unused = BluetoothOperation.BluetoothDevice = bluetoothDevice;
                BleDevice unused2 = BluetoothOperation.BleDevice = bleDevice;
                BluetoothOperation.mBle.stopScan();
                BluetoothOperation.mBle.connect(bleDevice, bluetoothDevice, BluetoothOperation.connectCallback);
            }
        }
    };
    private static BleConnectCallback<BleDevice> connectCallback = new BleConnectCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.4
        @Override // cn.com.heaton.blelibrary.ble.callback.BleConnectCallback
        public void onConnectException(final BleDevice bleDevice, int i2) {
            super.onConnectException(bleDevice, i2);
            L.e(L.TAG, "连接异常，异常状态码:" + i2);
            if (BluetoothOperation.connectnum >= 3) {
                int unused = BluetoothOperation.connectnum = 0;
                c.getDefault().post(new ConnectionChangedEvent(bleDevice.getBleAddress(), 4));
            } else if (BluetoothOperation.isReconnect) {
                BluetoothOperation.handler.postDelayed(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT < 28) {
                            BluetoothOperation.mBle.connect(bleDevice, BluetoothOperation.BluetoothDevice, BluetoothOperation.connectCallback);
                        } else {
                            BluetoothOperation.connect(bleDevice.getBleAddress());
                        }
                    }
                }, 100L);
            }
        }

        @Override // cn.com.heaton.blelibrary.ble.callback.BleConnectCallback
        public void onConnectTimeOut(final BleDevice bleDevice) {
            super.onConnectTimeOut(bleDevice);
            L.e(L.TAG, "onConnectTimeOut: " + bleDevice.getBleAddress());
            if (BluetoothOperation.connectnum >= 3) {
                int unused = BluetoothOperation.connectnum = 0;
                c.getDefault().post(new ConnectionChangedEvent(bleDevice.getBleAddress(), 3));
            } else if (BluetoothOperation.isReconnect) {
                BluetoothOperation.handler.postDelayed(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.4.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT < 28) {
                            BluetoothOperation.mBle.connect(bleDevice, BluetoothOperation.BluetoothDevice, BluetoothOperation.connectCallback);
                        } else {
                            BluetoothOperation.connect(bleDevice.getBleAddress());
                        }
                    }
                }, 100L);
            }
        }

        @Override // cn.com.heaton.blelibrary.ble.callback.BleConnectCallback
        public void onConnectionChanged(final BleDevice bleDevice) {
            L.e(L.TAG, "onConnectionChanged: " + bleDevice.getConnectionState());
            if (bleDevice.isConnected()) {
                BluetoothOperation.mBle.startNotify(bleDevice, BluetoothOperation.notiftCallback);
                BluetoothOperation.handler.postDelayed(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BluetoothOperation.isNotifySuccess) {
                            boolean unused = BluetoothOperation.isNotifySuccess = false;
                        } else {
                            BluetoothOperation.disconnect(bleDevice.getBleAddress());
                            BluetoothOperation.handler.postDelayed(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.4.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (Build.VERSION.SDK_INT < 28) {
                                        BluetoothOperation.mBle.connect(bleDevice, BluetoothOperation.BluetoothDevice, BluetoothOperation.connectCallback);
                                    } else {
                                        BluetoothOperation.connect(bleDevice.getBleAddress());
                                    }
                                }
                            }, 2000L);
                        }
                    }
                }, 3000L);
            } else if (bleDevice.isConnectting()) {
                BluetoothOperation.access$804();
                c.getDefault().post(new ConnectionChangedEvent(bleDevice.getBleAddress(), 2));
            } else {
                c.getDefault().post(new ConnectionChangedEvent(bleDevice.getBleAddress(), 0));
            }
            L.e(L.TAG, "onConnectionChanged: " + bleDevice.isConnected());
        }
    };
    private static BleNotiftCallback<BleDevice> notiftCallback = new BleNotiftCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.5
        @Override // cn.com.heaton.blelibrary.ble.callback.BleNotiftCallback
        public void onNotifySuccess(BluetoothGatt bluetoothGatt) {
            super.onNotifySuccess(bluetoothGatt);
            boolean unused = BluetoothOperation.isNotifySuccess = true;
            int unused2 = BluetoothOperation.connectnum = 0;
            boolean unused3 = BluetoothOperation.isReconnect = false;
            c.getDefault().post(new ConnectionChangedEvent(bluetoothGatt.getDevice().getAddress(), 1));
            if (TextUtils.isEmpty((CharSequence) BluetoothOperation.operationMap.get(BluetoothOperation.operationKey))) {
                return;
            }
            String str = (String) BluetoothOperation.operationMap.get(BluetoothOperation.operationKey);
            str.hashCode();
            if (str.equals(BluetoothOperation.openLock)) {
                if (!BluetoothOperation.isSuperOperation) {
                    BluetoothOperation.openLock2(bluetoothGatt.getDevice().getAddress(), BluetoothOperation.Password, BluetoothOperation.IsAutoLock);
                    return;
                } else {
                    boolean unused4 = BluetoothOperation.isSuperOperation = false;
                    BluetoothOperation.openLockSuper2(bluetoothGatt.getDevice().getAddress(), BluetoothOperation.Cookie, BluetoothOperation.IsAutoLock);
                    return;
                }
            }
            if (str.equals(BluetoothOperation.closeLock)) {
                if (!BluetoothOperation.isSuperOperation) {
                    BluetoothOperation.closeLock2(bluetoothGatt.getDevice().getAddress(), BluetoothOperation.Password);
                } else {
                    boolean unused5 = BluetoothOperation.isSuperOperation = false;
                    BluetoothOperation.closeLockSuper2(bluetoothGatt.getDevice().getAddress(), BluetoothOperation.Cookie);
                }
            }
        }

        @Override // cn.com.heaton.blelibrary.ble.callback.BleNotiftCallback
        public void onChanged(final BleDevice bleDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            L.e(L.TAG, "收到" + bleDevice.getBleAddress() + "蓝牙锁消息:" + TLVParseUtils.toHexStr(bluetoothGattCharacteristic.getValue()));
            final byte[] value = bluetoothGattCharacteristic.getValue();
            ((Activity) BluetoothOperation.context).runOnUiThread(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.5.1
                @Override // java.lang.Runnable
                public void run() {
                    BluetoothOperation.byteMerger(value);
                    BluetoothOperation.subPackageOnce(bleDevice.getBleAddress());
                }
            });
        }
    };

    public static /* synthetic */ int access$804() {
        int i2 = connectnum + 1;
        connectnum = i2;
        return i2;
    }

    public static synchronized void byteMerger(byte[] bArr) {
        byte[] bArr2 = buffer;
        if (bArr2.length < 1 || (bArr2.length > 1 && bArr2[0] == 0 && bArr2[1] == 0)) {
            buffer = new byte[bArr.length];
            buffer = bArr;
        } else {
            int length = bArr2.length + bArr.length;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, 0, bArr3, buffer.length, bArr.length);
            buffer = new byte[length];
            buffer = bArr3;
        }
        L.e(L.TAG, "缓冲区数据：" + TLVParseUtils.toHexStr(buffer));
    }

    public static void checkBluetoothStatus(final String str) {
        if (!mBle.isSupportBle(context)) {
            Toast.makeText(context, "BLE is not supported", 0).show();
        }
        if (!mBle.isBleEnable()) {
            ((Activity) context).startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            if (Build.VERSION.SDK_INT >= 28) {
                handler.postDelayed(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.2
                    @Override // java.lang.Runnable
                    public void run() {
                        BluetoothOperation.connect(str);
                    }
                }, 500L);
                return;
            }
            BluetoothDevice bluetoothDevice = BluetoothDevice;
            if (bluetoothDevice != null && bluetoothDevice.getAddress().equals(str)) {
                mBle.connect(BleDevice, BluetoothDevice, connectCallback);
                return;
            }
            if (mBle.isScanning()) {
                mBle.stopScan();
            }
            mBle.startScan(scanCallback, str);
            return;
        }
        if (TextUtils.isEmpty(operationMap.get(operationKey))) {
            return;
        }
        String str2 = operationMap.get(operationKey);
        str2.hashCode();
        if (str2.equals(openLock)) {
            if (!isSuperOperation) {
                openLock2(str, Password, IsAutoLock);
                return;
            } else {
                isSuperOperation = false;
                openLockSuper2(str, Cookie, IsAutoLock);
                return;
            }
        }
        if (str2.equals(closeLock)) {
            if (!isSuperOperation) {
                closeLock2(str, Password);
            } else {
                isSuperOperation = false;
                closeLockSuper2(str, Cookie);
            }
        }
    }

    public static void closeLock(String str, byte[] bArr, byte[] bArr2) {
        closeLock(str, bArr, bArr2, false);
    }

    public static void closeLock2(final String str, String str2) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, closeLock, -1));
            return;
        }
        setCurrentOperation(closeLock);
        try {
            miyao3 = TLVParseUtils.hexStringtobyteArray((String) new JSONObject(str2).opt("BluetoothDataSecret"));
            byte[] bArr = CommandUtil.getRangeCode(new byte[]{12, 12, 12, 12}).getByte();
            L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr));
            EntityData entityData = getEntityData(str, CommandUtil.getCommunicationPackage(miyao3, bArr));
            if (entityData == null) {
                return;
            }
            mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.19
                @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
                public void onWriteFailed() {
                    L.e(L.TAG, "获取蓝牙锁通讯加密盐（随机串）命令发送失败");
                    c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.closeLock, -1));
                }

                @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
                public void onWriteSuccess() {
                    L.e(L.TAG, "获取蓝牙锁通讯加密盐（随机串）命令发送成功");
                }
            });
        } catch (JSONException e2) {
            e2.printStackTrace();
            c.getDefault().post(new CommandResultEvent(str, closeLock, -1));
        }
    }

    public static void closeLock3(Context context2, String str, String str2) {
        isReconnect = true;
        context = context2;
        setCurrentOperation(closeLock);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            Password = str2;
            miyao3 = TLVParseUtils.hexStringtobyteArray((String) jSONObject.opt("BluetoothDataSecret"));
            init(context, true, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            c.getDefault().post(new CommandResultEvent(str, openLock, -1));
        }
    }

    public static void closeLockSuper(final String str, byte[] bArr) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, closeLock, -1));
            return;
        }
        setCurrentOperation(closeLock);
        miyao3 = bArr;
        byte[] bArr2 = CommandUtil.getRangeCode(new byte[]{14, 14, 14, 14}).getByte();
        L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr2));
        EntityData entityData = getEntityData(str, CommandUtil.getCommunicationPackage(bArr, bArr2, true));
        if (entityData == null) {
            return;
        }
        mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.21
            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteFailed() {
                L.e(L.TAG, "获取蓝牙锁通讯加密盐（随机串）命令发送失败");
                c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.closeLock, -1));
            }

            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteSuccess() {
                L.e(L.TAG, "获取蓝牙锁通讯加密盐（随机串）命令发送成功");
            }
        });
    }

    public static void closeLockSuper2(final String str, String str2) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, closeLock, -1));
            return;
        }
        setCurrentOperation(closeLock);
        try {
            miyao3 = TLVParseUtils.hexStringtobyteArray((String) new JSONObject(str2).opt("SuperDataSecret"));
            byte[] bArr = CommandUtil.getRangeCode(new byte[]{GlyfDescript.X_DUAL, GlyfDescript.X_DUAL, GlyfDescript.X_DUAL, GlyfDescript.X_DUAL}).getByte();
            L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr));
            EntityData entityData = getEntityData(str, CommandUtil.getCommunicationPackage(miyao3, bArr, true));
            if (entityData == null) {
                return;
            }
            mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.23
                @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
                public void onWriteFailed() {
                    L.e(L.TAG, "获取蓝牙锁通讯加密盐（随机串）命令发送失败");
                    c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.closeLock, -1));
                }

                @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
                public void onWriteSuccess() {
                    L.e(L.TAG, "获取蓝牙锁通讯加密盐（随机串）命令发送成功");
                }
            });
        } catch (JSONException e2) {
            e2.printStackTrace();
            c.getDefault().post(new CommandResultEvent(str, closeLock, -1));
        }
    }

    public static void closeLockSuper3(Context context2, String str, String str2) {
        isReconnect = true;
        isSuperOperation = true;
        context = context2;
        setCurrentOperation(closeLock);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            Cookie = str2;
            miyao3 = TLVParseUtils.hexStringtobyteArray((String) jSONObject.opt("SuperDataSecret"));
            init(context, true, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            c.getDefault().post(new CommandResultEvent(str, closeLock, -1));
        }
    }

    public static void confirmUpdateKeyPackage(final String str, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, confirmUpdateKeyPackage, -1));
            return;
        }
        setCurrentOperation(confirmUpdateKeyPackage);
        miyao3 = bArr;
        byte[] bArr4 = CommandUtil.confirmUpdateKeyPackage(bArr2, bArr3, new byte[]{6, 6, 6, 6}).getByte();
        L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr4));
        EntityData entityData = getEntityData(str, CommandUtil.getCommunicationPackage(bArr, bArr4));
        if (entityData == null) {
            return;
        }
        mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.13
            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteFailed() {
                L.e(L.TAG, "确认更换蓝牙密钥命令发送失败");
                c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.confirmUpdateKeyPackage, -1));
            }

            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteSuccess() {
                L.e(L.TAG, "确认更换蓝牙密钥命令发送成功");
            }
        });
    }

    public static void connect(String str) {
        Ble<BleDevice> ble = mBle;
        if (ble == null || ble.getBleDevice(str) != null) {
            return;
        }
        mBle.connect(str, connectCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03dc A[Catch: all -> 0x069e, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000d, B:10:0x001c, B:21:0x007a, B:22:0x00a1, B:24:0x00a7, B:26:0x00ae, B:28:0x00bf, B:30:0x00c2, B:32:0x00df, B:34:0x00e9, B:52:0x0153, B:54:0x0163, B:68:0x0190, B:69:0x01b0, B:58:0x0176, B:61:0x017f, B:70:0x01d7, B:84:0x0204, B:85:0x0236, B:74:0x01ea, B:77:0x01f3, B:86:0x0268, B:88:0x0272, B:89:0x0289, B:90:0x02bb, B:92:0x02c5, B:93:0x02dc, B:94:0x030e, B:96:0x0318, B:97:0x033f, B:98:0x0371, B:100:0x0381, B:114:0x03ae, B:115:0x03dc, B:104:0x0394, B:107:0x039e, B:116:0x0403, B:130:0x0430, B:131:0x0462, B:120:0x0416, B:123:0x0420, B:132:0x0494, B:134:0x049e, B:135:0x04b5, B:136:0x04e7, B:138:0x04f1, B:139:0x0508, B:140:0x053a, B:142:0x054d, B:144:0x055a, B:164:0x0597, B:166:0x05a4, B:168:0x05b1, B:170:0x05c2, B:171:0x05d3, B:149:0x056f, B:152:0x0579, B:155:0x0583, B:172:0x05f3, B:191:0x0647, B:192:0x065e, B:193:0x0675, B:177:0x0622, B:180:0x062c, B:183:0x0636, B:194:0x068c, B:197:0x0695), top: B:205:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0462 A[Catch: all -> 0x069e, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000d, B:10:0x001c, B:21:0x007a, B:22:0x00a1, B:24:0x00a7, B:26:0x00ae, B:28:0x00bf, B:30:0x00c2, B:32:0x00df, B:34:0x00e9, B:52:0x0153, B:54:0x0163, B:68:0x0190, B:69:0x01b0, B:58:0x0176, B:61:0x017f, B:70:0x01d7, B:84:0x0204, B:85:0x0236, B:74:0x01ea, B:77:0x01f3, B:86:0x0268, B:88:0x0272, B:89:0x0289, B:90:0x02bb, B:92:0x02c5, B:93:0x02dc, B:94:0x030e, B:96:0x0318, B:97:0x033f, B:98:0x0371, B:100:0x0381, B:114:0x03ae, B:115:0x03dc, B:104:0x0394, B:107:0x039e, B:116:0x0403, B:130:0x0430, B:131:0x0462, B:120:0x0416, B:123:0x0420, B:132:0x0494, B:134:0x049e, B:135:0x04b5, B:136:0x04e7, B:138:0x04f1, B:139:0x0508, B:140:0x053a, B:142:0x054d, B:144:0x055a, B:164:0x0597, B:166:0x05a4, B:168:0x05b1, B:170:0x05c2, B:171:0x05d3, B:149:0x056f, B:152:0x0579, B:155:0x0583, B:172:0x05f3, B:191:0x0647, B:192:0x065e, B:193:0x0675, B:177:0x0622, B:180:0x062c, B:183:0x0636, B:194:0x068c, B:197:0x0695), top: B:205:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x05d3 A[Catch: all -> 0x069e, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000d, B:10:0x001c, B:21:0x007a, B:22:0x00a1, B:24:0x00a7, B:26:0x00ae, B:28:0x00bf, B:30:0x00c2, B:32:0x00df, B:34:0x00e9, B:52:0x0153, B:54:0x0163, B:68:0x0190, B:69:0x01b0, B:58:0x0176, B:61:0x017f, B:70:0x01d7, B:84:0x0204, B:85:0x0236, B:74:0x01ea, B:77:0x01f3, B:86:0x0268, B:88:0x0272, B:89:0x0289, B:90:0x02bb, B:92:0x02c5, B:93:0x02dc, B:94:0x030e, B:96:0x0318, B:97:0x033f, B:98:0x0371, B:100:0x0381, B:114:0x03ae, B:115:0x03dc, B:104:0x0394, B:107:0x039e, B:116:0x0403, B:130:0x0430, B:131:0x0462, B:120:0x0416, B:123:0x0420, B:132:0x0494, B:134:0x049e, B:135:0x04b5, B:136:0x04e7, B:138:0x04f1, B:139:0x0508, B:140:0x053a, B:142:0x054d, B:144:0x055a, B:164:0x0597, B:166:0x05a4, B:168:0x05b1, B:170:0x05c2, B:171:0x05d3, B:149:0x056f, B:152:0x0579, B:155:0x0583, B:172:0x05f3, B:191:0x0647, B:192:0x065e, B:193:0x0675, B:177:0x0622, B:180:0x062c, B:183:0x0636, B:194:0x068c, B:197:0x0695), top: B:205:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x063f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0675 A[Catch: all -> 0x069e, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000d, B:10:0x001c, B:21:0x007a, B:22:0x00a1, B:24:0x00a7, B:26:0x00ae, B:28:0x00bf, B:30:0x00c2, B:32:0x00df, B:34:0x00e9, B:52:0x0153, B:54:0x0163, B:68:0x0190, B:69:0x01b0, B:58:0x0176, B:61:0x017f, B:70:0x01d7, B:84:0x0204, B:85:0x0236, B:74:0x01ea, B:77:0x01f3, B:86:0x0268, B:88:0x0272, B:89:0x0289, B:90:0x02bb, B:92:0x02c5, B:93:0x02dc, B:94:0x030e, B:96:0x0318, B:97:0x033f, B:98:0x0371, B:100:0x0381, B:114:0x03ae, B:115:0x03dc, B:104:0x0394, B:107:0x039e, B:116:0x0403, B:130:0x0430, B:131:0x0462, B:120:0x0416, B:123:0x0420, B:132:0x0494, B:134:0x049e, B:135:0x04b5, B:136:0x04e7, B:138:0x04f1, B:139:0x0508, B:140:0x053a, B:142:0x054d, B:144:0x055a, B:164:0x0597, B:166:0x05a4, B:168:0x05b1, B:170:0x05c2, B:171:0x05d3, B:149:0x056f, B:152:0x0579, B:155:0x0583, B:172:0x05f3, B:191:0x0647, B:192:0x065e, B:193:0x0675, B:177:0x0622, B:180:0x062c, B:183:0x0636, B:194:0x068c, B:197:0x0695), top: B:205:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b0 A[Catch: all -> 0x069e, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000d, B:10:0x001c, B:21:0x007a, B:22:0x00a1, B:24:0x00a7, B:26:0x00ae, B:28:0x00bf, B:30:0x00c2, B:32:0x00df, B:34:0x00e9, B:52:0x0153, B:54:0x0163, B:68:0x0190, B:69:0x01b0, B:58:0x0176, B:61:0x017f, B:70:0x01d7, B:84:0x0204, B:85:0x0236, B:74:0x01ea, B:77:0x01f3, B:86:0x0268, B:88:0x0272, B:89:0x0289, B:90:0x02bb, B:92:0x02c5, B:93:0x02dc, B:94:0x030e, B:96:0x0318, B:97:0x033f, B:98:0x0371, B:100:0x0381, B:114:0x03ae, B:115:0x03dc, B:104:0x0394, B:107:0x039e, B:116:0x0403, B:130:0x0430, B:131:0x0462, B:120:0x0416, B:123:0x0420, B:132:0x0494, B:134:0x049e, B:135:0x04b5, B:136:0x04e7, B:138:0x04f1, B:139:0x0508, B:140:0x053a, B:142:0x054d, B:144:0x055a, B:164:0x0597, B:166:0x05a4, B:168:0x05b1, B:170:0x05c2, B:171:0x05d3, B:149:0x056f, B:152:0x0579, B:155:0x0583, B:172:0x05f3, B:191:0x0647, B:192:0x065e, B:193:0x0675, B:177:0x0622, B:180:0x062c, B:183:0x0636, B:194:0x068c, B:197:0x0695), top: B:205:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0236 A[Catch: all -> 0x069e, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000d, B:10:0x001c, B:21:0x007a, B:22:0x00a1, B:24:0x00a7, B:26:0x00ae, B:28:0x00bf, B:30:0x00c2, B:32:0x00df, B:34:0x00e9, B:52:0x0153, B:54:0x0163, B:68:0x0190, B:69:0x01b0, B:58:0x0176, B:61:0x017f, B:70:0x01d7, B:84:0x0204, B:85:0x0236, B:74:0x01ea, B:77:0x01f3, B:86:0x0268, B:88:0x0272, B:89:0x0289, B:90:0x02bb, B:92:0x02c5, B:93:0x02dc, B:94:0x030e, B:96:0x0318, B:97:0x033f, B:98:0x0371, B:100:0x0381, B:114:0x03ae, B:115:0x03dc, B:104:0x0394, B:107:0x039e, B:116:0x0403, B:130:0x0430, B:131:0x0462, B:120:0x0416, B:123:0x0420, B:132:0x0494, B:134:0x049e, B:135:0x04b5, B:136:0x04e7, B:138:0x04f1, B:139:0x0508, B:140:0x053a, B:142:0x054d, B:144:0x055a, B:164:0x0597, B:166:0x05a4, B:168:0x05b1, B:170:0x05c2, B:171:0x05d3, B:149:0x056f, B:152:0x0579, B:155:0x0583, B:172:0x05f3, B:191:0x0647, B:192:0x065e, B:193:0x0675, B:177:0x0622, B:180:0x062c, B:183:0x0636, B:194:0x068c, B:197:0x0695), top: B:205:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized void dealData(java.lang.String r13, byte[] r14) {
        /*
            Method dump skipped, instruction units count: 1697
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.heaton.blelibrary.ble.BluetoothOperation.dealData(java.lang.String, byte[]):void");
    }

    public static void disconnect(String str) {
        Ble<BleDevice> ble = mBle;
        if (ble != null) {
            for (T t : ble.getConnetedDevices()) {
                if (t.getBleAddress().equals(str)) {
                    mBle.cancelNotify(t);
                    mBle.disconnect(t, connectCallback);
                }
            }
        }
    }

    public static int getConnectStatus(String str) {
        Ble<BleDevice> ble = mBle;
        if (ble == null || ble.getBleDevice(str) == null) {
            return 0;
        }
        if (mBle.getBleDevice(str).isConnectting()) {
            return 2;
        }
        return mBle.getBleDevice(str).isConnected() ? 1 : 0;
    }

    private static EntityData getEntityData(String str, byte[] bArr) {
        return new EntityData.Builder().setAutoWriteMode(isAutoMode(str)).setAddress(str).setData(bArr).setPackLength(20).setDelay(50L).build();
    }

    public static void getNBSignal(final String str, byte[] bArr, byte[] bArr2) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, getNBSignal, -1));
            return;
        }
        setCurrentOperation(getNBSignal);
        miyao3 = bArr;
        byte[] bArr3 = CommandUtil.getLockStatus(bArr2, new byte[]{2, 2, 2, 2}).getByte();
        L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr3));
        EntityData entityData = getEntityData(str, CommandUtil.getCommunicationPackage(bArr, bArr3));
        if (entityData == null) {
            return;
        }
        mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.9
            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteFailed() {
                L.e(L.TAG, "获取NB信号强度命令发送失败");
                c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.getNBSignal, -1));
            }

            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteSuccess() {
                L.e(L.TAG, "获取NB信号强度命令发送成功");
            }
        });
    }

    public static void getNBStatus(final String str, byte[] bArr, byte[] bArr2) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, getNBStatus, -1));
            return;
        }
        setCurrentOperation(getNBStatus);
        miyao3 = bArr;
        byte[] bArr3 = CommandUtil.getNBStatus(bArr2, new byte[]{9, 9, 9, 9}).getByte();
        L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr3));
        EntityData entityData = getEntityData(str, CommandUtil.getCommunicationPackage(bArr, bArr3));
        if (entityData == null) {
            return;
        }
        mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.16
            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteFailed() {
                L.e(L.TAG, "获取NB功能打开状态命令发送失败");
                c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.getNBStatus, -1));
            }

            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteSuccess() {
                L.e(L.TAG, "获取NB功能打开状态命令发送成功");
            }
        });
    }

    public static void getNewKeyPackage(final String str, byte[] bArr, byte[] bArr2) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, getNewKeyPackage, -1));
            return;
        }
        setCurrentOperation(getNewKeyPackage);
        miyao3 = bArr;
        byte[] bArr3 = CommandUtil.getNewKeyPackage(bArr2, new byte[]{5, 5, 5, 5}).getByte();
        L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr3));
        EntityData entityData = getEntityData(str, CommandUtil.getCommunicationPackage(bArr, bArr3));
        if (entityData == null) {
            return;
        }
        mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.12
            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteFailed() {
                L.e(L.TAG, "获取新的蓝牙密钥命令发送失败");
                c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.getNewKeyPackage, -1));
            }

            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteSuccess() {
                L.e(L.TAG, "获取新的蓝牙密钥命令发送成功");
            }
        });
    }

    public static void getRandomStr(final String str, byte[] bArr) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, getRandomStr, -1));
            return;
        }
        setCurrentOperation(getRandomStr);
        miyao3 = bArr;
        byte[] bArr2 = CommandUtil.getRangeCode(new byte[]{1, 1, 1, 1}).getByte();
        L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr2));
        EntityData entityData = getEntityData(str, CommandUtil.getCommunicationPackage(bArr, bArr2));
        if (entityData == null) {
            return;
        }
        mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.8
            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteFailed() {
                L.e(L.TAG, "获取蓝牙锁通讯加密盐（随机串）命令发送失败");
                c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.getRandomStr, -1));
            }

            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteSuccess() {
                L.e(L.TAG, "获取蓝牙锁通讯加密盐（随机串）命令发送成功");
            }
        });
    }

    public static void getTimeZoneFromLock(final String str, byte[] bArr, byte[] bArr2) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, getTimeZoneFromLock, -1));
            return;
        }
        setCurrentOperation(getTimeZoneFromLock);
        miyao3 = bArr;
        byte[] bArr3 = CommandUtil.getLockStatus(bArr2, new byte[]{7, 7, 7, 7}).getByte();
        L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr3));
        EntityData entityData = getEntityData(str, CommandUtil.getCommunicationPackage(bArr, bArr3));
        if (entityData == null) {
            return;
        }
        mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.14
            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteFailed() {
                L.e(L.TAG, "读取锁时间&时区命令发送失败");
                c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.getTimeZoneFromLock, -1));
            }

            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteSuccess() {
                L.e(L.TAG, "读取锁时间&时区命令发送成功");
            }
        });
    }

    public static void init(Context context2, boolean z) {
        init(context, z, null);
    }

    public static void initBle(boolean z, String str) {
        Ble<BleDevice> ble = mBle;
        if (ble == null || ble.getBleService() == null) {
            mBle = Ble.options().setLogBleExceptions(z).setThrowBleException(true).setLogTAG("AndroidBLE").setFilterScan(true).setScanPeriod(30000L).setConnectTimeout(10000L).setUuidService(UUID.fromString("000018f0-0000-1000-8000-00805f9b34fb")).setUuidWriteCha(UUID.fromString("00002af1-0000-1000-8000-00805f9b34fb")).setUuidReadCha(UUID.fromString("00002af0-0000-1000-8000-00805f9b34fb")).setUuidNotify(UUID.fromString("00002af0-0000-1000-8000-00805f9b34fb")).create(context.getApplicationContext());
        }
        initBleStatus();
        checkBluetoothStatus(str);
    }

    public static void initBleStatus() {
        mBle.setBleStatusCallback(new BleStatusCallback() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.1
            @Override // cn.com.heaton.blelibrary.ble.callback.BleStatusCallback
            public void onBluetoothStatusOff() {
                L.i(L.TAG, "onBluetoothStatusOff: 蓝牙关闭>>>>>");
            }

            @Override // cn.com.heaton.blelibrary.ble.callback.BleStatusCallback
            public void onBluetoothStatusOn() {
                L.i(L.TAG, "onBluetoothStatusOn: 蓝牙开启>>>>>");
            }
        });
    }

    private static boolean isAutoMode(String str) {
        Ble<BleDevice> ble = mBle;
        return (ble == null || ble.getBleService() == null || mBle.getBleService().getWriteCharacteristic(str) == null || mBle.getBleService().getWriteCharacteristic(str).getWriteType() != 2) ? false : true;
    }

    public static void openLock(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z) {
        openLock(str, bArr, bArr2, bArr3, z, false);
    }

    public static void openLock2(final String str, String str2, boolean z) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, openLock, -1));
            return;
        }
        setCurrentOperation(openLock);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String str3 = (String) jSONObject.opt("BluetoothDataSecret");
            String str4 = (String) jSONObject.opt("BluetoothUserKey");
            miyao3 = TLVParseUtils.hexStringtobyteArray(str3);
            LockPackage = TLVParseUtils.hexStringtobyteArray(str4);
            IsAutoLock = z;
            byte[] bArr = CommandUtil.getRangeCode(new byte[]{11, 11, 11, 11}).getByte();
            L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr));
            EntityData entityData = getEntityData(str, CommandUtil.getCommunicationPackage(miyao3, bArr));
            if (entityData == null) {
                return;
            }
            mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.18
                @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
                public void onWriteFailed() {
                    L.e(L.TAG, "获取蓝牙锁通讯加密盐（随机串）命令发送失败");
                    c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.openLock, -1));
                }

                @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
                public void onWriteSuccess() {
                    L.e(L.TAG, "获取蓝牙锁通讯加密盐（随机串）命令发送成功");
                }
            });
        } catch (JSONException e2) {
            e2.printStackTrace();
            c.getDefault().post(new CommandResultEvent(str, openLock, -1));
        }
    }

    public static void openLock3(Context context2, String str, String str2, boolean z) {
        isReconnect = true;
        context = context2;
        setCurrentOperation(openLock);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            Password = str2;
            String str3 = (String) jSONObject.opt("BluetoothDataSecret");
            String str4 = (String) jSONObject.opt("BluetoothUserKey");
            miyao3 = TLVParseUtils.hexStringtobyteArray(str3);
            LockPackage = TLVParseUtils.hexStringtobyteArray(str4);
            IsAutoLock = z;
            init(context, true, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            c.getDefault().post(new CommandResultEvent(str, openLock, -1));
        }
    }

    public static void openLockSuper(final String str, byte[] bArr, byte[] bArr2, boolean z) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, openLock, -1));
            return;
        }
        setCurrentOperation(openLock);
        miyao3 = bArr;
        LockPackage = bArr2;
        IsAutoLock = z;
        byte[] bArr3 = CommandUtil.getRangeCode(new byte[]{BaseParser.ASCII_CR, BaseParser.ASCII_CR, BaseParser.ASCII_CR, BaseParser.ASCII_CR}).getByte();
        L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr3));
        EntityData entityData = getEntityData(str, CommandUtil.getCommunicationPackage(bArr, bArr3, true));
        if (entityData == null) {
            return;
        }
        mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.20
            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteFailed() {
                L.e(L.TAG, "获取蓝牙锁通讯加密盐（随机串）命令发送失败");
                c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.openLock, -1));
            }

            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteSuccess() {
                L.e(L.TAG, "获取蓝牙锁通讯加密盐（随机串）命令发送成功");
            }
        });
    }

    public static void openLockSuper2(final String str, String str2, boolean z) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, openLock, -1));
            return;
        }
        setCurrentOperation(openLock);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String str3 = (String) jSONObject.opt("SuperDataSecret");
            String str4 = (String) jSONObject.opt("SuperUserKey");
            miyao3 = TLVParseUtils.hexStringtobyteArray(str3);
            LockPackage = TLVParseUtils.hexStringtobyteArray(str4);
            IsAutoLock = z;
            byte[] bArr = CommandUtil.getRangeCode(new byte[]{15, 15, 15, 15}).getByte();
            L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr));
            EntityData entityData = getEntityData(str, CommandUtil.getCommunicationPackage(miyao3, bArr, true));
            if (entityData == null) {
                return;
            }
            mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.22
                @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
                public void onWriteFailed() {
                    L.e(L.TAG, "获取蓝牙锁通讯加密盐（随机串）命令发送失败");
                    c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.openLock, -1));
                }

                @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
                public void onWriteSuccess() {
                    L.e(L.TAG, "获取蓝牙锁通讯加密盐（随机串）命令发送成功");
                }
            });
        } catch (JSONException e2) {
            e2.printStackTrace();
            c.getDefault().post(new CommandResultEvent(str, openLock, -1));
        }
    }

    public static void openLockSuper3(Context context2, String str, String str2, boolean z) {
        isReconnect = true;
        isSuperOperation = true;
        context = context2;
        setCurrentOperation(openLock);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            Cookie = str2;
            String str3 = (String) jSONObject.opt("SuperDataSecret");
            String str4 = (String) jSONObject.opt("SuperUserKey");
            miyao3 = TLVParseUtils.hexStringtobyteArray(str3);
            LockPackage = TLVParseUtils.hexStringtobyteArray(str4);
            IsAutoLock = z;
            init(context, true, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            c.getDefault().post(new CommandResultEvent(str, openLock, -1));
        }
    }

    public static void release() {
        connectnum = 0;
        isReconnect = false;
        isNotifySuccess = false;
        Handler handler2 = handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        Ble<BleDevice> ble = mBle;
        if (ble != null) {
            ble.stopScan();
            BleDevice bleDevice = BleDevice;
            if (bleDevice != null) {
                mBle.disconnect(bleDevice);
                BleDevice = null;
            }
            BluetoothDevice = null;
            for (T t : mBle.getConnetedDevices()) {
                mBle.cancelNotify(t);
                mBle.disconnect(t, connectCallback);
            }
            if (mBle.getBleService() != null) {
                for (BluetoothGatt bluetoothGatt : mBle.getBleService().getmBluetoothGattList()) {
                    bluetoothGatt.disconnect();
                    bluetoothGatt.close();
                }
            }
            mBle.destory(context.getApplicationContext());
            mBle.clearDevices();
        }
        c.getDefault().unregister(context);
    }

    private static void setCurrentOperation(String str) {
        operationMap.put(operationKey, str);
    }

    public static void setLockTimeZone(final String str, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, setLockTimeZone, -1));
            return;
        }
        setCurrentOperation(setLockTimeZone);
        miyao3 = bArr;
        byte[] bArr4 = CommandUtil.setLockTimeZone(bArr2, bArr3, new byte[]{8, 8, 8, 8}).getByte();
        L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr4));
        EntityData entityData = getEntityData(str, CommandUtil.getCommunicationPackage(bArr, bArr4));
        if (entityData == null) {
            return;
        }
        mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.15
            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteFailed() {
                L.e(L.TAG, "设置锁时间&时区命令发送失败");
                c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.setLockTimeZone, -1));
            }

            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteSuccess() {
                L.e(L.TAG, "设置锁时间&时区命令发送成功");
            }
        });
    }

    public static void setNBStatus(final String str, byte[] bArr, byte[] bArr2, boolean z) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, setNBStatus, -1));
            return;
        }
        setCurrentOperation(setNBStatus);
        miyao3 = bArr;
        byte[] bArr3 = CommandUtil.setNBStatus(bArr2, new byte[]{10, 10, 10, 10}, z ? new byte[]{1} : new byte[]{0}).getByte();
        L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr3));
        EntityData entityData = getEntityData(str, CommandUtil.getCommunicationPackage(bArr, bArr3));
        if (entityData == null) {
            return;
        }
        mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.17
            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteFailed() {
                L.e(L.TAG, "关闭或打开NB功能命令发送失败");
                c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.setNBStatus, -1));
            }

            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteSuccess() {
                L.e(L.TAG, "关闭或打开NB功能命令发送成功");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized boolean subPackageOnce(String str) {
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.6
            @Override // java.lang.Runnable
            public void run() {
                if (BluetoothOperation.buffer == null || BluetoothOperation.buffer.length < 5) {
                    byte[] unused = BluetoothOperation.buffer = new byte[0];
                    L.e(L.TAG, "超时清空缓存区");
                }
            }
        }, 5000L);
        byte[] bArr = buffer;
        if (bArr != null && bArr.length >= 5) {
            if ((bArr[0] != 31 || bArr[1] != 2) && ((bArr[0] != 106 || bArr[1] != 1) && ((bArr[0] != 106 || bArr[1] != 2) && ((bArr[0] != 106 || bArr[1] != 3) && (bArr[0] != 106 || bArr[1] != 4))))) {
                buffer = new byte[0];
                L.e(L.TAG, "数据不符合清空缓存区");
                return false;
            }
            int i2 = bArr[3];
            if (bArr.length - 5 < i2) {
                handler.removeCallbacksAndMessages(null);
                handler.postDelayed(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.7
                    @Override // java.lang.Runnable
                    public void run() {
                        byte[] unused = BluetoothOperation.buffer = new byte[0];
                        L.e(L.TAG, "超时清空缓存区");
                    }
                }, 5000L);
                return false;
            }
            int i3 = i2 + 5;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            L.e(L.TAG, "组成单个完整包数据：" + TLVParseUtils.toHexStr(bArr2));
            buffer = new byte[0];
            L.e(L.TAG, "组完单个包后清空缓存区");
            dealData(str, bArr2);
            return true;
        }
        return false;
    }

    public static void closeLock(final String str, byte[] bArr, byte[] bArr2, boolean z) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, closeLock, -1));
            return;
        }
        setCurrentOperation(closeLock);
        miyao3 = bArr;
        byte[] bArr3 = CommandUtil.closeLock(bArr2, new byte[]{4, 4, 4, 4}).getByte();
        L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr3));
        EntityData entityData = getEntityData(str, z ? CommandUtil.getCommunicationPackage(bArr, bArr3, true) : CommandUtil.getCommunicationPackage(bArr, bArr3));
        if (entityData == null) {
            return;
        }
        mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.11
            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteFailed() {
                L.e(L.TAG, "蓝牙关锁命令发送失败");
                c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.closeLock, -1));
            }

            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteSuccess() {
                L.e(L.TAG, "蓝牙关锁命令发送成功");
            }
        });
    }

    public static void init(Context context2, boolean z, String str) {
        MacAddress = str;
        context = context2;
        handler = new Handler();
        if (!c.getDefault().isRegistered(context)) {
            c.getDefault().register(context);
        }
        initBle(z, str);
    }

    public static void openLock(final String str, byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z, boolean z2) {
        if (mBle.getBleDevice(str) == null || !mBle.getBleDevice(str).isConnected()) {
            L.e(L.TAG, "蓝牙锁未连接");
            c.getDefault().post(new CommandResultEvent(str, openLock, -1));
            return;
        }
        setCurrentOperation(openLock);
        miyao3 = bArr;
        LockPackage = bArr2;
        IsAutoLock = z;
        byte[] bArr4 = CommandUtil.openLock(bArr2, bArr3, new byte[]{3, 3, 3, 3}, z ? new byte[]{1} : new byte[]{0}).getByte();
        L.e(L.TAG, "待发送未加密数据：" + TLVParseUtils.toHexStr(bArr4));
        EntityData entityData = getEntityData(str, z2 ? CommandUtil.getCommunicationPackage(bArr, bArr4, true) : CommandUtil.getCommunicationPackage(bArr, bArr4));
        if (entityData == null) {
            return;
        }
        mBle.writeEntity(entityData, new BleWriteEntityCallback<BleDevice>() { // from class: cn.com.heaton.blelibrary.ble.BluetoothOperation.10
            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteFailed() {
                L.e(L.TAG, "蓝牙开锁命令发送失败");
                c.getDefault().post(new CommandResultEvent(str, BluetoothOperation.openLock, -1));
            }

            @Override // cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback
            public void onWriteSuccess() {
                L.e(L.TAG, "蓝牙开锁命令发送成功");
            }
        });
    }
}

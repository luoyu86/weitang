package c.p.a.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.text.TextUtils;
import c.p.a.a.n;
import java.util.Iterator;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class p extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final UUID f3041e = UUID.fromString("00002902-0000-1000-8000-00805F9B34FB");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final UUID f3042f = UUID.fromString("0000ffe9-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final UUID f3043g = UUID.fromString("0000ffe4-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public n.a f3045i;

    public p(BluetoothGatt bluetoothGatt, j jVar) {
        super(bluetoothGatt, jVar);
        this.f3044h = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void i(java.lang.String r9, android.bluetooth.BluetoothGattCharacteristic r10) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.p.a.a.p.i(java.lang.String, android.bluetooth.BluetoothGattCharacteristic):void");
    }

    public final void g(String str) {
        if (this.f3045i != null) {
            c.p.a.d.d.d("VTOpenDoorWriterHandle", "disconnectConnect method = " + str);
            this.f3045i.disconnectBluetooth();
        }
    }

    public void j(n.a aVar) {
        this.f3045i = aVar;
    }

    public void k(BluetoothGatt bluetoothGatt) {
        if (this.f3044h) {
            c.p.a.d.d.d("VTOpenDoorWriterHandle", "setCharacteristicNotification true notification");
            return;
        }
        if (bluetoothGatt == null) {
            f("蓝牙适配器为空!");
            g("setNotificationCharacteristic-BLE_ADAPTER_EMPTY");
            return;
        }
        this.f2998a = bluetoothGatt;
        int i2 = 0;
        if (bluetoothGatt == null) {
            try {
                c.p.a.d.d.e("VTOpenDoorWriterHandle", "setCharacteristicNotification mBluetoothGatt is null sleep");
                for (int i3 = 0; this.f2998a == null && i3 < 5; i3++) {
                    Thread.sleep(80L);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristicB = b(k.getInstance().getNotifyUuid(), false);
        if (bluetoothGattCharacteristicB == null) {
            try {
                c.p.a.d.d.e("VTOpenDoorWriterHandle", "setCharacteristicNotification characteristic is null sleep");
                while (bluetoothGattCharacteristicB == null && i2 < 8) {
                    Thread.sleep(100L);
                    i2++;
                    bluetoothGattCharacteristicB = b(k.getInstance().getNotifyUuid(), true);
                }
                if (bluetoothGattCharacteristicB == null) {
                    this.f2998a = bluetoothGatt;
                    BluetoothGattCharacteristic bluetoothGattCharacteristicB2 = b(k.getInstance().getNotifyUuid(), true);
                    try {
                        c.p.a.d.d.e("VTOpenDoorWriterHandle", "setCharacteristicNotification characteristic is null sleep over");
                        bluetoothGattCharacteristicB = bluetoothGattCharacteristicB2;
                    } catch (Exception e3) {
                        bluetoothGattCharacteristicB = bluetoothGattCharacteristicB2;
                        e = e3;
                        e.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e = e4;
            }
        }
        this.f3044h = this.f2998a.setCharacteristicNotification(bluetoothGattCharacteristicB, true);
        c.p.a.d.d.d("VTOpenDoorWriterHandle", "setCharacteristicNotification notification:" + this.f3044h + ", Properties = " + bluetoothGattCharacteristicB.getProperties());
        if (!this.f3044h) {
            f("添加通知监听失败!");
            g("setNotificationCharacteristic-BLE_ADD_NOTIFICATION_FAILED");
            return;
        }
        Iterator<BluetoothGattDescriptor> it = bluetoothGattCharacteristicB.getDescriptors().iterator();
        while (it.hasNext()) {
            c.p.a.d.d.d("VTOpenDoorWriterHandle", "setCharacteristicNotification notification getUuid:" + it.next().getUuid().toString());
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristicB.getDescriptor(f3041e);
        descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        boolean zWriteDescriptor = this.f2998a.writeDescriptor(descriptor);
        this.f3044h = zWriteDescriptor;
        if (!zWriteDescriptor) {
            f("添加通知监听失败!");
            g("setNotificationCharacteristic-BLE_ADD_NOTIFICATION_FAILED");
        }
        c.p.a.d.d.d("VTOpenDoorWriterHandle", "setCharacteristicNotification write notification:" + this.f3044h);
    }

    public void l(final String str, boolean z) {
        final BluetoothGattCharacteristic bluetoothGattCharacteristicB = b(k.getInstance().getWriterUuid(), false);
        if (this.f2998a != null && bluetoothGattCharacteristicB != null && !TextUtils.isEmpty(str)) {
            new Thread(new Runnable() { // from class: c.p.a.a.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2995a.i(str, bluetoothGattCharacteristicB);
                }
            }).start();
        } else {
            f("写入数据为空或者BluetoothGattCharacteristic对象为空!");
            g("setNotificationCharacteristic-BLE_WRITE_DATA_EMPTY_FAILED");
        }
    }
}

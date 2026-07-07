package c.q.a.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.text.TextUtils;
import c.q.a.a.m;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class o extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f3111e = "o";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final UUID f3112f = UUID.fromString("00002902-0000-1000-8000-00805F9B34FB");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final UUID f3113g = UUID.fromString("0000ffe9-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final UUID f3114h = UUID.fromString("0000ffe4-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3115i;
    public m.a j;

    public o(BluetoothGatt bluetoothGatt, i iVar) {
        super(bluetoothGatt, iVar);
        this.f3115i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void i(java.lang.String r8, android.bluetooth.BluetoothGattCharacteristic r9) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.q.a.a.o.i(java.lang.String, android.bluetooth.BluetoothGattCharacteristic):void");
    }

    public final void g(String str) {
        if (this.j != null) {
            c.q.a.c.i.d(f3111e, "disconnectConnect method = " + str);
            this.j.disconnectBluetooth();
        }
    }

    public void j(m.a aVar) {
        this.j = aVar;
    }

    public void k(BluetoothGatt bluetoothGatt) {
        if (this.f3115i) {
            c.q.a.c.i.d(f3111e, "setCharacteristicNotification true notification");
            return;
        }
        if (bluetoothGatt == null) {
            f("蓝牙适配器为空!");
            g("setNotificationCharacteristic-BLE_ADAPTER_EMPTY");
            return;
        }
        int i2 = 0;
        if (this.f3072a == null) {
            try {
                c.q.a.c.i.e(f3111e, "setCharacteristicNotification mBluetoothGatt is null sleep");
                for (int i3 = 0; this.f3072a == null && i3 < 5; i3++) {
                    Thread.sleep(80L);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristicB = b(j.f3077b, false);
        if (bluetoothGattCharacteristicB == null) {
            try {
                c.q.a.c.i.e(f3111e, "setCharacteristicNotification characteristic is null sleep");
                while (bluetoothGattCharacteristicB == null && i2 < 8) {
                    Thread.sleep(100L);
                    i2++;
                    bluetoothGattCharacteristicB = b(j.f3077b, true);
                }
                if (bluetoothGattCharacteristicB == null) {
                    this.f3072a = bluetoothGatt;
                    BluetoothGattCharacteristic bluetoothGattCharacteristicB2 = b(j.f3077b, true);
                    try {
                        c.q.a.c.i.e(f3111e, "setCharacteristicNotification characteristic is null sleep over");
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
        this.f3115i = this.f3072a.setCharacteristicNotification(bluetoothGattCharacteristicB, true);
        c.q.a.c.i.d(f3111e, "setCharacteristicNotification notification:" + this.f3115i + ", Properties = " + bluetoothGattCharacteristicB.getProperties());
        if (!this.f3115i) {
            f("添加通知监听失败!");
            g("setNotificationCharacteristic-BLE_ADD_NOTIFICATION_FAILED");
            return;
        }
        for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristicB.getDescriptors()) {
            c.q.a.c.i.d(f3111e, "setCharacteristicNotification notification getUuid:" + bluetoothGattDescriptor.getUuid().toString());
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristicB.getDescriptor(f3112f);
        descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        boolean zWriteDescriptor = this.f3072a.writeDescriptor(descriptor);
        this.f3115i = zWriteDescriptor;
        if (!zWriteDescriptor) {
            f("添加通知监听失败!");
            g("setNotificationCharacteristic-BLE_ADD_NOTIFICATION_FAILED");
        }
        c.q.a.c.i.d(f3111e, "setCharacteristicNotification write notification:" + this.f3115i);
    }

    public void l(final String str, boolean z) {
        final BluetoothGattCharacteristic bluetoothGattCharacteristicB = b(j.f3076a, false);
        if (this.f3072a != null && bluetoothGattCharacteristicB != null && !TextUtils.isEmpty(str)) {
            new Thread(new Runnable() { // from class: c.q.a.a.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3069a.i(str, bluetoothGattCharacteristicB);
                }
            }).start();
        } else {
            f("写入数据为空或者BluetoothGattCharacteristic对象为空!");
            g("setNotificationCharacteristic-BLE_WRITE_DATA_EMPTY_FAILED");
        }
    }
}

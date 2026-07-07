package c.e.e.a.r.j;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.chinavisionary.twlib.R;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class o extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f2457c = "o";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final UUID f2458d = UUID.fromString("00002902-0000-1000-8000-00805F9B34FB");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final UUID f2459e = UUID.fromString("0000ffe9-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final UUID f2460f = UUID.fromString("0000ffe4-0000-1000-8000-00805f9b34fb");

    public o(BluetoothGatt bluetoothGatt, c.e.e.a.r.d dVar) {
        super(bluetoothGatt, dVar);
    }

    public void j(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt == null) {
            i(c.e.e.a.x.k.getString(R.string.tw_lib_title_ble_adapter_is_empty));
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristicB = b(f2460f);
        boolean characteristicNotification = bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristicB, true);
        String str = f2457c;
        c.e.e.a.x.i.d(str, "setCharacteristicNotification notification:" + characteristicNotification);
        if (!characteristicNotification) {
            i(c.e.e.a.x.k.getString(R.string.tw_lib_title_ble_add_notification_failed));
            return;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristicB.getDescriptor(f2458d);
        descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        boolean zWriteDescriptor = bluetoothGatt.writeDescriptor(descriptor);
        if (!zWriteDescriptor) {
            i(c.e.e.a.x.k.getString(R.string.tw_lib_title_ble_add_notification_failed));
        }
        c.e.e.a.x.i.d(str, "setCharacteristicNotification write notification:" + zWriteDescriptor);
    }

    public void k(String str) {
        BluetoothGattCharacteristic bluetoothGattCharacteristicB = b(f2459e);
        if (this.f2423a == null || bluetoothGattCharacteristicB == null || c.e.e.a.x.k.isNullStr(str)) {
            i(c.e.e.a.x.k.getString(R.string.tw_lib_title_ble_writer_data_is_empty));
            return;
        }
        bluetoothGattCharacteristicB.setValue(c.e.e.a.x.h.hexStringToBytes(str));
        c.e.e.a.r.d dVar = this.f2424b;
        if (dVar != null) {
            dVar.onUnlocking();
        }
        boolean zWriteCharacteristic = this.f2423a.writeCharacteristic(bluetoothGattCharacteristicB);
        c.e.e.a.x.i.d(f2457c, "is success :" + zWriteCharacteristic);
        if (zWriteCharacteristic) {
            return;
        }
        i(c.e.e.a.x.k.getString(R.string.tw_lib_title_unlock_failed_writer_data_err));
    }
}

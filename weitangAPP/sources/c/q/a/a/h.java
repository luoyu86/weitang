package c.q.a.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Build;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGatt f3072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f3073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothGattCharacteristic f3074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BluetoothGattCharacteristic f3075d;

    public h(BluetoothGatt bluetoothGatt, i iVar) {
        this.f3072a = bluetoothGatt;
        this.f3073b = iVar;
    }

    public boolean a() {
        return Build.VERSION.SDK_INT >= 23 && !e();
    }

    public BluetoothGattCharacteristic b(UUID uuid, boolean z) {
        List<BluetoothGattService> listD;
        BluetoothGattService bluetoothGattServiceC = c();
        if (bluetoothGattServiceC != null) {
            if (z && (listD = d()) != null && !listD.isEmpty()) {
                for (BluetoothGattService bluetoothGattService : listD) {
                    c.q.a.c.i.d(getClass().getSimpleName(), "getBluetoothGattCharacteristic service uuid =" + bluetoothGattService.getUuid());
                    List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                    if (characteristics != null && !characteristics.isEmpty()) {
                        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                            c.q.a.c.i.d(getClass().getSimpleName(), "getBluetoothGattCharacteristic  gattCharacteristic uuid =" + bluetoothGattCharacteristic.getUuid());
                        }
                    }
                }
            }
            BluetoothGattCharacteristic characteristic = bluetoothGattServiceC.getCharacteristic(uuid);
            if (characteristic != null) {
                return characteristic;
            }
            c.q.a.c.i.d(getClass().getSimpleName(), "getBluetoothGattCharacteristic bluetoothGattCharacteristic is null");
            return characteristic;
        }
        c.q.a.c.i.d(getClass().getSimpleName(), "getBluetoothGattCharacteristic gattServices is null");
        if (z) {
            List<BluetoothGattService> listD2 = d();
            if (listD2 == null || listD2.isEmpty()) {
                String simpleName = getClass().getSimpleName();
                StringBuilder sb = new StringBuilder();
                sb.append("getBluetoothGattCharacteristic gattServices list is null,gatt = ");
                sb.append(this.f3072a == null);
                c.q.a.c.i.d(simpleName, sb.toString());
            } else {
                for (BluetoothGattService bluetoothGattService2 : listD2) {
                    c.q.a.c.i.d(getClass().getSimpleName(), "getBluetoothGattCharacteristic service uuid =" + bluetoothGattService2.getUuid());
                    List<BluetoothGattCharacteristic> characteristics2 = bluetoothGattService2.getCharacteristics();
                    if (characteristics2 != null && !characteristics2.isEmpty()) {
                        for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : characteristics2) {
                            c.q.a.c.i.d(getClass().getSimpleName(), "getBluetoothGattCharacteristic  gattCharacteristic uuid =" + bluetoothGattCharacteristic2.getUuid());
                        }
                    }
                }
            }
        }
        return null;
    }

    public final BluetoothGattService c() {
        BluetoothGatt bluetoothGatt = this.f3072a;
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getService(j.f3078c);
    }

    public final List<BluetoothGattService> d() {
        BluetoothGatt bluetoothGatt = this.f3072a;
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getServices();
    }

    public final boolean e() {
        return Build.BRAND.equals("Xiaomi") && Build.VERSION.SDK_INT == 23;
    }

    public void f(String str) {
        i iVar = this.f3073b;
        if (iVar != null) {
            iVar.onUnlockFailed(str);
        }
    }

    public void setReadBluetoothGattCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f3075d = bluetoothGattCharacteristic;
    }

    public void setWriterBluetoothGattCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f3074c = bluetoothGattCharacteristic;
    }
}

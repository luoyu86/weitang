package c.p.a.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Build;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGatt f2998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f2999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothGattCharacteristic f3000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BluetoothGattCharacteristic f3001d;

    public i(BluetoothGatt bluetoothGatt, j jVar) {
        this.f2998a = bluetoothGatt;
        this.f2999b = jVar;
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
                    c.p.a.d.d.d("BaseVTOpenDoorHandle", "getBluetoothGattCharacteristic service uuid =" + bluetoothGattService.getUuid());
                    List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                    if (characteristics != null && !characteristics.isEmpty()) {
                        Iterator<BluetoothGattCharacteristic> it = characteristics.iterator();
                        while (it.hasNext()) {
                            c.p.a.d.d.d("BaseVTOpenDoorHandle", "getBluetoothGattCharacteristic  gattCharacteristic uuid =" + it.next().getUuid());
                        }
                    }
                }
            }
            BluetoothGattCharacteristic characteristic = bluetoothGattServiceC.getCharacteristic(uuid);
            if (characteristic != null) {
                return characteristic;
            }
            c.p.a.d.d.d("BaseVTOpenDoorHandle", "getBluetoothGattCharacteristic bluetoothGattCharacteristic is null");
            return characteristic;
        }
        c.p.a.d.d.d("BaseVTOpenDoorHandle", "getBluetoothGattCharacteristic gattServices is null");
        if (z) {
            List<BluetoothGattService> listD2 = d();
            if (listD2 == null || listD2.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("getBluetoothGattCharacteristic gattServices list is null,gatt = ");
                sb.append(this.f2998a == null);
                c.p.a.d.d.d("BaseVTOpenDoorHandle", sb.toString());
            } else {
                for (BluetoothGattService bluetoothGattService2 : listD2) {
                    c.p.a.d.d.d("BaseVTOpenDoorHandle", "getBluetoothGattCharacteristic service uuid =" + bluetoothGattService2.getUuid());
                    List<BluetoothGattCharacteristic> characteristics2 = bluetoothGattService2.getCharacteristics();
                    if (characteristics2 != null && !characteristics2.isEmpty()) {
                        Iterator<BluetoothGattCharacteristic> it2 = characteristics2.iterator();
                        while (it2.hasNext()) {
                            c.p.a.d.d.d("BaseVTOpenDoorHandle", "getBluetoothGattCharacteristic  gattCharacteristic uuid =" + it2.next().getUuid());
                        }
                    }
                }
            }
        }
        return null;
    }

    public final BluetoothGattService c() {
        BluetoothGatt bluetoothGatt = this.f2998a;
        if (bluetoothGatt != null) {
            return bluetoothGatt.getService(k.getInstance().getServiceUuid());
        }
        c.p.a.d.d.e("BaseVTOpenDoorHandle", "getSupportedGattService mBluetoothGatt is null");
        return null;
    }

    public final List<BluetoothGattService> d() {
        BluetoothGatt bluetoothGatt = this.f2998a;
        if (bluetoothGatt != null) {
            return bluetoothGatt.getServices();
        }
        c.p.a.d.d.e("BaseVTOpenDoorHandle", "getSupportedGattServices mBluetoothGatt is null");
        return null;
    }

    public final boolean e() {
        return Build.BRAND.equals("Xiaomi") && Build.VERSION.SDK_INT == 23;
    }

    public void f(String str) {
        j jVar = this.f2999b;
        if (jVar != null) {
            jVar.onUnlockFailed(str);
        }
    }

    public void setReadBluetoothGattCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f3001d = bluetoothGattCharacteristic;
    }

    public void setWriterBluetoothGattCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f3000c = bluetoothGattCharacteristic;
    }
}

package c.e.e.a.r.j;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Build;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGatt f2423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.e.e.a.r.d f2424b;

    public j(BluetoothGatt bluetoothGatt, c.e.e.a.r.d dVar) {
        this.f2423a = bluetoothGatt;
        this.f2424b = dVar;
    }

    public boolean a() {
        return Build.VERSION.SDK_INT >= 23 && !g();
    }

    public BluetoothGattCharacteristic b(UUID uuid) {
        List<BluetoothGattService> listD = d();
        BluetoothGattCharacteristic characteristic = null;
        if (listD != null) {
            Iterator<BluetoothGattService> it = listD.iterator();
            while (it.hasNext() && (characteristic = it.next().getCharacteristic(uuid)) == null) {
            }
        }
        return characteristic;
    }

    public String c(String str) {
        StringBuilder sb = new StringBuilder(4);
        if (str.length() > 8) {
            sb.append("cmd=");
            sb.append(str.substring(0, 4));
            sb.append("code=");
            sb.append(str.substring(4, 6));
        } else {
            sb.append("code=");
            sb.append(str);
        }
        return sb.toString();
    }

    public void closeGatt() {
        BluetoothGatt bluetoothGatt = this.f2423a;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
            this.f2423a.close();
            this.f2423a = null;
            c.e.e.a.x.i.d(getClass().getSimpleName(), "closeGatt");
        }
    }

    public final List<BluetoothGattService> d() {
        BluetoothGatt bluetoothGatt = this.f2423a;
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getServices();
    }

    public boolean e() {
        return c.e.e.a.x.f.getOpenDoorModel() == 1;
    }

    public boolean f() {
        return c.e.e.a.x.f.getOpenDoorModel() == 0;
    }

    public final boolean g() {
        return Build.BRAND.equals("Xiaomi") && Build.VERSION.SDK_INT == 23;
    }

    public void h(c.e.e.a.r.d dVar) {
        this.f2424b = dVar;
    }

    public void i(String str) {
        c.e.e.a.r.d dVar = this.f2424b;
        if (dVar != null) {
            dVar.onUnlockFailed(str);
        }
    }
}

package c.e.e.a.r.j;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.chinavisionary.twlib.R;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class m extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f2442c = "m";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final UUID f2443d = UUID.fromString("00002a00-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final UUID f2444e = UUID.fromString("0000ffe4-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f2446g;

    public interface a {
        void resetBluetoothConnect();

        void useCookieUnlock();
    }

    public m(c.e.e.a.r.d dVar, a aVar) {
        super(null, dVar);
        this.f2445f = false;
        this.f2446g = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(BluetoothGatt bluetoothGatt) {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        String str = f2442c;
        c.e.e.a.x.i.d(str, "performReadCharacteristic start read data is isReadSuccess:" + this.f2445f);
        if (this.f2445f) {
            return;
        }
        boolean characteristic = bluetoothGatt.readCharacteristic(b(f2443d));
        c.e.e.a.x.i.d(str, "performReadCharacteristic end read data is :" + characteristic);
        this.f2445f = characteristic;
        if (characteristic) {
            return;
        }
        o(c.e.e.a.x.k.getString(R.string.tw_lib_title_ble_read_data_err));
    }

    public final void j(byte[] bArr) {
        String str = f2442c;
        c.e.e.a.x.i.i(str, "  bleUnlockResponse ");
        if (bArr[2] == 0) {
            q();
            s();
        } else {
            String strEncodeHexStr = c.e.e.a.x.h.encodeHexStr(bArr);
            if (bArr[2] == 1) {
                t(strEncodeHexStr);
            } else {
                q();
                i(c.e.e.a.x.k.getString(R.string.tw_lib_title_pwd_and_cookie_err));
                c.e.e.a.x.i.d(str, "蓝牙cookie开锁失败... ");
            }
        }
        this.f2445f = false;
    }

    public final byte[] k(BluetoothGatt bluetoothGatt) {
        List<BluetoothGattCharacteristic> characteristics;
        byte[] value;
        for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
            if (bluetoothGattService != null && (characteristics = bluetoothGattService.getCharacteristics()) != null) {
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                    if (bluetoothGattCharacteristic != null && bluetoothGattCharacteristic.getUuid().toString().equals(f2444e.toString()) && (value = bluetoothGattCharacteristic.getValue()) != null) {
                        c.e.e.a.x.i.d(f2442c, "bluetoothGattDescriptor lenght :" + value.length + ",readValue:" + c.e.e.a.x.h.encodeHexStr(value) + ",uuid :" + bluetoothGattCharacteristic.getUuid());
                        return value;
                    }
                }
            }
        }
        return null;
    }

    public void l(BluetoothGatt bluetoothGatt, int i2) {
        String str = f2442c;
        c.e.e.a.x.i.d(str, "handleCharacteristicRead  start isReadSuccess :" + this.f2445f);
        if (i2 == 0) {
            byte[] bArrK = k(bluetoothGatt);
            if (bArrK != null && bArrK.length > 0) {
                String strEncodeHexStr = c.e.e.a.x.h.encodeHexStr(bArrK);
                byte[] bArrDecodeBleWriteData = c.e.e.a.x.c.decodeBleWriteData(bArrK);
                if (bArrDecodeBleWriteData == null) {
                    i(c(strEncodeHexStr));
                    this.f2445f = false;
                    c.e.e.a.x.i.i(str, " onCharacteristicRead bytes1 is null ");
                } else if (bArrDecodeBleWriteData[1] == -62) {
                    j(bArrDecodeBleWriteData);
                } else {
                    i(c(strEncodeHexStr));
                    this.f2445f = false;
                }
                c.e.e.a.x.i.i(str, " onCharacteristicRead end " + bArrK.length + " && " + strEncodeHexStr);
            }
        } else {
            i(c.e.e.a.x.k.getString(R.string.tw_lib_title_ble_red_data_err) + i2);
            this.f2445f = false;
        }
        c.e.e.a.x.i.i(str, " handleCharacteristicRead end isReadSuccess：" + this.f2445f);
    }

    public final void o(String str) {
        c.e.e.a.r.d dVar = this.f2424b;
        if (dVar != null) {
            dVar.onConnectError(str);
        }
    }

    public void p(final BluetoothGatt bluetoothGatt) {
        this.f2423a = bluetoothGatt;
        new Thread(new Runnable() { // from class: c.e.e.a.r.j.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f2418a.n(bluetoothGatt);
            }
        }).start();
    }

    public final void q() {
        a aVar = this.f2446g;
        if (aVar != null) {
            aVar.resetBluetoothConnect();
        }
    }

    public void r(c.e.e.a.r.d dVar, a aVar) {
        this.f2446g = aVar;
        this.f2424b = dVar;
    }

    public final void s() {
        c.e.e.a.r.d dVar = this.f2424b;
        if (dVar != null) {
            dVar.onUnlockSuccess();
        }
    }

    public final void t(String str) {
        c.e.e.a.r.d dVar = this.f2424b;
        if (dVar != null) {
            dVar.onUnlockPwdFailed(c.e.e.a.x.k.getString(R.string.tw_lib_title_pwd_err_use_cookie) + c(str));
        }
        a aVar = this.f2446g;
        if (aVar != null) {
            aVar.useCookieUnlock();
        }
    }
}

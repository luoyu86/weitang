package c.q.a.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class m extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f3098e = "m";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final UUID f3099f = UUID.fromString("00002a00-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f3100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f3101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AtomicBoolean f3102i;
    public StringBuilder j;
    public boolean k;
    public a l;

    public interface a {
        void disconnectBluetooth();

        void resetBluetoothConnect();

        void retryOpenDoor();

        void useCookieUnlock();
    }

    public m(i iVar, a aVar) {
        super(null, iVar);
        this.f3101h = new CopyOnWriteArrayList<>();
        this.f3102i = new AtomicBoolean(false);
        this.k = false;
        this.l = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(BluetoothGatt bluetoothGatt) {
        c.q.a.c.i.d(f3098e, "performReadCharacteristic start read data is isReadSuccess:" + this.k);
        if (this.k) {
            return;
        }
        h(bluetoothGatt, 0);
    }

    public final byte[] g(BluetoothGatt bluetoothGatt) {
        List<BluetoothGattCharacteristic> characteristics;
        byte[] value;
        for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
            if (bluetoothGattService != null && (characteristics = bluetoothGattService.getCharacteristics()) != null) {
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                    if (bluetoothGattCharacteristic != null && bluetoothGattCharacteristic.getUuid().toString().equals(j.f3077b.toString()) && (value = bluetoothGattCharacteristic.getValue()) != null) {
                        c.q.a.c.i.d(f3098e, "bluetoothGattDescriptor lenght :" + value.length + ",readValue:" + c.q.a.c.h.encodeHexStr(value).toUpperCase(Locale.ROOT) + ",uuid :" + bluetoothGattCharacteristic.getUuid());
                        return value;
                    }
                }
            }
        }
        return null;
    }

    public synchronized void h(BluetoothGatt bluetoothGatt, int i2) {
        String str = f3098e;
        c.q.a.c.i.d(str, "handleCharacteristicRead  start isReadSuccess :" + this.k);
        if (i2 == 0) {
            byte[] bArrG = g(bluetoothGatt);
            if (bArrG != null && bArrG.length > 0) {
                byte b2 = bArrG[1];
                c.q.a.c.i.d(str, "handleCharacteristicRead  start dataLength :" + ((int) b2));
                if (this.j == null) {
                    this.j = new StringBuilder();
                }
                int i3 = b2 * 2;
                if (this.j.length() < i3) {
                    String upperCase = c.q.a.c.h.encodeHexStr(c.q.a.c.c.decodeVtBleResponseData(bArrG)).toUpperCase(Locale.ROOT);
                    this.f3101h.add(upperCase);
                    this.j.append(upperCase);
                    c.q.a.c.i.i(str, " onCharacteristicRead end " + bArrG.length + " && " + upperCase + ",mResult = " + this.j.length());
                    if (this.j.length() == i3) {
                        i();
                    }
                }
            }
        } else {
            f("蓝牙数据读取失败, 错误码:" + i2);
            this.k = false;
        }
        c.q.a.c.i.i(str, " handleCharacteristicRead end isReadSuccess：" + this.k);
    }

    public void i() {
        c.q.a.c.i.d(f3098e, "handleReadComplete");
        if (this.f3073b != null) {
            try {
                TimeUnit.MILLISECONDS.sleep(10L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            StringBuilder sb = new StringBuilder(this.f3101h.size());
            Iterator<String> it = this.f3101h.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            this.j = null;
            this.f3101h.clear();
            String string = sb.toString();
            String str = f3098e;
            c.q.a.c.i.d(str, "handleReadComplete size = " + sb.length() + ", result = " + ((Object) sb));
            boolean z = true;
            if (string.equals("AAEE20")) {
                if (this.f3102i.getAndSet(true)) {
                    return;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(200L);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                this.l.retryOpenDoor();
                c.q.a.c.i.d(f3098e, "handleReadComplete retry send open door");
                return;
            }
            if (string.indexOf("9A") == 0) {
                this.f3102i.getAndSet(false);
                if (c.q.a.c.c.openDoorIsSuccess(string)) {
                    this.f3073b.onUnlockSuccess();
                } else {
                    this.f3073b.onUnlockFailed(c.q.a.c.c.parseOpenDoorResult(string));
                }
            } else {
                this.f3073b.onReadResult(string);
            }
            if (!TextUtils.isEmpty(this.f3100g)) {
                c.q.a.c.i.d(str, "handleReadComplete mWriteData = " + this.f3100g + ", result = " + ((Object) sb));
                if ("9A0301037A8A7A8B".equals(this.f3100g) && "8AEE08".equals(sb.toString())) {
                    z = false;
                }
            }
            if (z) {
                this.l.disconnectBluetooth();
            }
        }
    }

    public void l(final BluetoothGatt bluetoothGatt) {
        this.f3072a = bluetoothGatt;
        new Thread(new Runnable() { // from class: c.q.a.a.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f3065a.k(bluetoothGatt);
            }
        }).start();
    }

    public void setWriteData(String str) {
        this.f3100g = str;
    }
}

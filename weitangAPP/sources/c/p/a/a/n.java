package c.p.a.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Handler;
import android.os.Message;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class n extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f3028e = "n";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final UUID f3029f = UUID.fromString("00002a00-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f3030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f3031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AtomicBoolean f3032i;
    public StringBuilder j;
    public boolean k;
    public a l;
    public final c.p.a.c.b m;
    public final Handler n;

    public interface a {
        void disconnectBluetooth();

        void resetBluetoothConnect();

        void retryOpenDoor();

        void useCookieUnlock();
    }

    public n(j jVar, a aVar) {
        super(null, jVar);
        this.f3031h = new CopyOnWriteArrayList<>();
        this.f3032i = new AtomicBoolean(false);
        this.k = false;
        c.p.a.c.b bVar = new c.p.a.c.b() { // from class: c.p.a.a.e
            @Override // c.p.a.c.b
            public final void handleMessage(Message message) {
                this.f2989a.j(message);
            }
        };
        this.m = bVar;
        this.n = c.p.a.c.c.obtain(bVar);
        this.l = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Message message) {
        if (message.what == 8) {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        c.p.a.d.d.d(f3028e, "performReadCharacteristic start read data is isReadSuccess:" + this.k);
        if (this.k) {
            return;
        }
        g(bluetoothGatt, 0, bluetoothGattCharacteristic);
    }

    public synchronized void g(BluetoothGatt bluetoothGatt, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] value;
        String str = f3028e;
        c.p.a.d.d.d(str, "handleCharacteristicRead  start isReadSuccess :" + this.k);
        if (i2 != 0) {
            f("蓝牙数据读取失败, 错误码:" + i2);
            this.k = false;
        } else if (k.getInstance().getNotifyUuid().equals(bluetoothGattCharacteristic.getUuid()) && (value = bluetoothGattCharacteristic.getValue()) != null && value.length > 0) {
            if (this.j == null) {
                this.j = new StringBuilder();
            }
            String upperCase = c.p.a.d.c.encodeHexStr(value).toUpperCase(Locale.ROOT);
            if (!this.f3031h.contains(upperCase)) {
                this.f3031h.add(upperCase);
                this.f3031h.add("#");
                this.j.append(upperCase);
                c.p.a.d.d.i(str, " onCharacteristicRead end " + value.length + " && " + upperCase + ",mResult = " + this.j.length());
            }
            n();
        }
        c.p.a.d.d.i(str, " handleCharacteristicRead end isReadSuccess：" + this.k);
    }

    public void h() {
        c.p.a.d.d.d(f3028e, "handleReadComplete");
        if (this.f2999b != null) {
            try {
                TimeUnit.MILLISECONDS.sleep(10L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            StringBuilder sb = new StringBuilder(this.f3031h.size());
            Iterator<String> it = this.f3031h.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            this.j = null;
            this.f3031h.clear();
            String string = sb.toString();
            c.p.a.d.d.d(f3028e, "handleReadComplete size = " + sb.length() + ", result = " + ((Object) sb));
            this.f2999b.onReadResult(string);
            if (k.getInstance().isReadDataToDisconnect()) {
                this.l.disconnectBluetooth();
            }
        }
    }

    public void m(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f2998a = bluetoothGatt;
        new Thread(new Runnable() { // from class: c.p.a.a.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f2990a.l(bluetoothGatt, bluetoothGattCharacteristic);
            }
        }).start();
    }

    public final void n() {
        this.n.removeMessages(8);
        this.n.sendEmptyMessageDelayed(8, 800L);
    }

    public void setWriteData(String str) {
        this.f3030g = str;
    }
}

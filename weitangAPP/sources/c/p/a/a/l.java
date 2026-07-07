package c.p.a.a;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import c.p.a.a.m;
import c.p.a.a.n;
import c.p.a.a.o;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f3009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothGatt f3011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BluetoothAdapter f3012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c.p.a.b.a f3013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f3014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o f3015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p f3016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f3017i;
    public boolean j = false;
    public final c.p.a.c.b k;
    public final Handler l;
    public boolean m;
    public boolean n;
    public volatile boolean o;
    public final o.d p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final m.b f3018q;
    public final n.a r;
    public final Runnable s;

    public class a implements m.b {
        public a() {
        }

        public final void a(int i2) {
            if (l.this.f3011c == null) {
                c.p.a.d.d.i("VTOpenDoorAdapter", "handleDisconnect mBluetoothGatt is null state:" + i2);
                return;
            }
            if (!l.this.j) {
                l.this.K("连接已断开,status=" + i2);
            }
            c.p.a.d.d.i("VTOpenDoorAdapter", "handleDisconnect mBluetoothGatt state:" + i2 + ", isActiveDisconnect = " + l.this.j);
            l.this.O();
            l.this.w(i2);
        }

        public final void b() {
            c.p.a.d.d.i("VTOpenDoorAdapter", "onConnectionStateChange time:" + System.currentTimeMillis());
            if (l.this.m) {
                l.this.z("handlerConnectSuccess");
                return;
            }
            if (l.this.f3011c == null) {
                try {
                    c.p.a.d.d.e("VTOpenDoorAdapter", "handlerConnectSuccess sleep");
                    for (int i2 = 0; l.this.f3011c == null && i2 < 5; i2++) {
                        Thread.sleep(80L);
                    }
                    if (l.this.f3011c != null) {
                        Thread.sleep(180L);
                        c.p.a.d.d.e("VTOpenDoorAdapter", "handlerConnectSuccess sleep over");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (l.this.f3011c != null) {
                l.this.f3011c.discoverServices();
            }
        }

        @Override // c.p.a.a.m.b
        public void onCharacteristicReadData(int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (l.this.f3014f != null) {
                l.this.f3014f.g(l.this.f3011c, i2, bluetoothGattCharacteristic);
            }
        }

        @Override // c.p.a.a.m.b
        public void onConnectResult(BluetoothGatt bluetoothGatt) {
            l.this.f3011c = bluetoothGatt;
            l.this.C();
            l.this.E();
            c.p.a.d.d.i("VTOpenDoorAdapter", "onConnectResult time:" + System.currentTimeMillis());
        }

        @Override // c.p.a.a.m.b
        public void onConnectState(int i2) {
            c.p.a.d.d.i("VTOpenDoorAdapter", "onConnectState connectState:" + i2);
            if (i2 != 2) {
                a(i2);
            } else {
                b();
            }
        }

        @Override // c.p.a.a.m.b
        public void onConnectSuccessStartWriterData() {
            c.p.a.d.d.d("VTOpenDoorAdapter", "onConnectSuccessStartWriterData");
            l.this.n = true;
            l.this.V(false);
        }

        @Override // c.p.a.a.m.b
        public void onNotifySuccessStartReadData(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (l.this.f3014f != null) {
                l.this.f3014f.m(l.this.f3011c, bluetoothGattCharacteristic);
            }
        }

        @Override // c.p.a.a.m.b
        public void onNotifySuccessStartReadDataComplete() {
            if (l.this.f3014f != null) {
                l.this.f3014f.h();
                l.this.n = false;
                l.this.f3010b = null;
                l.this.z("onNotifySuccessStartReadDataComplete");
            }
        }

        @Override // c.p.a.a.m.b
        public void onWriterSuccessSetupNotify() {
            l.this.R();
        }
    }

    public class b implements n.a {
        public b() {
        }

        @Override // c.p.a.a.n.a
        public void disconnectBluetooth() {
            l.this.M("disconnectBluetooth");
        }

        @Override // c.p.a.a.n.a
        public void resetBluetoothConnect() {
            l.this.Q();
        }

        @Override // c.p.a.a.n.a
        public void retryOpenDoor() {
            c.p.a.d.d.d("VTOpenDoorAdapter", "retryOpenDoor");
            l.this.V(true);
        }

        @Override // c.p.a.a.n.a
        public void useCookieUnlock() {
            l lVar = l.this;
            lVar.writerData(lVar.f3013e.getBluetoothCookie(), false);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(1000L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c.p.a.d.d.d("VTOpenDoorAdapter", "onlyDisconnectBle delayCloseBluetoothGatt");
            if (l.this.f3011c == null || l.this.o) {
                return;
            }
            l.this.f3011c.close();
            l.this.f3011c = null;
            c.p.a.d.d.d("VTOpenDoorAdapter", "onlyDisconnectBle delayCloseBluetoothGatt close");
        }
    }

    public l(j jVar) {
        c.p.a.c.b bVar = new c.p.a.c.b() { // from class: c.p.a.a.a
            @Override // c.p.a.c.b
            public final void handleMessage(Message message) {
                this.f2983a.H(message);
            }
        };
        this.k = bVar;
        this.l = c.p.a.c.c.obtain(bVar);
        this.m = false;
        this.o = false;
        this.p = new o.d() { // from class: c.p.a.a.b
            @Override // c.p.a.a.o.d
            public final void onScanResult(BluetoothDevice bluetoothDevice) {
                this.f2984a.x(bluetoothDevice);
            }
        };
        this.f3018q = new a();
        this.r = new b();
        this.s = new Runnable() { // from class: c.p.a.a.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f2985a.J();
            }
        };
        this.n = false;
        this.f3009a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(Message message) {
        if (message.what == 8) {
            this.f3009a.onConnectError("连接超时");
            M("WHAT_TIME_OUT_MSG");
            this.f3015g.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J() {
        c.p.a.d.d.d("VTOpenDoorAdapter", "close run");
        w(-1);
    }

    public final void A(Context context) {
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        if (bluetoothManager != null) {
            D(bluetoothManager, context);
        } else {
            U("无法获取蓝牙适配器");
        }
        c.p.a.d.d.d(l.class.getSimpleName(), "initBleAdapter mBluetoothMac:" + this.f3010b);
    }

    public final void B() {
        this.m = false;
        O();
    }

    public final void C() {
        n nVar = new n(this.f3009a, this.r);
        this.f3014f = nVar;
        c.p.a.b.a aVar = this.f3013e;
        if (aVar != null) {
            nVar.setWriteData(aVar.getBluetoothPassword());
        }
    }

    public final void D(BluetoothManager bluetoothManager, Context context) {
        B();
        S();
        this.f3012d = bluetoothManager.getAdapter();
        if (u() && c.p.a.d.b.isConnectModel()) {
            N();
            c.p.a.d.d.d(l.class.getSimpleName(), "initScanHandler connect model");
        } else {
            o oVar = new o(this.f3012d, this.f3009a, context);
            this.f3015g = oVar;
            oVar.v(this.p);
            this.f3015g.u(this.f3010b);
        }
    }

    public final void E() {
        p pVar = new p(this.f3011c, this.f3009a);
        this.f3016h = pVar;
        pVar.j(this.r);
    }

    public final void K(String str) {
        if (this.f3009a != null) {
            P();
            this.f3009a.onScanError(str);
        }
    }

    public final void L() {
        j jVar = this.f3009a;
        if (jVar != null) {
            jVar.onScanStart();
        }
    }

    public final void M(String str) {
        if (this.f3011c != null) {
            this.j = !"WHAT_TIME_OUT_MSG".equals(str);
            P();
            if (!"connectBluetoothDevice".equals(str)) {
                this.f3011c.disconnect();
                y();
                c.p.a.d.d.d("VTOpenDoorAdapter", "onlyDisconnectBle ble enable method = " + str + "， disconnect bluetoothGatt ");
            }
            c.p.a.d.d.d("VTOpenDoorAdapter", "onlyDisconnectBle ble enable method = " + str);
        }
    }

    public final void N() {
        BluetoothDevice remoteDevice = this.f3012d.getRemoteDevice(this.f3010b);
        if (remoteDevice != null) {
            L();
            x(remoteDevice);
            c.p.a.d.d.d(l.class.getSimpleName(), "onScanResult getRemoteDevice");
        }
    }

    public final void O() {
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void P() {
        Handler handler = this.l;
        if (handler != null) {
            handler.removeMessages(8);
        }
    }

    public final void Q() {
        this.n = false;
        P();
        z("resetBleConnect");
        Handler handler = this.l;
        if (handler != null) {
            handler.postDelayed(this.s, 300L);
        }
    }

    public final void R() {
        p pVar = this.f3016h;
        if (pVar != null) {
            pVar.k(this.f3011c);
        }
    }

    public final void S() {
        Handler handler = this.l;
        if (handler != null) {
            handler.removeMessages(8);
            this.l.sendEmptyMessageDelayed(8, 20000L);
        }
    }

    public final void T() {
        c.p.a.d.d.d(l.class.getSimpleName(), "stopBleScanner");
        o oVar = this.f3015g;
        if (oVar != null) {
            oVar.w();
        }
    }

    public final void U(String str) {
        if (this.f3009a != null) {
            P();
            this.f3009a.onUnlockFailed(str);
        }
    }

    public final void V(boolean z) {
        writerData(this.f3013e.getBluetoothPassword(), z);
    }

    public void onlyScanBle() {
        if (this.f3015g == null) {
            c.p.a.d.d.d("VTOpenDoorAdapter", "onlyScanBle mVTOpenDoorScanHandle is empty");
        } else {
            c.p.a.d.d.d("VTOpenDoorAdapter", "onlyScanBle mVTOpenDoorScanHandle onlyScanBle");
            this.f3015g.onlyScanBle();
        }
    }

    public void openDoor(c.p.a.b.a aVar, Activity activity) {
        this.f3017i = activity;
        if (aVar != null) {
            String bluetoothMac = aVar.getBluetoothMac();
            if (TextUtils.isEmpty(bluetoothMac)) {
                return;
            }
            if (this.f3010b == null) {
                this.f3010b = bluetoothMac;
            }
            if (t(aVar)) {
                A(activity);
            }
            c.p.a.d.d.d(l.class.getSimpleName(), "isWaitWriterData:" + this.n);
        }
    }

    public void openDoorContext(c.p.a.b.a aVar, Context context) {
        this.f3017i = context;
        if (t(aVar)) {
            A(context);
        }
    }

    public void release() {
        this.n = false;
        O();
        Q();
    }

    public void setIBleStateCallback(j jVar) {
        this.f3009a = jVar;
    }

    public final boolean t(c.p.a.b.a aVar) {
        boolean z = false;
        this.j = false;
        if (aVar != null) {
            this.f3013e = aVar;
            String bluetoothMac = c.p.a.c.a.getBluetoothMac(aVar.getBluetoothMac());
            this.f3010b = bluetoothMac;
            z = !TextUtils.isEmpty(bluetoothMac);
        }
        if (!z) {
            K("传入的蓝牙地址为空");
        }
        return z;
    }

    public final boolean u() {
        BluetoothAdapter bluetoothAdapter = this.f3012d;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public final boolean v() {
        try {
            Thread.sleep(500L);
            Method method = this.f3011c.getClass().getMethod(com.alipay.sdk.m.x.d.w, new Class[0]);
            if (method != null) {
                return ((Boolean) method.invoke(this.f3011c, new Object[0])).booleanValue();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            c.p.a.d.d.e("VTOpenDoorAdapter", "ERROR: Could not invoke refresh method");
            return false;
        }
    }

    public final void w(int i2) {
        this.o = true;
        try {
            if (this.f3011c != null && (i2 == 133 || i2 == 62)) {
                try {
                    z(ILivePush.ClickType.CLOSE);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Thread.sleep(500L);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.f3010b = null;
        this.j = false;
        BluetoothGatt bluetoothGatt = this.f3011c;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
            v();
        }
        this.f3011c = null;
        this.o = false;
        c.p.a.d.d.d("VTOpenDoorAdapter", "close isActiveDisconnect = " + this.j);
    }

    public void writerData(String str, boolean z) {
        if (this.f3016h == null || TextUtils.isEmpty(str)) {
            return;
        }
        c.p.a.d.d.d("VTOpenDoorAdapter", "writerData");
        this.f3016h.l(str, z);
    }

    public final void x(BluetoothDevice bluetoothDevice) {
        c.p.a.b.a aVar;
        if (this.f3010b == null && (aVar = this.f3013e) != null) {
            this.f3010b = c.p.a.c.a.getBluetoothMac(aVar.getBluetoothMac());
        }
        M("connectBluetoothDevice");
        new m(this.f3009a, this.f3018q, this.f3017i).u(bluetoothDevice, this.l, this.f3010b);
    }

    public final void y() {
        new Thread(new c()).start();
    }

    public final void z(String str) {
        if (!u()) {
            c.p.a.d.d.d("VTOpenDoorAdapter", "disconnect ble un enable");
            return;
        }
        c.p.a.d.d.d("VTOpenDoorAdapter", "disconnect ble enable method = " + str);
        T();
        this.m = true;
        M(str);
    }
}

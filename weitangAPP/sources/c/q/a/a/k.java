package c.q.a.a;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import c.q.a.a.l;
import c.q.a.a.m;
import c.q.a.a.n;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.vtown.doorlibrary.bo.BleUnlockResponse;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f3079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothGatt f3081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BluetoothAdapter f3082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BleUnlockResponse f3083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m f3084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n f3085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o f3086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f3087i;
    public boolean j = false;
    public final c.q.a.b.b k;
    public final Handler l;
    public boolean m;
    public boolean n;
    public volatile boolean o;
    public final n.d p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final l.b f3088q;
    public final m.a r;
    public final Runnable s;

    public class a implements l.b {
        public a() {
        }

        public final void a(int i2) {
            if (k.this.f3081c == null) {
                c.q.a.c.i.i("VTOpenDoorAdapter", "handleDisconnect mBluetoothGatt is null state:" + i2);
                return;
            }
            if (!k.this.j) {
                k.this.L("连接已断开,status=" + i2);
            }
            c.q.a.c.i.i("VTOpenDoorAdapter", "handleDisconnect mBluetoothGatt state:" + i2 + ", isActiveDisconnect = " + k.this.j);
            k.this.P();
            k.this.x(i2);
        }

        public final void b() {
            c.q.a.c.i.i("VTOpenDoorAdapter", "onConnectionStateChange time:" + System.currentTimeMillis());
            if (k.this.m) {
                k.this.A("handlerConnectSuccess");
                return;
            }
            if (k.this.f3081c == null) {
                try {
                    c.q.a.c.i.e("VTOpenDoorAdapter", "handlerConnectSuccess sleep");
                    for (int i2 = 0; k.this.f3081c == null && i2 < 5; i2++) {
                        Thread.sleep(80L);
                    }
                    if (k.this.f3081c != null) {
                        Thread.sleep(180L);
                        c.q.a.c.i.e("VTOpenDoorAdapter", "handlerConnectSuccess sleep over");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (k.this.f3081c != null) {
                k.this.f3081c.discoverServices();
            }
        }

        @Override // c.q.a.a.l.b
        public void onCharacteristicReadData(int i2) {
            if (k.this.f3084f != null) {
                k.this.f3084f.h(k.this.f3081c, i2);
            }
        }

        @Override // c.q.a.a.l.b
        public void onConnectResult(BluetoothGatt bluetoothGatt) {
            k.this.f3081c = bluetoothGatt;
            k.this.D();
            k.this.F();
            c.q.a.c.i.i("VTOpenDoorAdapter", "onConnectResult time:" + System.currentTimeMillis());
        }

        @Override // c.q.a.a.l.b
        public void onConnectState(int i2) {
            c.q.a.c.i.i("VTOpenDoorAdapter", "onConnectState connectState:" + i2);
            if (i2 != 2) {
                a(i2);
            } else {
                b();
            }
        }

        @Override // c.q.a.a.l.b
        public void onConnectSuccessStartWriterData() {
            c.q.a.c.i.d("VTOpenDoorAdapter", "onConnectSuccessStartWriterData");
            k.this.n = true;
            k.this.W(false);
        }

        @Override // c.q.a.a.l.b
        public void onNotifySuccessStartReadData() {
            if (k.this.f3084f != null) {
                k.this.f3084f.l(k.this.f3081c);
            }
        }

        @Override // c.q.a.a.l.b
        public void onNotifySuccessStartReadDataComplete() {
            if (k.this.f3084f != null) {
                k.this.f3084f.i();
                k.this.n = false;
                k.this.f3080b = null;
                k.this.A("onNotifySuccessStartReadDataComplete");
            }
        }

        @Override // c.q.a.a.l.b
        public void onWriterSuccessSetupNotify() {
            k.this.S();
        }
    }

    public class b implements m.a {
        public b() {
        }

        @Override // c.q.a.a.m.a
        public void disconnectBluetooth() {
            k.this.N("disconnectBluetooth");
        }

        @Override // c.q.a.a.m.a
        public void resetBluetoothConnect() {
            k.this.R();
        }

        @Override // c.q.a.a.m.a
        public void retryOpenDoor() {
            c.q.a.c.i.d("VTOpenDoorAdapter", "retryOpenDoor");
            k.this.W(true);
        }

        @Override // c.q.a.a.m.a
        public void useCookieUnlock() {
            k kVar = k.this;
            kVar.X(kVar.f3083e.getBluetoothCookie(), false);
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
            c.q.a.c.i.d("VTOpenDoorAdapter", "onlyDisconnectBle delayCloseBluetoothGatt");
            if (k.this.f3081c == null || k.this.o) {
                return;
            }
            k.this.f3081c.close();
            k.this.f3081c = null;
            c.q.a.c.i.d("VTOpenDoorAdapter", "onlyDisconnectBle delayCloseBluetoothGatt close");
        }
    }

    public k(i iVar) {
        c.q.a.b.b bVar = new c.q.a.b.b() { // from class: c.q.a.a.b
            @Override // c.q.a.b.b
            public final void handleMessage(Message message) {
                this.f3060a.I(message);
            }
        };
        this.k = bVar;
        this.l = c.q.a.b.c.obtain(bVar);
        this.m = false;
        this.o = false;
        this.p = new n.d() { // from class: c.q.a.a.c
            @Override // c.q.a.a.n.d
            public final void onScanResult(BluetoothDevice bluetoothDevice) {
                this.f3061a.y(bluetoothDevice);
            }
        };
        this.f3088q = new a();
        this.r = new b();
        this.s = new Runnable() { // from class: c.q.a.a.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f3059a.K();
            }
        };
        this.n = false;
        this.f3079a = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(Message message) {
        if (message.what == 8) {
            this.f3079a.onConnectError("连接超时");
            N("WHAT_TIME_OUT_MSG");
            this.f3085g.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K() {
        c.q.a.c.i.d("VTOpenDoorAdapter", "close run");
        x(-1);
    }

    public final void A(String str) {
        if (!v()) {
            c.q.a.c.i.d("VTOpenDoorAdapter", "disconnect ble un enable");
            return;
        }
        c.q.a.c.i.d("VTOpenDoorAdapter", "disconnect ble enable method = " + str);
        U();
        this.m = true;
        N(str);
    }

    public final void B(Context context) {
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        if (bluetoothManager != null) {
            E(bluetoothManager, context);
        } else {
            V("无法获取蓝牙适配器");
        }
        c.q.a.c.i.d(k.class.getSimpleName(), "initBleAdapter mBluetoothMac:" + this.f3080b);
    }

    public final void C() {
        this.m = false;
        P();
    }

    public final void D() {
        m mVar = new m(this.f3079a, this.r);
        this.f3084f = mVar;
        BleUnlockResponse bleUnlockResponse = this.f3083e;
        if (bleUnlockResponse != null) {
            mVar.setWriteData(bleUnlockResponse.getBluetoothPassword());
        }
    }

    public final void E(BluetoothManager bluetoothManager, Context context) {
        C();
        T();
        this.f3082d = bluetoothManager.getAdapter();
        if (v() && c.q.a.c.g.isConnectModel()) {
            O();
            c.q.a.c.i.d(k.class.getSimpleName(), "initScanHandler connect model");
        } else {
            n nVar = new n(this.f3082d, this.f3079a, context);
            this.f3085g = nVar;
            nVar.v(this.p);
            this.f3085g.u(this.f3080b);
        }
    }

    public final void F() {
        o oVar = new o(this.f3081c, this.f3079a);
        this.f3086h = oVar;
        oVar.j(this.r);
    }

    public final void L(String str) {
        if (this.f3079a != null) {
            Q();
            this.f3079a.onScanError(str);
        }
    }

    public final void M() {
        i iVar = this.f3079a;
        if (iVar != null) {
            iVar.onScanStart();
        }
    }

    public final void N(String str) {
        if (this.f3081c != null) {
            this.j = !"WHAT_TIME_OUT_MSG".equals(str);
            Q();
            if (!"connectBluetoothDevice".equals(str)) {
                this.f3081c.disconnect();
                z();
                c.q.a.c.i.d("VTOpenDoorAdapter", "onlyDisconnectBle ble enable method = " + str + "， disconnect bluetoothGatt ");
            }
            c.q.a.c.i.d("VTOpenDoorAdapter", "onlyDisconnectBle ble enable method = " + str);
        }
    }

    public final void O() {
        BluetoothDevice remoteDevice = this.f3082d.getRemoteDevice(this.f3080b);
        if (remoteDevice != null) {
            M();
            y(remoteDevice);
            c.q.a.c.i.d(k.class.getSimpleName(), "onScanResult getRemoteDevice");
        }
    }

    public final void P() {
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void Q() {
        Handler handler = this.l;
        if (handler != null) {
            handler.removeMessages(8);
        }
    }

    public final void R() {
        this.n = false;
        Q();
        A("resetBleConnect");
        Handler handler = this.l;
        if (handler != null) {
            handler.postDelayed(this.s, 300L);
        }
    }

    public final void S() {
        o oVar = this.f3086h;
        if (oVar != null) {
            oVar.k(this.f3081c);
        }
    }

    public final void T() {
        Handler handler = this.l;
        if (handler != null) {
            handler.removeMessages(8);
            this.l.sendEmptyMessageDelayed(8, 20000L);
        }
    }

    public final void U() {
        c.q.a.c.i.d(k.class.getSimpleName(), "stopBleScanner");
        n nVar = this.f3085g;
        if (nVar != null) {
            nVar.w();
        }
    }

    public final void V(String str) {
        if (this.f3079a != null) {
            Q();
            this.f3079a.onUnlockFailed(str);
        }
    }

    public final void W(boolean z) {
        X(this.f3083e.getBluetoothPassword(), z);
    }

    public final void X(String str, boolean z) {
        if (this.f3086h == null || TextUtils.isEmpty(str)) {
            return;
        }
        c.q.a.c.i.d("VTOpenDoorAdapter", "writerData");
        this.f3086h.l(str, z);
    }

    public void onlyScanBle() {
        if (this.f3085g == null) {
            c.q.a.c.i.d("VTOpenDoorAdapter", "onlyScanBle mVTOpenDoorScanHandle is empty");
        } else {
            c.q.a.c.i.d("VTOpenDoorAdapter", "onlyScanBle mVTOpenDoorScanHandle onlyScanBle");
            this.f3085g.onlyScanBle();
        }
    }

    public void openDoor(BleUnlockResponse bleUnlockResponse, Activity activity) {
        this.f3087i = activity;
        if (bleUnlockResponse != null) {
            String bluetoothMac = bleUnlockResponse.getBluetoothMac();
            if (TextUtils.isEmpty(bluetoothMac)) {
                return;
            }
            if (this.f3080b == null) {
                this.f3080b = bluetoothMac;
            }
            if (u(bleUnlockResponse)) {
                B(activity);
            }
            c.q.a.c.i.d(k.class.getSimpleName(), "isWaitWriterData:" + this.n);
        }
    }

    public void openDoorContext(BleUnlockResponse bleUnlockResponse, Context context) {
        this.f3087i = context;
        if (u(bleUnlockResponse)) {
            B(context);
        }
    }

    public void release() {
        this.n = false;
        P();
        R();
    }

    public void setIBleStateCallback(i iVar) {
        this.f3079a = iVar;
    }

    public final boolean u(BleUnlockResponse bleUnlockResponse) {
        boolean z = false;
        this.j = false;
        if (bleUnlockResponse != null) {
            this.f3083e = bleUnlockResponse;
            String bluetoothMac = c.q.a.b.a.getBluetoothMac(bleUnlockResponse.getBluetoothMac());
            this.f3080b = bluetoothMac;
            z = !TextUtils.isEmpty(bluetoothMac);
        }
        if (!z) {
            L("传入的蓝牙地址为空");
        }
        return z;
    }

    public final boolean v() {
        BluetoothAdapter bluetoothAdapter = this.f3082d;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public final boolean w() {
        try {
            Thread.sleep(500L);
            Method method = this.f3081c.getClass().getMethod(com.alipay.sdk.m.x.d.w, new Class[0]);
            if (method != null) {
                return ((Boolean) method.invoke(this.f3081c, new Object[0])).booleanValue();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            c.q.a.c.i.e("VTOpenDoorAdapter", "ERROR: Could not invoke refresh method");
            return false;
        }
    }

    public final void x(int i2) {
        this.o = true;
        try {
            if (this.f3081c != null && i2 == 133) {
                try {
                    A(ILivePush.ClickType.CLOSE);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Thread.sleep(500L);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.f3080b = null;
        this.j = false;
        BluetoothGatt bluetoothGatt = this.f3081c;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
            w();
        }
        this.f3081c = null;
        this.o = false;
        c.q.a.c.i.d("VTOpenDoorAdapter", "close isActiveDisconnect = " + this.j);
    }

    public final void y(BluetoothDevice bluetoothDevice) {
        BleUnlockResponse bleUnlockResponse;
        if (this.f3080b == null && (bleUnlockResponse = this.f3083e) != null) {
            this.f3080b = c.q.a.b.a.getBluetoothMac(bleUnlockResponse.getBluetoothMac());
        }
        N("connectBluetoothDevice");
        new l(this.f3079a, this.f3088q, this.f3087i).v(bluetoothDevice, this.l, this.f3080b);
    }

    public final void z() {
        new Thread(new c()).start();
    }
}

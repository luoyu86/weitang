package c.e.e.a.r.j;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import c.e.e.a.r.j.l;
import c.e.e.a.r.j.m;
import c.e.e.a.r.j.n;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.chinavisionary.twlib.R;

/* JADX INFO: loaded from: classes2.dex */
public class k extends c.e.e.a.r.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile k f2425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BluetoothGatt f2427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BluetoothAdapter f2428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c.e.e.a.x.d f2429g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f2430h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public n f2431i;
    public o j;
    public l k;
    public Handler l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final n.d f2432q;
    public final l.b r;
    public m.a s;
    public Runnable t;

    public class a implements l.b {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d() {
            if (k.this.f2427e != null) {
                k.this.f2427e.discoverServices();
            }
            c.e.e.a.x.i.i("TWOpenDoorAdapter", "handlerConnectSuccess discoverServices :" + Thread.currentThread().getName());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f() {
            try {
                Thread.sleep(100L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c.e.e.a.x.i.i("TWOpenDoorAdapter", "handlerConnectSuccess mBluetoothGatt");
            k.this.l.post(new Runnable() { // from class: c.e.e.a.r.j.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2413a.d();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void h() {
            try {
                k.this.Q("onConnectState");
                Thread.sleep(300L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            k.s(k.this);
            k.this.k.retryConnectGatt();
            c.e.e.a.x.i.d("TWOpenDoorAdapter", "onConnectState retry performBleScanToBluetoothMac mRetryConnectIndex = " + k.this.p);
        }

        public final void a() {
            if (k.this.f2427e != null) {
                k.this.S();
                k.this.B();
            }
        }

        public final void b() {
            c.e.e.a.x.i.i("TWOpenDoorAdapter", "onConnectionStateChange time:" + System.currentTimeMillis());
            if (k.this.m) {
                k.this.D();
            } else {
                new Thread(new Runnable() { // from class: c.e.e.a.r.j.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2411a.f();
                    }
                }).start();
            }
        }

        @Override // c.e.e.a.r.j.l.b
        public void onCharacteristicReadData(int i2) {
            if (k.this.f2430h != null) {
                k.this.f2430h.l(k.this.f2427e, i2);
            }
        }

        @Override // c.e.e.a.r.j.l.b
        public void onConnectResult(BluetoothGatt bluetoothGatt) {
            k.this.f2427e = bluetoothGatt;
            k.this.H();
            k.this.J();
        }

        @Override // c.e.e.a.r.j.l.b
        public void onConnectState(int i2) {
            c.e.e.a.x.i.i("TWOpenDoorAdapter", "onConnectState connectState:" + i2);
            if (i2 != 0) {
                if (i2 != 2) {
                    return;
                }
                b();
            } else {
                if (!k.this.o && k.this.p <= 4) {
                    new Thread(new Runnable() { // from class: c.e.e.a.r.j.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2412a.h();
                        }
                    }).start();
                    return;
                }
                c.e.e.a.x.i.d("TWOpenDoorAdapter", "onConnectState handleDisconnect");
                a();
                if (k.this.o) {
                    return;
                }
                k.this.N(c.e.e.a.x.k.getString(R.string.ble_title_connect_failed_close_ble));
            }
        }

        @Override // c.e.e.a.r.j.l.b
        public void onConnectSuccessStartWriterData() {
            k.this.o = true;
            k.this.n = true;
            k.this.Y();
        }

        @Override // c.e.e.a.r.j.l.b
        public void onNotifySuccessStartReadData() {
            if (k.this.f2430h != null) {
                k.this.f2430h.p(k.this.f2427e);
            }
        }

        @Override // c.e.e.a.r.j.l.b
        public void onWriterSuccessSetupNotify() {
            k.this.V();
        }
    }

    public class b implements m.a {
        public b() {
        }

        @Override // c.e.e.a.r.j.m.a
        public void resetBluetoothConnect() {
            k.this.T();
        }

        @Override // c.e.e.a.r.j.m.a
        public void useCookieUnlock() {
            k kVar = k.this;
            kVar.Z(kVar.f2429g.getBluetoothCookie());
        }
    }

    public k() {
        super(null);
        this.l = c.e.e.a.u.e.obtain();
        this.m = false;
        this.o = false;
        this.p = 0;
        this.f2432q = new n.d() { // from class: c.e.e.a.r.j.e
            @Override // c.e.e.a.r.j.n.d
            public final void onScanResult(BluetoothDevice bluetoothDevice) {
                this.f2415a.C(bluetoothDevice);
            }
        };
        this.r = new a();
        this.s = new b();
        this.t = new Runnable() { // from class: c.e.e.a.r.j.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f2414a.M();
            }
        };
        this.n = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M() {
        c.e.e.a.x.i.d("TWOpenDoorAdapter", "close run");
        B();
    }

    public static synchronized k getInstance() {
        if (f2425c == null) {
            synchronized (k.class) {
                if (f2425c == null) {
                    f2425c = new k();
                }
            }
        }
        return f2425c;
    }

    public static /* synthetic */ int s(k kVar) {
        int i2 = kVar.p;
        kVar.p = i2 + 1;
        return i2;
    }

    public final boolean A() {
        return z() && this.f2427e != null;
    }

    public final void B() {
        if (A() && this.m) {
            if (this.f2384b) {
                this.f2384b = false;
            }
            Q(ILivePush.ClickType.CLOSE);
            c.e.e.a.x.i.d("TWOpenDoorAdapter", ILivePush.ClickType.CLOSE);
        }
    }

    public final void C(BluetoothDevice bluetoothDevice) {
        l lVar = new l(this.f2383a, this.r);
        this.k = lVar;
        lVar.p(bluetoothDevice, this.l);
    }

    public final void D() {
        if (!z()) {
            c.e.e.a.x.i.d("TWOpenDoorAdapter", "disconnect ble un enable");
            return;
        }
        c.e.e.a.x.i.d("TWOpenDoorAdapter", "disconnect ble enable");
        W();
        this.m = true;
        Q("disconnect");
    }

    public final void E() {
        U();
        if (!this.n) {
            P();
            c.e.e.a.x.i.d(k.class.getSimpleName(), "scann ing");
        } else {
            this.f2384b = false;
            this.n = false;
            Y();
        }
    }

    public final void F(Context context) {
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        if (bluetoothManager != null) {
            I(bluetoothManager, context);
        } else {
            X(c.e.e.a.x.k.getString(R.string.tw_lib_title_get_bluetooth_adapter_failed));
        }
        c.e.e.a.x.i.d(k.class.getSimpleName(), "initBleAdapter mBluetoothMac:" + this.f2426d);
    }

    public final void G() {
        this.m = false;
        if (this.f2384b) {
            return;
        }
        S();
    }

    public final void H() {
        this.f2430h = new m(this.f2383a, this.s);
    }

    public final void I(BluetoothManager bluetoothManager, Context context) {
        G();
        this.f2428f = bluetoothManager.getAdapter();
        if (z() && c.e.e.a.x.f.isConnectModel()) {
            R();
            c.e.e.a.x.i.d(k.class.getSimpleName(), "initScanHandler connect model");
        } else {
            n nVar = new n(this.f2428f, this.f2383a);
            this.f2431i = nVar;
            nVar.A(this.f2432q);
            this.f2431i.x(this.f2426d, this.f2384b);
        }
    }

    public final void J() {
        this.j = new o(this.f2427e, this.f2383a);
    }

    public final void N(String str) {
        c.e.e.a.r.d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onConnectError(str);
        }
    }

    public final void O(String str) {
        c.e.e.a.r.d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onScanError(str);
        }
    }

    public final void P() {
        c.e.e.a.r.d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onScanStart();
        }
    }

    public final void Q(String str) {
        BluetoothGatt bluetoothGatt = this.f2427e;
        if (bluetoothGatt != null) {
            if (bluetoothGatt != null) {
                try {
                    bluetoothGatt.disconnect();
                    Thread.sleep(80L);
                    this.f2427e.close();
                } catch (Exception e2) {
                    try {
                        e2.printStackTrace();
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
            }
            this.f2427e = null;
            c.e.e.a.x.i.d("TWOpenDoorAdapter", "onlyCloseGatt method = " + str + ",disconnect Thread name = " + Thread.currentThread().getName());
        }
    }

    public final void R() {
        BluetoothDevice remoteDevice = this.f2428f.getRemoteDevice(this.f2426d);
        if (remoteDevice != null) {
            P();
            C(remoteDevice);
            c.e.e.a.x.i.d(k.class.getSimpleName(), "onScanResult getRemoteDevice");
        }
    }

    public final void S() {
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void T() {
        this.f2384b = false;
        this.n = false;
        D();
        Handler handler = this.l;
        if (handler != null) {
            handler.postDelayed(this.t, 300L);
        }
    }

    public final void U() {
        o oVar = this.j;
        if (oVar != null) {
            oVar.h(this.f2383a);
        }
        m mVar = this.f2430h;
        if (mVar != null) {
            mVar.r(this.f2383a, this.s);
        }
    }

    public final void V() {
        o oVar = this.j;
        if (oVar != null) {
            oVar.j(this.f2427e);
        }
    }

    public final void W() {
        c.e.e.a.x.i.d(k.class.getSimpleName(), "stopBleScanner");
        n nVar = this.f2431i;
        if (nVar != null) {
            nVar.B();
        }
    }

    public final void X(String str) {
        c.e.e.a.r.d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onUnlockFailed(str);
        }
    }

    public final void Y() {
        if (this.f2384b) {
            return;
        }
        Z(this.f2429g.getBluetoothPassword());
    }

    public final void Z(String str) {
        if (this.j == null || !c.e.e.a.x.k.isNotNull(str)) {
            return;
        }
        this.j.k(str);
    }

    @Override // c.e.e.a.r.a
    public void openDoor(c.e.e.a.x.d dVar, Activity activity, c.e.e.a.s.f fVar) {
        boolean zIsEqualsMac = c.e.e.a.u.b.isEqualsMac(dVar.getBluetoothMac(), this.f2426d);
        if (y(dVar)) {
            if (zIsEqualsMac) {
                E();
            } else {
                F(activity);
            }
        }
        c.e.e.a.x.i.d(k.class.getSimpleName(), "isEqualsMac:" + zIsEqualsMac + ",isScanOnly:" + this.f2384b + ",isWaitWriterData:" + this.n);
    }

    public void openDoorContext(c.e.e.a.x.d dVar, Context context, c.e.e.a.s.f fVar) {
        boolean zIsEqualsMac = c.e.e.a.u.b.isEqualsMac(dVar.getBluetoothMac(), this.f2426d);
        if (y(dVar)) {
            if (zIsEqualsMac) {
                E();
            } else {
                F(context);
            }
        }
        c.e.e.a.x.i.d(k.class.getSimpleName(), "isEqualsMac:" + zIsEqualsMac + ",isScanOnly:" + this.f2384b + ",isWaitWriterData:" + this.n);
    }

    @Override // c.e.e.a.r.a
    public void release() {
        this.f2384b = false;
        this.n = false;
        S();
        T();
        f2425c = null;
    }

    public k setScanOnly(boolean z) {
        this.f2384b = z;
        if (!z) {
            S();
        }
        return this;
    }

    public k startScanTimeOut(long j) {
        S();
        this.l.postDelayed(new Runnable() { // from class: c.e.e.a.r.j.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f2422a.release();
            }
        }, j);
        return this;
    }

    public final boolean y(c.e.e.a.x.d dVar) {
        boolean zIsNotNull;
        if (dVar != null) {
            this.f2429g = dVar;
            String bluetoothMac = c.e.e.a.u.b.getBluetoothMac(dVar.getBluetoothMac());
            this.f2426d = bluetoothMac;
            zIsNotNull = c.e.e.a.x.k.isNotNull(bluetoothMac);
        } else {
            zIsNotNull = false;
        }
        if (!zIsNotNull) {
            O(c.e.e.a.x.k.getString(R.string.tw_lib_title_ble_mac_address_is_empty));
        }
        return zIsNotNull;
    }

    public final boolean z() {
        BluetoothAdapter bluetoothAdapter = this.f2428f;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }
}

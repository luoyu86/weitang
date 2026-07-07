package c.e.e.a.r.j;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.chinavisionary.twlib.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class n extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f2449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BluetoothAdapter f2451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BluetoothLeScanner f2452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f2453i;
    public final BroadcastReceiver j;

    @TargetApi(21)
    public final ScanCallback k;

    @TargetApi(19)
    public final BluetoothAdapter.LeScanCallback l;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"android.bluetooth.device.action.FOUND".equals(intent.getAction())) {
                return;
            }
            c.e.e.a.x.i.d(n.class.getCanonicalName(), "ble receiver connect");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice != null) {
                String address = bluetoothDevice.getAddress();
                c.e.e.a.x.i.d(n.class.getCanonicalName(), "ble receiver connect address:" + address + "，device name:" + bluetoothDevice.getName());
                if (address.equals(n.this.f2450f)) {
                    n.this.q(bluetoothDevice);
                    n.this.C();
                }
            }
        }
    }

    public class b extends ScanCallback {
        public b() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
            c.e.e.a.x.i.d(n.class.getCanonicalName(), "onBatchScanResults");
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i2) {
            super.onScanFailed(i2);
            c.e.e.a.x.i.d(n.class.getCanonicalName(), "onScanFailed errorCode:" + i2);
            n.this.v(c.e.e.a.x.k.getString(R.string.tw_lib_title_scan_failed) + i2);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i2, ScanResult scanResult) {
            super.onScanResult(i2, scanResult);
            BluetoothDevice device = scanResult.getDevice();
            c.e.e.a.x.i.d(n.class.getCanonicalName(), "onScanResult callbackType:" + device.getAddress() + ",name :" + device.getName());
            n.this.q(device);
        }
    }

    public class c implements BluetoothAdapter.LeScanCallback {
        public c() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
            n.this.q(bluetoothDevice);
        }
    }

    public interface d {
        void onScanResult(BluetoothDevice bluetoothDevice);
    }

    public n(BluetoothAdapter bluetoothAdapter, c.e.e.a.r.d dVar) {
        super(null, dVar);
        this.f2447c = false;
        this.f2448d = false;
        this.f2449e = false;
        this.j = new a();
        this.k = new b();
        this.l = new c();
        this.f2451g = bluetoothAdapter;
    }

    public void A(d dVar) {
        this.f2453i = dVar;
    }

    public synchronized void B() {
        c.e.e.a.x.i.d(getClass().getSimpleName(), "stopBleScanner stop scanner");
        C();
        BluetoothAdapter bluetoothAdapter = this.f2451g;
        if (bluetoothAdapter != null && !this.f2447c) {
            boolean zIsEnabled = bluetoothAdapter.isEnabled();
            BluetoothLeScanner bluetoothLeScanner = this.f2452h;
            if (bluetoothLeScanner == null || !zIsEnabled) {
                String simpleName = getClass().getSimpleName();
                StringBuilder sb = new StringBuilder();
                sb.append("stopBleScanner stop scanner over isEnable = ");
                sb.append(zIsEnabled);
                sb.append(",mBluetoothLeScanner is null = ");
                sb.append(this.f2452h != null);
                c.e.e.a.x.i.d(simpleName, sb.toString());
            } else {
                this.f2447c = true;
                bluetoothLeScanner.stopScan(this.k);
                c.e.e.a.x.i.d(getClass().getSimpleName(), "stopBleScanner stop scanner over");
            }
            if (this.f2449e && ((c.e.e.a.x.f.isXiaoMimi() || a()) && zIsEnabled)) {
                this.f2447c = true;
                this.f2449e = false;
                this.f2451g.stopLeScan(this.l);
                c.e.e.a.x.i.d(getClass().getSimpleName(), "stopBleScanner stopLeScan  isEnable =" + zIsEnabled);
            }
        }
    }

    public final void C() {
        c.e.e.a.x.i.d(k.class.getCanonicalName(), "unregisterBleReceiver ble receiver connect is receiver = " + this.f2448d);
        if (this.f2448d) {
            this.f2448d = false;
            this.f2451g.cancelDiscovery();
            c.e.e.a.x.g.getInstance().getContext().getApplicationContext().unregisterReceiver(this.j);
        }
    }

    public final List<ScanFilter> n(String str) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            arrayList.add(new ScanFilter.Builder().setDeviceAddress(str).build());
        }
        return arrayList;
    }

    public final ScanSettings o() {
        return new ScanSettings.Builder().setScanMode(0).build();
    }

    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void t(String str) {
        this.f2447c = false;
        if (f()) {
            this.f2452h.startScan(n(str), o(), this.k);
        } else if (c.e.e.a.x.f.isReceiveModel()) {
            y(c.e.e.a.x.g.getInstance().getContext());
        } else if (e()) {
            this.f2452h.startScan((List<ScanFilter>) null, o(), this.k);
        } else {
            this.f2452h.startScan(this.k);
        }
        c.e.e.a.x.i.d(n.class.getSimpleName(), "handleScanModel start scan thread name background bluetoothMac:" + str);
    }

    public final void q(BluetoothDevice bluetoothDevice) {
        String str = this.f2450f;
        if (str == null || !str.equalsIgnoreCase(bluetoothDevice.getAddress())) {
            return;
        }
        this.f2447c = false;
        B();
        u();
        d dVar = this.f2453i;
        if (dVar != null) {
            dVar.onScanResult(bluetoothDevice);
        }
    }

    public final void r(String str) {
        this.f2447c = false;
        this.f2450f = str;
        B();
        w();
    }

    public final void u() {
        c.e.e.a.r.d dVar = this.f2424b;
        if (dVar != null) {
            dVar.onScanEnd();
        }
    }

    public final void v(String str) {
        c.e.e.a.r.d dVar = this.f2424b;
        if (dVar != null) {
            dVar.onScanError(str);
        }
    }

    public final void w() {
        c.e.e.a.r.d dVar = this.f2424b;
        if (dVar != null) {
            dVar.onScanStart();
        }
    }

    public void x(final String str, boolean z) {
        c.e.e.a.x.i.d(n.class.getSimpleName(), "performBleScanToBluetoothMac");
        r(str);
        this.f2449e = false;
        if (!a()) {
            this.f2449e = true;
            this.f2451g.startLeScan(this.l);
            return;
        }
        BluetoothDevice remoteDevice = null;
        if (c.e.e.a.x.f.isRedmiK40() && !z) {
            remoteDevice = this.f2451g.getRemoteDevice(str);
        }
        if (remoteDevice != null) {
            q(remoteDevice);
            return;
        }
        if (c.e.e.a.x.f.isXiaoMimi()) {
            this.f2449e = true;
            c.e.e.a.x.i.d(n.class.getSimpleName(), "performBleScanToBluetoothMac isXiaoMimi");
            this.f2451g.startLeScan(this.l);
        } else {
            BluetoothLeScanner bluetoothLeScanner = this.f2451g.getBluetoothLeScanner();
            this.f2452h = bluetoothLeScanner;
            if (bluetoothLeScanner != null) {
                new Thread(new Runnable() { // from class: c.e.e.a.r.j.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2420a.t(str);
                    }
                }).start();
            } else {
                i(c.e.e.a.x.k.getString(R.string.tw_lib_bluetooth_not_auth));
            }
        }
    }

    public final void y(Context context) {
        w();
        this.f2451g.startDiscovery();
        z(context);
    }

    public final void z(Context context) {
        this.f2448d = true;
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        context.getApplicationContext().registerReceiver(this.j, intentFilter);
    }
}

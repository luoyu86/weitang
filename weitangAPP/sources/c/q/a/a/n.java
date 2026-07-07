package c.q.a.a;

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
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class n extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3106h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f3107i;
    public BluetoothAdapter j;
    public BluetoothLeScanner k;
    public d l;
    public final BroadcastReceiver m;

    @TargetApi(21)
    public final ScanCallback n;

    @TargetApi(19)
    public final BluetoothAdapter.LeScanCallback o;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"android.bluetooth.device.action.FOUND".equals(intent.getAction())) {
                return;
            }
            c.q.a.c.i.d(n.class.getCanonicalName(), "ble receiver connect");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice != null) {
                String address = bluetoothDevice.getAddress();
                c.q.a.c.i.d(n.class.getCanonicalName(), "ble receiver connect address:" + address + "，device name:" + bluetoothDevice.getName());
                if (address.equals(n.this.f3106h)) {
                    n.this.n(bluetoothDevice);
                    n.this.x();
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
            c.q.a.c.i.d(n.class.getCanonicalName(), "onBatchScanResults");
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i2) {
            super.onScanFailed(i2);
            c.q.a.c.i.d(n.class.getCanonicalName(), "onScanFailed errorCode:" + i2);
            n.this.s("扫描失败,错误码:" + i2);
            n.this.w();
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i2, ScanResult scanResult) {
            super.onScanResult(i2, scanResult);
            BluetoothDevice device = scanResult.getDevice();
            c.q.a.c.i.d(n.class.getCanonicalName(), "onScanResult callbackType:" + device.getAddress() + ",name :" + device.getName());
            n.this.n(device);
        }
    }

    public class c implements BluetoothAdapter.LeScanCallback {
        public c() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
            n.this.n(bluetoothDevice);
        }
    }

    public interface d {
        void onScanResult(BluetoothDevice bluetoothDevice);
    }

    public n(BluetoothAdapter bluetoothAdapter, i iVar, Context context) {
        super(null, iVar);
        this.f3103e = false;
        this.f3104f = false;
        this.f3105g = false;
        this.m = new a();
        this.n = new b();
        this.o = new c();
        this.j = bluetoothAdapter;
        this.f3107i = context;
    }

    public final List<ScanFilter> k(String str) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            arrayList.add(new ScanFilter.Builder().setDeviceAddress(str).build());
        }
        return arrayList;
    }

    public final ScanSettings l() {
        return new ScanSettings.Builder().setScanMode(2).build();
    }

    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public final void q(String str) {
        this.f3103e = false;
        this.k.startScan(k(str), l(), this.n);
        c.q.a.c.i.d(n.class.getSimpleName(), "handleScanModel start scan thread name background bluetoothMac:" + str);
    }

    public final synchronized void n(BluetoothDevice bluetoothDevice) {
        i iVar = this.f3073b;
        if (iVar != null) {
            iVar.onScanResult(bluetoothDevice);
        }
        String str = this.f3106h;
        if (str != null && str.equalsIgnoreCase(bluetoothDevice.getAddress())) {
            this.f3103e = false;
            ArrayList arrayList = new ArrayList();
            arrayList.add(bluetoothDevice);
            w();
            r();
            if (this.l != null) {
                c.q.a.c.i.d(getClass().getSimpleName(), "handleScanResult mBluetoothMac = " + this.f3106h + ", device = " + bluetoothDevice.getAddress() + ", deviceType = " + bluetoothDevice.getType() + ", getBondState = " + bluetoothDevice.getBondState());
                this.l.onScanResult((BluetoothDevice) arrayList.get(0));
            }
        } else if (this.f3103e) {
            c.q.a.c.i.d(getClass().getSimpleName(), "handleScanResult isStopScan = true mBluetoothMac = " + this.f3106h + ", device = " + bluetoothDevice.getAddress());
        }
    }

    public final void o(String str) {
        this.f3103e = false;
        this.f3106h = str;
        w();
        t();
    }

    public void onlyScanBle() {
        BluetoothLeScanner bluetoothLeScanner = this.j.getBluetoothLeScanner();
        this.k = bluetoothLeScanner;
        bluetoothLeScanner.startScan((List<ScanFilter>) null, l(), this.n);
    }

    public final void r() {
        i iVar = this.f3073b;
        if (iVar != null) {
            iVar.onScanEnd();
        }
    }

    public final void s(String str) {
        i iVar = this.f3073b;
        if (iVar != null) {
            iVar.onScanError(str);
        }
    }

    public final void t() {
        i iVar = this.f3073b;
        if (iVar != null) {
            iVar.onScanStart();
        }
    }

    public void u(final String str) {
        this.f3105g = false;
        c.q.a.c.i.d(n.class.getSimpleName(), "performBleScanToBluetoothMac bluetoothMac = " + str);
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            f("Mac地址错误");
            return;
        }
        o(str);
        if (!a()) {
            this.f3103e = false;
            this.f3105g = true;
            this.j.startLeScan(this.o);
            return;
        }
        BluetoothDevice remoteDevice = this.j.getRemoteDevice(this.f3106h);
        if (remoteDevice != null && !TextUtils.isEmpty(remoteDevice.getName()) && !c.q.a.b.a.isScan()) {
            c.q.a.c.i.d(n.class.getSimpleName(), "performBleScanToBluetoothMac getRemoteDevice name = " + remoteDevice.getName());
            n(remoteDevice);
            return;
        }
        this.f3103e = false;
        if (c.q.a.c.g.isXiaoMimi()) {
            this.f3105g = true;
            c.q.a.c.i.d(n.class.getSimpleName(), "performBleScanToBluetoothMac isXiaoMimi startLeScan");
            this.j.startLeScan(this.o);
        } else {
            BluetoothLeScanner bluetoothLeScanner = this.j.getBluetoothLeScanner();
            this.k = bluetoothLeScanner;
            if (bluetoothLeScanner != null) {
                new Thread(new Runnable() { // from class: c.q.a.a.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f3067a.q(str);
                    }
                }).start();
            } else {
                f("无法获取蓝牙扫描器,蓝牙没有授权");
            }
        }
    }

    public void v(d dVar) {
        this.l = dVar;
    }

    public synchronized void w() {
        c.q.a.c.i.d(getClass().getSimpleName(), "stopBleScanner stop scanner isStopScan = " + this.f3103e);
        x();
        BluetoothAdapter bluetoothAdapter = this.j;
        if (bluetoothAdapter != null && !this.f3103e) {
            boolean zIsEnabled = bluetoothAdapter.isEnabled();
            BluetoothLeScanner bluetoothLeScanner = this.k;
            if (bluetoothLeScanner == null || !zIsEnabled) {
                String simpleName = getClass().getSimpleName();
                StringBuilder sb = new StringBuilder();
                sb.append("stopBleScanner stop scanner over isEnable = ");
                sb.append(zIsEnabled);
                sb.append(",mBluetoothLeScanner is null = ");
                sb.append(this.k != null);
                c.q.a.c.i.d(simpleName, sb.toString());
            } else {
                this.f3103e = true;
                bluetoothLeScanner.stopScan(this.n);
                c.q.a.c.i.d(getClass().getSimpleName(), "stopBleScanner stop scanner over");
            }
            if (this.f3105g && ((c.q.a.c.g.isXiaoMimi() || a()) && zIsEnabled)) {
                this.f3103e = true;
                this.j.stopLeScan(this.o);
                c.q.a.c.i.d(getClass().getSimpleName(), "stopBleScanner stopLeScan  isEnable =" + zIsEnabled);
            }
        }
    }

    public final void x() {
        c.q.a.c.i.d(k.class.getCanonicalName(), "unregisterBleReceiver ble receiver connect is receiver = " + this.f3104f);
        if (this.f3104f) {
            this.f3104f = false;
            this.j.cancelDiscovery();
            Context context = this.f3107i;
            if (context != null) {
                context.getApplicationContext().unregisterReceiver(this.m);
            }
        }
    }
}

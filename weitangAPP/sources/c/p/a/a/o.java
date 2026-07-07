package c.p.a.a;

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
public class o extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f3037i;
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
            c.p.a.d.d.d("VTOpenDoorScanHandle", "ble receiver connect");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice != null) {
                String address = bluetoothDevice.getAddress();
                c.p.a.d.d.d("VTOpenDoorScanHandle", "ble receiver connect address:" + address + "，device name:" + bluetoothDevice.getName());
                if (address.equals(o.this.f3036h)) {
                    o.this.n(bluetoothDevice);
                    o.this.x();
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
            c.p.a.d.d.d("VTOpenDoorScanHandle", "onBatchScanResults");
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i2) {
            super.onScanFailed(i2);
            c.p.a.d.d.d("VTOpenDoorScanHandle", "onScanFailed errorCode:" + i2);
            o.this.s("扫描失败,错误码:" + i2);
            o.this.w();
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i2, ScanResult scanResult) {
            super.onScanResult(i2, scanResult);
            BluetoothDevice device = scanResult.getDevice();
            c.p.a.d.d.d("VTOpenDoorScanHandle", "onScanResult callbackType:" + device.getAddress() + ",name :" + device.getName());
            o.this.n(device);
        }
    }

    public class c implements BluetoothAdapter.LeScanCallback {
        public c() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
            o.this.n(bluetoothDevice);
        }
    }

    public interface d {
        void onScanResult(BluetoothDevice bluetoothDevice);
    }

    public o(BluetoothAdapter bluetoothAdapter, j jVar, Context context) {
        super(null, jVar);
        this.f3033e = false;
        this.f3034f = false;
        this.f3035g = false;
        this.m = new a();
        this.n = new b();
        this.o = new c();
        this.j = bluetoothAdapter;
        this.f3037i = context;
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
        this.f3033e = false;
        this.k.startScan(k(str), l(), this.n);
        c.p.a.d.d.d("VTOpenDoorScanHandle", "handleScanModel start scan thread name background bluetoothMac:" + str);
    }

    public final synchronized void n(BluetoothDevice bluetoothDevice) {
        j jVar = this.f2999b;
        if (jVar != null) {
            jVar.onScanResult(bluetoothDevice);
        }
        String str = this.f3036h;
        if (str != null && str.equalsIgnoreCase(bluetoothDevice.getAddress())) {
            this.f3033e = false;
            ArrayList arrayList = new ArrayList();
            arrayList.add(bluetoothDevice);
            w();
            r();
            if (this.l != null) {
                c.p.a.d.d.d("VTOpenDoorScanHandle", "handleScanResult mBluetoothMac = " + this.f3036h + ", device = " + bluetoothDevice.getAddress() + ", deviceType = " + bluetoothDevice.getType() + ", getBondState = " + bluetoothDevice.getBondState());
                this.l.onScanResult((BluetoothDevice) arrayList.get(0));
            }
        } else if (this.f3033e) {
            c.p.a.d.d.d("VTOpenDoorScanHandle", "handleScanResult isStopScan = true mBluetoothMac = " + this.f3036h + ", device = " + bluetoothDevice.getAddress());
        }
    }

    public final void o(String str) {
        this.f3033e = false;
        this.f3036h = str;
        w();
        t();
    }

    public void onlyScanBle() {
        BluetoothLeScanner bluetoothLeScanner = this.j.getBluetoothLeScanner();
        this.k = bluetoothLeScanner;
        bluetoothLeScanner.startScan((List<ScanFilter>) null, l(), this.n);
    }

    public final void r() {
        j jVar = this.f2999b;
        if (jVar != null) {
            jVar.onScanEnd();
        }
    }

    public final void s(String str) {
        j jVar = this.f2999b;
        if (jVar != null) {
            jVar.onScanError(str);
        }
    }

    public final void t() {
        j jVar = this.f2999b;
        if (jVar != null) {
            jVar.onScanStart();
        }
    }

    public void u(final String str) {
        this.f3035g = false;
        c.p.a.d.d.d("VTOpenDoorScanHandle", "performBleScanToBluetoothMac bluetoothMac = " + str);
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            f("Mac地址错误");
            return;
        }
        o(str);
        if (!a()) {
            this.f3033e = false;
            this.f3035g = true;
            this.j.startLeScan(this.o);
            return;
        }
        BluetoothDevice remoteDevice = this.j.getRemoteDevice(this.f3036h);
        if (remoteDevice != null && !TextUtils.isEmpty(remoteDevice.getName()) && !c.p.a.c.a.isScan()) {
            c.p.a.d.d.d("VTOpenDoorScanHandle", "performBleScanToBluetoothMac getRemoteDevice name = " + remoteDevice.getName());
            n(remoteDevice);
            return;
        }
        this.f3033e = false;
        if (c.p.a.d.b.isXiaoMimi()) {
            this.f3035g = true;
            c.p.a.d.d.d("VTOpenDoorScanHandle", "performBleScanToBluetoothMac isXiaoMimi startLeScan");
            this.j.startLeScan(this.o);
        } else {
            BluetoothLeScanner bluetoothLeScanner = this.j.getBluetoothLeScanner();
            this.k = bluetoothLeScanner;
            if (bluetoothLeScanner != null) {
                new Thread(new Runnable() { // from class: c.p.a.a.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2993a.q(str);
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
        c.p.a.d.d.d("VTOpenDoorScanHandle", "stopBleScanner stop scanner isStopScan = " + this.f3033e);
        x();
        BluetoothAdapter bluetoothAdapter = this.j;
        if (bluetoothAdapter != null && !this.f3033e) {
            boolean zIsEnabled = bluetoothAdapter.isEnabled();
            BluetoothLeScanner bluetoothLeScanner = this.k;
            if (bluetoothLeScanner == null || !zIsEnabled) {
                StringBuilder sb = new StringBuilder();
                sb.append("stopBleScanner stop scanner over isEnable = ");
                sb.append(zIsEnabled);
                sb.append(",mBluetoothLeScanner is null = ");
                sb.append(this.k != null);
                c.p.a.d.d.d("VTOpenDoorScanHandle", sb.toString());
            } else {
                this.f3033e = true;
                bluetoothLeScanner.stopScan(this.n);
                c.p.a.d.d.d("VTOpenDoorScanHandle", "stopBleScanner stop scanner over");
            }
            if (this.f3035g && ((c.p.a.d.b.isXiaoMimi() || a()) && zIsEnabled)) {
                this.f3033e = true;
                this.j.stopLeScan(this.o);
                c.p.a.d.d.d("VTOpenDoorScanHandle", "stopBleScanner stopLeScan  isEnable =" + zIsEnabled);
            }
        }
    }

    public final void x() {
        c.p.a.d.d.d(l.class.getCanonicalName(), "unregisterBleReceiver ble receiver connect is receiver = " + this.f3034f);
        if (this.f3034f) {
            this.f3034f = false;
            this.j.cancelDiscovery();
            Context context = this.f3037i;
            if (context != null) {
                context.getApplicationContext().unregisterReceiver(this.m);
            }
        }
    }
}

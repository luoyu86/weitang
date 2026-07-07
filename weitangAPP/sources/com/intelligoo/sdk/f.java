package com.intelligoo.sdk;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.intelligoo.sdk.BluetoothLeService;
import com.intelligoo.sdk.LibInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f9230b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f9231c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f9232d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static LibInterface.ManagerCallback f9233e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static LibInterface.ReadCardCallback f9234f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static LibInterface.ReadOpenRecordCallback f9235g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static LibInterface.SyncFingerprintCallback f9236h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static LibInterface.ReadFingerprintCallback f9237i = null;
    private static boolean j = false;
    private static BluetoothLeService k;
    private static LocalBroadcastManager l;
    private static Timer m;
    private static TimerTask n;
    private static int o;
    private static int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static BluetoothGattCharacteristic f9238q;
    private static BluetoothGattCharacteristic r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f9229a = new Handler(Looper.getMainLooper());
    private static BroadcastReceiver s = new BroadcastReceiver() { // from class: com.intelligoo.sdk.f.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equalsIgnoreCase("com.intelligoo.doormaster.ACTION_GATT_CONNECTED") || action.equalsIgnoreCase("com.intelligoo.doormaster.ACTION_GATT_DISCONNECTED")) {
                return;
            }
            if (action.equalsIgnoreCase("com.intelligoo.doormaster.ACTION_SERVICE_DISCOVERED")) {
                f.b(f.k.b());
                return;
            }
            if (action.equalsIgnoreCase("com.intelligoo.doormaster.ACTION_DATA_CALLBACK")) {
                byte[] byteArrayExtra = intent.getByteArrayExtra("com.intelligoo.doormaster.EXTRA_DATA");
                l.a(byteArrayExtra != null);
                n.a(byteArrayExtra);
            } else if (action.equalsIgnoreCase("com.intelligoo.doormaster.ACTION_WRITE_SUCCESS_CALL_BACK")) {
                l.a("receive write success call back");
                f.r();
            } else if (action.equalsIgnoreCase("com.intelligoo.doormaster.ACTION_DATA_RSSI")) {
                f.a(intent);
            } else if (action.equalsIgnoreCase("com.intelligoo.doormaster.ACTION_WRITE_DESCRIPTOR_SUCCESS_CALLBACK")) {
                f.q();
            }
        }
    };
    private static ServiceConnection t = new ServiceConnection() { // from class: com.intelligoo.sdk.f.4
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BluetoothLeService unused = f.k = ((BluetoothLeService.LocalBinder) iBinder).getService(f.f9230b);
            if (!f.k.initialize()) {
                l.a("Unable to initialize Bluetooth");
                BluetoothLeService unused2 = f.k = null;
            }
            if (f.k == null || f.f9230b == null) {
                return;
            }
            i.a();
            LibDevModel libDevModel = i.a().f9265a;
            if (libDevModel == null) {
                f.a(-3, (Bundle) null);
                return;
            }
            String str = libDevModel.devMac;
            if (str == null) {
                f.a(-3, (Bundle) null);
                return;
            }
            l.a("mContext" + f.f9230b + "mac" + str);
            if (f.f9232d != 15 && f.f9232d != 16 && f.f9232d != 18 && f.k.a(str.toUpperCase(Locale.CHINA), f.f9230b)) {
                f.a();
            } else if (f.k.a(str.toUpperCase(Locale.CHINA), f.f9230b)) {
                f.b();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            l.a("bind BleService failed");
        }
    };

    public static int a(Context context, int i2, LibInterface.ManagerCallback managerCallback) {
        if (j) {
            return ConstantsUtils.SET_RESULT_ERROR_OPERATING;
        }
        if (!a(context)) {
            return -100;
        }
        f9230b = context;
        f9231c = context.getApplicationContext();
        f9233e = managerCallback;
        f9232d = i2;
        o();
        p();
        j = true;
        return 0;
    }

    public static int a(Context context, int i2, LibInterface.ReadCardCallback readCardCallback) {
        if (j) {
            return ConstantsUtils.SET_RESULT_ERROR_OPERATING;
        }
        f9234f = readCardCallback;
        b.b();
        return a(context, i2, (LibInterface.ManagerCallback) null);
    }

    public static int a(Context context, int i2, LibInterface.ReadOpenRecordCallback readOpenRecordCallback) {
        if (j) {
            return ConstantsUtils.SET_RESULT_ERROR_OPERATING;
        }
        f9235g = readOpenRecordCallback;
        j.b();
        return a(context, i2, (LibInterface.ManagerCallback) null);
    }

    public static int a(Context context, int i2, ArrayList<DMFingerprintModel> arrayList, LibInterface.SyncFingerprintCallback syncFingerprintCallback) {
        if (j) {
            return ConstantsUtils.SET_RESULT_ERROR_OPERATING;
        }
        f9236h = syncFingerprintCallback;
        g.c();
        g.a(true);
        g.a(arrayList);
        return a(context, i2, (LibInterface.ManagerCallback) null);
    }

    public static void a() {
        m = new Timer(false);
        TimerTask timerTask = new TimerTask() { // from class: com.intelligoo.sdk.f.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Bundle bundle;
                if (f.f9232d != 11 || (bundle = k.f9271c) == null) {
                    f.a(48, (Bundle) null);
                } else {
                    f.a(0, bundle);
                    k.f9271c = null;
                }
            }
        };
        n = timerTask;
        m.schedule(timerTask, 10000L);
    }

    public static void a(final int i2, final int i3) {
        f9229a.post(new Runnable() { // from class: com.intelligoo.sdk.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.f9234f != null) {
                    f.f9234f.onProgress(i2, i3);
                }
            }
        });
    }

    public static void a(final int i2, final int i3, final ArrayList<String> arrayList) {
        d();
        f9229a.post(new Runnable() { // from class: com.intelligoo.sdk.f.9
            @Override // java.lang.Runnable
            public void run() {
                if (f.f9234f != null) {
                    f.f9234f.onResult(i2, i3, arrayList);
                }
            }
        });
    }

    public static void a(final int i2, final Bundle bundle) {
        d();
        f9229a.post(new Runnable() { // from class: com.intelligoo.sdk.f.7
            @Override // java.lang.Runnable
            public void run() {
                if (f.f9232d == 24 && f.f9234f != null) {
                    f.f9234f.onResult(i2, b.c(), b.a());
                    return;
                }
                if (f.f9232d == 25 && f.f9235g != null) {
                    f.f9235g.onResult(i2, j.c(), j.a());
                    return;
                }
                if (f.f9232d == 26 && f.f9236h != null) {
                    f.f9236h.onResult(i2, g.b());
                } else if (f.f9233e != null) {
                    f.f9233e.setResult(i2, bundle);
                }
            }
        });
    }

    public static void a(Intent intent) {
        if (o < 16) {
            p += intent.getIntExtra("com.intelligoo.doormaster.EXTRA_DATA", -100);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            k.a();
            o++;
            return;
        }
        Bundle bundle = new Bundle();
        int i2 = (0 - (p / 16)) + 3;
        bundle.putInt(ConstantsUtils.SET_SHAKE_RSSI, i2);
        l.a("shakeRssi:" + i2);
        a(0, bundle);
        p = 0;
        o = 0;
    }

    public static void a(byte[] bArr) {
        if (bArr == null || r == null) {
            a(51, (Bundle) null);
        }
        r.setValue(bArr);
        k.a(r);
    }

    public static boolean a(Context context) {
        BluetoothAdapter adapter;
        if (!context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") || (adapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter()) == null) {
            return false;
        }
        if (adapter.isEnabled()) {
            return true;
        }
        boolean zEnable = adapter.enable();
        if (zEnable) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
        }
        return zEnable;
    }

    public static void b() {
        m = new Timer(false);
        TimerTask timerTask = new TimerTask() { // from class: com.intelligoo.sdk.f.6
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                f.a(48, (Bundle) null);
            }
        };
        n = timerTask;
        m.schedule(timerTask, 12000L);
    }

    public static void b(final int i2, final int i3) {
        f9229a.post(new Runnable() { // from class: com.intelligoo.sdk.f.10
            @Override // java.lang.Runnable
            public void run() {
                if (f.f9235g != null) {
                    f.f9235g.onProgress(i2, i3);
                }
            }
        });
    }

    public static void b(final int i2, final int i3, final ArrayList<Map> arrayList) {
        d();
        f9229a.post(new Runnable() { // from class: com.intelligoo.sdk.f.11
            @Override // java.lang.Runnable
            public void run() {
                if (f.f9235g != null) {
                    f.f9235g.onResult(i2, i3, arrayList);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(List<BluetoothGattService> list) {
        l.a(list != null);
        if (list != null) {
            for (BluetoothGattService bluetoothGattService : list) {
                l.a("service: " + bluetoothGattService.getUuid().toString());
                if (bluetoothGattService.getUuid().toString().equalsIgnoreCase("0886b765-9f76-6472-96ef-ab19c539878a")) {
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                        l.a("charater: " + bluetoothGattCharacteristic.getUuid().toString());
                        if (bluetoothGattCharacteristic.getUuid().toString().equals("0000878b-0000-1000-8000-00805f9b34fb")) {
                            f9238q = bluetoothGattCharacteristic;
                        }
                        if (bluetoothGattCharacteristic.getUuid().toString().equals("0000878c-0000-1000-8000-00805f9b34fb")) {
                            r = bluetoothGattCharacteristic;
                        }
                    }
                }
            }
        }
        if (r == null || f9238q == null) {
            a(49, (Bundle) null);
            return;
        }
        l.a("write-c: " + r.getUuid().toString() + " read-c :" + f9238q.getUuid().toString());
        if (f9232d == 17) {
            k.a();
        } else {
            k.a(f9238q, true);
        }
    }

    public static void c() {
        m.cancel();
        a();
    }

    public static void c(final int i2, final int i3) {
        f9229a.post(new Runnable() { // from class: com.intelligoo.sdk.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.f9236h != null) {
                    f.f9236h.onProgress(i2, i3);
                }
            }
        });
    }

    public static void d() {
        Log.e("bensontest", "disconnectDevice");
        l.unregisterReceiver(s);
        Timer timer = m;
        if (timer != null) {
            timer.cancel();
            m = null;
        }
        try {
            if (k != null) {
                Log.e("bensontest", "mLeService.disconnect()");
                k.c();
            }
            Thread.sleep(100L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        BluetoothLeService bluetoothLeService = k;
        if (bluetoothLeService != null) {
            bluetoothLeService.close();
        }
        try {
            f9231c.unbindService(t);
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        }
        j = false;
    }

    public static void d(final int i2, final int i3) {
        d();
        f9229a.post(new Runnable() { // from class: com.intelligoo.sdk.f.3
            @Override // java.lang.Runnable
            public void run() {
                if (f.f9236h != null) {
                    f.f9236h.onResult(i2, i3);
                }
            }
        });
    }

    private static IntentFilter n() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.intelligoo.doormaster.ACTION_GATT_DISCONNECTED");
        intentFilter.addAction("com.intelligoo.doormaster.ACTION_GATT_CONNECTED");
        intentFilter.addAction("com.intelligoo.doormaster.ACTION_SERVICE_DISCOVERED");
        intentFilter.addAction("com.intelligoo.doormaster.ACTION_DATA_CALLBACK");
        intentFilter.addAction("com.intelligoo.doormaster.ACTION_WRITE_SUCCESS_CALL_BACK");
        intentFilter.addAction("com.intelligoo.doormaster.ACTION_DATA_RSSI");
        intentFilter.addAction("com.intelligoo.doormaster.ACTION_WRITE_DESCRIPTOR_SUCCESS_CALLBACK");
        return intentFilter;
    }

    private static void o() {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(f9230b);
        l = localBroadcastManager;
        localBroadcastManager.registerReceiver(s, n());
    }

    private static void p() {
        l.a("connectDevice" + f9230b);
        f9231c.bindService(new Intent(f9230b, (Class<?>) BluetoothLeService.class), t, 1);
        l.a("connectDevice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
        a(n.a(f9232d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r() {
        byte[] bArrA = n.a();
        if (bArrA == null || r == null) {
            return;
        }
        a(bArrA);
    }
}

package c.m.a;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresPermission;
import c.m.a.e.b;
import com.mars.marsbluelock.ble.BluetoothLeService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2852h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BluetoothAdapter f2853i;
    public BroadcastReceiver j;
    public boolean k;
    public Handler l;
    public Handler m;
    public Runnable n;
    public BluetoothLeService o;
    public BluetoothDevice p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public BluetoothGattCharacteristic f2854q;
    public String r;
    public Activity s;
    public f t;
    public String u;
    public c.m.a.e.b v;
    public String z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2845a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2846b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2847c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2848d = 21;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2849e = 22;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2850f = 31;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2851g = 32;
    public boolean w = false;
    public boolean x = false;
    public long y = 0;
    public List<c.m.a.e.a> A = new ArrayList();
    public boolean B = true;
    public final BroadcastReceiver C = new b();
    public String[] D = null;

    @RequiresPermission("android.permission.BLUETOOTH_CONNECT")
    public final BluetoothAdapter.LeScanCallback E = new c();
    public final ServiceConnection F = new ServiceConnectionC0044d();

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                d.this.G(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0));
            }
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d("yang", "mGattUpdateReceiver:action:" + action);
            byte[] byteArrayExtra = intent.getByteArrayExtra("com.example.bluetooth.le.EXTRA_DATA");
            int intExtra = intent.getIntExtra("status", -1);
            if ("com.example.bluetooth.le.ACTION_GATT_CONNECTED".equals(action)) {
                d.this.f2852h = true;
                if (d.this.l != null && d.this.n != null) {
                    d.this.l.removeCallbacks(d.this.n);
                    d.this.l = null;
                }
                Log.d("yang", "STATE_GATT_CONNECTED");
                d.this.G(31);
                return;
            }
            if ("com.example.bluetooth.le.ACTION_GATT_DISCONNECTED".equals(action) && d.this.f2852h) {
                if (d.this.l != null && d.this.n != null) {
                    d.this.l.removeCallbacks(d.this.n);
                    d.this.l = null;
                }
                d.this.f2852h = false;
                d.this.G(32);
                return;
            }
            if ("com.example.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED".equals(action)) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                d dVar = d.this;
                if (jCurrentTimeMillis - dVar.y > 1000) {
                    dVar.y = System.currentTimeMillis();
                    d dVar2 = d.this;
                    dVar2.w(dVar2.o.getSupportedGattServices());
                    return;
                }
                return;
            }
            if (!"com.example.bluetooth.le.ACTION_DATA_AVAILABLE".equals(action)) {
                if (!"com.example.bluetooth.le.ACTION_DATA_WRITE".equals(action) || intExtra == 0) {
                    return;
                }
                Log.e("yang", "写入失败");
                return;
            }
            if ("settime".equals(d.this.z)) {
                c.m.a.e.a aVar = new c.m.a.e.a();
                aVar.setCommandId(d.this.v.getSetTime().getCommandId());
                ArrayList arrayList = new ArrayList();
                arrayList.add(d.parseByte2HexStr(byteArrayExtra));
                aVar.setEncryptResult(arrayList);
                aVar.setCommandBizType(1);
                d.this.u(aVar);
                return;
            }
            if (!"unexecuteds".equals(d.this.z)) {
                if ("openDoor".equals(d.this.z)) {
                    c.m.a.e.a aVar2 = new c.m.a.e.a();
                    aVar2.setCommandId(d.this.v.getOpenDoor().getCommandId());
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(d.parseByte2HexStr(byteArrayExtra));
                    aVar2.setEncryptResult(arrayList2);
                    aVar2.setCommandBizType(3);
                    d.this.u(aVar2);
                    return;
                }
                return;
            }
            if (d.this.v.getUnexecuteds() == null || d.this.v.getUnexecuteds().size() == 0) {
                return;
            }
            c.m.a.e.a aVar3 = new c.m.a.e.a();
            aVar3.setCommandId(d.this.v.getUnexecuteds().get(0).getCommandId());
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(d.parseByte2HexStr(byteArrayExtra));
            aVar3.setEncryptResult(arrayList3);
            aVar3.setCommandBizType(2);
            d.this.u(aVar3);
        }
    }

    public class c implements BluetoothAdapter.LeScanCallback {
        public c() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("deviceName:");
            sb.append(bluetoothDevice != null ? bluetoothDevice.getName() : "");
            Log.d("yang", sb.toString());
            if (bluetoothDevice == null || !TextUtils.equals(bluetoothDevice.getAddress(), d.this.u)) {
                return;
            }
            d.this.p = bluetoothDevice;
            d dVar = d.this;
            dVar.r = dVar.u;
            d.this.F(false);
            d.this.s.bindService(new Intent(d.this.s, (Class<?>) BluetoothLeService.class), d.this.F, 1);
        }
    }

    /* JADX INFO: renamed from: c.m.a.d$d, reason: collision with other inner class name */
    public class ServiceConnectionC0044d implements ServiceConnection {
        public ServiceConnectionC0044d() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("yangxj", "开始连接");
            d.this.o = ((BluetoothLeService.b) iBinder).getService();
            if (!d.this.o.initialize()) {
                Log.e("yangxj", "Unable to initialize Bluetooth");
            }
            d.this.o.connect(d.this.r);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.o = null;
            Log.e("yangxj", "resetBle2");
            d.this.onDestroyBle();
            if (d.this.t != null) {
                d.this.t.openDoorBlueStatus(32, "设备已断开");
            }
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f2859a = new d();
    }

    public interface f {
        void getDoorMsg();

        void openDoorBlueStatus(int i2, String str);

        void openDoorBlueStatus(String str);

        void uploadDoorCommands(List<c.m.a.e.a> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C() {
        this.k = false;
        if (TextUtils.isEmpty(this.r)) {
            G(22);
        }
        this.f2853i.stopLeScan(this.E);
    }

    public static IntentFilter D() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.bluetooth.le.ACTION_GATT_CONNECTED");
        intentFilter.addAction("com.example.bluetooth.le.ACTION_GATT_DISCONNECTED");
        intentFilter.addAction("com.example.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED");
        intentFilter.addAction("com.example.bluetooth.le.ACTION_DATA_AVAILABLE");
        intentFilter.addAction("com.example.bluetooth.le.ACTION_DATA_WRITE");
        return intentFilter;
    }

    public static byte[] getHexBytes(String str) {
        int length = str.length() / 2;
        char[] charArray = str.toCharArray();
        String[] strArr = new String[length];
        byte[] bArr = new byte[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            strArr[i3] = "" + charArray[i2] + charArray[i2 + 1];
            bArr[i3] = (byte) Integer.parseInt(strArr[i3], 16);
            i2 += 2;
        }
        return bArr;
    }

    public static d getInstance() {
        return e.f2859a;
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length > 0) {
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    hexString = '0' + hexString;
                }
                sb.append(hexString.toUpperCase());
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(c.m.a.e.a aVar) {
        int iCeil = (int) Math.ceil(((double) Integer.parseInt(aVar.getEncryptResult().get(0).substring(2, 4), 16)) / 15.0d);
        int i2 = Integer.parseInt(aVar.getEncryptResult().get(0).substring(4, 6), 16);
        boolean z = true;
        if (this.D == null || i2 == 1) {
            this.D = new String[iCeil];
        }
        Log.d("yang", "总片数=" + iCeil + ", 当前片数=" + i2);
        this.D[i2 - 1] = aVar.getEncryptResult().get(0);
        String[] strArr = this.D;
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (strArr[i3] == null) {
                z = false;
                break;
            }
            i3++;
        }
        if (z) {
            if (aVar.getCommandBizType() == 2) {
                this.v.getUnexecuteds().remove(0);
            }
            aVar.setEncryptResult(new ArrayList(Arrays.asList(this.D)));
            H(aVar);
            this.D = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A() {
        if (this.f2852h) {
            return;
        }
        G(22);
        onDestroyBle();
    }

    public final void E() {
        if (this.F != null) {
            try {
                this.o.disconnect();
                this.f2852h = false;
                G(32);
                this.s.unbindService(this.F);
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        this.o = null;
    }

    public final void F(boolean z) {
        if (!z || this.k) {
            if (z) {
                return;
            }
            this.k = false;
            if (TextUtils.isEmpty(this.r)) {
                G(22);
            }
            this.f2853i.stopLeScan(this.E);
            return;
        }
        Runnable runnable = new Runnable() { // from class: c.m.a.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f2841a.C();
            }
        };
        this.n = runnable;
        this.l.postDelayed(runnable, 60000L);
        this.k = true;
        G(21);
        this.f2853i.startLeScan(this.E);
    }

    public final void G(int i2) {
        if (i2 == 21) {
            f fVar = this.t;
            if (fVar != null) {
                fVar.openDoorBlueStatus(21, "设备搜索中");
            }
            return;
        }
        if (i2 == 22) {
            f fVar2 = this.t;
            if (fVar2 != null) {
                fVar2.openDoorBlueStatus(22, "设备未找到");
                return;
            }
            return;
        }
        if (i2 == 31) {
            f fVar3 = this.t;
            if (fVar3 != null) {
                fVar3.openDoorBlueStatus(31, "设备已连接");
                return;
            }
            return;
        }
        if (i2 == 32) {
            f fVar4 = this.t;
            if (fVar4 != null) {
                fVar4.openDoorBlueStatus(32, "设备已断开");
                return;
            }
            return;
        }
        switch (i2) {
            case 10:
                f fVar5 = this.t;
                if (fVar5 != null) {
                    fVar5.openDoorBlueStatus(10, "蓝牙已关闭");
                }
                break;
            case 11:
                f fVar6 = this.t;
                if (fVar6 != null) {
                    fVar6.openDoorBlueStatus(11, "蓝牙开启中");
                }
                break;
            case 12:
                f fVar7 = this.t;
                if (fVar7 != null) {
                    fVar7.openDoorBlueStatus(12, "蓝牙已开启");
                }
                break;
            case 13:
                f fVar8 = this.t;
                if (fVar8 != null) {
                    fVar8.openDoorBlueStatus(13, "蓝牙关闭中");
                }
                break;
            default:
                f fVar9 = this.t;
                if (fVar9 != null) {
                    fVar9.openDoorBlueStatus(i2, "状态未知:code:" + i2);
                }
                break;
        }
    }

    public final void H(c.m.a.e.a aVar) {
        c.m.a.e.b bVar;
        String strReplaceAll;
        this.A.add(aVar);
        int i2 = 0;
        if (!"settime".equals(this.z) && !"unexecuteds".equals(this.z)) {
            if ("openDoor".equals(this.z)) {
                if (this.t != null) {
                    if (aVar != null && aVar.getEncryptResult() != null && aVar.getEncryptResult().size() > 0) {
                        int size = aVar.getEncryptResult().size() - 1;
                        String lowerCase = aVar.getEncryptResult().get(size).toLowerCase();
                        if (lowerCase.contains("aaaa")) {
                            strReplaceAll = lowerCase.substring(lowerCase.length() - 6).replaceAll("aaaa", "");
                            String strSubstring = lowerCase.substring(0, lowerCase.length() - 6);
                            aVar.getEncryptResult().remove(size);
                            aVar.getEncryptResult().add(size, strSubstring);
                        } else {
                            strReplaceAll = "35";
                        }
                        this.t.openDoorBlueStatus(strReplaceAll);
                    }
                    this.A.remove(r0.size() - 1);
                    this.A.add(aVar);
                    this.t.openDoorBlueStatus(0, "发送开锁指令成功");
                    this.t.uploadDoorCommands(this.A);
                }
                try {
                    Log.e("yangxj", "resetBle1");
                    Thread.sleep(5000L);
                    onDestroyBle();
                    return;
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (this.f2854q == null || (bVar = this.v) == null) {
            return;
        }
        if (bVar.getUnexecuteds() != null && this.v.getUnexecuteds() != null && this.v.getUnexecuteds().size() == 0) {
            this.z = "unexecuteds";
        }
        if (this.v.getUnexecuteds() != null && this.v.getUnexecuteds() != null && this.v.getUnexecuteds().size() > 0) {
            b.a aVar2 = this.v.getUnexecuteds().get(0);
            if (aVar2 != null && aVar2.getCommand() != null) {
                while (i2 < aVar2.getCommand().size()) {
                    this.f2854q.setValue(getHexBytes(aVar2.getCommand().get(i2)));
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    while (System.currentTimeMillis() - jCurrentTimeMillis < 200) {
                        boolean zWriteCharacteristic = this.o.writeCharacteristic(this.f2854q);
                        Log.d("yang", "写入_Unexecuteds" + zWriteCharacteristic + aVar2.getCommand().get(i2));
                        if (!zWriteCharacteristic) {
                            try {
                                Thread.sleep(20L);
                            } catch (InterruptedException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    i2++;
                }
                Log.d("yang", "写入_Unexecuteds" + aVar2.getCommand().toString());
            }
            this.z = "unexecuteds";
            return;
        }
        if (!"unexecuteds".equals(this.z) || this.v.getOpenDoor() == null || this.v.getOpenDoor().getCommand() == null || this.v.getOpenDoor().getCommand().size() <= 0) {
            return;
        }
        while (i2 < this.v.getOpenDoor().getCommand().size()) {
            this.f2854q.setValue(getHexBytes(this.v.getOpenDoor().getCommand().get(i2)));
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            while (System.currentTimeMillis() - jCurrentTimeMillis2 < 200) {
                boolean zWriteCharacteristic2 = this.o.writeCharacteristic(this.f2854q);
                Log.d("yang", "写入_OpenDoor" + zWriteCharacteristic2 + this.v.getOpenDoor().getCommand().get(i2));
                if (!zWriteCharacteristic2) {
                    try {
                        Thread.sleep(20L);
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
                    }
                }
            }
            i2++;
        }
        Log.d("yang", "写入_OpenDoor" + this.v.getOpenDoor().getCommand().toString());
        this.z = "openDoor";
    }

    public void onDestroy(Activity activity) {
        Runnable runnable;
        Handler handler = this.l;
        if (handler != null && (runnable = this.n) != null) {
            handler.removeCallbacks(runnable);
            this.l = null;
        }
        Handler handler2 = this.m;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.m = null;
        }
        if (this.w) {
            this.w = false;
            try {
                activity.unregisterReceiver(this.j);
            } catch (IllegalArgumentException unused) {
            }
        }
        if (this.x) {
            this.x = false;
            try {
                activity.unregisterReceiver(this.C);
            } catch (IllegalArgumentException unused2) {
            }
        }
        E();
    }

    public void onDestroyBle() {
        Runnable runnable;
        Handler handler = this.l;
        if (handler != null && (runnable = this.n) != null) {
            handler.removeCallbacks(runnable);
            this.l = null;
        }
        Handler handler2 = this.m;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.m = null;
        }
        if (this.w) {
            this.w = false;
            try {
                this.s.unregisterReceiver(this.j);
            } catch (IllegalArgumentException unused) {
            }
        }
        if (this.x) {
            this.x = false;
            try {
                this.s.unregisterReceiver(this.C);
            } catch (IllegalArgumentException unused2) {
            }
        }
        E();
    }

    public void onlyOpenDoor(c.m.a.e.b bVar) {
        this.v = bVar;
        this.A.clear();
        if (this.f2854q == null || bVar == null) {
            return;
        }
        this.z = "settime";
        H(new c.m.a.e.a());
    }

    public void sendDoorMsg(c.m.a.e.b bVar) {
        this.v = bVar;
        this.A.clear();
        if (this.f2854q == null || bVar == null || bVar.getSetTime() == null || bVar.getSetTime().getCommand() == null) {
            return;
        }
        for (int i2 = 0; i2 < bVar.getSetTime().getCommand().size(); i2++) {
            this.f2854q.setValue(getHexBytes(bVar.getSetTime().getCommand().get(i2)));
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (System.currentTimeMillis() - jCurrentTimeMillis < 200) {
                boolean zWriteCharacteristic = this.o.writeCharacteristic(this.f2854q);
                Log.d("yang", "写入_SetTime" + zWriteCharacteristic + bVar.getSetTime().getCommand().get(i2));
                if (!zWriteCharacteristic) {
                    try {
                        Thread.sleep(20L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        Log.d("yang", "写入_SetTime" + bVar.getSetTime().getCommand().toString());
        this.z = "settime";
    }

    public void startOpenLock(Activity activity, String str, f fVar) {
        if (this.B) {
            this.s = activity;
            this.u = str;
            this.t = fVar;
            String str2 = "";
            if (!str.contains(":")) {
                for (int i2 = 0; i2 < this.u.length(); i2++) {
                    if (i2 % 2 == 0 && i2 != 0 && i2 != this.u.length() - 1) {
                        str2 = str2 + ":";
                    }
                    str2 = str2 + this.u.charAt(i2);
                }
            }
            this.u = str2;
            v(activity);
        }
    }

    public final void u(final c.m.a.e.a aVar) {
        new Thread(new Runnable() { // from class: c.m.a.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f2843a.y(aVar);
            }
        }).start();
    }

    public final void v(Activity activity) {
        Runnable runnable;
        Runnable runnable2;
        Handler handler = this.l;
        if (handler != null && (runnable2 = this.n) != null) {
            handler.removeCallbacks(runnable2);
            this.l = null;
        }
        this.l = new Handler();
        this.m = new Handler();
        BluetoothAdapter adapter = ((BluetoothManager) activity.getSystemService("bluetooth")).getAdapter();
        this.f2853i = adapter;
        if (adapter == null || !adapter.isEnabled()) {
            G(10);
            return;
        }
        Handler handler2 = this.l;
        if (handler2 != null && (runnable = this.n) != null) {
            handler2.removeCallbacks(runnable);
            this.l = null;
        }
        this.l = new Handler();
        this.m = new Handler();
        this.j = new a();
        if (!this.w) {
            this.w = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            activity.registerReceiver(this.j, intentFilter);
        }
        if (!this.x) {
            this.x = true;
            Log.d("yang", "mGattUpdateReceiver");
            activity.registerReceiver(this.C, D());
        }
        G(12);
        Runnable runnable3 = new Runnable() { // from class: c.m.a.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f2842a.A();
            }
        };
        this.n = runnable3;
        this.l.postDelayed(runnable3, 60000L);
        this.r = this.u;
        activity.bindService(new Intent(activity, (Class<?>) BluetoothLeService.class), this.F, 1);
    }

    public final void w(List<BluetoothGattService> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (BluetoothGattService bluetoothGattService : list) {
            if (c.m.a.f.a.f2869a.equalsIgnoreCase(bluetoothGattService.getUuid().toString())) {
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                    if (c.m.a.f.a.f2870b.equalsIgnoreCase(bluetoothGattCharacteristic.getUuid().toString())) {
                        this.o.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                    }
                    if (c.m.a.f.a.f2871c.equalsIgnoreCase(bluetoothGattCharacteristic.getUuid().toString())) {
                        this.f2854q = bluetoothGattCharacteristic;
                        f fVar = this.t;
                        if (fVar != null) {
                            fVar.getDoorMsg();
                        }
                    }
                }
            }
        }
    }
}

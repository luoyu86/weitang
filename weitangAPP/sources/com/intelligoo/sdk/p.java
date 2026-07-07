package com.intelligoo.sdk;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.intelligoo.sdk.exception.ConnectException;
import com.intelligoo.sdk.exception.GattException;
import com.intelligoo.sdk.exception.TimeoutException;
import com.intelligoo.sdk.utils.BleLog;
import com.intelligoo.sdk.utils.HexUtil;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class p {
    private static p m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BluetoothManager f9292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BluetoothAdapter f9293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BluetoothGatt f9294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.intelligoo.sdk.b.b f9295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.intelligoo.sdk.b.a f9296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.intelligoo.sdk.b.a f9297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile Set<com.intelligoo.sdk.b.a> f9298h = new LinkedHashSet();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.intelligoo.sdk.c.b f9299i = com.intelligoo.sdk.c.b.DISCONNECT;
    private int j = com.alipay.sdk.m.m.a.e0;
    private int k = 10000;
    private int l = 5000;
    private Handler n = new Handler(Looper.getMainLooper()) { // from class: com.intelligoo.sdk.p.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 6) {
                com.intelligoo.sdk.b.b bVar = (com.intelligoo.sdk.b.b) message.obj;
                if (bVar != null && p.this.f9299i != com.intelligoo.sdk.c.b.CONNECT_SUCCESS) {
                    p.this.c();
                    bVar.a(new TimeoutException());
                }
            } else {
                com.intelligoo.sdk.b.a aVar = (com.intelligoo.sdk.b.a) message.obj;
                if (aVar != null) {
                    aVar.a(new TimeoutException());
                    p.this.a(aVar);
                }
            }
            message.obj = null;
        }
    };
    private BluetoothGattCallback o = new BluetoothGattCallback() { // from class: com.intelligoo.sdk.p.2
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BleLog.i("onCharacteristicChanged data:" + HexUtil.encodeHexStr(bluetoothGattCharacteristic.getValue()));
            p.this.a(new Runnable() { // from class: com.intelligoo.sdk.p.2.6
                @Override // java.lang.Runnable
                public void run() {
                    if (p.this.f9297g != null) {
                        p.this.f9297g.a(bluetoothGattCharacteristic, 0);
                    }
                }
            });
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final int i2) {
            BleLog.i("onCharacteristicRead  status: " + i2 + ", data:" + HexUtil.encodeHexStr(bluetoothGattCharacteristic.getValue()));
            if (p.this.f9298h == null) {
                return;
            }
            if (p.this.n != null) {
                p.this.n.removeMessages(3);
            }
            p.this.a(new Runnable() { // from class: com.intelligoo.sdk.p.2.4
                @Override // java.lang.Runnable
                public void run() {
                    for (com.intelligoo.sdk.b.a aVar : p.this.f9298h) {
                        int i3 = i2;
                        if (i3 == 0) {
                            aVar.a(bluetoothGattCharacteristic, 0);
                        } else {
                            aVar.a(new GattException(i3));
                        }
                    }
                    p pVar = p.this;
                    pVar.a(pVar.f9296f);
                }
            });
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final int i2) {
            BleLog.i("onCharacteristicWrite  status: " + i2 + ", data:" + HexUtil.encodeHexStr(bluetoothGattCharacteristic.getValue()));
            if (p.this.f9298h == null) {
                return;
            }
            if (p.this.n != null) {
                p.this.n.removeMessages(1);
            }
            p.this.a(new Runnable() { // from class: com.intelligoo.sdk.p.2.5
                @Override // java.lang.Runnable
                public void run() {
                    for (com.intelligoo.sdk.b.a aVar : p.this.f9298h) {
                        int i3 = i2;
                        if (i3 == 0) {
                            aVar.a(bluetoothGattCharacteristic, 0);
                        } else {
                            aVar.a(new GattException(i3));
                        }
                    }
                    p pVar = p.this;
                    pVar.a(pVar.f9296f);
                }
            });
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(final BluetoothGatt bluetoothGatt, final int i2, int i3) {
            BleLog.i("onConnectionStateChange  status: " + i2 + " ,newState: " + i3 + "  ,thread: " + Thread.currentThread().getId());
            if (i3 == 2) {
                bluetoothGatt.discoverServices();
                return;
            }
            if (i3 != 0) {
                if (i3 == 1) {
                    p.this.f9299i = com.intelligoo.sdk.c.b.CONNECT_PROCESS;
                    return;
                }
                return;
            }
            p.this.f9299i = com.intelligoo.sdk.c.b.DISCONNECT;
            if (p.this.n != null) {
                p.this.n.removeMessages(6);
            }
            if (p.this.f9295e != null) {
                p.this.c();
                p.this.a(new Runnable() { // from class: com.intelligoo.sdk.p.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (i2 == 0) {
                            p.this.f9295e.a();
                        } else {
                            p.this.f9295e.a(new ConnectException(bluetoothGatt, i2));
                        }
                    }
                });
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, final BluetoothGattDescriptor bluetoothGattDescriptor, final int i2) {
            BleLog.i("onDescriptorRead  status: " + i2 + ", data:" + HexUtil.encodeHexStr(bluetoothGattDescriptor.getValue()));
            if (p.this.f9298h == null) {
                return;
            }
            if (p.this.n != null) {
                p.this.n.removeMessages(4);
            }
            p.this.a(new Runnable() { // from class: com.intelligoo.sdk.p.2.7
                @Override // java.lang.Runnable
                public void run() {
                    for (com.intelligoo.sdk.b.a aVar : p.this.f9298h) {
                        int i3 = i2;
                        if (i3 == 0) {
                            aVar.a(bluetoothGattDescriptor, 0);
                        } else {
                            aVar.a(new GattException(i3));
                        }
                    }
                    p pVar = p.this;
                    pVar.a(pVar.f9296f);
                }
            });
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, final BluetoothGattDescriptor bluetoothGattDescriptor, final int i2) {
            BleLog.i("onDescriptorWrite  status: " + i2 + ", data:" + HexUtil.encodeHexStr(bluetoothGattDescriptor.getValue()));
            if (p.this.f9298h == null) {
                return;
            }
            if (p.this.n != null) {
                p.this.n.removeMessages(2);
            }
            p.this.a(new Runnable() { // from class: com.intelligoo.sdk.p.2.8
                @Override // java.lang.Runnable
                public void run() {
                    for (com.intelligoo.sdk.b.a aVar : p.this.f9298h) {
                        int i3 = i2;
                        if (i3 == 0) {
                            aVar.a(bluetoothGattDescriptor, 0);
                        } else {
                            aVar.a(new GattException(i3));
                        }
                    }
                    p pVar = p.this;
                    pVar.a(pVar.f9296f);
                }
            });
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, final int i2, final int i3) {
            BleLog.i("onReadRemoteRssi  status: " + i3 + ", rssi:" + i2);
            if (p.this.f9298h == null) {
                return;
            }
            if (p.this.n != null) {
                p.this.n.removeMessages(5);
            }
            p.this.a(new Runnable() { // from class: com.intelligoo.sdk.p.2.9
                @Override // java.lang.Runnable
                public void run() {
                    for (com.intelligoo.sdk.b.a aVar : p.this.f9298h) {
                        int i4 = i3;
                        if (i4 == 0) {
                            aVar.a(Integer.valueOf(i2), 0);
                        } else {
                            aVar.a(new GattException(i4));
                        }
                    }
                    p pVar = p.this;
                    pVar.a(pVar.f9296f);
                }
            });
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(final BluetoothGatt bluetoothGatt, final int i2) {
            p pVar;
            Runnable runnable;
            BleLog.i("onServicesDiscovered  status: " + i2);
            if (p.this.n != null) {
                p.this.n.removeMessages(6);
            }
            p pVar2 = p.this;
            if (i2 == 0) {
                pVar2.f9294d = bluetoothGatt;
                p.this.f9299i = com.intelligoo.sdk.c.b.CONNECT_SUCCESS;
                if (p.this.f9295e == null) {
                    return;
                }
                pVar = p.this;
                runnable = new Runnable() { // from class: com.intelligoo.sdk.p.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        p.this.f9295e.a(bluetoothGatt, i2);
                    }
                };
            } else {
                pVar2.f9299i = com.intelligoo.sdk.c.b.CONNECT_FAILURE;
                if (p.this.f9295e == null) {
                    return;
                }
                p.this.c();
                pVar = p.this;
                runnable = new Runnable() { // from class: com.intelligoo.sdk.p.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        p.this.f9295e.a(new ConnectException(bluetoothGatt, i2));
                    }
                };
            }
            pVar.a(runnable);
        }
    };

    private p() {
    }

    public static p a() {
        if (m == null) {
            synchronized (p.class) {
                if (m == null) {
                    m = new p();
                }
            }
        }
        return m;
    }

    @Deprecated
    public int a(com.intelligoo.sdk.b.a.a aVar) {
        if (aVar != null) {
            return aVar.a(this).a(true).a(this.j).b();
        }
        throw new IllegalArgumentException("this PeriodScanCallback is Null!");
    }

    public p a(int i2) {
        this.j = i2;
        return this;
    }

    public p a(com.intelligoo.sdk.c.b bVar) {
        this.f9299i = bVar;
        return this;
    }

    @Deprecated
    public void a(BluetoothAdapter.LeScanCallback leScanCallback) {
        BluetoothAdapter bluetoothAdapter = this.f9293c;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.startLeScan(leScanCallback);
            this.f9299i = com.intelligoo.sdk.c.b.SCAN_PROCESS;
        }
    }

    public void a(Context context) {
        if (this.f9291a == null) {
            Context applicationContext = context.getApplicationContext();
            this.f9291a = applicationContext;
            BluetoothManager bluetoothManager = (BluetoothManager) applicationContext.getSystemService("bluetooth");
            this.f9292b = bluetoothManager;
            this.f9293c = bluetoothManager.getAdapter();
        }
    }

    public synchronized void a(com.intelligoo.sdk.b.a aVar) {
        if (this.f9298h != null && this.f9298h.size() > 0) {
            this.f9298h.remove(aVar);
        }
    }

    public void a(Runnable runnable) {
        if (b()) {
            runnable.run();
            return;
        }
        Handler handler = this.n;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Deprecated
    public void b(BluetoothAdapter.LeScanCallback leScanCallback) {
        BluetoothAdapter bluetoothAdapter = this.f9293c;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.stopLeScan(leScanCallback);
        }
    }

    @Deprecated
    public void b(com.intelligoo.sdk.b.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("this PeriodScanCallback is Null!");
        }
        aVar.a(this).a(false).c().b();
    }

    public boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public synchronized void c() {
        BluetoothGatt bluetoothGatt = this.f9294d;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
        }
    }

    public com.intelligoo.sdk.c.b d() {
        return this.f9299i;
    }
}

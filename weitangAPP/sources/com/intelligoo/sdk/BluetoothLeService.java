package com.intelligoo.sdk;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothLeService extends Service {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static BluetoothAdapter f9141f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static BluetoothGatt f9142g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static BluetoothDevice f9143h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Handler f9144i = new Handler(Looper.getMainLooper());
    private static LocalBroadcastManager j = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f9140b = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final IBinder f9147d = new LocalBinder();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BluetoothManager f9148e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9145a = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothGattCallback f9146c = new BluetoothGattCallback() { // from class: com.intelligoo.sdk.BluetoothLeService.1
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGatt == null) {
                l.b("gatt is null");
            } else if (bluetoothGattCharacteristic == null) {
                l.b("characteristic is null");
            } else {
                l.a("onCharacteristicChanged");
                BluetoothLeService.this.a("com.intelligoo.doormaster.ACTION_DATA_CALLBACK", bluetoothGattCharacteristic);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            l.a("onCharacteristicRead");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            String str;
            if (bluetoothGatt == null) {
                str = "gatt is null";
            } else {
                if (bluetoothGattCharacteristic != null) {
                    l.a("onCharacteristicWrite:" + i2);
                    if (i2 == 0) {
                        BluetoothLeService.this.a("com.intelligoo.doormaster.ACTION_WRITE_SUCCESS_CALL_BACK", bluetoothGattCharacteristic);
                        return;
                    }
                    return;
                }
                str = "characteristic is null";
            }
            l.b(str);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
            BluetoothLeService bluetoothLeService;
            String str;
            if (bluetoothGatt == null) {
                l.b("gatt is null");
                return;
            }
            l.a("onConnectionStateChange" + i3);
            String str2 = null;
            if (i3 == 2) {
                str2 = "connected";
            } else if (i3 == 1) {
                str2 = "connecting";
            } else if (i3 == 3) {
                str2 = "disconnecting";
            } else if (i3 == 0) {
                str2 = "disconnected";
            }
            Log.e("bensontest", "gatttest onConnectionStateChange: " + i3 + "  " + str2);
            if (i3 == 2) {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                BluetoothLeService.f9142g.discoverServices();
                bluetoothLeService = BluetoothLeService.this;
                str = "com.intelligoo.doormaster.ACTION_GATT_CONNECTED";
            } else {
                if (i3 != 0) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("connectAgain:");
                sb.append(BluetoothLeService.this.f9145a ? "true" : "false");
                l.a(sb.toString());
                BluetoothLeService bluetoothLeService2 = BluetoothLeService.this;
                if (bluetoothLeService2.f9145a) {
                    bluetoothLeService2.f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("connectAgain:");
                    sb2.append(BluetoothLeService.this.f9145a ? "true" : "false");
                    l.a(sb2.toString());
                } else {
                    bluetoothLeService2.close();
                }
                bluetoothLeService = BluetoothLeService.this;
                str = "com.intelligoo.doormaster.ACTION_GATT_DISCONNECTED";
            }
            bluetoothLeService.a(str);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
            String str;
            if (bluetoothGatt == null) {
                str = "gatt is null";
            } else {
                if (bluetoothGattDescriptor != null) {
                    l.a("onDescriptorWrite:" + i2);
                    if (i2 == 0) {
                        BluetoothLeService.this.a("com.intelligoo.doormaster.ACTION_WRITE_DESCRIPTOR_SUCCESS_CALLBACK");
                        return;
                    }
                    return;
                }
                str = "descriptor is null";
            }
            l.b(str);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i2, int i3) {
            l.a("onReadRemoteRssi:" + i2);
            if (i3 == 0) {
                BluetoothLeService.this.a("com.intelligoo.doormaster.ACTION_DATA_RSSI", i2);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
            if (bluetoothGatt == null) {
                l.b("gatt is null");
                return;
            }
            l.a("onServicesDiscovered" + i2);
            if (i2 == 0) {
                BluetoothLeService.this.a("com.intelligoo.doormaster.ACTION_SERVICE_DISCOVERED");
                BluetoothLeService.f9140b = 2;
                return;
            }
            if (i2 == 129 || i2 == 133) {
                l.b("refreshDeviceCacheResult:" + BluetoothLeService.this.b(BluetoothLeService.f9142g));
                BluetoothLeService.this.f9145a = true;
                BluetoothLeService.f9142g.disconnect();
                l.a("onServicesDiscovered" + i2);
            }
        }
    };

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public BluetoothLeService getService(Context context) {
            LocalBroadcastManager unused = BluetoothLeService.j = LocalBroadcastManager.getInstance(context);
            return BluetoothLeService.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        j.sendBroadcast(new Intent(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        Intent intent = new Intent(str);
        intent.putExtra("com.intelligoo.doormaster.EXTRA_DATA", i2);
        j.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Intent intent = new Intent(str);
        intent.putExtra("com.intelligoo.doormaster.EXTRA_DATA", bluetoothGattCharacteristic.getValue());
        j.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(BluetoothGatt bluetoothGatt) {
        try {
            Method method = bluetoothGatt.getClass().getMethod(com.alipay.sdk.m.x.d.w, new Class[0]);
            if (method != null) {
                return ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
            }
        } catch (Exception unused) {
            l.a("refreshDeviceCache An exception occured while refreshing device");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        l.a("conectAgain");
        this.f9145a = false;
        if (f9143h != null) {
            if (f9142g != null) {
                close();
            }
            this.f9145a = true;
            f9144i.post(new Runnable() { // from class: com.intelligoo.sdk.BluetoothLeService.2
                @Override // java.lang.Runnable
                public void run() {
                    BluetoothDevice bluetoothDevice = BluetoothLeService.f9143h;
                    BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                    BluetoothGatt unused = BluetoothLeService.f9142g = bluetoothDevice.connectGatt(bluetoothLeService, false, bluetoothLeService.f9146c);
                }
            });
        }
        StringBuilder sb = new StringBuilder();
        sb.append("connectAgain:");
        sb.append(this.f9145a ? "true" : "false");
        l.a(sb.toString());
    }

    public void a() {
        BluetoothGatt bluetoothGatt = f9142g;
        if (bluetoothGatt == null || f9141f == null) {
            return;
        }
        bluetoothGatt.readRemoteRssi();
    }

    public void a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt;
        if (f9141f == null || (bluetoothGatt = f9142g) == null) {
            return;
        }
        bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    public boolean a(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        if (f9141f == null || f9142g == null) {
            return false;
        }
        l.a("setCharacteristicNotification:" + bluetoothGattCharacteristic.getUuid().toString());
        f9142g.setCharacteristicNotification(bluetoothGattCharacteristic, z);
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
        if (descriptor == null) {
            return true;
        }
        if ((bluetoothGattCharacteristic.getProperties() & 16) != 0) {
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        } else if ((bluetoothGattCharacteristic.getProperties() & 32) != 0) {
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
        }
        f9142g.writeDescriptor(descriptor);
        return true;
    }

    public boolean a(String str, Context context) {
        l.a("connect: " + str);
        BluetoothAdapter bluetoothAdapter = f9141f;
        if (bluetoothAdapter == null || str == null || context == null) {
            return false;
        }
        if (f9143h != null) {
            f9143h = null;
        }
        BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(str);
        f9143h = remoteDevice;
        if (remoteDevice == null) {
            return false;
        }
        close();
        f9144i.post(new Runnable() { // from class: com.intelligoo.sdk.BluetoothLeService.3
            @Override // java.lang.Runnable
            public void run() {
                BluetoothDevice bluetoothDevice = BluetoothLeService.f9143h;
                BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                BluetoothGatt unused = BluetoothLeService.f9142g = bluetoothDevice.connectGatt(bluetoothLeService, false, bluetoothLeService.f9146c);
            }
        });
        l.a("mBluetoothGatt");
        return true;
    }

    public List<BluetoothGattService> b() {
        BluetoothGatt bluetoothGatt = f9142g;
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getServices();
    }

    public void c() {
        this.f9145a = false;
        l.a("connectAgain:false");
        BluetoothGatt bluetoothGatt = f9142g;
        if (bluetoothGatt == null) {
            return;
        }
        bluetoothGatt.disconnect();
    }

    public void close() {
        BluetoothGatt bluetoothGatt = f9142g;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
            b(f9142g);
        }
        this.f9145a = true;
        f9142g = null;
    }

    public boolean initialize() {
        if (this.f9148e == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
            this.f9148e = bluetoothManager;
            if (bluetoothManager == null) {
                return false;
            }
        }
        BluetoothAdapter adapter = this.f9148e.getAdapter();
        f9141f = adapter;
        return adapter != null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f9147d;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        close();
        return super.onUnbind(intent);
    }
}

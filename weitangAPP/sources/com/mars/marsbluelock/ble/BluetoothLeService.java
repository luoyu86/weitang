package com.mars.marsbluelock.ble;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothLeService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UUID f9486a = UUID.fromString(c.m.a.f.a.f2869a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothManager f9487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothAdapter f9488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BluetoothGatt f9490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9491f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BluetoothGattCallback f9492g = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IBinder f9493h = new b();

    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BluetoothLeService.this.g("com.example.bluetooth.le.ACTION_DATA_AVAILABLE", bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            if (i2 == 0) {
                BluetoothLeService.this.g("com.example.bluetooth.le.ACTION_DATA_AVAILABLE", bluetoothGattCharacteristic);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i2);
            bluetoothGattCharacteristic.getUuid().toString();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
            if (i3 != 2) {
                if (i3 == 0) {
                    BluetoothLeService.this.f9491f = 0;
                    Log.i("yang", "Disconnected from GATT server.");
                    BluetoothLeService.this.f("com.example.bluetooth.le.ACTION_GATT_DISCONNECTED");
                    return;
                }
                return;
            }
            BluetoothLeService.this.f9491f = 2;
            BluetoothLeService.this.f("com.example.bluetooth.le.ACTION_GATT_CONNECTED");
            Log.i("yang", "Connected to GATT server.");
            Log.i("yang", "Attempting to start service discovery:" + BluetoothLeService.this.f9490e.discoverServices());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i2);
            bluetoothGattDescriptor.getUuid().toString();
            BluetoothLeService.this.h("com.example.bluetooth.le.ACTION_DATA_WRITE", bluetoothGattDescriptor, i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
            if (i2 == 0) {
                BluetoothLeService.this.f("com.example.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED");
                return;
            }
            Log.w("yang", "onServicesDiscovered received: " + i2);
        }
    }

    public class b extends Binder {
        public b() {
        }

        public BluetoothLeService getService() {
            return BluetoothLeService.this;
        }
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public void close() {
        BluetoothGatt bluetoothGatt = this.f9490e;
        if (bluetoothGatt == null) {
            return;
        }
        bluetoothGatt.close();
        this.f9490e = null;
    }

    public boolean connect(String str) {
        if (this.f9488c == null || str == null) {
            Log.w("yang", "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }
        String str2 = this.f9489d;
        if (str2 != null && str.equals(str2) && this.f9490e != null) {
            Log.d("yang", "Trying to use an existing mBluetoothGatt for connection.");
            if (!this.f9490e.connect()) {
                return false;
            }
            this.f9491f = 1;
            return true;
        }
        BluetoothDevice remoteDevice = this.f9488c.getRemoteDevice(str);
        if (remoteDevice == null) {
            Log.w("yang", "Device not found.  Unable to connect.");
            return false;
        }
        this.f9490e = remoteDevice.connectGatt(this, false, this.f9492g);
        Log.d("yang", "Trying to create a new connection.");
        this.f9489d = str;
        this.f9491f = 1;
        return true;
    }

    public void disconnect() {
        BluetoothGatt bluetoothGatt;
        if (this.f9488c == null || (bluetoothGatt = this.f9490e) == null) {
            Log.w("yang", "BluetoothAdapter not initialized");
        } else {
            bluetoothGatt.disconnect();
        }
    }

    public final void f(String str) {
        sendBroadcast(new Intent(str));
    }

    public final void g(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Intent intent = new Intent(str);
        byte[] value = bluetoothGattCharacteristic.getValue();
        if (value == null || value.length <= 0) {
            return;
        }
        intent.putExtra("com.example.bluetooth.le.EXTRA_DATA", value);
        sendBroadcast(intent);
    }

    public List<BluetoothGattService> getSupportedGattServices() {
        BluetoothGatt bluetoothGatt = this.f9490e;
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getServices();
    }

    public final void h(String str, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
        Intent intent = new Intent(str);
        byte[] value = bluetoothGattDescriptor.getValue();
        if (value != null && value.length > 0) {
            intent.putExtra("com.example.bluetooth.le.EXTRA_DATA", value);
        }
        intent.putExtra("status", i2);
        sendBroadcast(intent);
    }

    public boolean initialize() {
        if (this.f9487b == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
            this.f9487b = bluetoothManager;
            if (bluetoothManager == null) {
                Log.e("yang", "Unable to initialize BluetoothManager.");
                return false;
            }
        }
        BluetoothAdapter adapter = this.f9487b.getAdapter();
        this.f9488c = adapter;
        if (adapter != null) {
            return true;
        }
        Log.e("yang", "Unable to obtain a BluetoothAdapter.");
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f9493h;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        close();
        return super.onUnbind(intent);
    }

    public void readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt;
        if (this.f9488c == null || (bluetoothGatt = this.f9490e) == null) {
            Log.w("yang", "BluetoothAdapter not initialized");
        } else {
            bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
        }
    }

    public void setCharacteristicNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        if (this.f9488c == null || this.f9490e == null) {
            Log.w("yang", "BluetoothAdapter not initialized");
            return;
        }
        Log.d("yang", "setCharacteristicNotification：" + bluetoothGattCharacteristic.getUuid() + "====" + z);
        this.f9490e.setCharacteristicNotification(bluetoothGattCharacteristic, z);
    }

    public boolean writeCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.f9488c != null) {
            return this.f9490e.writeCharacteristic(bluetoothGattCharacteristic);
        }
        Log.w("yang", "BluetoothAdapter not initialized");
        return false;
    }
}

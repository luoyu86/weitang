package c.e.e.a.r.j;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import com.chinavisionary.twlib.R;

/* JADX INFO: loaded from: classes2.dex */
public class l extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f2435c = "l";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f2436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BluetoothDevice f2437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BluetoothGattCallback f2440h;

    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            c.e.e.a.x.i.d(l.f2435c, "onCharacteristicChanged red");
            l.this.y();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i2);
            c.e.e.a.x.i.d(l.f2435c, "onCharacteristicRead " + i2 + ", unlock success time:" + System.currentTimeMillis());
            l.this.q(i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i2);
            l.this.r(i2);
            c.e.e.a.x.i.d(l.f2435c, "onCharacteristicWrite " + i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
            super.onConnectionStateChange(bluetoothGatt, i2, i3);
            c.e.e.a.x.i.d(l.f2435c, "onConnectionStateChange newState:" + i3 + ",status :" + i2);
            if (i2 != 0) {
                i3 = 0;
            }
            l.this.s(i3);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i2);
            c.e.e.a.x.i.d(l.f2435c, "onDescriptorRead status:" + i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i2);
            c.e.e.a.x.i.d(l.f2435c, "onDescriptorWrite status:" + i2);
            l.this.y();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i2, int i3) {
            super.onMtuChanged(bluetoothGatt, i2, i3);
            c.e.e.a.x.i.d(l.f2435c, "onMtuChanged status:" + i3);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i2, int i3) {
            super.onReadRemoteRssi(bluetoothGatt, i2, i3);
            c.e.e.a.x.i.d(l.f2435c, "onReadRemoteRssi status:" + i3);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i2) {
            super.onReliableWriteCompleted(bluetoothGatt, i2);
            c.e.e.a.x.i.d(l.f2435c, "onReliableWriteCompleted status:" + i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
            super.onServicesDiscovered(bluetoothGatt, i2);
            c.e.e.a.x.i.d(l.f2435c, "onServicesDiscovered " + i2);
            l.this.t(i2);
        }
    }

    public interface b {
        void onCharacteristicReadData(int i2);

        void onConnectResult(BluetoothGatt bluetoothGatt);

        void onConnectState(int i2);

        void onConnectSuccessStartWriterData();

        void onNotifySuccessStartReadData();

        void onWriterSuccessSetupNotify();
    }

    public l(c.e.e.a.r.d dVar, b bVar) {
        super(null, dVar);
        this.f2438f = 0;
        this.f2439g = 2;
        this.f2440h = new a();
        this.f2436d = bVar;
    }

    public void p(final BluetoothDevice bluetoothDevice, Handler handler) {
        c.e.e.a.r.d dVar = this.f2424b;
        if (dVar != null) {
            dVar.onConnect();
        }
        this.f2437e = bluetoothDevice;
        handler.postDelayed(new Runnable() { // from class: c.e.e.a.r.j.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f2416a.w(bluetoothDevice);
            }
        }, 100L);
        c.e.e.a.x.i.d(f2435c, "connect :" + bluetoothDevice.getAddress());
    }

    public final void q(int i2) {
        b bVar = this.f2436d;
        if (bVar != null) {
            bVar.onCharacteristicReadData(i2);
        }
    }

    public final void r(int i2) {
        if (i2 == 0) {
            b bVar = this.f2436d;
            if (bVar != null) {
                bVar.onWriterSuccessSetupNotify();
            }
            c.e.e.a.x.i.d(f2435c, "onCharacteristicWrite write success...");
            return;
        }
        x(c.e.e.a.x.k.getString(R.string.tw_lib_title_ble_writer_err) + i2);
    }

    public void retryConnectGatt() {
        if (this.f2437e != null) {
            c.e.e.a.x.i.d(f2435c, "retryConnectGatt device name:" + this.f2437e.getAddress() + " Thread name = " + Thread.currentThread().getName());
            v(this.f2437e);
        }
    }

    public final void s(int i2) {
        b bVar = this.f2436d;
        if (bVar != null) {
            bVar.onConnectState(i2);
        }
    }

    public final void t(int i2) {
        if (i2 == 0) {
            b bVar = this.f2436d;
            if (bVar != null) {
                bVar.onConnectSuccessStartWriterData();
            }
            c.e.e.a.x.i.i(f2435c, "onServicesDiscovered time." + System.currentTimeMillis());
            return;
        }
        x(c.e.e.a.x.k.getString(R.string.tw_lib_title_ble_connect_failed) + i2);
        c.e.e.a.x.i.d(f2435c, "onServicesDiscovered received: " + i2);
    }

    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final void w(BluetoothDevice bluetoothDevice) {
        if (a()) {
            this.f2423a = bluetoothDevice.connectGatt(c.e.e.a.x.g.getInstance().getContext(), false, this.f2440h, 2);
        } else {
            this.f2423a = bluetoothDevice.connectGatt(c.e.e.a.x.g.getInstance().getContext(), false, this.f2440h);
        }
        b bVar = this.f2436d;
        if (bVar != null) {
            bVar.onConnectResult(this.f2423a);
        }
    }

    public final void x(String str) {
        c.e.e.a.r.d dVar = this.f2424b;
        if (dVar != null) {
            dVar.onConnectError(str);
        }
    }

    public final void y() {
        this.f2438f++;
        c.e.e.a.x.i.d(f2435c, "readCharacteristicData isWriterOverAndChangeIndex:" + this.f2438f);
        b bVar = this.f2436d;
        if (bVar == null || this.f2438f < this.f2439g) {
            return;
        }
        this.f2438f = 0;
        bVar.onNotifySuccessStartReadData();
    }
}

package c.p.a.a;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import android.os.Handler;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class m extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f3022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f3023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f3024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f3025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3026i;
    public int j;
    public int k;
    public Context l;
    public final BluetoothGattCallback m;

    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            c.p.a.d.d.d("VTOpenDoorConnectHandle", "onCharacteristicChanged red characteristic uuid =  " + bluetoothGattCharacteristic.getUuid().toString());
            if (k.getInstance().getNotifyUuid().equals(bluetoothGattCharacteristic.getUuid())) {
                m.this.v(0, bluetoothGattCharacteristic);
                c.p.a.d.d.d("VTOpenDoorConnectHandle", "onCharacteristicChanged onCharacteristicRead data:" + c.p.a.d.c.encodeHexStr(bluetoothGattCharacteristic.getValue()).toUpperCase(Locale.ROOT));
            } else {
                m.this.D(bluetoothGattCharacteristic);
            }
            m.this.f3024g = true;
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i2);
            c.p.a.d.d.d("VTOpenDoorConnectHandle", "onCharacteristicRead " + i2 + ", unlock success time:" + System.currentTimeMillis());
            m.this.v(i2, bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i2);
            if (i2 == 0) {
                c.p.a.d.d.d("VTOpenDoorConnectHandle", "onCharacteristicWrite send success");
                c.p.a.d.a.INSTANCE.updateBoolean(true);
            }
            c.p.a.d.d.d("VTOpenDoorConnectHandle", "onCharacteristicWrite " + i2 + "， characteristic = " + bluetoothGattCharacteristic.getUuid().toString());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
            super.onConnectionStateChange(bluetoothGatt, i2, i3);
            c.p.a.d.d.d("VTOpenDoorConnectHandle", "onConnectionStateChange newState:" + i3 + ",status :" + i2);
            if (bluetoothGatt.getDevice() != null) {
                c.p.a.d.d.d("VTOpenDoorConnectHandle", "onConnectionStateChange newState:" + i3 + ",status :" + i2 + ",getBondState :" + bluetoothGatt.getDevice().getBondState());
            }
            if (i3 != 0) {
                m.this.x(i3);
                return;
            }
            if (!c.p.a.d.a.INSTANCE.getIsRetryConnect() || (!(i2 == 133 || i2 == 62) || m.this.k >= m.this.j)) {
                m.this.x(i2);
                return;
            }
            try {
                Thread.sleep(1000L);
                c.p.a.d.d.e("VTOpenDoorConnectHandle", "onConnectionStateChange 133 sleep status = " + i2);
                m.this.f2998a.connect();
                m.h(m.this);
                c.p.a.d.d.d("VTOpenDoorConnectHandle", "onConnectionStateChange 133 retry connect");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i2);
            c.p.a.d.d.d("VTOpenDoorConnectHandle", "onDescriptorRead status:" + i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i2);
            c.p.a.d.d.d("VTOpenDoorConnectHandle", "onDescriptorWrite status:" + i2);
            if (i2 == 0 && m.this.f3024g) {
                m.this.f3024g = false;
                m.this.E();
            }
            if (m.this.f3025h) {
                m.this.f3025h = false;
                m.this.w(i2);
                c.p.a.d.d.d("VTOpenDoorConnectHandle", "onDescriptorWrite handleCharacteristicWrite");
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i2, int i3) {
            super.onMtuChanged(bluetoothGatt, i2, i3);
            if (i3 == 0 && 180 == i2) {
                c.p.a.d.d.d("VTOpenDoorConnectHandle", "MTU change success = " + i2);
            } else {
                c.p.a.d.d.d("VTOpenDoorConnectHandle", "MTU change fail!");
            }
            m.this.y(i3);
            c.p.a.d.d.d("VTOpenDoorConnectHandle", "onMtuChanged status:" + i3);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i2, int i3) {
            super.onReadRemoteRssi(bluetoothGatt, i2, i3);
            c.p.a.d.d.d("VTOpenDoorConnectHandle", "onReadRemoteRssi status:" + i3);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i2) {
            super.onReliableWriteCompleted(bluetoothGatt, i2);
            c.p.a.d.d.d("VTOpenDoorConnectHandle", "onReliableWriteCompleted status:" + i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
            super.onServicesDiscovered(bluetoothGatt, i2);
            c.p.a.d.d.d("VTOpenDoorConnectHandle", "onServicesDiscovered " + i2);
            m.this.f3023f = false;
            m.this.y(i2);
        }
    }

    public interface b {
        void onCharacteristicReadData(int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic);

        void onConnectResult(BluetoothGatt bluetoothGatt);

        void onConnectState(int i2);

        void onConnectSuccessStartWriterData();

        void onNotifySuccessStartReadData(BluetoothGattCharacteristic bluetoothGattCharacteristic);

        void onNotifySuccessStartReadDataComplete();

        void onWriterSuccessSetupNotify();
    }

    public m(j jVar, b bVar, Context context) {
        super(null, jVar);
        this.f3023f = false;
        this.f3024g = false;
        this.f3025h = false;
        this.f3026i = 0;
        this.j = 2;
        this.k = 0;
        this.m = new a();
        this.f3022e = bVar;
        this.l = context;
    }

    public static /* synthetic */ int h(m mVar) {
        int i2 = mVar.k;
        mVar.k = i2 + 1;
        return i2;
    }

    public final void C(String str) {
        j jVar = this.f2999b;
        if (jVar != null) {
            jVar.onConnectError(str);
        }
    }

    public final void D(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f3026i++;
        c.p.a.d.d.d("VTOpenDoorConnectHandle", "readCharacteristicData isWriterOverAndChangeIndex:" + this.f3026i);
        if (this.f3022e != null) {
            this.f3025h = false;
            this.f3022e.onNotifySuccessStartReadData(bluetoothGattCharacteristic);
        }
    }

    public final void E() {
        c.p.a.d.d.d("VTOpenDoorConnectHandle", "readDataComplete");
        b bVar = this.f3022e;
        if (bVar != null) {
            bVar.onNotifySuccessStartReadDataComplete();
        }
    }

    public void u(final BluetoothDevice bluetoothDevice, Handler handler, final String str) {
        j jVar = this.f2999b;
        if (jVar != null) {
            jVar.onConnect();
        }
        this.f3023f = false;
        handler.postDelayed(new Runnable() { // from class: c.p.a.a.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f2986a.B(bluetoothDevice, str);
            }
        }, 400L);
        c.p.a.d.d.d("VTOpenDoorConnectHandle", "connect :" + bluetoothDevice.getAddress() + "， macAddress = " + str);
    }

    public final void v(int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        b bVar = this.f3022e;
        if (bVar != null) {
            bVar.onCharacteristicReadData(i2, bluetoothGattCharacteristic);
        }
    }

    public final void w(int i2) {
        if (i2 == 0) {
            b bVar = this.f3022e;
            if (bVar != null) {
                bVar.onConnectSuccessStartWriterData();
            }
            c.p.a.d.d.d("VTOpenDoorConnectHandle", "onCharacteristicWrite onConnectSuccessStartWriterData...");
            return;
        }
        C("写入数据错误,蓝牙错误码:" + i2);
    }

    public final void x(int i2) {
        b bVar = this.f3022e;
        if (bVar != null) {
            bVar.onConnectState(i2);
        }
    }

    public final void y(int i2) {
        if (i2 != 0) {
            C("蓝牙连接失败,错误码:" + i2);
            c.p.a.d.d.d("VTOpenDoorConnectHandle", "onServicesDiscovered received: " + i2);
            return;
        }
        this.f3023f = false;
        b bVar = this.f3022e;
        if (bVar != null) {
            bVar.onWriterSuccessSetupNotify();
            this.f3025h = true;
        }
        c.p.a.d.d.i("VTOpenDoorConnectHandle", "onServicesDiscovered time." + System.currentTimeMillis());
    }

    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public final void B(BluetoothDevice bluetoothDevice, String str) {
        if (!bluetoothDevice.getAddress().equalsIgnoreCase(str)) {
            C("蓝牙连接失败,mac地址错误");
            return;
        }
        this.f3023f = false;
        this.f3025h = false;
        this.k = 0;
        c.p.a.d.d.d("VTOpenDoorConnectHandle", "initBluetoothGattToDevice getBondState :" + bluetoothDevice.getBondState() + "， macAddress = " + str);
        if (a()) {
            this.f2998a = bluetoothDevice.connectGatt(this.l, false, this.m, 2);
        } else {
            this.f2998a = bluetoothDevice.connectGatt(this.l, false, this.m);
        }
        if (this.f3022e != null) {
            try {
                Thread.sleep(50L);
                c.p.a.d.d.d("VTOpenDoorConnectHandle", "initBluetoothGattToDevice requestConnectionPriority isSuccess :" + this.f2998a.requestConnectionPriority(1) + "， macAddress = " + str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f3022e.onConnectResult(this.f2998a);
        }
    }
}

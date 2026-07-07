package c.q.a.a;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public class l extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f3092e = "l";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f3093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f3094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f3095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f3096i;
    public int j;
    public int k;
    public int l;
    public Context m;
    public final BluetoothGattCallback n;

    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            c.q.a.c.i.d(l.f3092e, "onCharacteristicChanged red characteristic uuid =  " + bluetoothGattCharacteristic.getUuid().toString());
            l.this.f3095h = true;
            l.this.E();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i2);
            c.q.a.c.i.d(l.f3092e, "onCharacteristicRead " + i2 + ", unlock success time:" + System.currentTimeMillis());
            l.this.w(i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i2);
            if (i2 == 0) {
                c.q.a.c.i.d(l.f3092e, "onCharacteristicWrite send success");
                c.q.a.c.e.INSTANCE.updateBoolean(true);
            }
            c.q.a.c.i.d(l.f3092e, "onCharacteristicWrite " + i2 + "， characteristic = " + bluetoothGattCharacteristic.getUuid().toString());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
            super.onConnectionStateChange(bluetoothGatt, i2, i3);
            c.q.a.c.i.d(l.f3092e, "onConnectionStateChange newState:" + i3 + ",status :" + i2);
            if (bluetoothGatt.getDevice() != null) {
                c.q.a.c.i.d(l.f3092e, "onConnectionStateChange newState:" + i3 + ",status :" + i2 + ",getBondState :" + bluetoothGatt.getDevice().getBondState());
            }
            if (i3 != 0) {
                l.this.y(i3);
                return;
            }
            if (!c.q.a.c.e.INSTANCE.getIsRetryConnect() || i2 != 133 || l.this.l >= l.this.k) {
                l.this.y(i2);
                return;
            }
            try {
                Thread.sleep(1000L);
                c.q.a.c.i.e(l.f3092e, "onConnectionStateChange 133 sleep");
                l.this.f3072a.connect();
                l.k(l.this);
                c.q.a.c.i.d(l.f3092e, "onConnectionStateChange 133 retry connect");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i2);
            c.q.a.c.i.d(l.f3092e, "onDescriptorRead status:" + i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i2);
            c.q.a.c.i.d(l.f3092e, "onDescriptorWrite status:" + i2);
            if (i2 == 0 && l.this.f3095h) {
                l.this.f3095h = false;
                l.this.F();
            }
            if (l.this.f3096i) {
                l.this.f3096i = false;
                l.this.x(i2);
                c.q.a.c.i.d(l.f3092e, "onDescriptorWrite handleCharacteristicWrite");
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i2, int i3) {
            super.onMtuChanged(bluetoothGatt, i2, i3);
            if (i3 == 0 && 180 == i2) {
                c.q.a.c.i.d("MTU change success = " + i2);
            } else {
                c.q.a.c.i.d("MTU change fail!");
            }
            l.this.z(i3);
            c.q.a.c.i.d(l.f3092e, "onMtuChanged status:" + i3);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i2, int i3) {
            super.onReadRemoteRssi(bluetoothGatt, i2, i3);
            c.q.a.c.i.d(l.f3092e, "onReadRemoteRssi status:" + i3);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i2) {
            super.onReliableWriteCompleted(bluetoothGatt, i2);
            c.q.a.c.i.d(l.f3092e, "onReliableWriteCompleted status:" + i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
            super.onServicesDiscovered(bluetoothGatt, i2);
            c.q.a.c.i.d(l.f3092e, "onServicesDiscovered " + i2);
            l.this.f3094g = false;
            l.this.z(i2);
        }
    }

    public interface b {
        void onCharacteristicReadData(int i2);

        void onConnectResult(BluetoothGatt bluetoothGatt);

        void onConnectState(int i2);

        void onConnectSuccessStartWriterData();

        void onNotifySuccessStartReadData();

        void onNotifySuccessStartReadDataComplete();

        void onWriterSuccessSetupNotify();
    }

    public l(i iVar, b bVar, Context context) {
        super(null, iVar);
        this.f3094g = false;
        this.f3095h = false;
        this.f3096i = false;
        this.j = 0;
        this.k = 2;
        this.l = 0;
        this.n = new a();
        this.f3093f = bVar;
        this.m = context;
    }

    public static /* synthetic */ int k(l lVar) {
        int i2 = lVar.l;
        lVar.l = i2 + 1;
        return i2;
    }

    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final void C(BluetoothDevice bluetoothDevice, String str) {
        if (!bluetoothDevice.getAddress().equalsIgnoreCase(str)) {
            D("蓝牙连接失败,mac地址错误");
            return;
        }
        this.f3094g = false;
        this.f3096i = false;
        this.l = 0;
        c.q.a.c.i.d(l.class.getSimpleName(), "initBluetoothGattToDevice getBondState :" + bluetoothDevice.getBondState() + "， macAddress = " + str);
        if (a()) {
            this.f3072a = bluetoothDevice.connectGatt(this.m, false, this.n, 2);
        } else {
            this.f3072a = bluetoothDevice.connectGatt(this.m, false, this.n);
        }
        if (this.f3093f != null) {
            try {
                Thread.sleep(50L);
                boolean zRequestConnectionPriority = this.f3072a.requestConnectionPriority(1);
                c.q.a.c.i.d(getClass().getSimpleName(), "initBluetoothGattToDevice requestConnectionPriority isSuccess :" + zRequestConnectionPriority + "， macAddress = " + str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f3093f.onConnectResult(this.f3072a);
        }
    }

    public final void D(String str) {
        i iVar = this.f3073b;
        if (iVar != null) {
            iVar.onConnectError(str);
        }
    }

    public final void E() {
        this.j++;
        c.q.a.c.i.d(f3092e, "readCharacteristicData isWriterOverAndChangeIndex:" + this.j);
        if (this.f3093f != null) {
            this.f3096i = false;
            this.f3093f.onNotifySuccessStartReadData();
        }
    }

    public final void F() {
        c.q.a.c.i.d(f3092e, "readDataComplete");
        b bVar = this.f3093f;
        if (bVar != null) {
            bVar.onNotifySuccessStartReadDataComplete();
        }
    }

    public void v(final BluetoothDevice bluetoothDevice, Handler handler, final String str) {
        i iVar = this.f3073b;
        if (iVar != null) {
            iVar.onConnect();
        }
        this.f3094g = false;
        handler.postDelayed(new Runnable() { // from class: c.q.a.a.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f3062a.C(bluetoothDevice, str);
            }
        }, 400L);
        c.q.a.c.i.d(l.class.getSimpleName(), "connect :" + bluetoothDevice.getAddress() + "， macAddress = " + str);
    }

    public final void w(int i2) {
        b bVar = this.f3093f;
        if (bVar != null) {
            bVar.onCharacteristicReadData(i2);
        }
    }

    public final void x(int i2) {
        if (i2 == 0) {
            b bVar = this.f3093f;
            if (bVar != null) {
                bVar.onConnectSuccessStartWriterData();
            }
            c.q.a.c.i.d(f3092e, "onCharacteristicWrite onConnectSuccessStartWriterData...");
            return;
        }
        D("写入数据错误,蓝牙错误码:" + i2);
    }

    public final void y(int i2) {
        b bVar = this.f3093f;
        if (bVar != null) {
            bVar.onConnectState(i2);
        }
    }

    public final void z(int i2) {
        if (i2 != 0) {
            D("蓝牙连接失败,错误码:" + i2);
            c.q.a.c.i.d(f3092e, "onServicesDiscovered received: " + i2);
            return;
        }
        this.f3094g = false;
        b bVar = this.f3093f;
        if (bVar != null) {
            bVar.onWriterSuccessSetupNotify();
            this.f3096i = true;
        }
        c.q.a.c.i.i(f3092e, "onServicesDiscovered time." + System.currentTimeMillis());
    }
}

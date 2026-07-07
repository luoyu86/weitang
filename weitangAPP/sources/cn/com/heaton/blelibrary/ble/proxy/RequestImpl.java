package cn.com.heaton.blelibrary.ble.proxy;

import android.bluetooth.BluetoothDevice;
import androidx.annotation.RequiresApi;
import cn.com.heaton.blelibrary.ble.Ble;
import cn.com.heaton.blelibrary.ble.callback.BleConnectCallback;
import cn.com.heaton.blelibrary.ble.callback.BleMtuCallback;
import cn.com.heaton.blelibrary.ble.callback.BleNotiftCallback;
import cn.com.heaton.blelibrary.ble.callback.BleReadCallback;
import cn.com.heaton.blelibrary.ble.callback.BleReadRssiCallback;
import cn.com.heaton.blelibrary.ble.callback.BleScanCallback;
import cn.com.heaton.blelibrary.ble.callback.BleWriteCallback;
import cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback;
import cn.com.heaton.blelibrary.ble.model.BleDevice;
import cn.com.heaton.blelibrary.ble.model.EntityData;
import cn.com.heaton.blelibrary.ble.request.AdvertiserRequest;
import cn.com.heaton.blelibrary.ble.request.ConnectRequest;
import cn.com.heaton.blelibrary.ble.request.MtuRequest;
import cn.com.heaton.blelibrary.ble.request.NotifyRequest;
import cn.com.heaton.blelibrary.ble.request.ReadRequest;
import cn.com.heaton.blelibrary.ble.request.ReadRssiRequest;
import cn.com.heaton.blelibrary.ble.request.Rproxy;
import cn.com.heaton.blelibrary.ble.request.ScanRequest;
import cn.com.heaton.blelibrary.ble.request.WriteRequest;

/* JADX INFO: loaded from: classes.dex */
public class RequestImpl<T extends BleDevice> implements RequestLisenter<T> {
    private static RequestImpl instance = new RequestImpl();
    private static Ble.Options options;

    public static RequestImpl getInstance(Ble.Options options2) {
        options = options2;
        return instance;
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public void cancelWriteEntity() {
        ((WriteRequest) Rproxy.getInstance().getRequest(WriteRequest.class)).cancelWriteEntity();
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public /* bridge */ /* synthetic */ boolean connect(Object obj, BluetoothDevice bluetoothDevice, BleConnectCallback bleConnectCallback) {
        return connect((BleDevice) obj, bluetoothDevice, (BleConnectCallback<BleDevice>) bleConnectCallback);
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public /* bridge */ /* synthetic */ void notify(Object obj, BleNotiftCallback bleNotiftCallback) {
        notify((BleDevice) obj, (BleNotiftCallback<BleDevice>) bleNotiftCallback);
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public /* bridge */ /* synthetic */ boolean read(Object obj, BleReadCallback bleReadCallback) {
        return read((BleDevice) obj, (BleReadCallback<BleDevice>) bleReadCallback);
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public /* bridge */ /* synthetic */ boolean readRssi(Object obj, BleReadRssiCallback bleReadRssiCallback) {
        return readRssi((BleDevice) obj, (BleReadRssiCallback<BleDevice>) bleReadRssiCallback);
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public boolean setMtu(String str, int i2, BleMtuCallback<T> bleMtuCallback) {
        return ((MtuRequest) Rproxy.getInstance().getRequest(MtuRequest.class)).setMtu(str, i2, bleMtuCallback);
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    @RequiresApi(api = 21)
    public void startAdvertising(byte[] bArr) {
        ((AdvertiserRequest) Rproxy.getInstance().getRequest(AdvertiserRequest.class)).startAdvertising(bArr);
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public void startScan(BleScanCallback<T> bleScanCallback, String str) {
        ((ScanRequest) Rproxy.getInstance().getRequest(ScanRequest.class)).startScan(bleScanCallback, options.scanPeriod, str);
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    @RequiresApi(api = 21)
    public void stopAdvertising() {
        ((AdvertiserRequest) Rproxy.getInstance().getRequest(AdvertiserRequest.class)).stopAdvertising();
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public void stopScan() {
        ((ScanRequest) Rproxy.getInstance().getRequest(ScanRequest.class)).stopScan();
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public /* bridge */ /* synthetic */ boolean write(Object obj, byte[] bArr, BleWriteCallback bleWriteCallback) {
        return write((BleDevice) obj, bArr, (BleWriteCallback<BleDevice>) bleWriteCallback);
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public /* bridge */ /* synthetic */ void writeEntity(Object obj, byte[] bArr, int i2, int i3, BleWriteEntityCallback bleWriteEntityCallback) {
        writeEntity((BleDevice) obj, bArr, i2, i3, (BleWriteEntityCallback<BleDevice>) bleWriteEntityCallback);
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public /* bridge */ /* synthetic */ boolean connect(Object obj, BleConnectCallback bleConnectCallback) {
        return connect((BleDevice) obj, (BleConnectCallback<BleDevice>) bleConnectCallback);
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public /* bridge */ /* synthetic */ void disconnect(Object obj, BleConnectCallback bleConnectCallback) {
        disconnect((BleDevice) obj, (BleConnectCallback<BleDevice>) bleConnectCallback);
    }

    public void notify(T t, BleNotiftCallback<T> bleNotiftCallback) {
        ((NotifyRequest) Rproxy.getInstance().getRequest(NotifyRequest.class)).notify(t, bleNotiftCallback);
    }

    public boolean read(T t, BleReadCallback<T> bleReadCallback) {
        return ((ReadRequest) Rproxy.getInstance().getRequest(ReadRequest.class)).read(t, bleReadCallback);
    }

    public boolean readRssi(T t, BleReadRssiCallback<T> bleReadRssiCallback) {
        return ((ReadRssiRequest) Rproxy.getInstance().getRequest(ReadRssiRequest.class)).readRssi(t, bleReadRssiCallback);
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public void unNotify(T t) {
        ((NotifyRequest) Rproxy.getInstance().getRequest(NotifyRequest.class)).unNotify(t);
    }

    public boolean write(T t, byte[] bArr, BleWriteCallback<T> bleWriteCallback) {
        return ((WriteRequest) Rproxy.getInstance().getRequest(WriteRequest.class)).write(t, bArr, bleWriteCallback);
    }

    public void writeEntity(T t, byte[] bArr, int i2, int i3, BleWriteEntityCallback<T> bleWriteEntityCallback) {
        ((WriteRequest) Rproxy.getInstance().getRequest(WriteRequest.class)).writeEntity(t, bArr, i2, i3, bleWriteEntityCallback);
    }

    public boolean connect(T t, BleConnectCallback<T> bleConnectCallback) {
        return ((ConnectRequest) Rproxy.getInstance().getRequest(ConnectRequest.class)).connect(t, bleConnectCallback);
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public void disconnect(T t) {
        ((ConnectRequest) Rproxy.getInstance().getRequest(ConnectRequest.class)).disconnect(t);
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public void writeEntity(EntityData entityData, BleWriteEntityCallback<T> bleWriteEntityCallback) {
        ((WriteRequest) Rproxy.getInstance().getRequest(WriteRequest.class)).writeEntity(entityData, bleWriteEntityCallback);
    }

    public boolean connect(T t, BluetoothDevice bluetoothDevice, BleConnectCallback<T> bleConnectCallback) {
        return ((ConnectRequest) Rproxy.getInstance().getRequest(ConnectRequest.class)).connect(t, bluetoothDevice, bleConnectCallback);
    }

    public void disconnect(T t, BleConnectCallback<T> bleConnectCallback) {
        ((ConnectRequest) Rproxy.getInstance().getRequest(ConnectRequest.class)).disconnect(t, bleConnectCallback);
    }

    @Override // cn.com.heaton.blelibrary.ble.proxy.RequestLisenter
    public boolean connect(String str, BleConnectCallback<T> bleConnectCallback) {
        return ((ConnectRequest) Rproxy.getInstance().getRequest(ConnectRequest.class)).connect(str, bleConnectCallback);
    }
}

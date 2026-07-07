package cn.com.heaton.blelibrary.ble.request;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Message;
import cn.com.heaton.blelibrary.ble.Ble;
import cn.com.heaton.blelibrary.ble.BleHandler;
import cn.com.heaton.blelibrary.ble.BluetoothLeService;
import cn.com.heaton.blelibrary.ble.annotation.Implement;
import cn.com.heaton.blelibrary.ble.callback.BleReadCallback;
import cn.com.heaton.blelibrary.ble.model.BleDevice;

/* JADX INFO: loaded from: classes.dex */
@Implement(ReadRequest.class)
public class ReadRequest<T extends BleDevice> implements IMessage {
    private BleReadCallback<T> mBleLisenter;

    public ReadRequest() {
        BleHandler.of().setHandlerCallback(this);
    }

    @Override // cn.com.heaton.blelibrary.ble.request.IMessage
    public void handleMessage(Message message) {
        if (message.what != 2513) {
            return;
        }
        Object obj = message.obj;
        if (obj instanceof BluetoothGattCharacteristic) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) obj;
            BleReadCallback<T> bleReadCallback = this.mBleLisenter;
            if (bleReadCallback != null) {
                bleReadCallback.onReadSuccess(bluetoothGattCharacteristic);
            }
        }
    }

    public boolean read(T t, BleReadCallback<T> bleReadCallback) {
        this.mBleLisenter = bleReadCallback;
        BluetoothLeService bleService = Ble.getInstance().getBleService();
        if (Ble.getInstance() == null || bleService == null) {
            return false;
        }
        return bleService.readCharacteristic(t.getBleAddress());
    }
}

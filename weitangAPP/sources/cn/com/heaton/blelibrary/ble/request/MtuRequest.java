package cn.com.heaton.blelibrary.ble.request;

import android.os.Message;
import cn.com.heaton.blelibrary.ble.Ble;
import cn.com.heaton.blelibrary.ble.BleHandler;
import cn.com.heaton.blelibrary.ble.BluetoothLeService;
import cn.com.heaton.blelibrary.ble.annotation.Implement;
import cn.com.heaton.blelibrary.ble.callback.BleMtuCallback;
import cn.com.heaton.blelibrary.ble.model.BleDevice;

/* JADX INFO: loaded from: classes.dex */
@Implement(MtuRequest.class)
public class MtuRequest<T extends BleDevice> implements IMessage {
    private BleMtuCallback<T> mBleLisenter;

    public MtuRequest() {
        BleHandler.of().setHandlerCallback(this);
    }

    @Override // cn.com.heaton.blelibrary.ble.request.IMessage
    public void handleMessage(Message message) {
        if (message.what != 2526) {
            return;
        }
        Object obj = message.obj;
        if (obj instanceof BleDevice) {
            BleDevice bleDevice = (BleDevice) obj;
            BleMtuCallback<T> bleMtuCallback = this.mBleLisenter;
            if (bleMtuCallback != null) {
                bleMtuCallback.onMtuChanged(bleDevice, message.arg1, message.arg2);
            }
        }
    }

    public boolean setMtu(String str, int i2, BleMtuCallback<T> bleMtuCallback) {
        this.mBleLisenter = bleMtuCallback;
        BluetoothLeService bleService = Ble.getInstance().getBleService();
        if (Ble.getInstance() == null || bleService == null) {
            return false;
        }
        return bleService.setMTU(str, i2);
    }
}

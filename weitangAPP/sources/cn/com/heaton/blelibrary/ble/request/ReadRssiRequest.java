package cn.com.heaton.blelibrary.ble.request;

import android.os.Message;
import cn.com.heaton.blelibrary.ble.Ble;
import cn.com.heaton.blelibrary.ble.BleHandler;
import cn.com.heaton.blelibrary.ble.BluetoothLeService;
import cn.com.heaton.blelibrary.ble.annotation.Implement;
import cn.com.heaton.blelibrary.ble.callback.BleReadRssiCallback;
import cn.com.heaton.blelibrary.ble.model.BleDevice;

/* JADX INFO: loaded from: classes.dex */
@Implement(ReadRssiRequest.class)
public class ReadRssiRequest<T extends BleDevice> implements IMessage {
    private BleReadRssiCallback<T> mBleLisenter;

    public ReadRssiRequest() {
        BleHandler.of().setHandlerCallback(this);
    }

    @Override // cn.com.heaton.blelibrary.ble.request.IMessage
    public void handleMessage(Message message) {
        if (message.what != 2524) {
            return;
        }
        Object obj = message.obj;
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            BleReadRssiCallback<T> bleReadRssiCallback = this.mBleLisenter;
            if (bleReadRssiCallback != null) {
                bleReadRssiCallback.onReadRssiSuccess(iIntValue);
            }
        }
    }

    public boolean readRssi(T t, BleReadRssiCallback<T> bleReadRssiCallback) {
        this.mBleLisenter = bleReadRssiCallback;
        BluetoothLeService bleService = Ble.getInstance().getBleService();
        if (Ble.getInstance() == null || bleService == null) {
            return false;
        }
        return bleService.readRssi(t.getBleAddress());
    }
}

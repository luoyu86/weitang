package cn.com.heaton.blelibrary.ble;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import cn.com.heaton.blelibrary.ble.request.IMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BleHandler extends Handler {
    private static final String TAG = "BleHandler";
    private static BleHandler sHandler;
    private List<IMessage> receiveMessages;

    private BleHandler(Looper looper) {
        super(Looper.myLooper());
        this.receiveMessages = new ArrayList();
    }

    public static BleHandler of() {
        BleHandler bleHandler;
        synchronized (BleHandler.class) {
            if (sHandler == null) {
                HandlerThread handlerThread = new HandlerThread("handler thread");
                handlerThread.start();
                sHandler = new BleHandler(handlerThread.getLooper());
            }
            bleHandler = sHandler;
        }
        return bleHandler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Iterator<IMessage> it = this.receiveMessages.iterator();
        while (it.hasNext()) {
            it.next().handleMessage(message);
        }
    }

    public void setHandlerCallback(IMessage iMessage) {
        if (this.receiveMessages.contains(iMessage)) {
            return;
        }
        this.receiveMessages.add(iMessage);
    }
}

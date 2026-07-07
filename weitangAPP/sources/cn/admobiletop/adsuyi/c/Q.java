package cn.admobiletop.adsuyi.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class Q extends Handler {
    public Q(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        sendMessageDelayed(obtainMessage(), 1000L);
    }
}

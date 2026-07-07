package com.taobao.accs.data;

import android.content.Intent;
import android.os.Handler;
import com.taobao.accs.messenger.MessengerService;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class i extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MsgDistributeService f10304a;

    public i(MsgDistributeService msgDistributeService) {
        this.f10304a = msgDistributeService;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        if (message != null) {
            ALog.i("MsgDistributeService", "handleMessage on receive msg", "msg", message.toString());
            Intent intent = (Intent) message.getData().getParcelable(MessengerService.INTENT);
            if (intent != null) {
                ALog.i("MsgDistributeService", "handleMessage get intent success", MessengerService.INTENT, intent.toString());
                this.f10304a.onStartCommand(intent, 0, 0);
            }
        }
    }
}

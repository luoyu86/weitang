package org.android.agoo.control;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.messenger.MessengerService;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class h extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseIntentService f14962a;

    public h(BaseIntentService baseIntentService) {
        this.f14962a = baseIntentService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            ALog.i("BaseIntentService", "handleMessage on receive msg", "msg", message.toString());
            Intent intent = (Intent) message.getData().getParcelable(MessengerService.INTENT);
            if (intent != null) {
                ALog.i("BaseIntentService", "handleMessage get intent success", MessengerService.INTENT, intent.toString());
                ThreadPoolExecutorFactory.execute(new i(this, intent));
            }
        }
    }
}

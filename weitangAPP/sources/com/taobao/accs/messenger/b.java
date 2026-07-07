package com.taobao.accs.messenger;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessengerService f10332a;

    public b(MessengerService messengerService) {
        this.f10332a = messengerService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Intent intent;
        if (message == null || (intent = (Intent) message.getData().getParcelable(MessengerService.INTENT)) == null) {
            return;
        }
        this.f10332a.f10327a.execute(new c(this, intent));
    }
}

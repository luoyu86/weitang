package com.taobao.accs.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.taobao.accs.internal.ReceiverImpl;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class BaseReceiver extends BroadcastReceiver {
    private static final String TAG = BaseReceiver.class.getSimpleName();
    private IBaseReceiver baseReceiver;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (this.baseReceiver == null) {
                this.baseReceiver = new ReceiverImpl();
            }
            this.baseReceiver.onReceive(context, intent);
        } catch (Exception e2) {
            ALog.e(TAG, "build ReceiverImpl error", e2.getMessage());
        }
    }
}

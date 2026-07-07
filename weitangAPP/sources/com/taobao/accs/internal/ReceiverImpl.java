package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.base.IBaseReceiver;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UtilityImpl;

/* JADX INFO: loaded from: classes2.dex */
public class ReceiverImpl implements IBaseReceiver {
    @Override // com.taobao.accs.base.IBaseReceiver
    public void onReceive(Context context, Intent intent) {
        ALog.d("ReceiverImpl", "ReceiverImpl onReceive begin......", new Object[0]);
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            Intent intent2 = new Intent();
            if (UtilityImpl.b(context, true)) {
                return;
            }
            try {
                String packageName = context.getPackageName();
                String str = AdapterUtilityImpl.channelService;
                intent2.setClassName(packageName, str);
                IntentDispatch.dispatchIntent(context.getApplicationContext(), intent2, str);
                if (UtilityImpl.d(context)) {
                    String agooCustomServiceName = AdapterGlobalClientInfo.getAgooCustomServiceName(context);
                    intent2.setClassName(context, agooCustomServiceName);
                    IntentDispatch.dispatchIntent(context.getApplicationContext(), intent2, agooCustomServiceName);
                }
            } catch (Throwable th) {
                ALog.e("ReceiverImpl", "ReceiverImpl onReceive,exception,e=" + th.getMessage(), new Object[0]);
            }
        }
    }
}

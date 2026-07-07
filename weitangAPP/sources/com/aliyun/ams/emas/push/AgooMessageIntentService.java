package com.aliyun.ams.emas.push;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import c.a.a.a.a.b;
import c.a.a.a.a.c;
import c.a.a.a.a.f;
import c.a.a.a.a.g;
import com.aliyun.ams.emas.push.notification.CPushMessage;
import com.taobao.accs.utl.ALog;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public abstract class AgooMessageIntentService extends Service implements b, c {
    private static final String TAG = "MPS:AliyunMessageIntentService";
    private Messenger messenger = new Messenger(new f(this));

    public abstract /* synthetic */ boolean checkNotificationShowInInnerGroup(Map<String, String> map);

    public abstract /* synthetic */ Notification customNotificationUI(Context context, Map<String, String> map);

    public abstract /* synthetic */ Notification customSummaryNotification(Context context, Map<String, String> map);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.messenger.getBinder();
    }

    public void onHandleIntent(Intent intent) throws JSONException {
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            ALog.e(TAG, "Action is null, return.", new Object[0]);
            return;
        }
        ALog.d(TAG, "AgooMessageIntentService onHandleIntent action: " + action, new Object[0]);
        if ("com.alibaba.sdk.android.push.RECEIVE".equals(action)) {
            g.a(getApplicationContext(), intent, this, this);
            return;
        }
        if (AgooMessageReceiver.NOTIFICATION_OPENED_ACTION.equals(action)) {
            g.a(getApplicationContext(), intent, this);
        } else if (AgooMessageReceiver.NOTIFICATION_REMOVED_ACTION.equals(action)) {
            g.b(getApplicationContext(), intent, this);
        } else {
            ALog.e(TAG, "Invalid action", new Object[0]);
        }
    }

    public abstract /* synthetic */ void onMessageArrived(Context context, CPushMessage cPushMessage);

    public abstract /* synthetic */ void onNotificationOpened(Context context, String str, String str2, String str3, int i2);

    public abstract /* synthetic */ void onNotificationReceivedWithoutShow(Context context, String str, String str2, Map<String, String> map, int i2, String str3, String str4);

    public abstract /* synthetic */ void onNotificationRemoved(Context context, String str, String str2, String str3, int i2, String str4);

    public abstract /* synthetic */ void onNotificationShow(Context context, String str, String str2, Map<String, String> map);

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onHandleIntent(intent);
        return 2;
    }

    public abstract /* synthetic */ boolean showNotificationNow(Context context, Map<String, String> map);
}

package com.aliyun.ams.emas.push;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import c.a.a.a.a.b;
import c.a.a.a.a.c;
import c.a.a.a.a.g;
import com.aliyun.ams.emas.push.notification.CPushMessage;
import com.taobao.accs.utl.ALog;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class AgooMessageReceiver extends BroadcastReceiver implements b, c {
    public static final String EXTRA_MAP = "extraMap";
    public static final String MESSAGE_ID = "messageId";
    public static final String NOTIFICATION_GROUP = "group";
    public static final String NOTIFICATION_ID = "notificationId";
    public static final String NOTIFICATION_OPENED_ACTION = "com.alibaba.push2.action.NOTIFICATION_OPENED";
    public static final String NOTIFICATION_OPEN_TYPE = "notificationOpenType";
    public static final String NOTIFICATION_REMOVED_ACTION = "com.alibaba.push2.action.NOTIFICATION_REMOVED";
    public static final String SUMMARY = "summary";
    public static final String TAG = "MPS:AgooMessageReceiver";
    public static final String TITLE = "title";

    public abstract /* synthetic */ boolean checkNotificationShowInInnerGroup(Map<String, String> map);

    public abstract /* synthetic */ Notification customNotificationUI(Context context, Map<String, String> map);

    public abstract /* synthetic */ Notification customSummaryNotification(Context context, Map<String, String> map);

    public abstract /* synthetic */ void onMessageArrived(Context context, CPushMessage cPushMessage);

    public abstract /* synthetic */ void onNotificationOpened(Context context, String str, String str2, String str3, int i2);

    public abstract /* synthetic */ void onNotificationReceivedWithoutShow(Context context, String str, String str2, Map<String, String> map, int i2, String str3, String str4);

    public abstract /* synthetic */ void onNotificationRemoved(Context context, String str, String str2, String str3, int i2, String str4);

    public abstract /* synthetic */ void onNotificationShow(Context context, String str, String str2, Map<String, String> map);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ALog.d(TAG, "AgooMessageReceiver onReceive begin...intent=" + intent, new Object[0]);
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        try {
            if (TextUtils.equals("com.alibaba.sdk.android.push.RECEIVE", action)) {
                g.a(context, intent, this, this);
            } else if (TextUtils.equals(NOTIFICATION_OPENED_ACTION, action)) {
                g.a(context, intent, this);
            } else if (TextUtils.equals(NOTIFICATION_REMOVED_ACTION, action)) {
                g.b(context, intent, this);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "handle action error:", th, new Object[0]);
        }
    }

    public abstract /* synthetic */ boolean showNotificationNow(Context context, Map<String, String> map);
}

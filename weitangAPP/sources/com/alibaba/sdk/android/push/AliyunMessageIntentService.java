package com.alibaba.sdk.android.push;

import android.app.Notification;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.push.a.b;
import com.alibaba.sdk.android.push.notification.CPushMessage;
import com.alibaba.sdk.android.push.notification.NotificationConfigure;
import com.alibaba.sdk.android.push.notification.PushData;
import com.alibaba.sdk.android.push.notification.d;
import com.alibaba.sdk.android.push.notification.e;
import com.alibaba.sdk.android.push.util.a;
import com.aliyun.ams.emas.push.AgooMessageIntentService;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public abstract class AliyunMessageIntentService extends AgooMessageIntentService {
    private final d mMessageNotification = new d();

    @Override // com.aliyun.ams.emas.push.AgooMessageIntentService, c.a.a.a.a.c
    public boolean checkNotificationShowInInnerGroup(Map<String, String> map) {
        boolean zC = b.a().c();
        if (zC) {
            map.put(AgooConstants.MESSAGE_BODY_EMAS_GROUP, AgooConstants.ACCS_PUSH_GROUP);
        }
        return zC;
    }

    public Notification customNotificationUI(Context context, PushData pushData) {
        return null;
    }

    @Override // com.aliyun.ams.emas.push.AgooMessageIntentService, c.a.a.a.a.c
    public Notification customNotificationUI(Context context, Map<String, String> map) {
        PushData pushData = PushData.parse(context, map);
        NotificationConfigure notificationConfigureHookNotificationBuild = hookNotificationBuild();
        Notification notificationCustomNotificationUI = customNotificationUI(context, pushData);
        if (notificationCustomNotificationUI != null) {
            return notificationCustomNotificationUI;
        }
        return this.mMessageNotification.b(getApplicationContext(), this.mMessageNotification.a(getApplicationContext(), map), pushData, notificationConfigureHookNotificationBuild);
    }

    @Override // com.aliyun.ams.emas.push.AgooMessageIntentService, c.a.a.a.a.c
    public Notification customSummaryNotification(Context context, Map<String, String> map) {
        PushData pushData = PushData.parse(context, map);
        NotificationConfigure notificationConfigureHookNotificationBuild = hookNotificationBuild();
        return this.mMessageNotification.a(context, this.mMessageNotification.a(context, map), pushData, notificationConfigureHookNotificationBuild);
    }

    public NotificationConfigure hookNotificationBuild() {
        return null;
    }

    public abstract void onMessage(Context context, CPushMessage cPushMessage);

    @Override // com.aliyun.ams.emas.push.AgooMessageIntentService, c.a.a.a.a.b
    public void onMessageArrived(Context context, com.aliyun.ams.emas.push.notification.CPushMessage cPushMessage) {
        onMessage(context, CPushMessage.from(cPushMessage));
    }

    public abstract void onNotification(Context context, String str, String str2, Map<String, String> map);

    public abstract void onNotificationClickedWithNoAction(Context context, String str, String str2, String str3);

    public abstract void onNotificationOpened(Context context, String str, String str2, String str3);

    @Override // com.aliyun.ams.emas.push.AgooMessageIntentService, c.a.a.a.a.b
    public void onNotificationOpened(Context context, String str, String str2, String str3, int i2) {
        if (i2 == 4) {
            onNotificationClickedWithNoAction(context, str, str2, str3);
        } else {
            onNotificationOpened(context, str, str2, str3);
        }
    }

    public abstract void onNotificationReceivedInApp(Context context, String str, String str2, Map<String, String> map, int i2, String str3, String str4);

    @Override // com.aliyun.ams.emas.push.AgooMessageIntentService, c.a.a.a.a.b
    public void onNotificationReceivedWithoutShow(Context context, String str, String str2, Map<String, String> map, int i2, String str3, String str4) {
        onNotificationReceivedInApp(context, str, str2, map, i2, str3, str4);
    }

    public abstract void onNotificationRemoved(Context context, String str);

    @Override // com.aliyun.ams.emas.push.AgooMessageIntentService, c.a.a.a.a.b
    public void onNotificationRemoved(Context context, String str, String str2, String str3, int i2, String str4) {
        onNotificationRemoved(context, str4);
    }

    @Override // com.aliyun.ams.emas.push.AgooMessageIntentService, c.a.a.a.a.b
    public void onNotificationShow(Context context, String str, String str2, Map<String, String> map) {
        if (map != null && map.containsKey(AgooConstants.LOCAL_ALIYUN_NOTIFICATION_BADGE)) {
            String str3 = map.get(AgooConstants.LOCAL_ALIYUN_NOTIFICATION_BADGE);
            if (!TextUtils.isEmpty(str3)) {
                try {
                    a.a(context, Integer.parseInt(str3));
                } catch (Exception unused) {
                }
            }
        }
        onNotification(context, str, str2, map);
    }

    @Override // com.aliyun.ams.emas.push.AgooMessageIntentService, c.a.a.a.a.c
    public boolean showNotificationNow(Context context, Map<String, String> map) {
        return d.a(map) || !e.a(context);
    }
}

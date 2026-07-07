package c.a.a.a.a.n;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import c.a.a.a.a.m;
import com.aliyun.ams.emas.push.AgooMessageReceiver;
import com.aliyun.ams.emas.push.MsgService;
import com.aliyun.ams.emas.push.NotificationActivity;
import com.aliyun.ams.emas.push.notification.CPushMessage;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public CPushMessage a(Map<String, String> map, String str, String str2) {
        String str3 = map.get("title");
        String str4 = map.get("content");
        String str5 = map.get(AgooConstants.MESSAGE_EXT);
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            ALog.e("MPS:MessageNotification", "Message title or content is empty:" + map.toString(), new Object[0]);
            return null;
        }
        CPushMessage cPushMessage = new CPushMessage();
        cPushMessage.setMessageId(str2);
        cPushMessage.setAppId(str);
        cPushMessage.setTitle(str3);
        cPushMessage.setContent(str4);
        cPushMessage.setTraceInfo(str5);
        return cPushMessage;
    }

    public a b(Map<String, String> map, String str, String str2) {
        String str3 = map.get("title");
        String str4 = map.get("content");
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            ALog.e("MPS:MessageNotification", "title or content of notify is empty: " + map, new Object[0]);
            return null;
        }
        a aVar = new a();
        String strValueOf = map.get("open");
        if (TextUtils.isEmpty(strValueOf)) {
            strValueOf = String.valueOf(1);
        }
        String str5 = map.get(AgooConstants.OPEN_URL);
        String str6 = map.get("activity");
        String str7 = map.get("ext");
        String str8 = map.get(AgooConstants.MESSAGE_TASK_ID);
        String str9 = map.get(AgooConstants.MESSAGE_EXT);
        String str10 = map.get("notification_channel");
        String str11 = map.get("notify_id");
        String str12 = map.get("tid");
        String str13 = map.get(AgooConstants.KEY_BADGE);
        int i2 = !TextUtils.isEmpty(str11) ? Integer.parseInt(str11) : m.c();
        aVar.e(str);
        aVar.d(str2);
        aVar.h(str8);
        aVar.i(str9);
        aVar.k(map.get(AgooConstants.MESSAGE_SOURCE));
        aVar.a(str3);
        aVar.b(str4);
        aVar.a(Integer.parseInt(strValueOf));
        if (TextUtils.isEmpty(str5)) {
            str5 = null;
        }
        aVar.c(str5);
        if (TextUtils.isEmpty(str6)) {
            str6 = null;
        }
        aVar.f(str6);
        aVar.b(i2);
        aVar.j(str10);
        aVar.l(str12);
        if (!TextUtils.isEmpty(str7)) {
            try {
                Map<String, String> map2 = JsonUtility.toMap(new JSONObject(str7));
                map2.put("_ALIYUN_NOTIFICATION_ID_", String.valueOf(aVar.i()));
                if (map2.containsKey("_ALIYUN_NOTIFICATION_PRIORITY_")) {
                    aVar.g(map2.get("_ALIYUN_NOTIFICATION_PRIORITY_"));
                } else if (Build.VERSION.SDK_INT >= 16) {
                    aVar.g(String.valueOf(0));
                } else {
                    aVar.g(String.valueOf(0));
                }
                map2.put(AgooConstants.MESSAGE_BODY_MSG_ID_ALIYUN_FLAG, map.get(AgooConstants.MESSAGE_BODY_MSG_ID_ALIYUN_FLAG));
                aVar.a(map2);
            } catch (JSONException e2) {
                ALog.e("MPS:MessageNotification", "Parse inner json(ext) error:", e2, new Object[0]);
            }
        }
        if (!TextUtils.isEmpty(str13)) {
            if (aVar.e() == null) {
                aVar.a(new HashMap());
            }
            aVar.e().put(AgooConstants.LOCAL_ALIYUN_NOTIFICATION_BADGE, str13);
            aVar.n(str13);
        }
        return aVar;
    }

    public void a(Context context, Notification notification, Notification notification2, a aVar) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            String str = "";
            if (notification == null) {
                c cVar = new c();
                cVar.a(aVar.b());
                cVar.b(aVar.c());
                cVar.a(aVar.j());
                cVar.c(aVar.m());
                cVar.d(aVar.o());
                notification = cVar.a(context);
                if (notification == null) {
                    notification = new Notification(R.drawable.stat_notify_chat, "", System.currentTimeMillis());
                }
            }
            Intent intent = new Intent();
            intent.putExtra("appId", aVar.g());
            intent.putExtra("msgId", aVar.f());
            intent.putExtra(AgooConstants.MESSAGE_TASK_ID, aVar.k());
            intent.putExtra(AgooConstants.MESSAGE_EXT, aVar.l());
            intent.putExtra(AgooConstants.MESSAGE_SOURCE, aVar.n());
            intent.setFlags(270532608);
            try {
                int iA = aVar.a();
                if (iA == 1) {
                    str = "app";
                    intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                } else if (iA == 2) {
                    str = "activity";
                    try {
                        intent.setClass(context, Class.forName(aVar.h()));
                    } catch (Throwable th) {
                        ALog.e("MPS:MessageNotification", "can't find certain activity class: ", th, new Object[0]);
                    }
                } else if (iA == 3) {
                    str = AgooConstants.OPEN_URL;
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(aVar.d()));
                } else if (iA == 4) {
                    str = "no action";
                }
                ALog.i("MPS:MessageNotification", "open type:" + str, new Object[0]);
            } catch (Throwable th2) {
                ALog.e("MPS:MessageNotification", "openType exception", th2, new Object[0]);
            }
            notification.contentIntent = b(context, aVar, intent, m.d());
            notification.deleteIntent = a(context, aVar, m.d());
            try {
                ALog.i("MPS:MessageNotification", "messageId=" + aVar.f() + ";appId=" + aVar.g() + ";messageType=notify", null, 1);
            } catch (Throwable th3) {
                ALog.e("MPS:MessageNotification", "ut log error", th3, new Object[0]);
            }
            c.a.a.a.a.e.a.a().a(aVar.i());
            notificationManager.notify(aVar.i(), notification);
            m.f812a.d("push notify notification");
            String strO = aVar.o();
            String strP = aVar.p();
            if (notification2 != null) {
                if (!TextUtils.isEmpty(strO)) {
                    notificationManager.notify(strO.hashCode(), notification2);
                } else {
                    if (TextUtils.isEmpty(strP)) {
                        return;
                    }
                    notificationManager.notify(0, notification2);
                }
            }
        } catch (Throwable th4) {
            m.f812a.e("onNotification", th4);
            Log.e("MPS:MessageNotification", Log.getStackTraceString(th4));
        }
    }

    public final PendingIntent b(Context context, a aVar, Intent intent, int i2) {
        Intent intent2 = new Intent();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 30 && context.getApplicationInfo().targetSdkVersion <= 30) {
            intent2.setClassName(context.getPackageName(), MsgService.class.getName());
        } else {
            intent2.setClassName(context.getPackageName(), NotificationActivity.class.getName());
        }
        intent2.setAction(m.f813b);
        intent2.putExtra(AgooConstants.ACTION_TYPE, AgooConstants.NOTIFICATION_TYPE_OPEN);
        intent2.putExtra(AgooConstants.MESSAGE_TASK_ID, aVar.k());
        intent2.putExtra(AgooConstants.MESSAGE_EXT, aVar.l());
        String strO = aVar.o();
        if (!TextUtils.isEmpty(strO)) {
            intent2.putExtra(AgooMessageReceiver.NOTIFICATION_GROUP, strO);
        }
        intent.putExtra("title", aVar.b());
        intent.putExtra(AgooMessageReceiver.SUMMARY, aVar.c());
        intent.putExtra("msgId", aVar.f());
        intent.putExtra("appId", aVar.g());
        intent.putExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, aVar.a());
        intent.putExtra(AgooMessageReceiver.NOTIFICATION_ID, aVar.i());
        if (!TextUtils.isEmpty(strO)) {
            intent.putExtra(AgooMessageReceiver.NOTIFICATION_GROUP, strO);
        }
        intent2.putExtra("msgId", aVar.f());
        if (aVar.e() != null) {
            intent.putExtra(AgooMessageReceiver.EXTRA_MAP, new JSONObject(aVar.e()).toString());
        }
        ALog.d("MPS:MessageNotification", "build content messageId:" + aVar.f(), new Object[0]);
        intent2.putExtra(AgooConstants.KEY_REAL_INTENT, intent);
        if (i3 > 30 || context.getApplicationInfo().targetSdkVersion > 30) {
            return PendingIntent.getActivity(context, i2, intent2, 201326592);
        }
        if (i3 >= 23) {
            return PendingIntent.getService(context, i2, intent2, 201326592);
        }
        return PendingIntent.getService(context, i2, intent2, 134217728);
    }

    public final PendingIntent a(Context context, a aVar, int i2) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), MsgService.class.getName());
        intent.setAction(m.f813b);
        intent.putExtra(AgooConstants.ACTION_TYPE, AgooConstants.NOTIFICATION_TYPE_DELETE);
        intent.putExtra(AgooConstants.MESSAGE_TASK_ID, aVar.k());
        intent.putExtra(AgooConstants.MESSAGE_EXT, aVar.l());
        intent.putExtra("msgId", aVar.f());
        intent.putExtra("title", aVar.b());
        intent.putExtra(AgooMessageReceiver.SUMMARY, aVar.c());
        intent.putExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, aVar.a());
        intent.putExtra(AgooMessageReceiver.NOTIFICATION_ID, aVar.i());
        intent.putExtra(AgooMessageReceiver.NOTIFICATION_GROUP, aVar.o());
        if (aVar.e() != null) {
            intent.putExtra(AgooMessageReceiver.EXTRA_MAP, new JSONObject(aVar.e()).toString());
        }
        ALog.d("MPS:MessageNotification", "delete content messageId:" + aVar.f(), new Object[0]);
        intent.putExtra("appId", aVar.g());
        if (Build.VERSION.SDK_INT >= 23) {
            return PendingIntent.getService(context, i2, intent, 201326592);
        }
        return PendingIntent.getService(context, i2, intent, 134217728);
    }
}

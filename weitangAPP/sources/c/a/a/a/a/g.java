package c.a.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.aliyun.ams.emas.push.AgooMessageReceiver;
import com.aliyun.ams.emas.push.notification.CPushMessage;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static void a(Context context, Intent intent, c cVar, b bVar) throws JSONException {
        try {
            String stringExtra = intent.getStringExtra("id");
            if (TextUtils.isEmpty(stringExtra)) {
                ALog.e("AgooPushHandler", "handle message Null messageId!", new Object[0]);
                return;
            }
            String stringExtra2 = intent.getStringExtra(AgooConstants.MESSAGE_BODY);
            String stringExtra3 = intent.getStringExtra(AgooConstants.MESSAGE_TASK_ID);
            String stringExtra4 = intent.getStringExtra(AgooConstants.MESSAGE_EXT);
            String stringExtra5 = intent.getStringExtra(AgooConstants.MESSAGE_SOURCE);
            if (TextUtils.isEmpty(stringExtra2)) {
                ALog.e("AgooPushHandler", "handle message json body is Empty!", new Object[0]);
                return;
            }
            Map<String, String> map = null;
            try {
                map = JsonUtility.toMap(new JSONObject(stringExtra2));
            } catch (JSONException e2) {
                ALog.e("AgooPushHandler", "Parse json error:", e2, new Object[0]);
            }
            try {
                int i2 = Integer.parseInt(map.get("type"));
                m.f812a.d("handle message, messageId:" + stringExtra + ", type:" + i2 + ", msg receive:" + stringExtra2);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    m.f812a.d(entry.getKey() + " --> " + entry.getValue());
                }
                String str = map.get("msg_id");
                map.put(AgooConstants.MESSAGE_TASK_ID, stringExtra3);
                map.put(AgooConstants.MESSAGE_EXT, stringExtra4);
                map.put(AgooConstants.MESSAGE_SOURCE, stringExtra5);
                map.put(AgooConstants.MESSAGE_BODY_MSG_ID_ALIYUN_FLAG, str);
                if (m.b()) {
                    m.f812a.d("Push received in DoNotDisturb time window, ignored.");
                } else {
                    b(context, cVar, bVar, stringExtra, map, i2);
                }
            } catch (Throwable th) {
                ALog.e("AgooPushHandler", "Wrong message Type Define!", th, new Object[0]);
            }
        } catch (Throwable th2) {
            ALog.e("AgooPushHandler", "onHandleCallException", th2, new Object[0]);
        }
    }

    public static void b(Context context, c cVar, b bVar, String str, Map<String, String> map, int i2) {
        c.a.a.a.a.n.b bVar2 = new c.a.a.a.a.n.b();
        if (i2 != 1) {
            if (i2 != 2) {
                ALog.e("AgooPushHandler", "Wrong message Type Define!", new Object[0]);
                return;
            }
            try {
                CPushMessage cPushMessageA = bVar2.a(map, Config.b(context), str);
                if (cPushMessageA != null) {
                    m.a(context, cPushMessageA.getMessageId(), i2);
                    try {
                        ALog.i("AgooPushHandler", "messageId=" + cPushMessageA.getMessageId() + ";appId=" + cPushMessageA.getAppId() + ";messageType=msg", null, 1);
                    } catch (Throwable th) {
                        ALog.e("AgooPushHandler", "ut log error", th, new Object[0]);
                    }
                    bVar.onMessageArrived(context, cPushMessageA);
                    return;
                }
                return;
            } catch (Throwable th2) {
                ALog.e("AgooPushHandler", "Custom message parse error:", th2, new Object[0]);
                return;
            }
        }
        try {
            String strB = Config.b(context);
            c.a.a.a.a.n.a aVarB = bVar2.b(map, strB, str);
            if (aVarB == null) {
                ALog.e("AgooPushHandler", "Notify title is null or server push data Error appId =  " + strB, new Object[0]);
                return;
            }
            m.a(context, aVarB.f(), i2);
            if (!cVar.showNotificationNow(context, map)) {
                m.f812a.i("do not build notification as user request");
                bVar.onNotificationReceivedWithoutShow(context, aVarB.b(), aVarB.c(), aVarB.e(), aVarB.a(), aVarB.h(), aVarB.d());
            } else {
                String strO = aVarB.o();
                if (!TextUtils.isEmpty(strO)) {
                    c.a.a.a.a.e.a.a().a(strO, aVarB);
                }
                c(context, cVar, map, new j(map, aVarB, bVar2, context, bVar));
            }
        } catch (Throwable th3) {
            ALog.e("AgooPushHandler", "Notify message error:", th3, new Object[0]);
        }
    }

    public static void c(Context context, c cVar, Map<String, String> map, l lVar) {
        String str = map.get("image");
        String str2 = map.get("big_picture");
        String str3 = map.get("tid");
        boolean zCheckNotificationShowInInnerGroup = cVar.checkNotificationShowInInnerGroup(map);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            lVar.a(cVar.customNotificationUI(context, map), (!TextUtils.isEmpty(str3) || zCheckNotificationShowInInnerGroup) ? cVar.customSummaryNotification(context, map) : null);
        } else {
            ThreadPoolExecutorFactory.execute(new h(cVar, context, map, str3, zCheckNotificationShowInInnerGroup, Looper.myLooper() != null ? new Handler(Looper.myLooper()) : null, lVar));
        }
    }

    public static void a(Context context, Intent intent, b bVar) {
        try {
            String stringExtra = intent.getStringExtra(AgooMessageReceiver.MESSAGE_ID);
            String stringExtra2 = intent.getStringExtra("title");
            String stringExtra3 = intent.getStringExtra(AgooMessageReceiver.SUMMARY);
            String stringExtra4 = intent.getStringExtra(AgooMessageReceiver.EXTRA_MAP);
            String stringExtra5 = intent.getStringExtra(AgooMessageReceiver.NOTIFICATION_GROUP);
            int intExtra = intent.getIntExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, 1);
            m.f812a.d("notification opened " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra5)) {
                c.a.a.a.a.e.a.a().a(stringExtra5);
            }
            bVar.onNotificationOpened(context, stringExtra2, stringExtra3, stringExtra4, intExtra);
        } catch (Throwable th) {
            ALog.e("AgooPushHandler", "Handle notification open action failed.", th, new Object[0]);
        }
    }

    public static void b(Context context, Intent intent, b bVar) {
        try {
            String stringExtra = intent.getStringExtra(AgooMessageReceiver.MESSAGE_ID);
            String stringExtra2 = intent.getStringExtra("title");
            String stringExtra3 = intent.getStringExtra(AgooMessageReceiver.SUMMARY);
            String stringExtra4 = intent.getStringExtra(AgooMessageReceiver.EXTRA_MAP);
            int intExtra = intent.getIntExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, 1);
            String stringExtra5 = intent.getStringExtra(AgooMessageReceiver.NOTIFICATION_GROUP);
            m.f812a.d("notification deleted " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra5)) {
                c.a.a.a.a.e.a.a().a(stringExtra5);
            }
            bVar.onNotificationRemoved(context, stringExtra2, stringExtra3, stringExtra4, intExtra, stringExtra);
        } catch (Throwable th) {
            ALog.e("AgooPushHandler", "Handle notification delete action failed.", th, new Object[0]);
        }
    }
}

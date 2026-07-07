package com.chinavisionary.microtang.push;

import android.content.Context;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.c.e0.a.a;
import c.e.c.e0.a.b;
import c.e.e.a.x.l;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.sdk.android.push.MessageReceiver;
import com.alibaba.sdk.android.push.notification.CPushMessage;
import com.chinavisionary.microtang.main.event.EventBadgeMsgVo;
import com.chinavisionary.microtang.msg.vo.MsgVo;
import g.b.a.c;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PushReceive extends MessageReceiver {
    public final void a(Map<String, String> map) {
        try {
            PushMsgExtVo pushMsgExtVo = (PushMsgExtVo) JSON.parseObject(JSON.toJSONString(map), PushMsgExtVo.class);
            b.getInstance().setNotifyMessageKey(pushMsgExtVo.getMessageKey());
            b(pushMsgExtVo);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void b(PushMsgExtVo pushMsgExtVo) {
        boolean z = pushMsgExtVo.getShowType() == 1;
        int msgCount = pushMsgExtVo.getMsgCount();
        EventBadgeMsgVo eventBadgeMsgVo = new EventBadgeMsgVo();
        eventBadgeMsgVo.setShow(z);
        eventBadgeMsgVo.setShowPaint(!z);
        eventBadgeMsgVo.setBadgeNumber(msgCount);
        c.getDefault().postSticky(eventBadgeMsgVo);
    }

    public final void c(Context context, String str, String str2, Map<String, String> map) {
        if ("App升级信息".equals(str)) {
            w.getInstance().putString("app_info", str2);
            String string = w.getInstance().getString("app_info", null);
            q.d(PushReceive.class.getSimpleName(), "setupNotification save content:" + string);
            return;
        }
        MsgVo msgVo = new MsgVo();
        msgVo.setTitle(str);
        msgVo.setContent(str2);
        if (map != null) {
            msgVo.setExt(map);
            a(map);
        }
        boolean z = true;
        if (map != null && map.containsKey("enableEmergencyLock")) {
            z = false;
            boolean zEquals = "true".equals(map.get("enableEmergencyLock"));
            l.getInstance().setEnableCache(zEquals);
            w.getInstance().putBoolean("is_enable_cache_key", zEquals);
        }
        if (z) {
            a.getInstance().startNotification(c.e.a.a.b.getInstance().getContext(), msgVo);
        }
    }

    @Override // com.alibaba.sdk.android.push.MessageReceiver
    public void onMessage(Context context, CPushMessage cPushMessage) {
        String jSONString = JSON.toJSONString(cPushMessage);
        c(context, cPushMessage.getTitle(), cPushMessage.getContent(), null);
        q.d(PushReceive.class.getSimpleName(), "cPushMessage:" + jSONString);
    }

    @Override // com.alibaba.sdk.android.push.MessageReceiver
    public void onNotification(Context context, String str, String str2, Map<String, String> map) {
        q.d(PushReceive.class.getSimpleName(), "通知接收到的消息: title:" + str + ",summary: " + str2 + "，extraMap:" + JSON.toJSONString(map));
        c(context, str, str2, map);
    }

    @Override // com.alibaba.sdk.android.push.MessageReceiver
    public void onNotificationClickedWithNoAction(Context context, String str, String str2, String str3) {
    }

    @Override // com.alibaba.sdk.android.push.MessageReceiver
    public void onNotificationOpened(Context context, String str, String str2, String str3) {
    }

    @Override // com.alibaba.sdk.android.push.MessageReceiver
    public void onNotificationReceivedInApp(Context context, String str, String str2, Map<String, String> map, int i2, String str3, String str4) {
    }

    @Override // com.alibaba.sdk.android.push.MessageReceiver
    public void onNotificationRemoved(Context context, String str) {
    }
}

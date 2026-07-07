package com.alibaba.sdk.android.push.popup;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.agoo.BaseNotifyClick;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PopupNotifyClick extends BaseNotifyClick {
    public static final String TAG = "PopupNotifyClick";
    private PopupNotifyClickListener listener;

    public PopupNotifyClick(PopupNotifyClickListener popupNotifyClickListener) {
        this.listener = popupNotifyClickListener;
    }

    @Override // com.taobao.agoo.BaseNotifyClick
    public void onMessage(Intent intent) {
        if (intent == null) {
            ALog.e(TAG, "intent null, return", new Object[0]);
            return;
        }
        String stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_BODY);
        if (stringExtra != null) {
            ALog.i(TAG, "Receive notification, body: " + stringExtra, new Object[0]);
            try {
                Map<String, String> map = JsonUtility.toMap(new JSONObject(stringExtra));
                String str = map.get("title");
                String str2 = map.get("content");
                String str3 = map.get("msg_id");
                int iIntValue = new Integer(map.get("type")).intValue();
                if (1 == iIntValue) {
                    Map<String, String> map2 = JsonUtility.toMap(new JSONObject(map.get("ext")));
                    map2.put(AgooConstants.MESSAGE_BODY_MSG_ID_ALIYUN_FLAG, str3);
                    PopupNotifyClickListener popupNotifyClickListener = this.listener;
                    if (popupNotifyClickListener != null) {
                        popupNotifyClickListener.onSysNoticeOpened(str, str2, map2);
                    } else {
                        ALog.e(TAG, "PopupNotifyClickListener is null", new Object[0]);
                    }
                } else if (2 == iIntValue) {
                    HashMap map3 = new HashMap();
                    map3.put(AgooConstants.MESSAGE_BODY_MSG_ID_ALIYUN_FLAG, str3);
                    PopupNotifyClickListener popupNotifyClickListener2 = this.listener;
                    if (popupNotifyClickListener2 != null) {
                        popupNotifyClickListener2.onSysNoticeOpened(str, str2, map3);
                    } else {
                        ALog.e(TAG, "PopupNotifyClickListener is null", new Object[0]);
                    }
                }
            } catch (JSONException e2) {
                ALog.e(TAG, "Parse json error, " + e2, new Object[0]);
            }
        }
    }

    @Override // com.taobao.agoo.BaseNotifyClick
    public void onNotPushData(Intent intent) {
        PopupNotifyClickListener popupNotifyClickListener = this.listener;
        if (popupNotifyClickListener instanceof OnPushParseFailedListener) {
            ((OnPushParseFailedListener) popupNotifyClickListener).onNotPushData(intent);
        }
    }

    @Override // com.taobao.agoo.BaseNotifyClick
    public void onParseFailed(Intent intent) {
        PopupNotifyClickListener popupNotifyClickListener = this.listener;
        if (popupNotifyClickListener instanceof OnPushParseFailedListener) {
            ((OnPushParseFailedListener) popupNotifyClickListener).onParseFailed(intent);
        }
    }
}

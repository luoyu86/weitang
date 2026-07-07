package com.alibaba.sdk.android.push.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class VivoMsgParseImpl implements BaseNotifyClickActivity.INotifyListener {
    public static final String TAG = "MPS:VivoMsgParseImpl";
    private Context context;

    private String fixVivoMsg(String str, Intent intent) {
        Context context;
        ALog.i(TAG, "fixVivoMsg intent:" + printBundle(intent.getExtras(), 1), new Object[0]);
        if (str == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (!jSONObject.has("p") && (context = this.context) != null) {
                        jSONObject.put("p", context.getPackageName());
                    }
                    if (!jSONObject.has("ext")) {
                        jSONObject.put("ext", intent.getStringExtra("ext"));
                    }
                    if (!jSONObject.has(OperatorName.CLOSE_FILL_NON_ZERO_AND_STROKE)) {
                        jSONObject.put(OperatorName.CLOSE_FILL_NON_ZERO_AND_STROKE, intent.getStringExtra(OperatorName.CLOSE_FILL_NON_ZERO_AND_STROKE));
                    }
                    if (!jSONObject.has(OperatorName.FILL_NON_ZERO)) {
                        jSONObject.put(OperatorName.FILL_NON_ZERO, intent.getLongExtra(OperatorName.FILL_NON_ZERO, 0L));
                    }
                    if (!jSONObject.has(OperatorName.SET_FLATNESS)) {
                        jSONObject.put(OperatorName.SET_FLATNESS, intent.getStringExtra(OperatorName.SET_FLATNESS));
                    }
                    jSONArray.put(i2, jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return jSONArray.toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    private static final String printBundle(Bundle bundle, int i2) {
        StringBuilder sb = new StringBuilder();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                for (int i3 = 0; i3 < i2; i3++) {
                    sb.append('\t');
                }
                if (obj instanceof String) {
                    sb.append("String\t");
                    sb.append(str);
                    sb.append('\t');
                    sb.append(obj);
                    sb.append('\n');
                } else if (obj instanceof Integer) {
                    sb.append("int\t");
                    sb.append(str);
                    sb.append('\t');
                    sb.append(obj);
                    sb.append('\n');
                } else if (obj instanceof Long) {
                    sb.append("long\t");
                    sb.append(str);
                    sb.append('\t');
                    sb.append(obj);
                    sb.append('\n');
                } else if (obj instanceof Boolean) {
                    sb.append("boolean\t");
                    sb.append(str);
                    sb.append('\t');
                    sb.append(obj);
                    sb.append('\n');
                } else if (obj instanceof Bundle) {
                    sb.append("Bundle\t");
                    sb.append(str);
                    sb.append('\t');
                    sb.append('\n');
                    sb.append(printBundle((Bundle) obj, i2 + 1));
                } else {
                    sb.append("unknown\t");
                    sb.append(str);
                    sb.append('\t');
                    sb.append(obj);
                    sb.append('\n');
                }
            }
        }
        return sb.toString();
    }

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String getMsgSource() {
        return AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO;
    }

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String parseMsgFromIntent(Intent intent) {
        String strFixVivoMsg = null;
        if (intent == null) {
            ALog.e(TAG, "parseMsgFromIntent null", new Object[0]);
            return null;
        }
        try {
            String stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_VIVO_PAYLOAD);
            ALog.i(TAG, "parseMsgFromIntent msg:" + stringExtra, new Object[0]);
            strFixVivoMsg = fixVivoMsg(stringExtra, intent);
            ALog.i(TAG, "after fixup msg:" + strFixVivoMsg, new Object[0]);
            return strFixVivoMsg;
        } catch (Throwable th) {
            ALog.e(TAG, "parseMsgFromIntent ", th, new Object[0]);
            return strFixVivoMsg;
        }
    }

    public void setContext(Context context) {
        this.context = context.getApplicationContext();
    }
}

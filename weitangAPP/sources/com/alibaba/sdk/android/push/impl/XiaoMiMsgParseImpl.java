package com.alibaba.sdk.android.push.impl;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class XiaoMiMsgParseImpl implements BaseNotifyClickActivity.INotifyListener {
    private static final String TAG = "MPS:MiPushRegistar";

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String getMsgSource() {
        return AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI;
    }

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String parseMsgFromIntent(Intent intent) {
        String content;
        try {
            content = intent.getSerializableExtra("key_message").getContent();
        } catch (Exception unused) {
            content = null;
        }
        ALog.i(TAG, "parseMsgFromIntent msg:" + content, new Object[0]);
        return content;
    }

    public String toString() {
        return "INotifyListener: " + getMsgSource();
    }
}

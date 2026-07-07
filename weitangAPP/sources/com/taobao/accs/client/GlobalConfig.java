package com.taobao.accs.client;

import android.content.Context;
import com.taobao.accs.ChannelService;
import com.taobao.accs.IProcessName;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class GlobalConfig {
    public static boolean enableCookie = true;

    public static void setChannelProcessName(String str) {
        AdapterGlobalClientInfo.mChannelProcessName = str;
    }

    public static void setControlFrameMaxRetry(int i2) {
        Message.f10264a = i2;
    }

    public static void setCurrProcessNameImpl(IProcessName iProcessName) {
        AdapterGlobalClientInfo.mProcessNameImpl = iProcessName;
    }

    public static void setEnableForeground(Context context, boolean z) {
        ALog.i("GlobalConfig", "setEnableForeground", "enable", Boolean.valueOf(z));
        OrangeAdapter.saveConfigToSP(context, ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, z ? 24 : 0);
    }

    public static void setMainProcessName(String str) {
        AdapterGlobalClientInfo.mMainProcessName = str;
    }
}

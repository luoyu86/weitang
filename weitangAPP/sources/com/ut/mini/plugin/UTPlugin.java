package com.ut.mini.plugin;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UTPlugin {
    public static final int MSG_ID_IN_DISPATCH_AGGREGATION_LOG_MAP = 5;
    public static final int MSG_ID_IN_DISPATCH_LOG_STRING_4_UTPERF_PLUGIN = 9;
    public static final int MSG_ID_IN_NOMATCH_ONLINE_CONF = 7;
    public static final int MSG_ID_IN_SWITCH_BACKGROUND = 2;
    public static final int MSG_ID_IN_SWITCH_FOREGROUND = 8;
    public static final int MSG_ID_OUT_AGGREGATED_LOG_MAP = 65536;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UTPluginContext f12367a = null;

    public void a(UTPluginContext uTPluginContext) {
        this.f12367a = uTPluginContext;
    }

    public final void deliverMsgToSDK(int i2, Object obj) {
        UTPluginMgr.getInstance().dispatchPluginMsg(i2, obj);
    }

    public final UTPluginContext getPluginContext() {
        return this.f12367a;
    }

    public void onPluginContextValueUpdate(int i2) {
    }

    public abstract void onPluginMsgArrivedFromSDK(int i2, Object obj);

    public void onRegistered() {
    }

    public void onUnRegistered() {
    }

    public abstract int[] returnRequiredMsgIds();

    public String[] returnRequiredOnlineConfNames() {
        return null;
    }
}

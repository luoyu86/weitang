package com.bytedance.pangle.receiver;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
public abstract class PluginBroadcastReceiver {
    public abstract void onReceive(Context context, Intent intent);
}

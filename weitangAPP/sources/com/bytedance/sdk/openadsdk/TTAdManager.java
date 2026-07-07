package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;

/* JADX INFO: loaded from: classes.dex */
public interface TTAdManager {

    public interface OnExitInstallListener {
        void onExitInstall();
    }

    TTAdNative createAdNative(Context context);

    String getBiddingToken(AdSlot adSlot);

    String getBiddingToken(AdSlot adSlot, boolean z, int i2);

    <T> T getExtra(Class<T> cls, Bundle bundle);

    String getPluginVersion();

    String getSDKVersion();

    int getThemeStatus();

    void register(Object obj);

    void requestPermissionIfNecessary(Context context);

    void setThemeStatus(int i2);

    boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener);

    void unregister(Object obj);
}

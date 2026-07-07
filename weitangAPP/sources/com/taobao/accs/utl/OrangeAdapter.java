package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class OrangeAdapter {
    public static final String NAMESPACE = "accs";
    private static final String TAG = "OrangeAdapter";
    private static final String TNET_LOG_KEY = "tnet_log_off";
    public static final boolean mOrangeValid = false;

    public static String getConfig(String str, String str2, String str3) {
        return str3;
    }

    private static boolean getConfigFromSP(Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getBoolean(str, z);
        } catch (Exception e2) {
            ALog.e(TAG, "getConfigFromSP fail:", e2, "key", str);
            return z;
        }
    }

    public static boolean isBindService(Context context) {
        boolean configFromSP;
        try {
            configFromSP = getConfigFromSP(context, Constants.SP_KEY_BIND_SERVICE_ENABLE, true);
        } catch (Throwable th) {
            ALog.e(TAG, "isBindService", th, new Object[0]);
            configFromSP = true;
        }
        ALog.d(TAG, "isBindService", "result", Boolean.valueOf(configFromSP));
        return configFromSP;
    }

    public static boolean isSmartHb() {
        boolean configFromSP;
        try {
            configFromSP = getConfigFromSP(GlobalClientInfo.getContext(), Constants.SP_KEY_HB_SMART_ENABLE, true);
        } catch (Throwable th) {
            ALog.e(TAG, "isSmartHb", th, new Object[0]);
            configFromSP = true;
        }
        ALog.d(TAG, "isSmartHb", "result", Boolean.valueOf(configFromSP));
        return configFromSP;
    }

    public static boolean isTnetLogOff(boolean z) {
        boolean z2;
        String config;
        boolean zBooleanValue;
        if (z) {
            try {
                config = getConfig("accs", "tnet_log_off", AccsClientConfig.DEFAULT_CONFIG_TAG);
            } catch (Throwable th) {
                th = th;
                z2 = true;
                ALog.e(TAG, "isTnetLogOff", th, new Object[0]);
                zBooleanValue = z2;
                ALog.i(TAG, "isTnetLogOff", "result", Boolean.valueOf(zBooleanValue));
                return zBooleanValue;
            }
        } else {
            config = AccsClientConfig.DEFAULT_CONFIG_TAG;
        }
        if (config.equals(AccsClientConfig.DEFAULT_CONFIG_TAG)) {
            zBooleanValue = getConfigFromSP(GlobalClientInfo.getContext(), "tnet_log_off", true);
        } else {
            zBooleanValue = Boolean.valueOf(config).booleanValue();
            try {
                saveConfigToSP(GlobalClientInfo.getContext(), "tnet_log_off", zBooleanValue);
            } catch (Throwable th2) {
                z2 = zBooleanValue;
                th = th2;
                ALog.e(TAG, "isTnetLogOff", th, new Object[0]);
                zBooleanValue = z2;
            }
        }
        ALog.i(TAG, "isTnetLogOff", "result", Boolean.valueOf(zBooleanValue));
        return zBooleanValue;
    }

    private static void saveConfigToSP(Context context, String str, boolean z) {
        try {
        } catch (Exception e2) {
            ALog.e(TAG, "saveConfigToSP fail:", e2, "key", str, com.alipay.sdk.m.p0.b.f5579d, Boolean.valueOf(z));
        }
        if (context == null) {
            ALog.e(TAG, "saveTLogOffToSP context null", new Object[0]);
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
        ALog.i(TAG, "saveConfigToSP", "key", str, com.alipay.sdk.m.p0.b.f5579d, Boolean.valueOf(z));
    }

    public static void saveConfigToSP(Context context, String str, int i2) {
        try {
        } catch (Exception e2) {
            ALog.e(TAG, "saveConfigToSP fail:", e2, "key", str, com.alipay.sdk.m.p0.b.f5579d, Integer.valueOf(i2));
        }
        if (context == null) {
            ALog.e(TAG, "saveTLogOffToSP context null", new Object[0]);
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        editorEdit.putInt(str, i2);
        editorEdit.apply();
        ALog.i(TAG, "saveConfigToSP", "key", str, com.alipay.sdk.m.p0.b.f5579d, Integer.valueOf(i2));
    }
}

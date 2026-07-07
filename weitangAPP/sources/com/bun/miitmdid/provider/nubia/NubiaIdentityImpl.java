package com.bun.miitmdid.provider.nubia;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.bun.miitmdid.j0;
import com.taobao.accs.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public class NubiaIdentityImpl {
    private static final String TAG = "NubiaIdentityImpl";
    private static Uri uri = Uri.parse("content://cn.nubia.identity/identity");

    private static Object generalMethod(Context context, String str, @Nullable String str2, String str3, Class<?> cls) {
        Bundle bundleCall;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 17) {
                ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
                if (contentProviderClientAcquireContentProviderClient == null) {
                    j0.d(TAG, "generalMethod: contentResolver is null");
                    return null;
                }
                bundleCall = contentProviderClientAcquireContentProviderClient.call(str, str2, null);
                if (i2 >= 24) {
                    contentProviderClientAcquireContentProviderClient.close();
                } else {
                    contentProviderClientAcquireContentProviderClient.release();
                }
            } else {
                bundleCall = context.getContentResolver().call(uri, str, str2, (Bundle) null);
            }
            if (bundleCall == null) {
                j0.d(TAG, "generalMethod: bundle is null");
                return null;
            }
            if (bundleCall.getInt("code", -1) == 0) {
                j0.c(TAG, "generalMethod: success");
                if (cls == Boolean.class) {
                    return Boolean.valueOf(bundleCall.getBoolean(str3, false));
                }
                if (cls == String.class) {
                    return bundleCall.getString(str3, "");
                }
                return null;
            }
            j0.d(TAG, "generalMethod: failed:" + bundleCall.getString(Constants.SHARED_MESSAGE_ID_FILE));
            return null;
        } catch (Exception e2) {
            j0.d(TAG, "generalMethod: Exception: " + e2.getMessage());
            return null;
        }
    }

    public static String getAAID(Context context, String str) {
        Object objGeneralMethod = generalMethod(context, "getAAID", str, "id", String.class);
        return objGeneralMethod == null ? "" : (String) objGeneralMethod;
    }

    public static String getOAID(Context context) {
        Object objGeneralMethod = generalMethod(context, "getOAID", null, "id", String.class);
        return objGeneralMethod == null ? "" : (String) objGeneralMethod;
    }

    public static String getVAID(Context context, String str) {
        Object objGeneralMethod = generalMethod(context, "getVAID", str, "id", String.class);
        return objGeneralMethod == null ? "" : (String) objGeneralMethod;
    }

    public static boolean isSupported(Context context) {
        Object objGeneralMethod = generalMethod(context, "isSupport", null, "issupport", Boolean.class);
        if (objGeneralMethod == null) {
            return false;
        }
        return ((Boolean) objGeneralMethod).booleanValue();
    }
}

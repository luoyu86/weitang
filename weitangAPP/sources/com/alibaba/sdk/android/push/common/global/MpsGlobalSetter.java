package com.alibaba.sdk.android.push.common.global;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class MpsGlobalSetter {
    public static synchronized void setDebug(boolean z) {
        b.f4873g = z;
    }

    public static synchronized void setMessageIntentService(Class<?> cls) {
        if (cls != null) {
            b.f4869c = cls;
        }
    }

    public static synchronized void setNotificationId(int i2) {
        b.f4872f = i2;
    }

    public static synchronized void setNotificationIntentRequestCode(int i2) {
        b.f4871e = i2;
    }

    public static synchronized void setNotificationLargeIconBitmap(Bitmap bitmap) {
        b.f4868b = bitmap;
    }

    public static synchronized void setNotificationSmallIconId(int i2) {
        b.f4870d = i2;
    }

    public static synchronized void setNotificationSoundPath(String str) {
        if (str != null) {
            if (str.length() > 0) {
                b.f4867a = str;
            }
        }
    }
}

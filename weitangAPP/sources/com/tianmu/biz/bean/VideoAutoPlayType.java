package com.tianmu.biz.bean;

import android.content.Context;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.utils.a0;

/* JADX INFO: loaded from: classes2.dex */
public class VideoAutoPlayType {
    public static int AUTO_PLAY = 1;
    public static int DEFAULT_PLAY = 0;
    public static int NO_AUTO_PLAY = -1;

    public static boolean isNativeAutoPlayVideo() {
        Context context = TianmuSDK.getInstance().getContext();
        if (context == null) {
            return false;
        }
        String strA = a0.a(context);
        strA.hashCode();
        switch (strA) {
        }
        return false;
    }
}

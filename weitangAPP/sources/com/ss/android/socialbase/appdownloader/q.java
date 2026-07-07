package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import com.alibaba.sdk.android.push.notification.CustomNotificationBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    public static int a(String str) {
        return ok(com.ss.android.socialbase.downloader.downloader.bl.l(), str);
    }

    public static int bl(String str) {
        try {
            return ok(str, com.ss.android.socialbase.downloader.downloader.bl.l().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int kf(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.bl.l().getResources().getIdentifier(str, "color", com.ss.android.socialbase.downloader.downloader.bl.l().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int n(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.bl.l().getResources().getIdentifier(str, "id", com.ss.android.socialbase.downloader.downloader.bl.l().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int ok(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.bl.l().getResources().getIdentifier(str, "layout", com.ss.android.socialbase.downloader.downloader.bl.l().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int s(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.bl.l().getResources().getIdentifier(str, "style", com.ss.android.socialbase.downloader.downloader.bl.l().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int a(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.bl.l().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int ok(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int ok(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.bl.l().getResources().getIdentifier(str, CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}

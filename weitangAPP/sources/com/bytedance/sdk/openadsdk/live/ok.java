package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.openliveplugin.LivePluginHelper;

/* JADX INFO: loaded from: classes.dex */
public class ok {
    public static boolean ok(Context context, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback, boolean z) {
        try {
            LivePluginHelper.initLive((Application) context, str, builder, iLiveInitCallback, z);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean ok() {
        try {
            com.bytedance.sdk.openadsdk.n.ok.ok().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.live.ok.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LivePluginHelper.initLiveCommerce();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean ok(Context context, Bundle bundle) {
        if (context != null && bundle != null && bundle.containsKey(TTLiveConstants.ROOMID_KEY)) {
            long j = bundle.getLong(TTLiveConstants.ROOMID_KEY);
            try {
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                if (liveRoomService == null) {
                    return false;
                }
                liveRoomService.enterLiveRoom(context, j, bundle);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean ok(Context context, Uri uri) {
        if (context != null && uri != null) {
            try {
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                if (liveRoomService != null) {
                    return liveRoomService.handleSchema(context, uri);
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }
}

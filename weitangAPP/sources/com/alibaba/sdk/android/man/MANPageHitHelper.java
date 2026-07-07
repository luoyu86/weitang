package com.alibaba.sdk.android.man;

import android.app.Activity;
import com.alibaba.sdk.android.man.util.MANLog;
import com.alibaba.sdk.android.man.util.UTWrapper;
import com.ut.mini.UTPageHitHelper;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MANPageHitHelper {
    private static final String TAG = MANTracker.class.getSimpleName();
    private volatile boolean isEnabled;

    public static class Singleton {
        public static MANPageHitHelper instance = new MANPageHitHelper();

        private Singleton() {
        }
    }

    public static MANPageHitHelper getInstance() {
        return Singleton.instance;
    }

    public void pageAppear(Activity activity) {
        if (!this.isEnabled) {
            MANLog.Loge(TAG, "MAN init failed,can not work for now!");
        } else {
            UTPageHitHelper.getInstance().pageAppear(activity);
            UTWrapper.commitPageEvent("1");
        }
    }

    public void pageDisAppear(Activity activity) {
        if (!this.isEnabled) {
            MANLog.Loge(TAG, "MAN init failed,can not work for now!");
        } else {
            UTPageHitHelper.getInstance().pageDisAppear(activity);
            UTWrapper.commitPageEvent("1");
        }
    }

    public void setEnableStatus(boolean z) {
        this.isEnabled = z;
    }

    public void updatePageProperties(Map<String, String> map) {
        if (!this.isEnabled) {
            MANLog.Loge(TAG, "MAN init failed,can not work for now!");
        } else {
            UTPageHitHelper.getInstance().updatePageProperties(map);
            UTWrapper.commitPageEvent("1");
        }
    }

    private MANPageHitHelper() {
        this.isEnabled = true;
    }
}

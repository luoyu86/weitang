package com.alibaba.sdk.android.man;

import android.util.Log;
import com.alibaba.sdk.android.man.customperf.MANCustomPerformance;
import com.alibaba.sdk.android.man.network.NetworkEvent;
import com.alibaba.sdk.android.man.util.EventCommitTool;
import com.alibaba.sdk.android.man.util.MANLog;
import com.alibaba.sdk.android.man.util.UTWrapper;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTTracker;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MANTracker {
    private static final String TAG = "MANTracker";
    public String appKey;
    private volatile boolean isEnabled;

    public static class Singleton {
        public static MANTracker instance = new MANTracker();

        private Singleton() {
        }
    }

    public static MANTracker getInstance() {
        return Singleton.instance;
    }

    private UTTracker getTrackerFromUt() {
        UTTracker trackerByAppkey = UTAnalytics.getInstance().getTrackerByAppkey(this.appKey);
        if (trackerByAppkey == null) {
            Log.e("MAN", "请先初始化MAN");
        }
        return trackerByAppkey;
    }

    public void send(Map<String, String> map) {
        if (!this.isEnabled) {
            MANLog.Loge(TAG, "MAN init failed,can not work for now!");
            return;
        }
        UTTracker trackerFromUt = getTrackerFromUt();
        if (trackerFromUt == null) {
            return;
        }
        trackerFromUt.send(map);
        UTWrapper.commitCustomEvent();
    }

    public void setEnableStatus(boolean z) {
        this.isEnabled = z;
    }

    private MANTracker() {
        this.isEnabled = true;
    }

    public void send(MANCustomPerformance mANCustomPerformance) {
        if (!this.isEnabled) {
            MANLog.Loge(TAG, "MAN init failed,can not work for now!");
        } else {
            EventCommitTool.commitCustomPerformanceEvent(mANCustomPerformance);
            UTWrapper.commitPerfEvent("3");
        }
    }

    public void send(NetworkEvent networkEvent) {
        if (!this.isEnabled) {
            MANLog.Loge(TAG, "MAN init failed,can not work for now!");
        } else if (networkEvent != null) {
            networkEvent.reportNetworkInfo();
            UTWrapper.commitPerfEvent(networkEvent.isAdvancedStat() ? "2" : "1");
        }
    }
}

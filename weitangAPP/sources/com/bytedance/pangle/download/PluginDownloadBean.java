package com.bytedance.pangle.download;

import androidx.annotation.Keep;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class PluginDownloadBean {
    public List<String> mBackupUrlList;
    public int mFlag;
    public long mFollowId;
    public String mMd5;
    public String mPackageName;
    public String mUrl;
    public int mVersionCode;
    public int mApiVersionMin = 0;
    public int mApiVersionMax = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    public boolean isRevert() {
        return this.mFlag == 3;
    }

    public boolean isUnInstall() {
        return this.mFlag == 1;
    }
}

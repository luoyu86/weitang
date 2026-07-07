package com.chinavisionary.core.app.event;

import android.app.Activity;
import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class EventPageAppearBo extends BaseVo {
    private Activity activity;
    private boolean isPageDisAppear;
    private String pageName;

    public Activity getActivity() {
        return this.activity;
    }

    public String getPageName() {
        return this.pageName;
    }

    public boolean isPageDisAppear() {
        return this.isPageDisAppear;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setPageDisAppear(boolean z) {
        this.isPageDisAppear = z;
    }

    public void setPageName(String str) {
        this.pageName = str;
    }
}

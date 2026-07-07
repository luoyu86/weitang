package com.tianmu.biz.dr;

import android.view.View;
import com.tianmu.ad.base.BaseAdTouchView;

/* JADX INFO: loaded from: classes2.dex */
public interface IUnifiedAd {
    int getRefreshState(BaseAdTouchView baseAdTouchView);

    void init();

    View registerAdListener(String str, String str2, String str3, View view, boolean z);
}

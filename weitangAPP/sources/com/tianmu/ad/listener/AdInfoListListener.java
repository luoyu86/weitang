package com.tianmu.ad.listener;

import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.base.BaseAdListener;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface AdInfoListListener<T extends BaseAdInfo> extends BaseAdListener<T> {
    void onAdReceive(List<T> list);
}

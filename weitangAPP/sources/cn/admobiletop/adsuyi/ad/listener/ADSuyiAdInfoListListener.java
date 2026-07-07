package cn.admobiletop.adsuyi.ad.listener;

import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiAdInfoListListener<T extends ADSuyiAdInfo> extends ADSuyiAdListener<T> {
    void onAdReceive(List<T> list);
}

package cn.admobiletop.adsuyi.ad.listener;

import cn.admobiletop.adsuyi.ad.data.ADSuyiDrawVodAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiDrawVodAdListener extends ADSuyiAdInfoListListener<ADSuyiDrawVodAdInfo> {
    void onRenderFailed(ADSuyiDrawVodAdInfo aDSuyiDrawVodAdInfo, ADSuyiError aDSuyiError);
}

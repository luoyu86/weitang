package cn.admobiletop.adsuyi.ad;

import android.content.Context;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.a.b.u;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdType;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;

/* JADX INFO: loaded from: classes.dex */
public final class ADSuyiInnerNoticeAd extends u<ADSuyiInnerNoticeAdListener> {
    public ADSuyiInnerNoticeAd(@NonNull Context context) {
        super(context);
        setTimeout(10000L);
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public String getAdType() {
        return ADSuyiAdType.TYPE_INNER_NOTICE;
    }
}

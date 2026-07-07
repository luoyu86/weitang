package cn.admobiletop.adsuyi.ad;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import cn.admobiletop.adsuyi.a.b.u;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdType;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodAdListener;

/* JADX INFO: loaded from: classes.dex */
public final class ADSuyiDrawVodAd extends u<ADSuyiDrawVodAdListener> {
    public ADSuyiExtraParams m;

    public ADSuyiDrawVodAd(@NonNull Activity activity) {
        super(activity);
        setTimeout(60000L);
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public String getAdType() {
        return ADSuyiAdType.TYPE_DRAW_VOD;
    }

    public ADSuyiExtraParams getLocalExtraParams() {
        return this.m;
    }

    public void setLocalExtraParams(ADSuyiExtraParams aDSuyiExtraParams) {
        this.m = aDSuyiExtraParams;
    }

    public ADSuyiDrawVodAd(@NonNull Fragment fragment) {
        super(fragment);
        setTimeout(60000L);
    }
}

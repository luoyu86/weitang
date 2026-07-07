package cn.admobiletop.adsuyi.adapter.tianmu.a;

import android.app.Activity;
import cn.admobiletop.adsuyi.ad.data.ADSuyiRewardVodAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;
import com.tianmu.ad.bean.RewardAdInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h extends a<ADSuyiRewardVodAdListener, RewardAdInfo> implements ADSuyiRewardVodAdInfo {
    public boolean k;

    public h(String str) {
        super(str);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiRewardVodAdInfo
    public Map<String, Object> getRewardMap() {
        return new HashMap();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasExpired() {
        return getAdapterAdInfo().isOvertime();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasShown() {
        return this.k;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean isReady() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.adapter.tianmu.a.a, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        setAdapterAdInfo(null);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiRewardVodAdInfo
    public void showRewardVod(Activity activity) {
        if (activity == null || isReleased() || !isReady() || getAdapterAdInfo() == null || hasShown() || hasExpired()) {
            return;
        }
        getAdapterAdInfo().showRewardAd(activity);
        this.k = true;
    }
}

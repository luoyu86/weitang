package cn.admobiletop.adsuyi.adapter.gdt.a;

import android.app.Activity;
import cn.admobiletop.adsuyi.ad.data.ADSuyiRewardVodAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k extends b<ADSuyiRewardVodAdListener, RewardVideoAD> implements ADSuyiRewardVodAdInfo {
    public Map<String, Object> k;

    public k(String str) {
        super(str);
    }

    public void a(Map<String, Object> map) {
        this.k = map;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiRewardVodAdInfo
    public Map<String, Object> getRewardMap() {
        if (this.k == null) {
            this.k = new HashMap();
        }
        return this.k;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasExpired() {
        return getAdapterAdInfo() == null || !getAdapterAdInfo().isValid();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasShown() {
        return getAdapterAdInfo() == null || getAdapterAdInfo().hasShown();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean isReady() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.a.b, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        setAdapterAdInfo((RewardVideoAD) null);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiRewardVodAdInfo
    public void showRewardVod(Activity activity) {
        if (activity == null || isReleased() || !isReady() || getAdapterAdInfo() == null || hasShown() || hasExpired()) {
            return;
        }
        getAdapterAdInfo().showAD();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(RewardVideoAD rewardVideoAD) {
        super.setAdapterAdInfo(rewardVideoAD);
        if (rewardVideoAD == null || !cn.admobiletop.adsuyi.adapter.gdt.c.c.a()) {
            return;
        }
        rewardVideoAD.setDownloadConfirmListener(cn.admobiletop.adsuyi.adapter.gdt.c.c.f3681b);
    }
}

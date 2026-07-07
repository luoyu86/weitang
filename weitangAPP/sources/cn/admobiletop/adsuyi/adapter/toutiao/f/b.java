package cn.admobiletop.adsuyi.adapter.toutiao.f;

import android.view.View;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.ADSuyiBannerAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiAdSize;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiBannerAdContainer;
import cn.admobiletop.adsuyi.adapter.toutiao.ADSuyiIniter;
import cn.admobiletop.adsuyi.adapter.toutiao.b.C0312q;
import cn.admobiletop.adsuyi.adapter.toutiao.c.d;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;

/* JADX INFO: loaded from: classes.dex */
public class b extends ADSuyiBannerAdContainer {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ADSuyiBannerAd f4067i;
    public ADSuyiAdapterParams j;
    public ADSuyiBannerAdListener k;
    public C0312q l;
    public a m;

    public interface a {
        void a();

        void a(View view);
    }

    public b(ADSuyiBannerAd aDSuyiBannerAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiBannerAdListener aDSuyiBannerAdListener, ADSuyiAdSize aDSuyiAdSize) {
        super(aDSuyiBannerAd.getActivity(), 15000L, aDSuyiAdSize);
        this.m = new cn.admobiletop.adsuyi.adapter.toutiao.f.a(this);
        this.f4067i = aDSuyiBannerAd;
        this.j = aDSuyiAdapterParams;
        this.k = aDSuyiBannerAdListener;
        onRefresh();
    }

    public void d() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        f();
        if (ADSuyiAdUtil.isReleased(this.f4067i) || this.f4067i.getContainer() == null || (aDSuyiAdapterParams = this.j) == null || aDSuyiAdapterParams.getPlatformPosId() == null || this.k == null) {
            return;
        }
        ADSuyiPlatformPosId platformPosId = this.j.getPlatformPosId();
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config != null && config.isFilterThirdQuestion() && cn.admobiletop.adsuyi.adapter.toutiao.e.a.a()) {
            this.k.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "过滤Banner广告，经过测试头条的模板广告在安卓5.1及以下版本的手机上可能存在兼容性问题"));
            return;
        }
        TTAdNative tTAdNativeA = d.a().a(this.f4067i.getActivity());
        if (tTAdNativeA == null) {
            this.k.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "头条SDK createNative失败，可能初始化失败或初始化数据有误"));
            return;
        }
        ADSuyiAdSize aDSuyiAdSize = platformPosId.getAdSize() == null ? new ADSuyiAdSize(640, 100) : platformPosId.getAdSize();
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(platformPosId.getPlatformPosId()).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize((int) (this.f4067i.getContainer().getWidth() / ADSuyiSdk.getInstance().getInitiallyDensity()), (aDSuyiAdSize.getHeight() * r3) / aDSuyiAdSize.getWidth()).setImageAcceptedSize(aDSuyiAdSize.getWidth(), aDSuyiAdSize.getHeight()).build();
        C0312q c0312q = new C0312q(this.f4067i, platformPosId.getPlatformPosId(), this.k, this.m, this);
        this.l = c0312q;
        tTAdNativeA.loadBannerExpressAd(adSlotBuild, c0312q);
    }

    public final void f() {
        C0312q c0312q = this.l;
        if (c0312q != null) {
            c0312q.release();
            this.l = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.widget.ADSuyiBannerAdContainer
    public void onRefresh() {
        d();
    }

    @Override // cn.admobiletop.adsuyi.ad.widget.ADSuyiBannerAdContainer
    public void release() {
        super.release();
        f();
        C0312q c0312q = this.l;
        if (c0312q != null) {
            c0312q.release();
            this.l = null;
        }
    }
}

package cn.admobiletop.adsuyi.adapter.toutiao.loader;

import android.util.DisplayMetrics;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.ADSuyiRewardVodAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiRewardExtra;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.ADSuyiIniter;
import cn.admobiletop.adsuyi.adapter.toutiao.b.sa;
import cn.admobiletop.adsuyi.adapter.toutiao.c.d;
import cn.admobiletop.adsuyi.adapter.toutiao.d.b;
import cn.admobiletop.adsuyi.adapter.toutiao.d.c;
import cn.admobiletop.adsuyi.adapter.toutiao.e.a;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiParallelCallback;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiPreLoadParams;
import cn.admobiletop.adsuyi.parallel.interf.ParallelAdLoadController;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;

/* JADX INFO: loaded from: classes.dex */
public class RewardVodAdLoader implements ADSuyiAdapterLoader<ADSuyiRewardVodAd, ADSuyiRewardVodAdListener>, ParallelAdLoadController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiRewardVodAd f4083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiAdapterParams f4084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiRewardVodAdListener f4085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public sa f4086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f4087e;

    public final void a() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        String custom;
        ADSuyiRewardExtra rewardExtra;
        sa saVar;
        if (ADSuyiAdUtil.isReleased(this.f4083a) || (aDSuyiAdapterParams = this.f4084b) == null || aDSuyiAdapterParams.getPlatformPosId() == null || this.f4085c == null) {
            return;
        }
        if (this.f4087e != null && (saVar = this.f4086d) != null) {
            saVar.a();
            return;
        }
        ADSuyiPlatformPosId platformPosId = this.f4084b.getPlatformPosId();
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config != null && config.isFilterThirdQuestion() && a.a()) {
            this.f4085c.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatformPosId(), -1, "过滤Reward广告，经过测试头条的广告在安卓5.1及以下版本的手机上可能存在兼容性问题"));
            return;
        }
        TTAdNative tTAdNativeA = d.a().a(this.f4083a.getActivity());
        if (tTAdNativeA == null) {
            this.f4085c.onAdFailed(ADSuyiError.createErrorDesc(ADSuyiIniter.PLATFORM, platformPosId.getPlatform(), -1, "头条SDK createNative失败，可能初始化失败或初始化数据有误"));
            return;
        }
        ADSuyiExtraParams localExtraParams = this.f4083a.getLocalExtraParams();
        String userId = "";
        if (localExtraParams == null || (rewardExtra = localExtraParams.getRewardExtra()) == null) {
            custom = "";
        } else {
            userId = rewardExtra.getUserId();
            custom = rewardExtra.getCustom();
        }
        DisplayMetrics displayMetrics = this.f4083a.getActivity().getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        float f2 = displayMetrics.density;
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(platformPosId.getPlatformPosId()).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(i2 / f2, i3 / f2).setImageAcceptedSize(i2, i3).setUserID(userId).setMediaExtra(custom).setOrientation(2 != platformPosId.getScreenOrientation() ? 1 : 2).build();
        sa saVar2 = new sa(platformPosId.getPlatformPosId(), this.f4085c, this.f4087e);
        this.f4086d = saVar2;
        tTAdNativeA.loadRewardVideoAd(adSlotBuild, saVar2);
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
    }

    @Override // cn.admobiletop.adsuyi.parallel.interf.ParallelAdLoadController
    public void parallelLoad(ADSuyiPreLoadParams aDSuyiPreLoadParams, String str, ADSuyiParallelCallback aDSuyiParallelCallback) {
        if (aDSuyiPreLoadParams == null) {
            aDSuyiParallelCallback.onFailed(ADSuyiIniter.PLATFORM, "并行请求参数错误");
            return;
        }
        if (aDSuyiPreLoadParams.getSuyiAd() instanceof ADSuyiRewardVodAd) {
            this.f4083a = (ADSuyiRewardVodAd) aDSuyiPreLoadParams.getSuyiAd();
        }
        this.f4084b = aDSuyiPreLoadParams.getAdapterParams();
        if (aDSuyiPreLoadParams.getListener() instanceof ADSuyiRewardVodAdListener) {
            this.f4085c = (ADSuyiRewardVodAdListener) aDSuyiPreLoadParams.getListener();
        }
        this.f4087e = new b(aDSuyiParallelCallback);
        a();
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        sa saVar = this.f4086d;
        if (saVar != null) {
            saVar.release();
            this.f4086d = null;
        }
        c cVar = this.f4087e;
        if (cVar != null) {
            cVar.release();
            this.f4087e = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiRewardVodAd aDSuyiRewardVodAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiRewardVodAdListener aDSuyiRewardVodAdListener) {
        this.f4083a = aDSuyiRewardVodAd;
        this.f4084b = aDSuyiAdapterParams;
        this.f4085c = aDSuyiRewardVodAdListener;
        a();
    }
}

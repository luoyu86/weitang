package cn.admobiletop.adsuyi.adapter.gdt.loader;

import android.text.TextUtils;
import cn.admobiletop.adsuyi.ad.ADSuyiSplashAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiRewardExtra;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.adapter.gdt.b.p;
import cn.admobiletop.adsuyi.adapter.gdt.b.s;
import cn.admobiletop.adsuyi.adapter.gdt.b.v;
import cn.admobiletop.adsuyi.adapter.gdt.d.a;
import cn.admobiletop.adsuyi.adapter.gdt.d.b;
import cn.admobiletop.adsuyi.adapter.gdt.d.c;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.bid.ADSuyiBidParams;
import cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiParallelCallback;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiPreLoadParams;
import cn.admobiletop.adsuyi.parallel.interf.ParallelAdLoadController;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class SplashAdLoader implements ADSuyiAdapterLoader<ADSuyiSplashAd, ADSuyiSplashAdListener>, ADSuyiBidManager, ParallelAdLoadController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiSplashAd f3741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiAdapterParams f3742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiSplashAdListener f3743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public s f3744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v f3745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f3746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f3747g;

    public final void a() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        if (ADSuyiAdUtil.isReleased(this.f3741a) || this.f3741a.getContainer() == null || (aDSuyiAdapterParams = this.f3742b) == null || aDSuyiAdapterParams.getPlatform() == null || this.f3742b.getPlatformPosId() == null || this.f3743c == null) {
            return;
        }
        ADSuyiPlatformPosId platformPosId = this.f3742b.getPlatformPosId();
        if ("flow".equals(platformPosId.getAdType())) {
            c(this.f3741a, platformPosId, this.f3743c);
        } else if (4 == platformPosId.getRenderType()) {
            d(this.f3741a, this.f3742b, platformPosId, this.f3743c);
        } else if (1 == platformPosId.getRenderType()) {
            b(this.f3741a, this.f3742b, platformPosId, this.f3743c);
        }
    }

    public final void b(ADSuyiSplashAd aDSuyiSplashAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiPlatformPosId aDSuyiPlatformPosId, ADSuyiSplashAdListener aDSuyiSplashAdListener) {
        String custom;
        ADSuyiRewardExtra rewardExtra;
        s sVar;
        if (this.f3747g != null && (sVar = this.f3744d) != null) {
            sVar.a();
            return;
        }
        ADSuyiExtraParams localExtraParams = aDSuyiSplashAd.getLocalExtraParams();
        String userId = "";
        if (localExtraParams == null || (rewardExtra = localExtraParams.getRewardExtra()) == null) {
            custom = "";
        } else {
            userId = rewardExtra.getUserId();
            custom = rewardExtra.getCustom();
        }
        this.f3744d = new s(aDSuyiSplashAd, aDSuyiSplashAd.getContainer(), aDSuyiPlatformPosId.getPlatformPosId(), aDSuyiSplashAdListener, aDSuyiSplashAd.getSkipViewType(), this.f3747g);
        ADSuyiExtraParams localExtraParams2 = aDSuyiSplashAd.getLocalExtraParams();
        if (localExtraParams2 != null) {
            HashMap map = new HashMap();
            if (localExtraParams2.isAdShakeDisable()) {
                map.put("shakable", "0");
            } else {
                map.put("shakable", "1");
            }
            GlobalSetting.setExtraUserData(map);
        }
        SplashAD splashAD = new SplashAD(aDSuyiSplashAd.getActivity(), aDSuyiPlatformPosId.getPlatformPosId(), this.f3744d, (int) aDSuyiSplashAd.getPlatformTimeout(aDSuyiAdapterParams.getPosId()));
        if (!TextUtils.isEmpty(userId) || !TextUtils.isEmpty(custom)) {
            splashAD.setServerSideVerificationOptions(new ServerSideVerificationOptions.Builder().setUserId(userId).setCustomData(custom).build());
        }
        splashAD.setRewardListener(this.f3744d);
        this.f3744d.a(splashAD);
        splashAD.fetchAdOnly();
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void bid(ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback) {
        this.f3747g = new a(aDSuyiBidAdapterCallback);
        a();
    }

    public final void c(ADSuyiSplashAd aDSuyiSplashAd, ADSuyiPlatformPosId aDSuyiPlatformPosId, ADSuyiSplashAdListener aDSuyiSplashAdListener) {
        p pVar;
        if (this.f3747g != null && (pVar = this.f3746f) != null) {
            pVar.a();
            return;
        }
        this.f3746f = new p(aDSuyiSplashAd, aDSuyiSplashAd.getContainer(), aDSuyiPlatformPosId.getPlatformPosId(), aDSuyiSplashAdListener, this.f3747g);
        NativeExpressAD nativeExpressAD = new NativeExpressAD(aDSuyiSplashAd.getActivity(), new ADSize(-1, -2), aDSuyiPlatformPosId.getPlatformPosId(), this.f3746f);
        nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(0).setAutoPlayMuted(true).setDetailPageMuted(true).build());
        nativeExpressAD.loadAD(1);
    }

    public final void d(ADSuyiSplashAd aDSuyiSplashAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiPlatformPosId aDSuyiPlatformPosId, ADSuyiSplashAdListener aDSuyiSplashAdListener) {
        v vVar;
        if (this.f3747g != null && (vVar = this.f3745e) != null) {
            vVar.a();
            return;
        }
        this.f3745e = new v(aDSuyiSplashAd, aDSuyiSplashAd.getActivity(), aDSuyiSplashAd.getContainer(), aDSuyiPlatformPosId.getPlatformPosId(), aDSuyiSplashAdListener, this.f3747g);
        SplashAD splashAD = new SplashAD(aDSuyiSplashAd.getActivity(), aDSuyiPlatformPosId.getPlatformPosId(), this.f3745e, (int) aDSuyiSplashAd.getPlatformTimeout(aDSuyiAdapterParams.getPosId()));
        this.f3745e.a(splashAD);
        splashAD.fetchAdOnly();
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void init(ADSuyiPlatformPosId aDSuyiPlatformPosId, String str, ADSuyiBidParams aDSuyiBidParams) {
        if (aDSuyiBidParams != null) {
            if (aDSuyiBidParams.getSuyiAd() instanceof ADSuyiSplashAd) {
                this.f3741a = (ADSuyiSplashAd) aDSuyiBidParams.getSuyiAd();
            }
            this.f3742b = aDSuyiBidParams.getAdapterParams();
            if (aDSuyiBidParams.getListener() instanceof ADSuyiSplashAdListener) {
                this.f3743c = (ADSuyiSplashAdListener) aDSuyiBidParams.getListener();
            }
        }
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
            aDSuyiParallelCallback.onFailed("gdt", "并行请求参数错误");
            return;
        }
        if (aDSuyiPreLoadParams.getSuyiAd() instanceof ADSuyiSplashAd) {
            this.f3741a = (ADSuyiSplashAd) aDSuyiPreLoadParams.getSuyiAd();
        }
        this.f3742b = aDSuyiPreLoadParams.getAdapterParams();
        if (aDSuyiPreLoadParams.getListener() instanceof ADSuyiSplashAdListener) {
            this.f3743c = (ADSuyiSplashAdListener) aDSuyiPreLoadParams.getListener();
        }
        this.f3747g = new b(aDSuyiParallelCallback);
        a();
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        s sVar = this.f3744d;
        if (sVar != null) {
            sVar.release();
            this.f3744d = null;
        }
        v vVar = this.f3745e;
        if (vVar != null) {
            vVar.release();
            this.f3745e = null;
        }
        p pVar = this.f3746f;
        if (pVar != null) {
            pVar.release();
            this.f3746f = null;
        }
        this.f3741a = null;
        this.f3742b = null;
        this.f3743c = null;
        c cVar = this.f3747g;
        if (cVar != null) {
            cVar.release();
            this.f3747g = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiSplashAd aDSuyiSplashAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiSplashAdListener aDSuyiSplashAdListener) {
        this.f3741a = aDSuyiSplashAd;
        this.f3742b = aDSuyiAdapterParams;
        this.f3743c = aDSuyiSplashAdListener;
        a();
    }
}

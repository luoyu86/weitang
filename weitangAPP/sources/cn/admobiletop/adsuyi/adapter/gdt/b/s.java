package cn.admobiletop.adsuyi.adapter.gdt.b;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.ADSuyiSplashAd;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiSplashAdContainer;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class s extends c<ADSuyiSplashAdListener> implements SplashADListener, ADRewardListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ADSuyiSplashAdContainer f3664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.gdt.a.l f3665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f3666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<Long> f3668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3669i;
    public SplashAD j;
    public cn.admobiletop.adsuyi.adapter.gdt.d.c k;
    public ADSuyiSplashAd l;

    public s(ADSuyiSplashAd aDSuyiSplashAd, ADSuyiSplashAdContainer aDSuyiSplashAdContainer, String str, ADSuyiSplashAdListener aDSuyiSplashAdListener, int i2, cn.admobiletop.adsuyi.adapter.gdt.d.c cVar) {
        super(str, aDSuyiSplashAdListener);
        this.f3666f = new Handler(Looper.getMainLooper());
        this.l = aDSuyiSplashAd;
        this.f3664d = aDSuyiSplashAdContainer;
        this.f3669i = i2;
        this.k = cVar;
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        if (getAdListener() == 0 || this.f3665e == null) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onAdClick(this.f3665e);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        if (getAdListener() == 0 || this.f3665e == null) {
            return;
        }
        if (this.f3667g / 1000 > 0) {
            ((ADSuyiSplashAdListener) getAdListener()).onAdSkip(this.f3665e);
        }
        ((ADSuyiSplashAdListener) getAdListener()).onAdClose(this.f3665e);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
        if (getAdListener() == 0 || this.f3665e == null) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onAdExpose(this.f3665e);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADLoaded(long j) {
        if (getAdListener() == 0 || this.f3664d == null) {
            return;
        }
        cn.admobiletop.adsuyi.adapter.gdt.a.l lVar = new cn.admobiletop.adsuyi.adapter.gdt.a.l(getPlatformPosId());
        this.f3665e = lVar;
        lVar.setAdapterAdInfo(this.j);
        this.f3664d.setSplashAdListener((ADSuyiSplashAdListener) getAdListener());
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.k;
        if (cVar != null) {
            cVar.a(this.j);
        } else {
            a();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j) {
        this.f3667g = j;
        if (this.f3669i == 0 || getAdListener() == 0 || this.f3665e == null) {
            return;
        }
        long jRound = Math.round(j / 1000.0f);
        if (this.f3668h == null) {
            this.f3668h = new ArrayList();
        }
        if (this.f3668h.contains(Long.valueOf(jRound))) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onADTick(jRound);
        this.f3668h.add(Long.valueOf(jRound));
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void onAdFailed(int i2, String str) {
        Handler handler = this.f3666f;
        if (handler != null) {
            handler.post(new r(this, i2, str));
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(AdError adError) {
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.k;
        if (cVar != null) {
            cVar.a(adError, this.j);
        } else {
            onAdFailed(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    @Override // com.qq.e.comm.listeners.ADRewardListener
    public void onReward(Map<String, Object> map) {
        if (getAdListener() == 0 || this.f3665e == null) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onReward(this.f3665e);
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        this.f3664d = null;
        Handler handler = this.f3666f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3666f = null;
        }
        cn.admobiletop.adsuyi.adapter.gdt.a.l lVar = this.f3665e;
        if (lVar != null) {
            lVar.release();
            this.f3665e = null;
        }
    }

    public void a() {
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.k;
        if (cVar != null) {
            cVar.release();
            this.k = null;
        }
        ADSuyiSplashAd aDSuyiSplashAd = this.l;
        if (aDSuyiSplashAd != null) {
            aDSuyiSplashAd.setAllowCustomSkipView(false);
        }
        if (this.f3665e != null) {
            ((ADSuyiSplashAdListener) getAdListener()).onAdReceive(this.f3665e);
        } else {
            onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
        }
    }

    public void a(SplashAD splashAD) {
        this.j = splashAD;
    }
}

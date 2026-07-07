package com.qq.e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class UnifiedBannerAD extends LiteAbstractAD<UBVI> implements NFBI, IReward {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UnifiedBannerADListener f9533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AtomicInteger f9534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9535i;
    public LoadAdParams j;
    public UnifiedBannerView k;
    public final ADListenerAdapter l;
    public volatile ServerSideVerificationOptions m;

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str);
    }

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str, str2);
    }

    public UnifiedBannerAD(UnifiedBannerView unifiedBannerView, UnifiedBannerADListener unifiedBannerADListener) {
        this.f9534h = new AtomicInteger(0);
        this.f9535i = 30;
        this.j = null;
        this.f9533g = unifiedBannerADListener;
        this.k = unifiedBannerView;
        this.l = new ADListenerAdapter(unifiedBannerADListener);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.k, (Activity) context, str, str2, str3, this.l);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        UnifiedBannerADListener unifiedBannerADListener = this.f9533g;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public void d(int i2) {
        this.f9535i = i2;
        T t = this.f9515a;
        if (t != 0) {
            ((UBVI) t).setRefresh(i2);
        }
    }

    public void destroy() {
        T t = this.f9515a;
        if (t != 0) {
            ((UBVI) t).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t = this.f9515a;
        if (t != 0) {
            return ((UBVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f9534h.incrementAndGet();
                return;
            }
            T t = this.f9515a;
            if (t != 0) {
                ((UBVI) t).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        T t = this.f9515a;
        if (t != 0) {
            ((UBVI) t).onWindowFocusChanged(z);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.j = loadAdParams;
        T t = this.f9515a;
        if (t != 0) {
            ((UBVI) t).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.l.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.l.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.m = serverSideVerificationOptions;
        T t = this.f9515a;
        if (t != 0) {
            ((UBVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        UBVI ubvi = (UBVI) obj;
        int i2 = this.f9535i;
        this.f9535i = i2;
        T t = this.f9515a;
        if (t != 0) {
            ((UBVI) t).setRefresh(i2);
        }
        LoadAdParams loadAdParams = this.j;
        this.j = loadAdParams;
        T t2 = this.f9515a;
        if (t2 != 0) {
            ((UBVI) t2).setLoadAdParams(loadAdParams);
        }
        ubvi.setServerSideVerificationOptions(this.m);
        while (this.f9534h.getAndDecrement() > 0) {
            loadAD();
        }
    }
}

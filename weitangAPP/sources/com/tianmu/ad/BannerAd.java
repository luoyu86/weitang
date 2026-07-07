package com.tianmu.ad;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tianmu.ad.base.BaseAd;
import com.tianmu.ad.bean.BannerAdInfo;
import com.tianmu.ad.entity.TianmuAdSize;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.BannerAdListener;
import com.tianmu.ad.widget.BannerView;
import com.tianmu.c.i.e;
import com.tianmu.c.m.a;
import com.tianmu.c.n.n;

/* JADX INFO: loaded from: classes2.dex */
public class BannerAd extends BaseAd<BannerAdListener> {
    private ViewGroup m;
    private long n;
    private BannerView o;
    private Handler p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private a f10547q;
    private e r;
    private boolean s;

    public BannerAd(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context);
        this.n = 0L;
        this.p = new Handler(Looper.getMainLooper());
        this.m = viewGroup;
        this.s = true;
    }

    private void b(int i2) {
        if (i2 == 0) {
            i2 = 0;
        } else if (i2 < 15) {
            i2 = 15;
        } else if (i2 > 120) {
            i2 = 120;
        }
        this.n = i2 * 1000;
    }

    private void c() {
        if (getContainer() == null) {
            onAdFailed(new TianmuError(-2001, "广告容器不能为空"));
            return;
        }
        TianmuAdSize tianmuAdSizeA = this.r.a();
        b(this.r.d());
        this.o = new BannerView(this, tianmuAdSizeA, this.s, this.f10547q);
    }

    @Override // com.tianmu.ad.base.BaseAd
    public com.tianmu.c.c.e a() {
        this.r = n.D().a(getPosId());
        a aVar = new a(this, this.p);
        this.f10547q = aVar;
        return aVar;
    }

    @Override // com.tianmu.ad.base.BaseAd
    public String getAdType() {
        return "banner";
    }

    public long getAutoRefresh() {
        return this.n;
    }

    public ViewGroup getContainer() {
        return this.m;
    }

    @Override // com.tianmu.ad.base.BaseAd
    public int getRenderType() {
        return 0;
    }

    public boolean isLoadAndShow() {
        return this.s;
    }

    public void loadAd(String str) {
        super.loadAd(str, 1);
    }

    public void onAdReceive(BannerAdInfo bannerAdInfo) {
        this.f10547q.onAdReceive(bannerAdInfo);
    }

    public void pause() {
        BannerView bannerView;
        if (getAutoRefresh() <= 0 || (bannerView = this.o) == null) {
            return;
        }
        bannerView.removeHandler();
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void release() {
        super.release();
        Handler handler = this.p;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.p = null;
        }
        BannerView bannerView = this.o;
        if (bannerView != null) {
            bannerView.release();
            this.o = null;
        }
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void requestAdInfo(com.tianmu.c.c.e eVar) {
        c();
    }

    public void resume() {
        BannerView bannerView;
        if (getAutoRefresh() <= 0 || (bannerView = this.o) == null) {
            return;
        }
        bannerView.startRefreshDelayed();
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void startLoopLoadAd() {
        a aVar = this.f10547q;
        if (aVar != null) {
            aVar.a(this.r, 1);
        }
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void setListener(BannerAdListener bannerAdListener) {
        super.setListener(bannerAdListener);
    }

    public BannerAd(@NonNull Context context) {
        super(context);
        this.n = 0L;
        this.p = new Handler(Looper.getMainLooper());
        this.m = new FrameLayout(context);
        this.s = false;
    }
}

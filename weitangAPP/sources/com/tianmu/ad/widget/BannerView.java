package com.tianmu.ad.widget;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.BannerAd;
import com.tianmu.ad.bean.BannerAdInfo;
import com.tianmu.ad.entity.TianmuAdSize;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.widget.banneradview.base.BaseBannerViewContainer;
import com.tianmu.ad.widget.banneradview.factory.BannerBase;
import com.tianmu.c.i.l;
import com.tianmu.c.k.f.c;
import com.tianmu.c.m.a;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public class BannerView extends BaseBannerViewContainer {
    private BannerBase w;
    private Handler x;
    private boolean y;
    private a z;

    public BannerView(@NonNull BannerAd bannerAd, TianmuAdSize tianmuAdSize, boolean z, a aVar) {
        super(bannerAd, bannerAd.getAutoRefresh(), tianmuAdSize);
        this.x = new Handler(Looper.getMainLooper());
        this.y = z;
        this.z = aVar;
        if (z && getAd() != null && getAd().getContainer() != null) {
            getAd().getContainer().removeAllViews();
            getAd().getContainer().addView(this);
        }
        f();
    }

    private void e() {
        BannerBase bannerBaseInit = BannerBase.init(getContext(), 4 == getAdInfo().getAdData().w() ? 1 : 4, "", this.imageLoaderCallback);
        this.w = bannerBaseInit;
        bannerBaseInit.setBannerData(getAdInfo().getAdData().getImageUrl(), getAdInfo().getAdData().getTitle(), getAdInfo().getAdData().getDesc(), getAdInfo().getAdData().e(), getAdInfo().getAdData().c());
    }

    private void f() {
        com.tianmu.c.b.a.a(getAd().getPosId(), getAd().getAdType(), new c(getAd().getPosId(), getAd().getAdType(), this.x) { // from class: com.tianmu.ad.widget.BannerView.1
            @Override // com.tianmu.c.k.f.c
            public void a(l lVar) {
                if (lVar == null || lVar.a() == null || lVar.a().size() == 0) {
                    if (BannerView.this.getAd() != null) {
                        BannerView.this.getAd().onAdFailed(new TianmuError(TianmuErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"));
                        return;
                    }
                    return;
                }
                if (lVar.a().size() > 1) {
                    com.tianmu.c.i.c cVar = lVar.a().get(0);
                    lVar.a().clear();
                    lVar.a().add(cVar);
                }
                BannerAdInfo bannerAdInfo = new BannerAdInfo(BannerView.this.z);
                bannerAdInfo.setAdData(lVar);
                BannerView.this.initBannerAdView(bannerAdInfo);
            }

            @Override // com.tianmu.c.k.f.c
            public void a(int i2, String str) {
                if (BannerView.this.getAd() != null) {
                    BannerView.this.getAd().onAdFailed(new TianmuError(i2, str));
                }
            }
        });
    }

    private void g() {
        getAd().onAdReceive(getAdInfo());
    }

    private void h() {
        a(this.w.getClickView());
    }

    private void i() {
        this.w.getCloseView().setOnClickListener(new com.tianmu.c.l.a() { // from class: com.tianmu.ad.widget.BannerView.2
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view) {
                BannerView.this.getAd().getContainer().removeAllViews();
                TianmuViewUtil.removeSelfFromParent(BannerView.this);
                BannerView.this.getAd().onAdClose(BannerView.this.getAdInfo());
            }
        });
    }

    @Override // com.tianmu.ad.widget.banneradview.base.BaseBannerViewContainer
    public void d() {
        BannerBase bannerBase = this.w;
        if (bannerBase != null) {
            bannerBase.setConfigView(getContainerWidth(), getContainerHeight());
        }
    }

    @Override // com.tianmu.ad.base.BaseView
    public View getClickView() {
        BannerBase bannerBase = this.w;
        if (bannerBase != null) {
            return bannerBase.getClickView();
        }
        return null;
    }

    public void initBannerAdView(BannerAdInfo bannerAdInfo) {
        if (bannerAdInfo == null) {
            if (getAd() != null) {
                getAd().onAdFailed(new TianmuError(-2012, "获取广告时发生未知异常"));
                return;
            }
            return;
        }
        setAdInfo(bannerAdInfo);
        e();
        h();
        i();
        if (getAd() != null) {
            if (this.y) {
                render();
            } else {
                bannerAdInfo.setAdView(this);
            }
        }
        g();
    }

    @Override // com.tianmu.ad.widget.banneradview.base.BaseBannerViewContainer
    public void onRefresh() {
        f();
    }

    @Override // com.tianmu.ad.widget.banneradview.base.BaseBannerViewContainer, com.tianmu.ad.base.BaseView
    public void release() {
        super.release();
        TianmuViewUtil.removeSelfFromParent(this);
        removeAllViews();
        BannerBase bannerBase = this.w;
        if (bannerBase != null) {
            bannerBase.release();
            this.w = null;
        }
        Handler handler = this.x;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.x = null;
        }
        a aVar = this.z;
        if (aVar != null) {
            aVar.release();
            this.z = null;
        }
    }

    public void render() {
        removeAllViews();
        if (TianmuSDK.getInstance().isFlutter()) {
            refreshView(this.w.getView(), new com.tianmu.c.j.a(false, this));
        } else {
            refreshView(this.w.getView(), new com.tianmu.c.j.a(this));
        }
        if (this.r) {
            d();
        }
    }

    private void a(View view) {
        view.setOnClickListener(new com.tianmu.c.l.a() { // from class: com.tianmu.ad.widget.BannerView.3
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view2) {
                if (BannerView.this.getAd() == null || BannerView.this.getAd().getListener() == null || BannerView.this.getAdInfo() == null || BannerView.this.getAdInfo().getAdInfoStatus() == null) {
                    return;
                }
                BannerView.this.getAdInfo().getAdInfoStatus().a(true);
                BannerView.this.onAdExpose();
                BannerAd ad = BannerView.this.getAd();
                BannerView bannerView = BannerView.this;
                ad.onAdClick(bannerView, bannerView.getAdInfo(), 0);
            }
        });
    }
}

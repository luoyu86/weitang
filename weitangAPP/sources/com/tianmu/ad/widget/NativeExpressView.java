package com.tianmu.ad.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.NativeExpressAd;
import com.tianmu.ad.base.BaseView;
import com.tianmu.ad.bean.NativeExpressAdInfo;
import com.tianmu.ad.model.ITianmuNativeVideoAd;
import com.tianmu.ad.widget.nativeadview.config.NativeConfig;
import com.tianmu.ad.widget.nativeadview.config.NativeConstant;
import com.tianmu.ad.widget.nativeadview.factory.NativeBase;
import com.tianmu.ad.widget.nativeadview.model.NativeAction;
import com.tianmu.ad.widget.nativeadview.model.NativeDesc;
import com.tianmu.ad.widget.nativeadview.model.NativeMargin;
import com.tianmu.ad.widget.nativeadview.model.NativePadding;
import com.tianmu.ad.widget.nativeadview.model.NativeTitle;
import com.tianmu.biz.bean.VideoAutoPlayType;
import com.tianmu.c.j.a;
import com.tianmu.c.n.q;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class NativeExpressView extends BaseView<NativeExpressAd, NativeExpressAdInfo> {
    private a o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private NativeBase f10690q;

    public NativeExpressView(@NonNull NativeExpressAd nativeExpressAd, @NonNull NativeExpressAdInfo nativeExpressAdInfo, @NonNull Context context) {
        super(nativeExpressAd);
        setAdInfo(nativeExpressAdInfo);
        this.p = nativeExpressAdInfo.getVideoAutoPlayType();
        a(context);
    }

    private String c() {
        try {
            return getAdInfo().getAdData().d().b();
        } catch (Exception unused) {
            return NativeConstant.TEMPLATE_TOP_PIC_FLOW;
        }
    }

    private void render() {
        NativeBase nativeBase = this.f10690q;
        if (nativeBase != null) {
            nativeBase.setAdMaterial();
        }
    }

    @Override // com.tianmu.ad.base.BaseView
    public void clickHidView() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tianmu.ad.widget.NativeExpressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (NativeExpressView.this.f10690q != null) {
                    NativeExpressView.this.f10690q.hideEraseView();
                }
            }
        }, 1000L);
    }

    @Override // com.tianmu.ad.base.BaseView
    public View getClickView() {
        NativeBase nativeBase = this.f10690q;
        if (nativeBase != null) {
            return nativeBase.getNativeView();
        }
        return null;
    }

    @Override // com.tianmu.ad.base.BaseView, com.tianmu.ad.listener.VideoAdListener
    public void onVideoFinish(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
        super.onVideoFinish(iTianmuNativeVideoAd);
        NativeBase nativeBase = this.f10690q;
        if (nativeBase != null) {
            nativeBase.setSlideHide();
        }
    }

    @Override // com.tianmu.ad.base.BaseView, com.tianmu.ad.listener.VideoAdListener
    public void onVideoPause(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
        super.onVideoPause(iTianmuNativeVideoAd);
        int i2 = this.p;
        if (i2 == VideoAutoPlayType.DEFAULT_PLAY ? VideoAutoPlayType.isNativeAutoPlayVideo() : i2 == VideoAutoPlayType.AUTO_PLAY) {
            NativeBase nativeBase = this.f10690q;
            if (nativeBase != null) {
                nativeBase.setSlideShow();
                return;
            }
            return;
        }
        NativeBase nativeBase2 = this.f10690q;
        if (nativeBase2 != null) {
            nativeBase2.setSlideHide();
        }
    }

    @Override // com.tianmu.ad.base.BaseView, com.tianmu.ad.listener.VideoAdListener
    public void onVideoResume(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
        super.onVideoResume(iTianmuNativeVideoAd);
        NativeBase nativeBase = this.f10690q;
        if (nativeBase != null) {
            nativeBase.setSlideShow();
        }
    }

    @Override // com.tianmu.ad.base.BaseView, com.tianmu.ad.listener.VideoAdListener
    public void onVideoStart(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
        super.onVideoStart(iTianmuNativeVideoAd);
        NativeBase nativeBase = this.f10690q;
        if (nativeBase != null) {
            nativeBase.setSlideShow();
        }
    }

    @Override // com.tianmu.ad.base.BaseView
    public void release() {
        super.release();
        releaseExposeChecker();
        NativeBase nativeBase = this.f10690q;
        if (nativeBase != null) {
            nativeBase.release();
            this.f10690q = null;
        }
    }

    @Override // com.tianmu.ad.base.BaseView
    public void releaseExposeChecker() {
        a aVar = this.o;
        if (aVar != null) {
            aVar.c();
            this.o = null;
        }
    }

    @Override // com.tianmu.ad.base.BaseView
    public void startExposeChecker() {
        render();
        if (isExpose()) {
            return;
        }
        if (TianmuSDK.getInstance().isFlutter()) {
            this.o = new a(false, this);
        } else {
            this.o = new a(this);
        }
        this.o.a(this);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void a(Context context) {
        NativeExpressView nativeExpressView;
        NativeMargin nativeMargin;
        int iDp2px;
        int i2;
        int i3;
        int iDp2px2;
        int i4;
        int iDp2px3;
        int i5;
        int iDp2px4;
        int iDp2px5;
        int iDp2px6;
        if (this.f10690q == null) {
            String strC = c();
            NativeMargin nativeMargin2 = new NativeMargin(0);
            int iDp2px7 = TianmuDisplayUtil.dp2px(16);
            int iDp2px8 = TianmuDisplayUtil.dp2px(16);
            int iDp2px9 = TianmuDisplayUtil.dp2px(16);
            int i6 = 12;
            int iDp2px10 = TianmuDisplayUtil.dp2px(12);
            strC.hashCode();
            byte b2 = -1;
            int i7 = 1;
            switch (strC.hashCode()) {
                case -2074819418:
                    if (strC.equals(NativeConstant.TEMPLATE_PIC)) {
                        b2 = 0;
                    }
                    break;
                case -1875758650:
                    if (strC.equals("RIGHT_PIC_FLOW")) {
                        b2 = 1;
                    }
                    break;
                case -914096101:
                    if (strC.equals("LEFT_PIC_FLOW")) {
                        b2 = 2;
                    }
                    break;
                case -655669587:
                    if (strC.equals(NativeConstant.TEMPLATE_TOP_PIC_FLOW)) {
                        b2 = 3;
                    }
                    break;
                case 487567991:
                    if (strC.equals("BOTTOM_PIC_FLOW")) {
                        b2 = 4;
                    }
                    break;
            }
            int i8 = 14;
            switch (b2) {
                case 0:
                    nativeMargin = nativeMargin2;
                    iDp2px = 0;
                    i2 = 0;
                    i3 = 0;
                    iDp2px8 = 0;
                    iDp2px2 = 0;
                    i4 = 0;
                    iDp2px3 = 0;
                    i5 = 0;
                    i8 = 12;
                    break;
                case 1:
                case 2:
                    nativeMargin = nativeMargin2;
                    iDp2px3 = iDp2px10;
                    iDp2px = 0;
                    i4 = 0;
                    i5 = 0;
                    i7 = 3;
                    i8 = 12;
                    iDp2px2 = iDp2px7;
                    i3 = iDp2px9;
                    i2 = 0;
                    break;
                case 3:
                    iDp2px4 = TianmuDisplayUtil.dp2px(10);
                    iDp2px5 = TianmuDisplayUtil.dp2px(14);
                    iDp2px6 = TianmuDisplayUtil.dp2px(25);
                    nativeMargin = new NativeMargin(0, 0, 0, 0);
                    iDp2px3 = iDp2px10;
                    i5 = iDp2px6;
                    i7 = 3;
                    iDp2px2 = iDp2px7;
                    i4 = iDp2px5;
                    i6 = 14;
                    i3 = iDp2px9;
                    i2 = iDp2px4;
                    iDp2px = 0;
                    break;
                case 4:
                    iDp2px = TianmuDisplayUtil.dp2px(13);
                    int iDp2px11 = TianmuDisplayUtil.dp2px(14);
                    int iDp2px12 = TianmuDisplayUtil.dp2px(25);
                    NativeMargin nativeMargin3 = new NativeMargin(0, 0, 0, 0);
                    iDp2px8 = TianmuDisplayUtil.dp2px(11);
                    iDp2px2 = TianmuDisplayUtil.dp2px(15);
                    int iDp2px13 = TianmuDisplayUtil.dp2px(15);
                    iDp2px3 = TianmuDisplayUtil.dp2px(15);
                    i5 = iDp2px12;
                    i3 = iDp2px13;
                    i7 = 3;
                    nativeMargin = nativeMargin3;
                    i4 = iDp2px11;
                    i2 = 0;
                    i6 = 14;
                    break;
                default:
                    iDp2px4 = TianmuDisplayUtil.dp2px(8);
                    iDp2px5 = TianmuDisplayUtil.dp2px(4);
                    iDp2px6 = TianmuDisplayUtil.dp2px(25);
                    nativeMargin = new NativeMargin(0, 0, 0, TianmuDisplayUtil.dp2px(2));
                    iDp2px3 = iDp2px10;
                    i5 = iDp2px6;
                    i7 = 3;
                    iDp2px2 = iDp2px7;
                    i4 = iDp2px5;
                    i6 = 14;
                    i3 = iDp2px9;
                    i2 = iDp2px4;
                    iDp2px = 0;
                    break;
            }
            NativeTitle nativeTitle = new NativeTitle();
            nativeTitle.setSize(i6);
            nativeTitle.setColor("#B3B3B3");
            NativeAction nativeAction = new NativeAction();
            nativeAction.setSize(i8);
            nativeAction.setColor("#0091FF");
            NativeDesc nativeDesc = new NativeDesc();
            nativeDesc.setSize(18);
            nativeDesc.setColor("#333333");
            nativeExpressView = this;
            nativeExpressView.f10690q = NativeBase.init(context, strC, new NativeConfig.Builder().setAdContainerPadding(new NativePadding(iDp2px2, iDp2px8, i3, iDp2px3)).setAdContainerWidth(getAd().getAdSize().getWidth()).setAdImageMargin(new NativeMargin(0, 0, 0, 0)).setAdTitleMargin(new NativeMargin(0, i4, i5, 0)).setAdImageMargin(new NativeMargin(0, iDp2px, 0, 0)).setAdDescMargin(new NativeMargin(0, i2, 0, 0)).setAdClosePosition(i7).setAdCloseMargin(nativeMargin).setAdTypePosition(3).setAdDescText(nativeDesc).setAdTitleText(nativeTitle).setAdActionText(nativeAction).build(), getAdInfo(), nativeExpressView.imageLoaderCallback);
        } else {
            nativeExpressView = this;
        }
        View nativeView = nativeExpressView.f10690q.getNativeView();
        nativeExpressView.addView(q.a().a(getAd() == null ? "" : getAd().getPosId(), getAdInfo() == null ? "" : getAdInfo().getKey(), "flow", nativeView, (getAdInfo() == null || getAdInfo().getAdData() == null || getAdInfo().getAdData().N()) ? false : getAdInfo().getAdData().O()));
    }
}

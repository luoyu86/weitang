package com.tianmu.ad.widget.interstitialview.factory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManagerImpl;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.ad.widget.interstitialview.InterstitialView;
import com.tianmu.biz.widget.roundimage.RoundedImageView;
import com.tianmu.c.f.a0;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuViewUtil;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialEnvelopeTextView extends InterstitialEnvelopeView {
    public InterstitialEnvelopeTextView(InterstitialView interstitialView, InterstitialAdInfo interstitialAdInfo) {
        super(interstitialView, interstitialAdInfo);
    }

    private void a(RoundedImageView roundedImageView) {
        InterstitialAdInfo interstitialAdInfo;
        if (roundedImageView == null || (interstitialAdInfo = this.o) == null || interstitialAdInfo.getAdData() == null) {
            return;
        }
        roundedImageView.a(TianmuDisplayUtil.dp2px(40));
        TianmuSDK.getInstance().getImageLoader().loadImage(roundedImageView.getContext(), this.o.getAdData().getAppIconUrl(), roundedImageView);
    }

    private void b(RoundedImageView roundedImageView) {
        if (roundedImageView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) roundedImageView.getLayoutParams();
        int i2 = this.S;
        layoutParams.width = i2;
        layoutParams.height = (i2 * 9) / 16;
        roundedImageView.setLayoutParams(layoutParams);
        roundedImageView.a(TianmuDisplayUtil.dp2px(this.L), TianmuDisplayUtil.dp2px(this.L), 0.0f, 0.0f);
        loadImage(roundedImageView);
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialEnvelopeView
    public double e() {
        if (this.u) {
            return 0.8d;
        }
        double dDoubleValue = new BigDecimal(1400).divide(new BigDecimal(this.f10706b), 2, 4).doubleValue();
        if (dDoubleValue > 0.69d) {
            return 0.69d;
        }
        return dDoubleValue;
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialEnvelopeView
    public double f() {
        if (this.u) {
            return 0.08d;
        }
        return new BigDecimal(1).subtract(new BigDecimal(e())).divide(new BigDecimal(2), 2, 4).doubleValue();
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialEnvelopeView
    public void g() {
        int i2 = (this.S * 9) / 16;
        if (this.o.getAdData().s() != 6) {
            super.g();
            return;
        }
        this.Q = true;
        a(i2 - TianmuDisplayUtil.dp2px(40), "#000000", null, this.u ? FragmentManagerImpl.ANIM_DUR : TianmuDisplayUtil.px2dp(this.B) - 217, !this.u, false);
        View view = this.J;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialEnvelopeView, com.tianmu.ad.widget.interstitialview.factory.InterstitialBase
    public void initView() {
        super.initView();
    }

    @Override // com.tianmu.ad.widget.interstitialview.factory.InterstitialEnvelopeView
    public void j() {
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.r.getSystemService("layout_inflater")).inflate(a0.f11252a, (ViewGroup) this.p, false);
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(a0.f11253b);
        TextView textView = (TextView) viewGroup.findViewById(a0.f11254c);
        RoundedImageView roundedImageView = (RoundedImageView) viewGroup.findViewById(a0.f11255d);
        TextView textView2 = (TextView) viewGroup.findViewById(a0.f11256e);
        if (this.o.isVideo()) {
            TianmuViewUtil.addAdViewToAdContainer(frameLayout, this.o.getMediaView(this.I));
        } else {
            b((RoundedImageView) viewGroup.findViewById(a0.f11257f));
        }
        InterstitialAdInfo interstitialAdInfo = this.o;
        if (interstitialAdInfo == null || interstitialAdInfo.getAdData() == null) {
            textView.setVisibility(8);
        } else {
            textView.setText(this.o.getAdData().getTitle());
        }
        a(roundedImageView);
        InterstitialAdInfo interstitialAdInfo2 = this.o;
        if (interstitialAdInfo2 != null && interstitialAdInfo2.getAdData() != null) {
            textView2.setText(this.o.getAdData().getDesc());
        }
        this.I.addView(viewGroup);
    }
}

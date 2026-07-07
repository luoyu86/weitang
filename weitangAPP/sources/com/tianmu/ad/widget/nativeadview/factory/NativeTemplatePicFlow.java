package com.tianmu.ad.widget.nativeadview.factory;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.bean.NativeExpressAdInfo;
import com.tianmu.ad.widget.nativeadview.config.NativeConfig;
import com.tianmu.c.f.b;
import com.tianmu.c.f.i0;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public class NativeTemplatePicFlow extends NativeBase {
    public NativeTemplatePicFlow(Context context, NativeConfig nativeConfig, NativeExpressAdInfo nativeExpressAdInfo) {
        super(context, nativeConfig, nativeExpressAdInfo);
    }

    private void b() {
        try {
            SpannableStringBuilder spannableStringBuilderA = a();
            if (spannableStringBuilderA == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.rightMargin = TianmuDisplayUtil.dp2px(46);
            TextView textView = new TextView(getContext());
            textView.setTextSize(8.0f);
            textView.setTextColor(-855638017);
            textView.setPadding(TianmuDisplayUtil.dp2px(3), TianmuDisplayUtil.dp2px(1), TianmuDisplayUtil.dp2px(23), TianmuDisplayUtil.dp2px(5));
            textView.setLayoutParams(layoutParams);
            textView.setBackgroundResource(b.f11260a);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(spannableStringBuilderA);
            this.f10741a.addView(textView);
        } catch (Exception unused) {
        }
    }

    @Override // com.tianmu.ad.widget.nativeadview.factory.NativeBase
    public View getNativeView() {
        return this;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.m.getAdContainerWidth() > 0 || this.m.getAdContainerHeight() > 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f10743c.getLayoutParams();
        int measuredWidth = getMeasuredWidth();
        layoutParams.width = measuredWidth;
        layoutParams.height = (measuredWidth * 9) / 16;
        this.f10743c.setLayoutParams(layoutParams);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.m.getAdContainerWidth() > 0 || this.m.getAdContainerHeight() > 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f10743c.getLayoutParams();
        int measuredWidth = getMeasuredWidth();
        layoutParams.width = measuredWidth;
        layoutParams.height = (measuredWidth * 9) / 16;
        this.f10743c.setLayoutParams(layoutParams);
    }

    @Override // com.tianmu.ad.widget.nativeadview.factory.NativeBase
    public void setAdInfo() {
        super.setAdInfo();
        FrameLayout frameLayout = this.f10743c;
        if (frameLayout != null) {
            frameLayout.post(new Runnable() { // from class: com.tianmu.ad.widget.nativeadview.factory.NativeTemplatePicFlow.1
                @Override // java.lang.Runnable
                public void run() {
                    NativeTemplatePicFlow nativeTemplatePicFlow = NativeTemplatePicFlow.this;
                    nativeTemplatePicFlow.setInteractSubStyle(nativeTemplatePicFlow.u, nativeTemplatePicFlow.v);
                }
            });
        }
    }

    @Override // com.tianmu.ad.widget.nativeadview.factory.NativeBase
    public void setAdMaterial() {
        if (this.n.isVideo()) {
            TianmuViewUtil.addAdViewToAdContainer(this.f10743c, this.n.getMediaView(this.f10743c));
            return;
        }
        this.t = new ImageView(this.f10743c.getContext());
        this.t.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.t.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TianmuSDK.getInstance().getImageLoader().loadImage(this.l, this.n.getImageUrl(), this.t, getADImageLoaderCallback());
        TianmuViewUtil.addAdViewToAdContainer(this.f10743c, this.t);
    }

    @Override // com.tianmu.ad.widget.nativeadview.factory.NativeBase
    public void setConfigView() {
        this.o = ((LayoutInflater) this.l.getSystemService("layout_inflater")).inflate(i0.f11393a, (ViewGroup) null);
        if (this.m.getAdContainerWidth() <= 0 && this.m.getAdContainerHeight() <= 0) {
            this.u = -1;
            this.v = -2;
        } else if (this.m.getAdContainerWidth() <= 0 || this.m.getAdContainerHeight() > 0) {
            this.u = this.m.getAdContainerWidth();
            this.v = this.m.getAdContainerHeight();
        } else {
            int adContainerWidth = this.m.getAdContainerWidth();
            this.u = adContainerWidth;
            this.v = (adContainerWidth * 9) / 16;
        }
        RelativeLayout relativeLayout = (RelativeLayout) this.o.findViewById(i0.f11394b);
        this.f10741a = relativeLayout;
        relativeLayout.setPadding(this.m.getAdContainerPadding().getLeft(), this.m.getAdContainerPadding().getTop(), this.m.getAdContainerPadding().getRight(), this.m.getAdContainerPadding().getBottom());
        this.f10741a.setBackground(getDrawableBg(this.m.getAdContainerRadius(), this.m.getAdContainerColor()));
        this.f10743c = (FrameLayout) this.o.findViewById(i0.f11395c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.u, this.v);
        layoutParams.setMargins(this.m.getAdImageMargin().getLeft(), this.m.getAdImageMargin().getTop(), this.m.getAdImageMargin().getRight(), this.m.getAdImageMargin().getBottom());
        this.f10743c.setLayoutParams(layoutParams);
        this.f10744d = (FrameLayout) this.o.findViewById(i0.f11396d);
        this.f10746f = (TextView) this.o.findViewById(i0.f11397e);
        this.f10747g = (TextView) this.o.findViewById(i0.f11398f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.m.getAdTypeSize().getWidth(), this.m.getAdTypeSize().getHeight());
        layoutParams2.setMargins(this.m.getAdTypeMargin().getLeft(), this.m.getAdTypeMargin().getTop(), this.m.getAdTypeMargin().getRight(), this.m.getAdTypeMargin().getBottom());
        int adTypePosition = this.m.getAdTypePosition();
        if (adTypePosition == 0) {
            layoutParams2.addRule(6, this.f10743c.getId());
            layoutParams2.addRule(5, this.f10743c.getId());
        } else if (adTypePosition == 1) {
            layoutParams2.addRule(6, this.f10743c.getId());
            layoutParams2.addRule(7, this.f10743c.getId());
        } else if (adTypePosition == 2) {
            layoutParams2.addRule(8, this.f10743c.getId());
            layoutParams2.addRule(5, this.f10743c.getId());
        } else if (adTypePosition == 3) {
            layoutParams2.addRule(8, this.f10743c.getId());
            layoutParams2.addRule(7, this.f10743c.getId());
        }
        this.f10746f.setLayoutParams(layoutParams2);
        this.k = (ImageView) this.o.findViewById(i0.f11399g);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.k.getLayoutParams());
        layoutParams3.setMargins(this.m.getAdCloseMargin().getLeft(), this.m.getAdCloseMargin().getTop(), TianmuDisplayUtil.dp2px(7), TianmuDisplayUtil.dp2px(7));
        int adClosePosition = this.m.getAdClosePosition();
        if (adClosePosition == 0) {
            layoutParams3.addRule(6, this.f10743c.getId());
            layoutParams3.addRule(5, this.f10743c.getId());
        } else if (adClosePosition == 1) {
            layoutParams3.addRule(6, this.f10743c.getId());
            layoutParams3.addRule(7, this.f10743c.getId());
        } else if (adClosePosition == 2) {
            layoutParams3.addRule(8, this.f10743c.getId());
            layoutParams3.addRule(5, this.f10743c.getId());
        } else if (adClosePosition == 3) {
            layoutParams3.addRule(8, this.f10743c.getId());
            layoutParams3.addRule(7, this.f10743c.getId());
        }
        this.k.setLayoutParams(layoutParams3);
        b();
        TianmuViewUtil.addAdViewToAdContainer(this, this.o, new ViewGroup.LayoutParams(-1, -2));
    }
}

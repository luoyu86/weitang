package com.tianmu.ad.widget.nativeadview.factory;

import android.content.Context;
import android.graphics.Color;
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
import com.tianmu.c.f.m;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public class NativeTemplateBottomPicFlow extends NativeBase {
    private int x;
    private int y;

    public NativeTemplateBottomPicFlow(Context context, NativeConfig nativeConfig, NativeExpressAdInfo nativeExpressAdInfo) {
        super(context, nativeConfig, nativeExpressAdInfo);
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
        layoutParams.height = (((measuredWidth - this.m.getAdContainerPadding().getLeft()) - this.m.getAdContainerPadding().getRight()) * 9) / 16;
        this.f10743c.setLayoutParams(layoutParams);
    }

    @Override // com.tianmu.ad.widget.nativeadview.factory.NativeBase
    public void setAdInfo() {
        super.setAdInfo();
        FrameLayout frameLayout = this.f10743c;
        if (frameLayout != null) {
            frameLayout.post(new Runnable() { // from class: com.tianmu.ad.widget.nativeadview.factory.NativeTemplateBottomPicFlow.1
                @Override // java.lang.Runnable
                public void run() {
                    NativeTemplateBottomPicFlow nativeTemplateBottomPicFlow = NativeTemplateBottomPicFlow.this;
                    nativeTemplateBottomPicFlow.setInteractSubStyle(nativeTemplateBottomPicFlow.x, NativeTemplateBottomPicFlow.this.y);
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
        this.o = ((LayoutInflater) this.l.getSystemService("layout_inflater")).inflate(m.f11436a, (ViewGroup) null);
        if (this.m.getAdContainerWidth() > 0 || this.m.getAdContainerHeight() > 0) {
            int adContainerWidth = this.m.getAdContainerWidth();
            this.u = adContainerWidth;
            this.v = (adContainerWidth * 9) / 16;
        } else {
            this.u = -1;
            this.v = -2;
        }
        if (this.m.getAdContainerWidth() > 0 || this.m.getAdContainerHeight() > 0) {
            int adContainerWidth2 = (this.m.getAdContainerWidth() - this.m.getAdContainerPadding().getLeft()) - this.m.getAdContainerPadding().getRight();
            this.x = adContainerWidth2;
            this.y = (adContainerWidth2 * 9) / 16;
        } else {
            this.x = -1;
            this.y = -2;
        }
        RelativeLayout relativeLayout = (RelativeLayout) this.o.findViewById(m.f11437b);
        this.f10741a = relativeLayout;
        relativeLayout.setPadding(this.m.getAdContainerPadding().getLeft(), this.m.getAdContainerPadding().getTop(), this.m.getAdContainerPadding().getRight(), this.m.getAdContainerPadding().getBottom());
        this.f10741a.setBackground(getDrawableBg(this.m.getAdContainerRadius(), this.m.getAdContainerColor()));
        this.f10749i = (TextView) this.o.findViewById(m.f11438c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f10749i.getLayoutParams());
        layoutParams.setMargins(this.m.getAdDescMargin().getLeft(), this.m.getAdDescMargin().getTop(), this.m.getAdDescMargin().getRight(), this.m.getAdDescMargin().getBottom());
        this.f10749i.setLayoutParams(layoutParams);
        this.f10749i.setTextSize(this.m.getAdDescText().getSize());
        this.f10749i.setTextColor(Color.parseColor(this.m.getAdDescText().getColor()));
        this.f10749i.setBackground(getDrawableBg(this.m.getAdDescText().getBgRadius(), this.m.getAdDescText().getBg()));
        this.f10749i.setMaxLines(this.m.getAdDescText().getMaxLines());
        this.f10749i.setPadding(this.m.getAdDescPadding().getLeft(), this.m.getAdDescPadding().getTop(), this.m.getAdDescPadding().getRight(), this.m.getAdDescPadding().getBottom());
        this.f10743c = (FrameLayout) this.o.findViewById(m.f11439d);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.x, this.y);
        layoutParams2.setMargins(this.m.getAdImageMargin().getLeft(), this.m.getAdImageMargin().getTop(), this.m.getAdImageMargin().getRight(), this.m.getAdImageMargin().getBottom());
        layoutParams2.addRule(3, this.f10749i.getId());
        this.f10743c.setLayoutParams(layoutParams2);
        this.f10744d = (FrameLayout) this.o.findViewById(m.f11440e);
        this.f10746f = (TextView) this.o.findViewById(m.f11441f);
        this.f10747g = (TextView) this.o.findViewById(m.f11442g);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.m.getAdTypeSize().getWidth(), this.m.getAdTypeSize().getHeight());
        layoutParams3.setMargins(this.m.getAdTypeMargin().getLeft(), this.m.getAdTypeMargin().getTop(), this.m.getAdTypeMargin().getRight(), this.m.getAdTypeMargin().getBottom());
        int adTypePosition = this.m.getAdTypePosition();
        if (adTypePosition == 0) {
            layoutParams3.addRule(6, this.f10743c.getId());
            layoutParams3.addRule(5, this.f10743c.getId());
        } else if (adTypePosition == 1) {
            layoutParams3.addRule(6, this.f10743c.getId());
            layoutParams3.addRule(7, this.f10743c.getId());
        } else if (adTypePosition == 2) {
            layoutParams3.addRule(8, this.f10743c.getId());
            layoutParams3.addRule(5, this.f10743c.getId());
        } else if (adTypePosition == 3) {
            layoutParams3.addRule(8, this.f10743c.getId());
            layoutParams3.addRule(7, this.f10743c.getId());
        }
        this.f10746f.setLayoutParams(layoutParams3);
        TextView textView = (TextView) this.o.findViewById(m.f11443h);
        this.j = textView;
        textView.setTextSize(this.m.getAdActionText().getSize());
        this.j.setTextColor(Color.parseColor(this.m.getAdActionText().getColor()));
        this.f10748h = (TextView) this.o.findViewById(m.f11444i);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.f10748h.getLayoutParams());
        layoutParams4.setMargins(this.m.getAdTitleMargin().getLeft(), this.m.getAdTitleMargin().getTop(), this.m.getAdTitleMargin().getRight(), this.m.getAdTitleMargin().getBottom());
        layoutParams4.addRule(3, this.f10743c.getId());
        layoutParams4.addRule(0, this.j.getId());
        this.f10748h.setLayoutParams(layoutParams4);
        this.f10748h.setTextSize(this.m.getAdTitleText().getSize());
        this.f10748h.setTextColor(Color.parseColor(this.m.getAdTitleText().getColor()));
        this.f10748h.setBackground(getDrawableBg(this.m.getAdTitleText().getBgRadius(), this.m.getAdTitleText().getBg()));
        this.f10748h.setMaxLines(this.m.getAdTitleText().getMaxLines());
        this.f10748h.setPadding(this.m.getAdTitlePadding().getLeft(), this.m.getAdTitlePadding().getTop(), this.m.getAdTitlePadding().getRight(), this.m.getAdTitlePadding().getBottom());
        this.k = (ImageView) this.o.findViewById(m.j);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(this.k.getLayoutParams());
        layoutParams5.setMargins(this.m.getAdCloseMargin().getLeft(), this.m.getAdCloseMargin().getTop(), this.m.getAdCloseMargin().getRight(), this.m.getAdCloseMargin().getBottom());
        int adClosePosition = this.m.getAdClosePosition();
        if (adClosePosition == 0) {
            layoutParams5.addRule(6, this.f10749i.getId());
            layoutParams5.addRule(9);
        } else if (adClosePosition == 1) {
            layoutParams5.addRule(6, this.f10749i.getId());
            layoutParams5.addRule(11);
        } else if (adClosePosition == 2) {
            layoutParams5.addRule(8, this.f10748h.getId());
            layoutParams5.addRule(9);
        } else if (adClosePosition == 3) {
            layoutParams5.addRule(8, this.f10748h.getId());
            layoutParams5.addRule(11);
        }
        this.k.setLayoutParams(layoutParams5);
        b();
        TianmuViewUtil.addAdViewToAdContainer(this, this.o, new ViewGroup.LayoutParams(this.u, -2));
    }

    private void b() {
        try {
            SpannableStringBuilder spannableStringBuilderA = a();
            if (spannableStringBuilderA == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.rightMargin = TianmuDisplayUtil.dp2px(46);
            layoutParams.addRule(9);
            layoutParams.addRule(6, this.f10743c.getId());
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
}

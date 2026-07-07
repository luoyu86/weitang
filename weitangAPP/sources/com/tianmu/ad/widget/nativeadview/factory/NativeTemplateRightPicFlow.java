package com.tianmu.ad.widget.nativeadview.factory;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tianmu.ad.bean.NativeExpressAdInfo;
import com.tianmu.ad.widget.nativeadview.config.NativeConfig;
import com.tianmu.c.f.n0;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public class NativeTemplateRightPicFlow extends NativeBase {
    public NativeTemplateRightPicFlow(Context context, NativeConfig nativeConfig, NativeExpressAdInfo nativeExpressAdInfo) {
        super(context, nativeConfig, nativeExpressAdInfo);
    }

    private int a(NativeConfig nativeConfig) {
        if (nativeConfig.getAdContainerWidth() <= 0) {
            return 378;
        }
        return (int) (((double) ((nativeConfig.getAdContainerWidth() - (nativeConfig.getAdContainerPadding().getLeft() + nativeConfig.getAdContainerPadding().getRight())) - (nativeConfig.getAdImageMargin().getLeft() + nativeConfig.getAdImageMargin().getLeft()))) * 0.35d);
    }

    @Override // com.tianmu.ad.widget.nativeadview.factory.NativeBase
    public View getNativeView() {
        return this;
    }

    @Override // com.tianmu.ad.widget.nativeadview.factory.NativeBase
    public void setAdMaterial() {
    }

    @Override // com.tianmu.ad.widget.nativeadview.factory.NativeBase
    public void setConfigView() {
        View viewInflate = ((LayoutInflater) this.l.getSystemService("layout_inflater")).inflate(n0.f11456a, (ViewGroup) null);
        this.o = viewInflate;
        this.f10746f = (TextView) viewInflate.findViewById(n0.f11457b);
        this.f10747g = (TextView) this.o.findViewById(n0.f11458c);
        this.f10741a = (RelativeLayout) this.o.findViewById(n0.f11459d);
        this.f10741a.setBackground(getDrawableBg(this.m.getAdContainerRadius(), this.m.getAdContainerColor()));
        RelativeLayout relativeLayout = (RelativeLayout) this.o.findViewById(n0.f11460e);
        this.f10742b = relativeLayout;
        relativeLayout.setPadding(this.m.getAdContainerPadding().getLeft(), this.m.getAdContainerPadding().getTop(), this.m.getAdContainerPadding().getRight(), this.m.getAdContainerPadding().getBottom());
        int iA = a(this.m);
        this.f10745e = (ImageView) this.o.findViewById(n0.f11461f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, (iA * 9) / 16);
        layoutParams.addRule(11);
        this.f10745e.setLayoutParams(layoutParams);
        TextView textView = (TextView) this.o.findViewById(n0.f11462g);
        this.f10748h = textView;
        textView.setTextSize(this.m.getAdTitleText().getSize());
        this.f10748h.setTextColor(Color.parseColor(this.m.getAdTitleText().getColor()));
        TextView textView2 = (TextView) this.o.findViewById(n0.f11463h);
        this.f10749i = textView2;
        textView2.setTextSize(this.m.getAdDescText().getSize());
        this.f10749i.setTextColor(Color.parseColor(this.m.getAdDescText().getColor()));
        this.f10749i.post(new Runnable() { // from class: com.tianmu.ad.widget.nativeadview.factory.NativeTemplateRightPicFlow.1
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressAdInfo nativeExpressAdInfo = NativeTemplateRightPicFlow.this.n;
                if (nativeExpressAdInfo == null || TextUtils.isEmpty(nativeExpressAdInfo.getDesc())) {
                    return;
                }
                if (NativeTemplateRightPicFlow.this.f10749i.getPaint().measureText(NativeTemplateRightPicFlow.this.n.getDesc()) > NativeTemplateRightPicFlow.this.f10749i.getWidth()) {
                    NativeTemplateRightPicFlow.this.f10749i.setGravity(1);
                }
            }
        });
        this.k = (ImageView) this.o.findViewById(n0.f11464i);
        TianmuViewUtil.addAdViewToAdContainer(this, this.o, new ViewGroup.LayoutParams(-1, -2));
    }
}

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
import com.tianmu.c.f.f0;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public class NativeTemplateLeftPicFlow extends NativeBase {
    public NativeTemplateLeftPicFlow(Context context, NativeConfig nativeConfig, NativeExpressAdInfo nativeExpressAdInfo) {
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
        View viewInflate = ((LayoutInflater) this.l.getSystemService("layout_inflater")).inflate(f0.f11356a, (ViewGroup) null);
        this.o = viewInflate;
        this.f10746f = (TextView) viewInflate.findViewById(f0.f11357b);
        this.f10747g = (TextView) this.o.findViewById(f0.f11358c);
        this.f10741a = (RelativeLayout) this.o.findViewById(f0.f11359d);
        this.f10741a.setBackground(getDrawableBg(this.m.getAdContainerRadius(), this.m.getAdContainerColor()));
        RelativeLayout relativeLayout = (RelativeLayout) this.o.findViewById(f0.f11360e);
        this.f10742b = relativeLayout;
        relativeLayout.setPadding(this.m.getAdContainerPadding().getLeft(), this.m.getAdContainerPadding().getTop(), this.m.getAdContainerPadding().getRight(), this.m.getAdContainerPadding().getBottom());
        int iA = a(this.m);
        this.f10745e = (ImageView) this.o.findViewById(f0.f11361f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, (iA * 9) / 16);
        layoutParams.addRule(9);
        this.f10745e.setLayoutParams(layoutParams);
        TextView textView = (TextView) this.o.findViewById(f0.f11362g);
        this.f10748h = textView;
        textView.setTextSize(this.m.getAdTitleText().getSize());
        this.f10748h.setTextColor(Color.parseColor(this.m.getAdTitleText().getColor()));
        TextView textView2 = (TextView) this.o.findViewById(f0.f11363h);
        this.f10749i = textView2;
        textView2.setTextSize(this.m.getAdDescText().getSize());
        this.f10749i.setTextColor(Color.parseColor(this.m.getAdDescText().getColor()));
        this.f10749i.post(new Runnable() { // from class: com.tianmu.ad.widget.nativeadview.factory.NativeTemplateLeftPicFlow.1
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressAdInfo nativeExpressAdInfo = NativeTemplateLeftPicFlow.this.n;
                if (nativeExpressAdInfo == null || TextUtils.isEmpty(nativeExpressAdInfo.getDesc())) {
                    return;
                }
                if (NativeTemplateLeftPicFlow.this.f10749i.getPaint().measureText(NativeTemplateLeftPicFlow.this.n.getDesc()) > NativeTemplateLeftPicFlow.this.f10749i.getWidth()) {
                    NativeTemplateLeftPicFlow.this.f10749i.setGravity(1);
                }
            }
        });
        this.k = (ImageView) this.o.findViewById(f0.f11364i);
        TianmuViewUtil.addAdViewToAdContainer(this, this.o, new ViewGroup.LayoutParams(-1, -2));
    }
}

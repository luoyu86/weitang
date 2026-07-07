package com.tianmu.ad.widget.banneradview.factory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tianmu.c.f.h;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class BannerAdLeftPicView extends BannerBase {
    public BannerAdLeftPicView(Context context) {
        super(context);
    }

    @Override // com.tianmu.ad.widget.banneradview.factory.BannerBase
    public View getClickView() {
        return this.j;
    }

    @Override // com.tianmu.ad.widget.banneradview.factory.BannerBase
    public View getView() {
        return this.j;
    }

    @Override // com.tianmu.ad.widget.banneradview.factory.BannerBase
    public void initView() {
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(h.f11377a, (ViewGroup) this, false);
        this.j = viewGroup;
        this.f10694a = (ImageView) viewGroup.findViewById(h.f11378b);
        this.f10695b = (LinearLayout) this.j.findViewById(h.f11379c);
        this.f10696c = (TextView) this.j.findViewById(h.f11380d);
        this.f10697d = (TextView) this.j.findViewById(h.f11381e);
        this.f10698e = (TextView) this.j.findViewById(h.f11382f);
        this.f10700g = (TextView) this.j.findViewById(h.f11383g);
        this.f10699f = (TextView) this.j.findViewById(h.f11384h);
        this.f10701h = (ImageView) this.j.findViewById(h.f11385i);
    }

    @Override // com.tianmu.ad.widget.banneradview.factory.BannerBase
    public void setConfigView(int i2, int i3) {
        int iMin = Math.min((i3 * 16) / 9, i2 / 2);
        int i4 = i3 / 8;
        int iMin2 = Math.min(16, TianmuDisplayUtil.px2dp(i4) + 6);
        int iMin3 = Math.min(14, TianmuDisplayUtil.px2dp(i4) + 5);
        ImageView imageView = this.f10694a;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = iMin;
            layoutParams.height = i3;
            this.f10694a.setLayoutParams(layoutParams);
        }
        TextView textView = this.f10696c;
        if (textView != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams2.setMargins(0, 0, 0, 0);
            this.f10696c.setLayoutParams(layoutParams2);
            this.f10696c.setTextSize(iMin2);
        }
        TextView textView2 = this.f10697d;
        if (textView2 != null) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) textView2.getLayoutParams();
            layoutParams3.setMargins(0, Math.min(TianmuDisplayUtil.dp2px(8), i4), 0, 0);
            this.f10697d.setLayoutParams(layoutParams3);
            this.f10697d.setTextSize(iMin3);
        }
        this.f10695b.setGravity(16);
    }
}

package com.tianmu.ad.widget.banneradview.factory;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tianmu.c.f.g;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class BannerAdLeftPic150View extends BannerBase {
    public BannerAdLeftPic150View(Context context, String str) {
        super(context, str);
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
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(g.f11365a, (ViewGroup) this, false);
        this.j = viewGroup;
        this.f10694a = (ImageView) viewGroup.findViewById(g.f11366b);
        this.f10695b = (LinearLayout) this.j.findViewById(g.f11367c);
        this.f10696c = (TextView) this.j.findViewById(g.f11368d);
        this.f10697d = (TextView) this.j.findViewById(g.f11369e);
        this.f10698e = (TextView) this.j.findViewById(g.f11370f);
        this.f10700g = (TextView) this.j.findViewById(g.f11371g);
        this.f10699f = (TextView) this.j.findViewById(g.f11372h);
        this.f10701h = (ImageView) this.j.findViewById(g.f11373i);
    }

    @Override // com.tianmu.ad.widget.banneradview.factory.BannerBase
    public void setConfigView(int i2, int i3) {
        int iMin = Math.min((i3 * 16) / 9, i2 / 2);
        int i4 = i3 / 10;
        int iMin2 = Math.min(16, TianmuDisplayUtil.px2dp(i4) + 6);
        int iMin3 = Math.min(14, TianmuDisplayUtil.px2dp(i4) + 5);
        ImageView imageView = this.f10694a;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = iMin;
            layoutParams.height = i3;
            this.f10694a.setLayoutParams(layoutParams);
        }
        if (this.f10696c != null) {
            int iMin4 = !TextUtils.isEmpty(this.f10702i) ? Math.min(TianmuDisplayUtil.dp2px(10), i4) : 0;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f10696c.getLayoutParams();
            layoutParams2.setMargins(0, iMin4, 0, 0);
            this.f10696c.setLayoutParams(layoutParams2);
            this.f10696c.setTextSize(iMin2);
        }
        TextView textView = this.f10697d;
        if (textView != null) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams3.setMargins(0, Math.min(TianmuDisplayUtil.dp2px(10), i4), 0, 0);
            this.f10697d.setLayoutParams(layoutParams3);
            this.f10697d.setTextSize(iMin3);
            this.f10697d.setMaxLines(2);
        }
        TextView textView2 = this.f10698e;
        if (textView2 != null) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
            int iMin5 = Math.min(TianmuDisplayUtil.dp2px(25), TianmuDisplayUtil.dp2px(iMin3 * 2));
            layoutParams4.height = iMin5;
            layoutParams4.width = (iMin5 * 16) / 5;
            this.f10698e.setLayoutParams(layoutParams4);
            this.f10698e.setTextSize(iMin3);
        }
        if (TextUtils.isEmpty(this.f10702i)) {
            this.f10695b.setGravity(16);
            this.f10698e.setVisibility(8);
        } else {
            this.f10698e.setVisibility(0);
            this.f10698e.setText(this.f10702i);
        }
    }
}

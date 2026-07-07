package com.tianmu.ad.widget.banneradview.factory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tianmu.c.f.i;

/* JADX INFO: loaded from: classes2.dex */
public class BannerAdPicView extends BannerBase {
    public BannerAdPicView(Context context) {
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
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(i.f11388a, (ViewGroup) this, false);
        this.j = viewGroup;
        this.f10694a = (ImageView) viewGroup.findViewById(i.f11389b);
        this.f10700g = (TextView) this.j.findViewById(i.f11390c);
        this.f10699f = (TextView) this.j.findViewById(i.f11391d);
        this.f10701h = (ImageView) this.j.findViewById(i.f11392e);
    }

    @Override // com.tianmu.ad.widget.banneradview.factory.BannerBase
    public void setConfigView(int i2, int i3) {
    }
}

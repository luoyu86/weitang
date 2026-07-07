package com.tianmu.ad.widget.nativeadview.config;

import com.tianmu.ad.widget.nativeadview.model.NativeAction;
import com.tianmu.ad.widget.nativeadview.model.NativeDesc;
import com.tianmu.ad.widget.nativeadview.model.NativeMargin;
import com.tianmu.ad.widget.nativeadview.model.NativePadding;
import com.tianmu.ad.widget.nativeadview.model.NativeSize;
import com.tianmu.ad.widget.nativeadview.model.NativeTitle;

/* JADX INFO: loaded from: classes2.dex */
public class NativeConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10730a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10731b = -2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10732c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10733d = "#00FFFFFF";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private NativePadding f10734e = new NativePadding();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private NativeMargin f10735f = new NativeMargin();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private NativeSize f10736g = new NativeSize();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10737h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private NativeSize f10738i = new NativeSize();
    private NativeMargin j = new NativeMargin();
    private NativeTitle k = new NativeTitle();
    private NativeMargin l = new NativeMargin();
    private NativePadding m = new NativePadding();
    private NativeAction n = new NativeAction();
    private NativeDesc o = new NativeDesc();
    private NativeMargin p = new NativeMargin();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private NativePadding f10739q = new NativePadding();
    private int r = 1;
    private NativeMargin s = new NativeMargin();
    private NativeSize t = new NativeSize();

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private NativeConfig f10740a = new NativeConfig();

        public NativeConfig build() {
            return this.f10740a;
        }

        public Builder setAdActionText(NativeAction nativeAction) {
            this.f10740a.n = nativeAction;
            return this;
        }

        public Builder setAdCloseMargin(NativeMargin nativeMargin) {
            this.f10740a.s = nativeMargin;
            return this;
        }

        public Builder setAdClosePosition(int i2) {
            this.f10740a.r = i2;
            return this;
        }

        public Builder setAdCloseSize(NativeSize nativeSize) {
            this.f10740a.t = nativeSize;
            return this;
        }

        public Builder setAdContainerColor(String str) {
            this.f10740a.f10733d = str;
            return this;
        }

        public Builder setAdContainerHeight(int i2) {
            this.f10740a.f10731b = i2;
            return this;
        }

        public Builder setAdContainerPadding(NativePadding nativePadding) {
            this.f10740a.f10734e = nativePadding;
            return this;
        }

        public Builder setAdContainerRadius(int i2) {
            this.f10740a.f10732c = i2;
            return this;
        }

        public Builder setAdContainerWidth(int i2) {
            this.f10740a.f10730a = i2;
            return this;
        }

        public Builder setAdDescMargin(NativeMargin nativeMargin) {
            this.f10740a.p = nativeMargin;
            return this;
        }

        public Builder setAdDescPadding(NativePadding nativePadding) {
            this.f10740a.f10739q = nativePadding;
            return this;
        }

        public Builder setAdDescText(NativeDesc nativeDesc) {
            this.f10740a.o = nativeDesc;
            return this;
        }

        public Builder setAdImageMargin(NativeMargin nativeMargin) {
            this.f10740a.f10735f = nativeMargin;
            return this;
        }

        public Builder setAdImageSize(NativeSize nativeSize) {
            this.f10740a.f10736g = nativeSize;
            return this;
        }

        public Builder setAdTitleMargin(NativeMargin nativeMargin) {
            this.f10740a.l = nativeMargin;
            return this;
        }

        public Builder setAdTitlePadding(NativePadding nativePadding) {
            this.f10740a.m = nativePadding;
            return this;
        }

        public Builder setAdTitleText(NativeTitle nativeTitle) {
            this.f10740a.k = nativeTitle;
            return this;
        }

        public Builder setAdTypeMargin(NativeMargin nativeMargin) {
            this.f10740a.j = nativeMargin;
            return this;
        }

        public Builder setAdTypePosition(int i2) {
            this.f10740a.f10737h = i2;
            return this;
        }

        public Builder setAdTypeSize(NativeSize nativeSize) {
            this.f10740a.f10738i = nativeSize;
            return this;
        }
    }

    public NativeAction getAdActionText() {
        return this.n;
    }

    public NativeMargin getAdCloseMargin() {
        return this.s;
    }

    public int getAdClosePosition() {
        return this.r;
    }

    public NativeSize getAdCloseSize() {
        return this.t;
    }

    public String getAdContainerColor() {
        return this.f10733d;
    }

    public int getAdContainerHeight() {
        return this.f10731b;
    }

    public NativePadding getAdContainerPadding() {
        return this.f10734e;
    }

    public int getAdContainerRadius() {
        return this.f10732c;
    }

    public int getAdContainerWidth() {
        return this.f10730a;
    }

    public NativeMargin getAdDescMargin() {
        return this.p;
    }

    public NativePadding getAdDescPadding() {
        return this.f10739q;
    }

    public NativeDesc getAdDescText() {
        return this.o;
    }

    public NativeMargin getAdImageMargin() {
        return this.f10735f;
    }

    public NativeSize getAdImageSize() {
        return this.f10736g;
    }

    public NativeMargin getAdTitleMargin() {
        return this.l;
    }

    public NativePadding getAdTitlePadding() {
        return this.m;
    }

    public NativeTitle getAdTitleText() {
        return this.k;
    }

    public NativeMargin getAdTypeMargin() {
        return this.j;
    }

    public int getAdTypePosition() {
        return this.f10737h;
    }

    public NativeSize getAdTypeSize() {
        return this.f10738i;
    }
}

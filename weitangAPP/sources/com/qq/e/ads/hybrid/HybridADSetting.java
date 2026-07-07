package com.qq.e.ads.hybrid;

/* JADX INFO: loaded from: classes2.dex */
public class HybridADSetting {
    public static final int TYPE_REWARD_VIDEO = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f9579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f9580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f9581h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9574a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9575b = 44;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9576c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9577d = -14013133;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9578e = 16;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9582i = -1776153;
    public int j = 16;

    public HybridADSetting backButtonImage(String str) {
        this.f9580g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i2) {
        this.j = i2;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f9581h = str;
        return this;
    }

    public String getBackButtonImage() {
        return this.f9580g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public String getCloseButtonImage() {
        return this.f9581h;
    }

    public int getSeparatorColor() {
        return this.f9582i;
    }

    public String getTitle() {
        return this.f9579f;
    }

    public int getTitleBarColor() {
        return this.f9576c;
    }

    public int getTitleBarHeight() {
        return this.f9575b;
    }

    public int getTitleColor() {
        return this.f9577d;
    }

    public int getTitleSize() {
        return this.f9578e;
    }

    public int getType() {
        return this.f9574a;
    }

    public HybridADSetting separatorColor(int i2) {
        this.f9582i = i2;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f9579f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i2) {
        this.f9576c = i2;
        return this;
    }

    public HybridADSetting titleBarHeight(int i2) {
        this.f9575b = i2;
        return this;
    }

    public HybridADSetting titleColor(int i2) {
        this.f9577d = i2;
        return this;
    }

    public HybridADSetting titleSize(int i2) {
        this.f9578e = i2;
        return this;
    }

    public HybridADSetting type(int i2) {
        this.f9574a = i2;
        return this;
    }
}

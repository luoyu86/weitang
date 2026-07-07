package com.tianmu.biz.bean;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialStyleBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10825a = 16;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Typeface f10826b = Typeface.DEFAULT;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10827c = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f10828d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10829e = "#ffffff";

    public InterstitialStyleBean() {
        setTipsSize(20);
        setTipsColor("#ffffff");
        setShade(true);
        setTipsMargin(10);
        setTipsStyle(Typeface.DEFAULT_BOLD);
    }

    public String getTipsColor() {
        return this.f10829e;
    }

    public int getTipsMargin() {
        return this.f10827c;
    }

    public int getTipsSize() {
        return this.f10825a;
    }

    public Typeface getTipsStyle() {
        return this.f10826b;
    }

    public boolean isShade() {
        return this.f10828d;
    }

    public void setShade(boolean z) {
        this.f10828d = z;
    }

    public void setTipsColor(String str) {
        this.f10829e = str;
    }

    public void setTipsMargin(int i2) {
        this.f10827c = i2;
    }

    public void setTipsSize(int i2) {
        this.f10825a = i2;
    }

    public void setTipsStyle(Typeface typeface) {
        this.f10826b = typeface;
    }
}

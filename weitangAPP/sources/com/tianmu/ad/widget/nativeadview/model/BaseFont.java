package com.tianmu.ad.widget.nativeadview.model;

/* JADX INFO: loaded from: classes2.dex */
public class BaseFont {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10764a = 14;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10765b = "#ff000000";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10766c = "#00ffffff";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10767d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10768e = 1;

    public String getBg() {
        return this.f10766c;
    }

    public int getBgRadius() {
        return this.f10767d;
    }

    public String getColor() {
        return this.f10765b;
    }

    public int getMaxLines() {
        return this.f10768e;
    }

    public int getSize() {
        return this.f10764a;
    }

    public void setBg(String str) {
        this.f10766c = str;
    }

    public void setBgRadius(int i2) {
        this.f10767d = i2;
    }

    public void setColor(String str) {
        this.f10765b = str;
    }

    public void setMaxLines(int i2) {
        this.f10768e = i2;
    }

    public void setSize(int i2) {
        this.f10764a = i2;
    }
}

package com.tianmu.ad.entity;

/* JADX INFO: loaded from: classes2.dex */
public class AdNativeStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10675f;

    public AdNativeStyle(int i2) {
        this.f10670a = i2;
        this.f10671b = i2;
        this.f10672c = i2;
        this.f10673d = i2;
    }

    public int getContainerPaddingBottom() {
        return this.f10673d;
    }

    public int getContainerPaddingLeft() {
        return this.f10670a;
    }

    public int getContainerPaddingRight() {
        return this.f10672c;
    }

    public int getContainerPaddingTop() {
        return this.f10671b;
    }

    public int getDescSize() {
        return this.f10675f;
    }

    public int getTitleSize() {
        return this.f10674e;
    }

    public void setDescSize(int i2) {
        this.f10675f = i2;
    }

    public void setTitleSize(int i2) {
        this.f10674e = i2;
    }

    public AdNativeStyle(int i2, int i3, int i4, int i5) {
        this.f10670a = i2;
        this.f10671b = i3;
        this.f10672c = i4;
        this.f10673d = i5;
    }
}

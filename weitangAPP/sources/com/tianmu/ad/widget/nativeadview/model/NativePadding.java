package com.tianmu.ad.widget.nativeadview.model;

/* JADX INFO: loaded from: classes2.dex */
public class NativePadding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10776d;

    public NativePadding() {
    }

    public int getBottom() {
        return this.f10776d;
    }

    public int getLeft() {
        return this.f10773a;
    }

    public int getRight() {
        return this.f10775c;
    }

    public int getTop() {
        return this.f10774b;
    }

    public NativePadding(int i2) {
        this.f10773a = i2;
        this.f10774b = i2;
        this.f10775c = i2;
        this.f10776d = i2;
    }

    public NativePadding(int i2, int i3, int i4, int i5) {
        this.f10773a = i2;
        this.f10774b = i3;
        this.f10775c = i4;
        this.f10776d = i5;
    }
}

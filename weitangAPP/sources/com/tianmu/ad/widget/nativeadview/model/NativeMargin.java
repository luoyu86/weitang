package com.tianmu.ad.widget.nativeadview.model;

/* JADX INFO: loaded from: classes2.dex */
public class NativeMargin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10772d;

    public NativeMargin() {
    }

    public int getBottom() {
        return this.f10772d;
    }

    public int getLeft() {
        return this.f10769a;
    }

    public int getRight() {
        return this.f10771c;
    }

    public int getTop() {
        return this.f10770b;
    }

    public NativeMargin(int i2) {
        this.f10769a = i2;
        this.f10770b = i2;
        this.f10771c = i2;
        this.f10772d = i2;
    }

    public NativeMargin(int i2, int i3, int i4, int i5) {
        this.f10769a = i2;
        this.f10770b = i3;
        this.f10771c = i4;
        this.f10772d = i5;
    }
}

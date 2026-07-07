package com.tianmu.biz.widget.interaction.slideanimalview.b;

import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11051i;
    private boolean j;

    public a() {
        this.f11043a = 60;
        this.f11044b = 69;
        this.f11045c = 20;
        this.f11046d = 0;
        this.f11047e = 0;
        this.f11048f = 0;
        this.f11049g = 0;
        this.f11050h = 0;
        this.f11043a = 60;
        this.f11044b = 69;
        this.f11045c = 20;
        this.f11046d = 0;
        this.f11047e = TianmuDisplayUtil.dp2px(20);
        this.f11048f = 0;
        this.f11049g = TianmuDisplayUtil.dp2px(20);
        this.f11050h = TianmuDisplayUtil.dp2px(50);
    }

    public int a() {
        return this.f11044b;
    }

    public int b() {
        return this.f11043a;
    }

    public int c() {
        return this.f11045c;
    }

    public int d() {
        return this.f11046d;
    }

    public int e() {
        return this.f11051i;
    }

    public int f() {
        return this.f11050h;
    }

    public int g() {
        return this.f11047e;
    }

    public int h() {
        return this.f11049g;
    }

    public int i() {
        return this.f11048f;
    }

    public boolean j() {
        return this.j;
    }

    public a(int i2) {
        this.f11043a = 60;
        this.f11044b = 69;
        this.f11045c = 20;
        this.f11046d = 0;
        this.f11047e = 0;
        this.f11048f = 0;
        this.f11049g = 0;
        this.f11050h = 0;
        this.f11043a = 70;
        this.f11044b = 80;
        this.f11045c = 70 / 3;
        this.f11046d = -10;
        this.f11047e = TianmuDisplayUtil.dp2px(20);
        this.f11048f = TianmuDisplayUtil.dp2px(25);
        this.f11049g = TianmuDisplayUtil.dp2px(20);
        this.f11051i = TianmuDisplayUtil.dp2px(10);
        this.j = true;
        if (i2 == 23) {
            this.f11050h = TianmuDisplayUtil.dp2px(50);
        } else {
            this.f11050h = TianmuDisplayUtil.dp2px(35);
        }
    }
}

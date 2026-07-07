package com.tianmu.biz.widget.o;

import android.widget.ImageView;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f11157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f11158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f11159c;

    public b(double d2, double d3) {
        this.f11157a = d2;
        this.f11158b = d3;
    }

    public ImageView a() {
        return this.f11159c;
    }

    public double b() {
        return this.f11157a;
    }

    public double c() {
        return this.f11158b;
    }

    public void d() {
        TianmuViewUtil.removeSelfFromParent(this.f11159c);
    }

    public void a(ImageView imageView) {
        this.f11159c = imageView;
    }
}

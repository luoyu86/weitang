package com.ss.android.socialbase.downloader.network;

import androidx.appcompat.widget.ActivityChooserView;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10140a;
    private double bl = -1.0d;
    private final double ok;
    private int s;

    public s(double d2) {
        this.ok = d2;
        this.f10140a = d2 == 0.0d ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) Math.ceil(1.0d / d2);
    }

    public void ok(double d2) {
        double d3 = 1.0d - this.ok;
        int i2 = this.s;
        if (i2 > this.f10140a) {
            this.bl = Math.exp((d3 * Math.log(this.bl)) + (this.ok * Math.log(d2)));
        } else if (i2 > 0) {
            double d4 = (d3 * ((double) i2)) / (((double) i2) + 1.0d);
            this.bl = Math.exp((d4 * Math.log(this.bl)) + ((1.0d - d4) * Math.log(d2)));
        } else {
            this.bl = d2;
        }
        this.s++;
    }

    public double ok() {
        return this.bl;
    }
}

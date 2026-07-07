package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes.dex */
public class TTLocation implements LocationProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f6316a;
    private double ok;

    public TTLocation(double d2, double d3) {
        this.ok = 0.0d;
        this.f6316a = 0.0d;
        this.ok = d2;
        this.f6316a = d3;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.ok;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.f6316a;
    }

    public void setLatitude(double d2) {
        this.ok = d2;
    }

    public void setLongitude(double d2) {
        this.f6316a = d2;
    }
}

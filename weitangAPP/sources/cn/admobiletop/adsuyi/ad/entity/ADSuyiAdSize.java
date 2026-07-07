package cn.admobiletop.adsuyi.ad.entity;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiAdSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3509b;

    public ADSuyiAdSize(int i2) {
        this(i2, 0);
    }

    public int getHeight() {
        return this.f3509b;
    }

    public int getWidth() {
        return this.f3508a;
    }

    public void setHeight(int i2) {
        this.f3509b = i2;
    }

    public void setWidth(int i2) {
        this.f3508a = i2;
    }

    public ADSuyiAdSize(int i2, int i3) {
        this.f3508a = i2;
        this.f3509b = i3;
    }
}

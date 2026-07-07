package com.bytedance.pangle.f.a;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f6057a = new int[32];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6059c;

    public final void a() {
        b();
        int i2 = this.f6058b;
        int[] iArr = this.f6057a;
        iArr[i2] = 0;
        iArr[i2 + 1] = 0;
        this.f6058b = i2 + 2;
        this.f6059c++;
    }

    public final void b() {
        int[] iArr = this.f6057a;
        int length = iArr.length;
        int i2 = this.f6058b;
        int i3 = length - i2;
        if (i3 <= 2) {
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f6057a = iArr2;
        }
    }
}

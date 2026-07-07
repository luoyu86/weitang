package com.tianmu.g;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f12105b = new o("NO_CACHE", 0, 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f12106c = new o("NO_STORE", 1, 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12107a;

    private o(String str, int i2, int i3) {
        this.f12107a = i3;
    }

    public static boolean a(int i2) {
        return (i2 & f12105b.f12107a) == 0;
    }

    public static boolean b(int i2) {
        return (i2 & f12106c.f12107a) == 0;
    }
}

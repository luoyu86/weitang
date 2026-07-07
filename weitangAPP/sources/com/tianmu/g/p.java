package com.tianmu.g;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f12108b = new p("NO_CACHE", 0, 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p f12109c = new p("NO_STORE", 1, 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f12110d = new p("OFFLINE", 2, 4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12111a;

    private p(String str, int i2, int i3) {
        this.f12111a = i3;
    }

    public static boolean a(int i2) {
        return (i2 & f12110d.f12111a) != 0;
    }

    public static boolean b(int i2) {
        return (i2 & f12108b.f12111a) == 0;
    }

    public static boolean c(int i2) {
        return (i2 & f12109c.f12111a) == 0;
    }
}

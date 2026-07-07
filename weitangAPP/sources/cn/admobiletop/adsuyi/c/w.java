package cn.admobiletop.adsuyi.c;

/* JADX INFO: loaded from: classes.dex */
public enum w {
    NO_CACHE(1),
    NO_STORE(2);


    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4282d;

    w(int i2) {
        this.f4282d = i2;
    }

    public static boolean a(int i2) {
        return (i2 & NO_CACHE.f4282d) == 0;
    }

    public static boolean b(int i2) {
        return (i2 & NO_STORE.f4282d) == 0;
    }
}

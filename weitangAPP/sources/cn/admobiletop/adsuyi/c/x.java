package cn.admobiletop.adsuyi.c;

/* JADX INFO: loaded from: classes.dex */
public enum x {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4287e;

    x(int i2) {
        this.f4287e = i2;
    }

    public static boolean a(int i2) {
        return (i2 & OFFLINE.f4287e) != 0;
    }

    public static boolean b(int i2) {
        return (i2 & NO_CACHE.f4287e) == 0;
    }

    public static boolean c(int i2) {
        return (i2 & NO_STORE.f4287e) == 0;
    }
}

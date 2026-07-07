package com.bytedance.pangle.log;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f6132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f6133e;

    private a(String str, String str2, String str3) {
        this.f6129a = str;
        this.f6130b = str2;
        this.f6131c = str3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f6133e = jCurrentTimeMillis;
        this.f6132d = jCurrentTimeMillis;
        ZeusLogger.i(this.f6129a, this.f6130b + String.format(" watcher[%s]-start", str3));
    }

    public static a a(String str, String str2, String str3) {
        return new a(str, str2, str3);
    }

    public final long a(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f6133e;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - this.f6132d;
        ZeusLogger.i(this.f6129a, this.f6130b + String.format(" watcher[%s]-%s cost=%s, total=%s", this.f6131c, str, Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis2)));
        return jCurrentTimeMillis2;
    }

    public final long a() {
        return System.currentTimeMillis() - this.f6132d;
    }
}

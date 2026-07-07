package com.tianmu.j.b.c;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f12310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f12311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f12312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.tianmu.j.b.d.c f12313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f12314i;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f12315a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f12317c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private h f12319e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private g f12320f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f12321g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private com.tianmu.j.b.d.c f12322h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f12316b = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f12318d = true;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f12323i = true;

        public j a() {
            return new j(this);
        }
    }

    public static b a() {
        return new b();
    }

    private j(b bVar) {
        this.f12309d = bVar.f12315a;
        this.f12307b = bVar.f12317c;
        this.f12306a = bVar.f12316b;
        this.f12308c = bVar.f12318d;
        this.f12310e = bVar.f12319e;
        this.f12312g = bVar.f12321g;
        if (bVar.f12320f == null) {
            this.f12311f = c.a();
        } else {
            this.f12311f = bVar.f12320f;
        }
        if (bVar.f12322h == null) {
            this.f12313h = com.tianmu.j.b.d.e.a();
        } else {
            this.f12313h = bVar.f12322h;
        }
        this.f12314i = bVar.f12323i;
    }
}

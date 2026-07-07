package com.tianmu.g;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.tianmu.g.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u extends com.tianmu.g.a<b> {
    public final RemoteViews m;
    public final int n;
    private b o;

    public static class a extends u {
        private final int p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final Notification f12153q;

        public a(r rVar, v vVar, RemoteViews remoteViews, int i2, int i3, Notification notification, int i4, int i5, String str, Object obj, int i6) {
            super(rVar, vVar, remoteViews, i2, i6, i4, i5, obj, str);
            this.p = i3;
            this.f12153q = notification;
        }

        @Override // com.tianmu.g.a
        public /* bridge */ /* synthetic */ b j() {
            return super.j();
        }

        @Override // com.tianmu.g.u
        public void m() {
            ((NotificationManager) f0.a(this.f12023a.f12119e, "notification")).notify(this.p, this.f12153q);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RemoteViews f12154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12155b;

        public b(RemoteViews remoteViews, int i2) {
            this.f12154a = remoteViews;
            this.f12155b = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f12155b == bVar.f12155b && this.f12154a.equals(bVar.f12154a);
        }

        public int hashCode() {
            return (this.f12154a.hashCode() * 31) + this.f12155b;
        }
    }

    public u(r rVar, v vVar, RemoteViews remoteViews, int i2, int i3, int i4, int i5, Object obj, String str) {
        super(rVar, null, vVar, i4, i5, i3, null, str, obj, false);
        this.m = remoteViews;
        this.n = i2;
    }

    @Override // com.tianmu.g.a
    public void a(Bitmap bitmap, r.e eVar) {
        this.m.setImageViewBitmap(this.n, bitmap);
        m();
    }

    @Override // com.tianmu.g.a
    public void b() {
        int i2 = this.f12029g;
        if (i2 != 0) {
            a(i2);
        }
    }

    @Override // com.tianmu.g.a
    public b j() {
        if (this.o == null) {
            this.o = new b(this.m, this.n);
        }
        return this.o;
    }

    public abstract void m();

    public void a(int i2) {
        this.m.setImageViewResource(this.n, i2);
        m();
    }
}

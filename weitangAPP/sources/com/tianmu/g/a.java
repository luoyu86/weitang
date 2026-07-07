package com.tianmu.g;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tianmu.g.r;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f12023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f12024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<T> f12025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f12029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f12030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f12031i;
    public final Object j;
    public boolean k;
    public boolean l;

    /* JADX INFO: renamed from: com.tianmu.g.a$a, reason: collision with other inner class name */
    public static class C0221a<M> extends WeakReference<M> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f12032a;

        public C0221a(a aVar, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f12032a = aVar;
        }
    }

    public a(r rVar, T t, v vVar, int i2, int i3, int i4, Drawable drawable, String str, Object obj, boolean z) {
        this.f12023a = rVar;
        this.f12024b = vVar;
        this.f12025c = t == null ? null : new C0221a(this, t, rVar.k);
        this.f12027e = i2;
        this.f12028f = i3;
        this.f12026d = z;
        this.f12029g = i4;
        this.f12030h = drawable;
        this.f12031i = str;
        this.j = obj == null ? this : obj;
    }

    public void a() {
        this.l = true;
    }

    public abstract void a(Bitmap bitmap, r.e eVar);

    public abstract void b();

    public String c() {
        return this.f12031i;
    }

    public int d() {
        return this.f12027e;
    }

    public int e() {
        return this.f12028f;
    }

    public r f() {
        return this.f12023a;
    }

    public r.f g() {
        return this.f12024b.r;
    }

    public v h() {
        return this.f12024b;
    }

    public Object i() {
        return this.j;
    }

    public T j() {
        WeakReference<T> weakReference = this.f12025c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public boolean k() {
        return this.l;
    }

    public boolean l() {
        return this.k;
    }
}

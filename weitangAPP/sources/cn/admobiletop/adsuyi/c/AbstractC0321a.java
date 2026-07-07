package cn.admobiletop.adsuyi.c;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import cn.admobiletop.adsuyi.c.A;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0321a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f4208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G f4209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<T> f4210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f4211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f4214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f4215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f4216i;
    public final Object j;
    public boolean k;
    public boolean l;

    /* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.a$a, reason: collision with other inner class name */
    public static class C0051a<M> extends WeakReference<M> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0321a f4217a;

        public C0051a(AbstractC0321a abstractC0321a, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f4217a = abstractC0321a;
        }
    }

    public AbstractC0321a(A a2, T t, G g2, int i2, int i3, int i4, Drawable drawable, String str, Object obj, boolean z) {
        this.f4208a = a2;
        this.f4209b = g2;
        this.f4210c = t == null ? null : new C0051a(this, t, a2.m);
        this.f4212e = i2;
        this.f4213f = i3;
        this.f4211d = z;
        this.f4214g = i4;
        this.f4215h = drawable;
        this.f4216i = str;
        this.j = obj == null ? this : obj;
    }

    public void a() {
        this.l = true;
    }

    public abstract void a(Bitmap bitmap, A.d dVar);

    public abstract void b();

    public String c() {
        return this.f4216i;
    }

    public int d() {
        return this.f4212e;
    }

    public int e() {
        return this.f4213f;
    }

    public A f() {
        return this.f4208a;
    }

    public A.e g() {
        return this.f4209b.s;
    }

    public G h() {
        return this.f4209b;
    }

    public Object i() {
        return this.j;
    }

    public T j() {
        WeakReference<T> weakReference = this.f4210c;
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

package cn.admobiletop.adsuyi.a.i;

import cn.admobiletop.adsuyi.a.b.v;
import cn.admobiletop.adsuyi.ad.data.IBaseRelease;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<T extends v> implements a, IBaseRelease {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<T> f3346c;

    public c(T t, String str, int i2) {
        this.f3346c = new WeakReference<>(t);
        this.f3344a = str;
        this.f3345b = i2;
    }

    @Override // cn.admobiletop.adsuyi.a.i.a
    public void a() {
        WeakReference<T> weakReference = this.f3346c;
        if (weakReference != null) {
            a(weakReference.get(), this.f3344a, this.f3345b);
        }
    }

    public abstract void a(T t, String str, int i2);

    @Override // cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        this.f3346c = null;
    }
}

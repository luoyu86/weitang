package cn.admobiletop.adsuyi.a.i;

import cn.admobiletop.adsuyi.a.b.v;
import cn.admobiletop.adsuyi.a.f.c;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import cn.admobiletop.adsuyi.ad.data.IBaseRelease;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T extends v> implements c.a, IBaseRelease {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<T> f3341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<ADSuyiPosId> f3342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3343c;

    public b(T t, ADSuyiPosId aDSuyiPosId, int i2) {
        this.f3341a = new WeakReference<>(t);
        this.f3342b = new WeakReference<>(aDSuyiPosId);
        this.f3343c = i2;
    }

    public abstract void a(T t, ADSuyiPosId aDSuyiPosId, int i2);

    @Override // cn.admobiletop.adsuyi.a.f.c.a
    public void onFinish() {
        WeakReference<T> weakReference = this.f3341a;
        if (weakReference == null || this.f3342b == null) {
            return;
        }
        a(weakReference.get(), this.f3342b.get(), this.f3343c);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        this.f3341a = null;
        this.f3342b = null;
    }
}

package cn.admobiletop.adsuyi.c;

import cn.admobiletop.adsuyi.c.A;

/* JADX INFO: loaded from: classes.dex */
public class B implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Exception f4138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A.b f4139b;

    public B(A.b bVar, Exception exc) {
        this.f4139b = bVar;
        this.f4138a = exc;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new RuntimeException(this.f4138a);
    }
}

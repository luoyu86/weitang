package cn.admobiletop.adsuyi.b.c;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f4099a;

    public void a(a aVar) {
        this.f4099a = aVar;
    }

    public void b() {
        if (this.f4099a != null) {
            this.f4099a = null;
        }
    }

    public void a() {
        a aVar = this.f4099a;
        if (aVar != null) {
            aVar.a();
        }
    }
}

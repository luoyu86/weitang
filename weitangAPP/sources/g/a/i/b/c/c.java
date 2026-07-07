package g.a.i.b.c;

/* JADX INFO: loaded from: classes3.dex */
public class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g.a.i.d.a.c f14378e;

    public c(int i2, int i3, g.a.i.d.a.c cVar, String str) {
        super(false, str);
        this.f14376c = i2;
        this.f14377d = i3;
        this.f14378e = new g.a.i.d.a.c(cVar);
    }

    public g.a.i.d.a.c getG() {
        return this.f14378e;
    }

    public int getK() {
        return this.f14378e.getNumRows();
    }

    public int getN() {
        return this.f14376c;
    }

    public int getT() {
        return this.f14377d;
    }
}

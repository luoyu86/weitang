package g.a.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d0 implements g.a.j.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13629a;

    public d0(int i2) {
        this.f13629a = i2;
    }

    @Override // g.a.j.m
    public abstract Object clone();

    public int getType() {
        return this.f13629a;
    }

    @Override // g.a.j.m
    public abstract /* synthetic */ boolean match(T t);
}

package g.a.i.b.i;

import g.a.i.b.i.o;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f14475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14476g;

    public static class b extends o.a<b> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14477e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f14478f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f14479g;

        public b() {
            super(0);
            this.f14477e = 0;
            this.f14478f = 0;
            this.f14479g = 0;
        }

        public o l() {
            return new j(this);
        }

        @Override // g.a.i.b.i.o.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public b e() {
            return this;
        }

        public b n(int i2) {
            this.f14478f = i2;
            return this;
        }

        public b o(int i2) {
            this.f14479g = i2;
            return this;
        }

        public b p(int i2) {
            this.f14477e = i2;
            return this;
        }
    }

    public j(b bVar) {
        super(bVar);
        this.f14474e = bVar.f14477e;
        this.f14475f = bVar.f14478f;
        this.f14476g = bVar.f14479g;
    }

    @Override // g.a.i.b.i.o
    public byte[] c() {
        byte[] bArrC = super.c();
        g.a.j.k.intToBigEndian(this.f14474e, bArrC, 16);
        g.a.j.k.intToBigEndian(this.f14475f, bArrC, 20);
        g.a.j.k.intToBigEndian(this.f14476g, bArrC, 24);
        return bArrC;
    }

    public int d() {
        return this.f14475f;
    }

    public int e() {
        return this.f14476g;
    }

    public int f() {
        return this.f14474e;
    }
}

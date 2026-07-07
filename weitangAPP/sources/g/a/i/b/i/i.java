package g.a.i.b.i;

import g.a.i.b.i.o;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f14469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14470g;

    public static class b extends o.a<b> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14471e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f14472f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f14473g;

        public b() {
            super(1);
            this.f14471e = 0;
            this.f14472f = 0;
            this.f14473g = 0;
        }

        public o l() {
            return new i(this);
        }

        @Override // g.a.i.b.i.o.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public b e() {
            return this;
        }

        public b n(int i2) {
            this.f14471e = i2;
            return this;
        }

        public b o(int i2) {
            this.f14472f = i2;
            return this;
        }

        public b p(int i2) {
            this.f14473g = i2;
            return this;
        }
    }

    public i(b bVar) {
        super(bVar);
        this.f14468e = bVar.f14471e;
        this.f14469f = bVar.f14472f;
        this.f14470g = bVar.f14473g;
    }

    @Override // g.a.i.b.i.o
    public byte[] c() {
        byte[] bArrC = super.c();
        g.a.j.k.intToBigEndian(this.f14468e, bArrC, 16);
        g.a.j.k.intToBigEndian(this.f14469f, bArrC, 20);
        g.a.j.k.intToBigEndian(this.f14470g, bArrC, 24);
        return bArrC;
    }

    public int d() {
        return this.f14468e;
    }

    public int e() {
        return this.f14469f;
    }

    public int f() {
        return this.f14470g;
    }
}

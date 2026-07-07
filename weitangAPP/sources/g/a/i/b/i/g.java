package g.a.i.b.i;

import g.a.i.b.i.o;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f14462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14463g;

    public static class b extends o.a<b> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14464e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f14465f;

        public b() {
            super(2);
            this.f14464e = 0;
            this.f14465f = 0;
        }

        public o k() {
            return new g(this);
        }

        @Override // g.a.i.b.i.o.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public b e() {
            return this;
        }

        public b m(int i2) {
            this.f14464e = i2;
            return this;
        }

        public b n(int i2) {
            this.f14465f = i2;
            return this;
        }
    }

    public g(b bVar) {
        super(bVar);
        this.f14461e = 0;
        this.f14462f = bVar.f14464e;
        this.f14463g = bVar.f14465f;
    }

    @Override // g.a.i.b.i.o
    public byte[] c() {
        byte[] bArrC = super.c();
        g.a.j.k.intToBigEndian(this.f14461e, bArrC, 16);
        g.a.j.k.intToBigEndian(this.f14462f, bArrC, 20);
        g.a.j.k.intToBigEndian(this.f14463g, bArrC, 24);
        return bArrC;
    }

    public int d() {
        return this.f14462f;
    }

    public int e() {
        return this.f14463g;
    }
}

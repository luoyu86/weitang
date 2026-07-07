package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class v2 extends i1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f13370d;

    public v2(int i2, int i3, boolean z, h0 h0Var) {
        super(i2, i3, h0Var);
        this.f13370d = z;
    }

    @Override // g.a.a.i1, g.a.a.m0, g.a.a.y2
    public a0 getLoadedObject() throws IOException {
        return this.f13120c.b(this.f13118a, this.f13119b, this.f13370d);
    }

    @Override // g.a.a.i1
    public boolean isConstructed() {
        return this.f13370d;
    }

    @Override // g.a.a.i1, g.a.a.m0
    public g parseBaseUniversal(boolean z, int i2) throws IOException {
        if (!z) {
            return this.f13370d ? this.f13120c.d(i2) : this.f13120c.f(i2);
        }
        if (this.f13370d) {
            return this.f13120c.h(i2);
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    @Override // g.a.a.i1, g.a.a.m0
    public g parseExplicitBaseObject() throws IOException {
        if (this.f13370d) {
            return this.f13120c.readObject();
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    @Override // g.a.a.i1, g.a.a.m0
    public m0 parseExplicitBaseTagged() throws IOException {
        if (this.f13370d) {
            return this.f13120c.i();
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    @Override // g.a.a.i1, g.a.a.m0
    public m0 parseImplicitBaseTagged(int i2, int i3) throws IOException {
        return 64 == i2 ? (k2) this.f13120c.b(i2, i3, this.f13370d) : new v2(i2, i3, this.f13370d, this.f13120c);
    }
}

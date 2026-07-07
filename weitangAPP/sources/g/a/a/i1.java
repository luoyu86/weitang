package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class i1 implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0 f13120c;

    public i1(int i2, int i3, h0 h0Var) {
        this.f13118a = i2;
        this.f13119b = i3;
        this.f13120c = h0Var;
    }

    @Override // g.a.a.m0, g.a.a.y2
    public a0 getLoadedObject() throws IOException {
        return this.f13120c.c(this.f13118a, this.f13119b);
    }

    @Override // g.a.a.m0
    public g getObjectParser(int i2, boolean z) throws IOException {
        if (128 == getTagClass()) {
            return parseBaseUniversal(z, i2);
        }
        throw new j("this method only valid for CONTEXT_SPECIFIC tags");
    }

    @Override // g.a.a.m0
    public int getTagClass() {
        return this.f13118a;
    }

    @Override // g.a.a.m0
    public int getTagNo() {
        return this.f13119b;
    }

    @Override // g.a.a.m0
    public boolean hasContextTag(int i2) {
        return this.f13118a == 128 && this.f13119b == i2;
    }

    @Override // g.a.a.m0
    public boolean hasTag(int i2, int i3) {
        return this.f13118a == i2 && this.f13119b == i3;
    }

    public boolean isConstructed() {
        return true;
    }

    @Override // g.a.a.m0
    public g parseBaseUniversal(boolean z, int i2) throws IOException {
        return z ? this.f13120c.h(i2) : this.f13120c.e(i2);
    }

    @Override // g.a.a.m0
    public g parseExplicitBaseObject() throws IOException {
        return this.f13120c.readObject();
    }

    @Override // g.a.a.m0
    public m0 parseExplicitBaseTagged() throws IOException {
        return this.f13120c.i();
    }

    @Override // g.a.a.m0
    public m0 parseImplicitBaseTagged(int i2, int i3) throws IOException {
        return 64 == i2 ? new x0(i3, this.f13120c) : new i1(i2, i3, this.f13120c);
    }

    @Override // g.a.a.m0, g.a.a.g
    public a0 toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e2) {
            throw new z(e2.getMessage());
        }
    }
}

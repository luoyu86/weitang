package g.a.a.z3;

import g.a.a.a0;
import g.a.a.t;
import g.a.a.x1;

/* JADX INFO: loaded from: classes2.dex */
public class h extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static j f13588a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.g.a.f f13589b;

    public h(g.a.g.a.f fVar) {
        this.f13589b = fVar;
    }

    public g.a.g.a.f getValue() {
        return this.f13589b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return new x1(f13588a.integerToBytes(this.f13589b.toBigInteger(), f13588a.getByteLength(this.f13589b)));
    }
}

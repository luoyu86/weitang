package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class p1 implements g, y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f13282a;

    public p1(h0 h0Var) {
        this.f13282a = h0Var;
    }

    public static n2 a(h0 h0Var) throws IOException {
        try {
            return new n2(h0Var.j());
        } catch (IllegalArgumentException e2) {
            throw new j(e2.getMessage(), e2);
        }
    }

    @Override // g.a.a.y2
    public a0 getLoadedObject() throws IOException {
        return a(this.f13282a);
    }

    public g readObject() throws IOException {
        return this.f13282a.readObject();
    }

    @Override // g.a.a.g
    public a0 toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e2) {
            throw new z("unable to get DER object", e2);
        } catch (IllegalArgumentException e3) {
            throw new z("unable to get DER object", e3);
        }
    }
}

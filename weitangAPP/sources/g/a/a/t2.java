package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class t2 implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f13330a;

    public t2(h0 h0Var) {
        this.f13330a = h0Var;
    }

    @Override // g.a.a.g0, g.a.a.y2
    public a0 getLoadedObject() throws IOException {
        return o2.b(this.f13330a.j());
    }

    @Override // g.a.a.g0
    public g readObject() throws IOException {
        return this.f13330a.readObject();
    }

    @Override // g.a.a.g0, g.a.a.g
    public a0 toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e2) {
            throw new z(e2.getMessage(), e2);
        }
    }
}

package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class g1 implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f13086a;

    public g1(h0 h0Var) {
        this.f13086a = h0Var;
    }

    public static f1 a(h0 h0Var) throws IOException {
        return new f1(h0Var.j());
    }

    @Override // g.a.a.g0, g.a.a.y2
    public a0 getLoadedObject() throws IOException {
        return a(this.f13086a);
    }

    @Override // g.a.a.g0
    public g readObject() throws IOException {
        return this.f13086a.readObject();
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

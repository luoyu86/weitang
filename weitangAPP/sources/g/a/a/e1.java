package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class e1 implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f13071a;

    public e1(h0 h0Var) {
        this.f13071a = h0Var;
    }

    public static d1 a(h0 h0Var) throws IOException {
        return new d1(h0Var.j());
    }

    @Override // g.a.a.e0, g.a.a.y2
    public a0 getLoadedObject() throws IOException {
        return a(this.f13071a);
    }

    @Override // g.a.a.e0
    public g readObject() throws IOException {
        return this.f13071a.readObject();
    }

    @Override // g.a.a.e0, g.a.a.g
    public a0 toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e2) {
            throw new IllegalStateException(e2.getMessage());
        }
    }
}

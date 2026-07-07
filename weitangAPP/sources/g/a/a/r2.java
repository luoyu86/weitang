package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class r2 implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f13311a;

    public r2(h0 h0Var) {
        this.f13311a = h0Var;
    }

    @Override // g.a.a.e0, g.a.a.y2
    public a0 getLoadedObject() throws IOException {
        return o2.a(this.f13311a.j());
    }

    @Override // g.a.a.e0
    public g readObject() throws IOException {
        return this.f13311a.readObject();
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

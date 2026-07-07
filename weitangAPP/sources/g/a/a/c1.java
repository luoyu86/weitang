package g.a.a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class c1 implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f13054a;

    public c1(h0 h0Var) {
        this.f13054a = h0Var;
    }

    public static b1 a(h0 h0Var) throws IOException {
        return new b1(g.a.j.s.b.readAll(new k1(h0Var)));
    }

    @Override // g.a.a.x, g.a.a.y2
    public a0 getLoadedObject() throws IOException {
        return a(this.f13054a);
    }

    @Override // g.a.a.x
    public InputStream getOctetStream() {
        return new k1(this.f13054a);
    }

    @Override // g.a.a.x, g.a.a.g
    public a0 toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e2) {
            throw new z("IOException converting stream to byte array: " + e2.getMessage(), e2);
        }
    }
}

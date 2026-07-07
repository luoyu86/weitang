package g.a.a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class z0 implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f13557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j1 f13558b;

    public z0(h0 h0Var) {
        this.f13557a = h0Var;
    }

    public static y0 a(h0 h0Var) throws IOException {
        j1 j1Var = new j1(h0Var, false);
        return new y0(g.a.j.s.b.readAll(j1Var), j1Var.b());
    }

    @Override // g.a.a.d
    public InputStream getBitStream() throws IOException {
        j1 j1Var = new j1(this.f13557a, false);
        this.f13558b = j1Var;
        return j1Var;
    }

    @Override // g.a.a.d, g.a.a.y2
    public a0 getLoadedObject() throws IOException {
        return a(this.f13557a);
    }

    @Override // g.a.a.d
    public InputStream getOctetStream() throws IOException {
        j1 j1Var = new j1(this.f13557a, true);
        this.f13558b = j1Var;
        return j1Var;
    }

    @Override // g.a.a.d
    public int getPadBits() {
        return this.f13558b.b();
    }

    @Override // g.a.a.d, g.a.a.g
    public a0 toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e2) {
            throw new z("IOException converting stream to byte array: " + e2.getMessage(), e2);
        }
    }
}

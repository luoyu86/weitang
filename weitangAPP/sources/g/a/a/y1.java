package g.a.a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class y1 implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x2 f13448a;

    public y1(x2 x2Var) {
        this.f13448a = x2Var;
    }

    @Override // g.a.a.x, g.a.a.y2
    public a0 getLoadedObject() throws IOException {
        return new x1(this.f13448a.e());
    }

    @Override // g.a.a.x
    public InputStream getOctetStream() {
        return this.f13448a;
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

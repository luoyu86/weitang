package g.a.a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class m2 implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x2 f13244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13245b = 0;

    public m2(x2 x2Var) {
        this.f13244a = x2Var;
    }

    public final InputStream a(boolean z) throws IOException {
        int iC = this.f13244a.c();
        if (iC < 1) {
            throw new IllegalStateException("content octets cannot be empty");
        }
        int i2 = this.f13244a.read();
        this.f13245b = i2;
        if (i2 > 0) {
            if (iC < 2) {
                throw new IllegalStateException("zero length data with non-zero pad bits");
            }
            if (i2 > 7) {
                throw new IllegalStateException("pad bits cannot be greater than 7 or less than 0");
            }
            if (z) {
                throw new IOException("expected octet-aligned bitstring, but found padBits: " + this.f13245b);
            }
        }
        return this.f13244a;
    }

    @Override // g.a.a.d
    public InputStream getBitStream() throws IOException {
        return a(false);
    }

    @Override // g.a.a.d, g.a.a.y2
    public a0 getLoadedObject() throws IOException {
        return c.g(this.f13244a.e());
    }

    @Override // g.a.a.d
    public InputStream getOctetStream() throws IOException {
        return a(true);
    }

    @Override // g.a.a.d
    public int getPadBits() {
        return this.f13245b;
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

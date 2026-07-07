package g.a.a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class k1 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f13199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13200b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f13201c;

    public k1(h0 h0Var) {
        this.f13199a = h0Var;
    }

    public final x a() throws IOException {
        g object = this.f13199a.readObject();
        if (object == null) {
            return null;
        }
        if (object instanceof x) {
            return (x) object;
        }
        throw new IOException("unknown object encountered: " + object.getClass());
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        x xVarA;
        if (this.f13201c == null) {
            if (!this.f13200b || (xVarA = a()) == null) {
                return -1;
            }
            this.f13200b = false;
            this.f13201c = xVarA.getOctetStream();
        }
        while (true) {
            int i2 = this.f13201c.read();
            if (i2 >= 0) {
                return i2;
            }
            x xVarA2 = a();
            if (xVarA2 == null) {
                this.f13201c = null;
                return -1;
            }
            this.f13201c = xVarA2.getOctetStream();
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        x xVarA;
        int i4 = 0;
        if (this.f13201c == null) {
            if (!this.f13200b || (xVarA = a()) == null) {
                return -1;
            }
            this.f13200b = false;
            this.f13201c = xVarA.getOctetStream();
        }
        while (true) {
            int i5 = this.f13201c.read(bArr, i2 + i4, i3 - i4);
            if (i5 >= 0) {
                i4 += i5;
                if (i4 == i3) {
                    return i4;
                }
            } else {
                x xVarA2 = a();
                if (xVarA2 == null) {
                    this.f13201c = null;
                    if (i4 < 1) {
                        return -1;
                    }
                    return i4;
                }
                this.f13201c = xVarA2.getOctetStream();
            }
        }
    }
}

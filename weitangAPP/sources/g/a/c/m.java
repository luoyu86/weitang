package g.a.c;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.a.a.v f13690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InputStream f13691b;

    public static class a extends FilterInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            if (i3 == 0) {
                return 0;
            }
            int fully = g.a.j.s.b.readFully(((FilterInputStream) this).in, bArr, i2, i3);
            if (fully > 0) {
                return fully;
            }
            return -1;
        }
    }

    public m(g.a.a.v vVar, InputStream inputStream) {
        this(vVar, inputStream, 32768);
    }

    public m(g.a.a.v vVar, InputStream inputStream, int i2) {
        this.f13690a = vVar;
        this.f13691b = new a(new BufferedInputStream(inputStream, i2));
    }

    public m(InputStream inputStream) {
        this(g.a.a.t3.a.m1.getId(), inputStream, 32768);
    }

    public m(String str, InputStream inputStream) {
        this(new g.a.a.v(str), inputStream, 32768);
    }

    public m(String str, InputStream inputStream, int i2) {
        this(new g.a.a.v(str), inputStream, i2);
    }

    public void drain() throws IOException {
        g.a.j.s.b.drain(this.f13691b);
        this.f13691b.close();
    }

    public InputStream getContentStream() {
        return this.f13691b;
    }

    public g.a.a.v getContentType() {
        return this.f13690a;
    }
}

package g.a.c;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    public static class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g.a.h.f f13652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g.a.a.v f13653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j f13654c;

        /* JADX INFO: renamed from: g.a.c.g$a$a, reason: collision with other inner class name */
        public class C0252a extends FilterInputStream {
            public C0252a(InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                int i2 = ((FilterInputStream) this).in.read();
                if (i2 >= 0) {
                    a.this.f13652a.getOutputStream().write(i2);
                }
                return i2;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) throws IOException {
                int i4 = ((FilterInputStream) this).in.read(bArr, i2, i3);
                if (i4 >= 0) {
                    a.this.f13652a.getOutputStream().write(bArr, i2, i4);
                }
                return i4;
            }
        }

        public a(g.a.h.f fVar, g.a.a.v vVar, j jVar) {
            this.f13652a = fVar;
            this.f13653b = vVar;
            this.f13654c = jVar;
        }

        @Override // g.a.c.l
        public g.a.a.v getContentType() {
            return this.f13653b;
        }

        public byte[] getDigest() {
            return this.f13652a.getDigest();
        }

        @Override // g.a.c.l
        public InputStream getInputStream() throws h, IOException {
            return new C0252a(this.f13654c.getInputStream());
        }
    }

    public static class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g.a.a.y3.a f13656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g.a.a.v f13657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j f13658c;

        public b(g.a.a.y3.a aVar, g.a.a.v vVar, j jVar) {
            this.f13656a = aVar;
            this.f13657b = vVar;
            this.f13658c = jVar;
        }

        @Override // g.a.c.l
        public g.a.a.v getContentType() {
            return this.f13657b;
        }

        @Override // g.a.c.l
        public InputStream getInputStream() throws h, IOException {
            return this.f13658c.getInputStream();
        }
    }

    public static g0 a(g.a.a.f0 f0Var, g.a.a.y3.a aVar, l lVar) {
        return b(f0Var, aVar, lVar, null);
    }

    public static g0 b(g.a.a.f0 f0Var, g.a.a.y3.a aVar, l lVar, g.a.c.a aVar2) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 != f0Var.size(); i2++) {
            c(arrayList, g.a.a.i3.w.getInstance(f0Var.getObjectAt(i2)), aVar, lVar, aVar2);
        }
        return new g0(arrayList);
    }

    public static void c(List list, g.a.a.i3.w wVar, g.a.a.y3.a aVar, l lVar, g.a.c.a aVar2) {
        f0 b0Var;
        g.a.a.g info = wVar.getInfo();
        if (info instanceof g.a.a.i3.n) {
            b0Var = new w((g.a.a.i3.n) info, aVar, lVar, aVar2);
        } else if (info instanceof g.a.a.i3.k) {
            b0Var = new q((g.a.a.i3.k) info, aVar, lVar, aVar2);
        } else if (info instanceof g.a.a.i3.m) {
            t.f(list, (g.a.a.i3.m) info, aVar, lVar, aVar2);
            return;
        } else if (!(info instanceof g.a.a.i3.t)) {
            return;
        } else {
            b0Var = new b0((g.a.a.i3.t) info, aVar, lVar, aVar2);
        }
        list.add(b0Var);
    }
}

package g.a.d.o;

import g.a.a.b2;
import g.a.a.e2;
import g.a.a.g;
import g.a.a.h;
import g.a.a.l0;
import g.a.a.w;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b2 f13821a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g.a.a.y3.a f13822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final w f13823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final w f13824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public l0 f13825d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public l0 f13826e;

        public b(g.a.a.y3.a aVar, byte[] bArr, byte[] bArr2) {
            this.f13822a = aVar;
            this.f13823b = g.a.d.o.b.a(bArr);
            this.f13824c = g.a.d.o.b.a(bArr2);
        }

        public a build() {
            h hVar = new h();
            hVar.add(this.f13822a);
            hVar.add(this.f13823b);
            hVar.add(this.f13824c);
            l0 l0Var = this.f13825d;
            if (l0Var != null) {
                hVar.add(l0Var);
            }
            l0 l0Var2 = this.f13826e;
            if (l0Var2 != null) {
                hVar.add(l0Var2);
            }
            return new a(new b2(hVar));
        }

        public b withSuppPrivInfo(byte[] bArr) {
            this.f13826e = new e2(false, 1, (g) g.a.d.o.b.a(bArr));
            return this;
        }

        public b withSuppPubInfo(byte[] bArr) {
            this.f13825d = new e2(false, 0, (g) g.a.d.o.b.a(bArr));
            return this;
        }
    }

    public a(b2 b2Var) {
        this.f13821a = b2Var;
    }

    public byte[] getEncoded() throws IOException {
        return this.f13821a.getEncoded();
    }
}

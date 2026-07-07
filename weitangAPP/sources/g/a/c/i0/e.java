package g.a.c.i0;

import g.a.c.h0;
import g.a.h.i;
import java.io.InputStream;
import java.security.PrivateKey;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
public class e extends f {

    public class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.a.a.y3.a f13680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Cipher f13681b;

        public a(g.a.a.y3.a aVar, Cipher cipher) {
            this.f13680a = aVar;
            this.f13681b = cipher;
        }

        @Override // g.a.h.i
        public g.a.a.y3.a getAlgorithmIdentifier() {
            return this.f13680a;
        }

        @Override // g.a.h.i
        public InputStream getInputStream(InputStream inputStream) {
            return new g.a.e.a.a(inputStream, this.f13681b);
        }
    }

    public e(PrivateKey privateKey) {
        super(privateKey);
    }

    @Override // g.a.c.i0.f, g.a.c.u
    public h0 getRecipientOperator(g.a.a.y3.a aVar, g.a.a.y3.a aVar2, byte[] bArr) throws g.a.c.h {
        return new h0(new a(aVar2, this.f13685c.createContentCipher(a(aVar, aVar2, bArr), aVar2)));
    }
}

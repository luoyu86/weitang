package g.a.c.i0;

import g.a.h.n;
import java.security.PrivateKey;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
public class b extends g.a.e.d.c implements d {
    @Override // g.a.c.i0.d
    public g.a.h.o.a createAsymmetricUnwrapper(g.a.a.y3.a aVar, PrivateKey privateKey) {
        return new g.a.h.o.a(aVar, a.a(privateKey));
    }

    @Override // g.a.c.i0.d
    public g.a.h.o.c createAsymmetricUnwrapper(g.a.a.y3.a aVar, PrivateKey privateKey, byte[] bArr, byte[] bArr2) {
        return new g.a.h.o.c(aVar, a.a(privateKey), bArr, bArr2);
    }

    @Override // g.a.c.i0.d
    public n createSymmetricUnwrapper(g.a.a.y3.a aVar, SecretKey secretKey) {
        return new g.a.h.o.d(aVar, secretKey);
    }
}

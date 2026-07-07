package g.a.h.o;

import g.a.a.i3.h;
import g.a.a.i3.y;
import g.a.d.o.a;
import g.a.e.c.c;
import g.a.e.d.f;
import g.a.h.g;
import g.a.h.l;
import java.security.PrivateKey;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes3.dex */
public class c extends g.a.h.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f14201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f14202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PrivateKey f14203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f14204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f14205f;

    public c(g.a.a.y3.a aVar, PrivateKey privateKey, byte[] bArr, byte[] bArr2) {
        super(aVar);
        this.f14201b = new e(new g.a.e.d.c());
        this.f14202c = new HashMap();
        this.f14203d = privateKey;
        this.f14204e = g.a.j.a.clone(bArr);
        this.f14205f = g.a.j.a.clone(bArr2);
    }

    @Override // g.a.h.a
    public g generateUnwrappedKey(g.a.a.y3.a aVar, byte[] bArr) throws l {
        h hVar = h.getInstance(getAlgorithmIdentifier().getParameters());
        Cipher cipherB = this.f14201b.b(getAlgorithmIdentifier().getAlgorithm(), this.f14202c);
        String strE = this.f14201b.e(hVar.getDem().getAlgorithm());
        y yVar = y.getInstance(hVar.getKem().getParameters());
        try {
            cipherB.init(4, this.f14203d, new c.b(strE, yVar.getKeyLength().intValue() * 8, new a.b(hVar.getDem(), this.f14204e, this.f14205f).build().getEncoded()).withKdfAlgorithm(yVar.getKeyDerivationFunction()).build());
            return new b(aVar, cipherB.unwrap(bArr, this.f14201b.d(aVar.getAlgorithm()), 3));
        } catch (Exception e2) {
            throw new l("Unable to unwrap contents key: " + e2.getMessage(), e2);
        }
    }

    public c setProvider(String str) {
        this.f14201b = new e(new g.a.e.d.e(str));
        return this;
    }

    public c setProvider(Provider provider) {
        this.f14201b = new e(new f(provider));
        return this;
    }
}

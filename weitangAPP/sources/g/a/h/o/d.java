package g.a.h.o;

import g.a.e.d.f;
import g.a.h.g;
import g.a.h.l;
import g.a.h.n;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes3.dex */
public class d extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f14206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecretKey f14207c;

    public d(g.a.a.y3.a aVar, SecretKey secretKey) {
        super(aVar);
        this.f14206b = new e(new g.a.e.d.c());
        this.f14207c = secretKey;
    }

    @Override // g.a.h.n
    public g generateUnwrappedKey(g.a.a.y3.a aVar, byte[] bArr) throws l {
        try {
            Cipher cipherC = this.f14206b.c(getAlgorithmIdentifier().getAlgorithm());
            cipherC.init(4, this.f14207c);
            return new b(aVar, cipherC.unwrap(bArr, this.f14206b.d(aVar.getAlgorithm()), 3));
        } catch (InvalidKeyException e2) {
            throw new l("key invalid in message.", e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new l("can't find algorithm.", e3);
        }
    }

    public d setProvider(String str) {
        this.f14206b = new e(new g.a.e.d.e(str));
        return this;
    }

    public d setProvider(Provider provider) {
        this.f14206b = new e(new f(provider));
        return this;
    }
}

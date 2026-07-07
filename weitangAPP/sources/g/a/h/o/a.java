package g.a.h.o;

import g.a.a.v;
import g.a.e.d.f;
import g.a.h.g;
import g.a.h.l;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.ProviderException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class a extends g.a.h.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f14197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f14198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PrivateKey f14199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14200e;

    public a(g.a.a.y3.a aVar, PrivateKey privateKey) {
        super(aVar);
        this.f14197b = new e(new g.a.e.d.c());
        this.f14198c = new HashMap();
        this.f14199d = privateKey;
    }

    @Override // g.a.h.a
    public g generateUnwrappedKey(g.a.a.y3.a aVar, byte[] bArr) throws l {
        byte[] encoded;
        try {
            Cipher cipherB = this.f14197b.b(getAlgorithmIdentifier().getAlgorithm(), this.f14198c);
            AlgorithmParameters algorithmParametersA = this.f14197b.a(getAlgorithmIdentifier());
            Key secretKeySpec = null;
            try {
                if (algorithmParametersA != null) {
                    cipherB.init(4, this.f14199d, algorithmParametersA);
                } else {
                    cipherB.init(4, this.f14199d);
                }
                Key keyUnwrap = cipherB.unwrap(bArr, this.f14197b.d(aVar.getAlgorithm()), 3);
                if (!this.f14200e || ((encoded = keyUnwrap.getEncoded()) != null && encoded.length != 0)) {
                    secretKeySpec = keyUnwrap;
                }
            } catch (IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException | Exception unused) {
            }
            if (secretKeySpec == null) {
                cipherB.init(2, this.f14199d);
                secretKeySpec = new SecretKeySpec(cipherB.doFinal(bArr), aVar.getAlgorithm().getId());
            }
            return new b(aVar, secretKeySpec);
        } catch (InvalidKeyException e2) {
            throw new l("key invalid: " + e2.getMessage(), e2);
        } catch (BadPaddingException e3) {
            throw new l("bad padding: " + e3.getMessage(), e3);
        } catch (IllegalBlockSizeException e4) {
            throw new l("illegal blocksize: " + e4.getMessage(), e4);
        }
    }

    public a setAlgorithmMapping(v vVar, String str) {
        this.f14198c.put(vVar, str);
        return this;
    }

    public a setMustProduceEncodableUnwrappedKey(boolean z) {
        this.f14200e = z;
        return this;
    }

    public a setProvider(String str) {
        this.f14197b = new e(new g.a.e.d.e(str));
        return this;
    }

    public a setProvider(Provider provider) {
        this.f14197b = new e(new f(provider));
        return this;
    }
}

package g.a.i.c.b.h;

import com.alibaba.android.arouter.utils.Consts;
import g.a.a.a0;
import g.a.a.y3.l;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class f extends KeyFactorySpi implements g.a.e.b.d.b {
    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return generatePrivate(g.a.a.t3.b.getInstance(a0.fromByteArray(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
            } catch (Exception e2) {
                throw new InvalidKeySpecException(e2.toString());
            }
        }
        throw new InvalidKeySpecException("unsupported key specification: " + keySpec.getClass() + Consts.DOT);
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return generatePublic(l.getInstance(((X509EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e2) {
                throw new InvalidKeySpecException(e2.toString());
            }
        }
        throw new InvalidKeySpecException("unknown key specification: " + keySpec + Consts.DOT);
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof c) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
        } else {
            if (!(key instanceof d)) {
                throw new InvalidKeySpecException("unsupported key type: " + key.getClass() + Consts.DOT);
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new X509EncodedKeySpec(key.getEncoded());
            }
        }
        throw new InvalidKeySpecException("unknown key specification: " + cls + Consts.DOT);
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if ((key instanceof c) || (key instanceof d)) {
            return key;
        }
        throw new InvalidKeyException("unsupported key type");
    }

    @Override // g.a.e.b.d.b
    public PrivateKey generatePrivate(g.a.a.t3.b bVar) throws IOException {
        return new c(bVar);
    }

    @Override // g.a.e.b.d.b
    public PublicKey generatePublic(l lVar) throws IOException {
        return new d(lVar);
    }
}

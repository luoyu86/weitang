package g.a.i.c.b.e;

import com.alibaba.android.arouter.utils.Consts;
import g.a.a.a0;
import g.a.a.y3.l;
import g.a.i.a.f;
import g.a.i.a.g;
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
public class c extends KeyFactorySpi implements g.a.e.b.d.b {
    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof g.a.i.c.c.b) {
            return new a((g.a.i.c.c.b) keySpec);
        }
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return generatePrivate(g.a.a.t3.b.getInstance(a0.fromByteArray(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
            } catch (Exception e2) {
                throw new InvalidKeySpecException(e2.toString());
            }
        }
        throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + Consts.DOT);
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof g.a.i.c.c.c) {
            return new b((g.a.i.c.c.c) keySpec);
        }
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return generatePublic(l.getInstance(((X509EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e2) {
                throw new InvalidKeySpecException(e2.toString());
            }
        }
        throw new InvalidKeySpecException("Unknown key specification: " + keySpec + Consts.DOT);
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof a) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
            if (g.a.i.c.c.b.class.isAssignableFrom(cls)) {
                a aVar = (a) key;
                return new g.a.i.c.c.b(aVar.getInvA1(), aVar.getB1(), aVar.getInvA2(), aVar.getB2(), aVar.getVi(), aVar.getLayers());
            }
        } else {
            if (!(key instanceof b)) {
                throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + Consts.DOT);
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new X509EncodedKeySpec(key.getEncoded());
            }
            if (g.a.i.c.c.c.class.isAssignableFrom(cls)) {
                b bVar = (b) key;
                return new g.a.i.c.c.c(bVar.getDocLength(), bVar.getCoeffQuadratic(), bVar.getCoeffSingular(), bVar.getCoeffScalar());
            }
        }
        throw new InvalidKeySpecException("Unknown key specification: " + cls + Consts.DOT);
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if ((key instanceof a) || (key instanceof b)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type");
    }

    @Override // g.a.e.b.d.b
    public PrivateKey generatePrivate(g.a.a.t3.b bVar) throws IOException {
        f fVar = f.getInstance(bVar.parsePrivateKey());
        return new a(fVar.getInvA1(), fVar.getB1(), fVar.getInvA2(), fVar.getB2(), fVar.getVi(), fVar.getLayers());
    }

    @Override // g.a.e.b.d.b
    public PublicKey generatePublic(l lVar) throws IOException {
        g gVar = g.getInstance(lVar.parsePublicKey());
        return new b(gVar.getDocLength(), gVar.getCoeffQuadratic(), gVar.getCoeffSingular(), gVar.getCoeffScalar());
    }
}

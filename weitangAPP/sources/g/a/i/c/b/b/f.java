package g.a.i.c.b.b;

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
        if (!(keySpec instanceof PKCS8EncodedKeySpec)) {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + Consts.DOT);
        }
        try {
            g.a.a.t3.b bVar = g.a.a.t3.b.getInstance(a0.fromByteArray(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
            try {
                if (!g.a.i.a.e.m.equals((a0) bVar.getPrivateKeyAlgorithm().getAlgorithm())) {
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
                }
                g.a.i.a.c cVar = g.a.i.a.c.getInstance(bVar.parsePrivateKey());
                return new c(new g.a.i.b.c.f(cVar.getN(), cVar.getK(), cVar.getField(), cVar.getGoppaPoly(), cVar.getP1(), cVar.getP2(), cVar.getSInv()));
            } catch (IOException unused) {
                throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
            }
        } catch (IOException e2) {
            throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec: " + e2);
        }
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof X509EncodedKeySpec)) {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + Consts.DOT);
        }
        try {
            l lVar = l.getInstance(a0.fromByteArray(((X509EncodedKeySpec) keySpec).getEncoded()));
            try {
                if (!g.a.i.a.e.m.equals((a0) lVar.getAlgorithm().getAlgorithm())) {
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
                }
                g.a.i.a.d dVar = g.a.i.a.d.getInstance(lVar.parsePublicKey());
                return new d(new g.a.i.b.c.g(dVar.getN(), dVar.getT(), dVar.getG()));
            } catch (IOException e2) {
                throw new InvalidKeySpecException("Unable to decode X509EncodedKeySpec: " + e2.getMessage());
            }
        } catch (IOException e3) {
            throw new InvalidKeySpecException(e3.toString());
        }
    }

    @Override // java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        return null;
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        return null;
    }

    @Override // g.a.e.b.d.b
    public PrivateKey generatePrivate(g.a.a.t3.b bVar) throws IOException {
        g.a.i.a.c cVar = g.a.i.a.c.getInstance(bVar.parsePrivateKey().toASN1Primitive());
        return new c(new g.a.i.b.c.f(cVar.getN(), cVar.getK(), cVar.getField(), cVar.getGoppaPoly(), cVar.getP1(), cVar.getP2(), cVar.getSInv()));
    }

    @Override // g.a.e.b.d.b
    public PublicKey generatePublic(l lVar) throws IOException {
        g.a.i.a.d dVar = g.a.i.a.d.getInstance(lVar.parsePublicKey());
        return new d(new g.a.i.b.c.g(dVar.getN(), dVar.getT(), dVar.getG()));
    }

    public KeySpec getKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof c) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
        } else {
            if (!(key instanceof d)) {
                throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + Consts.DOT);
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new X509EncodedKeySpec(key.getEncoded());
            }
        }
        throw new InvalidKeySpecException("Unknown key specification: " + cls + Consts.DOT);
    }

    public Key translateKey(Key key) throws InvalidKeyException {
        if ((key instanceof c) || (key instanceof d)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type.");
    }
}

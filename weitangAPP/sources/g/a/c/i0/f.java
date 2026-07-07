package g.a.c.i0;

import g.a.a.v;
import g.a.c.h0;
import g.a.c.u;
import g.a.h.l;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PrivateKey f13683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f13684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f13685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f13686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13688f;

    public f(PrivateKey privateKey) {
        c cVar = new c(new b());
        this.f13684b = cVar;
        this.f13685c = cVar;
        this.f13686d = new HashMap();
        this.f13687e = false;
        this.f13683a = a.a(privateKey);
    }

    public Key a(g.a.a.y3.a aVar, g.a.a.y3.a aVar2, byte[] bArr) throws g.a.c.h {
        if (!a.d(aVar.getAlgorithm())) {
            g.a.h.o.a mustProduceEncodableUnwrappedKey = this.f13684b.createAsymmetricUnwrapper(aVar, this.f13683a).setMustProduceEncodableUnwrappedKey(this.f13688f);
            if (!this.f13686d.isEmpty()) {
                for (v vVar : this.f13686d.keySet()) {
                    mustProduceEncodableUnwrappedKey.setAlgorithmMapping(vVar, (String) this.f13686d.get(vVar));
                }
            }
            try {
                Key jceKey = this.f13684b.getJceKey(aVar2.getAlgorithm(), mustProduceEncodableUnwrappedKey.generateUnwrappedKey(aVar2, bArr));
                if (this.f13687e) {
                    this.f13684b.keySizeCheck(aVar2, jceKey);
                }
                return jceKey;
            } catch (l e2) {
                throw new g.a.c.h("exception unwrapping key: " + e2.getMessage(), e2);
            }
        }
        try {
            g.a.a.k3.e eVar = g.a.a.k3.e.getInstance(bArr);
            g.a.a.k3.f transportParameters = eVar.getTransportParameters();
            PublicKey publicKeyGeneratePublic = this.f13684b.createKeyFactory(aVar.getAlgorithm()).generatePublic(new X509EncodedKeySpec(transportParameters.getEphemeralPublicKey().getEncoded()));
            KeyAgreement keyAgreementC = this.f13684b.c(aVar.getAlgorithm());
            keyAgreementC.init(this.f13683a, new g.a.e.c.d(transportParameters.getUkm()));
            keyAgreementC.doPhase(publicKeyGeneratePublic, true);
            v vVar2 = g.a.a.k3.a.f13206e;
            SecretKey secretKeyGenerateSecret = keyAgreementC.generateSecret(vVar2.getId());
            Cipher cipherB = this.f13684b.b(vVar2);
            cipherB.init(4, secretKeyGenerateSecret, new g.a.e.c.b(transportParameters.getEncryptionParamSet(), transportParameters.getUkm()));
            g.a.a.k3.d sessionEncryptedKey = eVar.getSessionEncryptedKey();
            return cipherB.unwrap(g.a.j.a.concatenate(sessionEncryptedKey.getEncryptedKey(), sessionEncryptedKey.getMacKey()), this.f13684b.e(aVar2.getAlgorithm()), 3);
        } catch (Exception e3) {
            throw new g.a.c.h("exception unwrapping key: " + e3.getMessage(), e3);
        }
    }

    @Override // g.a.c.u
    public abstract /* synthetic */ h0 getRecipientOperator(g.a.a.y3.a aVar, g.a.a.y3.a aVar2, byte[] bArr) throws g.a.c.h;

    public f setAlgorithmMapping(v vVar, String str) {
        this.f13686d.put(vVar, str);
        return this;
    }

    public f setContentProvider(String str) {
        this.f13685c = a.b(str);
        return this;
    }

    public f setContentProvider(Provider provider) {
        this.f13685c = a.c(provider);
        return this;
    }

    public f setKeySizeValidation(boolean z) {
        this.f13687e = z;
        return this;
    }

    public f setMustProduceEncodableUnwrappedKey(boolean z) {
        this.f13688f = z;
        return this;
    }

    public f setProvider(String str) {
        c cVar = new c(new g(str));
        this.f13684b = cVar;
        this.f13685c = cVar;
        return this;
    }

    public f setProvider(Provider provider) {
        c cVar = new c(new h(provider));
        this.f13684b = cVar;
        this.f13685c = cVar;
        return this;
    }
}

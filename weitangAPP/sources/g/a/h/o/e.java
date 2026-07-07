package g.a.h.o;

import g.a.a.a0;
import g.a.a.v;
import g.a.a.y3.l;
import g.a.b.f;
import g.a.h.k;
import g.a.j.g;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f14208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f14209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f14210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f14211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f14212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static g.a.h.e f14213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g.a.e.d.d f14214g;

    public static class a extends CertificateException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Throwable f14215a;

        public a(String str, Throwable th) {
            super(str);
            this.f14215a = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.f14215a;
        }
    }

    static {
        HashMap map = new HashMap();
        f14208a = map;
        HashMap map2 = new HashMap();
        f14209b = map2;
        HashMap map3 = new HashMap();
        f14210c = map3;
        HashMap map4 = new HashMap();
        f14211d = map4;
        HashMap map5 = new HashMap();
        f14212e = map5;
        f14213f = new g.a.h.e();
        map.put(g.a.a.s3.a.f13329i, "SHA1");
        map.put(g.a.a.q3.b.f13304f, "SHA224");
        map.put(g.a.a.q3.b.f13301c, "SHA256");
        map.put(g.a.a.q3.b.f13302d, "SHA384");
        map.put(g.a.a.q3.b.f13303e, "SHA512");
        map.put(g.a.a.w3.b.f13409c, "RIPEMD128");
        map.put(g.a.a.w3.b.f13408b, "RIPEMD160");
        map.put(g.a.a.w3.b.f13410d, "RIPEMD256");
        map2.put(g.a.a.t3.a.s0, "RSA/ECB/PKCS1Padding");
        map2.put(g.a.a.k3.a.m, "ECGOST3410");
        v vVar = g.a.a.t3.a.q3;
        map3.put(vVar, "DESEDEWrap");
        map3.put(g.a.a.t3.a.r3, "RC2Wrap");
        v vVar2 = g.a.a.q3.b.B;
        map3.put(vVar2, "AESWrap");
        v vVar3 = g.a.a.q3.b.J;
        map3.put(vVar3, "AESWrap");
        v vVar4 = g.a.a.q3.b.R;
        map3.put(vVar4, "AESWrap");
        v vVar5 = g.a.a.r3.a.f13315d;
        map3.put(vVar5, "CamelliaWrap");
        v vVar6 = g.a.a.r3.a.f13316e;
        map3.put(vVar6, "CamelliaWrap");
        v vVar7 = g.a.a.r3.a.f13317f;
        map3.put(vVar7, "CamelliaWrap");
        v vVar8 = g.a.a.p3.a.f13286d;
        map3.put(vVar8, "SEEDWrap");
        v vVar9 = g.a.a.t3.a.W0;
        map3.put(vVar9, "DESede");
        map5.put(vVar, g.valueOf(192));
        map5.put(vVar2, g.valueOf(128));
        map5.put(vVar3, g.valueOf(192));
        map5.put(vVar4, g.valueOf(256));
        map5.put(vVar5, g.valueOf(128));
        map5.put(vVar6, g.valueOf(192));
        map5.put(vVar7, g.valueOf(256));
        map5.put(vVar8, g.valueOf(128));
        map5.put(vVar9, g.valueOf(192));
        map4.put(g.a.a.q3.b.w, "AES");
        map4.put(g.a.a.q3.b.y, "AES");
        map4.put(g.a.a.q3.b.G, "AES");
        map4.put(g.a.a.q3.b.O, "AES");
        map4.put(vVar9, "DESede");
        map4.put(g.a.a.t3.a.X0, "RC2");
    }

    public e(g.a.e.d.d dVar) {
        this.f14214g = dVar;
    }

    public AlgorithmParameters a(g.a.a.y3.a aVar) throws k {
        if (aVar.getAlgorithm().equals((a0) g.a.a.t3.a.s0)) {
            return null;
        }
        try {
            AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f14214g.createAlgorithmParameters(aVar.getAlgorithm().getId());
            try {
                algorithmParametersCreateAlgorithmParameters.init(aVar.getParameters().toASN1Primitive().getEncoded());
                return algorithmParametersCreateAlgorithmParameters;
            } catch (IOException e2) {
                throw new k("cannot initialise algorithm parameters: " + e2.getMessage(), e2);
            }
        } catch (NoSuchAlgorithmException unused) {
            return null;
        } catch (NoSuchProviderException e3) {
            throw new k("cannot create algorithm parameters: " + e3.getMessage(), e3);
        }
    }

    public Cipher b(v vVar, Map map) throws k {
        try {
            String str = map.isEmpty() ? null : (String) map.get(vVar);
            if (str == null) {
                str = (String) f14209b.get(vVar);
            }
            if (str != null) {
                try {
                    return this.f14214g.createCipher(str);
                } catch (NoSuchAlgorithmException unused) {
                    if (str.equals("RSA/ECB/PKCS1Padding")) {
                        try {
                            return this.f14214g.createCipher("RSA/NONE/PKCS1Padding");
                        } catch (NoSuchAlgorithmException unused2) {
                        }
                    }
                    return this.f14214g.createCipher(vVar.getId());
                }
            }
            return this.f14214g.createCipher(vVar.getId());
        } catch (GeneralSecurityException e2) {
            throw new k("cannot create cipher: " + e2.getMessage(), e2);
        }
    }

    public Cipher c(v vVar) throws k {
        try {
            String str = (String) f14210c.get(vVar);
            if (str != null) {
                try {
                    return this.f14214g.createCipher(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f14214g.createCipher(vVar.getId());
        } catch (GeneralSecurityException e2) {
            throw new k("cannot create cipher: " + e2.getMessage(), e2);
        }
    }

    public X509Certificate convertCertificate(f fVar) throws CertificateException {
        try {
            return (X509Certificate) this.f14214g.createCertificateFactory("X.509").generateCertificate(new ByteArrayInputStream(fVar.getEncoded()));
        } catch (IOException e2) {
            throw new a("cannot get encoded form of certificate: " + e2.getMessage(), e2);
        } catch (NoSuchProviderException e3) {
            throw new a("cannot find factory provider: " + e3.getMessage(), e3);
        }
    }

    public PublicKey convertPublicKey(l lVar) throws k {
        try {
            return this.f14214g.createKeyFactory(lVar.getAlgorithm().getAlgorithm().getId()).generatePublic(new X509EncodedKeySpec(lVar.getEncoded()));
        } catch (IOException e2) {
            throw new k("cannot get encoded form of key: " + e2.getMessage(), e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new k("cannot create key factory: " + e3.getMessage(), e3);
        } catch (NoSuchProviderException e4) {
            throw new k("cannot find factory provider: " + e4.getMessage(), e4);
        } catch (InvalidKeySpecException e5) {
            throw new k("cannot create key factory: " + e5.getMessage(), e5);
        }
    }

    public String d(v vVar) {
        String str = (String) f14211d.get(vVar);
        return str != null ? str : vVar.getId();
    }

    public String e(v vVar) {
        return (String) f14210c.get(vVar);
    }
}

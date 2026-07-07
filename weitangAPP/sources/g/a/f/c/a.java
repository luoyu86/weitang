package g.a.f.c;

import com.alibaba.android.arouter.utils.Consts;
import com.alipay.sdk.m.n.d;
import g.a.a.v;
import g.a.a.y3.l;
import g.a.i.a.e;
import g.a.i.c.b.f.c;
import g.a.i.c.b.h.f;
import g.a.i.c.b.h.g;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Provider implements g.a.e.b.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f13861a = "BouncyCastle Security Provider v1.70";
    public static final g.a.e.b.b.b CONFIGURATION = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f13862b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class f13863c = g.a.e.b.c.a.a.loadClass(a.class, "java.security.cert.PKIXRevocationChecker");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f13864d = {"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF", "SCRYPT"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f13865e = {"SipHash", "SipHash128", "Poly1305"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f13866f = {"AES", "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF", "DSTU7624", "GOST3412_2015", "Zuc"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f13867g = {"X509", "IES", "COMPOSITE"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f13868h = {"DSA", "DH", "EC", d.f5523a, "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM", "EdEC"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f13869i = {"GOST3411", "Keccak", MessageDigestAlgorithms.MD2, "MD4", MessageDigestAlgorithms.MD5, "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "Blake2s", "DSTU7564", "Haraka"};
    public static final String PROVIDER_NAME = "BC";
    public static final String[] j = {PROVIDER_NAME, "BCFKS", "PKCS12"};
    public static final String[] k = {"DRBG"};

    /* JADX INFO: renamed from: g.a.f.c.a$a, reason: collision with other inner class name */
    public class C0257a implements PrivilegedAction {
        public C0257a() {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            a.this.e();
            return null;
        }
    }

    public a() {
        super(PROVIDER_NAME, 1.7d, f13861a);
        AccessController.doPrivileged(new C0257a());
    }

    public static g.a.e.b.d.b b(v vVar) {
        g.a.e.b.d.b bVar;
        Map map = f13862b;
        synchronized (map) {
            bVar = (g.a.e.b.d.b) map.get(vVar);
        }
        return bVar;
    }

    public static PrivateKey getPrivateKey(g.a.a.t3.b bVar) throws IOException {
        g.a.e.b.d.b bVarB = b(bVar.getPrivateKeyAlgorithm().getAlgorithm());
        if (bVarB == null) {
            return null;
        }
        return bVarB.generatePrivate(bVar);
    }

    public static PublicKey getPublicKey(l lVar) throws IOException {
        g.a.e.b.d.b bVarB = b(lVar.getAlgorithm().getAlgorithm());
        if (bVarB == null) {
            return null;
        }
        return bVarB.generatePublic(lVar);
    }

    @Override // g.a.e.b.b.a
    public void addAlgorithm(String str, v vVar, String str2) {
        addAlgorithm(str + Consts.DOT + vVar, str2);
        addAlgorithm(str + ".OID." + vVar, str2);
    }

    @Override // g.a.e.b.b.a
    public void addAlgorithm(String str, String str2) {
        if (!containsKey(str)) {
            put(str, str2);
            return;
        }
        throw new IllegalStateException("duplicate provider key (" + str + ") found");
    }

    @Override // g.a.e.b.b.a
    public void addAttributes(String str, Map<String, String> map) {
        for (String str2 : map.keySet()) {
            String str3 = str + " " + str2;
            if (containsKey(str3)) {
                throw new IllegalStateException("duplicate provider attribute key (" + str3 + ") found");
            }
            put(str3, map.get(str2));
        }
    }

    @Override // g.a.e.b.b.a
    public void addKeyInfoConverter(v vVar, g.a.e.b.d.b bVar) {
        Map map = f13862b;
        synchronized (map) {
            map.put(vVar, bVar);
        }
    }

    public final void c(String str, String[] strArr) {
        for (int i2 = 0; i2 != strArr.length; i2++) {
            Class clsLoadClass = g.a.e.b.c.a.a.loadClass(a.class, str + strArr[i2] + "$Mappings");
            if (clsLoadClass != null) {
                try {
                    ((g.a.e.b.d.a) clsLoadClass.newInstance()).configure(this);
                } catch (Exception e2) {
                    throw new InternalError("cannot create instance of " + str + strArr[i2] + "$Mappings : " + e2);
                }
            }
        }
    }

    public final void d() {
        addKeyInfoConverter(e.r, new c());
        addKeyInfoConverter(e.v, new g.a.i.c.b.c.c());
        addKeyInfoConverter(e.w, new f());
        addKeyInfoConverter(g.a.a.o3.a.f13275a, new f());
        addKeyInfoConverter(e.F, new g());
        addKeyInfoConverter(g.a.a.o3.a.f13276b, new g());
        addKeyInfoConverter(e.m, new g.a.i.c.b.b.f());
        addKeyInfoConverter(e.n, new g.a.i.c.b.b.e());
        addKeyInfoConverter(e.f14236a, new g.a.i.c.b.e.c());
        addKeyInfoConverter(e.X, new g.a.i.c.b.d.c());
        addKeyInfoConverter(e.Y, new g.a.i.c.b.d.c());
        addKeyInfoConverter(g.a.a.t3.a.e2, new g.a.i.c.b.a.c());
    }

    public final void e() {
        String str;
        String str2;
        c("org.bouncycastle.jcajce.provider.digest.", f13869i);
        c("org.bouncycastle.jcajce.provider.symmetric.", f13864d);
        c("org.bouncycastle.jcajce.provider.symmetric.", f13865e);
        c("org.bouncycastle.jcajce.provider.symmetric.", f13866f);
        c("org.bouncycastle.jcajce.provider.asymmetric.", f13867g);
        c("org.bouncycastle.jcajce.provider.asymmetric.", f13868h);
        c("org.bouncycastle.jcajce.provider.keystore.", j);
        c("org.bouncycastle.jcajce.provider.drbg.", k);
        d();
        put("X509Store.CERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertCollection");
        put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreAttrCertCollection");
        put("X509Store.CRL/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCRLCollection");
        put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertPairCollection");
        put("X509Store.CERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCerts");
        put("X509Store.CRL/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCRLs");
        put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
        put("X509Store.CERTIFICATEPAIR/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
        put("X509StreamParser.CERTIFICATE", "org.bouncycastle.jce.provider.X509CertParser");
        put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.bouncycastle.jce.provider.X509AttrCertParser");
        put("X509StreamParser.CRL", "org.bouncycastle.jce.provider.X509CRLParser");
        put("X509StreamParser.CERTIFICATEPAIR", "org.bouncycastle.jce.provider.X509CertPairParser");
        put("Cipher.BROKENPBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        Class cls = f13863c;
        put("CertPathValidator.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
        put("CertPathBuilder.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
        if (cls != null) {
            str = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8";
            put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8");
            str2 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi_8";
        } else {
            str = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi";
            put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
            str2 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi";
        }
        put("CertPathBuilder.RFC3280", str2);
        put("CertPathValidator.PKIX", str);
        put("CertPathBuilder.PKIX", str2);
        put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
        put("CertStore.LDAP", "org.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
        put("CertStore.Multi", "org.bouncycastle.jce.provider.MultiCertStoreSpi");
        put("Alg.Alias.CertStore.X509LDAP", "LDAP");
    }

    @Override // g.a.e.b.b.a
    public g.a.e.b.d.b getKeyInfoConverter(v vVar) {
        return (g.a.e.b.d.b) f13862b.get(vVar);
    }

    @Override // g.a.e.b.b.a
    public boolean hasAlgorithm(String str, String str2) {
        if (!containsKey(str + Consts.DOT + str2)) {
            if (!containsKey("Alg.Alias." + str + Consts.DOT + str2)) {
                return false;
            }
        }
        return true;
    }

    @Override // g.a.e.b.b.a
    public void setParameter(String str, Object obj) {
        g.a.e.b.b.b bVar = CONFIGURATION;
        synchronized (bVar) {
            ((b) bVar).a(str, obj);
        }
    }
}

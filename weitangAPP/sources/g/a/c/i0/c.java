package g.a.c.i0;

import com.tom_roush.fontbox.ttf.GlyfCompositeComp;
import g.a.a.r;
import g.a.a.v;
import g.a.a.w;
import g.a.a.x1;
import g.a.c.z;
import g.a.h.m;
import g.a.h.n;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f13668a = g.a.h.d.f14189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f13669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f13670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f13671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f13672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map f13673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final short[] f13674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final short[] f13675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f13676i;

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.a.a.y3.a f13677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Key f13678b;

        public a(g.a.a.y3.a aVar, Key key) {
            this.f13677a = aVar;
            this.f13678b = key;
        }

        @Override // g.a.c.i0.c.b
        public Object doInJCE() throws NoSuchPaddingException, g.a.c.h, NoSuchAlgorithmException, InvalidParameterSpecException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
            Cipher cipherB = c.this.b(this.f13677a.getAlgorithm());
            g.a.a.g parameters = this.f13677a.getParameters();
            String id = this.f13677a.getAlgorithm().getId();
            if (parameters != null && !(parameters instanceof r)) {
                try {
                    AlgorithmParameters algorithmParametersA = c.this.a(this.f13677a.getAlgorithm());
                    g.a.c.i0.a.e(algorithmParametersA, parameters);
                    cipherB.init(2, this.f13678b, algorithmParametersA);
                } catch (NoSuchAlgorithmException e2) {
                    if (!id.equals(g.a.c.b.f13616a.getId()) && !id.equals(g.a.c.f.f13635a) && !id.equals("1.3.6.1.4.1.188.7.1.1.2") && !id.equals(g.a.c.f.f13637c) && !id.equals(g.a.c.f.f13638d) && !id.equals(g.a.c.f.f13639e)) {
                        throw e2;
                    }
                    cipherB.init(2, this.f13678b, new IvParameterSpec(w.getInstance(parameters).getOctets()));
                }
            } else if (id.equals(g.a.c.b.f13616a.getId()) || id.equals(g.a.c.f.f13635a) || id.equals("1.3.6.1.4.1.188.7.1.1.2") || id.equals("1.2.840.113533.7.66.10")) {
                cipherB.init(2, this.f13678b, new IvParameterSpec(new byte[8]));
            } else {
                cipherB.init(2, this.f13678b);
            }
            return cipherB;
        }
    }

    public interface b {
        Object doInJCE() throws NoSuchPaddingException, g.a.c.h, NoSuchAlgorithmException, InvalidParameterSpecException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException;
    }

    static {
        HashSet hashSet = new HashSet();
        f13669b = hashSet;
        HashMap map = new HashMap();
        f13670c = map;
        HashMap map2 = new HashMap();
        f13671d = map2;
        HashMap map3 = new HashMap();
        f13672e = map3;
        HashMap map4 = new HashMap();
        f13673f = map4;
        v vVar = g.a.c.b.f13616a;
        map.put(vVar, "DES");
        v vVar2 = g.a.c.b.f13617b;
        map.put(vVar2, "DESEDE");
        v vVar3 = g.a.c.b.f13621f;
        map.put(vVar3, "AES");
        v vVar4 = g.a.c.b.f13622g;
        map.put(vVar4, "AES");
        v vVar5 = g.a.c.b.f13623h;
        map.put(vVar5, "AES");
        v vVar6 = g.a.c.b.f13618c;
        map.put(vVar6, "RC2");
        v vVar7 = g.a.c.b.f13620e;
        map.put(vVar7, "CAST5");
        v vVar8 = g.a.c.b.o;
        map.put(vVar8, "Camellia");
        v vVar9 = g.a.c.b.p;
        map.put(vVar9, "Camellia");
        v vVar10 = g.a.c.b.f13625q;
        map.put(vVar10, "Camellia");
        v vVar11 = g.a.c.b.s;
        map.put(vVar11, "SEED");
        v vVar12 = g.a.a.t3.a.Y0;
        map.put(vVar12, "RC4");
        map.put(g.a.a.k3.a.f13207f, "GOST28147");
        map2.put(vVar, "DES/CBC/PKCS5Padding");
        map2.put(vVar6, "RC2/CBC/PKCS5Padding");
        map2.put(vVar2, "DESEDE/CBC/PKCS5Padding");
        map2.put(vVar3, "AES/CBC/PKCS5Padding");
        map2.put(vVar4, "AES/CBC/PKCS5Padding");
        map2.put(vVar5, "AES/CBC/PKCS5Padding");
        map2.put(g.a.a.t3.a.s0, "RSA/ECB/PKCS1Padding");
        map2.put(vVar7, "CAST5/CBC/PKCS5Padding");
        map2.put(vVar8, "Camellia/CBC/PKCS5Padding");
        map2.put(vVar9, "Camellia/CBC/PKCS5Padding");
        map2.put(vVar10, "Camellia/CBC/PKCS5Padding");
        map2.put(vVar11, "SEED/CBC/PKCS5Padding");
        map2.put(vVar12, "RC4");
        map3.put(vVar2, "DESEDEMac");
        map3.put(vVar3, "AESMac");
        map3.put(vVar4, "AESMac");
        map3.put(vVar5, "AESMac");
        map3.put(vVar6, "RC2Mac");
        map4.put(z.a.f13707a.getAlgorithmID(), "PBKDF2WITHHMACSHA1");
        map4.put(z.a.f13708b.getAlgorithmID(), "PBKDF2WITHHMACSHA224");
        map4.put(z.a.f13709c.getAlgorithmID(), "PBKDF2WITHHMACSHA256");
        map4.put(z.a.f13710d.getAlgorithmID(), "PBKDF2WITHHMACSHA384");
        map4.put(z.a.f13711e.getAlgorithmID(), "PBKDF2WITHHMACSHA512");
        hashSet.add(g.a.a.q3.b.C);
        hashSet.add(g.a.a.q3.b.K);
        hashSet.add(g.a.a.q3.b.S);
        hashSet.add(g.a.a.q3.b.D);
        hashSet.add(g.a.a.q3.b.L);
        hashSet.add(g.a.a.q3.b.T);
        f13674g = new short[]{189, 86, 234, 242, 162, 241, 172, 42, 176, 147, 209, 156, 27, 51, 253, 208, 48, 4, 182, 220, 125, 223, 50, 75, 247, 203, 69, 155, 49, 187, 33, 90, 65, 159, 225, 217, 74, 77, 158, 218, 160, 104, 44, 195, 39, 95, GlyfCompositeComp.WE_HAVE_A_TWO_BY_TWO, 54, 62, 238, 251, 149, 26, 254, 206, 168, 52, 169, 19, 240, 166, 63, 216, 12, 120, 36, 175, 35, 82, 193, 103, 23, 245, 102, 144, 231, 232, 7, 184, 96, 72, 230, 30, 83, 243, 146, 164, 114, 140, 8, 21, 110, 134, 0, 132, 250, 244, 127, 138, 66, 25, 246, 219, 205, 20, 141, 80, 18, 186, 60, 6, 78, 236, 179, 53, 17, 161, 136, 142, 43, 148, 153, 183, 113, 116, 211, 228, 191, 58, 222, 150, 14, 188, 10, 237, 119, 252, 55, 107, 3, 121, 137, 98, 198, 215, 192, 210, 124, 106, 139, 34, 163, 91, 5, 93, 2, 117, 213, 97, 227, 24, 143, 85, 81, 173, 31, 11, 94, 133, 229, 194, 87, 99, 202, 61, 108, 180, 197, 204, 112, 178, 145, 89, 13, 71, 32, 200, 79, 88, 224, 1, 226, 22, 56, 196, 111, 59, 15, 101, 70, 190, 126, 45, 123, 130, 249, 64, 181, 29, 115, 248, 235, 38, 199, 135, 151, 37, 84, 177, 40, 170, 152, 157, 165, 100, 109, 122, 212, 16, 129, 68, 239, 73, 214, 174, 46, 221, 118, 92, 47, 167, 28, 201, 9, 105, 154, 131, 207, 41, 57, 185, 233, 76, 255, 67, 171};
        f13675h = new short[]{93, 190, 155, 139, 17, 153, 110, 77, 89, 243, 133, 166, 63, 183, 131, 197, 228, 115, 107, 58, 104, 90, 192, 71, 160, 100, 52, 12, 241, 208, 82, 165, 185, 30, 150, 67, 65, 216, 212, 44, 219, 248, 7, 119, 42, 202, 235, 239, 16, 28, 22, 13, 56, 114, 47, 137, 193, 249, GlyfCompositeComp.WE_HAVE_A_TWO_BY_TWO, 196, 109, 174, 48, 61, 206, 32, 99, 254, 230, 26, 199, 184, 80, 232, 36, 23, 252, 37, 111, 187, 106, 163, 68, 83, 217, 162, 1, 171, 188, 182, 31, 152, 238, 154, 167, 45, 79, 158, 142, 172, 224, 198, 73, 70, 41, 244, 148, 138, 175, 225, 91, 195, 179, 123, 87, 209, 124, 156, 237, 135, 64, 140, 226, 203, 147, 20, 201, 97, 46, 229, 204, 246, 94, 168, 92, 214, 117, 141, 98, 149, 88, 105, 118, 161, 74, 181, 85, 9, 120, 51, 130, 215, 221, 121, 245, 27, 11, 222, 38, 33, 40, 116, 4, 151, 86, 223, 60, 240, 55, 57, 220, 255, 6, 164, 234, 66, 8, 218, 180, 113, 176, 207, 18, 122, 78, 250, 108, 29, 132, 0, 200, 127, 145, 69, 170, 43, 194, 177, 143, 213, 186, 242, 173, 25, 178, 103, 54, 247, 15, 10, 146, 125, 227, 157, 233, 144, 62, 35, 39, 102, 19, 236, 129, 21, 189, 34, 191, 159, 126, 169, 81, 75, 76, 251, 2, 211, 112, 134, 49, 231, 59, 5, 3, 84, 96, 72, 101, 24, 210, 205, 95, 50, 136, 14, 53, 253};
    }

    public c(d dVar) {
        this.f13676i = dVar;
    }

    public static Object d(b bVar) throws g.a.c.h {
        try {
            return bVar.doInJCE();
        } catch (InvalidAlgorithmParameterException e2) {
            throw new g.a.c.h("algorithm parameters invalid.", e2);
        } catch (InvalidKeyException e3) {
            throw new g.a.c.h("key invalid in message.", e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new g.a.c.h("can't find algorithm.", e4);
        } catch (NoSuchProviderException e5) {
            throw new g.a.c.h("can't find provider.", e5);
        } catch (InvalidParameterSpecException e6) {
            throw new g.a.c.h("MAC algorithm parameter spec invalid.", e6);
        } catch (NoSuchPaddingException e7) {
            throw new g.a.c.h("required padding not supported.", e7);
        }
    }

    public AlgorithmParameters a(v vVar) throws NoSuchAlgorithmException, NoSuchProviderException {
        String str = (String) f13670c.get(vVar);
        if (str != null) {
            try {
                return this.f13676i.createAlgorithmParameters(str);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return this.f13676i.createAlgorithmParameters(vVar.getId());
    }

    public Cipher b(v vVar) throws g.a.c.h {
        try {
            String str = (String) f13671d.get(vVar);
            if (str != null) {
                try {
                    return this.f13676i.createCipher(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f13676i.createCipher(vVar.getId());
        } catch (GeneralSecurityException e2) {
            throw new g.a.c.h("cannot create cipher: " + e2.getMessage(), e2);
        }
    }

    public KeyAgreement c(v vVar) throws g.a.c.h {
        try {
            String str = (String) f13670c.get(vVar);
            if (str != null) {
                try {
                    return this.f13676i.createKeyAgreement(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f13676i.createKeyAgreement(vVar.getId());
        } catch (GeneralSecurityException e2) {
            throw new g.a.c.h("cannot create key agreement: " + e2.getMessage(), e2);
        }
    }

    public g.a.h.o.a createAsymmetricUnwrapper(g.a.a.y3.a aVar, PrivateKey privateKey) {
        return this.f13676i.createAsymmetricUnwrapper(aVar, g.a.c.i0.a.a(privateKey));
    }

    public g.a.h.o.c createAsymmetricUnwrapper(g.a.a.y3.a aVar, PrivateKey privateKey, byte[] bArr, byte[] bArr2) {
        return this.f13676i.createAsymmetricUnwrapper(aVar, g.a.c.i0.a.a(privateKey), bArr, bArr2);
    }

    public Cipher createContentCipher(Key key, g.a.a.y3.a aVar) throws g.a.c.h {
        return (Cipher) d(new a(aVar, key));
    }

    public KeyFactory createKeyFactory(v vVar) throws g.a.c.h {
        try {
            String str = (String) f13670c.get(vVar);
            if (str != null) {
                try {
                    return this.f13676i.createKeyFactory(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f13676i.createKeyFactory(vVar.getId());
        } catch (GeneralSecurityException e2) {
            throw new g.a.c.h("cannot create key factory: " + e2.getMessage(), e2);
        }
    }

    public KeyGenerator createKeyGenerator(v vVar) throws g.a.c.h {
        try {
            String str = (String) f13670c.get(vVar);
            if (str != null) {
                try {
                    return this.f13676i.createKeyGenerator(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f13676i.createKeyGenerator(vVar.getId());
        } catch (GeneralSecurityException e2) {
            throw new g.a.c.h("cannot create key generator: " + e2.getMessage(), e2);
        }
    }

    public n createSymmetricUnwrapper(g.a.a.y3.a aVar, SecretKey secretKey) {
        return this.f13676i.createSymmetricUnwrapper(aVar, secretKey);
    }

    public String e(v vVar) {
        String str = (String) f13670c.get(vVar);
        return str == null ? vVar.getId() : str;
    }

    public g.a.a.y3.a getAlgorithmIdentifier(v vVar, AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            return new g.a.a.y3.a(vVar, new x1(((IvParameterSpec) algorithmParameterSpec).getIV()));
        }
        if (!(algorithmParameterSpec instanceof RC2ParameterSpec)) {
            throw new IllegalStateException("unknown parameter spec: " + algorithmParameterSpec);
        }
        RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
        int effectiveKeyBits = rC2ParameterSpec.getEffectiveKeyBits();
        if (effectiveKeyBits == -1) {
            return new g.a.a.y3.a(vVar, new g.a.a.t3.c(rC2ParameterSpec.getIV()));
        }
        int i2 = effectiveKeyBits;
        if (effectiveKeyBits < 256) {
            i2 = f13674g[effectiveKeyBits];
        }
        return new g.a.a.y3.a(vVar, new g.a.a.t3.c(i2, rC2ParameterSpec.getIV()));
    }

    public Key getJceKey(v vVar, g.a.h.g gVar) {
        if (gVar.getRepresentation() instanceof Key) {
            return (Key) gVar.getRepresentation();
        }
        if (gVar.getRepresentation() instanceof byte[]) {
            return new SecretKeySpec((byte[]) gVar.getRepresentation(), e(vVar));
        }
        throw new IllegalArgumentException("unknown generic key type");
    }

    public void keySizeCheck(g.a.a.y3.a aVar, Key key) throws g.a.c.h {
        int keySize = f13668a.getKeySize(aVar);
        if (keySize > 0) {
            byte[] encoded = null;
            try {
                encoded = key.getEncoded();
            } catch (Exception unused) {
            }
            if (encoded != null && encoded.length * 8 != keySize) {
                throw new g.a.c.h("Expected key size for algorithm OID not found in recipient.");
            }
        }
    }
}

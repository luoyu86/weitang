package g.a.h;

import g.a.a.a0;
import g.a.a.v;
import g.a.a.v1;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f14191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f14192b;

    static {
        HashMap map = new HashMap();
        f14191a = map;
        HashMap map2 = new HashMap();
        f14192b = map2;
        map.put(g.a.a.t3.a.D0, "RSASSA-PSS");
        map.put(g.a.a.m3.a.f13249d, "ED25519");
        map.put(g.a.a.m3.a.f13250e, "ED448");
        map.put(new v("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        map.put(g.a.a.t3.a.H0, "SHA224WITHRSA");
        map.put(g.a.a.t3.a.E0, "SHA256WITHRSA");
        map.put(g.a.a.t3.a.F0, "SHA384WITHRSA");
        map.put(g.a.a.t3.a.G0, "SHA512WITHRSA");
        map.put(g.a.a.i3.d.n0, "SHAKE128WITHRSAPSS");
        map.put(g.a.a.i3.d.o0, "SHAKE256WITHRSAPSS");
        map.put(g.a.a.k3.a.n, "GOST3411WITHGOST3410");
        map.put(g.a.a.k3.a.o, "GOST3411WITHECGOST3410");
        map.put(g.a.a.u3.a.f13358i, "GOST3411-2012-256WITHECGOST3410-2012-256");
        map.put(g.a.a.u3.a.j, "GOST3411-2012-512WITHECGOST3410-2012-512");
        map.put(g.a.a.h3.a.f13107d, "SHA1WITHPLAIN-ECDSA");
        map.put(g.a.a.h3.a.f13108e, "SHA224WITHPLAIN-ECDSA");
        map.put(g.a.a.h3.a.f13109f, "SHA256WITHPLAIN-ECDSA");
        map.put(g.a.a.h3.a.f13110g, "SHA384WITHPLAIN-ECDSA");
        map.put(g.a.a.h3.a.f13111h, "SHA512WITHPLAIN-ECDSA");
        map.put(g.a.a.h3.a.j, "SHA3-224WITHPLAIN-ECDSA");
        map.put(g.a.a.h3.a.k, "SHA3-256WITHPLAIN-ECDSA");
        map.put(g.a.a.h3.a.l, "SHA3-384WITHPLAIN-ECDSA");
        map.put(g.a.a.h3.a.m, "SHA3-512WITHPLAIN-ECDSA");
        map.put(g.a.a.h3.a.f13112i, "RIPEMD160WITHPLAIN-ECDSA");
        map.put(g.a.a.l3.a.s, "SHA1WITHCVC-ECDSA");
        map.put(g.a.a.l3.a.t, "SHA224WITHCVC-ECDSA");
        map.put(g.a.a.l3.a.u, "SHA256WITHCVC-ECDSA");
        map.put(g.a.a.l3.a.v, "SHA384WITHCVC-ECDSA");
        map.put(g.a.a.l3.a.w, "SHA512WITHCVC-ECDSA");
        map.put(g.a.a.o3.a.f13275a, "XMSS");
        map.put(g.a.a.o3.a.f13276b, "XMSSMT");
        map.put(g.a.a.w3.b.f13413g, "RIPEMD128WITHRSA");
        map.put(g.a.a.w3.b.f13412f, "RIPEMD160WITHRSA");
        map.put(g.a.a.w3.b.f13414h, "RIPEMD256WITHRSA");
        map.put(new v("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        map.put(new v("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        map.put(new v("1.2.840.10040.4.3"), "SHA1WITHDSA");
        map.put(g.a.a.z3.k.c4, "SHA1WITHECDSA");
        map.put(g.a.a.z3.k.g4, "SHA224WITHECDSA");
        map.put(g.a.a.z3.k.h4, "SHA256WITHECDSA");
        map.put(g.a.a.z3.k.i4, "SHA384WITHECDSA");
        map.put(g.a.a.z3.k.j4, "SHA512WITHECDSA");
        map.put(g.a.a.i3.d.p0, "SHAKE128WITHECDSA");
        map.put(g.a.a.i3.d.q0, "SHAKE256WITHECDSA");
        map.put(g.a.a.s3.a.k, "SHA1WITHRSA");
        map.put(g.a.a.s3.a.j, "SHA1WITHDSA");
        map.put(g.a.a.q3.b.X, "SHA224WITHDSA");
        map.put(g.a.a.q3.b.Y, "SHA256WITHDSA");
        map2.put(g.a.a.s3.a.f13329i, "SHA1");
        map2.put(g.a.a.q3.b.f13304f, "SHA224");
        map2.put(g.a.a.q3.b.f13301c, "SHA256");
        map2.put(g.a.a.q3.b.f13302d, "SHA384");
        map2.put(g.a.a.q3.b.f13303e, "SHA512");
        map2.put(g.a.a.q3.b.f13307i, MessageDigestAlgorithms.SHA3_224);
        Map map3 = f14192b;
        map3.put(g.a.a.q3.b.j, MessageDigestAlgorithms.SHA3_256);
        map3.put(g.a.a.q3.b.k, MessageDigestAlgorithms.SHA3_384);
        map3.put(g.a.a.q3.b.l, MessageDigestAlgorithms.SHA3_512);
        map3.put(g.a.a.w3.b.f13409c, "RIPEMD128");
        map3.put(g.a.a.w3.b.f13408b, "RIPEMD160");
        map3.put(g.a.a.w3.b.f13410d, "RIPEMD256");
    }

    public static String a(v vVar) {
        String str = (String) f14192b.get(vVar);
        return str != null ? str : vVar.getId();
    }

    public String getAlgorithmName(v vVar) {
        String str = (String) f14191a.get(vVar);
        return str != null ? str : vVar.getId();
    }

    public String getAlgorithmName(g.a.a.y3.a aVar) {
        g.a.a.g parameters = aVar.getParameters();
        if (parameters == null || v1.f13368b.equals(parameters) || !aVar.getAlgorithm().equals((a0) g.a.a.t3.a.D0)) {
            Map map = f14191a;
            boolean zContainsKey = map.containsKey(aVar.getAlgorithm());
            v algorithm = aVar.getAlgorithm();
            return zContainsKey ? (String) map.get(algorithm) : algorithm.getId();
        }
        g.a.a.t3.d dVar = g.a.a.t3.d.getInstance(parameters);
        g.a.a.y3.a maskGenAlgorithm = dVar.getMaskGenAlgorithm();
        if (!maskGenAlgorithm.getAlgorithm().equals((a0) g.a.a.t3.a.z0)) {
            return a(dVar.getHashAlgorithm().getAlgorithm()) + "WITHRSAAND" + maskGenAlgorithm.getAlgorithm().getId();
        }
        g.a.a.y3.a hashAlgorithm = dVar.getHashAlgorithm();
        v algorithm2 = g.a.a.y3.a.getInstance(maskGenAlgorithm.getParameters()).getAlgorithm();
        if (algorithm2.equals((a0) hashAlgorithm.getAlgorithm())) {
            return a(hashAlgorithm.getAlgorithm()) + "WITHRSAANDMGF1";
        }
        return a(hashAlgorithm.getAlgorithm()) + "WITHRSAANDMGF1USING" + a(algorithm2);
    }

    public boolean hasAlgorithmName(v vVar) {
        return f14191a.containsKey(vVar);
    }
}

package g.a.e.b.a.a;

import g.a.a.v;
import g.a.a.y3.l;
import g.a.d.n.f;
import g.a.d.n.h;
import g.a.d.n.j;
import g.a.f.d.c;
import g.a.g.a.e;
import g.a.g.a.i;
import g.a.g.a.k;
import g.a.j.q;
import java.math.BigInteger;
import java.security.AccessController;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    public static class a implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlgorithmParameterSpec f13835a;

        public a(AlgorithmParameterSpec algorithmParameterSpec) {
            this.f13835a = algorithmParameterSpec;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            try {
                return this.f13835a.getClass().getMethod("getName", new Class[0]).invoke(this.f13835a, new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static int[] a(int[] iArr) {
        int[] iArr2 = new int[3];
        if (iArr.length == 1) {
            iArr2[0] = iArr[0];
        } else {
            if (iArr.length != 3) {
                throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
            }
            if (iArr[0] < iArr[1] && iArr[0] < iArr[2]) {
                iArr2[0] = iArr[0];
                if (iArr[1] < iArr[2]) {
                    iArr2[1] = iArr[1];
                    iArr2[2] = iArr[2];
                } else {
                    iArr2[1] = iArr[2];
                    iArr2[2] = iArr[1];
                }
            } else if (iArr[1] < iArr[2]) {
                iArr2[0] = iArr[1];
                if (iArr[0] < iArr[2]) {
                    iArr2[1] = iArr[0];
                    iArr2[2] = iArr[2];
                } else {
                    iArr2[1] = iArr[2];
                    iArr2[2] = iArr[0];
                }
            } else {
                iArr2[0] = iArr[2];
                if (iArr[0] < iArr[1]) {
                    iArr2[1] = iArr[0];
                    iArr2[2] = iArr[1];
                } else {
                    iArr2[1] = iArr[1];
                    iArr2[2] = iArr[0];
                }
            }
        }
        return iArr2;
    }

    public static v b(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt < '0' || cCharAt > '2') {
            return null;
        }
        try {
            return new v(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String generateKeyFingerprint(i iVar, c cVar) {
        e curve = cVar.getCurve();
        return curve != null ? new g.a.j.e(g.a.j.a.concatenate(iVar.getEncoded(false), curve.getA().getEncoded(), curve.getB().getEncoded(), cVar.getG().getEncoded(false))).toString() : new g.a.j.e(iVar.getEncoded(false)).toString();
    }

    public static g.a.d.n.a generatePrivateKeyParameter(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof g.a.f.b.a) {
            g.a.f.b.a aVar = (g.a.f.b.a) privateKey;
            c parameters = aVar.getParameters();
            if (parameters == null) {
                parameters = g.a.f.c.a.CONFIGURATION.getEcImplicitlyCa();
            }
            if (!(aVar.getParameters() instanceof g.a.f.d.a)) {
                return new g.a.d.n.i(aVar.getD(), new f(parameters.getCurve(), parameters.getG(), parameters.getN(), parameters.getH(), parameters.getSeed()));
            }
            return new g.a.d.n.i(aVar.getD(), new h(g.a.a.z3.a.getOID(((g.a.f.d.a) aVar.getParameters()).getName()), parameters.getCurve(), parameters.getG(), parameters.getN(), parameters.getH(), parameters.getSeed()));
        }
        if (privateKey instanceof ECPrivateKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) privateKey;
            c cVarConvertSpec = g.a.e.b.a.a.a.convertSpec(eCPrivateKey.getParams());
            return new g.a.d.n.i(eCPrivateKey.getS(), new f(cVarConvertSpec.getCurve(), cVarConvertSpec.getG(), cVarConvertSpec.getN(), cVarConvertSpec.getH(), cVarConvertSpec.getSeed()));
        }
        try {
            byte[] encoded = privateKey.getEncoded();
            if (encoded == null) {
                throw new InvalidKeyException("no encoding for EC private key");
            }
            PrivateKey privateKey2 = g.a.f.c.a.getPrivateKey(g.a.a.t3.b.getInstance(encoded));
            if (privateKey2 instanceof ECPrivateKey) {
                return generatePrivateKeyParameter(privateKey2);
            }
            throw new InvalidKeyException("can't identify EC private key.");
        } catch (Exception e2) {
            throw new InvalidKeyException("cannot identify EC private key: " + e2.toString());
        }
    }

    public static g.a.d.n.a generatePublicKeyParameter(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof g.a.f.b.b) {
            g.a.f.b.b bVar = (g.a.f.b.b) publicKey;
            c parameters = bVar.getParameters();
            return new j(bVar.getQ(), new f(parameters.getCurve(), parameters.getG(), parameters.getN(), parameters.getH(), parameters.getSeed()));
        }
        if (publicKey instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            c cVarConvertSpec = g.a.e.b.a.a.a.convertSpec(eCPublicKey.getParams());
            return new j(g.a.e.b.a.a.a.convertPoint(eCPublicKey.getParams(), eCPublicKey.getW()), new f(cVarConvertSpec.getCurve(), cVarConvertSpec.getG(), cVarConvertSpec.getN(), cVarConvertSpec.getH(), cVarConvertSpec.getSeed()));
        }
        try {
            byte[] encoded = publicKey.getEncoded();
            if (encoded == null) {
                throw new InvalidKeyException("no encoding for EC public key");
            }
            PublicKey publicKey2 = g.a.f.c.a.getPublicKey(l.getInstance(encoded));
            if (publicKey2 instanceof ECPublicKey) {
                return generatePublicKeyParameter(publicKey2);
            }
            throw new InvalidKeyException("cannot identify EC public key.");
        } catch (Exception e2) {
            throw new InvalidKeyException("cannot identify EC public key: " + e2.toString());
        }
    }

    public static String getCurveName(v vVar) {
        return g.a.a.z3.a.getName(vVar);
    }

    public static f getDomainParameters(g.a.e.b.b.b bVar, g.a.a.z3.c cVar) {
        f fVar;
        if (cVar.isNamedCurve()) {
            v vVar = v.getInstance(cVar.getParameters());
            g.a.a.z3.e namedCurveByOid = getNamedCurveByOid(vVar);
            if (namedCurveByOid == null) {
                namedCurveByOid = (g.a.a.z3.e) bVar.getAdditionalECParameters().get(vVar);
            }
            return new h(vVar, namedCurveByOid);
        }
        if (cVar.isImplicitlyCA()) {
            c ecImplicitlyCa = bVar.getEcImplicitlyCa();
            fVar = new f(ecImplicitlyCa.getCurve(), ecImplicitlyCa.getG(), ecImplicitlyCa.getN(), ecImplicitlyCa.getH(), ecImplicitlyCa.getSeed());
        } else {
            g.a.a.z3.e eVar = g.a.a.z3.e.getInstance(cVar.getParameters());
            fVar = new f(eVar.getCurve(), eVar.getG(), eVar.getN(), eVar.getH(), eVar.getSeed());
        }
        return fVar;
    }

    public static f getDomainParameters(g.a.e.b.b.b bVar, c cVar) {
        if (cVar instanceof g.a.f.d.a) {
            g.a.f.d.a aVar = (g.a.f.d.a) cVar;
            return new h(getNamedCurveOid(aVar.getName()), aVar.getCurve(), aVar.getG(), aVar.getN(), aVar.getH(), aVar.getSeed());
        }
        if (cVar != null) {
            return new f(cVar.getCurve(), cVar.getG(), cVar.getN(), cVar.getH(), cVar.getSeed());
        }
        c ecImplicitlyCa = bVar.getEcImplicitlyCa();
        return new f(ecImplicitlyCa.getCurve(), ecImplicitlyCa.getG(), ecImplicitlyCa.getN(), ecImplicitlyCa.getH(), ecImplicitlyCa.getSeed());
    }

    public static String getNameFrom(AlgorithmParameterSpec algorithmParameterSpec) {
        return (String) AccessController.doPrivileged(new a(algorithmParameterSpec));
    }

    public static g.a.a.z3.e getNamedCurveByName(String str) {
        g.a.a.z3.e byName = g.a.d.k.a.getByName(str);
        return byName == null ? g.a.a.z3.a.getByName(str) : byName;
    }

    public static g.a.a.z3.e getNamedCurveByOid(v vVar) {
        g.a.a.z3.e byOID = g.a.d.k.a.getByOID(vVar);
        return byOID == null ? g.a.a.z3.a.getByOID(vVar) : byOID;
    }

    public static v getNamedCurveOid(c cVar) {
        Enumeration names = g.a.a.z3.a.getNames();
        while (names.hasMoreElements()) {
            String str = (String) names.nextElement();
            g.a.a.z3.e byName = g.a.a.z3.a.getByName(str);
            if (byName.getN().equals(cVar.getN()) && byName.getH().equals(cVar.getH()) && byName.getCurve().equals(cVar.getCurve()) && byName.getG().equals(cVar.getG())) {
                return g.a.a.z3.a.getOID(str);
            }
        }
        return null;
    }

    public static v getNamedCurveOid(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        int iIndexOf = str.indexOf(32);
        if (iIndexOf > 0) {
            str = str.substring(iIndexOf + 1);
        }
        v vVarB = b(str);
        return vVarB != null ? vVarB : g.a.a.z3.a.getOID(str);
    }

    public static int getOrderBitLength(g.a.e.b.b.b bVar, BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger != null) {
            return bigInteger.bitLength();
        }
        c ecImplicitlyCa = bVar.getEcImplicitlyCa();
        return ecImplicitlyCa == null ? bigInteger2.bitLength() : ecImplicitlyCa.getN().bitLength();
    }

    public static String privateKeyToString(String str, BigInteger bigInteger, c cVar) {
        StringBuffer stringBuffer = new StringBuffer();
        String strLineSeparator = q.lineSeparator();
        i iVarNormalize = new k().multiply(cVar.getG(), bigInteger).normalize();
        stringBuffer.append(str);
        stringBuffer.append(" Private Key [");
        stringBuffer.append(generateKeyFingerprint(iVarNormalize, cVar));
        stringBuffer.append("]");
        stringBuffer.append(strLineSeparator);
        stringBuffer.append("            X: ");
        stringBuffer.append(iVarNormalize.getAffineXCoord().toBigInteger().toString(16));
        stringBuffer.append(strLineSeparator);
        stringBuffer.append("            Y: ");
        stringBuffer.append(iVarNormalize.getAffineYCoord().toBigInteger().toString(16));
        stringBuffer.append(strLineSeparator);
        return stringBuffer.toString();
    }

    public static String publicKeyToString(String str, i iVar, c cVar) {
        StringBuffer stringBuffer = new StringBuffer();
        String strLineSeparator = q.lineSeparator();
        stringBuffer.append(str);
        stringBuffer.append(" Public Key [");
        stringBuffer.append(generateKeyFingerprint(iVar, cVar));
        stringBuffer.append("]");
        stringBuffer.append(strLineSeparator);
        stringBuffer.append("            X: ");
        stringBuffer.append(iVar.getAffineXCoord().toBigInteger().toString(16));
        stringBuffer.append(strLineSeparator);
        stringBuffer.append("            Y: ");
        stringBuffer.append(iVar.getAffineYCoord().toBigInteger().toString(16));
        stringBuffer.append(strLineSeparator);
        return stringBuffer.toString();
    }
}

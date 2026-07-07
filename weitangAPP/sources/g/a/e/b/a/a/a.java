package g.a.e.b.a.a;

import g.a.a.d0;
import g.a.a.v;
import g.a.a.z3.e;
import g.a.g.a.c;
import g.a.g.a.e;
import g.a.g.a.i;
import g.a.g.b.f;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f13834a = new HashMap();

    static {
        Enumeration names = g.a.d.k.a.getNames();
        while (names.hasMoreElements()) {
            String str = (String) names.nextElement();
            e byName = g.a.a.z3.a.getByName(str);
            if (byName != null) {
                f13834a.put(byName.getCurve(), g.a.d.k.a.getByName(str).getCurve());
            }
        }
        g.a.g.a.e curve = g.a.d.k.a.getByName("Curve25519").getCurve();
        f13834a.put(new e.f(curve.getField().getCharacteristic(), curve.getA().toBigInteger(), curve.getB().toBigInteger(), curve.getOrder(), curve.getCofactor()), curve);
    }

    public static g.a.g.a.e convertCurve(EllipticCurve ellipticCurve) {
        ECField field = ellipticCurve.getField();
        BigInteger a2 = ellipticCurve.getA();
        BigInteger b2 = ellipticCurve.getB();
        if (field instanceof ECFieldFp) {
            e.f fVar = new e.f(((ECFieldFp) field).getP(), a2, b2);
            return f13834a.containsKey(fVar) ? (g.a.g.a.e) f13834a.get(fVar) : fVar;
        }
        ECFieldF2m eCFieldF2m = (ECFieldF2m) field;
        int m = eCFieldF2m.getM();
        int[] iArrA = b.a(eCFieldF2m.getMidTermsOfReductionPolynomial());
        return new e.C0261e(m, iArrA[0], iArrA[1], iArrA[2], a2, b2);
    }

    public static EllipticCurve convertCurve(g.a.g.a.e eVar, byte[] bArr) {
        return new EllipticCurve(convertField(eVar.getField()), eVar.getA().toBigInteger(), eVar.getB().toBigInteger(), null);
    }

    public static ECField convertField(g.a.g.b.a aVar) {
        if (c.isFpField(aVar)) {
            return new ECFieldFp(aVar.getCharacteristic());
        }
        g.a.g.b.e minimalPolynomial = ((f) aVar).getMinimalPolynomial();
        int[] exponentsPresent = minimalPolynomial.getExponentsPresent();
        return new ECFieldF2m(minimalPolynomial.getDegree(), g.a.j.a.reverseInPlace(g.a.j.a.copyOfRange(exponentsPresent, 1, exponentsPresent.length - 1)));
    }

    public static i convertPoint(g.a.g.a.e eVar, ECPoint eCPoint) {
        return eVar.createPoint(eCPoint.getAffineX(), eCPoint.getAffineY());
    }

    public static i convertPoint(ECParameterSpec eCParameterSpec, ECPoint eCPoint) {
        return convertPoint(convertCurve(eCParameterSpec.getCurve()), eCPoint);
    }

    public static ECPoint convertPoint(i iVar) {
        i iVarNormalize = iVar.normalize();
        return new ECPoint(iVarNormalize.getAffineXCoord().toBigInteger(), iVarNormalize.getAffineYCoord().toBigInteger());
    }

    public static g.a.f.d.c convertSpec(ECParameterSpec eCParameterSpec) {
        g.a.g.a.e eVarConvertCurve = convertCurve(eCParameterSpec.getCurve());
        i iVarConvertPoint = convertPoint(eVarConvertCurve, eCParameterSpec.getGenerator());
        BigInteger order = eCParameterSpec.getOrder();
        BigInteger bigIntegerValueOf = BigInteger.valueOf(eCParameterSpec.getCofactor());
        byte[] seed = eCParameterSpec.getCurve().getSeed();
        return eCParameterSpec instanceof g.a.f.d.b ? new g.a.f.d.a(((g.a.f.d.b) eCParameterSpec).getName(), eVarConvertCurve, iVarConvertPoint, order, bigIntegerValueOf, seed) : new g.a.f.d.c(eVarConvertCurve, iVarConvertPoint, order, bigIntegerValueOf, seed);
    }

    public static ECParameterSpec convertSpec(EllipticCurve ellipticCurve, g.a.f.d.c cVar) {
        ECPoint eCPointConvertPoint = convertPoint(cVar.getG());
        return cVar instanceof g.a.f.d.a ? new g.a.f.d.b(((g.a.f.d.a) cVar).getName(), ellipticCurve, eCPointConvertPoint, cVar.getN(), cVar.getH()) : new ECParameterSpec(ellipticCurve, eCPointConvertPoint, cVar.getN(), cVar.getH().intValue());
    }

    public static ECParameterSpec convertToSpec(g.a.a.z3.c cVar, g.a.g.a.e eVar) {
        ECParameterSpec bVar;
        if (cVar.isNamedCurve()) {
            v vVar = (v) cVar.getParameters();
            g.a.a.z3.e namedCurveByOid = b.getNamedCurveByOid(vVar);
            if (namedCurveByOid == null) {
                Map additionalECParameters = g.a.f.c.a.CONFIGURATION.getAdditionalECParameters();
                if (!additionalECParameters.isEmpty()) {
                    namedCurveByOid = (g.a.a.z3.e) additionalECParameters.get(vVar);
                }
            }
            return new g.a.f.d.b(b.getCurveName(vVar), convertCurve(eVar, namedCurveByOid.getSeed()), convertPoint(namedCurveByOid.getG()), namedCurveByOid.getN(), namedCurveByOid.getH());
        }
        if (cVar.isImplicitlyCA()) {
            return null;
        }
        d0 d0Var = d0.getInstance(cVar.getParameters());
        if (d0Var.size() > 3) {
            g.a.a.z3.e eVar2 = g.a.a.z3.e.getInstance(d0Var);
            EllipticCurve ellipticCurveConvertCurve = convertCurve(eVar, eVar2.getSeed());
            bVar = eVar2.getH() != null ? new ECParameterSpec(ellipticCurveConvertCurve, convertPoint(eVar2.getG()), eVar2.getN(), eVar2.getH().intValue()) : new ECParameterSpec(ellipticCurveConvertCurve, convertPoint(eVar2.getG()), eVar2.getN(), 1);
        } else {
            g.a.a.k3.c cVar2 = g.a.a.k3.c.getInstance(d0Var);
            g.a.f.d.a parameterSpec = g.a.f.a.getParameterSpec(g.a.a.k3.b.getName(cVar2.getPublicKeyParamSet()));
            bVar = new g.a.f.d.b(g.a.a.k3.b.getName(cVar2.getPublicKeyParamSet()), convertCurve(parameterSpec.getCurve(), parameterSpec.getSeed()), convertPoint(parameterSpec.getG()), parameterSpec.getN(), parameterSpec.getH());
        }
        return bVar;
    }

    public static ECParameterSpec convertToSpec(g.a.a.z3.e eVar) {
        return new ECParameterSpec(convertCurve(eVar.getCurve(), null), convertPoint(eVar.getG()), eVar.getN(), eVar.getH().intValue());
    }

    public static ECParameterSpec convertToSpec(g.a.d.n.f fVar) {
        return new ECParameterSpec(convertCurve(fVar.getCurve(), null), convertPoint(fVar.getG()), fVar.getN(), fVar.getH().intValue());
    }

    public static g.a.g.a.e getCurve(g.a.e.b.b.b bVar, g.a.a.z3.c cVar) {
        Set acceptableNamedCurves = bVar.getAcceptableNamedCurves();
        if (!cVar.isNamedCurve()) {
            if (cVar.isImplicitlyCA()) {
                return bVar.getEcImplicitlyCa().getCurve();
            }
            d0 d0Var = d0.getInstance(cVar.getParameters());
            if (acceptableNamedCurves.isEmpty()) {
                return (d0Var.size() > 3 ? g.a.a.z3.e.getInstance(d0Var) : g.a.a.k3.b.getByOIDX9(v.getInstance(d0Var.getObjectAt(0)))).getCurve();
            }
            throw new IllegalStateException("encoded parameters not acceptable");
        }
        v vVar = v.getInstance(cVar.getParameters());
        if (!acceptableNamedCurves.isEmpty() && !acceptableNamedCurves.contains(vVar)) {
            throw new IllegalStateException("named curve not acceptable");
        }
        g.a.a.z3.e namedCurveByOid = b.getNamedCurveByOid(vVar);
        if (namedCurveByOid == null) {
            namedCurveByOid = (g.a.a.z3.e) bVar.getAdditionalECParameters().get(vVar);
        }
        return namedCurveByOid.getCurve();
    }

    public static g.a.d.n.f getDomainParameters(g.a.e.b.b.b bVar, ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec != null) {
            return b.getDomainParameters(bVar, convertSpec(eCParameterSpec));
        }
        g.a.f.d.c ecImplicitlyCa = bVar.getEcImplicitlyCa();
        return new g.a.d.n.f(ecImplicitlyCa.getCurve(), ecImplicitlyCa.getG(), ecImplicitlyCa.getN(), ecImplicitlyCa.getH(), ecImplicitlyCa.getSeed());
    }
}

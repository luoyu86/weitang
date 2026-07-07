package g.a.f.d;

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

/* JADX INFO: loaded from: classes2.dex */
public class b extends ECParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13881a;

    public b(String str, e eVar, i iVar, BigInteger bigInteger) {
        super(a(eVar, null), g.a.e.b.a.a.a.convertPoint(iVar), bigInteger, 1);
        this.f13881a = str;
    }

    public b(String str, e eVar, i iVar, BigInteger bigInteger, BigInteger bigInteger2) {
        super(a(eVar, null), g.a.e.b.a.a.a.convertPoint(iVar), bigInteger, bigInteger2.intValue());
        this.f13881a = str;
    }

    public b(String str, e eVar, i iVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(a(eVar, bArr), g.a.e.b.a.a.a.convertPoint(iVar), bigInteger, bigInteger2.intValue());
        this.f13881a = str;
    }

    public b(String str, EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger) {
        super(ellipticCurve, eCPoint, bigInteger, 1);
        this.f13881a = str;
    }

    public b(String str, EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(ellipticCurve, eCPoint, bigInteger, bigInteger2.intValue());
        this.f13881a = str;
    }

    public static EllipticCurve a(e eVar, byte[] bArr) {
        return new EllipticCurve(b(eVar.getField()), eVar.getA().toBigInteger(), eVar.getB().toBigInteger(), bArr);
    }

    public static ECField b(g.a.g.b.a aVar) {
        if (g.a.g.a.c.isFpField(aVar)) {
            return new ECFieldFp(aVar.getCharacteristic());
        }
        g.a.g.b.e minimalPolynomial = ((f) aVar).getMinimalPolynomial();
        int[] exponentsPresent = minimalPolynomial.getExponentsPresent();
        return new ECFieldF2m(minimalPolynomial.getDegree(), g.a.j.a.reverseInPlace(g.a.j.a.copyOfRange(exponentsPresent, 1, exponentsPresent.length - 1)));
    }

    public String getName() {
        return this.f13881a;
    }
}

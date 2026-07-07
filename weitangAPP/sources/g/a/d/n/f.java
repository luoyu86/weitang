package g.a.d.n;

import androidx.core.view.InputDeviceCompat;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class f implements g.a.g.a.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g.a.g.a.e f13812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f13813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g.a.g.a.i f13814i;
    public final BigInteger j;
    public final BigInteger k;
    public BigInteger l;

    public f(g.a.a.z3.e eVar) {
        this(eVar.getCurve(), eVar.getG(), eVar.getN(), eVar.getH(), eVar.getSeed());
    }

    public f(g.a.g.a.e eVar, g.a.g.a.i iVar, BigInteger bigInteger) {
        this(eVar, iVar, bigInteger, g.a.g.a.d.f14091b, null);
    }

    public f(g.a.g.a.e eVar, g.a.g.a.i iVar, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eVar, iVar, bigInteger, bigInteger2, null);
    }

    public f(g.a.g.a.e eVar, g.a.g.a.i iVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.l = null;
        Objects.requireNonNull(eVar, "curve");
        Objects.requireNonNull(bigInteger, OperatorName.ENDPATH);
        this.f13812g = eVar;
        this.f13814i = a(eVar, iVar);
        this.j = bigInteger;
        this.k = bigInteger2;
        this.f13813h = g.a.j.a.clone(bArr);
    }

    public static g.a.g.a.i a(g.a.g.a.e eVar, g.a.g.a.i iVar) {
        Objects.requireNonNull(iVar, "Point cannot be null");
        g.a.g.a.i iVarNormalize = g.a.g.a.c.importPoint(eVar, iVar).normalize();
        if (iVarNormalize.isInfinity()) {
            throw new IllegalArgumentException("Point at infinity");
        }
        if (iVarNormalize.isValid()) {
            return iVarNormalize;
        }
        throw new IllegalArgumentException("Point not on curve");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f13812g.equals(fVar.f13812g) && this.f13814i.equals(fVar.f13814i) && this.j.equals(fVar.j);
    }

    public g.a.g.a.e getCurve() {
        return this.f13812g;
    }

    public g.a.g.a.i getG() {
        return this.f13814i;
    }

    public BigInteger getH() {
        return this.k;
    }

    public synchronized BigInteger getHInv() {
        if (this.l == null) {
            this.l = g.a.j.b.modOddInverseVar(this.j, this.k);
        }
        return this.l;
    }

    public BigInteger getN() {
        return this.j;
    }

    public byte[] getSeed() {
        return g.a.j.a.clone(this.f13813h);
    }

    public int hashCode() {
        return ((((this.f13812g.hashCode() ^ 1028) * InputDeviceCompat.SOURCE_KEYBOARD) ^ this.f13814i.hashCode()) * InputDeviceCompat.SOURCE_KEYBOARD) ^ this.j.hashCode();
    }

    public BigInteger validatePrivateScalar(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "Scalar cannot be null");
        if (bigInteger.compareTo(g.a.g.a.d.f14091b) < 0 || bigInteger.compareTo(getN()) >= 0) {
            throw new IllegalArgumentException("Scalar is not in the interval [1, n - 1]");
        }
        return bigInteger;
    }

    public g.a.g.a.i validatePublicPoint(g.a.g.a.i iVar) {
        return a(getCurve(), iVar);
    }
}

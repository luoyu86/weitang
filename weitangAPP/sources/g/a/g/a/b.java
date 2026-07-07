package g.a.g.a;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements h {
    public i a(i iVar) {
        return c.a(iVar);
    }

    public abstract i b(i iVar, BigInteger bigInteger);

    @Override // g.a.g.a.h
    public i multiply(i iVar, BigInteger bigInteger) {
        int iSignum = bigInteger.signum();
        if (iSignum == 0 || iVar.isInfinity()) {
            return iVar.getCurve().getInfinity();
        }
        i iVarB = b(iVar, bigInteger.abs());
        if (iSignum <= 0) {
            iVarB = iVarB.negate();
        }
        return a(iVarB);
    }
}

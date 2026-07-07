package g.a.d.n;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class i extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BigInteger f13816c;

    public i(BigInteger bigInteger, f fVar) {
        super(true, fVar);
        this.f13816c = fVar.validatePrivateScalar(bigInteger);
    }

    public BigInteger getD() {
        return this.f13816c;
    }
}

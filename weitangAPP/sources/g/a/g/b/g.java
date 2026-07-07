package g.a.g.b;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f14187a;

    public g(BigInteger bigInteger) {
        this.f14187a = bigInteger;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            return this.f14187a.equals(((g) obj).f14187a);
        }
        return false;
    }

    @Override // g.a.g.b.a
    public BigInteger getCharacteristic() {
        return this.f14187a;
    }

    @Override // g.a.g.b.a
    public int getDimension() {
        return 1;
    }

    public int hashCode() {
        return this.f14187a.hashCode();
    }
}

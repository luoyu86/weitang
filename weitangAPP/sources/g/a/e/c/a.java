package g.a.e.c;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public class a extends DHParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f13839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BigInteger f13840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g.a.d.n.c f13842d;

    public a(g.a.d.n.b bVar) {
        this(bVar.getP(), bVar.getQ(), bVar.getG(), bVar.getJ(), bVar.getM(), bVar.getL());
        this.f13842d = bVar.getValidationParameters();
    }

    public a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, null, 0);
    }

    public a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i2) {
        this(bigInteger, bigInteger2, bigInteger3, null, i2);
    }

    public a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i2) {
        this(bigInteger, bigInteger2, bigInteger3, bigInteger4, 0, i2);
    }

    public a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i2, int i3) {
        super(bigInteger, bigInteger3, i3);
        this.f13839a = bigInteger2;
        this.f13840b = bigInteger4;
        this.f13841c = i2;
    }

    public g.a.d.n.b getDomainParameters() {
        return new g.a.d.n.b(getP(), getG(), this.f13839a, this.f13841c, getL(), this.f13840b, this.f13842d);
    }

    public BigInteger getJ() {
        return this.f13840b;
    }

    public int getM() {
        return this.f13841c;
    }

    public BigInteger getQ() {
        return this.f13839a;
    }
}

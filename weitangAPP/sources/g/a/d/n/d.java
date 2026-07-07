package g.a.d.n;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class d implements g.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f13805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f13806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f13807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f13808d;

    public d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f13805a = bigInteger3;
        this.f13807c = bigInteger;
        this.f13806b = bigInteger2;
    }

    public d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, e eVar) {
        this.f13805a = bigInteger3;
        this.f13807c = bigInteger;
        this.f13806b = bigInteger2;
        this.f13808d = eVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.getP().equals(this.f13807c) && dVar.getQ().equals(this.f13806b) && dVar.getG().equals(this.f13805a);
    }

    public BigInteger getG() {
        return this.f13805a;
    }

    public BigInteger getP() {
        return this.f13807c;
    }

    public BigInteger getQ() {
        return this.f13806b;
    }

    public e getValidationParameters() {
        return this.f13808d;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getQ().hashCode()) ^ getG().hashCode();
    }
}

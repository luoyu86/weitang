package g.a.c;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class x implements g.a.j.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f13703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.x3.c f13704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f13705c;

    public x(g.a.a.x3.c cVar, BigInteger bigInteger) {
        b(cVar, bigInteger);
    }

    public x(g.a.a.x3.c cVar, BigInteger bigInteger, byte[] bArr) {
        b(cVar, bigInteger);
        c(bArr);
    }

    public x(byte[] bArr) {
        c(bArr);
    }

    public final boolean a(Object obj, Object obj2) {
        return obj != null ? obj.equals(obj2) : obj2 == null;
    }

    public final void b(g.a.a.x3.c cVar, BigInteger bigInteger) {
        this.f13704b = cVar;
        this.f13705c = bigInteger;
    }

    public final void c(byte[] bArr) {
        this.f13703a = bArr;
    }

    @Override // g.a.j.m
    public Object clone() {
        return new x(this.f13704b, this.f13705c, this.f13703a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return g.a.j.a.areEqual(this.f13703a, xVar.f13703a) && a(this.f13705c, xVar.f13705c) && a(this.f13704b, xVar.f13704b);
    }

    public g.a.a.x3.c getIssuer() {
        return this.f13704b;
    }

    public int hashCode() {
        int iHashCode = g.a.j.a.hashCode(this.f13703a);
        BigInteger bigInteger = this.f13705c;
        if (bigInteger != null) {
            iHashCode ^= bigInteger.hashCode();
        }
        g.a.a.x3.c cVar = this.f13704b;
        return cVar != null ? iHashCode ^ cVar.hashCode() : iHashCode;
    }

    @Override // g.a.j.m
    public boolean match(Object obj) {
        return false;
    }
}

package g.a.c;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class v extends d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.b.g.b f13701b;

    public v(g.a.a.x3.c cVar, BigInteger bigInteger) {
        this(cVar, bigInteger, null);
    }

    public v(g.a.a.x3.c cVar, BigInteger bigInteger, byte[] bArr) {
        this(new g.a.b.g.b(cVar, bigInteger, bArr));
    }

    public v(g.a.b.g.b bVar) {
        super(0);
        this.f13701b = bVar;
    }

    public v(byte[] bArr) {
        this(null, null, bArr);
    }

    @Override // g.a.c.d0, g.a.j.m
    public Object clone() {
        return new v(this.f13701b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof v) {
            return this.f13701b.equals(((v) obj).f13701b);
        }
        return false;
    }

    public g.a.a.x3.c getIssuer() {
        return this.f13701b.getIssuer();
    }

    public BigInteger getSerialNumber() {
        return this.f13701b.getSerialNumber();
    }

    public byte[] getSubjectKeyIdentifier() {
        return this.f13701b.getSubjectKeyIdentifier();
    }

    public int hashCode() {
        return this.f13701b.hashCode();
    }

    @Override // g.a.c.d0, g.a.j.m
    public boolean match(Object obj) {
        return obj instanceof w ? ((w) obj).getRID().equals(this) : this.f13701b.match(obj);
    }
}

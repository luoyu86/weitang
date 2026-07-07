package g.a.c;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class s extends d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.b.g.b f13698b;

    public s(g.a.a.x3.c cVar, BigInteger bigInteger) {
        this(cVar, bigInteger, null);
    }

    public s(g.a.a.x3.c cVar, BigInteger bigInteger, byte[] bArr) {
        this(new g.a.b.g.b(cVar, bigInteger, bArr));
    }

    public s(g.a.b.g.b bVar) {
        super(2);
        this.f13698b = bVar;
    }

    public s(byte[] bArr) {
        this(null, null, bArr);
    }

    @Override // g.a.c.d0, g.a.j.m
    public Object clone() {
        return new s(this.f13698b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof s) {
            return this.f13698b.equals(((s) obj).f13698b);
        }
        return false;
    }

    public g.a.a.x3.c getIssuer() {
        return this.f13698b.getIssuer();
    }

    public BigInteger getSerialNumber() {
        return this.f13698b.getSerialNumber();
    }

    public byte[] getSubjectKeyIdentifier() {
        return this.f13698b.getSubjectKeyIdentifier();
    }

    public int hashCode() {
        return this.f13698b.hashCode();
    }

    @Override // g.a.c.d0, g.a.j.m
    public boolean match(Object obj) {
        return obj instanceof t ? ((t) obj).getRID().equals(this) : this.f13698b.match(obj);
    }
}

package g.a.b.g;

import g.a.a.i3.i;
import g.a.a.w;
import g.a.a.x3.c;
import g.a.a.y3.e;
import g.a.b.f;
import g.a.j.m;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f13613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f13614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f13615c;

    public b(c cVar, BigInteger bigInteger) {
        this(cVar, bigInteger, null);
    }

    public b(c cVar, BigInteger bigInteger, byte[] bArr) {
        this.f13614b = cVar;
        this.f13615c = bigInteger;
        this.f13613a = bArr;
    }

    public b(byte[] bArr) {
        this(null, null, bArr);
    }

    public final boolean a(Object obj, Object obj2) {
        return obj != null ? obj.equals(obj2) : obj2 == null;
    }

    @Override // g.a.j.m
    public Object clone() {
        return new b(this.f13614b, this.f13615c, this.f13613a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return g.a.j.a.areEqual(this.f13613a, bVar.f13613a) && a(this.f13615c, bVar.f13615c) && a(this.f13614b, bVar.f13614b);
    }

    public c getIssuer() {
        return this.f13614b;
    }

    public BigInteger getSerialNumber() {
        return this.f13615c;
    }

    public byte[] getSubjectKeyIdentifier() {
        return g.a.j.a.clone(this.f13613a);
    }

    public int hashCode() {
        int iHashCode = g.a.j.a.hashCode(this.f13613a);
        BigInteger bigInteger = this.f13615c;
        if (bigInteger != null) {
            iHashCode ^= bigInteger.hashCode();
        }
        c cVar = this.f13614b;
        return cVar != null ? iHashCode ^ cVar.hashCode() : iHashCode;
    }

    @Override // g.a.j.m
    public boolean match(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (getSerialNumber() != null) {
                i iVar = new i(fVar.toASN1Structure());
                return iVar.getName().equals(this.f13614b) && iVar.getSerialNumber().hasValue(this.f13615c);
            }
            if (this.f13613a != null) {
                e extension = fVar.getExtension(e.f13463b);
                if (extension == null) {
                    return g.a.j.a.areEqual(this.f13613a, a.a(fVar.getSubjectPublicKeyInfo()));
                }
                return g.a.j.a.areEqual(this.f13613a, w.getInstance(extension.getParsedValue()).getOctets());
            }
        } else if (obj instanceof byte[]) {
            return g.a.j.a.areEqual(this.f13613a, (byte[]) obj);
        }
        return false;
    }
}

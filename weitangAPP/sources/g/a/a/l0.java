package g.a.a;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l0 extends a0 implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f13231d;

    public l0(int i2, int i3, int i4, g gVar) {
        Objects.requireNonNull(gVar, "'obj' cannot be null");
        if (i3 == 0 || (i3 & 192) != i3) {
            throw new IllegalArgumentException("invalid tag class: " + i3);
        }
        this.f13228a = gVar instanceof f ? 1 : i2;
        this.f13229b = i3;
        this.f13230c = i4;
        this.f13231d = gVar;
    }

    public l0(boolean z, int i2, int i3, g gVar) {
        this(z ? 1 : 2, i2, i3, gVar);
    }

    public l0(boolean z, int i2, g gVar) {
        this(z, 128, i2, gVar);
    }

    public static l0 g(a0 a0Var) {
        if (a0Var instanceof l0) {
            return (l0) a0Var;
        }
        throw new IllegalStateException("unexpected object: " + a0Var.getClass().getName());
    }

    public static l0 getInstance(l0 l0Var, boolean z) {
        if (128 != l0Var.getTagClass()) {
            throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
        }
        if (z) {
            return l0Var.getExplicitBaseTagged();
        }
        throw new IllegalArgumentException("this method not valid for implicitly tagged tagged objects");
    }

    public static l0 getInstance(Object obj) {
        if (obj == null || (obj instanceof l0)) {
            return (l0) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof l0) {
                return (l0) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return g(a0.fromByteArray((byte[]) obj));
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct tagged object from byte[]: " + e2.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static a0 h(int i2, int i3, h hVar) {
        u2 u2Var = hVar.size() == 1 ? new u2(3, i2, i3, hVar.get(0)) : new u2(4, i2, i3, o2.a(hVar));
        return i2 != 64 ? u2Var : new k2(u2Var);
    }

    public static a0 i(int i2, int i3, h hVar) {
        h1 h1Var = hVar.size() == 1 ? new h1(3, i2, i3, hVar.get(0)) : new h1(4, i2, i3, a1.a(hVar));
        return i2 != 64 ? h1Var : new w0(h1Var);
    }

    public static a0 j(int i2, int i3, byte[] bArr) {
        u2 u2Var = new u2(4, i2, i3, new x1(bArr));
        return i2 != 64 ? u2Var : new k2(u2Var);
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        if (a0Var instanceof a) {
            return a0Var.equals((a0) this);
        }
        if (!(a0Var instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) a0Var;
        if (this.f13230c != l0Var.f13230c || this.f13229b != l0Var.f13229b) {
            return false;
        }
        if (this.f13228a != l0Var.f13228a && isExplicit() != l0Var.isExplicit()) {
            return false;
        }
        a0 aSN1Primitive = this.f13231d.toASN1Primitive();
        a0 aSN1Primitive2 = l0Var.f13231d.toASN1Primitive();
        if (aSN1Primitive == aSN1Primitive2) {
            return true;
        }
        if (isExplicit()) {
            return aSN1Primitive.a(aSN1Primitive2);
        }
        try {
            return g.a.j.a.areEqual(getEncoded(), l0Var.getEncoded());
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // g.a.a.a0
    public a0 e() {
        return new e2(this.f13228a, this.f13229b, this.f13230c, this.f13231d);
    }

    @Override // g.a.a.a0
    public a0 f() {
        return new u2(this.f13228a, this.f13229b, this.f13230c, this.f13231d);
    }

    public t getBaseObject() {
        g gVar = this.f13231d;
        return gVar instanceof t ? (t) gVar : gVar.toASN1Primitive();
    }

    public a0 getBaseUniversal(boolean z, int i2) {
        r0 r0VarA = s0.a(i2);
        if (r0VarA != null) {
            return l(z, r0VarA);
        }
        throw new IllegalArgumentException("unsupported UNIVERSAL tag number: " + i2);
    }

    public byte[] getContents() {
        try {
            byte[] encoded = this.f13231d.toASN1Primitive().getEncoded(k());
            if (isExplicit()) {
                return encoded;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(encoded);
            p.j(byteArrayInputStream, byteArrayInputStream.read());
            int i2 = p.i(byteArrayInputStream, byteArrayInputStream.available(), false);
            int iAvailable = byteArrayInputStream.available();
            int i3 = i2 < 0 ? iAvailable - 2 : iAvailable;
            if (i3 < 0) {
                throw new z("failed to get contents");
            }
            byte[] bArr = new byte[i3];
            System.arraycopy(encoded, encoded.length - iAvailable, bArr, 0, i3);
            return bArr;
        } catch (IOException e2) {
            throw new z("failed to get contents", e2);
        }
    }

    public t getExplicitBaseObject() {
        if (!isExplicit()) {
            throw new IllegalStateException("object implicit - explicit expected.");
        }
        g gVar = this.f13231d;
        return gVar instanceof t ? (t) gVar : gVar.toASN1Primitive();
    }

    public l0 getExplicitBaseTagged() {
        if (isExplicit()) {
            return g(this.f13231d.toASN1Primitive());
        }
        throw new IllegalStateException("object implicit - explicit expected.");
    }

    public l0 getImplicitBaseTagged(int i2, int i3) {
        if (i2 == 0 || (i2 & 192) != i2) {
            throw new IllegalArgumentException("invalid base tag class: " + i2);
        }
        int i4 = this.f13228a;
        if (i4 != 1) {
            return i4 != 2 ? o(i2, i3) : t0.a(g(this.f13231d.toASN1Primitive()), i2, i3);
        }
        throw new IllegalStateException("object explicit - implicit expected.");
    }

    @Override // g.a.a.m0, g.a.a.y2
    public final a0 getLoadedObject() {
        return this;
    }

    public a0 getObject() {
        if (128 == getTagClass()) {
            return this.f13231d.toASN1Primitive();
        }
        throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
    }

    @Override // g.a.a.m0
    public g getObjectParser(int i2, boolean z) throws IOException {
        if (128 == getTagClass()) {
            return parseBaseUniversal(z, i2);
        }
        throw new j("this method only valid for CONTEXT_SPECIFIC tags");
    }

    @Override // g.a.a.m0
    public int getTagClass() {
        return this.f13229b;
    }

    @Override // g.a.a.m0
    public int getTagNo() {
        return this.f13230c;
    }

    @Override // g.a.a.m0
    public boolean hasContextTag(int i2) {
        return this.f13229b == 128 && this.f13230c == i2;
    }

    @Override // g.a.a.m0
    public boolean hasTag(int i2, int i3) {
        return this.f13229b == i2 && this.f13230c == i3;
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        return (((this.f13229b * 7919) ^ this.f13230c) ^ (isExplicit() ? 15 : 240)) ^ this.f13231d.toASN1Primitive().hashCode();
    }

    public boolean isConstructed() {
        return c();
    }

    public boolean isExplicit() {
        int i2 = this.f13228a;
        return i2 == 1 || i2 == 3;
    }

    public abstract String k();

    public a0 l(boolean z, r0 r0Var) {
        if (z) {
            if (isExplicit()) {
                return r0Var.a(this.f13231d.toASN1Primitive());
            }
            throw new IllegalStateException("object explicit - implicit expected.");
        }
        if (1 == this.f13228a) {
            throw new IllegalStateException("object explicit - implicit expected.");
        }
        a0 aSN1Primitive = this.f13231d.toASN1Primitive();
        int i2 = this.f13228a;
        return i2 != 3 ? i2 != 4 ? r0Var.a(aSN1Primitive) : aSN1Primitive instanceof d0 ? r0Var.c((d0) aSN1Primitive) : r0Var.d((x1) aSN1Primitive) : r0Var.c(n(aSN1Primitive));
    }

    public boolean m() {
        int i2 = this.f13228a;
        return i2 == 3 || i2 == 4;
    }

    public abstract d0 n(a0 a0Var);

    public abstract l0 o(int i2, int i3);

    @Override // g.a.a.m0
    public g parseBaseUniversal(boolean z, int i2) throws IOException {
        a0 baseUniversal = getBaseUniversal(z, i2);
        return i2 != 3 ? i2 != 4 ? i2 != 16 ? i2 != 17 ? baseUniversal : ((f0) baseUniversal).parser() : ((d0) baseUniversal).parser() : ((w) baseUniversal).parser() : ((c) baseUniversal).parser();
    }

    @Override // g.a.a.m0
    public g parseExplicitBaseObject() throws IOException {
        return getExplicitBaseObject();
    }

    @Override // g.a.a.m0
    public m0 parseExplicitBaseTagged() throws IOException {
        return getExplicitBaseTagged();
    }

    @Override // g.a.a.m0
    public m0 parseImplicitBaseTagged(int i2, int i3) throws IOException {
        return getImplicitBaseTagged(i2, i3);
    }

    public String toString() {
        return t0.getTagText(this.f13229b, this.f13230c) + this.f13231d;
    }
}

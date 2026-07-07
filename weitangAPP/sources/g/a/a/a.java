package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends a0 implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f13031a;

    public a(l0 l0Var) {
        g(l0Var.getTagClass());
        this.f13031a = l0Var;
    }

    public static int g(int i2) {
        if (64 == i2) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    public static a getInstance(Object obj) {
        if (obj == null || (obj instanceof a)) {
            return (a) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
        try {
            return getInstance(a0.fromByteArray((byte[]) obj));
        } catch (IOException e2) {
            throw new IllegalArgumentException("Failed to construct object from byte[]: " + e2.getMessage());
        }
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        l0 l0Var;
        if (a0Var instanceof a) {
            l0Var = ((a) a0Var).f13031a;
        } else {
            if (!(a0Var instanceof l0)) {
                return false;
            }
            l0Var = (l0) a0Var;
        }
        return this.f13031a.equals((a0) l0Var);
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        this.f13031a.b(yVar, z);
    }

    @Override // g.a.a.a0
    public boolean c() {
        return this.f13031a.c();
    }

    @Override // g.a.a.a0
    public int d(boolean z) throws IOException {
        return this.f13031a.d(z);
    }

    @Override // g.a.a.a0
    public a0 e() {
        return new l1((l0) this.f13031a.e());
    }

    @Override // g.a.a.a0
    public a0 f() {
        return new k2((l0) this.f13031a.f());
    }

    public int getApplicationTag() {
        return this.f13031a.getTagNo();
    }

    public byte[] getContents() {
        return this.f13031a.getContents();
    }

    public a0 getEnclosedObject() throws IOException {
        return this.f13031a.getBaseObject().toASN1Primitive();
    }

    @Override // g.a.a.m0, g.a.a.y2
    public final a0 getLoadedObject() {
        return this;
    }

    public a0 getObject() throws IOException {
        return getEnclosedObject();
    }

    public a0 getObject(int i2) throws IOException {
        return this.f13031a.getBaseUniversal(false, i2);
    }

    @Override // g.a.a.m0
    public g getObjectParser(int i2, boolean z) throws IOException {
        throw new j("this method only valid for CONTEXT_SPECIFIC tags");
    }

    @Override // g.a.a.m0
    public int getTagClass() {
        return 64;
    }

    @Override // g.a.a.m0
    public int getTagNo() {
        return this.f13031a.getTagNo();
    }

    public l0 getTaggedObject() {
        return this.f13031a;
    }

    public boolean hasApplicationTag(int i2) {
        return this.f13031a.hasTag(64, i2);
    }

    @Override // g.a.a.m0
    public boolean hasContextTag(int i2) {
        return false;
    }

    @Override // g.a.a.m0
    public boolean hasTag(int i2, int i3) {
        return this.f13031a.hasTag(i2, i3);
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        return this.f13031a.hashCode();
    }

    public boolean isConstructed() {
        return this.f13031a.isConstructed();
    }

    @Override // g.a.a.m0
    public g parseBaseUniversal(boolean z, int i2) throws IOException {
        return this.f13031a.parseBaseUniversal(z, i2);
    }

    @Override // g.a.a.m0
    public g parseExplicitBaseObject() throws IOException {
        return this.f13031a.parseExplicitBaseObject();
    }

    @Override // g.a.a.m0
    public m0 parseExplicitBaseTagged() throws IOException {
        return this.f13031a.parseExplicitBaseTagged();
    }

    @Override // g.a.a.m0
    public m0 parseImplicitBaseTagged(int i2, int i3) throws IOException {
        return this.f13031a.parseImplicitBaseTagged(i2, i3);
    }

    public g readObject() throws IOException {
        return parseExplicitBaseObject();
    }
}

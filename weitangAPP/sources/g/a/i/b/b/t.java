package g.a.i.b.b;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class t implements g.a.j.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f14352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f14353b;

    public t(s sVar, r rVar) {
        this.f14352a = sVar;
        this.f14353b = rVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        s sVar = this.f14352a;
        if (sVar == null ? tVar.f14352a != null : !sVar.equals(tVar.f14352a)) {
            return false;
        }
        r rVar = this.f14353b;
        r rVar2 = tVar.f14353b;
        return rVar != null ? rVar.equals(rVar2) : rVar2 == null;
    }

    @Override // g.a.j.d
    public byte[] getEncoded() throws IOException {
        return a.compose().bytes(this.f14352a.getEncoded()).bytes(this.f14353b.getEncoded()).build();
    }

    public r getPublicKey() {
        return this.f14353b;
    }

    public s getSignature() {
        return this.f14352a;
    }

    public int hashCode() {
        s sVar = this.f14352a;
        int iHashCode = (sVar != null ? sVar.hashCode() : 0) * 31;
        r rVar = this.f14353b;
        return iHashCode + (rVar != null ? rVar.hashCode() : 0);
    }
}

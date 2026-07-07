package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class d1 extends d0 {
    public d1() {
    }

    public d1(g gVar) {
        super(gVar);
    }

    public d1(h hVar) {
        super(hVar);
    }

    public d1(g[] gVarArr) {
        super(gVarArr);
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.p(z, 48, this.f13059b);
    }

    @Override // g.a.a.a0
    public int d(boolean z) throws IOException {
        int iD = z ? 4 : 3;
        int length = this.f13059b.length;
        for (int i2 = 0; i2 < length; i2++) {
            iD += this.f13059b[i2].toASN1Primitive().d(true);
        }
        return iD;
    }

    @Override // g.a.a.d0
    public c i() {
        return new y0(g());
    }

    @Override // g.a.a.d0
    public k j() {
        return ((d0) f()).j();
    }

    @Override // g.a.a.d0
    public w k() {
        return new b1(h());
    }

    @Override // g.a.a.d0
    public f0 l() {
        return new f1(false, m());
    }
}

package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class f1 extends f0 {
    public f1() {
    }

    public f1(g gVar) {
        super(gVar);
    }

    public f1(h hVar) {
        super(hVar, false);
    }

    public f1(boolean z, g[] gVarArr) {
        super(z, gVarArr);
    }

    public f1(g[] gVarArr) {
        super(gVarArr, false);
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.p(z, 49, this.f13074b);
    }

    @Override // g.a.a.a0
    public int d(boolean z) throws IOException {
        int iD = z ? 4 : 3;
        int length = this.f13074b.length;
        for (int i2 = 0; i2 < length; i2++) {
            iD += this.f13074b[i2].toASN1Primitive().d(true);
        }
        return iD;
    }
}

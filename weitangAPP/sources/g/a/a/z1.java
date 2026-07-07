package g.a.a;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class z1 extends p2 {
    public z1(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // g.a.a.y
    public z1 b() {
        return this;
    }

    @Override // g.a.a.p2, g.a.a.y
    public void j(g[] gVarArr) throws IOException {
        for (g gVar : gVarArr) {
            gVar.toASN1Primitive().e().b(this, true);
        }
    }

    @Override // g.a.a.p2, g.a.a.y
    public void s(a0 a0Var, boolean z) throws IOException {
        a0Var.e().b(this, z);
    }

    @Override // g.a.a.p2, g.a.a.y
    public void t(a0[] a0VarArr) throws IOException {
        for (a0 a0Var : a0VarArr) {
            a0Var.e().b(this, true);
        }
    }
}

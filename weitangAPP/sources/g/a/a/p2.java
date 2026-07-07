package g.a.a;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class p2 extends y {
    public p2(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // g.a.a.y
    public p2 c() {
        return this;
    }

    @Override // g.a.a.y
    public void j(g[] gVarArr) throws IOException {
        for (g gVar : gVarArr) {
            gVar.toASN1Primitive().f().b(this, true);
        }
    }

    @Override // g.a.a.y
    public void s(a0 a0Var, boolean z) throws IOException {
        a0Var.f().b(this, z);
    }

    @Override // g.a.a.y
    public void t(a0[] a0VarArr) throws IOException {
        for (a0 a0Var : a0VarArr) {
            a0Var.f().b(this, true);
        }
    }
}

package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class o1 extends k {
    public o1(b2 b2Var) {
        super(b2Var);
    }

    public o1(h hVar) {
        this(q1.a(hVar));
    }

    public o1(v vVar, q qVar, a0 a0Var, int i2, a0 a0Var2) {
        super(vVar, qVar, a0Var, i2, a0Var2);
    }

    public o1(v vVar, q qVar, a0 a0Var, e2 e2Var) {
        super(vVar, qVar, a0Var, e2Var);
    }

    @Override // g.a.a.k, g.a.a.a0
    public a0 e() {
        return this;
    }

    @Override // g.a.a.k, g.a.a.a0
    public a0 f() {
        return this;
    }

    @Override // g.a.a.k
    public d0 g() {
        h hVar = new h(4);
        v vVar = this.f13192b;
        if (vVar != null) {
            hVar.add(vVar);
        }
        q qVar = this.f13193c;
        if (qVar != null) {
            hVar.add(qVar);
        }
        a0 a0Var = this.f13194d;
        if (a0Var != null) {
            hVar.add(a0Var.e());
        }
        int i2 = this.f13195e;
        hVar.add(new e2(i2 == 0, i2, this.f13196f));
        return new b2(hVar);
    }
}

package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class n2 extends k {
    public n2(h hVar) {
        this(o2.a(hVar));
    }

    public n2(q2 q2Var) {
        super(q2Var);
    }

    public n2(v vVar, q qVar, a0 a0Var, int i2, a0 a0Var2) {
        super(vVar, qVar, a0Var, i2, a0Var2);
    }

    public n2(v vVar, q qVar, a0 a0Var, e2 e2Var) {
        super(vVar, qVar, a0Var, e2Var);
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
            hVar.add(a0Var.f());
        }
        int i2 = this.f13195e;
        hVar.add(new u2(i2 == 0, i2, this.f13196f));
        return new q2(hVar);
    }
}

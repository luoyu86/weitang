package g.a.d.n;

import g.a.a.v;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class h extends f {
    public v m;

    public h(v vVar, g.a.a.z3.e eVar) {
        super(eVar);
        this.m = vVar;
    }

    public h(v vVar, f fVar) {
        super(fVar.getCurve(), fVar.getG(), fVar.getN(), fVar.getH(), fVar.getSeed());
        this.m = vVar;
    }

    public h(v vVar, g.a.g.a.e eVar, g.a.g.a.i iVar, BigInteger bigInteger) {
        this(vVar, eVar, iVar, bigInteger, g.a.g.a.d.f14091b, null);
    }

    public h(v vVar, g.a.g.a.e eVar, g.a.g.a.i iVar, BigInteger bigInteger, BigInteger bigInteger2) {
        this(vVar, eVar, iVar, bigInteger, bigInteger2, null);
    }

    public h(v vVar, g.a.g.a.e eVar, g.a.g.a.i iVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(eVar, iVar, bigInteger, bigInteger2, bArr);
        this.m = vVar;
    }

    public v getName() {
        return this.m;
    }
}

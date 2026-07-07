package g.a.g.a;

import g.a.g.a.e;
import g.a.g.a.i;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class y extends b {

    public static class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i.b f14179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte f14180b;

        public a(i.b bVar, byte b2) {
            this.f14179a = bVar;
            this.f14180b = b2;
        }

        @Override // g.a.g.a.p
        public q precompute(q qVar) {
            if (qVar instanceof z) {
                return qVar;
            }
            z zVar = new z();
            zVar.setPreComp(t.getPreComp(this.f14179a, this.f14180b));
            return zVar;
        }
    }

    public static i.b c(i.b bVar, byte[] bArr) {
        e.b bVar2 = (e.b) bVar.getCurve();
        i.b[] preComp = ((z) bVar2.precompute(bVar, "bc_wtnaf", new a(bVar, bVar2.getA().toBigInteger().byteValue()))).getPreComp();
        i.b[] bVarArr = new i.b[preComp.length];
        for (int i2 = 0; i2 < preComp.length; i2++) {
            bVarArr[i2] = (i.b) preComp[i2].negate();
        }
        i.b bVar3 = (i.b) bVar.getCurve().getInfinity();
        int i3 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            i3++;
            byte b2 = bArr[length];
            if (b2 != 0) {
                bVar3 = (i.b) bVar3.tauPow(i3).add(b2 > 0 ? preComp[b2 >>> 1] : bVarArr[(-b2) >>> 1]);
                i3 = 0;
            }
        }
        return i3 > 0 ? bVar3.tauPow(i3) : bVar3;
    }

    @Override // g.a.g.a.b
    public i b(i iVar, BigInteger bigInteger) {
        if (!(iVar instanceof i.b)) {
            throw new IllegalArgumentException("Only ECPoint.AbstractF2m can be used in WTauNafMultiplier");
        }
        i.b bVar = (i.b) iVar;
        e.b bVar2 = (e.b) bVar.getCurve();
        int fieldSize = bVar2.getFieldSize();
        byte bByteValue = bVar2.getA().toBigInteger().byteValue();
        byte mu = t.getMu(bByteValue);
        return d(bVar, t.partModReduction(bigInteger, fieldSize, bByteValue, bVar2.i(), mu, (byte) 10), bByteValue, mu);
    }

    public final i.b d(i.b bVar, a0 a0Var, byte b2, byte b3) {
        a0[] a0VarArr = b2 == 0 ? t.f14154d : t.f14156f;
        return c(bVar, t.tauAdicWNaf(b3, a0Var, (byte) 4, BigInteger.valueOf(16L), t.getTw(b3, 4), a0VarArr));
    }
}

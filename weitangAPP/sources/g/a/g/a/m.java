package g.a.g.a;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    public static class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f14137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f14138b;

        public a(e eVar, i iVar) {
            this.f14137a = eVar;
            this.f14138b = iVar;
        }

        public final boolean a(l lVar, int i2) {
            return lVar != null && b(lVar.getLookupTable(), i2);
        }

        public final boolean b(g gVar, int i2) {
            return gVar != null && gVar.getSize() >= i2;
        }

        @Override // g.a.g.a.p
        public q precompute(q qVar) {
            l lVar = qVar instanceof l ? (l) qVar : null;
            int combSize = m.getCombSize(this.f14137a);
            int i2 = combSize > 250 ? 6 : 5;
            int i3 = 1 << i2;
            if (a(lVar, i3)) {
                return lVar;
            }
            int i4 = ((combSize + i2) - 1) / i2;
            i[] iVarArr = new i[i2 + 1];
            iVarArr[0] = this.f14138b;
            for (int i5 = 1; i5 < i2; i5++) {
                iVarArr[i5] = iVarArr[i5 - 1].timesPow2(i4);
            }
            iVarArr[i2] = iVarArr[0].subtract(iVarArr[1]);
            this.f14137a.normalizeAll(iVarArr);
            i[] iVarArr2 = new i[i3];
            iVarArr2[0] = iVarArr[0];
            for (int i6 = i2 - 1; i6 >= 0; i6--) {
                i iVar = iVarArr[i6];
                int i7 = 1 << i6;
                for (int i8 = i7; i8 < i3; i8 += i7 << 1) {
                    iVarArr2[i8] = iVarArr2[i8 - i7].add(iVar);
                }
            }
            this.f14137a.normalizeAll(iVarArr2);
            l lVar2 = new l();
            lVar2.setLookupTable(this.f14137a.createCacheSafeLookupTable(iVarArr2, 0, i3));
            lVar2.setOffset(iVarArr[i2]);
            lVar2.setWidth(i2);
            return lVar2;
        }
    }

    public static int getCombSize(e eVar) {
        BigInteger order = eVar.getOrder();
        return order == null ? eVar.getFieldSize() + 1 : order.bitLength();
    }

    public static l getFixedPointPreCompInfo(q qVar) {
        if (qVar instanceof l) {
            return (l) qVar;
        }
        return null;
    }

    public static l precompute(i iVar) {
        e curve = iVar.getCurve();
        return (l) curve.precompute(iVar, "bc_fixed_point", new a(curve, iVar));
    }
}

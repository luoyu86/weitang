package g.a.i.b.i;

import g.a.i.b.i.g;
import g.a.i.b.i.i;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class v {
    public static u a(k kVar, n nVar, i iVar) {
        double d2;
        Objects.requireNonNull(nVar, "publicKey == null");
        Objects.requireNonNull(iVar, "address == null");
        int iA = kVar.d().a();
        byte[][] bArrA = nVar.a();
        u[] uVarArr = new u[bArrA.length];
        for (int i2 = 0; i2 < bArrA.length; i2++) {
            uVarArr[i2] = new u(0, bArrA[i2]);
        }
        i.b bVarF = new i.b().g(iVar.a()).h(iVar.b()).n(iVar.d()).o(0).p(iVar.f()).f(iVar.getKeyAndMask());
        while (true) {
            i iVar2 = (i) bVarF.l();
            if (iA <= 1) {
                return uVarArr[0];
            }
            int i3 = 0;
            while (true) {
                d2 = iA / 2;
                if (i3 >= ((int) Math.floor(d2))) {
                    break;
                }
                iVar2 = (i) new i.b().g(iVar2.a()).h(iVar2.b()).n(iVar2.d()).o(iVar2.e()).p(i3).f(iVar2.getKeyAndMask()).l();
                int i4 = i3 * 2;
                uVarArr[i3] = b(kVar, uVarArr[i4], uVarArr[i4 + 1], iVar2);
                i3++;
            }
            if (iA % 2 == 1) {
                uVarArr[(int) Math.floor(d2)] = uVarArr[iA - 1];
            }
            iA = (int) Math.ceil(((double) iA) / 2.0d);
            bVarF = new i.b().g(iVar2.a()).h(iVar2.b()).n(iVar2.d()).o(iVar2.e() + 1).p(iVar2.f()).f(iVar2.getKeyAndMask());
        }
    }

    public static u b(k kVar, u uVar, u uVar2, o oVar) {
        Objects.requireNonNull(uVar, "left == null");
        Objects.requireNonNull(uVar2, "right == null");
        if (uVar.getHeight() != uVar2.getHeight()) {
            throw new IllegalStateException("height of both nodes must be equal");
        }
        Objects.requireNonNull(oVar, "address == null");
        byte[] bArrF = kVar.f();
        if (oVar instanceof i) {
            i iVar = (i) oVar;
            oVar = (i) new i.b().g(iVar.a()).h(iVar.b()).n(iVar.d()).o(iVar.e()).p(iVar.f()).f(0).l();
        } else if (oVar instanceof g) {
            g gVar = (g) oVar;
            oVar = (g) new g.b().g(gVar.a()).h(gVar.b()).m(gVar.d()).n(gVar.e()).f(0).k();
        }
        byte[] bArrC = kVar.c().c(bArrF, oVar.c());
        if (oVar instanceof i) {
            i iVar2 = (i) oVar;
            oVar = (i) new i.b().g(iVar2.a()).h(iVar2.b()).n(iVar2.d()).o(iVar2.e()).p(iVar2.f()).f(1).l();
        } else if (oVar instanceof g) {
            g gVar2 = (g) oVar;
            oVar = (g) new g.b().g(gVar2.a()).h(gVar2.b()).m(gVar2.d()).n(gVar2.e()).f(1).k();
        }
        byte[] bArrC2 = kVar.c().c(bArrF, oVar.c());
        if (oVar instanceof i) {
            i iVar3 = (i) oVar;
            oVar = (i) new i.b().g(iVar3.a()).h(iVar3.b()).n(iVar3.d()).o(iVar3.e()).p(iVar3.f()).f(2).l();
        } else if (oVar instanceof g) {
            g gVar3 = (g) oVar;
            oVar = (g) new g.b().g(gVar3.a()).h(gVar3.b()).m(gVar3.d()).n(gVar3.e()).f(2).k();
        }
        byte[] bArrC3 = kVar.c().c(bArrF, oVar.c());
        int iB = kVar.d().b();
        byte[] bArr = new byte[iB * 2];
        for (int i2 = 0; i2 < iB; i2++) {
            bArr[i2] = (byte) (uVar.getValue()[i2] ^ bArrC2[i2]);
        }
        for (int i3 = 0; i3 < iB; i3++) {
            bArr[i3 + iB] = (byte) (uVar2.getValue()[i3] ^ bArrC3[i3]);
        }
        return new u(uVar.getHeight(), kVar.c().b(bArrC, bArr));
    }
}

package g.a.i.b.b;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    public static class a extends q {
        public a(u uVar, h hVar, int i2, byte[] bArr, int i3, byte[] bArr2) {
            super(uVar, hVar, i2, bArr, i3, bArr2);
        }

        @Override // g.a.i.b.b.q
        public i e() {
            throw new RuntimeException("placeholder only");
        }

        @Override // g.a.i.b.b.q
        public r getPublicKey() {
            throw new RuntimeException("placeholder only");
        }
    }

    public static void a(e eVar) {
        synchronized (eVar) {
            if (eVar.getIndex() >= eVar.a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("hss private key");
                sb.append(eVar.f() ? " shard" : "");
                sb.append(" is exhausted");
                throw new g.a.i.b.a(sb.toString());
            }
            int l = eVar.getL();
            List<q> listB = eVar.b();
            int i2 = l;
            while (true) {
                int i3 = i2 - 1;
                if (listB.get(i3).getIndex() != (1 << listB.get(i3).getSigParameters().getH())) {
                    while (i2 < l) {
                        eVar.h(i2);
                        i2++;
                    }
                } else {
                    if (i3 == 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("hss private key");
                        sb2.append(eVar.f() ? " shard" : "");
                        sb2.append(" is exhausted the maximum limit for this HSS private key");
                        throw new g.a.i.b.a(sb2.toString());
                    }
                    i2 = i3;
                }
            }
        }
    }

    public static e generateHSSKeyPair(d dVar) {
        int i2;
        byte[] bArr;
        int depth = dVar.getDepth();
        q[] qVarArr = new q[depth];
        s[] sVarArr = new s[dVar.getDepth() - 1];
        byte[] bArr2 = new byte[32];
        dVar.getRandom().nextBytes(bArr2);
        byte[] bArr3 = new byte[16];
        dVar.getRandom().nextBytes(bArr3);
        byte[] bArr4 = new byte[0];
        long h2 = 1;
        int i3 = 0;
        while (i3 < depth) {
            if (i3 == 0) {
                qVarArr[i3] = new q(dVar.getLmsParameters()[i3].getLMSigParam(), dVar.getLmsParameters()[i3].getLMOTSParam(), 0, bArr3, 1 << dVar.getLmsParameters()[i3].getLMSigParam().getH(), bArr2);
                i2 = i3;
                bArr = bArr4;
            } else {
                i2 = i3;
                bArr = bArr4;
                qVarArr[i2] = new a(dVar.getLmsParameters()[i3].getLMSigParam(), dVar.getLmsParameters()[i3].getLMOTSParam(), -1, bArr, 1 << dVar.getLmsParameters()[i3].getLMSigParam().getH(), bArr);
            }
            h2 *= (long) (1 << dVar.getLmsParameters()[i2].getLMSigParam().getH());
            i3 = i2 + 1;
            bArr4 = bArr;
        }
        if (h2 == 0) {
            h2 = RecyclerView.FOREVER_NS;
        }
        return new e(dVar.getDepth(), Arrays.asList(qVarArr), Arrays.asList(sVarArr), 0L, h2);
    }

    public static g generateSignature(int i2, m mVar) {
        return new g(i2 - 1, mVar.f(), l.generateSign(mVar));
    }

    public static g generateSignature(e eVar, byte[] bArr) {
        q qVar;
        t[] tVarArr;
        int l = eVar.getL();
        synchronized (eVar) {
            a(eVar);
            List<q> listB = eVar.b();
            List<s> listD = eVar.d();
            int i2 = l - 1;
            qVar = eVar.b().get(i2);
            tVarArr = new t[i2];
            int i3 = 0;
            while (i3 < i2) {
                int i4 = i3 + 1;
                tVarArr[i3] = new t(listD.get(i3), listB.get(i4).getPublicKey());
                i3 = i4;
            }
            eVar.e();
        }
        m mVarG = qVar.generateLMSContext().g(tVarArr);
        mVarG.update(bArr, 0, bArr.length);
        return generateSignature(l, mVarG);
    }

    public static void incrementIndex(e eVar) {
        synchronized (eVar) {
            a(eVar);
            eVar.e();
            eVar.b().get(eVar.getL() - 1).f();
        }
    }

    public static boolean verifySignature(f fVar, g gVar, byte[] bArr) {
        int i2 = gVar.getlMinus1();
        int i3 = i2 + 1;
        if (i3 != fVar.getL()) {
            return false;
        }
        s[] sVarArr = new s[i3];
        r[] rVarArr = new r[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            sVarArr[i4] = gVar.getSignedPubKey()[i4].getSignature();
            rVarArr[i4] = gVar.getSignedPubKey()[i4].getPublicKey();
        }
        sVarArr[i2] = gVar.getSignature();
        r lMSPublicKey = fVar.getLMSPublicKey();
        for (int i5 = 0; i5 < i2; i5++) {
            if (!l.verifySignature(lMSPublicKey, sVarArr[i5], rVarArr[i5].toByteArray())) {
                return false;
            }
            try {
                lMSPublicKey = rVarArr[i5];
            } catch (Exception e2) {
                throw new IllegalStateException(e2.getMessage(), e2);
            }
        }
        return l.verifySignature(lMSPublicKey, sVarArr[i2], bArr);
    }
}

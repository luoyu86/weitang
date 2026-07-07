package g.a.i.b.b;

/* JADX INFO: loaded from: classes3.dex */
public class v {
    public static byte[] a(h hVar, byte[] bArr, int i2, byte[] bArr2) {
        g.a.d.e eVarA = b.a(hVar.getDigestOID());
        byte[] bArrBuild = a.compose().bytes(bArr).u32str(i2).u16str(-32640).padUntil(0, 22).build();
        eVarA.update(bArrBuild, 0, bArrBuild.length);
        g.a.d.e eVarA2 = b.a(hVar.getDigestOID());
        byte[] bArrBuild2 = a.compose().bytes(bArr).u32str(i2).padUntil(0, eVarA2.getDigestSize() + 23).build();
        x xVar = new x(bArr, bArr2, b.a(hVar.getDigestOID()));
        xVar.setQ(i2);
        xVar.setJ(0);
        int p = hVar.getP();
        int n = hVar.getN();
        int w = (1 << hVar.getW()) - 1;
        int i3 = 0;
        while (i3 < p) {
            xVar.deriveSeed(bArrBuild2, i3 < p + (-1), 23);
            g.a.j.k.shortToBigEndian((short) i3, bArrBuild2, 20);
            for (int i4 = 0; i4 < w; i4++) {
                bArrBuild2[22] = (byte) i4;
                eVarA2.update(bArrBuild2, 0, bArrBuild2.length);
                eVarA2.doFinal(bArrBuild2, 23);
            }
            eVarA.update(bArrBuild2, 23, n);
            i3++;
        }
        byte[] bArr3 = new byte[eVarA.getDigestSize()];
        eVarA.doFinal(bArr3, 0);
        return bArr3;
    }

    public static int cksm(byte[] bArr, int i2, h hVar) {
        int w = (1 << hVar.getW()) - 1;
        int iCoef = 0;
        for (int i3 = 0; i3 < (i2 * 8) / hVar.getW(); i3++) {
            iCoef = (iCoef + w) - coef(bArr, i3, hVar.getW());
        }
        return iCoef << hVar.getLs();
    }

    public static int coef(byte[] bArr, int i2, int i3) {
        int i4 = (i2 * i3) / 8;
        return (bArr[i4] >>> (((~i2) & ((8 / i3) - 1)) * i3)) & ((1 << i3) - 1);
    }

    public static k lm_ots_generate_signature(i iVar, byte[] bArr, byte[] bArr2) {
        h parameter = iVar.getParameter();
        int n = parameter.getN();
        int p = parameter.getP();
        int w = parameter.getW();
        byte[] bArr3 = new byte[p * n];
        g.a.d.e eVarA = b.a(parameter.getDigestOID());
        x xVarA = iVar.a();
        int iCksm = cksm(bArr, n, parameter);
        bArr[n] = (byte) ((iCksm >>> 8) & 255);
        bArr[n + 1] = (byte) iCksm;
        int i2 = n + 23;
        byte[] bArrBuild = a.compose().bytes(iVar.getI()).u32str(iVar.getQ()).padUntil(0, i2).build();
        xVarA.setJ(0);
        int i3 = 0;
        while (i3 < p) {
            g.a.j.k.shortToBigEndian((short) i3, bArrBuild, 20);
            int i4 = 23;
            xVarA.deriveSeed(bArrBuild, i3 < p + (-1), 23);
            int iCoef = coef(bArr, i3, w);
            for (int i5 = 0; i5 < iCoef; i5++) {
                bArrBuild[22] = (byte) i5;
                eVarA.update(bArrBuild, 0, i2);
                i4 = 23;
                eVarA.doFinal(bArrBuild, 23);
            }
            System.arraycopy(bArrBuild, i4, bArr3, n * i3, n);
            i3++;
        }
        return new k(parameter, bArr2, bArr3);
    }

    public static k lm_ots_generate_signature(u uVar, i iVar, byte[][] bArr, byte[] bArr2, boolean z) {
        byte[] bArrA;
        byte[] bArrD = new byte[34];
        if (z) {
            bArrA = new byte[32];
            System.arraycopy(bArr2, 0, bArrD, 0, iVar.getParameter().getN());
        } else {
            m mVarB = iVar.b(uVar, bArr);
            w.a(bArr2, 0, bArr2.length, mVarB);
            bArrA = mVarB.a();
            bArrD = mVarB.d();
        }
        return lm_ots_generate_signature(iVar, bArrD, bArrA);
    }

    public static boolean lm_ots_validate_signature(j jVar, k kVar, byte[] bArr, boolean z) throws n {
        if (kVar.getType().equals(jVar.getParameter())) {
            return g.a.j.a.areEqual(lm_ots_validate_signature_calculate(jVar, kVar, bArr), jVar.getK());
        }
        throw new n("public key and signature ots types do not match");
    }

    public static byte[] lm_ots_validate_signature_calculate(j jVar, k kVar, byte[] bArr) {
        m mVarA = jVar.a(kVar);
        w.b(bArr, mVarA);
        return lm_ots_validate_signature_calculate(mVarA);
    }

    public static byte[] lm_ots_validate_signature_calculate(m mVar) {
        j publicKey = mVar.getPublicKey();
        h parameter = publicKey.getParameter();
        Object signature = mVar.getSignature();
        k otsSignature = signature instanceof s ? ((s) signature).getOtsSignature() : (k) signature;
        int n = parameter.getN();
        int w = parameter.getW();
        int p = parameter.getP();
        byte[] bArrD = mVar.d();
        int iCksm = cksm(bArrD, n, parameter);
        bArrD[n] = (byte) ((iCksm >>> 8) & 255);
        bArrD[n + 1] = (byte) iCksm;
        byte[] i2 = publicKey.getI();
        int q2 = publicKey.getQ();
        g.a.d.e eVarA = b.a(parameter.getDigestOID());
        w.b(i2, eVarA);
        w.e(q2, eVarA);
        w.d((short) -32640, eVarA);
        a aVarU32str = a.compose().bytes(i2).u32str(q2);
        int i3 = n + 23;
        byte[] bArrBuild = aVarU32str.padUntil(0, i3).build();
        int i4 = (1 << w) - 1;
        byte[] y = otsSignature.getY();
        g.a.d.e eVarA2 = b.a(parameter.getDigestOID());
        for (int i5 = 0; i5 < p; i5++) {
            g.a.j.k.shortToBigEndian((short) i5, bArrBuild, 20);
            System.arraycopy(y, i5 * n, bArrBuild, 23, n);
            for (int iCoef = coef(bArrD, i5, w); iCoef < i4; iCoef++) {
                bArrBuild[22] = (byte) iCoef;
                eVarA2.update(bArrBuild, 0, i3);
                eVarA2.doFinal(bArrBuild, 23);
            }
            eVarA.update(bArrBuild, 23, n);
        }
        byte[] bArr = new byte[n];
        eVarA.doFinal(bArr, 0);
        return bArr;
    }

    public static j lms_ots_generatePublicKey(i iVar) {
        return new j(iVar.getParameter(), iVar.getI(), iVar.getQ(), a(iVar.getParameter(), iVar.getI(), iVar.getQ(), iVar.getMasterSecret()));
    }
}

package g.a.i.b.b;

/* JADX INFO: loaded from: classes3.dex */
public class l {
    public static q generateKeys(u uVar, h hVar, int i2, byte[] bArr, byte[] bArr2) throws IllegalArgumentException {
        if (bArr2 != null && bArr2.length >= uVar.getM()) {
            return new q(uVar, hVar, i2, bArr, 1 << uVar.getH(), bArr2);
        }
        throw new IllegalArgumentException("root seed is less than " + uVar.getM());
    }

    public static s generateSign(m mVar) {
        return new s(mVar.c().getQ(), v.lm_ots_generate_signature(mVar.c(), mVar.d(), mVar.a()), mVar.e(), mVar.b());
    }

    public static s generateSign(q qVar, byte[] bArr) {
        m mVarGenerateLMSContext = qVar.generateLMSContext();
        mVarGenerateLMSContext.update(bArr, 0, bArr.length);
        return generateSign(mVarGenerateLMSContext);
    }

    public static boolean verifySignature(r rVar, m mVar) {
        s sVar = (s) mVar.getSignature();
        u parameter = sVar.getParameter();
        int h2 = parameter.getH();
        byte[][] y = sVar.getY();
        byte[] bArrLm_ots_validate_signature_calculate = v.lm_ots_validate_signature_calculate(mVar);
        int q2 = (1 << h2) + sVar.getQ();
        byte[] i2 = rVar.getI();
        g.a.d.e eVarA = b.a(parameter.getDigestOID());
        int digestSize = eVarA.getDigestSize();
        byte[] bArr = new byte[digestSize];
        eVarA.update(i2, 0, i2.length);
        w.e(q2, eVarA);
        w.d((short) -32126, eVarA);
        eVarA.update(bArrLm_ots_validate_signature_calculate, 0, bArrLm_ots_validate_signature_calculate.length);
        eVarA.doFinal(bArr, 0);
        int i3 = 0;
        while (q2 > 1) {
            if ((q2 & 1) == 1) {
                eVarA.update(i2, 0, i2.length);
                w.e(q2 / 2, eVarA);
                w.d((short) -31869, eVarA);
                eVarA.update(y[i3], 0, y[i3].length);
                eVarA.update(bArr, 0, digestSize);
            } else {
                eVarA.update(i2, 0, i2.length);
                w.e(q2 / 2, eVarA);
                w.d((short) -31869, eVarA);
                eVarA.update(bArr, 0, digestSize);
                eVarA.update(y[i3], 0, y[i3].length);
            }
            eVarA.doFinal(bArr, 0);
            q2 /= 2;
            i3++;
        }
        return rVar.b(bArr);
    }

    public static boolean verifySignature(r rVar, s sVar, byte[] bArr) {
        m mVarA = rVar.a(sVar);
        w.b(bArr, mVarA);
        return verifySignature(rVar, mVarA);
    }

    public static boolean verifySignature(r rVar, byte[] bArr, byte[] bArr2) {
        m mVarGenerateLMSContext = rVar.generateLMSContext(bArr);
        w.b(bArr2, mVarGenerateLMSContext);
        return verifySignature(rVar, mVarGenerateLMSContext);
    }
}

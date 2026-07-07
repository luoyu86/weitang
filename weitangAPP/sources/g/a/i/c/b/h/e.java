package g.a.i.c.b.h;

import g.a.a.a0;
import g.a.a.v;
import g.a.d.i;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static v a(String str) {
        if (str.equals(MessageDigestAlgorithms.SHA_256)) {
            return g.a.a.q3.b.f13301c;
        }
        if (str.equals(MessageDigestAlgorithms.SHA_512)) {
            return g.a.a.q3.b.f13303e;
        }
        if (str.equals("SHAKE128")) {
            return g.a.a.q3.b.m;
        }
        if (str.equals("SHAKE256")) {
            return g.a.a.q3.b.n;
        }
        throw new IllegalArgumentException("unrecognized digest: " + str);
    }

    public static byte[] getDigestResult(g.a.d.e eVar) {
        int digestSize = getDigestSize(eVar);
        byte[] bArr = new byte[digestSize];
        if (eVar instanceof i) {
            ((i) eVar).doFinal(bArr, 0, digestSize);
        } else {
            eVar.doFinal(bArr, 0);
        }
        return bArr;
    }

    public static int getDigestSize(g.a.d.e eVar) {
        boolean z = eVar instanceof i;
        int digestSize = eVar.getDigestSize();
        return z ? digestSize * 2 : digestSize;
    }

    public static String getXMSSDigestName(v vVar) {
        if (vVar.equals((a0) g.a.a.q3.b.f13301c)) {
            return "SHA256";
        }
        if (vVar.equals((a0) g.a.a.q3.b.f13303e)) {
            return "SHA512";
        }
        if (vVar.equals((a0) g.a.a.q3.b.m)) {
            return "SHAKE128";
        }
        if (vVar.equals((a0) g.a.a.q3.b.n)) {
            return "SHAKE256";
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + vVar);
    }
}

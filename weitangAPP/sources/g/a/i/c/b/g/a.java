package g.a.i.c.b.g;

import g.a.a.g;
import g.a.a.t3.b;
import g.a.a.y3.l;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static byte[] getEncodedPrivateKeyInfo(b bVar) {
        try {
            return bVar.getEncoded("DER");
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] getEncodedPrivateKeyInfo(g.a.a.y3.a aVar, g gVar) {
        try {
            return getEncodedPrivateKeyInfo(new b(aVar, gVar.toASN1Primitive()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] getEncodedSubjectPublicKeyInfo(g.a.a.y3.a aVar, g gVar) {
        try {
            return getEncodedSubjectPublicKeyInfo(new l(aVar, gVar));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] getEncodedSubjectPublicKeyInfo(g.a.a.y3.a aVar, byte[] bArr) {
        try {
            return getEncodedSubjectPublicKeyInfo(new l(aVar, bArr));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] getEncodedSubjectPublicKeyInfo(l lVar) {
        try {
            return lVar.getEncoded("DER");
        } catch (Exception unused) {
            return null;
        }
    }
}

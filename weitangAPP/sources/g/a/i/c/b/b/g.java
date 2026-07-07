package g.a.i.c.b.b;

import g.a.a.a0;
import g.a.a.v1;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static g.a.a.y3.a a(String str) {
        if (str.equals(MessageDigestAlgorithms.SHA_1)) {
            return new g.a.a.y3.a(g.a.a.s3.a.f13329i, v1.f13368b);
        }
        if (str.equals(MessageDigestAlgorithms.SHA_224)) {
            return new g.a.a.y3.a(g.a.a.q3.b.f13304f);
        }
        if (str.equals(MessageDigestAlgorithms.SHA_256)) {
            return new g.a.a.y3.a(g.a.a.q3.b.f13301c);
        }
        if (str.equals(MessageDigestAlgorithms.SHA_384)) {
            return new g.a.a.y3.a(g.a.a.q3.b.f13302d);
        }
        if (str.equals(MessageDigestAlgorithms.SHA_512)) {
            return new g.a.a.y3.a(g.a.a.q3.b.f13303e);
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + str);
    }

    public static g.a.d.e b(g.a.a.y3.a aVar) {
        if (aVar.getAlgorithm().equals((a0) g.a.a.s3.a.f13329i)) {
            return g.a.d.o.c.createSHA1();
        }
        if (aVar.getAlgorithm().equals((a0) g.a.a.q3.b.f13304f)) {
            return g.a.d.o.c.createSHA224();
        }
        if (aVar.getAlgorithm().equals((a0) g.a.a.q3.b.f13301c)) {
            return g.a.d.o.c.createSHA256();
        }
        if (aVar.getAlgorithm().equals((a0) g.a.a.q3.b.f13302d)) {
            return g.a.d.o.c.createSHA384();
        }
        if (aVar.getAlgorithm().equals((a0) g.a.a.q3.b.f13303e)) {
            return g.a.d.o.c.createSHA512();
        }
        throw new IllegalArgumentException("unrecognised OID in digest algorithm identifier: " + aVar.getAlgorithm());
    }
}

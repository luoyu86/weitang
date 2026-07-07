package g.a.i.b.h;

import g.a.a.a0;
import g.a.a.v;
import g.a.a.v1;
import g.a.d.j.j;
import g.a.d.j.l;
import g.a.i.a.h;
import g.a.j.g;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g.a.a.y3.a f14424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g.a.a.y3.a f14425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g.a.a.y3.a f14426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g.a.a.y3.a f14427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g.a.a.y3.a f14428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g.a.a.y3.a f14429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g.a.a.y3.a f14430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g.a.a.y3.a f14431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map f14432i;

    static {
        v vVar = g.a.i.a.e.X;
        f14424a = new g.a.a.y3.a(vVar);
        v vVar2 = g.a.i.a.e.Y;
        f14425b = new g.a.a.y3.a(vVar2);
        f14426c = new g.a.a.y3.a(g.a.a.q3.b.j);
        f14427d = new g.a.a.y3.a(g.a.a.q3.b.f13306h);
        f14428e = new g.a.a.y3.a(g.a.a.q3.b.f13301c);
        f14429f = new g.a.a.y3.a(g.a.a.q3.b.f13303e);
        f14430g = new g.a.a.y3.a(g.a.a.q3.b.m);
        f14431h = new g.a.a.y3.a(g.a.a.q3.b.n);
        HashMap map = new HashMap();
        f14432i = map;
        map.put(vVar, g.valueOf(5));
        map.put(vVar2, g.valueOf(6));
    }

    public static g.a.d.e a(v vVar) {
        if (vVar.equals((a0) g.a.a.q3.b.f13301c)) {
            return new g.a.d.j.g();
        }
        if (vVar.equals((a0) g.a.a.q3.b.f13303e)) {
            return new j();
        }
        if (vVar.equals((a0) g.a.a.q3.b.m)) {
            return new l(128);
        }
        if (vVar.equals((a0) g.a.a.q3.b.n)) {
            return new l(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + vVar);
    }

    public static g.a.a.y3.a b(int i2) {
        if (i2 == 5) {
            return f14424a;
        }
        if (i2 == 6) {
            return f14425b;
        }
        throw new IllegalArgumentException("unknown security category: " + i2);
    }

    public static int c(g.a.a.y3.a aVar) {
        return ((Integer) f14432i.get(aVar.getAlgorithm())).intValue();
    }

    public static g.a.a.y3.a d(String str) {
        if (str.equals(MessageDigestAlgorithms.SHA3_256)) {
            return f14426c;
        }
        if (str.equals(MessageDigestAlgorithms.SHA_512_256)) {
            return f14427d;
        }
        throw new IllegalArgumentException("unknown tree digest: " + str);
    }

    public static String e(h hVar) {
        g.a.a.y3.a treeDigest = hVar.getTreeDigest();
        if (treeDigest.getAlgorithm().equals((a0) f14426c.getAlgorithm())) {
            return MessageDigestAlgorithms.SHA3_256;
        }
        if (treeDigest.getAlgorithm().equals((a0) f14427d.getAlgorithm())) {
            return MessageDigestAlgorithms.SHA_512_256;
        }
        throw new IllegalArgumentException("unknown tree digest: " + treeDigest.getAlgorithm());
    }

    public static g.a.a.y3.a f(String str) {
        if (str.equals(MessageDigestAlgorithms.SHA_256)) {
            return f14428e;
        }
        if (str.equals(MessageDigestAlgorithms.SHA_512)) {
            return f14429f;
        }
        if (str.equals("SHAKE128")) {
            return f14430g;
        }
        if (str.equals("SHAKE256")) {
            return f14431h;
        }
        throw new IllegalArgumentException("unknown tree digest: " + str);
    }

    public static g.a.a.y3.a getAlgorithmIdentifier(String str) {
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

    public static String getDigestName(v vVar) {
        if (vVar.equals((a0) g.a.a.s3.a.f13329i)) {
            return MessageDigestAlgorithms.SHA_1;
        }
        if (vVar.equals((a0) g.a.a.q3.b.f13304f)) {
            return MessageDigestAlgorithms.SHA_224;
        }
        if (vVar.equals((a0) g.a.a.q3.b.f13301c)) {
            return MessageDigestAlgorithms.SHA_256;
        }
        if (vVar.equals((a0) g.a.a.q3.b.f13302d)) {
            return MessageDigestAlgorithms.SHA_384;
        }
        if (vVar.equals((a0) g.a.a.q3.b.f13303e)) {
            return MessageDigestAlgorithms.SHA_512;
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + vVar);
    }
}

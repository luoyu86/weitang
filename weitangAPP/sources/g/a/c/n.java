package g.a.c;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f13692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f13693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f13694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f13695d;

    static {
        HashSet hashSet = new HashSet();
        f13692a = hashSet;
        HashSet hashSet2 = new HashSet();
        f13693b = hashSet2;
        HashSet hashSet3 = new HashSet();
        f13694c = hashSet3;
        HashSet hashSet4 = new HashSet();
        f13695d = hashSet4;
        hashSet.add("DES");
        hashSet.add("DESEDE");
        hashSet.add(g.a.a.s3.a.f13325e.getId());
        hashSet.add(g.a.a.t3.a.W0.getId());
        hashSet.add(g.a.a.t3.a.q3.getId());
        hashSet2.add(g.a.a.z3.k.U4);
        hashSet2.add(g.a.a.v3.b.R);
        hashSet2.add(g.a.a.v3.b.S);
        hashSet2.add(g.a.a.v3.b.T);
        hashSet2.add(g.a.a.v3.b.U);
        hashSet3.add(g.a.a.z3.k.T4);
        hashSet3.add(g.a.a.z3.k.S4);
        hashSet3.add(g.a.a.v3.b.N);
        hashSet3.add(g.a.a.v3.b.J);
        hashSet3.add(g.a.a.v3.b.O);
        hashSet3.add(g.a.a.v3.b.K);
        hashSet3.add(g.a.a.v3.b.P);
        hashSet3.add(g.a.a.v3.b.L);
        hashSet3.add(g.a.a.v3.b.Q);
        hashSet3.add(g.a.a.v3.b.M);
        hashSet4.add(g.a.a.k3.a.E);
        hashSet4.add(g.a.a.u3.a.l);
        hashSet4.add(g.a.a.u3.a.m);
    }

    public static g.a.a.i3.e a(InputStream inputStream) throws h {
        return b(new g.a.a.p(inputStream));
    }

    public static g.a.a.i3.e b(g.a.a.p pVar) throws h {
        try {
            g.a.a.i3.e eVar = g.a.a.i3.e.getInstance(pVar.readObject());
            if (eVar != null) {
                return eVar;
            }
            throw new h("No content found.");
        } catch (IOException e2) {
            throw new h("IOException reading content.", e2);
        } catch (ClassCastException e3) {
            throw new h("Malformed content.", e3);
        } catch (IllegalArgumentException e4) {
            throw new h("Malformed content.", e4);
        }
    }

    public static g.a.a.i3.e c(byte[] bArr) throws h {
        return b(new g.a.a.p(bArr));
    }

    public static byte[] streamToByteArray(InputStream inputStream) throws IOException {
        return g.a.j.s.b.readAll(inputStream);
    }

    public static byte[] streamToByteArray(InputStream inputStream, int i2) throws IOException {
        return g.a.j.s.b.readAllLimited(inputStream, i2);
    }
}

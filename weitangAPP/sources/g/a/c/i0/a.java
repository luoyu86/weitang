package g.a.c.i0;

import g.a.a.v;
import g.a.a.z3.k;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.PrivateKey;
import java.security.Provider;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f13665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f13666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f13667c;

    static {
        HashSet hashSet = new HashSet();
        f13665a = hashSet;
        HashSet hashSet2 = new HashSet();
        f13666b = hashSet2;
        HashSet hashSet3 = new HashSet();
        f13667c = hashSet3;
        hashSet.add(k.U4);
        hashSet.add(g.a.a.v3.b.R);
        hashSet.add(g.a.a.v3.b.S);
        hashSet.add(g.a.a.v3.b.T);
        hashSet.add(g.a.a.v3.b.U);
        hashSet2.add(k.T4);
        hashSet2.add(k.S4);
        hashSet2.add(g.a.a.v3.b.N);
        hashSet2.add(g.a.a.v3.b.J);
        hashSet2.add(g.a.a.v3.b.O);
        hashSet2.add(g.a.a.v3.b.K);
        hashSet2.add(g.a.a.v3.b.P);
        hashSet2.add(g.a.a.v3.b.L);
        hashSet2.add(g.a.a.v3.b.Q);
        hashSet2.add(g.a.a.v3.b.M);
        hashSet3.add(g.a.a.k3.a.E);
        hashSet3.add(g.a.a.k3.a.m);
        hashSet3.add(g.a.a.u3.a.l);
        hashSet3.add(g.a.a.u3.a.m);
        hashSet3.add(g.a.a.u3.a.f13356g);
        hashSet3.add(g.a.a.u3.a.f13357h);
    }

    public static PrivateKey a(PrivateKey privateKey) {
        return privateKey instanceof g.a.e.d.b ? a(((g.a.e.d.b) privateKey).getKey()) : privateKey;
    }

    public static c b(String str) {
        return str != null ? new c(new g(str)) : new c(new b());
    }

    public static c c(Provider provider) {
        return provider != null ? new c(new h(provider)) : new c(new b());
    }

    public static boolean d(v vVar) {
        return f13667c.contains(vVar);
    }

    public static void e(AlgorithmParameters algorithmParameters, g.a.a.g gVar) throws g.a.c.h {
        try {
            g.a.e.d.a.loadParameters(algorithmParameters, gVar);
        } catch (IOException e2) {
            throw new g.a.c.h("error encoding algorithm parameters.", e2);
        }
    }
}

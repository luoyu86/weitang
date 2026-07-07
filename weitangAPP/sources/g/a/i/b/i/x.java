package g.a.i.b.i;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, x> f14536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f14537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g.a.a.v f14540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f14541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f14542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f14543h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m f14544i;

    static {
        HashMap map = new HashMap();
        Integer numValueOf = g.a.j.g.valueOf(1);
        g.a.a.v vVar = g.a.a.q3.b.f13301c;
        map.put(numValueOf, new x(10, vVar));
        map.put(g.a.j.g.valueOf(2), new x(16, vVar));
        map.put(g.a.j.g.valueOf(3), new x(20, vVar));
        Integer numValueOf2 = g.a.j.g.valueOf(4);
        g.a.a.v vVar2 = g.a.a.q3.b.f13303e;
        map.put(numValueOf2, new x(10, vVar2));
        map.put(g.a.j.g.valueOf(5), new x(16, vVar2));
        map.put(g.a.j.g.valueOf(6), new x(20, vVar2));
        Integer numValueOf3 = g.a.j.g.valueOf(7);
        g.a.a.v vVar3 = g.a.a.q3.b.m;
        map.put(numValueOf3, new x(10, vVar3));
        map.put(g.a.j.g.valueOf(8), new x(16, vVar3));
        map.put(g.a.j.g.valueOf(9), new x(20, vVar3));
        Integer numValueOf4 = g.a.j.g.valueOf(10);
        g.a.a.v vVar4 = g.a.a.q3.b.n;
        map.put(numValueOf4, new x(10, vVar4));
        map.put(g.a.j.g.valueOf(11), new x(16, vVar4));
        map.put(g.a.j.g.valueOf(12), new x(20, vVar4));
        f14536a = Collections.unmodifiableMap(map);
    }

    public x(int i2, g.a.a.v vVar) {
        if (i2 < 2) {
            throw new IllegalArgumentException("height must be >= 2");
        }
        Objects.requireNonNull(vVar, "digest == null");
        this.f14538c = i2;
        this.f14539d = a();
        String strB = f.b(vVar);
        this.f14542g = strB;
        this.f14540e = vVar;
        m mVar = new m(vVar);
        this.f14544i = mVar;
        int iB = mVar.b();
        this.f14543h = iB;
        int iC = mVar.c();
        this.f14541f = iC;
        this.f14537b = e.lookup(strB, iB, iC, mVar.a(), i2);
    }

    public x(int i2, g.a.d.e eVar) {
        this(i2, f.c(eVar.getAlgorithmName()));
    }

    public static x lookupByOID(int i2) {
        return f14536a.get(g.a.j.g.valueOf(i2));
    }

    public final int a() {
        int i2 = 2;
        while (true) {
            int i3 = this.f14538c;
            if (i2 > i3) {
                throw new IllegalStateException("should never happen...");
            }
            if ((i3 - i2) % 2 == 0) {
                return i2;
            }
            i2++;
        }
    }

    public int b() {
        return this.f14539d;
    }

    public int c() {
        return this.f14544i.a();
    }

    public w d() {
        return this.f14537b;
    }

    public String e() {
        return this.f14542g;
    }

    public k f() {
        return new k(this.f14544i);
    }

    public int g() {
        return this.f14541f;
    }

    public int getHeight() {
        return this.f14538c;
    }

    public g.a.a.v getTreeDigestOID() {
        return this.f14540e;
    }

    public int getTreeDigestSize() {
        return this.f14543h;
    }
}

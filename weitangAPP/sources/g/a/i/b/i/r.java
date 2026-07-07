package g.a.i.b.i;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, r> f14505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f14506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f14507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14509e;

    static {
        HashMap map = new HashMap();
        Integer numValueOf = g.a.j.g.valueOf(1);
        g.a.a.v vVar = g.a.a.q3.b.f13301c;
        map.put(numValueOf, new r(20, 2, vVar));
        map.put(g.a.j.g.valueOf(2), new r(20, 4, vVar));
        map.put(g.a.j.g.valueOf(3), new r(40, 2, vVar));
        map.put(g.a.j.g.valueOf(4), new r(40, 4, vVar));
        map.put(g.a.j.g.valueOf(5), new r(40, 8, vVar));
        map.put(g.a.j.g.valueOf(6), new r(60, 3, vVar));
        map.put(g.a.j.g.valueOf(7), new r(60, 6, vVar));
        map.put(g.a.j.g.valueOf(8), new r(60, 12, vVar));
        Integer numValueOf2 = g.a.j.g.valueOf(9);
        g.a.a.v vVar2 = g.a.a.q3.b.f13303e;
        map.put(numValueOf2, new r(20, 2, vVar2));
        map.put(g.a.j.g.valueOf(10), new r(20, 4, vVar2));
        map.put(g.a.j.g.valueOf(11), new r(40, 2, vVar2));
        map.put(g.a.j.g.valueOf(12), new r(40, 4, vVar2));
        map.put(g.a.j.g.valueOf(13), new r(40, 8, vVar2));
        map.put(g.a.j.g.valueOf(14), new r(60, 3, vVar2));
        map.put(g.a.j.g.valueOf(15), new r(60, 6, vVar2));
        map.put(g.a.j.g.valueOf(16), new r(60, 12, vVar2));
        Integer numValueOf3 = g.a.j.g.valueOf(17);
        g.a.a.v vVar3 = g.a.a.q3.b.m;
        map.put(numValueOf3, new r(20, 2, vVar3));
        map.put(g.a.j.g.valueOf(18), new r(20, 4, vVar3));
        map.put(g.a.j.g.valueOf(19), new r(40, 2, vVar3));
        map.put(g.a.j.g.valueOf(20), new r(40, 4, vVar3));
        map.put(g.a.j.g.valueOf(21), new r(40, 8, vVar3));
        map.put(g.a.j.g.valueOf(22), new r(60, 3, vVar3));
        map.put(g.a.j.g.valueOf(23), new r(60, 6, vVar3));
        map.put(g.a.j.g.valueOf(24), new r(60, 12, vVar3));
        Integer numValueOf4 = g.a.j.g.valueOf(25);
        g.a.a.v vVar4 = g.a.a.q3.b.n;
        map.put(numValueOf4, new r(20, 2, vVar4));
        map.put(g.a.j.g.valueOf(26), new r(20, 4, vVar4));
        map.put(g.a.j.g.valueOf(27), new r(40, 2, vVar4));
        map.put(g.a.j.g.valueOf(28), new r(40, 4, vVar4));
        map.put(g.a.j.g.valueOf(29), new r(40, 8, vVar4));
        map.put(g.a.j.g.valueOf(30), new r(60, 3, vVar4));
        map.put(g.a.j.g.valueOf(31), new r(60, 6, vVar4));
        map.put(g.a.j.g.valueOf(32), new r(60, 12, vVar4));
        f14505a = Collections.unmodifiableMap(map);
    }

    public r(int i2, int i3, g.a.a.v vVar) {
        this.f14508d = i2;
        this.f14509e = i3;
        this.f14507c = new x(f(i2, i3), vVar);
        this.f14506b = d.lookup(c(), getTreeDigestSize(), d(), a(), getHeight(), i3);
    }

    public r(int i2, int i3, g.a.d.e eVar) {
        this(i2, i3, f.c(eVar.getAlgorithmName()));
    }

    public static int f(int i2, int i3) throws IllegalArgumentException {
        if (i2 < 2) {
            throw new IllegalArgumentException("totalHeight must be > 1");
        }
        if (i2 % i3 != 0) {
            throw new IllegalArgumentException("layers must divide totalHeight without remainder");
        }
        int i4 = i2 / i3;
        if (i4 != 1) {
            return i4;
        }
        throw new IllegalArgumentException("height / layers must be greater than 1");
    }

    public static r lookupByOID(int i2) {
        return f14505a.get(g.a.j.g.valueOf(i2));
    }

    public int a() {
        return this.f14507c.c();
    }

    public w b() {
        return this.f14506b;
    }

    public String c() {
        return this.f14507c.e();
    }

    public int d() {
        return this.f14507c.g();
    }

    public x e() {
        return this.f14507c;
    }

    public int getHeight() {
        return this.f14508d;
    }

    public int getLayers() {
        return this.f14509e;
    }

    public g.a.a.v getTreeDigestOID() {
        return this.f14507c.getTreeDigestOID();
    }

    public int getTreeDigestSize() {
        return this.f14507c.getTreeDigestSize();
    }
}

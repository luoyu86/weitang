package g.a.h;

import g.a.a.v;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f14189a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f14190b;

    static {
        HashMap map = new HashMap();
        map.put(new v("1.2.840.113533.7.66.10"), g.a.j.g.valueOf(128));
        map.put(g.a.a.t3.a.W0, g.a.j.g.valueOf(192));
        map.put(g.a.a.t3.a.q3, g.a.j.g.valueOf(192));
        map.put(g.a.a.t3.a.R0, g.a.j.g.valueOf(64));
        map.put(g.a.a.t3.a.P0, g.a.j.g.valueOf(64));
        map.put(g.a.a.q3.b.y, g.a.j.g.valueOf(128));
        map.put(g.a.a.q3.b.G, g.a.j.g.valueOf(192));
        map.put(g.a.a.q3.b.O, g.a.j.g.valueOf(256));
        map.put(g.a.a.q3.b.C, g.a.j.g.valueOf(128));
        map.put(g.a.a.q3.b.K, g.a.j.g.valueOf(192));
        map.put(g.a.a.q3.b.S, g.a.j.g.valueOf(256));
        map.put(g.a.a.q3.b.D, g.a.j.g.valueOf(128));
        map.put(g.a.a.q3.b.L, g.a.j.g.valueOf(192));
        map.put(g.a.a.q3.b.T, g.a.j.g.valueOf(256));
        map.put(g.a.a.q3.b.B, g.a.j.g.valueOf(128));
        map.put(g.a.a.q3.b.J, g.a.j.g.valueOf(192));
        map.put(g.a.a.q3.b.R, g.a.j.g.valueOf(256));
        map.put(g.a.a.q3.b.E, g.a.j.g.valueOf(128));
        map.put(g.a.a.q3.b.M, g.a.j.g.valueOf(192));
        map.put(g.a.a.q3.b.U, g.a.j.g.valueOf(256));
        map.put(g.a.a.r3.a.f13312a, g.a.j.g.valueOf(128));
        map.put(g.a.a.r3.a.f13313b, g.a.j.g.valueOf(192));
        map.put(g.a.a.r3.a.f13314c, g.a.j.g.valueOf(256));
        map.put(g.a.a.r3.a.f13315d, g.a.j.g.valueOf(128));
        map.put(g.a.a.r3.a.f13316e, g.a.j.g.valueOf(192));
        map.put(g.a.a.r3.a.f13317f, g.a.j.g.valueOf(256));
        map.put(g.a.a.p3.a.f13283a, g.a.j.g.valueOf(128));
        map.put(g.a.a.s3.a.f13325e, g.a.j.g.valueOf(64));
        map.put(g.a.a.k3.a.f13207f, g.a.j.g.valueOf(256));
        f14190b = Collections.unmodifiableMap(map);
    }

    @Override // g.a.h.m
    public int getKeySize(v vVar) {
        Integer num = (Integer) f14190b.get(vVar);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // g.a.h.m
    public int getKeySize(g.a.a.y3.a aVar) {
        int keySize = getKeySize(aVar.getAlgorithm());
        if (keySize > 0) {
            return keySize;
        }
        return -1;
    }
}

package g.a.d.o;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f13827a;

    public static class a implements m {
        @Override // g.a.d.o.c.m
        public g.a.d.e createClone(g.a.d.e eVar) {
            return new g.a.d.j.i((g.a.d.j.i) eVar);
        }
    }

    public static class b implements m {
        @Override // g.a.d.o.c.m
        public g.a.d.e createClone(g.a.d.e eVar) {
            return new g.a.d.j.l((g.a.d.j.l) eVar);
        }
    }

    /* JADX INFO: renamed from: g.a.d.o.c$c, reason: collision with other inner class name */
    public static class C0255c implements m {
        @Override // g.a.d.o.c.m
        public g.a.d.e createClone(g.a.d.e eVar) {
            return new g.a.d.j.l((g.a.d.j.l) eVar);
        }
    }

    public static class d implements m {
        @Override // g.a.d.o.c.m
        public g.a.d.e createClone(g.a.d.e eVar) {
            return new g.a.d.j.d((g.a.d.j.d) eVar);
        }
    }

    public static class e implements m {
        @Override // g.a.d.o.c.m
        public g.a.d.e createClone(g.a.d.e eVar) {
            return new g.a.d.j.d((g.a.d.j.d) eVar);
        }
    }

    public static class f implements m {
        @Override // g.a.d.o.c.m
        public g.a.d.e createClone(g.a.d.e eVar) {
            return new g.a.d.j.f((g.a.d.j.f) eVar);
        }
    }

    public static class g implements m {
        @Override // g.a.d.o.c.m
        public g.a.d.e createClone(g.a.d.e eVar) {
            return new g.a.d.j.g((g.a.d.j.g) eVar);
        }
    }

    public static class h implements m {
        @Override // g.a.d.o.c.m
        public g.a.d.e createClone(g.a.d.e eVar) {
            return new g.a.d.j.h((g.a.d.j.h) eVar);
        }
    }

    public static class i implements m {
        @Override // g.a.d.o.c.m
        public g.a.d.e createClone(g.a.d.e eVar) {
            return new g.a.d.j.j((g.a.d.j.j) eVar);
        }
    }

    public static class j implements m {
        @Override // g.a.d.o.c.m
        public g.a.d.e createClone(g.a.d.e eVar) {
            return new g.a.d.j.i((g.a.d.j.i) eVar);
        }
    }

    public static class k implements m {
        @Override // g.a.d.o.c.m
        public g.a.d.e createClone(g.a.d.e eVar) {
            return new g.a.d.j.i((g.a.d.j.i) eVar);
        }
    }

    public static class l implements m {
        @Override // g.a.d.o.c.m
        public g.a.d.e createClone(g.a.d.e eVar) {
            return new g.a.d.j.i((g.a.d.j.i) eVar);
        }
    }

    public interface m {
        g.a.d.e createClone(g.a.d.e eVar);
    }

    static {
        HashMap map = new HashMap();
        f13827a = map;
        map.put(createMD5().getAlgorithmName(), new d());
        map.put(createSHA1().getAlgorithmName(), new e());
        map.put(createSHA224().getAlgorithmName(), new f());
        map.put(createSHA256().getAlgorithmName(), new g());
        map.put(createSHA384().getAlgorithmName(), new h());
        map.put(createSHA512().getAlgorithmName(), new i());
        map.put(createSHA3_224().getAlgorithmName(), new j());
        map.put(createSHA3_256().getAlgorithmName(), new k());
        map.put(createSHA3_384().getAlgorithmName(), new l());
        map.put(createSHA3_512().getAlgorithmName(), new a());
        map.put(createSHAKE128().getAlgorithmName(), new b());
        map.put(createSHAKE256().getAlgorithmName(), new C0255c());
    }

    public static g.a.d.e cloneDigest(g.a.d.e eVar) {
        return ((m) f13827a.get(eVar.getAlgorithmName())).createClone(eVar);
    }

    public static g.a.d.e createMD5() {
        return new g.a.d.j.d();
    }

    public static g.a.d.e createSHA1() {
        return new g.a.d.j.e();
    }

    public static g.a.d.e createSHA224() {
        return new g.a.d.j.f();
    }

    public static g.a.d.e createSHA256() {
        return new g.a.d.j.g();
    }

    public static g.a.d.e createSHA384() {
        return new g.a.d.j.h();
    }

    public static g.a.d.e createSHA3_224() {
        return new g.a.d.j.i(224);
    }

    public static g.a.d.e createSHA3_256() {
        return new g.a.d.j.i(256);
    }

    public static g.a.d.e createSHA3_384() {
        return new g.a.d.j.i(384);
    }

    public static g.a.d.e createSHA3_512() {
        return new g.a.d.j.i(512);
    }

    public static g.a.d.e createSHA512() {
        return new g.a.d.j.j();
    }

    public static g.a.d.e createSHA512_224() {
        return new g.a.d.j.k(224);
    }

    public static g.a.d.e createSHA512_256() {
        return new g.a.d.j.k(256);
    }

    public static g.a.d.e createSHAKE128() {
        return new g.a.d.j.l(128);
    }

    public static g.a.d.e createSHAKE256() {
        return new g.a.d.j.l(256);
    }
}

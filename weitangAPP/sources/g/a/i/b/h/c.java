package g.a.i.b.h;

import g.a.a.a0;
import g.a.a.p;
import g.a.a.v;
import g.a.a.w;
import g.a.a.y3.l;
import g.a.i.a.j;
import g.a.i.a.n;
import g.a.i.b.b.r;
import g.a.i.b.i.t;
import g.a.i.b.i.x;
import g.a.i.b.i.z;
import g.a.j.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f14423a;

    public static class b extends g {
        public b() {
            super();
        }

        @Override // g.a.i.b.h.c.g
        public g.a.d.n.a a(l lVar, Object obj) throws IOException {
            byte[] octets = w.getInstance(lVar.parsePublicKey()).getOctets();
            if (k.bigEndianToInt(octets, 0) == 1) {
                return r.getInstance(g.a.j.a.copyOfRange(octets, 4, octets.length));
            }
            if (octets.length == 64) {
                octets = g.a.j.a.copyOfRange(octets, 4, octets.length);
            }
            return g.a.i.b.b.f.getInstance(octets);
        }
    }

    /* JADX INFO: renamed from: g.a.i.b.h.c$c, reason: collision with other inner class name */
    public static class C0262c extends g {
        public C0262c() {
            super();
        }

        @Override // g.a.i.b.h.c.g
        public g.a.d.n.a a(l lVar, Object obj) throws IOException {
            g.a.i.a.b bVar = g.a.i.a.b.getInstance(lVar.parsePublicKey());
            return new g.a.i.b.c.c(bVar.getN(), bVar.getT(), bVar.getG(), g.a.i.b.h.e.getDigestName(bVar.getDigest().getAlgorithm()));
        }
    }

    public static class d extends g {
        public d() {
            super();
        }

        @Override // g.a.i.b.h.c.g
        public g.a.d.n.a a(l lVar, Object obj) throws IOException {
            return new g.a.i.b.d.b(lVar.getPublicKeyData().getBytes());
        }
    }

    public static class e extends g {
        public e() {
            super();
        }

        @Override // g.a.i.b.h.c.g
        public g.a.d.n.a a(l lVar, Object obj) throws IOException {
            return new g.a.i.b.e.b(g.a.i.b.h.e.c(lVar.getAlgorithm()), lVar.getPublicKeyData().getOctets());
        }
    }

    public static class f extends g {
        public f() {
            super();
        }

        @Override // g.a.i.b.h.c.g
        public g.a.d.n.a a(l lVar, Object obj) throws IOException {
            return new g.a.i.b.g.c(lVar.getPublicKeyData().getBytes(), g.a.i.b.h.e.e(g.a.i.a.h.getInstance(lVar.getAlgorithm().getParameters())));
        }
    }

    public static abstract class g {
        public g() {
        }

        public abstract g.a.d.n.a a(l lVar, Object obj) throws IOException;
    }

    public static class h extends g {
        public h() {
            super();
        }

        @Override // g.a.i.b.h.c.g
        public g.a.d.n.a a(l lVar, Object obj) throws IOException {
            z.b bVarWithPublicKey;
            g.a.i.a.i iVar = g.a.i.a.i.getInstance(lVar.getAlgorithm().getParameters());
            if (iVar != null) {
                v algorithm = iVar.getTreeDigest().getAlgorithm();
                n nVar = n.getInstance(lVar.parsePublicKey());
                bVarWithPublicKey = new z.b(new x(iVar.getHeight(), g.a.i.b.h.e.a(algorithm))).withPublicSeed(nVar.getPublicSeed()).withRoot(nVar.getRoot());
            } else {
                byte[] octets = w.getInstance(lVar.parsePublicKey()).getOctets();
                bVarWithPublicKey = new z.b(x.lookupByOID(k.bigEndianToInt(octets, 0))).withPublicKey(octets);
            }
            return bVarWithPublicKey.build();
        }
    }

    public static class i extends g {
        public i() {
            super();
        }

        @Override // g.a.i.b.h.c.g
        public g.a.d.n.a a(l lVar, Object obj) throws IOException {
            t.b bVarWithPublicKey;
            j jVar = j.getInstance(lVar.getAlgorithm().getParameters());
            if (jVar != null) {
                v algorithm = jVar.getTreeDigest().getAlgorithm();
                n nVar = n.getInstance(lVar.parsePublicKey());
                bVarWithPublicKey = new t.b(new g.a.i.b.i.r(jVar.getHeight(), jVar.getLayers(), g.a.i.b.h.e.a(algorithm))).withPublicSeed(nVar.getPublicSeed()).withRoot(nVar.getRoot());
            } else {
                byte[] octets = w.getInstance(lVar.parsePublicKey()).getOctets();
                bVarWithPublicKey = new t.b(g.a.i.b.i.r.lookupByOID(k.bigEndianToInt(octets, 0))).withPublicKey(octets);
            }
            return bVarWithPublicKey.build();
        }
    }

    static {
        HashMap map = new HashMap();
        f14423a = map;
        map.put(g.a.i.a.e.X, new e());
        f14423a.put(g.a.i.a.e.Y, new e());
        f14423a.put(g.a.i.a.e.r, new f());
        f14423a.put(g.a.i.a.e.v, new d());
        f14423a.put(g.a.i.a.e.w, new h());
        f14423a.put(g.a.i.a.e.F, new i());
        f14423a.put(g.a.a.o3.a.f13275a, new h());
        f14423a.put(g.a.a.o3.a.f13276b, new i());
        f14423a.put(g.a.a.t3.a.e2, new b());
        f14423a.put(g.a.i.a.e.n, new C0262c());
    }

    public static g.a.d.n.a createKey(l lVar) throws IOException {
        return createKey(lVar, null);
    }

    public static g.a.d.n.a createKey(l lVar, Object obj) throws IOException {
        g.a.a.y3.a algorithm = lVar.getAlgorithm();
        g gVar = (g) f14423a.get(algorithm.getAlgorithm());
        if (gVar != null) {
            return gVar.a(lVar, obj);
        }
        throw new IOException("algorithm identifier in public key not recognised: " + algorithm.getAlgorithm());
    }

    public static g.a.d.n.a createKey(InputStream inputStream) throws IOException {
        return createKey(l.getInstance(new p(inputStream).readObject()));
    }

    public static g.a.d.n.a createKey(byte[] bArr) throws IOException {
        return createKey(l.getInstance(a0.fromByteArray(bArr)));
    }
}

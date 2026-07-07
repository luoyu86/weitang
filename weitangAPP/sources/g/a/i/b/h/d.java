package g.a.i.b.h;

import g.a.a.x1;
import g.a.a.y3.l;
import g.a.i.a.h;
import g.a.i.a.i;
import g.a.i.a.j;
import g.a.i.a.n;
import g.a.i.b.b.f;
import g.a.i.b.b.r;
import g.a.i.b.i.t;
import g.a.i.b.i.z;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static l createSubjectPublicKeyInfo(g.a.d.n.a aVar) throws IOException {
        if (aVar instanceof g.a.i.b.e.b) {
            g.a.i.b.e.b bVar = (g.a.i.b.e.b) aVar;
            return new l(e.b(bVar.getSecurityCategory()), bVar.getPublicData());
        }
        if (aVar instanceof g.a.i.b.g.c) {
            g.a.i.b.g.c cVar = (g.a.i.b.g.c) aVar;
            return new l(new g.a.a.y3.a(g.a.i.a.e.r, new h(e.d(cVar.getTreeDigest()))), cVar.getKeyData());
        }
        if (aVar instanceof g.a.i.b.d.b) {
            return new l(new g.a.a.y3.a(g.a.i.a.e.v), ((g.a.i.b.d.b) aVar).getPubData());
        }
        if (aVar instanceof r) {
            return new l(new g.a.a.y3.a(g.a.a.t3.a.e2), new x1(g.a.i.b.b.a.compose().u32str(1).bytes((r) aVar).build()));
        }
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            return new l(new g.a.a.y3.a(g.a.a.t3.a.e2), new x1(g.a.i.b.b.a.compose().u32str(fVar.getL()).bytes(fVar.getLMSPublicKey()).build()));
        }
        if (aVar instanceof z) {
            z zVar = (z) aVar;
            byte[] publicSeed = zVar.getPublicSeed();
            byte[] root = zVar.getRoot();
            byte[] encoded = zVar.getEncoded();
            return encoded.length > publicSeed.length + root.length ? new l(new g.a.a.y3.a(g.a.a.o3.a.f13275a), new x1(encoded)) : new l(new g.a.a.y3.a(g.a.i.a.e.w, new i(zVar.getParameters().getHeight(), e.f(zVar.getTreeDigest()))), new n(publicSeed, root));
        }
        if (!(aVar instanceof t)) {
            if (!(aVar instanceof g.a.i.b.c.c)) {
                throw new IOException("key parameters not recognized");
            }
            g.a.i.b.c.c cVar2 = (g.a.i.b.c.c) aVar;
            return new l(new g.a.a.y3.a(g.a.i.a.e.n), new g.a.i.a.b(cVar2.getN(), cVar2.getT(), cVar2.getG(), e.getAlgorithmIdentifier(cVar2.getDigest())));
        }
        t tVar = (t) aVar;
        byte[] publicSeed2 = tVar.getPublicSeed();
        byte[] root2 = tVar.getRoot();
        byte[] encoded2 = tVar.getEncoded();
        return encoded2.length > publicSeed2.length + root2.length ? new l(new g.a.a.y3.a(g.a.a.o3.a.f13276b), new x1(encoded2)) : new l(new g.a.a.y3.a(g.a.i.a.e.F, new j(tVar.getParameters().getHeight(), tVar.getParameters().getLayers(), e.f(tVar.getTreeDigest()))), new g.a.i.a.l(tVar.getPublicSeed(), tVar.getRoot()));
    }
}

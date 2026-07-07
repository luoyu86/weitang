package g.a.i.b.h;

import g.a.a.a0;
import g.a.a.p;
import g.a.a.v;
import g.a.a.w;
import g.a.i.a.h;
import g.a.i.a.i;
import g.a.i.a.j;
import g.a.i.a.m;
import g.a.i.b.b.q;
import g.a.i.b.i.r;
import g.a.i.b.i.s;
import g.a.i.b.i.x;
import g.a.i.b.i.y;
import g.a.j.k;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static short[] a(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i2 = 0; i2 != length; i2++) {
            sArr[i2] = k.littleEndianToShort(bArr, i2 * 2);
        }
        return sArr;
    }

    public static g.a.d.n.a createKey(g.a.a.t3.b bVar) throws IOException {
        v algorithm = bVar.getPrivateKeyAlgorithm().getAlgorithm();
        if (algorithm.on(g.a.a.g3.a.W)) {
            return new g.a.i.b.e.a(e.c(bVar.getPrivateKeyAlgorithm()), w.getInstance(bVar.parsePrivateKey()).getOctets());
        }
        if (algorithm.equals((a0) g.a.a.g3.a.s)) {
            return new g.a.i.b.g.b(w.getInstance(bVar.parsePrivateKey()).getOctets(), e.e(h.getInstance(bVar.getPrivateKeyAlgorithm().getParameters())));
        }
        if (algorithm.equals((a0) g.a.a.g3.a.f0)) {
            return new g.a.i.b.d.a(a(w.getInstance(bVar.parsePrivateKey()).getOctets()));
        }
        if (algorithm.equals((a0) g.a.a.t3.a.e2)) {
            byte[] octets = w.getInstance(bVar.parsePrivateKey()).getOctets();
            g.a.a.c publicKeyData = bVar.getPublicKeyData();
            if (k.bigEndianToInt(octets, 0) == 1) {
                if (publicKeyData == null) {
                    return q.getInstance(g.a.j.a.copyOfRange(octets, 4, octets.length));
                }
                byte[] octets2 = publicKeyData.getOctets();
                return q.getInstance(g.a.j.a.copyOfRange(octets, 4, octets.length), g.a.j.a.copyOfRange(octets2, 4, octets2.length));
            }
            if (publicKeyData == null) {
                return g.a.i.b.b.e.getInstance(g.a.j.a.copyOfRange(octets, 4, octets.length));
            }
            return g.a.i.b.b.e.getInstance(g.a.j.a.copyOfRange(octets, 4, octets.length), publicKeyData.getOctets());
        }
        if (algorithm.equals((a0) g.a.a.g3.a.w)) {
            i iVar = i.getInstance(bVar.getPrivateKeyAlgorithm().getParameters());
            v algorithm2 = iVar.getTreeDigest().getAlgorithm();
            m mVar = m.getInstance(bVar.parsePrivateKey());
            try {
                y.b bVarWithRoot = new y.b(new x(iVar.getHeight(), e.a(algorithm2))).withIndex(mVar.getIndex()).withSecretKeySeed(mVar.getSecretKeySeed()).withSecretKeyPRF(mVar.getSecretKeyPRF()).withPublicSeed(mVar.getPublicSeed()).withRoot(mVar.getRoot());
                if (mVar.getVersion() != 0) {
                    bVarWithRoot.withMaxIndex(mVar.getMaxIndex());
                }
                if (mVar.getBdsState() != null) {
                    bVarWithRoot.withBDSState(((g.a.i.b.i.a) g.a.i.b.i.a0.deserialize(mVar.getBdsState(), g.a.i.b.i.a.class)).withWOTSDigest(algorithm2));
                }
                return bVarWithRoot.build();
            } catch (ClassNotFoundException e2) {
                throw new IOException("ClassNotFoundException processing BDS state: " + e2.getMessage());
            }
        }
        if (!algorithm.equals((a0) g.a.i.a.e.F)) {
            if (!algorithm.equals((a0) g.a.i.a.e.n)) {
                throw new RuntimeException("algorithm identifier in private key not recognised");
            }
            g.a.i.a.a aVar = g.a.i.a.a.getInstance(bVar.parsePrivateKey());
            return new g.a.i.b.c.b(aVar.getN(), aVar.getK(), aVar.getField(), aVar.getGoppaPoly(), aVar.getP(), e.getDigestName(aVar.getDigest().getAlgorithm()));
        }
        j jVar = j.getInstance(bVar.getPrivateKeyAlgorithm().getParameters());
        v algorithm3 = jVar.getTreeDigest().getAlgorithm();
        try {
            g.a.i.a.k kVar = g.a.i.a.k.getInstance(bVar.parsePrivateKey());
            s.b bVarWithRoot2 = new s.b(new r(jVar.getHeight(), jVar.getLayers(), e.a(algorithm3))).withIndex(kVar.getIndex()).withSecretKeySeed(kVar.getSecretKeySeed()).withSecretKeyPRF(kVar.getSecretKeyPRF()).withPublicSeed(kVar.getPublicSeed()).withRoot(kVar.getRoot());
            if (kVar.getVersion() != 0) {
                bVarWithRoot2.withMaxIndex(kVar.getMaxIndex());
            }
            if (kVar.getBdsState() != null) {
                bVarWithRoot2.withBDSState(((g.a.i.b.i.b) g.a.i.b.i.a0.deserialize(kVar.getBdsState(), g.a.i.b.i.b.class)).withWOTSDigest(algorithm3));
            }
            return bVarWithRoot2.build();
        } catch (ClassNotFoundException e3) {
            throw new IOException("ClassNotFoundException processing BDS state: " + e3.getMessage());
        }
    }

    public static g.a.d.n.a createKey(InputStream inputStream) throws IOException {
        return createKey(g.a.a.t3.b.getInstance(new p(inputStream).readObject()));
    }

    public static g.a.d.n.a createKey(byte[] bArr) throws IOException {
        return createKey(g.a.a.t3.b.getInstance(a0.fromByteArray(bArr)));
    }
}

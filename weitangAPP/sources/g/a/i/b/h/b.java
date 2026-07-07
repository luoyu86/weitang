package g.a.i.b.h;

import g.a.a.f0;
import g.a.a.x1;
import g.a.i.a.h;
import g.a.i.a.i;
import g.a.i.a.j;
import g.a.i.a.k;
import g.a.i.a.m;
import g.a.i.b.b.q;
import g.a.i.b.i.a0;
import g.a.i.b.i.s;
import g.a.i.b.i.y;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static m a(y yVar) throws IOException {
        byte[] encoded = yVar.getEncoded();
        int treeDigestSize = yVar.getParameters().getTreeDigestSize();
        int height = yVar.getParameters().getHeight();
        int iBytesToXBigEndian = (int) a0.bytesToXBigEndian(encoded, 0, 4);
        if (!a0.isIndexValid(height, iBytesToXBigEndian)) {
            throw new IllegalArgumentException("index out of bounds");
        }
        byte[] bArrExtractBytesAtOffset = a0.extractBytesAtOffset(encoded, 4, treeDigestSize);
        int i2 = 4 + treeDigestSize;
        byte[] bArrExtractBytesAtOffset2 = a0.extractBytesAtOffset(encoded, i2, treeDigestSize);
        int i3 = i2 + treeDigestSize;
        byte[] bArrExtractBytesAtOffset3 = a0.extractBytesAtOffset(encoded, i3, treeDigestSize);
        int i4 = i3 + treeDigestSize;
        byte[] bArrExtractBytesAtOffset4 = a0.extractBytesAtOffset(encoded, i4, treeDigestSize);
        int i5 = i4 + treeDigestSize;
        byte[] bArrExtractBytesAtOffset5 = a0.extractBytesAtOffset(encoded, i5, encoded.length - i5);
        try {
            g.a.i.b.i.a aVar = (g.a.i.b.i.a) a0.deserialize(bArrExtractBytesAtOffset5, g.a.i.b.i.a.class);
            return aVar.getMaxIndex() != (1 << height) - 1 ? new m(iBytesToXBigEndian, bArrExtractBytesAtOffset, bArrExtractBytesAtOffset2, bArrExtractBytesAtOffset3, bArrExtractBytesAtOffset4, bArrExtractBytesAtOffset5, aVar.getMaxIndex()) : new m(iBytesToXBigEndian, bArrExtractBytesAtOffset, bArrExtractBytesAtOffset2, bArrExtractBytesAtOffset3, bArrExtractBytesAtOffset4, bArrExtractBytesAtOffset5);
        } catch (ClassNotFoundException e2) {
            throw new IOException("cannot parse BDS: " + e2.getMessage());
        }
    }

    public static k b(s sVar) throws IOException {
        byte[] encoded = sVar.getEncoded();
        int treeDigestSize = sVar.getParameters().getTreeDigestSize();
        int height = sVar.getParameters().getHeight();
        int i2 = (height + 7) / 8;
        long jBytesToXBigEndian = (int) a0.bytesToXBigEndian(encoded, 0, i2);
        if (!a0.isIndexValid(height, jBytesToXBigEndian)) {
            throw new IllegalArgumentException("index out of bounds");
        }
        int i3 = i2 + 0;
        byte[] bArrExtractBytesAtOffset = a0.extractBytesAtOffset(encoded, i3, treeDigestSize);
        int i4 = i3 + treeDigestSize;
        byte[] bArrExtractBytesAtOffset2 = a0.extractBytesAtOffset(encoded, i4, treeDigestSize);
        int i5 = i4 + treeDigestSize;
        byte[] bArrExtractBytesAtOffset3 = a0.extractBytesAtOffset(encoded, i5, treeDigestSize);
        int i6 = i5 + treeDigestSize;
        byte[] bArrExtractBytesAtOffset4 = a0.extractBytesAtOffset(encoded, i6, treeDigestSize);
        int i7 = i6 + treeDigestSize;
        byte[] bArrExtractBytesAtOffset5 = a0.extractBytesAtOffset(encoded, i7, encoded.length - i7);
        try {
            g.a.i.b.i.b bVar = (g.a.i.b.i.b) a0.deserialize(bArrExtractBytesAtOffset5, g.a.i.b.i.b.class);
            return bVar.getMaxIndex() != (1 << height) - 1 ? new k(jBytesToXBigEndian, bArrExtractBytesAtOffset, bArrExtractBytesAtOffset2, bArrExtractBytesAtOffset3, bArrExtractBytesAtOffset4, bArrExtractBytesAtOffset5, bVar.getMaxIndex()) : new k(jBytesToXBigEndian, bArrExtractBytesAtOffset, bArrExtractBytesAtOffset2, bArrExtractBytesAtOffset3, bArrExtractBytesAtOffset4, bArrExtractBytesAtOffset5);
        } catch (ClassNotFoundException e2) {
            throw new IOException("cannot parse BDSStateMap: " + e2.getMessage());
        }
    }

    public static g.a.a.t3.b createPrivateKeyInfo(g.a.d.n.a aVar) throws IOException {
        return createPrivateKeyInfo(aVar, null);
    }

    public static g.a.a.t3.b createPrivateKeyInfo(g.a.d.n.a aVar, f0 f0Var) throws IOException {
        if (aVar instanceof g.a.i.b.e.a) {
            g.a.i.b.e.a aVar2 = (g.a.i.b.e.a) aVar;
            return new g.a.a.t3.b(e.b(aVar2.getSecurityCategory()), new x1(aVar2.getSecret()), f0Var);
        }
        if (aVar instanceof g.a.i.b.g.b) {
            g.a.i.b.g.b bVar = (g.a.i.b.g.b) aVar;
            return new g.a.a.t3.b(new g.a.a.y3.a(g.a.i.a.e.r, new h(e.d(bVar.getTreeDigest()))), new x1(bVar.getKeyData()));
        }
        if (aVar instanceof g.a.i.b.d.a) {
            g.a.a.y3.a aVar3 = new g.a.a.y3.a(g.a.i.a.e.v);
            short[] secData = ((g.a.i.b.d.a) aVar).getSecData();
            byte[] bArr = new byte[secData.length * 2];
            for (int i2 = 0; i2 != secData.length; i2++) {
                g.a.j.k.shortToLittleEndian(secData[i2], bArr, i2 * 2);
            }
            return new g.a.a.t3.b(aVar3, new x1(bArr));
        }
        if (aVar instanceof q) {
            q qVar = (q) aVar;
            byte[] bArrBuild = g.a.i.b.b.a.compose().u32str(1).bytes(qVar).build();
            return new g.a.a.t3.b(new g.a.a.y3.a(g.a.a.t3.a.e2), new x1(bArrBuild), f0Var, g.a.i.b.b.a.compose().u32str(1).bytes(qVar.getPublicKey()).build());
        }
        if (aVar instanceof g.a.i.b.b.e) {
            g.a.i.b.b.e eVar = (g.a.i.b.b.e) aVar;
            byte[] bArrBuild2 = g.a.i.b.b.a.compose().u32str(eVar.getL()).bytes(eVar).build();
            return new g.a.a.t3.b(new g.a.a.y3.a(g.a.a.t3.a.e2), new x1(bArrBuild2), f0Var, g.a.i.b.b.a.compose().u32str(eVar.getL()).bytes(eVar.getPublicKey().getLMSPublicKey()).build());
        }
        if (aVar instanceof y) {
            y yVar = (y) aVar;
            return new g.a.a.t3.b(new g.a.a.y3.a(g.a.i.a.e.w, new i(yVar.getParameters().getHeight(), e.f(yVar.getTreeDigest()))), a(yVar), f0Var);
        }
        if (aVar instanceof s) {
            s sVar = (s) aVar;
            return new g.a.a.t3.b(new g.a.a.y3.a(g.a.i.a.e.F, new j(sVar.getParameters().getHeight(), sVar.getParameters().getLayers(), e.f(sVar.getTreeDigest()))), b(sVar), f0Var);
        }
        if (!(aVar instanceof g.a.i.b.c.b)) {
            throw new IOException("key parameters not recognized");
        }
        g.a.i.b.c.b bVar2 = (g.a.i.b.c.b) aVar;
        return new g.a.a.t3.b(new g.a.a.y3.a(g.a.i.a.e.n), new g.a.i.a.a(bVar2.getN(), bVar2.getK(), bVar2.getField(), bVar2.getGoppaPoly(), bVar2.getP(), e.getAlgorithmIdentifier(bVar2.getDigest())));
    }
}

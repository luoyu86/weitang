package g.a.i.b.i;

import g.a.i.b.i.j;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class b implements Serializable {
    private static final long serialVersionUID = -3464451825208522308L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, a> f14445a = new TreeMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient long f14446b;

    public b(long j) {
        this.f14446b = j;
    }

    public b(b bVar, long j) {
        for (Integer num : bVar.f14445a.keySet()) {
            this.f14445a.put(num, new a(bVar.f14445a.get(num)));
        }
        this.f14446b = j;
    }

    public b(r rVar, long j, byte[] bArr, byte[] bArr2) {
        this.f14446b = (1 << rVar.getHeight()) - 1;
        for (long j2 = 0; j2 < j; j2++) {
            d(rVar, j2, bArr, bArr2);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f14446b = objectInputStream.available() != 0 ? objectInputStream.readLong() : 0L;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(this.f14446b);
    }

    public a a(int i2) {
        return this.f14445a.get(g.a.j.g.valueOf(i2));
    }

    public void b(int i2, a aVar) {
        this.f14445a.put(g.a.j.g.valueOf(i2), aVar);
    }

    public a c(int i2, byte[] bArr, byte[] bArr2, j jVar) {
        return this.f14445a.put(g.a.j.g.valueOf(i2), this.f14445a.get(g.a.j.g.valueOf(i2)).getNextState(bArr, bArr2, jVar));
    }

    public void d(r rVar, long j, byte[] bArr, byte[] bArr2) {
        x xVarE = rVar.e();
        int height = xVarE.getHeight();
        long treeIndex = a0.getTreeIndex(j, height);
        int leafIndex = a0.getLeafIndex(j, height);
        j jVar = (j) new j.b().h(treeIndex).p(leafIndex).l();
        int i2 = (1 << height) - 1;
        if (leafIndex < i2) {
            if (a(0) == null || leafIndex == 0) {
                b(0, new a(xVarE, bArr, bArr2, jVar));
            }
            c(0, bArr, bArr2, jVar);
        }
        for (int i3 = 1; i3 < rVar.getLayers(); i3++) {
            int leafIndex2 = a0.getLeafIndex(treeIndex, height);
            treeIndex = a0.getTreeIndex(treeIndex, height);
            j jVar2 = (j) new j.b().g(i3).h(treeIndex).p(leafIndex2).l();
            if (this.f14445a.get(Integer.valueOf(i3)) == null || a0.isNewBDSInitNeeded(j, height, i3)) {
                this.f14445a.put(Integer.valueOf(i3), new a(xVarE, bArr, bArr2, jVar2));
            }
            if (leafIndex2 < i2 && a0.isNewAuthenticationPathNeeded(j, height, i3)) {
                c(i3, bArr, bArr2, jVar2);
            }
        }
    }

    public long getMaxIndex() {
        return this.f14446b;
    }

    public boolean isEmpty() {
        return this.f14445a.isEmpty();
    }

    public b withWOTSDigest(g.a.a.v vVar) {
        b bVar = new b(this.f14446b);
        for (Integer num : this.f14445a.keySet()) {
            bVar.f14445a.put(num, this.f14445a.get(num).withWOTSDigest(vVar));
        }
        return bVar;
    }
}

package g.a.i.b.b;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class e extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<q> f14295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<s> f14296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f14297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f14299h;

    public e(int i2, List<q> list, List<s> list2, long j, long j2) {
        super(true);
        this.f14298g = 0L;
        this.f14293b = i2;
        this.f14295d = Collections.unmodifiableList(list);
        this.f14296e = Collections.unmodifiableList(list2);
        this.f14298g = j;
        this.f14297f = j2;
        this.f14294c = false;
        i();
    }

    public e(int i2, List<q> list, List<s> list2, long j, long j2, boolean z) {
        super(true);
        this.f14298g = 0L;
        this.f14293b = i2;
        this.f14295d = Collections.unmodifiableList(list);
        this.f14296e = Collections.unmodifiableList(list2);
        this.f14298g = j;
        this.f14297f = j2;
        this.f14294c = z;
    }

    public static e g(e eVar) {
        try {
            return getInstance(eVar.getEncoded());
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    public static e getInstance(Object obj) throws Throwable {
        DataInputStream dataInputStream;
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream2 = (DataInputStream) obj;
            if (dataInputStream2.readInt() != 0) {
                throw new IllegalStateException("unknown version for hss private key");
            }
            int i2 = dataInputStream2.readInt();
            long j = dataInputStream2.readLong();
            long j2 = dataInputStream2.readLong();
            boolean z = dataInputStream2.readBoolean();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(q.getInstance(obj));
            }
            for (int i4 = 0; i4 < i2 - 1; i4++) {
                arrayList2.add(s.getInstance(obj));
            }
            return new e(i2, arrayList, arrayList2, j, j2, z);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return getInstance(g.a.j.s.b.readAll((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream3 = null;
        try {
            dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
        } catch (Throwable th) {
            th = th;
        }
        try {
            e eVar = getInstance(dataInputStream);
            dataInputStream.close();
            return eVar;
        } catch (Throwable th2) {
            th = th2;
            dataInputStream3 = dataInputStream;
            if (dataInputStream3 != null) {
                dataInputStream3.close();
            }
            throw th;
        }
    }

    public static e getInstance(byte[] bArr, byte[] bArr2) throws Throwable {
        e eVar = getInstance(bArr);
        eVar.f14299h = f.getInstance(bArr2);
        return eVar;
    }

    public long a() {
        return this.f14297f;
    }

    public synchronized List<q> b() {
        return this.f14295d;
    }

    public q c() {
        return this.f14295d.get(0);
    }

    public Object clone() throws CloneNotSupportedException {
        return g(this);
    }

    public synchronized List<s> d() {
        return this.f14296e;
    }

    public synchronized void e() {
        this.f14298g++;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f14293b == eVar.f14293b && this.f14294c == eVar.f14294c && this.f14297f == eVar.f14297f && this.f14298g == eVar.f14298g && this.f14295d.equals(eVar.f14295d)) {
            return this.f14296e.equals(eVar.f14296e);
        }
        return false;
    }

    public e extractKeyShard(int i2) {
        e eVarG;
        synchronized (this) {
            long j = i2;
            if (getUsagesRemaining() < j) {
                throw new IllegalArgumentException("usageCount exceeds usages remaining in current leaf");
            }
            long j2 = this.f14298g;
            this.f14298g = j + j2;
            eVarG = g(new e(this.f14293b, new ArrayList(b()), new ArrayList(d()), j2, j2 + j, true));
            i();
        }
        return eVarG;
    }

    public boolean f() {
        return this.f14294c;
    }

    public m generateLMSContext() {
        q qVar;
        t[] tVarArr;
        int l = getL();
        synchronized (this) {
            c.a(this);
            List<q> listB = b();
            List<s> listD = d();
            int i2 = l - 1;
            qVar = b().get(i2);
            int i3 = 0;
            tVarArr = new t[i2];
            while (i3 < i2) {
                int i4 = i3 + 1;
                tVarArr[i3] = new t(listD.get(i3), listB.get(i4).getPublicKey());
                i3 = i4;
            }
            e();
        }
        return qVar.generateLMSContext().g(tVarArr);
    }

    public byte[] generateSignature(m mVar) {
        try {
            return c.generateSignature(getL(), mVar).getEncoded();
        } catch (IOException e2) {
            throw new IllegalStateException("unable to encode signature: " + e2.getMessage(), e2);
        }
    }

    @Override // g.a.i.b.b.o, g.a.j.d
    public synchronized byte[] getEncoded() throws IOException {
        a aVarBool;
        aVarBool = a.compose().u32str(0).u32str(this.f14293b).u64str(this.f14298g).u64str(this.f14297f).bool(this.f14294c);
        Iterator<q> it = this.f14295d.iterator();
        while (it.hasNext()) {
            aVarBool.bytes(it.next());
        }
        Iterator<s> it2 = this.f14296e.iterator();
        while (it2.hasNext()) {
            aVarBool.bytes(it2.next());
        }
        return aVarBool.build();
    }

    public synchronized long getIndex() {
        return this.f14298g;
    }

    public int getL() {
        return this.f14293b;
    }

    public synchronized p[] getLMSParameters() {
        p[] pVarArr;
        int size = this.f14295d.size();
        pVarArr = new p[size];
        for (int i2 = 0; i2 < size; i2++) {
            q qVar = this.f14295d.get(i2);
            pVarArr[i2] = new p(qVar.getSigParameters(), qVar.getOtsParameters());
        }
        return pVarArr;
    }

    public synchronized f getPublicKey() {
        return new f(this.f14293b, c().getPublicKey());
    }

    public long getUsagesRemaining() {
        return this.f14297f - this.f14298g;
    }

    public void h(int i2) {
        int i3 = i2 - 1;
        x xVarA = this.f14295d.get(i3).d().a();
        xVarA.setJ(-2);
        byte[] bArr = new byte[32];
        xVarA.deriveSeed(bArr, true);
        byte[] bArr2 = new byte[32];
        xVarA.deriveSeed(bArr2, false);
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr2, 0, bArr3, 0, 16);
        ArrayList arrayList = new ArrayList(this.f14295d);
        q qVar = this.f14295d.get(i2);
        arrayList.set(i2, l.generateKeys(qVar.getSigParameters(), qVar.getOtsParameters(), 0, bArr3, bArr));
        ArrayList arrayList2 = new ArrayList(this.f14296e);
        arrayList2.set(i3, l.generateSign((q) arrayList.get(i3), ((q) arrayList.get(i2)).getPublicKey().toByteArray()));
        this.f14295d = Collections.unmodifiableList(arrayList);
        this.f14296e = Collections.unmodifiableList(arrayList2);
    }

    public int hashCode() {
        int iHashCode = ((((((this.f14293b * 31) + (this.f14294c ? 1 : 0)) * 31) + this.f14295d.hashCode()) * 31) + this.f14296e.hashCode()) * 31;
        long j = this.f14297f;
        int i2 = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.f14298g;
        return i2 + ((int) (j2 ^ (j2 >>> 32)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i() {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.i.b.b.e.i():void");
    }

    public void j(q[] qVarArr, s[] sVarArr) {
        synchronized (this) {
            this.f14295d = Collections.unmodifiableList(Arrays.asList(qVarArr));
            this.f14296e = Collections.unmodifiableList(Arrays.asList(sVarArr));
        }
    }
}

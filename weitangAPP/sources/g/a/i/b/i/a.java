package g.a.i.b.i;

import g.a.i.b.i.g;
import g.a.i.b.i.i;
import g.a.i.b.i.j;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient k f14433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f14435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u f14437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<u> f14438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<Integer, LinkedList<u>> f14439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Stack<u> f14440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<Integer, u> f14441i;
    public int j;
    public boolean k;
    public transient int l;

    public a(a aVar) {
        this.f14433a = new k(aVar.f14433a.d());
        this.f14434b = aVar.f14434b;
        this.f14436d = aVar.f14436d;
        this.f14437e = aVar.f14437e;
        ArrayList arrayList = new ArrayList();
        this.f14438f = arrayList;
        arrayList.addAll(aVar.f14438f);
        this.f14439g = new TreeMap();
        for (Integer num : aVar.f14439g.keySet()) {
            this.f14439g.put(num, (LinkedList) aVar.f14439g.get(num).clone());
        }
        Stack<u> stack = new Stack<>();
        this.f14440h = stack;
        stack.addAll(aVar.f14440h);
        this.f14435c = new ArrayList();
        Iterator<c> it = aVar.f14435c.iterator();
        while (it.hasNext()) {
            this.f14435c.add(it.next().clone());
        }
        this.f14441i = new TreeMap(aVar.f14441i);
        this.j = aVar.j;
        this.l = aVar.l;
        this.k = aVar.k;
    }

    public a(a aVar, int i2, g.a.a.v vVar) {
        this.f14433a = new k(new m(vVar));
        this.f14434b = aVar.f14434b;
        this.f14436d = aVar.f14436d;
        this.f14437e = aVar.f14437e;
        ArrayList arrayList = new ArrayList();
        this.f14438f = arrayList;
        arrayList.addAll(aVar.f14438f);
        this.f14439g = new TreeMap();
        for (Integer num : aVar.f14439g.keySet()) {
            this.f14439g.put(num, (LinkedList) aVar.f14439g.get(num).clone());
        }
        Stack<u> stack = new Stack<>();
        this.f14440h = stack;
        stack.addAll(aVar.f14440h);
        this.f14435c = new ArrayList();
        Iterator<c> it = aVar.f14435c.iterator();
        while (it.hasNext()) {
            this.f14435c.add(it.next().clone());
        }
        this.f14441i = new TreeMap(aVar.f14441i);
        this.j = aVar.j;
        this.l = i2;
        this.k = aVar.k;
        e();
    }

    public a(a aVar, g.a.a.v vVar) {
        this.f14433a = new k(new m(vVar));
        this.f14434b = aVar.f14434b;
        this.f14436d = aVar.f14436d;
        this.f14437e = aVar.f14437e;
        ArrayList arrayList = new ArrayList();
        this.f14438f = arrayList;
        arrayList.addAll(aVar.f14438f);
        this.f14439g = new TreeMap();
        for (Integer num : aVar.f14439g.keySet()) {
            this.f14439g.put(num, (LinkedList) aVar.f14439g.get(num).clone());
        }
        Stack<u> stack = new Stack<>();
        this.f14440h = stack;
        stack.addAll(aVar.f14440h);
        this.f14435c = new ArrayList();
        Iterator<c> it = aVar.f14435c.iterator();
        while (it.hasNext()) {
            this.f14435c.add(it.next().clone());
        }
        this.f14441i = new TreeMap(aVar.f14441i);
        this.j = aVar.j;
        this.l = aVar.l;
        this.k = aVar.k;
        e();
    }

    public a(a aVar, byte[] bArr, byte[] bArr2, j jVar) {
        this.f14433a = new k(aVar.f14433a.d());
        this.f14434b = aVar.f14434b;
        this.f14436d = aVar.f14436d;
        this.f14437e = aVar.f14437e;
        ArrayList arrayList = new ArrayList();
        this.f14438f = arrayList;
        arrayList.addAll(aVar.f14438f);
        this.f14439g = new TreeMap();
        for (Integer num : aVar.f14439g.keySet()) {
            this.f14439g.put(num, (LinkedList) aVar.f14439g.get(num).clone());
        }
        Stack<u> stack = new Stack<>();
        this.f14440h = stack;
        stack.addAll(aVar.f14440h);
        this.f14435c = new ArrayList();
        Iterator<c> it = aVar.f14435c.iterator();
        while (it.hasNext()) {
            this.f14435c.add(it.next().clone());
        }
        this.f14441i = new TreeMap(aVar.f14441i);
        this.j = aVar.j;
        this.l = aVar.l;
        this.k = false;
        d(bArr, bArr2, jVar);
    }

    public a(k kVar, int i2, int i3, int i4) {
        this.f14433a = kVar;
        this.f14434b = i2;
        this.l = i4;
        this.f14436d = i3;
        if (i3 <= i2 && i3 >= 2) {
            int i5 = i2 - i3;
            if (i5 % 2 == 0) {
                this.f14438f = new ArrayList();
                this.f14439g = new TreeMap();
                this.f14440h = new Stack<>();
                this.f14435c = new ArrayList();
                for (int i6 = 0; i6 < i5; i6++) {
                    this.f14435c.add(new c(i6));
                }
                this.f14441i = new TreeMap();
                this.j = 0;
                this.k = false;
                return;
            }
        }
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    public a(x xVar, int i2, int i3) {
        this(xVar.f(), xVar.getHeight(), xVar.b(), i3);
        this.l = i2;
        this.j = i3;
        this.k = true;
    }

    public a(x xVar, byte[] bArr, byte[] bArr2, j jVar) {
        this(xVar.f(), xVar.getHeight(), xVar.b(), (1 << xVar.getHeight()) - 1);
        c(bArr, bArr2, jVar);
    }

    public a(x xVar, byte[] bArr, byte[] bArr2, j jVar, int i2) {
        this(xVar.f(), xVar.getHeight(), xVar.b(), (1 << xVar.getHeight()) - 1);
        c(bArr, bArr2, jVar);
        while (this.j < i2) {
            d(bArr, bArr2, jVar);
            this.k = false;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.l = objectInputStream.available() != 0 ? objectInputStream.readInt() : (1 << this.f14434b) - 1;
        int i2 = this.l;
        if (i2 > (1 << this.f14434b) - 1 || this.j > i2 + 1 || objectInputStream.available() != 0) {
            throw new IOException("inconsistent BDS data detected");
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.l);
    }

    public final c a() {
        c cVar = null;
        for (c cVar2 : this.f14435c) {
            if (!cVar2.d() && cVar2.e() && (cVar == null || cVar2.getHeight() < cVar.getHeight() || (cVar2.getHeight() == cVar.getHeight() && cVar2.b() < cVar.b()))) {
                cVar = cVar2;
            }
        }
        return cVar;
    }

    public int b() {
        return this.j;
    }

    public final void c(byte[] bArr, byte[] bArr2, j jVar) {
        Objects.requireNonNull(jVar, "otsHashAddress == null");
        i iVar = (i) new i.b().g(jVar.a()).h(jVar.b()).l();
        g gVar = (g) new g.b().g(jVar.a()).h(jVar.b()).k();
        for (int i2 = 0; i2 < (1 << this.f14434b); i2++) {
            jVar = (j) new j.b().g(jVar.a()).h(jVar.b()).p(i2).n(jVar.d()).o(jVar.e()).f(jVar.getKeyAndMask()).l();
            k kVar = this.f14433a;
            kVar.h(kVar.g(bArr2, jVar), bArr);
            n nVarE = this.f14433a.e(jVar);
            iVar = (i) new i.b().g(iVar.a()).h(iVar.b()).n(i2).o(iVar.e()).p(iVar.f()).f(iVar.getKeyAndMask()).l();
            u uVarA = v.a(this.f14433a, nVarE, iVar);
            gVar = (g) new g.b().g(gVar.a()).h(gVar.b()).n(i2).f(gVar.getKeyAndMask()).k();
            while (!this.f14440h.isEmpty() && this.f14440h.peek().getHeight() == uVarA.getHeight()) {
                int height = i2 / (1 << uVarA.getHeight());
                if (height == 1) {
                    this.f14438f.add(uVarA);
                }
                if (height == 3 && uVarA.getHeight() < this.f14434b - this.f14436d) {
                    this.f14435c.get(uVarA.getHeight()).f(uVarA);
                }
                if (height >= 3 && (height & 1) == 1 && uVarA.getHeight() >= this.f14434b - this.f14436d && uVarA.getHeight() <= this.f14434b - 2) {
                    if (this.f14439g.get(Integer.valueOf(uVarA.getHeight())) == null) {
                        LinkedList<u> linkedList = new LinkedList<>();
                        linkedList.add(uVarA);
                        this.f14439g.put(Integer.valueOf(uVarA.getHeight()), linkedList);
                    } else {
                        this.f14439g.get(Integer.valueOf(uVarA.getHeight())).add(uVarA);
                    }
                }
                g gVar2 = (g) new g.b().g(gVar.a()).h(gVar.b()).m(gVar.d()).n((gVar.e() - 1) / 2).f(gVar.getKeyAndMask()).k();
                u uVarB = v.b(this.f14433a, this.f14440h.pop(), uVarA, gVar2);
                u uVar = new u(uVarB.getHeight() + 1, uVarB.getValue());
                gVar = (g) new g.b().g(gVar2.a()).h(gVar2.b()).m(gVar2.d() + 1).n(gVar2.e()).f(gVar2.getKeyAndMask()).k();
                uVarA = uVar;
            }
            this.f14440h.push(uVarA);
        }
        this.f14437e = this.f14440h.pop();
    }

    public final void d(byte[] bArr, byte[] bArr2, j jVar) {
        List<u> list;
        u uVarRemoveFirst;
        Objects.requireNonNull(jVar, "otsHashAddress == null");
        if (this.k) {
            throw new IllegalStateException("index already used");
        }
        int i2 = this.j;
        if (i2 > this.l - 1) {
            throw new IllegalStateException("index out of bounds");
        }
        int iCalculateTau = a0.calculateTau(i2, this.f14434b);
        if (((this.j >> (iCalculateTau + 1)) & 1) == 0 && iCalculateTau < this.f14434b - 1) {
            this.f14441i.put(Integer.valueOf(iCalculateTau), this.f14438f.get(iCalculateTau));
        }
        i iVar = (i) new i.b().g(jVar.a()).h(jVar.b()).l();
        g gVar = (g) new g.b().g(jVar.a()).h(jVar.b()).k();
        if (iCalculateTau == 0) {
            jVar = (j) new j.b().g(jVar.a()).h(jVar.b()).p(this.j).n(jVar.d()).o(jVar.e()).f(jVar.getKeyAndMask()).l();
            k kVar = this.f14433a;
            kVar.h(kVar.g(bArr2, jVar), bArr);
            this.f14438f.set(0, v.a(this.f14433a, this.f14433a.e(jVar), (i) new i.b().g(iVar.a()).h(iVar.b()).n(this.j).o(iVar.e()).p(iVar.f()).f(iVar.getKeyAndMask()).l()));
        } else {
            int i3 = iCalculateTau - 1;
            g gVar2 = (g) new g.b().g(gVar.a()).h(gVar.b()).m(i3).n(this.j >> iCalculateTau).f(gVar.getKeyAndMask()).k();
            k kVar2 = this.f14433a;
            kVar2.h(kVar2.g(bArr2, jVar), bArr);
            u uVarB = v.b(this.f14433a, this.f14438f.get(i3), this.f14441i.get(Integer.valueOf(i3)), gVar2);
            this.f14438f.set(iCalculateTau, new u(uVarB.getHeight() + 1, uVarB.getValue()));
            this.f14441i.remove(Integer.valueOf(i3));
            for (int i4 = 0; i4 < iCalculateTau; i4++) {
                if (i4 < this.f14434b - this.f14436d) {
                    list = this.f14438f;
                    uVarRemoveFirst = this.f14435c.get(i4).getTailNode();
                } else {
                    list = this.f14438f;
                    uVarRemoveFirst = this.f14439g.get(Integer.valueOf(i4)).removeFirst();
                }
                list.set(i4, uVarRemoveFirst);
            }
            int iMin = Math.min(iCalculateTau, this.f14434b - this.f14436d);
            for (int i5 = 0; i5 < iMin; i5++) {
                int i6 = this.j + 1 + ((1 << i5) * 3);
                if (i6 < (1 << this.f14434b)) {
                    this.f14435c.get(i5).c(i6);
                }
            }
        }
        for (int i7 = 0; i7 < ((this.f14434b - this.f14436d) >> 1); i7++) {
            c cVarA = a();
            if (cVarA != null) {
                cVarA.g(this.f14440h, this.f14433a, bArr, bArr2, jVar);
            }
        }
        this.j++;
    }

    public final void e() {
        if (this.f14438f == null) {
            throw new IllegalStateException("authenticationPath == null");
        }
        if (this.f14439g == null) {
            throw new IllegalStateException("retain == null");
        }
        if (this.f14440h == null) {
            throw new IllegalStateException("stack == null");
        }
        if (this.f14435c == null) {
            throw new IllegalStateException("treeHashInstances == null");
        }
        if (this.f14441i == null) {
            throw new IllegalStateException("keep == null");
        }
        if (!a0.isIndexValid(this.f14434b, this.j)) {
            throw new IllegalStateException("index in BDS state out of bounds");
        }
    }

    public int getMaxIndex() {
        return this.l;
    }

    public a getNextState(byte[] bArr, byte[] bArr2, j jVar) {
        return new a(this, bArr, bArr2, jVar);
    }

    public a withMaxIndex(int i2, g.a.a.v vVar) {
        return new a(this, i2, vVar);
    }

    public a withWOTSDigest(g.a.a.v vVar) {
        return new a(this, vVar);
    }
}

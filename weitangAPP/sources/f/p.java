package f;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f13024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p f13025g;

    public p() {
        this.f13019a = new byte[8192];
        this.f13023e = true;
        this.f13022d = false;
    }

    public p a() {
        this.f13022d = true;
        return new p(this.f13019a, this.f13020b, this.f13021c, true, false);
    }

    public p b() {
        return new p((byte[]) this.f13019a.clone(), this.f13020b, this.f13021c, false, true);
    }

    public void compact() {
        p pVar = this.f13025g;
        if (pVar == this) {
            throw new IllegalStateException();
        }
        if (pVar.f13023e) {
            int i2 = this.f13021c - this.f13020b;
            if (i2 > (8192 - pVar.f13021c) + (pVar.f13022d ? 0 : pVar.f13020b)) {
                return;
            }
            writeTo(pVar, i2);
            pop();
            q.a(this);
        }
    }

    @Nullable
    public p pop() {
        p pVar = this.f13024f;
        p pVar2 = pVar != this ? pVar : null;
        p pVar3 = this.f13025g;
        pVar3.f13024f = pVar;
        this.f13024f.f13025g = pVar3;
        this.f13024f = null;
        this.f13025g = null;
        return pVar2;
    }

    public p push(p pVar) {
        pVar.f13025g = this;
        pVar.f13024f = this.f13024f;
        this.f13024f.f13025g = pVar;
        this.f13024f = pVar;
        return pVar;
    }

    public p split(int i2) {
        p pVarB;
        if (i2 <= 0 || i2 > this.f13021c - this.f13020b) {
            throw new IllegalArgumentException();
        }
        if (i2 >= 1024) {
            pVarB = a();
        } else {
            pVarB = q.b();
            System.arraycopy(this.f13019a, this.f13020b, pVarB.f13019a, 0, i2);
        }
        pVarB.f13021c = pVarB.f13020b + i2;
        this.f13020b += i2;
        this.f13025g.push(pVarB);
        return pVarB;
    }

    public void writeTo(p pVar, int i2) {
        if (!pVar.f13023e) {
            throw new IllegalArgumentException();
        }
        int i3 = pVar.f13021c;
        if (i3 + i2 > 8192) {
            if (pVar.f13022d) {
                throw new IllegalArgumentException();
            }
            int i4 = pVar.f13020b;
            if ((i3 + i2) - i4 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = pVar.f13019a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            pVar.f13021c -= pVar.f13020b;
            pVar.f13020b = 0;
        }
        System.arraycopy(this.f13019a, this.f13020b, pVar.f13019a, pVar.f13021c, i2);
        pVar.f13021c += i2;
        this.f13020b += i2;
    }

    public p(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f13019a = bArr;
        this.f13020b = i2;
        this.f13021c = i3;
        this.f13022d = z;
        this.f13023e = z2;
    }
}

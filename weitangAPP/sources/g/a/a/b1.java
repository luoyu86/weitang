package g.a.a;

import java.io.IOException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class b1 extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w[] f13041e;

    public class a implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13042a = 0;

        public a() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f13042a < b1.this.f13393c.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            int i2 = this.f13042a;
            b1 b1Var = b1.this;
            byte[] bArr = b1Var.f13393c;
            if (i2 >= bArr.length) {
                throw new NoSuchElementException();
            }
            int iMin = Math.min(bArr.length - i2, b1Var.f13040d);
            byte[] bArr2 = new byte[iMin];
            System.arraycopy(b1.this.f13393c, this.f13042a, bArr2, 0, iMin);
            this.f13042a += iMin;
            return new x1(bArr2);
        }
    }

    public class b implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13044a = 0;

        public b() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f13044a < b1.this.f13041e.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            if (this.f13044a >= b1.this.f13041e.length) {
                throw new NoSuchElementException();
            }
            w[] wVarArr = b1.this.f13041e;
            int i2 = this.f13044a;
            this.f13044a = i2 + 1;
            return wVarArr[i2];
        }
    }

    public b1(byte[] bArr) {
        this(bArr, 1000);
    }

    public b1(byte[] bArr, int i2) {
        this(bArr, null, i2);
    }

    public b1(byte[] bArr, w[] wVarArr, int i2) {
        super(bArr);
        this.f13041e = wVarArr;
        this.f13040d = i2;
    }

    public b1(w[] wVarArr) {
        this(wVarArr, 1000);
    }

    public b1(w[] wVarArr, int i2) {
        this(j(wVarArr), wVarArr, i2);
    }

    public static byte[] j(w[] wVarArr) {
        int length = wVarArr.length;
        if (length == 0) {
            return w.f13392b;
        }
        if (length == 1) {
            return wVarArr[0].f13393c;
        }
        int length2 = 0;
        for (w wVar : wVarArr) {
            length2 += wVar.f13393c.length;
        }
        byte[] bArr = new byte[length2];
        int length3 = 0;
        for (w wVar2 : wVarArr) {
            byte[] bArr2 = wVar2.f13393c;
            System.arraycopy(bArr2, 0, bArr, length3, bArr2.length);
            length3 += bArr2.length;
        }
        return bArr;
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        if (!c()) {
            byte[] bArr = this.f13393c;
            x1.h(yVar, z, bArr, 0, bArr.length);
            return;
        }
        yVar.q(z, 36);
        yVar.g(128);
        w[] wVarArr = this.f13041e;
        if (wVarArr == null) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = this.f13393c;
                if (i2 >= bArr2.length) {
                    break;
                }
                int iMin = Math.min(bArr2.length - i2, this.f13040d);
                x1.h(yVar, true, this.f13393c, i2, iMin);
                i2 += iMin;
            }
        } else {
            yVar.t(wVarArr);
        }
        yVar.g(0);
        yVar.g(0);
    }

    @Override // g.a.a.a0
    public boolean c() {
        return this.f13041e != null || this.f13393c.length > this.f13040d;
    }

    @Override // g.a.a.a0
    public int d(boolean z) throws IOException {
        if (!c()) {
            return x1.i(z, this.f13393c.length);
        }
        int iD = z ? 4 : 3;
        if (this.f13041e == null) {
            int length = this.f13393c.length;
            int i2 = this.f13040d;
            int i3 = length / i2;
            int i4 = iD + (x1.i(true, i2) * i3);
            int length2 = this.f13393c.length - (i3 * this.f13040d);
            return length2 > 0 ? i4 + x1.i(true, length2) : i4;
        }
        int i5 = 0;
        while (true) {
            w[] wVarArr = this.f13041e;
            if (i5 >= wVarArr.length) {
                return iD;
            }
            iD += wVarArr[i5].d(true);
            i5++;
        }
    }

    public Enumeration getObjects() {
        return this.f13041e == null ? new a() : new b();
    }
}

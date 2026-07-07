package g.a.a;

import g.a.j.a;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f0 extends a0 implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13073a = new a(f0.class, 17);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g[] f13074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f13075c;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 c(d0 d0Var) {
            return d0Var.l();
        }
    }

    public class b implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13076a = 0;

        public b() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f13076a < f0.this.f13074b.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            int i2 = this.f13076a;
            g[] gVarArr = f0.this.f13074b;
            if (i2 >= gVarArr.length) {
                throw new NoSuchElementException();
            }
            this.f13076a = i2 + 1;
            return gVarArr[i2];
        }
    }

    public class c implements g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13078a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f13079b;

        public c(int i2) {
            this.f13079b = i2;
        }

        @Override // g.a.a.g0, g.a.a.y2
        public a0 getLoadedObject() {
            return f0.this;
        }

        @Override // g.a.a.g0
        public g readObject() throws IOException {
            int i2 = this.f13079b;
            int i3 = this.f13078a;
            if (i2 == i3) {
                return null;
            }
            g[] gVarArr = f0.this.f13074b;
            this.f13078a = i3 + 1;
            g gVar = gVarArr[i3];
            return gVar instanceof d0 ? ((d0) gVar).parser() : gVar instanceof f0 ? ((f0) gVar).parser() : gVar;
        }

        @Override // g.a.a.g0, g.a.a.g
        public a0 toASN1Primitive() {
            return f0.this;
        }
    }

    public f0() {
        this.f13074b = h.f13097a;
        this.f13075c = true;
    }

    public f0(g gVar) {
        Objects.requireNonNull(gVar, "'element' cannot be null");
        this.f13074b = new g[]{gVar};
        this.f13075c = true;
    }

    public f0(h hVar, boolean z) {
        g[] gVarArrE;
        Objects.requireNonNull(hVar, "'elementVector' cannot be null");
        if (!z || hVar.size() < 2) {
            gVarArrE = hVar.e();
        } else {
            gVarArrE = hVar.b();
            i(gVarArrE);
        }
        this.f13074b = gVarArrE;
        this.f13075c = z || gVarArrE.length < 2;
    }

    public f0(boolean z, g[] gVarArr) {
        this.f13074b = gVarArr;
        this.f13075c = z || gVarArr.length < 2;
    }

    public f0(g[] gVarArr, boolean z) {
        if (g.a.j.a.isNullOrContainsNull(gVarArr)) {
            throw new NullPointerException("'elements' cannot be null, or contain null");
        }
        g[] gVarArrA = h.a(gVarArr);
        if (z && gVarArrA.length >= 2) {
            i(gVarArrA);
        }
        this.f13074b = gVarArrA;
        this.f13075c = z || gVarArrA.length < 2;
    }

    public static byte[] g(g gVar) {
        try {
            return gVar.toASN1Primitive().getEncoded("DER");
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    public static f0 getInstance(l0 l0Var, boolean z) {
        return (f0) f13073a.e(l0Var, z);
    }

    public static f0 getInstance(Object obj) {
        if (obj == null || (obj instanceof f0)) {
            return (f0) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof f0) {
                return (f0) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (f0) f13073a.b((byte[]) obj);
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct set from byte[]: " + e2.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static boolean h(byte[] bArr, byte[] bArr2) {
        int i2 = bArr[0] & (-33);
        int i3 = bArr2[0] & (-33);
        if (i2 != i3) {
            return i2 < i3;
        }
        int iMin = Math.min(bArr.length, bArr2.length) - 1;
        for (int i4 = 1; i4 < iMin; i4++) {
            if (bArr[i4] != bArr2[i4]) {
                return (bArr[i4] & 255) < (bArr2[i4] & 255);
            }
        }
        return (bArr[iMin] & 255) <= (bArr2[iMin] & 255);
    }

    public static void i(g[] gVarArr) {
        int length = gVarArr.length;
        if (length < 2) {
            return;
        }
        g gVar = gVarArr[0];
        g gVar2 = gVarArr[1];
        byte[] bArrG = g(gVar);
        byte[] bArrG2 = g(gVar2);
        if (h(bArrG2, bArrG)) {
            gVar2 = gVar;
            gVar = gVar2;
            bArrG2 = bArrG;
            bArrG = bArrG2;
        }
        for (int i2 = 2; i2 < length; i2++) {
            g gVar3 = gVarArr[i2];
            byte[] bArrG3 = g(gVar3);
            if (h(bArrG2, bArrG3)) {
                gVarArr[i2 - 2] = gVar;
                gVar = gVar2;
                bArrG = bArrG2;
                gVar2 = gVar3;
                bArrG2 = bArrG3;
            } else if (h(bArrG, bArrG3)) {
                gVarArr[i2 - 2] = gVar;
                gVar = gVar3;
                bArrG = bArrG3;
            } else {
                int i3 = i2 - 1;
                while (true) {
                    i3--;
                    if (i3 <= 0) {
                        break;
                    }
                    g gVar4 = gVarArr[i3 - 1];
                    if (h(g(gVar4), bArrG3)) {
                        break;
                    } else {
                        gVarArr[i3] = gVar4;
                    }
                }
                gVarArr[i3] = gVar3;
            }
        }
        gVarArr[length - 2] = gVar;
        gVarArr[length - 1] = gVar2;
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        if (!(a0Var instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) a0Var;
        int size = size();
        if (f0Var.size() != size) {
            return false;
        }
        c2 c2Var = (c2) e();
        c2 c2Var2 = (c2) f0Var.e();
        for (int i2 = 0; i2 < size; i2++) {
            a0 aSN1Primitive = c2Var.f13074b[i2].toASN1Primitive();
            a0 aSN1Primitive2 = c2Var2.f13074b[i2].toASN1Primitive();
            if (aSN1Primitive != aSN1Primitive2 && !aSN1Primitive.a(aSN1Primitive2)) {
                return false;
            }
        }
        return true;
    }

    @Override // g.a.a.a0
    public boolean c() {
        return true;
    }

    @Override // g.a.a.a0
    public a0 e() {
        g[] gVarArr;
        if (this.f13075c) {
            gVarArr = this.f13074b;
        } else {
            gVarArr = (g[]) this.f13074b.clone();
            i(gVarArr);
        }
        return new c2(true, gVarArr);
    }

    @Override // g.a.a.a0
    public a0 f() {
        return new s2(this.f13075c, this.f13074b);
    }

    public g getObjectAt(int i2) {
        return this.f13074b[i2];
    }

    public Enumeration getObjects() {
        return new b();
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        int length = this.f13074b.length;
        int iHashCode = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return iHashCode;
            }
            iHashCode += this.f13074b[length].toASN1Primitive().hashCode();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<g> iterator() {
        return new a.C0263a(toArray());
    }

    public g0 parser() {
        return new c(size());
    }

    public int size() {
        return this.f13074b.length;
    }

    public g[] toArray() {
        return h.a(this.f13074b);
    }

    public String toString() {
        int size = size();
        if (size == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        int i2 = 0;
        while (true) {
            stringBuffer.append(this.f13074b[i2]);
            i2++;
            if (i2 >= size) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }
}

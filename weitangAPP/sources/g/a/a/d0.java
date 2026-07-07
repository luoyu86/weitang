package g.a.a;

import androidx.core.view.InputDeviceCompat;
import g.a.j.a;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d0 extends a0 implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13058a = new a(d0.class, 16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g[] f13059b;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 c(d0 d0Var) {
            return d0Var;
        }
    }

    public class b implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13060a = 0;

        public b() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f13060a < d0.this.f13059b.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            int i2 = this.f13060a;
            g[] gVarArr = d0.this.f13059b;
            if (i2 >= gVarArr.length) {
                throw new NoSuchElementException();
            }
            this.f13060a = i2 + 1;
            return gVarArr[i2];
        }
    }

    public class c implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13062a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f13063b;

        public c(int i2) {
            this.f13063b = i2;
        }

        @Override // g.a.a.e0, g.a.a.y2
        public a0 getLoadedObject() {
            return d0.this;
        }

        @Override // g.a.a.e0
        public g readObject() throws IOException {
            int i2 = this.f13063b;
            int i3 = this.f13062a;
            if (i2 == i3) {
                return null;
            }
            g[] gVarArr = d0.this.f13059b;
            this.f13062a = i3 + 1;
            g gVar = gVarArr[i3];
            return gVar instanceof d0 ? ((d0) gVar).parser() : gVar instanceof f0 ? ((f0) gVar).parser() : gVar;
        }

        @Override // g.a.a.e0, g.a.a.g
        public a0 toASN1Primitive() {
            return d0.this;
        }
    }

    public d0() {
        this.f13059b = h.f13097a;
    }

    public d0(g gVar) {
        Objects.requireNonNull(gVar, "'element' cannot be null");
        this.f13059b = new g[]{gVar};
    }

    public d0(h hVar) {
        Objects.requireNonNull(hVar, "'elementVector' cannot be null");
        this.f13059b = hVar.e();
    }

    public d0(g[] gVarArr) {
        if (g.a.j.a.isNullOrContainsNull(gVarArr)) {
            throw new NullPointerException("'elements' cannot be null, or contain null");
        }
        this.f13059b = h.a(gVarArr);
    }

    public d0(g[] gVarArr, boolean z) {
        this.f13059b = z ? h.a(gVarArr) : gVarArr;
    }

    public static d0 getInstance(l0 l0Var, boolean z) {
        return (d0) f13058a.e(l0Var, z);
    }

    public static d0 getInstance(Object obj) {
        if (obj == null || (obj instanceof d0)) {
            return (d0) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof d0) {
                return (d0) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (d0) f13058a.b((byte[]) obj);
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e2.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        if (!(a0Var instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) a0Var;
        int size = size();
        if (d0Var.size() != size) {
            return false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            a0 aSN1Primitive = this.f13059b[i2].toASN1Primitive();
            a0 aSN1Primitive2 = d0Var.f13059b[i2].toASN1Primitive();
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
        return new b2(this.f13059b, false);
    }

    @Override // g.a.a.a0
    public a0 f() {
        return new q2(this.f13059b, false);
    }

    public g.a.a.c[] g() {
        int size = size();
        g.a.a.c[] cVarArr = new g.a.a.c[size];
        for (int i2 = 0; i2 < size; i2++) {
            cVarArr[i2] = g.a.a.c.getInstance(this.f13059b[i2]);
        }
        return cVarArr;
    }

    public g getObjectAt(int i2) {
        return this.f13059b[i2];
    }

    public Enumeration getObjects() {
        return new b();
    }

    public w[] h() {
        int size = size();
        w[] wVarArr = new w[size];
        for (int i2 = 0; i2 < size; i2++) {
            wVarArr[i2] = w.getInstance(this.f13059b[i2]);
        }
        return wVarArr;
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        int length = this.f13059b.length;
        int iHashCode = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return iHashCode;
            }
            iHashCode = (iHashCode * InputDeviceCompat.SOURCE_KEYBOARD) ^ this.f13059b[length].toASN1Primitive().hashCode();
        }
    }

    public abstract g.a.a.c i();

    public Iterator<g> iterator() {
        return new a.C0263a(this.f13059b);
    }

    public abstract k j();

    public abstract w k();

    public abstract f0 l();

    public g[] m() {
        return this.f13059b;
    }

    public e0 parser() {
        return new c(size());
    }

    public int size() {
        return this.f13059b.length;
    }

    public g[] toArray() {
        return h.a(this.f13059b);
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
            stringBuffer.append(this.f13059b[i2]);
            i2++;
            if (i2 >= size) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }
}

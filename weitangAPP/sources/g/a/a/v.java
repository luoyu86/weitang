package g.a.a;

import com.alibaba.android.arouter.utils.Consts;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public class v extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13360a = new a(v.class, 6);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentMap<b, v> f13361b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f13363d;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return v.g(x1Var.getOctets(), false);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f13365b;

        public b(byte[] bArr) {
            this.f13364a = g.a.j.a.hashCode(bArr);
            this.f13365b = bArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return g.a.j.a.areEqual(this.f13365b, ((b) obj).f13365b);
            }
            return false;
        }

        public int hashCode() {
            return this.f13364a;
        }
    }

    public v(v vVar, String str) {
        if (!c0.i(str, 0)) {
            throw new IllegalArgumentException("string " + str + " not a valid OID branch");
        }
        this.f13362c = vVar.getId() + Consts.DOT + str;
    }

    public v(String str) {
        Objects.requireNonNull(str, "'identifier' cannot be null");
        if (i(str)) {
            this.f13362c = str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not an OID");
    }

    public v(byte[] bArr, boolean z) {
        byte[] bArr2 = bArr;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z2 = true;
        long j = 0;
        BigInteger bigIntegerShiftLeft = null;
        for (int i2 = 0; i2 != bArr2.length; i2++) {
            int i3 = bArr2[i2] & 255;
            if (j <= 72057594037927808L) {
                long j2 = j + ((long) (i3 & 127));
                if ((i3 & 128) == 0) {
                    if (z2) {
                        if (j2 < 40) {
                            stringBuffer.append('0');
                        } else if (j2 < 80) {
                            stringBuffer.append('1');
                            j2 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j2 -= 80;
                        }
                        z2 = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                    j = 0;
                } else {
                    j = j2 << 7;
                }
            } else {
                BigInteger bigIntegerOr = (bigIntegerShiftLeft == null ? BigInteger.valueOf(j) : bigIntegerShiftLeft).or(BigInteger.valueOf(i3 & 127));
                if ((i3 & 128) == 0) {
                    if (z2) {
                        stringBuffer.append('2');
                        bigIntegerOr = bigIntegerOr.subtract(BigInteger.valueOf(80L));
                        z2 = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(bigIntegerOr);
                    j = 0;
                    bigIntegerShiftLeft = null;
                } else {
                    bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                }
            }
        }
        this.f13362c = stringBuffer.toString();
        this.f13363d = z ? g.a.j.a.clone(bArr) : bArr2;
    }

    public static v fromContents(byte[] bArr) {
        return g(bArr, true);
    }

    public static v g(byte[] bArr, boolean z) {
        v vVar = f13361b.get(new b(bArr));
        return vVar == null ? new v(bArr, z) : vVar;
    }

    public static v getInstance(l0 l0Var, boolean z) {
        if (!z && !l0Var.m()) {
            a0 object = l0Var.getObject();
            if (!(object instanceof v)) {
                return fromContents(w.getInstance(object).getOctets());
            }
        }
        return (v) f13360a.e(l0Var, z);
    }

    public static v getInstance(Object obj) {
        if (obj == null || (obj instanceof v)) {
            return (v) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof v) {
                return (v) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (v) f13360a.b((byte[]) obj);
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + e2.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static boolean i(String str) {
        char cCharAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (cCharAt = str.charAt(0)) < '0' || cCharAt > '2') {
            return false;
        }
        return c0.i(str, 2);
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        if (a0Var == this) {
            return true;
        }
        if (a0Var instanceof v) {
            return this.f13362c.equals(((v) a0Var).f13362c);
        }
        return false;
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 6, getContents());
    }

    public v branch(String str) {
        return new v(this, str);
    }

    @Override // g.a.a.a0
    public boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public int d(boolean z) {
        return y.e(z, getContents().length);
    }

    public final synchronized byte[] getContents() {
        if (this.f13363d == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            h(byteArrayOutputStream);
            this.f13363d = byteArrayOutputStream.toByteArray();
        }
        return this.f13363d;
    }

    public String getId() {
        return this.f13362c;
    }

    public final void h(ByteArrayOutputStream byteArrayOutputStream) {
        d3 d3Var = new d3(this.f13362c);
        int i2 = Integer.parseInt(d3Var.nextToken()) * 40;
        String strNextToken = d3Var.nextToken();
        if (strNextToken.length() <= 18) {
            c0.j(byteArrayOutputStream, ((long) i2) + Long.parseLong(strNextToken));
        } else {
            c0.k(byteArrayOutputStream, new BigInteger(strNextToken).add(BigInteger.valueOf(i2)));
        }
        while (d3Var.hasMoreTokens()) {
            String strNextToken2 = d3Var.nextToken();
            if (strNextToken2.length() <= 18) {
                c0.j(byteArrayOutputStream, Long.parseLong(strNextToken2));
            } else {
                c0.k(byteArrayOutputStream, new BigInteger(strNextToken2));
            }
        }
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        return this.f13362c.hashCode();
    }

    public v intern() {
        b bVar = new b(getContents());
        ConcurrentMap<b, v> concurrentMap = f13361b;
        v vVar = concurrentMap.get(bVar);
        if (vVar != null) {
            return vVar;
        }
        v vVarPutIfAbsent = concurrentMap.putIfAbsent(bVar, this);
        return vVarPutIfAbsent == null ? this : vVarPutIfAbsent;
    }

    public boolean on(v vVar) {
        String id = getId();
        String id2 = vVar.getId();
        return id.length() > id2.length() && id.charAt(id2.length()) == '.' && id.startsWith(id2);
    }

    public String toString() {
        return getId();
    }
}

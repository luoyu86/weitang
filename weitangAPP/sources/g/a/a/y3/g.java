package g.a.a.y3;

import com.alibaba.android.arouter.utils.Consts;
import g.a.a.a0;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.l0;
import g.a.a.u1;
import g.a.a.x1;
import java.io.IOException;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class g extends g.a.a.t implements g.a.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.g f13474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13475b;

    public g(int i2, g.a.a.g gVar) {
        this.f13474a = gVar;
        this.f13475b = i2;
    }

    public g(int i2, String str) {
        g.a.a.g u1Var;
        this.f13475b = i2;
        if (i2 == 1 || i2 == 2 || i2 == 6) {
            u1Var = new u1(str);
        } else if (i2 == 8) {
            u1Var = new g.a.a.v(str);
        } else {
            if (i2 != 4) {
                if (i2 != 7) {
                    throw new IllegalArgumentException("can't process String for tag: " + i2);
                }
                byte[] bArrF = f(str);
                if (bArrF == null) {
                    throw new IllegalArgumentException("IP Address is invalid");
                }
                this.f13474a = new x1(bArrF);
                return;
            }
            u1Var = new g.a.a.x3.c(str);
        }
        this.f13474a = u1Var;
    }

    public g(g.a.a.x3.c cVar) {
        this.f13474a = cVar;
        this.f13475b = 4;
    }

    public g(u uVar) {
        this.f13474a = g.a.a.x3.c.getInstance(uVar);
        this.f13475b = 4;
    }

    public static g getInstance(l0 l0Var, boolean z) {
        return getInstance(l0.getInstance(l0Var, true));
    }

    public static g getInstance(Object obj) {
        if (obj == null || (obj instanceof g)) {
            return (g) obj;
        }
        if (!(obj instanceof l0)) {
            if (obj instanceof byte[]) {
                try {
                    return getInstance(a0.fromByteArray((byte[]) obj));
                } catch (IOException unused) {
                    throw new IllegalArgumentException("unable to parse encoded general name");
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
        l0 l0Var = (l0) obj;
        int tagNo = l0Var.getTagNo();
        switch (tagNo) {
            case 0:
            case 3:
            case 5:
                return new g(tagNo, d0.getInstance(l0Var, false));
            case 1:
            case 2:
            case 6:
                return new g(tagNo, g.a.a.o.getInstance(l0Var, false));
            case 4:
                return new g(tagNo, g.a.a.x3.c.getInstance(l0Var, true));
            case 7:
                return new g(tagNo, g.a.a.w.getInstance(l0Var, false));
            case 8:
                return new g(tagNo, g.a.a.v.getInstance(l0Var, false));
            default:
                throw new IllegalArgumentException("unknown tag: " + tagNo);
        }
    }

    public final void a(int[] iArr, byte[] bArr, int i2) {
        for (int i3 = 0; i3 != iArr.length; i3++) {
            int i4 = i3 * 2;
            bArr[i4 + i2] = (byte) (iArr[i3] >> 8);
            bArr[i4 + 1 + i2] = (byte) iArr[i3];
        }
    }

    public final void b(String str, byte[] bArr, int i2) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "./");
        int i3 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            bArr[i3 + i2] = (byte) Integer.parseInt(stringTokenizer.nextToken());
            i3++;
        }
    }

    public final void c(String str, byte[] bArr, int i2) {
        int i3 = Integer.parseInt(str);
        for (int i4 = 0; i4 != i3; i4++) {
            int i5 = (i4 / 8) + i2;
            bArr[i5] = (byte) (bArr[i5] | (1 << (7 - (i4 % 8))));
        }
    }

    public final int[] d(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ":", true);
        int[] iArr = new int[8];
        if (str.charAt(0) == ':' && str.charAt(1) == ':') {
            stringTokenizer.nextToken();
        }
        int i2 = -1;
        int i3 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (strNextToken.equals(":")) {
                iArr[i3] = 0;
                int i4 = i3;
                i3++;
                i2 = i4;
            } else if (strNextToken.indexOf(46) < 0) {
                int i5 = i3 + 1;
                iArr[i3] = Integer.parseInt(strNextToken, 16);
                if (stringTokenizer.hasMoreTokens()) {
                    stringTokenizer.nextToken();
                }
                i3 = i5;
            } else {
                StringTokenizer stringTokenizer2 = new StringTokenizer(strNextToken, Consts.DOT);
                int i6 = i3 + 1;
                iArr[i3] = (Integer.parseInt(stringTokenizer2.nextToken()) << 8) | Integer.parseInt(stringTokenizer2.nextToken());
                i3 = i6 + 1;
                iArr[i6] = Integer.parseInt(stringTokenizer2.nextToken()) | (Integer.parseInt(stringTokenizer2.nextToken()) << 8);
            }
        }
        if (i3 != 8) {
            int i7 = i3 - i2;
            int i8 = 8 - i7;
            System.arraycopy(iArr, i2, iArr, i8, i7);
            while (i2 != i8) {
                iArr[i2] = 0;
                i2++;
            }
        }
        return iArr;
    }

    public final int[] e(String str) {
        int[] iArr = new int[8];
        int i2 = Integer.parseInt(str);
        for (int i3 = 0; i3 != i2; i3++) {
            int i4 = i3 / 16;
            iArr[i4] = iArr[i4] | (1 << (15 - (i3 % 16)));
        }
        return iArr;
    }

    public final byte[] f(String str) {
        if (g.a.j.f.isValidIPv6WithNetmask(str) || g.a.j.f.isValidIPv6(str)) {
            int iIndexOf = str.indexOf(47);
            if (iIndexOf < 0) {
                byte[] bArr = new byte[16];
                a(d(str), bArr, 0);
                return bArr;
            }
            byte[] bArr2 = new byte[32];
            a(d(str.substring(0, iIndexOf)), bArr2, 0);
            String strSubstring = str.substring(iIndexOf + 1);
            a(strSubstring.indexOf(58) > 0 ? d(strSubstring) : e(strSubstring), bArr2, 16);
            return bArr2;
        }
        if (!g.a.j.f.isValidIPv4WithNetmask(str) && !g.a.j.f.isValidIPv4(str)) {
            return null;
        }
        int iIndexOf2 = str.indexOf(47);
        if (iIndexOf2 < 0) {
            byte[] bArr3 = new byte[4];
            b(str, bArr3, 0);
            return bArr3;
        }
        byte[] bArr4 = new byte[8];
        b(str.substring(0, iIndexOf2), bArr4, 0);
        String strSubstring2 = str.substring(iIndexOf2 + 1);
        if (strSubstring2.indexOf(46) > 0) {
            b(strSubstring2, bArr4, 4);
        } else {
            c(strSubstring2, bArr4, 4);
        }
        return bArr4;
    }

    public g.a.a.g getName() {
        return this.f13474a;
    }

    public int getTagNo() {
        return this.f13475b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        int i2 = this.f13475b;
        return new e2(i2 == 4, i2, this.f13474a);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r3 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            int r1 = r3.f13475b
            r0.append(r1)
            java.lang.String r1 = ": "
            r0.append(r1)
            int r1 = r3.f13475b
            r2 = 1
            if (r1 == r2) goto L2f
            r2 = 2
            if (r1 == r2) goto L2f
            r2 = 4
            if (r1 == r2) goto L24
            r2 = 6
            if (r1 == r2) goto L2f
            g.a.a.g r1 = r3.f13474a
            java.lang.String r1 = r1.toString()
            goto L39
        L24:
            g.a.a.g r1 = r3.f13474a
            g.a.a.x3.c r1 = g.a.a.x3.c.getInstance(r1)
            java.lang.String r1 = r1.toString()
            goto L39
        L2f:
            g.a.a.g r1 = r3.f13474a
            g.a.a.o r1 = g.a.a.o.getInstance(r1)
            java.lang.String r1 = r1.getString()
        L39:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.a.y3.g.toString():java.lang.String");
    }
}

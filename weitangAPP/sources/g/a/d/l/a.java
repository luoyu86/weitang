package g.a.d.l;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.tom_roush.fontbox.ttf.GlyfDescript;
import com.tom_roush.pdfbox.pdfparser.BaseParser;
import g.a.d.d;
import g.a.d.g;
import g.a.d.n.k;
import g.a.d.n.l;
import g.a.j.q;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f13785a = {4, 10, 9, 2, BaseParser.ASCII_CR, 8, 0, 14, 6, 11, 1, 12, 7, 15, 5, 3, 14, 11, 4, 12, 6, BaseParser.ASCII_CR, 15, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, BaseParser.ASCII_CR, 10, 3, 4, 2, 14, 15, 12, 7, 6, 0, 9, 11, 7, BaseParser.ASCII_CR, 10, 1, 0, 8, 9, 15, 14, 4, 6, 12, 11, 2, 5, 3, 6, 12, 7, 1, 5, 15, BaseParser.ASCII_CR, 8, 4, 10, 9, 14, 0, 3, 11, 2, 4, 11, 10, 0, 7, 2, 1, BaseParser.ASCII_CR, 3, 6, 8, 5, 9, 12, 15, 14, BaseParser.ASCII_CR, 11, 4, 1, 3, 15, 5, 9, 0, 10, 14, 7, 6, 8, 2, 12, 1, 15, BaseParser.ASCII_CR, 0, 5, 7, 10, 4, 9, 2, 3, 14, 6, 11, 8, 12};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static byte[] f13786b = {4, 2, 15, 5, 9, 1, 0, 8, 14, 3, 11, 12, BaseParser.ASCII_CR, 7, 10, 6, 12, 9, 15, 14, 8, 1, 3, 10, 2, 7, 4, BaseParser.ASCII_CR, 6, 0, 11, 5, BaseParser.ASCII_CR, 8, 14, 12, 7, 3, 9, 10, 1, 5, 2, 4, 6, 15, 0, 11, 14, 9, 11, 2, 5, 15, 7, 1, 0, BaseParser.ASCII_CR, 12, 6, 10, 4, 3, 8, 3, 14, 5, 9, 6, 8, 0, BaseParser.ASCII_CR, 10, 11, 7, 12, 2, 1, 15, 4, 8, 15, 6, 11, 1, 9, 12, 5, BaseParser.ASCII_CR, 3, 7, 10, 0, 14, 2, 4, 9, 11, 12, 0, 3, 6, 7, 5, 4, 8, 14, 15, 1, 10, 2, BaseParser.ASCII_CR, 12, 6, 5, 2, 11, 0, 9, BaseParser.ASCII_CR, 3, 14, 7, 10, 15, 4, 1, 8};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static byte[] f13787c = {9, 6, 3, 2, 8, 11, 1, 7, 10, 4, 14, 15, 12, 0, BaseParser.ASCII_CR, 5, 3, 7, 14, 9, 8, 10, 15, 0, 5, 2, 6, 12, 11, 4, BaseParser.ASCII_CR, 1, 14, 4, 6, 2, 11, 3, BaseParser.ASCII_CR, 8, 12, 15, 5, 10, 0, 7, 1, 9, 14, 7, 10, 12, BaseParser.ASCII_CR, 1, 3, 9, 0, 2, 11, 4, 15, 8, 5, 6, 11, 5, 1, 9, 8, BaseParser.ASCII_CR, 15, 0, 14, 4, 2, 3, 12, 7, 10, 6, 3, 10, BaseParser.ASCII_CR, 12, 1, 2, 0, 11, 7, 5, 9, 4, 8, 15, 14, 6, 1, BaseParser.ASCII_CR, 2, 9, 7, 10, 6, 0, 8, 12, 4, 5, 15, 3, 11, 14, 11, 10, 15, 5, 0, 12, 14, 8, 6, 2, 3, 9, 1, 7, BaseParser.ASCII_CR, 4};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static byte[] f13788d = {8, 4, 11, 1, 3, 5, 0, 9, 2, 14, 10, 12, BaseParser.ASCII_CR, 6, 7, 15, 0, 1, 2, 10, 4, BaseParser.ASCII_CR, 5, 12, 9, 7, 3, 15, 11, 8, 6, 14, 14, 12, 0, 10, 9, 2, BaseParser.ASCII_CR, 11, 7, 5, 8, 15, 3, 6, 1, 4, 7, 5, 0, BaseParser.ASCII_CR, 11, 6, 1, 2, 3, 10, 12, 15, 4, 14, 9, 8, 2, 7, 12, 15, 9, 5, 10, 11, 1, 4, 0, BaseParser.ASCII_CR, 6, 8, 14, 3, 8, 3, 2, 6, 4, BaseParser.ASCII_CR, 14, 11, 12, 1, 7, 15, 10, 0, 9, 5, 5, 2, 10, 11, 9, 1, 12, 3, 7, 4, BaseParser.ASCII_CR, 0, 6, 15, 8, 14, 0, 4, 11, 14, 8, 3, 7, 1, 10, 2, 9, 6, 15, BaseParser.ASCII_CR, 5, 12};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static byte[] f13789e = {1, 11, 12, 2, 9, BaseParser.ASCII_CR, 0, 15, 4, 5, 8, 14, 10, 7, 6, 3, 0, 1, 7, BaseParser.ASCII_CR, 11, 4, 5, 2, 8, 14, 15, 12, 9, 10, 6, 3, 8, 2, 5, 0, 4, 9, 15, 10, 3, 7, 12, BaseParser.ASCII_CR, 6, 14, 1, 11, 3, 6, 0, 1, 5, BaseParser.ASCII_CR, 10, 8, 11, 2, 9, 7, 14, 15, 12, 4, 8, BaseParser.ASCII_CR, 11, 0, 4, 5, 1, 2, 9, 3, 12, 14, 6, 15, 10, 7, 12, 9, 11, 1, 8, 14, 2, 4, 7, 3, 6, 5, 10, 0, 15, BaseParser.ASCII_CR, 10, 9, 6, 8, BaseParser.ASCII_CR, 14, 2, 0, 15, 3, 5, 11, 4, 1, 12, 7, 7, 4, 0, 5, 10, 2, 15, 14, 12, 6, 1, 11, BaseParser.ASCII_CR, 9, 3, 8};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static byte[] f13790f = {15, 12, 2, 10, 6, 4, 5, 0, 7, 9, 14, BaseParser.ASCII_CR, 1, 11, 8, 3, 11, 6, 3, 4, 12, 15, 14, 2, 7, BaseParser.ASCII_CR, 8, 0, 5, 10, 9, 1, 1, 12, 11, 0, 15, 14, 6, 5, 10, BaseParser.ASCII_CR, 4, 8, 9, 3, 7, 2, 1, 5, 14, 12, 10, 7, 0, BaseParser.ASCII_CR, 6, 2, 11, 4, 9, 3, 15, 8, 0, 12, 8, 9, BaseParser.ASCII_CR, 2, 10, 11, 7, 3, 6, 5, 4, 14, 15, 1, 8, 0, 15, 3, 2, 5, 14, 11, 1, 10, 4, 7, 12, 9, BaseParser.ASCII_CR, 6, 3, 0, 6, 15, 1, 14, 9, 2, BaseParser.ASCII_CR, 8, 12, 4, 11, 10, 5, 7, 1, 10, 6, 8, 15, 11, 0, 4, 12, 3, 5, 9, 7, BaseParser.ASCII_CR, 2, 14};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static byte[] f13791g = {12, 4, 6, 2, 10, 5, 11, 9, 14, 8, BaseParser.ASCII_CR, 7, 0, 3, 15, 1, 6, 8, 2, 3, 9, 10, 5, 12, 1, 14, 4, 7, 11, BaseParser.ASCII_CR, 0, 15, 11, 3, 5, 8, 2, 15, 10, BaseParser.ASCII_CR, 14, 1, 7, 4, 12, 9, 6, 0, 12, 8, 2, 1, BaseParser.ASCII_CR, 4, 15, 6, 7, 0, 10, 5, 3, 14, 9, 11, 7, 15, 5, 10, 8, 1, 6, BaseParser.ASCII_CR, 0, 9, 3, 14, 11, 4, 2, 12, 5, BaseParser.ASCII_CR, 15, 6, 9, 2, 12, 10, 11, 7, 8, 1, 4, 3, 14, 0, 8, 14, 2, 5, 6, 9, 1, 12, 15, 4, 11, 0, BaseParser.ASCII_CR, 10, 3, 7, 1, 7, 14, BaseParser.ASCII_CR, 0, 5, 8, 3, 4, 15, 10, 6, 9, 12, 11, 2};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static byte[] f13792h = {4, 10, 9, 2, BaseParser.ASCII_CR, 8, 0, 14, 6, 11, 1, 12, 7, 15, 5, 3, 14, 11, 4, 12, 6, BaseParser.ASCII_CR, 15, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, BaseParser.ASCII_CR, 10, 3, 4, 2, 14, 15, 12, 7, 6, 0, 9, 11, 7, BaseParser.ASCII_CR, 10, 1, 0, 8, 9, 15, 14, 4, 6, 12, 11, 2, 5, 3, 6, 12, 7, 1, 5, 15, BaseParser.ASCII_CR, 8, 4, 10, 9, 14, 0, 3, 11, 2, 4, 11, 10, 0, 7, 2, 1, BaseParser.ASCII_CR, 3, 6, 8, 5, 9, 12, 15, 14, BaseParser.ASCII_CR, 11, 4, 1, 3, 15, 5, 9, 0, 10, 14, 7, 6, 8, 2, 12, 1, 15, BaseParser.ASCII_CR, 0, 5, 7, 10, 4, 9, 2, 3, 14, 6, 11, 8, 12};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static byte[] f13793i = {10, 4, 5, 6, 8, 1, 3, 7, BaseParser.ASCII_CR, 12, 14, 0, 9, 2, 11, 15, 5, 15, 4, 0, 2, BaseParser.ASCII_CR, 11, 9, 1, 7, 6, 3, 12, 14, 10, 8, 7, 15, 12, 14, 9, 4, 1, 0, 3, 11, 5, 2, 6, 10, 8, BaseParser.ASCII_CR, 4, 10, 7, 12, 0, 15, 2, 8, 14, 1, 6, 5, BaseParser.ASCII_CR, 11, 9, 3, 7, 6, 4, 11, 9, 12, 2, 10, 1, 8, 0, 14, 15, BaseParser.ASCII_CR, 3, 5, 7, 6, 2, 4, BaseParser.ASCII_CR, 9, 15, 0, 10, 1, 5, 11, 8, 14, 12, 3, BaseParser.ASCII_CR, 14, 4, 1, 7, 0, 5, 10, 3, 12, 8, 15, 6, 2, 9, 11, 1, 3, 10, 9, 5, 11, 4, 15, 8, 6, 7, 14, BaseParser.ASCII_CR, 0, 2, 12};
    public static Hashtable j = new Hashtable();
    public boolean l;
    public int[] k = null;
    public byte[] m = f13785a;

    static {
        c("Default", f13785a);
        c("E-TEST", f13786b);
        c("E-A", f13787c);
        c("E-B", f13788d);
        c("E-C", f13789e);
        c("E-D", f13790f);
        c("Param-Z", f13791g);
        c("D-TEST", f13792h);
        c("D-A", f13793i);
    }

    public static void c(String str, byte[] bArr) {
        j.put(q.toUpperCase(str), bArr);
    }

    public static byte[] getSBox(String str) {
        byte[] bArr = (byte[]) j.get(q.toUpperCase(str));
        if (bArr != null) {
            return g.a.j.a.clone(bArr);
        }
        throw new IllegalArgumentException("Unknown S-Box - possible types: \"Default\", \"E-Test\", \"E-A\", \"E-B\", \"E-C\", \"E-D\", \"Param-Z\", \"D-Test\", \"D-A\".");
    }

    public static String getSBoxName(byte[] bArr) {
        Enumeration enumerationKeys = j.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            if (g.a.j.a.areEqual((byte[]) j.get(str), bArr)) {
                return str;
            }
        }
        throw new IllegalArgumentException("SBOX provided did not map to a known one");
    }

    public final void a(int[] iArr, byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4;
        int i5;
        int iD = d(bArr, i2);
        int iD2 = d(bArr, i2 + 4);
        int i6 = 7;
        if (this.l) {
            for (int i7 = 0; i7 < 3; i7++) {
                int i8 = 0;
                while (i8 < 8) {
                    int iB = iD2 ^ b(iD, iArr[i8]);
                    i8++;
                    int i9 = iD;
                    iD = iB;
                    iD2 = i9;
                }
            }
            i4 = iD2;
            i5 = iD;
            while (i6 > 0) {
                int iB2 = i4 ^ b(i5, iArr[i6]);
                i6--;
                i4 = i5;
                i5 = iB2;
            }
        } else {
            int i10 = 0;
            while (i10 < 8) {
                int iB3 = iD2 ^ b(iD, iArr[i10]);
                i10++;
                int i11 = iD;
                iD = iB3;
                iD2 = i11;
            }
            i4 = iD2;
            i5 = iD;
            for (int i12 = 0; i12 < 3; i12++) {
                int i13 = 7;
                while (i13 >= 0 && (i12 != 2 || i13 != 0)) {
                    int iB4 = i4 ^ b(i5, iArr[i13]);
                    i13--;
                    i4 = i5;
                    i5 = iB4;
                }
            }
        }
        int iB5 = b(i5, iArr[0]) ^ i4;
        f(i5, bArr2, i3);
        f(iB5, bArr2, i3 + 4);
    }

    public final int b(int i2, int i3) {
        int i4 = i3 + i2;
        byte[] bArr = this.m;
        int i5 = (bArr[((i4 >> 0) & 15) + 0] << 0) + (bArr[((i4 >> 4) & 15) + 16] << 4) + (bArr[((i4 >> 8) & 15) + 32] << 8) + (bArr[((i4 >> 12) & 15) + 48] << 12) + (bArr[((i4 >> 16) & 15) + 64] << GlyfDescript.X_DUAL) + (bArr[((i4 >> 20) & 15) + 80] << 20) + (bArr[((i4 >> 24) & 15) + 96] << 24) + (bArr[((i4 >> 28) & 15) + 112] << 28);
        return (i5 << 11) | (i5 >>> 21);
    }

    public final int d(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] << 24) & (-16777216)) + ((bArr[i2 + 2] << GlyfDescript.X_DUAL) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) + ((bArr[i2 + 1] << 8) & 65280) + (bArr[i2] & 255);
    }

    public final int[] e(boolean z, byte[] bArr) {
        this.l = z;
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
        }
        int[] iArr = new int[8];
        for (int i2 = 0; i2 != 8; i2++) {
            iArr[i2] = d(bArr, i2 * 4);
        }
        return iArr;
    }

    public final void f(int i2, byte[] bArr, int i3) {
        bArr[i3 + 3] = (byte) (i2 >>> 24);
        bArr[i3 + 2] = (byte) (i2 >>> 16);
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3] = (byte) i2;
    }

    public String getAlgorithmName() {
        return "GOST28147";
    }

    public int getBlockSize() {
        return 8;
    }

    public void init(boolean z, g.a.d.a aVar) {
        if (aVar instanceof l) {
            l lVar = (l) aVar;
            byte[] sBox = lVar.getSBox();
            if (sBox.length != f13785a.length) {
                throw new IllegalArgumentException("invalid S-box passed to GOST28147 init");
            }
            this.m = g.a.j.a.clone(sBox);
            if (lVar.getParameters() != null) {
                this.k = e(z, ((k) lVar.getParameters()).getKey());
                return;
            }
            return;
        }
        if (aVar instanceof k) {
            this.k = e(z, ((k) aVar).getKey());
        } else {
            if (aVar == null) {
                return;
            }
            throw new IllegalArgumentException("invalid parameter passed to GOST28147 init - " + aVar.getClass().getName());
        }
    }

    public int processBlock(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int[] iArr = this.k;
        if (iArr == null) {
            throw new IllegalStateException("GOST28147 engine not initialised");
        }
        if (i2 + 8 > bArr.length) {
            throw new d("input buffer too short");
        }
        if (i3 + 8 > bArr2.length) {
            throw new g("output buffer too short");
        }
        a(iArr, bArr, i2, bArr2, i3);
        return 8;
    }

    public void reset() {
    }
}

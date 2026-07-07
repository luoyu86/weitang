package g.a.a;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f13445a;

    public y(OutputStream outputStream) {
        this.f13445a = outputStream;
    }

    public static y create(OutputStream outputStream) {
        return new y(outputStream);
    }

    public static y create(OutputStream outputStream, String str) {
        return str.equals("DER") ? new z1(outputStream) : str.equals("DL") ? new p2(outputStream) : new y(outputStream);
    }

    public static int d(int i2) {
        if (i2 < 128) {
            return 1;
        }
        int i3 = 2;
        while (true) {
            i2 >>>= 8;
            if (i2 == 0) {
                return i3;
            }
            i3++;
        }
    }

    public static int e(boolean z, int i2) {
        return (z ? 1 : 0) + d(i2) + i2;
    }

    public static int f(int i2) {
        if (i2 < 31) {
            return 1;
        }
        int i3 = 2;
        while (true) {
            i2 >>>= 7;
            if (i2 == 0) {
                return i3;
            }
            i3++;
        }
    }

    public void a() throws IOException {
    }

    public z1 b() {
        return new z1(this.f13445a);
    }

    public p2 c() {
        return new p2(this.f13445a);
    }

    public void close() throws IOException {
        this.f13445a.close();
    }

    public void flush() throws IOException {
        this.f13445a.flush();
    }

    public final void g(int i2) throws IOException {
        this.f13445a.write(i2);
    }

    public final void h(byte[] bArr, int i2, int i3) throws IOException {
        this.f13445a.write(bArr, i2, i3);
    }

    public final void i(int i2) throws IOException {
        if (i2 < 128) {
            g(i2);
            return;
        }
        int i3 = 5;
        byte[] bArr = new byte[5];
        do {
            i3--;
            bArr[i3] = (byte) i2;
            i2 >>>= 8;
        } while (i2 != 0);
        int i4 = 5 - i3;
        int i5 = i3 - 1;
        bArr[i5] = (byte) (i4 | 128);
        h(bArr, i5, i4 + 1);
    }

    public void j(g[] gVarArr) throws IOException {
        for (g gVar : gVarArr) {
            gVar.toASN1Primitive().b(this, true);
        }
    }

    public final void k(boolean z, int i2, byte b2) throws IOException {
        q(z, i2);
        i(1);
        g(b2);
    }

    public final void l(boolean z, int i2, byte b2, byte[] bArr, int i3, int i4) throws IOException {
        q(z, i2);
        i(i4 + 1);
        g(b2);
        h(bArr, i3, i4);
    }

    public final void m(boolean z, int i2, byte[] bArr) throws IOException {
        q(z, i2);
        i(bArr.length);
        h(bArr, 0, bArr.length);
    }

    public final void n(boolean z, int i2, byte[] bArr, int i3, int i4) throws IOException {
        q(z, i2);
        i(i4);
        h(bArr, i3, i4);
    }

    public final void o(boolean z, int i2, byte[] bArr, int i3, int i4, byte b2) throws IOException {
        q(z, i2);
        i(i4 + 1);
        h(bArr, i3, i4);
        g(b2);
    }

    public final void p(boolean z, int i2, g[] gVarArr) throws IOException {
        q(z, i2);
        g(128);
        j(gVarArr);
        g(0);
        g(0);
    }

    public final void q(boolean z, int i2) throws IOException {
        if (z) {
            g(i2);
        }
    }

    public final void r(boolean z, int i2, int i3) throws IOException {
        if (z) {
            if (i3 < 31) {
                g(i2 | i3);
                return;
            }
            byte[] bArr = new byte[6];
            int i4 = 5;
            bArr[5] = (byte) (i3 & 127);
            while (i3 > 127) {
                i3 >>>= 7;
                i4--;
                bArr[i4] = (byte) ((i3 & 127) | 128);
            }
            int i5 = i4 - 1;
            bArr[i5] = (byte) (31 | i2);
            h(bArr, i5, 6 - i5);
        }
    }

    public void s(a0 a0Var, boolean z) throws IOException {
        a0Var.b(this, z);
    }

    public void t(a0[] a0VarArr) throws IOException {
        for (a0 a0Var : a0VarArr) {
            a0Var.b(this, true);
        }
    }

    public final void writeObject(a0 a0Var) throws IOException {
        if (a0Var == null) {
            throw new IOException("null object detected");
        }
        s(a0Var, true);
        a();
    }

    public final void writeObject(g gVar) throws IOException {
        if (gVar == null) {
            throw new IOException("null object detected");
        }
        s(gVar.toASN1Primitive(), true);
        a();
    }
}

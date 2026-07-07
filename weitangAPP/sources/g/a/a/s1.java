package g.a.a;

import java.io.IOException;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class s1 extends m {
    public s1(String str) {
        super(str);
    }

    public s1(Date date) {
        super(date);
    }

    public s1(byte[] bArr) {
        super(bArr);
    }

    @Override // g.a.a.m, g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 24, p());
    }

    @Override // g.a.a.m, g.a.a.a0
    public int d(boolean z) {
        return y.e(z, p().length);
    }

    @Override // g.a.a.m, g.a.a.a0
    public a0 e() {
        return this;
    }

    @Override // g.a.a.m, g.a.a.a0
    public a0 f() {
        return this;
    }

    public final byte[] p() {
        byte[] bArr = this.f13243b;
        if (bArr[bArr.length - 1] != 90) {
            return bArr;
        }
        if (!l()) {
            byte[] bArr2 = this.f13243b;
            byte[] bArr3 = new byte[bArr2.length + 4];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length - 1);
            System.arraycopy(g.a.j.q.toByteArray("0000Z"), 0, bArr3, this.f13243b.length - 1, 5);
            return bArr3;
        }
        if (!m()) {
            byte[] bArr4 = this.f13243b;
            byte[] bArr5 = new byte[bArr4.length + 2];
            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length - 1);
            System.arraycopy(g.a.j.q.toByteArray("00Z"), 0, bArr5, this.f13243b.length - 1, 3);
            return bArr5;
        }
        if (!k()) {
            return this.f13243b;
        }
        int length = this.f13243b.length - 2;
        while (length > 0 && this.f13243b[length] == 48) {
            length--;
        }
        byte[] bArr6 = this.f13243b;
        if (bArr6[length] == 46) {
            byte[] bArr7 = new byte[length + 1];
            System.arraycopy(bArr6, 0, bArr7, 0, length);
            bArr7[length] = 90;
            return bArr7;
        }
        byte[] bArr8 = new byte[length + 2];
        int i2 = length + 1;
        System.arraycopy(bArr6, 0, bArr8, 0, i2);
        bArr8[i2] = 90;
        return bArr8;
    }
}

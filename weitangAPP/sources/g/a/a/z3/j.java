package g.a.a.z3;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    public int getByteLength(g.a.g.a.e eVar) {
        return (eVar.getFieldSize() + 7) / 8;
    }

    public int getByteLength(g.a.g.a.f fVar) {
        return (fVar.getFieldSize() + 7) / 8;
    }

    public byte[] integerToBytes(BigInteger bigInteger, int i2) {
        byte[] byteArray = bigInteger.toByteArray();
        if (i2 < byteArray.length) {
            byte[] bArr = new byte[i2];
            System.arraycopy(byteArray, byteArray.length - i2, bArr, 0, i2);
            return bArr;
        }
        if (i2 <= byteArray.length) {
            return byteArray;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(byteArray, 0, bArr2, i2 - byteArray.length, byteArray.length);
        return bArr2;
    }
}

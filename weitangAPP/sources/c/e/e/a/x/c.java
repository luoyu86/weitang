package c.e.e.a.x;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static byte[] decodeBleWriteData(byte[] bArr) {
        byte[] bArrDecrypt;
        i.i("BleData ", " decode read*hex " + h.encodeHexStr(bArr) + " read*byte[] " + Arrays.toString(bArr));
        byte[] bArr2 = new byte[16];
        for (int i2 = 0; i2 < 16; i2++) {
            bArr2[i2] = bArr[i2];
        }
        try {
            bArrDecrypt = b.Decrypt(bArr2, j.f2494a);
        } catch (Exception e2) {
            e2.printStackTrace();
            bArrDecrypt = null;
        }
        if (bArrDecrypt == null) {
            return null;
        }
        byte[] bArr3 = new byte[20];
        for (int i3 = 0; i3 < 20; i3++) {
            if (i3 < 16) {
                bArr3[i3] = bArrDecrypt[i3];
            } else {
                bArr3[i3] = bArr[i3];
            }
        }
        i.i("BleData ", " decode read*disbytes " + h.encodeHexStr(bArr3));
        byte[] bArr4 = new byte[15];
        bArr4[0] = bArr3[0];
        bArr4[1] = bArr3[1];
        for (int i4 = 0; i4 < 13; i4++) {
            bArr4[i4 + 2] = bArr3[i4];
        }
        e.calcCrc8(bArr4);
        return bArr3;
    }

    public static byte[] encodeBleWriteData(byte b2, byte b3, byte[] bArr) {
        byte[] bArr2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        if (bArr != null) {
            for (int i2 = 0; i2 < 17; i2++) {
                if (i2 < 11) {
                    bArr2[i2] = bArr[i2];
                } else {
                    bArr2[i2] = 0;
                }
            }
        }
        byte[] bArr3 = new byte[15];
        bArr3[0] = b2;
        bArr3[1] = b3;
        for (int i3 = 0; i3 < 13; i3++) {
            bArr3[i3 + 2] = bArr2[i3];
        }
        byte bCalcCrc8 = e.calcCrc8(bArr3);
        byte[] bArr4 = new byte[20];
        bArr4[0] = b2;
        bArr4[1] = b3;
        for (int i4 = 0; i4 < 17; i4++) {
            bArr4[i4 + 2] = bArr2[i4];
        }
        bArr4[19] = bCalcCrc8;
        byte[] bArr5 = new byte[16];
        byte[] bArr6 = new byte[20];
        for (int i5 = 0; i5 < 16; i5++) {
            bArr5[i5] = bArr4[i5];
        }
        byte[] bArrEncrypt = new byte[0];
        i.i("BleData", " encode checkOpenLock " + Arrays.toString(bArr4) + "*" + h.encodeHexStr(bArr4));
        try {
            bArrEncrypt = b.Encrypt(bArr5, j.f2494a);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (bArrEncrypt == null) {
            i.i("BleData", "encode encrypt为空");
            return bArr2;
        }
        if (TextUtils.isEmpty(new String(bArrEncrypt))) {
            return bArr2;
        }
        for (int i6 = 0; i6 < 20; i6++) {
            if (i6 < 16) {
                bArr6[i6] = bArrEncrypt[i6];
            } else {
                bArr6[i6] = bArr4[i6];
            }
        }
        i.i("BleData", " encode 1encrycheckOpenLock " + Arrays.toString(bArr6) + "*" + h.encodeHexStr(bArr6));
        return bArr6;
    }
}

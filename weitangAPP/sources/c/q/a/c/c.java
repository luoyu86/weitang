package c.q.a.c;

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
            bArrDecrypt = b.Decrypt(bArr2, j.f3132a);
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
        f.calcCrc8(bArr4);
        return bArr3;
    }

    public static byte[] decodeVtBleResponseData(byte[] bArr) {
        int length = (bArr.length - 4) - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 4, bArr2, 0, length);
        return bArr2;
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
        byte bCalcCrc8 = f.calcCrc8(bArr3);
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
            bArrEncrypt = b.Encrypt(bArr5, j.f3132a);
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

    public static boolean openDoorIsSuccess(String str) {
        return str.contains("EE08");
    }

    public static String parseOpenDoorResult(String str) {
        String str2 = "开门失败，";
        if (str.contains("EE01")) {
            str2 = "开门失败，校验位错误";
        }
        if (str.contains("EE02")) {
            str2 = str2 + "分包错误";
        }
        if (str.contains("EE05")) {
            str2 = str2 + "包头错误";
        }
        if (str.contains("EE06")) {
            str2 = str2 + "未鉴权";
        }
        if (str.contains("EEFF")) {
            str2 = str2 + "未知错误";
        }
        if (str.contains("EE03")) {
            str2 = str2 + "秘钥错误";
        }
        if (str.contains("EE04")) {
            str2 = str2 + "秘钥已过期";
        }
        if (str.contains("EE0F")) {
            str2 = str2 + "凭证不存在";
        }
        if (str.contains("EE0E")) {
            str2 = str2 + "凭证错误";
        }
        if (str.contains("EE0D")) {
            str2 = str2 + "指令失效时间";
        }
        if (str.contains("EE0C")) {
            str2 = str2 + "凭证有效期起始时间未到";
        }
        if (str.contains("EE0B")) {
            str2 = str2 + "凭证已过期";
        }
        if (str.contains("EE10")) {
            str2 = str2 + "NB消息码错误";
        }
        if (str.contains("EE0A")) {
            str2 = str2 + "凭证被冻结";
        }
        if (!str.contains("EE09")) {
            return str2;
        }
        return str2 + "开门次数不足";
    }
}

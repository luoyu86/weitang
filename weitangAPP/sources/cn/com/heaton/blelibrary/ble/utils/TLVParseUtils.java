package cn.com.heaton.blelibrary.ble.utils;

import android.text.TextUtils;
import android.util.Log;
import cn.com.heaton.blelibrary.ble.L;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class TLVParseUtils {
    private static TLVParseUtils tmpTLVParseUtils;
    public final String UTF_8 = "UTF-8";

    private static int[] byteToInt(byte[] bArr, int i2) {
        int[] iArr = new int[bArr.length >> 2];
        int i3 = 0;
        while (i2 < bArr.length) {
            iArr[i3] = transform(bArr[i2 + 3]) | (transform(bArr[i2 + 2]) << 8) | (transform(bArr[i2 + 1]) << 16) | (bArr[i2] << 24);
            i3++;
            i2 += 4;
        }
        return iArr;
    }

    private static byte[] decrypt(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int[] iArrByteToInt = byteToInt(bArr, i2);
        int i4 = iArrByteToInt[0];
        int i5 = iArrByteToInt[1];
        int[] iArrByteToInt2 = byteToInt(bArr2, 0);
        int i6 = iArrByteToInt2[0];
        int i7 = iArrByteToInt2[1];
        int i8 = iArrByteToInt2[2];
        int i9 = iArrByteToInt2[3];
        int iLog = (-1640531527) << ((int) (Math.log(i3) / Math.log(2.0d)));
        for (int i10 = 0; i10 < i3; i10++) {
            i5 -= (((i4 << 4) + i8) ^ (i4 + iLog)) ^ ((i4 >>> 5) + i9);
            i4 -= (((i5 << 4) + i6) ^ (i5 + iLog)) ^ ((i5 >>> 5) + i7);
            iLog -= -1640531527;
        }
        iArrByteToInt[0] = i4;
        iArrByteToInt[1] = i5;
        return intToByte(iArrByteToInt, 0);
    }

    public static byte[] decryptByTea(byte[] bArr, byte[] bArr2, int i2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3 += 8) {
            System.arraycopy(decrypt(bArr, i3, bArr2, i2), 0, bArr3, i3, 8);
        }
        return bArr3;
    }

    private static byte[] encrypt(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int[] iArrByteToInt = byteToInt(bArr, i2);
        int i4 = iArrByteToInt[0];
        int i5 = iArrByteToInt[1];
        int[] iArrByteToInt2 = byteToInt(bArr2, 0);
        int i6 = iArrByteToInt2[0];
        int i7 = iArrByteToInt2[1];
        int i8 = iArrByteToInt2[2];
        int i9 = iArrByteToInt2[3];
        int i10 = 0;
        for (int i11 = 0; i11 < i3; i11++) {
            i10 -= 1640531527;
            i4 += (((i5 << 4) + i6) ^ (i5 + i10)) ^ ((i5 >>> 5) + i7);
            i5 += (((i4 << 4) + i8) ^ (i4 + i10)) ^ ((i4 >>> 5) + i9);
        }
        iArrByteToInt[0] = i4;
        iArrByteToInt[1] = i5;
        return intToByte(iArrByteToInt, 0);
    }

    public static byte[] encryptByTea(byte[] bArr, byte[] bArr2, int i2) {
        int length = 8 - (bArr.length % 8);
        int length2 = bArr.length + length;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        fillChar(bArr3, (byte) length, bArr.length, length);
        byte[] bArr4 = new byte[length2];
        for (int i3 = 0; i3 < length2; i3 += 8) {
            System.arraycopy(encrypt(bArr3, i3, bArr2, i2), 0, bArr4, i3, 8);
        }
        return bArr4;
    }

    private static void fillChar(byte[] bArr, byte b2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i2 + i4] = b2;
        }
    }

    public static TLVParseUtils getInstance() {
        if (tmpTLVParseUtils == null) {
            synchronized (TLVParseUtils.class) {
                if (tmpTLVParseUtils == null) {
                    tmpTLVParseUtils = new TLVParseUtils();
                }
            }
        }
        return tmpTLVParseUtils;
    }

    public static String getTimeZoneTransformId(String str) {
        return String.valueOf(TimeZone.getTimeZone(str).getRawOffset() / 3600000);
    }

    public static byte[] hexStringtobyteArray(String str) {
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        byte[] bArr = new byte[str.length() / 2];
        while (i2 < str.length() - 1) {
            int i3 = i2 + 2;
            bArr[i2 / 2] = Integer.valueOf(str.substring(i2, i3), 16).byteValue();
            i2 = i3;
        }
        return bArr;
    }

    private static byte[] intToByte(int[] iArr, int i2) {
        int length = iArr.length << 2;
        byte[] bArr = new byte[length];
        int i3 = 0;
        while (i2 < length) {
            bArr[i2 + 3] = (byte) (iArr[i3] & 255);
            bArr[i2 + 2] = (byte) ((iArr[i3] >> 8) & 255);
            bArr[i2 + 1] = (byte) ((iArr[i3] >> 16) & 255);
            bArr[i2] = (byte) ((iArr[i3] >> 24) & 255);
            i3++;
            i2 += 4;
        }
        return bArr;
    }

    public static String toHexStr(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr[i2] >= 0 && bArr[i2] <= 15) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(bArr[i2] & 255));
        }
        return sb.toString();
    }

    private static int transform(byte b2) {
        return b2 < 0 ? b2 + 256 : b2;
    }

    public int byteArrayToInt(byte[] bArr) {
        if (bArr.length == 1) {
            return bArr[0];
        }
        if (bArr.length == 2) {
            return byteArrayToShort(bArr);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 += (bArr[i3] & 255) << ((3 - i3) * 8);
        }
        return i2;
    }

    public short byteArrayToShort(byte[] bArr) {
        if (bArr.length == 1) {
            return bArr[0];
        }
        short s = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            s = (short) (s + ((bArr[i2] & 255) << ((1 - i2) * 8)));
        }
        return s;
    }

    public boolean checkXorCode(byte[] bArr) {
        int i2;
        int length = bArr.length;
        byte b2 = bArr[0];
        int i3 = 1;
        while (true) {
            i2 = length - 1;
            if (i3 >= i2) {
                break;
            }
            b2 = (byte) (b2 ^ bArr[i3]);
            i3++;
        }
        return bArr[i2] == b2;
    }

    public BluetoothResultTLV getBluetoothResultTLV(byte[] bArr, int i2, boolean z) {
        BluetoothResultTLV bluetoothResultTLV = new BluetoothResultTLV();
        if (z && bArr.length > 2) {
            bluetoothResultTLV.setCmd(Integer.valueOf(bArr[0]));
            bluetoothResultTLV.setSubCmd(Integer.valueOf(bArr[1]));
        }
        int i3 = z ? 4 : 0;
        byte[] bArr2 = new byte[2];
        while (i3 < i2) {
            bArr2[0] = bArr[i3];
            if (i3 != i2 - 1) {
                try {
                    bArr2[1] = bArr[i3 + 1];
                    short sByteArrayToShort = byteArrayToShort(bArr2);
                    int i4 = i3 + 2;
                    bArr2[0] = bArr[i4];
                    bArr2[1] = bArr[i4 + 1];
                    int iByteArrayToShort = byteArrayToShort(bArr2);
                    int i5 = i4 + 2;
                    byte[] bArr3 = new byte[iByteArrayToShort];
                    System.arraycopy(bArr, i5, bArr3, 0, iByteArrayToShort);
                    L.e(L.TAG, "tagType=" + ((int) sByteArrayToShort) + " dataLen=" + iByteArrayToShort);
                    if (sByteArrayToShort != 1) {
                        if (sByteArrayToShort != 25) {
                            if (sByteArrayToShort != 29) {
                                if (sByteArrayToShort != 33) {
                                    if (sByteArrayToShort != 70) {
                                        if (sByteArrayToShort != 100) {
                                            if (sByteArrayToShort != 103) {
                                                if (sByteArrayToShort != 64) {
                                                    if (sByteArrayToShort != 65) {
                                                        switch (sByteArrayToShort) {
                                                            case 36:
                                                                if (iByteArrayToShort > 0) {
                                                                    bluetoothResultTLV.setXuliehao(Integer.valueOf(byteArrayToInt(bArr3)));
                                                                }
                                                                break;
                                                            case 37:
                                                                if (iByteArrayToShort > 0) {
                                                                    bluetoothResultTLV.setUtcTime(byteArrayToInt(bArr3));
                                                                }
                                                                break;
                                                            case 38:
                                                                if (iByteArrayToShort > 0) {
                                                                    bluetoothResultTLV.setTimeZone(byteArrayToInt(bArr3));
                                                                }
                                                                break;
                                                            case 39:
                                                                if (iByteArrayToShort > 0) {
                                                                    bluetoothResultTLV.setNbSignal(byteArrayToInt(bArr3));
                                                                }
                                                                break;
                                                        }
                                                    } else if (iByteArrayToShort > 0) {
                                                        bluetoothResultTLV.setStatus(byteArrayToInt(bArr3));
                                                    }
                                                } else if (iByteArrayToShort > 0) {
                                                    bluetoothResultTLV.setPower(byteArrayToInt(bArr3));
                                                }
                                            } else if (iByteArrayToShort > 0) {
                                                bluetoothResultTLV.setNbStatus(byteArrayToInt(bArr3));
                                            }
                                        } else if (iByteArrayToShort > 0) {
                                            bluetoothResultTLV.setRandStr(bArr3);
                                        }
                                    } else if (iByteArrayToShort > 0) {
                                        bluetoothResultTLV.setZwaveCommand(bArr3);
                                    }
                                } else if (iByteArrayToShort > 0) {
                                    bluetoothResultTLV.setNewKeyPackage(bArr3);
                                }
                            } else if (iByteArrayToShort > 0) {
                                bluetoothResultTLV.setData(bArr3);
                            }
                        } else if (iByteArrayToShort > 0) {
                            bluetoothResultTLV.setRandNum(bArr3);
                        }
                    } else if (iByteArrayToShort > 0) {
                        bluetoothResultTLV.setResultCode(Integer.valueOf(byteArrayToInt(bArr3)));
                    }
                    i3 = i5 + iByteArrayToShort;
                } catch (Exception e2) {
                    L.e(L.TAG, Log.getStackTraceString(e2));
                }
            }
            return bluetoothResultTLV;
        }
        return bluetoothResultTLV;
    }

    public byte xorCode(byte[] bArr) {
        byte b2 = bArr[0];
        int length = bArr.length - 1;
        for (int i2 = 1; i2 < length; i2++) {
            b2 = (byte) (b2 ^ bArr[i2]);
        }
        return b2;
    }
}

package c.p.a.d;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f3056a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f3057b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] a(byte[] bArr, char[] cArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            cArr2[i2] = cArr[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr2[i4] = cArr[bArr[i3] & 15];
        }
        return cArr2;
    }

    public static String b(byte[] bArr, char[] cArr) {
        return new String(a(bArr, cArr));
    }

    public static String byteToHex(byte b2) {
        String hexString = Integer.toHexString(b2 & 255);
        if (hexString.length() >= 2) {
            return hexString;
        }
        return "0" + hexString;
    }

    public static int c(char c2, int i2) {
        int iDigit = Character.digit(c2, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new RuntimeException("Illegal hexadecimal character " + c2 + " at index " + i2);
    }

    public static byte charToByte(char c2) {
        return (byte) "0123456789ABCDEF".indexOf(c2);
    }

    public static byte[] decodeHex(char[] cArr) {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new RuntimeException("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int iC = c(cArr[i2], i2) << 4;
            int i4 = i2 + 1;
            int iC2 = iC | c(cArr[i4], i4);
            i2 = i4 + 1;
            bArr[i3] = (byte) (iC2 & 255);
            i3++;
        }
        return bArr;
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, true);
    }

    public static String encodeHexStr(byte[] bArr) {
        return encodeHexStr(bArr, true);
    }

    public static String extractData(byte[] bArr, int i2) {
        return encodeHexStr(new byte[]{bArr[i2]});
    }

    public static byte[] hexStringToBytes(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (charToByte(charArray[i3 + 1]) | (charToByte(charArray[i3]) << 4));
        }
        return bArr;
    }

    public static char[] encodeHex(byte[] bArr, boolean z) {
        return a(bArr, z ? f3056a : f3057b);
    }

    public static String encodeHexStr(byte[] bArr, boolean z) {
        return b(bArr, z ? f3056a : f3057b);
    }
}

package com.sun.mail.imap.protocol;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/* JADX INFO: loaded from: classes2.dex */
public class BASE64MailboxDecoder {
    public static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', ','};
    private static final byte[] pem_convert_array = new byte[256];

    static {
        int i2 = 0;
        for (int i3 = 0; i3 < 255; i3++) {
            pem_convert_array[i3] = -1;
        }
        while (true) {
            char[] cArr = pem_array;
            if (i2 >= cArr.length) {
                return;
            }
            pem_convert_array[cArr[i2]] = (byte) i2;
            i2++;
        }
    }

    public static int base64decode(char[] cArr, int i2, CharacterIterator characterIterator) {
        byte b2;
        boolean z = true;
        while (true) {
            int i3 = -1;
            while (true) {
                byte next = (byte) characterIterator.next();
                if (next == -1) {
                    return i2;
                }
                if (next == 45) {
                    if (!z) {
                        return i2;
                    }
                    int i4 = i2 + 1;
                    cArr[i2] = '&';
                    return i4;
                }
                z = false;
                byte next2 = (byte) characterIterator.next();
                if (next2 == -1 || next2 == 45) {
                    return i2;
                }
                byte[] bArr = pem_convert_array;
                byte b3 = bArr[next & 255];
                byte b4 = bArr[next2 & 255];
                byte b5 = (byte) (((b3 << 2) & 252) | ((b4 >>> 4) & 3));
                if (i3 != -1) {
                    cArr[i2] = (char) ((i3 << 8) | (b5 & 255));
                    i2++;
                    i3 = -1;
                } else {
                    i3 = b5 & 255;
                }
                byte next3 = (byte) characterIterator.next();
                if (next3 != 61) {
                    if (next3 == -1 || next3 == 45) {
                        return i2;
                    }
                    byte b6 = bArr[next3 & 255];
                    byte b7 = (byte) (((b4 << 4) & 240) | ((b6 >>> 2) & 15));
                    if (i3 != -1) {
                        cArr[i2] = (char) ((i3 << 8) | (b7 & 255));
                        i2++;
                        i3 = -1;
                    } else {
                        i3 = b7 & 255;
                    }
                    byte next4 = (byte) characterIterator.next();
                    if (next4 == 61) {
                        continue;
                    } else {
                        if (next4 == -1 || next4 == 45) {
                            return i2;
                        }
                        b2 = (byte) (((b6 << 6) & 192) | (bArr[next4 & 255] & 63));
                        if (i3 != -1) {
                            break;
                        }
                        i3 = b2 & 255;
                    }
                }
            }
            cArr[i2] = (char) ((i3 << 8) | (b2 & 255));
            i2++;
        }
    }

    public static String decode(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] cArr = new char[str.length()];
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        boolean z = false;
        int iBase64decode = 0;
        for (char cFirst = stringCharacterIterator.first(); cFirst != 65535; cFirst = stringCharacterIterator.next()) {
            if (cFirst == '&') {
                z = true;
                iBase64decode = base64decode(cArr, iBase64decode, stringCharacterIterator);
            } else {
                cArr[iBase64decode] = cFirst;
                iBase64decode++;
            }
        }
        return z ? new String(cArr, 0, iBase64decode) : str;
    }
}

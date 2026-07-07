package com.tom_roush.pdfbox.util;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class Hex {
    private static final byte[] HEX_BYTES = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private Hex() {
    }

    public static byte[] decodeBase64(String str) {
        try {
            Class<?> cls = Class.forName("java.util.Base64");
            Object objInvoke = cls.getMethod("getDecoder", new Class[0]).invoke(cls, new Object[0]);
            return (byte[]) objInvoke.getClass().getMethod("decode", String.class).invoke(objInvoke, str.replaceAll("\\s", ""));
        } catch (ClassNotFoundException e2) {
            Log.d("PdfBox-Android", e2.getMessage(), e2);
            try {
                return (byte[]) Class.forName("javax.xml.bind.DatatypeConverter").getMethod("parseBase64Binary", String.class).invoke(null, str);
            } catch (ClassNotFoundException e3) {
                Log.d("PdfBox-Android", e3.getMessage(), e3);
                Log.e("PdfBox-Android", "Can't decode base64 value, try adding javax.xml.bind:jaxb-api to your build");
                return new byte[0];
            } catch (IllegalAccessException e4) {
                Log.d("PdfBox-Android", e4.getMessage(), e4);
                Log.e("PdfBox-Android", "Can't decode base64 value, try adding javax.xml.bind:jaxb-api to your build");
                return new byte[0];
            } catch (IllegalArgumentException e5) {
                Log.d("PdfBox-Android", e5.getMessage(), e5);
                Log.e("PdfBox-Android", "Can't decode base64 value, try adding javax.xml.bind:jaxb-api to your build");
                return new byte[0];
            } catch (NoSuchMethodException e6) {
                Log.d("PdfBox-Android", e6.getMessage(), e6);
                Log.e("PdfBox-Android", "Can't decode base64 value, try adding javax.xml.bind:jaxb-api to your build");
                return new byte[0];
            } catch (SecurityException e7) {
                Log.d("PdfBox-Android", e7.getMessage(), e7);
                Log.e("PdfBox-Android", "Can't decode base64 value, try adding javax.xml.bind:jaxb-api to your build");
                return new byte[0];
            } catch (InvocationTargetException e8) {
                Log.d("PdfBox-Android", e8.getMessage(), e8);
                Log.e("PdfBox-Android", "Can't decode base64 value, try adding javax.xml.bind:jaxb-api to your build");
                return new byte[0];
            }
        } catch (IllegalAccessException e9) {
            Log.d("PdfBox-Android", e9.getMessage(), e9);
            return (byte[]) Class.forName("javax.xml.bind.DatatypeConverter").getMethod("parseBase64Binary", String.class).invoke(null, str);
        } catch (IllegalArgumentException e10) {
            Log.d("PdfBox-Android", e10.getMessage(), e10);
            return (byte[]) Class.forName("javax.xml.bind.DatatypeConverter").getMethod("parseBase64Binary", String.class).invoke(null, str);
        } catch (NoSuchMethodException e11) {
            Log.d("PdfBox-Android", e11.getMessage(), e11);
            return (byte[]) Class.forName("javax.xml.bind.DatatypeConverter").getMethod("parseBase64Binary", String.class).invoke(null, str);
        } catch (SecurityException e12) {
            Log.d("PdfBox-Android", e12.getMessage(), e12);
            return (byte[]) Class.forName("javax.xml.bind.DatatypeConverter").getMethod("parseBase64Binary", String.class).invoke(null, str);
        } catch (InvocationTargetException e13) {
            Log.d("PdfBox-Android", e13.getMessage(), e13);
            return (byte[]) Class.forName("javax.xml.bind.DatatypeConverter").getMethod("parseBase64Binary", String.class).invoke(null, str);
        }
    }

    public static byte[] decodeHex(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < str.length() - 1) {
            if (str.charAt(i2) == '\n' || str.charAt(i2) == '\r') {
                i2++;
            } else {
                int i3 = i2 + 2;
                String strSubstring = str.substring(i2, i3);
                try {
                    byteArrayOutputStream.write(Integer.parseInt(strSubstring, 16));
                    i2 = i3;
                } catch (NumberFormatException e2) {
                    Log.e("PdfBox-Android", "Can't parse " + strSubstring + ", aborting decode", e2);
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] getBytes(byte b2) {
        byte[] bArr = HEX_BYTES;
        return new byte[]{bArr[getHighNibble(b2)], bArr[getLowNibble(b2)]};
    }

    public static char[] getChars(short s) {
        char[] cArr = HEX_CHARS;
        return new char[]{cArr[(s >> 12) & 15], cArr[(s >> 8) & 15], cArr[(s >> 4) & 15], cArr[s & 15]};
    }

    public static char[] getCharsUTF16BE(String str) {
        char[] cArr = new char[str.length() * 4];
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            int i4 = i2 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i2] = cArr2[(cCharAt >> '\f') & 15];
            int i5 = i4 + 1;
            cArr[i4] = cArr2[(cCharAt >> '\b') & 15];
            int i6 = i5 + 1;
            cArr[i5] = cArr2[(cCharAt >> 4) & 15];
            i2 = i6 + 1;
            cArr[i6] = cArr2[cCharAt & 15];
        }
        return cArr;
    }

    private static int getHighNibble(byte b2) {
        return (b2 & 240) >> 4;
    }

    private static int getLowNibble(byte b2) {
        return b2 & 15;
    }

    public static String getString(byte b2) {
        char[] cArr = HEX_CHARS;
        return new String(new char[]{cArr[getHighNibble(b2)], cArr[getLowNibble(b2)]});
    }

    public static void writeHexByte(byte b2, OutputStream outputStream) throws IOException {
        byte[] bArr = HEX_BYTES;
        outputStream.write(bArr[getHighNibble(b2)]);
        outputStream.write(bArr[getLowNibble(b2)]);
    }

    public static void writeHexBytes(byte[] bArr, OutputStream outputStream) throws IOException {
        for (byte b2 : bArr) {
            writeHexByte(b2, outputStream);
        }
    }

    public static byte[] getBytes(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i2 * 2;
            byte[] bArr3 = HEX_BYTES;
            bArr2[i3] = bArr3[getHighNibble(bArr[i2])];
            bArr2[i3 + 1] = bArr3[getLowNibble(bArr[i2])];
        }
        return bArr2;
    }

    public static String getString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            char[] cArr = HEX_CHARS;
            sb.append(cArr[getHighNibble(b2)]);
            sb.append(cArr[getLowNibble(b2)]);
        }
        return sb.toString();
    }
}

package g.a.j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Vector;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f14663a;

    public static class a implements PrivilegedAction<String> {
        @Override // java.security.PrivilegedAction
        public String run() {
            return System.getProperty("line.separator");
        }
    }

    public static class b extends ArrayList<String> implements p {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public void add(int i2, String str) {
            super.add(i2, str);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(String str) {
            return super.add(str);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List, g.a.j.p
        public /* bridge */ /* synthetic */ String get(int i2) {
            return (String) super.get(i2);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public String set(int i2, String str) {
            return (String) super.set(i2, str);
        }

        @Override // g.a.j.p
        public String[] toStringArray() {
            int size = size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 != size; i2++) {
                strArr[i2] = get(i2);
            }
            return strArr;
        }

        @Override // g.a.j.p
        public String[] toStringArray(int i2, int i3) {
            String[] strArr = new String[i3 - i2];
            for (int i4 = i2; i4 != size() && i4 != i3; i4++) {
                strArr[i4 - i2] = get(i4);
            }
            return strArr;
        }
    }

    static {
        try {
            try {
                f14663a = (String) AccessController.doPrivileged(new a());
            } catch (Exception unused) {
                f14663a = "\n";
            }
        } catch (Exception unused2) {
            f14663a = String.format("%n", new Object[0]);
        }
    }

    public static char[] asCharArray(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i2 = 0; i2 != length; i2++) {
            cArr[i2] = (char) (bArr[i2] & 255);
        }
        return cArr;
    }

    public static boolean constantTimeAreEqual(String str, String str2) {
        boolean z = str.length() == str2.length();
        int length = str.length();
        for (int i2 = 0; i2 != length; i2++) {
            z &= str.charAt(i2) == str2.charAt(i2);
        }
        return z;
    }

    public static String fromByteArray(byte[] bArr) {
        return new String(asCharArray(bArr));
    }

    public static String fromUTF8ByteArray(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        int iTranscodeToUTF16 = g.a.j.r.e.transcodeToUTF16(bArr, cArr);
        if (iTranscodeToUTF16 >= 0) {
            return new String(cArr, 0, iTranscodeToUTF16);
        }
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }

    public static String lineSeparator() {
        return f14663a;
    }

    public static p newList() {
        return new b(null);
    }

    public static String[] split(String str, char c2) {
        int i2;
        Vector vector = new Vector();
        boolean z = true;
        while (true) {
            if (!z) {
                break;
            }
            int iIndexOf = str.indexOf(c2);
            if (iIndexOf > 0) {
                vector.addElement(str.substring(0, iIndexOf));
                str = str.substring(iIndexOf + 1);
            } else {
                vector.addElement(str);
                z = false;
            }
        }
        int size = vector.size();
        String[] strArr = new String[size];
        for (i2 = 0; i2 != size; i2++) {
            strArr[i2] = (String) vector.elementAt(i2);
        }
        return strArr;
    }

    public static int toByteArray(String str, byte[] bArr, int i2) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i2 + i3] = (byte) str.charAt(i3);
        }
        return length;
    }

    public static byte[] toByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 != length; i2++) {
            bArr[i2] = (byte) str.charAt(i2);
        }
        return bArr;
    }

    public static byte[] toByteArray(char[] cArr) {
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 != length; i2++) {
            bArr[i2] = (byte) cArr[i2];
        }
        return bArr;
    }

    public static String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i2 = 0; i2 != charArray.length; i2++) {
            char c2 = charArray[i2];
            if ('A' <= c2 && 'Z' >= c2) {
                charArray[i2] = (char) ((c2 - 'A') + 97);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    public static void toUTF8ByteArray(char[] cArr, OutputStream outputStream) throws IOException {
        int i2;
        int i3;
        int i4 = 0;
        while (i4 < cArr.length) {
            char c2 = cArr[i4];
            int i5 = c2;
            if (c2 >= 128) {
                if (c2 < 2048) {
                    i2 = (c2 >> 6) | 192;
                } else if (c2 < 55296 || c2 > 57343) {
                    outputStream.write((c2 >> '\f') | 224);
                    i2 = ((c2 >> 6) & 63) | 128;
                } else {
                    i4++;
                    if (i4 >= cArr.length) {
                        throw new IllegalStateException("invalid UTF-16 codepoint");
                    }
                    char c3 = cArr[i4];
                    if (c2 > 56319) {
                        throw new IllegalStateException("invalid UTF-16 codepoint");
                    }
                    int i6 = (((c2 & 1023) << 10) | (c3 & 1023)) + 65536;
                    outputStream.write((i6 >> 18) | 240);
                    outputStream.write(((i6 >> 12) & 63) | 128);
                    outputStream.write(((i6 >> 6) & 63) | 128);
                    i3 = i6;
                    i5 = (i3 & 63) | 128;
                }
                outputStream.write(i2);
                i3 = c2;
                i5 = (i3 & 63) | 128;
            }
            outputStream.write(i5);
            i4++;
        }
    }

    public static byte[] toUTF8ByteArray(String str) {
        return toUTF8ByteArray(str.toCharArray());
    }

    public static byte[] toUTF8ByteArray(char[] cArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            toUTF8ByteArray(cArr, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new IllegalStateException("cannot encode string to byte array!");
        }
    }

    public static String toUpperCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i2 = 0; i2 != charArray.length; i2++) {
            char c2 = charArray[i2];
            if ('a' <= c2 && 'z' >= c2) {
                charArray[i2] = (char) ((c2 - 'a') + 65);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }
}

package com.nanchen.compresshelper;

/* JADX INFO: loaded from: classes2.dex */
public class StringUtil {
    private StringUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        return str == str2 || (str2 != null && str.length() == str2.length() && str.regionMatches(true, 0, str2, 0, str2.length()));
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isSpace(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String lowerFirstLetter(String str) {
        if (isEmpty(str) || !Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        return String.valueOf((char) (str.charAt(0) + ' ')) + str.substring(1);
    }

    public static String null2Length0(String str) {
        return str == null ? "" : str;
    }

    public static String reverse(String str) {
        int length = length(str);
        if (length <= 1) {
            return str;
        }
        int i2 = length >> 1;
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = charArray[i3];
            int i4 = (length - i3) - 1;
            charArray[i3] = charArray[i4];
            charArray[i4] = c2;
        }
        return new String(charArray);
    }

    public static String toDBC(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (charArray[i2] == 12288) {
                charArray[i2] = ' ';
            } else if (65281 > charArray[i2] || charArray[i2] > 65374) {
                charArray[i2] = charArray[i2];
            } else {
                charArray[i2] = (char) (charArray[i2] - 65248);
            }
        }
        return new String(charArray);
    }

    public static String toSBC(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (charArray[i2] == ' ') {
                charArray[i2] = 12288;
            } else if ('!' > charArray[i2] || charArray[i2] > '~') {
                charArray[i2] = charArray[i2];
            } else {
                charArray[i2] = (char) (charArray[i2] + 65248);
            }
        }
        return new String(charArray);
    }

    public static String upperFirstLetter(String str) {
        if (isEmpty(str) || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return String.valueOf((char) (str.charAt(0) - ' ')) + str.substring(1);
    }
}

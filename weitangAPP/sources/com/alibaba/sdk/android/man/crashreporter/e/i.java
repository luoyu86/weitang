package com.alibaba.sdk.android.man.crashreporter.e;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static boolean a(CharSequence charSequence) {
        int length;
        if (charSequence != null && (length = charSequence.length()) != 0) {
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isWhitespace(charSequence.charAt(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 0;
    }

    public static String c(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        boolean z = true;
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (str2 != null && str != null) {
                if (z) {
                    if ("--invalid--".equals(str2)) {
                        stringBuffer.append(str);
                    } else {
                        stringBuffer.append(str + "=" + str2);
                    }
                    z = false;
                } else if ("--invalid--".equals(str2)) {
                    stringBuffer.append(",");
                    stringBuffer.append(str);
                } else {
                    stringBuffer.append(",");
                    stringBuffer.append(str + "=" + str2);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static boolean b(CharSequence charSequence) {
        return !a(charSequence);
    }

    public static String a(String str, String str2) {
        return a((CharSequence) str) ? str2 : str;
    }

    public static int a(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i2 = 0;
        for (char c2 : str.toCharArray()) {
            i2 = (i2 * 31) + c2;
        }
        return i2;
    }

    public static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Integer) {
            return "" + ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return "" + ((Long) obj).longValue();
        }
        if (obj instanceof Double) {
            return "" + ((Double) obj).doubleValue();
        }
        if (obj instanceof Float) {
            return "" + ((Float) obj).floatValue();
        }
        if (obj instanceof Short) {
            return "" + ((int) ((Short) obj).shortValue());
        }
        if (obj instanceof Byte) {
            return "" + ((int) ((Byte) obj).byteValue());
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        if (obj instanceof Character) {
            return ((Character) obj).toString();
        }
        return obj.toString();
    }
}

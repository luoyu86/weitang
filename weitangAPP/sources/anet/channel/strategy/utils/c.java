package anet.channel.strategy.utils;

import android.text.TextUtils;
import anet.channel.util.ALog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        if (charArray.length < 7 || charArray.length > 15) {
            return false;
        }
        int i2 = 0;
        int i3 = 0;
        for (char c2 : charArray) {
            if (c2 >= '0' && c2 <= '9') {
                i3 = ((i3 * 10) + c2) - 48;
                if (i3 > 255) {
                    return false;
                }
            } else {
                if (c2 != '.' || (i2 = i2 + 1) > 3) {
                    return false;
                }
                i3 = 0;
            }
        }
        return true;
    }

    public static boolean b(String str) {
        int i2;
        boolean z;
        int i3;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        if (charArray.length < 2) {
            return false;
        }
        if (charArray[0] != ':') {
            i2 = 0;
            z = false;
            i3 = 0;
        } else {
            if (charArray[1] != ':') {
                return false;
            }
            i2 = 1;
            z = false;
            i3 = 1;
        }
        int i4 = 0;
        boolean z2 = true;
        while (i2 < charArray.length) {
            char c2 = charArray[i2];
            int iDigit = Character.digit(c2, 16);
            if (iDigit != -1) {
                i4 = (i4 << 4) + iDigit;
                if (i4 > 65535) {
                    return false;
                }
                z2 = false;
            } else {
                if (c2 != ':' || (i3 = i3 + 1) > 7) {
                    return false;
                }
                if (!z2) {
                    i4 = 0;
                    z2 = true;
                } else {
                    if (z) {
                        return false;
                    }
                    z = true;
                }
            }
            i2++;
        }
        return z || i3 >= 7;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        if (charArray.length <= 0 || charArray.length > 255) {
            return false;
        }
        boolean z = false;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if ((charArray[i2] >= 'A' && charArray[i2] <= 'Z') || ((charArray[i2] >= 'a' && charArray[i2] <= 'z') || charArray[i2] == '*')) {
                z = true;
            } else if ((charArray[i2] < '0' || charArray[i2] > '9') && charArray[i2] != '.' && charArray[i2] != '-') {
                return false;
            }
        }
        return z;
    }

    public static String d(String str) {
        return str == null ? "" : str;
    }

    public static String a(long j) {
        StringBuilder sb = new StringBuilder(16);
        long j2 = 1000000000;
        do {
            sb.append(j / j2);
            sb.append('.');
            j %= j2;
            j2 /= 1000;
        } while (j2 > 0);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static String a(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append("=");
                    sb.append(URLEncoder.encode(d(entry.getValue()), str).replace("+", "%20"));
                    sb.append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        } catch (UnsupportedEncodingException e2) {
            ALog.e("Request", "format params failed", null, e2, new Object[0]);
        }
        return sb.toString();
    }
}

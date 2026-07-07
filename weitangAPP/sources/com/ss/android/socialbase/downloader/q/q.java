package com.ss.android.socialbase.downloader.q;

import org.apache.commons.codec.net.RFC1522Codec;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    public static StringBuilder a(StringBuilder sb, String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            ok(sb, strArr[i2]).append(RFC1522Codec.PREFIX);
            if (i2 < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder ok(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder ok(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder ok(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append('\"');
            sb.append(strArr[i2]);
            sb.append('\"');
            if (i2 < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String a(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
        sb.append('\"' + str + '\"');
        sb.append(" (");
        ok(sb, strArr);
        sb.append(") VALUES (");
        ok(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static StringBuilder ok(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 < i2 - 1) {
                sb.append("?,");
            } else {
                sb.append(RFC1522Codec.SEP);
            }
        }
        return sb;
    }

    public static StringBuilder ok(StringBuilder sb, String str, String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            ok(sb, str, strArr[i2]).append(RFC1522Codec.PREFIX);
            if (i2 < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String ok(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('\"');
        sb.append(str2);
        sb.append('\"');
        sb.append(" (");
        ok(sb, strArr);
        sb.append(") VALUES (");
        ok(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String ok(String str, String[] strArr) {
        String str2 = '\"' + str + '\"';
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            ok(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String ok(String str, String[] strArr, String[] strArr2) {
        String str2 = '\"' + str + '\"';
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2);
        sb.append(" SET ");
        a(sb, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb.append(" WHERE ");
            ok(sb, str2, strArr2);
        }
        return sb.toString();
    }
}

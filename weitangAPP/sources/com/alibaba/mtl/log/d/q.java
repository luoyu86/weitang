package com.alibaba.mtl.log.d;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class q {
    public static Map<String, String> b(Map<String, String> map) {
        if (map == null) {
            return map;
        }
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            if (str instanceof String) {
                String str2 = map.get(str);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        map2.put(URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return map2;
    }

    public static String convertObjectToString(Object obj) {
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
        if (!(obj instanceof Byte)) {
            return obj instanceof Boolean ? ((Boolean) obj).toString() : obj instanceof Character ? ((Character) obj).toString() : obj.toString();
        }
        return "" + ((int) ((Byte) obj).byteValue());
    }

    public static String d(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        boolean z = true;
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : map.keySet()) {
            String strConvertObjectToString = convertObjectToString(map.get(str));
            String strConvertObjectToString2 = convertObjectToString(str);
            if (strConvertObjectToString != null && strConvertObjectToString2 != null) {
                if (z) {
                    stringBuffer.append(strConvertObjectToString2 + "=" + strConvertObjectToString);
                    z = false;
                } else {
                    stringBuffer.append(",");
                    stringBuffer.append(strConvertObjectToString2 + "=" + strConvertObjectToString);
                }
            }
        }
        return stringBuffer.toString();
    }
}

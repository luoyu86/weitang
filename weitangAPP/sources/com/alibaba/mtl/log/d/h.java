package com.alibaba.mtl.log.d;

import android.text.TextUtils;
import com.alibaba.mtl.log.model.LogField;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static String a(Map<String, String> map) {
        boolean z;
        LogField logField;
        StringBuilder sb = new StringBuilder();
        LogField[] logFieldArrValues = LogField.values();
        int length = logFieldArrValues.length;
        int i2 = 0;
        while (true) {
            String str = null;
            if (i2 >= length || (logField = logFieldArrValues[i2]) == LogField.ARGS) {
                break;
            }
            if (map.containsKey(logField.toString())) {
                str = map.get(logField.toString()) + "";
                map.remove(logField.toString());
            }
            sb.append(b(str));
            sb.append("||");
            i2++;
        }
        LogField logField2 = LogField.ARGS;
        if (map.containsKey(logField2.toString())) {
            sb.append(b(map.get(logField2.toString()) + ""));
            map.remove(logField2.toString());
            z = false;
        } else {
            z = true;
        }
        for (String str2 : map.keySet()) {
            String str3 = map.containsKey(str2) ? map.get(str2) + "" : null;
            if (z) {
                if ("StackTrace".equals(str2)) {
                    sb.append("StackTrace=====>");
                    sb.append(str3);
                } else {
                    sb.append(b(str2));
                    sb.append("=");
                    sb.append(str3);
                }
                z = false;
            } else if ("StackTrace".equals(str2)) {
                sb.append(",");
                sb.append("StackTrace=====>");
                sb.append(str3);
            } else {
                sb.append(",");
                sb.append(b(str2));
                sb.append("=");
                sb.append(str3);
            }
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string) || !string.endsWith("||")) {
            return string;
        }
        return string + "-";
    }

    public static String b(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        m29a(map);
        return a(map);
    }

    private static String c(Map<String, String> map) {
        String str = "_ap=1";
        if (OperatorName.CURVE_TO_REPLICATE_FINAL_POINT.equalsIgnoreCase(map.get(LogField.OS.toString()))) {
            String strR = d.r();
            if (!TextUtils.isEmpty(strR)) {
                str = "_ap=1,_did=" + strR;
            }
        }
        String str2 = map.get(LogField.APPKEY.toString());
        if (TextUtils.isEmpty(b.getAppkey()) || TextUtils.isEmpty(str2) || b.getAppkey().equalsIgnoreCase(str2)) {
            return str;
        }
        return str + ",_mak=" + b.getAppkey();
    }

    private static String b(String str) {
        return TextUtils.isEmpty(str) ? "-" : str;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Map<String, String> m29a(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        try {
            String strN = b.n();
            if (!TextUtils.isEmpty(strN)) {
                LogField logField = LogField.USERNICK;
                if (!map.containsKey(logField.toString())) {
                    map.put(logField.toString(), strN);
                }
            }
            String strK = b.k();
            if (!TextUtils.isEmpty(strK)) {
                LogField logField2 = LogField.LL_USERNICK;
                if (!map.containsKey(logField2.toString())) {
                    map.put(logField2.toString(), strK);
                }
            }
            String strO = b.o();
            if (!TextUtils.isEmpty(strO)) {
                LogField logField3 = LogField.USERID;
                if (!map.containsKey(logField3.toString())) {
                    map.put(logField3.toString(), strO);
                }
            }
            String strL = b.l();
            if (!TextUtils.isEmpty(strL)) {
                LogField logField4 = LogField.LL_USERID;
                if (!map.containsKey(logField4.toString())) {
                    map.put(logField4.toString(), strL);
                }
            }
            String strValueOf = String.valueOf(System.currentTimeMillis());
            LogField logField5 = LogField.RECORD_TIMESTAMP;
            if (!map.containsKey(logField5.toString())) {
                map.put(logField5.toString(), strValueOf);
            }
            LogField logField6 = LogField.START_SESSION_TIMESTAMP;
            if (!map.containsKey(logField6.toString())) {
                map.put(logField6.toString(), String.valueOf(com.alibaba.mtl.log.a.B));
            }
            Map<String, String> mapA = d.a(com.alibaba.mtl.log.a.getContext());
            if (mapA != null) {
                for (String str : mapA.keySet()) {
                    String str2 = mapA.get(str);
                    if (!TextUtils.isEmpty(str2) && !map.containsKey(str) && !map.containsKey(str)) {
                        map.put(str, str2);
                    }
                }
            }
            String strC = c(map);
            if (!TextUtils.isEmpty(strC)) {
                LogField logField7 = LogField.RESERVES;
                if (!map.containsKey(logField7.toString())) {
                    map.put(logField7.toString(), strC);
                }
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    public static String a(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6, String str7) {
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        if (!TextUtils.isEmpty(str)) {
            map2.put(LogField.PAGE.toString(), str);
        }
        map2.put(LogField.EVENTID.toString(), str2);
        if (!TextUtils.isEmpty(str3)) {
            map2.put(LogField.ARG1.toString(), str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            map2.put(LogField.ARG2.toString(), str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            map2.put(LogField.ARG3.toString(), str5);
        }
        if (!TextUtils.isEmpty(str7)) {
            map2.put(LogField.RECORD_TIMESTAMP.toString(), str7);
        }
        if (!TextUtils.isEmpty(str6)) {
            map2.put(LogField.RESERVE3.toString(), str6);
        }
        return b(map2);
    }
}

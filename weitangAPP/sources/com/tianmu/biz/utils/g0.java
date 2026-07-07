package com.tianmu.biz.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class g0 {
    public static String a(String str) {
        Matcher matcher = Pattern.compile("http[s]?:\\/\\/[^\"]*").matcher(str);
        String strGroup = "";
        while (matcher.find()) {
            strGroup = matcher.group(0);
        }
        return strGroup;
    }
}

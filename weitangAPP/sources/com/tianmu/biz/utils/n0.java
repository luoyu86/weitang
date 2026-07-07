package com.tianmu.biz.utils;

import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class n0 {
    public static String a(String str, com.tianmu.c.i.j jVar) {
        return jVar == null ? a(str, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0) : a(str, jVar.c(), jVar.d(), jVar.h(), jVar.i(), jVar.a(), jVar.b(), jVar.f(), jVar.g(), jVar.j(), jVar.e());
    }

    public static String b(String str) {
        try {
            long jC = com.tianmu.c.n.k.h().c();
            return str.replaceAll("__TM_EVENT_TIME__", (jC / 1000) + "").replaceAll("__TM_EVENT_MILLI_TIME__", jC + "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String a(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        if (str == null) {
            return null;
        }
        try {
            return str.replace("__TM_DOWN_X__", i2 + "").replace("__TM_ABS_DOWN_X__", i6 + "").replace("__TM_DOWN_Y__", i3 + "").replace("__TM_ABS_DOWN_Y__", i7 + "").replace("__TM_UP_X__", i4 + "").replace("__TM_ABS_UP_X__", i8 + "").replace("__TM_UP_Y__", i5 + "").replace("__TM_ABS_UP_Y__", i9 + "").replace("__TM_WIDTH__", i10 + "").replace("__TM_HEIGHT__", i11 + "").replace("[", "%5b").replace("]", "%5d");
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String b(String str, int i2) {
        try {
            return str.replace("__TM_BID_PRICE__", URLEncoder.encode(com.tianmu.c.d.a.c(String.valueOf(i2), "0276af914fee82a4"), "UTF-8"));
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String a(String str, int i2) {
        try {
            return str.replace("__TM_CLICK_TYPE__", i2 + "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String a(String str, int i2, int i3) {
        try {
            return str.replace("__TM_BID_PRICE__", URLEncoder.encode(com.tianmu.c.d.a.c(String.valueOf(i2), "0276af914fee82a4"), "UTF-8")).replace("__TM_LOSS_REASON__", String.valueOf(i3));
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list == null || list.size() == 0) {
            return null;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(list.get(i2));
            if (i2 < list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static List<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }
}

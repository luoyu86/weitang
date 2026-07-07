package com.alibaba.mtl.log.d;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.SdkMeta;
import com.alibaba.mtl.log.model.LogField;
import com.alibaba.mtl.log.sign.BaseRequestAuth;
import com.alibaba.mtl.log.sign.IRequestAuth;
import com.alibaba.mtl.log.sign.SecurityRequestAuth;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class u {
    private static final String TAG = "u";

    public static String a(String str, Map<String, Object> map, Map<String, Object> map2) throws Exception {
        String strA;
        String str2 = "";
        if (map2 != null && map2.size() > 0) {
            Set<String> setKeySet = map2.keySet();
            String[] strArr = new String[setKeySet.size()];
            setKeySet.toArray(strArr);
            for (String str3 : g.a().a(strArr, true)) {
                str2 = str2 + str3 + j.b((byte[]) map2.get(str3));
            }
        }
        try {
            strA = a(str, null, null, str2);
        } catch (Throwable unused) {
            strA = a(com.alibaba.mtl.log.a.a.g(), null, null, str2);
        }
        String str4 = com.alibaba.mtl.log.a.a.S;
        if (TextUtils.isEmpty(str4)) {
            return strA;
        }
        return strA + "&dk=" + URLEncoder.encode(str4, "UTF-8");
    }

    private static String c(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    private static String a(String str, String str2, String str3, String str4) throws Exception {
        String str5;
        String str6;
        Context context = com.alibaba.mtl.log.a.getContext();
        String appkey = b.getAppkey();
        String strM = b.m();
        if (strM == null) {
            strM = "";
        }
        String str7 = d.a(context).get(LogField.APPVERSION.toString());
        String str8 = d.a(context).get(LogField.OS.toString());
        String str9 = d.a(context).get(LogField.UTDID.toString());
        String strValueOf = String.valueOf(System.currentTimeMillis());
        IRequestAuth iRequestAuthA = com.alibaba.mtl.log.a.a();
        str5 = "1";
        String str10 = "0";
        if (!(iRequestAuthA instanceof SecurityRequestAuth)) {
            if (iRequestAuthA instanceof BaseRequestAuth) {
                str10 = ((BaseRequestAuth) iRequestAuthA).isEncode() ? "1" : "0";
                str5 = "0";
            } else {
                str5 = "0";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(appkey);
        sb.append(strM);
        sb.append(str7);
        sb.append(str8);
        sb.append(SdkMeta.SDK_VERSION);
        sb.append(str9);
        sb.append(strValueOf);
        sb.append("3.0");
        sb.append(str5);
        sb.append(str3 == null ? "" : str3);
        sb.append(str4 == null ? "" : str4);
        String sign = iRequestAuthA.getSign(j.b(sb.toString().getBytes()));
        if (TextUtils.isEmpty(str2)) {
            str6 = "";
        } else {
            str6 = str2 + "&";
        }
        return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s&k=%s", str, str6, c(appkey), c(str7), c(strM), c("3.0"), c(sign), c(str9), SdkMeta.SDK_VERSION, str8, strValueOf, "", str5, str10);
    }
}

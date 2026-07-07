package com.tianmu.biz.utils;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    public static String a(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(TTDownloadField.TT_MD5).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}

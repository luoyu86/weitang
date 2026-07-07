package cn.admobiletop.adsuyi.a.m;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class j {
    public static String a(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(TTDownloadField.TT_MD5).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("0");
                    sb2.append(hexString);
                    hexString = sb2.toString();
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

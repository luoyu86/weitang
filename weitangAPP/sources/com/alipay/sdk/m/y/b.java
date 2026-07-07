package com.alipay.sdk.m.y;

import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static String a(String str) {
        try {
            if (com.alipay.sdk.m.z.a.a(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b2)));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}

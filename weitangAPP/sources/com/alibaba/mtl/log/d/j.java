package com.alibaba.mtl.log.d;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static char[] f4564a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(f4564a[(bArr[i2] & 240) >>> 4]);
            sb.append(f4564a[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    public static String b(byte[] bArr) {
        byte[] bArrM30a = m30a(bArr);
        return bArrM30a != null ? a(bArrM30a) : "0000000000000000";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m30a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}

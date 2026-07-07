package org.android.agoo.common;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.codec.net.URLCodec;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f14939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<Cipher> f14940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AlgorithmParameterSpec f14941c;

    static {
        byte[] bArr = {82, 22, 50, 44, -16, 124, -40, -114, -87, -40, URLCodec.ESCAPE_CHAR, 23, -56, 23, -33, 75};
        f14939a = bArr;
        f14940b = new ThreadLocal<>();
        f14941c = new IvParameterSpec(bArr);
    }

    public static byte[] a(byte[] bArr, SecretKeySpec secretKeySpec, byte[] bArr2) throws IllegalArgumentException {
        try {
            return a(secretKeySpec, bArr2, 2).doFinal(bArr);
        } catch (BadPaddingException e2) {
            throw new IllegalArgumentException("AES decrypt error:" + e2.getMessage(), e2);
        } catch (IllegalBlockSizeException e3) {
            throw new IllegalArgumentException("AES decrypt error:" + e3.getMessage(), e3);
        }
    }

    private static Cipher a(SecretKeySpec secretKeySpec, byte[] bArr, int i2) {
        Cipher cipherA = a();
        try {
            cipherA.init(i2, secretKeySpec, new IvParameterSpec(bArr));
            return cipherA;
        } catch (IllegalArgumentException e2) {
            throw new RuntimeException("init Chipher error:" + e2.getMessage(), e2);
        } catch (InvalidAlgorithmParameterException e3) {
            throw new RuntimeException("init Chipher error:" + e3.getMessage(), e3);
        } catch (InvalidKeyException e4) {
            throw new RuntimeException("init Chipher error:" + e4.getMessage(), e4);
        }
    }

    private static Cipher a() {
        ThreadLocal<Cipher> threadLocal = f14940b;
        Cipher cipher = threadLocal.get();
        if (cipher == null) {
            try {
                cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                threadLocal.set(cipher);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException("get Chipher error:" + e2.getMessage(), e2);
            } catch (NoSuchPaddingException e3) {
                throw new RuntimeException("get Chipher error:" + e3.getMessage(), e3);
            }
        }
        return cipher;
    }

    public static byte[] a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            throw new RuntimeException("md5 value Throwable", th);
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "HmacSHA1");
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            return mac.doFinal(bArr2);
        } catch (Throwable th) {
            throw new RuntimeException("HmacSHA1 Throwable", th);
        }
    }
}

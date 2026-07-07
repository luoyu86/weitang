package c.e.a.d.d0;

import c.e.a.d.x;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1195a = "chinavisionaryiv";

    public static byte[] a() {
        return f1195a.getBytes();
    }

    public static String aesDecrypt(String str, String str2) throws Exception {
        return (x.isNotNull(str) ? aesDecryptByBytes(base64Decode(str), str2) : null).trim();
    }

    public static String aesDecryptByBytes(byte[] bArr, String str) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(2, new SecretKeySpec(str.getBytes(), "AES"), new IvParameterSpec(a()));
        return new String(cipher.doFinal(bArr)).trim();
    }

    public static String aesEncrypt(String str, String str2) throws Exception {
        return base64Encode(aesEncryptToBytes(str, str2));
    }

    public static byte[] aesEncryptToBytes(String str, String str2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        int blockSize = cipher.getBlockSize();
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        int i2 = length % blockSize;
        if (i2 != 0) {
            length += blockSize - i2;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        cipher.init(1, new SecretKeySpec(str2.getBytes(), "AES"), new IvParameterSpec(a()));
        return cipher.doFinal(bArr);
    }

    public static byte[] base64Decode(String str) throws Exception {
        if (x.isNullStr(str)) {
            return null;
        }
        return Base64.decodeBase64(str.getBytes());
    }

    public static String base64Encode(byte[] bArr) {
        return new String(Base64.encodeBase64(bArr));
    }

    public static String binary(byte[] bArr, int i2) {
        return new BigInteger(1, bArr).toString(i2);
    }

    public static byte[] md5(byte[] bArr) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static String md5Encrypt(String str) throws Exception {
        if (x.isNullStr(str)) {
            return null;
        }
        return base64Encode(md5(str));
    }

    public void setVi(String str) {
        f1195a = str;
    }

    public static byte[] md5(String str) throws Exception {
        if (x.isNullStr(str)) {
            return null;
        }
        return md5(str.getBytes());
    }
}

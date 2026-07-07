package c.e.a.d.d0;

import c.e.a.d.x;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1196a = "RSA/ECB/PKCS1Padding";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1198b;

        public a(String str, String str2) {
            this.f1197a = str;
            this.f1198b = str2;
        }

        public String getPrivateKey() {
            return this.f1198b;
        }

        public String getPublicKey() {
            return this.f1197a;
        }

        public void setPrivateKey(String str) {
            this.f1198b = str;
        }

        public void setPublicKey(String str) {
            this.f1197a = str;
        }
    }

    public static String a(byte[] bArr, String str) throws Exception {
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) getPrivateKey(str);
        Cipher cipher = Cipher.getInstance(f1196a);
        cipher.init(2, rSAPrivateKey);
        return new String(cipher.doFinal(bArr));
    }

    public static String b(byte[] bArr, String str) throws Exception {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) getPublicKey(str);
        Cipher cipher = Cipher.getInstance(f1196a);
        cipher.init(2, rSAPublicKey);
        return new String(cipher.doFinal(bArr));
    }

    public static byte[] c(String str, String str2) throws Exception {
        byte[] bytes = str.getBytes();
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) getPrivateKey(str2);
        Cipher cipher = Cipher.getInstance(f1196a);
        cipher.init(1, rSAPrivateKey);
        return cipher.doFinal(bytes);
    }

    public static byte[] d(String str, String str2) throws Exception {
        byte[] bytes = str.getBytes();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) getPublicKey(str2);
        Cipher cipher = Cipher.getInstance(f1196a);
        cipher.init(1, rSAPublicKey);
        return cipher.doFinal(bytes);
    }

    public static byte[] decryptBASE64(String str) throws Exception {
        if (x.isNullStr(str)) {
            return null;
        }
        return Base64.decodeBase64(str.getBytes());
    }

    public static String encryptBASE64(byte[] bArr) throws Exception {
        return new String(Base64.encodeBase64(bArr));
    }

    public static a getKey(String str) throws Exception {
        Map<String, Object> mapInitKey = initKey(512, str);
        return new a(getPublicKey(mapInitKey), getPrivateKey(mapInitKey));
    }

    public static String getPrivateKey(Map<String, Object> map) throws Exception {
        return encryptBASE64(((Key) map.get("RSAPrivateKey")).getEncoded());
    }

    public static String getPublicKey(Map<String, Object> map) throws Exception {
        return encryptBASE64(((Key) map.get("RSAPublicKey")).getEncoded());
    }

    public static Map<String, Object> initKey(int i2) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.f5523a);
        keyPairGenerator.initialize(i2);
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) keyPairGenerateKeyPair.getPublic();
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) keyPairGenerateKeyPair.getPrivate();
        HashMap map = new HashMap(2);
        map.put("RSAPublicKey", rSAPublicKey);
        map.put("RSAPrivateKey", rSAPrivateKey);
        return map;
    }

    public static String rsaDecryptByPrivateKey(String str, String str2) throws Exception {
        if (x.isNotNull(str)) {
            return a(decryptBASE64(str), str2);
        }
        return null;
    }

    public static String rsaDecryptByPublicKey(String str, String str2) throws Exception {
        if (x.isNotNull(str)) {
            return b(decryptBASE64(str), str2);
        }
        return null;
    }

    public static String rsaEncryptyPrivateKey(String str, String str2) throws Exception {
        return encryptBASE64(c(str, str2));
    }

    public static String rsaEncryptyPublicKey(String str, String str2) throws Exception {
        return encryptBASE64(d(str, str2));
    }

    public static String sign(byte[] bArr, String str) throws Exception {
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance(com.alipay.sdk.m.n.d.f5523a).generatePrivate(new PKCS8EncodedKeySpec(decryptBASE64(str)));
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initSign(privateKeyGeneratePrivate);
        signature.update(bArr);
        return encryptBASE64(signature.sign());
    }

    public static boolean verify(byte[] bArr, String str, String str2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(com.alipay.sdk.m.n.d.f5523a).generatePublic(new X509EncodedKeySpec(decryptBASE64(str)));
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(bArr);
        return signature.verify(decryptBASE64(str2));
    }

    public static PrivateKey getPrivateKey(String str) throws Exception {
        return KeyFactory.getInstance(com.alipay.sdk.m.n.d.f5523a).generatePrivate(new PKCS8EncodedKeySpec(decryptBASE64(str)));
    }

    public static PublicKey getPublicKey(String str) throws Exception {
        return KeyFactory.getInstance(com.alipay.sdk.m.n.d.f5523a).generatePublic(new X509EncodedKeySpec(decryptBASE64(str)));
    }

    public static Map<String, Object> initKey(int i2, String str) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.f5523a);
        keyPairGenerator.initialize(i2);
        if (x.isNotNull(str)) {
            keyPairGenerator.initialize(i2, new SecureRandom(str.getBytes()));
        } else {
            keyPairGenerator.initialize(i2, new SecureRandom(String.valueOf(System.currentTimeMillis()).getBytes()));
        }
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) keyPairGenerateKeyPair.getPublic();
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) keyPairGenerateKeyPair.getPrivate();
        HashMap map = new HashMap(2);
        map.put("RSAPublicKey", rSAPublicKey);
        map.put("RSAPrivateKey", rSAPrivateKey);
        return map;
    }
}

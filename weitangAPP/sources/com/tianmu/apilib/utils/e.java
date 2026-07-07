package com.tianmu.apilib.utils;

import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static String a(String str) {
        return a(Base64.decode(str, 2), b(b.a() + b.b()), 2);
    }

    private static PublicKey b(String str) {
        try {
            return KeyFactory.getInstance(com.alipay.sdk.m.n.d.f5523a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] bArr, Key key, int i2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
        cipher.init(i2, key);
        return new String(cipher.doFinal(bArr), "UTF-8");
    }
}

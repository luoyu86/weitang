package com.tianmu.apilib.utils;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(str.getBytes("UTF-8"));
        } catch (Exception unused) {
            return "";
        }
    }

    private static String a(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance(com.alipay.sdk.m.n.d.f5523a).generatePublic(new X509EncodedKeySpec(Base64.decode(c.a() + c.b(), 2)));
                Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
                cipher.init(1, rSAPublicKey);
                return Base64.encodeToString(cipher.doFinal(bArr), 2);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}

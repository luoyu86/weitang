package com.tianmu.c.d;

import android.util.Base64;
import com.alipay.sdk.m.n.d;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return a(Base64.decode(str, 2));
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return b(str.getBytes("UTF-8"));
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance(d.f5523a).generatePublic(new X509EncodedKeySpec(Base64.decode(b.b() + b.c(), 2)));
                Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
                cipher.init(2, rSAPublicKey);
                return new String(cipher.doFinal(bArr), "UTF-8");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static String b(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance(d.f5523a).generatePublic(new X509EncodedKeySpec(Base64.decode(b.b() + b.c(), 2)));
                Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
                cipher.init(1, rSAPublicKey);
                return Base64.encodeToString(cipher.doFinal(bArr), 2);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}

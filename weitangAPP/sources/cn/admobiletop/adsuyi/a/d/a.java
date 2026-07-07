package cn.admobiletop.adsuyi.a.d;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(String str, String str2) {
        try {
            String strA = a(str);
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, new SecretKeySpec(bytes, "AES"), new IvParameterSpec(bytes, 0, 16));
            return new String(cipher.doFinal(Base64.decode(strA, 2)), "UTF-8").trim();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str, String str2) {
        try {
            String strA = a(str);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(1, new SecretKeySpec(str2.getBytes(), "AES"), new IvParameterSpec(str2.getBytes(), 0, 16));
            return Base64.encodeToString(cipher.doFinal(strA.getBytes("UTF-8")), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        while (length % 16 != 0) {
            str = str + "\n";
            length = str.length();
        }
        return str;
    }
}

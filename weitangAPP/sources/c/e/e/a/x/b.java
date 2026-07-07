package c.e.e.a.x;

import android.util.Log;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static byte[] Decrypt(byte[] bArr, byte[] bArr2) throws Exception {
        try {
            if (bArr2 == null) {
                Log.i("Decrypt", "Key为空null");
                return null;
            }
            if (bArr2.length != 16) {
                Log.i("Decrypt", "Key长度不是16位");
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e2) {
                Log.i("Decrypt", " original " + e2.toString());
                return null;
            }
        } catch (Exception e3) {
            Log.i("Decrypt", " ex " + e3.toString());
            return null;
        }
    }

    public static byte[] Encrypt(byte[] bArr, byte[] bArr2) throws Exception {
        if (bArr2 == null) {
            Log.i("Encrypt", "Key为空");
            return null;
        }
        if (bArr2.length != 16) {
            Log.i("Encrypt", "Key长度不是16位");
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(1, secretKeySpec);
        byte[] bArrDoFinal = cipher.doFinal(bArr);
        if (bArrDoFinal == null) {
            Log.i("Encrypt", "encrypte为空");
        }
        return bArrDoFinal;
    }
}

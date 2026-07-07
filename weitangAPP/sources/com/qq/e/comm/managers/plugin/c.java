package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f9688a = {82, 83, 65, 47, 69, 67, 66, 47, 80, 75, 67, 83, 49, 80, 97, 100, 100, 105, 110, 103};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PublicKey f9689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9690c;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f9691a = new c();
    }

    public c() {
        boolean z;
        try {
            this.f9689b = a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        this.f9690c = z;
    }

    public final PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(com.alipay.sdk.m.n.d.f5523a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    public boolean a(String str, String str2) {
        String strTrim;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!this.f9690c) {
            return true;
        }
        if (this.f9689b != null) {
            byte[] bArrDecode = Base64.decode(str, 0);
            try {
                Cipher cipher = Cipher.getInstance(new String(f9688a, "UTF-8"));
                cipher.init(2, this.f9689b);
                strTrim = new String(cipher.doFinal(bArrDecode), "UTF-8").trim();
            } catch (Throwable unused) {
                GDTLogger.d("ErrorWhileVerifySigNature");
                strTrim = null;
            }
        } else {
            strTrim = null;
        }
        boolean zEquals = str2.equals(strTrim);
        GDTLogger.d("Verify Result" + zEquals + "src=" + str2 + " & target=" + strTrim);
        return zEquals;
    }

    public boolean a(String str, File file) throws Throwable {
        String strA;
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.exists()) {
            FileInputStream fileInputStream2 = null;
            try {
                messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int i2 = fileInputStream.read(bArr);
                    if (i2 <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i2);
                }
                strA = d.a(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused4) {
                    }
                }
                strA = "";
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        } else {
            strA = "";
        }
        return a(str, strA);
    }
}

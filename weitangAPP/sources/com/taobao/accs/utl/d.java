package com.taobao.accs.utl;

import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.codec.net.URLCodec;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f10477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<Cipher> f10478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AlgorithmParameterSpec f10479c;

    static {
        byte[] bArr = {82, 22, 50, 44, -16, 124, -40, -114, -87, -40, URLCodec.ESCAPE_CHAR, 23, -56, 23, -33, 75};
        f10477a = bArr;
        f10478b = new ThreadLocal<>();
        f10479c = new IvParameterSpec(bArr);
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
}

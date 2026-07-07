package com.tianmu.danikula.videocache;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyCacheUtils {
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final int MAX_ARRAY_PREVIEW = 16;
    private static final String TAG = "ProxyCacheUtils";

    public static void assertBuffer(byte[] bArr, long j, int i2) {
        Preconditions.checkNotNull(bArr, "Buffer must be not null!");
        Preconditions.checkArgument(j >= 0, "Data offset must be positive!");
        Preconditions.checkArgument(i2 >= 0 && i2 <= bArr.length, "Length must be in range [0..buffer.length]");
    }

    private static String bytesToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b2)));
        }
        return stringBuffer.toString();
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.i(TAG, "ProxyCacheUtils Error closing resource");
            }
        }
    }

    public static String computeMD5(String str) {
        try {
            return bytesToHexString(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static String decode(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Error decoding url", e2);
        }
    }

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Error encoding url", e2);
        }
    }

    public static String getSupposablyMime(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public static String preview(byte[] bArr, int i2) {
        int iMin = Math.min(16, Math.max(i2, 0));
        String string = Arrays.toString(Arrays.copyOfRange(bArr, 0, iMin));
        if (iMin >= i2) {
            return string;
        }
        return string.substring(0, string.length() - 1) + ", ...]";
    }
}

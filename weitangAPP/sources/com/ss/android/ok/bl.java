package com.ss.android.ok;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alipay.sdk.m.u.i;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Objects;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public class bl {
    private static final char[] ok = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static class ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9907a;
        private int bl;
        private String n;
        private int ok;
        private long s;

        private ok() {
        }
    }

    private static String a(File file, int i2, long j) throws Exception {
        return ok(new com.ss.android.ok.ok(file), i2, j);
    }

    public static String ok(File file) {
        return ok(file, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    private static long a(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    public static String ok(File file, int i2, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return a(file, i2, j);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    public static int ok(String str, File file) {
        return ok(str, file, (a) null);
    }

    public static int ok(String str, File file, a aVar) {
        String strA;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (aVar != null) {
                if (aVar.ok() <= 0) {
                    try {
                        aVar.a();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            int i2 = -1;
            long j = -1;
            try {
                ok okVarOk = ok(str);
                if (okVarOk != null) {
                    if (okVarOk.ok > 1) {
                        return 3;
                    }
                    i2 = okVarOk.bl;
                    j = okVarOk.s;
                }
                ok okVarOk2 = null;
                try {
                    if (aVar != null) {
                        strA = ok(aVar, i2, j);
                    } else {
                        strA = a(file, i2, j);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    strA = null;
                }
                if (strA != null && strA.length() != 0) {
                    if (okVarOk != null && (okVarOk.ok != 1 || okVarOk.f9907a != 1)) {
                        if (okVarOk.n != null) {
                            try {
                                okVarOk2 = ok(strA);
                            } catch (Throwable unused2) {
                            }
                            if (okVarOk2 != null && okVarOk.bl == okVarOk2.bl && okVarOk.s == okVarOk2.s && okVarOk.n.equals(okVarOk2.n)) {
                                return 0;
                            }
                        }
                    } else if (strA.equals(str)) {
                        return 0;
                    }
                    return 1;
                }
                return 6;
            } catch (Throwable unused3) {
                return 4;
            }
        } catch (Throwable unused4) {
            return 99;
        }
    }

    private static String ok(a aVar, int i2, long j) throws Exception {
        long j2;
        int i3 = i2;
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        if (messageDigest == null) {
            return "";
        }
        try {
            long jOk = aVar.ok();
            if (i3 <= 0 || j <= 0 || ((long) i3) * j > (8 * jOk) / 10) {
                j2 = jOk;
                i3 = 1;
            } else {
                j2 = j;
            }
            byte[] bArr = new byte[8192];
            long j3 = 0;
            ok(aVar, messageDigest, bArr, 0L, j2);
            if (i3 > 2) {
                int i4 = i3 - 1;
                long j4 = (jOk - (((long) i3) * j2)) / ((long) i4);
                int i5 = 1;
                while (i5 < i4) {
                    j3 += j2 + j4;
                    ok(aVar, messageDigest, bArr, j3, j2);
                    i5++;
                    i4 = i4;
                }
            }
            if (i3 > 1) {
                ok(aVar, messageDigest, bArr, jOk - j2, j2);
            }
            String strOk = ok(messageDigest.digest());
            if (i3 == 1 && j2 == jOk) {
                return strOk;
            }
            String str = ok(i3, j2) + i.f5697b + strOk;
            try {
                aVar.a();
            } catch (Throwable unused) {
            }
            return str;
        } finally {
            try {
                aVar.a();
            } catch (Throwable unused2) {
            }
        }
    }

    private static void ok(a aVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        aVar.ok(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int iOk = aVar.ok(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (iOk > 0) {
                messageDigest.update(bArr, 0, iOk);
                j3 += (long) iOk;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + iOk + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
        }
    }

    private static String ok(byte[] bArr) {
        Objects.requireNonNull(bArr, "bytes is null");
        int length = bArr.length;
        int i2 = length * 2;
        char[] cArr = new char[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = bArr[i4 + 0] & 255;
            int i6 = i3 + 1;
            char[] cArr2 = ok;
            cArr[i3] = cArr2[i5 >> 4];
            i3 = i6 + 1;
            cArr[i6] = cArr2[i5 & 15];
        }
        return new String(cArr, 0, i2);
    }

    private static String ok(int i2, long j) {
        return "ttmd5:1:1:" + ok(i2) + OperatorName.NON_STROKING_GRAY + ok(j);
    }

    private static ok ok(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] strArrSplit = str.split(i.f5697b);
        String[] strArrSplit2 = strArrSplit[0].split(":");
        ok okVar = new ok();
        okVar.ok = Integer.parseInt(strArrSplit2[1]);
        if (okVar.ok > 1) {
            return okVar;
        }
        okVar.f9907a = Integer.parseInt(strArrSplit2[2]);
        String[] strArrSplit3 = strArrSplit2[3].split(OperatorName.NON_STROKING_GRAY);
        okVar.bl = (int) a(strArrSplit3[0]);
        okVar.s = a(strArrSplit3[1]);
        okVar.n = strArrSplit[1];
        return okVar;
    }

    private static String ok(long j) {
        return Long.toHexString((j << 4) + 31);
    }
}

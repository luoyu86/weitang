package com.ss.android.socialbase.appdownloader.n;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.network.q;
import com.ss.android.socialbase.downloader.q.kf;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bl f9944a = null;
    private static int ok = 8;
    private ok<Integer, Bitmap> bl;

    public static class ok<K, T> extends LinkedHashMap<K, T> {
        public final int ok;

        public ok(int i2, int i3) {
            super(i3, 0.75f, true);
            this.ok = i2;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.ok;
        }
    }

    private bl() {
        this.bl = null;
        int i2 = ok;
        this.bl = new ok<>(i2, i2 / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 <= -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public static bl ok() {
        if (f9944a == null) {
            synchronized (bl.class) {
                if (f9944a == null) {
                    f9944a = new bl();
                }
            }
        }
        return f9944a;
    }

    public Bitmap ok(int i2) {
        return this.bl.get(Integer.valueOf(i2));
    }

    public void ok(final int i2, final String str) {
        if (TextUtils.isEmpty(str) || ok(i2) != null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.z().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.n.bl.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ByteArrayOutputStream byteArrayOutputStreamA;
                ByteArrayInputStream byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Throwable th;
                InputStream inputStreamOk;
                Exception e2;
                q qVarOk;
                int i3 = 4;
                i3 = 4;
                i3 = 4;
                i3 = 4;
                i3 = 4;
                try {
                    try {
                        qVarOk = com.ss.android.socialbase.downloader.downloader.bl.ok(true, 0, str, null);
                    } catch (Exception e3) {
                        byteArrayOutputStreamA = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e2 = e3;
                        inputStreamOk = null;
                    } catch (Throwable th2) {
                        byteArrayOutputStreamA = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th = th2;
                        inputStreamOk = null;
                    }
                    if (qVarOk == null) {
                        kf.ok(null, null, null, null);
                        return;
                    }
                    inputStreamOk = qVarOk.ok();
                    try {
                        byteArrayOutputStreamA = bl.a(inputStreamOk);
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStreamA.toByteArray());
                            try {
                                byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStreamA.toByteArray());
                            } catch (Exception e4) {
                                byteArrayInputStream2 = null;
                                e2 = e4;
                            } catch (Throwable th3) {
                                byteArrayInputStream2 = null;
                                th = th3;
                                Closeable[] closeableArr = new Closeable[i3];
                                closeableArr[0] = inputStreamOk;
                                closeableArr[1] = byteArrayOutputStreamA;
                                closeableArr[2] = byteArrayInputStream;
                                closeableArr[3] = byteArrayInputStream2;
                                kf.ok(closeableArr);
                                throw th;
                            }
                        } catch (Exception e5) {
                            byteArrayInputStream2 = null;
                            e2 = e5;
                            byteArrayInputStream = null;
                        } catch (Throwable th4) {
                            byteArrayInputStream2 = null;
                            th = th4;
                            byteArrayInputStream = null;
                        }
                    } catch (Exception e6) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e2 = e6;
                        byteArrayOutputStreamA = null;
                    } catch (Throwable th5) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th = th5;
                        byteArrayOutputStreamA = null;
                    }
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                        int iOk = com.ss.android.socialbase.appdownloader.bl.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), 44.0f);
                        options.inSampleSize = bl.ok(iOk, iOk, options);
                        options.inJustDecodeBounds = false;
                        bl.this.bl.put(Integer.valueOf(i2), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                        Closeable[] closeableArr2 = {inputStreamOk, byteArrayOutputStreamA, byteArrayInputStream, byteArrayInputStream2};
                        kf.ok(closeableArr2);
                        i3 = closeableArr2;
                    } catch (Exception e7) {
                        e2 = e7;
                        e2.printStackTrace();
                        Closeable[] closeableArr3 = {inputStreamOk, byteArrayOutputStreamA, byteArrayInputStream, byteArrayInputStream2};
                        kf.ok(closeableArr3);
                        i3 = closeableArr3;
                    }
                    e2.printStackTrace();
                    Closeable[] closeableArr32 = {inputStreamOk, byteArrayOutputStreamA, byteArrayInputStream, byteArrayInputStream2};
                    kf.ok(closeableArr32);
                    i3 = closeableArr32;
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        });
    }

    public static int ok(int i2, int i3, BitmapFactory.Options options) {
        int i4 = options.outWidth;
        if (i4 > i2 || options.outHeight > i3) {
            return Math.min(Math.round(i4 / i2), Math.round(options.outHeight / i3));
        }
        return 1;
    }
}

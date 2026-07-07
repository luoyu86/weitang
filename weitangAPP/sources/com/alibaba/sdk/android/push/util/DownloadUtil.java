package com.alibaba.sdk.android.push.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class DownloadUtil {

    public interface OnLargeIconDownloadListener {
        void onDownloadBigPictureFailed(String str);

        void onDownloadLargeIconFailed(String str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.File] */
    public static void download(String str, File file, String str2, String str3) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        Throwable th;
        ?? r3;
        System.currentTimeMillis();
        OnLargeIconDownloadListener onLargeIconDownloadListenerB = com.alibaba.sdk.android.push.a.b.a().b();
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(false);
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setRequestProperty("charset", "utf-8");
                if (httpURLConnection2.getResponseCode() != 200) {
                    inputStream = httpURLConnection2.getErrorStream();
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        try {
                            String string = readStringFrom(bufferedReader).toString();
                            if ("image".equals(str3)) {
                                if (onLargeIconDownloadListenerB != null) {
                                    onLargeIconDownloadListenerB.onDownloadLargeIconFailed(httpURLConnection2.getResponseCode() + string);
                                }
                            } else if (onLargeIconDownloadListenerB != null) {
                                onLargeIconDownloadListenerB.onDownloadBigPictureFailed(httpURLConnection2.getResponseCode() + string);
                            }
                            throw new Exception(httpURLConnection2.getResponseCode() + string);
                        } catch (Throwable th2) {
                            httpURLConnection = httpURLConnection2;
                            th = th2;
                            r3 = 0;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                        httpURLConnection = httpURLConnection2;
                        th = th;
                        r3 = bufferedReader;
                    }
                } else {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(file, str2);
                    try {
                        inputStream = httpURLConnection2.getInputStream();
                        try {
                            writeToFile(inputStream, file2, str3);
                            System.currentTimeMillis();
                            httpURLConnection2.disconnect();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th4) {
                            httpURLConnection = httpURLConnection2;
                            th = th4;
                            bufferedReader = null;
                            r3 = file2;
                        }
                    } catch (Throwable th5) {
                        bufferedReader = null;
                        httpURLConnection = httpURLConnection2;
                        th = th5;
                        inputStream = null;
                        r3 = file2;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
                bufferedReader = null;
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            bufferedReader = null;
        }
        try {
            if ("image".equals(str3)) {
                if (onLargeIconDownloadListenerB != null) {
                    onLargeIconDownloadListenerB.onDownloadLargeIconFailed(th.getMessage());
                }
            } else if (onLargeIconDownloadListenerB != null) {
                onLargeIconDownloadListenerB.onDownloadBigPictureFailed(th.getMessage());
            }
            AmsLogger.getLogger("MPS:Download").d("download failed: " + str3 + ", error: " + Log.getStackTraceString(th));
            throw th;
        } finally {
        }
    }

    public static Bitmap downloadImage(Context context, String str, String str2) {
        File file;
        File file2 = new File(context.getCacheDir(), "aliyun_push_images");
        String fileName = getFileName(str);
        if (new File(file2, fileName).exists()) {
            file = new File(file2, fileName);
        } else {
            try {
                download(str, file2, fileName, str2);
                file = new File(file2, fileName);
            } catch (Exception unused) {
                return null;
            }
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public static String getFileName(String str) {
        String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        return strSubstring.contains("?") ? strSubstring.substring(0, strSubstring.indexOf("?")) : strSubstring;
    }

    public static StringBuilder readStringFrom(BufferedReader bufferedReader) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return sb;
            }
            sb.append(line);
        }
    }

    private static void writeToFile(InputStream inputStream, File file, String str) {
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[10240];
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int i2 = bufferedInputStream2.read(bArr);
                        if (i2 != -1) {
                            fileOutputStream.write(bArr, 0, i2);
                        } else {
                            try {
                                break;
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            OnLargeIconDownloadListener onLargeIconDownloadListenerB = com.alibaba.sdk.android.push.a.b.a().b();
                            if ("image".equals(str)) {
                                if (onLargeIconDownloadListenerB != null) {
                                    onLargeIconDownloadListenerB.onDownloadLargeIconFailed(th.getMessage());
                                }
                            } else if (onLargeIconDownloadListenerB != null) {
                                onLargeIconDownloadListenerB.onDownloadBigPictureFailed(th.getMessage());
                            }
                            AmsLogger.getLogger("MPS:Download").d("writeToFile failed: " + str + ", error: " + Log.getStackTraceString(th));
                            throw th;
                        } finally {
                        }
                    }
                }
                bufferedInputStream2.close();
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }
}

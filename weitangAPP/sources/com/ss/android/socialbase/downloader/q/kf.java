package com.ss.android.socialbase.downloader.q;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import anet.channel.util.HttpConstant;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.socialbase.downloader.depend.fd;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class kf {
    private static Boolean k = null;
    private static final String ok = "kf";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static ConnectivityManager f10182q;
    private static Boolean r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f10180a = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static String bl = null;
    private static volatile SparseArray<Boolean> s = new SparseArray<>();
    private static volatile SparseArray<List<fd>> n = new SparseArray<>();
    private static final char[] kf = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Pattern f10181h = null;
    private static Pattern p = null;

    public static long a(com.ss.android.socialbase.downloader.network.h hVar) {
        if (hVar == null) {
            return -1L;
        }
        String strA = a(hVar, "Content-Range");
        if (TextUtils.isEmpty(strA)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(strA);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e2) {
            com.ss.android.socialbase.downloader.bl.ok.s(ok, "parse content-length from content-range failed " + e2);
        }
        return -1L;
    }

    public static boolean a(long j) {
        return j == -1;
    }

    public static String bl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static boolean bl(int i2) {
        return i2 == 200 || i2 == 201 || i2 == 0;
    }

    public static String h(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private static String k(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (f10181h == null) {
                f10181h = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = f10181h.matcher(str);
        } catch (Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (p == null) {
            p = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        Matcher matcher2 = p.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static boolean kf(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String strS = s(com.ss.android.socialbase.downloader.downloader.bl.l());
        return strS != null && strS.equals(str);
    }

    public static String n(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                    messageDigest.update(str.getBytes("UTF-8"));
                    return ok(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static double ok(long j) {
        return j / 1048576.0d;
    }

    public static String ok(byte[] bArr) {
        Objects.requireNonNull(bArr, "bytes is null");
        return ok(bArr, 0, bArr.length);
    }

    public static boolean ok(int i2) {
        return i2 == 0 || i2 == 2;
    }

    public static boolean p(Throwable th) {
        if (th == null) {
            return false;
        }
        if (!(th instanceof BaseException)) {
            if (!(th instanceof IOException)) {
                return false;
            }
            String strK = k(th);
            return !TextUtils.isEmpty(strK) && strK.contains("ENOSPC");
        }
        BaseException baseException = (BaseException) th;
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1006) {
            return true;
        }
        if (!(errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064)) {
            return false;
        }
        String message = baseException.getMessage();
        return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
    }

    private static String q() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i2 = bufferedReader.read();
                    if (i2 <= 0) {
                        break;
                    }
                    sb.append((char) i2);
                }
                if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                    com.ss.android.socialbase.downloader.bl.ok.a("Process", "get processName = " + sb.toString());
                }
                String string = sb.toString();
                ok(bufferedReader);
                return string;
            } catch (Throwable unused) {
                ok(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    private static boolean r(String str) {
        String str2 = ok;
        Log.w(str2, "deleteDirIfEmpty on thread: " + Thread.currentThread());
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                if (file.delete()) {
                    return true;
                }
                Log.w(str2, "deleteDirIfEmpty return false");
                return false;
            }
        }
        return false;
    }

    public static boolean s(int i2) {
        return i2 == 206 || i2 == 200;
    }

    public static boolean s(DownloadInfo downloadInfo) {
        boolean z = false;
        if (downloadInfo.isDeleteCacheIfCheckFailed() || !TextUtils.isEmpty(downloadInfo.getLastModified())) {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z = true;
            }
        } else {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "dcache::last modify is emtpy, so just return cache");
        }
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z);
        return z;
    }

    public static void bl(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            Log.e(ok, "deleteFile: " + str + "/" + str2);
            file.delete();
        }
    }

    public static String ok(byte[] bArr, int i2, int i3) {
        Objects.requireNonNull(bArr, "bytes is null");
        if (i2 >= 0 && i2 + i3 <= bArr.length) {
            int i4 = i3 * 2;
            char[] cArr = new char[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = bArr[i6 + i2] & 255;
                int i8 = i5 + 1;
                char[] cArr2 = kf;
                cArr[i5] = cArr2[i7 >> 4];
                i5 = i8 + 1;
                cArr[i8] = cArr2[i7 & 15];
            }
            return new String(cArr, 0, i4);
        }
        throw new IndexOutOfBoundsException();
    }

    public static boolean kf(Throwable th) {
        if (th == null) {
            return false;
        }
        String strK = k(th);
        return !TextUtils.isEmpty(strK) && strK.contains("Requested Range Not Satisfiable");
    }

    public static long kf(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<com.ss.android.socialbase.downloader.model.a> listBl = com.ss.android.socialbase.downloader.downloader.bl.m().bl(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z = chunkCount > 1;
        if (!downloadInfo.isBreakpointAvailable()) {
            return 0L;
        }
        if (z) {
            if (listBl == null || chunkCount != listBl.size()) {
                return 0L;
            }
            return a(listBl);
        }
        return downloadInfo.getCurBytes();
    }

    private static String n(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                            com.ss.android.socialbase.downloader.bl.ok.a("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static long s(String str) throws BaseException {
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (IllegalArgumentException e2) {
            throw new BaseException(1050, e2);
        } catch (Throwable th) {
            throw new BaseException(1052, th);
        }
    }

    public static boolean h(Throwable th) {
        return com.ss.android.socialbase.downloader.downloader.bl.ah().ok(th);
    }

    private static String r() {
        String str;
        Throwable th;
        Object objInvoke;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            objInvoke = declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th2) {
            str = null;
            th = th2;
        }
        if (!(objInvoke instanceof String)) {
            return null;
        }
        str = (String) objInvoke;
        try {
            if (!TextUtils.isEmpty(str) && com.ss.android.socialbase.downloader.bl.ok.ok()) {
                com.ss.android.socialbase.downloader.bl.ok.a("Process", "processName = " + str);
            }
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
        }
        return str;
        th.printStackTrace();
        return str;
    }

    public static boolean bl(DownloadInfo downloadInfo) {
        return ok(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static File h() {
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception unused) {
            externalStorageState = "";
        }
        if ("mounted".equals(externalStorageState)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static long a(String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                com.ss.android.socialbase.downloader.bl.ok.s(ok, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    public static boolean bl(String str, String str2, String str3) {
        return ok(a(str, str2, str3));
    }

    public static boolean p(String str) {
        Context contextL;
        if (com.ss.android.socialbase.downloader.h.ok.bl().a("save_path_security") > 0 && (contextL = com.ss.android.socialbase.downloader.downloader.bl.l()) != null && !TextUtils.isEmpty(str) && !str.startsWith("/data")) {
            if (!str.contains("Android/data/" + contextL.getPackageName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean q(Throwable th) {
        if (!(th instanceof BaseException)) {
            return false;
        }
        int errorCode = ((BaseException) th).getErrorCode();
        return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
    }

    public static boolean bl(com.ss.android.socialbase.downloader.network.h hVar) {
        if (hVar == null) {
            return false;
        }
        return ok.ok(8) ? "chunked".equals(hVar.ok("Transfer-Encoding")) || ok(hVar) == -1 : ok(hVar) == -1;
    }

    private static String k() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName) && com.ss.android.socialbase.downloader.bl.ok.ok()) {
                com.ss.android.socialbase.downloader.bl.ok.a("Process", "processName = " + processName);
            }
            return processName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            try {
                bArr[i2] = (byte) (Integer.parseInt(str.substring(i3, i3 + 2), 16) & 255);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static String kf() {
        return ok(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getGlobalSaveTempDir(), false);
    }

    public static boolean s(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static long q(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
        if (!matcher.find()) {
            return 0L;
        }
        try {
            return Long.parseLong(matcher.group(1));
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static boolean bl(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerOk = ok(context);
            if (connectivityManagerOk == null || (activeNetworkInfo = connectivityManagerOk.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean n(Throwable th) {
        if (th == null) {
            return false;
        }
        String strK = k(th);
        return !TextUtils.isEmpty(strK) && strK.contains("Precondition Failed");
    }

    public static boolean p() {
        Context contextL = com.ss.android.socialbase.downloader.downloader.bl.l();
        return (contextL == null || a(contextL) || !bl(contextL)) ? false : true;
    }

    public static long a(List<com.ss.android.socialbase.downloader.model.a> list) {
        Iterator<com.ss.android.socialbase.downloader.model.a> it = list.iterator();
        long jT = 0;
        while (it.hasNext()) {
            jT += it.next().t();
        }
        return jT;
    }

    public static String s(Context context) {
        String str = bl;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strK = k();
        bl = strK;
        if (!TextUtils.isEmpty(strK)) {
            return bl;
        }
        String strR = r();
        bl = strR;
        if (!TextUtils.isEmpty(strR)) {
            return bl;
        }
        String strN = n(context);
        bl = strN;
        if (!TextUtils.isEmpty(strN)) {
            return bl;
        }
        String strQ = q();
        bl = strQ;
        return strQ;
    }

    public static String k(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "throwable getMsg error";
        }
    }

    public static com.ss.android.socialbase.downloader.constants.kf n(int i2) {
        com.ss.android.socialbase.downloader.constants.kf kfVar = com.ss.android.socialbase.downloader.constants.kf.MAIN;
        com.ss.android.socialbase.downloader.constants.kf kfVar2 = com.ss.android.socialbase.downloader.constants.kf.SUB;
        if (i2 != kfVar2.ordinal()) {
            kfVar2 = com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION;
            if (i2 != kfVar2.ordinal()) {
                return kfVar;
            }
        }
        return kfVar2;
    }

    public static void a(DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.h.ok okVarOk;
        JSONObject jSONObjectS;
        if (downloadInfo == null || (jSONObjectS = (okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId())).s("download_dir")) == null) {
            return;
        }
        String strOptString = jSONObjectS.optString("ins_desc");
        if (!TextUtils.isEmpty(strOptString)) {
            bl(downloadInfo.getSavePath(), strOptString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String strOk = ok(title, okVarOk);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(strOk) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(strOk);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            r(file2.getPath());
            file = file.getParentFile();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean bl() {
        /*
            java.lang.Boolean r0 = com.ss.android.socialbase.downloader.q.kf.r
            if (r0 == 0) goto L9
            boolean r0 = r0.booleanValue()
            return r0
        L9:
            android.content.Context r0 = com.ss.android.socialbase.downloader.downloader.bl.l()
            java.lang.String r0 = s(r0)
            if (r0 == 0) goto L37
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r2 = com.ss.android.socialbase.downloader.downloader.bl.l()
            java.lang.String r2 = r2.getPackageName()
            r1.append(r2)
            java.lang.String r2 = ":downloader"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            com.ss.android.socialbase.downloader.q.kf.r = r0
            goto L3b
        L37:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            com.ss.android.socialbase.downloader.q.kf.r = r0
        L3b:
            java.lang.Boolean r0 = com.ss.android.socialbase.downloader.q.kf.r
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.q.kf.bl():boolean");
    }

    public static long ok(com.ss.android.socialbase.downloader.network.h hVar) {
        if (hVar == null) {
            return -1L;
        }
        String strA = a(hVar, "Content-Length");
        if (TextUtils.isEmpty(strA) && ok.ok(1)) {
            return a(hVar);
        }
        try {
            return Long.parseLong(strA);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static long n(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<com.ss.android.socialbase.downloader.model.a> listBl = com.ss.android.socialbase.downloader.downloader.bl.m().bl(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (listBl == null || listBl.size() <= 1) {
            return 0L;
        }
        long jS = s(listBl);
        if (jS >= 0) {
            return jS;
        }
        return 0L;
    }

    public static String ok(com.ss.android.socialbase.downloader.network.h hVar, String str) {
        String strK = k(hVar.ok(HttpHeaders.CONTENT_DISPOSITION));
        return TextUtils.isEmpty(strK) ? n(str) : strK;
    }

    public static boolean bl(Throwable th) {
        if (th == null) {
            return false;
        }
        String strK = k(th);
        return !TextUtils.isEmpty(strK) && strK.contains("network not available");
    }

    public static String n() {
        return ok(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getGlobalSaveDir(), true);
    }

    public static boolean bl(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        return baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException));
    }

    public static com.ss.android.socialbase.downloader.model.n ok(DownloadInfo downloadInfo, String str, String str2, int i2) throws BaseException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            boolean zMkdirs = false;
            if (file.exists() && file.isDirectory()) {
                throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
            }
            if (!file.exists()) {
                try {
                    File file2 = new File(str);
                    if (!file2.exists() || !file2.isDirectory()) {
                        if (!file2.exists()) {
                            if (!file2.mkdirs() && !file2.exists()) {
                                if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo).ok("opt_mkdir_failed", 0) != 1) {
                                    throw new BaseException(1030, "download savePath directory can not created:" + str);
                                }
                                int i3 = 0;
                                while (!zMkdirs) {
                                    int i4 = i3 + 1;
                                    if (i3 >= 3) {
                                        break;
                                    }
                                    try {
                                        Thread.sleep(10L);
                                        zMkdirs = file2.mkdirs();
                                        i3 = i4;
                                    } catch (InterruptedException unused) {
                                    }
                                }
                                if (!zMkdirs) {
                                    if (s(downloadInfo.getSavePath()) < PlaybackStateCompat.ACTION_PREPARE) {
                                        throw new BaseException(1006, "download savePath directory can not created:" + str);
                                    }
                                    throw new BaseException(1030, "download savePath directory can not created:" + str);
                                }
                            }
                        } else {
                            file2.delete();
                            if (!file2.mkdirs() && !file2.exists()) {
                                throw new BaseException(1031, "download savePath is not directory:path=" + str);
                            }
                            throw new BaseException(1031, "download savePath is not directory:" + str);
                        }
                    }
                    file.createNewFile();
                } catch (IOException e2) {
                    throw new BaseException(1036, e2);
                }
            }
            return new com.ss.android.socialbase.downloader.model.n(file, i2);
        }
        throw new BaseException(PointerIconCompat.TYPE_GRABBING, new IOException("path must be not empty"));
    }

    public static String n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strN = n(str2);
        return (TextUtils.isEmpty(strN) || str.contains(strN)) ? str : new File(str, strN).getAbsolutePath();
    }

    public static boolean s() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private static void bl(Throwable th, String str) throws com.ss.android.socialbase.downloader.exception.h {
        com.ss.android.socialbase.downloader.exception.h hVarOk = com.ss.android.socialbase.downloader.downloader.bl.ah().ok(th, null);
        if (hVarOk == null) {
            hVarOk = com.ss.android.socialbase.downloader.downloader.bl.ah().ok(th.getCause(), null);
        }
        if (hVarOk == null) {
            return;
        }
        throw new com.ss.android.socialbase.downloader.exception.h(hVarOk.getErrorCode(), a(hVarOk, str)).ok(hVarOk.ok());
    }

    public static boolean s(Throwable th) {
        if (th == null) {
            return false;
        }
        String strK = k(th);
        return !TextUtils.isEmpty(strK) && strK.contains("Exception in connect");
    }

    private static long s(List<com.ss.android.socialbase.downloader.model.a> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long jRh = -1;
        for (com.ss.android.socialbase.downloader.model.a aVar : list) {
            if (aVar != null && (aVar.rh() <= aVar.i() || aVar.i() == 0)) {
                if (jRh == -1 || jRh > aVar.rh()) {
                    jRh = aVar.rh();
                }
            }
        }
        return jRh;
    }

    public static long bl(long j) {
        return System.currentTimeMillis() - j;
    }

    public static boolean bl(List<com.ss.android.socialbase.downloader.model.bl> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.bl blVar : list) {
            if (blVar != null && !TextUtils.isEmpty(blVar.ok()) && !TextUtils.isEmpty(blVar.a()) && "download-tc21-1-15".equals(blVar.ok()) && "download-tc21-1-15".equals(blVar.a())) {
                return true;
            }
        }
        return false;
    }

    public static int a(String str, String str2, String str3) {
        return com.ss.android.ok.bl.ok(str3, new File(str, str2));
    }

    public static String a(int i2) {
        String str = "ttmd5 check code = " + i2 + ", ";
        if (i2 != 99) {
            switch (i2) {
                case 0:
                    return str + "md5 match";
                case 1:
                    return str + "md5 not match";
                case 2:
                    return str + "md5 empty";
                case 3:
                    return str + "ttmd5 version not support";
                case 4:
                    return str + "ttmd5 tag parser error";
                case 5:
                    return str + "file not exist";
                case 6:
                    return str + "get file md5 error";
                default:
                    return str;
            }
        }
        return str + "unknown error";
    }

    @TargetApi(19)
    private static void a(File file, File file2, boolean z) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j = 0;
                        while (j < size) {
                            long j2 = size - j;
                            long jTransferFrom = channel2.transferFrom(channel, j, j2 > 31457280 ? 31457280L : j2);
                            if (jTransferFrom == 0) {
                                break;
                            } else {
                                j += jTransferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        channel.close();
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length == length2) {
                            if (z) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static List<com.ss.android.socialbase.downloader.model.a> ok(List<com.ss.android.socialbase.downloader.model.a> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.ss.android.socialbase.downloader.model.a aVar : list) {
            if (aVar != null) {
                if (aVar.s()) {
                    sparseArray.put(aVar.zz(), aVar);
                    List<com.ss.android.socialbase.downloader.model.a> list2 = (List) sparseArray2.get(aVar.zz());
                    if (list2 != null) {
                        Iterator<com.ss.android.socialbase.downloader.model.a> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().ok(aVar);
                        }
                        aVar.ok(list2);
                    }
                } else {
                    com.ss.android.socialbase.downloader.model.a aVar2 = (com.ss.android.socialbase.downloader.model.a) sparseArray.get(aVar.a());
                    if (aVar2 != null) {
                        List<com.ss.android.socialbase.downloader.model.a> listH = aVar2.h();
                        if (listH == null) {
                            listH = new ArrayList<>();
                            aVar2.ok(listH);
                        }
                        aVar.ok(aVar2);
                        listH.add(aVar);
                    } else {
                        List arrayList = (List) sparseArray2.get(aVar.a());
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            sparseArray2.put(aVar.a(), arrayList);
                        }
                        arrayList.add(aVar);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList2.add(sparseArray.get(sparseArray.keyAt(i2)));
        }
        return arrayList2.isEmpty() ? list : arrayList2;
    }

    public static boolean a(File file, File file2) throws BaseException {
        String str = ok;
        Log.e(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean zRenameTo = file.renameTo(file2);
        if (!zRenameTo) {
            zRenameTo = ok(file, file2);
            try {
                Log.e(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return zRenameTo;
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManagerOk = ok(context);
            if (connectivityManagerOk != null && (activeNetworkInfo = connectivityManagerOk.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                return 1 == activeNetworkInfo.getType();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String ok(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String ok(String str, String str2, String str3) {
        String strOk;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            strOk = ok(str2, str3);
        } else {
            strOk = ok(str, str3);
        }
        if (TextUtils.isEmpty(strOk)) {
            return null;
        }
        return String.format("%s.tp", strOk);
    }

    public static boolean a() {
        return !bl() && com.ss.android.socialbase.downloader.downloader.bl.bl() && j.ok(true).h();
    }

    public static boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        String strK = k(th);
        if (!(th instanceof com.ss.android.socialbase.downloader.exception.a) || (((com.ss.android.socialbase.downloader.exception.a) th).ok() != 403 && (TextUtils.isEmpty(strK) || !strK.contains("403")))) {
            return !TextUtils.isEmpty(strK) && strK.contains("Forbidden");
        }
        return true;
    }

    public static void ok(DownloadInfo downloadInfo) {
        ok(downloadInfo, true);
    }

    public static boolean a(BaseException baseException) {
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.a) {
            com.ss.android.socialbase.downloader.exception.a aVar = (com.ss.android.socialbase.downloader.exception.a) baseException;
            if (aVar.ok() == 412 || aVar.ok() == 416) {
                return true;
            }
        }
        return false;
    }

    public static void ok(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                bl(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        bl(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            a(downloadInfo);
        }
        if (z) {
            String strN = n(downloadInfo.getUrl());
            if (TextUtils.isEmpty(strN) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(strN)) {
                return;
            }
            r(downloadInfo.getSavePath());
        }
    }

    public static String a(Throwable th, String str) {
        if (str == null) {
            return k(th);
        }
        return str + "-" + k(th);
    }

    public static void a(List<com.ss.android.socialbase.downloader.model.bl> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new com.ss.android.socialbase.downloader.model.bl("extra_ttnet_protect_timeout", String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static String a(com.ss.android.socialbase.downloader.network.h hVar, String str) {
        if (hVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String strOk = hVar.ok(str);
        if (!com.ss.android.socialbase.downloader.h.ok.bl().a("fix_get_http_resp_head_ignore_case", true)) {
            return strOk;
        }
        if (TextUtils.isEmpty(strOk)) {
            strOk = hVar.ok(str.toLowerCase());
        }
        return TextUtils.isEmpty(strOk) ? hVar.ok(str.toUpperCase()) : strOk;
    }

    public static boolean ok(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static boolean ok(DownloadInfo downloadInfo, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists()) {
                    if (bl(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean a(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && bl(com.ss.android.socialbase.downloader.downloader.bl.l());
    }

    public static int ok(File file, String str) {
        return com.ss.android.ok.bl.ok(str, file);
    }

    public static void ok(DownloadInfo downloadInfo, y yVar, fd fdVar) {
        boolean z;
        BaseException baseException;
        boolean z2;
        String str = ok;
        com.ss.android.socialbase.downloader.bl.ok.a(str, "saveFileAsTargetName targetName is " + downloadInfo.getTargetFilePath());
        try {
            synchronized (s) {
                Boolean bool = s.get(downloadInfo.getId());
                Boolean bool2 = Boolean.TRUE;
                if (bool == bool2) {
                    com.ss.android.socialbase.downloader.bl.ok.a(str, "has another same task is saving temp file");
                    if (fdVar != null) {
                        List<fd> arrayList = n.get(downloadInfo.getId());
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            n.put(downloadInfo.getId(), arrayList);
                        }
                        arrayList.add(fdVar);
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.bl.ok.a(str, "saveTempFileStatusMap put id:" + downloadInfo.getId());
                s.put(downloadInfo.getId(), bool2);
                File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
                File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                boolean zP = p(downloadInfo.getSavePath());
                if (file2.exists()) {
                    com.ss.android.socialbase.downloader.bl.ok.a(str, "targetFile exist");
                    int iOk = ok(file2, downloadInfo.getMd5());
                    if (ok(iOk)) {
                        com.ss.android.socialbase.downloader.bl.ok.a(str, "tempFile not exist , targetFile exists and md5 check valid");
                        downloadInfo.setTTMd5CheckStatus(iOk);
                        if (fdVar != null) {
                            fdVar.ok();
                        }
                        ok(downloadInfo.getId(), true, (BaseException) null);
                    } else {
                        if (file.exists()) {
                            z = true;
                        } else {
                            BaseException baseException2 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName(), a(iOk)));
                            if (fdVar != null) {
                                fdVar.ok(baseException2);
                            }
                            ok(downloadInfo.getId(), false, baseException2);
                            z = false;
                        }
                        if (zP && !file2.delete()) {
                            if (z) {
                                BaseException baseException3 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + a(iOk));
                                if (fdVar != null) {
                                    fdVar.ok(baseException3);
                                }
                                ok(downloadInfo.getId(), false, baseException3);
                            } else if (yVar != null) {
                                com.ss.android.socialbase.downloader.s.ok.ok(yVar, downloadInfo, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), downloadInfo.getStatus());
                            }
                        }
                    }
                    z = false;
                } else if (file.exists()) {
                    z = true;
                } else {
                    BaseException baseException4 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                    if (fdVar != null) {
                        fdVar.ok(baseException4);
                    }
                    ok(downloadInfo.getId(), false, baseException4);
                    z = false;
                }
                if (z) {
                    try {
                        int iOk2 = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("download_finish_check_ttmd5", 2);
                        if (iOk2 > 0) {
                            int iOk3 = ok(file, downloadInfo.getMd5());
                            downloadInfo.setTTMd5CheckStatus(iOk3);
                            if (iOk2 >= 2 && !ok(iOk3)) {
                                BaseException baseException5 = new BaseException(1034, a(iOk3));
                                if (fdVar != null) {
                                    fdVar.ok(baseException5);
                                }
                                ok(downloadInfo.getId(), false, baseException5);
                                ok(downloadInfo, zP);
                                return;
                            }
                        }
                        z2 = !a(file, file2);
                        baseException = null;
                    } catch (BaseException e2) {
                        if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("fix_file_rename_failed")) {
                            baseException = e2;
                            z2 = true;
                        } else {
                            baseException = e2;
                            z2 = false;
                        }
                    }
                    if (z2) {
                        if (baseException == null) {
                            baseException = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                        }
                        if (fdVar != null) {
                            fdVar.ok(baseException);
                        }
                        ok(downloadInfo.getId(), false, baseException);
                        return;
                    }
                    if (fdVar != null) {
                        fdVar.ok();
                    }
                    ok(downloadInfo.getId(), true, (BaseException) null);
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "saveFileAsTargetName throwable " + th.getMessage());
            if (fdVar != null) {
                fdVar.ok(new BaseException(1038, a(th, "saveFileAsTargetName")));
            }
        }
    }

    private static void ok(int i2, boolean z, BaseException baseException) {
        synchronized (s) {
            List<fd> list = n.get(i2);
            if (list != null) {
                for (fd fdVar : list) {
                    if (fdVar != null) {
                        if (z) {
                            fdVar.ok();
                        } else {
                            fdVar.ok(baseException);
                        }
                    }
                }
            }
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "handleTempSaveCallback id:" + i2);
            s.remove(i2);
        }
    }

    public static void ok(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        Log.e(ok, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!ok(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static boolean ok(File file, File file2) throws BaseException {
        return ok(file, file2, true);
    }

    public static boolean ok(File file, File file2, boolean z) throws BaseException {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    Log.e(ok, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    a(file, file2, z);
                    return true;
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                ok(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    public static boolean ok(int i2, String str) {
        if (ok.ok(16777216)) {
            return i2 == 206 || i2 == 1;
        }
        if (i2 >= 400) {
            return false;
        }
        return i2 == 206 || i2 == 1 || "bytes".equals(str);
    }

    public static List<com.ss.android.socialbase.downloader.model.bl> ok(List<com.ss.android.socialbase.downloader.model.bl> list, String str, com.ss.android.socialbase.downloader.model.a aVar) {
        return ok(list, str, aVar.z(), aVar.i());
    }

    public static List<com.ss.android.socialbase.downloader.model.bl> ok(List<com.ss.android.socialbase.downloader.model.bl> list, String str, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.bl blVar : list) {
                if (blVar != null) {
                    arrayList.add(blVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.bl("If-Match", str));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.model.bl(HttpConstant.ACCEPT_ENCODING, "identity"));
        String str2 = j2 <= 0 ? String.format("bytes=%s-", String.valueOf(j)) : String.format("bytes=%s-%s", String.valueOf(j), String.valueOf(j2));
        arrayList.add(new com.ss.android.socialbase.downloader.model.bl(HttpHeaders.RANGE, str2));
        com.ss.android.socialbase.downloader.bl.ok.a(ok, " range CurrentOffset:" + j + " EndOffset:" + j2 + ", range = " + str2);
        return arrayList;
    }

    public static boolean ok(int i2, String str, String str2) {
        return i2 == -3 && !s(str, str2);
    }

    public static ConnectivityManager ok(Context context) {
        ConnectivityManager connectivityManager = f10182q;
        if (connectivityManager != null) {
            return connectivityManager;
        }
        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
        f10182q = connectivityManager2;
        return connectivityManager2;
    }

    public static boolean ok() {
        Boolean bool = k;
        if (bool != null) {
            return bool.booleanValue();
        }
        String strS = s(com.ss.android.socialbase.downloader.downloader.bl.l());
        if (strS == null || !strS.contains(":")) {
            k = Boolean.valueOf(strS != null && strS.equals(com.ss.android.socialbase.downloader.downloader.bl.l().getPackageName()));
        } else {
            k = Boolean.FALSE;
        }
        return k.booleanValue();
    }

    public static boolean ok(Throwable th) {
        if (th == null) {
            return false;
        }
        String strK = k(th);
        if (!(th instanceof SocketTimeoutException)) {
            if (TextUtils.isEmpty(strK)) {
                return false;
            }
            if (!strK.contains("time out") && !strK.contains("Time-out")) {
                return false;
            }
        }
        return true;
    }

    public static boolean ok(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static void ok(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (!(th instanceof BaseException)) {
            if (!(th instanceof SSLHandshakeException)) {
                if (!ok(th)) {
                    if (!n(th)) {
                        if (!kf(th)) {
                            if (!a(th)) {
                                if (!bl(th)) {
                                    if (!s(th)) {
                                        if (th instanceof IOException) {
                                            bl(th, str);
                                            ok((IOException) th, str);
                                            return;
                                        }
                                        throw new BaseException(1000, a(th, str2));
                                    }
                                    throw new BaseException(1041, a(th, str2));
                                }
                                throw new BaseException(1049, a(th, str2));
                            }
                            throw new BaseException(1047, a(th, str2));
                        }
                        throw new com.ss.android.socialbase.downloader.exception.a(1004, 416, a(th, str2));
                    }
                    throw new com.ss.android.socialbase.downloader.exception.a(1004, TTAdConstant.IMAGE_URL_CODE, a(th, str2));
                }
                throw new BaseException(1048, a(th, str2));
            }
            throw new BaseException(PointerIconCompat.TYPE_COPY, a(th, str2));
        }
        BaseException baseException = (BaseException) th;
        baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
        throw baseException;
    }

    public static void ok(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String strA = a(iOException, str);
        if (!(iOException instanceof ConnectException)) {
            if (!(iOException instanceof UnknownHostException)) {
                if (!(iOException instanceof NoRouteToHostException)) {
                    if (!(iOException instanceof UnknownServiceException)) {
                        if (!(iOException instanceof PortUnreachableException)) {
                            if (!(iOException instanceof SocketTimeoutException)) {
                                if (!(iOException instanceof SocketException)) {
                                    if (!(iOException instanceof HttpRetryException)) {
                                        if (!(iOException instanceof ProtocolException)) {
                                            if (!(iOException instanceof MalformedURLException)) {
                                                if (!(iOException instanceof FileNotFoundException)) {
                                                    if (!(iOException instanceof InterruptedIOException)) {
                                                        if (!(iOException instanceof UnsupportedEncodingException)) {
                                                            if (!(iOException instanceof EOFException)) {
                                                                if (!(iOException instanceof StreamResetException)) {
                                                                    if (!(iOException instanceof SSLException)) {
                                                                        if (p(iOException)) {
                                                                            throw new BaseException(1006, strA);
                                                                        }
                                                                        throw new BaseException(1023, strA);
                                                                    }
                                                                    throw new BaseException(PointerIconCompat.TYPE_COPY, strA);
                                                                }
                                                                throw new BaseException(1067, strA);
                                                            }
                                                            throw new BaseException(1066, strA);
                                                        }
                                                        throw new BaseException(1065, strA);
                                                    }
                                                    throw new BaseException(1064, strA);
                                                }
                                                throw new BaseException(1063, strA);
                                            }
                                            throw new BaseException(1062, strA);
                                        }
                                        throw new BaseException(1061, strA);
                                    }
                                    throw new BaseException(1060, strA);
                                }
                                throw new BaseException(1059, strA);
                            }
                            throw new BaseException(1048, strA);
                        }
                        throw new BaseException(1058, strA);
                    }
                    throw new BaseException(1057, strA);
                }
                throw new BaseException(1056, strA);
            }
            throw new BaseException(1055, strA);
        }
        throw new BaseException(1041, strA);
    }

    public static boolean ok(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
    }

    public static <K> HashMap<Integer, K> ok(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> map = new HashMap<>();
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = sparseArray.keyAt(i2);
            map.put(Integer.valueOf(iKeyAt), sparseArray.valueAt(i2));
        }
        return map;
    }

    public static <K> void ok(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static boolean ok(List<com.ss.android.socialbase.downloader.model.bl> list, List<com.ss.android.socialbase.downloader.model.bl> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void ok(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void ok(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static String ok(String str, int i2) {
        return i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public static String ok(String str, com.ss.android.socialbase.downloader.h.ok okVar) {
        JSONObject jSONObjectS;
        String str2;
        if (okVar == null || (jSONObjectS = okVar.s("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectS.optString("dir_name");
        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("/")) {
            strOptString = strOptString.substring(1);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        if (!strOptString.contains("%s")) {
            str2 = strOptString + str;
        } else {
            try {
                str2 = String.format(strOptString, str);
            } catch (Throwable unused) {
            }
        }
        strOptString = str2;
        return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
    }

    private static String ok(File file, boolean z) {
        Context contextL = com.ss.android.socialbase.downloader.downloader.bl.l();
        if (ok(file)) {
            return file.getAbsolutePath();
        }
        int i2 = contextL.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
            File externalFilesDir = contextL.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (ok(externalFilesDir)) {
                return externalFilesDir.getAbsolutePath();
            }
        } else {
            if (z) {
                File fileH = h();
                if (ok(fileH)) {
                    return fileH.getAbsolutePath();
                }
            }
            File externalFilesDir2 = contextL.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (ok(externalFilesDir2)) {
                return externalFilesDir2.getAbsolutePath();
            }
        }
        return contextL.getFilesDir().getAbsolutePath();
    }

    public static boolean ok(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() || file.mkdirs()) {
                return file.isDirectory();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void ok(List<com.ss.android.socialbase.downloader.model.bl> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new com.ss.android.socialbase.downloader.model.bl("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
        }
    }

    public static int ok(Object obj, int i2) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i2;
        }
    }

    public static String ok(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean ok(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z;
        }
    }
}

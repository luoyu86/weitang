package com.alibaba.sdk.android.man.crashreporter.a.a.a.b;

import android.os.Build;
import android.os.Process;
import com.alibaba.sdk.android.man.crashreporter.MotuCrashReporter;
import com.alibaba.sdk.android.man.crashreporter.ReporterConfigure;
import com.alibaba.sdk.android.man.crashreporter.e.f;
import com.alibaba.sdk.android.man.crashreporter.e.i;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final int o = 8192;
    public static int p = 100;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f4690q = 100;
    public static final int r = 10000;

    public static String a(String... strArr) throws Throwable {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream()), 8192);
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append("\n");
                } catch (IOException unused) {
                    bufferedReader = bufferedReader2;
                    f.a(bufferedReader);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    f.a(bufferedReader);
                    throw th;
                }
            }
            f.a(bufferedReader2);
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return sb.toString();
    }

    public static String f() {
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
            f.a(fileReader);
            f.a(bufferedReader);
            return "";
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("read /proc/cpuinfo error.", e2);
            return "";
        }
    }

    public static String g() {
        return a("dumpsys", "meminfo", Integer.toString(Process.myPid()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    public static String a(String str, boolean z) throws Throwable {
        String str2;
        ?? Contains;
        ?? sb;
        ReporterConfigure configure = MotuCrashReporter.getInstance().getConfigure();
        if (configure != null) {
            int i2 = configure.enableSysLogcatMaxCount;
            f4690q = i2;
            int i3 = configure.enableSysLogcatLinkMaxCount;
            p = i3;
            if (i2 == 0 || i3 == 0) {
                return "";
            }
        }
        int iMyPid = Process.myPid();
        ?? r1 = 0;
         = 0;
        ?? r12 = 0;
        BufferedReader bufferedReader = null;
        if (!z || iMyPid <= 0) {
            str2 = null;
        } else {
            str2 = Integer.toString(iMyPid) + "):";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("logcat");
        if (i.b((CharSequence) str)) {
            arrayList.add("-b");
            arrayList.add(str);
        }
        int i4 = 0;
        List listAsList = Arrays.asList("-t", Integer.toString(f4690q), "-v", "time");
        int iIndexOf = listAsList.indexOf("-t");
        int i5 = -1;
        if (iIndexOf > -1 && iIndexOf < listAsList.size()) {
            int i6 = iIndexOf + 1;
            int i7 = Integer.parseInt((String) listAsList.get(i6));
            if (Build.VERSION.SDK_INT < 8) {
                listAsList.remove(i6);
                listAsList.remove(iIndexOf);
                listAsList.add("-d");
            }
            i5 = i7;
        }
        if (i5 <= 0) {
            i5 = p;
        }
        com.alibaba.sdk.android.man.crashreporter.a.a.a.b.a.a aVar = new com.alibaba.sdk.android.man.crashreporter.a.a.a.b.a.a(i5);
        arrayList.addAll(listAsList);
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[arrayList.size()])).getInputStream()), 8192);
                try {
                    com.alibaba.sdk.android.man.crashreporter.b.a.e("collectLogCat Retrieving logcat output...");
                    if (i.b((CharSequence) str)) {
                        while (true) {
                            String line = bufferedReader2.readLine();
                            if (line == null || i4 >= (r12 = p)) {
                                break;
                            }
                            if (str2 == null || (sb = line.contains(str2)) != 0) {
                                sb = new StringBuilder();
                                sb.append(line);
                                sb.append("\n");
                                aVar.add(sb.toString());
                            }
                            i4++;
                            r12 = sb;
                        }
                    } else {
                        while (true) {
                            String line2 = bufferedReader2.readLine();
                            if (line2 == null || i4 >= (r12 = p)) {
                                break;
                            }
                            if ((str2 == null || (Contains = line2.contains(str2)) != 0) && ((line2.contains("W/") || (Contains = line2.contains("E/")) != 0) && (Contains = line2.contains("com.alibaba.motu.crashreporter")) == 0)) {
                                Contains = new StringBuilder();
                                Contains.append(line2);
                                Contains.append("\n");
                                aVar.add(Contains.toString());
                            }
                            i4++;
                            r12 = Contains;
                        }
                    }
                    f.a(bufferedReader2);
                    r1 = r12;
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                    com.alibaba.sdk.android.man.crashreporter.b.a.d("MotuLogProber could not retrieve data", e);
                    f.a(bufferedReader);
                    r1 = bufferedReader;
                } catch (Throwable th) {
                    th = th;
                    r1 = bufferedReader2;
                    f.a((Reader) r1);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
            return aVar.toString();
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

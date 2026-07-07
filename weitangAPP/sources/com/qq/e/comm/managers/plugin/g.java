package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f9693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f9694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f9697e;

    public g(File file, File file2) {
        this.f9693a = file;
        this.f9694b = file2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    public final String a(File file) throws Throwable {
        Throwable th;
        ?? r1 = 0;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                            }
                            String string = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                            return string;
                        } catch (IOException e2) {
                            throw e2;
                        }
                    } catch (IOException e3) {
                        throw e3;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (Exception unused2) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                r1 = file;
                th = th3;
            }
        }
        return null;
    }

    public boolean b() {
        int i2;
        try {
            if (this.f9694b.exists() && this.f9693a.exists()) {
                String strA = a(this.f9694b);
                this.f9697e = strA;
                if (TextUtils.isEmpty(strA)) {
                    return false;
                }
                String[] strArrSplit = this.f9697e.split("#####");
                if (strArrSplit.length == 2) {
                    String str = strArrSplit[1];
                    try {
                        i2 = Integer.parseInt(strArrSplit[0]);
                    } catch (Throwable unused) {
                        i2 = 0;
                    }
                    if (c.b.f9691a.a(str, this.f9693a)) {
                        this.f9695c = str;
                        this.f9696d = i2;
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable unused2) {
            GDTLogger.d("Exception while checking plugin");
            return false;
        }
    }

    public boolean c(File file, File file2) {
        return (file.equals(this.f9693a) || h.a(this.f9693a, file)) && (file2.equals(this.f9694b) || h.a(this.f9694b, file2));
    }

    public String d() {
        return this.f9697e;
    }

    public String e() {
        return this.f9695c;
    }

    public int f() {
        return this.f9696d;
    }
}

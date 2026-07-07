package com.alipay.sdk.m.c0;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5301a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f5302b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f5303c = "";

    public static synchronized void a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        a(arrayList);
    }

    public static synchronized void a(String str, String str2, String str3) {
        f5301a = str;
        f5302b = str2;
        f5303c = str3;
    }

    public static synchronized void a(Throwable th) {
        String string;
        ArrayList arrayList = new ArrayList();
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            string = stringWriter.toString();
        } else {
            string = "";
        }
        arrayList.add(string);
        a(arrayList);
    }

    public static synchronized void a(List<String> list) {
        if (!com.alipay.sdk.m.z.a.a(f5302b) && !com.alipay.sdk.m.z.a.a(f5303c)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(f5303c);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(", " + it.next());
            }
            stringBuffer.append("\n");
            try {
                File file = new File(f5301a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(f5301a, f5302b);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileWriter fileWriter = ((long) stringBuffer.length()) + file2.length() <= 51200 ? new FileWriter(file2, true) : new FileWriter(file2);
                fileWriter.write(stringBuffer.toString());
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception unused) {
            }
        }
    }
}

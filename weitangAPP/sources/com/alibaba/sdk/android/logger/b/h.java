package com.alibaba.sdk.android.logger.b;

import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.LogLevel;
import java.util.ArrayList;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class h implements com.alibaba.sdk.android.logger.interceptor.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f4664a = {"null"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f4665b = {HttpUrl.PATH_SEGMENT_ENCODE_SET_URI};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.alibaba.sdk.android.logger.a.a f4666c;

    public h(com.alibaba.sdk.android.logger.a.a aVar) {
        this.f4666c = aVar;
    }

    private String[] a(Object[] objArr) {
        if (objArr == null) {
            return f4664a;
        }
        if (objArr.length == 0) {
            return f4665b;
        }
        String[] strArr = new String[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            strArr[i2] = this.f4666c.a(objArr[i2]);
        }
        return strArr;
    }

    private String[] a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : strArr) {
            if (str == null) {
                str = "";
            }
            if (z) {
                z = false;
            } else {
                sb.append(" ");
            }
            if (str.contains("\n")) {
                String[] strArrSplit = str.split("\n");
                for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                    sb.append(strArrSplit[i2]);
                    if (i2 < strArrSplit.length - 1) {
                        arrayList.add(sb.toString());
                        sb = new StringBuilder();
                    } else if (i2 == strArrSplit.length - 1 && str.endsWith("\n")) {
                        arrayList.add(sb.toString());
                        sb = new StringBuilder();
                        z = true;
                    }
                }
            } else {
                sb.append(str);
            }
        }
        arrayList.add(sb.toString());
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.alibaba.sdk.android.logger.interceptor.d
    public void a(LogLevel logLevel, String str, Object[] objArr, ILogger iLogger) {
        for (String str2 : a(a(objArr))) {
            iLogger.print(logLevel, str, str2);
        }
    }
}

package com.alibaba.sdk.android.man.crashreporter.a;

import android.content.Context;
import com.alibaba.sdk.android.man.crashreporter.ReporterConfigure;
import com.alibaba.sdk.android.man.crashreporter.c;
import com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent;
import com.alibaba.sdk.android.man.crashreporter.global.CrashReportDataForSave;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    /* JADX INFO: renamed from: a */
    CrashReportDataForSave mo37a();

    CrashReportDataForSave a(String str);

    CrashReportDataForSave a(String str, String str2, String str3, Map map);

    /* JADX INFO: renamed from: a */
    String mo38a(String str);

    /* JADX INFO: renamed from: a */
    Map<String, String> mo39a();

    Map<com.alibaba.sdk.android.man.crashreporter.global.a, String> a(int i2, int i3, int i4, int i5);

    void a(ReporterConfigure reporterConfigure, BaseDataContent baseDataContent, int i2);

    void a(Map map, String str, String str2, String str3);

    boolean a(Context context, ReporterConfigure reporterConfigure, c cVar, com.alibaba.sdk.android.man.crashreporter.d.c cVar2, com.alibaba.sdk.android.man.crashreporter.d.c cVar3);

    CrashReportDataForSave b(String str, String str2, String str3, Map map);
}

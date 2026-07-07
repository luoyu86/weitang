package com.alibaba.sdk.android.man.crashreporter.d;

import android.content.Context;
import com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent;
import com.alibaba.sdk.android.man.crashreporter.global.CrashReportDataForSave;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    BaseDataContent a();

    CrashReportDataForSave a(String str, int i2);

    String a(long j);

    void a(BaseDataContent baseDataContent);

    boolean a(CrashReportDataForSave crashReportDataForSave, int i2);

    String[] a(int i2);

    CrashReportDataForSave b(String str);

    void b(CrashReportDataForSave crashReportDataForSave);

    void b(boolean z);

    boolean c(Context context);

    String h();

    String i();

    String j();
}

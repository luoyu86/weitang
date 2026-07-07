package com.alibaba.sdk.android.logger.b;

import android.util.Log;
import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.LogLevel;

/* JADX INFO: loaded from: classes.dex */
public class d implements ILogger {

    /* JADX INFO: renamed from: com.alibaba.sdk.android.logger.b.d$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4656a;

        static {
            int[] iArr = new int[LogLevel.values().length];
            f4656a = iArr;
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4656a[LogLevel.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4656a[LogLevel.WARN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4656a[LogLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.alibaba.sdk.android.logger.ILogger
    public void print(LogLevel logLevel, String str, String str2) {
        String strSubstring;
        if (str2.length() > 4000) {
            strSubstring = str2.substring(4000);
            str2 = str2.substring(0, 4000);
        } else {
            strSubstring = null;
        }
        int i2 = AnonymousClass1.f4656a[logLevel.ordinal()];
        if (i2 == 1) {
            Log.d(str, str2);
        } else if (i2 == 2) {
            Log.i(str, str2);
        } else if (i2 == 3) {
            Log.w(str, str2);
        } else if (i2 == 4) {
            Log.e(str, str2);
        }
        if (strSubstring != null) {
            print(logLevel, str, strSubstring);
        }
    }
}
